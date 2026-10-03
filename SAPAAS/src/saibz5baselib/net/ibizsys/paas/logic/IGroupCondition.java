package net.ibizsys.paas.logic;

/**
 * 组条件接口
 * 
 * @author Administrator
 *
 * @param <CT>
 */
public interface IGroupCondition<CT extends ICondition> extends ICondition {
	
	
	
	/**
	 * 取反操作
	 * 
	 * @return
	 */
	boolean isNotMode();

	/**
	 * 获取全部子条件
	 * 
	 * @return
	 */
	java.util.Iterator<CT> getChildConditions();
}
