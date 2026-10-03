package net.ibizsys.model.control.ajax;

import net.ibizsys.model.dataentity.dataexport.IPSDEDataExport;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.paas.core.IDEDataRange;

/**
 * 多数据部件处理对象接口
 * @author lionlau
 *
 */
public interface IPSMDAjaxControlHandler extends IPSAjaxControlHandler,IDEDataRange
{
	/**
	 * 批添加数据
	 */
	final static String ACTION_ADDBATCH = "addbatch";

	/**
	 * 用户界面行为
	 */
	final static String ACTION_UIACTION = "uiaction";

	/**
	 * 导出数据模型
	 */
	final static String ACTION_EXPORTMODEL = "exportmodel";

	/**
	 * 导出导入模板
	 */
	final static String ACTION_EXPORTIMPTEMPL = "exportimptempl";

	/**
	 * 导出数据
	 */
	final static String ACTION_EXPORTDATA = "exportdata";
	
	
	/**
	 * 获取数据集合编号
	 * @return
	 */
	String getPSDEDataSetId();
	
	
	
	/**
	 * 获取数据实体对象
	 * @return
	 * @throws Exception
	 */
	IPSDEDataSet getPSDEDataSet() throws Exception;
	
	
	
	/**
	 * 获取数据导出编号
	 * @return
	 */
	String getPSDEDataExportId();
	
	
	
	/**
	 * 获取数据导出对象
	 * @return
	 * @throws Exception
	 */
	IPSDEDataExport getPSDEDataExport() throws Exception;
//	
//	
//	
//	
//	/**
//	 * 获取系统自定义权限数据范围
//	 * @return
//	 */
//	IPSSysUserDR getPSSysUserDR();
//	
//	
//	
//	/**
//	 * 获取系统自定义权限数据范围2
//	 * @return
//	 */
//	IPSSysUserDR getPSSysUserDR2();
	
	
	/**
	 * 获取数据查询超时时间
	 * @return
	 */
	int getFetchTimeout();
	
	
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
