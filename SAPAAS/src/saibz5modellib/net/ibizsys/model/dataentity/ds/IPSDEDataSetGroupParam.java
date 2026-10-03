package net.ibizsys.model.dataentity.ds;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.paas.core.IDEDataSetGroupParam;

/**
 * 实体数据集合分组参数对象接口
 * @author lionlau
 *
 */
public interface IPSDEDataSetGroupParam extends IPSModelObject,IDEDataSetGroupParam
{

	/**
	 * 
	 * 获取实体数据集合
	 * @return
	 */
	IPSDEDataSet getPSDEDataSet();
	
	
	
	/**
	 * 获取标准数据类型
	 * @return
	 */
	int getStdDataType(); 
	
}
