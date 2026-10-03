package net.ibizsys.model.control.grid;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.paas.control.grid.IGridColumn;


/**
 * 实体表格列对象接口
 * 
 * @author Administrator
 *
 */
public interface IPSDEGridColumn extends IPSModelObject, IGridColumn {
	
	/**
	 * 列内容水平对齐：左对齐
	 */
	public final static String ALIGN_LEFT = "LEFT";

	/**
	 * 列内容水平对齐：居中
	 */
	public final static String ALIGN_CENTER = "CENTER";

	/**
	 * 列内容水平对齐：右对齐
	 */
	public final static String ALIGN_RIGHT = "RIGHT";

	
	/**
	 * 获取实体表格对象
	 * 
	 * @return
	 */
	IPSDEGrid getPSDEGrid();

	/**
	 * 获取代码名称
	 * 
	 * @return
	 */
	String getCodeName();

	/**
	 * 获取列使用的数据项集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSDEGridDataItem> getPSDEGridDataItems();

	/**
	 * 获取宽度单位名称
	 * 
	 * @return
	 */
	String getWidthUnit();

	/**
	 * 获取宽度
	 * 
	 * @return
	 */
	int getWidth();

	/**
	 * 获取列类型
	 * 
	 * @return
	 */
	String getColumnType();

	/**
	 * 是否支持排序
	 * 
	 * @return
	 */
	boolean isEnableSort();



	/**
	 * 获取宽度字符串
	 * 
	 * @return
	 */
	String getWidthString();

	/**
	 * 是否为隐藏数据项
	 * 
	 * @return
	 */
	boolean isHiddenDataItem();

	
	/**
	 * 获取水平对齐方式。具体参考 SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn.ALIGN_XXX 定义。
	 * 
	 * @return
	 */
	String getAlign();

	/**
	 * 是否默认隐藏
	 * 
	 * @return
	 */
	boolean isHideDefault();

	

	/**
	 * 是否支持行编辑
	 * 
	 * @return
	 */
	boolean isEnableRowEdit();

	/**
	 * 获取对应的表格编辑项
	 * 
	 * @return
	 */
	IPSDEGridEditItem getPSDEGridEditItem();

	/**
	 * 获取父表格列
	 * 
	 * @return
	 */
	IPSDEGridColumn getParentPSGridColumn();

	/**
	 * 获取标题语言资源对象
	 * 
	 * @return
	 */
	IPSLanguageRes getCapPSLanguageRes();

	/**
	 * 获取标题语言资源标识
	 * 
	 * @return
	 */
	String getCapLanResTag();

//	/**
//	 * 获取Excel标题语言资源标识
//	 * 
//	 * @return
//	 */
//	IPSLanguageRes getExcelCapPSLanguageRes();
	
	
	/**
	 * 获取列样式
	 * @return
	 */
	String getColumnStyle();

	
	
	/**
	 * 获取用户标记
	 * @return
	 */
	String getUserTag();
	
	
	/**
	 * 获取用户标记2
	 * @return
	 */
	String getUserTag2();
	
	
	/**
	 * 获取头部样式对象
	 * @return
	 */
	IPSSysCss getHeaderPSSysCss();
	
	
	/**
	 * 获取单元格样式对象
	 * @return
	 */
	IPSSysCss getCellPSSysCss();
}
