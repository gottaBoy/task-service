package net.ibizsys.paas.ctrlhandler;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;

/**
 * 控件后台处理对象接口
 * 
 * @author lionlau
 *
 */
public interface ICtrlHandler {
	/**
	 * 临时数据模式:未知
	 */
	public final static int TEMPMODE_NONE = 0;

	/**
	 * 临时数据模式:主数据
	 */
	public final static int TEMPMODE_MAJOR = 1;

	/**
	 * 临时数据模式:从数据
	 */
	public final static int TEMPMODE_MINOR = 2;

	/**
	 * 初始化
	 * 
	 * @param iViewController
	 * @throws Exception
	 */
	void init(IViewController iViewController) throws Exception;

	/**
	 * 获取控件模型
	 * 
	 * @return
	 */
	ICtrlModel getCtrlModel();

	/**
	 * 获取视图Controller
	 * 
	 * @return
	 */
	IViewController getViewController();

	/**
	 * 获取上下文对象
	 * 
	 * @return
	 */
	IWebContext getWebContext();

	/**
	 * 处理
	 * 
	 * @param strAction
	 * @param iWebContext
	 * @return
	 * @throws Exception
	 */
	AjaxActionResult processAction(String strAction, IWebContext iWebContext) throws Exception;

	/**
	 * 是否临时模式
	 * 
	 * @return
	 */
	int getTempMode();

	/**
	 * 转换实体属性错误
	 * 
	 * @param entityFieldError
	 * @throws Exception
	 */
	boolean convertEntityFieldError(EntityFieldError entityFieldError) throws Exception;
	
	
	/**
	 * 获取处理对象名称
	 * @return
	 */
	String getName();

	
	
	/**
	 * 获取数据库会话工厂
	 * @return
	 */
	SessionFactory getSessionFactory();
	
}
