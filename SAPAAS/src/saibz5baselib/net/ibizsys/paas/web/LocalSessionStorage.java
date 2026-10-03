package net.ibizsys.paas.web;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * 本地会话存储对象
 * 
 * @author Administrator
 *
 */
public class LocalSessionStorage {

	private HashMap<String, HashMap<String, Object>> sessionValueMapMap = new HashMap<String, HashMap<String, Object>>();

	/**
	 * 本地会话存储对象标识
	 */
	public final static String LOCALSESSIONSTORAGE = "SRFLOCALSESSIONSTORAGE";

	/**
	 * 获取Session存储对象
	 * 
	 * @param servletContext
	 * @return
	 * @throws Exception
	 */
	public static LocalSessionStorage getCurrent(ServletContext servletContext) {
		Object objStorage = servletContext.getAttribute(LOCALSESSIONSTORAGE);
		if (objStorage == null) {
			objStorage = new LocalSessionStorage();
			servletContext.setAttribute(LOCALSESSIONSTORAGE, objStorage);
		}
		return (LocalSessionStorage) objStorage;
	}

	/**
	 * 设置会话值
	 * 
	 * @param session
	 * @param strKey
	 * @param objValue
	 */
	public void setSessionValue(HttpSession session, String strKey, Object objValue) {
		HashMap<String, Object> sessionValueMap = null;
		synchronized (sessionValueMapMap) {
			sessionValueMap = sessionValueMapMap.get(session.getId());
			if (sessionValueMap == null) {
				sessionValueMap = new HashMap<String, Object>();
				sessionValueMapMap.put(session.getId(), sessionValueMap);
			}
		}
		synchronized (sessionValueMap) {
			if (objValue == null) {
				sessionValueMap.remove(strKey);
			} else {
				sessionValueMap.put(strKey, objValue);
			}
		}
	}

	/**
	 * 获取会话值
	 * 
	 * @param session
	 * @param strKey
	 * @return
	 */
	public Object getSessionValue(HttpSession session, String strKey) {
		HashMap<String, Object> sessionValueMap = null;
		synchronized (sessionValueMapMap) {
			sessionValueMap = sessionValueMapMap.get(session.getId());
			if (sessionValueMap == null) {
				return null;
			}
		}
		synchronized (sessionValueMap) {
			return sessionValueMap.get(strKey);
		}
	}

	/**
	 * 移除会话
	 * 
	 * @param session
	 */
	public void removeSession(HttpSession session) {
		synchronized (sessionValueMapMap) {
			sessionValueMapMap.remove(session.getId());
		}
	}

}
