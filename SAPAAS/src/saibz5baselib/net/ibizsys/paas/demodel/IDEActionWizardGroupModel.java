package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEActionWizardGroup;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.view.IViewWizardGroupModel;

/**
 * 实体操作向导组模型接口
 * @author Administrator
 *
 */
public interface IDEActionWizardGroupModel extends IDEActionWizardGroup,IViewWizardGroupModel,IModelBase3 {
	
	/**
	 * 注册实体操作向导模型
	 * @param iDEActionWizardModel
	 * @throws Exception
	 */
	void registerDEActionWizardModel(IDEActionWizardModel iDEActionWizardModel) throws Exception;
	
	
	
	
}
