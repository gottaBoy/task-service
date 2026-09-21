/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.pswx.bean.WXDept
 *  net.ibizsys.pswx.bean.WXUser
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.pswx.api;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.pswx.api.WXBaseApi;
import net.ibizsys.pswx.bean.WXDept;
import net.ibizsys.pswx.bean.WXUser;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WXEntAddressBookApi
extends WXBaseApi {
    private static final String SubscribeApi = "https://qyapi.weixin.qq.com/cgi-bin/user/authsucc";
    public static final String DeptCreateApi = "https://qyapi.weixin.qq.com/cgi-bin/department/create";
    private static final String DeptUpdateApi = "https://qyapi.weixin.qq.com/cgi-bin/department/update";
    private static final String DeptDeleteApi = "https://qyapi.weixin.qq.com/cgi-bin/department/delete";
    private static final String DeptListApi = "https://qyapi.weixin.qq.com/cgi-bin/department/list";
    private static final String UserCreateApi = "https://qyapi.weixin.qq.com/cgi-bin/user/create";
    private static final String UserUpdateApi = "https://qyapi.weixin.qq.com/cgi-bin/user/update";
    private static final String UserDeleteApi = "https://qyapi.weixin.qq.com/cgi-bin/user/delete";
    private static final String UserBatchDeleteApi = "https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete";
    private static final String UserGetApi = "https://qyapi.weixin.qq.com/cgi-bin/user/get";
    private static final String UserSimpleListApi = "https://qyapi.weixin.qq.com/cgi-bin/user/simplelist";
    private static final String UserListApi = "https://qyapi.weixin.qq.com/cgi-bin/user/list";

    public static CallResult subscribe(String accessToken, String userid) {
        return WXEntAddressBookApi.get(String.format("%1$s?access_token=%2$s&userid=%3$s", SubscribeApi, accessToken, userid), null);
    }

    public static CallResult createDept(String accessToken, JSONObject params) {
        return WXEntAddressBookApi.post(String.format("%1$s?access_token=%2$s", DeptCreateApi, accessToken), params);
    }

    public static CallResult updateDept(String accessToken, JSONObject params) {
        return WXEntAddressBookApi.post(String.format("%1$s?access_token=%2$s", DeptUpdateApi, accessToken), params);
    }

    public static CallResult deleteDept(String accessToken, int deptid) {
        return WXEntAddressBookApi.get(String.format("%1$s?access_token=%2$s&id=%3$s", DeptDeleteApi, accessToken, deptid), null);
    }

    public static CallResult deleteDept(String accessToken, int deptid, boolean cascade) {
        if (!cascade) {
            return WXEntAddressBookApi.deleteDept(accessToken, deptid);
        }
        return WXEntAddressBookApi.get(String.format("%1$s?access_token=%2$s&id=%3$s", DeptDeleteApi, accessToken, deptid), null);
    }

    public static CallResult listDept(String accessToken, int deptid) {
        return WXEntAddressBookApi.get(String.format("%1$s?access_token=%2$s&id=%3$s", DeptListApi, accessToken, deptid), null);
    }

    public static CallResult createUser(String accessToken, JSONObject params) {
        return WXEntAddressBookApi.post(String.format("%1$s?access_token=%2$s", UserCreateApi, accessToken), params);
    }

    public static CallResult updateUser(String accessToken, JSONObject params) {
        return WXEntAddressBookApi.post(String.format("%1$s?access_token=%2$s", UserUpdateApi, accessToken), params);
    }

    public static CallResult deleteUser(String accessToken, String userid) {
        return WXEntAddressBookApi.get(String.format("%1$s?access_token=%2$s&userid=%3$s", UserDeleteApi, accessToken, userid), null);
    }

    public static CallResult deleteUserBatch(String accessToken, JSONObject params) {
        return WXEntAddressBookApi.post(String.format("%1$s?access_token=%2$s", UserBatchDeleteApi, accessToken), params);
    }

    public static CallResult getUser(String accessToken, String userid) {
        return WXEntAddressBookApi.get(String.format("%1$s?access_token=%2$s&userid=%3$s", UserGetApi, accessToken, userid), null);
    }

    public static CallResult simpleListUser(String accessToken, int deptid, boolean fetchchild, int status) {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("access_token", accessToken);
        params.put("department_id", String.valueOf(deptid));
        params.put("fetch_child", fetchchild ? "1" : "0");
        params.put("status", String.valueOf(status));
        return WXEntAddressBookApi.get(UserSimpleListApi, params);
    }

    public static CallResult listUser(String accessToken, int deptid, boolean fetchchild, int status) {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("access_token", accessToken);
        params.put("department_id", String.valueOf(deptid));
        params.put("fetch_child", fetchchild ? "1" : "0");
        params.put("status", String.valueOf(status));
        return WXEntAddressBookApi.get(UserListApi, params);
    }

    public static CallResult listDeptEx(String accessToken, int deptid) {
        CallResult callResult = WXEntAddressBookApi.listDept(accessToken, deptid);
        if (callResult.isError()) {
            return callResult;
        }
        if (callResult.getUserObject() == null || !(callResult.getUserObject() instanceof JSONObject)) {
            callResult.setRetCode(-1);
            callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u90e8\u95e8\u4fe1\u606f");
        }
        try {
            JSONObject json = (JSONObject)callResult.getUserObject();
            JSONArray depts = json.getJSONArray("department");
            ArrayList<WXDept> list = new ArrayList<WXDept>();
            int i = 0;
            while (i < depts.length()) {
                WXDept wxDept = new WXDept(depts.getJSONObject(i));
                list.add(wxDept);
                ++i;
            }
            callResult.setUserObject(list);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            callResult.setRetCode(-1);
            callResult.setErrorInfo("\u89e3\u6790\u90e8\u95e8\u6570\u636e\u5f02\u5e38");
        }
        return callResult;
    }

    public static CallResult listUserEx(String accessToken, int deptid, boolean fetchchild, int status) {
        CallResult callResult = WXEntAddressBookApi.listUser(accessToken, deptid, fetchchild, status);
        if (callResult.isError()) {
            return callResult;
        }
        if (callResult.getUserObject() == null || !(callResult.getUserObject() instanceof JSONObject)) {
            callResult.setRetCode(-1);
            callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u7528\u6237\u4fe1\u606f");
        }
        try {
            JSONObject json = (JSONObject)callResult.getUserObject();
            JSONArray users = json.getJSONArray("userlist");
            ArrayList<WXUser> list = new ArrayList<WXUser>();
            int i = 0;
            while (i < users.length()) {
                WXUser wxUser = new WXUser(users.getJSONObject(i));
                list.add(wxUser);
                ++i;
            }
            callResult.setUserObject(list);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            callResult.setRetCode(-1);
            callResult.setErrorInfo("\u89e3\u6790\u7528\u6237\u6570\u636e\u5f02\u5e38");
        }
        return callResult;
    }
}

