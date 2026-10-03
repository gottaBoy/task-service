package net.ibizsys.paas.core;

import net.ibizsys.paas.db.ISelectFilter;

/**
 * 数据查询代码条件代码
 * 
 * @author lionlau
 *
 */
public interface IDEDataQueryCodeCond extends IModelBase,ISelectFilter {

	/**
	 * 属性条件，单项条件
	 */
	final static String CONDTYPE_DEFIELD = "DEFIELD";

	/**
	 * 自定义条件，直接代码
	 */
	final static String CONDTYPE_CUSTOM = "CUSTOM";

	/**
	 * 组条件，包括一个或多个条件
	 */
	final static String CONDTYPE_GROUP = "GROUP";

	/**
	 * 预置条件，引擎预置的条件
	 */
	final static String CONDTYPE_PREDEFINED = "PREDEFINED";

	
	/**
	 * 获取属性名称
	 * 
	 * @return
	 */
	String getDEFName();

	/**
	 * 获取条件类型，值参考 IDEDataQueryCodeCond.CONDTYPE_XXXX
	 * 
	 * @return
	 */
	String getCondType();

	/**
	 * 获取条件操作，值参考  net.ibizsys.paas.logic.ICondition 
	 * 
	 * @return
	 */
	String getCondOp();

	/**
	 * 获取条件值
	 * 
	 * @return
	 */
	String getCondValue();

	/**
	 * 获取自定义条件
	 * 
	 * @return
	 */
	String getCustomCond();

	/**
	 * 获取预置条件，方法命名有误，请使用 getPredefinedCode
	 * 
	 * @return
	 */
	@Deprecated
	String getPredefindedCond();
	
	/**
	 * 获取预置条件
	 * 
	 * @return
	 */
	String getPredefinedCode();

	/**
	 * 获取子条件集合
	 * 
	 * @return
	 */
	java.util.Iterator<IDEDataQueryCodeCond> getChildDEDataQueryConds();

	/**
	 * 获取属性表达式
	 * 
	 * @return
	 */
	String getDEFieldExp();

	/**
	 * 是否为逻辑取反模式
	 * 
	 * @return
	 */
	boolean isNotMode();

	/**
	 * 获取值的标准数据类型
	 * 
	 * @return
	 */
	int getStdDataType();
	
	
	
	/**
	 * 获取值处理函数
	 * @return
	 */
	String getValueFunc();
	
}
