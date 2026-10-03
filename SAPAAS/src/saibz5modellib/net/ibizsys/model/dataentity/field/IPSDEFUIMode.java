package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.control.form.IPSDEFFormItem;
import net.ibizsys.model.control.grid.IPSDEFGridColumn;


/**
 * 属性界面模式对象接口
 * @author Administrator
 *
 */
public interface IPSDEFUIMode extends IPSDEFieldObject
{
	

	/**
	 * 获取编辑表单项界面模式配置对象
	 * @return
	 */
	IPSDEFFormItem getPSDEFFormItem();
	
	
	
	
	/**
	 * 获取表格列界面模式对象
	 * @return
	 */
	IPSDEFGridColumn getPSDEFGridColumn();
	
}
