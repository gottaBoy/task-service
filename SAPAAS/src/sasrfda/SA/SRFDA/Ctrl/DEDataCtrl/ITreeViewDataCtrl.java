/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.Data.TreeNode;
import SA.SRFDA.Ctrl.Data.TreeNodeRS;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public interface ITreeViewDataCtrl
extends IDEDataCtrl {
    public CallResult ListTreeNodes(String var1, Vector<TreeNode> var2);

    public CallResult ListTreeNodeRSs(String var1, Vector<TreeNodeRS> var2);
}

