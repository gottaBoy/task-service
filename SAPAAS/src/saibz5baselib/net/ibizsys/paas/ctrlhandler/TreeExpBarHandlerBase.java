package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;

import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.control.tree.TreeNode;
import net.ibizsys.paas.ctrlmodel.IExpBarModel;
import net.ibizsys.paas.ctrlmodel.ITreeExpBarModel;
import net.ibizsys.paas.ctrlmodel.ITreeModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.psrt.srv.web.WebContext;

/**
 * 树导航栏处理对象
 * 
 * @author Administrator
 *
 */
public abstract class TreeExpBarHandlerBase extends ExpBarHandlerBase {
	/**
	 * 获取树导航栏模型
	 * 
	 * @return
	 */
	protected abstract ITreeExpBarModel getTreeExpBarModel();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ExpBarHandlerBase#getExpBarModel()
	 */
	@Override
	protected IExpBarModel getExpBarModel() {
		return getTreeExpBarModel();
	}

	/**
	 * 获取树模型
	 * 
	 * @return
	 */
	protected ITreeModel getTreeModel() throws Exception {
		return null;
	}

	/**
	 * 获取树模型处理对象
	 * 
	 * @return
	 */
	protected ITreeHandler getTreeHandler() throws Exception {
		return null;
	}

	/*
	 * 后台处理
	 */
	@Override
	protected AjaxActionResult onFetch() throws Exception {
		if (getTreeHandler() != null) {
			MDAjaxActionResult mdAjaxActionResult = createFetchActionResult();
			TreeNodeFetchContext treeNodeFetchContext = new TreeNodeFetchContext();
			ArrayList<ITreeNode> treeNodeList = getTreeHandler().getAllTreeNodes(treeNodeFetchContext);
			String strRender = WebContext.getRender(this.getWebContext());
			if (!StringHelper.isNullOrEmpty(strRender)) {
				IExpBarRender iExpBarRender = (IExpBarRender) this.getViewController().getAppModel().getCtrlRender(this.getExpBarModel().getControlType(), strRender);
				if (iExpBarRender != null) {
					iExpBarRender.fillFetchResult(treeNodeList, mdAjaxActionResult);
					return mdAjaxActionResult;
				}
			}

			for (ITreeNode iTreeNode : treeNodeList) {
				mdAjaxActionResult.getRows().add(TreeNode.toJSONObject(iTreeNode, treeNodeFetchContext.isSimpleMode(), true));
			}

			return mdAjaxActionResult;
		}
		return super.onFetch();
	}
}
