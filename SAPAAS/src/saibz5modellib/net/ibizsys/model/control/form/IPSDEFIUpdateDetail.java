package net.ibizsys.model.control.form;

import net.ibizsys.model.core.IPSModelObject;


/**
 * 实体表单更新更新成员对象接口
 * @author Administrator
 *
 */
public interface IPSDEFIUpdateDetail extends IPSModelObject
{
	
	
	/**
	 * 获取表单项名称
	 * @return
	 */
	String getPSDEFormDetailName();
	
	
	/**
	 * 获取表单项标识
	 * @return
	 */
	String getPSDEFormDetailId();
}
