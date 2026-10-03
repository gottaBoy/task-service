package net.ibizsys.model.control.list;

import net.ibizsys.model.control.IPSAjaxControlParam;

/**
 * 实体列表参数对象接口
 * @author lionlau
 *
 */
public interface IPSDEListParam extends IPSAjaxControlParam
{
	/**
	 * 获取实体列表编号
	 * @return
	 */
	String getPSDEListId();
	
	
	
	/**
	 * 获取实体数据集合编号
	 * @return
	 */
	String getPSDEDataSetId();
}
