package net.ibizsys.model.valuerule;

import net.ibizsys.model.IPSSystemObject;


/**
 * 系统预置值规则对象接口
 * @author lionlau
 *
 */
public interface IPSSysValueRule extends IPSSystemObject
{
	/**
	*规则类型：脚本
	*/
	public final static String RULETYPE_SCRIPT = "SCRIPT" ;

	/**
	*规则类型：正则式（废弃）
	*/
	public final static String RULETYPE_REG = "REG" ;
	
	/**
	*规则类型：正则式
	*/
	public final static String RULETYPE_REGEX = "REGEX" ;
	
	
	/**
	* 规则类型：自定义
	*/
	public final static String RULETYPE_CUSTOM = "CUSTOM" ;

	

	
	
	/**
	 * 获取规则类型，值参考 SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule.RULETYPE_XXX 定义
	 * @return
	 */
	String getRuleType();
	
	
	
	/**
	 * 获取规则信息
	 * @return
	 */
	String getRuleInfo();
	
	
	
	/**
	 * 获取正则式内容
	 * @return
	 */
	String getRegExCode();
	
	
	/**
	 * 获取脚本代码
	 * @return
	 */
	String getScriptCode();
	
	
	/**
	 * 获取自定义处理对象
	 * @return
	 */
	String getCustomObject();
	
	
	/**
	 * 获取自定义参数集合
	 * @return
	 */
	String getCustomParams();
}
