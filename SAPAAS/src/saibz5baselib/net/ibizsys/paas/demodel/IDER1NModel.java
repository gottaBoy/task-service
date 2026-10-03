package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDER1N;

/**
 * 实体1：N关系模型对象接口
 * 
 * @author Administrator
 *
 */
public interface IDER1NModel extends IDER1N {
	/**
	 * 获取关系主实体
	 * 
	 * @return
	 */
	IDataEntityModel getMajorDEModel() throws Exception;

	/**
	 * 获取关系从实体
	 * 
	 * @return
	 */
	IDataEntityModel getMinorDEModel() throws Exception;
}
