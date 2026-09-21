/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.paas.xml.XmlNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.appdesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuItem;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppMenuService
extends PSAppMenuServiceBase {
    private static final Log log = LogFactory.getLog(PSAppMenuService.class);

    @Override
    public void getWithModel(PSAppMenu pSAppMenu) throws Exception {
        if (!KeyValueHelper.isTempKey((String)pSAppMenu.getPSAppMenuId())) {
            this.getTempMajor(pSAppMenu);
        } else {
            this.getTemp((IEntity)pSAppMenu);
        }
        pSAppMenu.setMenuModel(this.getMenuModel(pSAppMenu));
    }

    protected String getMenuModel(PSAppMenu pSAppMenu) throws Exception {
        PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService((String)PSAppMenuItemService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppMenuItem> arrayList = pSAppMenuItemService.selectTempByPSAppMenu(pSAppMenu, "ORDER BY ORDERVALUE");
        HashMap<String, XmlNode> hashMap = new HashMap<String, XmlNode>();
        for (PSAppMenuItem entityBase2 : arrayList) {
            XmlNode xmlNode = new XmlNode();
            xmlNode.setNodeName(entityBase2.getAMItemType());
            entityBase2.fillXmlNode(xmlNode, true);
            hashMap.put(entityBase2.getPSAppMenuItemId(), xmlNode);
        }
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName("APPMENU");
        PSSystem pSSystem = pSAppMenu.getPSSysApp().getPSSystem();
        xmlNode.setAttribute("PSSYSTEMID", pSSystem.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)pSSystem.getPSDevSlnSysId())) {
            xmlNode.setAttribute("PSDEVSLNSYSID", pSSystem.getPSDevSlnSysId());
            xmlNode.setAttribute("TASKSERVERURL", pSSystem.getPSDevCenterTS().getPSTaskServer().getServerUrl());
        } else {
            xmlNode.setAttribute("PSDEVSLNSYSID", "");
            xmlNode.setAttribute("TASKSERVERURL", "http://lionlau-w530:8000/SAEAM/");
        }
        xmlNode.setAttribute("PSSYSAPPID", pSAppMenu.getPSSysAppId());
        xmlNode.setAttribute("PSAPPMENUID", pSAppMenu.getPSAppMenuId());
        for (PSAppMenuItem pSAppMenuItem : arrayList) {
            XmlNode xmlNode2 = (XmlNode)hashMap.get(pSAppMenuItem.getPSAppMenuItemId());
            if (StringHelper.isNullOrEmpty((String)pSAppMenuItem.getPPSAppMenuItemId())) {
                xmlNode.addNode(xmlNode2);
                continue;
            }
            XmlNode xmlNode3 = (XmlNode)hashMap.get(pSAppMenuItem.getPPSAppMenuItemId());
            if (xmlNode3 != null) {
                xmlNode3.addNode(xmlNode2);
                continue;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u4e0a\u7ea7\u83dc\u5355\u9879\u6807\u8bc6[%1$s], \u540d\u79f0\u4e3a[%2$s]", (Object)pSAppMenuItem.getPPSAppMenuItemId(), (Object)pSAppMenuItem.getPSAppMenuItemName()));
        }
        return XmlNode.export((XmlNode)xmlNode);
    }

    @Override
    public void updateWithModel(PSAppMenu pSAppMenu) throws Exception {
        final PSAppMenu pSAppMenu2 = pSAppMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuItem pSAppMenuItem2;
                PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService((String)PSAppMenuItemService.class.getCanonicalName(), (SessionFactory)PSAppMenuService.this.getSessionFactory());
                ArrayList<PSAppMenuItem> arrayList = pSAppMenuItemService.selectTempByPSAppMenu(pSAppMenu2);
                HashMap<String, PSAppMenuItem> hashMap = new HashMap<String, PSAppMenuItem>();
                for (PSAppMenuItem pSAppMenuItem2 : arrayList) {
                    hashMap.put(pSAppMenuItem2.getPSAppMenuItemId(), pSAppMenuItem2);
                }
                String string = pSAppMenu2.getMenuModel();
                pSAppMenuItem2 = XmlNode.loadFromXML((String)string);
                if (pSAppMenuItem2 != null) {
                    PSAppMenuService.this.updatePSAppMenuItems(pSAppMenu2, null, (XmlNode)pSAppMenuItem2, hashMap);
                    pSAppMenu2.setMenuModel(XmlNode.export((XmlNode)pSAppMenuItem2));
                } else {
                    pSAppMenu2.setMenuModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSAppMenuItem pSAppMenuItem3 : hashMap.values()) {
                        pSAppMenuItemService.removeTemp((IEntity)pSAppMenuItem3);
                    }
                }
                PSAppMenuService.this.updateTempMajor(pSAppMenu2);
            }
        });
    }

    protected void updatePSAppMenuItems(PSAppMenu pSAppMenu, PSAppMenuItem pSAppMenuItem, XmlNode xmlNode, HashMap<String, PSAppMenuItem> hashMap) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
            int n = 0;
            while (iterator.hasNext()) {
                PSAppMenuItem pSAppMenuItem2;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                String string = xmlNode2.getAttribute("PSAPPMENUITEMID", "");
                if (StringHelper.isNullOrEmpty((String)string) || (pSAppMenuItem2 = hashMap.remove(string)) == null) continue;
                ++n;
                boolean bl = false;
                if (StringHelper.compare((String)pSAppMenuItem2.getPSAppMenuId(), (String)pSAppMenu.getPSAppMenuId(), (boolean)false) != 0) {
                    pSAppMenuItem2.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
                    bl = true;
                }
                if (StringHelper.compare((String)pSAppMenuItem2.getPSAppMenuName(), (String)pSAppMenu.getPSAppMenuName(), (boolean)false) != 0) {
                    pSAppMenuItem2.setPSAppMenuName(pSAppMenu.getPSAppMenuName());
                    bl = true;
                }
                if (pSAppMenuItem != null) {
                    if (StringHelper.compare((String)pSAppMenuItem2.getPPSAppMenuItemId(), (String)pSAppMenuItem.getPSAppMenuItemId(), (boolean)false) != 0) {
                        pSAppMenuItem2.setPPSAppMenuItemId(pSAppMenuItem.getPSAppMenuItemId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)pSAppMenuItem2.getPPSAppMenuItemName(), (String)pSAppMenuItem.getPSAppMenuItemName(), (boolean)false) != 0) {
                        pSAppMenuItem2.setPPSAppMenuItemName(pSAppMenuItem.getPSAppMenuItemName());
                        bl = true;
                    }
                }
                if (pSAppMenuItem2.getOrderValue() == null || pSAppMenuItem2.getOrderValue() != n) {
                    pSAppMenuItem2.setOrderValue(n);
                    bl = true;
                }
                if (bl) {
                    pSAppMenuItemService.updateTemp((IEntity)pSAppMenuItem2);
                }
                xmlNode2.resetAttributes();
                pSAppMenuItem2.fillXmlNode(xmlNode2, false);
                arrayList.add(xmlNode2);
                this.updatePSAppMenuItems(pSAppMenu, pSAppMenuItem2, xmlNode2, hashMap);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
        }
    }

    @Override
    public void createWithModel(PSAppMenu pSAppMenu) throws Exception {
        final PSAppMenu pSAppMenu2 = pSAppMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuItem pSAppMenuItem2;
                PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService((String)PSAppMenuItemService.class.getCanonicalName(), (SessionFactory)PSAppMenuService.this.getSessionFactory());
                ArrayList<PSAppMenuItem> arrayList = pSAppMenuItemService.selectTempByPSAppMenu(pSAppMenu2);
                HashMap<String, PSAppMenuItem> hashMap = new HashMap<String, PSAppMenuItem>();
                for (PSAppMenuItem pSAppMenuItem2 : arrayList) {
                    hashMap.put(pSAppMenuItem2.getPSAppMenuItemId(), pSAppMenuItem2);
                }
                String string = pSAppMenu2.getMenuModel();
                pSAppMenuItem2 = XmlNode.loadFromXML((String)string);
                if (pSAppMenuItem2 != null) {
                    PSAppMenuService.this.updatePSAppMenuItems(pSAppMenu2, null, (XmlNode)pSAppMenuItem2, hashMap);
                    pSAppMenu2.setMenuModel(XmlNode.export((XmlNode)pSAppMenuItem2));
                } else {
                    pSAppMenu2.setMenuModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSAppMenuItem pSAppMenuItem3 : hashMap.values()) {
                        pSAppMenuItemService.removeTemp((IEntity)pSAppMenuItem3);
                    }
                }
                PSAppMenuService.this.createTempMajor((IEntity)pSAppMenu2);
            }
        });
    }

    @Override
    public void previewSave(PSAppMenu pSAppMenu) throws Exception {
        final PSAppMenu pSAppMenu2 = pSAppMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuItem pSAppMenuItem2;
                PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService((String)PSAppMenuItemService.class.getCanonicalName(), (SessionFactory)PSAppMenuService.this.getSessionFactory());
                ArrayList<PSAppMenuItem> arrayList = pSAppMenuItemService.selectTempByPSAppMenu(pSAppMenu2);
                HashMap<String, PSAppMenuItem> hashMap = new HashMap<String, PSAppMenuItem>();
                for (PSAppMenuItem pSAppMenuItem2 : arrayList) {
                    hashMap.put(pSAppMenuItem2.getPSAppMenuItemId(), pSAppMenuItem2);
                }
                Object object = pSAppMenu2.getMenuModel();
                if (StringHelper.isNullOrEmpty((String)object)) {
                    object = WebContext.getCurrent().getPostValue("tbmodel");
                }
                if ((pSAppMenuItem2 = XmlNode.loadFromXML((String)object)) != null) {
                    PSAppMenuService.this.updatePSAppMenuItems(pSAppMenu2, null, (XmlNode)pSAppMenuItem2, hashMap);
                    pSAppMenu2.setMenuModel(XmlNode.export((XmlNode)pSAppMenuItem2));
                } else {
                    pSAppMenu2.setMenuModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSAppMenuItem pSAppMenuItem3 : hashMap.values()) {
                        pSAppMenuItemService.removeTemp((IEntity)pSAppMenuItem3);
                    }
                }
            }
        });
    }

    @Override
    public void getDraftWithModel(PSAppMenu pSAppMenu) throws Exception {
        this.getDraftTempMajor((IEntity)pSAppMenu);
        pSAppMenu.setMenuModel(this.getMenuModel(pSAppMenu));
    }

    @Override
    public void getDraftFromWithModel(PSAppMenu pSAppMenu) throws Exception {
        this.getDraftTempMajorFrom(pSAppMenu);
        pSAppMenu.setMenuModel(this.getMenuModel(pSAppMenu));
    }

    @Override
    protected void onBeforeCreate(PSAppMenu pSAppMenu) throws Exception {
        pSAppMenu.setMenuModel(null);
        super.onBeforeCreate(pSAppMenu);
    }

    @Override
    protected void onBeforeUpdate(PSAppMenu pSAppMenu) throws Exception {
        pSAppMenu.setMenuModel(null);
        super.onBeforeUpdate(pSAppMenu);
    }

    @Override
    public void getDraftTempMajorFrom(PSAppMenu pSAppMenu) throws Exception {
        Object object = EntityBase.getOriginKey((IEntity)pSAppMenu);
        if (StringHelper.isNullOrEmpty((Object)object)) {
            object = pSAppMenu.getPSAppMenuId();
        }
        super.getDraftTempMajorFrom(pSAppMenu);
        if (!StringHelper.isNullOrEmpty((Object)object)) {
            PSAppMenu pSAppMenu2;
            PSAppMenu pSAppMenu3 = new PSAppMenu();
            pSAppMenu3.setSessionFactory(this.getSessionFactory());
            pSAppMenu3.setPSAppMenuId((String)object);
            if (!pSAppMenu3.get(true)) {
                return;
            }
            int n = 2;
            if (StringHelper.isNullOrEmpty((String)pSAppMenu3.getPSAppMenuName())) {
                pSAppMenu3.setPSAppMenuName("DEFAULT");
            }
            while (true) {
                pSAppMenu2 = new PSAppMenu();
                pSAppMenu2.setSessionFactory(this.getSessionFactory());
                pSAppMenu2.setPSSysAppId(pSAppMenu3.getPSSysAppId());
                pSAppMenu2.setPSAppMenuName(StringHelper.format((String)"%1$s_%2$s", (Object)pSAppMenu3.getPSAppMenuName(), (Object)n));
                if (!pSAppMenu2.select(true)) break;
                ++n;
            }
            pSAppMenu.setPSAppMenuName(pSAppMenu2.getPSAppMenuName());
            if (!StringHelper.isNullOrEmpty((String)pSAppMenu3.getLogicName())) {
                n = 2;
                while (true) {
                    pSAppMenu2 = new PSAppMenu();
                    pSAppMenu2.setSessionFactory(this.getSessionFactory());
                    pSAppMenu2.setPSSysAppId(pSAppMenu3.getPSSysAppId());
                    pSAppMenu2.setLogicName(StringHelper.format((String)"%1$s(%2$s)", (Object)pSAppMenu3.getLogicName(), (Object)n));
                    if (!pSAppMenu2.select(true)) {
                        pSAppMenu.setLogicName(pSAppMenu2.getLogicName());
                        break;
                    }
                    ++n;
                }
            }
            if (!StringHelper.isNullOrEmpty((String)pSAppMenu3.getCodeName())) {
                n = 2;
                while (true) {
                    pSAppMenu2 = new PSAppMenu();
                    pSAppMenu2.setSessionFactory(this.getSessionFactory());
                    pSAppMenu2.setPSSysAppId(pSAppMenu3.getPSSysAppId());
                    pSAppMenu2.setCodeName(StringHelper.format((String)"%1$s_%2$s", (Object)pSAppMenu3.getCodeName(), (Object)n));
                    if (!pSAppMenu2.select(true)) {
                        pSAppMenu.setCodeName(pSAppMenu2.getCodeName());
                        break;
                    }
                    ++n;
                }
            }
        }
    }
}

