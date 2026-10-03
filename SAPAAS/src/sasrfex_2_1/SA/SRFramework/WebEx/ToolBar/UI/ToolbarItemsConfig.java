/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.ToolBar.UI;

import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ToolBar.UI.BaseToolbarItemConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarSeperatorConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarSpaceConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarSplitButtonConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarTextItemConfig;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class ToolbarItemsConfig
extends XMLCollectionExConfig<BaseToolbarItemConfig> {
    public static String TAG_TOOLBARITEMS = "SRFEXTOOLBARITEMS";
    protected static TreeMap<String, String> childNodeMap = new TreeMap();

    static {
        childNodeMap.put(ToolbarSeperatorConfig.TAG_TOOLBARSEPARATOR, "SA.SRFramework.WebEx.ToolBar.UI.ToolbarSeperatorConfig");
        childNodeMap.put(ToolbarTextItemConfig.TAG_TOOLBARTEXTITEM, "SA.SRFramework.WebEx.ToolBar.UI.ToolbarTextItemConfig");
        childNodeMap.put(ToolbarSpaceConfig.TAG_TOOLBARSPACE, "SA.SRFramework.WebEx.ToolBar.UI.ToolbarSpaceConfig");
        childNodeMap.put(ToolbarButtonConfig.TAG_TOOLBARBUTTON, "SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig");
        childNodeMap.put(ToolbarSplitButtonConfig.TAG_TOOLBARSPLITBUTTON, "SA.SRFramework.WebEx.ToolBar.UI.ToolbarSplitButtonConfig");
    }

    public BaseToolbarItemConfig FindToolbarItemConfig(String strTBBId) {
        for (BaseToolbarItemConfig toolbarItemConfig : this.arr) {
            if (StringHelper.Compare((String)toolbarItemConfig.getID(), (String)strTBBId, (boolean)true) != 0) continue;
            return toolbarItemConfig;
        }
        return null;
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = ToolbarItemsConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((BaseToolbarItemConfig)childNode)) {
                this.add((BaseToolbarItemConfig)childNode);
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}
