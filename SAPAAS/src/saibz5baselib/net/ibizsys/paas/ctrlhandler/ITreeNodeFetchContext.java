package net.ibizsys.paas.ctrlhandler;

/**
 * 树节点获取上下文对象
 * 
 * @author Administrator
 *
 */
public interface ITreeNodeFetchContext {
	/**
	 * 获取树视图分类
	 * 
	 * @return
	 */
	String getCatalog();

	/**
	 * 获取节点过滤
	 * 
	 * @return
	 */
	String getNodeFilter();

	/**
	 * 是否自动展开节点
	 * 
	 * @return
	 */
	boolean isAutoExpand();

	/**
	 * 获取实际节点标识
	 * 
	 * @return
	 */
	String getRealNodeId();

	/**
	 * 输出简单模式
	 * 
	 * @return
	 */
	boolean isSimpleMode();
}
