package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.valuerule.IPSSysValueRule;


/**
 * 属性值规则（系统值规则）对象接口
 * @author Administrator
 *
 */
public interface IPSDEFVRSysValueRuleCondition extends IPSDEFVRSingleCondition
{
	/**
	 * 获取系统值规则对象
	 * @return
	 */
	IPSSysValueRule getPSSysValueRule();
}
