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
package net.ibizsys.pscore.srv.appdesign.service;

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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPVPart;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortalView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPVPartService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPortalViewServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppPortalViewService
extends PSAppPortalViewServiceBase {
    public static final String XMLNODE_APPPORTALVIEW = "APPPORTALVIEW";
    private static final Log log = LogFactory.getLog(PSAppPortalViewService.class);

    @Override
    public void getWithModel(PSAppPortalView pSAppPortalView) throws Exception {
        if (!KeyValueHelper.isTempKey((String)pSAppPortalView.getPSAppPortalViewId())) {
            this.getTempMajor(pSAppPortalView);
        } else {
            this.getTemp((IEntity)pSAppPortalView);
        }
        pSAppPortalView.setDBModel(this.getDashboardModel(pSAppPortalView));
    }

    protected String getDashboardModel(PSAppPortalView pSAppPortalView) throws Exception {
        PSAppPVPartService pSAppPVPartService = (PSAppPVPartService)ServiceGlobal.getService((String)PSAppPVPartService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppPVPart> arrayList = pSAppPVPartService.selectTempByPSAppPortalView(pSAppPortalView, "ORDER BY ORDERVALUE");
        HashMap<String, XmlNode> hashMap = new HashMap<String, XmlNode>();
        for (PSAppPVPart entityBase2 : arrayList) {
            XmlNode xmlNode = new XmlNode();
            xmlNode.setNodeName(entityBase2.getPVPartType());
            entityBase2.fillXmlNode(xmlNode, true);
            hashMap.put(entityBase2.getPSAppPVPartId(), xmlNode);
        }
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_APPPORTALVIEW);
        PSSystem pSSystem = pSAppPortalView.getPSSysApp().getPSSystem();
        xmlNode.setAttribute("PSSYSTEMID", pSSystem.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)pSSystem.getPSDevSlnSysId())) {
            xmlNode.setAttribute("PSDEVSLNSYSID", pSSystem.getPSDevSlnSysId());
            xmlNode.setAttribute("TASKSERVERURL", pSSystem.getPSDevCenterTS().getPSTaskServer().getServerUrl());
        } else {
            xmlNode.setAttribute("PSDEVSLNSYSID", "");
            xmlNode.setAttribute("TASKSERVERURL", "http://lionlau-w530:8000/SAEAM/");
        }
        xmlNode.setAttribute("PSAPPPORTALVIEWID", pSAppPortalView.getPSAppPortalViewId());
        for (PSAppPVPart pSAppPVPart : arrayList) {
            XmlNode xmlNode2 = (XmlNode)hashMap.get(pSAppPVPart.getPSAppPVPartId());
            if (StringHelper.isNullOrEmpty((String)pSAppPVPart.getPPSAppPVPartId())) {
                xmlNode.addNode(xmlNode2);
                continue;
            }
            XmlNode xmlNode3 = (XmlNode)hashMap.get(pSAppPVPart.getPPSAppPVPartId());
            if (xmlNode3 != null) {
                xmlNode3.addNode(xmlNode2);
                continue;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7236\u5e94\u7528\u95e8\u6237\u89c6\u56fe\u6210\u5458[%1$s], \u5f53\u524d[%2$s]", (Object)pSAppPVPart.getPPSAppPVPartId(), (Object)pSAppPVPart.getPSAppPVPartName()));
        }
        return XmlNode.export((XmlNode)xmlNode);
    }

    @Override
    public void updateWithModel(PSAppPortalView pSAppPortalView) throws Exception {
        final PSAppPortalView pSAppPortalView2 = pSAppPortalView;
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppPVPart pSAppPVPart2;
                PSAppPVPartService pSAppPVPartService = (PSAppPVPartService)ServiceGlobal.getService((String)PSAppPVPartService.class.getCanonicalName(), (SessionFactory)PSAppPortalViewService.this.getSessionFactory());
                ArrayList<PSAppPVPart> arrayList = pSAppPVPartService.selectTempByPSAppPortalView(pSAppPortalView2);
                HashMap<String, PSAppPVPart> hashMap = new HashMap<String, PSAppPVPart>();
                for (PSAppPVPart pSAppPVPart2 : arrayList) {
                    hashMap.put(pSAppPVPart2.getPSAppPVPartId(), pSAppPVPart2);
                }
                String string = pSAppPortalView2.getDBModel();
                pSAppPVPart2 = XmlNode.loadFromXML((String)string);
                if (pSAppPVPart2 != null) {
                    pSAppPVPart2.setAttribute("PSAPPPORTALVIEWID", pSAppPortalView2.getPSAppPortalViewId());
                    PSAppPortalViewService.this.updatePSAppPVParts(pSAppPortalView2, null, (XmlNode)pSAppPVPart2, hashMap);
                    pSAppPortalView2.setDBModel(XmlNode.export((XmlNode)pSAppPVPart2));
                } else {
                    pSAppPortalView2.setDBModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSAppPVPart pSAppPVPart3 : hashMap.values()) {
                        pSAppPVPartService.removeTemp((IEntity)pSAppPVPart3);
                    }
                }
                PSAppPortalViewService.this.updateTempMajor(pSAppPortalView2);
            }
        });
    }

    protected void updatePSAppPVParts(PSAppPortalView pSAppPortalView, PSAppPVPart pSAppPVPart, XmlNode xmlNode, HashMap<String, PSAppPVPart> hashMap) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            PSAppPVPartService pSAppPVPartService = (PSAppPVPartService)ServiceGlobal.getService((String)PSAppPVPartService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            int n = 0;
            while (iterator.hasNext()) {
                PSAppPVPart pSAppPVPart2;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                String string = xmlNode2.getAttribute("PSAPPPVPARTID", "");
                if (StringHelper.isNullOrEmpty((String)string) || (pSAppPVPart2 = hashMap.remove(string)) == null) continue;
                ++n;
                boolean bl = false;
                if (StringHelper.compare((String)pSAppPVPart2.getPSAppPortalViewId(), (String)pSAppPortalView.getPSAppPortalViewId(), (boolean)false) != 0) {
                    pSAppPVPart2.setPSAppPortalViewId(pSAppPortalView.getPSAppPortalViewId());
                    bl = true;
                }
                if (StringHelper.compare((String)pSAppPVPart2.getPSAppPortalViewName(), (String)pSAppPortalView.getPSAppPortalViewName(), (boolean)false) != 0) {
                    pSAppPVPart2.setPSAppPortalViewName(pSAppPortalView.getPSAppPortalViewName());
                    bl = true;
                }
                if (pSAppPVPart != null) {
                    if (StringHelper.compare((String)pSAppPVPart2.getPPSAppPVPartId(), (String)pSAppPVPart.getPSAppPVPartId(), (boolean)false) != 0) {
                        pSAppPVPart2.setPPSAppPVPartId(pSAppPVPart.getPSAppPVPartId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)pSAppPVPart2.getPPSAppPVPartName(), (String)pSAppPVPart.getPSAppPVPartName(), (boolean)false) != 0) {
                        pSAppPVPart2.setPPSAppPVPartName(pSAppPVPart.getPSAppPVPartName());
                        bl = true;
                    }
                }
                if (pSAppPVPart2.getOrderValue() == null || pSAppPVPart2.getOrderValue() != n) {
                    pSAppPVPart2.setOrderValue(n);
                    bl = true;
                }
                if (bl) {
                    pSAppPVPartService.updateTemp((IEntity)pSAppPVPart2);
                }
                xmlNode2.resetAttributes();
                pSAppPVPart2.fillXmlNode(xmlNode2, false);
                arrayList.add(xmlNode2);
                this.updatePSAppPVParts(pSAppPortalView, pSAppPVPart2, xmlNode2, hashMap);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
        }
    }

    @Override
    public void createWithModel(PSAppPortalView pSAppPortalView) throws Exception {
        final PSAppPortalView pSAppPortalView2 = pSAppPortalView;
        log.debug((Object)"\u5f00\u59cb[createWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppPVPart pSAppPVPart2;
                PSAppPVPartService pSAppPVPartService = (PSAppPVPartService)ServiceGlobal.getService((String)PSAppPVPartService.class.getCanonicalName(), (SessionFactory)PSAppPortalViewService.this.getSessionFactory());
                ArrayList<PSAppPVPart> arrayList = pSAppPVPartService.selectTempByPSAppPortalView(pSAppPortalView2);
                HashMap<String, PSAppPVPart> hashMap = new HashMap<String, PSAppPVPart>();
                for (PSAppPVPart pSAppPVPart2 : arrayList) {
                    hashMap.put(pSAppPVPart2.getPSAppPVPartId(), pSAppPVPart2);
                }
                String string = pSAppPortalView2.getDBModel();
                pSAppPVPart2 = XmlNode.loadFromXML((String)string);
                if (pSAppPVPart2 != null) {
                    pSAppPVPart2.setAttribute("PSAPPPORTALVIEWID", pSAppPortalView2.getPSAppPortalViewId());
                    PSAppPortalViewService.this.updatePSAppPVParts(pSAppPortalView2, null, (XmlNode)pSAppPVPart2, hashMap);
                    pSAppPortalView2.setDBModel(XmlNode.export((XmlNode)pSAppPVPart2));
                } else {
                    pSAppPortalView2.setDBModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSAppPVPart pSAppPVPart3 : hashMap.values()) {
                        pSAppPVPartService.removeTemp((IEntity)pSAppPVPart3);
                    }
                }
                PSAppPortalViewService.this.createTempMajor((IEntity)pSAppPortalView2);
            }
        });
    }

    @Override
    public void previewSave(PSAppPortalView pSAppPortalView) throws Exception {
        final PSAppPortalView pSAppPortalView2 = pSAppPortalView;
        log.debug((Object)"\u5f00\u59cb[previewSave]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppPVPart pSAppPVPart2;
                PSAppPVPartService pSAppPVPartService = (PSAppPVPartService)ServiceGlobal.getService((String)PSAppPVPartService.class.getCanonicalName(), (SessionFactory)PSAppPortalViewService.this.getSessionFactory());
                ArrayList<PSAppPVPart> arrayList = pSAppPVPartService.selectTempByPSAppPortalView(pSAppPortalView2);
                HashMap<String, PSAppPVPart> hashMap = new HashMap<String, PSAppPVPart>();
                for (PSAppPVPart pSAppPVPart2 : arrayList) {
                    hashMap.put(pSAppPVPart2.getPSAppPVPartId(), pSAppPVPart2);
                }
                Object object = pSAppPortalView2.getDBModel();
                if (StringHelper.isNullOrEmpty((String)object)) {
                    object = WebContext.getCurrent().getPostValue("dbmodel");
                }
                if ((pSAppPVPart2 = XmlNode.loadFromXML((String)object)) != null) {
                    PSAppPortalViewService.this.updatePSAppPVParts(pSAppPortalView2, null, (XmlNode)pSAppPVPart2, hashMap);
                    pSAppPortalView2.setDBModel(XmlNode.export((XmlNode)pSAppPVPart2));
                } else {
                    pSAppPortalView2.setDBModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSAppPVPart pSAppPVPart3 : hashMap.values()) {
                        pSAppPVPartService.removeTemp((IEntity)pSAppPVPart3);
                    }
                }
            }
        });
    }

    @Override
    public void getDraftWithModel(PSAppPortalView pSAppPortalView) throws Exception {
        this.getDraftTempMajor((IEntity)pSAppPortalView);
        this.fillPSAppPortalViewDefaultName(pSAppPortalView);
        pSAppPortalView.setDBModel(this.getDashboardModel(pSAppPortalView));
    }

    @Override
    protected void onBeforeCreate(PSAppPortalView pSAppPortalView) throws Exception {
        pSAppPortalView.setDBModel(null);
        super.onBeforeCreate(pSAppPortalView);
    }

    @Override
    protected void onBeforeUpdate(PSAppPortalView pSAppPortalView) throws Exception {
        pSAppPortalView.setDBModel(null);
        super.onBeforeUpdate(pSAppPortalView);
    }

    @Override
    public void getDraftFromWithModel(PSAppPortalView pSAppPortalView) throws Exception {
        this.getDraftTempMajorFrom(pSAppPortalView);
        pSAppPortalView.resetPSAppPortalViewName();
        this.fillPSAppPortalViewDefaultName(pSAppPortalView);
        pSAppPortalView.setDBModel(this.getDashboardModel(pSAppPortalView));
    }

    @Override
    protected void onAfterUpdate(PSAppPortalView pSAppPortalView) throws Exception {
        super.onAfterUpdate(pSAppPortalView);
    }

    protected void fillPSAppPortalViewDefaultName(PSAppPortalView pSAppPortalView) throws Exception {
        PSAppPortalView pSAppPortalView2;
        if (StringHelper.isNullOrEmpty((String)pSAppPortalView.getPSSysAppId()) || !StringHelper.isNullOrEmpty((String)pSAppPortalView.getPSAppPortalViewName())) {
            return;
        }
        int n = 0;
        String string = "AppDashboardView";
        while (true) {
            pSAppPortalView2 = new PSAppPortalView();
            pSAppPortalView2.setPSSysAppId(pSAppPortalView.getPSSysAppId());
            pSAppPortalView2.setPSAppPortalViewName(StringHelper.format((String)"%1$s%2$s", (Object)string, (Object)(n == 0 ? "" : Integer.valueOf(n + 1))));
            if (!this.selectOne((IEntity)pSAppPortalView2, true)) break;
            ++n;
        }
        pSAppPortalView.setPSAppPortalViewName(pSAppPortalView2.getPSAppPortalViewName());
    }
}

