package net.ibizsys.paas.core;

import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.web.IWebContext;

/**
 * 实体数据导出项接口
 * 
 * @author Administrator
 *
 */
public interface IDEDataExportItem extends IDataItem {
	/**
	 * 获取实体数据导出对象
	 * 
	 * @return
	 */
	IDEDataExport getDEDataExport();

	/**
	 * 获取权限标识
	 * 
	 * @return
	 */
	String getPrivilegeId();

	/**
	 * 获取项标题
	 * 
	 * @return
	 */
	String getCaption();

	/**
	 * 获取Excel文本值
	 * 
	 * @param iWebContext
	 * @param object
	 * @param bEnableItemPrivilege 是否启用列权限
	 * @return
	 * @throws Exception
	 */
	String getText(IWebContext iWebContext, Object object, boolean bEnableItemPrivilege) throws Exception;
	
	
	
	/**
	 * 获取标题语言资源标识
	 * @return
	 */
	String getCapLanResTag();
}
