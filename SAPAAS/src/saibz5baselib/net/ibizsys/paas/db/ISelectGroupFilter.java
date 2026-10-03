package net.ibizsys.paas.db;

import java.util.ArrayList;

import net.ibizsys.paas.core.IDEDataQueryCodeCond;


/**
 * 获取组条件
 * @author Administrator
 *
 */
public interface ISelectGroupFilter extends ISelectFilter,IDEDataQueryCodeCond {

	/**
	 * 获取查询过滤对象集合
	 * @param bCreateIfNotExists
	 * @return
	 */
	ArrayList<IDEDataQueryCodeCond> getSelectFilterList(boolean bCreateIfNotExists);
	
}
