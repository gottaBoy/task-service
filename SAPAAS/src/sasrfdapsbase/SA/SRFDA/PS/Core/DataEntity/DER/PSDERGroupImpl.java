/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERGroup;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERGroupDetail;
import SA.SRFDA.PS.Core.DataEntity.DER.PSDERGroupDetailImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSDERGroup;
import SA.SRFDA.PS.Data.PSDERGroupDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDERGroupImpl
extends PSDataEntityObjectImpl
implements IPSDERGroup {
    private static final Log log = LogFactory.getLog(PSDERGroupImpl.class);
    protected PSDERGroup psDERGroup = null;
    protected ArrayList<IPSDERBase> psDERList = new ArrayList();
    protected ArrayList<IPSDERGroupDetail> psDERGroupDetailList = new ArrayList();
    private String strCodeName = "";
    private int nOrderValue = 99999;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDERGroup psDERGroup) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.psDERGroup = psDERGroup;
            this.setId(this.psDERGroup.getPSDERGROUPID());
            this.setName(this.psDERGroup.getPSDERGROUPNAME());
            this.setPSObjectData(this.psDERGroup);
            this.strCodeName = this.psDERGroup.getCODENAME();
            if (!this.psDERGroup.isORDERVALUENull()) {
                this.nOrderValue = this.psDERGroup.getORDERVALUE();
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSDataEntities();
    }

    protected void onPreparePSDataEntities() throws Exception {
        this.psDERList.clear();
        this.psDERGroupDetailList.clear();
        Vector<PSDERGroupDetail> psDERGroupDetailList = new Vector<PSDERGroupDetail>();
        CallResult callResult = this.getPSModelHelper().getPSDERGroupDetails(this.getId(), psDERGroupDetailList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5173\u7cfb\u7ec4\u6210\u5458\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDERGroupDetail psDERGroupDetail : psDERGroupDetailList) {
            if (!psDERGroupDetail.isVALIDFLAGNull() && !psDERGroupDetail.getVALIDFLAG()) continue;
            PSDERGroupDetailImpl iPSDERGroupDetail = new PSDERGroupDetailImpl();
            iPSDERGroupDetail.init(this.getDAGlobalHelper(), this, psDERGroupDetail);
            this.psDERGroupDetailList.add(iPSDERGroupDetail);
            if (iPSDERGroupDetail.getPSDER() == null) continue;
            this.psDERList.add(iPSDERGroupDetail.getPSDER());
        }
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u96c6\u5408")
    public Iterator<IPSDERBase> getPSDERs() {
        if (this.psDERList == null || this.psDERList.size() == 0) {
            return null;
        }
        return this.psDERList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u7ec4\u6210\u5458\u96c6\u5408", child=true, dynamodelmode=5, ignorepf=true)
    public Iterator<IPSDERGroupDetail> getPSDERGroupDetails() {
        if (this.psDERGroupDetailList == null || this.psDERGroupDetailList.size() == 0) {
            return null;
        }
        return this.psDERGroupDetailList.iterator();
    }

    @Override
    public String getModelType() {
        return "PSDERGROUP";
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02", hideempty2=true)
    public String getCodeName2() {
        return this.psDERGroup.getCODENAME2();
    }

    @Override
    public boolean contains(String strPSDERName) {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSDERName)) {
            return false;
        }
        if (this.psDERList == null || this.psDERList.size() == 0) {
            return false;
        }
        for (IPSDERBase iPSDER : this.psDERList) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDER.getId(), (String)strPSDERName, (boolean)false) == 0) {
                return true;
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDER.getName(), (String)strPSDERName, (boolean)true) != 0) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(IPSDERBase iPSDER2) {
        if (iPSDER2 == null) {
            return false;
        }
        if (this.psDERList == null || this.psDERList.size() == 0) {
            return false;
        }
        for (IPSDERBase iPSDER : this.psDERList) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDER.getId(), (String)iPSDER2.getId(), (boolean)false) != 0) continue;
            return true;
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", ignoredumpvalues="99999")
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6807\u8bb0", fields={"GROUPTAG"})
    public String getGroupTag() {
        return this.psDERGroup.getGROUPTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6807\u8bb02", fields={"GROUPTAG2"})
    public String getGroupTag2() {
        return this.psDERGroup.getGROUPTAG2();
    }
}

