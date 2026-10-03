package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;

import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.ctrlmodel.ITreeModel;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 树绘制器接口
 * 
 * @author Administrator
 * 
 */
public interface ITreeRender extends IMDCtrlRender {

	/**
	 * 获取子节点标识
	 * 
	 * @param iWebContext
	 * @return
	 * @throws Exception
	 */
	String getNodeId(IWebContext iWebContext) throws Exception;

	/**
	 * 填充数据获取结果
	 * 
	 * @param iTreeModel
	 * @param fetchResult
	 * @param treeNodeList
	 * @throws Exception
	 */
	void fillFetchResult(ITreeModel iTreeModel, MDAjaxActionResult fetchResult, ArrayList<ITreeNode> treeNodeList) throws Exception;
}
