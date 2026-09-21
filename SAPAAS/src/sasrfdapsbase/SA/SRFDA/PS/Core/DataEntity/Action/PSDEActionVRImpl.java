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

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionVR;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEActionVR;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEActionVRImpl
extends PSObjectImpl
implements IPSDEActionVR {
    private static final Log log = LogFactory.getLog(PSDEActionVRImpl.class);
    private IPSDEAction iPSDEAction = null;
    private PSDEActionVR psDEActionVR = null;
    private String strVRType = null;
    private IPSDEFValueRule iPSDEFValueRule = null;
    private String strCodeName = null;
    private int nOrderValue = 1000;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEAction iPSDEAction, PSDEActionVR psDEActionVR) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEAction(iPSDEAction);
            this.psDEActionVR = psDEActionVR;
            this.setId(this.psDEActionVR.getPSDEACTIONVRID());
            this.setName(this.psDEActionVR.getPSDEACTIONVRNAME());
            this.setPSObjectData(this.psDEActionVR);
            this.strVRType = psDEActionVR.getVRTYPE();
            if (!StringHelper.isNullOrEmpty((String)this.psDEActionVR.getCODENAME())) {
                this.strCodeName = this.psDEActionVR.getCODENAME();
            }
            if (!this.psDEActionVR.isORDERVALUENull()) {
                this.nOrderValue = this.psDEActionVR.getORDERVALUE();
            }
            if (StringHelper.compare((String)this.getValueRuleType(), (String)"DEFVALUERULE", (boolean)false) == 0) {
                if (StringHelper.isNullOrEmpty((String)this.psDEActionVR.getPSDEFVRID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027\u503c\u89c4\u5219");
                }
                this.iPSDEFValueRule = this.getPSDEAction().getPSDataEntity().getPSDEFValueRule(this.psDEActionVR.getPSDEFVRID());
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
    }

    @Override
    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
    }

    protected void setPSDEAction(IPSDEAction iPSDEAction) {
        this.iPSDEAction = iPSDEAction;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEAction.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u89c4\u5219\u7c7b\u578b", codelist="DEFIVRType")
    public String getValueRuleType() {
        return this.strVRType;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getModelType() {
        return "PSDEACTIONVR";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEAction().getModelId(), (Object)super.getModelId());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEAction().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEAction().getPSDataEntity().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u68c0\u67e5\u6b21\u5e8f")
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u503c\u89c4\u5219", dumpref=true, ignorepf=true, from="__self__", from_method="getPSDEFieldMust().getPSDEFValueRule")
    public IPSDEFValueRule getPSDEFValueRule() {
        return this.iPSDEFValueRule;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u5bf9\u8c61", dumpref=true, ignorepf=true, from="IPSDataEntity")
    public IPSDEField getPSDEField() {
        if (this.getPSDEFValueRule() != null) {
            return this.getPSDEFValueRule().getPSDEField();
        }
        return null;
    }
}

