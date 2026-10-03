package net.ibizsys.paas.control.menu;

import java.util.Iterator;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;

/**
 * 应用菜单辅助功能
 * @author Administrator
 *
 */
public class AppMenuUtils {
	
	/**
	 * 从Xml文件加载菜单配置信息
	 * @param rootMenuItem
	 * @param strXmlPath
	 * @throws Exception 
	 */
	public static void writeXmlFile(AppMenuRootItem rootMenuItem, String strXmlPath) throws Exception{
		XmlNode root = new XmlNode();
		root.setNodeName("ROOT");
		AppMenuUtils.toXmlNode(rootMenuItem, root);
		XmlNode.writeToFile(root, strXmlPath);
	}
	
	/**
	 * 将菜单配置信息写入Xml文件
	 * @param rootMenuItem
	 * @param strXmlPath
	 * @return
	 */
	public static AppMenuRootItem loadXmlFile(AppMenuRootItem rootMenuItem, String strXmlPath) throws Exception{
		if(rootMenuItem == null)
			rootMenuItem = new AppMenuRootItem();
		
		XmlNode root = XmlNode.load(strXmlPath);
		AppMenuUtils.fromXmlNode(root, rootMenuItem);
		
		return rootMenuItem;
	}
	
	/**
	 * 导出到Xml对象
	 * @param iAppMenuItem
	 * @param xmlNode
	 * @return
	 * @throws Exception
	 */
	public static XmlNode toXmlNode(IAppMenuItem iAppMenuItem, XmlNode xmlNode) throws Exception {
		if (xmlNode == null) 
			xmlNode = new XmlNode();
		
		String strItemType = iAppMenuItem.getItemType();
		xmlNode.setId(iAppMenuItem.getId());
		if(!StringHelper.isNullOrEmpty(strItemType))
			xmlNode.setNodeName(strItemType);
		if(StringHelper.compare(strItemType, MenuItem.MENUITEMTYPE_MENUITEM, true) ==0){
			xmlNode.setAttribute(MenuItem.MENUITEM_TEXT, iAppMenuItem.getText());
			if(!StringHelper.isNullOrEmpty(iAppMenuItem.getTextCls()))
				xmlNode.setAttribute(MenuItem.MENUITEM_TEXTCLS, iAppMenuItem.getTextCls());
			if(!StringHelper.isNullOrEmpty(iAppMenuItem.getTextLanResTag()))
				xmlNode.setAttribute(MenuItem.MENUITEM_TEXTLANRESTAG, iAppMenuItem.getTextLanResTag());
			if(!StringHelper.isNullOrEmpty(iAppMenuItem.getIconCls()))
				xmlNode.setAttribute(MenuItem.MENUITEM_ICONCLS, iAppMenuItem.getIconCls());
			if(!StringHelper.isNullOrEmpty(iAppMenuItem.getIconPath()))
				xmlNode.setAttribute(MenuItem.MENUITEM_ICONPATH, iAppMenuItem.getIconPath());
			if(!StringHelper.isNullOrEmpty(iAppMenuItem.getTooltip()))
				xmlNode.setAttribute(MenuItem.MENUITEM_TOOLTIP, iAppMenuItem.getTooltip());
			if(!StringHelper.isNullOrEmpty(iAppMenuItem.getTooltipLanResTag()))
				xmlNode.setAttribute(MenuItem.MENUITEM_TOOLTIPLANRESTAG, iAppMenuItem.getTooltipLanResTag());
			if(!StringHelper.isNullOrEmpty(iAppMenuItem.getPId()))
				xmlNode.setAttribute(MenuItem.MENUITEM_PID, iAppMenuItem.getPId());
			if(!StringHelper.isNullOrEmpty(iAppMenuItem.getCounterId()))
				xmlNode.setAttribute(MenuItem.MENUITEM_COUNTERID, iAppMenuItem.getCounterId());
			if(!StringHelper.isNullOrEmpty(iAppMenuItem.getAccessKey()))
				xmlNode.setAttribute(MenuItem.MENUITEM_ACCESSKEY, iAppMenuItem.getAccessKey());
			xmlNode.setAttribute(MenuItem.MENUITEM_ACCUSERMODE, String.valueOf(iAppMenuItem.getAccUserMode()));
			xmlNode.setAttribute(MenuItem.MENUITEM_EXPANDED, iAppMenuItem.isExpanded()?"TRUE":"FALSE");
			
		}else if(StringHelper.compare(strItemType, IMenuItem.MENUITEMTYPE_SEPERATOR, true) ==0){
			
		}else if(StringHelper.compare(strItemType, IMenuItem.MENUITEMTYPE_USERITEM, true) ==0){
			
		}		
		if (!StringHelper.isNullOrEmpty(iAppMenuItem.getAppFuncId())) {
			xmlNode.setAttribute(AppMenuItem.APPMENUITEM_APPFUNCID, iAppMenuItem.getAppFuncId());
		}
		if (iAppMenuItem.isHideSideBar()) {
			xmlNode.setAttribute(AppMenuItem.APPMENUITEM_HIDESIDEBAR, "TRUE");
		}
		if (iAppMenuItem.isOpenDefault()) {
			xmlNode.setAttribute(AppMenuItem.APPMENUITEM_OPENDEFAULT, "TRUE");
		}

		for (IAppMenuItem childExpBarItem : iAppMenuItem.getItems()) {
			XmlNode item = AppMenuUtils.toXmlNode(childExpBarItem, null);
			if (item == null) 
				continue;
			xmlNode.addNode(item);
		}
		
		return xmlNode;
	}

	/**
	 * 从Xml对象导入
	 * @param xmlNode
	 * @param iAppMenuItem
	 * @return
	 * @throws Exception
	 */
	public static IAppMenuItem fromXmlNode(XmlNode xmlNode, IAppMenuItem iAppMenuItem) throws Exception {
		AppMenuItem appMenuItem = null;
		if (iAppMenuItem == null) 
			appMenuItem = new AppMenuItem();
		else
			appMenuItem = (AppMenuItem)iAppMenuItem;
		
		String strItemType = xmlNode.getNodeName();
		appMenuItem.setId(xmlNode.getId());
		appMenuItem.setItemType(strItemType);
		if(StringHelper.compare(strItemType, IMenuItem.MENUITEMTYPE_MENUITEM, true) ==0){
			appMenuItem.setText(xmlNode.getAttribute(MenuItem.MENUITEM_TEXT, ""));
			if(!StringHelper.isNullOrEmpty(xmlNode.getAttribute(MenuItem.MENUITEM_TEXTCLS, "")))
				appMenuItem.setTextCls(xmlNode.getAttribute(MenuItem.MENUITEM_TEXTCLS, ""));
			if(!StringHelper.isNullOrEmpty(xmlNode.getAttribute(MenuItem.MENUITEM_TEXTLANRESTAG, "")))
				appMenuItem.setTextLanResTag(xmlNode.getAttribute(MenuItem.MENUITEM_TEXTLANRESTAG, ""));
			if(!StringHelper.isNullOrEmpty(xmlNode.getAttribute(MenuItem.MENUITEM_ICONCLS, "")))
				appMenuItem.setIconCls(xmlNode.getAttribute(MenuItem.MENUITEM_ICONCLS, ""));
			if(!StringHelper.isNullOrEmpty(xmlNode.getAttribute(MenuItem.MENUITEM_ICONPATH, "")))
				appMenuItem.setIconPath(xmlNode.getAttribute(MenuItem.MENUITEM_ICONPATH, ""));
			if(!StringHelper.isNullOrEmpty(xmlNode.getAttribute(MenuItem.MENUITEM_TOOLTIP, "")))
				appMenuItem.setTooltip(xmlNode.getAttribute(MenuItem.MENUITEM_TOOLTIP, ""));
			if(!StringHelper.isNullOrEmpty(xmlNode.getAttribute(MenuItem.MENUITEM_TOOLTIPLANRESTAG, "")))
				appMenuItem.setTooltipLanResTag(xmlNode.getAttribute(MenuItem.MENUITEM_TOOLTIPLANRESTAG, ""));
			if(!StringHelper.isNullOrEmpty(xmlNode.getAttribute(MenuItem.MENUITEM_PID, "")))
				appMenuItem.setPId(xmlNode.getAttribute(MenuItem.MENUITEM_PID, ""));
			if(!StringHelper.isNullOrEmpty(xmlNode.getAttribute(MenuItem.MENUITEM_COUNTERID, "")))
				appMenuItem.setCounterId(xmlNode.getAttribute(MenuItem.MENUITEM_COUNTERID, ""));
			if(!StringHelper.isNullOrEmpty(xmlNode.getAttribute(MenuItem.MENUITEM_ACCESSKEY, "")))
				appMenuItem.setAccessKey(xmlNode.getAttribute(MenuItem.MENUITEM_ACCESSKEY, ""));
			appMenuItem.setAccUserMode(xmlNode.getAttribute(MenuItem.MENUITEM_ACCUSERMODE, 0));
			appMenuItem.setExpanded(xmlNode.getAttribute(MenuItem.MENUITEM_EXPANDED, false));
			
			if (!StringHelper.isNullOrEmpty(xmlNode.getAttribute(AppMenuItem.APPMENUITEM_APPFUNCID, ""))) {
				appMenuItem.setAppFuncId(xmlNode.getAttribute(AppMenuItem.APPMENUITEM_APPFUNCID, ""));
			}
			if (xmlNode.getAttribute(AppMenuItem.APPMENUITEM_HIDESIDEBAR, false)) {
				appMenuItem.setHideSideBar(true);
			}
			if (xmlNode.getAttribute(AppMenuItem.APPMENUITEM_OPENDEFAULT, false)) {
				appMenuItem.setOpenDefault(true);
			}
		}else if(StringHelper.compare(strItemType, IMenuItem.MENUITEMTYPE_SEPERATOR, true) ==0){
			
		}else if(StringHelper.compare(strItemType, IMenuItem.MENUITEMTYPE_USERITEM, true) ==0){
			
		}
		
		Iterator<XmlNode> children = xmlNode.getChildNodes();
		if(children != null){
			while(children.hasNext()){
				XmlNode child = children.next();
				AppMenuItem childAppMenuItem = new AppMenuItem();
				AppMenuUtils.fromXmlNode(child, childAppMenuItem);
				appMenuItem.getItems().add(childAppMenuItem);
			}
		}
		return appMenuItem;
	}

}
