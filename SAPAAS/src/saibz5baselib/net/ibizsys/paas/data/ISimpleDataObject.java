package net.ibizsys.paas.data;

/**
 * 简单数据对象接口
 * 
 * @author Administrator
 *
 */
public interface ISimpleDataObject {

	/**
	 * 获取属性值
	 * 
	 * @param strParamName
	 * @return
	 */
	Object get(String strParamName) throws Exception;

	/**
	 * 判断参数是否为空
	 * 
	 * @param strParamName
	 * @return
	 */
	boolean isNull(String strParamName) throws Exception;

	/**
	 * 判断是否存在指定参数
	 * 
	 * @param strParamName
	 * @return
	 * @throws Exception
	 */
	boolean contains(String strParamName) throws Exception;
}
