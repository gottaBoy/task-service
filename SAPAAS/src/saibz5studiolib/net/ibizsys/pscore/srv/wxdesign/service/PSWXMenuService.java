/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
package net.ibizsys.pscore.srv.wxdesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenu;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuItem;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuItemService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSWXMenuService
extends PSWXMenuServiceBase {
    private static final Log log = LogFactory.getLog(PSWXMenuService.class);

    @Override
    public void getWithModel(PSWXMenu pSWXMenu) throws Exception {
        if (!KeyValueHelper.isTempKey((String)pSWXMenu.getPSWXMenuId())) {
            this.getTempMajor(pSWXMenu);
        } else {
            this.getTemp((IEntity)pSWXMenu);
        }
        pSWXMenu.setMenuModel(this.getMenuModel(pSWXMenu));
    }

    protected String getMenuModel(PSWXMenu pSWXMenu) throws Exception {
        PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService((String)PSWXMenuItemService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSWXMenuItem> arrayList = pSWXMenuItemService.selectTempByPSWXMenu(pSWXMenu, "ORDER BY ORDERVALUE");
        HashMap<String, XmlNode> hashMap = new HashMap<String, XmlNode>();
        for (PSWXMenuItem entityBase2 : arrayList) {
            XmlNode xmlNode = new XmlNode();
            xmlNode.setNodeName("WXMENUITEM");
            entityBase2.fillXmlNode(xmlNode, true);
            hashMap.put(entityBase2.getPSWXMenuItemId(), xmlNode);
        }
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName("WXMENU");
        PSSystem pSSystem = pSWXMenu.getPSWXAccount().getPSSystem();
        xmlNode.setAttribute("PSSYSTEMID", pSSystem.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)pSSystem.getPSDevSlnSysId())) {
            xmlNode.setAttribute("PSDEVSLNSYSID", pSSystem.getPSDevSlnSysId());
            xmlNode.setAttribute("TASKSERVERURL", pSSystem.getPSDevCenterTS().getPSTaskServer().getServerUrl());
        } else {
            xmlNode.setAttribute("PSDEVSLNSYSID", "");
            xmlNode.setAttribute("TASKSERVERURL", "http://lionlau-w530:8000/SAEAM/");
        }
        xmlNode.setAttribute("PSWXACCOUNTID", pSWXMenu.getPSWXAccountId());
        xmlNode.setAttribute("PSWXMENUID", pSWXMenu.getPSWXMenuId());
        for (PSWXMenuItem pSWXMenuItem : arrayList) {
            XmlNode xmlNode2 = (XmlNode)hashMap.get(pSWXMenuItem.getPSWXMenuItemId());
            if (StringHelper.isNullOrEmpty((String)pSWXMenuItem.getPPSWXMenuItemId())) {
                xmlNode.addNode(xmlNode2);
                continue;
            }
            XmlNode xmlNode3 = (XmlNode)hashMap.get(pSWXMenuItem.getPPSWXMenuItemId());
            if (xmlNode3 != null) {
                xmlNode3.addNode(xmlNode2);
                continue;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7236\u83dc\u5355\u9879\u6807\u8bc6[%1$s],\u540d\u79f0\u4e3a[%2$s]", (Object)pSWXMenuItem.getPPSWXMenuItemId(), (Object)pSWXMenuItem.getPSWXMenuItemName()));
        }
        return XmlNode.export((XmlNode)xmlNode);
    }

    @Override
    public void updateWithModel(PSWXMenu pSWXMenu) throws Exception {
        final PSWXMenu pSWXMenu2 = pSWXMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXMenuItem pSWXMenuItem2;
                PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService((String)PSWXMenuItemService.class.getCanonicalName(), (SessionFactory)PSWXMenuService.this.getSessionFactory());
                ArrayList<PSWXMenuItem> arrayList = pSWXMenuItemService.selectTempByPSWXMenu(pSWXMenu2);
                HashMap<String, PSWXMenuItem> hashMap = new HashMap<String, PSWXMenuItem>();
                for (PSWXMenuItem pSWXMenuItem2 : arrayList) {
                    hashMap.put(pSWXMenuItem2.getPSWXMenuItemId(), pSWXMenuItem2);
                }
                String string = pSWXMenu2.getMenuModel();
                pSWXMenuItem2 = XmlNode.loadFromXML((String)string);
                if (pSWXMenuItem2 != null) {
                    PSWXMenuService.this.updatePSWXMenuItems(pSWXMenu2, null, (XmlNode)pSWXMenuItem2, hashMap);
                    pSWXMenu2.setMenuModel(XmlNode.export((XmlNode)pSWXMenuItem2));
                } else {
                    pSWXMenu2.setMenuModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSWXMenuItem pSWXMenuItem3 : hashMap.values()) {
                        pSWXMenuItemService.removeTemp((IEntity)pSWXMenuItem3);
                    }
                }
                PSWXMenuService.this.updateTempMajor(pSWXMenu2);
            }
        });
    }

    protected void updatePSWXMenuItems(PSWXMenu pSWXMenu, PSWXMenuItem pSWXMenuItem, XmlNode xmlNode, HashMap<String, PSWXMenuItem> hashMap) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService(PSWXMenuItemService.class, (SessionFactory)this.getSessionFactory());
            int n = 0;
            while (iterator.hasNext()) {
                PSWXMenuItem pSWXMenuItem2;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                String string = xmlNode2.getAttribute("PSWXMENUITEMID", "");
                if (StringHelper.isNullOrEmpty((String)string) || (pSWXMenuItem2 = hashMap.remove(string)) == null) continue;
                ++n;
                boolean bl = false;
                if (StringHelper.compare((String)pSWXMenuItem2.getPSWXMenuId(), (String)pSWXMenu.getPSWXMenuId(), (boolean)false) != 0) {
                    pSWXMenuItem2.setPSWXMenuId(pSWXMenu.getPSWXMenuId());
                    bl = true;
                }
                if (StringHelper.compare((String)pSWXMenuItem2.getPSWXMenuName(), (String)pSWXMenu.getPSWXMenuName(), (boolean)false) != 0) {
                    pSWXMenuItem2.setPSWXMenuName(pSWXMenu.getPSWXMenuName());
                    bl = true;
                }
                if (pSWXMenuItem != null) {
                    if (StringHelper.compare((String)pSWXMenuItem2.getPPSWXMenuItemId(), (String)pSWXMenuItem.getPSWXMenuItemId(), (boolean)false) != 0) {
                        pSWXMenuItem2.setPPSWXMenuItemId(pSWXMenuItem.getPSWXMenuItemId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)pSWXMenuItem2.getPPSWXMenuItemName(), (String)pSWXMenuItem.getPSWXMenuItemName(), (boolean)false) != 0) {
                        pSWXMenuItem2.setPPSWXMenuItemName(pSWXMenuItem.getPSWXMenuItemName());
                        bl = true;
                    }
                }
                if (pSWXMenuItem2.getOrderValue() == null || pSWXMenuItem2.getOrderValue() != n) {
                    pSWXMenuItem2.setOrderValue(n);
                    bl = true;
                }
                if (bl) {
                    pSWXMenuItemService.updateTemp((IEntity)pSWXMenuItem2);
                }
                xmlNode2.resetAttributes();
                pSWXMenuItem2.fillXmlNode(xmlNode2, false);
                arrayList.add(xmlNode2);
                this.updatePSWXMenuItems(pSWXMenu, pSWXMenuItem2, xmlNode2, hashMap);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
        }
    }

    @Override
    public void createWithModel(PSWXMenu pSWXMenu) throws Exception {
        final PSWXMenu pSWXMenu2 = pSWXMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXMenuItem pSWXMenuItem2;
                PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService((String)PSWXMenuItemService.class.getCanonicalName(), (SessionFactory)PSWXMenuService.this.getSessionFactory());
                ArrayList<PSWXMenuItem> arrayList = pSWXMenuItemService.selectTempByPSWXMenu(pSWXMenu2);
                HashMap<String, PSWXMenuItem> hashMap = new HashMap<String, PSWXMenuItem>();
                for (PSWXMenuItem pSWXMenuItem2 : arrayList) {
                    hashMap.put(pSWXMenuItem2.getPSWXMenuItemId(), pSWXMenuItem2);
                }
                String string = pSWXMenu2.getMenuModel();
                pSWXMenuItem2 = XmlNode.loadFromXML((String)string);
                if (pSWXMenuItem2 != null) {
                    PSWXMenuService.this.updatePSWXMenuItems(pSWXMenu2, null, (XmlNode)pSWXMenuItem2, hashMap);
                    pSWXMenu2.setMenuModel(XmlNode.export((XmlNode)pSWXMenuItem2));
                } else {
                    pSWXMenu2.setMenuModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSWXMenuItem pSWXMenuItem3 : hashMap.values()) {
                        pSWXMenuItemService.removeTemp((IEntity)pSWXMenuItem3);
                    }
                }
                PSWXMenuService.this.createTempMajor((IEntity)pSWXMenu2);
            }
        });
    }

    @Override
    public void previewSave(PSWXMenu pSWXMenu) throws Exception {
        final PSWXMenu pSWXMenu2 = pSWXMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXMenuItem pSWXMenuItem2;
                PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService((String)PSWXMenuItemService.class.getCanonicalName(), (SessionFactory)PSWXMenuService.this.getSessionFactory());
                ArrayList<PSWXMenuItem> arrayList = pSWXMenuItemService.selectTempByPSWXMenu(pSWXMenu2);
                HashMap<String, PSWXMenuItem> hashMap = new HashMap<String, PSWXMenuItem>();
                for (PSWXMenuItem pSWXMenuItem2 : arrayList) {
                    hashMap.put(pSWXMenuItem2.getPSWXMenuItemId(), pSWXMenuItem2);
                }
                Object object = pSWXMenu2.getMenuModel();
                if (StringHelper.isNullOrEmpty((String)object)) {
                    object = WebContext.getCurrent().getPostValue("tbmodel");
                }
                if ((pSWXMenuItem2 = XmlNode.loadFromXML((String)object)) != null) {
                    PSWXMenuService.this.updatePSWXMenuItems(pSWXMenu2, null, (XmlNode)pSWXMenuItem2, hashMap);
                    pSWXMenu2.setMenuModel(XmlNode.export((XmlNode)pSWXMenuItem2));
                } else {
                    pSWXMenu2.setMenuModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSWXMenuItem pSWXMenuItem3 : hashMap.values()) {
                        pSWXMenuItemService.removeTemp((IEntity)pSWXMenuItem3);
                    }
                }
            }
        });
    }

    @Override
    public void getDraftWithModel(PSWXMenu pSWXMenu) throws Exception {
        this.getDraftTempMajor((IEntity)pSWXMenu);
        pSWXMenu.setMenuModel(this.getMenuModel(pSWXMenu));
    }

    @Override
    public void getDraftFromWithModel(PSWXMenu pSWXMenu) throws Exception {
        super.getDraftTempMajorFrom(pSWXMenu);
        pSWXMenu.setMenuModel(this.getMenuModel(pSWXMenu));
    }

    @Override
    protected void onBeforeCreate(PSWXMenu pSWXMenu) throws Exception {
        pSWXMenu.setMenuModel(null);
        super.onBeforeCreate(pSWXMenu);
    }

    @Override
    protected void onBeforeUpdate(PSWXMenu pSWXMenu) throws Exception {
        pSWXMenu.setMenuModel(null);
        super.onBeforeUpdate(pSWXMenu);
    }
}

