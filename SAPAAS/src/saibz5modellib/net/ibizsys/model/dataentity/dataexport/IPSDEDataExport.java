package net.ibizsys.model.dataentity.dataexport;

import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.paas.core.IDEDataExport;
/* INTERNAL-BEGIN */



/**
 * 实体数据导出定义对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSDEDataExport extends IPSDataEntityObject, IDEDataExport {
	

//	/**
//	 * 获取数据导出项集合
//	 * 
//	 * @return
//	 */
//	java.util.Iterator<IPSDEDataExportItem> getPSDEDataExportItems();

	/**
	 * 获取允许导出的最大记录数
	 * 
	 * @return
	 */
	int getMaxRowCount();
}
