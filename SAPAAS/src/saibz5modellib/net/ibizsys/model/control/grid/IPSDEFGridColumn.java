package net.ibizsys.model.control.grid;

import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.model.dataentity.field.IPSDEFUIItem;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 实体属性表格列配置对象接口
 * 
 * @author Administrator
 *
 */
public interface IPSDEFGridColumn extends IPSDEFUIItem {
	
	/**
	 * 获取列使用的数据项集合
	 * 
	 * @return
	 */
	Iterator<IPSDEGridDataItem> getPSDEGridDataItems();

	/**
	 * 获取数据项名称
	 * 
	 * @return
	 */
	String getDataItemName();

	/**
	 * 获取默认宽度
	 * 
	 * @return
	 */
	int getColumnWidth();

	/**
	 * 获取标题
	 * 
	 * @param strLanguage
	 * @return
	 */
	String getCaption(String strLanguage);

	/**
	 * 获取是否支持排序
	 * 
	 * @return
	 */
	boolean isEnableSort();

//	/**
//	 * 获取绘制插件
//	 * 
//	 * @return
//	 */
//	IPSSysPFPlugin getRenderPSSysPFPlugin();

	/**
	 * 获取列水平对齐方式。具体参考 SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn.ALIGN_XXX 定义。
	 * 
	 * @return
	 */
	String getColumnAlign();

	

	/**
	 * 获取表格编辑项属性值规则集合
	 * 
	 * @return
	 */
	Iterator<IPSGEIDEFValueRule> getPSGEIDEFValueRules();

	/**
	 * 获取后台处理器类型
	 * 
	 * @param iPSDEGridEditItem
	 * @return
	 */
	String getItemHandlerType(IPSDEGridEditItem iPSDEGridEditItem);

	/**
	 * 获取启用编辑的条件
	 * 
	 * @return
	 */
	int getEnableCond();

	/**
	 * 获取扩展的参数对象
	 * 
	 * @return
	 */
	ObjectNode getItemParam(IPSDEGridEditItem iPSDEGridEditItem) throws Exception;

	/**
	 * 获取指定表格属性列的数据项集合
	 * 
	 * @param iPSDEGridFieldColumn
	 * @return
	 * @throws Exception
	 */
	ArrayList<IPSDEGridDataItem> getPSDEGridDataItems(IPSDEGridFieldColumn iPSDEGridFieldColumn) throws Exception;

	/**
	 * 获取数据项名称
	 * 
	 * @param iPSDEGridFieldColumn
	 *            表格列对象
	 * @return
	 */
	String getDataItemName(IPSDEGridFieldColumn iPSDEGridFieldColumn) throws Exception;
	
	
	/**
	 * 获取代码表模式，值参考 SA.SRFDA.PS.Core.Control.List.IPSListItem.CLCONVERTMODE_XXX 定义
	 * @return
	 */
	String getCLConvertMode();

}
