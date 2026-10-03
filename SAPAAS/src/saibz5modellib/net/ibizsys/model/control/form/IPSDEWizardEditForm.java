package net.ibizsys.model.control.form;

import net.ibizsys.model.dataentity.wizard.IPSDEWizardForm;


/**
 * 实体向导编辑表单对象接口
 * @author Administrator
 *
 */
public interface IPSDEWizardEditForm extends IPSDEEditForm{

	/**
	 * 获取向导表单对象
	 * @return
	 */
	IPSDEWizardForm getPSDEWizardForm();
	
}
