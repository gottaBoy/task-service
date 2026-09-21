/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.Deploy.IPSDCDBDevInst;
import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatform;
import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatformNode;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepFunc;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepFuncItem;
import SA.SRFDA.PS.Core.Deploy.PSDCDBDevInstImpl;
import SA.SRFDA.PS.Core.Deploy.PSDCMSPDeployItemImplBase;
import SA.SRFDA.PS.Core.Deploy.PSDevSlnMSDepFuncAPIImpl;
import SA.SRFDA.PS.Core.Deploy.PSDevSlnMSDepFuncAppImpl;
import SA.SRFDA.PS.Core.Deploy.PSDevSlnMSDepFuncItemImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDevCenterDBInst;
import SA.SRFDA.PS.Data.PSDevSlnMSDepFunc;
import SA.SRFDA.PS.Data.PSDevSlnMSDepFuncItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDevSlnMSDepFuncImpl
extends PSDCMSPDeployItemImplBase
implements IPSDevSlnMSDepFunc {
    private static final Log log = LogFactory.getLog(PSDevSlnMSDepFuncImpl.class);
    protected PSDevSlnMSDepFunc psDevSlnMSDepFunc = null;
    private int nHttpPort = 18080;
    private IPSDevSlnSys iPSDevSlnSys = null;
    private String strPSDevSlnSysId = null;
    private String strPSDevCenterDBInstId = null;
    private IPSDCDBDevInst iPSDCDBDevInst = null;
    private ArrayList<IPSDevSlnMSDepFuncItem> psDevSlnMSDepFuncItemList = new ArrayList();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDevSlnSys iPSDevSlnSys, PSDevSlnMSDepFunc psDevSlnMSDepFunc) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDevSlnMSDepFunc = psDevSlnMSDepFunc;
        if (!psDevSlnMSDepFunc.isVALIDFLAGNull() && !psDevSlnMSDepFunc.getVALIDFLAG()) {
            throw new Exception("\u6307\u5b9a\u5fae\u670d\u52a1\u529f\u80fd\u90e8\u7f72\u6ca1\u6709\u88ab\u542f\u7528");
        }
        this.setId(this.psDevSlnMSDepFunc.getPSDEVSLNMSDEPFUNCID());
        this.setName(this.psDevSlnMSDepFunc.getPSDEVSLNMSDEPFUNCNAME());
        this.setPSObjectData(this.psDevSlnMSDepFunc);
        this.iPSDevSlnSys = iPSDevSlnSys;
        this.strPSDevSlnSysId = this.psDevSlnMSDepFunc.getPSDEVSLNSYSID();
        this.strPSDevCenterDBInstId = this.psDevSlnMSDepFunc.getPSDEVCENTERDBINSTID();
        if (!StringHelper.isNullOrEmpty((String)this.psDevSlnMSDepFunc.getPSDCMSPLATFORMID())) {
            IPSDCMSPlatform iPSDCMSPlatform = this.getPSModelStorage().getPSDCMSPlatform(this.psDevSlnMSDepFunc.getPSDCMSPLATFORMID());
            this.setPSDCMSPlatform(iPSDCMSPlatform);
            if (!StringHelper.isNullOrEmpty((String)this.psDevSlnMSDepFunc.getPSDCMSPLATFORMNODEID())) {
                IPSDCMSPlatformNode iPSDCMSPlatformNode = iPSDCMSPlatform.getPSDCMSPlatformNode(this.psDevSlnMSDepFunc.getPSDCMSPLATFORMNODEID());
                this.setPSDCMSPlatformNode(iPSDCMSPlatformNode);
            }
        }
        if (!this.psDevSlnMSDepFunc.isHTTPPORTNull() && this.psDevSlnMSDepFunc.getHTTPPORT() > 0) {
            this.nHttpPort = this.psDevSlnMSDepFunc.getHTTPPORT();
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getPSDevCenterDBInstId())) {
            PSDevCenterDBInst psDevCenterDBInst = new PSDevCenterDBInst();
            CallResult callResult = this.getPSModelHelper(null).getPSDCDBInst(this.getPSDevCenterDBInstId(), psDevCenterDBInst);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u529f\u80fd\u4e2d\u5fc3\u6570\u636e\u5e93\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            PSDCDBDevInstImpl iPSDCDBDevInst = new PSDCDBDevInstImpl();
            iPSDCDBDevInst.init(this.getDAGlobalHelper(), psDevCenterDBInst);
            this.iPSDCDBDevInst = iPSDCDBDevInst;
        }
        this.onPreparePSDevSlnMSDepFuncItems();
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDEVSLNMSDEPFUNC";
    }

    @Override
    @PSModelRTMeta(description="Http\u7aef\u53e3")
    public int getHttpPort() {
        return this.nHttpPort;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public IPSDevSlnSys getPSDevSlnSys() throws Exception {
        if (this.iPSDevSlnSys == null) {
            if (StringHelper.isNullOrEmpty((String)this.strPSDevSlnSysId)) {
                return null;
            }
            this.iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.strPSDevSlnSysId);
        }
        return this.iPSDevSlnSys;
    }

    @Override
    public String getPSDevCenterDBInstId() {
        return this.strPSDevCenterDBInstId;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u5b9e\u4f8b")
    public IPSDBDevInst getPSDBDevInst() {
        return this.iPSDCDBDevInst;
    }

    @Override
    public Iterator<IPSDevSlnMSDepFuncItem> getPSDevSlnMSDepFuncItems() {
        if (this.psDevSlnMSDepFuncItemList.size() == 0) {
            return null;
        }
        return this.psDevSlnMSDepFuncItemList.iterator();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void onPreparePSDevSlnMSDepFuncItems() throws Exception {
        ArrayList<IPSDevSlnMSDepFuncItem> arrayList = this.psDevSlnMSDepFuncItemList;
        synchronized (arrayList) {
            this.psDevSlnMSDepFuncItemList.clear();
            Vector<PSDevSlnMSDepFuncItem> psDevSlnMSDepFuncItemList = new Vector<PSDevSlnMSDepFuncItem>();
            CallResult callResullt = this.getPSModelHelper().getPSDevSlnMSDepFuncItems(this.getId(), psDevSlnMSDepFuncItemList);
            if (callResullt.isError()) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5fae\u670d\u52a1\u529f\u80fd\u90e8\u7f72\u6210\u5458\u96c6\u5408\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResullt.getErrorInfo()));
            }
            for (PSDevSlnMSDepFuncItem psDevSlnMSDepFuncItem : psDevSlnMSDepFuncItemList) {
                if (!psDevSlnMSDepFuncItem.isVALIDFLAGNull() && !psDevSlnMSDepFuncItem.getVALIDFLAG()) continue;
                PSDevSlnMSDepFuncItemImplBase iPSDevSlnMSDepFuncItem = null;
                if (StringHelper.compare((String)psDevSlnMSDepFuncItem.getITEMTYPE(), (String)"API", (boolean)true) == 0) {
                    iPSDevSlnMSDepFuncItem = new PSDevSlnMSDepFuncAPIImpl();
                } else if (StringHelper.compare((String)psDevSlnMSDepFuncItem.getITEMTYPE(), (String)"APP", (boolean)true) == 0) {
                    iPSDevSlnMSDepFuncItem = new PSDevSlnMSDepFuncAppImpl();
                }
                if (iPSDevSlnMSDepFuncItem == null) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5f00\u53d1\u65b9\u6848\u5fae\u670d\u52a1\u529f\u80fd\u90e8\u7f72\u6210\u5458\u7c7b\u578b[%1$s]", (Object)psDevSlnMSDepFuncItem.getITEMTYPE()));
                }
                iPSDevSlnMSDepFuncItem.init(this.getDAGlobalHelper(), this, psDevSlnMSDepFuncItem);
                this.psDevSlnMSDepFuncItemList.add(iPSDevSlnMSDepFuncItem);
            }
        }
    }
}

