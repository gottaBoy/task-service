package net.ibizsys.paas.ctrlhandler;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;

/**
 * 控件子项处理对象基类
 * 
 * @author lionlau
 *
 */
public class CtrlItemHandlerBase implements ICtrlItemHandler {
	private ICtrlHandler iCtrlHandler = null;

	/**
	 * 初始化
	 * 
	 * @param iCtrlHandler
	 * @throws Exception
	 */
	public void init(ICtrlHandler iCtrlHandler) throws Exception {
		this.setCtrlHandler(iCtrlHandler);
		onInit();
	}

	protected void onInit() throws Exception {

	}

	/**
	 * 获取部件处理对象
	 * 
	 * @return
	 */
	public ICtrlHandler getCtrlHandler() {
		return iCtrlHandler;
	}

	/**
	 * 设置部件处理对象
	 * 
	 * @param iCtrlHandler
	 */
	public void setCtrlHandler(ICtrlHandler iCtrlHandler) {
		this.iCtrlHandler = iCtrlHandler;
	}

	/**
	 * 获取Web请求上下文对象
	 * 
	 * @return
	 */
	public IWebContext getWebContext() {
		return getCtrlHandler().getWebContext();
	}

	/**
	 * 获取视图控制器
	 * 
	 * @return
	 */
	public IViewController getViewController() {
		return this.getCtrlHandler().getViewController();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ICtrlHandler#handlerAction(java.lang.String, net.ibizsys.paas.web.IWebContext)
	 */
	@Override
	public AjaxActionResult processAction(String strAction) throws Exception {
		AjaxActionResult ajaxActionResult = onProcessAction(strAction);
		return ajaxActionResult;
	}

	/**
	 * 执行处理
	 * 
	 * @param strAction
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onProcessAction(String strAction) throws Exception {
		throw new Exception("没有实现");
	}

	/**
	 * 获取对象
	 * 
	 * @param strBeanName
	 * @return
	 */
	protected Object getBean(String strName) {
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getWebContext().getRequest().getSession().getServletContext());
		return ctx.getBean(strName);
	}

}
