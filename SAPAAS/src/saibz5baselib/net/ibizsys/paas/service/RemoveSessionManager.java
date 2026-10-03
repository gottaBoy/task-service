package net.ibizsys.paas.service;

/**
 * 删除会话管理类
 * 
 * @author lionlau
 *
 */
@Deprecated
public class RemoveSessionManager {
	static ThreadLocal<RemoveSession> removeSession = new ThreadLocal<RemoveSession>();

	/**
	 * 打开新会话
	 * 
	 * @return
	 */
	static public RemoveSession openSession() {
		RemoveSession curentSession = removeSession.get();
		if (curentSession == null) {
			curentSession = new RemoveSession();
			removeSession.set(curentSession);
		}
		return curentSession;
	}

	/**
	 * 关闭当前会话
	 * 
	 * @return
	 */
	static public void closeSession() {
		removeSession.set(null);
	}

	/**
	 * 获取当前会话
	 * 
	 * @return
	 */
	static public RemoveSession getCurrentSession() {
		return removeSession.get();
	}
}
