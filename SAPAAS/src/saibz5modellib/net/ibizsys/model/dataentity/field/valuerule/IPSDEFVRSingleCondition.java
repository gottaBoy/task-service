package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.dataentity.field.IPSDEField;


/**
 * 属性值规则单项条件对象接口
 * @author Administrator
 *
 */
public interface IPSDEFVRSingleCondition extends IPSDEFVRCondition
{
	/**
	 * 获取实体属性标识
	 * @return
	 */
	String getPSDEFId();
	

	
	
	/**
	 * 获取属性对象
	 * @return
	 */
	IPSDEField getPSDEField();
	
	
	
	
	/**
	 * 获取属性名称
	 * @return
	 */
	String getDEFName();
}
