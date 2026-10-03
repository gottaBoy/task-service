package net.ibizsys.model.control.tree;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSMDAjaxControl;
import net.ibizsys.paas.control.tree.ITree;

/**
 * 实体树视图部件接口
 * @author lionlau
 *
 */
public interface IPSDETree extends IPSMDAjaxControl,ITree
{
	/**
	 * 是否支持根节点选择
	 * @return
	 */
	boolean isEnableRootSelect();
	
	
	
	/**
	 * 是否显示根节点
	 * @return
	 */
	boolean isRootVisible();
	
	
	/**
	 * 获取树节点集合
	 * @return
	 */
	java.util.Iterator<IPSDETreeNode> getPSDETreeNodes();
	
	
	/**
	 * 获取树节点关系集合
	 * @return
	 */
	java.util.Iterator<IPSDETreeNodeRS> getPSDETreeNodeRSs();
	

	/**
	 * 获取树节点关系
	 * @param strPSDETreeNodeRSId
	 * @return
	 * @throws Exception
	 */
	IPSDETreeNodeRS getPSDETreeNodeRS(String strPSDETreeNodeRSId) throws Exception;
	
	
	
	/**
	 * 获取指定树节点
	 * @param strPSDETreeNodeId
	 * @return
	 * @throws Exception
	 */
	IPSDETreeNode getPSDETreeNode(String strPSDETreeNodeId) throws Exception;
	
	
	
	/**
	 * 获取分类代码表
	 * @return
	 */
	IPSCodeList getCatPSCodeList();
	
	
	
//	/**
//	 * 获取无值显示内容语言资源对象
//	 * @return
//	 */
//	IPSLanguageRes getEmptyTextPSLanguageRes();
	
	
	/**
	 * 获取无值显示内容
	 * @return
	 */
	String getEmptyText();
	
	
	/**
	 * 获取树表格列集合，没有返回null
	 * @return
	 */
	java.util.Iterator<IPSDETreeColumn> getPSDETreeColumns();
	
	
	
	
	/**
	 * 获取指定树视图列对象
	 * @param strPSDETreeColumnId
	 * @return
	 * @throws Exception
	 */
	IPSDETreeColumn getPSDETreeColumn(String strPSDETreeColumnId) throws Exception;
	

	/**
	 * 是否启用树表格
	 * @return
	 */
	boolean isEnableTreeGrid();
	
	
	
	/**
	 * 是否使用缓存绘制模式，默认为是
	 * @return
	 */
	boolean isBufferRenderer();
}
