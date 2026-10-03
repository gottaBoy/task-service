package net.ibizsys.model.res;

import net.ibizsys.model.core.IPSModelObject;


/**
 * 门户部件类型对象接口
 * @author lionlau
 *
 */
public interface IPSPortletType extends IPSModelObject
{
	/**
	 * 是否为系统门户部件
	 * @return
	 */
	boolean isSysPortlet();

	
}
