/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.sf.json.JSONObject;
import org.w3c.dom.Node;

public class TreeNodeConfig
extends XMLConfig
implements Comparable {
    public static final String TAG_TREENODE = "SRFEXTREENODE";
    public static final String TAG_TEXT = "TEXT";
    public static final String TAG_ASYNCMODE = "ASYNCMODE";
    public static final String TAG_TIPS = "TIPS";
    public static final String TAG_CSSCLASS = "CSSCLASS";
    public static final String TAG_ICONCSSCLASS = "ICONCSSCLASS";
    public static final String TAG_ICON = "ICON";
    public static final String TAG_EXPAND = "EXPAND";
    public static final String TAG_DISABLE = "DISABLE";
    public static final String TAG_HREF = "HREF";
    public static final String TAG_HREFTARGET = "HREFTARGET";
    public static final String TAG_LEAF = "LEAF";
    public static final String TAG_TAG = "TAG";
    public static final String TAG_ALWAYSASYNCMODE = "ALWAYSASYNCMODE";
    public static final String TAG_DRAGGABLE = "DRAGGABLE";
    public static final String TAG_CHECKED = "CHECKED";
    protected static ArrayList<String> properties = new ArrayList();
    protected boolean bAsyncMode = false;
    protected String strText = "";
    protected String strTips = "";
    protected String strCssClass = "";
    protected String strIconCssClass = "";
    protected String strIcon = "";
    protected boolean bExpand = false;
    protected boolean bDisable = false;
    protected String strHref = "";
    protected String strHrefTarget = "";
    protected boolean bLeaf = true;
    protected boolean bAlwaysAsyncMode = false;
    protected boolean bDraggable = false;
    protected boolean bChecked = false;
    protected boolean bEnableCheck = false;
    protected ArrayList childNodes = null;
    protected JSONObject tagObj = null;

    static {
        properties.add("ID");
        properties.add(TAG_TEXT);
        properties.add(TAG_ASYNCMODE);
        properties.add(TAG_TIPS);
        properties.add(TAG_CSSCLASS);
        properties.add(TAG_ICONCSSCLASS);
        properties.add(TAG_ICON);
        properties.add(TAG_EXPAND);
        properties.add(TAG_DISABLE);
        properties.add(TAG_HREF);
        properties.add(TAG_HREFTARGET);
        properties.add(TAG_LEAF);
        properties.add(TAG_TAG);
        properties.add(TAG_ALWAYSASYNCMODE);
        properties.add(TAG_DRAGGABLE);
        properties.add(TAG_CHECKED);
    }

    public ArrayList getChildNodes() {
        return this.childNodes;
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)TAG_TREENODE, (String)strName, (boolean)true) == 0) {
            TreeNodeConfig treeNodeConfig;
            if (this.childNodes == null) {
                this.childNodes = new ArrayList();
                this.bLeaf = false;
            }
            if ((treeNodeConfig = new TreeNodeConfig()).LoadConfig(xmlNode)) {
                this.childNodes.add(treeNodeConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_ASYNCMODE, (boolean)true) == 0) {
            this.bAsyncMode = TreeNodeConfig.GetValue((String)strValue, (boolean)this.bAsyncMode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TIPS, (boolean)true) == 0) {
            this.strTips = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_EXPAND, (boolean)true) == 0) {
            this.bExpand = TreeNodeConfig.GetValue((String)strValue, (boolean)this.bExpand);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TAG, (boolean)true) == 0) {
            this.tagObj = JSONObject.fromString((String)strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DISABLE, (boolean)true) == 0) {
            this.bDisable = TreeNodeConfig.GetValue((String)strValue, (boolean)this.bDisable);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_LEAF, (boolean)true) == 0) {
            this.bLeaf = TreeNodeConfig.GetValue((String)strValue, (boolean)this.bLeaf);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_HREFTARGET, (boolean)true) == 0) {
            this.strHrefTarget = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_HREF, (boolean)true) == 0) {
            this.strHref = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CSSCLASS, (boolean)true) == 0) {
            this.strCssClass = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ICONCSSCLASS, (boolean)true) == 0) {
            this.strIconCssClass = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ICON, (boolean)true) == 0) {
            this.strIcon = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TEXT, (boolean)true) == 0) {
            this.strText = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ALWAYSASYNCMODE, (boolean)true) == 0) {
            this.bAlwaysAsyncMode = TreeNodeConfig.GetValue((String)strValue, (boolean)this.bAlwaysAsyncMode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DRAGGABLE, (boolean)true) == 0) {
            this.bDraggable = TreeNodeConfig.GetValue((String)strValue, (boolean)this.bDraggable);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CHECKED, (boolean)true) == 0) {
            this.bEnableCheck = true;
            this.bChecked = TreeNodeConfig.GetValue((String)strValue, (boolean)this.bChecked);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void setAsyncMode(boolean bAsyncMode) {
        this.bAsyncMode = bAsyncMode;
    }

    public boolean getAsyncMode() {
        if (this.getAlwaysAsyncMode()) {
            return true;
        }
        return this.bAsyncMode;
    }

    public void setAlwaysAsyncMode(boolean bAlwaysAsyncMode) {
        this.bAlwaysAsyncMode = bAlwaysAsyncMode;
    }

    public boolean getAlwaysAsyncMode() {
        return this.bAlwaysAsyncMode;
    }

    public void setExpand(boolean bExpand) {
        this.bExpand = bExpand;
    }

    public boolean getExpand() {
        return this.bExpand;
    }

    public void setDisable(boolean bDisable) {
        this.bDisable = bDisable;
    }

    public boolean getDisable() {
        return this.bDisable;
    }

    public void setLeaf(boolean bLeaf) {
        this.bLeaf = bLeaf;
    }

    public boolean getLeaf() {
        return this.bLeaf;
    }

    public String getCssClass() {
        return this.strCssClass;
    }

    public void setCssClass(String strCssClass) {
        this.strCssClass = strCssClass;
    }

    public String getIconCssClass() {
        return this.strIconCssClass;
    }

    public void setIconCssClass(String strIconCssClass) {
        this.strIconCssClass = strIconCssClass;
    }

    public String getIcon() {
        return this.strIcon;
    }

    public void setIcon(String strIcon) {
        this.strIcon = strIcon;
    }

    public String getHref() {
        return this.strHref;
    }

    public void setHref(String strHref) {
        this.strHref = strHref;
    }

    public String getHrefTarget() {
        return this.strHrefTarget;
    }

    public void setHrefTarget(String strHrefTarget) {
        this.strHrefTarget = strHrefTarget;
    }

    public String getTips() {
        return this.strTips;
    }

    public void setTips(String strTips) {
        this.strTips = strTips;
    }

    public String getText() {
        return this.strText;
    }

    public void setText(String strText) {
        this.strText = strText;
    }

    public boolean isDraggable() {
        return this.bDraggable;
    }

    public void setDraggable(boolean draggable) {
        this.bDraggable = draggable;
    }

    public boolean isChecked() {
        return this.bChecked;
    }

    public boolean isEnableCheck() {
        return this.bEnableCheck;
    }

    public void setChecked(boolean bChecked) {
        this.bEnableCheck = true;
        this.bChecked = bChecked;
    }

    public void setEnableCheck(boolean bEnableCheck) {
        this.bEnableCheck = bEnableCheck;
    }

    public TreeNodeConfig FindTreeNode(String strTreeNodeId) {
        if (StringHelper.Compare((String)this.getID(), (String)strTreeNodeId, (boolean)true) == 0) {
            return this;
        }
        if (this.childNodes == null) {
            return null;
        }
        int nCount = this.childNodes.size();
        int i = 0;
        while (i < nCount) {
            TreeNodeConfig childNode = (TreeNodeConfig)this.childNodes.get(i);
            TreeNodeConfig findNode = childNode.FindTreeNode(strTreeNodeId);
            if (findNode != null) {
                return findNode;
            }
            ++i;
        }
        return null;
    }

    public boolean ContainTreeNode(String strTreeNodeId) {
        return this.FindTreeNode(strTreeNodeId) != null;
    }

    public void AddChildNode(TreeNodeConfig childNodeConfig) {
        if (this.childNodes == null) {
            this.childNodes = new ArrayList();
            this.bLeaf = false;
        }
        this.childNodes.add(childNodeConfig);
    }

    public void ResetChildNode() {
        this.childNodes = null;
        this.bLeaf = true;
    }

    public String ToJSCode() {
        String strOutput = "";
        strOutput = this.getAsyncMode() ? String.valueOf(strOutput) + "new Ext.tree.AsyncTreeNode(" : String.valueOf(strOutput) + "new Ext.tree.TreeNode(";
        JSONObject objJSON = new JSONObject();
        objJSON.put("id", (Object)this.getID());
        objJSON.put("text", (Object)this.getText());
        if (!StringHelper.IsNullOrEmpty((String)this.getTips())) {
            objJSON.put("qtip", (Object)this.getTips());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getCssClass())) {
            objJSON.put("cls", (Object)this.getCssClass());
        }
        objJSON.put("disabled", this.getDisable());
        objJSON.put("expanded", this.getExpand());
        objJSON.put("leaf", this.getLeaf());
        if (!StringHelper.IsNullOrEmpty((String)this.getHref())) {
            objJSON.put("href", (Object)this.getHref());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getHrefTarget())) {
            objJSON.put("hrefTarget", (Object)this.getHrefTarget());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getIcon())) {
            objJSON.put("icon", (Object)this.getIcon());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getIconCssClass())) {
            objJSON.put("iconCls", (Object)this.getIconCssClass());
        }
        if (this.isDraggable()) {
            objJSON.put("draggable", this.isDraggable());
        }
        if (this.isEnableCheck()) {
            objJSON.put("checked", this.isChecked());
        }
        if (this.getTag() != null) {
            Iterator en = this.getTag().keys();
            while (en.hasNext()) {
                String strKey = (String)en.next();
                if (objJSON.has(strKey)) continue;
                Object objValue = this.getTag().get(strKey);
                objJSON.put(strKey, objValue);
            }
        }
        strOutput = String.valueOf(strOutput) + objJSON.toString();
        strOutput = String.valueOf(strOutput) + ")";
        return strOutput;
    }

    public void setTagValue(String strKey, Object objValue) {
        if (this.tagObj == null) {
            this.tagObj = new JSONObject();
        }
        if (this.tagObj.has(strKey)) {
            this.tagObj.remove(strKey);
        }
        if (objValue == null) {
            return;
        }
        this.tagObj.put(strKey, objValue);
    }

    public Object getTagValue(String strKey) {
        return this.tagObj.get(strKey);
    }

    public JSONObject getTag() {
        return this.tagObj;
    }

    public static JSONObject ToJSON(TreeNodeConfig treeNodeConfig, boolean bSimple) {
        JSONObject objJSON = new JSONObject();
        objJSON.put("id", (Object)treeNodeConfig.getID());
        objJSON.put("text", (Object)treeNodeConfig.getText());
        if (!StringHelper.IsNullOrEmpty((String)treeNodeConfig.getTips()) || !bSimple) {
            objJSON.put("qtip", (Object)treeNodeConfig.getTips());
        }
        if (!StringHelper.IsNullOrEmpty((String)treeNodeConfig.getCssClass()) || !bSimple) {
            objJSON.put("cls", (Object)treeNodeConfig.getCssClass());
        }
        if (treeNodeConfig.getDisable() || !bSimple) {
            objJSON.put("disabled", treeNodeConfig.getDisable());
        }
        if (treeNodeConfig.getExpand() || !bSimple) {
            objJSON.put("expanded", treeNodeConfig.getExpand());
        }
        objJSON.put("leaf", treeNodeConfig.getLeaf());
        if (!StringHelper.IsNullOrEmpty((String)treeNodeConfig.getHref()) || !bSimple) {
            objJSON.put("href", (Object)treeNodeConfig.getHref());
        }
        if (!StringHelper.IsNullOrEmpty((String)treeNodeConfig.getHrefTarget()) || !bSimple) {
            objJSON.put("hrefTarget", (Object)treeNodeConfig.getHrefTarget());
        }
        if (!StringHelper.IsNullOrEmpty((String)treeNodeConfig.getIcon()) || !bSimple) {
            objJSON.put("icon", (Object)treeNodeConfig.getIcon());
        }
        if (!StringHelper.IsNullOrEmpty((String)treeNodeConfig.getIconCssClass()) || !bSimple) {
            objJSON.put("iconCls", (Object)treeNodeConfig.getIconCssClass());
        }
        if (treeNodeConfig.isDraggable()) {
            objJSON.put("draggable", treeNodeConfig.isDraggable());
        }
        if (treeNodeConfig.isEnableCheck()) {
            objJSON.put("checked", treeNodeConfig.isChecked());
        }
        if (treeNodeConfig.getTag() != null) {
            Iterator en = treeNodeConfig.getTag().keys();
            while (en.hasNext()) {
                String strKey = (String)en.next();
                if (objJSON.has(strKey)) continue;
                objJSON.put(strKey, treeNodeConfig.getTag().get(strKey));
            }
        }
        return objJSON;
    }

    public static JSONObject ToJSON(TreeNodeConfig treeNodeConfig, boolean bSimple, boolean bChild) {
        JSONObject objJSON = TreeNodeConfig.ToJSON(treeNodeConfig, bSimple);
        if (bChild && treeNodeConfig.getChildNodes() != null) {
            ArrayList<JSONObject> childJson = new ArrayList<JSONObject>();
            int i = 0;
            while (i < treeNodeConfig.getChildNodes().size()) {
                TreeNodeConfig childTreeNodeConfig = (TreeNodeConfig)treeNodeConfig.getChildNodes().get(i);
                JSONObject childJsonItem = TreeNodeConfig.ToJSON(childTreeNodeConfig, bSimple, bChild);
                childJson.add(childJsonItem);
                ++i;
            }
            if (childJson.size() > 0) {
                objJSON.put("items", (Object)childJson.toArray());
            }
        }
        return objJSON;
    }

    public static JSONObject ToJSON(TreeNodeConfig treeNodeConfig) {
        return TreeNodeConfig.ToJSON(treeNodeConfig, false);
    }

    public static ArrayList<String> getProperties() {
        return properties;
    }

    public int compareTo(Object arg0) {
        if (!(arg0 instanceof TreeNodeConfig)) {
            return 1;
        }
        TreeNodeConfig treeNodeConfig = (TreeNodeConfig)arg0;
        return StringHelper.Compare((String)this.getText(), (String)treeNodeConfig.getText(), (boolean)false);
    }
}

