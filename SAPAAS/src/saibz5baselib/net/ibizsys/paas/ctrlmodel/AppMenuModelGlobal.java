package net.ibizsys.paas.ctrlmodel;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.util.StringHelper;

/**
 * 应用菜单模型全局存储对象
 * 
 * @author lionlau
 *
 */
public class AppMenuModelGlobal {
	private static final Log log = LogFactory.getLog(AppMenuModelGlobal.class);
	private static HashMap<String, IAppMenuModel> appMenuModelMap = new HashMap<String, IAppMenuModel>();
	private static IAppMenuModelGlobalPlugin iAppMenuModelGlobalPlugin = null;
	/**
	 * 注册应用菜单模型
	 * 
	 * @param strAppMenuModelClsType
	 * @param iAppMenuModel
	 */
	public static void registerAppMenuModel(String strAppMenuModelClsType, IAppMenuModel iAppMenuModel) {
		if(getPlugin()!=null){
			getPlugin().registerAppMenuModel(strAppMenuModelClsType, iAppMenuModel);
			return ;
		}
		if (!appMenuModelMap.containsKey(strAppMenuModelClsType)) {
			appMenuModelMap.put(strAppMenuModelClsType, iAppMenuModel);
		}

	}

	/**
	 * 获取应用菜单模型
	 * 
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public static IAppMenuModel getAppMenuModel(Class cls) throws Exception {
		if(getPlugin()!=null){
			return getPlugin().getAppMenuModel(cls);
		}
		return getAppMenuModel(cls.getCanonicalName());
	}

	/**
	 * 获取应用菜单模型
	 * 
	 * @param strAppMenuModelClsType
	 * @return
	 * @throws Exception
	 */
	public static IAppMenuModel getAppMenuModel(String strAppMenuModelClsType) throws Exception {
		if(getPlugin()!=null){
			return getPlugin().getAppMenuModel(strAppMenuModelClsType);
		}
		IAppMenuModel iAppMenuModel = appMenuModelMap.get(strAppMenuModelClsType);
		if (iAppMenuModel == null) throw new Exception(StringHelper.format("无法获取指定应用菜单模型[%1$s]", strAppMenuModelClsType));
		return iAppMenuModel;
	}
	
	
	/**
	 * 获取全部应用菜单模型
	 * 
	 * @return
	 * @throws Exception
	 */
	public static	java.util.Iterator<IAppMenuModel> getAllAppMenuModels() throws Exception {
		if(getPlugin()!=null){
			return getPlugin().getAllAppMenuModels();
		}
		return appMenuModelMap.values().iterator();
	}
	
	/**
	 * 设置插件
	 * @param iAppMenuModelGlobalPlugin
	 */
	public static void setPlugin(IAppMenuModelGlobalPlugin iAppMenuModelGlobalPlugin){
		AppMenuModelGlobal.iAppMenuModelGlobalPlugin = iAppMenuModelGlobalPlugin;
	}
	
	public static IAppMenuModelGlobalPlugin getPlugin(){
		return AppMenuModelGlobal.iAppMenuModelGlobalPlugin; 
	}
}
