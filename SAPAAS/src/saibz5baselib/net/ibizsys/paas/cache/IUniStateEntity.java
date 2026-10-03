package net.ibizsys.paas.cache;

import net.ibizsys.paas.entity.IEntity;

/**
 * 统一状态数据对象接口
 * @author Administrator
 *
 */
public interface IUniStateEntity extends IEntity {
	
	/**
	 * 获取数据版本
	 * @return
	 */
	int getUSDataVersion();
	
	
	/**
	 * 设置数据版本
	 * @param nVersion
	 */
	void setUSDataVersion(int nVersion);
}
