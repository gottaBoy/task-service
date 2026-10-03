package net.ibizsys.model.control.dataview;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.data.IPSDataItem;
import net.ibizsys.paas.control.dataview.IDataViewDataItem;

/**
 * 数据视图数据项对象接口
 * @author lionlau
 *
 */
public interface IPSDEDataViewDataItem extends IPSDataItem,IDataViewDataItem
{
	/**
	 * 获取前端代码表对象
	 * @return
	 */
	IPSCodeList getFrontPSCodeList();
	
	
	/**
	 * 获取数据视图对象
	 * @return
	 */
	IPSDEDataView getPSDEDataView();
}
