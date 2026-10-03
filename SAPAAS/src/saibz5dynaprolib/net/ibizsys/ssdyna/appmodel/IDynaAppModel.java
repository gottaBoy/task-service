package net.ibizsys.ssdyna.appmodel;

import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;

/**
 * 动态应用模型对象接口
 * @author Administrator
 *
 */
public interface IDynaAppModel extends net.ibizsys.saas.appmodel.ISaaSAppModel {

	
	/**
	 * 获取动态应用视图对象
	 * @param strAppViewId
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	IDynaViewModel getDynaViewModel(String strAppViewId,boolean bTryMode)throws Exception;
	
	
	
	/**
	 * 获取系统应用模型对象
	 * @return
	 */
	IPSApplication getPSApplication() throws Exception;
	
	
	/**
	 * 获取动态系统模型对象
	 * @return
	 */
	IDynaSysModel getDynaSysModel();

	
	/**
	 * 创建动态部件模型
	 * @param iDynaViewModel
	 * @param iPSControl
	 * @return
	 * @throws Exception
	 */
	IDynaCtrlModel createDynaCtrlModel(IDynaViewModel iDynaViewModel, IPSControl iPSControl)throws Exception;
	
	
	
	
	/**
	 * 创建动态部件处理对象
	 * @param iDynaViewModel
	 * @param iPSControl
	 * @return
	 * @throws Exception
	 */
	IDynaCtrlHandler createDynaCtrlHandler(IDynaViewModel iDynaViewModel, IPSControl iPSControl)throws Exception;
}
