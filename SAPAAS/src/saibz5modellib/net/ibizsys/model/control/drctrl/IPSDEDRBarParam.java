package net.ibizsys.model.control.drctrl;


/**
 * 实体关系栏参数对象接口
 * @author lionlau
 *
 */
public interface IPSDEDRBarParam extends IPSDEDRCtrlParam
{
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
	 * 是否显示标题
	 * @return
	 */
	Boolean isShowTitle(); 
}
