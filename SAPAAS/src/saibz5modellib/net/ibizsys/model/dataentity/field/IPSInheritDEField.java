package net.ibizsys.model.dataentity.field;

/**
 * 实体继承属性对象接口
 * @author lionlau
 *
 */
public interface IPSInheritDEField extends IPSLinkDEField
{
	
	/**
	 * 获取实际继承的属性(可能存在多重继承)
	 * @return
	 */
	IPSDEField getRealInheritPSDEField() throws Exception;
}
