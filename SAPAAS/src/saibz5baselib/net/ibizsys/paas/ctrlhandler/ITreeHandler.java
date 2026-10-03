package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;

import net.ibizsys.paas.control.tree.ITreeNode;

/**
 * 树视图后台处理接口
 * 
 * @author lionlau
 *
 */
public interface ITreeHandler extends IMDCtrlHandler {
	
	/**
	 * 获取树分类数据
	 */
	final static String ACTION_FETCHCAT = "fetchcat";
	
	
	/**
	 * 获取计数器数据
	 */
	final static String ACTION_FETCHCOUNTER = "fetchcounter";
	

	/**
	 * 获取全部树节点，完全展开
	 * 
	 * @param iTreeNodeFetchContext
	 * @return
	 * @throws Exception
	 */
	ArrayList<ITreeNode> getAllTreeNodes(ITreeNodeFetchContext iTreeNodeFetchContext) throws Exception;
}
