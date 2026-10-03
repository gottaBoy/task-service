package net.ibizsys.paas.core;

import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.util.IGlobalContext;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 实体自填填充器接口
 * 
 * @author Administrator
 *
 */
public interface IDEACFiller {
	/**
	 * 初始化
	 * 
	 * @param iGlobalContext
	 * @param iDEACMode
	 * @throws Exception
	 */
	void init(IGlobalContext iGlobalContext, IDEACMode iDEACMode) throws Exception;

	/**
	 * 填充异步请求结果对象
	 * 
	 * @param fetchResult
	 * @param dt
	 * @throws Exception
	 */
	void fillAjaxFetchActionResult(MDAjaxActionResult fetchResult, IDataTable dt, IWebContext iWebContext) throws Exception;

	/**
	 * 关闭
	 */
	void close();
}
