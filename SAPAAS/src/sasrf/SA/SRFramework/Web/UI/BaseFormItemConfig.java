/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Data.ValueRuleGroupsConfig;
import SA.SRFramework.Web.UI.FormItemUserError;
import SA.SRFramework.Web.UI.ParamConfig;
import SA.SRFramework.Web.UI.WebCtrlConfig;
import java.util.ArrayList;
import java.util.Hashtable;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class BaseFormItemConfig
extends WebCtrlConfig {
    protected static String ITEMPARAMS = "ITEMPARAMS";
    protected static String ITEMPARAM = "ITEMPARAM";
    protected static String CELLCOUNT = "CELLCOUNT";
    protected static String SINGLEROW = "SINGLEROW";
    protected static String VALUEFORMAT = "VALUEFORMAT";
    protected static String ITEMFORMAT = "ITEMFORMAT";
    protected static String USERERRORS = "USERERRORS";
    protected static String VALUERULES = "VALUERULES";
    protected static String VALUERULE = "VALUERULE";
    protected static String USERERROR = "USERERROR";
    protected static String CUSTOMWIDTH = "CUSTOMWIDTH";
    protected static String GROUP = "GROUP";
    protected static String SHORTCUTLINK = "SHORTCUTLINK";
    protected int nCellCount = 0;
    protected boolean bSingleRow = false;
    protected String strValueFormat = "";
    protected ArrayList itemParamList = new ArrayList();
    protected Hashtable userErrorList = null;
    protected int nWidth = 0;
    protected String strGroupId = "";
    protected ValueRuleGroupsConfig valueRuleGroupsConfig = null;
    protected String strShortcutLink = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (strName.compareToIgnoreCase(CELLCOUNT) == 0) {
            this.nCellCount = BaseFormItemConfig.GetValue(strValue, this.nCellCount);
            return;
        }
        if (strName.compareToIgnoreCase(SINGLEROW) == 0) {
            this.bSingleRow = BaseFormItemConfig.GetValue(strValue, this.bSingleRow);
            return;
        }
        if (strName.compareToIgnoreCase(VALUEFORMAT) == 0 || strName.compareToIgnoreCase(ITEMFORMAT) == 0) {
            this.strValueFormat = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(CUSTOMWIDTH) == 0) {
            this.nWidth = BaseFormItemConfig.GetValue(strValue, this.nWidth);
            if (this.nWidth < 0) {
                this.nWidth = 0;
            }
            return;
        }
        if (strName.compareToIgnoreCase(GROUP) == 0) {
            this.strGroupId = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(SHORTCUTLINK) == 0) {
            this.strShortcutLink = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (strName.compareToIgnoreCase(ITEMPARAMS) == 0) {
            this.OnLoadItemParams(xmlNode);
            return;
        }
        if (strName.compareToIgnoreCase(USERERRORS) == 0) {
            this.LoadUserErrors(xmlNode);
            return;
        }
        if (strName.compareToIgnoreCase(VALUERULES) == 0) {
            this.LoadValueRules(xmlNode);
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

    protected void LoadUserErrors(Node xmlNode) {
        this.userErrorList = new Hashtable();
        NodeList nodes = xmlNode.getChildNodes();
        int i = 0;
        while (i < nodes.getLength()) {
            FormItemUserError formItemUserError;
            Node childXML = nodes.item(i);
            if (childXML.getNodeName().compareToIgnoreCase(USERERROR) == 0 && (formItemUserError = new FormItemUserError()).LoadConfig(childXML)) {
                this.userErrorList.put(formItemUserError.getID(), formItemUserError);
            }
            ++i;
        }
    }

    protected void LoadValueRules(Node xmlNode) {
        this.valueRuleGroupsConfig = null;
        this.valueRuleGroupsConfig = new ValueRuleGroupsConfig();
        this.valueRuleGroupsConfig.LoadConfig(xmlNode);
    }

    public FormItemUserError GetUserError(String strUserErrorId) {
        if (this.userErrorList == null) {
            return null;
        }
        if (this.userErrorList.containsKey((strUserErrorId = strUserErrorId.toUpperCase()).toUpperCase())) {
            return (FormItemUserError)this.userErrorList.get(strUserErrorId.toUpperCase());
        }
        return null;
    }

    public int getCellCount() {
        return this.nCellCount;
    }

    public boolean getSingleRow() {
        return this.bSingleRow;
    }

    public void setSingleRow(boolean value) {
        this.bSingleRow = value;
    }

    public String getValueFormat() {
        return this.strValueFormat;
    }

    public ArrayList getItemParams() {
        return this.itemParamList;
    }

    public ValueRuleGroupsConfig getValueRules() {
        return this.valueRuleGroupsConfig;
    }

    public int getCustomWidth() {
        return this.nWidth;
    }

    public String getGroup() {
        return this.strGroupId;
    }

    public void setGroup(String value) {
        this.strGroupId = value;
    }

    public String getShortcutLink() {
        return this.strShortcutLink;
    }
}

