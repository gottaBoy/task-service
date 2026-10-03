package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;

import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.control.tree.TreeNode;
import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDEUIAction;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.ITreeCodeListNodeModel;
import net.ibizsys.paas.ctrlmodel.ITreeDEDataSetNodeModel;
import net.ibizsys.paas.ctrlmodel.ITreeModel;
import net.ibizsys.paas.ctrlmodel.ITreeNodeModel;
import net.ibizsys.paas.ctrlmodel.ITreeNodeRSModel;
import net.ibizsys.paas.ctrlmodel.ITreeStaticNodeModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEUIActionModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.security.DataAccessActions;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceBase;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

/**
 * 树视图处理对象基类
 * 
 * @author lionlau
 *
 */
public abstract class TreeHandlerBase extends MDCtrlHandlerBase implements ITreeHandler {

	/**
	 * 计数器处理对象
	 */
	private ICounterHandler iCounterHandler = null;
	
	/**
	 * 获取当前的树视图模型
	 * 
	 * @return
	 */
	protected ITreeModel getTreeModel() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ICtrlHandler#getCtrlModel()
	 */
	@Override
	public ICtrlModel getCtrlModel() {
		return getTreeModel();
	}

	/**
	 * @param iTreeNodeFetchContext
	 * @return
	 * @throws Exception
	 */
	public ArrayList<ITreeNode> getAllTreeNodes(ITreeNodeFetchContext iTreeNodeFetchContext) throws Exception {
		ArrayList<ITreeNode> treeNodeList = new ArrayList<ITreeNode>();
		// 没有指定节点，判断是否输出根
		if (getTreeModel().isRootVisible()) {
			// 返回根节点
			this.getTreeModel().getRootTreeNodeModel().fillFetchResult(iTreeNodeFetchContext, treeNodeList);
			for (ITreeNode iTreeNode : treeNodeList) {
				if (this.isOutputTreeNode(iTreeNodeFetchContext, iTreeNode)) fillChildTreeNodes(iTreeNodeFetchContext, iTreeNode, this.getTreeModel().getRootTreeNodeModel());
			}
		} else {
			TreeNodeFetchContext treeNodeFetchContext = new TreeNodeFetchContext(iTreeNodeFetchContext);
			treeNodeFetchContext.setRealNodeId(ITreeModel.NODE_ROOTID);

			// 根不可见
			boolean bRootSelect = false;
			java.util.Iterator<ITreeNodeRSModel> iTreeNodeRSModelModels = this.getTreeModel().getRootTreeNodeModel().getTreeNodeRSModels();
			while (iTreeNodeRSModelModels.hasNext()) {
				ITreeNodeRSModel iTreeNodeRSModel = iTreeNodeRSModelModels.next();
				if (!isOutputTreeNodeRS(iTreeNodeFetchContext, iTreeNodeRSModel)) continue;

				if (bRootSelect) {
					// if (StringHelper.isNullOrEmpty(strRootSelectNode) || StringHelper.compare(strRootSelectNode, iTreeNodeRSModel.getChildTreeNodeId(), true) == 0)
					// {
					// fillTreeNodeFetchResult(treeNodeFetchContext, iTreeNodeRSModel, mdAjaxActionResult);
					// return mdAjaxActionResult;
					// }
				} else {
					ArrayList<ITreeNode> treeNodeList2 = new ArrayList<ITreeNode>();
					fillTreeNodeFetchResult(treeNodeFetchContext, iTreeNodeRSModel, treeNodeList2);
					treeNodeList.addAll(treeNodeList2);
				}
			}

		}
		return treeNodeList;

	}

	/**
	 * 填充指定树节点子节点集合
	 * @param iTreeNodeFetchContext
	 * @param iTreeNode
	 * @param iTreeNodeModel
	 * @throws Exception
	 */
	protected void fillChildTreeNodes(ITreeNodeFetchContext iTreeNodeFetchContext, ITreeNode iTreeNode, ITreeNodeModel iTreeNodeModel) throws Exception {
		TreeNodeFetchContext treeNodeFetchContext = new TreeNodeFetchContext(iTreeNodeFetchContext);
		String strTreeNodeId = iTreeNode.getId();
		int nPos = strTreeNodeId.indexOf(ITreeModel.NODE_SEPARATOR);
		if (nPos == -1) {
			throw new Exception(StringHelper.format("树节点[%1$s]标识无效", strTreeNodeId));
		}

		String strRealNodeId = strTreeNodeId.substring(nPos + 1);
		treeNodeFetchContext.setRealNodeId(strRealNodeId);

		ArrayList<ITreeNode> treeNodeList = new ArrayList<ITreeNode>();
		java.util.Iterator<ITreeNodeRSModel> iTreeNodeRSModelModels = iTreeNodeModel.getTreeNodeRSModels();
		while (iTreeNodeRSModelModels.hasNext()) {
			ITreeNodeRSModel iTreeNodeRSModel = iTreeNodeRSModelModels.next();
			if (!isOutputTreeNodeRS(iTreeNodeFetchContext, iTreeNodeRSModel)) continue;

			ArrayList<ITreeNode> treeNodeList2 = new ArrayList<ITreeNode>();
			fillTreeNodeFetchResult(treeNodeFetchContext, iTreeNodeRSModel, treeNodeList2);
			treeNodeList.addAll(treeNodeList2);
		}
		for (ITreeNode childTreeNode : treeNodeList) {
			if (this.isOutputTreeNode(iTreeNodeFetchContext, childTreeNode)) iTreeNode.addChildNode(childTreeNode);
		}
		if (iTreeNode.getChildNodes() == null) iTreeNode.setLeaf(true);
	}

	/**
	 * 填充树节点查询结果
	 * 
	 * @param iTreeNodeFetchContext 上下文
	 * @param iTreeNodeRSModel 树节点关系模型
	 * @param treeNodeList 树节点列表
	 * @throws Exception
	 */
	protected void fillTreeNodeFetchResult(ITreeNodeFetchContext iTreeNodeFetchContext, ITreeNodeRSModel iTreeNodeRSModel, ArrayList<ITreeNode> treeNodeList) throws Exception {
		ITreeNodeModel iTreeNodeModel = this.getTreeModel().getTreeNodeModel(iTreeNodeRSModel.getChildTreeNodeId());
		if (iTreeNodeModel == null) {
			throw new Exception(StringHelper.format("无法获取树节点[%1$s]", iTreeNodeRSModel.getChildTreeNodeId()));
		}

		// 判断节点类型
		if ((StringHelper.compare(iTreeNodeModel.getTreeNodeType(), ITreeNodeModel.TREENODETYPE_STATIC, true) == 0) || (StringHelper.compare(iTreeNodeModel.getTreeNodeType(), ITreeNodeModel.TREENODETYPE_CODELIST, true) == 0)) {
			ArrayList<ITreeNode> treeNodeList2 = new ArrayList<ITreeNode>();
			iTreeNodeModel.fillFetchResult(iTreeNodeFetchContext, treeNodeList2);
			for (ITreeNode iTreeNode : treeNodeList2) {
				if (this.isOutputTreeNode(iTreeNodeFetchContext, iTreeNode)) {
					treeNodeList.add(iTreeNode);
					fillChildTreeNodes(iTreeNodeFetchContext, iTreeNode, iTreeNodeModel);
				}
			}
			return;
		}

		if (StringHelper.compare(iTreeNodeModel.getTreeNodeType(), ITreeNodeModel.TREENODETYPE_DE, true) == 0) {
			ITreeDEDataSetNodeModel iTreeDEDataSetNodeModel = (ITreeDEDataSetNodeModel) iTreeNodeModel;
			IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(iTreeDEDataSetNodeModel.getDEName());
			IService iService = iDataEntityModel.getService(ViewController.getCurrent().getSessionFactory());

			SimpleEntity srcDataEntity = new SimpleEntity();
			srcDataEntity.set("NODEFILTER", iTreeNodeFetchContext.getNodeFilter());

			String[] nodeid = iTreeNodeFetchContext.getRealNodeId().split(ITreeNodeModel.TREENODE_SEPARATOR);
			for (int i = 0; i < nodeid.length; i++) {
				if (i == 0) {
					srcDataEntity.set("NODEID", nodeid[i]);
				} else {
					srcDataEntity.set(StringHelper.format("NODEID%1$s", i + 1), nodeid[i]);
				}
			}
			
			/**
			 * 20170924添加，增强上下文数据转化能力
			 */
			if(!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getActiveDataDELogicId())){
				iService.executeLogic(iTreeDEDataSetNodeModel.getActiveDataDELogicId(), srcDataEntity);
			}

			String strSortParam = "";
			String strSortDir = "ASC";

			if (!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getSortField())) {
				IDEField sortDEField = iDataEntityModel.getDEField(iTreeDEDataSetNodeModel.getSortField(), false);
				if (sortDEField != null) {
					// strSortParam = sortDEField.getName().GetColumnName();
					strSortParam = sortDEField.getName();
				}

				if (!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getSortDir())) strSortDir = iTreeDEDataSetNodeModel.getSortDir();
			}

			// 判断是否有查询模型
			String strQueryModelId = "";
			if (!StringHelper.isNullOrEmpty(iTreeNodeFetchContext.getNodeFilter())) {
				strQueryModelId = iTreeDEDataSetNodeModel.getFilterDEDataSetName();
			}

			if (StringHelper.isNullOrEmpty(strQueryModelId)) strQueryModelId = iTreeDEDataSetNodeModel.getDEDataSetName();

			DEDataSetFetchContext deDataSetFetchContext = new DEDataSetFetchContext(null);
			deDataSetFetchContext.setActiveDataObject(processActiveDataObject(iTreeNodeFetchContext, iTreeNodeRSModel, srcDataEntity));
			deDataSetFetchContext.setSort(strSortParam);
			deDataSetFetchContext.setSortDir(strSortDir);
			deDataSetFetchContext.setStartRow(0);
			if(iTreeDEDataSetNodeModel.getMaxSize()>0){
				deDataSetFetchContext.setPageSize(iTreeDEDataSetNodeModel.getMaxSize());
			}
			else
				deDataSetFetchContext.setPageSize(1000);
			deDataSetFetchContext.setSessionFactory(ViewController.getCurrent().getSessionFactory());
			/**
			 * 20180831修改，增强节点快速搜索能力
			 */
			if (iTreeNodeModel.isEnableQuickSearch() && !StringHelper.isNullOrEmpty(iTreeNodeFetchContext.getNodeFilter())) {
				IDEDataSetCond iDEDataSetCond = iDataEntityModel.getFetchQuickSearchCondition(iTreeNodeFetchContext.getNodeFilter());
				if (iDEDataSetCond != null) {
					deDataSetFetchContext.getConditionList().add(iDEDataSetCond);
				}		
			}
			fillDEDataSetFetchContext(deDataSetFetchContext,iTreeDEDataSetNodeModel,iTreeNodeFetchContext,  iTreeNodeRSModel);
			
			DBFetchResult dbFetchResult = iService.fetchDataSet(strQueryModelId, deDataSetFetchContext);
			ArrayList<ITreeNode> treeNodeList2 = new ArrayList<ITreeNode>();
			iTreeDEDataSetNodeModel.fillFetchResult(iTreeNodeFetchContext, treeNodeList2, dbFetchResult.getDataSet().getDataTable(0));
			for (ITreeNode iTreeNode : treeNodeList2) {
				if (this.isOutputTreeNode(iTreeNodeFetchContext, iTreeNode)) {
					treeNodeList.add(iTreeNode);
					fillChildTreeNodes(iTreeNodeFetchContext, iTreeNode, iTreeNodeModel);
				}
			}
			dbFetchResult.getDataSet().close();
			return;
		}

	}
	
	

	/**
	 * 填充获取数据上下文对象
	 * @param deDataSetFetchContextImpl
	 * @param iTreeDEDataSetNodeModel
	 * @param iTreeNodeFetchContext
	 * @param iTreeNodeRSModel
	 * @throws Exception
	 */
	protected void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl,ITreeDEDataSetNodeModel iTreeDEDataSetNodeModel,ITreeNodeFetchContext iTreeNodeFetchContext,ITreeNodeRSModel iTreeNodeRSModel) throws Exception {

	}

	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase#onFetch()
	 */
	@Override
	protected AjaxActionResult onFetch() throws Exception {
		MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);

		TreeNodeFetchContext treeNodeFetchContext = new TreeNodeFetchContext(this.getWebContext());

		String strTreeNodeId = this.getCurNodeId(this.getWebContext());

		if (StringHelper.isNullOrEmpty(strTreeNodeId) || StringHelper.compare(strTreeNodeId, "#", true) == 0) {
			// 没有指定节点，判断是否输出根
			if (getTreeModel().isRootVisible()) {
				// 返回根节点
				ArrayList<ITreeNode> treeNodeList = new ArrayList<ITreeNode>();
				this.getTreeModel().getRootTreeNodeModel().fillFetchResult(treeNodeFetchContext, treeNodeList);
				this.fillFetchResult(mdAjaxActionResult, treeNodeList);
				return mdAjaxActionResult;
			} else {
				strTreeNodeId = ITreeModel.NODE_ROOTID;
			}
		}

		String strRealNodeId = "";
		ITreeNodeModel treeNode = null;
		boolean bRootSelect = false;
		// String strRootSelectNode = this.getWebContext().getPostValue("srfnodeselect");
		String strRootSelectNode = "";// this.getWebContext().getPostValue("srfnodeselect");
		if (StringHelper.compare(ITreeModel.NODE_ROOTID, strTreeNodeId, true) == 0) {
			treeNode = this.getTreeModel().getRootTreeNodeModel();
			strRealNodeId = treeNodeFetchContext.getCatalog();
			bRootSelect = this.getTreeModel().isEnableRootSelect();
		} else {
			int nPos = strTreeNodeId.indexOf(ITreeModel.NODE_SEPARATOR);
			if (nPos == -1) {
				mdAjaxActionResult.setRetCode(Errors.INTERNALERROR);
				mdAjaxActionResult.setErrorInfo(StringHelper.format("树节点[%1$s]标识无效", strTreeNodeId));
				return mdAjaxActionResult;
			}

			String strNodeType = strTreeNodeId.substring(0, nPos);
			strRealNodeId = strTreeNodeId.substring(nPos + 1);
			treeNode = this.getTreeModel().getTreeNodeModel(strNodeType);
		}
		//
		if (treeNode == null) {
			mdAjaxActionResult.setRetCode(Errors.INTERNALERROR);
			mdAjaxActionResult.setErrorInfo(StringHelper.format("无法获取树节点[%1$s]", strTreeNodeId));
			return mdAjaxActionResult;
		}

		treeNodeFetchContext.setRealNodeId(strRealNodeId);

		// 循环所有的子节点
		java.util.Iterator<ITreeNodeRSModel> iTreeNodeRSModelModels = treeNode.getTreeNodeRSModels();
		while (iTreeNodeRSModelModels.hasNext()) {
			ITreeNodeRSModel iTreeNodeRSModel = iTreeNodeRSModelModels.next();
			if (!isOutputTreeNodeRS(treeNodeFetchContext, iTreeNodeRSModel)) continue;

			// if(iTreeNodeRSModel.getTreeNodeRSSelector()!=null)
			// {
			// if(!iTreeNodeRSModel.getTreeNodeRSSelector().Test(this.getWebContext(), this.getTreeView()))
			// continue;
			// }

			if (bRootSelect) {
				if (StringHelper.isNullOrEmpty(strRootSelectNode) || StringHelper.compare(strRootSelectNode, iTreeNodeRSModel.getChildTreeNodeId(), true) == 0) {
					fillTreeNodeFetchResult(treeNodeFetchContext, iTreeNodeRSModel, mdAjaxActionResult);
					return mdAjaxActionResult;
				}
			} else {
				fillTreeNodeFetchResult(treeNodeFetchContext, iTreeNodeRSModel, mdAjaxActionResult);
			}
		}
		return mdAjaxActionResult;
	}

	/**
	 * 判断是否输出指定树关系
	 * 
	 * @param iTreeNodeRSModel
	 * @return
	 * @throws Exception
	 */
	protected boolean isOutputTreeNodeRS(ITreeNodeFetchContext iTreeNodeFetchContext, ITreeNodeRSModel iTreeNodeRSModel) throws Exception {
		return this.getTreeModel().isOutputTreeNodeRS(iTreeNodeFetchContext, iTreeNodeRSModel);
	}

	/**
	 * 判断是否输出指定树节点
	 * 
	 * @param iTreeNodeRSModel
	 * @return
	 * @throws Exception
	 */
	protected boolean isOutputTreeNode(ITreeNodeFetchContext iTreeNodeFetchContext, ITreeNode iTreeNode) throws Exception {
		return this.getTreeModel().isOutputTreeNode(iTreeNodeFetchContext, iTreeNode);
	}

	/**
	 * 填充树节点查询结果
	 * @param iTreeNodeFetchContext
	 * @param iTreeNodeRSModel
	 * @param treeNodeLoadResult
	 * @throws Exception
	 */
	protected void fillTreeNodeFetchResult(ITreeNodeFetchContext iTreeNodeFetchContext, ITreeNodeRSModel iTreeNodeRSModel, MDAjaxActionResult treeNodeLoadResult) throws Exception {
		ITreeNodeModel iTreeNodeModel = this.getTreeModel().getTreeNodeModel(iTreeNodeRSModel.getChildTreeNodeId());
		if (iTreeNodeModel == null) {
			treeNodeLoadResult.setRetCode(Errors.INTERNALERROR);
			treeNodeLoadResult.setErrorInfo(StringHelper.format("无法获取树节点[%1$s]", iTreeNodeRSModel.getChildTreeNodeId()));
			return;
		}

		// 判断节点类型
		if ((StringHelper.compare(iTreeNodeModel.getTreeNodeType(), ITreeNodeModel.TREENODETYPE_STATIC, true) == 0) || (StringHelper.compare(iTreeNodeModel.getTreeNodeType(), ITreeNodeModel.TREENODETYPE_CODELIST, true) == 0)) {
			ArrayList<ITreeNode> treeNodeList = new ArrayList<ITreeNode>();
			iTreeNodeModel.fillFetchResult(iTreeNodeFetchContext, treeNodeList);
			ArrayList<ITreeNode> treeNodeList2 = new ArrayList<ITreeNode>();
			for (ITreeNode iTreeNode : treeNodeList) {
				if (this.isOutputTreeNode(iTreeNodeFetchContext, iTreeNode)) treeNodeList2.add(iTreeNode);
			}
			this.fillFetchResult(treeNodeLoadResult, treeNodeList2);
			return;
		}

		if (StringHelper.compare(iTreeNodeModel.getTreeNodeType(), ITreeNodeModel.TREENODETYPE_DE, true) == 0) {
			ITreeDEDataSetNodeModel iTreeDEDataSetNodeModel = (ITreeDEDataSetNodeModel) iTreeNodeModel;
			IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(iTreeDEDataSetNodeModel.getDEName());
			IService iService = iDataEntityModel.getService(ViewController.getCurrent().getSessionFactory());

			SimpleEntity srcDataEntity = new SimpleEntity();
			srcDataEntity.set("NODEFILTER", iTreeNodeFetchContext.getNodeFilter());

			String[] nodeid = iTreeNodeFetchContext.getRealNodeId().split(ITreeNodeModel.TREENODE_SEPARATOR);
			for (int i = 0; i < nodeid.length; i++) {
				if (i == 0) {
					srcDataEntity.set("NODEID", nodeid[i]);
				} else {
					srcDataEntity.set(StringHelper.format("NODEID%1$s", i + 1), nodeid[i]);
				}
			}

			/**
			 * 20170924添加，增强上下文数据转化能力
			 */
			if(!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getActiveDataDELogicId())){
				iService.executeLogic(iTreeDEDataSetNodeModel.getActiveDataDELogicId(), srcDataEntity);
			}
			
			String strSortParam = "";
			String strSortDir = "ASC";

			if (!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getSortField())) {
				IDEField sortDEField = iDataEntityModel.getDEField(iTreeDEDataSetNodeModel.getSortField(), false);
				if (sortDEField != null) {
					strSortParam = sortDEField.getName();
				}

				if (!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getSortDir())) strSortDir = iTreeDEDataSetNodeModel.getSortDir();
			}

			// 判断是否有查询模型
			String strQueryModelId = "";
			if (!StringHelper.isNullOrEmpty(iTreeNodeFetchContext.getNodeFilter())) {
				strQueryModelId = iTreeDEDataSetNodeModel.getFilterDEDataSetName();
			}

			if (StringHelper.isNullOrEmpty(strQueryModelId)) strQueryModelId = iTreeDEDataSetNodeModel.getDEDataSetName();

			DEDataSetFetchContext deDataSetFetchContext = new DEDataSetFetchContext(null);
			deDataSetFetchContext.setActiveDataObject(processActiveDataObject(iTreeNodeFetchContext, iTreeNodeRSModel, srcDataEntity));
			deDataSetFetchContext.setSort(strSortParam);
			deDataSetFetchContext.setSortDir(strSortDir);
			deDataSetFetchContext.setStartRow(0);
			if(iTreeDEDataSetNodeModel.getMaxSize()>0){
				deDataSetFetchContext.setPageSize(iTreeDEDataSetNodeModel.getMaxSize());
			}
			else
				deDataSetFetchContext.setPageSize(1000);
			deDataSetFetchContext.setSessionFactory(ViewController.getCurrent().getSessionFactory());
			/**
			 * 20180831修改，增强节点快速搜索能力
			 */
			if (iTreeNodeModel.isEnableQuickSearch() && !StringHelper.isNullOrEmpty(iTreeNodeFetchContext.getNodeFilter())) {
				IDEDataSetCond iDEDataSetCond = iDataEntityModel.getFetchQuickSearchCondition(iTreeNodeFetchContext.getNodeFilter());
				if (iDEDataSetCond != null) {
					deDataSetFetchContext.getConditionList().add(iDEDataSetCond);
				}		
			}
			fillDEDataSetFetchContext(deDataSetFetchContext,iTreeDEDataSetNodeModel,iTreeNodeFetchContext,  iTreeNodeRSModel);
			

			DBFetchResult dbFetchResult = iService.fetchDataSet(strQueryModelId, deDataSetFetchContext);
			ArrayList<ITreeNode> treeNodeList = new ArrayList<ITreeNode>();
			iTreeDEDataSetNodeModel.fillFetchResult(iTreeNodeFetchContext, treeNodeList, dbFetchResult.getDataSet().getDataTable(0));

			ArrayList<ITreeNode> treeNodeList2 = new ArrayList<ITreeNode>();
			for (ITreeNode iTreeNode : treeNodeList) {
				if (this.isOutputTreeNode(iTreeNodeFetchContext, iTreeNode)) treeNodeList2.add(iTreeNode);
			}
			this.fillFetchResult(treeNodeLoadResult, treeNodeList2);
			return;
		}

	}


	/**
	 * 填充数据获取结果
	 * @param fetchResult
	 * @param treeNodeList
	 * @throws Exception
	 */
	protected void fillFetchResult(MDAjaxActionResult fetchResult, ArrayList<ITreeNode> treeNodeList) throws Exception {
		ICtrlRender iCtrlRender = this.getCtrlRender();
		if (iCtrlRender != null) {
			ITreeRender iTreeRender = (ITreeRender) iCtrlRender;
			iTreeRender.fillFetchResult(this.getTreeModel(), fetchResult, treeNodeList);
		} else {
			for (ITreeNode iTreeNode : treeNodeList) {
				fetchResult.getRows().add(TreeNode.toJSONObject(iTreeNode, false));
			}
		}
	}

	/**
	 * 获取当前请求的树节点
	 * 
	 * @return
	 * @throws Exception
	 */
	protected String getCurNodeId(IWebContext iWebContext) throws Exception {
		ICtrlRender iCtrlRender = this.getCtrlRender();
		if (iCtrlRender != null) {
			ITreeRender iTreeRender = (ITreeRender) iCtrlRender;
			return iTreeRender.getNodeId(iWebContext);
		} else {
			return WebContext.getNodeId(iWebContext);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase#onProcessAction(java.lang.String)
	 */
	@Override
	protected AjaxActionResult onProcessAction(String strAction) throws Exception {
		if (StringHelper.compare(strAction, ACTION_FETCHCAT, true) == 0) {
			return onFetchCat();
		}

		if (StringHelper.compare(strAction, ACTION_FETCHCOUNTER, true) == 0) {
			return onFetchCounter();
		}
		
		
		
		return super.onProcessAction(strAction);
	}

	/**
	 * 获取树分类数据
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onFetchCat() throws Exception {
		MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);
		this.getTreeModel().fillCatFetchResult(mdAjaxActionResult);
		return mdAjaxActionResult;
	}

	/**
	 * 处理当前数据对象
	 * 
	 * @param iTreeNodeFetchContext
	 * @param iTreeNodeRSModel
	 * @param iDataObject
	 * @return
	 * @throws Exception
	 */
	protected IEntity processActiveDataObject(ITreeNodeFetchContext iTreeNodeFetchContext, ITreeNodeRSModel iTreeNodeRSModel, IEntity iEntity) throws Exception {
		if (StringHelper.isNullOrEmpty(iTreeNodeRSModel.getDEActionName())) {
			return iEntity;
		} else {
			this.getService().executeAction(iTreeNodeRSModel.getDEActionName(), iEntity);
			return iEntity;
		}

	}

	/**
	 * 删除树节点
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onRemove() throws Exception {
		MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(ajaxActionResult);
		
		String strTreeNodeId = this.getCurNodeId(this.getWebContext());

		if (StringHelper.isNullOrEmpty(strTreeNodeId) || StringHelper.compare(strTreeNodeId, "#", true) == 0) {
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(StringHelper.format("树节点[%1$s]标识无效", strTreeNodeId));
			return ajaxActionResult;
		}

		String strRealNodeId = "";
		ITreeNodeModel treeNode = null;
		if (StringHelper.compare(ITreeModel.NODE_ROOTID, strTreeNodeId, true) == 0) {
			treeNode = this.getTreeModel().getRootTreeNodeModel();
		} else {
			int nPos = strTreeNodeId.indexOf(ITreeModel.NODE_SEPARATOR);
			if (nPos == -1) {
				ajaxActionResult.setRetCode(Errors.INTERNALERROR);
				ajaxActionResult.setErrorInfo(StringHelper.format("树节点[%1$s]标识无效", strTreeNodeId));
				return ajaxActionResult;
			}

			String strNodeType = strTreeNodeId.substring(0, nPos);
			strRealNodeId = strTreeNodeId.substring(nPos + 1);
			treeNode = this.getTreeModel().getTreeNodeModel(strNodeType);
		}
		//
		if (treeNode == null) {
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(StringHelper.format("无法获取树节点[%1$s]", strTreeNodeId));
			return ajaxActionResult;
		}

		try {
			removeTreeNode(treeNode, strRealNodeId);
		} catch (ErrorException ex) {
			ajaxActionResult.setRetCode(ex.getErrorCode());
			ajaxActionResult.setErrorInfo(ex.getMessage());
			return ajaxActionResult;
		} catch (Exception ex) {
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(ex.getMessage());
			return ajaxActionResult;
		}

		ajaxActionResult.setReloadData(true);
		return ajaxActionResult;
	}

	/**
	 * 删除树节点
	 * 
	 * @param treeNode
	 * @param strRealNodeId
	 * @throws Exception
	 */
	protected void removeTreeNode(ITreeNodeModel iTreeNodeModel, String strRealNodeId) throws Exception {
		String[] nodeids = strRealNodeId.split(ITreeNodeModel.TREENODE_SEPARATOR);
		String strKey = nodeids[0];

		if (iTreeNodeModel instanceof ITreeDEDataSetNodeModel) {
			ITreeDEDataSetNodeModel iTreeDEDataSetNodeModel = (ITreeDEDataSetNodeModel) iTreeNodeModel;
			String strRemoveDEActionName = iTreeDEDataSetNodeModel.getRemoveDEActionName();
			if (StringHelper.isNullOrEmpty(strRemoveDEActionName)){
				throw new Exception(StringHelper.format("树节点[%1$s]不支持删除操作", iTreeNodeModel.getName()));
			}

			IDataEntityModel iDEModel = DEModelGlobal.getDEModel(iTreeDEDataSetNodeModel.getDEName());
			String strDataAccessAction = iTreeDEDataSetNodeModel.getRemoveDataAccessAction();
			if (StringHelper.isNullOrEmpty(strDataAccessAction)) {
				strDataAccessAction = DataAccessActions.DELETE;
			}

			IEntity iEntity = getSimpleEntity(iDEModel, strKey);
			CallResult callResult = this.testDataAccessAction(iDEModel, iEntity, strDataAccessAction);
			if (!callResult.isOk()) {
				throw new ErrorException(Errors.ACCESSDENY, callResult.getErrorInfo());
			}

			iDEModel.getService(this.getSessionFactory()).executeAction(strRemoveDEActionName, iEntity);
			return;
		}

		throw new Exception(StringHelper.format("树节点[%1$s]不支持删除操作", iTreeNodeModel.getName()));

	}

	/**
	 * 获取数据对象，用于权限处理
	 * 
	 * @param strDEName 实体名称
	 * @param objKey
	 * @return
	 * @throws Exception
	 */
	protected IEntity getSimpleEntity(IDataEntityModel iDEModel, Object objKey) throws Exception {
		if (objKey != null && objKey instanceof String) {
			if (((String) objKey).indexOf(ServiceBase.TEMPKEY) == 0) return null;
		}

		IEntity iEntity = iDEModel.createEntity();
		iEntity.set(iDEModel.getKeyDEField().getName(), objKey);
		iDEModel.getService(this.getSessionFactory()).get(iEntity);
		return iEntity;
	}

	/**
	 * 测试数据是否具备指定权限
	 * 
	 * @param strDEName
	 * @param iEntity
	 * @param strDataAccessAction
	 * @return
	 * @throws Exception
	 */
	protected CallResult testDataAccessAction(IDataEntityModel iDEModel, IEntity iEntity, String strDataAccessAction) throws Exception {
		return this.getWebContext().getUserPrivilegeMgr().testDataAccessAction(this.getWebContext(), iDEModel, iEntity, strDataAccessAction);
	}
	
	
	/**
	 * 处理用户界面行为
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	protected AjaxActionResult onUIAction() throws Exception {
		// 获取对应的行为
		String strDEUIActionId = WebContext.getUIActionId(this.getWebContext());
		String strTreeNodeType = WebContext.getNodeType(this.getWebContext());
		IDEUIActionModel iDEUIActionModel = null;
		if(StringHelper.isNullOrEmpty(strTreeNodeType)){
			 iDEUIActionModel = (IDEUIActionModel) this.getDEModel().getDEUIAction(strDEUIActionId);
		}
		else{
			ITreeNodeModel iTreeNodeModel = this.getTreeModel().getTreeNodeModel(strTreeNodeType);
			if(!StringHelper.isNullOrEmpty(iTreeNodeModel.getDEName())){
				IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(iTreeNodeModel.getDEName());
				iDEUIActionModel = (IDEUIActionModel)iDataEntityModel.getDEUIAction(strDEUIActionId);
			}
		}
		return this.doUIAction(iDEUIActionModel);
	}
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase#doUIAction(net.ibizsys.paas.demodel.IDEUIActionModel)
	 */
	@Override
	protected AjaxActionResult doUIAction(IDEUIActionModel iDEUIActionModel) throws Exception {
		MDAjaxActionResult mdAjaxActionResult = createFetchActionResult();
		this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);
		if (StringHelper.compare(iDEUIActionModel.getActionTarget(), IDEUIAction.ACTIONTARGET_NONE, true) == 0) {
			if (!StringHelper.isNullOrEmpty(iDEUIActionModel.getDataAccessAction())) {
				// 判断是否有指定行为
				CallResult callResult = iDEUIActionModel.getDEModel().getDEDataAccMgr().test(this.getWebContext(), null, iDEUIActionModel.getDataAccessAction());
				if (callResult.isError()) {
					mdAjaxActionResult.from(callResult);
					return mdAjaxActionResult;
				}
			}
			iDEUIActionModel.execute(null, this.getSessionFactory());
		} else {
			String strKeys = WebContext.getKeys(this.getWebContext());
			if (StringHelper.isNullOrEmpty(strKeys)) {
				strKeys = WebContext.getKey(this.getWebContext());
			}

			if (StringHelper.isNullOrEmpty(strKeys)) {
				mdAjaxActionResult.setRetCode(Errors.INVALIDDATAKEYS);
				return mdAjaxActionResult;
			}
			ArrayList entities = iDEUIActionModel.getDEModel().createEntityList();
			String[] keys = strKeys.split("[|]");//使用 | 分隔
			for (int i = 0; i < keys.length; i++) {
				String strTreeNodeId = keys[i];
				int nPos = strTreeNodeId.indexOf(ITreeModel.NODE_SEPARATOR);
				if (nPos == -1) {
					mdAjaxActionResult.setRetCode(Errors.INTERNALERROR);
					mdAjaxActionResult.setErrorInfo(StringHelper.format("树节点[%1$s]标识无效", strTreeNodeId));
					return mdAjaxActionResult;
				}

				String strNodeType = strTreeNodeId.substring(0, nPos);
				String strRealNodeId = strTreeNodeId.substring(nPos + 1);
				IEntity iEntity = iDEUIActionModel.getDEModel().createEntity();
				iEntity.set(iDEUIActionModel.getDEModel().getKeyDEField().getName(), strRealNodeId);
				// 判断权限
				if (!StringHelper.isNullOrEmpty(iDEUIActionModel.getDataAccessAction())) {
					IEntity iEntity2 = this.getSimpleEntity(iDEUIActionModel.getDEModel(),strRealNodeId);
					if(iEntity2!=null){
						// 判断是否有指定行为
						CallResult callResult = iDEUIActionModel.getDEModel().getDEDataAccMgr().test(this.getWebContext(), iEntity2, iDEUIActionModel.getDataAccessAction());
						if (callResult.isError()) {
							mdAjaxActionResult.from(callResult);
							return mdAjaxActionResult;
						}
						//相同主键，赋值
						if(DataTypeHelper.compare(iDEUIActionModel.getDEModel().getKeyDEField().getStdDataType(), iEntity.get(iDEUIActionModel.getDEModel().getKeyDEField().getName()), iEntity2.get(iDEUIActionModel.getDEModel().getKeyDEField().getName()))==0){
							iEntity  = iEntity2;
						}
					}
				}
				entities.add(iEntity);
			}

			iDEUIActionModel.execute(entities, this.getSessionFactory());
		}
		mdAjaxActionResult.setReloadData(iDEUIActionModel.isReloadData());
		mdAjaxActionResult.setErrorInfo(iDEUIActionModel.getSuccessMsg());
		return mdAjaxActionResult;
	}
	
	
	@Override
	protected AjaxActionResult onItemTip() throws Exception {
		AjaxActionResult ajaxActionResult = new AjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(ajaxActionResult);
		String strTreeNodeId = this.getCurNodeId(this.getWebContext());

		if (StringHelper.isNullOrEmpty(strTreeNodeId) || StringHelper.compare(strTreeNodeId, "#", true) == 0) {
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(StringHelper.format("树节点[%1$s]标识无效", strTreeNodeId));
			return ajaxActionResult;
		}

		String strRealNodeId = "";
		ITreeNodeModel treeNode = null;
		if (StringHelper.compare(ITreeModel.NODE_ROOTID, strTreeNodeId, true) == 0) {
			treeNode = this.getTreeModel().getRootTreeNodeModel();
		} else {
			int nPos = strTreeNodeId.indexOf(ITreeModel.NODE_SEPARATOR);
			if (nPos == -1) {
				ajaxActionResult.setRetCode(Errors.INTERNALERROR);
				ajaxActionResult.setErrorInfo(StringHelper.format("树节点[%1$s]标识无效", strTreeNodeId));
				return ajaxActionResult;
			}

			String strNodeType = strTreeNodeId.substring(0, nPos);
			strRealNodeId = strTreeNodeId.substring(nPos + 1);
			treeNode = this.getTreeModel().getTreeNodeModel(strNodeType);
		}
		//
		if (treeNode == null) {
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(StringHelper.format("无法获取树节点[%1$s]", strTreeNodeId));
			return ajaxActionResult;
		}

		try {
			ajaxActionResult.setContent(getTreeNodeSummary(treeNode, strRealNodeId));
		} catch (ErrorException ex) {
			ajaxActionResult.setRetCode(ex.getErrorCode());
			ajaxActionResult.setErrorInfo(ex.getMessage());
			return ajaxActionResult;
		} catch (Exception ex) {
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(ex.getMessage());
			return ajaxActionResult;
		}
		return ajaxActionResult;
	}
	
	
	
	/**
	 * 获取树节点信息
	 * 
	 * @param treeNode
	 * @param strRealNodeId
	 * @throws Exception
	 */
	protected String getTreeNodeSummary(ITreeNodeModel iTreeNodeModel, String strRealNodeId) throws Exception {
		String[] nodeids = strRealNodeId.split(ITreeNodeModel.TREENODE_SEPARATOR);
		String strKey = nodeids[0];

		if (iTreeNodeModel instanceof ITreeDEDataSetNodeModel) {
			ITreeDEDataSetNodeModel iTreeDEDataSetNodeModel = (ITreeDEDataSetNodeModel) iTreeNodeModel;
			IDataEntityModel iDEModel = DEModelGlobal.getDEModel(iTreeDEDataSetNodeModel.getDEName());
			String strDataAccessAction = DataAccessActions.READ;
			IEntity iEntity = getSimpleEntity(iDEModel, strKey);
			CallResult callResult = this.testDataAccessAction(iDEModel, iEntity, strDataAccessAction);
			if (!callResult.isOk()) {
				throw new ErrorException(Errors.ACCESSDENY, callResult.getErrorInfo());
			}
			return iDEModel.getService(this.getSessionFactory()).getDataSummary(iEntity);
		}

		return iTreeNodeModel.getName();
	}
	
	/**
	 * 获取计数器数据
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onFetchCounter() throws Exception {
		MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);
		
		String strAllTreeNodeId = this.getCurNodeId(this.getWebContext());

		if (StringHelper.isNullOrEmpty(strAllTreeNodeId) || StringHelper.compare(strAllTreeNodeId, "#", true) == 0) {
			//mdAjaxActionResult.setRetCode(Errors.INTERNALERROR);
			//mdAjaxActionResult.setErrorInfo(StringHelper.format("树节点[%1$s]标识无效", strAllTreeNodeId));
			return mdAjaxActionResult;
		}
		
		String[] treeNodeIds =strAllTreeNodeId.split("[|]");
		for(String   strTreeNodeId:treeNodeIds) {
			if (StringHelper.isNullOrEmpty(strTreeNodeId) || StringHelper.compare(strTreeNodeId, "#", true) == 0) {
				continue;
			}
			
			String strRealNodeId = "";
			ITreeNodeModel treeNode = null;
			if (StringHelper.compare(ITreeModel.NODE_ROOTID, strTreeNodeId, true) == 0) {
				treeNode = this.getTreeModel().getRootTreeNodeModel();
			} else {
				int nPos = strTreeNodeId.indexOf(ITreeModel.NODE_SEPARATOR);
				if (nPos == -1) {
					mdAjaxActionResult.setRetCode(Errors.INTERNALERROR);
					mdAjaxActionResult.setErrorInfo(StringHelper.format("树节点[%1$s]标识无效", strTreeNodeId));
					return mdAjaxActionResult;
				}

				String strNodeType = strTreeNodeId.substring(0, nPos);
				strRealNodeId = strTreeNodeId.substring(nPos + 1);
				treeNode = this.getTreeModel().getTreeNodeModel(strNodeType);
			}
			//
			if (treeNode == null) {
				mdAjaxActionResult.setRetCode(Errors.INTERNALERROR);
				mdAjaxActionResult.setErrorInfo(StringHelper.format("无法获取树节点[%1$s]", strTreeNodeId));
				return mdAjaxActionResult;
			}

			int nCounterValue = getTreeNodeCounterValue(treeNode, strRealNodeId);
			JSONObject jo = new JSONObject();
			jo.put("srfkey",strTreeNodeId);
			jo.put("value",nCounterValue);
			
			mdAjaxActionResult.getRows().add(jo);
			
		}
		
		return mdAjaxActionResult;
	}

	/**
	 * 获取树节点计数器值
	 * 
	 * @param treeNode
	 * @param strRealNodeId
	 * @throws Exception
	 */
	protected int getTreeNodeCounterValue(ITreeNodeModel iTreeNodeModel, String strRealNodeId) throws Exception {
		String[] nodeids = strRealNodeId.split(ITreeNodeModel.TREENODE_SEPARATOR);
		String strKey = nodeids[0];

		if (iTreeNodeModel instanceof ITreeStaticNodeModel) {
			//ITreeStaticNodeModel iTreeStaticNodeModel = (ITreeStaticNodeModel)iTreeNodeModel;
			if(!StringHelper.isNullOrEmpty(iTreeNodeModel.getCounterId())) {
				if(getCounterHandler()!=null) {
					return getCounterHandler().getCounterItemValue(iTreeNodeModel.getCounterId(), ViewController.getCurrent(),WebContext.getCurrent());
				}
			}
			return 0;
		}
		
		if (iTreeNodeModel instanceof ITreeCodeListNodeModel) {
			//ITreeCodeListNodeModel iTreeCodeListNodeModel = (ITreeCodeListNodeModel)iTreeNodeModel;
			if(!StringHelper.isNullOrEmpty(iTreeNodeModel.getCounterId())) {
				if(getCounterHandler()!=null) {
					return getCounterHandler().getCounterItemValue(iTreeNodeModel.getCounterId(), ViewController.getCurrent(),WebContext.getCurrent());
				}
			}
			return 0;
		}
		
		
		if (iTreeNodeModel instanceof ITreeDEDataSetNodeModel) {
			ITreeDEDataSetNodeModel iTreeDEDataSetNodeModel = (ITreeDEDataSetNodeModel) iTreeNodeModel;
			IDataEntityModel iDEModel = DEModelGlobal.getDEModel(iTreeDEDataSetNodeModel.getDEName());
			String strDataAccessAction = DataAccessActions.READ;
			IEntity iEntity = getSimpleEntity(iDEModel, strKey);
			CallResult callResult = this.testDataAccessAction(iDEModel, iEntity, strDataAccessAction);
			if (!callResult.isOk()) {
				throw new ErrorException(Errors.ACCESSDENY, callResult.getErrorInfo());
			}
			
			int nCount = 0;
			if(!StringHelper.isNullOrEmpty(iTreeNodeModel.getCounterId())) {
				if(iEntity.contains(iTreeNodeModel.getCounterId())) {
					return DataObject.getIntegerValue(iEntity, iTreeNodeModel.getCounterId(), nCount);
				}
			}
			if(!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getChildCntField())) {
				if(iEntity.contains(iTreeDEDataSetNodeModel.getChildCntField())) {
					return DataObject.getIntegerValue(iEntity, iTreeDEDataSetNodeModel.getChildCntField(), nCount);
				}
			}
			return 0;
		}

		return 0;
	}
	
	/**
	 * 获取计数器处理对象
	 * @return
	 * @throws Exception
	 */
	protected ICounterHandler getCounterHandler() throws Exception {
		if(this.iCounterHandler == null) {
			if(!StringHelper.isNullOrEmpty(this.getTreeModel().getCounterId())) {
				this.iCounterHandler = CounterGlobal.getCounterHandler(this.getTreeModel().getCounterId());
			}
		}
		return this.iCounterHandler;
	}
}
