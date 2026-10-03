package net.ibizsys.model.control.expbar;

import net.ibizsys.model.control.IPSAjaxControlParam;

/**
 * 导航栏参数对象接口
 * @author lionlau
 *
 */
public interface IPSExpBarParam extends IPSAjaxControlParam
{
	/**
	 * 部件参数：分区名称
	 */
	public final static String CTRLPARAM_SECTIONNAME = "SECTION.NAME";

	
	/**
	 * 部件参数：分区名称语言标识
	 */
	public final static String CTRLPARAM_SECTIONNAMELANRESTAG = "SECTION.NAMELANRESTAG";
	
	
	/**
	 * 获取界面计数器标识
	 * @return
	 */
	String getPSSysCounterId();
	
	
	
	
	/**
	 * 获取导航栏标题
	 * @return
	 */
	String getTitle();

	
	
	/**
	 * 获取标题语言资源标识
	 * @return
	 */
	String getTitlePSLanguageResId();
	
	
	
	/**
	 * 是否支持计数器
	 * @return
	 */
	Boolean getEnableCounter();
}
