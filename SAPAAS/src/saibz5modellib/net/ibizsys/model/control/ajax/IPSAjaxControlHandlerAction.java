package net.ibizsys.model.control.ajax;

import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;

/**
 * 异步处理对象行为接口
 * @author Administrator
 *
 */
public interface IPSAjaxControlHandlerAction extends IPSAjaxHandlerAction {

	/**
	*行为类型：实体行为
	*/
	final static String ACTIONTYPE_DEACTION = "DEACTION" ;

	/**
	*行为类型：实体结果集
	*/
	final static String ACTIONTYPE_DEDATASET = "DEDATASET" ;
	
	
	/**
	 * 获取行为类型，值参考 SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandlerAction.ACTIONTYPE_XXX 定义
	 * @return
	 */
	String getActionType();
	
	/**
	 * 获取行为需要的实体操作标识
	 * @return
	 */
	IPSDEOPPriv getPSDEOPPriv();
	
	
	/**
	 * 获取实体行为
	 * @return
	 */
	IPSDEAction getPSDEAction();
	
	
	/**
	 * 获取实体行为名称
	 * @return
	 */
	String getDEActionName();
	
	
	/**
	 * 获取相应的实体对象
	 * @return
	 */
	IPSDataEntity getPSDataEntity();
	
	
	
	/**
	 * 获取数据访问行为
	 * @return
	 */
	String getDataAccessAction();
	

}
