package net.ibizsys.psba.dao;

import net.ibizsys.paas.db.SelectFieldFilter;

/**
 * 大数据查询列过滤器对象实现
 * @author Administrator
 *
 */
public class BASelectFilter extends SelectFieldFilter implements IBASelectFilter {

	private String strColSet = null;
	private String strBAFilterType= null;
	
	
	@Override
	public String getColSet() {
		return this.strColSet;
	}

	/**
	 * 设置列族
	 * @param strColSet
	 */
	public void setColSet(String strColSet){
		this.strColSet = strColSet;
	}

	@Override
	public String getBAFilterType() {
		return this.strBAFilterType;
	}

	/**
	 * 设置大数据过滤器类型
	 * @param strBAFilterType
	 */
	public void setBAFilterType(String strBAFilterType) {
		this.strBAFilterType = strBAFilterType;
	}


	
}
