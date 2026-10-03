package net.ibizsys.paas.control.expbar;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.paas.util.StringHelper;

/**
 * 导航栏数据项根项
 * 
 * @author lionlau
 *
 */
public class ExpBarRootItem extends ExpBarItem {
	protected HashMap<String, ExpBarItem> expBarItemMap = new HashMap<String, ExpBarItem>();

	/**
	 * 添加导航项
	 * 
	 * @param strId 当前项标识
	 * @param strPId 父项标识
	 * @return
	 * @throws Exception
	 */
	public ExpBarItem addItem(String strId, String strPId) throws Exception {
		ExpBarItem expBarItem = new ExpBarItem();
		expBarItem.setId(strId);
		expBarItem.setPId(strPId);
		expBarItemMap.put(strId, expBarItem);
		if (StringHelper.isNullOrEmpty(strPId)) {
			this.getItems().add(expBarItem);

		} else {
			// 有父对象
			ExpBarItem parentExpBarItem = expBarItemMap.get(strPId);
			if (parentExpBarItem == null) {
				throw new Exception(StringHelper.format("无法获取指定节点，标识为[%1$s]", strPId));
			}

			parentExpBarItem.getItems().add(expBarItem);
		}

		return expBarItem;
	}
	
	/**
	 * 获取指定导航栏项
	 * @param strId
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	public ExpBarItem getItem(String strId,boolean bTryMode) throws Exception {

		ExpBarItem expBarItem = expBarItemMap.get(strId);
		if (expBarItem == null && !bTryMode) {
			throw new Exception(StringHelper.format("无法获取指定节点，标识为[%1$s]", strId));
		}
		return expBarItem;
	}
	

	/**
	 * 获取全部子项集合
	 * 
	 * @return
	 */
	public ArrayList<IExpBarItem> getAllItems() {
		ArrayList<IExpBarItem> allItems = new ArrayList<IExpBarItem>();
		for (IExpBarItem iExpBarItem : this.getItems()) {
			allItems.add(iExpBarItem);
			fillItems(iExpBarItem, allItems);
		}
		return allItems;
	}

	/**
	 * @param expBarItem
	 * @param allItems
	 */
	protected void fillItems(IExpBarItem expBarItem, ArrayList<IExpBarItem> allItems) {
		for (IExpBarItem childItem : expBarItem.getItems()) {
			if (childItem instanceof ExpBarItem) {
				((ExpBarItem) childItem).setPId(expBarItem.getId());
			}
			allItems.add(childItem);
			fillItems(childItem, allItems);
		}
	}
}
