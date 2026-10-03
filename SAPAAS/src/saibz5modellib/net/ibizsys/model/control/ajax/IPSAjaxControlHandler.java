package net.ibizsys.model.control.ajax;

import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.dataentity.IPSDataEntity;

/**
 * Ajax异步控件后台处理对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSAjaxControlHandler extends IPSAjaxHandler {

	// 定义缓存范围代码表

	/**
	 * 缓存范围：无
	 */
	public final static int CACHESCOPE_NONE = 0;

	/**
	 * 缓存范围：系统全局
	 */
	public final static int CACHESCOPE_GLOBAL = 1;

	/**
	 * 缓存范围：组织机构全局
	 */
	public final static int CACHESCOPE_ORG = 2;

	/**
	 * 缓存范围：用户全局
	 */
	public final static int CACHESCOPE_USER = 3;

	/**
	 * 缓存范围：应用全局
	 */
	public final static int CACHESCOPE_APP = 4;

	

	/**
	 * 是否启用属性权限控制
	 * 
	 * @return
	 */
	boolean isEnableDEFieldPrivilege();

	/**
	 * 是否支持指定操作
	 * 
	 * @param strAjaxActionName
	 * @return
	 */
	boolean isEnableAjaxAction(String strAjaxActionName);

	/**
	 * 获取操作对应的实体行为
	 * 
	 * @param strAjaxActionName
	 * @return
	 */
	String getDEActionName(String strAjaxActionName);

	/**
	 * 获取数据访问行为
	 * 
	 * @param strAjaxActionName
	 * @return
	 */
	String getDataAccessAction(String strAjaxActionName);

	/**
	 * 获取支持的请求
	 * 
	 * @return
	 */
	java.util.Iterator<String> getAjaxActions();

	/**
	 * 获取临时数据模式
	 * 
	 * @return
	 */
	int getTempMode();

//	/**
//	 * 获取预置的后台服务处理对象
//	 * 
//	 * @return
//	 */
//	IPSSFACHandler getPSSFACHandler();

//	/**
//	 * 是否支持缓存
//	 * 
//	 * @return
//	 */
//	boolean isEnableCache();

//	/**
//	 * 获取缓存的超时时长
//	 * 
//	 * @return
//	 */
//	int getCacheTimeout();

//	/**
//	 * 获取缓存的范围，值参考 SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxControlHandler.CACHESCOPE_XXX 定义
//	 * 
//	 * @return
//	 */
//	int getCacheScope();
	
	
//	/**
//	 * 获取系统统一状态对象
//	 * @return
//	 */
//	IPSSysUniState getPSSysUniState();
	
	
	
//	/**
//	 * 获取统一状态键值
//	 * @return
//	 */
//	String getUniStateKeyValue();
//	
//	
//	
//	/**
//	 * 获取统一状态属性
//	 * @return
//	 */
//	String getUniStateField();

	
	
	/**
	 * 获取用户标记
	 * @return
	 */
	String getUserTag();
	
	
	/**
	 * 获取用户标记2
	 * @return
	 */
	String getUserTag2();
	
	
	/**
	 * 获取用户标记3
	 * @return
	 */
	String getUserTag3();
	
	/**
	 * 获取用户标记4
	 * @return
	 */
	String getUserTag4();

	/**
	 * 获取异步控件对象
	 * @return
	 */
	IPSAjaxControl getPSAjaxControl();
	
	

	
	/**
	 * 获取异步控件处理对象实体对象
	 * @return
	 */
	IPSDataEntity getPSDataEntity();
	
}
