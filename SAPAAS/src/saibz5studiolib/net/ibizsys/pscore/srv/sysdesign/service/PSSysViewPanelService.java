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
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysViewPanelService
extends PSSysViewPanelServiceBase {
    private static final Log log = LogFactory.getLog(PSSysViewPanelService.class);

    @Override
    public void getWithModel(PSSysViewPanel pSSysViewPanel) throws Exception {
        if (!KeyValueHelper.isTempKey((String)pSSysViewPanel.getPSSysViewPanelId())) {
            this.getTempMajor(pSSysViewPanel);
        } else {
            this.getTemp(pSSysViewPanel);
        }
        pSSysViewPanel.setPanelModel(this.getPanelModel(pSSysViewPanel));
    }

    protected String getPanelModel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService((String)PSSysViewPanelItemService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        final ArrayList<PSSysViewPanelItem> arrayList = pSSysViewPanelItemService.selectTempByPSSysViewPanel(pSSysViewPanel, "ORDER BY ORDERVALUE");
        final HashMap hashMap = new HashMap();
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
                    pSSysViewPanelItemService.fillPreviewHtml(pSSysViewPanelItem);
                    XmlNode xmlNode = new XmlNode();
                    xmlNode.setNodeName(pSSysViewPanelItem.getItemType());
                    pSSysViewPanelItem.fillXmlNode(xmlNode, true);
                    hashMap.put(pSSysViewPanelItem.getPSSysViewPanelItemId(), xmlNode);
                }
            }
        }, false);
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName("SYSVIEWPANEL");
        PSSystem pSSystem = pSSysViewPanel.getPSSystem();
        xmlNode.setAttribute("PSSYSTEMID", pSSystem.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)pSSystem.getPSDevSlnSysId())) {
            xmlNode.setAttribute("PSDEVSLNSYSID", pSSystem.getPSDevSlnSysId());
            xmlNode.setAttribute("TASKSERVERURL", pSSystem.getPSDevCenterTS().getPSTaskServer().getServerUrl());
        } else {
            xmlNode.setAttribute("PSDEVSLNSYSID", "");
            xmlNode.setAttribute("TASKSERVERURL", "http://lionlau-w530:8000/SAEAM/");
        }
        xmlNode.setAttribute("PSDEID", pSSysViewPanel.getPSDEId());
        xmlNode.setAttribute("PSSYSVIEWPANELID", pSSysViewPanel.getPSSysViewPanelId());
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            XmlNode xmlNode2 = (XmlNode)hashMap.get(pSSysViewPanelItem.getPSSysViewPanelItemId());
            if (StringHelper.isNullOrEmpty((String)pSSysViewPanelItem.getPPSSysViewPanelItemId())) {
                xmlNode.addNode(xmlNode2);
                continue;
            }
            XmlNode xmlNode3 = (XmlNode)hashMap.get(pSSysViewPanelItem.getPPSSysViewPanelItemId());
            if (xmlNode3 != null) {
                xmlNode3.addNode(xmlNode2);
                continue;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7236\u89c6\u56fe\u9762\u677f\u9879[%1$s], \u5f53\u524d[%2$s]", (Object)pSSysViewPanelItem.getPPSSysViewPanelItemId(), (Object)pSSysViewPanelItem.getPSSysViewPanelItemName()));
        }
        return XmlNode.export((XmlNode)xmlNode);
    }

    @Override
    public void updateWithModel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService((String)PSSysViewPanelItemService.class.getCanonicalName(), (SessionFactory)PSSysViewPanelService.this.getSessionFactory());
                ArrayList<PSSysViewPanelItem> arrayList = pSSysViewPanelItemService.selectTempByPSSysViewPanel(pSSysViewPanel2);
                HashMap<String, PSSysViewPanelItem> hashMap = new HashMap<String, PSSysViewPanelItem>();
                for (PSSysViewPanelItem pSSysViewPanelItem2 : arrayList) {
                    hashMap.put(pSSysViewPanelItem2.getPSSysViewPanelItemId(), pSSysViewPanelItem2);
                }
                String string = pSSysViewPanel2.getPanelModel();
                XmlNode xmlNode = XmlNode.loadFromXML((String)string);
                if (xmlNode != null) {
                    xmlNode.setAttribute("PSDEID", pSSysViewPanel2.getPSDEId());
                    xmlNode.setAttribute("PSSYSVIEWPANELID", pSSysViewPanel2.getPSSysViewPanelId());
                    PSSysViewPanelService.this.updatePSSysViewPanelItems(pSSysViewPanel2, null, xmlNode, hashMap);
                    pSSysViewPanel2.setPanelModel(XmlNode.export(xmlNode));
                } else {
                    pSSysViewPanel2.setPanelModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSSysViewPanelItem pSSysViewPanelItem3 : hashMap.values()) {
                        pSSysViewPanelItemService.removeTemp(pSSysViewPanelItem3);
                    }
                }
                PSSysViewPanelService.this.updateTempMajor(pSSysViewPanel2);
            }
        });
    }

    protected void updatePSSysViewPanelItems(PSSysViewPanel pSSysViewPanel, PSSysViewPanelItem pSSysViewPanelItem, XmlNode xmlNode, HashMap<String, PSSysViewPanelItem> hashMap) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<XmlNode> arrayList = new ArrayList<XmlNode>();
            PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService((String)PSSysViewPanelItemService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            int n = 0;
            while (iterator.hasNext()) {
                PSSysViewPanelItem pSSysViewPanelItem2;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                String string = xmlNode2.getAttribute("PSSYSVIEWPANELITEMID", "");
                if (StringHelper.isNullOrEmpty((String)string) || (pSSysViewPanelItem2 = hashMap.remove(string)) == null) continue;
                ++n;
                boolean bl = false;
                if (StringHelper.compare((String)pSSysViewPanelItem2.getPSSysViewPanelId(), (String)pSSysViewPanel.getPSSysViewPanelId(), (boolean)false) != 0) {
                    pSSysViewPanelItem2.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
                    bl = true;
                }
                if (StringHelper.compare((String)pSSysViewPanelItem2.getPSSysViewPanelName(), (String)pSSysViewPanel.getPSSysViewPanelName(), (boolean)false) != 0) {
                    pSSysViewPanelItem2.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
                    bl = true;
                }
                if (pSSysViewPanelItem != null) {
                    if (StringHelper.compare((String)pSSysViewPanelItem2.getPPSSysViewPanelItemId(), (String)pSSysViewPanelItem.getPSSysViewPanelItemId(), (boolean)false) != 0) {
                        pSSysViewPanelItem2.setPPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)pSSysViewPanelItem2.getPPSSysViewPanelItemName(), (String)pSSysViewPanelItem.getPSSysViewPanelItemName(), (boolean)false) != 0) {
                        pSSysViewPanelItem2.setPPSSysViewPanelItemName(pSSysViewPanelItem.getPSSysViewPanelItemName());
                        bl = true;
                    }
                }
                if (pSSysViewPanelItem2.getOrderValue() == null || pSSysViewPanelItem2.getOrderValue() != n) {
                    pSSysViewPanelItem2.setOrderValue(n);
                    bl = true;
                }
                if (bl) {
                    pSSysViewPanelItemService.updateTemp(pSSysViewPanelItem2);
                }
                xmlNode2.resetAttributes();
                pSSysViewPanelItem2.fillXmlNode(xmlNode2, false);
                arrayList.add(xmlNode2);
                this.updatePSSysViewPanelItems(pSSysViewPanel, pSSysViewPanelItem2, xmlNode2, hashMap);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
        }
    }

    @Override
    public void createWithModel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        log.debug((Object)"\u5f00\u59cb[createWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService((String)PSSysViewPanelItemService.class.getCanonicalName(), (SessionFactory)PSSysViewPanelService.this.getSessionFactory());
                ArrayList<PSSysViewPanelItem> arrayList = pSSysViewPanelItemService.selectTempByPSSysViewPanel(pSSysViewPanel2);
                HashMap<String, PSSysViewPanelItem> hashMap = new HashMap<String, PSSysViewPanelItem>();
                for (PSSysViewPanelItem pSSysViewPanelItem2 : arrayList) {
                    hashMap.put(pSSysViewPanelItem2.getPSSysViewPanelItemId(), pSSysViewPanelItem2);
                }
                String string = pSSysViewPanel2.getPanelModel();
                XmlNode xmlNode = XmlNode.loadFromXML((String)string);
                if (xmlNode != null) {
                    xmlNode.setAttribute("PSDEID", pSSysViewPanel2.getPSDEId());
                    xmlNode.setAttribute("PSSYSVIEWPANELID", pSSysViewPanel2.getPSSysViewPanelId());
                    PSSysViewPanelService.this.updatePSSysViewPanelItems(pSSysViewPanel2, null, xmlNode, hashMap);
                    pSSysViewPanel2.setPanelModel(XmlNode.export(xmlNode));
                } else {
                    pSSysViewPanel2.setPanelModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSSysViewPanelItem pSSysViewPanelItem3 : hashMap.values()) {
                        pSSysViewPanelItemService.removeTemp(pSSysViewPanelItem3);
                    }
                }
                PSSysViewPanelService.this.createTempMajor(pSSysViewPanel2);
            }
        });
    }

    @Override
    public void previewSave(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        log.debug((Object)"\u5f00\u59cb[previewSave]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService((String)PSSysViewPanelItemService.class.getCanonicalName(), (SessionFactory)PSSysViewPanelService.this.getSessionFactory());
                ArrayList<PSSysViewPanelItem> arrayList = pSSysViewPanelItemService.selectTempByPSSysViewPanel(pSSysViewPanel2);
                HashMap<String, PSSysViewPanelItem> hashMap = new HashMap<String, PSSysViewPanelItem>();
                for (PSSysViewPanelItem pSSysViewPanelItem2 : arrayList) {
                    hashMap.put(pSSysViewPanelItem2.getPSSysViewPanelItemId(), pSSysViewPanelItem2);
                }
                Object object = pSSysViewPanel2.getPanelModel();
                if (StringHelper.isNullOrEmpty((String)object)) {
                    object = WebContext.getCurrent().getPostValue("panelmodel");
                }
                XmlNode xmlNode = XmlNode.loadFromXML((String)object);
                if (xmlNode != null) {
                    PSSysViewPanelService.this.updatePSSysViewPanelItems(pSSysViewPanel2, null, xmlNode, hashMap);
                    pSSysViewPanel2.setPanelModel(XmlNode.export(xmlNode));
                } else {
                    pSSysViewPanel2.setPanelModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSSysViewPanelItem pSSysViewPanelItem3 : hashMap.values()) {
                        pSSysViewPanelItemService.removeTemp(pSSysViewPanelItem3);
                    }
                }
            }
        });
    }

    @Override
    public void getDraftWithModel(PSSysViewPanel pSSysViewPanel) throws Exception {
        this.getDraftTempMajor(pSSysViewPanel);
        pSSysViewPanel.setPanelModel(this.getPanelModel(pSSysViewPanel));
    }

    @Override
    public void getDraftFromWithModel(PSSysViewPanel pSSysViewPanel) throws Exception {
        super.getDraftTempMajorFrom(pSSysViewPanel);
        pSSysViewPanel.setPanelModel(this.getPanelModel(pSSysViewPanel));
    }

    @Override
    protected void onBeforeCreate(PSSysViewPanel pSSysViewPanel) throws Exception {
        pSSysViewPanel.setPanelModel(null);
        super.onBeforeCreate(pSSysViewPanel);
    }

    @Override
    protected void onBeforeUpdate(PSSysViewPanel pSSysViewPanel) throws Exception {
        pSSysViewPanel.setPanelModel(null);
        super.onBeforeUpdate(pSSysViewPanel);
    }
}

