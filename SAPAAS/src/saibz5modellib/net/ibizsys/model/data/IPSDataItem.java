package net.ibizsys.model.data;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.paas.data.IDataItem;

/**
 * 系统数据项对象接口
 * @author lionlau
 *
 */
public interface IPSDataItem extends IDataItem,IPSModelObject
{
	/**
	 * 获取代码表对象
	 * @return
	 */
	IPSCodeList getPSCodeList();
}
