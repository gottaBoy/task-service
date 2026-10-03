package net.ibizsys.psba.core;

import net.ibizsys.paas.core.IModelBase;

/**
 * 大数据表相关对象接口
 * 
 * @author Administrator
 *
 */
public interface IBATableObject extends IModelBase {

	/**
	 * 获取数据表对象
	 * 
	 * @return
	 */
	IBATable getBATable();
}
