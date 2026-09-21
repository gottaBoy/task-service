/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Ajax.PSAjaxHandlerImpl;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem;

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
    public String getModelId() {
        return this.getPSDEGridEditItem().getModelId();
    }

    @Override
    public IPSAppView getPSAppView() {
        return this.getPSDEGridEditItem().getPSDEGrid().getPSAppView();
    }
}

