package net.ibizsys.ssdyna.view;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.view.IDynaView;
import net.ibizsys.ssdyna.appmodel.IDynaAppModel;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;

/**
 * 动态应用视图模型对象接口
 * @author Administrator
 *
 */
public interface IDynaViewModel extends IDynaView,IViewController,IDynaViewController {

	/**
	 * 获取应用视图对象
	 * @return
	 */
	IPSAppView getPSAppView();
	
	
	
	/**
	 * 获取动态应用模型对象
	 * @return
	 */
	IDynaAppModel getDynaAppModel();
	
	
	/**
	 * 获取动态系统模型对象
	 * @return
	 */
	IDynaSysModel getDynaSysModel();
	
	
	/**
	 * 是否为动态视图实例模式
	 * @return
	 */
	boolean isDynaViewInstMode();
	
	
	/**
	 * 建立动态部件处理对象
	 * @param iPSControl
	 * @return
	 * @throws Exception
	 */
	IDynaCtrlHandler createDynaCtrlHandler(IPSControl iPSControl)throws Exception;
	
	
	
	/**
	 * 建立动态部件模型对象
	 * @param iPSControl
	 * @return
	 * @throws Exception
	 */
	IDynaCtrlModel createDynaCtrlModel(IPSControl iPSControl)throws Exception;
	
	
	
	/**
	 * 注册动态界面行为对象
	 * @param strActionTag
	 * @param iDynaUIActionModel
	 * @throws Exception
	 */
	void registerDynaUIActionModel(String strActionTag, IDynaUIActionModel iDynaUIActionModel) throws Exception;
	
	
	
	
	/**
	 * 获取动态界面行为对象集合
	 * @return
	 */
	java.util.Iterator<IDynaUIActionModel> getDynaUIActionModels();
}
