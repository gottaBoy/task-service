package net.ibizsys.paas.codelist;

import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.web.IWebContext;

/**
 * 动态代码表接口
 * 
 * @author Administrator
 *
 */
public interface IDynamicCodeList extends ICodeList {
	/**
	 * 实时获取代码项集合
	 * 
	 * @param iWebContext 当前网络请求上下文对象
	 * @param iDataObject 当前上下文数据
	 * @return
	 */
	java.util.Iterator<ICodeItem> queryCodeItems(IWebContext iWebContext, IDataObject iDataObject) throws Exception;

	/**
	 * 刷新动态代码表
	 */
	void refresh() throws Exception;

	/**
	 * 获取刷新间隔（毫秒）
	 * 
	 * @return
	 */
	int getRefreshTimer();
}
