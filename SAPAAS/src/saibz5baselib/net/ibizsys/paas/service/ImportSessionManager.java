package net.ibizsys.paas.service;

/**
 * 导入会话管理类
 * 
 * @author lionlau
 *
 */
public class ImportSessionManager {
	static ThreadLocal<ImportSession> importSession = new ThreadLocal<ImportSession>();

	/**
	 * 打开新会话
	 * 
	 * @return
	 */
	static public ImportSession openSession() {
		ImportSession curentSession = importSession.get();
		if (curentSession == null) {
			curentSession = new ImportSession();
			importSession.set(curentSession);
		}
		return curentSession;
	}

	/**
	 * 关闭当前会话
	 * 
	 * @return
	 */
	static public void closeSession() {
		importSession.set(null);
	}

	/**
	 * 获取当前会话
	 * 
	 * @return
	 */
	static public ImportSession getCurrentSession() {
		return importSession.get();
	}
}
