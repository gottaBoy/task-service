package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEDBConfig;

/**
 * 实体数据库配置模型对象接口
 * @author Administrator
 *
 */
public interface IDEDBConfigModel extends IDEDBConfig {
	
	/**
	 * 获取数据库类型
	 * @return
	 */
	String getDBType();
}
