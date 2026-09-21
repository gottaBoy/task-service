/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Ajax;

import SA.SRFDA.PS.Core.Control.Ajax.IPSMDAjaxControlHandler;
import SA.SRFDA.PS.Core.Control.Ajax.PSAjaxControlHandlerActionImpl;
import SA.SRFDA.PS.Core.Control.Ajax.PSAjaxControlHandlerImpl;
import SA.SRFDA.PS.Core.Control.IPSControlXDataContainer;
import SA.SRFDA.PS.Core.Control.IPSMDAjaxControlParam;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExport;
import SA.SRFDA.PS.Core.DataEntity.DataImport.IPSDEDataImport;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Security.IPSSysUserDR;
import SA.SRFDA.PS.Data.PSACHandlerAction;
import SA.SRFramework.Utility.StringHelper;

public class PSMDAjaxControlHandlerImpl
extends PSAjaxControlHandlerImpl
implements IPSMDAjaxControlHandler {
    protected String strPSDEDataSetId = "";
    protected IPSMDAjaxControlParam iPSMDAjaxControlParam = null;
    protected String strPSDEDataExportId = "";
    private String strActiveDataPSDELogicId = "";
    protected String strCustomCond = "";
    private boolean bEnableOrgDR = false;
    private boolean bEnableSecDR = false;
    private boolean bEnableSecBC = false;
    private long nOrgDR = 0L;
    private long nSecDR = 0L;
    private String strSecBC = "";
    private boolean bEnableUserDR = false;
    private String strUserDRAction = "READ";
    private String strCustomDRModeParam = "";
    private String strCustomDRMode2Param = "";
    private IPSSysUserDR iPSSysUserDR = null;
    private IPSSysUserDR iPSSysUserDR2 = null;
    private int nFetchTimeout = -1;
    private String strPSDEDataImportId = "";

    @Override
    protected void onInit() throws Exception {
        if (this.getTempMode() == 1) {
            this.ajaxDEActionNameMap.put("load", "GETTEMPMAJOR");
            this.ajaxDEActionNameMap.put("create", "CREATETEMPMAJOR");
            this.ajaxDEActionNameMap.put("update", "UPDATETEMPMAJOR");
            this.ajaxDEActionNameMap.put("remove", "REMOVETEMPMAJOR");
        } else if (this.getTempMode() == 2) {
            this.ajaxDEActionNameMap.put("load", "GETTEMP");
            this.ajaxDEActionNameMap.put("create", "CREATETEMP");
            this.ajaxDEActionNameMap.put("update", "UPDATETEMP");
            this.ajaxDEActionNameMap.put("remove", "REMOVETEMP");
        } else {
            this.ajaxDEActionNameMap.put("load", "GET");
            this.ajaxDEActionNameMap.put("create", "CREATE");
            this.ajaxDEActionNameMap.put("update", "UPDATE");
            this.ajaxDEActionNameMap.put("remove", "REMOVE");
        }
        this.ajaxDataAccessActionMap.put("load", "READ");
        this.ajaxDataAccessActionMap.put("create", "CREATE");
        this.ajaxDataAccessActionMap.put("update", "UPDATE");
        this.ajaxDataAccessActionMap.put("remove", "DELETE");
        this.ajaxDataAccessActionMap.put("clone", "CREATE");
        this.ajaxDataAccessActionMap.put("addbatch", "CREATE");
        super.onInit();
        if (!this.psAjaxControlHandler.isFETCHTIMEOUTNull()) {
            this.nFetchTimeout = this.psAjaxControlHandler.getFETCHTIMEOUT();
        }
        if (!this.psAjaxControlHandler.isENABLEORGDRNull()) {
            this.bEnableOrgDR = this.psAjaxControlHandler.getENABLEORGDR();
            if (this.bEnableOrgDR) {
                this.nOrgDR = this.psAjaxControlHandler.getORGDR();
            }
        }
        if (!this.psAjaxControlHandler.isENABLESECDRNull()) {
            this.bEnableSecDR = this.psAjaxControlHandler.getENABLESECDR();
            if (this.bEnableSecDR) {
                this.nSecDR = this.psAjaxControlHandler.getSECDR();
            }
        }
        if (!this.psAjaxControlHandler.isENABLESECBCNull()) {
            this.bEnableSecBC = this.psAjaxControlHandler.getENABLESECBC();
            if (this.bEnableSecBC) {
                this.strSecBC = this.psAjaxControlHandler.getSECBC();
            }
        }
        if (!this.psAjaxControlHandler.isENABLEUSERDRNull()) {
            this.bEnableUserDR = this.psAjaxControlHandler.getENABLEUSERDR();
        }
        this.iPSMDAjaxControlParam = (IPSMDAjaxControlParam)this.getPSAjaxControl().getPSAjaxControlParam();
        this.setPSDEDataSetId(this.iPSMDAjaxControlParam.getPSDEDataSetId());
        this.setCustomCond(this.iPSMDAjaxControlParam.getCustomCond());
        this.setPSDEDataExportId(this.iPSMDAjaxControlParam.getPSDEDataExportId());
        this.setPSDEDataImportId(this.iPSMDAjaxControlParam.getPSDEDataImportId());
        this.setActiveDataPSDELogicId(this.iPSMDAjaxControlParam.getActiveDataPSDELogicId());
        if (!StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getGETPSDEACTIONNAME())) {
            this.ajaxDEActionNameMap.put("load", this.psAjaxControlHandler.getGETPSDEACTIONNAME());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getCREATEPSDEACTIONNAME())) {
            this.ajaxDEActionNameMap.put("create", this.psAjaxControlHandler.getCREATEPSDEACTIONNAME());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getUPDATEPSDEACTIONNAME())) {
            this.ajaxDEActionNameMap.put("update", this.psAjaxControlHandler.getUPDATEPSDEACTIONNAME());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getREMOVEPSDEACTIONNAME())) {
            this.ajaxDEActionNameMap.put("remove", this.psAjaxControlHandler.getREMOVEPSDEACTIONNAME());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getMOVEPSDEACTIONNAME())) {
            this.ajaxDEActionNameMap.put("move", this.psAjaxControlHandler.getMOVEPSDEACTIONNAME());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getGROUPMOVEPSDEACTIONNAME())) {
            this.ajaxDEActionNameMap.put("groupmove", this.psAjaxControlHandler.getGROUPMOVEPSDEACTIONNAME());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getREADPSDEOPPRIVNAME())) {
            this.ajaxDataAccessActionMap.put("load", this.psAjaxControlHandler.getREADPSDEOPPRIVNAME());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getCREATEPSDEOPPRIVINAME())) {
            this.ajaxDataAccessActionMap.put("create", this.psAjaxControlHandler.getCREATEPSDEOPPRIVINAME());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getUPDATEPSDEOPPRIVNAME())) {
            this.ajaxDataAccessActionMap.put("update", this.psAjaxControlHandler.getUPDATEPSDEOPPRIVNAME());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getREMOVEPSDEOPPRIVNAME())) {
            this.ajaxDataAccessActionMap.put("remove", this.psAjaxControlHandler.getREMOVEPSDEOPPRIVNAME());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getEXPORTPSDEOPPRIVINAME())) {
            this.ajaxDataAccessActionMap.put("exportdata", this.psAjaxControlHandler.getEXPORTPSDEOPPRIVINAME());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getPSSYSUSERDRID())) {
            this.iPSSysUserDR = this.getPSAppView().getPSSystem().getPSSysUserDR(this.psAjaxControlHandler.getPSSYSUSERDRID());
            this.strCustomDRModeParam = this.psAjaxControlHandler.getSYSUSERDRPARAM();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getPSSYSUSERDRID2())) {
            this.iPSSysUserDR2 = this.getPSAppView().getPSSystem().getPSSysUserDR(this.psAjaxControlHandler.getPSSYSUSERDRID2());
            this.strCustomDRMode2Param = this.psAjaxControlHandler.getSYSUSERDR2PARAM();
        }
        if (this.getPSAjaxControl().getRecvAjaxActionMode() == 1 && this.getPSAppView() instanceof IPSControlXDataContainer) {
            IPSControlXDataContainer iPSControlXDataContainer = (IPSControlXDataContainer)((Object)this.getPSAppView());
            if (!iPSControlXDataContainer.isEnableNewData()) {
                this.ajaxDataAccessActionMap.put("create", "DENY");
                this.ajaxDataAccessActionMap.put("clone", "DENY");
            }
            if (!iPSControlXDataContainer.isEnableCopy()) {
                this.ajaxDataAccessActionMap.put("clone", "DENY");
            }
            if (!iPSControlXDataContainer.isEnableEditData() || iPSControlXDataContainer.isReadOnly()) {
                this.ajaxDataAccessActionMap.put("update", "DENY");
            }
            if (!iPSControlXDataContainer.isEnableRemoveData() || iPSControlXDataContainer.isReadOnly()) {
                this.ajaxDataAccessActionMap.put("remove", "DENY");
            }
            if (!iPSControlXDataContainer.isEnableStartWF()) {
                this.ajaxDataAccessActionMap.put("wfstart", "DENY");
            }
        }
    }

    @Override
    public String getPSDEDataSetId() {
        return this.strPSDEDataSetId;
    }

    public void setPSDEDataSetId(String strPSDEDataSetId) {
        this.strPSDEDataSetId = strPSDEDataSetId;
    }

    @Override
    public String getCustomCond() {
        return this.strCustomCond;
    }

    public void setCustomCond(String strCustomCond) {
        this.strCustomCond = strCustomCond;
    }

    public String getDEDataSetId() {
        return this.getPSDEDataSetId();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61")
    public IPSDEDataSet getPSDEDataSet() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getDEDataSetId())) {
            return null;
        }
        return this.getPSDataEntityMust().getPSDEDataSet(this.getDEDataSetId());
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u5bf9\u8c61")
    public IPSDEDataExport getPSDEDataExport() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getDEDataExportId())) {
            return null;
        }
        return this.getPSDataEntity().getPSDEDataExport(this.getDEDataExportId());
    }

    @PSModelRTMeta(description="\u652f\u6301\u673a\u6784\u6570\u636e\u8303\u56f4", ignoredumpvalues="false")
    public boolean isEnableOrgDR() {
        return this.bEnableOrgDR;
    }

    @PSModelRTMeta(description="\u652f\u6301\u90e8\u95e8\u6570\u636e\u8303\u56f4", ignoredumpvalues="false")
    public boolean isEnableSecDR() {
        return this.bEnableSecDR;
    }

    @PSModelRTMeta(description="\u652f\u6301\u90e8\u95e8\u4e1a\u52a1\u6761\u7ebf", ignoredumpvalues="false")
    public boolean isEnableSecBC() {
        return this.bEnableSecBC;
    }

    @PSModelRTMeta(description="\u673a\u6784\u6570\u636e\u8303\u56f4", codelist="ACHOrgDR", ignoredumpvalues="0")
    public long getOrgDR() {
        return this.nOrgDR;
    }

    @PSModelRTMeta(description="\u90e8\u95e8\u6570\u636e\u8303\u56f4", codelist="ACHSecDR", ignoredumpvalues="0")
    public long getSecDR() {
        return this.nSecDR;
    }

    @PSModelRTMeta(description="\u90e8\u95e8\u4e1a\u52a1\u6761\u4ef6")
    public String getSecBC() {
        return this.strSecBC;
    }

    @PSModelRTMeta(description="\u542f\u7528\u7528\u6237\u6570\u636e\u8303\u56f4", ignoredumpvalues="false")
    public boolean isEnableUserDR() {
        return this.bEnableUserDR;
    }

    @PSModelRTMeta(description="\u6570\u636e\u8bbf\u95ee\u4f7f\u7528\u64cd\u4f5c\u6807\u8bc6")
    public String getUserDRAction() {
        return this.strUserDRAction;
    }

    public String getCustomDRMode() {
        if (this.getPSSysUserDR() != null) {
            return this.getPSSysUserDR().getCustomMode();
        }
        return null;
    }

    public String getCustomDRMode2() {
        if (this.getPSSysUserDR2() != null) {
            return this.getPSSysUserDR2().getCustomMode();
        }
        return null;
    }

    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6570\u636e\u8303\u56f4\u53c2\u6570")
    public String getCustomDRModeParam() {
        return this.strCustomDRModeParam;
    }

    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6570\u636e\u8303\u56f42\u53c2\u6570")
    public String getCustomDRMode2Param() {
        return this.strCustomDRMode2Param;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6570\u636e\u8303\u56f4\u5bf9\u8c61", dumpref=true)
    public IPSSysUserDR getPSSysUserDR() {
        return this.iPSSysUserDR;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6570\u636e\u8303\u56f4\u5bf9\u8c612", dumpref=true)
    public IPSSysUserDR getPSSysUserDR2() {
        return this.iPSSysUserDR2;
    }

    @Override
    public String getPSDEDataExportId() {
        return this.strPSDEDataExportId;
    }

    public void setPSDEDataExportId(String strPSDEDataExportId) {
        this.strPSDEDataExportId = strPSDEDataExportId;
    }

    public String getDEDataExportId() {
        return this.getPSDEDataExportId();
    }

    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u6570\u636e\u8d85\u65f6\uff08\u6beb\u79d2\uff09", ignoredumpvalues="-1")
    public int getFetchTimeout() {
        return this.nFetchTimeout;
    }

    @Override
    public String getActiveDataPSDELogicId() {
        return this.strActiveDataPSDELogicId;
    }

    public void setActiveDataPSDELogicId(String strActiveDataPSDELogicId) {
        this.strActiveDataPSDELogicId = strActiveDataPSDELogicId;
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u4e0b\u6587\u6570\u636e\u8ba1\u7b97\u903b\u8f91")
    public IPSDELogic getActiveDataPSDELogic() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getActiveDataPSDELogicId())) {
            return null;
        }
        return this.getPSDataEntityMust().getPSDELogic(this.getActiveDataPSDELogicId());
    }

    @Override
    public String getPSDEDataImportId() {
        return this.strPSDEDataImportId;
    }

    public void setPSDEDataImportId(String strPSDEDataImportId) {
        this.strPSDEDataImportId = strPSDEDataImportId;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u5bf9\u8c61")
    public IPSDEDataImport getPSDEDataImport() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getPSDEDataImportId())) {
            return null;
        }
        return this.getPSDataEntity().getPSDEDataImport(this.getPSDEDataImportId());
    }

    @Override
    protected void onPreparePSAjaxHandlerActions() throws Exception {
        super.onPreparePSAjaxHandlerActions();
        if (this.getPSAppDataEntity() != null) {
            String strAction = "fetch";
            PSACHandlerAction psACHandlerAction = new PSACHandlerAction();
            psACHandlerAction.setPSACHANDLERACTIONID(StringHelper.Format((String)"%1$s_%2$s", (Object)this.getId(), (Object)strAction));
            psACHandlerAction.setPSACHANDLERACTIONNAME(strAction);
            psACHandlerAction.setACTIONTYPE("DEDATASET");
            psACHandlerAction.setACTIONTIMEOUT(this.getFetchTimeout());
            psACHandlerAction.setPSDEDATASETID(this.getPSDEDataSetId());
            psACHandlerAction.setCUSTOMCOND(this.getCustomCond());
            psACHandlerAction.setADPSDELOGICID(this.getActiveDataPSDELogicId());
            PSAjaxControlHandlerActionImpl psAjaxControlHandlerActionImpl = new PSAjaxControlHandlerActionImpl();
            psAjaxControlHandlerActionImpl.init(this.getDAGlobalHelper(), this, psACHandlerAction);
            this.registerPSAjaxHandlerAction(psAjaxControlHandlerActionImpl);
        }
    }
}

