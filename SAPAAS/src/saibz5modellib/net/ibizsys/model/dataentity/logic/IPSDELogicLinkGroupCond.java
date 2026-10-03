package net.ibizsys.model.dataentity.logic;


/**
 * 实体逻辑链接组合条件对象接口
 * @author lionlau
 *
 */
public interface IPSDELogicLinkGroupCond extends IPSDELogicLinkCond
{
	/**
	 * 获取组逻辑，具体参考 net.ibizsys.paas.logic.ICondition.CONDOP_XXX 定义
	 * @return
	 */
	String getGroupOP();
	
	
	/**
	 * 是否取反
	 * @return
	 */
	boolean isNotMode();
	
	
	
	/**
	 * 获取子逻辑集合
	 * @return
	 */
	java.util.Iterator<IPSDELogicLinkCond> getPSDELogicLinkConds();
}
