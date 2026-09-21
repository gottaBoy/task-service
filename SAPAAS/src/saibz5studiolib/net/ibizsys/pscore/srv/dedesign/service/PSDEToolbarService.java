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
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDETBItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDETBItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.util.PSModelFolderKeyHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEToolbarService
extends PSDEToolbarServiceBase {
    private static final Log log = LogFactory.getLog(PSDEToolbarService.class);

    @Override
    public void getWithModel(PSDEToolbar pSDEToolbar) throws Exception {
        if (!KeyValueHelper.isTempKey((String)pSDEToolbar.getPSDEToolbarId())) {
            this.getTempMajor(pSDEToolbar);
        } else {
            this.getTemp((IEntity)pSDEToolbar);
        }
        pSDEToolbar.setTBModel(this.getTBModel(pSDEToolbar));
    }

    protected String getTBModel(PSDEToolbar pSDEToolbar) throws Exception {
        PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService((String)PSDETBItemService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETBItem> arrayList = pSDETBItemService.selectTempByPSDEToolbar(pSDEToolbar, "ORDER BY ORDERVALUE");
        HashMap<String, XmlNode> hashMap = new HashMap<String, XmlNode>();
        for (PSDETBItem entityBase2 : arrayList) {
            XmlNode xmlNode = new XmlNode();
            xmlNode.setNodeName(entityBase2.getTBItemType());
            entityBase2.fillXmlNode(xmlNode, true);
            hashMap.put(entityBase2.getPSDETBItemId(), xmlNode);
        }
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName("DETOOLBAR");
        PSSystem pSSystem = pSDEToolbar.getPSSystem();
        xmlNode.setAttribute("PSSYSTEMID", pSSystem.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)pSSystem.getPSDevSlnSysId())) {
            xmlNode.setAttribute("PSDEVSLNSYSID", pSSystem.getPSDevSlnSysId());
            xmlNode.setAttribute("TASKSERVERURL", pSSystem.getPSDevCenterTS().getPSTaskServer().getServerUrl());
        } else {
            xmlNode.setAttribute("PSDEVSLNSYSID", "");
            xmlNode.setAttribute("TASKSERVERURL", "http://lionlau-w530:8000/SAEAM/");
        }
        xmlNode.setAttribute("PSDEID", pSDEToolbar.getPSDEId());
        xmlNode.setAttribute("PSDETOOLBARID", pSDEToolbar.getPSDEToolbarId());
        for (PSDETBItem pSDETBItem : arrayList) {
            XmlNode xmlNode2 = (XmlNode)hashMap.get(pSDETBItem.getPSDETBItemId());
            if (StringHelper.isNullOrEmpty((String)pSDETBItem.getPPSDETBItemId())) {
                xmlNode.addNode(xmlNode2);
                continue;
            }
            XmlNode xmlNode3 = (XmlNode)hashMap.get(pSDETBItem.getPPSDETBItemId());
            if (xmlNode3 != null) {
                xmlNode3.addNode(xmlNode2);
                continue;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7236\u5de5\u5177\u680f\u6210\u5458[%1$s], \u5f53\u524d[%2$s]", (Object)pSDETBItem.getPPSDETBItemId(), (Object)pSDETBItem.getPSDETBItemName()));
        }
        return XmlNode.export((XmlNode)xmlNode);
    }

    @Override
    public void updateWithModel(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETBItem pSDETBItem2;
                PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService((String)PSDETBItemService.class.getCanonicalName(), (SessionFactory)PSDEToolbarService.this.getSessionFactory());
                ArrayList<PSDETBItem> arrayList = pSDETBItemService.selectTempByPSDEToolbar(pSDEToolbar2);
                HashMap<String, PSDETBItem> hashMap = new HashMap<String, PSDETBItem>();
                for (PSDETBItem pSDETBItem2 : arrayList) {
                    hashMap.put(pSDETBItem2.getPSDETBItemId(), pSDETBItem2);
                }
                String string = pSDEToolbar2.getTBModel();
                pSDETBItem2 = XmlNode.loadFromXML((String)string);
                if (pSDETBItem2 != null) {
                    pSDETBItem2.setAttribute("PSDEID", pSDEToolbar2.getPSDEId());
                    pSDETBItem2.setAttribute("PSDETOOLBARID", pSDEToolbar2.getPSDEToolbarId());
                    PSDEToolbarService.this.updatePSDETBItems(pSDEToolbar2, null, (XmlNode)pSDETBItem2, hashMap);
                    pSDEToolbar2.setTBModel(XmlNode.export((XmlNode)pSDETBItem2));
                } else {
                    pSDEToolbar2.setTBModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSDETBItem pSDETBItem3 : hashMap.values()) {
                        pSDETBItemService.removeTemp((IEntity)pSDETBItem3);
                    }
                }
                PSDEToolbarService.this.updateTempMajor(pSDEToolbar2);
            }
        });
    }

    protected void updatePSDETBItems(PSDEToolbar pSDEToolbar, PSDETBItem pSDETBItem, XmlNode xmlNode, HashMap<String, PSDETBItem> hashMap) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService((String)PSDETBItemService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            int n = 0;
            while (iterator.hasNext()) {
                PSDETBItem pSDETBItem2;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                String string = xmlNode2.getAttribute("PSDETBITEMID", "");
                if (StringHelper.isNullOrEmpty((String)string) || (pSDETBItem2 = hashMap.remove(string)) == null) continue;
                ++n;
                boolean bl = false;
                if (StringHelper.compare((String)pSDETBItem2.getPSDEToolbarId(), (String)pSDEToolbar.getPSDEToolbarId(), (boolean)false) != 0) {
                    pSDETBItem2.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
                    bl = true;
                }
                if (StringHelper.compare((String)pSDETBItem2.getPSDEToolbarName(), (String)pSDEToolbar.getPSDEToolbarName(), (boolean)false) != 0) {
                    pSDETBItem2.setPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
                    bl = true;
                }
                if (pSDETBItem != null) {
                    if (StringHelper.compare((String)pSDETBItem2.getPPSDETBItemId(), (String)pSDETBItem.getPSDETBItemId(), (boolean)false) != 0) {
                        pSDETBItem2.setPPSDETBItemId(pSDETBItem.getPSDETBItemId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)pSDETBItem2.getPPSDETBItemName(), (String)pSDETBItem.getPSDETBItemName(), (boolean)false) != 0) {
                        pSDETBItem2.setPPSDETBItemName(pSDETBItem.getPSDETBItemName());
                        bl = true;
                    }
                }
                if (pSDETBItem2.getOrderValue() == null || pSDETBItem2.getOrderValue() != n) {
                    pSDETBItem2.setOrderValue(n);
                    bl = true;
                }
                if (bl) {
                    pSDETBItemService.updateTemp((IEntity)pSDETBItem2);
                }
                xmlNode2.resetAttributes();
                pSDETBItem2.fillXmlNode(xmlNode2, false);
                arrayList.add(xmlNode2);
                this.updatePSDETBItems(pSDEToolbar, pSDETBItem2, xmlNode2, hashMap);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
        }
    }

    @Override
    public void createWithModel(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        log.debug((Object)"\u5f00\u59cb[createWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETBItem pSDETBItem2;
                PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService((String)PSDETBItemService.class.getCanonicalName(), (SessionFactory)PSDEToolbarService.this.getSessionFactory());
                ArrayList<PSDETBItem> arrayList = pSDETBItemService.selectTempByPSDEToolbar(pSDEToolbar2);
                HashMap<String, PSDETBItem> hashMap = new HashMap<String, PSDETBItem>();
                for (PSDETBItem pSDETBItem2 : arrayList) {
                    hashMap.put(pSDETBItem2.getPSDETBItemId(), pSDETBItem2);
                }
                String string = pSDEToolbar2.getTBModel();
                pSDETBItem2 = XmlNode.loadFromXML((String)string);
                if (pSDETBItem2 != null) {
                    pSDETBItem2.setAttribute("PSDEID", pSDEToolbar2.getPSDEId());
                    pSDETBItem2.setAttribute("PSDETOOLBARID", pSDEToolbar2.getPSDEToolbarId());
                    PSDEToolbarService.this.updatePSDETBItems(pSDEToolbar2, null, (XmlNode)pSDETBItem2, hashMap);
                    pSDEToolbar2.setTBModel(XmlNode.export((XmlNode)pSDETBItem2));
                } else {
                    pSDEToolbar2.setTBModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSDETBItem pSDETBItem3 : hashMap.values()) {
                        pSDETBItemService.removeTemp((IEntity)pSDETBItem3);
                    }
                }
                PSDEToolbarService.this.createTempMajor((IEntity)pSDEToolbar2);
            }
        });
    }

    @Override
    public void previewSave(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        log.debug((Object)"\u5f00\u59cb[previewSave]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETBItem pSDETBItem2;
                PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService((String)PSDETBItemService.class.getCanonicalName(), (SessionFactory)PSDEToolbarService.this.getSessionFactory());
                ArrayList<PSDETBItem> arrayList = pSDETBItemService.selectTempByPSDEToolbar(pSDEToolbar2);
                HashMap<String, PSDETBItem> hashMap = new HashMap<String, PSDETBItem>();
                for (PSDETBItem pSDETBItem2 : arrayList) {
                    hashMap.put(pSDETBItem2.getPSDETBItemId(), pSDETBItem2);
                }
                Object object = pSDEToolbar2.getTBModel();
                if (StringHelper.isNullOrEmpty((String)object)) {
                    object = WebContext.getCurrent().getPostValue("tbmodel");
                }
                if ((pSDETBItem2 = XmlNode.loadFromXML((String)object)) != null) {
                    PSDEToolbarService.this.updatePSDETBItems(pSDEToolbar2, null, (XmlNode)pSDETBItem2, hashMap);
                    pSDEToolbar2.setTBModel(XmlNode.export((XmlNode)pSDETBItem2));
                } else {
                    pSDEToolbar2.setTBModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSDETBItem pSDETBItem3 : hashMap.values()) {
                        pSDETBItemService.removeTemp((IEntity)pSDETBItem3);
                    }
                }
            }
        });
    }

    @Override
    public void getDraftWithModel(PSDEToolbar pSDEToolbar) throws Exception {
        this.getDraftTempMajor((IEntity)pSDEToolbar);
        pSDEToolbar.setTBModel(this.getTBModel(pSDEToolbar));
    }

    @Override
    public void getDraftFromWithModel(PSDEToolbar pSDEToolbar) throws Exception {
        this.getDraftTempMajorFrom(pSDEToolbar);
        pSDEToolbar.setTBModel(this.getTBModel(pSDEToolbar));
    }

    @Override
    protected void onBeforeCreate(PSDEToolbar pSDEToolbar) throws Exception {
        pSDEToolbar.setTBModel(null);
        super.onBeforeCreate(pSDEToolbar);
    }

    @Override
    protected void onBeforeUpdate(PSDEToolbar pSDEToolbar) throws Exception {
        pSDEToolbar.setTBModel(null);
        super.onBeforeUpdate(pSDEToolbar);
    }

    @Override
    protected void onFillParentInfo_PSDE(PSDEToolbar pSDEToolbar, PSDataEntity pSDataEntity) throws Exception {
        super.onFillParentInfo_PSDE(pSDEToolbar, pSDataEntity);
        pSDEToolbar.setPSSystemId(pSDataEntity.getPSSystemId());
        pSDEToolbar.setPSSystemName(pSDataEntity.getPSSystemName());
    }

    @Override
    public void getDraftTempMajorFrom(PSDEToolbar pSDEToolbar) throws Exception {
        Object object = EntityBase.getOriginKey((IEntity)pSDEToolbar);
        if (StringHelper.isNullOrEmpty((Object)object)) {
            object = pSDEToolbar.getPSDEToolbarId();
        }
        super.getDraftTempMajorFrom(pSDEToolbar);
        if (!StringHelper.isNullOrEmpty((Object)object)) {
            PSDEToolbar pSDEToolbar2 = new PSDEToolbar();
            pSDEToolbar2.setSessionFactory(this.getSessionFactory());
            pSDEToolbar2.setPSDEToolbarId((String)object);
            if (!pSDEToolbar2.get(true)) {
                return;
            }
            int n = 2;
            while (true) {
                PSDEToolbar pSDEToolbar3 = new PSDEToolbar();
                pSDEToolbar3.setSessionFactory(this.getSessionFactory());
                if (StringHelper.isNullOrEmpty((String)pSDEToolbar2.getPSDEId())) {
                    pSDEToolbar3.setPSDEId(pSDEToolbar2.getPSDEId());
                }
                pSDEToolbar3.setPSDEToolbarName(StringHelper.format((String)"%1$s(%2$s)", (Object)pSDEToolbar2.getPSDEToolbarName(), (Object)n));
                if (!pSDEToolbar3.select(true)) {
                    pSDEToolbar.setPSDEToolbarName(pSDEToolbar3.getPSDEToolbarName());
                    break;
                }
                ++n;
            }
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDEToolbar pSDEToolbar, PSSystem pSSystem) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDEToolbar.getPSDEId())) {
            return PSModelFolderKeyHelper.getModelKey((IEntity)pSDEToolbar, pSSystem, "PSDETOOLBAR_SYS", "", this.getSessionFactory());
        }
        return super.getEntityFolderKeyValue(pSDEToolbar, pSSystem);
    }
}

