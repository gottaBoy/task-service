/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.IDEBehaviorHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;

public class DEBehaviorHelper
extends BaseDAObjectHelper
implements IDEBehaviorHelper {
    protected DEBehavior deBehavior = null;
    private String strActionTarget = "";
    private String strBHCode = "";
    private String strImportance = "";
    private String strProcessType = "";
    private int nOrderFlag = 0;
    private String strDescription = "";
    private String strTooltip = "";
    private String strCaption = "";
    private String strDEId = "";
    private String strDevImageId = "";
    private String strCapLanResId = "";
    private String strTipLanResId = "";
    private String strResourceId = "";
    private String strDEActionId = "";
    private int nTimeout = 0;
    private String strConfirmInfo = "";
    private boolean bReloadData = false;
    private String strDataAction = "";
    private String strSuccessInfo = "";
    private String strBeforeCode = "";
    private String strSuccessCode = "";
    private String strDEWizardId = "";
    private String strExtParams = "";
    private String strFrontProType = "";
    private String strPageId = "";
    private String strUrlAppendParam = "";
    private boolean bHtmlMode = false;
    private boolean bUserConfirm = false;

    @Override
    public final void Init(ISRFDAGlobalHelper iDAGlobalHelper, DEBehavior deBehavior) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.deBehavior = deBehavior;
        this.setId(deBehavior.getDEBEHAVIORID());
        this.setName(deBehavior.getDEBEHAVIORNAME());
        this.setVersion(deBehavior.getVERSION());
        this.InitModel(deBehavior);
        this.OnInit();
    }

    @Override
    public final DEBehavior getData() {
        return this.deBehavior;
    }

    @Override
    public String getActionTarget() {
        return this.strActionTarget;
    }

    protected void setActionTarget(String strValue) {
        this.strActionTarget = strValue;
    }

    @Override
    public String getBHCode() {
        return this.strBHCode;
    }

    protected void setBHCode(String strValue) {
        this.strBHCode = strValue;
    }

    @Override
    public String getImportance() {
        return this.strImportance;
    }

    protected void setImportance(String strValue) {
        this.strImportance = strValue;
    }

    @Override
    public String getProcessType() {
        return this.strProcessType;
    }

    protected void setProcessType(String strValue) {
        this.strProcessType = strValue;
    }

    @Override
    public int getOrderFlag() {
        return this.nOrderFlag;
    }

    protected void setOrderFlag(int nValue) {
        this.nOrderFlag = nValue;
    }

    @Override
    public String getDescription() {
        return this.strDescription;
    }

    protected void setDescription(String strValue) {
        this.strDescription = strValue;
    }

    @Override
    public String getTooltip() {
        if (StringHelper.IsNullOrEmpty((String)this.strTooltip)) {
            return this.getCaption();
        }
        return this.strTooltip;
    }

    protected void setTooltip(String strValue) {
        this.strTooltip = strValue;
    }

    @Override
    public String getCaption() {
        return this.strCaption;
    }

    protected void setCaption(String strValue) {
        this.strCaption = strValue;
    }

    @Override
    public String getDEId() {
        return this.strDEId;
    }

    protected void setDEId(String strValue) {
        this.strDEId = strValue;
    }

    @Override
    public String getDevImageId() {
        return this.strDevImageId;
    }

    protected void setDevImageId(String strValue) {
        this.strDevImageId = strValue;
    }

    @Override
    public String getCapLanResId() {
        return this.strCapLanResId;
    }

    protected void setCapLanResId(String strValue) {
        this.strCapLanResId = strValue;
    }

    @Override
    public String getTipLanResId() {
        if (StringHelper.IsNullOrEmpty((String)this.strTipLanResId)) {
            return this.getCapLanResId();
        }
        return this.strTipLanResId;
    }

    protected void setTipLanResId(String strValue) {
        this.strTipLanResId = strValue;
    }

    @Override
    public String getResourceId() {
        return this.strResourceId;
    }

    protected void setResourceId(String strValue) {
        this.strResourceId = strValue;
    }

    @Override
    public String getDEActionId() {
        return this.strDEActionId;
    }

    protected void setDEActionId(String strValue) {
        this.strDEActionId = strValue;
    }

    @Override
    public int getTimeout() {
        return this.nTimeout;
    }

    protected void setTimeout(int nValue) {
        this.nTimeout = nValue;
    }

    @Override
    public String getConfirmInfo() {
        return this.strConfirmInfo;
    }

    protected void setConfirmInfo(String strValue) {
        this.strConfirmInfo = strValue;
    }

    @Override
    public boolean isReloadData() {
        return this.bReloadData;
    }

    protected void setReloadData(boolean bValue) {
        this.bReloadData = bValue;
    }

    @Override
    public String getDataAction() {
        return this.strDataAction;
    }

    protected void setDataAction(String strValue) {
        this.strDataAction = strValue;
    }

    @Override
    public String getSuccessInfo() {
        return this.strSuccessInfo;
    }

    protected void setSuccessInfo(String strValue) {
        this.strSuccessInfo = strValue;
    }

    @Override
    public String getBeforeCode() {
        return this.strBeforeCode;
    }

    protected void setBeforeCode(String strValue) {
        this.strBeforeCode = strValue;
    }

    @Override
    public String getSuccessCode() {
        return this.strSuccessCode;
    }

    protected void setSuccessCode(String strValue) {
        this.strSuccessCode = strValue;
    }

    @Override
    public String getDEWizardId() {
        return this.strDEWizardId;
    }

    protected void setDEWizardId(String strValue) {
        this.strDEWizardId = strValue;
    }

    @Override
    public String getExtParams() {
        return this.strExtParams;
    }

    protected void setExtParams(String strValue) {
        this.strExtParams = strValue;
    }

    @Override
    public String getFrontProType() {
        return this.strFrontProType;
    }

    protected void setFrontProType(String strValue) {
        this.strFrontProType = strValue;
    }

    @Override
    public String getPageId() {
        return this.strPageId;
    }

    protected void setPageId(String strValue) {
        this.strPageId = strValue;
    }

    @Override
    public String getUrlAppendParam() {
        return this.strUrlAppendParam;
    }

    protected void setUrlAppendParam(String strValue) {
        this.strUrlAppendParam = strValue;
    }

    @Override
    public boolean isHtmlMode() {
        return this.bHtmlMode;
    }

    protected void setHtmlMode(boolean bValue) {
        this.bHtmlMode = bValue;
    }

    @Override
    public boolean isUserConfirm() {
        return this.bUserConfirm;
    }

    protected void setUserConfirm(boolean bValue) {
        this.bUserConfirm = bValue;
    }

    private void InitModel(DEBehavior item) {
        if (!item.isACTIONTARGETNull()) {
            this.setActionTarget(item.getACTIONTARGET());
        }
        if (!item.isBHCODENull()) {
            this.setBHCode(item.getBHCODE());
        }
        if (!item.isIMPORTANCENull()) {
            this.setImportance(item.getIMPORTANCE());
        }
        if (!item.isPROCESSTYPENull()) {
            this.setProcessType(item.getPROCESSTYPE());
        }
        if (!item.isORDERFLAGNull()) {
            this.setOrderFlag(item.getORDERFLAG());
        }
        if (!item.isDESCRIPTIONNull()) {
            this.setDescription(item.getDESCRIPTION());
        }
        if (!item.isTOOLTIPNull()) {
            this.setTooltip(item.getTOOLTIP());
        }
        if (!item.isCAPTIONNull()) {
            this.setCaption(item.getCAPTION());
        }
        if (!item.isDEIDNull()) {
            this.setDEId(item.getDEID());
        }
        if (!item.isDEVIMAGEIDNull()) {
            this.setDevImageId(item.getDEVIMAGEID());
        }
        if (!item.isCAPLANRESIDNull()) {
            this.setCapLanResId(item.getCAPLANRESID());
        }
        if (!item.isTIPLANRESIDNull()) {
            this.setTipLanResId(item.getTIPLANRESID());
        }
        if (!item.isRESOURCEIDNull()) {
            this.setResourceId(item.getRESOURCEID());
        }
        if (!item.isDEACTIONIDNull()) {
            this.setDEActionId(item.getDEACTIONID());
        }
        if (!item.isTIMEOUTNull()) {
            this.setTimeout(item.getTIMEOUT());
        }
        if (!item.isCONFIRMINFONull()) {
            this.setConfirmInfo(item.getCONFIRMINFO());
        }
        if (!item.isRELOADDATANull()) {
            this.setReloadData(item.getRELOADDATA());
        }
        if (!item.isDATAACTIONNull()) {
            this.setDataAction(item.getDATAACTION());
        }
        if (!item.isSUCCESSINFONull()) {
            this.setSuccessInfo(item.getSUCCESSINFO());
        }
        if (!item.isBEFORECODENull()) {
            this.setBeforeCode(item.getBEFORECODE());
        }
        if (!item.isSUCCESSCODENull()) {
            this.setSuccessCode(item.getSUCCESSCODE());
        }
        if (!item.isDEWIZARDIDNull()) {
            this.setDEWizardId(item.getDEWIZARDID());
        }
        if (!item.isEXTPARAMSNull()) {
            this.setExtParams(item.getEXTPARAMS());
        }
        if (!item.isFRONTPROTYPENull()) {
            this.setFrontProType(item.getFRONTPROTYPE());
        }
        if (!item.isPAGEIDNull()) {
            this.setPageId(item.getPAGEID());
        }
        if (!item.isURLAPPENDPARAMNull()) {
            this.setUrlAppendParam(item.getURLAPPENDPARAM());
        }
        if (!item.isHTMLMODENull()) {
            this.setHtmlMode(item.getHTMLMODE());
        }
        if (!item.isUSERCONFIRMNull()) {
            this.setUserConfirm(item.getUSERCONFIRM());
        }
    }
}

