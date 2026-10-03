package net.ibizsys.model.control.tree;

import net.ibizsys.model.core.IPSModelObject;



/**
 * 实体树节点关联视图对象接口
 * @author Administrator
 *
 */
public interface IPSDETreeNodeRV extends IPSModelObject
{


	
	/**
	 * 获取应用视图标识
	 * @return
	 */
	String getPSDEViewBaseId();
	
	/**
	 * 获取树节点
	 * @return
	 */
	IPSDETreeNode getPSDETreeNode();
	

	/**
	 * 获取视图参数
	 * @return
	 */
	String getViewParam();
}
