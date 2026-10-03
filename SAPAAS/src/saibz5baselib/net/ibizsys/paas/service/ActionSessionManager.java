package net.ibizsys.paas.service;

/**
 * 服务操作会话管理类
 * 
 * @author lionlau
 *
 */
public class ActionSessionManager {
	
	static ThreadLocal<ActionSession> actionSession = new ThreadLocal<ActionSession>();

	/**
	 * 打开会话
	 * 
	 * @return
	 */
	static public ActionSession openSession() {
		return openSession("DEFAULT");
	}

	/**
	 * 打开新会话
	 * @strName 会话名称
	 * @return
	 */
	static public ActionSession openSession(String strName) {
		ActionSession currentSession = actionSession.get();
		if (currentSession == null) {
			currentSession = new ActionSession();
			currentSession.setName(strName);
			actionSession.set(currentSession);
		}
		return currentSession;
	}
	
	
	/**
	 * 打开新会话
	 * @strName 会话名称
	 * @bTopSession true 只打开顶级，如果顶级操作会话已经存在，则直接返回顶级会话，false，如顶级操作会话已经存在，则创建子会话
	 * @return
	 */
	static public ActionSession openSession(String strName,boolean bTopSession) {
		ActionSession currentSession = actionSession.get();
		if(currentSession!=null ){
			if(bTopSession)
				return currentSession;
			return currentSession.openChildSession(strName);
		}
			
		currentSession = new ActionSession();
		currentSession.setName(strName);
		actionSession.set(currentSession);
		return currentSession;
	}

	/**
	 * 关闭当前会话
	 * 
	 * @return
	 */
	static public void closeSession() {
		actionSession.set(null);
	}
	
	/**
	 * 关闭当前会话
	 * 
	 * @return
	 */
	static public void closeSession(boolean bTopSession) {
		if(bTopSession){
			actionSession.set(null);
		}
		else{
			ActionSession currentSession = actionSession.get();
			if(currentSession!=null){
				if(currentSession.closeChildSession()==-1){
					//无子会话
					actionSession.set(null);
				}
			}
		}
		
	}
	

	/**
	 * 获取当前会话
	 * 
	 * @return
	 */
	static public ActionSession getCurrentSession() {
		ActionSession actionSession2 = actionSession.get();
		if(actionSession2!=null)
			return actionSession2.getCurrentSession();
		return null;
	}

	/**
	 * 获取当前会话
	 * 
	 * @param bCreateIfNotExists 不存在时建立
	 * @return
	 */
	static public ActionSession getCurrentSession(boolean bCreateIfNotExists) {
		ActionSession actionSession2 = actionSession.get();
		if (actionSession2 == null && bCreateIfNotExists) {
			return openSession();
		}
		if(actionSession2==null)
			return null;
		return actionSession2.getCurrentSession();
	}

	/**
	 * 附加当前操作信息
	 * 
	 * @param strInfo
	 */
	public static void appendActionInfo(String strInfo) {
		if (getCurrentSession() == null) return;
		getCurrentSession().appendActionInfo(strInfo);
	}

	/**
	 * 获取当前操作信息
	 * 
	 * @param strInfo
	 */
	public static String getActionInfo() {
		if (getCurrentSession() == null) return null;
		return getCurrentSession().getActionInfo();
	}
}
