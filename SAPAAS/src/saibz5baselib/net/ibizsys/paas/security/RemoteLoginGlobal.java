/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.security;

import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.LoginLog;

public class RemoteLoginGlobal {
    private static HashMap<String, LoginLog> loginLogMap = new HashMap();
    private static HashMap<String, String> userLoginLogMap = new HashMap();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static LoginLog setUserLoginLog(String strUserId, LoginLog loginLog) throws Exception {
        HashMap<String, LoginLog> hashMap = loginLogMap;
        synchronized (hashMap) {
            LoginLog lastLoginLog = RemoteLoginGlobal.getUserLoginLog(strUserId);
            loginLogMap.put(loginLog.getLoginLogId(), loginLog);
            userLoginLogMap.put(strUserId, loginLog.getLoginLogId());
            return lastLoginLog;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static LoginLog getUserLoginLog(String strUserId) {
        HashMap<String, LoginLog> hashMap = loginLogMap;
        synchronized (hashMap) {
            String strUserLoginId;
            block4: {
                strUserLoginId = userLoginLogMap.get(strUserId);
                if (!StringHelper.isNullOrEmpty(strUserLoginId)) break block4;
                return null;
            }
            return loginLogMap.get(strUserLoginId);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static LoginLog getLoginLog(String strLoginLogId) {
        HashMap<String, LoginLog> hashMap = loginLogMap;
        synchronized (hashMap) {
            return loginLogMap.get(strLoginLogId);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void removeLoginLog(String strLoginLogId) {
        HashMap<String, LoginLog> hashMap = loginLogMap;
        synchronized (hashMap) {
            if (loginLogMap.containsKey(strLoginLogId)) {
                loginLogMap.remove(strLoginLogId);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void removeUserLoginLog(String strUserId) {
        HashMap<String, LoginLog> hashMap = loginLogMap;
        synchronized (hashMap) {
            if (userLoginLogMap.containsKey(strUserId)) {
                String strUserLoginId = userLoginLogMap.get(strUserId);
                if (loginLogMap.containsKey(strUserLoginId)) {
                    loginLogMap.remove(strUserLoginId);
                }
                userLoginLogMap.remove(strUserId);
            }
        }
    }
}

