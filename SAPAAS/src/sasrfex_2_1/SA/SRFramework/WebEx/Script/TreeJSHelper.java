/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Script;

import SA.SRFramework.Utility.StringHelper;

public class TreeJSHelper {
    public static String getOnSelectionchangeEventScript(String strTreeId, String strEventCode) {
        return StringHelper.Format((String)"$P.tree['%1$s'].getSelectionModel().on('selectionchange',function(_1,_2){%2$s});", (Object)strTreeId, (Object)strEventCode);
    }

    public static String getOnContextMenuEventScript(String strTreeId, String strEventCode) {
        return StringHelper.Format((String)"$P.tree['%1$s'].on('contextmenu',function(_1,_2){%2$s});", (Object)strTreeId, (Object)strEventCode);
    }

    public static String getTreePanel(String strTreeId) {
        return StringHelper.Format((String)"$P.tree['%1$s']", (Object)strTreeId);
    }

    public static String getTreePanelLoader(String strTreeId) {
        return StringHelper.Format((String)"$P.tree['%1$s'].getLoader()", (Object)strTreeId);
    }

    public static String getSetTreePanelLoaderParam(String strTreeId, String strParam, String strValue) {
        return StringHelper.Format((String)"$P.tree['%1$s'].getLoader().sparams['%2$s'] = %3$s;", (Object)strTreeId, (Object)strParam.toLowerCase(), (Object)strValue);
    }

    public static String getSetTreePanelLoaderDParam(String strTreeId, String strParam, String strValue) {
        return StringHelper.Format((String)"$P.tree['%1$s'].getLoader().dparams['%2$s'] = %3$s;", (Object)strTreeId, (Object)strParam.toLowerCase(), (Object)strValue);
    }

    public static String getSetTreePanelLoaderDParam(String strTreeId, String strValue) {
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            strValue = "{}";
        }
        return StringHelper.Format((String)"$P.tree['%1$s'].getLoader().dparams=%2$s;", (Object)strTreeId, (Object)strValue);
    }

    public static String getTreeReload(String strTreeId) {
        return StringHelper.Format((String)"$P.tree['%1$s'].getRootNode().reload();", (Object)strTreeId);
    }

    public static String getTreeReloadEx(String strTreeId) {
        return StringHelper.Format((String)"var node=$P.tree['%1$s'].getSelectionModel().getSelectedNode();if(node==null){$P.tree['%1$s'].getRootNode().reload();}else{node.reload();}", (Object)strTreeId);
    }

    public static String getTreeReset(String strTreeId) {
        return StringHelper.Format((String)"$P.tree['%1$s'].setRootNode($P.tree['%1$s']._createRootNode2());", (Object)strTreeId);
    }

    public static String getTreeReInit(String strTreeId) {
        String strScript = StringHelper.Format((String)"var varRoot=$P.tree['%1$s']._createRootNode();$P.tree['%1$s'].setRootNode(varRoot);varRoot.expand(false,false);", (Object)strTreeId);
        return strScript;
    }

    public static String getTreeRender(String strTreeId) {
        String strScript = StringHelper.Format((String)"$P.tree['%1$s']._render();", (Object)strTreeId);
        return strScript;
    }

    public static String geTreeCreateChild(String strTreeId, String strParam) {
        return StringHelper.Format((String)"$P.tree['%1$s']._createchild(%2$s);", (Object)strTreeId, (Object)strParam);
    }
}

