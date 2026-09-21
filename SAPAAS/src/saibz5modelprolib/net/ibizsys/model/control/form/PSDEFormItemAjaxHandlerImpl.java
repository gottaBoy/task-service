/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.form.IPSDEFormItem
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.ajax.PSAjaxHandlerImpl;
import net.ibizsys.model.control.form.IPSDEFormItem;

public class PSDEFormItemAjaxHandlerImpl
extends PSAjaxHandlerImpl {
    public IPSDEFormItem getPSDEFormItem() {
        return (IPSDEFormItem)this.getItem();
    }

    @Override
    public IPSAppView getPSAppView() {
        return this.getPSDEFormItem().getPSDEForm().getPSAppView();
    }
}

