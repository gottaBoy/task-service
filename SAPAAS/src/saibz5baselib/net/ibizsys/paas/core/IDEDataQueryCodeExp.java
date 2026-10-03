package net.ibizsys.paas.core;

/**
 * 实体查询代码表达式接口
 * 
 * @author lionlau
 *
 */
public interface IDEDataQueryCodeExp extends IModelBase {

	/**
	 * 获取表单式
	 * 
	 * @return
	 */
	String getExpression();

	/**
	 * 获取显示次序
	 * 
	 * @return
	 */
	int getShowOrder();
}
