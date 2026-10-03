/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlmodel.ITreeModel
 *  net.ibizsys.paas.ctrlmodel.ITreeNodeModel
 *  net.ibizsys.paas.ctrlmodel.ITreeNodeRSModel
 *  net.ibizsys.paas.ctrlmodel.TreeCodeListNodeModel
 *  net.ibizsys.paas.ctrlmodel.TreeDEDataSetNodeModel
 *  net.ibizsys.paas.ctrlmodel.TreeModelBase
 *  net.ibizsys.paas.ctrlmodel.TreeNodeRSModel
 *  net.ibizsys.paas.ctrlmodel.TreeStaticNodeModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.JIT.CtrlModel;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETree;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeCodeListNode;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeDataSetNode;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRS;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeStaticNode;
import SA.SRFDA.PS.Core.JIT.CtrlModel.IPSJITCtrlModel;
import java.util.Iterator;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlmodel.ITreeModel;
import net.ibizsys.paas.ctrlmodel.ITreeNodeModel;
import net.ibizsys.paas.ctrlmodel.ITreeNodeRSModel;
import net.ibizsys.paas.ctrlmodel.TreeCodeListNodeModel;
import net.ibizsys.paas.ctrlmodel.TreeDEDataSetNodeModel;
import net.ibizsys.paas.ctrlmodel.TreeModelBase;
import net.ibizsys.paas.ctrlmodel.TreeNodeModelBase;
import net.ibizsys.paas.ctrlmodel.TreeNodeRSModel;
import net.ibizsys.paas.ctrlmodel.TreeStaticNodeModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringHelper;

public class PSJITTreeModel
extends TreeModelBase
implements IPSJITCtrlModel {
    private IPSControl iPSControl = null;

    @Override
    public void init(IViewController iViewController, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iViewController);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    public IPSDETree getPSDETree() {
        return (IPSDETree)this.getPSControl();
    }

    public IDataEntityModel getDEModel() {
        try {
            if (this.getPSControl().getPSDataEntity() != null) {
                return this.getViewController().getSystemModel().getDataEntityModel(this.getPSControl().getPSDataEntity().getName());
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return super.getDEModel();
    }

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

    protected void onPrepareTreeMode() throws Exception {
        IPSDETree iPSDETree = this.getPSDETree();
        Iterator<IPSDETreeNode> psDETreeNodes = iPSDETree.getPSDETreeNodes();
        while (psDETreeNodes.hasNext()) {
            IPSDETreeNode iPSDETreeNode = psDETreeNodes.next();
            TreeNodeModelBase baseNode = null;
            if (StringHelper.compare((String)iPSDETreeNode.getTreeNodeType(), (String)"STATIC", (boolean)true) == 0) {
                IPSDETreeStaticNode treenode = (IPSDETreeStaticNode)iPSDETreeNode;
                TreeStaticNodeModel node = new TreeStaticNodeModel();
                node.setNodeValue(treenode.getNodeValue());
                baseNode = node;
            } else if (StringHelper.compare((String)iPSDETreeNode.getTreeNodeType(), (String)"CODELIST", (boolean)true) == 0) {
                IPSDETreeCodeListNode treenode = (IPSDETreeCodeListNode)iPSDETreeNode;
                TreeCodeListNodeModel node = new TreeCodeListNodeModel();
                node.setCodeListId(treenode.getCodeListId());
                baseNode = node;
            } else if (StringHelper.compare((String)iPSDETreeNode.getTreeNodeType(), (String)"DE", (boolean)true) == 0) {
                IPSDETreeDataSetNode treenode = (IPSDETreeDataSetNode)iPSDETreeNode;
                TreeDEDataSetNodeModel node = new TreeDEDataSetNodeModel();
                node.setDEName(treenode.getPSDataEntity().getName());
                node.setDEDataSetName(treenode.getDEDataSetName());
                if (!StringHelper.isNullOrEmpty((String)treenode.getFilterDEDataSetName())) {
                    node.setFilterDEDataSetName(treenode.getFilterDEDataSetName());
                }
                if (!StringHelper.isNullOrEmpty((String)treenode.getIdField())) {
                    node.setIdField(treenode.getIdField());
                }
                if (!StringHelper.isNullOrEmpty((String)treenode.getTextField())) {
                    node.setTextField(treenode.getTextField());
                }
                if (!StringHelper.isNullOrEmpty((String)treenode.getIconField())) {
                    node.setIconField(treenode.getIconField());
                }
                if (!StringHelper.isNullOrEmpty((String)treenode.getSortField())) {
                    node.setSortField(treenode.getSortField());
                }
                if (!StringHelper.isNullOrEmpty((String)treenode.getSortDir())) {
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
            if (!StringHelper.isNullOrEmpty((String)iPSDETreeNode.getIconCls())) {
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
            if (!StringHelper.isNullOrEmpty((String)iPSDETreeNode.getNodeType())) {
                baseNode.setNodeType(iPSDETreeNode.getNodeType());
            }
            baseNode.init((ITreeModel)this);
            Iterator<IPSDETreeNodeRS> psDETreeNodeRSs = iPSDETree.getPSDETreeNodeRSs();
            while (psDETreeNodeRSs.hasNext()) {
                IPSDETreeNodeRS rs = psDETreeNodeRSs.next();
                if (StringHelper.compare((String)rs.getParentTreeNodeId(), (String)iPSDETreeNode.getId(), (boolean)false) != 0) continue;
                TreeNodeRSModel treeNodeRSModel = new TreeNodeRSModel();
                treeNodeRSModel.setParentTreeNodeId(rs.getParentTreeNodeId());
                treeNodeRSModel.setChildTreeNodeId(rs.getChildTreeNodeId());
                if (rs.getPSDEAction() != null) {
                    treeNodeRSModel.setDEActionName(rs.getPSDEAction().getName());
                }
                treeNodeRSModel.init((ITreeModel)this);
                baseNode.registerTreeNodeRSModel((ITreeNodeRSModel)treeNodeRSModel);
            }
            this.registerTreeNodeModel((ITreeNodeModel)baseNode);
        }
    }
}
