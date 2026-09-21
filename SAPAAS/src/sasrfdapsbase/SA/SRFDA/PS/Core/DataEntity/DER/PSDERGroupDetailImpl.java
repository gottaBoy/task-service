/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERGroup;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERGroupDetail;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDERGroupDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDERGroupDetailImpl
extends PSObjectImpl
implements IPSDERGroupDetail {
    private static final Log log = LogFactory.getLog(PSDERGroupDetailImpl.class);
    private IPSDERGroup iPSDERGroup = null;
    private PSDERGroupDetail psDERGroupDetail = null;
    private IPSDERBase iPSDERBase = null;
    private int nOrderValue = 1000;
    private String strCodeName = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDERGroup iPSDERGroup, PSDERGroupDetail psDERGroupDetail) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDERGroup = iPSDERGroup;
            this.psDERGroupDetail = psDERGroupDetail;
            this.setId(this.psDERGroupDetail.getPSDERGROUPDETAILID());
            this.setName(this.psDERGroupDetail.getPSDERGROUPDETAILNAME());
            this.setPSObjectData(psDERGroupDetail);
            if (!StringHelper.isNullOrEmpty((String)psDERGroupDetail.getPSDERID())) {
                this.iPSDERBase = iPSDERGroup.getPSSystem().getPSDER(psDERGroupDetail.getPSDERID());
            }
            if (this.getPSDER() == null) {
                throw new Exception("\u5b9e\u4f53\u5173\u7cfb\u5bf9\u8c61\u65e0\u6548");
            }
            this.strCodeName = psDERGroupDetail.getCODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getPSDER().getCodeName();
            }
            if (!this.psDERGroupDetail.isORDERVALUENull()) {
                this.nOrderValue = this.psDERGroupDetail.getORDERVALUE();
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
    public IPSDERGroup getPSDERGroup() {
        return this.iPSDERGroup;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb", dumpref=true, ignorepf=true, fields={"PSDERID"})
    public IPSDERBase getPSDER() {
        return this.iPSDERBase;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDERGroup().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        if (StringHelper.compare((String)this.getPSDERGroup().getModelType(), (String)"PSSYSDERGROUP", (boolean)false) == 0) {
            return "PSSYSDERGROUPDETAIL";
        }
        return "PSDERGROUPDETAIL";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDERGroup().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDERGroup().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDERGroup().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", ignoredumpvalues="99999")
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02", hideempty2=true)
    public String getCodeName2() {
        return this.psDERGroupDetail.getCODENAME2();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u6807\u8bb0", hideempty2=true)
    public String getDetailTag() {
        return this.psDERGroupDetail.getDETAILTAG();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u6807\u8bb02", hideempty2=true)
    public String getDetailTag2() {
        return this.psDERGroupDetail.getDETAILTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u6570\u636e", hideempty2=true)
    public String getData() {
        return this.psDERGroupDetail.getDATA();
    }
}

