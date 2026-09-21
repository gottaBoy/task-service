/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.menu;

import java.util.Iterator;
import net.ibizsys.paas.control.menu.AppMenuItem;
import net.ibizsys.paas.control.menu.AppMenuRootItem;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;

public class AppMenuUtils {
    public static void writeXmlFile(AppMenuRootItem rootMenuItem, String strXmlPath) throws Exception {
        XmlNode root = new XmlNode();
        root.setNodeName("ROOT");
        AppMenuUtils.toXmlNode(rootMenuItem, root);
        XmlNode.writeToFile(root, strXmlPath);
    }

    public static AppMenuRootItem loadXmlFile(AppMenuRootItem rootMenuItem, String strXmlPath) throws Exception {
        if (rootMenuItem == null) {
            rootMenuItem = new AppMenuRootItem();
        }
        XmlNode root = XmlNode.load(strXmlPath);
        AppMenuUtils.fromXmlNode(root, rootMenuItem);
        return rootMenuItem;
    }

    public static XmlNode toXmlNode(IAppMenuItem iAppMenuItem, XmlNode xmlNode) throws Exception {
        if (xmlNode == null) {
            xmlNode = new XmlNode();
        }
        String strItemType = iAppMenuItem.getItemType();
        xmlNode.setId(iAppMenuItem.getId());
        if (!StringHelper.isNullOrEmpty(strItemType)) {
            xmlNode.setNodeName(strItemType);
        }
        if (StringHelper.compare(strItemType, "MENUITEM", true) == 0) {
            xmlNode.setAttribute("text", iAppMenuItem.getText());
            if (!StringHelper.isNullOrEmpty(iAppMenuItem.getTextCls())) {
                xmlNode.setAttribute("textcls", iAppMenuItem.getTextCls());
            }
            if (!StringHelper.isNullOrEmpty(iAppMenuItem.getTextLanResTag())) {
                xmlNode.setAttribute("textlanrestag", iAppMenuItem.getTextLanResTag());
            }
            if (!StringHelper.isNullOrEmpty(iAppMenuItem.getIconCls())) {
                xmlNode.setAttribute("iconcls", iAppMenuItem.getIconCls());
            }
            if (!StringHelper.isNullOrEmpty(iAppMenuItem.getIconPath())) {
                xmlNode.setAttribute("icon", iAppMenuItem.getIconPath());
            }
            if (!StringHelper.isNullOrEmpty(iAppMenuItem.getTooltip())) {
                xmlNode.setAttribute("tooltip", iAppMenuItem.getTooltip());
            }
            if (!StringHelper.isNullOrEmpty(iAppMenuItem.getTooltipLanResTag())) {
                xmlNode.setAttribute("tooltiplanrestag", iAppMenuItem.getTooltipLanResTag());
            }
            if (!StringHelper.isNullOrEmpty(iAppMenuItem.getPId())) {
                xmlNode.setAttribute("pid", iAppMenuItem.getPId());
            }
            if (!StringHelper.isNullOrEmpty(iAppMenuItem.getCounterId())) {
                xmlNode.setAttribute("counterid", iAppMenuItem.getCounterId());
            }
            if (!StringHelper.isNullOrEmpty(iAppMenuItem.getAccessKey())) {
                xmlNode.setAttribute("accesskey", iAppMenuItem.getAccessKey());
            }
            xmlNode.setAttribute("accusermode", String.valueOf(iAppMenuItem.getAccUserMode()));
            xmlNode.setAttribute("expanded", iAppMenuItem.isExpanded() ? "TRUE" : "FALSE");
        } else if (StringHelper.compare(strItemType, "SEPERATOR", true) != 0) {
            StringHelper.compare(strItemType, "USERITEM", true);
        }
        if (!StringHelper.isNullOrEmpty(iAppMenuItem.getAppFuncId())) {
            xmlNode.setAttribute("appfuncid", iAppMenuItem.getAppFuncId());
        }
        if (iAppMenuItem.isHideSideBar()) {
            xmlNode.setAttribute("hidesidebar", "TRUE");
        }
        if (iAppMenuItem.isOpenDefault()) {
            xmlNode.setAttribute("opendefault", "TRUE");
        }
        for (IAppMenuItem childExpBarItem : iAppMenuItem.getItems()) {
            XmlNode item = AppMenuUtils.toXmlNode(childExpBarItem, null);
            if (item == null) continue;
            xmlNode.addNode(item);
        }
        return xmlNode;
    }

    public static IAppMenuItem fromXmlNode(XmlNode xmlNode, IAppMenuItem iAppMenuItem) throws Exception {
        Iterator<XmlNode> children;
        AppMenuItem appMenuItem = null;
        appMenuItem = iAppMenuItem == null ? new AppMenuItem() : (AppMenuItem)iAppMenuItem;
        String strItemType = xmlNode.getNodeName();
        appMenuItem.setId(xmlNode.getId());
        appMenuItem.setItemType(strItemType);
        if (StringHelper.compare(strItemType, "MENUITEM", true) == 0) {
            appMenuItem.setText(xmlNode.getAttribute("text", ""));
            if (!StringHelper.isNullOrEmpty(xmlNode.getAttribute("textcls", ""))) {
                appMenuItem.setTextCls(xmlNode.getAttribute("textcls", ""));
            }
            if (!StringHelper.isNullOrEmpty(xmlNode.getAttribute("textlanrestag", ""))) {
                appMenuItem.setTextLanResTag(xmlNode.getAttribute("textlanrestag", ""));
            }
            if (!StringHelper.isNullOrEmpty(xmlNode.getAttribute("iconcls", ""))) {
                appMenuItem.setIconCls(xmlNode.getAttribute("iconcls", ""));
            }
            if (!StringHelper.isNullOrEmpty(xmlNode.getAttribute("icon", ""))) {
                appMenuItem.setIconPath(xmlNode.getAttribute("icon", ""));
            }
            if (!StringHelper.isNullOrEmpty(xmlNode.getAttribute("tooltip", ""))) {
                appMenuItem.setTooltip(xmlNode.getAttribute("tooltip", ""));
            }
            if (!StringHelper.isNullOrEmpty(xmlNode.getAttribute("tooltiplanrestag", ""))) {
                appMenuItem.setTooltipLanResTag(xmlNode.getAttribute("tooltiplanrestag", ""));
            }
            if (!StringHelper.isNullOrEmpty(xmlNode.getAttribute("pid", ""))) {
                appMenuItem.setPId(xmlNode.getAttribute("pid", ""));
            }
            if (!StringHelper.isNullOrEmpty(xmlNode.getAttribute("counterid", ""))) {
                appMenuItem.setCounterId(xmlNode.getAttribute("counterid", ""));
            }
            if (!StringHelper.isNullOrEmpty(xmlNode.getAttribute("accesskey", ""))) {
                appMenuItem.setAccessKey(xmlNode.getAttribute("accesskey", ""));
            }
            appMenuItem.setAccUserMode(xmlNode.getAttribute("accusermode", 0));
            appMenuItem.setExpanded(xmlNode.getAttribute("expanded", false));
            if (!StringHelper.isNullOrEmpty(xmlNode.getAttribute("appfuncid", ""))) {
                appMenuItem.setAppFuncId(xmlNode.getAttribute("appfuncid", ""));
            }
            if (xmlNode.getAttribute("hidesidebar", false)) {
                appMenuItem.setHideSideBar(true);
            }
            if (xmlNode.getAttribute("opendefault", false)) {
                appMenuItem.setOpenDefault(true);
            }
        } else if (StringHelper.compare(strItemType, "SEPERATOR", true) != 0) {
            StringHelper.compare(strItemType, "USERITEM", true);
        }
        if ((children = xmlNode.getChildNodes()) != null) {
            while (children.hasNext()) {
                XmlNode child = children.next();
                AppMenuItem childAppMenuItem = new AppMenuItem();
                AppMenuUtils.fromXmlNode(child, childAppMenuItem);
                appMenuItem.getItems().add(childAppMenuItem);
            }
        }
        return appMenuItem;
    }
}

