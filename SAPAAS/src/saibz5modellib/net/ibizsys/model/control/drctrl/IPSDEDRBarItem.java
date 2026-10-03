package net.ibizsys.model.control.drctrl;

import net.ibizsys.model.core.IPSModelObject;


/**
 * 实体关系栏项对象接口
 * @author lionlau
 *
 */
public interface IPSDEDRBarItem extends IPSDEDRCtrlItem,IPSModelObject
{
	
	
	/**
	 * 获取分组对象
	 * @return
	 */
	IPSDEDRBarGroup getPSDEDRBarGroup();
	
	
}
