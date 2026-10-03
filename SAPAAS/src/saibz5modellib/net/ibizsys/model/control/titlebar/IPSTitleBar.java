package net.ibizsys.model.control.titlebar;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.control.titlebar.ITitleBar;

/**
 * 标题栏对象接口
 * @author lionlau
 *
 */
public interface IPSTitleBar extends IPSControl,ITitleBar
{
	/**
	 * 标题栏类型，系统标题栏
	 */
	final static String TITLEBARTYPE_SYS = "SYSTITLEBAR";
	
	/**
	 * 标题栏类型，应用标题栏
	 */
	final static String TITLEBARTYPE_APP = "APPTITLEBAR";
	
	
	/**
	 * 标题栏样式，用户自定义
	 */
	final static String TITLEBARSTYLE_USER = "USER";
	
	/**
	 * 标题栏样式，用户自定义2
	 */
	final static String TITLEBARTYPE_USER2 = "USER2";
	
	
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
	
	
	
	/**
	 * 获取标题栏左侧控件集合，没有返回空（null）
	 * @return
	 */
	java.util.Iterator<IPSControl> getLeftPSControls();
	
	
	/**
	 * 获取标题栏右侧控件集合，没有返回空（null）
	 * @return
	 */
	java.util.Iterator<IPSControl> getRightPSControls();
	
	
	
	
	/**
	 * 获取标题栏样式，指参考 SA.SRFDA.PS.Core.Control.TitleBar.IPSTitleBar.TITLEBARSTYLE_XXX 定义
	 * @return
	 */
	String getTitleBarStyle();
	
	
	
	
	/**
	 * 获取标题栏类型，指参考 SA.SRFDA.PS.Core.Control.TitleBar.IPSTitleBar.TITLEBARTYPE_XXX 定义
	 * @return
	 */
	String getTitleBarType();
	
	
	
	/**
	 * 获取图标资源对象
	 * @return
	 */
	IPSSysImage getPSSysImage();
	
	

}
