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

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.Deploy.IPSDCDBDevInst;
import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatform;
import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatformNode;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepApp;
import SA.SRFDA.PS.Core.Deploy.PSDCDBDevInstImpl;
import SA.SRFDA.PS.Core.Deploy.PSDCMSPDeployItemImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDevCenterDBInst;
import SA.SRFDA.PS.Data.PSDevSlnMSDepApp;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDevSlnMSDepAppImpl
extends PSDCMSPDeployItemImplBase
implements IPSDevSlnMSDepApp {
    private static final Log log = LogFactory.getLog(PSDevSlnMSDepAppImpl.class);
    protected PSDevSlnMSDepApp psDevSlnMSDepApp = null;
    private int nHttpPort = 18080;
    private IPSDevSlnSys iPSDevSlnSys = null;
    private String strPSDevSlnSysId = null;
    private String strPSSysAppId = null;
    private String strPSDevCenterDBInstId = null;
    private IPSDCDBDevInst iPSDCDBDevInst = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDevSlnSys iPSDevSlnSys, PSDevSlnMSDepApp psDevSlnMSDepApp) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDevSlnMSDepApp = psDevSlnMSDepApp;
        if (!psDevSlnMSDepApp.isVALIDFLAGNull() && !psDevSlnMSDepApp.getVALIDFLAG()) {
            throw new Exception("\u6307\u5b9a\u5fae\u670d\u52a1\u5e94\u7528\u90e8\u7f72\u6ca1\u6709\u88ab\u542f\u7528");
        }
        this.setId(this.psDevSlnMSDepApp.getPSDEVSLNMSDEPAPPID());
        this.setName(this.psDevSlnMSDepApp.getPSDEVSLNMSDEPAPPNAME());
        this.setPSObjectData(this.psDevSlnMSDepApp);
        this.iPSDevSlnSys = iPSDevSlnSys;
        this.strPSDevSlnSysId = this.psDevSlnMSDepApp.getPSDEVSLNSYSID();
        this.strPSSysAppId = this.psDevSlnMSDepApp.getPSSYSAPPID();
        this.strPSDevCenterDBInstId = this.psDevSlnMSDepApp.getPSDEVCENTERDBINSTID();
        if (!StringHelper.isNullOrEmpty((String)this.psDevSlnMSDepApp.getPSDCMSPLATFORMID())) {
            IPSDCMSPlatform iPSDCMSPlatform = this.getPSModelStorage().getPSDCMSPlatform(this.psDevSlnMSDepApp.getPSDCMSPLATFORMID());
            this.setPSDCMSPlatform(iPSDCMSPlatform);
            if (!StringHelper.isNullOrEmpty((String)this.psDevSlnMSDepApp.getPSDCMSPLATFORMNODEID())) {
                IPSDCMSPlatformNode iPSDCMSPlatformNode = iPSDCMSPlatform.getPSDCMSPlatformNode(this.psDevSlnMSDepApp.getPSDCMSPLATFORMNODEID());
                this.setPSDCMSPlatformNode(iPSDCMSPlatformNode);
            }
        }
        if (!this.psDevSlnMSDepApp.isHTTPPORTNull() && this.psDevSlnMSDepApp.getHTTPPORT() > 0) {
            this.nHttpPort = this.psDevSlnMSDepApp.getHTTPPORT();
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getPSDevCenterDBInstId())) {
            PSDevCenterDBInst psDevCenterDBInst = new PSDevCenterDBInst();
            CallResult callResult = this.getPSModelHelper(null).getPSDCDBInst(this.getPSDevCenterDBInstId(), psDevCenterDBInst);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u6570\u636e\u5e93\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            PSDCDBDevInstImpl iPSDCDBDevInst = new PSDCDBDevInstImpl();
            iPSDCDBDevInst.init(this.getDAGlobalHelper(), psDevCenterDBInst);
            this.iPSDCDBDevInst = iPSDCDBDevInst;
        }
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDEVSLNMSDEPAPP";
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
    @PSModelRTMeta(description="\u524d\u7aef\u5e94\u7528")
    public IPSApplication getPSApplication() throws Exception {
        IPSDevSlnSys iPSDevSlnSys = this.getPSDevSlnSys();
        if (iPSDevSlnSys != null) {
            if (StringHelper.isNullOrEmpty((String)this.strPSSysAppId)) {
                return null;
            }
            return iPSDevSlnSys.getPSSystem().getPSApplication(this.strPSSysAppId);
        }
        return null;
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
    @PSModelRTMeta(description="\u5f00\u53d1\u7cfb\u7edf\u63a5\u53e3\u6807\u8bc6")
    public String getPSDevSlnSysAppId() {
        return this.psDevSlnMSDepApp.getPSDEVSLNSYSAPPID();
    }
}

