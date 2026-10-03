package net.ibizsys.paas.control.form;

/**
 * 编辑表单接口
 * 
 * @author lionlau
 *
 */
public interface IEditForm extends IForm {
	/**
	 * 加载数据
	 */
	final static String LoadAction = "load";

	/**
	 * 建立数据
	 */
	final static String CreateAction = "create";

	/**
	 * 更新数据
	 */
	final static String UpdateAction = "update";
	
	

}
