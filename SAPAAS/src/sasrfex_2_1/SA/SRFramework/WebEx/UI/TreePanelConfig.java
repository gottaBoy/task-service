/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarConfig;
import SA.SRFramework.WebEx.TreeView.UI.TreeNodeTemplatesConfig;
import SA.SRFramework.WebEx.UI.BaseControlConfig;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;
import org.w3c.dom.Node;

public class TreePanelConfig
extends BaseControlConfig {
    public static final String TAG_TREEPANEL = "SRFEXTREEPANEL";
    public static final String TAG_TOPTOOLBAR = "SRFEXTOPTOOLBAR";
    public static final String TAG_BOTTOMTOOLBAR = "SRFEXBOTTOMTOOLBAR";
    public static final String TAG_DATAURL = "DATAURL";
    public static final String TAG_LOADDEFAULT = "LOADDEFAULT";
    public static final String TAG_SELECTEDVALUE = "SELECTEDVALUE";
    public static final String TAG_BACKENDCONFIG = "BACKENDCONFIG";
    public static final String TAG_BACKENDCTRL = "BACKENDCTRL";
    public static final String TAG_HIDEHEADER = "HIDEHEADER";
    public static final String TAG_CTRLOBJECT = "CTRLOBJECT";
    public static final String TAG_CTRLID = "CTRLID";
    public static final String TAG_AUTORENDER = "AUTORENDER";
    public static final String TAG_CREATECHILDFUNC = "CREATECHILDFUNC ";
    public static final String TAG_MOVEUPFUNC = "MOVEUPFUNC";
    public static final String TAG_MOVEDOWNFUNC = "MOVEDOWNFUNC";
    public static final String TAG_DELETEFUNC = "DELETEFUNC";
    public static final String TAG_ROOTVISIBLE = "ROOTVISIBLE";
    public static final String TAG_SHOWLINE = "SHOWLINE";
    protected String strDataURL = "";
    protected boolean bLoadDefault = true;
    protected String strSelectedValue = "";
    protected TreeNodeConfig rootNodeConfig = new TreeNodeConfig();
    protected String strBackEndCtrl = "";
    protected String strBackEndConfig = "";
    protected String strCtrlObject = "";
    protected String strCtrlId = "";
    protected TreeNodeTemplatesConfig treeNodeTemplatesConfig = null;
    protected boolean bAutoRender = true;
    protected ToolbarConfig topToolbarConfig = null;
    protected ToolbarConfig bottomToolbarConfig = null;
    protected boolean bCreateChildFunc = false;
    protected boolean bMoveUpFunc = false;
    protected boolean bMoveDownFunc = false;
    protected boolean bDeleteFunc = false;
    protected boolean bRootVisible = true;
    protected boolean bShowLine = true;

    public TreeNodeConfig getRootNodeConfig() {
        return this.rootNodeConfig;
    }

    public void setRootNodeConfig(TreeNodeConfig rootNodeConfig) {
        this.rootNodeConfig = rootNodeConfig;
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DATAURL, (boolean)true) == 0) {
            this.strDataURL = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SELECTEDVALUE, (boolean)true) == 0) {
            this.strSelectedValue = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_LOADDEFAULT, (boolean)true) == 0) {
            this.bLoadDefault = TreePanelConfig.GetValue((String)strValue, (boolean)this.bLoadDefault);
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
        if (StringHelper.Compare((String)strName, (String)TAG_CTRLOBJECT, (boolean)true) == 0) {
            this.strCtrlObject = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CTRLID, (boolean)true) == 0) {
            this.strCtrlId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_AUTORENDER, (boolean)true) == 0) {
            this.bAutoRender = TreePanelConfig.GetValue((String)strValue, (boolean)this.bAutoRender);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CREATECHILDFUNC, (boolean)true) == 0) {
            this.bCreateChildFunc = TreePanelConfig.GetValue((String)strValue, (boolean)this.bCreateChildFunc);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_MOVEUPFUNC, (boolean)true) == 0) {
            this.bMoveUpFunc = TreePanelConfig.GetValue((String)strValue, (boolean)this.bMoveUpFunc);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_MOVEDOWNFUNC, (boolean)true) == 0) {
            this.bMoveDownFunc = TreePanelConfig.GetValue((String)strValue, (boolean)this.bMoveDownFunc);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DELETEFUNC, (boolean)true) == 0) {
            this.bDeleteFunc = TreePanelConfig.GetValue((String)strValue, (boolean)this.bDeleteFunc);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ROOTVISIBLE, (boolean)true) == 0) {
            this.bRootVisible = TreePanelConfig.GetValue((String)strValue, (boolean)this.bRootVisible);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SHOWLINE, (boolean)true) == 0) {
            this.bShowLine = TreePanelConfig.GetValue((String)strValue, (boolean)this.bShowLine);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXTREENODE", (boolean)true) == 0) {
            this.rootNodeConfig.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXTREENODETEMPLATES", (boolean)true) == 0) {
            if (this.treeNodeTemplatesConfig == null) {
                this.treeNodeTemplatesConfig = new TreeNodeTemplatesConfig();
            }
            this.treeNodeTemplatesConfig.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TOPTOOLBAR, (boolean)true) == 0) {
            if (this.topToolbarConfig == null) {
                this.topToolbarConfig = new ToolbarConfig();
            }
            this.topToolbarConfig.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_BOTTOMTOOLBAR, (boolean)true) == 0) {
            if (this.bottomToolbarConfig == null) {
                this.bottomToolbarConfig = new ToolbarConfig();
            }
            this.bottomToolbarConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
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

    public String getCtrlObject() {
        return this.strCtrlObject;
    }

    public void setCtrlObject(String strCtrlObject) {
        this.strCtrlObject = strCtrlObject;
    }

    public String getCtrlId() {
        return this.strCtrlId;
    }

    public void setCtrlId(String strCtrlId) {
        this.strCtrlId = strCtrlId;
    }

    public TreeNodeTemplatesConfig getTreeNodeTemplatesConfig() {
        return this.treeNodeTemplatesConfig;
    }

    public boolean isAutoRender() {
        return this.bAutoRender;
    }

    public void setAutoRender(boolean autoRender) {
        this.bAutoRender = autoRender;
    }

    public ToolbarConfig getTopToolbarConfig() {
        return this.topToolbarConfig;
    }

    public ToolbarConfig getBottomToolbarConfig() {
        return this.bottomToolbarConfig;
    }

    public boolean isCreateChildFunc() {
        return this.bCreateChildFunc;
    }

    public void setCreateChildFunc(boolean createChildFunc) {
        this.bCreateChildFunc = createChildFunc;
    }

    public boolean isMoveUpFunc() {
        return this.bMoveUpFunc;
    }

    public void setMoveUpFunc(boolean moveUpFunc) {
        this.bMoveUpFunc = moveUpFunc;
    }

    public boolean isMoveDownFunc() {
        return this.bMoveDownFunc;
    }

    public void setMoveDownFunc(boolean moveDownFunc) {
        this.bMoveDownFunc = moveDownFunc;
    }

    public boolean isDeleteFunc() {
        return this.bDeleteFunc;
    }

    public void setDeleteFunc(boolean deleteFunc) {
        this.bDeleteFunc = deleteFunc;
    }

    public boolean isRootVisible() {
        return this.bRootVisible;
    }

    public void setRootVisible(boolean rootVisible) {
        this.bRootVisible = rootVisible;
    }

    public boolean isShowLine() {
        return this.bShowLine;
    }

    public void setShowLine(boolean showLine) {
        this.bShowLine = showLine;
    }
}

