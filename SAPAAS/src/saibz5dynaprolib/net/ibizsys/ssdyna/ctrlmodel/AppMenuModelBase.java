package net.ibizsys.ssdyna.ctrlmodel;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.menu.IPSAppMenu;
import net.ibizsys.model.control.menu.IPSAppMenuItem;
import net.ibizsys.paas.control.menu.AppMenuItem;
import net.ibizsys.paas.control.menu.AppMenuRootItem;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.view.IDynaViewModel;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态应用菜单模型基类
 * @author Administrator
 *
 */
public abstract class AppMenuModelBase extends net.ibizsys.paas.ctrlmodel.AppMenuModelBase implements IDynaCtrlModel{

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(AppMenuModelBase.class);
	private IDynaViewModel iDynaViewModel = null;
	private IPSAppMenu iPSAppMenu = null; 
	
	
	@Override
	public void init(IViewController iViewController) throws Exception {
		if(iViewController instanceof IDynaViewModel){
			iDynaViewModel = (IDynaViewModel)iViewController;
			IPSControl iPSControl = null;
			if(iDynaViewModel.getPSAppView().hasPSControl(this.getName())){
				iPSControl = iDynaViewModel.getPSAppView().getPSControl(this.getName());
				if(!(iPSControl instanceof IPSAppMenu)){
					iPSControl = null;
				}
			}
			java.util.Iterator<IPSControl> psControls = iDynaViewModel.getPSAppView().getPSControls();
			while(psControls.hasNext()){
				iPSControl = psControls.next();
				if(iPSControl instanceof IPSAppMenu){
					iPSAppMenu = (IPSAppMenu) iPSControl;
					break;
				}
			}
			
			if(iPSAppMenu == null){
				//throw new Exception("无法获取当前应用菜单对象");
				log.error(StringHelper.format("无法从视图[%1$s][%2$s]获取菜单对象",iViewController.getId(),((IDynaViewModel) iViewController).getName()));
			}
		}
		
		super.init(iViewController);
	}

	@Override
	public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
		this.iDynaViewModel = iDynaViewModel;
		this.iPSAppMenu = (IPSAppMenu)iPSControl;
		super.init(iDynaViewModel);
	}

	@Override
	public IPSControl getPSControl() {
		return iPSAppMenu;
	}
	
	
	@Override
	protected void prepareCtrlModel() throws Exception {
		if(this.getPSControl()!=null && this.getPSControl().isDynamicCtrl()){
			//注册动态模型
			onPrepareDynaRootItem(this.getRootItem());
			return;
		}
		super.prepareCtrlModel();
	}
	
	/**
	 * 获取应用菜单对象
	 * @return
	 */
	public IPSAppMenu getPSAppMenu(){
		return this.iPSAppMenu;
	}
	
	/**
	 * 准备应用菜单根节点
	 * 
	 * @param appMenuRootItem
	 * @throws Exception
	 */
	protected void onPrepareDynaRootItem(AppMenuRootItem appMenuRootItem) throws Exception {
		java.util.ArrayList<IAppMenuItem> appMenuItems = this.getPSAppMenu().getRootItem().getAllItems();
		for (IAppMenuItem iAppMenuItem : appMenuItems) {
			IPSAppMenuItem iPSAppMenuItem = (IPSAppMenuItem) iAppMenuItem;
			// 添加 iPSAppMenuItem.text}
			AppMenuItem appMenuItemModel = appMenuRootItem.addItem(iPSAppMenuItem.getId(), iPSAppMenuItem.getPId());
			if (!StringHelper.isNullOrEmpty(iPSAppMenuItem.getAppFuncId())) {
				appMenuItemModel.setAppFuncId(iPSAppMenuItem.getAppFuncId());
			}
			if (!StringHelper.isNullOrEmpty(iPSAppMenuItem.getItemType())) {
				appMenuItemModel.setItemType(iPSAppMenuItem.getItemType());
			}
			appMenuItemModel.setText(iPSAppMenuItem.getText());
			if (iPSAppMenuItem.isExpanded()) {
				appMenuItemModel.setExpanded(true);
			}
			if (iPSAppMenuItem.isSeperator()) {
				appMenuItemModel.setSeperator(true);
			}
			if (iPSAppMenuItem.isHideSideBar()) {
				appMenuItemModel.setHideSideBar(true);
			}
			if (iPSAppMenuItem.isOpenDefault()) {
				appMenuItemModel.setOpenDefault(true);
			}
			if (iPSAppMenuItem.getPSSysImage() != null) {
				appMenuItemModel.setIconCls(iPSAppMenuItem.getPSSysImage().getCssClass());
				appMenuItemModel.setIconPath(iPSAppMenuItem.getPSSysImage().getImagePath());
			}
			if (iPSAppMenuItem.getPSSysCss() != null) {
				appMenuItemModel.setTextCls(iPSAppMenuItem.getPSSysCss().getCssName());
			}
			if (iPSAppMenuItem.getAccUserMode() > 0) {
				appMenuItemModel.setAccUserMode(iPSAppMenuItem.getAccUserMode());
			}
			if (!StringHelper.isNullOrEmpty(iPSAppMenuItem.getAccessKey())) {
				appMenuItemModel.setAccessKey(iPSAppMenuItem.getAccessKey());
				appMenuItemModel.setAccUserMode(4);// 强制设置值
			}
		}
	}
	
	@Override
	public ObjectNode toJsonObject(ObjectNode objectNode) throws Exception {
		if(objectNode == null){
			objectNode = JsonNodeHelper.createObjectNode();
		}
		onFillJsonObject(objectNode);
		return objectNode;
	}
	
	protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
		if(getPSControl()!=null){
			DynaCtrlModelBase.toJsonObject(objectNode,getPSControl());
		}
	}
	
	@Override
	public boolean isDynaCtrl() {
		if(this.getPSControl()!=null){
			return this.getPSControl().isDynamicCtrl();
		}
		return false;
	}
}
