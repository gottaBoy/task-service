package net.ibizsys.paas.ctrlmodel;


/**
 * 应用菜单模型全局对象插件
 * @author Administrator
 *
 */
public interface IAppMenuModelGlobalPlugin {
	/**
	 * 注册应用菜单模型
	 * 
	 * @param strAppMenuModelClsType
	 * @param iAppMenuModel
	 */
	  void registerAppMenuModel(String strAppMenuModelClsType, IAppMenuModel iAppMenuModel) ;

	/**
	 * 获取应用菜单模型
	 * 
	 * @param strAppMenuModelClsType
	 * @return
	 * @throws Exception
	 */
	  IAppMenuModel getAppMenuModel(Class cls) throws Exception ;

	/**
	 * 获取应用菜单模型
	 * 
	 * @param strAppMenuModelClsType
	 * @return
	 * @throws Exception
	 */
	IAppMenuModel getAppMenuModel(String strAppMenuModelClsType) throws Exception;
	
	
	
	
	/**
	 * 获取全部应用菜单模型
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IAppMenuModel> getAllAppMenuModels() throws Exception;
}
