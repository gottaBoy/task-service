package net.ibizsys.model.control.viewpanel;

import net.ibizsys.model.app.view.IPSAppDEView;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.res.IPSLanguageRes;

/**
 * 实体视图面板对象接口
 * @author lionlau
 *
 */
public interface IPSDEViewPanel extends IPSControl
{
	/**
	 * 获取应用实体视图
	 * @return
	 */
	IPSAppDEView getPSAppDEView();
	
	
	/**
	 * 获取嵌入视图标识
	 * @return
	 */
	String getEmbedViewId();
	
	
	
	/**
	 * 获取标题
	 * @return
	 */
	String getCaption();
	
	
	
	
	/**
	 * 获取标题语言资源
	 * @return
	 */
	IPSLanguageRes getCapPSLanguageRes();
}
