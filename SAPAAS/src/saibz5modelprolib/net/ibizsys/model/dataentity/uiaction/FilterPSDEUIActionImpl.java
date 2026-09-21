/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEMultiDataView
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.toolbar.IPSDETBUIActionItem
 */
package net.ibizsys.model.dataentity.uiaction;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.view.IPSAppDEMultiDataView;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.toolbar.IPSDETBUIActionItem;
import net.ibizsys.model.dataentity.uiaction.PSDEUIActionImpl;

public class FilterPSDEUIActionImpl
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
        if (obj != null && obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEMultiDataView) {
            IPSAppDEMultiDataView iPSAppDEMultiDataView = (IPSAppDEMultiDataView)iPSAppView;
            return iPSAppDEMultiDataView.isEnableFilter();
        }
        return super.isValid(obj);
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u6309\u94ae\u70b9\u51fb\u5207\u6362\u6a21\u5f0f")
    public boolean isEnableToggleMode() {
        return true;
    }
}

