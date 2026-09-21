/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.WebEx.UI.TreeNodeConfig
 */
package SA.SRFDA.Web;

import SA.SRFDA.Ctrl.Data.TreeView;
import SA.SRFDA.Web.ISRFDAPage;
import SA.SRFDA.Web.ISRFDATreeActionHelper;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;
import java.util.HashMap;

public interface ISRFDATreeActionHelperEx
extends ISRFDATreeActionHelper {
    public TreeView getTreeView();

    public void setTreeView(TreeView var1);

    public TreeNodeConfig getTreeNodeConfig(ISRFDAPage var1, String var2, HashMap<String, Integer> var3, boolean var4) throws Exception;
}

