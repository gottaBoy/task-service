/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.control.tree;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.SimpleXmlNode;
import net.sf.json.JSONObject;
import org.w3c.dom.Node;

public class TreeNode
extends SimpleXmlNode
implements ITreeNode {
    public static final String TREENODE_TREENODE = "SRFEXTREENODE";
    public static final String TREENODE_TEXT = "TEXT";
    public static final String TREENODE_ASYNCMODE = "ASYNCMODE";
    public static final String TREENODE_TIPS = "TIPS";
    public static final String TREENODE_CSSCLASS = "CSSCLASS";
    public static final String TREENODE_ICONCSSCLASS = "ICONCSSCLASS";
    public static final String TREENODE_ICON = "ICON";
    public static final String TREENODE_EXPAND = "EXPAND";
    public static final String TREENODE_DISABLE = "DISABLE";
    public static final String TREENODE_HREF = "HREF";
    public static final String TREENODE_HREFTARGET = "HREFTARGET";
    public static final String TREENODE_LEAF = "LEAF";
    public static final String TREENODE_TAG = "TAG";
    public static final String TREENODE_ALWAYSASYNCMODE = "ALWAYSASYNCMODE";
    public static final String TREENODE_DRAGGABLE = "DRAGGABLE";
    public static final String TREENODE_CHECKED = "CHECKED";
    public static final String TREENODE_DATATYPE = "DATATYPE";
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
    private String strTreeNodeType = "";
    private String strNodeDataType = "";
    protected ArrayList<ITreeNode> childNodes = null;
    protected JSONObject tagObj = null;
    private String strCounterId = "";
    private int nCounterMode = 0;
    private Object dataSource = null;

    @Override
    public Iterator<ITreeNode> getChildNodes() {
        if (this.childNodes == null || this.childNodes.size() == 0) {
            return null;
        }
        return this.childNodes.iterator();
    }

    @Override
    public void onLoadNode(String strName, Node xmlNode) {
        if (StringHelper.compare(TREENODE_TREENODE, strName, true) == 0) {
            TreeNode treeNodeConfig;
            if (this.childNodes == null) {
                this.childNodes = new ArrayList();
                this.bLeaf = false;
            }
            if ((treeNodeConfig = new TreeNode()).loadConfig(xmlNode)) {
                this.childNodes.add(treeNodeConfig);
            }
            return;
        }
        super.onLoadNode(strName, xmlNode);
    }

    @Override
    protected void onSetAttribute(String strName, String strValue) {
        if (StringHelper.compare(strName, TREENODE_ASYNCMODE, true) == 0) {
            this.bAsyncMode = TreeNode.getValue(strValue, this.bAsyncMode);
            return;
        }
        if (StringHelper.compare(strName, TREENODE_TIPS, true) == 0) {
            this.strTips = strValue;
            return;
        }
        if (StringHelper.compare(strName, TREENODE_EXPAND, true) == 0) {
            this.bExpand = TreeNode.getValue(strValue, this.bExpand);
            return;
        }
        if (StringHelper.compare(strName, TREENODE_TAG, true) == 0) {
            this.tagObj = JSONObjectHelper.fromString(strValue);
            return;
        }
        if (StringHelper.compare(strName, TREENODE_DISABLE, true) == 0) {
            this.bDisable = TreeNode.getValue(strValue, this.bDisable);
            return;
        }
        if (StringHelper.compare(strName, TREENODE_LEAF, true) == 0) {
            this.bLeaf = TreeNode.getValue(strValue, this.bLeaf);
            return;
        }
        if (StringHelper.compare(strName, TREENODE_HREFTARGET, true) == 0) {
            this.strHrefTarget = strValue;
            return;
        }
        if (StringHelper.compare(strName, TREENODE_HREF, true) == 0) {
            this.strHref = strValue;
            return;
        }
        if (StringHelper.compare(strName, TREENODE_CSSCLASS, true) == 0) {
            this.strCssClass = strValue;
            return;
        }
        if (StringHelper.compare(strName, TREENODE_ICONCSSCLASS, true) == 0) {
            this.strIconCssClass = strValue;
            return;
        }
        if (StringHelper.compare(strName, TREENODE_ICON, true) == 0) {
            this.strIcon = strValue;
            return;
        }
        if (StringHelper.compare(strName, TREENODE_TEXT, true) == 0) {
            this.strText = strValue;
            return;
        }
        if (StringHelper.compare(strName, TREENODE_ALWAYSASYNCMODE, true) == 0) {
            this.bAlwaysAsyncMode = TreeNode.getValue(strValue, this.bAlwaysAsyncMode);
            return;
        }
        if (StringHelper.compare(strName, TREENODE_DRAGGABLE, true) == 0) {
            this.bDraggable = TreeNode.getValue(strValue, this.bDraggable);
            return;
        }
        if (StringHelper.compare(strName, TREENODE_CHECKED, true) == 0) {
            this.bEnableCheck = true;
            this.bChecked = TreeNode.getValue(strValue, this.bChecked);
            return;
        }
        if (StringHelper.compare(strName, TREENODE_DATATYPE, true) == 0) {
            this.strNodeDataType = strValue;
            return;
        }
        super.onSetAttribute(strName, strValue);
    }

    public void setAsyncMode(boolean bAsyncMode) {
        this.bAsyncMode = bAsyncMode;
    }

    @Override
    public boolean isAsyncMode() {
        if (this.isAlwaysAsyncMode()) {
            return true;
        }
        return this.bAsyncMode;
    }

    public void setAlwaysAsyncMode(boolean bAlwaysAsyncMode) {
        this.bAlwaysAsyncMode = bAlwaysAsyncMode;
    }

    @Override
    public boolean isAlwaysAsyncMode() {
        return this.bAlwaysAsyncMode;
    }

    public void setExpanded(boolean bExpand) {
        this.bExpand = bExpand;
    }

    @Override
    public boolean isExpanded() {
        return this.bExpand;
    }

    public void setDisabled(boolean bDisable) {
        this.bDisable = bDisable;
    }

    @Override
    public boolean isDisabled() {
        return this.bDisable;
    }

    @Override
    public void setLeaf(boolean bLeaf) {
        this.bLeaf = bLeaf;
    }

    @Override
    public boolean isLeaf() {
        return this.bLeaf;
    }

    @Override
    public String getCssClass() {
        return this.strCssClass;
    }

    public void setCssClass(String strCssClass) {
        this.strCssClass = strCssClass;
    }

    @Override
    public String getIconCssClass() {
        return this.strIconCssClass;
    }

    public void setIconCssClass(String strIconCssClass) {
        this.strIconCssClass = strIconCssClass;
    }

    @Override
    public String getIcon() {
        return this.strIcon;
    }

    public void setIcon(String strIcon) {
        this.strIcon = strIcon;
    }

    @Override
    public String getHref() {
        return this.strHref;
    }

    public void setHref(String strHref) {
        this.strHref = strHref;
    }

    @Override
    public String getHrefTarget() {
        return this.strHrefTarget;
    }

    public void setHrefTarget(String strHrefTarget) {
        this.strHrefTarget = strHrefTarget;
    }

    @Override
    public String getTips() {
        return this.strTips;
    }

    public void setTips(String strTips) {
        this.strTips = strTips;
    }

    @Override
    public String getText() {
        return this.strText;
    }

    public void setText(String strText) {
        this.strText = strText;
    }

    @Override
    public boolean isDraggable() {
        return this.bDraggable;
    }

    public void setDraggable(boolean draggable) {
        this.bDraggable = draggable;
    }

    @Override
    public boolean isChecked() {
        return this.bChecked;
    }

    @Override
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

    @Override
    public ITreeNode findTreeNode(String strTreeNodeId) {
        if (StringHelper.compare(this.getId(), strTreeNodeId, true) == 0) {
            return this;
        }
        if (this.childNodes == null) {
            return null;
        }
        int nCount = this.childNodes.size();
        int i = 0;
        while (i < nCount) {
            ITreeNode childNode = this.childNodes.get(i);
            ITreeNode findNode = childNode.findTreeNode(strTreeNodeId);
            if (findNode != null) {
                return findNode;
            }
            ++i;
        }
        return null;
    }

    @Override
    public boolean containsTreeNode(String strTreeNodeId) {
        return this.findTreeNode(strTreeNodeId) != null;
    }

    @Override
    public void addChildNode(ITreeNode childNodeConfig) {
        if (this.childNodes == null) {
            this.childNodes = new ArrayList();
            this.bLeaf = false;
        }
        this.childNodes.add(childNodeConfig);
    }

    @Override
    public void resetChildNodes() {
        this.childNodes = null;
        this.bLeaf = true;
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
        this.tagObj.put(strKey, JSONObjectHelper.stripQuotes(objValue));
    }

    @Override
    public Object getTagValue(String strKey) {
        return this.tagObj.get(strKey);
    }

    @Override
    public JSONObject getTag() {
        return this.tagObj;
    }

    public static JSONObject toJSONObject(ITreeNode treeNodeConfig, boolean bSimple) {
        JSONObject objJSON = new JSONObject();
        objJSON.put("id", JSONObjectHelper.stripQuotes(treeNodeConfig.getId(), true));
        objJSON.put("text", JSONObjectHelper.stripQuotes(treeNodeConfig.getText(), true));
        if (!StringHelper.isNullOrEmpty(treeNodeConfig.getNodeDataType())) {
            objJSON.put("datatype", JSONObjectHelper.stripQuotes(treeNodeConfig.getNodeDataType(), true));
        }
        if (!StringHelper.isNullOrEmpty(treeNodeConfig.getTips()) || !bSimple) {
            objJSON.put("qtip", JSONObjectHelper.stripQuotes(treeNodeConfig.getTips(), true));
        }
        if (!StringHelper.isNullOrEmpty(treeNodeConfig.getCssClass()) || !bSimple) {
            objJSON.put("cls", JSONObjectHelper.stripQuotes(treeNodeConfig.getCssClass(), true));
        }
        if (treeNodeConfig.isDisabled() || !bSimple) {
            objJSON.put("disabled", treeNodeConfig.isDisabled());
        }
        if (treeNodeConfig.isExpanded() || !bSimple) {
            objJSON.put("expanded", treeNodeConfig.isExpanded());
        }
        objJSON.put("leaf", treeNodeConfig.isLeaf());
        if (!StringHelper.isNullOrEmpty(treeNodeConfig.getHref()) || !bSimple) {
            objJSON.put("href", JSONObjectHelper.stripQuotes(treeNodeConfig.getHref(), true));
        }
        if (!StringHelper.isNullOrEmpty(treeNodeConfig.getHrefTarget()) || !bSimple) {
            objJSON.put("hrefTarget", JSONObjectHelper.stripQuotes(treeNodeConfig.getHrefTarget(), true));
        }
        if (!StringHelper.isNullOrEmpty(treeNodeConfig.getIcon()) || !bSimple) {
            objJSON.put("icon", JSONObjectHelper.stripQuotes(treeNodeConfig.getIcon(), true));
        }
        if (!StringHelper.isNullOrEmpty(treeNodeConfig.getIconCssClass()) || !bSimple) {
            objJSON.put("iconCls", JSONObjectHelper.stripQuotes(treeNodeConfig.getIconCssClass(), true));
        }
        if (!StringHelper.isNullOrEmpty(treeNodeConfig.getCounterId())) {
            objJSON.put("counterid", JSONObjectHelper.stripQuotes(treeNodeConfig.getCounterId(), true));
            objJSON.put("countermode", treeNodeConfig.getCounterMode());
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

    public static JSONObject toJSONObject(ITreeNode treeNodeConfig, boolean bSimple, boolean bChild) {
        JSONObject objJSON = TreeNode.toJSONObject(treeNodeConfig, bSimple);
        if (bChild && treeNodeConfig.getChildNodes() != null) {
            ArrayList<JSONObject> childJson = new ArrayList<JSONObject>();
            Iterator<ITreeNode> treeNodes = treeNodeConfig.getChildNodes();
            while (treeNodes.hasNext()) {
                ITreeNode childTreeNode = treeNodes.next();
                JSONObject childJsonItem = TreeNode.toJSONObject(childTreeNode, bSimple, bChild);
                childJson.add(childJsonItem);
            }
            if (childJson.size() > 0) {
                objJSON.put("items", (Object)childJson.toArray());
            }
        }
        return objJSON;
    }

    public static JSONObject toJSONObject(ITreeNode treeNodeConfig) {
        return TreeNode.toJSONObject(treeNodeConfig, false);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getTreeNodeType() {
        return this.strTreeNodeType;
    }

    public void setTreeNodeType(String strTreeNodeType) {
        this.strTreeNodeType = strTreeNodeType;
    }

    @Override
    public String getCounterId() {
        return this.strCounterId;
    }

    @Override
    public int getCounterMode() {
        return this.nCounterMode;
    }

    public void setCounterId(String strCounterId) {
        this.strCounterId = strCounterId;
    }

    public void setCounterMode(int nCounterMode) {
        this.nCounterMode = nCounterMode;
    }

    public void setDataSource(Object dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Object getDataSource() {
        return this.dataSource;
    }

    @Override
    public String getNodeDataType() {
        return this.strNodeDataType;
    }

    public void setNodeDataType(String strNodeDataType) {
        this.strNodeDataType = strNodeDataType;
    }
}

