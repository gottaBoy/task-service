package net.ibizsys.pswf.core;


/**
 * 流程连接单项条件模型接口
 * @author Administrator
 *
 */
public interface IWFLinkSingleCondModel  extends IWFLinkCondModel
{
		
	/**
	 * 获取目标属性名称
	 * @return
	 * @throws Exception
	 */
	String getFieldName() throws Exception;
	

	/**
	 * 获取值操作符号标识
	 * @return
	 */
	String getCondOP();
	
	
	/**
	 * 获取参数类型
	 * @return
	 */
	String getParamType();
	
	
	/**
	 * 获取参数值
	 * @return
	 */
	String getParamValue();
	
	
	
}
