/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Ajax.PSAjaxHandlerImpl;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelItem;

public class PSSysPanelFieldAjaxHandlerImpl
extends PSAjaxHandlerImpl {
    public IPSSysPanelItem getPSSysPanelItem() {
        return (IPSSysPanelItem)this.getItem();
    }

    @Override
    public String getModelType() {
        return "PSACHANDLER_PANELFIELD";
    }

    @Override
    public String getModelId() {
        return this.getPSSysPanelItem().getModelId();
    }

    @Override
    public IPSAppView getPSAppView() {
        return this.getPSSysPanelItem().getPSSysPanel().getPSAppView();
    }
}

