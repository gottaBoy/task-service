package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 树部件模型接口
 * 
 * @author lionlau
 *
 */
public interface ITreeModel extends ICtrlModel {
	/**
	 * 节点分隔符号
	 */
	static final String NODE_SEPARATOR = ";";

	/**
	 * 根节点标识
	 */
	final static String NODE_ROOTID = "root";

	/**
	 * 获取根节点模型
	 * 
	 * @return
	 */
	ITreeNodeModel getRootTreeNodeModel();

	/**
	 * 获取指定树节点模型
	 * 
	 * @param strTreeNodeModelId
	 * @return
	 * @throws Exception
	 */
	ITreeNodeModel getTreeNodeModel(String strTreeNodeModelId) throws Exception;
	
	
	/**
	 * 获取树视图节点模型集合
	 * @return
	 */
	java.util.Iterator<ITreeNodeModel> getTreeNodeModels();

	/**
	 * 是否支持根节点选择
	 * 
	 * @return
	 */
	boolean isEnableRootSelect();

	/**
	 * 是否显示根节点
	 * 
	 * @return
	 */
	boolean isRootVisible();

	/**
	 * 获取树分类代码表标识
	 * 
	 * @return
	 */
	String getCatCodeListId();

	/**
	 * 填充分类数据结果对象
	 * 
	 * @param fetchResult
	 * @throws Exception
	 */
	void fillCatFetchResult(MDAjaxActionResult fetchResult) throws Exception;

	/**
	 * 判断是否输出指定树节点关系
	 * 
	 * @param iTreeNodeFetchContext
	 * @param iTreeNodeRSModel
	 * @return
	 * @throws Exception
	 */
	boolean isOutputTreeNodeRS(ITreeNodeFetchContext iTreeNodeFetchContext, ITreeNodeRSModel iTreeNodeRSModel) throws Exception;

	/**
	 * 判断是否输出指定树节点
	 * 
	 * @param iTreeNodeFetchContext
	 * @param iTreeNode
	 * @return
	 * @throws Exception
	 */
	boolean isOutputTreeNode(ITreeNodeFetchContext iTreeNodeFetchContext, ITreeNode iTreeNode) throws Exception;
	
	
	
	
	/**
	 * 获取计数器对象标识
	 * 
	 * @return
	 */
	String getCounterId();

}
