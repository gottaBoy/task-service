/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemVR;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Data.PSDEFormItemVR;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFormItemVRImpl
extends PSObjectImpl
implements IPSDEFormItemVR {
    private static final Log log = LogFactory.getLog(PSDEFormItemVRImpl.class);
    protected IPSDEForm iPSDEForm;
    protected PSDEFormItemVR psDEFormItemVR;
    protected IPSDEFValueRule iPSDEFValueRule = null;
    private IPSDEFormItem iPSDEFormItem = null;
    private int nCheckMode = 3;
    private String strValueRuleType = "DEFVALUERULE";
    private IPSSysValueRule iPSSysValueRule = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEForm iPSDEForm, PSDEFormItemVR psDEFormItemVR) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEForm = iPSDEForm;
            this.psDEFormItemVR = psDEFormItemVR;
            this.setId(psDEFormItemVR.getPSDEFIVRID());
            this.setName(psDEFormItemVR.getPSDEFIVRNAME());
            this.setPSObjectData(psDEFormItemVR);
            this.iPSDEFormItem = iPSDEForm.getPSDEFormItem(psDEFormItemVR.getPSDEFIID());
            if (!StringHelper.IsNullOrEmpty((String)this.psDEFormItemVR.getVRTYPE())) {
                this.strValueRuleType = this.psDEFormItemVR.getVRTYPE();
            }
            if ("DEFVALUERULE".equals(this.getValueRuleType())) {
                this.iPSDEFValueRule = iPSDEForm.getPSDataEntity().getPSDEFValueRule(this.psDEFormItemVR.getPSDEFVRID());
            } else if ("SYSVALUERULE".equals(this.getValueRuleType())) {
                this.iPSSysValueRule = iPSDEForm.getPSDataEntity().getPSSystem().getPSSysValueRule(this.psDEFormItemVR.getPSSYSVALUERULEID());
            }
            if (!this.psDEFormItemVR.isCHECKMODENull()) {
                this.nCheckMode = this.psDEFormItemVR.getCHECKMODE();
            }
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
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
    public String getPSSysModelInstId() {
        return this.iPSDEForm.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u9879\u540d\u79f0", fields={"PSDEFINAME"})
    public String getPSDEFormItemName() {
        return this.psDEFormItemVR.getPSDEFINAME();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u5bf9\u8c61 ")
    public IPSDEForm getPSDEForm() {
        return this.iPSDEForm;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u503c\u89c4\u5219 ", child=true, fields={"PSDEFVRID"})
    public IPSDEFValueRule getPSDEFValueRule() {
        return this.iPSDEFValueRule;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u9879 ")
    public IPSDEFormItem getPSDEFormItem() {
        return this.iPSDEFormItem;
    }

    @Override
    @PSModelRTMeta(description="\u68c0\u67e5\u6a21\u5f0f", codelist="DEFIVRCheckMode", fields={"CHECKMODE"})
    public int getCheckMode() {
        return this.nCheckMode;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEForm().getPSAppView().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEForm().getModelId(), (Object)this.getId());
    }

    @Override
    @PSModelRTMeta(description="\u503c\u89c4\u5219\u7c7b\u578b", codelist="DEFIVRType", fields={"VRTYPE"})
    public String getValueRuleType() {
        return this.strValueRuleType;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u503c\u89c4\u5219", child=true, fields={"PSSYSVALUERULEID"})
    public IPSSysValueRule getPSSysValueRule() {
        return this.iPSSysValueRule;
    }

    @Override
    public String getModelType() {
        return "PSDEFIVR";
    }

    @Override
    public String getModelRefId() {
        return null;
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        if (this.getPSDEFValueRule() != null && objectNode.has("getPSDEFValueRule")) {
            ObjectNode defValueRuleNode = (ObjectNode)objectNode.get("getPSDEFValueRule");
            defValueRuleNode.remove("checkDefault");
            defValueRuleNode.remove("defaultMode");
            defValueRuleNode.remove("enableBackend");
            defValueRuleNode.remove("enableFront");
        }
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u72b6\u6001", ignorert=3, ignoredumpvalues="0", fields={"MODELSTATE"})
    public int getModelState() {
        if (!this.psDEFormItemVR.isMODELSTATENull()) {
            return this.psDEFormItemVR.getMODELSTATE();
        }
        return 0;
    }
}

