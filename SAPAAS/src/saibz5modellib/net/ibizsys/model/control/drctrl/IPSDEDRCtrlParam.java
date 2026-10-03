package net.ibizsys.model.control.drctrl;

import net.ibizsys.model.control.IPSAjaxControlParam;

/**
 * 实体关系控件参数对象接口
 * @author lionlau
 *
 */
public interface IPSDEDRCtrlParam extends IPSAjaxControlParam
{
	/**
	 * 获取实体数据关系组标识
	 * @return
	 */
	String getPSDEDRId();
	
	
	/**
	 * 获取界面计数器标识
	 * @return
	 */
	String getPSSysCounterId();
	
	


}
