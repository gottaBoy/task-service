package net.ibizsys.paas.api;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;

/**
 * RESTful service 控制器基类
 * @author Administrator
 *
 */
public abstract class RestControllerBase implements IRestController {

	private String strId = null;
	private ThreadLocal<SessionFactory> sessionFactory = new ThreadLocal<SessionFactory>();
	private static final Log log = LogFactory.getLog(RestControllerBase.class);

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.api.IRestController#getId()
	 */
	@Override
	public String getId() {
		return this.strId;
	}

	/**
	 * 设置控制器接口标识
	 * 
	 * @param strId
	 */
	protected void setId(String strId) {
		this.strId = strId;
	}
	
	

	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.api.IRestController#setSessionFactory(org.hibernate.SessionFactory)
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory.set(sessionFactory);
	}

	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.api.IRestController#getSessionFactory()
	 */
	public SessionFactory getSessionFactory() {
		return this.sessionFactory.get();
	}
	
	/**
	 * 执行Rest服务作业
	 * @param iRestServiceWork
	 * @return
	 */
	protected String doRestServiceWork(IRestServiceWork iRestServiceWork){
		return doRestServiceWork(iRestServiceWork,null,null);
	}
			
	/**
	 * 建立Rest调用结果
	 * @return
	 */
	protected RestCallResult createRestCallResult(){
		return new RestCallResult();
	}

	/**
	 * 执行Rest服务作业
	 * @param iRestServiceWork
	 * @param req 请求对象
	 * @param principal 安全凭证
	 * @return
	 */
	protected String doRestServiceWork(IRestServiceWork iRestServiceWork,HttpServletRequest req,Principal principal){
		long nBeginTime = java.lang.System.currentTimeMillis();
		RestCallResult callResult = createRestCallResult();
		boolean bCreateWebContext = false;
		try {
			if (WebContext.getCurrent() == null) {
				WebContext.setCurrent(createRestCallContext(callResult));
				bCreateWebContext = true;
			}
			
			iRestServiceWork.execute(callResult);

			if(bCreateWebContext){
				WebContext.setCurrent(null);
			}

		} catch (Exception ex) {
			log.error(ex);
			if(bCreateWebContext){
				WebContext.setCurrent(null);
			}
			RestCallResult.fromException(callResult, ex);
		}

		long nTime = java.lang.System.currentTimeMillis() - nBeginTime;
		log.debug(StringHelper.format("作业 耗时[%1$s]", nTime));
		return callResult.toJSONObject(null).toString();
	}
	
	
	/**
	 * 创建Rest调用上下文对象
	 * @return
	 * @throws Exception
	 */
	protected IRestCallContext createRestCallContext()throws Exception{
		return createRestCallContext(null);
	}
	
	/**
	 * 创建Rest调用上下文对象
	 * @param callResult
	 * @return
	 * @throws Exception
	 */
	protected IRestCallContext createRestCallContext(RestCallResult callResult)throws Exception{
		RestCallContext restCallContext = new RestCallContext();
		restCallContext.setRestCallResult(callResult);
		restCallContext.setSessionValue(IWebContext.PERSONID, "SYSTEM");
		restCallContext.setSessionValue(IWebContext.LOGINNAME, "SYSTEM");
		restCallContext.setSessionValue(IWebContext.USERNAME, "系统内置用户");
		return restCallContext;
	}
}
