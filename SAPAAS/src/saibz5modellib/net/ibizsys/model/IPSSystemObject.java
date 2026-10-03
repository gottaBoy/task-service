package net.ibizsys.model;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.paas.core.ISystemObject;

/**
 * 系统模型相关对象
 * @author Administrator
 *
 */
public interface IPSSystemObject extends IPSModelObject,ISystemObject {

	/**
	 * 获取系统模型对象
	 * @return
	 */
	IPSSystem getPSSystem();
}
