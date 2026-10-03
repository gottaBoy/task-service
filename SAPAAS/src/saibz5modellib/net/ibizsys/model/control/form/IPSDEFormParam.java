package net.ibizsys.model.control.form;

import net.ibizsys.model.control.IPSAjaxControlParam;

/**
 * 表单部件参数对象接口
 * @author lionlau
 *
 */
public interface IPSDEFormParam extends IPSAjaxControlParam
{
	/**
	 * 获取实体表单标识
	 * @return
	 */
	String getPSDEFormId();
}
