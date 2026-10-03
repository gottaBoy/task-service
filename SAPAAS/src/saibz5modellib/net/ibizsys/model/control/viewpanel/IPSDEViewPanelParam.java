package net.ibizsys.model.control.viewpanel;

import net.ibizsys.model.control.IPSControlParam;

/**
 * 实体视图面板控件参数对象接口
 * @author Administrator
 *
 */
public interface IPSDEViewPanelParam extends IPSControlParam
{
	/**
	 * 获取实体视图编号
	 * @return
	 */
	String getPSDEViewId();
	
	
	
	/**
	 * 获取标题
	 * @return
	 */
	String getCaption();
	
	
	
	/**
	 * 获取标题语言资源对象标识
	 * @return
	 */
	String getCapPSLanguageResId();
}
