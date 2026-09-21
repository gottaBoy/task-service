/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.TreeNodeRS
 *  SA.SRFDA.Ctrl.Data.TreeView
 *  SA.SRFDA.Web.ISRFDATreeNodeRSSelector
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.ND.Ctrl.Tree;

import SA.SRFDA.Ctrl.Data.TreeNodeRS;
import SA.SRFDA.Ctrl.Data.TreeView;
import SA.SRFDA.ND.Ctrl.INDConfigTypeHelper;
import SA.SRFDA.ND.Ctrl.INDModelStorage;
import SA.SRFDA.ND.Ctrl.NDModelStorageFactory;
import SA.SRFDA.Web.ISRFDATreeNodeRSSelector;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.Utility.StringHelper;

public class NDDeptDeskTreeNodeRSSelector
implements ISRFDATreeNodeRSSelector {
    private TreeNodeRS treeNodeRS = null;

    public void Init(TreeNodeRS treeNodeRS) {
        this.treeNodeRS = treeNodeRS;
    }

    public boolean Test(ISRFDAWebContext iSRFDAWebContext, TreeView treeView) throws Exception {
        INDModelStorage iNDModelStorage = NDModelStorageFactory.Create(iSRFDAWebContext.getGlobalHelper());
        INDConfigTypeHelper iNDConfigTypeHelper = iNDModelStorage.FindNDConfigType("NDGLOBAL");
        String strValue = iNDConfigTypeHelper.FindNDConfigValue("NDDEPTDISK", "TRUE");
        return StringHelper.Compare((String)strValue, (String)"TRUE", (boolean)true) == 0;
    }
}

