package net.ibizsys.paas.control.tree;

import java.util.ArrayList;
import java.util.Iterator;

import org.w3c.dom.Node;

import net.ibizsys.paas.control.expbar.IExpBarItem;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.SimpleXmlNode;
import net.sf.json.JSONObject;

/**
 * 树节点对象
 * 
 * @author Administrator
 *
 */
public class TreeNode extends SimpleXmlNode implements ITreeNode {
	public final static String TREENODE_TREENODE = "SRFEXTREENODE";

	public final static String TREENODE_TEXT = "TEXT";
	public final static String TREENODE_ASYNCMODE = "ASYNCMODE";
	public final static String TREENODE_TIPS = "TIPS";
	public final static String TREENODE_CSSCLASS = "CSSCLASS";
	public final static String TREENODE_ICONCSSCLASS = "ICONCSSCLASS";
	public final static String TREENODE_ICON = "ICON";
	public final static String TREENODE_EXPAND = "EXPAND";
	public final static String TREENODE_DISABLE = "DISABLE";
	public final static String TREENODE_HREF = "HREF";
	public final static String TREENODE_HREFTARGET = "HREFTARGET";
	public final static String TREENODE_LEAF = "LEAF";
	public final static String TREENODE_TAG = "TAG";
	public final static String TREENODE_ALWAYSASYNCMODE = "ALWAYSASYNCMODE";
	public final static String TREENODE_DRAGGABLE = "DRAGGABLE";
	public final static String TREENODE_CHECKED = "CHECKED";
	public final static String TREENODE_DATATYPE = "DATATYPE";

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
	// protected boolean bSelected = false;

	protected ArrayList<ITreeNode> childNodes = null;
	protected JSONObject tagObj = null;

	/**
	 * 获取计数器标识
	 * 
	 * @return
	 */
	private String strCounterId = "";

	/**
	 * 获取计数器模式
	 */
	private int nCounterMode = IExpBarItem.COUNTERMODE_NONE;

	private Object dataSource = null;

	public TreeNode() {

	}

	/**
	 * 获取子节点集合
	 * 
	 * @return
	 */
	public java.util.Iterator<ITreeNode> getChildNodes() {
		if (childNodes == null || childNodes.size() == 0) return null;
		return childNodes.iterator();
	}

	@Override
	public void onLoadNode(String strName, Node xmlNode) {
		if (StringHelper.compare(TreeNode.TREENODE_TREENODE, strName, true) == 0) {
			if (childNodes == null) {
				childNodes = new ArrayList<ITreeNode>();
				bLeaf = false;
			}

			TreeNode treeNodeConfig = new TreeNode();
			if (treeNodeConfig.loadConfig(xmlNode)) {
				childNodes.add(treeNodeConfig);
			}
			return;
		}

		super.onLoadNode(strName, xmlNode);
	}

	@Override
	protected void onSetAttribute(String strName, String strValue) {
		if (StringHelper.compare(strName, TREENODE_ASYNCMODE, true) == 0) {
			bAsyncMode = getValue(strValue, bAsyncMode);
			return;
		}

		if (StringHelper.compare(strName, TREENODE_TIPS, true) == 0) {
			strTips = strValue;
			return;
		}
		if (StringHelper.compare(strName, TREENODE_EXPAND, true) == 0) {
			bExpand = getValue(strValue, bExpand);
			return;
		}

		if (StringHelper.compare(strName, TREENODE_TAG, true) == 0) {
			tagObj = JSONObjectHelper.fromString(strValue);
			return;
		}

		// if(StringHelper.compare(strName, TREENODE_SELECTED, true) == 0)
		// {
		// bSelected =GetValue(strValue, bSelected);
		// return;
		// }

		if (StringHelper.compare(strName, TREENODE_DISABLE, true) == 0) {
			bDisable = getValue(strValue, bDisable);
			return;
		}

		if (StringHelper.compare(strName, TREENODE_LEAF, true) == 0) {
			bLeaf = getValue(strValue, bLeaf);
			return;
		}

		if (StringHelper.compare(strName, TREENODE_HREFTARGET, true) == 0) {
			strHrefTarget = strValue;
			return;
		}

		if (StringHelper.compare(strName, TREENODE_HREF, true) == 0) {
			strHref = strValue;
			return;
		}

		if (StringHelper.compare(strName, TREENODE_CSSCLASS, true) == 0) {
			strCssClass = strValue;
			return;
		}

		if (StringHelper.compare(strName, TREENODE_ICONCSSCLASS, true) == 0) {
			strIconCssClass = strValue;
			return;
		}

		if (StringHelper.compare(strName, TREENODE_ICON, true) == 0) {
			strIcon = strValue;
			return;
		}

		if (StringHelper.compare(strName, TREENODE_TEXT, true) == 0) {
			this.strText = strValue;
			return;
		}

		if (StringHelper.compare(strName, TREENODE_ALWAYSASYNCMODE, true) == 0) {
			bAlwaysAsyncMode = getValue(strValue, bAlwaysAsyncMode);
			return;
		}

		if (StringHelper.compare(strName, TREENODE_DRAGGABLE, true) == 0) {
			bDraggable = getValue(strValue, bDraggable);
			return;
		}

		if (StringHelper.compare(strName, TREENODE_CHECKED, true) == 0) {
			this.bEnableCheck = true;
			bChecked = getValue(strValue, bChecked);
			return;
		}

		if (StringHelper.compare(strName, TREENODE_DATATYPE, true) == 0) {
			this.strNodeDataType = strValue;
			return;
		}
		
		super.onSetAttribute(strName, strValue);
	}

	/**
	 * 设置是否异步加载模式
	 * 
	 * @param bAsyncMode
	 */
	public void setAsyncMode(boolean bAsyncMode) {
		this.bAsyncMode = bAsyncMode;
	}

	/**
	 * 获取异步加载模式
	 * 
	 * @return
	 */
	public boolean isAsyncMode() {
		if (this.isAlwaysAsyncMode()) return true;
		return this.bAsyncMode;
	}

	/**
	 * 设置是否一直为异步加载模式(此代码用于预先加装节点，通知框架不将父节点设置为非异步加载节点
	 * 
	 * @param bAlwaysAsyncMode
	 */
	public void setAlwaysAsyncMode(boolean bAlwaysAsyncMode) {
		this.bAlwaysAsyncMode = bAlwaysAsyncMode;
	}

	/**
	 * 获取是否一直为异步加载模式
	 * 
	 * @return
	 */
	public boolean isAlwaysAsyncMode() {
		return this.bAlwaysAsyncMode;
	}

	// /**
	// * 设置是否选择
	// * @param bSelected
	// */
	// public void setSelected(boolean bSelected)
	// {
	// this.bSelected = bSelected;
	// }
	//
	//
	// /**
	// * 获取是否选择
	// * @return
	// */
	// public boolean getSelected()
	// {
	// return this.bSelected;
	// }

	/**
	 * 设置是否展开显示
	 * 
	 * @param bExpand
	 */
	public void setExpanded(boolean bExpand) {
		this.bExpand = bExpand;
	}

	/**
	 * 获取是否展开显示
	 * 
	 * @return
	 */
	public boolean isExpanded() {
		return this.bExpand;
	}

	/**
	 * 设置是否禁用
	 * 
	 * @param bDisable
	 */
	public void setDisabled(boolean bDisable) {
		this.bDisable = bDisable;
	}

	/**
	 * 获取是否禁用
	 * 
	 * @return
	 */
	public boolean isDisabled() {
		return this.bDisable;
	}

	/**
	 * 设置是否为叶子节点
	 * 
	 * @param bLeaf
	 */
	public void setLeaf(boolean bLeaf) {
		this.bLeaf = bLeaf;
	}

	/**
	 * 获取是否为叶子节点
	 * 
	 * @return
	 */
	public boolean isLeaf() {
		return this.bLeaf;
	}

	/**
	 * 获取样式
	 * 
	 * @return
	 */
	public String getCssClass() {
		return strCssClass;
	}

	/**
	 * 设置样式
	 * 
	 * @param strCssClass
	 */
	public void setCssClass(String strCssClass) {
		this.strCssClass = strCssClass;
	}

	/**
	 * 获取图标样式
	 * 
	 * @return
	 */
	public String getIconCssClass() {
		return strIconCssClass;
	}

	/**
	 * 设置图标样式
	 * 
	 * @param strIconCssClass
	 */
	public void setIconCssClass(String strIconCssClass) {
		this.strIconCssClass = strIconCssClass;
	}

	/**
	 * 获取图标
	 * 
	 * @return
	 */
	public String getIcon() {
		return strIcon;
	}

	/**
	 * 设置图标
	 * 
	 * @param strIcon
	 */
	public void setIcon(String strIcon) {
		this.strIcon = strIcon;
	}

	/**
	 * 获取链接
	 * 
	 * @return
	 */
	public String getHref() {
		return strHref;
	}

	/**
	 * 设置链接
	 * 
	 * @param strHref
	 */
	public void setHref(String strHref) {
		this.strHref = strHref;
	}

	/**
	 * 获取链接目标
	 * 
	 * @return
	 */
	public String getHrefTarget() {
		return strHrefTarget;
	}

	/**
	 * 设置链接目标
	 * 
	 * @param strHrefTarget
	 */
	public void setHrefTarget(String strHrefTarget) {
		this.strHrefTarget = strHrefTarget;
	}

	/**
	 * 获取节点提示信息
	 * 
	 * @return
	 */
	public String getTips() {
		return strTips;
	}

	/**
	 * 设置节点提示信息
	 * 
	 * @param strTips
	 */
	public void setTips(String strTips) {
		this.strTips = strTips;
	}

	/**
	 * 获取节点文本
	 * 
	 * @return
	 */
	public String getText() {
		return strText;
	}

	/**
	 * 设置节点文本
	 * 
	 * @param strText
	 */
	public void setText(String strText) {
		this.strText = strText;
	}

	/**
	 * 获取节点是否可以拖拽
	 * 
	 * @return the bDraggable
	 */
	public boolean isDraggable() {
		return bDraggable;
	}

	/**
	 * 设置节点是否可以拖拽
	 * 
	 * @param draggable
	 */
	public void setDraggable(boolean draggable) {
		bDraggable = draggable;
	}

	/**
	 * @return the bChecked
	 */
	public boolean isChecked() {
		return bChecked;
	}

	/**
	 * @return the bEnableCheck
	 */
	public boolean isEnableCheck() {
		return bEnableCheck;
	}

	/**
	 * 设置节点处于是否选中状态，同时启用 EnableCheck
	 * 
	 * @param bChecked
	 */
	public void setChecked(boolean bChecked) {
		this.bEnableCheck = true;
		this.bChecked = bChecked;
	}

	/**
	 * @param bEnableCheck
	 */
	public void setEnableCheck(boolean bEnableCheck) {
		this.bEnableCheck = bEnableCheck;
	}

	/**
	 * 通过节点编号查找制定的节点
	 * 
	 * @param strTreeNodeId 树节点的编号
	 * @return
	 */
	public ITreeNode findTreeNode(String strTreeNodeId) {
		if (StringHelper.compare(this.getId(), strTreeNodeId, true) == 0) return this;

		if (childNodes == null) return null;

		int nCount = childNodes.size();
		for (int i = 0; i < nCount; i++) {
			ITreeNode childNode = (ITreeNode) childNodes.get(i);
			ITreeNode findNode = childNode.findTreeNode(strTreeNodeId);
			if (findNode != null) return findNode;
		}
		return null;
	}

	/**
	 * 判断是否存在节点
	 * 
	 * @param strTreeNodeId
	 * @return
	 */
	public boolean containsTreeNode(String strTreeNodeId) {
		return (findTreeNode(strTreeNodeId) != null);
	}

	/**
	 * 增加树节点的子节点
	 * 
	 * @param childNodeConfig
	 */
	public void addChildNode(ITreeNode childNodeConfig) {
		if (childNodes == null) {
			childNodes = new ArrayList<ITreeNode>();
			bLeaf = false;
		}
		childNodes.add(childNodeConfig);
	}

	/**
	 * 重置子节点
	 */
	public void resetChildNodes() {
		childNodes = null;
		bLeaf = true;
	}

	/**
	 * 设置标记值
	 * 
	 * @param strKey
	 * @param objValue
	 */
	public void setTagValue(String strKey, Object objValue) {
		if (tagObj == null) tagObj = new JSONObject();

		if (tagObj.has(strKey)) {
			tagObj.remove(strKey);
		}

		if (objValue == null) {
			return;
		} else {
			tagObj.put(strKey,JSONObjectHelper.stripQuotes(objValue));
		}
	}

	/**
	 * 获取节点的标记值
	 * 
	 * @param strKey
	 * @return
	 */
	public Object getTagValue(String strKey) {
		return tagObj.get(strKey);
	}

	/**
	 * 获取标记数据
	 * 
	 * @return
	 */
	public JSONObject getTag() {
		return tagObj;
	}

	/**
	 * 导出树节点到Json
	 * 
	 * @param treeNodeConfig
	 * @param bSimple
	 * @return
	 */
	public static JSONObject toJSONObject(ITreeNode treeNodeConfig, boolean bSimple) {
		JSONObject objJSON = new JSONObject();

		objJSON.put("id", JSONObjectHelper.stripQuotes( treeNodeConfig.getId(),true));
		objJSON.put("text", JSONObjectHelper.stripQuotes( treeNodeConfig.getText(),true));
		if (!StringHelper.isNullOrEmpty(treeNodeConfig.getNodeDataType())){
			objJSON.put("datatype", JSONObjectHelper.stripQuotes( treeNodeConfig.getNodeDataType(),true));
		}
		
		if (!StringHelper.isNullOrEmpty(treeNodeConfig.getTips()) || !bSimple) {
			objJSON.put("qtip",JSONObjectHelper.stripQuotes(  treeNodeConfig.getTips(),true));
		}

		if (!StringHelper.isNullOrEmpty(treeNodeConfig.getCssClass()) || !bSimple) {
			objJSON.put("cls", JSONObjectHelper.stripQuotes( treeNodeConfig.getCssClass(),true));
		}

		if (treeNodeConfig.isDisabled() || !bSimple){
			objJSON.put("disabled", treeNodeConfig.isDisabled());
		}

		if (treeNodeConfig.isExpanded() || !bSimple){
			objJSON.put("expanded", treeNodeConfig.isExpanded());
		}
		objJSON.put("leaf", treeNodeConfig.isLeaf());

		if (!StringHelper.isNullOrEmpty(treeNodeConfig.getHref()) || !bSimple){
			objJSON.put("href", JSONObjectHelper.stripQuotes( treeNodeConfig.getHref(),true));
		}

		if (!StringHelper.isNullOrEmpty(treeNodeConfig.getHrefTarget()) || !bSimple){
			objJSON.put("hrefTarget", JSONObjectHelper.stripQuotes( treeNodeConfig.getHrefTarget(),true));
		}

		if (!StringHelper.isNullOrEmpty(treeNodeConfig.getIcon()) || !bSimple){
			objJSON.put("icon", JSONObjectHelper.stripQuotes( treeNodeConfig.getIcon(),true));
		}

		if (!StringHelper.isNullOrEmpty(treeNodeConfig.getIconCssClass()) || !bSimple){
			objJSON.put("iconCls",JSONObjectHelper.stripQuotes(  treeNodeConfig.getIconCssClass(),true));
		}
		
		if(!StringHelper.isNullOrEmpty(treeNodeConfig.getCounterId())) {
			objJSON.put("counterid",JSONObjectHelper.stripQuotes( treeNodeConfig.getCounterId(),true));
			objJSON.put("countermode", treeNodeConfig.getCounterMode());
		}

		if (treeNodeConfig.isDraggable()) objJSON.put("draggable", treeNodeConfig.isDraggable());
		if (treeNodeConfig.isEnableCheck()) {
			objJSON.put("checked", treeNodeConfig.isChecked());
		}
		if (treeNodeConfig.getTag() != null) {
			Iterator en = treeNodeConfig.getTag().keys();
			while (en.hasNext()) {
				String strKey = (String) en.next();
				if (!objJSON.has(strKey)){
					//避免重复写入
					objJSON.put(strKey, treeNodeConfig.getTag().get(strKey));
				}
			}
		}

		return objJSON;
	}

	/**
	 * 导出树节点到Json
	 * 
	 * @param treeNodeConfig
	 * @param bSimple
	 * @param bChild
	 * @return
	 */
	public static JSONObject toJSONObject(ITreeNode treeNodeConfig, boolean bSimple, boolean bChild) {
		JSONObject objJSON = toJSONObject(treeNodeConfig, bSimple);
		if (bChild && treeNodeConfig.getChildNodes() != null) {
			ArrayList<JSONObject> childJson = new ArrayList<JSONObject>();
			java.util.Iterator<ITreeNode> treeNodes = treeNodeConfig.getChildNodes();
			while (treeNodes.hasNext()) {
				ITreeNode childTreeNode = treeNodes.next();
				JSONObject childJsonItem = toJSONObject(childTreeNode, bSimple, bChild);
				childJson.add(childJsonItem);
			}

			if (childJson.size() > 0) {
				objJSON.put("items", childJson.toArray());

			}
		}
		return objJSON;
	}

	/**
	 * 导出JSON对象
	 * 
	 * @return
	 */
	public static JSONObject toJSONObject(ITreeNode treeNodeConfig) {
		return toJSONObject(treeNodeConfig, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IModelBase#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.tree.ITreeNode#getTreeNodeType()
	 */
	@Override
	public String getTreeNodeType() {
		return this.strTreeNodeType;
	}

	/**
	 * 设置节点类型
	 * 
	 * @param strTreeNodeType
	 */
	public void setTreeNodeType(String strTreeNodeType) {
		this.strTreeNodeType = strTreeNodeType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.expbar.IExpBarItem#getCounterId()
	 */
	@Override
	public String getCounterId() {
		return this.strCounterId;
	}

	/**
	 * 获取计数器模式
	 * 
	 * @return
	 */
	@Override
	public int getCounterMode() {
		return this.nCounterMode;
	}

	/**
	 * 设置计数器标识
	 * 
	 * @param strCounterId
	 */
	public void setCounterId(String strCounterId) {
		this.strCounterId = strCounterId;
	}

	/**
	 * 设置计算器模式
	 * 
	 * @param strCounterId
	 */
	public void setCounterMode(int nCounterMode) {
		this.nCounterMode = nCounterMode;
	}

	/**
	 * 设置数据源
	 * 
	 * @param dataSource
	 */
	public void setDataSource(Object dataSource) {
		this.dataSource = dataSource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.tree.ITreeNode#getDataSource()
	 */
	@Override
	public Object getDataSource() {
		return this.dataSource;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.control.tree.ITreeNode#getNodeDataType()
	 */
	@Override
	public String getNodeDataType() {
		return this.strNodeDataType;
	}

	
	/**
	 * 设置节点数据的类型
	 * @param strNodeDataType
	 */
	public void setNodeDataType(String strNodeDataType){
		this.strNodeDataType = strNodeDataType;
	}
	
	
}
