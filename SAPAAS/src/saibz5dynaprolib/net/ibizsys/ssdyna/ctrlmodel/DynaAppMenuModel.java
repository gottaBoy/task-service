package net.ibizsys.ssdyna.ctrlmodel;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.menu.IPSAppMenu;
import net.ibizsys.model.control.menu.IPSAppMenuItem;
import net.ibizsys.paas.control.menu.AppMenuItem;
import net.ibizsys.paas.control.menu.AppMenuRootItem;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.view.IDynaViewModel;

/**
 * 动态应用菜单模型对象
 * @author Administrator
 *
 */
public class DynaAppMenuModel extends AppMenuModelBase {

	private IPSControl iPSControl = null;

	@Override
	public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
		this.iPSControl = iPSControl;
		this.init(iDynaViewModel);
	}

	@Override
	public IPSControl getPSControl() {
		return this.iPSControl;
	}

	//
	// /**
	// * 注解Spring构造后执行
	// * @throws Exception
	// */
	// @PostConstruct
	// public void postConstruct() throws Exception{
	// AppMenuModelGlobal.registerAppMenuModel("${pub.getPKGCodeName()}.${app.getPKGCodeName()?lower_case}.srv.sys.ctrlmodel.${item.getControlType()?lower_case}.${app.getPKGCodeName()}${item.codeName}${srfclassname('${item.getControlType()}')}Model",this);
	// AppMenuModelGlobal.registerAppMenuModel("${srfjavastring('${item.id}')}",this);
	// }

	public IPSAppMenu getPSAppMenu() {
		return (IPSAppMenu) getPSControl();
	}

	/**
	 * 准备应用菜单根节点
	 * 
	 * @param appMenuRootItem
	 * @throws Exception
	 */
	@Override
	protected void onPrepareRootItem(AppMenuRootItem appMenuRootItem) throws Exception {
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
//			if (iPSAppMenuItem.getPSSysImage() != null) {
//				appMenuItemModel.setIconCls(iPSAppMenuItem.getPSSysImage().getCssClass());
//				appMenuItemModel.setIconPath(iPSAppMenuItem.getPSSysImage().getImagePath());
//			}
//			if (iPSAppMenuItem.getPSSysCss() != null) {
//				appMenuItemModel.setTextCls(iPSAppMenuItem.getPSSysCss().getCssName());
//			}
			if (iPSAppMenuItem.getAccUserMode() > 0) {
				appMenuItemModel.setAccUserMode(iPSAppMenuItem.getAccUserMode());
			}
			if (!StringHelper.isNullOrEmpty(iPSAppMenuItem.getAccessKey())) {
				appMenuItemModel.setAccessKey(iPSAppMenuItem.getAccessKey());
				appMenuItemModel.setAccUserMode(4);// 强制设置值
			}
		}

	}

}
