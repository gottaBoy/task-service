package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.core.valuerule.IDEFValueRule;

/**
 * 属性值规则模型
 * 
 * @author Administrator
 *
 */
public interface IDEFValueRuleModel extends IDEFValueRule,IModelBase3 {
	/**
	 * 测试规则是否成立
	 * 
	 * @param iActionContext
	 * @throws Exception
	 */
	void test(IActionContext iActionContext) throws Exception;
}
