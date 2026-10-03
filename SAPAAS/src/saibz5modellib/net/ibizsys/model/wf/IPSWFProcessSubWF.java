package net.ibizsys.model.wf;

import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.pswf.core.IWFProcSubWFModel;

/**
 * 工作流嵌入流程处理对象接口
 * 
 * @author Administrator
 *
 */
public interface IPSWFProcessSubWF extends IWFProcSubWFModel {

	

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
	 * 获取代码名称
	 * 
	 * @return
	 */
	String getCodeName();

}
