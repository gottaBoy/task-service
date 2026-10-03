package net.ibizsys.model.control.grid;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;


/**
 * 表格编辑项值更新逻辑对象接口
 * @author lionlau
 *
 */
public interface IPSDEGridEditItemUpdate  extends IPSModelObject
{
	
	
	
	/**
	 * 获取表格对象
	 * @return
	 */
	IPSDEGrid  getPSDEGrid();
	
	
	/**
	 * 获取代码名称
	 * @return
	 */
	String getCodeName();
	
	
	/**
	 * 获取成员项清单
	 * @return
	 */
	java.util.Iterator<IPSDEGEIUpdateDetail> getPSDEGEIUpdateDetails();
	
	
	
	/**
	 * 获取后台调用的实体行为
	 * @return
	 * @throws Exception
	 */
	IPSDEAction getPSDEAction()  throws Exception;
	
}
