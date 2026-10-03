package net.ibizsys.paas.view;

import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.paas.ctrlmodel.IDynaEditFormModel;
import net.ibizsys.paas.ctrlmodel.IDynaSearchFormModel;
import net.ibizsys.paas.ctrlmodel.IDynaToolbarModel;
import net.ibizsys.paas.sysmodel.IDynaSystemSettingModel;

/**
 * 动态视图设置对象模型接口
 * @author Administrator
 *
 */
public interface IDynaViewSettingModel extends IDynaViewSetting {

	/**
	 * 初始化
	 * @param iDynaSystemSettingModel
	 * @throws Exception
	 */
	void init(IDynaSystemSettingModel iDynaSystemSettingModel)throws Exception;
	
	
	/**
	 * 获取动态系统设置模型对象
	 * @return
	 */
	IDynaSystemSettingModel getDynaSystemSettingModel();
	
	/**
	 * 创建动态视图控制器实例
	 * @param iDynaViewController
	 * @param strDynaViewInstId
	 * @return
	 * @throws Exception
	 */
	IDynaViewControllerInst createDynaViewControllerInst(IDynaViewController iDynaViewController,String strDynaViewInstId)throws Exception;
	
	
	
	/**
	 * 创建动态部件模型
	 * @param strCtrlType
	 * @param ctrlParam
	 * @return
	 * @throws Exception
	 */
	IDynaCtrlModel createDynaCtrlModel(String strCtrlType,Object ctrlParam)throws Exception;
	
	
	
	/**
	 * 建立动态部件处理对象
	 * @param iDynaCtrlModel
	 * @return
	 * @throws Exception
	 */
	IDynaCtrlHandler createDynaCtrlHandler(IDynaCtrlModel iDynaCtrlModel)throws Exception;
	
	
	
	/**
	 * 建立动态工具栏模型对象
	 * @return
	 */
	IDynaToolbarModel createDynaToolbarModel();
	
	
	
	/**
	 * 建立动态编辑表单模型对象
	 * @return
	 */
	IDynaEditFormModel createDynaEditFormModel();
	
	
	
	/**
	 * 建立动态搜索表单模型对象
	 * @return
	 */
	IDynaSearchFormModel createDynaSearchFormModel();
	
	
	
}
