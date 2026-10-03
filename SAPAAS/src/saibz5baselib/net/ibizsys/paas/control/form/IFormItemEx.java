package net.ibizsys.paas.control.form;


/**
 * 复合表单项接口
 * @author Administrator
 *
 */
public interface IFormItemEx extends IFormItem{

	/**
	 * 获取子项名称集合
	 * @return
	 */
	java.util.Iterator<String> getItemNames(); 
}
