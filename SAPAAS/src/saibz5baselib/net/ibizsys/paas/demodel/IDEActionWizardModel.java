package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEActionWizard;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.view.IViewWizardModel;

/**
 * 实体操作向导模型接口
 * @author Administrator
 *
 */
public interface IDEActionWizardModel extends IDEActionWizard,IViewWizardModel,IModelBase3{
	
	/**
	 * 注册实体操作向导项模型
	 * @param iDEActionWizardItemModel
	 * @throws Exception
	 */
	void registerDEActionWizardItemModel(IDEActionWizardItemModel iDEActionWizardItemModel) throws Exception;
	
	

}
