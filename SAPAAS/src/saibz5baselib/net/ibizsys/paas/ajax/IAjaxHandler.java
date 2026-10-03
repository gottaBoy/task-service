package net.ibizsys.paas.ajax;

import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.util.IGlobalContext;
import net.ibizsys.paas.view.IView;

/**
 * 异步后台处理对象接口
 * 
 * @author Administrator
 *
 */
public interface IAjaxHandler {
	/**
	 * 初始化
	 * 
	 * @param iGlobalContext 应用全局上下文对象
	 * @param iApplication 应用对象
	 * @param strHandler 处理器
	 * @throws Exception
	 */
	void init(IGlobalContext iGlobalContext, IApplication iApplication, String strHandler) throws Exception;

	/**
	 * 获取处理对象类型
	 * 
	 * @return
	 */
	String getHandlerType();

	/**
	 * 获取视图对象
	 * 
	 * @return
	 */
	IView getView();

	/**
	 * 退出，进行释放
	 */
	void close();

}
