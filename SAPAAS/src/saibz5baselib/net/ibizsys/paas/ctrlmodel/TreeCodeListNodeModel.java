package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;

import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.control.tree.TreeNode;
import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringHelper;

/**
 * 代码表树节点模型
 * 
 * @author Administrator
 *
 */
public class TreeCodeListNodeModel extends TreeNodeModelBase implements ITreeCodeListNodeModel {
	private String strCodeListId = "";

	public void setCodeListId(String strCodeListId) {
		this.strCodeListId = strCodeListId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeCodeListNodeModel#getCodeListId()
	 */
	public String getCodeListId() {
		return this.strCodeListId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeNodeModel#getTreeNodeType()
	 */
	@Override
	public String getTreeNodeType() {
		return ITreeNodeModel.TREENODETYPE_CODELIST;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.TreeNodeModelBase#fillFetchResult(net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext, java.util.ArrayList)
	 */
	@Override
	public void fillFetchResult(ITreeNodeFetchContext iTreeNodeFetchContext, ArrayList<ITreeNode> treeNodeList) throws Exception {
		ICodeList iCodeList = CodeListGlobal.getCodeList(this.getCodeListId(), ViewController.getCurrent().getSessionFactory());

		// 判断是否指定了上级节点
		ICodeItem rootCodeItemConfig = iCodeList;
		if (rootCodeItemConfig.getCodeItems() == null) return;

		java.util.Iterator<ICodeItem> codeItems = rootCodeItemConfig.getCodeItems();
		while (codeItems.hasNext()) {
			ICodeItem iCodeItem = codeItems.next();
			String strNodeId = this.getId();
			strNodeId += ITreeNodeModel.TREENODE_SEPARATOR;
			strNodeId += iCodeItem.getValue();
			if (!StringHelper.isNullOrEmpty(iTreeNodeFetchContext.getRealNodeId())) {
				if (this.isAppendPNodeId()) {
					strNodeId += ITreeNodeModel.TREENODE_SEPARATOR;
					strNodeId += iTreeNodeFetchContext.getRealNodeId();
				}
			}

			TreeNode treeNodeConfig = new TreeNode();
			treeNodeConfig.setId(strNodeId);
			treeNodeConfig.setText(iCodeItem.getText());
			treeNodeConfig.setNodeDataType(this.getNodeDataType());

			if (!StringHelper.isNullOrEmpty(this.getIconCls())) {
				treeNodeConfig.setIconCssClass(this.getIconCls());
			} else {
				treeNodeConfig.setIcon(iCodeItem.getIconPath());
				treeNodeConfig.setIconCssClass(iCodeItem.getIconCls());
			}

			treeNodeConfig.setAsyncMode(true);
			treeNodeConfig.setLeaf(!this.hasTreeNodeRSModel());
			treeNodeConfig.setExpanded(this.isExpanded() || iTreeNodeFetchContext.isAutoExpand());
			treeNodeConfig.setEnableCheck(this.isEnableCheck());
			if (this.isEnableCheck()) treeNodeConfig.setChecked(this.isChecked());

			if (!StringHelper.isNullOrEmpty(this.getNodeType())) {
				treeNodeConfig.setTagValue("srfnodetype", this.getNodeType());
				treeNodeConfig.setTreeNodeType(this.getNodeType());
			}

			treeNodeConfig.setTagValue("srfkey", iCodeItem.getValue());
			treeNodeConfig.setTagValue("srfmajortext", iCodeItem.getText());

			treeNodeConfig.setDataSource(iCodeItem);
			treeNodeConfig.setCounterId(this.getCounterId());
			treeNodeConfig.setCounterMode(this.getCounterMode());
			treeNodeList.add(treeNodeConfig);
		}

	}

}
