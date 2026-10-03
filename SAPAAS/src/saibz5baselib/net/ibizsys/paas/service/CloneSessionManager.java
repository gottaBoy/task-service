package net.ibizsys.paas.service;

/**
 * 克隆会话管理类
 * 
 * @author lionlau
 *
 */
public class CloneSessionManager {
	static ThreadLocal<CloneSession> cloneSession = new ThreadLocal<CloneSession>();

	/**
	 * 打开新会话
	 * 
	 * @return
	 */
	static public CloneSession openSession() {
		CloneSession curentSession = cloneSession.get();
		if (curentSession == null) {
			curentSession = new CloneSession();
			cloneSession.set(curentSession);
		}
		return curentSession;
	}

	/**
	 * 关闭当前会话
	 * 
	 * @return
	 */
	static public void closeSession() {
		cloneSession.set(null);
	}

	/**
	 * 获取当前会话
	 * 
	 * @return
	 */
	static public CloneSession getCurrentSession() {
		return cloneSession.get();
	}
}
