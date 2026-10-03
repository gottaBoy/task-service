package net.ibizsys.model.control.dataview;

import net.ibizsys.model.control.IPSMDAjaxControlParam;
import net.ibizsys.paas.control.grid.IGridHandlerParam;

/**
 * 实体数据视图参数对象接口
 * @author lionlau
 *
 */
public interface IPSDEDataViewParam extends IPSMDAjaxControlParam,IGridHandlerParam
{
	/**
	 * 获取实体数据视图标识
	 * @return
	 */
	String getPSDEDataViewId();
	
	
	
	/**
	 * 是否单选模式
	 * @return
	 */
	boolean isSingleSelect();
}
