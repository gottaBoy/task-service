package net.ibizsys.model.control.grid;

import net.ibizsys.model.app.view.IPSAppDEView;

/**
 * 实体多编辑视图面板对象接口
 * @author lionlau
 *
 */
public interface IPSDEMultiEditViewPanel extends IPSDEGrid
{
	/**
	 * 获取应用实体视图
	 * @return
	 */
	IPSAppDEView getPSAppDEView();
	
	
	/**
	 * 获取面板样式
	 * @return
	 */
	String getPanelStyle();
}
