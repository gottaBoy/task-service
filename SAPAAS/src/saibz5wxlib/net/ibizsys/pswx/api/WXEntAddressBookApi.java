package net.ibizsys.pswx.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.pswx.bean.WXDept;
import net.ibizsys.pswx.bean.WXUser;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 企业号通讯录接口
 * 
 * @author Enmaai
 */
public class WXEntAddressBookApi extends WXBaseApi {

	/**
	 * 关注企业号
	 * <p>
	 * Https请求方式: GET
	 */
	private static final String SubscribeApi = "https://qyapi.weixin.qq.com/cgi-bin/user/authsucc";

	/**
	 * 创建部门
	 * <p>
	 * Https请求方式: POST
	 */
	public static final String DeptCreateApi = "https://qyapi.weixin.qq.com/cgi-bin/department/create";
	/**
	 * 更新部门
	 * <p>
	 * Https请求方式: POST
	 */
	private static final String DeptUpdateApi = "https://qyapi.weixin.qq.com/cgi-bin/department/update";

	/**
	 * 删除部门
	 * <p>
	 * Https请求方式: GET
	 */
	private static final String DeptDeleteApi = "https://qyapi.weixin.qq.com/cgi-bin/department/delete";

	/**
	 * 获取部门列表
	 * <p>
	 * Https请求方式: GET
	 */
	private static final String DeptListApi = "https://qyapi.weixin.qq.com/cgi-bin/department/list";

	/**
	 * 创建成员
	 * <p>
	 * Https请求方式: POST
	 */
	private static final String UserCreateApi = "https://qyapi.weixin.qq.com/cgi-bin/user/create";
	/**
	 * 更新成员
	 * <p>
	 * Https请求方式: POST
	 */
	private static final String UserUpdateApi = "https://qyapi.weixin.qq.com/cgi-bin/user/update";

	/**
	 * 删除成员
	 * <p>
	 * Https请求方式: GET
	 */
	private static final String UserDeleteApi = "https://qyapi.weixin.qq.com/cgi-bin/user/delete";

	/**
	 * 批量删除成员
	 * <p>
	 * Https请求方式: POST
	 */
	private static final String UserBatchDeleteApi = "https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete";

	/**
	 * 获取成员
	 * <p>
	 * Https请求方式: GET
	 */
	private static final String UserGetApi = "https://qyapi.weixin.qq.com/cgi-bin/user/get";

	/**
	 * 获取部门成员
	 * <p>
	 * Https请求方式: GET
	 */
	private static final String UserSimpleListApi = "https://qyapi.weixin.qq.com/cgi-bin/user/simplelist";

	/**
	 * 获取部门成员(详情)
	 * <p>
	 * Https请求方式: GET
	 */
	private static final String UserListApi = "https://qyapi.weixin.qq.com/cgi-bin/user/list";

	/**
	 * 认证完成用户关注企业号
	 * 
	 * @param accessToken 企业号票据
	 * @param agentid 用户标识
	 * @return
	 */
	public static CallResult subscribe(String accessToken, String userid) {
		return get(String.format("%1$s?access_token=%2$s&userid=%3$s", SubscribeApi, accessToken, userid), null);
	}

	/**
	 * 创建部门
	 * 
	 * @param accessToken 企业号票据
	 * @param params
	 * @return
	 */
	public static CallResult createDept(String accessToken, JSONObject params) {
		return post(String.format("%1$s?access_token=%2$s", DeptCreateApi, accessToken), params);
	}

	/**
	 * 更新部门
	 * 
	 * @param accessToken 企业号票据
	 * @param params
	 * @return
	 */
	public static CallResult updateDept(String accessToken, JSONObject params) {
		return post(String.format("%1$s?access_token=%2$s", DeptUpdateApi, accessToken), params);
	}

	/**
	 * 删除部门
	 * 
	 * @param accessToken 企业号票据
	 * @param deptid 部门id。（注：不能删除根部门；不能删除含有子部门、成员的部门）
	 * @return
	 */
	public static CallResult deleteDept(String accessToken, int deptid) {
		return get(String.format("%1$s?access_token=%2$s&id=%3$s", DeptDeleteApi, accessToken, deptid), null);
	}

	/**
	 * 删除部门
	 * <p>
	 * 未实现
	 * 
	 * @param accessToken 企业号票据
	 * @param deptid 部门id。（注：不能删除根部门；不能删除含有子部门、成员的部门）
	 * @param cascade级联删除
	 * @return
	 */
	public static CallResult deleteDept(String accessToken, int deptid, boolean cascade) {
		if (!cascade) {
			return deleteDept(accessToken, deptid);
		} else {
			return get(String.format("%1$s?access_token=%2$s&id=%3$s", DeptDeleteApi, accessToken, deptid), null);
		}
	}

	/**
	 * 获取部门列表
	 * 
	 * @param accessToken 企业号票据
	 * @param deptid 部门id。获取指定部门及其下的子部门
	 * @return
	 */
	public static CallResult listDept(String accessToken, int deptid) {
		return get(String.format("%1$s?access_token=%2$s&id=%3$s", DeptListApi, accessToken, deptid), null);
	}

	/**
	 * 创建成员
	 * 
	 * @param accessToken 企业号票据
	 * @param params
	 * @return
	 */
	public static CallResult createUser(String accessToken, JSONObject params) {
		return post(String.format("%1$s?access_token=%2$s", UserCreateApi, accessToken), params);
	}

	/**
	 * 更新成员
	 * 
	 * @param accessToken 企业号票据
	 * @param params
	 * @return
	 */
	public static CallResult updateUser(String accessToken, JSONObject params) {
		return post(String.format("%1$s?access_token=%2$s", UserUpdateApi, accessToken), params);
	}

	/**
	 * 删除成员
	 * 
	 * @param accessToken 企业号票据
	 * @param params
	 * @return
	 */
	public static CallResult deleteUser(String accessToken, String userid) {
		return get(String.format("%1$s?access_token=%2$s&userid=%3$s", UserDeleteApi, accessToken, userid), null);
	}

	/**
	 * 批量删除成员
	 * 
	 * @param accessToken 企业号票据
	 * @param userList 例如["zhangsan", "lisi"]
	 * @return
	 */
	public static CallResult deleteUserBatch(String accessToken, JSONObject params) {
		return post(String.format("%1$s?access_token=%2$s", UserBatchDeleteApi, accessToken), params);
	}

	/**
	 * 获取成员
	 * 
	 * @param accessToken 企业号票据
	 * @param userid 用户标识
	 * @return
	 */
	public static CallResult getUser(String accessToken, String userid) {
		return get(String.format("%1$s?access_token=%2$s&userid=%3$s", UserGetApi, accessToken, userid), null);
	}

	/**
	 * 获取部门成员
	 * 
	 * @param accessToken 企业号票据
	 * @param deptid 部门标识
	 * @param fetchchild 是否递归获取子部门下面的成员
	 * @param status 0获取全部成员，1获取已关注成员列表，2获取禁用成员列表，4获取未关注成员列表。status可叠加，未填写则默认为4
	 * @return
	 */
	public static CallResult simpleListUser(String accessToken, int deptid, boolean fetchchild, int status) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		params.put("department_id", deptid + "");
		params.put("fetch_child", fetchchild ? "1" : "0");
		params.put("status", status + "");

		return get(UserSimpleListApi, params);
	}

	/**
	 * 获取部门成员(详情)
	 * 
	 * @param accessToken 企业号票据
	 * @param deptid 部门标识
	 * @param fetchchild 是否递归获取子部门下面的成员
	 * @param status 0获取全部成员，1获取已关注成员列表，2获取禁用成员列表，4获取未关注成员列表。status可叠加，未填写则默认为4
	 * @return
	 */
	public static CallResult listUser(String accessToken, int deptid, boolean fetchchild, int status) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		params.put("department_id", deptid + "");
		params.put("fetch_child", fetchchild ? "1" : "0");
		params.put("status", status + "");

		return get(UserListApi, params);
	}

	/**
	 * 获取部门列表
	 * 
	 * @param accessToken 企业号票据
	 * @param deptid 部门id。获取指定部门及其下的子部门
	 * @return 返回WXDept对象集合
	 */
	public static CallResult listDeptEx(String accessToken, int deptid) {
		CallResult callResult = listDept(accessToken, deptid);

		if (callResult.isError()) {
			return callResult;
		}

		if (callResult.getUserObject() == null || !(callResult.getUserObject() instanceof JSONObject)) {
			callResult.setRetCode(-1);
			callResult.setErrorInfo("无法获取部门信息");
		}

		try {
			JSONObject json = (JSONObject) callResult.getUserObject();
			JSONArray depts = json.getJSONArray("department");

			List<WXDept> list = new ArrayList<WXDept>();

			for (int i = 0; i < depts.length(); i++) {
				WXDept wxDept = new WXDept(depts.getJSONObject(i));

				list.add(wxDept);
			}
			callResult.setUserObject(list);
		} catch (Exception ex) {
			ex.printStackTrace();
			callResult.setRetCode(-1);
			callResult.setErrorInfo("解析部门数据异常");
		}

		return callResult;
	}

	/**
	 * 获取部门成员(详情)
	 * 
	 * @param accessToken 企业号票据
	 * @param deptid 部门标识
	 * @param fetchchild 是否递归获取子部门下面的成员
	 * @param status 0获取全部成员，1获取已关注成员列表，2获取禁用成员列表，4获取未关注成员列表。status可叠加，未填写则默认为4
	 * @return
	 */
	public static CallResult listUserEx(String accessToken, int deptid, boolean fetchchild, int status) {
		CallResult callResult = listUser(accessToken, deptid, fetchchild, status);

		if (callResult.isError()) {
			return callResult;
		}

		if (callResult.getUserObject() == null || !(callResult.getUserObject() instanceof JSONObject)) {
			callResult.setRetCode(-1);
			callResult.setErrorInfo("无法获取用户信息");
		}

		try {
			JSONObject json = (JSONObject) callResult.getUserObject();
			JSONArray users = json.getJSONArray("userlist");

			List<WXUser> list = new ArrayList<WXUser>();

			for (int i = 0; i < users.length(); i++) {
				WXUser wxUser = new WXUser(users.getJSONObject(i));

				list.add(wxUser);
			}
			callResult.setUserObject(list);
		} catch (Exception ex) {
			ex.printStackTrace();
			callResult.setRetCode(-1);
			callResult.setErrorInfo("解析用户数据异常");
		}

		return callResult;
	}
}
