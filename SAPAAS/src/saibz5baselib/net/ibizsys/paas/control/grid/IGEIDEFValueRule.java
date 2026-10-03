package net.ibizsys.paas.control.grid;

import net.ibizsys.paas.core.valuerule.IDEFValueRule;

/**
 * 表格编辑项属性值规则接口
 * <p>
 * GEI ==>Grid Edit Item,DEF==>DataEntity Field,
 * 
 * @author Administrator
 *
 */
public interface IGEIDEFValueRule {

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
