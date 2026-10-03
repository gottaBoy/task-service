package net.ibizsys.model.control.form;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;


/**
 * 表单项更新逻辑对象接口
 * @author lionlau
 *
 */
public interface IPSDEFormItemUpdate  extends IPSModelObject
{

	/**
	 * 获取表单对象
	 * @return
	 */
	IPSDEForm  getPSDEForm();
	
	
	/**
	 * 获取代码名称
	 * @return
	 */
	String getCodeName();
	
	/**
	 * 获取表单更新处理成员集合
	 * @return
	 */
	java.util.Iterator<IPSDEFIUpdateDetail> getPSDEFIUpdateDetails();
	
	
	
	/**
	 * 获取后台调用的实体行为
	 * @return
	 * @throws Exception
	 */
	IPSDEAction getPSDEAction()  throws Exception;
	
}
