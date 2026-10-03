package net.ibizsys.model.res;

import net.ibizsys.model.IPSSystemObject;


/**
 * 系统门户部件接口
 * 
 * @author lionlau
 *
 */
public interface IPSSysPortlet extends IPSSystemObject {
	

	/**
	 * 获取标题
	 * 
	 * @return
	 */
	String getTitle();

	/**
	 * 获取部件类型
	 * 
	 * @return
	 */
	String getPortletType();



	/**
	 * 获取刷新间隔
	 * 
	 * @return
	 */
	int getReloadTimer();

	/**
	 * 是否显示标题栏
	 * 
	 * @return
	 */
	boolean isShowTitleBar();

//	/**
//	 * 获取标题栏应用插件
//	 * 
//	 * @return
//	 */
//	IPSSysPFPlugin getTitlePSSysPFPlugin();
//
	/**
	 * 获取标题语言资源
	 * 
	 * @return
	 */
	@Deprecated
	IPSLanguageRes getTitlePSIpsLanguageRes();

	/**
	 * 获取标题语言资源
	 * 
	 * @return
	 */
	IPSLanguageRes getTitlePSLanguageRes();

//	/**
//	 * 获取后台服务基类对象
//	 * 
//	 * @param strPSSFStyleId
//	 * @return
//	 * @throws Exception
//	 */
//	String getBaseClass(String strPSSFStyleId) throws Exception;

	/**
	 * 获取部件高度
	 * 
	 * @return
	 */
	int getHeight();

	/**
	 * 获取门户部件类型
	 * 
	 * @return
	 */
	IPSPortletType getPSPortletType();

	/**
	 * 获取无值显示内容语言资源对象
	 * 
	 * @return
	 */
	IPSLanguageRes getEmptyTextPSLanguageRes();

	/**
	 * 获取无值显示内容
	 * 
	 * @return
	 */
	String getEmptyText();
	
	
	
	/**
	 * 获取部件后台处理对象
	 * @return
	 */
	String getPSACHandlerId();
}
