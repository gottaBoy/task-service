/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.grid.IPSDEGridEditItem
 */
package net.ibizsys.model.control.grid;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.ajax.PSAjaxHandlerImpl;
import net.ibizsys.model.control.grid.IPSDEGridEditItem;

public class PSDEGridEditItemAjaxHandlerImpl
extends PSAjaxHandlerImpl {
    public IPSDEGridEditItem getPSDEGridEditItem() {
        return (IPSDEGridEditItem)this.getItem();
    }

    @Override
    public String getModelType() {
        return "PSACHANDLER_GRIDEDITITEM";
    }

    @Override
    public IPSAppView getPSAppView() {
        return this.getPSDEGridEditItem().getPSDEGrid().getPSAppView();
    }
}

