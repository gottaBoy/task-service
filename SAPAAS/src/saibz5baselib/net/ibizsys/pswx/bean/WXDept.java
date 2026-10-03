package net.ibizsys.pswx.bean;

import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

public class WXDept {

	private int id;
	private int parentid;
	private String name;
	private int order;

	public WXDept() {
	}

	public WXDept(JSONObject json) {
		setId(json.getInt("id"));
		setName(json.getString("name"));
		setParentid(json.getInt("parentid"));
		setOrder(json.getInt("order"));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public JSONObject toJSON() {
		JSONObject json = new JSONObject();

		json.put("id", this.getId());
		json.put("name", JSONObjectHelper.stripQuotes(this.getName(),true));
		if (this.getParentid() > 0) {
			json.put("parentid", this.getParentid());
		}
		if (this.getOrder() > 1) {
			json.put("order", this.getOrder());
		}

		return json;
	}

	public boolean isSame(WXDept comDept) {
		if (StringHelper.compare(this.getName(), comDept.getName(), true) != 0) {
			return false;
		}
		if (this.getOrder() != comDept.getOrder()) {
			return false;
		}
		if (this.getParentid() != comDept.getParentid()) {
			return false;
		}

		return true;
	}

}
