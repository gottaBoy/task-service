package net.ibizsys.ssdyna.sysmodel;

import net.ibizsys.model.dynasys.IPSDynaInst;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.core.IModelBase2;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;
import net.ibizsys.ssdynawf.core.IDynaWFModel;

/**
 * 动态实例模型对象接口
 * @author Administrator
 *
 */
public interface IDynaInstModel extends IModelBase2{

	/**
	 * 初始化动态实例
	 * @param iDynaSysModel
	 * @param iPSDynaInst
	 * @throws Exception
	 */
	void init(IDynaSysModel iDynaSysModel,IPSDynaInst iPSDynaInst)throws Exception;

	
	/**
	 * 获取动态标记
	 * @return
	 */
	String getDynaTag();

	
//	/**
//	 * 获取实体模型
//	 * @param strDEName
//	 * @param bIncludeOtherSys
//	 * @return
//	 * @throws Exception
//	 */
//	IDataEntityModel getDataEntityModel(String strDEName, boolean bIncludeOtherSys) throws Exception ;
//	
//	/**
//	 * 获取服务对象
//	 * @param iPSDataEntity
//	 * @param sessionFactory
//	 * @return
//	 * @throws Exception
//	 */
//	IDynaService getDynaService(IPSDataEntity iPSDataEntity,SessionFactory sessionFactory)throws Exception;
	
	
	
	/**
	 * 是否存在指定动态实体
	 * @param strDEName
	 * @return
	 * @throws Exception
	 */
	boolean containsDynaDEModel(String strDEName)throws Exception;
	
	
	
	/**
	 * 获取指定动态实体
	 * @param strDEName
	 * @return
	 * @throws Exception
	 */
	IDynaDEModel getDynaDEModel(String strDEName,boolean bTryMode) throws Exception;
	
	
	
	
	/**
	 * 注册动态实体模型
	 * @param iDynaDEModel
	 */
	void registerDynaDEModel(IDynaDEModel iDynaDEModel)throws Exception;
	
	
	
//	
//	
//	
//	
//	
//	/**
//	 * 获取动态实例对象
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDynaInst getPSDynaInst()throws Exception;
//	
//	
//	
	
	
	
	/**
	 * 获取动态系统模型对象
	 * @return
	 */
	IDynaSysModel getDynaSysModel();
	
	
	
	/**
	 * 注册动态应用视图模型
	 * @param iAppViewModel
	 * @throws Exception
	 */
	void registerDynaAppViewModel(IAppViewModel iAppViewModel) throws Exception;
	
	
	
	/**
	 * 是否存在指定动态应用视图模型
	 * @param strDynaAppViewModel
	 * @return
	 */
	boolean containsDynaAppViewModel(String strDynaAppViewModelId);
	
	
	
	/**
	 *获取指定动态应用视图模型
	 * @param strDynaAppViewModelId
	 * @return
	 */
	IAppViewModel getDynaAppViewModel(String strDynaAppViewModelId,boolean bTryMode)throws Exception;
	
	
	
	
	
	/**
	 * 获取指定动态工作流
	 * @param strDEName
	 * @return
	 * @throws Exception
	 */
	IDynaWFModel getDynaWFModel(String strDEName) throws Exception;
	
	
	
	
	/**
	 * 注册动态工作流模型
	 * @param iDynaWFModel
	 */
	void registerDynaWFModel(IDynaWFModel iDynaWFModel)throws Exception;
	

	
	/**
	 * 是否存在指定工作流模型
	 * @param strWFName
	 * @return
	 * @throws Exception
	 */
	boolean containsDynaWFModel(String strWFName)throws Exception;
	
	
	/**
	 * 获取指定动态视图实例
	 * @param strDynaViewControllerInstId
	 * @return
	 * @throws Exception
	 */
	IDynaViewControllerInst getDynaViewControllerInst(String strDynaViewControllerInstId,boolean bTryMode) throws Exception;
	
	
	
	
	/**
	 * 注册动态视图实例
	 * @param iDynaViewControllerInst
	 */
	void registerDynaViewControllerInst(IDynaViewControllerInst iDynaViewControllerInst)throws Exception;
	

	
	/**
	 * 是否存在指定动态视图实例
	 * @param strWFName
	 * @return
	 * @throws Exception
	 */
	boolean containsDynaViewControllerInst(String strDynaViewControllerInstId)throws Exception;

}
