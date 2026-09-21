/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.LayoutItem;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Ctrl.ILayoutItemPublisher;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface ILayoutItemHelper
extends IDAObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, LayoutItem var2) throws Exception;

    public ILayoutItemPublisher getPublisher() throws Exception;
}

