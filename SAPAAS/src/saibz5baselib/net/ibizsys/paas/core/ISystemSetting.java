package net.ibizsys.paas.core;

/**
 * 系统设置对象接口
 * @author Administrator
 *
 */
public interface ISystemSetting {
	
	/**
	 * 是否启用数据库值插入更新模式，默认为不启用，使用值函数模式
	 * @return
	 */
	boolean isEnableDBValueInsertUpdateMode();
}
