package net.ibizsys.paas.sysmodel;

/**
 * 系统全局异常处理对象
 * @author Administrator
 *
 */
public interface IExceptionHandler {

	/**
	 * 登记异常
	 * @param iSystemModel
	 * @param logger
	 * @param throwable
	 * @param strMessage
	 * @param objUserData
	 */
	void log(ISystemModel iSystemModel,Object logger,Throwable throwable,String strMessage,Object objUserData);
}
