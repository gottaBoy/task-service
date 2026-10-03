package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.dataentity.IPSDataEntity;

/**
 * 属性值规则条件（值递归条件）对象接口
 * @author Administrator
 *
 */
public interface IPSDEFVRValueRecursionCondition extends IPSDEFVRSingleCondition
{
	/**
	 * 获取实体数据集合实体
	 * @return
	 */
	IPSDataEntity getMajorPSDataEntity();
	
	
	
	/**
	 * 是否为始终检查
	 * @return
	 */
	boolean isAlwaysCheck();
}
