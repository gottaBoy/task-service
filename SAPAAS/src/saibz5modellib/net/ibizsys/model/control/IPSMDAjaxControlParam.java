package net.ibizsys.model.control;

import net.ibizsys.model.dataentity.dataexport.IPSDEDataExport;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.logic.IPSDELogic;

/**
 * 多数据异步部件参数对象接口
 * @author Administrator
 *
 */
public interface IPSMDAjaxControlParam extends IPSAjaxControlParam
{
	/**
	 * 获取数据集合编号
	 * @return
	 */
	String getPSDEDataSetId();
	
	
	
	/**
	 * 获取实体数据集合
	 * @return
	 * @throws Exception
	 */
	IPSDEDataSet getPSDEDataSet() throws Exception;
	

	
	/**
	 * 获取数据导出标识
	 * @return
	 */
	String getPSDEDataExportId();
	
	
	
	/**
	 * 获取实体数据导出对象
	 * @return
	 * @throws Exception
	 */
	IPSDEDataExport getPSDEDataExport() throws Exception;
	
	
	
	/**
	 * 获取上下文数据转换逻辑标识
	 * @return
	 */
	String getActiveDataPSDELogicId();
	

	
	
	/**
	 * 获取上下文数据转换逻辑
	 * @return
	 * @throws Exception
	 */
	IPSDELogic getActiveDataPSDELogic() throws Exception;
}
