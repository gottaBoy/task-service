package net.ibizsys.paas.sysmodel;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 系统代码表模型接口
 * 
 * @author lionlau
 *
 */
public interface ICodeListModel extends ICodeList,IModelBase3 {
	/**
	 * 填充结果
	 * 
	 * @param fetchResult
	 * @param iWebContext
	 * @throws Exception
	 */
	void fillFetchResult(MDAjaxActionResult fetchResult, IWebContext iWebContext) throws Exception;

	/**
	 * 设置会话工厂
	 * 
	 * @param sessionFactory
	 */
	void setSessionFactory(SessionFactory sessionFactory);

	/**
	 * 获取会话工厂
	 * 
	 * @return
	 */
	SessionFactory getSessionFactory();

	/**
	 * 重新刷新
	 * 
	 * @throws Exception
	 */
	void refresh() throws Exception;

	/**
	 * 从指定代码表构建
	 * 
	 * @param iCodeListModel
	 * @throws Exception
	 */
	void from(ICodeListModel iCodeListModel) throws Exception;

	
}
