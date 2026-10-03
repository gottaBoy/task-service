package net.ibizsys.model.dataentity.field.valuerule;

/**
 * 属性值规则（字符串长度）对象接口
 * @author Administrator
 *
 */
public interface IPSDEFVRStringLengthCondition extends IPSDEFVRSingleCondition
{
	/**
	 * 获取最小值
	 * @return
	 */
	Integer getMinValue();
	
	
	/**
	 * 是否包括最小值
	 * @return
	 */
	boolean isIncludeMinValue();
	
	/**
	 * 获取最大值
	 * @return
	 */
	Integer getMaxValue();
	
	
	/**
	 * 是否包括最大值
	 * @return
	 */
	boolean isIncludeMaxValue();
}
