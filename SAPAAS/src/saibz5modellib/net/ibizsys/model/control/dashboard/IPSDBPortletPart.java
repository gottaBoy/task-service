package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.paas.control.dashboard.IPortlet;

/**
 * 数据看板部件对象接口
 * @author lionlau
 *
 */
public interface IPSDBPortletPart extends   IPSAjaxControl,IPortlet,IPSControlContainer
{
	/**
	 * 获取默认列编号
	 * @return
	 */
	int getDefaultColId();
	
	
	
	/**
	 * 获取内容控件
	 * @return
	 */
	IPSControl getContentPSControl();
	
	
	/**
	 * 获取列布局的CSS
	 * @return
	 */
	String getColCssClass();
	
	
	
//	/**
//	 * 获取门户部件类型对象
//	 * @return
//	 */
//	IPSPortletType getPSPortetType();
	
	
	
//	/**
//	 * 获取标题语言资源
//	 * @return
//	 */
//	IPSLanguageRes getTitlePSLanguageRes();
	
	
	
	
	
	/**
	 * 是否显示标题栏 
	 * @return
	 */
	boolean isShowTitleBar();
}
