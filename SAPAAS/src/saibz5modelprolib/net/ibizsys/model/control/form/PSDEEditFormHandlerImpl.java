/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlXDataContainer
 *  net.ibizsys.model.control.form.IPSDEEditFormHandler
 *  net.ibizsys.model.control.form.IPSDEForm
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.control.IPSControlXDataContainer;
import net.ibizsys.model.control.PSSDAjaxControlHandlerImpl;
import net.ibizsys.model.control.form.IPSDEEditFormHandler;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.paas.util.StringHelper;

public class PSDEEditFormHandlerImpl
extends PSSDAjaxControlHandlerImpl
implements IPSDEEditFormHandler {
    private IPSDEForm iPSDEForm = null;

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
            IPSControlXDataContainer iPSControlXDataContainer = (IPSControlXDataContainer)this.getPSAppView();
            if (!iPSControlXDataContainer.isEnableNewData()) {
                this.ajaxDataAccessActionMap.put("loaddraftfrom", "DENY");
            }
            if (!iPSControlXDataContainer.isEnableCopy()) {
                this.ajaxDataAccessActionMap.put("loaddraftfrom", "DENY");
            }
        }
    }
}

