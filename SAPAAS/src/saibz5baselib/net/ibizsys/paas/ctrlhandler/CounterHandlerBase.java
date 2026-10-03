package net.ibizsys.paas.ctrlhandler;

import java.util.HashMap;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;

/**
 * 计数器处理基类
 * 
 * @author Administrator
 *
 */
public abstract class CounterHandlerBase extends ModelBaseImpl implements ICounterHandler {
	


	private ThreadLocal<IWebContext> webContext = new ThreadLocal<IWebContext>();

	private ThreadLocal<IViewController> viewController = new ThreadLocal<IViewController>();

	private ISystem iSystem = null;

	private HashMap<String, String> counterItemMap = new HashMap<String, String>();

	private SessionFactory sessionFactory = null;
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ICounterHandler#init(net.ibizsys.paas.core.ISystem)
	 */
	@Override
	public void init(ISystem iSystem) throws Exception {
		this.iSystem = iSystem;
		this.onInit();
	}

	/**
	 * 设置计数器处理对象标识
	 * 
	 * @param strId
	 */
	protected void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置计数器处理对象名称
	 * 
	 * @param strName
	 */
	protected void setName(String strName) {
		this.strName = strName;
	}

	/**
	 * 获取系统模型
	 * 
	 * @return
	 */
	protected ISystemModel getSystemModel() {
		return (ISystemModel) this.iSystem;
	}

	/**
	 * 获取上下文对象
	 * 
	 * @return
	 */
	public IWebContext getWebContext() {
		return webContext.get();
	}

	/**
	 * 设置上下文对象
	 * 
	 * @param value
	 */
	private void setWebContext(IWebContext value) {
		webContext.set(value);
	}

	/**
	 * 获取当前视图控制器
	 * 
	 * @return
	 */
	public IViewController getViewController() {
		return viewController.get();
	}

	/**
	 * 设置当前视图控制器
	 * 
	 * @param value
	 */
	private void setViewController(IViewController value) {
		viewController.set(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ICounterHandler#processAction(java.lang.String, net.ibizsys.paas.controller.IViewController, net.ibizsys.paas.web.IWebContext)
	 */
	@Override
	public AjaxActionResult processAction(String strAction, IViewController iViewController, IWebContext iWebContext) throws Exception {
		this.setWebContext(iWebContext);
		this.setViewController(iViewController);
		AjaxActionResult ajaxActionResult = onProcessAction(strAction);
		return ajaxActionResult;
	}

	@Override
	public int getCounterItemValue(String strCounterItem,IViewController iViewController, IWebContext iWebContext) throws Exception {
		this.setWebContext(iWebContext);
		this.setViewController(iViewController);
		return getCounterItemValue(strCounterItem);
	}
	
	protected int getCounterItemValue(String strCounterItem) throws Exception{
		return 0;
	}
	
	/**
	 * 后台处理
	 * 
	 * @param strAction 行为
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onProcessAction(String strAction) throws Exception {
		if (StringHelper.compare(strAction, ACTION_FETCH, true) == 0) {
			return onFetch();
		}

		throw new Exception("没有实现");
	}

	/**
	 * 数据获取处理
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onFetch() throws Exception {
		throw new Exception("没有实现");
	}

	/**
	 * 注册计数项
	 * 
	 * @param strItem 计数项
	 * @param strMemo 说明
	 */
	protected void registerCounterItem(String strItem, String strMemo) {
		strItem = strItem.toUpperCase();

		if (StringHelper.isNullOrEmpty(strMemo)) {
			strMemo = "";
		}
		synchronized (counterItemMap) {
			counterItemMap.put(strItem, strMemo);
		}
	}

	/**
	 * 获取计数项
	 * 
	 * @return
	 */
	protected java.util.Iterator<String> getCounterItems() {
		return this.counterItemMap.keySet().iterator();
	}

	
	/**
	 * 获取会话工厂
	 * @return
	 */
	public SessionFactory getSessionFactory(){
		if(this.sessionFactory!=null)
			return this.sessionFactory;
		if(this.getViewController()!=null)
			return this.getViewController().getSessionFactory();
		return null;
	}
	
	
	/**
	 * 设置会话工厂
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	
	
}
