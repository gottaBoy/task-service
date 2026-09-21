/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEDataCtrl.ITreeViewDataCtrl;
import SA.SRFDA.Ctrl.Data.TreeNode;
import SA.SRFDA.Ctrl.Data.TreeNodeRS;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public class TreeViewDataCtrl
extends BaseDEDataCtrl
implements ITreeViewDataCtrl {
    @Override
    public CallResult ListTreeNodeRSs(String strTreeNodeId, Vector<TreeNodeRS> treeNodes) {
        String strSQL = "select * from T_SRFTREENODERS WHERE PTREENODEID = ? ORDER BY ORDERFLAG";
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)strTreeNodeId);
        return BaseDEDataCtrl.SelectMultiEx(this.getGlobalHelper(), this.GetDEHelper().GetDBStorage(), strSQL, callParamList.GetList(), treeNodes, TreeNodeRS.class.getName());
    }

    @Override
    public CallResult ListTreeNodes(String strTreeViewId, Vector<TreeNode> treeNodes) {
        String strSQL = "select * from T_SRFTREENODE WHERE TREEVIEWID = ? ";
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)strTreeViewId);
        return BaseDEDataCtrl.SelectMultiEx(this.getGlobalHelper(), this.GetDEHelper().GetDBStorage(), strSQL, callParamList.GetList(), treeNodes, TreeNode.class.getName());
    }
}

