package net.ibizsys.paas.security;

import java.util.HashMap;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.LoginLog;

/**
 * 远程登录全局对象
 * 
 * @author Administrator
 *
 */
public class RemoteLoginGlobal {
	private static HashMap<String, LoginLog> loginLogMap = new HashMap<String, LoginLog>();
	private static HashMap<String, String> userLoginLogMap = new HashMap<String, String>();

	/**
	 * 设置用户登录日志
	 * 
	 * @param strUserId
	 * @param loginLog
	 * @return
	 * @throws Exception
	 */
	public static LoginLog setUserLoginLog(String strUserId, LoginLog loginLog) throws Exception {
		synchronized (loginLogMap) {
			LoginLog lastLoginLog = getUserLoginLog(strUserId);
			loginLogMap.put(loginLog.getLoginLogId(), loginLog);
			userLoginLogMap.put(strUserId, loginLog.getLoginLogId());
			return lastLoginLog;
		}
	}

	/**
	 * 获取用户登录日志
	 * 
	 * @param strUserId
	 * @return
	 */
	public static LoginLog getUserLoginLog(String strUserId) {
		synchronized (loginLogMap) {
			String strUserLoginId = userLoginLogMap.get(strUserId);
			if (StringHelper.isNullOrEmpty(strUserLoginId)) return null;
			return loginLogMap.get(strUserLoginId);
		}
	}

	/**
	 * 获取用户登录日志
	 * 
	 * @param strLoginLogId
	 * @return
	 */
	public static LoginLog getLoginLog(String strLoginLogId) {
		synchronized (loginLogMap) {
			return loginLogMap.get(strLoginLogId);
		}
	}
	
	/**
	 * 移除用户登录日志
	 * 
	 * @param strLoginLogId
	 * @return
	 */
	public static void removeLoginLog(String strLoginLogId) {
		synchronized (loginLogMap) {
			if(loginLogMap.containsKey(strLoginLogId))
				loginLogMap.remove(strLoginLogId);
		}
	}
	
	/**
	 * 移除用户登录日志
	 * 
	 * @param strUserId
	 * @return
	 */
	public static void removeUserLoginLog(String strUserId) {
		synchronized (loginLogMap) {
			if(userLoginLogMap.containsKey(strUserId)) {
				String strUserLoginId = userLoginLogMap.get(strUserId);
				if(loginLogMap.containsKey(strUserLoginId))
						loginLogMap.remove(strUserLoginId);
				userLoginLogMap.remove(strUserId);
			}
		}
	}
}
