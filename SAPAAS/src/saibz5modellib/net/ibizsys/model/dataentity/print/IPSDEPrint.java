package net.ibizsys.model.dataentity.print;

import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;


/**
 * 实体打印单据对象接口
 * @author lionlau
 *
 */
public interface IPSDEPrint extends IPSDataEntityObject
{

	
	
	/**
	 * 获取实体数据结果集
	 * @return
	 */
	IPSDEDataSet getPSDEDataSet();
	
	/**
	 * 获取实体数据结果标识
	 * @return
	 */
	@Deprecated
	String getPSDEDataSetId();
	
	/**
	 * 获取代码名称
	 * @return
	 */
	String getCodeName();
	
	

	
	/**
	 * 是否启用列权限
	 * @return
	 */
	boolean isEnableColPriv();

	
	
	/**
	 * 是否启用打印日志
	 * @return
	 */
	boolean isEnableLog();
	
	
	/**
	 * 是否启用多数据打印
	 * @return
	 */
	boolean isEnableMulitPrint();
	
	
	
	/**
	 * 获取获取数据实体行为对象
	 * @return
	 */
	IPSDEAction getGetDataPSDEAction();
	
	
	/**
	 * 获取获取数据实体行为对象标识
	 * @return
	 */
	String getGetDataPSDEActionId();
	
	
	
	/**
	 * 获取报表类型
	 * @return
	 */
	String getReportType();
	
	
	
	/**
	 * 获取报表文件路径
	 * @return
	 */
	String getReportFile();
	
	
	/**
	 * 获取获取数据操作权限对象
	 * @return
	 */
	IPSDEOPPriv getGetDataPSDEOPPriv();
	
	
	
	/**
	 * 获取明细数据实体标识
	 * @return
	 */
	String getDetailPSDEId();
	
	
	/**
	 * 获取明细数据实体对象
	 * @return
	 */
	IPSDataEntity getDetailPSDE();
	
	
	/**
	 * 获取明细数据结果集
	 * @return
	 */
	IPSDEDataSet getDetailPSDEDataSet();
	
	
	
	/**
	 * 获取明细数据数据集合上下文转换逻辑标识
	 * @return
	 */
	String getDetailActiveDataPSDELogicId();
	
	
	/**
	 * 获取明细数据数据集合上下文转换逻辑
	 * @return
	 */
	IPSDELogic getDetailActiveDataPSDELogic();
	

}
