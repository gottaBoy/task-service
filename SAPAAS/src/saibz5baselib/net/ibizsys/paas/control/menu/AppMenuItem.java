package net.ibizsys.paas.control.menu;

import java.util.ArrayList;

import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

/**
 * 应用菜单项
 * 
 * @author Administrator
 *
 */
public class AppMenuItem extends MenuItem implements IAppMenuItem {
	/**
	 * 应用功能标识
	 */
	public final static String APPMENUITEM_APPFUNCID = "appfuncid";

	/**
	 * 隐藏边栏
	 */
	public final static String APPMENUITEM_HIDESIDEBAR = "hidesidebar";

	/**
	 * 默认打开
	 */
	public final static String APPMENUITEM_OPENDEFAULT = "opendefault";
	
	/**
	 * 是否隐藏
	 */
	public final static String APPMENUITEM_HIDDEN = "hidden";
	
	/**
	 * 应用菜单项状态
	 */
	public final static String APPMENUITEM_STATE = "state";
	 
	

	private ArrayList<IAppMenuItem> items = new ArrayList<IAppMenuItem>();

	private String strAppFuncId = null;

	private boolean bSeperator = false;

	private boolean bHideSideBar = false;

	private boolean bOpenDefault = false;

	private String strCounterId = null;
	
	private int nAppMenuItemState = 0;

	/**
	 * 获取应用功能编号
	 * 
	 * @return
	 */
	@Override
	public String getAppFuncId() {
		return this.strAppFuncId;
	}

	/**
	 * 设置应用功能编号
	 * 
	 * @param strAppFuncId
	 */
	public void setAppFuncId(String strAppFuncId) {
		this.strAppFuncId = strAppFuncId;
	}

	@Override
	public ArrayList<IAppMenuItem> getItems() {
		return items;
	}

	/**
	 * 导出到JSON对象
	 * 
	 * @param iAppMenuItem
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(IAppMenuItem iAppMenuItem, JSONObject jsonObject) throws Exception {
		if (WebContext.getCurrent() != null) {
			String strPersonId = WebContext.getCurrent().getCurUserId();
			if (!StringHelper.isNullOrEmpty(strPersonId)) {
				if ((iAppMenuItem.getAccUserMode() & AccessUserModes.LOGINUSERWITHKEY) > 0) {
					if (!WebContext.getCurrent().getUserPrivilegeMgr().test(WebContext.getCurrent(), iAppMenuItem.getAccessKey())) return null;
				}
			}
		}

		jsonObject = MenuItem.toJSONObject(iAppMenuItem, jsonObject);
		if (!StringHelper.isNullOrEmpty(iAppMenuItem.getAppFuncId())) {
			jsonObject.put(APPMENUITEM_APPFUNCID,JSONObjectHelper.stripQuotes(iAppMenuItem.getAppFuncId(),true));
		}
		if (iAppMenuItem.isHideSideBar()) {
			jsonObject.put(APPMENUITEM_HIDESIDEBAR, iAppMenuItem.isHideSideBar());
		}
		if (iAppMenuItem.isOpenDefault()) {
			jsonObject.put(APPMENUITEM_OPENDEFAULT, iAppMenuItem.isOpenDefault());
		}
		if (iAppMenuItem.isHidden()) {
			jsonObject.put(APPMENUITEM_HIDDEN, iAppMenuItem.isHidden());
		}
		if(iAppMenuItem.getAppMenuItemState()>0)
			jsonObject.put(APPMENUITEM_STATE, iAppMenuItem.getAppMenuItemState());
		if (iAppMenuItem.getItems().size() == 0) {
			jsonObject.put(MENUITEM_LEAF, true);
		} else {
			ArrayList<JSONObject> items = new ArrayList<JSONObject>();
			for (IAppMenuItem childExpBarItem : iAppMenuItem.getItems()) {
				if(childExpBarItem.getFiller()!=null){
					ArrayList<JSONObject> list = childExpBarItem.getFiller().toJSONObjects(childExpBarItem);
					if(list!=null){
						items.addAll(list);
					}
				}
				else{
					JSONObject jsonItem = AppMenuItem.toJSONObject(childExpBarItem, null);
					if (jsonItem == null) continue;
					items.add(jsonItem);
				}
			}
			if (items.size() == 0) {
				jsonObject.put(MENUITEM_LEAF, true);
			} else
				jsonObject.put(MENUITEM_ITEMS, items.toArray());
		}
		return jsonObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.menu.IAppMenuItem#isSeperator()
	 */
	@Override
	public boolean isSeperator() {
		return bSeperator;
	}

	/**
	 * 设置是否为分割项
	 * 
	 * @param bSeperator
	 */
	public void setSeperator(boolean bSeperator) {
		this.bSeperator = bSeperator;
	}

	/**
	 * 获取点击时是否隐藏边栏
	 * 
	 * @return the bHideSideBar
	 */
	public boolean isHideSideBar() {
		return bHideSideBar;
	}

	/**
	 * 设置点击时是否隐藏边栏
	 * 
	 * @param bHideSideBar
	 */
	public void setHideSideBar(boolean bHideSideBar) {
		this.bHideSideBar = bHideSideBar;
	}

	/**
	 * 获取是否默认打开
	 * 
	 * @return the bOpenDefault
	 */
	public boolean isOpenDefault() {
		return bOpenDefault;
	}

	/**
	 * 设置是否默认打开
	 * 
	 * @param bOpenDefault
	 */
	public void setOpenDefault(boolean bOpenDefault) {
		this.bOpenDefault = bOpenDefault;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.menu.MenuItem#getCounterId()
	 */
	public String getCounterId() {
		return strCounterId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.menu.MenuItem#setCounterId(java.lang.String)
	 */
	public void setCounterId(String strCounterId) {
		this.strCounterId = strCounterId;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.control.menu.IAppMenuItem#getAppMenuItemState()
	 */
	@Override
	public int getAppMenuItemState() {
		return nAppMenuItemState;
	}
	
	
	/**
	 * 设置应用菜单项状态
	 * @param nAppMenuItemState
	 */
	public void setAppMenuItemState(int nAppMenuItemState){
		this.nAppMenuItemState = nAppMenuItemState;
	}

	
	
	
}
