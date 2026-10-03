package net.ibizsys.paas.logic;

/**
 * 条件函数接口
 * 
 * @author Administrator
 *
 */
public interface IConditionFunc {

	/**
	 * 判断是否成立
	 * 
	 * @param object
	 * @return
	 * @throws Exception
	 */
	boolean test(Object object) throws Exception;
}
