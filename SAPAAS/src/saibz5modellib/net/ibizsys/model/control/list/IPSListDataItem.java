package net.ibizsys.model.control.list;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.data.IPSDataItem;
import net.ibizsys.paas.control.list.IListDataItem;

/**
 * 列表数据项对象接口
 * @author lionlau
 *
 */
public interface IPSListDataItem extends IPSDataItem,IListDataItem
{
	/**
	 * 获取前端代码表
	 * @return
	 */
	IPSCodeList getFrontPSCodeList();
}
