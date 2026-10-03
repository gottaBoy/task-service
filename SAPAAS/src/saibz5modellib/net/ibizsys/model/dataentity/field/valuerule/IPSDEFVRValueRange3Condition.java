package net.ibizsys.model.dataentity.field.valuerule;

/**
 * 属性值规则条件：值范围对象接口
 * @author Administrator
 *
 */
public interface IPSDEFVRValueRange3Condition extends IPSDEFVRSingleCondition
{
	
	/**
	 * 获取分隔符号
	 * @return
	 */
	String getSeparator();
	
	
	/**
	 * 获取值范围
	 * @return
	 */
	String[] getValueRanges();
	
	
	
	
	/**
	 * 获取值列表，使用分隔符号分隔
	 * @return
	 */
	String getValues();
}
