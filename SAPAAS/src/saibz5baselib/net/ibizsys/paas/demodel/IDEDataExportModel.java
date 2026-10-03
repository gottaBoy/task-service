package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEDataExport;
import net.ibizsys.paas.core.IDEDataExportItem;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.web.IWebContext;

/**
 * 实体数据导出接口模型
 * 
 * @author Administrator
 *
 */
public interface IDEDataExportModel extends IDEDataExport,IModelBase3 {
	/**
	 * 获取列Excel文本值
	 * 
	 * @param iDEDataExportItem 导出
	 * @param iWebContext
	 * @param object
	 * @param bEnableItemPrivilege 是否启用列权限
	 * @return
	 * @throws Exception
	 */
	String getItemText(IDEDataExportItem iDEDataExportItem, IWebContext iWebContext, Object object, boolean bEnableItemPrivilege) throws Exception;
}
