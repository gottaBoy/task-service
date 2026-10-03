package net.ibizsys.model.control.tree;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.paas.ctrlmodel.ITreeNodeRSModel;



/**
 * 实体树节点关系对象接口
 * @author Administrator
 *
 */
public interface IPSDETreeNodeRS extends IPSModelObject,ITreeNodeRSModel
{

	
	/**
	 * 获取树视图部件
	 * @return
	 */
	IPSDETree getPSDETree();
	
	
	/**
	 * 获取上级树节点标识
	 * @return
	 */
	String getPPSTreeNodeId();
	
	
	
	/**
	 * 获取下级树节点标识
	 * @return
	 */
	String getCPSTreeNodeId();
	
	
	
	
	/**
	 * 获取处理排序值，按升序处理
	 * @return
	 */
	int getOrderValue();
	
	
	
	/**
	 * 获取处理实体行为
	 * @return
	 */
	IPSDEAction getPSDEAction();
	
	
	/**
	 * 获取父树节点对象
	 * @return
	 * @throws Exception
	 */
	IPSDETreeNode getParentPSDETreeNode() throws Exception;
	
	
	/**
	 * 获取子树节点对象
	 * @return
	 * @throws Exception
	 */
	IPSDETreeNode getChildPSDETreeNode() throws Exception;
}
