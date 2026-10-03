package net.ibizsys.psba.core;

import net.ibizsys.paas.core.IModelBase;

/**
 * 大数据架构模型基类
 * 
 * @author Administrator
 *
 */
public interface IBAModelBase extends IModelBase {

	/**
	 * 设置标识
	 * 
	 * @return
	 */
	void setId(String strId);

	/**
	 * 设置名称
	 * 
	 * @return
	 */
	void setName(String strName);
}
