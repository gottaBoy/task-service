package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.paas.core.valuerule.IDEFVRCondition;

/**
 * 属性值规则条件对象接口
 * 
 * @author Administrator
 *
 */
public interface IPSDEFVRCondition extends IDEFVRCondition, IPSModelObject {
	

	/**
	 * 获取值规则
	 * 
	 * @return
	 */
	IPSDEFValueRule getPSDEFValueRule();

	/**
	 * 获取条件组
	 * 
	 * @return
	 */
	IPSDEFVRGroupCondition getPSDEFVRGroupCondition();

	/**
	 * 获取条件类型
	 * 
	 * @return
	 */
	String getCondType();

	/**
	 * 获取规则信息
	 * 
	 * @return
	 */
	String getRuleInfo();

	

	/**
	 * 是否取反逻辑
	 * 
	 * @return
	 */
	boolean isNotMode();

	/**
	 * 是否为参数判断
	 * 
	 * @return
	 */
	boolean isTryMode();

	/**
	 * 是否为关键条件
	 * 
	 * @return
	 */
	boolean isKeyCond();

}
