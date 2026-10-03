package net.ibizsys.model.data;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.paas.data.IDataItemParam;

/**
 * 系统数据项参数对象接口
 * @author lionlau
 *
 */
public interface IPSDataItemParam extends IDataItemParam
{
	/**
	 * 获取代码表
	 * @return
	 */
	IPSCodeList getPSCodeList();
}
