/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEGridView
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.toolbar.IPSDETBUIActionItem
 */
package net.ibizsys.model.dataentity.uiaction;

import net.ibizsys.model.app.view.IPSAppDEGridView;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.toolbar.IPSDETBUIActionItem;
import net.ibizsys.model.dataentity.uiaction.PSDEUIActionImpl;

public class NewRowPSDEUIActionImpl
extends PSDEUIActionImpl {
    @Override
    protected void onInit() throws Exception {
        this.setValid(false);
        super.onInit();
    }

    @Override
    public boolean isValid(Object obj) throws Exception {
        IPSDETBUIActionItem iPSDETBUIActionItem;
        IPSAppView iPSAppView;
        if (obj != null && obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEGridView) {
            IPSAppDEGridView iPSAppDEXDataView = (IPSAppDEGridView)iPSAppView;
            return iPSAppDEXDataView.isEnableRowEdit();
        }
        return super.isValid(obj);
    }
}

