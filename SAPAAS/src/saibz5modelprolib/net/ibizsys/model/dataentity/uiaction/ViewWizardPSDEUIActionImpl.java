/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.toolbar.IPSDETBUIActionItem
 */
package net.ibizsys.model.dataentity.uiaction;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.toolbar.IPSDETBUIActionItem;
import net.ibizsys.model.dataentity.uiaction.PSDEUIActionImpl;

public class ViewWizardPSDEUIActionImpl
extends PSDEUIActionImpl {
    @Override
    protected void onInit() throws Exception {
        this.setValid(false);
        super.onInit();
    }

    @Override
    public boolean isValid(Object obj) throws Exception {
        if (obj != null && obj instanceof IPSDETBUIActionItem) {
            IPSDETBUIActionItem iPSDETBUIActionItem = (IPSDETBUIActionItem)obj;
            IPSAppView iPSAppView = iPSDETBUIActionItem.getPSAppView();
        }
        return super.isValid(obj);
    }

    @Override
    public boolean isEnableToggleMode() {
        return false;
    }
}

