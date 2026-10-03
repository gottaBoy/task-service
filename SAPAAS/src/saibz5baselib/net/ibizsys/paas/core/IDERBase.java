package net.ibizsys.paas.core;

/**
 * 关系基类接口
 * 
 * @author lionlau
 *
 */
public interface IDERBase extends IModelBase {
	/**
	 * 1:N关系
	 */
	static String DERTYPE_DER1N = "DER1N";

	/**
	 * 1:1关系
	 */
	static String DERTYPE_DER11 = "DER11";

	/**
	 * 索引关系
	 */
	static String DERTYPE_DERINDEX = "DERINDEX";

	/**
	 * 继承关系
	 */
	static String DERTYPE_DERINHERIT = "DERINHERIT";

	/**
	 * 虚拟实体多继承关系
	 */
	static String DERTYPE_DERMULINH = "DERMULINH";

	/**
	 * 自定义关系
	 */
	static String DERTYPE_DERCUSTOM = "DERCUSTOM";
	
	
	


	// 定义主实体删除类型代码表

	/**
	 * 无操作
	 */
	static int REMOVEACTIONTYPE_NONE = 0;

	/**
	 * 同时删除
	 */
	static int REMOVEACTIONTYPE_DELETE = 1;

	/**
	 * 置空
	 */
	static int REMOVEACTIONTYPE_RESET = 2;

	/**
	 * 限制删除
	 */
	static int REMOVEACTIONTYPE_REJECT = 3;

	/**
	 * 获取关系类型
	 * 
	 * @return
	 */
	String getDERType();

	/**
	 * 获取主实体
	 * 
	 * @return
	 */
	String getMajorDEId();

	/**
	 * 获取从实体
	 * 
	 * @return
	 */
	String getMinorDEId();

	/**
	 * 获取主实体
	 * 
	 * @return
	 */
	String getMajorDEName();

	/**
	 * 获取从实体
	 * 
	 * @return
	 */
	String getMinorDEName();

}
