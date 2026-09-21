/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.UIAction;

import SA.SRFDA.PS.Core.App.View.IPSAppDEGridView;
import SA.SRFDA.PS.Core.App.View.IPSAppDETreeGridView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBUIActionItem;
import SA.SRFDA.PS.Core.DataEntity.UIAction.PSDEUIActionImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public class NewRowPSDEUIActionImpl
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
            if (iPSAppView instanceof IPSAppDEGridView) {
                IPSAppDEGridView iPSAppDEXDataView = (IPSAppDEGridView)iPSAppView;
                return iPSAppDEXDataView.isEnableRowEdit();
            }
            if (iPSAppView instanceof IPSAppDETreeGridView) {
                IPSAppDETreeGridView iPSAppDEXDataView = (IPSAppDETreeGridView)iPSAppView;
                return iPSAppDEXDataView.isEnableRowEdit();
            }
        }
        return super.isValid(obj);
    }
}

