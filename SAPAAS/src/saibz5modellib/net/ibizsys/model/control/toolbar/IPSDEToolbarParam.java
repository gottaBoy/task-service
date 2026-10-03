package net.ibizsys.model.control.toolbar;

import net.ibizsys.model.control.IPSControlParam;

/**
 * 实体工具栏部件参数对象接口
 * @author Administrator
 *
 */
public interface IPSDEToolbarParam extends IPSControlParam
{
	/**
	 * 获取实体工具栏标识
	 * @return
	 */
	String getPSDEToolbarId();
	
	
	
	/**
	 * 获取工具栏绑定的界面行为组标识
	 * @return
	 */
	String getPSDEUIActionGroupId();
	
	
	/**
	 * 获取工具栏绑定的界面行为组2标识
	 * @return
	 */
	String getNo2PSDEUIActionGroupId();
	
	/**
	 * 获取工具栏绑定的界面行为组3标识
	 * @return
	 */
	String getNo3PSDEUIActionGroupId();
	
	/**
	 * 获取工具栏绑定的界面行为组4标识
	 * @return
	 */
	String getNo4PSDEUIActionGroupId();
	
	/**
	 * 获取工具栏绑定的界面行为组5标识
	 * @return
	 */
	String getNo5PSDEUIActionGroupId();
	
	/**
	 * 获取工具栏绑定的界面行为组6标识
	 * @return
	 */
	String getNo6PSDEUIActionGroupId();
	
	
	/**
	 * 获取工具栏样式
	 * @return
	 */
	String getToolbarStyle();
}
