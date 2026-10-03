package net.ibizsys.model.app.view;

/**
 * 应用实体树导航视图对象接口
 * @author Administrator
 *
 */
public interface IPSAppDETreeExplorerView extends IPSAppDEExplorerView,IPSAppDEMultiDataView
{
	/**
	 * 树导航面板
	 */
	final static String CTRL_TREEEXPBAR = "TREEEXPBAR";
	
	/**
	 * 支持树导航分类
	 */
	public final static String VIEWPARAM_UI_ENABLEEXPTREECAT = "UI.ENABLEEXPTREECAT";
	
}
