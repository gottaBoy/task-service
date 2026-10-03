package net.ibizsys.model.control.grid;

import net.ibizsys.model.data.IPSDataItem;
import net.ibizsys.paas.control.grid.IGridDataItem;

/**
 * 实体表格数据项对象接口
 * @author lionlau
 *
 */
public interface IPSDEGridDataItem extends IPSDataItem,IGridDataItem
{
	/**
	 * 获取实体表格对象
	 * @return
	 */
	IPSDEGrid getPSDEGrid();
	
	
	
	/**
	 * 获取实体表格列对象
	 * @return
	 */
	IPSDEGridColumn getPSDEGridColumn();
}
