package net.ibizsys.model.dataentity.field.valuerule;

/**
 * 属性值规则（正则式条件）对象接口
 * @author Administrator
 *
 */
public interface IPSDEFVRRegExCondition extends IPSDEFVRSingleCondition
{
	
	/**
	 * 获取正则式代码
	 * @return
	 */
	String getRegExCode();
}
