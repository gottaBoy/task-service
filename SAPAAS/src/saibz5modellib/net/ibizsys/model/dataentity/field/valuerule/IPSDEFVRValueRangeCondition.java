package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;

/**
 * 属性值规则条件：数据集合范围条件
 * @author Administrator
 *
 */
public interface IPSDEFVRValueRangeCondition extends IPSDEFVRSingleCondition
{
	/**
	 * 获取实体数据集合实体
	 * @return
	 */
	IPSDataEntity getMajorPSDataEntity();
	
	/**
	 * 获取实体数据集合
	 * @return
	 */
	IPSDEDataSet getMajorPSDEDataSet();
	
	
	/**
	 * 获取实体数据集合约束属性
	 * @return
	 */
	IPSDEField getExtMajorPSDEField();
	
	
	/**
	 * 获取当前实体约束属性
	 * @return
	 */
	IPSDEField getExtPSDEField();
	
	
	/**
	 * 是否为始终检查
	 * @return
	 */
	boolean isAlwaysCheck();
}
