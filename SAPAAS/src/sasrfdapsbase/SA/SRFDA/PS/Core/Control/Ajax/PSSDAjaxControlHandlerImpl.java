/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Ajax;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEWFActionView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEWFView;
import SA.SRFDA.PS.Core.Control.Ajax.IPSSDAjaxControlHandler;
import SA.SRFDA.PS.Core.Control.Ajax.PSAjaxControlHandlerActionImpl;
import SA.SRFDA.PS.Core.Control.Ajax.PSAjaxControlHandlerImpl;
import SA.SRFDA.PS.Core.Control.IPSControlXDataContainer;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSACHandlerAction;
import SA.SRFramework.Utility.StringHelper;

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
    @PSModelRTMeta(description="\u8bfb\u53d6\u8d85\u65f6", dump=false)
    public int getReadTimeout() {
        return this.nGetTimeout;
    }

    @Override
    @PSModelRTMeta(description="\u521b\u5efa\u8d85\u65f6", dump=false)
    public int getCreateTimeout() {
        return this.nCreateTimeout;
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u8d85\u65f6", dump=false)
    public int getUpdateTimeout() {
        return this.nUpdateTimeout;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u8d85\u65f6", dump=false)
    public int getRemoveTimeout() {
        return this.nRemoveTimeout;
    }

    @Override
    protected void onPreparePSAjaxHandlerActions() throws Exception {
        super.onPreparePSAjaxHandlerActions();
        if (this.getPSAppView() instanceof IPSAppDEView && this.getPSAppView().getPSPFStyle().getPFEngineVer() >= 20) {
            this.onPreparePSAjaxHandlerWFActions();
        }
    }

    protected void onPreparePSAjaxHandlerWFActions() throws Exception {
        PSAjaxControlHandlerActionImpl psAjaxControlHandlerActionImpl;
        PSACHandlerAction psACHandlerAction;
        String strAction;
        IPSAppDEView iPSAppDEView = (IPSAppDEView)this.getPSAppView();
        if (!iPSAppDEView.isEnableWF() || !(iPSAppDEView instanceof IPSAppDEWFView)) {
            return;
        }
        IPSAppDEWFView iPSAppDEWFView = (IPSAppDEWFView)iPSAppDEView;
        if (iPSAppDEWFView.getPSDEWF() == null) {
            return;
        }
        String strWFStepValue = "";
        if (iPSAppDEWFView instanceof IPSAppDEWFActionView) {
            strWFStepValue = ((IPSAppDEWFActionView)iPSAppDEWFView).getWFStepValue();
        }
        if (StringHelper.IsNullOrEmpty((String)strWFStepValue) && iPSAppDEWFView.getPSDEWF().isEnableUserStart()) {
            strAction = "WFSTART";
            psACHandlerAction = new PSACHandlerAction();
            psACHandlerAction.setPSACHANDLERACTIONID(StringHelper.Format((String)"%1$s_%2$s", (Object)this.getId(), (Object)strAction));
            psACHandlerAction.setPSACHANDLERACTIONNAME(strAction);
            psACHandlerAction.setACTIONTYPE("WFACTION");
            psAjaxControlHandlerActionImpl = new PSAjaxControlHandlerActionImpl();
            psAjaxControlHandlerActionImpl.init(this.getDAGlobalHelper(), this, psACHandlerAction);
            this.registerPSAjaxHandlerAction(psAjaxControlHandlerActionImpl);
        }
        if (!StringHelper.IsNullOrEmpty((String)strWFStepValue)) {
            strAction = "WFSUBMIT";
            psACHandlerAction = new PSACHandlerAction();
            psACHandlerAction.setPSACHANDLERACTIONID(StringHelper.Format((String)"%1$s_%2$s", (Object)this.getId(), (Object)strAction));
            psACHandlerAction.setPSACHANDLERACTIONNAME(strAction);
            psACHandlerAction.setPSDEACTIONID(StringHelper.Format((String)"%1$s_%2$s", (Object)strAction, (Object)strWFStepValue));
            psACHandlerAction.setACTIONTYPE("WFACTION");
            psAjaxControlHandlerActionImpl = new PSAjaxControlHandlerActionImpl();
            psAjaxControlHandlerActionImpl.init(this.getDAGlobalHelper(), this, psACHandlerAction);
            this.registerPSAjaxHandlerAction(psAjaxControlHandlerActionImpl);
        } else {
            strAction = "WFSUBMIT";
            psACHandlerAction = new PSACHandlerAction();
            psACHandlerAction.setPSACHANDLERACTIONID(StringHelper.Format((String)"%1$s_%2$s", (Object)this.getId(), (Object)strAction));
            psACHandlerAction.setPSACHANDLERACTIONNAME(strAction);
            psACHandlerAction.setPSDEACTIONID(StringHelper.Format((String)"%1$s", (Object)strAction));
            psACHandlerAction.setACTIONTYPE("WFACTION");
            psAjaxControlHandlerActionImpl = new PSAjaxControlHandlerActionImpl();
            psAjaxControlHandlerActionImpl.init(this.getDAGlobalHelper(), this, psACHandlerAction);
            this.registerPSAjaxHandlerAction(psAjaxControlHandlerActionImpl);
        }
    }
}

