package net.ibizsys.model.dataentity.action;

import net.ibizsys.model.dataentity.logic.IPSDELogic;

/**
 * 实体逻辑行为对象接口
 * @author lionlau
 *
 */
public interface IPSDELogicAction extends IPSDEAction
{
	/**
	 * 获取对应的实体逻辑
	 * @return
	 */
	IPSDELogic getPSDELogic()throws Exception;
}
