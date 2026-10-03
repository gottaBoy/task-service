package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.control.tree.ITreeNodeDataItem;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.util.StringHelper;

/**
 * 树节点模型对象
 * 
 * @author Administrator
 *
 */
public abstract class TreeNodeModelBase extends ModelBaseImpl implements ITreeNodeModel {
	
	private ArrayList<ITreeNodeRSModel> treeNodeRSModelList = new ArrayList<ITreeNodeRSModel>();
	protected ArrayList<ITreeNodeDataItem> treeNodeDataItemList = new ArrayList<ITreeNodeDataItem>();
	protected HashMap<String, ITreeNodeDataItem> treeNodeDataItemMap = new HashMap<String, ITreeNodeDataItem>();
	
	private ITreeModel iTreeModel = null;
	private boolean bAppendPNodeId = false;
	private String strIconCls = "";
	private String strIconPath = "";
	private boolean bExpanded = false;
	private boolean bEnableCheck = false;
	private boolean bChecked = false;
	private String strNodeType = "";
	private boolean bRootNode = false;
	private String strDEName = "";
	private int nCounterMode = COUNTERMODE_NONE;
	private String strCounterId = "";
	private String strNodeDataType = "";
	private boolean bEnableQuickSearch = false;
	
	/**
	 * 初始化
	 * 
	 * @param iTreeModel
	 * @throws Exception
	 */
	public void init(ITreeModel iTreeModel) throws Exception {
		this.iTreeModel = iTreeModel;
		this.onInit();
	}

	/**
	 * 设置标识
	 * 
	 * @param strId
	 */
	public void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置名称
	 * 
	 * @param strName
	 */
	public void setName(String strName) {
		this.strName = strName;
	}

	/**
	 * 获取树模型
	 * 
	 * @return
	 */
	public ITreeModel getTreeModel() {
		return this.iTreeModel;
	}

	/**
	 * 注册树节点关系模型
	 * 
	 * @param iTreeNodeTypeRSModel
	 */
	public void registerTreeNodeRSModel(ITreeNodeRSModel iTreeNodeTypeRSModel) {
		treeNodeRSModelList.add(iTreeNodeTypeRSModel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeNodeModel#getTreeNodeRSModels()
	 */
	@Override
	public Iterator<ITreeNodeRSModel> getTreeNodeRSModels() {
		return this.treeNodeRSModelList.iterator();
	}

	/**
	 * 是否拥有关系模型
	 * 
	 * @return
	 */
	public boolean hasTreeNodeRSModel() {
		return treeNodeRSModelList.size() > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeNodeModel#isAppendPNodeId()
	 */
	@Override
	public boolean isAppendPNodeId() {
		return this.bAppendPNodeId;
	}

	/**
	 * 设置是否附加父节点
	 * 
	 * @param bAppendPNodeId
	 */
	public void setAppendPNodeId(boolean bAppendPNodeId) {
		this.bAppendPNodeId = bAppendPNodeId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeNodeModel#getIconCls()
	 */
	@Override
	public String getIconCls() {
		return this.strIconCls;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeNodeModel#isExpanded()
	 */
	@Override
	public boolean isExpanded() {
		return this.bExpanded;
	}

	/**
	 * 设置树节点图表样式
	 * 
	 * @param strIconCls the strIconCls to set
	 */
	public void setIconCls(String strIconCls) {
		this.strIconCls = strIconCls;
	}

	/**
	 * 设置树节点是否默认展开
	 * 
	 * @param bExpanded the bExpanded to set
	 */
	public void setExpanded(boolean bExpanded) {
		this.bExpanded = bExpanded;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeNodeModel#isEnableCheck()
	 */
	@Override
	public boolean isEnableCheck() {
		return this.bEnableCheck;
	}

	/**
	 * 设置树节点是否允许选中
	 * 
	 * @param bEnableCheck
	 */
	public void setEnableCheck(boolean bEnableCheck) {
		this.bEnableCheck = bEnableCheck;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeNodeModel#fillFetchResult(net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext, java.util.ArrayList)
	 */
	@Override
	public void fillFetchResult(ITreeNodeFetchContext iTreeNodeFetchContext, ArrayList<ITreeNode> treeNodeList) throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeNodeModel#fillFetchResult(net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext, java.util.ArrayList, net.ibizsys.paas.db.IDataTable)
	 */
	@Override
	public void fillFetchResult(ITreeNodeFetchContext iTreeNodeFetchContext, ArrayList<ITreeNode> treeNodeList, IDataTable dt) throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeNodeModel#isChecked()
	 */
	@Override
	public boolean isChecked() {
		return this.bChecked;
	}

	/**
	 * 设置树节点是否选中
	 * 
	 * @param bChecked
	 */
	public void setChecked(boolean bChecked) {
		this.bChecked = bChecked;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeNodeModel#getNodeType()
	 */
	@Override
	public String getNodeType() {
		return this.strNodeType;
	}

	/**
	 * 设置节点类型
	 * 
	 * @param strNodeType
	 */
	public void setNodeType(String strNodeType) {
		this.strNodeType = strNodeType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeNodeModel#isRootNode()
	 */
	@Override
	public boolean isRootNode() {
		return this.bRootNode;
	}

	/**
	 * 设置树节点是否为根节点
	 * 
	 * @param bRootNode
	 */
	public void setRootNode(boolean bRootNode) {
		this.bRootNode = bRootNode;
	}
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlmodel.ITreeNodeModel#getDEName()
	 */
	@Override
	public String getDEName() {
		return this.strDEName;
	}

	/**
	 * 设置实体对象名称
	 * 
	 * @param strDEName the strDEName to set
	 */
	public void setDEName(String strDEName) {
		this.strDEName = strDEName;
	}

	@Override
	public String getIconPath() {
		return this.strIconPath;
	}
	
	
	/**
	 * 设置图标路径
	 * @param strIconPath
	 */
	public void setIconPath(String strIconPath){
		this.strIconPath = strIconPath;
	}

	@Override
	public int getCounterMode() {
		return this.nCounterMode;
	}

	@Override
	public String getCounterId() {
		return this.strCounterId;
	}
	
	/**
	 * 设置计数器模式，值参考 net.ibizsys.paas.ctrlmodel.ITreeNodeModel.COUNTERMODE_XXX 定义
	 * @param nCounterMode
	 */
	public void setCounterMode(int nCounterMode) {
		this.nCounterMode = nCounterMode;
	}
	
	
	/**
	 * 设置计数器标识
	 * @param strCounterId
	 */
	public void setCounterId(String strCounterId) {
		this.strCounterId = strCounterId;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlmodel.ITreeNodeModel#getNodeDataType()
	 */
	@Override
	public String getNodeDataType() {
		return this.strNodeDataType;
	}
	
	
	/**
	 * 设置节点的数据类型
	 * @param strNodeDataType
	 */
	public void setNodeDataType(String strNodeDataType){
		this.strNodeDataType = strNodeDataType;
	}
	
	
	
	
	@Override
	public boolean isEnableQuickSearch() {
		return this.bEnableQuickSearch;
	}
	
	
	/**
	 * 设置是否支持快速搜索
	 * @param bEnableQuickSearch
	 */
	public void setEnableQuickSearch(boolean bEnableQuickSearch){
		this.bEnableQuickSearch = bEnableQuickSearch;
	}

	/**
	 * 注册表格数据项对象
	 * 
	 * @param iTreeNodeDataItem
	 */
	public void registerTreeNodeDataItem(ITreeNodeDataItem iTreeNodeDataItem) {
		this.treeNodeDataItemList.add(iTreeNodeDataItem);
		this.treeNodeDataItemMap.put(iTreeNodeDataItem.getName().toLowerCase(), iTreeNodeDataItem);
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlmodel.ITreeNodeModel#getTreeNodeDataItem(java.lang.String)
	 */
	public ITreeNodeDataItem getTreeNodeDataItem(String strName) throws Exception {
		ITreeNodeDataItem iTreeNodeDataItem = treeNodeDataItemMap.get(strName.toLowerCase());
		if (iTreeNodeDataItem == null) {
			throw new Exception(StringHelper.format("无法获取指定数据项[%1$s]", strName));
		}
		return iTreeNodeDataItem;
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlmodel.ITreeNodeModel#getTreeNodeDataItems()
	 */
	@Override
	public Iterator<ITreeNodeDataItem> getTreeNodeDataItems() {
		return treeNodeDataItemList.iterator();
	}
}
