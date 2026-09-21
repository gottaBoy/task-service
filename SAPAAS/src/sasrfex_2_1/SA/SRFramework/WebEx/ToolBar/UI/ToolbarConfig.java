/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.ToolBar.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarItemsConfig;
import SA.SRFramework.WebEx.UI.BaseControlConfig;
import org.w3c.dom.Node;

public class ToolbarConfig
extends BaseControlConfig {
    public static final String TAG_TOOLBAR = "SRFEXTOOLBAR";
    public static final String TAG_CONTAINER = "CONTAINER";
    public static final String TAG_TOOLBARID = "%TOOLBARID%";
    protected ToolbarItemsConfig toolbarItemsConfig = new ToolbarItemsConfig();
    protected String strContainer = "";

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)ToolbarItemsConfig.TAG_TOOLBARITEMS, (boolean)true) == 0) {
            this.toolbarItemsConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_CONTAINER, (boolean)true) == 0) {
            this.setContainer(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public ToolbarItemsConfig getToolbarItemsConfig() {
        return this.toolbarItemsConfig;
    }

    public String getContainer() {
        return this.strContainer;
    }

    public void setContainer(String strContainer) {
        this.strContainer = strContainer;
    }
}

