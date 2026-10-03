package net.ibizsys.model.control.grid;


/**
 * 实体多编辑页面板控件参数对象接口
 * @author Administrator
 *
 */
public interface IPSDEMultiEditViewPanelParam extends IPSDEGridParam
{
	/**
	 * 获取实体视图标识
	 * @return
	 */
	String getPSDEViewId();
	
	
	
	/**
	 * 获取面板样式
	 * @return
	 */
	String getPanelStyle();
}
