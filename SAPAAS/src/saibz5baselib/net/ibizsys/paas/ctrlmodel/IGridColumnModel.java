package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.grid.IGridColumn;
import net.ibizsys.paas.control.grid.IGridDataItem;
import net.ibizsys.paas.web.IWebContext;

/**
 * 表格列模型对象接口
 * 
 * @author Administrator
 *
 */
public interface IGridColumnModel extends IGridColumn {

	/**
	 * 获取Excel文本值
	 * 
	 * @param iWebContext
	 * @param object
	 * @return
	 * @throws Exception
	 */
	String getExcelText(IWebContext iWebContext, Object object) throws Exception;

	/**
	 * 获取Excel文本值
	 * 
	 * @param iWebContext
	 * @param object
	 * @param bEnableItemPrivilege 是否启用列权限
	 * @return
	 * @throws Exception
	 */
	String getExcelText(IWebContext iWebContext, Object object, boolean bEnableItemPrivilege) throws Exception;

	/**
	 * 获取表格数据项
	 * 
	 * @return
	 * @throws Exception
	 */
	IGridDataItem getGridDataItem() throws Exception;
}
