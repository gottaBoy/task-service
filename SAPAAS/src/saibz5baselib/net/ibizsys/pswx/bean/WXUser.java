package net.ibizsys.pswx.bean;

import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WXUser {

	private String userid = "";
	private String name = "";
	private int department;
	private String mobile = "";
	private String email = "";
	private int enable = 1;
	private int order = 1;

	public WXUser() {
	}

	public WXUser(JSONObject json) {
		this.userid = json.getString("userid");
		this.name = json.getString("name");

		JSONArray depts = json.getJSONArray("department");

		if (depts.length() > 0) {
			this.department = depts.getInt(0);
		}
		if (json.has("mobile")) {
			this.mobile = json.getString("mobile");
		}
		if (json.has("email")) {
			this.email = json.getString("email");
		}
		if (json.has("enable")) {
			this.enable = json.getInt("enable");
		}
		if (json.has("order")) {
			JSONArray orders = json.getJSONArray("order");
			if (orders.length() > 0) {
				this.order = orders.getInt(0);
			}
		}
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null) {
			this.name = "";
		} else {
			this.name = name;
		}
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		if (mobile == null) {
			this.mobile = "";
		} else {
			this.mobile = mobile;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email == null) {
			this.email = "";
		} else {
			this.email = email;
		}
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public JSONObject toJSON() {
		JSONObject json = new JSONObject();

		json.put("userid", this.userid);
		json.put("name", this.name);

		JSONArray depts = new JSONArray();
		depts.put(this.department);

		json.put("department", depts);
		json.put("mobile", this.mobile);
		json.put("email", this.email);
		json.put("enable", this.enable);

		if (this.getOrder() > 1) {
			JSONArray orders = new JSONArray();
			orders.put(this.getOrder());

			json.put("order", orders);
		}

		return json;
	}

	public boolean isSame(WXUser comDept) {

		if (StringHelper.compare(this.getName(), comDept.getName(), true) != 0) {
			return false;
		}
		if (this.getDepartment() != comDept.getDepartment()) {
			return false;
		}
		if (StringHelper.compare(this.getMobile(), comDept.getMobile(), true) != 0) {
			return false;
		}
		if (StringHelper.compare(this.getEmail(), comDept.getEmail(), true) != 0) {
			return false;
		}
		if (this.getEnable() != comDept.getEnable()) {
			return false;
		}
		if (this.getOrder() != comDept.getOrder()) {
			return false;
		}
		return true;
	}

}
