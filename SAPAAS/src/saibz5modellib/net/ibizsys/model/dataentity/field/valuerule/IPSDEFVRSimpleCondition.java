package net.ibizsys.model.dataentity.field.valuerule;

/**
 * 属性值规则（标准条件）对象接口
 * @author Administrator
 *
 */
public interface IPSDEFVRSimpleCondition extends IPSDEFVRSingleCondition
{
	/**
	 * 获取值操作符号标识
	 * @return
	 */
	String getPSDBValueOPId();
	
	
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
