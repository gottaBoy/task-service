/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.UIAction;

import SA.SRFDA.PS.Core.App.View.IPSAppDEMultiDataView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBUIActionItem;
import SA.SRFDA.PS.Core.DataEntity.UIAction.PSDEUIActionImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public class ViewDataPSDEUIActionImpl
extends PSDEUIActionImpl {
    @Override
    public boolean isValid(Object obj) throws Exception {
        IPSDETBUIActionItem iPSDETBUIActionItem;
        IPSAppView iPSAppView;
        if (obj != null && obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEMultiDataView) {
            IPSAppDEMultiDataView iPSAppDEMultiDataView = (IPSAppDEMultiDataView)iPSAppView;
            return !iPSAppDEMultiDataView.isEnableEditData() && iPSAppDEMultiDataView.isEnableViewData();
        }
        return super.isValid(obj);
    }
}

