package net.ibizsys.pswf.core;

/**
 * 实体行为流程处理参数模型接口
 * @author lionlau
 *
 */
public interface IWFDEActionProcessParamModel
{
	/**
	*用户全局对象
	*/
	public final static String SRCVALUETYPE_SESSION = "SESSION" ;

	/**
	*系统全局对象
	*/
	public final static String SRCVALUETYPE_APPLICATION = "APPLICATION" ;

	/**
	*唯一编码
	*/
	public final static String SRCVALUETYPE_UNIQUEID = "UNIQUEID" ;

	/**
	*网页请求
	*/
	public final static String SRCVALUETYPE_CONTEXT = "CONTEXT" ;

	/**
	*当前操作用户(编号)
	*/
	public final static String SRCVALUETYPE_OPERATOR = "OPERATOR" ;

	/**
	*当前操作用户(名称)
	*/
	public final static String SRCVALUETYPE_OPERATORNAME = "OPERATORNAME" ;

	/**
	*当前时间
	*/
	public final static String SRCVALUETYPE_CURTIME = "CURTIME" ;
	
	
	/**
	 * 获取目标属性名称
	 * @return
	 * @throws Exception
	 */
	String getDstField() throws Exception;
	
	
	/**
	 * 获取参数值
	 * @return
	 */
	String getSrcValue();
	
	
	
	/**
	 * 获取直接的代码
	 * @return
	 */
	String getDirectCode();
	
	
	/**
	 * 获取源值类型
	 * @return
	 */
	String getSrcValueType();
}
