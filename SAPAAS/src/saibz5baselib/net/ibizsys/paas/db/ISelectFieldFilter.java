package net.ibizsys.paas.db;

import net.ibizsys.paas.core.IDEDataQueryCodeCond;


/**
 * 选择属性过滤器
 * @author Administrator
 *
 */
public interface ISelectFieldFilter extends ISelectFilter,IDEDataQueryCodeCond{

	/**
	 * 获取条件对象值
	 * @return
	 */
	Object getCondObjectValue() throws Exception;

}
