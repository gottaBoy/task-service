package net.ibizsys.ssdyna.ctrlmodel;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.tree.IPSDETree;
import net.ibizsys.model.control.tree.IPSDETreeCodeListNode;
import net.ibizsys.model.control.tree.IPSDETreeDataSetNode;
import net.ibizsys.model.control.tree.IPSDETreeNode;
import net.ibizsys.model.control.tree.IPSDETreeNodeRS;
import net.ibizsys.model.control.tree.IPSDETreeStaticNode;
import net.ibizsys.paas.ctrlmodel.TreeCodeListNodeModel;
import net.ibizsys.paas.ctrlmodel.TreeDEDataSetNodeModel;
import net.ibizsys.paas.ctrlmodel.TreeModelBase;
import net.ibizsys.paas.ctrlmodel.TreeNodeModelBase;
import net.ibizsys.paas.ctrlmodel.TreeNodeRSModel;
import net.ibizsys.paas.ctrlmodel.TreeStaticNodeModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.view.IDynaViewModel;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * JIT 树模型
 * @author Administrator
 *
 */
public class DynaTreeModel extends TreeModelBase implements IDynaCtrlModel {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DynaTreeModel.class);
	private IPSControl iPSControl = null;

	@Override
	public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
		this.iPSControl = iPSControl;
		this.init(iDynaViewModel);
	}

	@Override
	public IPSControl getPSControl() {
		return this.iPSControl;
	}

	public IPSDETree getPSDETree() {
		return (IPSDETree) getPSControl();
	}

	@Override
	public IDataEntityModel getDEModel() {
		try {
			if (getPSControl().getPSDataEntity() != null) {
				return ((IDynaViewModel)this.getViewController()).getDynaSysModel().getDynaDEModel(getPSControl().getPSDataEntity().getId());
			}
		} catch (Exception ex) {
			log.error(ex);
		}
		return super.getDEModel();
	}
	

	@Override
	protected void onInit() throws Exception {

		IPSDETree iPSDETree = this.getPSDETree();
		if (iPSDETree.isEnableRootSelect()) {
			this.setEnableRootSelect(true);
		}
		if (iPSDETree.isRootVisible()) {
			this.setRootVisible(true);
		}
		if (iPSDETree.getCatPSCodeList() != null) {
			this.setCatCodeListId(iPSDETree.getCatPSCodeList().getId());
		}
		super.onInit();
	}

	/**
	 * 准备树模型
	 * 
	 * @throws Exception
	 */
	@Override
	protected void onPrepareTreeMode() throws Exception {
		IPSDETree iPSDETree = this.getPSDETree();
		java.util.Iterator<IPSDETreeNode> psDETreeNodes = iPSDETree.getPSDETreeNodes();
		while (psDETreeNodes.hasNext()) {
			IPSDETreeNode iPSDETreeNode = psDETreeNodes.next();
			TreeNodeModelBase baseNode = null;
			if (StringHelper.compare(iPSDETreeNode.getTreeNodeType(), "STATIC", true) == 0) {
				IPSDETreeStaticNode treenode = (IPSDETreeStaticNode) iPSDETreeNode;
				TreeStaticNodeModel node = new TreeStaticNodeModel();
				node.setNodeValue(treenode.getNodeValue());
				baseNode = node;
			} else if (StringHelper.compare(iPSDETreeNode.getTreeNodeType(), "CODELIST", true) == 0) {
				IPSDETreeCodeListNode treenode = (IPSDETreeCodeListNode) iPSDETreeNode;
				TreeCodeListNodeModel node = new TreeCodeListNodeModel();
				node.setCodeListId(treenode.getCodeListId());
				baseNode = node;
			} else if (StringHelper.compare(iPSDETreeNode.getTreeNodeType(), "DE", true) == 0) {
				IPSDETreeDataSetNode treenode = (IPSDETreeDataSetNode) iPSDETreeNode;
				TreeDEDataSetNodeModel node = new TreeDEDataSetNodeModel();
				// ${treenode.getDEName()}
				node.setDEName(treenode.getPSDataEntity().getName());
				node.setDEDataSetName(treenode.getDEDataSetName());
				if (!StringHelper.isNullOrEmpty(treenode.getFilterDEDataSetName())) {
					node.setFilterDEDataSetName(treenode.getFilterDEDataSetName());
				}
				if (!StringHelper.isNullOrEmpty(treenode.getIdField())) {
					node.setIdField(treenode.getIdField());
				}
				if (!StringHelper.isNullOrEmpty(treenode.getTextField())) {
					node.setTextField(treenode.getTextField());
				}
				if (!StringHelper.isNullOrEmpty(treenode.getIconField())) {
					node.setIconField(treenode.getIconField());
				}
				if (!StringHelper.isNullOrEmpty(treenode.getSortField())) {
					node.setSortField(treenode.getSortField());
				}
				if (!StringHelper.isNullOrEmpty(treenode.getSortDir())) {
					node.setSortDir(treenode.getSortDir());
				}
				baseNode = node;
			}

			baseNode.setId(iPSDETreeNode.getId());
			baseNode.setName(iPSDETreeNode.getName());
			if (iPSDETreeNode.isRootNode()) {
				baseNode.setRootNode(true);
			}
			if (iPSDETreeNode.isAppendPNodeId()) {
				baseNode.setAppendPNodeId(true);
			}
			if (!StringHelper.isNullOrEmpty(iPSDETreeNode.getIconCls())) {
				baseNode.setIconCls(iPSDETreeNode.getIconCls());
			}
			if (iPSDETreeNode.isExpanded()) {
				baseNode.setExpanded(true);
			}
			if (iPSDETreeNode.isEnableCheck()) {
				baseNode.setEnableCheck(true);
			}
			if (iPSDETreeNode.isChecked()) {
				baseNode.setChecked(true);
			}
			if (!StringHelper.isNullOrEmpty(iPSDETreeNode.getNodeType())) {
				baseNode.setNodeType(iPSDETreeNode.getNodeType());
			}
			baseNode.init(this);
			java.util.Iterator<IPSDETreeNodeRS> psDETreeNodeRSs = iPSDETree.getPSDETreeNodeRSs();
			while (psDETreeNodeRSs.hasNext()) {
				IPSDETreeNodeRS rs = psDETreeNodeRSs.next();
				if (StringHelper.compare(rs.getParentTreeNodeId(), iPSDETreeNode.getId(), false) == 0) {
					TreeNodeRSModel treeNodeRSModel = new TreeNodeRSModel();
					treeNodeRSModel.setParentTreeNodeId(rs.getParentTreeNodeId());
					treeNodeRSModel.setChildTreeNodeId(rs.getChildTreeNodeId());
					if (rs.getPSDEAction() != null) {
						treeNodeRSModel.setDEActionName(rs.getPSDEAction().getName());
					}
					treeNodeRSModel.init(this);
					baseNode.registerTreeNodeRSModel(treeNodeRSModel);
				}
			}

			registerTreeNodeModel(baseNode);
			continue;
		}
	}

	@Override
	public ObjectNode toJsonObject(ObjectNode objectNode) throws Exception {
		if(objectNode == null){
			objectNode = JsonNodeHelper.createObjectNode();
		}
		onFillJsonObject(objectNode);
		return objectNode;
	}
	
	protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
		if(getPSControl()!=null){
			DynaCtrlModelBase.toJsonObject(objectNode,getPSControl());
		}
	}
	
	@Override
	public boolean isDynaCtrl() {
		if(this.getPSControl()!=null){
			return this.getPSControl().isDynamicCtrl();
		}
		return false;
	}
}
