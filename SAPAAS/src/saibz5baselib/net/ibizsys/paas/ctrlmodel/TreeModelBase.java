/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext;
import net.ibizsys.paas.ctrlmodel.CtrlModelBase;
import net.ibizsys.paas.ctrlmodel.ITreeModel;
import net.ibizsys.paas.ctrlmodel.ITreeNodeModel;
import net.ibizsys.paas.ctrlmodel.ITreeNodeRSModel;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;

public abstract class TreeModelBase
extends CtrlModelBase
implements ITreeModel {
    private HashMap<String, ITreeNodeModel> treeNodeModelMap = new HashMap();
    private boolean bEnableRootSelect = false;
    private ITreeNodeModel rootTreeNodeModel = null;
    private boolean bRootVisible = false;
    private String strCatCodeListId = null;
    private String strCounterId = null;

    @Override
    public String getControlType() {
        return "TREEVIEW";
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPrepareTreeMode();
    }

    protected void onPrepareTreeMode() throws Exception {
    }

    protected void registerTreeNodeModel(ITreeNodeModel iTreeNodeTypeModel) throws Exception {
        this.treeNodeModelMap.put(iTreeNodeTypeModel.getId(), iTreeNodeTypeModel);
        if (!StringHelper.isNullOrEmpty(iTreeNodeTypeModel.getNodeType())) {
            this.treeNodeModelMap.put(iTreeNodeTypeModel.getNodeType(), iTreeNodeTypeModel);
        }
        if (iTreeNodeTypeModel.isRootNode()) {
            this.rootTreeNodeModel = iTreeNodeTypeModel;
        }
    }

    @Override
    public ITreeNodeModel getTreeNodeModel(String strTreeNodeModelId) throws Exception {
        ITreeNodeModel iTreeNodeModel = this.treeNodeModelMap.get(strTreeNodeModelId);
        if (iTreeNodeModel == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6811\u8282\u70b9\u6a21\u578b[%1$s]", strTreeNodeModelId));
        }
        return iTreeNodeModel;
    }

    @Override
    public Iterator<ITreeNodeModel> getTreeNodeModels() {
        return this.treeNodeModelMap.values().iterator();
    }

    @Override
    public ITreeNodeModel getRootTreeNodeModel() {
        return this.rootTreeNodeModel;
    }

    @Override
    public boolean isEnableRootSelect() {
        return this.bEnableRootSelect;
    }

    protected void setEnableRootSelect(boolean bEnableRootSelect) {
        this.bEnableRootSelect = bEnableRootSelect;
    }

    @Override
    public boolean isRootVisible() {
        return this.bRootVisible;
    }

    protected void setRootVisible(boolean bRootVisible) {
        this.bRootVisible = bRootVisible;
    }

    @Override
    public String getCatCodeListId() {
        return this.strCatCodeListId;
    }

    protected void setCatCodeListId(String strCatCodeListId) {
        this.strCatCodeListId = strCatCodeListId;
    }

    @Override
    public void fillCatFetchResult(MDAjaxActionResult fetchResult) throws Exception {
        if (StringHelper.isNullOrEmpty(this.getCatCodeListId())) {
            return;
        }
        ICodeListModel iCodeListModel = (ICodeListModel)CodeListGlobal.getCodeList(this.getCatCodeListId());
        iCodeListModel.fillFetchResult(fetchResult, WebContext.getCurrent());
    }

    @Override
    public boolean isOutputTreeNodeRS(ITreeNodeFetchContext iTreeNodeFetchContext, ITreeNodeRSModel iTreeNodeRSModel) throws Exception {
        if (StringHelper.isNullOrEmpty(iTreeNodeFetchContext.getNodeFilter())) {
            return (iTreeNodeRSModel.getSearchMode() & 2) == 2;
        }
        return (iTreeNodeRSModel.getSearchMode() & 1) == 1;
    }

    @Override
    public boolean isOutputTreeNode(ITreeNodeFetchContext iTreeNodeFetchContext, ITreeNode iTreeNode) throws Exception {
        return true;
    }

    @Override
    public String getCounterId() {
        return this.strCounterId;
    }

    protected void setCounterId(String strCounterId) {
        this.strCounterId = strCounterId;
    }
}

