package net.ibizsys.paas.control.drctrl;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.paas.util.StringHelper;

/**
 * 数据关系部件数据项根项
 * 
 * @author lionlau
 *
 */
public class DRCtrlRootItem extends DRCtrlItem {
	protected HashMap<String, DRCtrlItem> expBarItemMap = new HashMap<String, DRCtrlItem>();
	private boolean bRootVisible = true;

	/**
	 * 增加数据项
	 * 
	 * @param strId 当前项标识
	 * @param strPId 父项标识
	 * @return
	 * @throws Exception
	 */
	public DRCtrlItem addItem(String strId, String strPId) throws Exception {
		DRCtrlItem expBarItem = new DRCtrlItem();
		expBarItem.setId(strId);
		expBarItem.setPId(strPId);
		expBarItemMap.put(strId, expBarItem);
		if (StringHelper.isNullOrEmpty(strPId)) {
			this.getItems().add(expBarItem);

		} else {
			// 有父对象
			DRCtrlItem parentExpBarItem = expBarItemMap.get(strPId);
			if (parentExpBarItem == null) {
				throw new Exception(StringHelper.format("无法获取指定节点，标识为[%1$s]", strPId));
			}

			parentExpBarItem.getItems().add(expBarItem);
		}

		return expBarItem;
	}

	/**
	 * 获取全部子项集合
	 * 
	 * @return
	 */
	public ArrayList<IDRCtrlItem> getAllItems() {
		ArrayList<IDRCtrlItem> allItems = new ArrayList<IDRCtrlItem>();
		for (IDRCtrlItem iExpBarItem : this.getItems()) {
			allItems.add(iExpBarItem);
			fillItems(iExpBarItem, allItems);
		}
		return allItems;
	}

	/**
	 * 填充子项到列表中
	 * 
	 * @param expBarItem
	 * @param allItems
	 */
	protected void fillItems(IDRCtrlItem expBarItem, ArrayList<IDRCtrlItem> allItems) {
		for (IDRCtrlItem childItem : expBarItem.getItems()) {
			if (childItem instanceof DRCtrlItem) {
				((DRCtrlItem) childItem).setPId(expBarItem.getId());
			}
			allItems.add(childItem);
			fillItems(childItem, allItems);
		}
	}

	/**
	 * 获取根是否可见
	 * 
	 * @return
	 */
	public boolean isRootVisible() {
		return bRootVisible;
	}

	/**
	 * 设置根是否可见
	 * 
	 * @param bRootVisible
	 */
	public void setRootVisible(boolean bRootVisible) {
		this.bRootVisible = bRootVisible;
	}
}
