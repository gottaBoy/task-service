package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.core.IPSModelObject;



/**
 * 实体逻辑连接对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSDELogicLink extends IPSModelObject {
	

	/**
	 * 获取逻辑连接条件
	 * 
	 * @return
	 */
	IPSDELogicLinkGroupCond getPSDELogicLinkGroupCond();

	/**
	 * 获取目标逻辑节点对象
	 * 
	 * @return
	 * @throws Exception
	 */
	IPSDELogicNode getDstPSDELogicNode() throws Exception;

	/**
	 * 获取起始逻辑节点对象
	 * 
	 * @return
	 * @throws Exception
	 */
	IPSDELogicNode getSrcPSDELogicNode() throws Exception;

	/**
	 * 获取实体逻辑对象
	 */
	IPSDELogic getPSDELogic();
	
	
	/**
	 * 获取全部逻辑连接条件对象集合
	 * @return
	 */
	java.util.Iterator<IPSDELogicLinkCond> getAllPSDELogicLinkConds();
}
