package net.ibizsys.paas.view;

import java.util.ArrayList;

import net.ibizsys.paas.controller.IViewController;

/**
 * 视图向导组模型
 * @author Administrator
 *
 */
public interface IViewWizardGroupModel extends IViewWizardGroup {
	
		
	
	/**
	 * 填充视图向导集合
	 * @param iViewController 
	 * @param strQuery
	 * @param viewWizardList
	 * @throws Exception
	 */
	void fillViewWizards(IViewController iViewController,String strQuery,ArrayList<IViewWizard> viewWizardList) throws Exception;
	
	
	
	/**
	 * 获取指定的视图向导
	 * @param strViewWizard
	 * @return
	 * @throws Exception
	 */
	IViewWizard getViewWizard(String strViewWizard)throws Exception;
}
