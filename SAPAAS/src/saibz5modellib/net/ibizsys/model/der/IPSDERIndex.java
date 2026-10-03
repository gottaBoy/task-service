package net.ibizsys.model.der;


/**
 * 实体关系（索引）对象接口
 * @author Administrator
 *
 */
public interface IPSDERIndex extends IPSDERBase
{
	/**
	 * 获取分类值
	 * @return
	 */
	String getTypeValue();
	
	
	
	/**
	 * 获取属性映射名称
	 * @return
	 */
	java.util.Iterator getPropertyMapNames();
	
	
	
	/**
	 * @param strName
	 * @return
	 */
	String getPropertyMap(String strName);
}
