/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.UIAction;

import SA.SRFDA.PS.Core.App.View.IPSAppDEMultiDataView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBUIActionItem;
import SA.SRFDA.PS.Core.DataEntity.UIAction.PSDEUIActionImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelPFIgnoreMeta
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

