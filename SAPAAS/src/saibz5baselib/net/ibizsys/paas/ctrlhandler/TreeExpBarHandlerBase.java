/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;
import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.control.tree.TreeNode;
import net.ibizsys.paas.ctrlhandler.ExpBarHandlerBase;
import net.ibizsys.paas.ctrlhandler.IExpBarRender;
import net.ibizsys.paas.ctrlhandler.ITreeHandler;
import net.ibizsys.paas.ctrlhandler.TreeNodeFetchContext;
import net.ibizsys.paas.ctrlmodel.IExpBarModel;
import net.ibizsys.paas.ctrlmodel.ITreeExpBarModel;
import net.ibizsys.paas.ctrlmodel.ITreeModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.psrt.srv.web.WebContext;

public abstract class TreeExpBarHandlerBase
extends ExpBarHandlerBase {
    protected abstract ITreeExpBarModel getTreeExpBarModel();

    @Override
    protected IExpBarModel getExpBarModel() {
        return this.getTreeExpBarModel();
    }

    protected ITreeModel getTreeModel() throws Exception {
        return null;
    }

    protected ITreeHandler getTreeHandler() throws Exception {
        return null;
    }

    @Override
    protected AjaxActionResult onFetch() throws Exception {
        if (this.getTreeHandler() != null) {
            IExpBarRender iExpBarRender;
            MDAjaxActionResult mdAjaxActionResult = this.createFetchActionResult();
            TreeNodeFetchContext treeNodeFetchContext = new TreeNodeFetchContext();
            ArrayList<ITreeNode> treeNodeList = this.getTreeHandler().getAllTreeNodes(treeNodeFetchContext);
            String strRender = WebContext.getRender(this.getWebContext());
            if (!StringHelper.isNullOrEmpty(strRender) && (iExpBarRender = (IExpBarRender)this.getViewController().getAppModel().getCtrlRender(this.getExpBarModel().getControlType(), strRender)) != null) {
                iExpBarRender.fillFetchResult(treeNodeList, mdAjaxActionResult);
                return mdAjaxActionResult;
            }
            for (ITreeNode iTreeNode : treeNodeList) {
                mdAjaxActionResult.getRows().add(TreeNode.toJSONObject(iTreeNode, treeNodeFetchContext.isSimpleMode(), true));
            }
            return mdAjaxActionResult;
        }
        return super.onFetch();
    }
}

