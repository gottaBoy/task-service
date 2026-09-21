/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.control.tree.ITreeNodeDataItem;
import net.ibizsys.paas.control.tree.TreeNode;
import net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext;
import net.ibizsys.paas.ctrlmodel.ITreeDEDataSetNodeModel;
import net.ibizsys.paas.ctrlmodel.TreeNodeModelBase;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;

public class TreeDEDataSetNodeModel
extends TreeNodeModelBase
implements ITreeDEDataSetNodeModel {
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

    @Override
    public String getTreeNodeType() {
        return "DE";
    }

    @Override
    public String getDEDataSetName() {
        return this.strDEDataSetName;
    }

    @Override
    public String getFilterDEDataSetName() {
        return this.strFilterDEDataSetName;
    }

    @Override
    public String getIdField() {
        return this.strIdField;
    }

    @Override
    public String getTextField() {
        return this.strTextField;
    }

    @Override
    public String getIconField() {
        return this.strIconField;
    }

    @Override
    public String getSortField() {
        return this.strSortField;
    }

    @Override
    public String getSortDir() {
        return this.strSortDir;
    }

    @Override
    public boolean isDistinctMode() {
        return this.bDistinctMode;
    }

    public void setDEDataSetName(String strDEDataSetName) {
        this.strDEDataSetName = strDEDataSetName;
    }

    public void setFilterDEDataSetName(String strFilterDEDataSetName) {
        this.strFilterDEDataSetName = strFilterDEDataSetName;
    }

    public void setIdField(String strIdField) {
        this.strIdField = strIdField;
    }

    public void setTextField(String strTextField) {
        this.strTextField = strTextField;
    }

    public void setIconField(String strIconField) {
        this.strIconField = strIconField;
    }

    public void setSortDir(String strSortDir) {
        this.strSortDir = strSortDir;
    }

    public void setSortField(String strSortField) {
        this.strSortField = strSortField;
    }

    public void setDistinctMode(boolean bDistinctMode) {
        this.bDistinctMode = bDistinctMode;
    }

    @Override
    public void fillFetchResult(ITreeNodeFetchContext iTreeNodeFetchContext, ArrayList<ITreeNode> treeNodeList, IDataTable dt) throws Exception {
        TreeDEDataSetNodeModel.fillFetchResult(this, iTreeNodeFetchContext, treeNodeList, dt);
    }

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
            IDataRow iDataRow;
            while ((iDataRow = dt.next()) != null) {
                TreeNode treeNode = new TreeNode();
                TreeDEDataSetNodeModel.fillTreeNode(treeNode, iTreeDEDataSetNodeModel, iTreeNodeFetchContext, iDataRow, strIdField, strTextField, strIconField, strChildCntField, strDataTypeField, strLeafFlagField);
                treeNodeList.add(treeNode);
            }
        } else {
            int nRows = dt.getCachedRowCount();
            int i = 0;
            while (i < nRows) {
                IDataRow iDataRow = dt.getCachedRow(i);
                TreeNode treeNode = new TreeNode();
                TreeDEDataSetNodeModel.fillTreeNode(treeNode, iTreeDEDataSetNodeModel, iTreeNodeFetchContext, iDataRow, strIdField, strTextField, strIconField, strChildCntField, strDataTypeField, strLeafFlagField);
                treeNodeList.add(treeNode);
                ++i;
            }
        }
    }

    public static void fillTreeNode(TreeNode treeNode, ITreeDEDataSetNodeModel iTreeDEDataSetNodeModel, ITreeNodeFetchContext iTreeNodeFetchContext, IDataRow iDataRow, String strIdField, String strTextField, String strIconField, String strChildCntField) throws Exception {
        TreeDEDataSetNodeModel.fillTreeNode(treeNode, iTreeDEDataSetNodeModel, iTreeNodeFetchContext, iDataRow, strIdField, strTextField, strIconField, strChildCntField, "");
    }

    public static void fillTreeNode(TreeNode treeNode, ITreeDEDataSetNodeModel iTreeDEDataSetNodeModel, ITreeNodeFetchContext iTreeNodeFetchContext, IDataRow iDataRow, String strIdField, String strTextField, String strIconField, String strChildCntField, String strDataTypeField) throws Exception {
        TreeDEDataSetNodeModel.fillTreeNode(treeNode, iTreeDEDataSetNodeModel, iTreeNodeFetchContext, iDataRow, strIdField, strTextField, strIconField, strChildCntField, strDataTypeField, "");
    }

    public static void fillTreeNode(TreeNode treeNode, ITreeDEDataSetNodeModel iTreeDEDataSetNodeModel, ITreeNodeFetchContext iTreeNodeFetchContext, IDataRow iDataRow, String strIdField, String strTextField, String strIconField, String strChildCntField, String strDataTypeField, String strLeafFlagField) throws Exception {
        String strNodeId = iTreeDEDataSetNodeModel.getId();
        strNodeId = String.valueOf(strNodeId) + ";";
        strNodeId = String.valueOf(strNodeId) + iDataRow.get(strIdField);
        if (!StringHelper.isNullOrEmpty(iTreeNodeFetchContext.getRealNodeId()) && iTreeDEDataSetNodeModel.isAppendPNodeId()) {
            strNodeId = String.valueOf(strNodeId) + ";";
            strNodeId = String.valueOf(strNodeId) + iTreeNodeFetchContext.getRealNodeId();
        }
        treeNode.setId(strNodeId);
        treeNode.setText((String)iDataRow.get(strTextField));
        String strNodeDataType = "";
        if (!StringHelper.isNullOrEmpty(strDataTypeField)) {
            strNodeDataType = (String)iDataRow.get(strDataTypeField);
        }
        if (StringHelper.isNullOrEmpty(strNodeDataType)) {
            strNodeDataType = iTreeDEDataSetNodeModel.getNodeDataType();
        }
        treeNode.setNodeDataType(strNodeDataType);
        if (!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getIconCls())) {
            treeNode.setIconCssClass(iTreeDEDataSetNodeModel.getIconCls());
        } else {
            String strIconPath = "";
            if (!StringHelper.isNullOrEmpty(strIconField)) {
                strIconPath = (String)iDataRow.get(strIconField);
            }
            if (StringHelper.isNullOrEmpty(strIconPath)) {
                strIconPath = iTreeDEDataSetNodeModel.getIconPath();
            }
            if (!StringHelper.isNullOrEmpty(strIconPath)) {
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
        if (!StringHelper.isNullOrEmpty(strLeafFlagField)) {
            int nLeafFlag = DataObject.getIntegerValue(iDataRow.get(strLeafFlagField), 0);
            treeNode.setLeaf(nLeafFlag == 1);
        }
        treeNode.setExpanded(iTreeDEDataSetNodeModel.isExpanded() || iTreeNodeFetchContext.isAutoExpand());
        treeNode.setEnableCheck(iTreeDEDataSetNodeModel.isEnableCheck());
        if (iTreeDEDataSetNodeModel.isEnableCheck()) {
            treeNode.setChecked(iTreeDEDataSetNodeModel.isChecked());
        }
        if (!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getNodeType())) {
            treeNode.setTagValue("srfnodetype", iTreeDEDataSetNodeModel.getNodeType());
            treeNode.setTreeNodeType(iTreeDEDataSetNodeModel.getNodeType());
        }
        treeNode.setTagValue("srfkey", iDataRow.get(strIdField));
        treeNode.setTagValue("srfmajortext", iDataRow.get(strTextField));
        Iterator<ITreeNodeDataItem> treeNodeDataItems = iTreeDEDataSetNodeModel.getTreeNodeDataItems();
        if (treeNodeDataItems != null) {
            while (treeNodeDataItems.hasNext()) {
                ITreeNodeDataItem iTreeNodeDataItem = treeNodeDataItems.next();
                Object objValue = iTreeNodeDataItem.getValue(WebContext.getCurrent(), iDataRow);
                treeNode.setTagValue(iTreeNodeDataItem.getName(), objValue);
            }
        }
        treeNode.setDataSource(iDataRow);
        treeNode.setCounterId(iTreeDEDataSetNodeModel.getCounterId());
        treeNode.setCounterMode(iTreeDEDataSetNodeModel.getCounterMode());
    }

    @Override
    public String getChildCntField() {
        return this.strChildCntField;
    }

    public void setChildCntField(String strChildCntField) {
        this.strChildCntField = strChildCntField;
    }

    @Override
    public String getRemoveDEActionName() {
        return this.strRemoveDEActionName;
    }

    public void setRemoveDEActionName(String strRemoveDEActionName) {
        this.strRemoveDEActionName = strRemoveDEActionName;
    }

    @Override
    public String getRemoveDataAccessAction() {
        return this.strRemoveDataAccessAction;
    }

    public void setRemoveDataAccessAction(String strRemoveDataAccessAction) {
        this.strRemoveDataAccessAction = strRemoveDataAccessAction;
    }

    @Override
    public String getActiveDataDELogicId() {
        return this.strActiveDataDELogicId;
    }

    public void setActiveDataDELogicId(String strActiveDataDELogicId) {
        this.strActiveDataDELogicId = strActiveDataDELogicId;
    }

    @Override
    public String getDataTypeField() {
        return this.strDataTypeField;
    }

    public void setDataTypeField(String strDataTypeField) {
        this.strDataTypeField = strDataTypeField;
    }

    @Override
    public String getLeafFlagField() {
        return this.strLeafFlagField;
    }

    public void setLeafFlagField(String strLeafFlagField) {
        this.strLeafFlagField = strLeafFlagField;
    }

    @Override
    public int getMaxSize() {
        return this.nMaxSize;
    }

    public void setMaxSize(int nMaxSize) {
        this.nMaxSize = nMaxSize;
    }
}

