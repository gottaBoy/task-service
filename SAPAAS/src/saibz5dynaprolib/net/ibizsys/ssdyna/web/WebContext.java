package net.ibizsys.ssdyna.web;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;

/**
 * 动态系统 Web 请求上下文对象
 * @author Administrator
 *
 */
public class WebContext extends net.ibizsys.saas.web.WebContext implements IDynaWebContext{

	private static ThreadLocal<String> dynaSysInstId = new ThreadLocal<String>();
	
	/**
	 * 获取当前动态系统 Web 请求上下文对象（必须存在）
	 * @return
	 * @throws Exception
	 */
	public static IDynaWebContext getDynaWebContext() throws Exception{
		return getDynaWebContext(false);
	}
	
	
	/**
	 * 获取当前动态系统 Web 请求上下文对象
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	public static IDynaWebContext getDynaWebContext(boolean bTryMode) throws Exception{
		IWebContext iWebContext = getCurrent();
		if(iWebContext != null && iWebContext instanceof IDynaWebContext) {
			return (IDynaWebContext)iWebContext;
		}
		if(!bTryMode ) {
			throw new Exception(StringHelper.format("无法获取动态系统 Web请求上下文对象"));
		}
		return null;
	}
	


	
	/**
	 * 获取当前动态系统实例标识
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	public static String getDynaSysInstId(boolean bTryMode) throws Exception{
		String strDynaInstId = dynaSysInstId.get();
		if(!StringHelper.isNullOrEmpty(strDynaInstId)) {
			return strDynaInstId;
		}
		if(WebContext.getCurrent() != null) {
			strDynaInstId = getDynaSysInstId(WebContext.getCurrent());
		}
		if(StringHelper.isNullOrEmpty(strDynaInstId)&& !bTryMode) {
			throw new Exception("没有指定当前动态实例标识");
		}
		return strDynaInstId;
	}
	
	
	
	
	/**
	 * 设置当前动态系统实例标识
	 * @param strDevCenterId
	 */
	public static void setDynaSysInstId(String strDynaInstId) {
		dynaSysInstId.set(strDynaInstId);
	}
	
	
	@Override
	public IDynaSysModel getDynaSysModel(boolean bTryMode) throws Exception {
		net.ibizsys.paas.core.ISystem iSystemModel = getCurSystem();
		if(iSystemModel != null && (iSystemModel instanceof IDynaSysModel)) {
			return (IDynaSysModel)iSystemModel;
		}
		if(!bTryMode)
		  throw new Exception("无法获取当前动态系统模型对象");
		return null;
	}
}
