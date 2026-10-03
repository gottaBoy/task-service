package net.ibizsys.paas.core;

/**
 * 一对多关系接口
 * 
 * @author lionlau
 *
 */
public interface IDER1N extends IDERBase {
	// 定义主从关系代码表
	/**
	 * 附属关系（无）
	 */
	final static int MASTERRS_NONE = 0;

	/**
	 * 附属关系
	 */
	final static int MASTERRS_ATTACHED = 1;

	/**
	 * 附属关系(N:N连接)
	 */
	final static int MASTERRS_ATTACHED_NN = 2;

	/**
	 * 附属关系(权限控制)
	 */
	final static int MASTERRS_ATTACHED_ACC = 4;
	
	/**
	 * 嵌套操作
	 */
	final static int MASTERRS_ATTACHED_NESTED = 8;
	
	
	/**
	 * 递归关系
	 */
	final static int MASTERRS_RECURSIVE = 16;

	/**
	 * 获取拾取属性名称
	 * 
	 * @return
	 */
	String getPickupDEFName();

	/**
	 * 是否为数据访问控制关系
	 * 
	 * @return
	 */
	int getMasterRS();
}
