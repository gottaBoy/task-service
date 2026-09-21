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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBPart;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDashboard;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBPartService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysDashboardService
extends PSSysDashboardServiceBase {
    public static final String XMLNODE_SYSDASHBOARD = "SYSDASHBOARD";
    private static final Log log = LogFactory.getLog(PSSysDashboardService.class);

    @Override
    public void getWithModel(PSSysDashboard pSSysDashboard) throws Exception {
        if (!KeyValueHelper.isTempKey((String)pSSysDashboard.getPSSysDashboardId())) {
            this.getTempMajor(pSSysDashboard);
        } else {
            this.getTemp((IEntity)pSSysDashboard);
        }
        pSSysDashboard.setDBModel(this.getDashboardModel(pSSysDashboard));
    }

    protected String getDashboardModel(PSSysDashboard pSSysDashboard) throws Exception {
        PSSysDBPartService pSSysDBPartService = (PSSysDBPartService)ServiceGlobal.getService((String)PSSysDBPartService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysDBPart> arrayList = pSSysDBPartService.selectTempByPSSysDashboard(pSSysDashboard, "ORDER BY ORDERVALUE");
        HashMap<String, XmlNode> hashMap = new HashMap<String, XmlNode>();
        for (PSSysDBPart entityBase2 : arrayList) {
            XmlNode xmlNode = new XmlNode();
            xmlNode.setNodeName(entityBase2.getDBPartType());
            entityBase2.fillXmlNode(xmlNode, true);
            hashMap.put(entityBase2.getPSSysDBPartId(), xmlNode);
        }
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_SYSDASHBOARD);
        PSSystem pSSystem = pSSysDashboard.getPSSystem();
        xmlNode.setAttribute("PSSYSTEMID", pSSystem.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)pSSystem.getPSDevSlnSysId())) {
            xmlNode.setAttribute("PSDEVSLNSYSID", pSSystem.getPSDevSlnSysId());
            xmlNode.setAttribute("TASKSERVERURL", pSSystem.getPSDevCenterTS().getPSTaskServer().getServerUrl());
        } else {
            xmlNode.setAttribute("PSDEVSLNSYSID", "");
            xmlNode.setAttribute("TASKSERVERURL", "http://lionlau-w530:8000/SAEAM/");
        }
        xmlNode.setAttribute("PSDEID", pSSysDashboard.getPSDEId());
        xmlNode.setAttribute("PSSYSDASHBOARDID", pSSysDashboard.getPSSysDashboardId());
        for (PSSysDBPart pSSysDBPart : arrayList) {
            XmlNode xmlNode2 = (XmlNode)hashMap.get(pSSysDBPart.getPSSysDBPartId());
            if (StringHelper.isNullOrEmpty((String)pSSysDBPart.getPPSSysDBPartId())) {
                xmlNode.addNode(xmlNode2);
                continue;
            }
            XmlNode xmlNode3 = (XmlNode)hashMap.get(pSSysDBPart.getPPSSysDBPartId());
            if (xmlNode3 != null) {
                xmlNode3.addNode(xmlNode2);
                continue;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7236\u6570\u636e\u770b\u677f\u6210\u5458[%1$s], \u5f53\u524d[%2$s]", (Object)pSSysDBPart.getPPSSysDBPartId(), (Object)pSSysDBPart.getPSSysDBPartName()));
        }
        return XmlNode.export((XmlNode)xmlNode);
    }

    @Override
    public void updateWithModel(PSSysDashboard pSSysDashboard) throws Exception {
        final PSSysDashboard pSSysDashboard2 = pSSysDashboard;
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBPart pSSysDBPart2;
                PSSysDBPartService pSSysDBPartService = (PSSysDBPartService)ServiceGlobal.getService((String)PSSysDBPartService.class.getCanonicalName(), (SessionFactory)PSSysDashboardService.this.getSessionFactory());
                ArrayList<PSSysDBPart> arrayList = pSSysDBPartService.selectTempByPSSysDashboard(pSSysDashboard2);
                HashMap<String, PSSysDBPart> hashMap = new HashMap<String, PSSysDBPart>();
                for (PSSysDBPart pSSysDBPart2 : arrayList) {
                    hashMap.put(pSSysDBPart2.getPSSysDBPartId(), pSSysDBPart2);
                }
                String string = pSSysDashboard2.getDBModel();
                pSSysDBPart2 = XmlNode.loadFromXML((String)string);
                if (pSSysDBPart2 != null) {
                    pSSysDBPart2.setAttribute("PSDEID", pSSysDashboard2.getPSDEId());
                    pSSysDBPart2.setAttribute("PSSYSDASHBOARDID", pSSysDashboard2.getPSSysDashboardId());
                    PSSysDashboardService.this.updatePSSysDBParts(pSSysDashboard2, null, (XmlNode)pSSysDBPart2, hashMap);
                    pSSysDashboard2.setDBModel(XmlNode.export((XmlNode)pSSysDBPart2));
                } else {
                    pSSysDashboard2.setDBModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSSysDBPart pSSysDBPart3 : hashMap.values()) {
                        pSSysDBPartService.removeTemp((IEntity)pSSysDBPart3);
                    }
                }
                PSSysDashboardService.this.updateTempMajor(pSSysDashboard2);
            }
        });
    }

    protected void updatePSSysDBParts(PSSysDashboard pSSysDashboard, PSSysDBPart pSSysDBPart, XmlNode xmlNode, HashMap<String, PSSysDBPart> hashMap) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            PSSysDBPartService pSSysDBPartService = (PSSysDBPartService)ServiceGlobal.getService((String)PSSysDBPartService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            int n = 0;
            while (iterator.hasNext()) {
                PSSysDBPart pSSysDBPart2;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                String string = xmlNode2.getAttribute("PSSYSDBPARTID", "");
                if (StringHelper.isNullOrEmpty((String)string) || (pSSysDBPart2 = hashMap.remove(string)) == null) continue;
                ++n;
                boolean bl = false;
                if (StringHelper.compare((String)pSSysDBPart2.getPSSysDashboardId(), (String)pSSysDashboard.getPSSysDashboardId(), (boolean)false) != 0) {
                    pSSysDBPart2.setPSSysDashboardId(pSSysDashboard.getPSSysDashboardId());
                    bl = true;
                }
                if (StringHelper.compare((String)pSSysDBPart2.getPSSysDashboardName(), (String)pSSysDashboard.getPSSysDashboardName(), (boolean)false) != 0) {
                    pSSysDBPart2.setPSSysDashboardName(pSSysDashboard.getPSSysDashboardName());
                    bl = true;
                }
                if (pSSysDBPart != null) {
                    if (StringHelper.compare((String)pSSysDBPart2.getPPSSysDBPartId(), (String)pSSysDBPart.getPSSysDBPartId(), (boolean)false) != 0) {
                        pSSysDBPart2.setPPSSysDBPartId(pSSysDBPart.getPSSysDBPartId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)pSSysDBPart2.getPPSSysDBPartName(), (String)pSSysDBPart.getPSSysDBPartName(), (boolean)false) != 0) {
                        pSSysDBPart2.setPPSSysDBPartName(pSSysDBPart.getPSSysDBPartName());
                        bl = true;
                    }
                }
                if (pSSysDBPart2.getOrderValue() == null || pSSysDBPart2.getOrderValue() != n) {
                    pSSysDBPart2.setOrderValue(n);
                    bl = true;
                }
                if (bl) {
                    pSSysDBPartService.updateTemp((IEntity)pSSysDBPart2);
                }
                xmlNode2.resetAttributes();
                pSSysDBPart2.fillXmlNode(xmlNode2, false);
                arrayList.add(xmlNode2);
                this.updatePSSysDBParts(pSSysDashboard, pSSysDBPart2, xmlNode2, hashMap);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
        }
    }

    @Override
    public void createWithModel(PSSysDashboard pSSysDashboard) throws Exception {
        final PSSysDashboard pSSysDashboard2 = pSSysDashboard;
        log.debug((Object)"\u5f00\u59cb[createWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBPart pSSysDBPart2;
                PSSysDBPartService pSSysDBPartService = (PSSysDBPartService)ServiceGlobal.getService((String)PSSysDBPartService.class.getCanonicalName(), (SessionFactory)PSSysDashboardService.this.getSessionFactory());
                ArrayList<PSSysDBPart> arrayList = pSSysDBPartService.selectTempByPSSysDashboard(pSSysDashboard2);
                HashMap<String, PSSysDBPart> hashMap = new HashMap<String, PSSysDBPart>();
                for (PSSysDBPart pSSysDBPart2 : arrayList) {
                    hashMap.put(pSSysDBPart2.getPSSysDBPartId(), pSSysDBPart2);
                }
                String string = pSSysDashboard2.getDBModel();
                pSSysDBPart2 = XmlNode.loadFromXML((String)string);
                if (pSSysDBPart2 != null) {
                    pSSysDBPart2.setAttribute("PSDEID", pSSysDashboard2.getPSDEId());
                    pSSysDBPart2.setAttribute("PSSYSDASHBOARDID", pSSysDashboard2.getPSSysDashboardId());
                    PSSysDashboardService.this.updatePSSysDBParts(pSSysDashboard2, null, (XmlNode)pSSysDBPart2, hashMap);
                    pSSysDashboard2.setDBModel(XmlNode.export((XmlNode)pSSysDBPart2));
                } else {
                    pSSysDashboard2.setDBModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSSysDBPart pSSysDBPart3 : hashMap.values()) {
                        pSSysDBPartService.removeTemp((IEntity)pSSysDBPart3);
                    }
                }
                PSSysDashboardService.this.createTempMajor((IEntity)pSSysDashboard2);
            }
        });
    }

    @Override
    public void previewSave(PSSysDashboard pSSysDashboard) throws Exception {
        final PSSysDashboard pSSysDashboard2 = pSSysDashboard;
        log.debug((Object)"\u5f00\u59cb[previewSave]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBPart pSSysDBPart2;
                PSSysDBPartService pSSysDBPartService = (PSSysDBPartService)ServiceGlobal.getService((String)PSSysDBPartService.class.getCanonicalName(), (SessionFactory)PSSysDashboardService.this.getSessionFactory());
                ArrayList<PSSysDBPart> arrayList = pSSysDBPartService.selectTempByPSSysDashboard(pSSysDashboard2);
                HashMap<String, PSSysDBPart> hashMap = new HashMap<String, PSSysDBPart>();
                for (PSSysDBPart pSSysDBPart2 : arrayList) {
                    hashMap.put(pSSysDBPart2.getPSSysDBPartId(), pSSysDBPart2);
                }
                Object object = pSSysDashboard2.getDBModel();
                if (StringHelper.isNullOrEmpty((String)object)) {
                    object = WebContext.getCurrent().getPostValue("dbmodel");
                }
                if ((pSSysDBPart2 = XmlNode.loadFromXML((String)object)) != null) {
                    PSSysDashboardService.this.updatePSSysDBParts(pSSysDashboard2, null, (XmlNode)pSSysDBPart2, hashMap);
                    pSSysDashboard2.setDBModel(XmlNode.export((XmlNode)pSSysDBPart2));
                } else {
                    pSSysDashboard2.setDBModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSSysDBPart pSSysDBPart3 : hashMap.values()) {
                        pSSysDBPartService.removeTemp((IEntity)pSSysDBPart3);
                    }
                }
            }
        });
    }

    @Override
    public void getDraftWithModel(PSSysDashboard pSSysDashboard) throws Exception {
        this.getDraftTempMajor((IEntity)pSSysDashboard);
        pSSysDashboard.setDBModel(this.getDashboardModel(pSSysDashboard));
    }

    @Override
    protected void onBeforeCreate(PSSysDashboard pSSysDashboard) throws Exception {
        pSSysDashboard.setDBModel(null);
        super.onBeforeCreate(pSSysDashboard);
    }

    @Override
    protected void onBeforeUpdate(PSSysDashboard pSSysDashboard) throws Exception {
        pSSysDashboard.setDBModel(null);
        super.onBeforeUpdate(pSSysDashboard);
    }

    @Override
    public void getDraftFromWithModel(PSSysDashboard pSSysDashboard) throws Exception {
        this.getDraftTempMajorFrom(pSSysDashboard);
        pSSysDashboard.setDBModel(this.getDashboardModel(pSSysDashboard));
    }

    @Override
    protected void onAfterUpdate(PSSysDashboard pSSysDashboard) throws Exception {
        super.onAfterUpdate(pSSysDashboard);
    }

    @Override
    public void getDraftTempMajorFrom(PSSysDashboard pSSysDashboard) throws Exception {
        Object object = EntityBase.getOriginKey((IEntity)pSSysDashboard);
        if (StringHelper.isNullOrEmpty((Object)object)) {
            object = pSSysDashboard.getPSSysDashboardId();
        }
        super.getDraftTempMajorFrom(pSSysDashboard);
        if (!StringHelper.isNullOrEmpty((Object)object)) {
            PSSysDashboard pSSysDashboard2 = new PSSysDashboard();
            pSSysDashboard2.setSessionFactory(this.getSessionFactory());
            pSSysDashboard2.setPSSysDashboardId((String)object);
            if (!pSSysDashboard2.get(true)) {
                return;
            }
            int n = 2;
            while (true) {
                PSSysDashboard pSSysDashboard3 = new PSSysDashboard();
                pSSysDashboard3.setSessionFactory(this.getSessionFactory());
                pSSysDashboard3.setPSDEId(pSSysDashboard2.getPSDEId());
                pSSysDashboard3.setPSSysDashboardName(StringHelper.format((String)"%1$s(%2$s)", (Object)pSSysDashboard2.getPSSysDashboardName(), (Object)n));
                if (!pSSysDashboard3.select(true)) {
                    pSSysDashboard.setPSSysDashboardName(pSSysDashboard3.getPSSysDashboardName());
                    break;
                }
                ++n;
            }
        }
    }
}

