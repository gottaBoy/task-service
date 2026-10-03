package net.ibizsys.psop.zookeeper;

import net.ibizsys.paas.entity.IEntity;

/**
 * ZooKeeper数据对象
 * @author Administrator
 *
 */
public interface IPSZooKeeperEntity extends IEntity {

	/**
	 * 获取数据版本
	 * @return
	 */
	int getZKDataVersion();
	
	
	/**
	 * 设置数据版本
	 * @param nVersion
	 */
	void setZKDataVersion(int nVersion);
}
