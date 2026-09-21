/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.CloneSessionManager
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
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
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.CloneSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLLCond;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicLink;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicNodeBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLLCondService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicLinkServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicNodeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSPanelLogicLinkService
extends PSPanelLogicLinkServiceBase {
    public static final String XMLNODE_PANELLLCOND = "PANELLLCOND";
    private static final Log log = LogFactory.getLog(PSPanelLogicLinkService.class);

    @Override
    public void updateWithModel(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        final PSPanelLogicLink pSPanelLogicLink2 = pSPanelLogicLink;
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService((String)PSPanelLLCondService.class.getCanonicalName(), (SessionFactory)PSPanelLogicLinkService.this.getSessionFactory());
                ArrayList<PSPanelLLCond> arrayList = pSPanelLLCondService.selectTempByPSPanelLogicLink(pSPanelLogicLink2);
                HashMap<String, PSPanelLLCond> hashMap = new HashMap<String, PSPanelLLCond>();
                for (PSPanelLLCond object2 : arrayList) {
                    hashMap.put(object2.getPSPanelLLCondId(), object2);
                }
                Object object3 = "";
                XmlNode xmlNode = new XmlNode();
                xmlNode.setNodeName(PSPanelLogicLinkService.XMLNODE_PANELLLCOND);
                xmlNode.setAttribute("PSPANELLOGICLINKID", pSPanelLogicLink2.getPSPanelLogicLinkId());
                xmlNode.setAttribute("PSSYSVIEWPANELLOGICID", pSPanelLogicLink2.getPSSysViewPanelLogicId());
                object3 = XmlNode.export((XmlNode)xmlNode);
                String string = pSPanelLogicLink2.getCondModel();
                XmlNode xmlNode2 = XmlNode.loadFromXML((String)string);
                if (xmlNode2 != null) {
                    PSPanelLogicLinkService.this.updatePSPanelLLConds(pSPanelLogicLink2, null, xmlNode2, hashMap);
                    xmlNode2.setAttribute("PSPANELLOGICLINKID", pSPanelLogicLink2.getPSPanelLogicLinkId());
                    xmlNode2.setAttribute("PSSYSVIEWPANELLOGICID", pSPanelLogicLink2.getPSSysViewPanelLogicId());
                    pSPanelLogicLink2.setCondModel(XmlNode.export((XmlNode)xmlNode2));
                } else {
                    pSPanelLogicLink2.setCondModel((String)object3);
                }
                if (hashMap.size() > 0) {
                    for (PSPanelLLCond pSPanelLLCond : hashMap.values()) {
                        pSPanelLLCondService.removeTemp((IEntity)pSPanelLLCond);
                    }
                }
                PSPanelLogicLinkService.this.updateTemp((IEntity)pSPanelLogicLink2);
            }
        });
    }

    protected void updatePSPanelLLConds(PSPanelLogicLink pSPanelLogicLink, PSPanelLLCond pSPanelLLCond, XmlNode xmlNode, HashMap<String, PSPanelLLCond> hashMap) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService((String)PSPanelLLCondService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            int n = 0;
            while (iterator.hasNext()) {
                PSPanelLLCond pSPanelLLCond2;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                String string = xmlNode2.getAttribute("PSPANELLLCONDID", "");
                if (StringHelper.isNullOrEmpty((String)string) || (pSPanelLLCond2 = hashMap.remove(string)) == null) continue;
                ++n;
                boolean bl = false;
                if (StringHelper.compare((String)pSPanelLLCond2.getPSPanelLogicLinkId(), (String)pSPanelLogicLink.getPSPanelLogicLinkId(), (boolean)false) != 0) {
                    pSPanelLLCond2.setPSPanelLogicLinkId(pSPanelLogicLink.getPSPanelLogicLinkId());
                    bl = true;
                }
                if (StringHelper.compare((String)pSPanelLLCond2.getPSPanelLogicLinkName(), (String)pSPanelLogicLink.getPSPanelLogicLinkName(), (boolean)false) != 0) {
                    pSPanelLLCond2.setPSPanelLogicLinkName(pSPanelLogicLink.getPSPanelLogicLinkName());
                    bl = true;
                }
                if (pSPanelLLCond != null) {
                    if (StringHelper.compare((String)pSPanelLLCond2.getPPSPanelLLCondId(), (String)pSPanelLLCond.getPSPanelLLCondId(), (boolean)false) != 0) {
                        pSPanelLLCond2.setPPSPanelLLCondId(pSPanelLLCond.getPSPanelLLCondId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)pSPanelLLCond2.getPPSPanelLLCondName(), (String)pSPanelLLCond.getPSPanelLLCondName(), (boolean)false) != 0) {
                        pSPanelLLCond2.setPPSPanelLLCondName(pSPanelLLCond.getPSPanelLLCondName());
                        bl = true;
                    }
                }
                if (pSPanelLLCond2.getOrderValue() == null || pSPanelLLCond2.getOrderValue() != n) {
                    pSPanelLLCond2.setOrderValue(n);
                    bl = true;
                }
                if (bl) {
                    pSPanelLLCondService.updateTemp((IEntity)pSPanelLLCond2);
                }
                xmlNode2.resetAttributes();
                pSPanelLLCond2.fillXmlNode(xmlNode2, false);
                arrayList.add(xmlNode2);
                this.updatePSPanelLLConds(pSPanelLogicLink, pSPanelLLCond2, xmlNode2, hashMap);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
        }
    }

    protected void createPSPanelLLConds(PSPanelLogicLink pSPanelLogicLink, String string, PSPanelLLCond pSPanelLLCond, XmlNode xmlNode) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService((String)PSPanelLLCondService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            int n = 0;
            while (iterator.hasNext()) {
                ++n;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSPanelLLCond pSPanelLLCond2 = new PSPanelLLCond();
                DataObject.fromXmlNode((IDataObject)pSPanelLLCond2, (XmlNode)xmlNode2);
                pSPanelLLCond2.resetPSPanelLLCondId();
                pSPanelLLCond2.resetPPSPanelLLCondId();
                pSPanelLLCond2.resetPPSPanelLLCondName();
                pSPanelLLCond2.setPSPanelLogicLinkId(pSPanelLogicLink.getPSPanelLogicLinkId());
                pSPanelLLCond2.setPSPanelLogicLinkName(pSPanelLogicLink.getPSPanelLogicLinkName());
                if (pSPanelLLCond != null) {
                    pSPanelLLCond2.setPPSPanelLLCondId(pSPanelLLCond.getPSPanelLLCondId());
                    pSPanelLLCond2.setPPSPanelLLCondName(pSPanelLLCond.getPSPanelLLCondName());
                }
                pSPanelLLCond2.setOrderValue(n);
                pSPanelLLCondService.create(pSPanelLLCond2);
                this.createPSPanelLLConds(pSPanelLogicLink, string, pSPanelLLCond2, xmlNode2);
            }
        }
    }

    @Override
    public void createWithModel(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        this.updateWithModel(pSPanelLogicLink);
    }

    @Override
    public void getWithModel(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        this.getTemp((IEntity)pSPanelLogicLink);
        if (StringHelper.isNullOrEmpty((String)pSPanelLogicLink.getCondModel())) {
            this.fillLogicLinkModel(pSPanelLogicLink);
            this.updateTemp((IEntity)pSPanelLogicLink);
        }
    }

    protected void fillLogicLinkModel(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService((String)PSPanelLLCondService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLLCond> arrayList = pSPanelLLCondService.selectTempByPSPanelLogicLink(pSPanelLogicLink, "ORDER BY ORDERVALUE");
        HashMap<String, XmlNode> hashMap = new HashMap<String, XmlNode>();
        for (PSPanelLLCond object : arrayList) {
            XmlNode xmlNode = new XmlNode();
            xmlNode.setNodeName(object.getLogicType());
            object.fillXmlNode(xmlNode, true);
            hashMap.put(object.getPSPanelLLCondId(), xmlNode);
        }
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_PANELLLCOND);
        xmlNode.setAttribute("PSPANELLOGICLINKID", pSPanelLogicLink.getPSPanelLogicLinkId());
        xmlNode.setAttribute("PSSYSVIEWPANELLOGICID", pSPanelLogicLink.getPSSysViewPanelLogicId());
        for (PSPanelLLCond pSPanelLLCond : arrayList) {
            XmlNode xmlNode2 = (XmlNode)hashMap.get(pSPanelLLCond.getPSPanelLLCondId());
            if (StringHelper.isNullOrEmpty((String)pSPanelLLCond.getPPSPanelLLCondId())) {
                xmlNode.addNode(xmlNode2);
                continue;
            }
            XmlNode xmlNode3 = (XmlNode)hashMap.get(pSPanelLLCond.getPPSPanelLLCondId());
            if (xmlNode3 != null) {
                xmlNode3.addNode(xmlNode2);
                continue;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u903b\u8f91\u8fde\u63a5\u7236\u903b\u8f91[%1$s], \u5f53\u524d[%2$s]", (Object)pSPanelLLCond.getPPSPanelLLCondId(), (Object)pSPanelLLCond.getPSPanelLLCondName()));
        }
        pSPanelLogicLink.setCondModel(XmlNode.export((XmlNode)xmlNode));
    }

    @Override
    protected void onBeforeGetDraftTemp(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        super.onBeforeGetDraftTemp(pSPanelLogicLink);
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_PANELLLCOND);
        xmlNode.setAttribute("PSPANELLOGICLINKID", pSPanelLogicLink.getPSPanelLogicLinkId());
        xmlNode.setAttribute("PSSYSVIEWPANELLOGICID", pSPanelLogicLink.getPSSysViewPanelLogicId());
        String string = XmlNode.export((XmlNode)xmlNode);
        pSPanelLogicLink.setCondModel(string);
    }

    @Override
    protected void onBeforeCreate(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        pSPanelLogicLink.setCondModel(null);
        super.onBeforeCreate(pSPanelLogicLink);
    }

    @Override
    protected void onBeforeUpdate(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        pSPanelLogicLink.setCondModel(null);
        super.onBeforeUpdate(pSPanelLogicLink);
    }

    @Override
    protected void onBeforeCreateTemp(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        pSPanelLogicLink.setLinkInfo(this.calcPSPanelLogicLinkLabel(pSPanelLogicLink, null));
        super.onBeforeCreateTemp(pSPanelLogicLink);
    }

    @Override
    protected void onBeforeUpdateTemp(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        pSPanelLogicLink.setLinkInfo(this.calcPSPanelLogicLinkLabel(pSPanelLogicLink, (PSPanelLogicLink)this.getLast((IEntity)pSPanelLogicLink)));
        super.onBeforeUpdateTemp(pSPanelLogicLink);
    }

    protected String calcPSPanelLogicLinkLabel(PSPanelLogicLink pSPanelLogicLink, PSPanelLogicLink pSPanelLogicLink2) throws Exception {
        Integer n = 0;
        if (pSPanelLogicLink.isOrderValueDirty()) {
            n = pSPanelLogicLink.getOrderValue();
        } else if (pSPanelLogicLink2 != null) {
            n = pSPanelLogicLink2.getOrderValue();
        }
        if (n == null) {
            n = 0;
        }
        Integer n2 = 0;
        if (pSPanelLogicLink.isDefaultLinkDirty()) {
            n2 = pSPanelLogicLink.getDefaultLink();
        } else if (pSPanelLogicLink2 != null) {
            n2 = pSPanelLogicLink2.getDefaultLink();
        }
        if (n2 == 0) {
            return StringHelper.format((String)"%1$s:%2$s", (Object)pSPanelLogicLink.getPSPanelLogicLinkName(), (Object)n);
        }
        return StringHelper.format((String)"%1$s:%2$s:[\u9ed8\u8ba4]", (Object)pSPanelLogicLink.getPSPanelLogicLinkName(), (Object)n);
    }

    @Override
    protected void importCurXmlModel(PSPanelLogicLink pSPanelLogicLink, XmlNode xmlNode) throws Exception {
        Object object;
        PSPanelLogicNodeService pSPanelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        String string = xmlNode.getAttribute("SRCPSPANELLOGICNODENAME", "");
        if (!StringHelper.isNullOrEmpty((String)string)) {
            object = new PSPanelLogicNode();
            ((PSPanelLogicNodeBase)object).setPSPanelLogicNodeName(string);
            ((PSPanelLogicNodeBase)object).setPSSysViewPanelLogicId(pSPanelLogicLink.getPSSysViewPanelLogicId());
            pSPanelLogicNodeService.selectTemp(object, false);
            pSPanelLogicLink.setSrcPSPanelLogicNodeId(((PSPanelLogicNodeBase)object).getPSPanelLogicNodeId());
            xmlNode.setAttribute("SRCPSPANELLOGICNODEID", ((PSPanelLogicNodeBase)object).getPSPanelLogicNodeId());
        }
        if (!StringHelper.isNullOrEmpty((String)(object = xmlNode.getAttribute("DSTPSPANELLOGICNODENAME", "")))) {
            PSPanelLogicNode pSPanelLogicNode = new PSPanelLogicNode();
            pSPanelLogicNode.setPSPanelLogicNodeName((String)object);
            pSPanelLogicNode.setPSSysViewPanelLogicId(pSPanelLogicLink.getPSSysViewPanelLogicId());
            pSPanelLogicNodeService.selectTemp(pSPanelLogicNode, false);
            pSPanelLogicLink.setDstPSPanelLogicNodeId(pSPanelLogicNode.getPSPanelLogicNodeId());
            xmlNode.setAttribute("DSTPSPANELLOGICNODEID", pSPanelLogicNode.getPSPanelLogicNodeId());
        }
        super.importCurXmlModel(pSPanelLogicLink, xmlNode);
    }

    @Override
    protected void exportCurXmlModel(PSPanelLogicLink pSPanelLogicLink, XmlNode xmlNode, boolean bl) throws Exception {
        pSPanelLogicLink.setCondModel(null);
        super.exportCurXmlModel(pSPanelLogicLink, xmlNode, bl);
    }

    @Override
    protected ArrayList<PSPanelLLCond> updateRelatedDataTempMajor_removePSPanelLLCond(PSPanelLogicLink pSPanelLogicLink, PSPanelLogicLink pSPanelLogicLink2) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
            return null;
        }
        return super.updateRelatedDataTempMajor_removePSPanelLLCond(pSPanelLogicLink, pSPanelLogicLink2);
    }

    @Override
    protected void updateRelatedDataTempMajor_updatePSPanelLLCond(PSPanelLogicLink pSPanelLogicLink, PSPanelLogicLink pSPanelLogicLink2, ArrayList<PSPanelLLCond> arrayList) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
            return;
        }
        super.updateRelatedDataTempMajor_updatePSPanelLLCond(pSPanelLogicLink, pSPanelLogicLink2, arrayList);
    }

    @Override
    protected void getRelatedDataTempMajor_PSPanelLLCond(PSPanelLogicLink pSPanelLogicLink) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
            return;
        }
        super.getRelatedDataTempMajor_PSPanelLLCond(pSPanelLogicLink);
    }
}

