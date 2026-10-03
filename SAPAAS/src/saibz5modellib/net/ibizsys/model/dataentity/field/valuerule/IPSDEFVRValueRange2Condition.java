package net.ibizsys.model.dataentity.field.valuerule;

/**
 * 性值规则条件：值范围对象接口
 * @author Administrator
 *
 */
public interface IPSDEFVRValueRange2Condition extends IPSDEFVRSingleCondition
{
	/**
	 * 获取最小值
	 * @return
	 */
	Double getMinValue();
	
	
	/**
	 * 是否包括最小值
	 * @return
	 */
	boolean isIncludeMinValue();
	
	/**
	 * 获取最大值
	 * @return
	 */
	Double getMaxValue();
	
	
	/**
	 * 是否包括最大值
	 * @return
	 */
	boolean isIncludeMaxValue();
}
