package net.ibizsys.model.control.list;

import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.logic.IPSDELogic;

/**
 * 实体列表控件对象接口
 * @author lionlau
 *
 */
public interface IPSDEList extends IPSList
{
	//定义移动端列表样式代码表

	/**
	*移动端列表样式：图标视图
	*/
	public final static String MOBLISTSTYLE_ICONVIEW = "ICONVIEW" ;

	/**
	*移动端列表样式：列表视图
	*/
	public final static String MOBLISTSTYLE_LISTVIEW = "LISTVIEW" ;

	/**
	*移动端列表样式：图片滑动视图
	*/
	public final static String MOBLISTSTYLE_SWIPERVIEW = "SWIPERVIEW" ;

	
	
	/**
	 * 获取数据集合
	 * @return
	 */
	IPSDEDataSet getPSDEDataSet();
	
	
	
	/**
	 * 获取数据集合上下文数据转换逻辑
	 * @return
	 */
	IPSDELogic getActiveDataPSDELogic();
	
	
	
	/**
	 * 获取列表项集合
	 * @return
	 */
	java.util.Iterator<IPSDEListItem> getPSDEListItems();
	                                   

	
	/**
	 * 是否显示头部
	 * @return
	 */
	boolean isShowHeader();
	
	
	/**
	 * 适应屏幕宽度
	 * @return
	 */
	boolean isForceFit();
	
	
//	/**
//	 * 获取列表绘制器
//	 * @return
//	 */
//	IPSSysPFPlugin getPSSysPFPlugin();
	
	
	
	
	/**
	 * 获取分页大小
	 * @return
	 */
	int getPagingSize();
	
	

	
	
	
	/**
	 * 获取二级排序属性
	 * @return
	 */
	IPSDEField getMinorSortPSDEF();
	

	
	/**
	 * 获取二级排序方向
	 * @return
	 */
	String getMinorSortDir();
	
	
	/**
	 * 实体禁用排序
	 * @return
	 */
	boolean isNoSort();
	
	
	
	/**
	 * 是否附加实体数据项
	 * @return
	 */
	boolean isAppendDEItems();

	
	
	/**
	 * 获取移动端列表视图样式，值参考 SA.SRFDA.PS.Core.Control.List.IPSDEList.MOBLISTSTYLE_XXX 定义
	 * @return
	 */
	String getMobListStyle();
	
	
//	/**
//	 * 获取项的系统布局面板
//	 * @return
//	 */
//	IPSSysLayoutPanel getItemPSSysLayoutPanel();
}
