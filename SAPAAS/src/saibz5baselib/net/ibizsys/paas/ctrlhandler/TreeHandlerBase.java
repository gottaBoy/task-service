/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.control.tree.TreeNode;
import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.ctrlhandler.CounterGlobal;
import net.ibizsys.paas.ctrlhandler.ICounterHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.ctrlhandler.ITreeHandler;
import net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext;
import net.ibizsys.paas.ctrlhandler.ITreeRender;
import net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase;
import net.ibizsys.paas.ctrlhandler.TreeNodeFetchContext;
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
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

public abstract class TreeHandlerBase
extends MDCtrlHandlerBase
implements ITreeHandler {
    private ICounterHandler iCounterHandler = null;

    protected ITreeModel getTreeModel() {
        return null;
    }

    @Override
    public ICtrlModel getCtrlModel() {
        return this.getTreeModel();
    }

    @Override
    public ArrayList<ITreeNode> getAllTreeNodes(ITreeNodeFetchContext iTreeNodeFetchContext) throws Exception {
        ArrayList<ITreeNode> treeNodeList = new ArrayList<ITreeNode>();
        if (this.getTreeModel().isRootVisible()) {
            this.getTreeModel().getRootTreeNodeModel().fillFetchResult(iTreeNodeFetchContext, treeNodeList);
            for (ITreeNode iTreeNode : treeNodeList) {
                if (!this.isOutputTreeNode(iTreeNodeFetchContext, iTreeNode)) continue;
                this.fillChildTreeNodes(iTreeNodeFetchContext, iTreeNode, this.getTreeModel().getRootTreeNodeModel());
            }
        } else {
            TreeNodeFetchContext treeNodeFetchContext = new TreeNodeFetchContext(iTreeNodeFetchContext);
            treeNodeFetchContext.setRealNodeId("root");
            boolean bRootSelect = false;
            Iterator<ITreeNodeRSModel> iTreeNodeRSModelModels = this.getTreeModel().getRootTreeNodeModel().getTreeNodeRSModels();
            while (iTreeNodeRSModelModels.hasNext()) {
                ITreeNodeRSModel iTreeNodeRSModel = iTreeNodeRSModelModels.next();
                if (!this.isOutputTreeNodeRS(iTreeNodeFetchContext, iTreeNodeRSModel) || bRootSelect) continue;
                ArrayList<ITreeNode> treeNodeList2 = new ArrayList<ITreeNode>();
                this.fillTreeNodeFetchResult((ITreeNodeFetchContext)treeNodeFetchContext, iTreeNodeRSModel, treeNodeList2);
                treeNodeList.addAll(treeNodeList2);
            }
        }
        return treeNodeList;
    }

    protected void fillChildTreeNodes(ITreeNodeFetchContext iTreeNodeFetchContext, ITreeNode iTreeNode, ITreeNodeModel iTreeNodeModel) throws Exception {
        TreeNodeFetchContext treeNodeFetchContext = new TreeNodeFetchContext(iTreeNodeFetchContext);
        String strTreeNodeId = iTreeNode.getId();
        int nPos = strTreeNodeId.indexOf(";");
        if (nPos == -1) {
            throw new Exception(StringHelper.format("\u6811\u8282\u70b9[%1$s]\u6807\u8bc6\u65e0\u6548", strTreeNodeId));
        }
        String strRealNodeId = strTreeNodeId.substring(nPos + 1);
        treeNodeFetchContext.setRealNodeId(strRealNodeId);
        ArrayList<ITreeNode> treeNodeList = new ArrayList<ITreeNode>();
        Iterator<ITreeNodeRSModel> iTreeNodeRSModelModels = iTreeNodeModel.getTreeNodeRSModels();
        while (iTreeNodeRSModelModels.hasNext()) {
            ITreeNodeRSModel iTreeNodeRSModel = iTreeNodeRSModelModels.next();
            if (!this.isOutputTreeNodeRS(iTreeNodeFetchContext, iTreeNodeRSModel)) continue;
            ArrayList<ITreeNode> treeNodeList2 = new ArrayList<ITreeNode>();
            this.fillTreeNodeFetchResult((ITreeNodeFetchContext)treeNodeFetchContext, iTreeNodeRSModel, treeNodeList2);
            treeNodeList.addAll(treeNodeList2);
        }
        for (ITreeNode childTreeNode : treeNodeList) {
            if (!this.isOutputTreeNode(iTreeNodeFetchContext, childTreeNode)) continue;
            iTreeNode.addChildNode(childTreeNode);
        }
        if (iTreeNode.getChildNodes() == null) {
            iTreeNode.setLeaf(true);
        }
    }

    protected void fillTreeNodeFetchResult(ITreeNodeFetchContext iTreeNodeFetchContext, ITreeNodeRSModel iTreeNodeRSModel, ArrayList<ITreeNode> treeNodeList) throws Exception {
        ITreeNodeModel iTreeNodeModel = this.getTreeModel().getTreeNodeModel(iTreeNodeRSModel.getChildTreeNodeId());
        if (iTreeNodeModel == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6811\u8282\u70b9[%1$s]", iTreeNodeRSModel.getChildTreeNodeId()));
        }
        if (StringHelper.compare(iTreeNodeModel.getTreeNodeType(), "STATIC", true) == 0 || StringHelper.compare(iTreeNodeModel.getTreeNodeType(), "CODELIST", true) == 0) {
            ArrayList<ITreeNode> treeNodeList2 = new ArrayList<ITreeNode>();
            iTreeNodeModel.fillFetchResult(iTreeNodeFetchContext, treeNodeList2);
            for (ITreeNode iTreeNode : treeNodeList2) {
                if (!this.isOutputTreeNode(iTreeNodeFetchContext, iTreeNode)) continue;
                treeNodeList.add(iTreeNode);
                this.fillChildTreeNodes(iTreeNodeFetchContext, iTreeNode, iTreeNodeModel);
            }
            return;
        }
        if (StringHelper.compare(iTreeNodeModel.getTreeNodeType(), "DE", true) == 0) {
            IDEDataSetCond iDEDataSetCond;
            ITreeDEDataSetNodeModel iTreeDEDataSetNodeModel = (ITreeDEDataSetNodeModel)iTreeNodeModel;
            IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(iTreeDEDataSetNodeModel.getDEName());
            IService iService = iDataEntityModel.getService(ViewController.getCurrent().getSessionFactory());
            SimpleEntity srcDataEntity = new SimpleEntity();
            srcDataEntity.set("NODEFILTER", iTreeNodeFetchContext.getNodeFilter());
            String[] nodeid = iTreeNodeFetchContext.getRealNodeId().split(";");
            int i = 0;
            while (i < nodeid.length) {
                if (i == 0) {
                    srcDataEntity.set("NODEID", nodeid[i]);
                } else {
                    srcDataEntity.set(StringHelper.format("NODEID%1$s", i + 1), nodeid[i]);
                }
                ++i;
            }
            if (!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getActiveDataDELogicId())) {
                iService.executeLogic(iTreeDEDataSetNodeModel.getActiveDataDELogicId(), srcDataEntity);
            }
            String strSortParam = "";
            String strSortDir = "ASC";
            if (!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getSortField())) {
                IDEField sortDEField = iDataEntityModel.getDEField(iTreeDEDataSetNodeModel.getSortField(), false);
                if (sortDEField != null) {
                    strSortParam = sortDEField.getName();
                }
                if (!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getSortDir())) {
                    strSortDir = iTreeDEDataSetNodeModel.getSortDir();
                }
            }
            String strQueryModelId = "";
            if (!StringHelper.isNullOrEmpty(iTreeNodeFetchContext.getNodeFilter())) {
                strQueryModelId = iTreeDEDataSetNodeModel.getFilterDEDataSetName();
            }
            if (StringHelper.isNullOrEmpty(strQueryModelId)) {
                strQueryModelId = iTreeDEDataSetNodeModel.getDEDataSetName();
            }
            DEDataSetFetchContext deDataSetFetchContext = new DEDataSetFetchContext(null);
            deDataSetFetchContext.setActiveDataObject(this.processActiveDataObject(iTreeNodeFetchContext, iTreeNodeRSModel, srcDataEntity));
            deDataSetFetchContext.setSort(strSortParam);
            deDataSetFetchContext.setSortDir(strSortDir);
            deDataSetFetchContext.setStartRow(0);
            if (iTreeDEDataSetNodeModel.getMaxSize() > 0) {
                deDataSetFetchContext.setPageSize(iTreeDEDataSetNodeModel.getMaxSize());
            } else {
                deDataSetFetchContext.setPageSize(1000);
            }
            deDataSetFetchContext.setSessionFactory(ViewController.getCurrent().getSessionFactory());
            if (iTreeNodeModel.isEnableQuickSearch() && !StringHelper.isNullOrEmpty(iTreeNodeFetchContext.getNodeFilter()) && (iDEDataSetCond = iDataEntityModel.getFetchQuickSearchCondition(iTreeNodeFetchContext.getNodeFilter())) != null) {
                deDataSetFetchContext.getConditionList().add(iDEDataSetCond);
            }
            this.fillDEDataSetFetchContext(deDataSetFetchContext, iTreeDEDataSetNodeModel, iTreeNodeFetchContext, iTreeNodeRSModel);
            DBFetchResult dbFetchResult = iService.fetchDataSet(strQueryModelId, deDataSetFetchContext);
            ArrayList<ITreeNode> treeNodeList2 = new ArrayList<ITreeNode>();
            iTreeDEDataSetNodeModel.fillFetchResult(iTreeNodeFetchContext, treeNodeList2, dbFetchResult.getDataSet().getDataTable(0));
            for (ITreeNode iTreeNode : treeNodeList2) {
                if (!this.isOutputTreeNode(iTreeNodeFetchContext, iTreeNode)) continue;
                treeNodeList.add(iTreeNode);
                this.fillChildTreeNodes(iTreeNodeFetchContext, iTreeNode, iTreeNodeModel);
            }
            dbFetchResult.getDataSet().close();
            return;
        }
    }

    protected void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl, ITreeDEDataSetNodeModel iTreeDEDataSetNodeModel, ITreeNodeFetchContext iTreeNodeFetchContext, ITreeNodeRSModel iTreeNodeRSModel) throws Exception {
    }

    @Override
    protected AjaxActionResult onFetch() throws Exception {
        MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);
        TreeNodeFetchContext treeNodeFetchContext = new TreeNodeFetchContext(this.getWebContext());
        String strTreeNodeId = this.getCurNodeId(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strTreeNodeId) || StringHelper.compare(strTreeNodeId, "#", true) == 0) {
            if (this.getTreeModel().isRootVisible()) {
                ArrayList<ITreeNode> treeNodeList = new ArrayList<ITreeNode>();
                this.getTreeModel().getRootTreeNodeModel().fillFetchResult(treeNodeFetchContext, treeNodeList);
                this.fillFetchResult(mdAjaxActionResult, treeNodeList);
                return mdAjaxActionResult;
            }
            strTreeNodeId = "root";
        }
        String strRealNodeId = "";
        ITreeNodeModel treeNode = null;
        boolean bRootSelect = false;
        String strRootSelectNode = "";
        if (StringHelper.compare("root", strTreeNodeId, true) == 0) {
            treeNode = this.getTreeModel().getRootTreeNodeModel();
            strRealNodeId = treeNodeFetchContext.getCatalog();
            bRootSelect = this.getTreeModel().isEnableRootSelect();
        } else {
            int nPos = strTreeNodeId.indexOf(";");
            if (nPos == -1) {
                mdAjaxActionResult.setRetCode(1);
                mdAjaxActionResult.setErrorInfo(StringHelper.format("\u6811\u8282\u70b9[%1$s]\u6807\u8bc6\u65e0\u6548", strTreeNodeId));
                return mdAjaxActionResult;
            }
            String strNodeType = strTreeNodeId.substring(0, nPos);
            strRealNodeId = strTreeNodeId.substring(nPos + 1);
            treeNode = this.getTreeModel().getTreeNodeModel(strNodeType);
        }
        if (treeNode == null) {
            mdAjaxActionResult.setRetCode(1);
            mdAjaxActionResult.setErrorInfo(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6811\u8282\u70b9[%1$s]", strTreeNodeId));
            return mdAjaxActionResult;
        }
        treeNodeFetchContext.setRealNodeId(strRealNodeId);
        Iterator<ITreeNodeRSModel> iTreeNodeRSModelModels = treeNode.getTreeNodeRSModels();
        while (iTreeNodeRSModelModels.hasNext()) {
            ITreeNodeRSModel iTreeNodeRSModel = iTreeNodeRSModelModels.next();
            if (!this.isOutputTreeNodeRS(treeNodeFetchContext, iTreeNodeRSModel)) continue;
            if (bRootSelect) {
                if (!StringHelper.isNullOrEmpty(strRootSelectNode) && StringHelper.compare(strRootSelectNode, iTreeNodeRSModel.getChildTreeNodeId(), true) != 0) continue;
                this.fillTreeNodeFetchResult((ITreeNodeFetchContext)treeNodeFetchContext, iTreeNodeRSModel, mdAjaxActionResult);
                return mdAjaxActionResult;
            }
            this.fillTreeNodeFetchResult((ITreeNodeFetchContext)treeNodeFetchContext, iTreeNodeRSModel, mdAjaxActionResult);
        }
        return mdAjaxActionResult;
    }

    protected boolean isOutputTreeNodeRS(ITreeNodeFetchContext iTreeNodeFetchContext, ITreeNodeRSModel iTreeNodeRSModel) throws Exception {
        return this.getTreeModel().isOutputTreeNodeRS(iTreeNodeFetchContext, iTreeNodeRSModel);
    }

    protected boolean isOutputTreeNode(ITreeNodeFetchContext iTreeNodeFetchContext, ITreeNode iTreeNode) throws Exception {
        return this.getTreeModel().isOutputTreeNode(iTreeNodeFetchContext, iTreeNode);
    }

    protected void fillTreeNodeFetchResult(ITreeNodeFetchContext iTreeNodeFetchContext, ITreeNodeRSModel iTreeNodeRSModel, MDAjaxActionResult treeNodeLoadResult) throws Exception {
        ITreeNodeModel iTreeNodeModel = this.getTreeModel().getTreeNodeModel(iTreeNodeRSModel.getChildTreeNodeId());
        if (iTreeNodeModel == null) {
            treeNodeLoadResult.setRetCode(1);
            treeNodeLoadResult.setErrorInfo(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6811\u8282\u70b9[%1$s]", iTreeNodeRSModel.getChildTreeNodeId()));
            return;
        }
        if (StringHelper.compare(iTreeNodeModel.getTreeNodeType(), "STATIC", true) == 0 || StringHelper.compare(iTreeNodeModel.getTreeNodeType(), "CODELIST", true) == 0) {
            ArrayList<ITreeNode> treeNodeList = new ArrayList<ITreeNode>();
            iTreeNodeModel.fillFetchResult(iTreeNodeFetchContext, treeNodeList);
            ArrayList<ITreeNode> treeNodeList2 = new ArrayList<ITreeNode>();
            for (ITreeNode iTreeNode : treeNodeList) {
                if (!this.isOutputTreeNode(iTreeNodeFetchContext, iTreeNode)) continue;
                treeNodeList2.add(iTreeNode);
            }
            this.fillFetchResult(treeNodeLoadResult, treeNodeList2);
            return;
        }
        if (StringHelper.compare(iTreeNodeModel.getTreeNodeType(), "DE", true) == 0) {
            IDEDataSetCond iDEDataSetCond;
            ITreeDEDataSetNodeModel iTreeDEDataSetNodeModel = (ITreeDEDataSetNodeModel)iTreeNodeModel;
            IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(iTreeDEDataSetNodeModel.getDEName());
            IService iService = iDataEntityModel.getService(ViewController.getCurrent().getSessionFactory());
            SimpleEntity srcDataEntity = new SimpleEntity();
            srcDataEntity.set("NODEFILTER", iTreeNodeFetchContext.getNodeFilter());
            String[] nodeid = iTreeNodeFetchContext.getRealNodeId().split(";");
            int i = 0;
            while (i < nodeid.length) {
                if (i == 0) {
                    srcDataEntity.set("NODEID", nodeid[i]);
                } else {
                    srcDataEntity.set(StringHelper.format("NODEID%1$s", i + 1), nodeid[i]);
                }
                ++i;
            }
            if (!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getActiveDataDELogicId())) {
                iService.executeLogic(iTreeDEDataSetNodeModel.getActiveDataDELogicId(), srcDataEntity);
            }
            String strSortParam = "";
            String strSortDir = "ASC";
            if (!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getSortField())) {
                IDEField sortDEField = iDataEntityModel.getDEField(iTreeDEDataSetNodeModel.getSortField(), false);
                if (sortDEField != null) {
                    strSortParam = sortDEField.getName();
                }
                if (!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getSortDir())) {
                    strSortDir = iTreeDEDataSetNodeModel.getSortDir();
                }
            }
            String strQueryModelId = "";
            if (!StringHelper.isNullOrEmpty(iTreeNodeFetchContext.getNodeFilter())) {
                strQueryModelId = iTreeDEDataSetNodeModel.getFilterDEDataSetName();
            }
            if (StringHelper.isNullOrEmpty(strQueryModelId)) {
                strQueryModelId = iTreeDEDataSetNodeModel.getDEDataSetName();
            }
            DEDataSetFetchContext deDataSetFetchContext = new DEDataSetFetchContext(null);
            deDataSetFetchContext.setActiveDataObject(this.processActiveDataObject(iTreeNodeFetchContext, iTreeNodeRSModel, srcDataEntity));
            deDataSetFetchContext.setSort(strSortParam);
            deDataSetFetchContext.setSortDir(strSortDir);
            deDataSetFetchContext.setStartRow(0);
            if (iTreeDEDataSetNodeModel.getMaxSize() > 0) {
                deDataSetFetchContext.setPageSize(iTreeDEDataSetNodeModel.getMaxSize());
            } else {
                deDataSetFetchContext.setPageSize(1000);
            }
            deDataSetFetchContext.setSessionFactory(ViewController.getCurrent().getSessionFactory());
            if (iTreeNodeModel.isEnableQuickSearch() && !StringHelper.isNullOrEmpty(iTreeNodeFetchContext.getNodeFilter()) && (iDEDataSetCond = iDataEntityModel.getFetchQuickSearchCondition(iTreeNodeFetchContext.getNodeFilter())) != null) {
                deDataSetFetchContext.getConditionList().add(iDEDataSetCond);
            }
            this.fillDEDataSetFetchContext(deDataSetFetchContext, iTreeDEDataSetNodeModel, iTreeNodeFetchContext, iTreeNodeRSModel);
            DBFetchResult dbFetchResult = iService.fetchDataSet(strQueryModelId, deDataSetFetchContext);
            ArrayList<ITreeNode> treeNodeList = new ArrayList<ITreeNode>();
            iTreeDEDataSetNodeModel.fillFetchResult(iTreeNodeFetchContext, treeNodeList, dbFetchResult.getDataSet().getDataTable(0));
            ArrayList<ITreeNode> treeNodeList2 = new ArrayList<ITreeNode>();
            for (ITreeNode iTreeNode : treeNodeList) {
                if (!this.isOutputTreeNode(iTreeNodeFetchContext, iTreeNode)) continue;
                treeNodeList2.add(iTreeNode);
            }
            this.fillFetchResult(treeNodeLoadResult, treeNodeList2);
            return;
        }
    }

    protected void fillFetchResult(MDAjaxActionResult fetchResult, ArrayList<ITreeNode> treeNodeList) throws Exception {
        ICtrlRender iCtrlRender = this.getCtrlRender();
        if (iCtrlRender != null) {
            ITreeRender iTreeRender = (ITreeRender)iCtrlRender;
            iTreeRender.fillFetchResult(this.getTreeModel(), fetchResult, treeNodeList);
        } else {
            for (ITreeNode iTreeNode : treeNodeList) {
                fetchResult.getRows().add(TreeNode.toJSONObject(iTreeNode, false));
            }
        }
    }

    protected String getCurNodeId(IWebContext iWebContext) throws Exception {
        ICtrlRender iCtrlRender = this.getCtrlRender();
        if (iCtrlRender != null) {
            ITreeRender iTreeRender = (ITreeRender)iCtrlRender;
            return iTreeRender.getNodeId(iWebContext);
        }
        return WebContext.getNodeId(iWebContext);
    }

    @Override
    protected AjaxActionResult onProcessAction(String strAction) throws Exception {
        if (StringHelper.compare(strAction, "fetchcat", true) == 0) {
            return this.onFetchCat();
        }
        if (StringHelper.compare(strAction, "fetchcounter", true) == 0) {
            return this.onFetchCounter();
        }
        return super.onProcessAction(strAction);
    }

    protected AjaxActionResult onFetchCat() throws Exception {
        MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);
        this.getTreeModel().fillCatFetchResult(mdAjaxActionResult);
        return mdAjaxActionResult;
    }

    protected IEntity processActiveDataObject(ITreeNodeFetchContext iTreeNodeFetchContext, ITreeNodeRSModel iTreeNodeRSModel, IEntity iEntity) throws Exception {
        if (StringHelper.isNullOrEmpty(iTreeNodeRSModel.getDEActionName())) {
            return iEntity;
        }
        this.getService().executeAction(iTreeNodeRSModel.getDEActionName(), iEntity);
        return iEntity;
    }

    @Override
    protected AjaxActionResult onRemove() throws Exception {
        MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(ajaxActionResult);
        String strTreeNodeId = this.getCurNodeId(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strTreeNodeId) || StringHelper.compare(strTreeNodeId, "#", true) == 0) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(StringHelper.format("\u6811\u8282\u70b9[%1$s]\u6807\u8bc6\u65e0\u6548", strTreeNodeId));
            return ajaxActionResult;
        }
        String strRealNodeId = "";
        ITreeNodeModel treeNode = null;
        if (StringHelper.compare("root", strTreeNodeId, true) == 0) {
            treeNode = this.getTreeModel().getRootTreeNodeModel();
        } else {
            int nPos = strTreeNodeId.indexOf(";");
            if (nPos == -1) {
                ajaxActionResult.setRetCode(1);
                ajaxActionResult.setErrorInfo(StringHelper.format("\u6811\u8282\u70b9[%1$s]\u6807\u8bc6\u65e0\u6548", strTreeNodeId));
                return ajaxActionResult;
            }
            String strNodeType = strTreeNodeId.substring(0, nPos);
            strRealNodeId = strTreeNodeId.substring(nPos + 1);
            treeNode = this.getTreeModel().getTreeNodeModel(strNodeType);
        }
        if (treeNode == null) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6811\u8282\u70b9[%1$s]", strTreeNodeId));
            return ajaxActionResult;
        }
        try {
            this.removeTreeNode(treeNode, strRealNodeId);
        }
        catch (ErrorException ex) {
            ajaxActionResult.setRetCode(ex.getErrorCode());
            ajaxActionResult.setErrorInfo(ex.getMessage());
            return ajaxActionResult;
        }
        catch (Exception ex) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(ex.getMessage());
            return ajaxActionResult;
        }
        ajaxActionResult.setReloadData(true);
        return ajaxActionResult;
    }

    protected void removeTreeNode(ITreeNodeModel iTreeNodeModel, String strRealNodeId) throws Exception {
        String[] nodeids = strRealNodeId.split(";");
        String strKey = nodeids[0];
        if (iTreeNodeModel instanceof ITreeDEDataSetNodeModel) {
            IEntity iEntity;
            CallResult callResult;
            ITreeDEDataSetNodeModel iTreeDEDataSetNodeModel = (ITreeDEDataSetNodeModel)iTreeNodeModel;
            String strRemoveDEActionName = iTreeDEDataSetNodeModel.getRemoveDEActionName();
            if (StringHelper.isNullOrEmpty(strRemoveDEActionName)) {
                throw new Exception(StringHelper.format("\u6811\u8282\u70b9[%1$s]\u4e0d\u652f\u6301\u5220\u9664\u64cd\u4f5c", iTreeNodeModel.getName()));
            }
            IDataEntityModel iDEModel = DEModelGlobal.getDEModel(iTreeDEDataSetNodeModel.getDEName());
            String strDataAccessAction = iTreeDEDataSetNodeModel.getRemoveDataAccessAction();
            if (StringHelper.isNullOrEmpty(strDataAccessAction)) {
                strDataAccessAction = "DELETE";
            }
            if (!(callResult = this.testDataAccessAction(iDEModel, iEntity = this.getSimpleEntity(iDEModel, strKey), strDataAccessAction)).isOk()) {
                throw new ErrorException(2, callResult.getErrorInfo());
            }
            iDEModel.getService(this.getSessionFactory()).executeAction(strRemoveDEActionName, iEntity);
            return;
        }
        throw new Exception(StringHelper.format("\u6811\u8282\u70b9[%1$s]\u4e0d\u652f\u6301\u5220\u9664\u64cd\u4f5c", iTreeNodeModel.getName()));
    }

    @Override
    protected IEntity getSimpleEntity(IDataEntityModel iDEModel, Object objKey) throws Exception {
        if (objKey != null && objKey instanceof String && ((String)objKey).indexOf("SRFTEMPKEY:") == 0) {
            return null;
        }
        Object iEntity = iDEModel.createEntity();
        iEntity.set(iDEModel.getKeyDEField().getName(), objKey);
        iDEModel.getService(this.getSessionFactory()).get(iEntity);
        return iEntity;
    }

    protected CallResult testDataAccessAction(IDataEntityModel iDEModel, IEntity iEntity, String strDataAccessAction) throws Exception {
        return this.getWebContext().getUserPrivilegeMgr().testDataAccessAction(this.getWebContext(), iDEModel, iEntity, strDataAccessAction);
    }

    @Override
    protected AjaxActionResult onUIAction() throws Exception {
        String strDEUIActionId = WebContext.getUIActionId(this.getWebContext());
        String strTreeNodeType = WebContext.getNodeType(this.getWebContext());
        IDEUIActionModel iDEUIActionModel = null;
        if (StringHelper.isNullOrEmpty(strTreeNodeType)) {
            iDEUIActionModel = (IDEUIActionModel)this.getDEModel().getDEUIAction(strDEUIActionId);
        } else {
            ITreeNodeModel iTreeNodeModel = this.getTreeModel().getTreeNodeModel(strTreeNodeType);
            if (!StringHelper.isNullOrEmpty(iTreeNodeModel.getDEName())) {
                IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(iTreeNodeModel.getDEName());
                iDEUIActionModel = (IDEUIActionModel)iDataEntityModel.getDEUIAction(strDEUIActionId);
            }
        }
        return this.doUIAction(iDEUIActionModel);
    }

    @Override
    protected AjaxActionResult doUIAction(IDEUIActionModel iDEUIActionModel) throws Exception {
        MDAjaxActionResult mdAjaxActionResult = this.createFetchActionResult();
        this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);
        if (StringHelper.compare(iDEUIActionModel.getActionTarget(), "NONE", true) == 0) {
            CallResult callResult;
            if (!StringHelper.isNullOrEmpty(iDEUIActionModel.getDataAccessAction()) && (callResult = iDEUIActionModel.getDEModel().getDEDataAccMgr().test(this.getWebContext(), null, iDEUIActionModel.getDataAccessAction())).isError()) {
                mdAjaxActionResult.from(callResult);
                return mdAjaxActionResult;
            }
            iDEUIActionModel.execute(null, this.getSessionFactory());
        } else {
            String strKeys = WebContext.getKeys(this.getWebContext());
            if (StringHelper.isNullOrEmpty(strKeys)) {
                strKeys = WebContext.getKey(this.getWebContext());
            }
            if (StringHelper.isNullOrEmpty(strKeys)) {
                mdAjaxActionResult.setRetCode(4);
                return mdAjaxActionResult;
            }
            ArrayList entities = iDEUIActionModel.getDEModel().createEntityList();
            String[] keys = strKeys.split("[|]");
            int i = 0;
            while (i < keys.length) {
                IEntity iEntity2;
                String strTreeNodeId = keys[i];
                int nPos = strTreeNodeId.indexOf(";");
                if (nPos == -1) {
                    mdAjaxActionResult.setRetCode(1);
                    mdAjaxActionResult.setErrorInfo(StringHelper.format("\u6811\u8282\u70b9[%1$s]\u6807\u8bc6\u65e0\u6548", strTreeNodeId));
                    return mdAjaxActionResult;
                }
                String strNodeType = strTreeNodeId.substring(0, nPos);
                String strRealNodeId = strTreeNodeId.substring(nPos + 1);
                Object iEntity = iDEUIActionModel.getDEModel().createEntity();
                iEntity.set(iDEUIActionModel.getDEModel().getKeyDEField().getName(), strRealNodeId);
                if (!StringHelper.isNullOrEmpty(iDEUIActionModel.getDataAccessAction()) && (iEntity2 = this.getSimpleEntity(iDEUIActionModel.getDEModel(), strRealNodeId)) != null) {
                    CallResult callResult = iDEUIActionModel.getDEModel().getDEDataAccMgr().test(this.getWebContext(), iEntity2, iDEUIActionModel.getDataAccessAction());
                    if (callResult.isError()) {
                        mdAjaxActionResult.from(callResult);
                        return mdAjaxActionResult;
                    }
                    if (DataTypeHelper.compare(iDEUIActionModel.getDEModel().getKeyDEField().getStdDataType(), iEntity.get(iDEUIActionModel.getDEModel().getKeyDEField().getName()), iEntity2.get(iDEUIActionModel.getDEModel().getKeyDEField().getName())) == 0L) {
                        iEntity = iEntity2;
                    }
                }
                entities.add(iEntity);
                ++i;
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
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(StringHelper.format("\u6811\u8282\u70b9[%1$s]\u6807\u8bc6\u65e0\u6548", strTreeNodeId));
            return ajaxActionResult;
        }
        String strRealNodeId = "";
        ITreeNodeModel treeNode = null;
        if (StringHelper.compare("root", strTreeNodeId, true) == 0) {
            treeNode = this.getTreeModel().getRootTreeNodeModel();
        } else {
            int nPos = strTreeNodeId.indexOf(";");
            if (nPos == -1) {
                ajaxActionResult.setRetCode(1);
                ajaxActionResult.setErrorInfo(StringHelper.format("\u6811\u8282\u70b9[%1$s]\u6807\u8bc6\u65e0\u6548", strTreeNodeId));
                return ajaxActionResult;
            }
            String strNodeType = strTreeNodeId.substring(0, nPos);
            strRealNodeId = strTreeNodeId.substring(nPos + 1);
            treeNode = this.getTreeModel().getTreeNodeModel(strNodeType);
        }
        if (treeNode == null) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6811\u8282\u70b9[%1$s]", strTreeNodeId));
            return ajaxActionResult;
        }
        try {
            ajaxActionResult.setContent(this.getTreeNodeSummary(treeNode, strRealNodeId));
        }
        catch (ErrorException ex) {
            ajaxActionResult.setRetCode(ex.getErrorCode());
            ajaxActionResult.setErrorInfo(ex.getMessage());
            return ajaxActionResult;
        }
        catch (Exception ex) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(ex.getMessage());
            return ajaxActionResult;
        }
        return ajaxActionResult;
    }

    protected String getTreeNodeSummary(ITreeNodeModel iTreeNodeModel, String strRealNodeId) throws Exception {
        String[] nodeids = strRealNodeId.split(";");
        String strKey = nodeids[0];
        if (iTreeNodeModel instanceof ITreeDEDataSetNodeModel) {
            ITreeDEDataSetNodeModel iTreeDEDataSetNodeModel = (ITreeDEDataSetNodeModel)iTreeNodeModel;
            IDataEntityModel iDEModel = DEModelGlobal.getDEModel(iTreeDEDataSetNodeModel.getDEName());
            String strDataAccessAction = "READ";
            IEntity iEntity = this.getSimpleEntity(iDEModel, strKey);
            CallResult callResult = this.testDataAccessAction(iDEModel, iEntity, strDataAccessAction);
            if (!callResult.isOk()) {
                throw new ErrorException(2, callResult.getErrorInfo());
            }
            return iDEModel.getService(this.getSessionFactory()).getDataSummary(iEntity);
        }
        return iTreeNodeModel.getName();
    }

    protected AjaxActionResult onFetchCounter() throws Exception {
        String[] treeNodeIds;
        MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);
        String strAllTreeNodeId = this.getCurNodeId(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strAllTreeNodeId) || StringHelper.compare(strAllTreeNodeId, "#", true) == 0) {
            return mdAjaxActionResult;
        }
        String[] stringArray = treeNodeIds = strAllTreeNodeId.split("[|]");
        int n = treeNodeIds.length;
        int n2 = 0;
        while (n2 < n) {
            String strTreeNodeId = stringArray[n2];
            if (!StringHelper.isNullOrEmpty(strTreeNodeId) && StringHelper.compare(strTreeNodeId, "#", true) != 0) {
                String strRealNodeId = "";
                ITreeNodeModel treeNode = null;
                if (StringHelper.compare("root", strTreeNodeId, true) == 0) {
                    treeNode = this.getTreeModel().getRootTreeNodeModel();
                } else {
                    int nPos = strTreeNodeId.indexOf(";");
                    if (nPos == -1) {
                        mdAjaxActionResult.setRetCode(1);
                        mdAjaxActionResult.setErrorInfo(StringHelper.format("\u6811\u8282\u70b9[%1$s]\u6807\u8bc6\u65e0\u6548", strTreeNodeId));
                        return mdAjaxActionResult;
                    }
                    String strNodeType = strTreeNodeId.substring(0, nPos);
                    strRealNodeId = strTreeNodeId.substring(nPos + 1);
                    treeNode = this.getTreeModel().getTreeNodeModel(strNodeType);
                }
                if (treeNode == null) {
                    mdAjaxActionResult.setRetCode(1);
                    mdAjaxActionResult.setErrorInfo(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6811\u8282\u70b9[%1$s]", strTreeNodeId));
                    return mdAjaxActionResult;
                }
                int nCounterValue = this.getTreeNodeCounterValue(treeNode, strRealNodeId);
                JSONObject jo = new JSONObject();
                jo.put("srfkey", (Object)strTreeNodeId);
                jo.put("value", nCounterValue);
                mdAjaxActionResult.getRows().add(jo);
            }
            ++n2;
        }
        return mdAjaxActionResult;
    }

    protected int getTreeNodeCounterValue(ITreeNodeModel iTreeNodeModel, String strRealNodeId) throws Exception {
        String[] nodeids = strRealNodeId.split(";");
        String strKey = nodeids[0];
        if (iTreeNodeModel instanceof ITreeStaticNodeModel) {
            if (!StringHelper.isNullOrEmpty(iTreeNodeModel.getCounterId()) && this.getCounterHandler() != null) {
                return this.getCounterHandler().getCounterItemValue(iTreeNodeModel.getCounterId(), ViewController.getCurrent(), WebContext.getCurrent());
            }
            return 0;
        }
        if (iTreeNodeModel instanceof ITreeCodeListNodeModel) {
            if (!StringHelper.isNullOrEmpty(iTreeNodeModel.getCounterId()) && this.getCounterHandler() != null) {
                return this.getCounterHandler().getCounterItemValue(iTreeNodeModel.getCounterId(), ViewController.getCurrent(), WebContext.getCurrent());
            }
            return 0;
        }
        if (iTreeNodeModel instanceof ITreeDEDataSetNodeModel) {
            ITreeDEDataSetNodeModel iTreeDEDataSetNodeModel = (ITreeDEDataSetNodeModel)iTreeNodeModel;
            IDataEntityModel iDEModel = DEModelGlobal.getDEModel(iTreeDEDataSetNodeModel.getDEName());
            String strDataAccessAction = "READ";
            IEntity iEntity = this.getSimpleEntity(iDEModel, strKey);
            CallResult callResult = this.testDataAccessAction(iDEModel, iEntity, strDataAccessAction);
            if (!callResult.isOk()) {
                throw new ErrorException(2, callResult.getErrorInfo());
            }
            int nCount = 0;
            if (!StringHelper.isNullOrEmpty(iTreeNodeModel.getCounterId()) && iEntity.contains(iTreeNodeModel.getCounterId())) {
                return DataObject.getIntegerValue(iEntity, iTreeNodeModel.getCounterId(), nCount);
            }
            if (!StringHelper.isNullOrEmpty(iTreeDEDataSetNodeModel.getChildCntField()) && iEntity.contains(iTreeDEDataSetNodeModel.getChildCntField())) {
                return DataObject.getIntegerValue(iEntity, iTreeDEDataSetNodeModel.getChildCntField(), nCount);
            }
            return 0;
        }
        return 0;
    }

    protected ICounterHandler getCounterHandler() throws Exception {
        if (this.iCounterHandler == null && !StringHelper.isNullOrEmpty(this.getTreeModel().getCounterId())) {
            this.iCounterHandler = CounterGlobal.getCounterHandler(this.getTreeModel().getCounterId());
        }
        return this.iCounterHandler;
    }
}

