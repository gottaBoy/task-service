package net.ibizsys.paas.control.grid;

import net.ibizsys.paas.web.IWebContext;

/**
 * 表格列接口
 * 
 * @author lionlau
 *
 */
public interface IGridColumn {
	// 定义表格列类型代码表
	/**
	 * 属性列
	 */
	final static String GRIDCOLTYPE_DEFGRIDCOLUMN = "DEFGRIDCOLUMN";

	/**
	 * 树表属性列
	 */
	final static String GRIDCOLTYPE_DEFTREEGRIDCOLUMN = "DEFTREEGRIDCOLUMN";

	// 定义宽度单位代码表

	/**
	 * px
	 */
	final static String WIDTHUNIT_PX = "PX";

	/**
	**
	*/
	final static String WIDTHUNIT_STAR = "STAR";

	// 水平对齐方式
	/**
	 * 左侧
	 */
	final static String ALIGN_LEFT = "LEFT";

	/**
	 * 居中
	 */
	final static String ALIGN_CENTER = "CENTER";

	/**
	 * 右侧
	 */
	final static String ALIGN_RIGHT = "RIGHT";

	/**
	 * 获取标题
	 * 
	 * @return
	 */
	String getCaption();

	/**
	 * 获取数据项名称
	 * 
	 * @return
	 */
	String getDataItemName();

	/**
	 * 获取导出Excel标题
	 * 
	 * @return
	 */
	String getExcelCaption();

	/**
	 * 获取代码表标识
	 * 
	 * @return
	 */
	String getCodeListId();

	/**
	 * 获取Excel文本值
	 * 
	 * @param iWebContext
	 * @param object 列值
	 * @return
	 * @throws Exception
	 */
	String getExcelText(IWebContext iWebContext, Object object) throws Exception;

	/**
	 * 获取Excel文本值
	 * 
	 * @param iWebContext
	 * @param object 列值
	 * @param bEnableItemPrivilege 是否启用列权限
	 * @return
	 * @throws Exception
	 */
	String getExcelText(IWebContext iWebContext, Object object, boolean bEnableItemPrivilege) throws Exception;

	/**
	 * 获取水平对齐方式
	 * 
	 * @return
	 */
	String getAlign();
	
	
	
	
	/**
	 * 获取标题语言资源标识
	 * @return
	 */
	String getCapLanResTag();
	
	
	/**
	 * 获取Excel标题语言资源标识
	 * @return
	 */
	String getExcelCapLanResTag();
}
