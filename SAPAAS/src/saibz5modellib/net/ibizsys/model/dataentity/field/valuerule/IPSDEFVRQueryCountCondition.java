package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;


/**
 * 属性值规则（查询计数条件）对象接口
 * @author Administrator
 *
 */
public interface IPSDEFVRQueryCountCondition extends IPSDEFVRSingleCondition
{
	/**
	 * 数据查询标识
	 * @return
	 */
	String getPSDEDataQueryId();
	
	
	/**
	 * 获取实体数据查询
	 * @return
	 */
	IPSDEDataQuery getPSDEDataQuery();
	
	
	/**
	 * 获取最小值
	 * @return
	 */
	Integer getMinValue();
	
	
	/**
	 * 是否包括最小值
	 * @return
	 */
	boolean isIncludeMinValue();
	
	/**
	 * 获取最大值
	 * @return
	 */
	Integer getMaxValue();
	
	
	/**
	 * 是否包括最大值
	 * @return
	 */
	boolean isIncludeMaxValue();
	
	
	/**
	 * 是否为始终检查
	 * @return
	 */
	boolean isAlwaysCheck();
}
