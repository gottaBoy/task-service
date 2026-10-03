package net.ibizsys.model.dataentity.uiaction;

import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.paas.core.IDEUIAction;


/**
 * 实体界面行为对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSDEUIAction extends IPSDataEntityObject, IPSUIAction, IDEUIAction {
	
	final String UIACTIONTYPE_DEUIACTION = "DEUIACTION";

	
	/**
	 * 获取预定义实体界面行为
	 * 
	 * @return
	 */
	String getPSSysDEUIActionId(Object obj) throws Exception;

	/**
	 * 获取实体行为对象
	 * 
	 * @return
	 */
	IPSDEAction getPSDEAction();


	
	
	/**
	 * 获取前端实体界面标识
	 * @return
	 */
	String getFrontPSDEViewId();

	
	
	
	/**
	 * 获取扩展模式，值参考 SA.SRFDA.PS.Core.DataEntity.IPSDataEntity.EXTENDMODE_XXX 定义
	 * 
	 * @return
	 */
	int getExtendMode();
}
