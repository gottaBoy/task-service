package net.ibizsys.psba.dao;

import net.ibizsys.paas.db.ISelectFieldFilter;

/**
 * 大数据数据查询过滤器接口
 * @author Administrator
 *
 */
public interface IBASelectFilter extends ISelectFieldFilter {
	
	/**
	 * 单列值过滤   展开
	 */
	final static String BAFILTER_COLUMNVALUE = "COLUMNVALUE";
	
	/**
	 * 单列值包含过滤
	 */
	final static String BAFILTER_COLUMNVALUECONTAINS="COLUMNVALUEPRE";
	
	/**
	 * 对所有列值进行过滤,查找以该前缀开头的值
	 */
	final static String BAFILTER_XCOLUMNVALUEPRE="XCOLUMNVALUEPRE";
	
	/**
	 * rowKey的值过滤
	 */
	final static String BAFILTER_ROWKEY="ROWKEY";
	
	/**
	 * 列名的值过滤
	 */
	final static String BAFILTER_COLUMNNAME="COLUMNNAME";
	
	/**
	 * 列名的前缀过滤
	 */
	final static String BAFILTER_COLUMNNAMEPRE="COLUMNNAMEPRE";
	
	
	/**
	 * 获取过滤器类型
	 * @return
	 */
	String getBAFilterType();
	
	
	
	/**
	 * 获取相应的列族
	 * @return
	 */
	String getColSet();
	
	
	
	/**
	 * 获取条件对象值
	 * @return
	 */
	Object getCondObjectValue() throws Exception;
	
	
}
