package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.core.IPSModelObject;

/**
 * 实体属性相关对象接口
 * @author lionlau
 *
 */
public interface IPSDEFieldObject  extends IPSModelObject
{
	/**
	 * 获取实体属性对象
	 * @return
	 */
	IPSDEField getPSDEField();
}
