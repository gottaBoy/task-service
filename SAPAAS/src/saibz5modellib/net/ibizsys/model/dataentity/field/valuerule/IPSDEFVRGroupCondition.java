package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.paas.core.valuerule.IDEFVRGroupCondition;

/**
 * 属性值规则组条件对象接口
 * @author Administrator
 *
 */
public interface IPSDEFVRGroupCondition extends IPSDEFVRCondition ,IDEFVRGroupCondition
{
	/**
	 * 获取组条件子条件集合
	 * @return
	 */
	java.util.Iterator<IPSDEFVRCondition> getPSDEFVRConditions();
	
	
	
	
}
