package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.core.IModelBase;

/**
 * 树节点关系模型接口
 * 
 * @author Administrator
 *
 */
public interface ITreeNodeRSModel extends IModelBase {
	
	
	/**
	 * 搜索模式，有搜索启用
	 */
	final int SEARCHMODE_YES = 1;
	
	
	/**
	 * 搜索模式，无搜索启用
	 */
	final int SEARCHMODE_NO = 2;
	
	
	/**
	 * 搜索模式，全部启用
	 */
	final int SEARCHMODE_ALL = 3;
	
	
	/**
	 * 获取父树节点标识
	 * 
	 * @return
	 */
	String getParentTreeNodeId();

	/**
	 * 获取子树节点标识
	 * 
	 * @return
	 */
	String getChildTreeNodeId();

	/**
	 * 获取处理的行为名称
	 * 
	 * @return
	 */
	String getDEActionName();

	
	
	
	/**
	 * 搜索模式启用的关系
	 * @return
	 */
	int getSearchMode();

}
