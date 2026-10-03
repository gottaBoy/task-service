package net.ibizsys.model.control.form;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule;


/**
 * 实体表单项值规则对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSDEFormItemVR extends IPSModelObject {
	// 定义检查方式代码表

	/**
	 * 检查方式：前台
	 */
	public final static int CHECKMODE_FRONT = 1;

	/**
	 * 检查方式：后台
	 */
	public final static int CHECKMODE_BACKEND = 2;

	/**
	 * 检查方式：前后台
	 */
	public final static int CHECKMODE_ALL = 3;

	

	/**
	 * 获取表单项名称
	 * 
	 * @return
	 */
	String getPSDEFormItemName();

	/**
	 * 获取表单对象
	 * 
	 * @return
	 */
	IPSDEForm getPSDEForm();

	/**
	 * 获取对应的实体属性规则对象
	 * 
	 * @return
	 */
	IPSDEFValueRule getPSDEFValueRule();

	/**
	 * 获取表单项对象
	 * 
	 * @return
	 */
	IPSDEFormItem getPSDEFormItem();
	
	
	/**
	 * 获取检查模式，值参考 SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemVR.CHECKMODE_XXX 定义
	 * @return
	 */
	int getCheckMode();

}
