package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.form.IFormItemEx;

/**
 * 复合表单项模型对象接口
 * @author Administrator
 *
 */
public interface IFormItemExModel extends IFormItemModel,IFormItemEx{

	/**
	 * 注册子项名称
	 * @param strItemName
	 */
	void registerItemName(String strItemName);
}
