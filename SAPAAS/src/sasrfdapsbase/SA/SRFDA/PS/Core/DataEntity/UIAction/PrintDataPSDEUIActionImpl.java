/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.UIAction;

import SA.SRFDA.PS.Core.App.View.IPSAppDEXDataView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControlXDataContainer;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBUIActionItem;
import SA.SRFDA.PS.Core.DataEntity.UIAction.PSDEUIActionImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public class PrintDataPSDEUIActionImpl
extends PSDEUIActionImpl {
    @Override
    protected void onInit() throws Exception {
        this.setValid(false);
        super.onInit();
    }

    @Override
    public boolean isValid(Object obj) throws Exception {
        if (obj != null) {
            IPSDETBUIActionItem iPSDETBUIActionItem;
            IPSAppView iPSAppView;
            IPSControlXDataContainer iPSControlXDataContainer = this.getPSControlXDataContainer(obj);
            if (iPSControlXDataContainer != null) {
                return iPSControlXDataContainer.isEnablePrint();
            }
            if (obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEXDataView) {
                IPSAppDEXDataView iPSAppDEXDataView = (IPSAppDEXDataView)iPSAppView;
                return iPSAppDEXDataView.isEnablePrint();
            }
        }
        return super.isValid(obj);
    }
}

