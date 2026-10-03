package net.ibizsys.paas.ctrlhandler;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.web.IWebContext;


/**
 * 部件请求操作处理队列基类
 * @author Administrator
 *
 */
public abstract class CtrlActionHandlerBase implements ICtrlActionHandler{
	
	private ICtrlHandler iCtrlHandler = null;
	
	@Override
	public void init(ICtrlHandler iCtrlHandler) throws Exception {
		this.iCtrlHandler = iCtrlHandler;
	}

	
	/**
	 * 获取部件处理对象
	 * @return
	 */
	protected ICtrlHandler getCtrlHandler(){
		return this.iCtrlHandler;
	}
	
	
	/**
	 * 获取部件的模型对象
	 * @return
	 */
	protected ICtrlModel getCtrlModel(){
		return this.getCtrlHandler().getCtrlModel();
	}

	
	/**
	 * 获取当前系统模型
	 * 
	 * @return
	 */
	protected ISystemModel getSystemModel() {
		return this.getCtrlHandler().getViewController().getSystemModel();
	}

	/**
	 * 获取当前实体模型
	 * 
	 * @return
	 */
	protected IDataEntityModel getDEModel() {
		if (this.getCtrlModel() != null && this.getCtrlModel().getDEModel() != null) return this.getCtrlModel().getDEModel();

		return this.getCtrlHandler().getViewController().getDEModel();
	}
	
	
	/**
	 * 获取Web请求上下文对象
	 * @return
	 */
	protected IWebContext getWebContext(){
		return  this.getCtrlHandler().getWebContext();
	}
	
	
	
	/**
	 * 获取数据库会话工厂 
	 * @return
	 */
	protected SessionFactory getSessionFactory(){
		return this.getCtrlHandler().getSessionFactory();
	}
	
	
	/**
	 * 获取临时数据模式
	 * @return
	 */
	protected int getTempMode(){
		return this.getCtrlHandler().getTempMode();
	}
}
