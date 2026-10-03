package net.ibizsys.pswx.core;

import java.util.Iterator;

import net.ibizsys.paas.core.ModelBaseImpl;
import net.sf.json.JSONObject;

/**
 * 应用菜单模型基类
 * 
 * @author lionlau
 * 
 */
public class WXMenuModel extends ModelBaseImpl implements IWXMenuModel {

	private WXMenuRootItem wxMenuRootItem = new WXMenuRootItem();
	private IWXAccountModel iWXAccountModel = null;
	private IWXEntAppModel iWXEntAppModel = null;

	/**
	 * 初始化
	 * 
	 * @param iWXAccountModel
	 * @param iWXEntAppModel
	 * @throws Exception
	 */
	public void init(IWXAccountModel iWXAccountModel, IWXEntAppModel iWXEntAppModel) throws Exception {
		this.iWXAccountModel = iWXAccountModel;
		this.iWXEntAppModel = iWXEntAppModel;
		this.onInit();
	}

	/**
	 * 设置菜单标识
	 * 
	 * @param strId
	 */
	public void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置菜单名称
	 * 
	 * @param strId
	 */
	public void setName(String strName) {
		this.strName = strName;
	}

	/**
	 * 获取菜单根节点
	 * 
	 * @return
	 */
	public WXMenuRootItem getRootItem() {
		return this.wxMenuRootItem;
	}

	@Override
	public Iterator<IWXMenuItem> getWXMenuItems() {
		return getRootItem().getItems().iterator();
	}

	@Override
	public IWXAccount getWXAccount() {
		return this.getWXAccountModel();
	}

	@Override
	public IWXEntApp getWXEntApp() {
		return this.getWXEntAppModel();
	}

	@Override
	public IWXAccountModel getWXAccountModel() {
		return this.iWXAccountModel;
	}

	@Override
	public IWXEntAppModel getWXEntAppModel() {
		return this.iWXEntAppModel;
	}

	@Override
	public JSONObject toJSON() {
		return this.wxMenuRootItem.toJSON();
	}

}
