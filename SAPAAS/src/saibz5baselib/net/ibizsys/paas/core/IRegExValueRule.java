package net.ibizsys.paas.core;

/**
 * 正则式值规则对象接口
 * @author Administrator
 *
 */
public interface IRegExValueRule extends IValueRule {

	/**
	 * 获取表单式
	 * @return
	 */
	String getExpression();
}
