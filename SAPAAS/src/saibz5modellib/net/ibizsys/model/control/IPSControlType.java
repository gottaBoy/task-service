package net.ibizsys.model.control;

import net.ibizsys.model.core.IPSModelObject;


/**
 * 云平台部件类型对象接口
 * 
 * @author Administrator
 *
 */
public interface IPSControlType extends IPSModelObject {
	

	/**
	 * 是否为Ajax控件
	 * 
	 * @return
	 */
	boolean isAjaxControl();

	

}
