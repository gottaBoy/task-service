package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.service.IService;

/**
 * 系统全局异常处理器基类
 * @author Administrator
 *
 */
public abstract class ExceptionHandlerBase implements IExceptionHandler {

	@Override
	public void log(ISystemModel iSystemModel, Object logger, Throwable throwable, String strMessage, Object objUserData) {
		if(logger instanceof ICtrlHandler){
			onCtrlHandlerException(iSystemModel, (ICtrlHandler) logger,  throwable,  strMessage,  objUserData);
			return;
		}
		
		if(logger instanceof IViewController){
			onViewControllerException(iSystemModel, (IViewController) logger,  throwable,  strMessage,  objUserData);
			return;
		}
		
		if(logger instanceof IService){
			onServiceException(iSystemModel, (IService) logger,  throwable,  strMessage,  objUserData);
			return;
		}
	}

	/**
	 * 控件后台处理对象异常
	 * @param iSystemModel
	 * @param iCtrlHandler
	 * @param throwable
	 * @param strMessage
	 * @param objUserData
	 */
	protected void onCtrlHandlerException(ISystemModel iSystemModel, ICtrlHandler iCtrlHandler, Throwable throwable, String strMessage, Object objUserData){
		
	}
	
	/**
	 * 视图控制器异常
	 * @param iSystemModel
	 * @param iViewController
	 * @param throwable
	 * @param strMessage
	 * @param objUserData
	 */
	protected void onViewControllerException(ISystemModel iSystemModel, IViewController iViewController, Throwable throwable, String strMessage, Object objUserData){
		
	}
	
	
	/**
	 * 实体服务对象异常
	 * @param iSystemModel
	 * @param iService
	 * @param throwable
	 * @param strMessage
	 * @param objUserData
	 */
	protected void onServiceException(ISystemModel iSystemModel, IService iService, Throwable throwable, String strMessage, Object objUserData){
		
	}
}
