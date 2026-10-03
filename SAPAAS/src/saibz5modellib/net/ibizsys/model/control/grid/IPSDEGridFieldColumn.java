package net.ibizsys.model.control.grid;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIAction;

/**
 * 实体属性表格列对象接口
 * @author lionlau
 *
 */
public interface IPSDEGridFieldColumn extends IPSDEGridColumn
{
	/**
	 * 获取关联的实体属性
	 * @return
	 */
	IPSDEField getPSDEField();
	
	
	
	
	/**
	 * 获取代码表对象
	 * @return
	 */
	IPSCodeList getPSCodeList();

	
	
	/**
	 * 获取代码表
	 * @return
	 */
	String getPSCodeListId();
	
	
	
	
	/**
	 * 获取值格式化
	 * @return
	 */
	String getValueFormat();

	
	
	
	/**
	 * 获取数据字段集合
	 * @return
	 */
	String[] getFields();
	
	
	
	
	/**
	 * 是否启用项权限控制
	 * @return
	 */
	boolean isEnableItemPriv();	
	
	
	
	/**
	 * 获取项权限标识
	 * @return
	 */
	String getItemPrivId();
	
	
	
	/**
	 * 获取分组项
	 * @return
	 */
	String getGroupItem();
	
	
	
	/**
	 * 获取实体界面行为
	 * @return
	 */
	IPSDEUIAction getPSDEUIAction();
	
	
	
	
	/**
	 * 获取代码表模式，值参考 SA.SRFDA.PS.Core.Control.List.IPSListItem.CLCONVERTMODE_XXX 定义
	 * @return
	 */
	String getCLConvertMode();
	
	
	
	/**
	 * 是否产生数据项
	 * @return
	 */
	boolean isGenerateDataItems();

}
