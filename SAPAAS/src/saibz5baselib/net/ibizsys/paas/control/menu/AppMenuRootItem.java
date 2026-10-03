package net.ibizsys.paas.control.menu;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.paas.util.StringHelper;

/**
 * 应用菜单项根项
 * 
 * @author lionlau
 *
 */
public class AppMenuRootItem extends AppMenuItem {
	protected HashMap<String, AppMenuItem> appMenuItemMap = new HashMap<String, AppMenuItem>();

	/**
	 * 增加菜单项
	 * 
	 * @param strId 当前菜单项标识
	 * @param strPId 父菜单项标识
	 * @return
	 * @throws Exception
	 */
	public AppMenuItem addItem(String strId, String strPId) throws Exception {
		AppMenuItem appMenuItem = new AppMenuItem();
		appMenuItem.setId(strId);
		appMenuItem.setPId(strPId);
		appMenuItemMap.put(strId, appMenuItem);
		if (StringHelper.isNullOrEmpty(strPId)) {
			this.getItems().add(appMenuItem);

		} else {
			// 有父对象
			AppMenuItem parentExpBarItem = appMenuItemMap.get(strPId);
			if (parentExpBarItem == null) {
				throw new Exception(StringHelper.format("无法获取指定节点，标识为[%1$s]", strPId));
			}

			parentExpBarItem.getItems().add(appMenuItem);
		}

		return appMenuItem;
	}

	/**
	 * 获取全部子项集合
	 * 
	 * @return
	 */
	public ArrayList<IAppMenuItem> getAllItems() {
		ArrayList<IAppMenuItem> allItems = new ArrayList<IAppMenuItem>();
		for (IAppMenuItem iExpBarItem : this.getItems()) {
			allItems.add(iExpBarItem);
			fillItems(iExpBarItem, allItems);
		}
		return allItems;
	}

	/**
	 * 填充子菜单项到列表中
	 * 
	 * @param appMenuItem
	 * @param allItems
	 */
	protected void fillItems(IAppMenuItem appMenuItem, ArrayList<IAppMenuItem> allItems) {
		if (appMenuItem.getItems() == null) return;

		for (IAppMenuItem childItem : appMenuItem.getItems()) {
			if (childItem instanceof AppMenuItem) {
				((AppMenuItem) childItem).setPId(appMenuItem.getId());
			}
			allItems.add(childItem);
			fillItems(childItem, allItems);
		}
	}
}
