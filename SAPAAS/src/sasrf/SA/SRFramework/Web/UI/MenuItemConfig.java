/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.UI.BaseMenuConfig;
import SA.SRFramework.Web.UI.MainMenuConfig;
import SA.SRFramework.Web.UI.MenuGroupConfig;
import SA.SRFramework.Web.UI.ParamConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MenuItemConfig
extends BaseMenuConfig {
    protected static String ITEMPARAMS = "ITEMPARAMS";
    protected static String ITEMPARAM = "ITEMPARAM";
    protected static String PATH = "PATH";
    protected static String NAME = "NAME";
    protected static String SELECT = "SELECT";
    protected static String GROUPNAME = "GROUPNAME";
    protected static String MENUMODE = "MENUMODE";
    protected static String TARGET = "TARGET";
    protected static String JSCALL = "JSCALL";
    protected String strPath = "";
    protected String strMenuName = "";
    protected MainMenuConfig mainMenuConfig = null;
    protected MenuGroupConfig menuGroupConfig = null;
    protected String strSelectName = "";
    protected String strGroupName = "";
    protected String strMenuMode = "";
    protected String strTarget = "";
    protected boolean bJsCall = false;
    protected ArrayList itemParamList = new ArrayList();

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (strName.compareToIgnoreCase(ITEMPARAMS) == 0) {
            this.OnLoadItemParams(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public void OnLoadItemParams(Node xmlNode) {
        NodeList nodes = xmlNode.getChildNodes();
        int i = 0;
        while (i < nodes.getLength()) {
            ParamConfig item;
            Node childNode = nodes.item(i);
            if (childNode.getNodeName().compareToIgnoreCase(ITEMPARAM) == 0 && (item = new ParamConfig()).LoadConfig(childNode)) {
                this.itemParamList.add(item);
            }
            ++i;
        }
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare(PATH, strName, true) == 0) {
            this.strPath = strValue;
            return;
        }
        if (StringHelper.Compare(NAME, strName, true) == 0) {
            this.strMenuName = strValue;
            return;
        }
        if (StringHelper.Compare(SELECT, strName, true) == 0) {
            this.strSelectName = strValue;
            return;
        }
        if (StringHelper.Compare(GROUPNAME, strName, true) == 0) {
            this.strGroupName = strValue;
            return;
        }
        if (StringHelper.Compare(MENUMODE, strName, true) == 0) {
            this.strMenuMode = strValue;
            return;
        }
        if (StringHelper.Compare(TARGET, strName, true) == 0) {
            this.strTarget = strValue;
            return;
        }
        if (StringHelper.Compare(JSCALL, strName, true) == 0) {
            this.bJsCall = MenuItemConfig.GetValue(strValue, this.bJsCall);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getPath() {
        return this.strPath;
    }

    public void setPath(String value) {
        this.strPath = value;
    }

    public String getName() {
        return this.strMenuName;
    }

    public void setName(String value) {
        this.strMenuName = value;
    }

    public String getSelectName() {
        return this.strSelectName;
    }

    public void setSelectName(String value) {
        this.strSelectName = value;
    }

    public String getGroupName() {
        return this.strGroupName;
    }

    public void setGroupName(String value) {
        this.strGroupName = value;
    }

    public MainMenuConfig getMainMenu() {
        return this.mainMenuConfig;
    }

    public void setMainMenu(MainMenuConfig value) {
        this.mainMenuConfig = value;
    }

    public void setMenuGroup(MenuGroupConfig value) {
        this.menuGroupConfig = value;
    }

    public MenuGroupConfig getMenuGroup() {
        return this.menuGroupConfig;
    }

    public ArrayList getParamList() {
        return this.itemParamList;
    }

    public String getMenuMode() {
        return this.strMenuMode;
    }

    public void setMenuMode(String value) {
        this.strMenuMode = value;
    }

    public String getTarget() {
        return this.strTarget;
    }

    public void setTarget(String value) {
        this.strTarget = value;
    }

    public boolean getJSCall() {
        return this.bJsCall;
    }

    public void setJSCall(boolean value) {
        this.bJsCall = value;
    }
}

