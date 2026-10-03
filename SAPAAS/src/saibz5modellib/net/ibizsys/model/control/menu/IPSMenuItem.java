package net.ibizsys.model.control.menu;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.paas.control.menu.IMenuItem;

/**
 * 菜单项对象接口
 * @author lionlau
 *
 */
public interface IPSMenuItem extends IPSModelObject,IMenuItem
{
	/**
	 * 获取标题
	 * @return
	 */
	String getCaption();

	
	
//	/**
//	 * 获取标题语言资源
//	 * @return
//	 */
//	IPSLanguageRes getCapPSLanguageRes();

	
	
//	/**
//	 * 获取提示语言资源
//	 * @return
//	 */
//	IPSLanguageRes getTooltipPSLanguageRes();
	

	

}
