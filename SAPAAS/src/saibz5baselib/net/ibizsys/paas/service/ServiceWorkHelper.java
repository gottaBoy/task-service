package net.ibizsys.paas.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.util.SimpleWebContext;

/**
 * 服务作业辅助对象
 * @author Administrator
 *
 */
public class ServiceWorkHelper {

	private static final Log log = LogFactory.getLog(ServiceWorkHelper.class);
	private static IWebContext simpleWebContext = null;
	
	static{
		SimpleWebContext webContext = new SimpleWebContext();
		webContext.setSessionValue(IWebContext.PERSONID, "SYSTEM");
		webContext.setSessionValue(IWebContext.LOGINNAME, "SYSTEM");
		webContext.setSessionValue(IWebContext.USERNAME, "系统内置用户");
		simpleWebContext = webContext;
	}
	
	/**
	 * 设置默认的Web请求上下文对象
	 * @param iWebContext
	 */
	public static void setWebContext(IWebContext iWebContext){
		simpleWebContext = iWebContext;
	}
	
	public static IWebContext getWebContext(){
		return simpleWebContext;
	}
	
	
	private IWebContext iWebContext = null;
	public ServiceWorkHelper(IWebContext iWebContext){
		this.iWebContext = iWebContext;
	}
	
	
	
	public ServiceWorkHelper(){
		
	}
	
	
	/**
	 * 获取辅助对象实例
	 * @param iWebContext
	 * @return
	 */
	public static ServiceWorkHelper getInstance(IWebContext iWebContext){
		return new ServiceWorkHelper(iWebContext);
	}
	
	
	/**
	 * 获取辅助对象实例
	 * @return
	 */
	public static ServiceWorkHelper getInstance(){
		return new ServiceWorkHelper();
	}
	
	
	
	/**
	 * 执行服务作业
	 * @param iServiceWork
	 * @throws Exception
	 */
	public void execute(IServiceWork iServiceWork) throws Exception {
		//long nBeginTime = java.lang.System.currentTimeMillis();

		boolean bOpenActionSession = (ActionSessionManager.getCurrentSession() == null);
		if (bOpenActionSession) {
			ActionSessionManager.openSession().setName("SERVICEWORKHELPER");
		}

		boolean bOpenCloneSession = (CloneSessionManager.getCurrentSession() == null);
		if (bOpenCloneSession) {
			CloneSessionManager.openSession().setOwner("SERVICEWORKHELPER");
		}

		boolean bCreateWebContext = false;
		int nLastRef = 0;
		try {
			
			nLastRef = SessionFactoryManager.addRef();
			
			if (WebContext.getCurrent() == null) {
				if(iWebContext!=null)
					WebContext.setCurrent(iWebContext);
				else
					WebContext.setCurrent(getWebContext());
				bCreateWebContext = true;
			}
			
			iServiceWork.execute(null);

			if(bCreateWebContext){
				WebContext.setCurrent(null);
			}
			
			if(nLastRef != SessionFactoryManager.releaseRef(true)+1){
				log.warn(StringHelper.format("实体服务[%1$s]会话工厂引用计数执行前后不一致，可能存在数据锁问题","SERVICEWORKHELPER"));
			}
			if (bOpenActionSession) {
				ActionSessionManager.closeSession();
			}
			if (bOpenCloneSession) {
				CloneSessionManager.closeSession();
			}
		} catch (Exception ex) {
			
			if(bCreateWebContext){
				WebContext.setCurrent(null);
			}
			

			if(nLastRef != 	SessionFactoryManager.releaseRef(false)+1){
				log.warn(StringHelper.format("实体服务[%1$s]会话工厂引用计数执行前后不一致，可能存在数据锁问题","SERVICEWORKHELPER"));
			}

			if (bOpenActionSession) {
				ActionSessionManager.closeSession();
			}
			if (bOpenCloneSession) {
				CloneSessionManager.closeSession();
			}
			throw ex;
		}

//		long nTime = java.lang.System.currentTimeMillis() - nBeginTime;
//		log.debug(StringHelper.format("作业 耗时[%1$s]", nTime));
	}
	
	
}
