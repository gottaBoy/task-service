package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.control.ControlTypes;
import net.ibizsys.paas.control.menu.AppMenuItem;
import net.ibizsys.paas.control.menu.AppMenuRootItem;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.sysmodel.ISystemUtil;
import net.ibizsys.paas.sysmodel.util.IAppCustomizeUtil;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.sf.json.JSONObject;

/**
 * 应用菜单模型基类
 * 
 * @author lionlau
 * 
 */
public abstract class AppMenuModelBase extends CtrlModelBase implements IAppMenuModel{
	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(AppMenuModelBase.class);
	private AppMenuRootItem appMenuRootItem = new AppMenuRootItem();
	private boolean bPrepareRootItem = false;

	/**
	 * 初始化
	 * 
	 * @throws Exception
	 */
	public void init() throws Exception {
		onInit();
		prepareCtrlModel();
	}

	@Override
	protected void onInit() throws Exception {
		super.onInit();
	}
	
	@Override
	protected void prepareCtrlModel() throws Exception {
		if(!bPrepareRootItem) {
			bPrepareRootItem = true;
			onPrepareRootItem(this.getRootItem());
		}
	}
	

	@Override
	public AppMenuRootItem getRootItem() {
		return this.appMenuRootItem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.menu.IAppMenu#getMenuItems()
	 */
	@Override
	public Iterator<IAppMenuItem> getAppMenuItems() {
		return getRootItem().getItems().iterator();
	}

	@Override
	public String getControlType() {
		return ControlTypes.AppMenu;
	}

	/**
	 * 准备导航栏根节点
	 * 
	 * @param expBarRootItem
	 * @throws Exception
	 */
	protected void onPrepareRootItem(AppMenuRootItem appMenuRootItem) throws Exception {

	}

	/**
	 * 填充获取数据返回结果对象
	 * 
	 * @param fetchResult
	 * @throws Exception
	 */
	@Override
	public void fillFetchResult(MDAjaxActionResult fetchResult) throws Exception {
		
		java.util.Iterator<IAppMenuItem> appMenuItems = null;
		if(this.isEnableCustomize() && this.getViewController()!=null) {
			ISystemUtil iSystemUtil = this.getViewController().getAppModel().getSystemModel().getSystemUtil(IAppCustomizeUtil.UTILTYPE_APPCUSTOMIZE, true);
			if(iSystemUtil!=null) {
				appMenuItems = ((IAppCustomizeUtil)iSystemUtil).getAppMenuItems(this);
			}
			else {
				log.warn(StringHelper.format("应用菜单[%1$s]启用自定义，但系统没有提供应用自定义组件"));
			}
		}
		if(appMenuItems == null) {
			appMenuItems = getAppMenuItems();
		}
		
		while(appMenuItems.hasNext()) {
			IAppMenuItem iAppMenuItem = appMenuItems.next();
			if(iAppMenuItem.getFiller()!=null){
				ArrayList<JSONObject> list = iAppMenuItem.getFiller().toJSONObjects(iAppMenuItem);
				if(list!=null){
					fetchResult.getRows().addAll(list);
				}
			}
			else{
				JSONObject jo = AppMenuItem.toJSONObject(iAppMenuItem, null);
				if (jo != null) {
					fetchResult.getRows().add(jo);
				}
			}
		}
	}
}
