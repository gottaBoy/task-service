package net.ibizsys.model.app.view;


/**
 * 应用实体表格界面对象接口
 * @author lionlau
 *
 */
public interface IPSAppDEGridView extends IPSAppDEMultiDataView,IPSAppDEWFView
{
	/**
	 * 默认表格部件名称
	 */
	final static String CONTROL_GRID = "grid";
	
	
	/**
	 * 是否支持行编辑
	 * @return
	 */
	boolean isEnableRowEdit();
	
	
	
	/**
	 * 是否支持双击激活数据
	 * @return
	 */
	boolean isDbClickEditData();
	
	
	
	/**
	 * 获取表格行数据默认激活模式，值参考  SA.SRFDA.PS.Core.App.IPSApplicationUI.GRIDROWACTIVEMODE_XXX 定义
	 * @return
	 */
	int getGridRowActiveMode();
	
	
	
	/**
	 * 是否默认进入行编辑
	 * @return
	 */
	boolean isRowEditDefault();
}
