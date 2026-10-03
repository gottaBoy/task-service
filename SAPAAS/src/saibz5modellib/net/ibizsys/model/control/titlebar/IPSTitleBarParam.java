package net.ibizsys.model.control.titlebar;

import net.ibizsys.model.control.IPSControlParam;

/**
 * 标题栏控件参数
 * @author Administrator
 *
 */
public interface IPSTitleBarParam extends IPSControlParam
{
	
	/**
	 * 获取标题栏标识
	 * @return
	 */
	String getPSTitleBarId();
	
	
	/**
	 * 获取标题栏类型
	 * @return
	 */
	String getTitleBarType();
	
}
