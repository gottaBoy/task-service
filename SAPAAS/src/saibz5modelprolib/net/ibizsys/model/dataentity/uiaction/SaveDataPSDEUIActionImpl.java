/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEXDataView
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.IPSControlXDataContainer
 *  net.ibizsys.model.control.toolbar.IPSDETBUIActionItem
 */
package net.ibizsys.model.dataentity.uiaction;

import net.ibizsys.model.app.view.IPSAppDEXDataView;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSControlXDataContainer;
import net.ibizsys.model.control.toolbar.IPSDETBUIActionItem;
import net.ibizsys.model.dataentity.uiaction.PSDEUIActionImpl;

public class SaveDataPSDEUIActionImpl
extends PSDEUIActionImpl {
    @Override
    public boolean isValid(Object obj) throws Exception {
        if (obj != null) {
            IPSDETBUIActionItem iPSDETBUIActionItem;
            IPSAppView iPSAppView;
            IPSControlXDataContainer iPSControlXDataContainer = this.getPSControlXDataContainer(obj);
            if (iPSControlXDataContainer != null) {
                return iPSControlXDataContainer.isEnableEditData();
            }
            if (obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEXDataView) {
                IPSAppDEXDataView iPSAppDEXDataView = (IPSAppDEXDataView)iPSAppView;
                return iPSAppDEXDataView.isEnableEditData();
            }
        }
        return super.isValid(obj);
    }
}

