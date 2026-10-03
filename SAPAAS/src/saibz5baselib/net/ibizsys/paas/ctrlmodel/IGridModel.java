package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.grid.IGrid;
import net.ibizsys.paas.control.grid.IGridColumn;
import net.ibizsys.paas.control.grid.IGridDataItem;
import net.ibizsys.paas.control.grid.IGridEditItem;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.sf.json.JSONObject;

/**
 * 实体表格模型接口
 * 
 * @author lionlau
 *
 */
public interface IGridModel extends ICtrlModel, IGrid {

	/**
	 * 填充返回结果对象
	 * 
	 * @param fetchResult
	 * @param dt
	 * @throws Exception
	 */
	void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt) throws Exception;

	/**
	 * 获取指定数据项
	 * 
	 * @param strName
	 * @return
	 * @throws Exception
	 */
	IGridDataItem getGridDataItem(String strName) throws Exception;

	/**
	 * 获取指定编辑项
	 * 
	 * @param strName
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	IGridEditItem getGridEditItem(String strName, boolean bTryMode) throws Exception;

	/**
	 * 转化实体属性错误
	 * 
	 * @param entityFieldError
	 * @return
	 * @throws Exception
	 */
	boolean convertEntityFieldError(EntityFieldError entityFieldError) throws Exception;

	/**
	 * 通过数据对象填充行
	 * 
	 * @param iDataObject 当前数据对象
	 * @param bUpdate 更新模式
	 * @param outputData 输出数据对象
	 * @param outputState 输出状态对象
	 * @param outputConfig 输出配置对象
	 * @throws Exception
	 */
	void fillRowOutputDatas(IDataObject iDataObject, boolean bUpdate, JSONObject outputData, JSONObject outputState, JSONObject outputConfig) throws Exception;

	/**
	 * 填充数据实体对象
	 * 
	 * @param iDataObject 数据实体对象
	 * @param bIgnoreEmpty 是否忽略空检查
	 * @param formItemErrors 表单项错误集合
	 * @return
	 */
	void fillRowInputValues(IDataObject iDataObject, boolean bUpdate, boolean bIgnoreEmpty) throws Exception;

	/**
	 * 获取编辑项输入的值
	 * 
	 * @param strGridEditItem 表单项
	 * @param iWebContext
	 * @return
	 */
	Object getGridEditItemInputValue(String strGridEditItem, IWebContext iWebContext) throws Exception;

	/**
	 * 填充数据实体对象默认值
	 * 
	 * @param iDataObject 数据实体s对象
	 * @param bIgnoreEmpty 是否忽略空检查
	 * @return
	 */
	void fillRowDefaultValues(IDataObject iDataObject, boolean bUpdate) throws Exception;

	/**
	 * 判断值规则
	 * 
	 * @param iService
	 * @param iDataObject
	 * @param bUpdate 是否为更新模式
	 * @throws Exception
	 */
	void testRowValueRule(IService iService, IDataObject iDataObject, boolean bUpdate) throws Exception;

	/**
	 * 获取列Excel文本值
	 * 
	 * @param iGridColumn 表格列
	 * @param iWebContext
	 * @param object
	 * @param bEnableItemPrivilege 是否启用列权限
	 * @return
	 * @throws Exception
	 */
	String getColumnExcelText(IGridColumn iGridColumn, IWebContext iWebContext, Object object, boolean bEnableItemPrivilege) throws Exception;

}
