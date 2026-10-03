package net.ibizsys.psba.core;

import net.ibizsys.paas.core.IDEField;

/**
 * 大数据列模型接口对象
 * 
 * @author Administrator
 *
 */
public interface IBAColumn extends IBATableObject {

	/**
	 * 联合键值1
	 */
	public final static String UNIONKEYVALUE_KEY1 = "KEY1";
	
	/**
	 * 联合键值2
	 */
	public final static String UNIONKEYVALUE_KEY2 = "KEY2";

	/**
	 * 联合键值3
	 */
	public final static String UNIONKEYVALUE_KEY3 = "KEY3";

	/**
	 * 联合键值4
	 */
	public final static String UNIONKEYVALUE_KEY4 = "KEY4";
	
	/**
	 * 获取实体属性模型
	 * 
	 * @return
	 */
	IDEField getDEField();

	/**
	 * 获取列族模型
	 * 
	 * @return
	 */
	IBAColSet getBAColSet();

	/**
	 * 获取表实体模型对象
	 * 
	 * @return
	 */
	IBATableDE getBATableDE();

	/**
	 * 数据库值函数
	 * 
	 * @return
	 */
	String getDBValueFunc();

	/**
	 * 获取实体属性名称
	 * 
	 * @return
	 */
	String getDEFieldName();

	/**
	 * 获取实体名称
	 * 
	 * @return
	 */
	String getDEName();

	/**
	 * 获取列族名称
	 * 
	 * @return
	 */
	String getBAColSetName();

	/**
	 * 获取预定义列类型
	 * 
	 * @return
	 */
	String getPreDefinedType();

	/**
	 * 是否支持临时数据
	 * 
	 * @return
	 */
	boolean isEnableTempData();

	/**
	 * 获取标准数据类型
	 * 
	 * @return
	 */
	int getStdDataType();
	
	
	
	
	
	/**
	 * 获取联合键值模式
	 * @return
	 */
	String getUnionKeyValue();
	
	
	
	/**
	 * 获取大数据表实体标识
	 * @return
	 */
	String getBATableDEId();
}
