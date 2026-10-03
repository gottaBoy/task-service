package net.ibizsys.model.control.grid;

import java.util.Iterator;

import net.ibizsys.model.control.IPSMDAjaxControl;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.paas.control.grid.IGrid;

/**
 * 实体表格对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSDEGrid extends IPSMDAjaxControl, IGrid {
	/**
	 * 表格样式：树表格
	 */
	public final static String GRIDSTYLE_TREEGRID = "TREEGRID";

	/**
	 * 表格样式：分组表格
	 */
	public final static String GRIDSTYLE_GROUPGRID = "GROUPGRID";

	/**
	 * 表格样式：无头单列（列表）
	 */
	public final static String GRIDSTYLE_LIST = "LIST";

	/**
	 * 表格样式：无头单列（列表）,支持排序
	 */
	public final static String GRIDSTYLE_LIST_SORT = "LIST_SORT";
	
	
	//定义排序模式代码表
	/**
	*远程排序
	*/
	public final static String SORTMODE_REMOTE = "REMOTE" ;

	/**
	*本地排序
	*/
	public final static String SORTMODE_LOCAL = "LOCAL" ;
	

	/**
	 * 获取实体表格列集合
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEGridColumn> getPSDEGridColumns();

	/**
	 * 获取实体表格全部列集合（包括分组列子列）
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEGridColumn> getAllPSDEGridColumns();

	/**
	 * 获取实体表格数据项集合
	 * 
	 * @return
	 */
	Iterator<IPSDEGridDataItem> getPSDEGridDataItems();

	/**
	 * 获取实体表格编辑项集合
	 * 
	 * @return
	 */
	Iterator<IPSDEGridEditItem> getPSDEGridEditItems();

	/**
	 * 是否支持分页工具栏
	 * 
	 * @return
	 */
	boolean isEnablePagingBar();

	/**
	 * 是否支持行编辑
	 * 
	 * @return
	 */
	boolean isEnableRowEdit();

	/**
	 * 获取分页大小
	 * 
	 * @return
	 */
	int getPagingSize();

	/**
	 * 是否为单项选择表格
	 * 
	 * @return
	 */
	boolean isSingleSelect();

	/**
	 * 是否适应屏幕宽度
	 * 
	 * @return
	 */
	boolean isForceFit();

	/**
	 * 获取表格样式，值参考 SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid.GRIDSTYLE_XXX 定义
	 * 
	 * @return
	 */
	String getGridStyle();

	/**
	 * 是否禁用排序
	 * 
	 * @return
	 */
	boolean isNoSort();

	/**
	 * 获取二级排序属性
	 * 
	 * @return
	 */
	IPSDEField getMinorSortPSDEF();

	/**
	 * 获取二级排序方向
	 * 
	 * @return
	 */
	String getMinorSortDir();

	/**
	 * 是否隐藏头部
	 * 
	 * @return
	 */
	boolean isHideHeader();

	/**
	 * 是否支持用户状态
	 * 
	 * @return
	 */
	boolean isStateful();

	/**
	 * 获取表格编辑项更新集合
	 * 
	 * @return
	 */
	Iterator<IPSDEGridEditItemUpdate> getPSDEGridEditItemUpdates();

	/**
	 * 获取指定表格编辑项更新
	 * 
	 * @param strPSDEGridEditItemUpdateId
	 * @return
	 * @throws Exception
	 */
	IPSDEGridEditItemUpdate getPSDEGridEditItemUpdate(String strPSDEGridEditItemUpdateId) throws Exception;

	/**
	 * 获取分组数据项集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSDEGridDataItem> getGroupPSDEGridDataItems();

//	/**
//	 * 获取无值显示内容语言资源对象
//	 * 
//	 * @return
//	 */
//	IPSLanguageRes getEmptyTextPSLanguageRes();

	/**
	 * 获取无值显示内容
	 * 
	 * @return
	 */
	String getEmptyText();
	
	
	/**
	 * 获取排序模式
	 * @return
	 */
	String getSortMode();
}
