package net.ibizsys.paas.core;

/**
 * 值规则接口
 * 
 * @author lionlau
 *
 */
public interface IValueRule extends IModelBase {
	/**
	 * 正则式规则
	 */
	public final static String RULETYPE_REGEX = "REGEX";

	/**
	 * 脚本规则
	 */
	public final static String RULETYPE_SCRIPT = "SCRIPT";

	/**
	 * 自定义
	 */
	public final static String RULETYPE_CUSTOM = "CUSTOM";

	/**
	 * 获取规则类型
	 * 
	 * @return
	 */
	String getRuleType();
	
	
	
	
	/**
	 * 获取规则信息
	 * @return
	 */
	String getRuleInfo(); 
}
