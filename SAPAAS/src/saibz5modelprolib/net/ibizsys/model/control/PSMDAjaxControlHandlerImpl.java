/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEView
 *  net.ibizsys.model.control.IPSControlXDataContainer
 *  net.ibizsys.model.control.IPSMDAjaxControlParam
 *  net.ibizsys.model.control.ajax.IPSMDAjaxControlHandler
 *  net.ibizsys.model.dataentity.dataexport.IPSDEDataExport
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.model.dataentity.logic.IPSDELogic
 *  net.ibizsys.model.security.IPSSysUserDR
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.view.IPSAppDEView;
import net.ibizsys.model.control.IPSControlXDataContainer;
import net.ibizsys.model.control.IPSMDAjaxControlParam;
import net.ibizsys.model.control.PSAjaxControlHandlerImpl;
import net.ibizsys.model.control.ajax.IPSMDAjaxControlHandler;
import net.ibizsys.model.dataentity.dataexport.IPSDEDataExport;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.security.IPSSysUserDR;
import net.ibizsys.paas.util.StringHelper;

public class PSMDAjaxControlHandlerImpl
extends PSAjaxControlHandlerImpl
implements IPSMDAjaxControlHandler {
    protected String strPSDEDataSetId = "";
    protected IPSMDAjaxControlParam iPSMDAjaxControlParam = null;
    protected String strPSDEDataExportId = "";
    private String strActiveDataPSDELogicId = "";
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
            this.bEnableSecBC = this.psAjaxControlHandler.isENABLESECBCNull();
            if (this.bEnableSecBC) {
                this.strSecBC = this.psAjaxControlHandler.getSECBC();
            }
        }
        if (!this.psAjaxControlHandler.isENABLEUSERDRNull()) {
            this.bEnableUserDR = this.psAjaxControlHandler.getENABLEUSERDR();
        }
        this.iPSMDAjaxControlParam = (IPSMDAjaxControlParam)this.getPSAjaxControl().getPSAjaxControlParam();
        this.setPSDEDataSetId(this.iPSMDAjaxControlParam.getPSDEDataSetId());
        this.setPSDEDataExportId(this.iPSMDAjaxControlParam.getPSDEDataExportId());
        this.setActiveDataPSDELogicId(this.iPSMDAjaxControlParam.getActiveDataPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)this.psAjaxControlHandler.getGETPSDEACTIONNAME())) {
            this.ajaxDEActionNameMap.put("load", this.psAjaxControlHandler.getGETPSDEACTIONNAME());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psAjaxControlHandler.getCREATEPSDEACTIONNAME())) {
            this.ajaxDEActionNameMap.put("create", this.psAjaxControlHandler.getCREATEPSDEACTIONNAME());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psAjaxControlHandler.getUPDATEPSDEACTIONNAME())) {
            this.ajaxDEActionNameMap.put("update", this.psAjaxControlHandler.getUPDATEPSDEACTIONNAME());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psAjaxControlHandler.getREMOVEPSDEACTIONNAME())) {
            this.ajaxDEActionNameMap.put("remove", this.psAjaxControlHandler.getREMOVEPSDEACTIONNAME());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psAjaxControlHandler.getREADPSDEOPPRIVNAME())) {
            this.ajaxDataAccessActionMap.put("load", this.psAjaxControlHandler.getREADPSDEOPPRIVNAME());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psAjaxControlHandler.getCREATEPSDEOPPRIVINAME())) {
            this.ajaxDataAccessActionMap.put("create", this.psAjaxControlHandler.getCREATEPSDEOPPRIVINAME());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psAjaxControlHandler.getUPDATEPSDEOPPRIVNAME())) {
            this.ajaxDataAccessActionMap.put("update", this.psAjaxControlHandler.getUPDATEPSDEOPPRIVNAME());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psAjaxControlHandler.getREMOVEPSDEOPPRIVNAME())) {
            this.ajaxDataAccessActionMap.put("remove", this.psAjaxControlHandler.getREMOVEPSDEOPPRIVNAME());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psAjaxControlHandler.getEXPORTPSDEOPPRIVINAME())) {
            this.ajaxDataAccessActionMap.put("exportdata", this.psAjaxControlHandler.getEXPORTPSDEOPPRIVINAME());
        }
        if (this.getPSAjaxControl().getRecvAjaxActionMode() == 1 && this.getPSAppView() instanceof IPSControlXDataContainer) {
            IPSControlXDataContainer iPSControlXDataContainer = (IPSControlXDataContainer)this.getPSAppView();
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

    public String getPSDEDataSetId() {
        return this.strPSDEDataSetId;
    }

    public void setPSDEDataSetId(String strPSDEDataSetId) {
        this.strPSDEDataSetId = strPSDEDataSetId;
    }

    public String getDEDataSetId() {
        return this.getPSDEDataSetId();
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61")
    public IPSDEDataSet getPSDEDataSet() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getDEDataSetId())) {
            return null;
        }
        IPSAppDEView iPSAppDEView = (IPSAppDEView)this.getPSAppView();
        return iPSAppDEView.getPSDataEntity().getPSDEDataSet(this.getDEDataSetId());
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u5bf9\u8c61")
    public IPSDEDataExport getPSDEDataExport() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getDEDataExportId())) {
            return null;
        }
        return this.getPSDataEntity().getPSDEDataExport(this.getDEDataExportId());
    }

    @PSModelRTMeta(description="\u662f\u5426\u652f\u6301\u673a\u6784\u6570\u636e\u8303\u56f4")
    public boolean isEnableOrgDR() {
        return this.bEnableOrgDR;
    }

    @PSModelRTMeta(description="\u662f\u5426\u652f\u6301\u90e8\u95e8\u6570\u636e\u8303\u56f4")
    public boolean isEnableSecDR() {
        return this.bEnableSecDR;
    }

    public boolean isEnableSecBC() {
        return this.bEnableSecBC;
    }

    @PSModelRTMeta(description="\u673a\u6784\u6570\u636e\u8303\u56f4", codelist="ACHOrgDR")
    public long getOrgDR() {
        return this.nOrgDR;
    }

    @PSModelRTMeta(description="\u90e8\u95e8\u6570\u636e\u8303\u56f4", codelist="ACHSecDR")
    public long getSecDR() {
        return this.nSecDR;
    }

    @PSModelRTMeta(description="\u90e8\u95e8\u4e1a\u52a1\u6761\u4ef6")
    public String getSecBC() {
        return this.strSecBC;
    }

    @PSModelRTMeta(description="\u662f\u5426\u542f\u7528\u7528\u6237\u6570\u636e\u8303\u56f4")
    public boolean isEnableUserDR() {
        return this.bEnableUserDR;
    }

    @PSModelRTMeta(description="\u6570\u636e\u8bbf\u95ee\u4f7f\u7528\u64cd\u4f5c\u6807\u8bc6")
    public String getUserDRAction() {
        return this.strUserDRAction;
    }

    public String getCustomDRMode() {
        return null;
    }

    public String getCustomDRMode2() {
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

    public String getPSDEDataExportId() {
        return this.strPSDEDataExportId;
    }

    public void setPSDEDataExportId(String strPSDEDataExportId) {
        this.strPSDEDataExportId = strPSDEDataExportId;
    }

    public String getDEDataExportId() {
        return this.getPSDEDataExportId();
    }

    @PSModelRTMeta(description="\u83b7\u53d6\u6570\u636e\u8d85\u65f6\uff08\u6beb\u79d2\uff09")
    public int getFetchTimeout() {
        return this.nFetchTimeout;
    }

    public String getActiveDataPSDELogicId() {
        return this.strActiveDataPSDELogicId;
    }

    public void setActiveDataPSDELogicId(String strActiveDataPSDELogicId) {
        this.strActiveDataPSDELogicId = strActiveDataPSDELogicId;
    }

    @PSModelRTMeta(description="\u4e0a\u4e0b\u6587\u6570\u636e\u8ba1\u7b97\u903b\u8f91")
    public IPSDELogic getActiveDataPSDELogic() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getActiveDataPSDELogicId())) {
            return null;
        }
        return this.getPSDataEntity().getPSDELogic(this.getActiveDataPSDELogicId());
    }
}

