/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.CloneSessionManager
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
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
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.CloneSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelItemLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelItemLogicBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItem;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelItemLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemServiceBase;
import net.ibizsys.pscore.srv.util.PSPFQuickPreviewHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysViewPanelItemService
extends PSSysViewPanelItemServiceBase {
    private static final Log log = LogFactory.getLog(PSSysViewPanelItemService.class);

    @Override
    public void updateWithModel(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService((String)PSPanelItemLogicService.class.getCanonicalName(), (SessionFactory)PSSysViewPanelItemService.this.getSessionFactory());
                ArrayList<PSPanelItemLogic> arrayList = pSPanelItemLogicService.selectTempByPSSysViewPanelItem(pSSysViewPanelItem2);
                HashMap<String, PSPanelItemLogic> hashMap = new HashMap<String, PSPanelItemLogic>();
                for (PSPanelItemLogic panelItemLogic : arrayList) {
                    hashMap.put(panelItemLogic.getPSPanelItemLogicId(), panelItemLogic);
                }
                XmlNode xmlNode = null;
                boolean bl = false;
                String string = "";
                XmlNode defaultLogic = new XmlNode();
                defaultLogic.setNodeName("PANELITEMLOGIC");
                defaultLogic.setAttribute("PSSYSVIEWPANELITEMID", pSSysViewPanelItem2.getPSSysViewPanelItemId());
                defaultLogic.setAttribute("PSSYSVIEWPANELID", pSSysViewPanelItem2.getPSSysViewPanelId());
                string = XmlNode.export(defaultLogic);
                if (StringHelper.compare((String)pSSysViewPanelItem2.getItemType(), (String)"FIELD", (boolean)true) == 0) {
                    String blankLogic = pSSysViewPanelItem2.getBlankLogic();
                    XmlNode blankNode = XmlNode.loadFromXML(blankLogic);
                    if (blankNode != null) {
                        PSSysViewPanelItemService.this.updatePSPanelItemLogics(pSSysViewPanelItem2, "ITEMBLANK", null, blankNode, hashMap);
                        blankNode.setAttribute("PSSYSVIEWPANELITEMID", pSSysViewPanelItem2.getPSSysViewPanelItemId());
                        blankNode.setAttribute("PSSYSVIEWPANELID", pSSysViewPanelItem2.getPSSysViewPanelId());
                        pSSysViewPanelItem2.setBlankLogic(XmlNode.export(blankNode));
                    } else {
                        pSSysViewPanelItem2.setBlankLogic(string);
                    }
                } else {
                    pSSysViewPanelItem2.setBlankLogic(string);
                }
                String visibleLogic = pSSysViewPanelItem2.getVisibleLogic();
                XmlNode xmlNode2 = XmlNode.loadFromXML(visibleLogic);
                if (xmlNode2 != null) {
                    PSSysViewPanelItemService.this.updatePSPanelItemLogics(pSSysViewPanelItem2, "PANELVISIBLE", null, xmlNode2, hashMap);
                    xmlNode2.setAttribute("PSSYSVIEWPANELITEMID", pSSysViewPanelItem2.getPSSysViewPanelItemId());
                    xmlNode2.setAttribute("PSSYSVIEWPANELID", pSSysViewPanelItem2.getPSSysViewPanelId());
                    pSSysViewPanelItem2.setVisibleLogic(XmlNode.export((XmlNode)xmlNode2));
                } else {
                    pSSysViewPanelItem2.setVisibleLogic(string);
                }
                String string2 = pSSysViewPanelItem2.getEnableLogic();
                xmlNode = XmlNode.loadFromXML((String)string2);
                if (xmlNode != null) {
                    PSSysViewPanelItemService.this.updatePSPanelItemLogics(pSSysViewPanelItem2, "ITEMENABLE", null, xmlNode, hashMap);
                    xmlNode.setAttribute("PSSYSVIEWPANELITEMID", pSSysViewPanelItem2.getPSSysViewPanelItemId());
                    xmlNode.setAttribute("PSSYSVIEWPANELID", pSSysViewPanelItem2.getPSSysViewPanelId());
                    pSSysViewPanelItem2.setEnableLogic(XmlNode.export((XmlNode)xmlNode));
                } else {
                    pSSysViewPanelItem2.setEnableLogic(string);
                }
                if (hashMap.size() > 0) {
                    for (PSPanelItemLogic pSPanelItemLogic3 : hashMap.values()) {
                        pSPanelItemLogicService.removeTemp(pSPanelItemLogic3);
                    }
                }
                PSSysViewPanelItemService.this.updateTemp(pSSysViewPanelItem2);
            }
        });
    }

    protected void updatePSPanelItemLogics(PSSysViewPanelItem pSSysViewPanelItem, String string, PSPanelItemLogic pSPanelItemLogic, XmlNode xmlNode, HashMap<String, PSPanelItemLogic> hashMap) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<XmlNode> arrayList = new ArrayList<XmlNode>();
            PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService((String)PSPanelItemLogicService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            int n = 0;
            while (iterator.hasNext()) {
                PSPanelItemLogic pSPanelItemLogic2;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                String string2 = xmlNode2.getAttribute("PSPANELITEMLOGICID", "");
                if (StringHelper.isNullOrEmpty((String)string2) || (pSPanelItemLogic2 = hashMap.remove(string2)) == null) continue;
                ++n;
                boolean bl = false;
                if (StringHelper.compare((String)pSPanelItemLogic2.getLogicCat(), (String)string, (boolean)false) != 0) {
                    pSPanelItemLogic2.setLogicCat(string);
                    bl = true;
                }
                if (StringHelper.compare((String)pSPanelItemLogic2.getPSSysViewPanelItemId(), (String)pSSysViewPanelItem.getPSSysViewPanelItemId(), (boolean)false) != 0) {
                    pSPanelItemLogic2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
                    bl = true;
                }
                if (StringHelper.compare((String)pSPanelItemLogic2.getPSSysViewPanelItemName(), (String)pSSysViewPanelItem.getPSSysViewPanelItemName(), (boolean)false) != 0) {
                    pSPanelItemLogic2.setPSSysViewPanelItemName(pSSysViewPanelItem.getPSSysViewPanelItemName());
                    bl = true;
                }
                if (pSPanelItemLogic != null) {
                    if (StringHelper.compare((String)pSPanelItemLogic2.getPPSPanelItemLogicId(), (String)pSPanelItemLogic.getPSPanelItemLogicId(), (boolean)false) != 0) {
                        pSPanelItemLogic2.setPPSPanelItemLogicId(pSPanelItemLogic.getPSPanelItemLogicId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)pSPanelItemLogic2.getPPSPanelItemLogicName(), (String)pSPanelItemLogic.getPSPanelItemLogicName(), (boolean)false) != 0) {
                        pSPanelItemLogic2.setPPSPanelItemLogicName(pSPanelItemLogic.getPSPanelItemLogicName());
                        bl = true;
                    }
                }
                if (pSPanelItemLogic2.getOrderValue() == null || pSPanelItemLogic2.getOrderValue() != n) {
                    pSPanelItemLogic2.setOrderValue(n);
                    bl = true;
                }
                if (bl) {
                    pSPanelItemLogicService.updateTemp(pSPanelItemLogic2);
                }
                xmlNode2.resetAttributes();
                pSPanelItemLogic2.fillXmlNode(xmlNode2, false);
                arrayList.add(xmlNode2);
                this.updatePSPanelItemLogics(pSSysViewPanelItem, string, pSPanelItemLogic2, xmlNode2, hashMap);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
        }
    }

    protected void createPSPanelItemLogics(PSSysViewPanelItem pSSysViewPanelItem, String string, PSPanelItemLogic pSPanelItemLogic, XmlNode xmlNode) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService((String)PSPanelItemLogicService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            int n = 0;
            while (iterator.hasNext()) {
                ++n;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSPanelItemLogic pSPanelItemLogic2 = new PSPanelItemLogic();
                DataObject.fromXmlNode((IDataObject)pSPanelItemLogic2, (XmlNode)xmlNode2);
                pSPanelItemLogic2.resetPSPanelItemLogicId();
                pSPanelItemLogic2.resetPPSPanelItemLogicId();
                pSPanelItemLogic2.resetPPSPanelItemLogicName();
                pSPanelItemLogic2.setLogicCat(string);
                pSPanelItemLogic2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
                pSPanelItemLogic2.setPSSysViewPanelItemName(pSSysViewPanelItem.getPSSysViewPanelItemName());
                if (pSPanelItemLogic != null) {
                    pSPanelItemLogic2.setPPSPanelItemLogicId(pSPanelItemLogic.getPSPanelItemLogicId());
                    pSPanelItemLogic2.setPPSPanelItemLogicName(pSPanelItemLogic.getPSPanelItemLogicName());
                }
                pSPanelItemLogic2.setOrderValue(n);
                pSPanelItemLogicService.create(pSPanelItemLogic2);
                this.createPSPanelItemLogics(pSSysViewPanelItem, string, pSPanelItemLogic2, xmlNode2);
            }
        }
    }

    @Override
    public void createWithModel(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        this.updateWithModel(pSSysViewPanelItem);
    }

    @Override
    public void getWithModel(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        this.getTemp(pSSysViewPanelItem);
        if (StringHelper.isNullOrEmpty((String)pSSysViewPanelItem.getBlankLogic()) || StringHelper.isNullOrEmpty((String)pSSysViewPanelItem.getVisibleLogic()) || StringHelper.isNullOrEmpty((String)pSSysViewPanelItem.getEnableLogic())) {
            this.fillPanelItemModel(pSSysViewPanelItem);
            this.updateTemp(pSSysViewPanelItem);
        }
    }

    protected void fillPanelItemModel(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        XmlNode xmlNode;
        XmlNode xmlNode2;
        XmlNode xmlNode3;
        PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService((String)PSPanelItemLogicService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelItemLogic> arrayList = pSPanelItemLogicService.selectTempByPSSysViewPanelItem(pSSysViewPanelItem, "ORDER BY ORDERVALUE");
        HashMap<String, XmlNode> hashMap = new HashMap<String, XmlNode>();
        for (PSPanelItemLogic object22 : arrayList) {
            XmlNode object = new XmlNode();
            object.setNodeName(object22.getLogicType());
            object22.fillXmlNode((XmlNode)object, true);
            hashMap.put(object22.getPSPanelItemLogicId(), (XmlNode)object);
        }
        HashMap hashMap2 = new HashMap();
        if (StringHelper.compare((String)pSSysViewPanelItem.getItemType(), (String)"FIELD", (boolean)true) == 0) {
            XmlNode xmlNode4 = new XmlNode();
            xmlNode4.setNodeName("PANELITEMLOGIC");
            xmlNode4.setAttribute("PSSYSVIEWPANELITEMID", pSSysViewPanelItem.getPSSysViewPanelItemId());
            xmlNode4.setAttribute("PSSYSVIEWPANELID", pSSysViewPanelItem.getPSSysViewPanelId());
            hashMap2.put("ITEMENABLE", xmlNode4);
        }
        if (StringHelper.compare((String)pSSysViewPanelItem.getItemType(), (String)"FIELD", (boolean)true) == 0) {
            XmlNode xmlNode5 = new XmlNode();
            xmlNode5.setNodeName("PANELITEMLOGIC");
            xmlNode5.setAttribute("PSSYSVIEWPANELITEMID", pSSysViewPanelItem.getPSSysViewPanelItemId());
            xmlNode5.setAttribute("PSSYSVIEWPANELID", pSSysViewPanelItem.getPSSysViewPanelId());
            hashMap2.put("ITEMBLANK", xmlNode5);
        }
        XmlNode xmlNode6 = new XmlNode();
        xmlNode6.setNodeName("PANELITEMLOGIC");
        xmlNode6.setAttribute("PSSYSVIEWPANELITEMID", pSSysViewPanelItem.getPSSysViewPanelItemId());
        xmlNode6.setAttribute("PSSYSVIEWPANELID", pSSysViewPanelItem.getPSSysViewPanelId());
        hashMap2.put("PANELVISIBLE", xmlNode6);
        for (Object object : arrayList) {
            XmlNode xmlNode7;
            XmlNode xmlNode8 = (XmlNode)hashMap.get(((PSPanelItemLogicBase)object).getPSPanelItemLogicId());
            if (StringHelper.isNullOrEmpty((String)((PSPanelItemLogicBase)object).getPPSPanelItemLogicId())) {
                xmlNode7 = (XmlNode)hashMap2.get(((PSPanelItemLogicBase)object).getLogicCat());
                if (xmlNode7 == null) continue;
                xmlNode7.addNode(xmlNode8);
                continue;
            }
            xmlNode7 = (XmlNode)hashMap.get(((PSPanelItemLogicBase)object).getPPSPanelItemLogicId());
            if (xmlNode7 != null) {
                xmlNode7.addNode(xmlNode8);
                continue;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u9762\u677f\u6210\u5458\u7236\u903b\u8f91[%1$s], \u5f53\u524d[%2$s]", (Object)((PSPanelItemLogicBase)object).getPPSPanelItemLogicId(), (Object)((PSPanelItemLogicBase)object).getPSPanelItemLogicName()));
        }
        if (StringHelper.compare((String)pSSysViewPanelItem.getItemType(), (String)"FIELD", (boolean)true) == 0 && (xmlNode3 = (XmlNode)hashMap2.get("ITEMENABLE")) != null) {
            pSSysViewPanelItem.setEnableLogic(XmlNode.export((XmlNode)xmlNode3));
        }
        if (StringHelper.compare((String)pSSysViewPanelItem.getItemType(), (String)"FIELD", (boolean)true) == 0 && (xmlNode2 = (XmlNode)hashMap2.get("ITEMBLANK")) != null) {
            pSSysViewPanelItem.setBlankLogic(XmlNode.export((XmlNode)xmlNode2));
        }
        if ((xmlNode = (XmlNode)hashMap2.get("PANELVISIBLE")) != null) {
            pSSysViewPanelItem.setVisibleLogic(XmlNode.export((XmlNode)xmlNode));
        }
    }

    @Override
    protected void onBeforeGetDraftTemp(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        super.onBeforeGetDraftTemp(pSSysViewPanelItem);
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName("PANELITEMLOGIC");
        xmlNode.setAttribute("PSSYSVIEWPANELITEMID", pSSysViewPanelItem.getPSSysViewPanelItemId());
        xmlNode.setAttribute("PSSYSVIEWPANELID", pSSysViewPanelItem.getPSSysViewPanelId());
        String string = XmlNode.export((XmlNode)xmlNode);
        pSSysViewPanelItem.setEnableLogic(string);
        pSSysViewPanelItem.setBlankLogic(string);
        pSSysViewPanelItem.setVisibleLogic(string);
        String string2 = pSSysViewPanelItem.getPSSysViewPanelItemName();
        if (StringHelper.isNullOrEmpty((String)string2)) {
            this.fillPSSysViewPanelItemDefaultName(pSSysViewPanelItem);
        }
    }

    protected void fillPSSysViewPanelItemDefaultName(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        int n = 1;
        String string = pSSysViewPanelItem.getItemType();
        String string2 = string;
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return;
        }
        string2 = string2.toLowerCase();
        PSSysViewPanel pSSysViewPanel = new PSSysViewPanel();
        pSSysViewPanel.setPSSysViewPanelId(pSSysViewPanelItem.getPSSysViewPanelId());
        ArrayList<PSSysViewPanelItem> arrayList = null;
        arrayList = pSSysViewPanel.getPSSysViewPanelId().indexOf("SRFTEMPKEY:") == 0 ? this.selectTempByPSSysViewPanel(pSSysViewPanel) : this.selectByPSSysViewPanel(pSSysViewPanel);
        HashMap<String, PSSysViewPanelItem> hashMap = new HashMap<String, PSSysViewPanelItem>();
        for (PSSysViewPanelItem pSSysViewPanelItem2 : arrayList) {
            if (StringHelper.isNullOrEmpty((String)pSSysViewPanelItem2.getPSSysViewPanelItemName())) continue;
            hashMap.put(pSSysViewPanelItem2.getPSSysViewPanelItemName().toLowerCase(), pSSysViewPanelItem2);
        }
        String candidateName;
        while (true) {
            candidateName = StringHelper.format((String)"%1$s%2$s", (Object)string2, (Object)(n == 0 ? "" : Integer.valueOf(n)));
            if (!hashMap.containsKey(candidateName)) break;
            ++n;
        }
        pSSysViewPanelItem.setPSSysViewPanelItemName(candidateName);
    }

    @Override
    protected void onBeforeCreate(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        pSSysViewPanelItem.setPreviewHtml(null);
        pSSysViewPanelItem.setVisibleLogic(null);
        pSSysViewPanelItem.setBlankLogic(null);
        pSSysViewPanelItem.setEnableLogic(null);
        super.onBeforeCreate(pSSysViewPanelItem);
    }

    @Override
    protected void onBeforeUpdate(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        pSSysViewPanelItem.setPreviewHtml(null);
        pSSysViewPanelItem.setVisibleLogic(null);
        pSSysViewPanelItem.setBlankLogic(null);
        pSSysViewPanelItem.setEnableLogic(null);
        super.onBeforeUpdate(pSSysViewPanelItem);
    }

    @Override
    protected void onBeforeCreateTemp(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        pSSysViewPanelItem.setPreviewHtml(null);
        pSSysViewPanelItem.setLogicName(this.calcPSSysViewPanelItemLogicName(pSSysViewPanelItem));
        if (StringHelper.isNullOrEmpty((String)pSSysViewPanelItem.getPSSysViewPanelItemName())) {
            this.fillPSSysViewPanelItemDefaultName(pSSysViewPanelItem);
        }
        super.onBeforeCreateTemp(pSSysViewPanelItem);
    }

    @Override
    protected void onBeforeUpdateTemp(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        pSSysViewPanelItem.setPreviewHtml(null);
        pSSysViewPanelItem.setLogicName(this.calcPSSysViewPanelItemLogicName(pSSysViewPanelItem));
        super.onBeforeUpdateTemp(pSSysViewPanelItem);
    }

    protected String calcPSSysViewPanelItemLogicName(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        String string = pSSysViewPanelItem.getItemType();
        return pSSysViewPanelItem.getLogicName();
    }

    @Override
    public PSSysViewPanelItem importXmlModel(PSSysViewPanelItem pSSysViewPanelItem, XmlNode xmlNode) throws Exception {
        PSSysViewPanelItem pSSysViewPanelItem2 = super.importXmlModel(pSSysViewPanelItem, xmlNode);
        pSSysViewPanelItem2.setVisibleLogic(null);
        pSSysViewPanelItem2.setBlankLogic(null);
        pSSysViewPanelItem2.setEnableLogic(null);
        if (pSSysViewPanelItem2.getPSSysViewPanelItemId().indexOf("SRFTEMPKEY:") == 0) {
            this.sysUpdateTemp(pSSysViewPanelItem2, false);
        } else {
            this.sysUpdate(pSSysViewPanelItem2, false);
        }
        return pSSysViewPanelItem2;
    }

    @Override
    protected ArrayList<PSPanelItemLogic> updateRelatedDataTempMajor_removePSPanelItemLogic(PSSysViewPanelItem pSSysViewPanelItem, PSSysViewPanelItem pSSysViewPanelItem2) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
            return null;
        }
        return super.updateRelatedDataTempMajor_removePSPanelItemLogic(pSSysViewPanelItem, pSSysViewPanelItem2);
    }

    @Override
    protected void updateRelatedDataTempMajor_updatePSPanelItemLogic(PSSysViewPanelItem pSSysViewPanelItem, PSSysViewPanelItem pSSysViewPanelItem2, ArrayList<PSPanelItemLogic> arrayList) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
            return;
        }
        super.updateRelatedDataTempMajor_updatePSPanelItemLogic(pSSysViewPanelItem, pSSysViewPanelItem2, arrayList);
    }

    @Override
    protected void getRelatedDataTempMajor_PSPanelItemLogic(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
            return;
        }
        super.getRelatedDataTempMajor_PSPanelItemLogic(pSSysViewPanelItem);
    }

    public void getTemp(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        super.getTemp(pSSysViewPanelItem);
    }

    @Override
    public void createTemp(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        pSSysViewPanelItem.resetPreviewHtml();
        super.createTemp(pSSysViewPanelItem);
    }

    public void updateTemp(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
        pSSysViewPanelItem.resetPreviewHtml();
        super.updateTemp(pSSysViewPanelItem, bl);
    }

    public void fillPreviewHtml(final PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSSysViewPanelItem.getPSSysViewPanelId()) || StringHelper.isNullOrEmpty((String)pSSysViewPanelItem.getItemType())) {
            return;
        }
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanel pSSysViewPanel = null;
                Object object = ActionSessionManager.getCurrentSession().getActionParam("PSSYSVIEWPANEL|" + pSSysViewPanelItem.getPSSysViewPanelId());
                if (object == null) {
                    pSSysViewPanel = pSSysViewPanelItem.getPSSysViewPanel();
                    if (pSSysViewPanel.getPSSysApp() == null) {
                        ActionSessionManager.getCurrentSession().setActionParam("PSSYSVIEWPANEL|" + pSSysViewPanelItem.getPSSysViewPanelId(), (Object)"");
                        return;
                    }
                    ActionSessionManager.getCurrentSession().setActionParam("PSSYSVIEWPANEL|" + pSSysViewPanelItem.getPSSysViewPanelId(), (Object)pSSysViewPanel);
                } else if (object instanceof PSSysViewPanel) {
                    pSSysViewPanel = (PSSysViewPanel)object;
                }
                if (pSSysViewPanel == null || pSSysViewPanel.getPSSysApp() == null) {
                    return;
                }
                String string = KeyValueHelper.genUniqueId((String)pSSysViewPanel.getPSSysApp().getPSPFId(), (String)("PSSYSVIEWPANELITEM|" + pSSysViewPanelItem.getItemType()));
                String string2 = PSPFQuickPreviewHelper.getQuickTempl(string, pSSysViewPanelItem);
                pSSysViewPanelItem.setPreviewHtml(string2);
            }
        }, false);
    }

    @Override
    public void getTempWithPreview(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        super.getTemp(pSSysViewPanelItem);
        this.fillPreviewHtml(pSSysViewPanelItem);
    }

    @Override
    public void updateTempWithPreview(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        pSSysViewPanelItem.resetPreviewHtml();
        super.updateTemp(pSSysViewPanelItem, true);
        this.fillPreviewHtml(pSSysViewPanelItem);
    }

    @Override
    public void createTempWithPreview(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        pSSysViewPanelItem.resetPreviewHtml();
        super.createTemp(pSSysViewPanelItem);
        this.fillPreviewHtml(pSSysViewPanelItem);
    }
}

