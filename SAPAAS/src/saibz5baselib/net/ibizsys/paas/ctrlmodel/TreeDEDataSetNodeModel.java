package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;

import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.control.tree.ITreeNodeDataItem;
import net.ibizsys.paas.control.tree.TreeNode;
import net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;

/**
 * 实体数据集合树节点模型
 * 
 * @author Administrator
 * 
 */
public class TreeDEDataSetNodeModel extends TreeNodeModelBase implements ITreeDEDataSetNodeModel {

	
	private String strDEDataSetName = "";

	private String strFilterDEDataSetName = "";

	private String strIdField = "";

	private String strTextField = "";

	private String strIconField = "";

	private String strSortField = "";

	private String strSortDir = "";

	private boolean bDistinctMode = false;

	private String strChildCntField = "";

	private String strRemoveDEActionName = "";

	private String strRemoveDataAccessAction = "";
	
	private String strActiveDataDELogicId = null;
	
	private String strDataTypeField = "";
	
	private String strLeafFlagField = "";
	
	private int nMaxSize = -1; 

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeNodeModel#getTreeNodeType()
	 */
	@Override
	public String getTreeNodeType() {
		return ITreeNodeModel.TREENODETYPE_DE;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeDEDataSetNodeModel#getDEDataSetName()
	 */
	@Override
	public String getDEDataSetName() {
		return this.strDEDataSetName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeDEDataSetNodeModel#getFilterDEDataSetName()
	 */
	@Override
	public String getFilterDEDataSetName() {
		return this.strFilterDEDataSetName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeDEDataSetNodeModel#getIdField()
	 */
	@Override
	public String getIdField() {
		return this.strIdField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeDEDataSetNodeModel#getTextField()
	 */
	@Override
	public String getTextField() {
		return this.strTextField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeDEDataSetNodeModel#getIconField()
	 */
	@Override
	public String getIconField() {
		return strIconField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeDEDataSetNodeModel#getSortField()
	 */
	@Override
	public String getSortField() {
		return strSortField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeDEDataSetNodeModel#getSortDir()
	 */
	@Override
	public String getSortDir() {
		return this.strSortDir;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeDEDataSetNodeModel#isDistinctMode()
	 */
	@Override
	public boolean isDistinctMode() {
		return this.bDistinctMode;
	}



	/**
	 * 设置实体结果集合名称
	 * 
	 * @param strDEDataSetName the strDEDataSetName to set
	 */
	public void setDEDataSetName(String strDEDataSetName) {
		this.strDEDataSetName = strDEDataSetName;
	}

	/**
	 * 设置实体过滤结果集合名称
	 * 
	 * @param strFilterDEDataSetName the strFilterDEDataSetName to set
	 */
	public void setFilterDEDataSetName(String strFilterDEDataSetName) {
		this.strFilterDEDataSetName = strFilterDEDataSetName;
	}

	/**
	 * 设置树节点标识值属性
	 * 
	 * @param strIdField the strIdField to set
	 */
	public void setIdField(String strIdField) {
		this.strIdField = strIdField;
	}

	/**
	 * 设置树节点文本值属性
	 * 
	 * @param strTextField the strTextField to set
	 */
	public void setTextField(String strTextField) {
		this.strTextField = strTextField;
	}

	/**
	 * 设置树节点图标属性
	 * 
	 * @param strIconField the strIconField to set
	 */
	public void setIconField(String strIconField) {
		this.strIconField = strIconField;
	}

	/**
	 * 设置默认排序方向
	 * 
	 * @param strSortDir the strSortDir to set
	 */
	public void setSortDir(String strSortDir) {
		this.strSortDir = strSortDir;
	}

	/**
	 * 设置默认排序属性
	 * 
	 * @param strSortField the strSortField to set
	 */
	public void setSortField(String strSortField) {
		this.strSortField = strSortField;
	}

	/**
	 * 设置唯一化数据
	 * 
	 * @param bDistinctMode the bDistinctMode to set
	 */
	public void setDistinctMode(boolean bDistinctMode) {
		this.bDistinctMode = bDistinctMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.TreeNodeModelBase#fillFetchResult(net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext, java.util.ArrayList, net.ibizsys.paas.db.IDataTable)
	 */
	@Override
	public void fillFetchResult(ITreeNodeFetchContext iTreeNodeFetchContext, ArrayList<ITreeNode> treeNodeList, IDataTable dt) throws Exception {
		fillFetchResult(this, iTreeNodeFetchContext, treeNodeList, dt);
	}

	/**
	 * 填充结果返回对象
	 * 
	 * @param iTreeDEDataSetNodeModel
	 * @param iTreeNodeFetchContext
	 * @param treeNodeList
	 * @param dt
	 * @throws Exception
	 */
	public static void fillFetchResult(ITreeDEDataSetNodeModel iTreeDEDataSetNodeModel, ITreeNodeFetchContext iTreeNodeFetchContext, ArrayList<ITreeNode> treeNodeList, IDataTable dt) throws Exception {
		IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(iTreeDEDataSetNodeModel.getDEName());
		String strIdField = iDataEntityModel.getKeyDEField().getName();
		if (!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getIdField())) {
			strIdField = iDataEntityModel.getDEField(iTreeDEDataSetNodeModel.getIdField(), false).getName();
		}
		String strTextField = iDataEntityModel.getMajorDEField().getName();
		if (!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getTextField())) {
			strTextField = iDataEntityModel.getDEField(iTreeDEDataSetNodeModel.getTextField(), false).getName();
		}
		String strIconField = "";
		if (!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getIconField())) {
			strIconField = iDataEntityModel.getDEField(iTreeDEDataSetNodeModel.getIconField(), false).getName();
		}

		String strChildCntField = "";
		if (!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getChildCntField())) {
			strChildCntField = iDataEntityModel.getDEField(iTreeDEDataSetNodeModel.getChildCntField(), false).getName();
		}
		
		String strDataTypeField = "";
		if (!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getDataTypeField())) {
			strDataTypeField = iDataEntityModel.getDEField(iTreeDEDataSetNodeModel.getDataTypeField(), false).getName();
		}
		
		String strLeafFlagField = "";
		if (!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getLeafFlagField())) {
			strLeafFlagField = iDataEntityModel.getDEField(iTreeDEDataSetNodeModel.getLeafFlagField(), false).getName();
		}

		if (dt.getCachedRowCount() == -1) {
			while (true) {
				IDataRow iDataRow = dt.next();
				if (iDataRow == null) break;

				TreeNode treeNode = new TreeNode();
				fillTreeNode(treeNode, iTreeDEDataSetNodeModel, iTreeNodeFetchContext, iDataRow, strIdField, strTextField, strIconField, strChildCntField, strDataTypeField,strLeafFlagField);
				treeNodeList.add(treeNode);
			}
		} else {
			int nRows = dt.getCachedRowCount();
			for (int i = 0; i < nRows; i++) {
				IDataRow iDataRow = dt.getCachedRow(i);
				TreeNode treeNode = new TreeNode();
				fillTreeNode(treeNode, iTreeDEDataSetNodeModel, iTreeNodeFetchContext, iDataRow, strIdField, strTextField, strIconField, strChildCntField, strDataTypeField,strLeafFlagField);
				treeNodeList.add(treeNode);
			}
		}

	}

	
	/**
	 * 填充树节点数据对象
	 * @param treeNode
	 * @param iTreeDEDataSetNodeModel
	 * @param iTreeNodeFetchContext
	 * @param iDataRow
	 * @param strIdField
	 * @param strTextField
	 * @param strIconField
	 * @param strChildCntField
	 * @throws Exception
	 */
	public static void fillTreeNode(TreeNode treeNode, ITreeDEDataSetNodeModel iTreeDEDataSetNodeModel, ITreeNodeFetchContext iTreeNodeFetchContext, IDataRow iDataRow, String strIdField, String strTextField, String strIconField, String strChildCntField) throws Exception {
		fillTreeNode(treeNode, iTreeDEDataSetNodeModel, iTreeNodeFetchContext, iDataRow, strIdField, strTextField, strIconField, strChildCntField,"");
	}
	
	
	/**
	 * 填充树节点对象
	 * 
	 * @param treeNode
	 * @param iTreeDEDataSetNodeModel
	 * @param iTreeNodeFetchContext
	 * @param iDataRow
	 * @param strIdField
	 * @param strTextField
	 * @param strIconField
	 * @param strChildCntField
	 * @param strDataTypeField 
	 * @throws Exception
	 */
	public static void fillTreeNode(TreeNode treeNode, ITreeDEDataSetNodeModel iTreeDEDataSetNodeModel, ITreeNodeFetchContext iTreeNodeFetchContext, IDataRow iDataRow, String strIdField, String strTextField, String strIconField, String strChildCntField,String strDataTypeField) throws Exception {
		fillTreeNode(treeNode, iTreeDEDataSetNodeModel, iTreeNodeFetchContext, iDataRow, strIdField, strTextField, strIconField, strChildCntField,strDataTypeField,"");
	}
	
	/**
	 * 填充树节点对象
	 * 
	 * @param treeNode
	 * @param iTreeDEDataSetNodeModel
	 * @param iTreeNodeFetchContext
	 * @param iDataRow
	 * @param strIdField
	 * @param strTextField
	 * @param strIconField
	 * @param strChildCntField
	 * @param strLeafFlagField
	 * @throws Exception
	 */
	public static void fillTreeNode(TreeNode treeNode, ITreeDEDataSetNodeModel iTreeDEDataSetNodeModel, ITreeNodeFetchContext iTreeNodeFetchContext, IDataRow iDataRow, String strIdField, String strTextField, String strIconField, String strChildCntField,String strDataTypeField,String strLeafFlagField) throws Exception {
		String strNodeId = iTreeDEDataSetNodeModel.getId();
		strNodeId += ITreeNodeModel.TREENODE_SEPARATOR;
		strNodeId += iDataRow.get(strIdField);
		if (!StringHelper.isNullOrEmpty(iTreeNodeFetchContext.getRealNodeId())) {
			if (iTreeDEDataSetNodeModel.isAppendPNodeId()) {
				strNodeId += ITreeNodeModel.TREENODE_SEPARATOR;
				strNodeId += iTreeNodeFetchContext.getRealNodeId();
			}
		}

		treeNode.setId(strNodeId);
		treeNode.setText((String) iDataRow.get(strTextField));
		String strNodeDataType = "";
		if (!StringHelper.isNullOrEmpty(strDataTypeField)) {
			strNodeDataType = (String) iDataRow.get(strDataTypeField);
		}
		if(StringHelper.isNullOrEmpty(strNodeDataType)){
			strNodeDataType = iTreeDEDataSetNodeModel.getNodeDataType();
		}
		treeNode.setNodeDataType(strNodeDataType);
		if (!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getIconCls())) {
			treeNode.setIconCssClass(iTreeDEDataSetNodeModel.getIconCls());
		} else {
			String strIconPath = "";
			if (!StringHelper.isNullOrEmpty(strIconField)) {
				strIconPath = (String) iDataRow.get(strIconField);
			}
			if(StringHelper.isNullOrEmpty(strIconPath)){
				strIconPath = iTreeDEDataSetNodeModel.getIconPath();
			}
			if(!StringHelper.isNullOrEmpty(strIconPath)){
				treeNode.setIcon(iTreeDEDataSetNodeModel.getTreeModel().getViewController().getAppModel().getAppPFHelper().mapImageRealUrl(strIconPath));
			}
		}

		treeNode.setAsyncMode(true);
		if (StringHelper.isNullOrEmpty(strChildCntField)) {
			treeNode.setLeaf(!iTreeDEDataSetNodeModel.hasTreeNodeRSModel());
		} else {
			int nChildCount = DataObject.getIntegerValue(iDataRow.get(strChildCntField), 0);
			treeNode.setLeaf(nChildCount == 0);
		}
		
		if(!StringHelper.isNullOrEmpty(strLeafFlagField)){
			int nLeafFlag = DataObject.getIntegerValue(iDataRow.get(strLeafFlagField), 0);
			treeNode.setLeaf(nLeafFlag == 1);
		}

		treeNode.setExpanded(iTreeDEDataSetNodeModel.isExpanded() || iTreeNodeFetchContext.isAutoExpand());
		treeNode.setEnableCheck(iTreeDEDataSetNodeModel.isEnableCheck());
		if (iTreeDEDataSetNodeModel.isEnableCheck()) treeNode.setChecked(iTreeDEDataSetNodeModel.isChecked());

		if (!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getNodeType())) {
			treeNode.setTagValue("srfnodetype", iTreeDEDataSetNodeModel.getNodeType());
			treeNode.setTreeNodeType(iTreeDEDataSetNodeModel.getNodeType());
		}

		treeNode.setTagValue("srfkey", iDataRow.get(strIdField));
		treeNode.setTagValue("srfmajortext", iDataRow.get(strTextField));
		
		java.util.Iterator<ITreeNodeDataItem> treeNodeDataItems = iTreeDEDataSetNodeModel.getTreeNodeDataItems();
		if(treeNodeDataItems!=null){
			while(treeNodeDataItems.hasNext()){
				ITreeNodeDataItem iTreeNodeDataItem = treeNodeDataItems.next();
				Object objValue = iTreeNodeDataItem.getValue(WebContext.getCurrent(), iDataRow);
				treeNode.setTagValue(iTreeNodeDataItem.getName(), objValue);
			}
		}
		treeNode.setDataSource(iDataRow);
		
		treeNode.setCounterId(iTreeDEDataSetNodeModel.getCounterId());
		treeNode.setCounterMode(iTreeDEDataSetNodeModel.getCounterMode());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeDEDataSetNodeModel#getChildCntField()
	 */
	@Override
	public String getChildCntField() {
		return this.strChildCntField;
	}

	/**
	 * 设置子节点数量字段
	 * 
	 * @param strChildCntField
	 */
	public void setChildCntField(String strChildCntField) {
		this.strChildCntField = strChildCntField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeDEDataSetNodeModel#getRemoveDEActionName()
	 */
	@Override
	public String getRemoveDEActionName() {
		return this.strRemoveDEActionName;
	}

	/**
	 * 设置删除实体行为名称
	 * 
	 * @param strRemoveDEActionName
	 */
	public void setRemoveDEActionName(String strRemoveDEActionName) {
		this.strRemoveDEActionName = strRemoveDEActionName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeDEDataSetNodeModel#getRemoveDataAccessAction()
	 */
	@Override
	public String getRemoveDataAccessAction() {
		return strRemoveDataAccessAction;
	}

	/**
	 * 设置删除行为的数据访问行为
	 * 
	 * @param strRemoveDataAccessAction
	 */
	public void setRemoveDataAccessAction(String strRemoveDataAccessAction) {
		this.strRemoveDataAccessAction = strRemoveDataAccessAction;
	}

	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlmodel.ITreeDEDataSetNodeModel#getActiveDataDELogicId()
	 */
	@Override
	public String getActiveDataDELogicId() {
		return this.strActiveDataDELogicId;
	}
	
	/**
	 * 设置上下文数据计算逻辑
	 * @param strActiveDataDELogicId
	 */
	public void setActiveDataDELogicId(String strActiveDataDELogicId){
		this.strActiveDataDELogicId = strActiveDataDELogicId;
	}


	/**
	 * @return
	 */
	@Override
	public String getDataTypeField() {
		return this.strDataTypeField;
	}
	
	
	/**
	 * 设置数据类型标记属性
	 * @param strDataTypeField
	 */
	public void setDataTypeField(String strDataTypeField){
		this.strDataTypeField = strDataTypeField;
	}


	@Override
	public String getLeafFlagField() {
		return this.strLeafFlagField;
	}
	
	
	/**
	 * 设置页节点标记属性
	 * @param strLeafFlagField
	 */
	public void setLeafFlagField(String strLeafFlagField){
		this.strLeafFlagField = strLeafFlagField;
	}


	@Override
	public int getMaxSize() {
		return this.nMaxSize;
	}
	
	/**
	 * 设置最大节点数
	 * @param nMaxSize
	 */
	public void setMaxSize(int nMaxSize){
		this.nMaxSize = nMaxSize;
	}
	
	
	
	
}
