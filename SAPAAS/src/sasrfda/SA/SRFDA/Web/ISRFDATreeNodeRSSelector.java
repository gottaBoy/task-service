/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Web;

import SA.SRFDA.Ctrl.Data.TreeNodeRS;
import SA.SRFDA.Ctrl.Data.TreeView;
import SA.SRFDA.Web.ISRFDAWebContext;

public interface ISRFDATreeNodeRSSelector {
    public void Init(TreeNodeRS var1);

    public boolean Test(ISRFDAWebContext var1, TreeView var2) throws Exception;
}

