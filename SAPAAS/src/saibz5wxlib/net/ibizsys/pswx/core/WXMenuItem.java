package net.ibizsys.pswx.core;

import java.util.ArrayList;

import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 微信菜单项实现对象
 * 
 * @author Administrator
 * 
 */
public class WXMenuItem implements IWXMenuItem {

	/**
	 * 菜单项标识
	 */
	public final static String WXMENUITEM_ID = "id";

	/**
	 * 父菜单项标识
	 */
	public final static String WXMENUITEM_PID = "pid";

	/**
	 * 显示文本
	 */
	public final static String WXMENUITEM_TEXT = "text";

	private String strId = "";
	private String strText = "";
	private String strPId = "";
	private String strWXFunc = "";
	private String strClickTag = "";
	private ArrayList<IWXMenuItem> items = new ArrayList<IWXMenuItem>();

	@Override
	public String getId() {
		return strId;
	}

	@Override
	public String getText() {
		return this.strText;
	}

	@Override
	public String getPId() {
		return this.strPId;
	}

	/**
	 * 设置标识
	 * 
	 * @param strId
	 */
	public void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置文本
	 * 
	 * @param strText
	 */
	public void setText(String strText) {
		this.strText = strText;
	}

	/**
	 * 设置父菜单项标识
	 * 
	 * @param strPId
	 */
	public void setPId(String strPId) {
		this.strPId = strPId;
	}

	/**
	 * 获取应用功能编号
	 * 
	 * @return
	 */
	@Override
	public String getWXFunc() {
		return this.strWXFunc;
	}

	/**
	 * 设置应用功能编号
	 * 
	 * @param strWXFunc
	 */
	public void setWXFunc(String strWXFunc) {
		this.strWXFunc = strWXFunc;
	}

	@Override
	public ArrayList<IWXMenuItem> getItems() {
		return items;
	}

	@Override
	public String getClickTag() {
		return strClickTag;
	}

	/**
	 * 设置菜单点击标识
	 * 
	 * @param strClickTag
	 */
	public void setClickTag(String strClickTag) {
		this.strClickTag = strClickTag;
	}

	@Override
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();

		json.put("name", JSONObjectHelper.stripQuotes(this.getText(),true));

		if (this.items.size() <= 0) {
			json.put("type", this.getWXFunc());

			if (StringHelper.isNullOrEmpty(this.getClickTag())) {
				json.put("key", this.getId());
			} else {
				json.put("key", this.getClickTag());
			}
		}
		JSONArray array = new JSONArray();

		for (IWXMenuItem item : this.items) {
			array.put(item.toJSON());
		}

		json.put("sub_button", array);

		return json;
	}
}
