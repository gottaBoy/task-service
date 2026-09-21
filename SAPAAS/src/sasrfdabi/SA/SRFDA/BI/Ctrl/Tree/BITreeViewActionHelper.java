/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.TreeView
 *  SA.SRFDA.Ctrl.Tree.BaseDATreeActionHelperEx
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.BI.Ctrl.Tree;

import SA.SRFDA.BI.Ctrl.BITreeModelStorage;
import SA.SRFDA.Ctrl.Data.TreeView;
import SA.SRFDA.Ctrl.Tree.BaseDATreeActionHelperEx;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;

public class BITreeViewActionHelper
extends BaseDATreeActionHelperEx {
    protected String strBITreeViewType = "";

    protected boolean OnBeforeProcess() {
        if (!super.OnBeforeProcess()) {
            return false;
        }
        this.strBITreeViewType = this.getWebContext().GetParamValue("BITREEVIEW");
        return true;
    }

    public TreeView getTreeView() {
        BITreeModelStorage biTreeModelStorage = BITreeModelStorage.Current((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
        if (StringHelper.Compare((String)this.strBITreeViewType, (String)"BICUBEDIMENSION", (boolean)true) == 0) {
            return biTreeModelStorage.FindHierarchyTreeView(this.getWebContext().GetParamValue("BICUBEDIMENSIONID"), this.getWebContext().GetParamValue("BIHIERARCHYID"));
        }
        this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6811\u89c6\u56fe\u7c7b\u578b[%1$s]", (Object)this.strBITreeViewType));
        return null;
    }
}

