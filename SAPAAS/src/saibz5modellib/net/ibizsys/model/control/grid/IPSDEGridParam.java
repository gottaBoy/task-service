package net.ibizsys.model.control.grid;

import net.ibizsys.model.control.IPSMDAjaxControlParam;
import net.ibizsys.paas.control.grid.IGridHandlerParam;

/**
 * 实体表格部件参数对象接口
 * @author lionlau
 *
 */
public interface IPSDEGridParam extends IPSMDAjaxControlParam,IGridHandlerParam
{
	/**
	 * 获取实体表格编号
	 * @return
	 */
	String getPSDEGridId();
	
	
	
	/**
	 * 是否单选
	 * @return
	 */
	Boolean isSingleSelect();
	
	
	
	/**
	 * 是否支持行编辑
	 * @return
	 */
	Boolean isEnableRowEdit();

}
