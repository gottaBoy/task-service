package net.ibizsys.paas.control.form;

import net.ibizsys.paas.core.valuerule.IDEFValueRule;

/**
 * 表单项属性值规则接口
 * 
 * @author Administrator
 *
 */
public interface IFIDEFValueRule {

	/**
	 * 获取规则名称
	 * 
	 * @return
	 */
	String getDEFVRName();

	/**
	 * 获取规则名称
	 * 
	 * @return
	 */
	String getDEFVRId();

	/**
	 * 获取属性值规则
	 * 
	 * @return
	 */
	IDEFValueRule getDEFValueRule();
}
