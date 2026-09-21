/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.Control.Ajax.PSAjaxControlHandlerActionImpl;
import SA.SRFDA.PS.Core.Control.Ajax.PSSDAjaxControlHandlerImpl;
import SA.SRFDA.PS.Core.Control.Form.IPSDEEditFormHandler;
import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.IPSControlXDataContainer;
import SA.SRFDA.PS.Data.PSACHandlerAction;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;

public class PSDEEditFormHandlerImpl
extends PSSDAjaxControlHandlerImpl
implements IPSDEEditFormHandler {
    private static final Map<String, String> _WFACTIONS = new LinkedHashMap<String, String>();
    private IPSDEForm iPSDEForm = null;

    static {
        _WFACTIONS.put("wfstart", "WFSTART");
        _WFACTIONS.put("wfsubmit", "WFSUBMIT");
    }

    @Override
    protected void onInit() throws Exception {
        if (!(this.getPSAjaxControl() instanceof IPSDEForm)) {
            String strInfo = StringHelper.format((String)"\u89c6\u56fe[%1$s]\u90e8\u4ef6[%2$s]\u5904\u7406\u5bf9\u8c61\u4e0d\u6b63\u786e", (Object)this.getPSAppView().getName(), (Object)this.getPSAjaxControl().getName());
            throw new Exception(strInfo);
        }
        this.iPSDEForm = (IPSDEForm)this.getPSAjaxControl();
        boolean bDefaultFormFunc = true;
        if (StringHelper.compare((String)this.iPSDEForm.getFormFuncMode(), (String)"WFACTION", (boolean)true) == 0) {
            bDefaultFormFunc = false;
        }
        if (this.getTempMode() == 1) {
            this.ajaxDEActionNameMap.put("loaddraft", "GETDRAFTTEMPMAJOR");
            this.ajaxDEActionNameMap.put("loaddraftfrom", "GETDRAFTTEMPMAJORFROM");
        } else if (this.getTempMode() == 2) {
            this.ajaxDEActionNameMap.put("loaddraft", "GETDRAFTTEMP");
            this.ajaxDEActionNameMap.put("loaddraftfrom", "GETDRAFTTEMPFROM");
        } else {
            this.ajaxDEActionNameMap.put("loaddraft", "GETDRAFT");
            this.ajaxDEActionNameMap.put("loaddraftfrom", "GETDRAFTFROM");
        }
        super.onInit();
        if (!StringHelper.isNullOrEmpty((String)this.psAjaxControlHandler.getGETDRAFTPSDEACTIONNAME())) {
            this.ajaxDEActionNameMap.put("loaddraft", this.psAjaxControlHandler.getGETDRAFTPSDEACTIONNAME());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psAjaxControlHandler.getCOPYPSDEACTIONNAME())) {
            this.ajaxDEActionNameMap.put("loaddraftfrom", this.psAjaxControlHandler.getCOPYPSDEACTIONNAME());
        }
        this.ajaxDataAccessActionMap.put("loaddraft", "CREATE");
        this.ajaxDataAccessActionMap.put("loaddraftfrom", "CREATE");
        if (this.getPSAjaxControl().getRecvAjaxActionMode() == 1 && this.getPSAppView() instanceof IPSControlXDataContainer) {
            IPSControlXDataContainer iPSControlXDataContainer = (IPSControlXDataContainer)((Object)this.getPSAppView());
            if (!iPSControlXDataContainer.isEnableNewData()) {
                this.ajaxDataAccessActionMap.put("loaddraftfrom", "DENY");
            }
            if (!iPSControlXDataContainer.isEnableCopy()) {
                this.ajaxDataAccessActionMap.put("loaddraftfrom", "DENY");
            }
        }
    }

    @Override
    protected void onPreparePSAjaxHandlerActions() throws Exception {
        super.onPreparePSAjaxHandlerActions();
        if (this.iPSDEForm == null) {
            return;
        }
        if (StringHelper.compare((String)this.iPSDEForm.getFormFuncMode(), (String)"WIZARDFORM", (boolean)true) == 0) {
            return;
        }
        if (this.getPSAppDataEntity() != null && this.getPSAppDataEntity().isEnableWFActions()) {
            for (Map.Entry<String, String> entry : _WFACTIONS.entrySet()) {
                IPSAppDEMethod iPSAppDEMethod = this.getPSAppDataEntity().getPSAppDEMethod("WFACTION", entry.getValue(), true);
                if (iPSAppDEMethod == null) continue;
                PSACHandlerAction psACHandlerAction = new PSACHandlerAction();
                psACHandlerAction.setPSACHANDLERACTIONID(StringHelper.format((String)"%1$s_%2$s", (Object)this.getId(), (Object)entry.getKey()));
                psACHandlerAction.setPSACHANDLERACTIONNAME(entry.getKey());
                psACHandlerAction.setACTIONTYPE("WFACTION");
                psACHandlerAction.setVALIDFLAG(true);
                psACHandlerAction.setPSDEACTIONID(entry.getValue());
                PSAjaxControlHandlerActionImpl psAjaxControlHandlerActionImpl = new PSAjaxControlHandlerActionImpl();
                psAjaxControlHandlerActionImpl.init(this.getDAGlobalHelper(), this, psACHandlerAction);
                this.registerPSAjaxHandlerAction(psAjaxControlHandlerActionImpl);
            }
        }
    }
}

