package net.ibizsys.model.dataentity.mainstate;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;


/**
 * 实体主数据状态相关实体行为
 * @author lionlau
 *
 */
public interface IPSDEMainStateAction extends IPSModelObject
{
	
	
	/**
	 * 获取实体主状态
	 * @return
	 */
	IPSDEMainState getPSDEMainState();
	
	/**
	 * 获取实体行为标识
	 * @return
	 */
	String getPSDEActionId();
	
	
	
	/**
	 * 获取实体操作
	 * @return
	 */
	IPSDEAction getPSDEAction();
}
