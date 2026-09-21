/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlXDataContainer
 *  net.ibizsys.model.control.ajax.IPSSDAjaxControlHandler
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control;

import net.ibizsys.model.control.IPSControlXDataContainer;
import net.ibizsys.model.control.PSAjaxControlHandlerImpl;
import net.ibizsys.model.control.ajax.IPSSDAjaxControlHandler;
import net.ibizsys.paas.util.StringHelper;

public class PSSDAjaxControlHandlerImpl
extends PSAjaxControlHandlerImpl
implements IPSSDAjaxControlHandler {
    private int nGetTimeout = -1;
    private int nCreateTimeout = -1;
    private int nUpdateTimeout = -1;
    private int nRemoveTimeout = -1;
    public static final String[] ACTIONS = new String[]{"load", "create", "update", "remove", "clone"};

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
        this.ajaxDataAccessActionMap.put("wfstart", "WFSTART");
        this.ajaxDataAccessActionMap.put("clone", "CREATE");
        super.onInit();
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
        if (!this.psAjaxControlHandler.isGETTIMEOUTNull() && this.psAjaxControlHandler.getGETTIMEOUT() > 0) {
            this.nGetTimeout = this.psAjaxControlHandler.getGETTIMEOUT();
            this.timeoutAjaxActionMap.put("load", this.nGetTimeout);
        }
        if (!this.psAjaxControlHandler.isCREATETIMEOUTNull() && this.psAjaxControlHandler.getCREATETIMEOUT() > 0) {
            this.nCreateTimeout = this.psAjaxControlHandler.getCREATETIMEOUT();
            this.timeoutAjaxActionMap.put("create", this.nCreateTimeout);
        }
        if (!this.psAjaxControlHandler.isUPDATETIMEOUTNull() && this.psAjaxControlHandler.getUPDATETIMEOUT() > 0) {
            this.nUpdateTimeout = this.psAjaxControlHandler.getUPDATETIMEOUT();
            this.timeoutAjaxActionMap.put("update", this.nUpdateTimeout);
        }
        if (!this.psAjaxControlHandler.isREMOVETIMEOUTNull() && this.psAjaxControlHandler.getREMOVETIMEOUT() > 0) {
            this.nRemoveTimeout = this.psAjaxControlHandler.getREMOVETIMEOUT();
            this.timeoutAjaxActionMap.put("remove", this.nRemoveTimeout);
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

    public int getReadTimeout() {
        return this.nGetTimeout;
    }

    public int getCreateTimeout() {
        return this.nCreateTimeout;
    }

    public int getUpdateTimeout() {
        return this.nUpdateTimeout;
    }

    public int getRemoveTimeout() {
        return this.nRemoveTimeout;
    }
}

