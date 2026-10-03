package net.ibizsys.paas.ctrlmodel;

import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.paas.control.ControlTypes;
import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;

/**
 * 树部件模型对象
 * 
 * @author Administrator
 *
 */
public abstract class TreeModelBase extends CtrlModelBase implements ITreeModel {
	

	private HashMap<String, ITreeNodeModel> treeNodeModelMap = new HashMap<String, ITreeNodeModel>();
	private boolean bEnableRootSelect = false;
	private ITreeNodeModel rootTreeNodeModel = null;
	private boolean bRootVisible = false;
	private String strCatCodeListId = null;
	private String strCounterId = null;

	@Override
	public String getControlType() {
		return ControlTypes.TreeView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.CtrlModelBase#onInit()
	 */
	@Override
	protected void onInit() throws Exception {
		super.onInit();

		onPrepareTreeMode();
	}

	/**
	 * 准备树模型
	 * 
	 * @throws Exception
	 */
	protected void onPrepareTreeMode() throws Exception {

	}

	/**
	 * 注树节点模型对象
	 * 
	 * @param iTreeNodeTypeModel
	 * @throws Exception
	 */
	protected void registerTreeNodeModel(ITreeNodeModel iTreeNodeTypeModel) throws Exception {
		treeNodeModelMap.put(iTreeNodeTypeModel.getId(), iTreeNodeTypeModel);
		if(!StringHelper.isNullOrEmpty(iTreeNodeTypeModel.getNodeType())){
			//20170322 进一步将节点类型进行注册
			treeNodeModelMap.put(iTreeNodeTypeModel.getNodeType(), iTreeNodeTypeModel);
		}
		if (iTreeNodeTypeModel.isRootNode()) {
			this.rootTreeNodeModel = iTreeNodeTypeModel;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeModel#getTreeNodeModel(java.lang.String)
	 */
	@Override
	public ITreeNodeModel getTreeNodeModel(String strTreeNodeModelId) throws Exception {
		ITreeNodeModel iTreeNodeModel = treeNodeModelMap.get(strTreeNodeModelId);
		if (iTreeNodeModel == null) {
			// 无法获取指定树节点模型
			throw new Exception(StringHelper.format("无法获取指定树节点模型[%1$s]", strTreeNodeModelId));
		}
		return iTreeNodeModel;
	}

	
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlmodel.ITreeModel#getTreeNodeModels()
	 */
	@Override
	public Iterator<ITreeNodeModel> getTreeNodeModels() {
		return this.treeNodeModelMap.values().iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeModel#getRootTreeNodeModel()
	 */
	@Override
	public ITreeNodeModel getRootTreeNodeModel() {
		return this.rootTreeNodeModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeModel#isEnableRootSelect()
	 */
	@Override
	public boolean isEnableRootSelect() {
		return this.bEnableRootSelect;
	}

	/**
	 * 设置是否允许根节点选中
	 * 
	 * @param bEnableRootSelect
	 */
	protected void setEnableRootSelect(boolean bEnableRootSelect) {
		this.bEnableRootSelect = bEnableRootSelect;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeModel#isRootVisible()
	 */
	@Override
	public boolean isRootVisible() {
		return this.bRootVisible;
	}

	/**
	 * 根节点是否可见
	 * 
	 * @param bRootVisible
	 */
	protected void setRootVisible(boolean bRootVisible) {
		this.bRootVisible = bRootVisible;
	}

	/**
	 * 获取树分类代码表标识
	 * 
	 * @return
	 */
	@Override
	public String getCatCodeListId() {
		return this.strCatCodeListId;
	}

	/**
	 * 设置分类代码表标识
	 * 
	 * @param bRootVisible
	 */
	protected void setCatCodeListId(String strCatCodeListId) {
		this.strCatCodeListId = strCatCodeListId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeModel#fillCatFetchResult(net.ibizsys.paas.web.MDAjaxActionResult)
	 */
	@Override
	public void fillCatFetchResult(MDAjaxActionResult fetchResult) throws Exception {
		if (StringHelper.isNullOrEmpty(getCatCodeListId())) return;

		ICodeListModel iCodeListModel = (ICodeListModel) CodeListGlobal.getCodeList(getCatCodeListId());
		iCodeListModel.fillFetchResult(fetchResult, WebContext.getCurrent());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeModel#isOutputTreeNodeRS(net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext, net.ibizsys.paas.ctrlmodel.ITreeNodeRSModel)
	 */
	@Override
	public boolean isOutputTreeNodeRS(ITreeNodeFetchContext iTreeNodeFetchContext, ITreeNodeRSModel iTreeNodeRSModel) throws Exception {
		/**
		 * 判断是否输出关系，20180831修改
		 */
		if(StringHelper.isNullOrEmpty(iTreeNodeFetchContext.getNodeFilter())){
			return ((iTreeNodeRSModel.getSearchMode() & ITreeNodeRSModel.SEARCHMODE_NO) == ITreeNodeRSModel.SEARCHMODE_NO);
		}
		else{
			return ((iTreeNodeRSModel.getSearchMode() & ITreeNodeRSModel.SEARCHMODE_YES) == ITreeNodeRSModel.SEARCHMODE_YES);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeModel#isOutputTreeNode(net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext, net.ibizsys.paas.control.tree.ITreeNode)
	 */
	@Override
	public boolean isOutputTreeNode(ITreeNodeFetchContext iTreeNodeFetchContext, ITreeNode iTreeNode) throws Exception {
		return true;
	}

	@Override
	public String getCounterId() {
		return this.strCounterId;
	}
	
	/**
	 * 设置计数器对象标识
	 * @param strCounterId
	 */
	protected void setCounterId(String strCounterId) {
		this.strCounterId = strCounterId;
	}
	
}
