package net.ibizsys.model.control.expbar;

import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.paas.control.expbar.ExpBarRootItem;


/**
 * 导航栏部件接口
 * @author lionlau
 *
 */
public interface IPSExpBar extends IPSAjaxControl
{

	/**
	 * 获取根节点 
	 * @return
	 */
	ExpBarRootItem getRootItem();
	
	
	
//	/**
//	 * 获取系统计数器
//	 * @return
//	 */
//	IPSSysCounter getPSSysCounter();
//
//	
	
//	/**
//	 * 获取系统计数器引用
//	 * @return
//	 */
//	IPSSysCounterRef getPSSysCounterRef();
	
	
	
	
	
	/**
	 * 获取导航栏标题
	 * @return
	 */
	String getTitle();
	
	
	
//	/**
//	 * 获取标题语言资源对象
//	 * @return
//	 */
//	IPSLanguageRes getTitlePSLanguageRes();
	
	
	
	/**
	 * 是否支持界面计数器
	 * @return
	 */
	boolean isEnableCounter();
}
