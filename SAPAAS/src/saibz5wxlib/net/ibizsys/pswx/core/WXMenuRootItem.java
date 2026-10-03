package net.ibizsys.pswx.core;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 微信菜单根项
 * 
 * @author lionlau
 * 
 */
public class WXMenuRootItem extends WXMenuItem {
	protected HashMap<String, WXMenuItem> wxMenuItemMap = new HashMap<String, WXMenuItem>();

	/**
	 * 增加菜单项
	 * 
	 * @param strId 当前菜单项标识
	 * @param strPId 父菜单项标识
	 * @return
	 * @throws Exception
	 */
	public WXMenuItem addItem(String strId, String strPId) throws Exception {

		WXMenuItem wxMenuItem = new WXMenuItem();
		wxMenuItem.setId(strId);
		wxMenuItem.setPId(strPId);
		wxMenuItemMap.put(strId, wxMenuItem);
		if (StringHelper.isNullOrEmpty(strPId)) {
			this.getItems().add(wxMenuItem);

		} else {
			WXMenuItem parentExpBarItem = wxMenuItemMap.get(strPId);
			if (parentExpBarItem == null) {
				throw new Exception(StringHelper.format("无法获取指定节点，标识为[%1$s]", strPId));
			}

			parentExpBarItem.getItems().add(wxMenuItem);
		}

		return wxMenuItem;
	}

	/**
	 * 获取全部子项集合
	 * 
	 * @return
	 */
	public ArrayList<IWXMenuItem> getAllItems() {
		ArrayList<IWXMenuItem> allItems = new ArrayList<IWXMenuItem>();
		for (IWXMenuItem iExpBarItem : this.getItems()) {
			allItems.add(iExpBarItem);
			fillItems(iExpBarItem, allItems);
		}
		return allItems;
	}

	/**
	 * 填充子菜单项到列表中
	 * 
	 * @param wxMenuItem
	 * @param allItems
	 */
	protected void fillItems(IWXMenuItem wxMenuItem, ArrayList<IWXMenuItem> allItems) {
		if (wxMenuItem.getItems() == null) return;

		for (IWXMenuItem childItem : wxMenuItem.getItems()) {
			if (childItem instanceof WXMenuItem) {
				((WXMenuItem) childItem).setPId(wxMenuItem.getId());
			}
			allItems.add(childItem);
			fillItems(childItem, allItems);
		}
	}

	@Override
	public JSONObject toJSON() {
		JSONArray array = new JSONArray();
		for (IWXMenuItem item : this.wxMenuItemMap.values()) {

			if (StringHelper.isNullOrEmpty(item.getPId())) {
				array.put(item.toJSON());
			}
		}
		JSONObject json = new JSONObject();
		json.put("button", array);

		return json;
	}
}
