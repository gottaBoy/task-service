/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseControlConfig;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;
import org.w3c.dom.Node;

public class TreeViewConfig
extends BaseControlConfig {
    public static final String TAG_TREEPANEL = "SRFEXTREEPANEL";
    public static final String TAG_JSNAME = "JSNAME";
    public static final String TAG_DATAURL = "DATAURL";
    public static final String TAG_LOADDEFAULT = "LOADDEFAULT";
    public static final String TAG_SELECTEDVALUE = "SELECTEDVALUE";
    public static final String TAG_BACKENDCONFIG = "BACKENDCONFIG";
    public static final String TAG_BACKENDCTRL = "BACKENDCTRL";
    protected String strDataURL = "";
    protected boolean bLoadDefault = true;
    protected String strSelectedValue = "";
    protected String strJSName = "";
    protected TreeNodeConfig rootNodeConfig = new TreeNodeConfig();
    protected String strBackEndCtrl = "";
    protected String strBackEndConfig = "";
    protected boolean bAutoRender = true;

    public TreeViewConfig() {
        this.rootNodeConfig.setAsyncMode(true);
        this.rootNodeConfig.setID("root");
        this.rootNodeConfig.setLeaf(false);
        this.rootNodeConfig.setText("\u6839\u8282\u70b9");
    }

    public TreeNodeConfig getRootNodeConfig() {
        return this.rootNodeConfig;
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_JSNAME, (boolean)true) == 0) {
            this.strJSName = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DATAURL, (boolean)true) == 0) {
            this.strDataURL = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SELECTEDVALUE, (boolean)true) == 0) {
            this.strSelectedValue = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_LOADDEFAULT, (boolean)true) == 0) {
            this.bLoadDefault = TreeViewConfig.GetValue((String)strValue, (boolean)this.bLoadDefault);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_BACKENDCTRL, (boolean)true) == 0) {
            this.strBackEndCtrl = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_BACKENDCONFIG, (boolean)true) == 0) {
            this.strBackEndConfig = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXTREENODE", (boolean)true) == 0) {
            this.rootNodeConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public void setJSName(String strJSName) {
        this.strJSName = strJSName;
    }

    public String getJSName() {
        return this.strJSName;
    }

    public void setSelectedValue(String strSelectedValue) {
        this.strSelectedValue = strSelectedValue;
    }

    public String getSelectedValue() {
        return this.strSelectedValue;
    }

    public void setDataURL(String strDataURL) {
        this.strDataURL = strDataURL;
    }

    public String getDataURL() {
        return this.strDataURL;
    }

    public void setLoadDefault(boolean bLoadDefault) {
        this.bLoadDefault = bLoadDefault;
    }

    public boolean getLoadDefault() {
        return this.bLoadDefault;
    }

    public String getBackEndCtrl() {
        return this.strBackEndCtrl;
    }

    public void setBackEndCtrl(String strBackEndCtrl) {
        this.strBackEndCtrl = strBackEndCtrl;
    }

    public String getBackEndConfig() {
        return this.strBackEndConfig;
    }

    public void setBackEndConfig(String strBackEndConfig) {
        this.strBackEndConfig = strBackEndConfig;
    }
}

