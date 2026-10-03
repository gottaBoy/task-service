package net.ibizsys.paas.sysmodel.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.paas.control.IControlCustomizable;
import net.ibizsys.paas.control.menu.AppMenuItem;
import net.ibizsys.paas.control.menu.AppMenuRootItem;
import net.ibizsys.paas.control.menu.IAppMenu;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.ctrlmodel.AppMenuModelGlobal;
import net.ibizsys.paas.ctrlmodel.IAppMenuModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.SystemUtilBase;
import net.ibizsys.paas.util.StringHelper;

/**
 * 系统应用功能组件基类
 * @author Administrator
 *
 */
public abstract class AppCustomizeUtilBase extends SystemUtilBase implements IAppCustomizeUtil {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(AppCustomizeUtilBase.class);
	public final static String DE_APPMENU = "APPMENUDENAME";
	public final static String DE_APPMENUITEM = "APPMENUITEMDENAME";
	public final static String DEF_LOCKFLAG = "LOCKFLAG";
	public final static String DEF_VALIDFLAG = "VALIDFLAG";
	public final static String DEF_ORDERVALUE = "ORDERVALUE";
	public final static String DEF_APPFUNCID = "APPFUNCID";
	public final static String DEF_ITEMTYPE = "ITEMTYPE";
	public final static String DEF_EXPANDEDFLAG = "EXPANDEDFLAG";
	public final static String DEF_SEPERATORFLAG = "SEPERATORFLAG";
	public final static String DEF_HIDESIDEBARFLAG = "HIDESIDEBARFLAG";
	public final static String DEF_OPENDEFAULTFLAG = "OPENDEFAULTFLAG";
	public final static String DEF_ICONCLS = "ICONCLS";
	public final static String DEF_ICONPATH = "ICONPATH";
	public final static String DEF_TEXTCLS = "TEXTCLS";
	public final static String DEF_ACCUSERMODE = "ACCUSERMODE";
	public final static String DEF_ACCESSKEY = "ACCESSKEY";
	public final static String DEF_TEXT = "TEXT";
	public final static String DEF_COUNTERID = "COUNTERID";
	
	private HashMap<String,AppMenuRootItem> appMenuRootItemMap = new HashMap<String,AppMenuRootItem>();
	
	public AppCustomizeUtilBase() {
		this.setUtilType(IAppCustomizeUtil.UTILTYPE_APPCUSTOMIZE);
	}
	
	
	@Override
	public Iterator<IAppMenuItem> getAppMenuItems(IAppMenu iAppMenu) throws Exception {
		AppMenuRootItem appMenuRootItem = this.getAppMenuRootItem(iAppMenu);
		if(appMenuRootItem!=null) {
			return appMenuRootItem.getItems().iterator();
		}
		return iAppMenu.getAppMenuItems();
	}
	
	
	
	@Override
	public void installAll() throws Exception {
		installAllAppMenus();
	}


	@Override
	public void installAllAppMenus() throws Exception {
		java.util.Iterator<IAppMenuModel> appMenuModels = AppMenuModelGlobal.getAllAppMenuModels();
		if(appMenuModels!=null) {
			HashMap<String, String> appMenuModelMap = new HashMap<String, String>();
			while(appMenuModels.hasNext()) {
				IAppMenuModel iAppMenuModel = appMenuModels.next();
				if(iAppMenuModel instanceof IControlCustomizable) {
					if(((IControlCustomizable)iAppMenuModel).isEnableCustomize()) {
						if(!appMenuModelMap.containsKey(iAppMenuModel.getId())) {
							appMenuModelMap.put(iAppMenuModel.getId(), "");
						}
						installAppMenu(iAppMenuModel);
					}
				}
			}
		}
	}
	
	@Override
	public void installAppMenu(IAppMenu iAppMenu) throws Exception {
		if(iAppMenu instanceof IControlCustomizable) {
			if(!((IControlCustomizable)iAppMenu).isEnableCustomize()) {
				throw new Exception(StringHelper.format("应用菜单[%1$s]不支持自定义",iAppMenu.getName()));
			}
		}
		else {
			throw new Exception(StringHelper.format("应用菜单[%1$s]不支持自定义",iAppMenu.getName()));
		}
		
		if(StringHelper.isNullOrEmpty(getAppMenuDEName())||StringHelper.isNullOrEmpty(getAppMenuItemDEName())) {
			throw new Exception("没有指定应用菜单存储实体");
		}
		
		
		IService appMenuService = DEModelGlobal.getDEModel(getAppMenuDEName()).getService();
		IService appMenuItemService = DEModelGlobal.getDEModel(getAppMenuItemDEName()).getService();
		
		IEntity appMenu = appMenuService.getDEModel().createEntity();
		appMenu.set(appMenuService.getDEModel().getKeyDEField().getName(),iAppMenu.getId());
		//判断数据是否存在
		boolean bCreate = true;
		if(appMenuService.get(appMenu, true)) {
			//判断是否加锁
			if(DataObject.getIntegerValue(appMenu.get(DEF_LOCKFLAG),0)==1)
				return;
			bCreate = false;
		}
		appMenu.reset();
		appMenu.set(appMenuService.getDEModel().getKeyDEField().getName(),iAppMenu.getId());
		if(bCreate && appMenuService.getDEModel().getMajorDEField()!=null) {
			appMenu.set(appMenuService.getDEModel().getMajorDEField().getName(),iAppMenu.getName());
		}
		try {
			if(bCreate) {
				appMenuService.create(appMenu);
			}
			else {
				appMenuService.update(appMenu);
			}
		}
		catch(Exception ex) {
			throw new Exception(StringHelper.format("保存应用菜单[%1$s]配置数据发生异常，%2$s",iAppMenu.getName(),ex.getMessage()),ex);
		}
		
		//循环菜单项
		java.util.Iterator<IAppMenuItem> appMenuItems = iAppMenu.getAppMenuItems();
		if(appMenuItems!=null) {
			int nOrderValue = 100;
			while(appMenuItems.hasNext()) {
				IAppMenuItem iAppMenuItem = appMenuItems.next();
				saveAppMenuItem(iAppMenuItem,nOrderValue,iAppMenu,appMenu,appMenuItemService,appMenuService);
				nOrderValue ++;
			}
		}

	}
	
	protected IEntity saveAppMenuItem(IAppMenuItem iAppMenuItem,int nOrderValue,IAppMenu iAppMenu,IEntity appMenu,IService appMenuItemService,IService appMenuService)throws Exception{
		IEntity appMenuItem = appMenuItemService.getDEModel().createEntity();
		appMenuItem.set(appMenuItemService.getDEModel().getKeyDEField().getName(), iAppMenuItem.getId());
		boolean bCreate = true;
		if(appMenuItemService.get(appMenuItem, true)) {
			//判断是否加锁
			if(DataObject.getIntegerValue(appMenu.get(DEF_LOCKFLAG),0)==1)
				return appMenuItem;
			bCreate = false;
		}
		
		appMenuItem.reset();
		appMenuItem.set(appMenuItemService.getDEModel().getKeyDEField().getName(),iAppMenuItem.getId());
		appMenuItem.set(appMenuItemService.getDEModel().getMajorDEField().getName(),iAppMenuItem.getText());
		appMenuItem.set("P"+appMenuItemService.getDEModel().getKeyDEField().getName(),iAppMenuItem.getPId());
		appMenuItem.set(appMenuService.getDEModel().getKeyDEField().getName(),appMenu.get(appMenuService.getDEModel().getKeyDEField().getName()));
		appMenuItem.set(DEF_TEXT,iAppMenuItem.getText());
		appMenuItem.set(DEF_ORDERVALUE, nOrderValue);
		appMenuItem.set(DEF_APPFUNCID, iAppMenuItem.getAppFuncId());
		appMenuItem.set(DEF_ITEMTYPE, iAppMenuItem.getItemType());
		appMenuItem.set(DEF_EXPANDEDFLAG, iAppMenuItem.isExpanded()?1:0);
		appMenuItem.set(DEF_SEPERATORFLAG, iAppMenuItem.isSeperator()?1:0);
		appMenuItem.set(DEF_HIDESIDEBARFLAG, iAppMenuItem.isHideSideBar()?1:0);
		appMenuItem.set(DEF_OPENDEFAULTFLAG, iAppMenuItem.isOpenDefault()?1:0);
		appMenuItem.set(DEF_ICONCLS, iAppMenuItem.getIconCls());
		appMenuItem.set(DEF_ICONPATH, iAppMenuItem.getIconPath());
		appMenuItem.set(DEF_TEXTCLS, iAppMenuItem.getTextCls());
		appMenuItem.set(DEF_ACCUSERMODE, iAppMenuItem.getAccUserMode());
		appMenuItem.set(DEF_ACCESSKEY, iAppMenuItem.getAccessKey());
		appMenuItem.set(DEF_COUNTERID, iAppMenuItem.getCounterId());
		

		try {
			if(bCreate) {
				appMenuItemService.create(appMenuItem);
			}
			else {
				appMenuItemService.update(appMenuItem);
			}
		}
		catch(Exception ex) {
			throw new Exception(StringHelper.format("保存应用菜单项[%1$s][%2$s]配置数据发生异常，%3$s",iAppMenu.getName(),iAppMenuItem.getText(),ex.getMessage()),ex);
		}
		
		//循环菜单项
		java.util.ArrayList<IAppMenuItem> appMenuItemList = iAppMenuItem.getItems();
		if(appMenuItemList!=null) {
			int nOrderValue2 = 100;
			for(IAppMenuItem childAppMenuItem:appMenuItemList) {
				saveAppMenuItem(childAppMenuItem,nOrderValue2,iAppMenu,appMenu,appMenuItemService,appMenuService);
				nOrderValue2 ++;
			}
		}
		
		return appMenuItem;
	}
	
	
	
	/**
	 * 获取存储应用菜单实体名称
	 * @return
	 */
	protected String getAppMenuDEName() {
		return this.getUtilParam("APPMENUDENAME", "");
	}

	/**
	 * 获取存储应用菜单项实体名称
	 * @return
	 */
	protected String getAppMenuItemDEName() {
		return this.getUtilParam("APPMENUITEMDENAME", "");
	}
	
	@Override
	public void resetCache() throws Exception {
		this.appMenuRootItemMap.clear();
	}
	
	
	protected AppMenuRootItem getAppMenuRootItem(IAppMenu iAppMenu)throws Exception{
		AppMenuRootItem appMenuRootItem = appMenuRootItemMap.get(iAppMenu.getId());
		if(appMenuRootItem!=null) {
			return appMenuRootItem;
		}
		
		IService appMenuService = DEModelGlobal.getDEModel(getAppMenuDEName()).getService();
		IService appMenuItemService = DEModelGlobal.getDEModel(getAppMenuItemDEName()).getService();
		
		SelectCond selectCond = new SelectCond();
		selectCond.set(appMenuService.getDEModel().getKeyDEField().getName(), iAppMenu.getId());
		selectCond.setOrderInfo("ORDER BY ORDERVALUE");
		ArrayList<IEntity> list = appMenuItemService.select(selectCond);
		ArrayList<IEntity> list2 = new ArrayList<IEntity>();
		String DEF_IDNAME = appMenuItemService.getDEModel().getKeyDEField().getName();
		String DEF_PIDNAME ="P"+DEF_IDNAME;
		HashMap<String, Boolean> appMenuItemMap = new  HashMap<String, Boolean>();
		appMenuRootItem = new AppMenuRootItem();
		while(list.size()>0) {
			list2.clear();
			for(IEntity iEntity:list){
				String strId = DataObject.getStringValue(iEntity.get(DEF_IDNAME), "");
				String strPId = DataObject.getStringValue(iEntity.get(DEF_PIDNAME), "");
				if(!StringHelper.isNullOrEmpty(strPId)) {
					if(!appMenuItemMap.containsKey(strPId)) {
						list2.add(iEntity);
						continue;
					}
					else {
						if(!appMenuItemMap.get(strPId)) {
							appMenuItemMap.put(strId, false);
							continue;
						}
					}
				}
				
				boolean bValidFlag = DataObject.getBoolValue(iEntity.get(DEF_VALIDFLAG),true);
				appMenuItemMap.put(strId, bValidFlag);
				if(!bValidFlag) {
					continue;
				}
				
				AppMenuItem appMenuItem = appMenuRootItem.addItem(strId, strPId);
				appMenuItem.setAppFuncId(DataObject.getStringValue(iEntity.get(DEF_APPFUNCID)));
				appMenuItem.setItemType(DataObject.getStringValue(iEntity.get(DEF_ITEMTYPE)));
				appMenuItem.setText(DataObject.getStringValue(iEntity.get(DEF_TEXT)));
				appMenuItem.setExpanded(DataObject.getBoolValue(iEntity, DEF_EXPANDEDFLAG,false));
				appMenuItem.setSeperator(DataObject.getBoolValue(iEntity, DEF_SEPERATORFLAG,false));
				appMenuItem.setHideSideBar(DataObject.getBoolValue(iEntity, DEF_HIDESIDEBARFLAG,false));
				appMenuItem.setOpenDefault(DataObject.getBoolValue(iEntity, DEF_OPENDEFAULTFLAG,false));
				appMenuItem.setIconCls(DataObject.getStringValue(iEntity, DEF_ICONCLS,""));
				appMenuItem.setIconPath(DataObject.getStringValue(iEntity, DEF_ICONPATH,""));
				appMenuItem.setTextCls(DataObject.getStringValue(iEntity, DEF_TEXTCLS,""));
				appMenuItem.setAccUserMode(DataObject.getIntegerValue(iEntity, DEF_ACCUSERMODE,AccessUserModes.UNKNOWN));
				appMenuItem.setAccessKey(DataObject.getStringValue(iEntity, DEF_ACCESSKEY,""));
				appMenuItem.setCounterId(DataObject.getStringValue(iEntity, DEF_COUNTERID,""));
			}
			
			if(list2.size() ==0) {
				break;
			}
			if(list2.size() == list.size() ) {
				log.error(StringHelper.format("应用菜单[%1$s][%2$s]配置出现无效菜单项",iAppMenu.getId(),iAppMenu.getName()));
				break;
			}
			list.clear();
			list.addAll(list2);
		}
		
		//appMenuRootItemMap.put(iAppMenu.getId(),appMenuRootItem);
		return appMenuRootItem;
	}
	
}
