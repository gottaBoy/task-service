package net.ibizsys.model.wf;

import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;

/**
 * 工作流实体数据集合角色对象接口
 * 
 * @author Administrator
 *
 */
public interface IPSWFDEDataSetRole extends IPSWFRole {

	/**
	 * 获取实体对象
	 * 
	 * @return
	 */
	IPSDataEntity getPSDataEntity();

	/**
	 * 获取实体数据集合对象
	 * 
	 * @return
	 */
	IPSDEDataSet getPSDEDataSet();

	/**
	 * 获取工作流用户标识存储属性
	 * 
	 * @return
	 */
	IPSDEField getWFUserIdPSDEF();

	/**
	 * 获取工作流用户名称存储属性
	 * 
	 * @return
	 */
	IPSDEField getWFUserNamePSDEF();

}
