/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.control.tree.ITreeNodeDataItem;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext;
import net.ibizsys.paas.ctrlmodel.ITreeModel;
import net.ibizsys.paas.ctrlmodel.ITreeNodeModel;
import net.ibizsys.paas.ctrlmodel.ITreeNodeRSModel;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.util.StringHelper;

public abstract class TreeNodeModelBase
extends ModelBaseImpl
implements ITreeNodeModel {
    private ArrayList<ITreeNodeRSModel> treeNodeRSModelList = new ArrayList();
    protected ArrayList<ITreeNodeDataItem> treeNodeDataItemList = new ArrayList();
    protected HashMap<String, ITreeNodeDataItem> treeNodeDataItemMap = new HashMap();
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
    private int nCounterMode = 0;
    private String strCounterId = "";
    private String strNodeDataType = "";
    private boolean bEnableQuickSearch = false;

    public void init(ITreeModel iTreeModel) throws Exception {
        this.iTreeModel = iTreeModel;
        this.onInit();
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public ITreeModel getTreeModel() {
        return this.iTreeModel;
    }

    public void registerTreeNodeRSModel(ITreeNodeRSModel iTreeNodeTypeRSModel) {
        this.treeNodeRSModelList.add(iTreeNodeTypeRSModel);
    }

    @Override
    public Iterator<ITreeNodeRSModel> getTreeNodeRSModels() {
        return this.treeNodeRSModelList.iterator();
    }

    @Override
    public boolean hasTreeNodeRSModel() {
        return this.treeNodeRSModelList.size() > 0;
    }

    @Override
    public boolean isAppendPNodeId() {
        return this.bAppendPNodeId;
    }

    public void setAppendPNodeId(boolean bAppendPNodeId) {
        this.bAppendPNodeId = bAppendPNodeId;
    }

    @Override
    public String getIconCls() {
        return this.strIconCls;
    }

    @Override
    public boolean isExpanded() {
        return this.bExpanded;
    }

    public void setIconCls(String strIconCls) {
        this.strIconCls = strIconCls;
    }

    public void setExpanded(boolean bExpanded) {
        this.bExpanded = bExpanded;
    }

    @Override
    public boolean isEnableCheck() {
        return this.bEnableCheck;
    }

    public void setEnableCheck(boolean bEnableCheck) {
        this.bEnableCheck = bEnableCheck;
    }

    @Override
    public void fillFetchResult(ITreeNodeFetchContext iTreeNodeFetchContext, ArrayList<ITreeNode> treeNodeList) throws Exception {
    }

    @Override
    public void fillFetchResult(ITreeNodeFetchContext iTreeNodeFetchContext, ArrayList<ITreeNode> treeNodeList, IDataTable dt) throws Exception {
    }

    @Override
    public boolean isChecked() {
        return this.bChecked;
    }

    public void setChecked(boolean bChecked) {
        this.bChecked = bChecked;
    }

    @Override
    public String getNodeType() {
        return this.strNodeType;
    }

    public void setNodeType(String strNodeType) {
        this.strNodeType = strNodeType;
    }

    @Override
    public boolean isRootNode() {
        return this.bRootNode;
    }

    public void setRootNode(boolean bRootNode) {
        this.bRootNode = bRootNode;
    }

    @Override
    public String getDEName() {
        return this.strDEName;
    }

    public void setDEName(String strDEName) {
        this.strDEName = strDEName;
    }

    @Override
    public String getIconPath() {
        return this.strIconPath;
    }

    public void setIconPath(String strIconPath) {
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

    public void setCounterMode(int nCounterMode) {
        this.nCounterMode = nCounterMode;
    }

    public void setCounterId(String strCounterId) {
        this.strCounterId = strCounterId;
    }

    @Override
    public String getNodeDataType() {
        return this.strNodeDataType;
    }

    public void setNodeDataType(String strNodeDataType) {
        this.strNodeDataType = strNodeDataType;
    }

    @Override
    public boolean isEnableQuickSearch() {
        return this.bEnableQuickSearch;
    }

    public void setEnableQuickSearch(boolean bEnableQuickSearch) {
        this.bEnableQuickSearch = bEnableQuickSearch;
    }

    public void registerTreeNodeDataItem(ITreeNodeDataItem iTreeNodeDataItem) {
        this.treeNodeDataItemList.add(iTreeNodeDataItem);
        this.treeNodeDataItemMap.put(iTreeNodeDataItem.getName().toLowerCase(), iTreeNodeDataItem);
    }

    @Override
    public ITreeNodeDataItem getTreeNodeDataItem(String strName) throws Exception {
        ITreeNodeDataItem iTreeNodeDataItem = this.treeNodeDataItemMap.get(strName.toLowerCase());
        if (iTreeNodeDataItem == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e\u9879[%1$s]", strName));
        }
        return iTreeNodeDataItem;
    }

    @Override
    public Iterator<ITreeNodeDataItem> getTreeNodeDataItems() {
        return this.treeNodeDataItemList.iterator();
    }
}

