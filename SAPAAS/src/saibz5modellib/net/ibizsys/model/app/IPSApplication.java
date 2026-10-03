package net.ibizsys.model.app;

import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.paas.core.IApplication;


public interface IPSApplication extends IPSSystemObject,IApplication,IPSModelObject {

	/**
	 * 查找指定应用功能
	 * @param strPSAppFuncId
	 * @return
	 * @throws Exception
	 */
	IPSAppFunc getPSAppFunc(String strPSAppFuncId)throws Exception;
	
	/**
	 * 获取应用程序界面定义
	 * @return
	 */
	IPSApplicationUI getPSApplicationUI();
	
	
	
	/**
	 * 是否为移动端应用
	 * @return
	 */
	boolean isMobileApp();
	
	
	
	/**
	 * 获取应用技术
	 * @return
	 */
	String getPFType();
	
	
	
	
	/**
	 * 获取应用技术样式
	 * @return
	 */
	String getPFStyle();
	
	
	
	/**
	 * 获取代码包名称
	 * @return
	 */
	String getPKGCodeName();
	
	
	
	
	/**
	 * 获取代码目录
	 * @return
	 */
	String getCodeFolder();
	
	
	/**
	 * 获取全部应用功能页面
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSAppUtilPage> getAllPSAppUtilPages()throws Exception;
	
	
	/**
	 * 查找指定应用功能界面
	 * @param strPSAppUtilPageId
	 * @return
	 * @throws Exception
	 */
	IPSAppUtilPage getPSAppUtilPage(String strPSAppUtilPageId)throws Exception;
	
	
	
	/**
	 * 启用统一认证登录
	 * @return
	 */
	boolean isEnableUACLogin();
	
	
	/**
	 * 查找指定视图
	 * @param strPSApplicationViewId
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	IPSAppView getPSAppView(String strPSApplicationViewId, boolean bTryMode) throws Exception;
	
	
	/**
	 * 获取默认发布标识
	 * @return
	 */
	boolean getDefaultFlag();
	
	
	/**
	 * 查找指定应用模块
	 * @param strPSAppModuleId
	 * @return
	 * @throws Exception
	 */
	IPSAppModule getPSAppModule(String strPSAppModuleId)throws Exception;
	
	
	
	
	/**
	 * 获取应用程序目录
	 * @return
	 */
	String getAppFolder();
	
}
