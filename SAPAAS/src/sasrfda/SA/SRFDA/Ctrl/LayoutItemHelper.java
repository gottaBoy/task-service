/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.Data.LayoutItem;
import SA.SRFDA.Ctrl.ILayoutItemHelper;
import SA.SRFDA.Ctrl.ILayoutItemPublisher;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;

public class LayoutItemHelper
extends BaseDAObjectHelper
implements ILayoutItemHelper {
    protected LayoutItem layoutItem = null;
    protected ILayoutItemPublisher iLayoutItemPublisher;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, LayoutItem layoutItem) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.layoutItem = layoutItem;
        this.setId(this.layoutItem.getLAYOUTITEMID());
        this.setName(this.layoutItem.getLAYOUTITEMNAME());
        this.iLayoutItemPublisher = (ILayoutItemPublisher)ObjectHelper.Create((String)this.layoutItem.getPUBLISHOBJECT());
        this.iLayoutItemPublisher.Init(iDAGlobalHelper, layoutItem);
        this.OnInit();
    }

    @Override
    public ILayoutItemPublisher getPublisher() throws Exception {
        return this.iLayoutItemPublisher;
    }
}

