/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEView
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.toolbar.IPSDETBUIActionItem
 */
package net.ibizsys.model.dataentity.uiaction;

import net.ibizsys.model.app.view.IPSAppDEView;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.toolbar.IPSDETBUIActionItem;
import net.ibizsys.model.dataentity.uiaction.PSDEUIActionImpl;

public class WFPSDEUIActionImpl
extends PSDEUIActionImpl {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (this.getPSDataEntity() != null && !this.getPSDataEntity().hasPSDEWF()) {
            this.setValid(false);
        }
    }

    @Override
    public boolean isValid(Object obj) throws Exception {
        IPSDETBUIActionItem iPSDETBUIActionItem;
        IPSAppView iPSAppView;
        if (obj != null && obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEView) {
            return ((IPSAppDEView)iPSAppView).isEnableWF();
        }
        return super.isValid(obj);
    }
}

