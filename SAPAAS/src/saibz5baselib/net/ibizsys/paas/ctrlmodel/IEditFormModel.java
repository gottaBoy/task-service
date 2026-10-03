package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.form.IEditForm;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.service.IService;

/**
 * 编辑表单模型接口
 * 
 * @author Administrator
 *
 */
public interface IEditFormModel extends IFormModel, IEditForm {
	/**
	 * 判断值规则
	 * 
	 * @param iService
	 * @param iDataObject
	 * @param bUpdate 是否为更新模式
	 * @throws Exception
	 */
	void testValueRule(IService iService, IDataObject iDataObject, boolean bUpdate) throws Exception;

	/**
	 * 转换实体属性错误
	 * 
	 * @param entityFieldError
	 * @throws Exception
	 */
	boolean convertEntityFieldError(EntityFieldError entityFieldError) throws Exception;
}
