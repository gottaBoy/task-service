package net.ibizsys.model.control.drctrl;

import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.res.IPSLanguageRes;


/**
 * 数据关系栏部件接口
 * @author Administrator
 *
 */
public interface IPSDRBar  extends IPSDRCtrl,IPSControlContainer
{
	/**
	 * 获取导航栏标题
	 * @return
	 */
	String getTitle();
	
	
	
	/**
	 * 获取标题语言资源
	 * @return
	 */
	IPSLanguageRes getTitlePSLanguageRes();
	
	
	
	/**
	 * 是否显示标题，默认为显示
	 * @return
	 */
	boolean isShowTitle();
}
