package net.ibizsys.paas.appmodel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.controller.IViewControllerPlugin;
import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.web.Page;

/**
 * 应用程序插件
 * @author Administrator
 *
 */
public interface IApplicationPlugin extends IPlugin,IViewControllerPlugin {

	/**
	 * 获取部件绘制器接口
	 * @param iApplicationModel
	 * @param strCtrlType 部件类型
	 * @param strRender 绘制器标识
	 * @return
	 */
	PluginActionResult doGetCtrlRender(IApplicationModel iApplicationModel,String strCtrlType, String strRender,Object objParam);

	
	/**
	 * 过滤请求
	 * @param iApplicationModel
	 * @param iViewController 视图控制器接口
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	PluginActionResult doFilter(IApplicationModel iApplicationModel,IViewController iViewController, HttpServletRequest request, HttpServletResponse response,Object objParam) throws Exception;

	/**
	 * 过滤请求
	 * @param iApplicationModel
	 * @param page 页面对象
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	PluginActionResult doFilter(IApplicationModel iApplicationModel,Page page, HttpServletRequest request, HttpServletResponse response,Object objParam) throws Exception;

}
