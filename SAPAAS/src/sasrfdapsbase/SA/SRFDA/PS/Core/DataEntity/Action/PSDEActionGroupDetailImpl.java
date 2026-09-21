/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionGroup;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionGroupDetail;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEAGDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEActionGroupDetailImpl
extends PSObjectImpl
implements IPSDEActionGroupDetail {
    private static final Log log = LogFactory.getLog(PSDEActionGroupDetailImpl.class);
    private IPSDEActionGroup iPSDEActionGroup = null;
    private PSDEAGDetail psDEActionDetail = null;
    private IPSDEAction iPSDEAction = null;
    private IPSDEDataSet iPSDEDataSet = null;
    private int nOrderValue = 1000;
    private String strCodeName = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEActionGroup iPSDEActionGroup, PSDEAGDetail psDEActionDetail) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEActionGroup = iPSDEActionGroup;
            this.psDEActionDetail = psDEActionDetail;
            this.setId(this.psDEActionDetail.getPSDEAGDETAILID());
            this.setName(this.psDEActionDetail.getPSDEAGDETAILNAME());
            this.setPSObjectData(psDEActionDetail);
            this.strCodeName = psDEActionDetail.getCODENAME();
            if (StringHelper.compare((String)this.getDetailType(), (String)"DEACTION", (boolean)false) == 0) {
                if (!StringHelper.isNullOrEmpty((String)psDEActionDetail.getPSDEACTIONID()) && iPSDEActionGroup.getPSDataEntity() != null) {
                    this.iPSDEAction = iPSDEActionGroup.getPSDataEntity().getPSDEAction(psDEActionDetail.getPSDEACTIONID());
                }
                if (this.getPSDEAction() == null) {
                    throw new Exception("\u5b9e\u4f53\u884c\u4e3a\u65e0\u6548");
                }
                if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                    this.strCodeName = this.getPSDEAction().getCodeName();
                }
            } else if (StringHelper.compare((String)this.getDetailType(), (String)"DEDATASET", (boolean)false) == 0) {
                if (!StringHelper.isNullOrEmpty((String)psDEActionDetail.getPSDEDATASETID()) && iPSDEActionGroup.getPSDataEntity() != null) {
                    this.iPSDEDataSet = iPSDEActionGroup.getPSDataEntity().getPSDEDataSet(psDEActionDetail.getPSDEDATASETID());
                }
                if (this.getPSDEDataSet() == null) {
                    throw new Exception("\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u65e0\u6548");
                }
                if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                    this.strCodeName = this.getPSDEDataSet().getCodeName();
                }
            }
            if (!this.psDEActionDetail.isORDERVALUENull()) {
                this.nOrderValue = this.psDEActionDetail.getORDERVALUE();
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
    public IPSDEActionGroup getPSDEActionGroup() {
        return this.iPSDEActionGroup;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a", hideempty=true, dumpref=true, from="IPSDataEntity", fields={"PSDEACTIONID"})
    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u7c7b\u578b", codelist="DEAGDetailType", fields={"DETAILTYPE"})
    public String getDetailType() {
        return this.psDEActionDetail.getDETAILTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6", hideempty=true, dumpref=true, from="IPSDataEntity", fields={"PSDEDATASETID"})
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEActionGroup().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEAGDETAIL";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEActionGroup().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEActionGroup().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEActionGroup().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c")
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02", hideempty2=true)
    public String getCodeName2() {
        return this.psDEActionDetail.getCODENAME2();
    }
}

