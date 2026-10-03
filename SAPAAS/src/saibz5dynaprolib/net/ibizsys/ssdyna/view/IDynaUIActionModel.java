package net.ibizsys.ssdyna.view;

import net.ibizsys.model.IPSModelJsonExporter;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.paas.view.IUIAction;

/**
 * 动态界面行为对象
 * @author Administrator
 *
 */
public interface IDynaUIActionModel extends IUIAction,IPSModelJsonExporter{

	/**
	 * 初始化
	 * @param iDynaViewModel
	 * @param iPSUIAction
	 * @throws Exception
	 */
	void init(IDynaViewModel iDynaViewModel, IPSUIAction iPSUIAction) throws Exception;
	
	/**
	 * 获取动态视图模型对象
	 * @return
	 */
	IDynaViewModel getDynaViewModel();
	
	
	
	/**
	 * 获取界面行为对象
	 * @return
	 */
	IPSUIAction getPSUIAction();
}
