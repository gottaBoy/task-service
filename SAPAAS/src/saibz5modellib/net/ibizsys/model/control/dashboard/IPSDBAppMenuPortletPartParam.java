package net.ibizsys.model.control.dashboard;

/**
 * 数据看板菜单部件参数对象接口
 * @author Administrator
 *
 */
public interface IPSDBAppMenuPortletPartParam extends IPSDBPortletPartParam{
	
	/**
	 * 获取应用菜单标识
	 * @return
	 */
	String getPSAppMenuId();

	/**
	 * 获取绘制器标识
	 * @return
	 */
	String getAMPSSysPFPluginId();
	
	
	/**
	 * 获取绘制样式
	 * @return
	 */
	String getAMListStyle();
}
