package net.ibizsys.model.control.form;

import net.ibizsys.model.dataentity.wizard.IPSDEWizardForm;

/**
 * 实体向导编辑表单参数对象接口
 * @author Administrator
 *
 */
public interface IPSDEWizardEditFormParam extends IPSDEEditFormParam {

	/**
	 * 获取对应的实体向导编辑表单对象
	 * @return
	 */
	IPSDEWizardForm getPSDEWizardForm();
	
}
