package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEACMode;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 实体自动填充模式模型
 * 
 * @author Administrator
 *
 */
public interface IDEACModeModel extends IDEACMode ,IModelBase3 {
	/**
	 * 填充返回结果
	 * 
	 * @param fetchResult
	 * @param dt
	 * @param iWebContext
	 * @throws Exception
	 */
	void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt, IWebContext iWebContext) throws Exception;
}
