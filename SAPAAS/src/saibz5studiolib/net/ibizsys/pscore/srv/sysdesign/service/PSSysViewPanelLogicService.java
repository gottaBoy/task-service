/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
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
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.CloneSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicLink;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelLogic;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicLinkService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysViewPanelLogicService
extends PSSysViewPanelLogicServiceBase {
    public static final String XMLNODE_PANELLOGIC = "PANELLOGIC";
    public static final String XMLNODE_PANELLOGICNODE = "PANELLOGICNODE";
    public static final String XMLNODE_PANELLOGICLINK = "PANELLOGICLINK";
    private static final Log log = LogFactory.getLog(PSSysViewPanelLogicService.class);

    @Override
    public void getWithModel(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        this.getTemp((IEntity)pSSysViewPanelLogic);
        pSSysViewPanelLogic.setLogicModel(this.getLogicModel(pSSysViewPanelLogic));
    }

    protected String getLogicModel(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_PANELLOGIC);
        xmlNode.setAttribute("PSDEID", pSSysViewPanelLogic.getPSDEId());
        xmlNode.setAttribute("PSSYSVIEWPANELLOGICID", pSSysViewPanelLogic.getPSSysViewPanelLogicId());
        String string = pSSysViewPanelLogic.getLogicType();
        if (StringHelper.isNullOrEmpty((String)string)) {
            string = "CUSTOM";
        }
        xmlNode.setAttribute("LOGICTYPE", string);
        PSPanelLogicNodeService pSPanelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService((String)PSPanelLogicNodeService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicNode> arrayList = pSPanelLogicNodeService.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogic);
        for (PSPanelLogicNode serializable2 : arrayList) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName(XMLNODE_PANELLOGICNODE);
            serializable2.fillXmlNode(xmlNode2, true);
            xmlNode.addNode(xmlNode2);
        }
        PSPanelLogicLinkService pSPanelLogicLinkService = (PSPanelLogicLinkService)ServiceGlobal.getService((String)PSPanelLogicLinkService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicLink> arrayList2 = pSPanelLogicLinkService.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogic);
        for (PSPanelLogicLink pSPanelLogicLink : arrayList2) {
            XmlNode xmlNode3 = new XmlNode();
            xmlNode3.setNodeName(XMLNODE_PANELLOGICLINK);
            pSPanelLogicLink.fillXmlNode(xmlNode3, true);
            xmlNode.addNode(xmlNode3);
        }
        return XmlNode.export((XmlNode)xmlNode);
    }

    @Override
    public void updateWithModel(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        PSSysViewPanelLogic pSSysViewPanelLogic2 = new PSSysViewPanelLogic();
        pSSysViewPanelLogic.copyTo((IDataObject)pSSysViewPanelLogic2, false);
        this.getTemp((IEntity)pSSysViewPanelLogic2);
        final PSSysViewPanelLogic pSSysViewPanelLogic3 = pSSysViewPanelLogic;
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicLink pSPanelLogicLink2;
                PSPanelLogicNodeService pSPanelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService((String)PSPanelLogicNodeService.class.getCanonicalName(), (SessionFactory)PSSysViewPanelLogicService.this.getSessionFactory());
                ArrayList<PSPanelLogicNode> arrayList = pSPanelLogicNodeService.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogic3);
                HashMap<String, PSPanelLogicNode> hashMap = new HashMap<String, PSPanelLogicNode>();
                for (PSPanelLogicNode serializable2 : arrayList) {
                    hashMap.put(serializable2.getPSPanelLogicNodeId(), serializable2);
                }
                PSPanelLogicLinkService pSPanelLogicLinkService = (PSPanelLogicLinkService)ServiceGlobal.getService((String)PSPanelLogicLinkService.class.getCanonicalName(), (SessionFactory)PSSysViewPanelLogicService.this.getSessionFactory());
                ArrayList<PSPanelLogicLink> arrayList2 = pSPanelLogicLinkService.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogic3);
                HashMap<String, PSPanelLogicLink> hashMap2 = new HashMap<String, PSPanelLogicLink>();
                for (PSPanelLogicLink pSPanelLogicLink2 : arrayList2) {
                    hashMap2.put(pSPanelLogicLink2.getPSPanelLogicLinkId(), pSPanelLogicLink2);
                }
                String string = pSSysViewPanelLogic3.getLogicModel();
                pSPanelLogicLink2 = XmlNode.loadFromXML((String)string);
                if (pSPanelLogicLink2 != null) {
                    pSPanelLogicLink2.setAttribute("PSDEID", pSSysViewPanelLogic3.getPSDEId());
                    pSPanelLogicLink2.setAttribute("PSSYSVIEWPANELLOGICID", pSSysViewPanelLogic3.getPSSysViewPanelLogicId());
                    Object object = pSSysViewPanelLogic3.getLogicType();
                    if (StringHelper.isNullOrEmpty((String)object)) {
                        object = "CUSTOM";
                    }
                    pSPanelLogicLink2.setAttribute("LOGICTYPE", (String)object);
                    PSSysViewPanelLogicService.this.updatePSSysViewPanelLogicModel(pSSysViewPanelLogic3, (XmlNode)pSPanelLogicLink2, hashMap, hashMap2);
                    pSSysViewPanelLogic3.setLogicModel(XmlNode.export((XmlNode)pSPanelLogicLink2));
                } else {
                    pSSysViewPanelLogic3.setLogicModel(null);
                }
                if (hashMap2.size() > 0) {
                    for (EntityBase entityBase : hashMap2.values()) {
                        pSPanelLogicLinkService.removeTemp((IEntity)entityBase);
                    }
                }
                if (hashMap.size() > 0) {
                    for (EntityBase entityBase : hashMap.values()) {
                        pSPanelLogicNodeService.removeTemp((IEntity)entityBase);
                    }
                }
                PSSysViewPanelLogicService.this.updateTemp((IEntity)pSSysViewPanelLogic3);
            }
        });
    }

    protected void updatePSSysViewPanelLogicModel(PSSysViewPanelLogic pSSysViewPanelLogic, XmlNode xmlNode, HashMap<String, PSPanelLogicNode> hashMap, HashMap<String, PSPanelLogicLink> hashMap2) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            ArrayList<Object> arrayList2 = new ArrayList<Object>();
            PSPanelLogicNodeService pSPanelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService((String)PSPanelLogicNodeService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            PSPanelLogicLinkService pSPanelLogicLinkService = (PSPanelLogicLinkService)ServiceGlobal.getService((String)PSPanelLogicLinkService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            while (iterator.hasNext()) {
                String string;
                String string2;
                String string3;
                boolean bl;
                EntityBase entityBase;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                if (StringHelper.compare((String)xmlNode2.getNodeName(), (String)XMLNODE_PANELLOGICNODE, (boolean)true) == 0) {
                    int n;
                    String string4 = xmlNode2.getAttribute("PSPANELLOGICNODEID", "");
                    if (StringHelper.isNullOrEmpty((String)string4) || (entityBase = hashMap.remove(string4)) == null) continue;
                    bl = false;
                    if (StringHelper.compare((String)entityBase.getPSSysViewPanelLogicId(), (String)pSSysViewPanelLogic.getPSSysViewPanelLogicId(), (boolean)false) != 0) {
                        entityBase.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)entityBase.getPSSysViewPanelLogicName(), (String)pSSysViewPanelLogic.getPSSysViewPanelLogicName(), (boolean)false) != 0) {
                        entityBase.setPSSysViewPanelLogicName(pSSysViewPanelLogic.getPSSysViewPanelLogicName());
                        bl = true;
                    }
                    string3 = xmlNode2.getAttribute("LEFTPOS", "");
                    string2 = xmlNode2.getAttribute("TOPPOS", "");
                    if (!StringHelper.isNullOrEmpty((String)string3)) {
                        n = Integer.parseInt(string3);
                        if (entityBase.getLeftPos() == null || entityBase.getLeftPos() != n) {
                            entityBase.setLeftPos(n);
                            bl = true;
                        }
                    }
                    if (!StringHelper.isNullOrEmpty((String)string2)) {
                        n = Integer.parseInt(string2);
                        if (entityBase.getTopPos() == null || entityBase.getTopPos() != n) {
                            entityBase.setTopPos(n);
                            bl = true;
                        }
                    }
                    if (bl) {
                        pSPanelLogicNodeService.updateTemp((IEntity)entityBase);
                    }
                    xmlNode2.resetAttributes();
                    entityBase.fillXmlNode(xmlNode2, false);
                    arrayList.add(xmlNode2);
                    continue;
                }
                if (StringHelper.compare((String)xmlNode2.getNodeName(), (String)XMLNODE_PANELLOGICLINK, (boolean)true) != 0 || StringHelper.isNullOrEmpty((String)(string = xmlNode2.getAttribute("PSPANELLOGICLINKID", ""))) || (entityBase = hashMap2.remove(string)) == null) continue;
                bl = false;
                if (StringHelper.compare((String)entityBase.getPSSysViewPanelLogicId(), (String)pSSysViewPanelLogic.getPSSysViewPanelLogicId(), (boolean)false) != 0) {
                    entityBase.setPSSysViewPanelLogicId(pSSysViewPanelLogic.getPSSysViewPanelLogicId());
                    bl = true;
                }
                if (StringHelper.compare((String)entityBase.getPSSysViewPanelLogicName(), (String)pSSysViewPanelLogic.getPSSysViewPanelLogicName(), (boolean)false) != 0) {
                    entityBase.setPSSysViewPanelLogicName(pSSysViewPanelLogic.getPSSysViewPanelLogicName());
                    bl = true;
                }
                string3 = xmlNode2.getAttribute("SRCENDPOINT", "");
                string2 = xmlNode2.getAttribute("DSTENDPOINT", "");
                String string5 = xmlNode2.getAttribute("SRCPSPANELLOGICNODEID", "");
                String string6 = xmlNode2.getAttribute("DSTPSPANELLOGICNODEID", "");
                if (StringHelper.compare((String)entityBase.getSrcEndPoint(), (String)string3, (boolean)false) != 0) {
                    entityBase.setSrcEndPoint(string3);
                    bl = true;
                }
                if (StringHelper.compare((String)entityBase.getDstEndPoint(), (String)string2, (boolean)false) != 0) {
                    entityBase.setDstEndPoint(string2);
                    bl = true;
                }
                if (StringHelper.compare((String)entityBase.getSrcPSPanelLogicNodeId(), (String)string5, (boolean)false) != 0) {
                    entityBase.setSrcPSPanelLogicNodeId(string5);
                    bl = true;
                }
                if (StringHelper.compare((String)entityBase.getDstPSPanelLogicNodeId(), (String)string6, (boolean)false) != 0) {
                    entityBase.setDstPSPanelLogicNodeId(string6);
                    bl = true;
                }
                if (bl) {
                    pSPanelLogicLinkService.updateTemp((IEntity)entityBase);
                }
                xmlNode2.resetAttributes();
                entityBase.fillXmlNode(xmlNode2, false);
                arrayList2.add(xmlNode2);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
            for (XmlNode xmlNode3 : arrayList2) {
                xmlNode.addNode(xmlNode3);
            }
        }
    }

    @Override
    public void createWithModel(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        final PSSysViewPanelLogic pSSysViewPanelLogic2 = pSSysViewPanelLogic;
        log.debug((Object)"\u5f00\u59cb[createWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPanelLogicLink pSPanelLogicLink2;
                PSPanelLogicNodeService pSPanelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService((String)PSPanelLogicNodeService.class.getCanonicalName(), (SessionFactory)PSSysViewPanelLogicService.this.getSessionFactory());
                ArrayList<PSPanelLogicNode> arrayList = pSPanelLogicNodeService.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogic2);
                HashMap<String, PSPanelLogicNode> hashMap = new HashMap<String, PSPanelLogicNode>();
                for (PSPanelLogicNode serializable2 : arrayList) {
                    hashMap.put(serializable2.getPSPanelLogicNodeId(), serializable2);
                }
                PSPanelLogicLinkService pSPanelLogicLinkService = (PSPanelLogicLinkService)ServiceGlobal.getService((String)PSPanelLogicLinkService.class.getCanonicalName(), (SessionFactory)PSSysViewPanelLogicService.this.getSessionFactory());
                ArrayList<PSPanelLogicLink> arrayList2 = pSPanelLogicLinkService.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogic2);
                HashMap<String, PSPanelLogicLink> hashMap2 = new HashMap<String, PSPanelLogicLink>();
                for (PSPanelLogicLink pSPanelLogicLink2 : arrayList2) {
                    hashMap2.put(pSPanelLogicLink2.getPSPanelLogicLinkId(), pSPanelLogicLink2);
                }
                String string = pSSysViewPanelLogic2.getLogicModel();
                pSPanelLogicLink2 = XmlNode.loadFromXML((String)string);
                if (pSPanelLogicLink2 != null) {
                    pSPanelLogicLink2.setAttribute("PSDEID", pSSysViewPanelLogic2.getPSDEId());
                    pSPanelLogicLink2.setAttribute("PSSYSVIEWPANELLOGICID", pSSysViewPanelLogic2.getPSSysViewPanelLogicId());
                    PSSysViewPanelLogicService.this.updatePSSysViewPanelLogicModel(pSSysViewPanelLogic2, (XmlNode)pSPanelLogicLink2, hashMap, hashMap2);
                    pSSysViewPanelLogic2.setLogicModel(XmlNode.export((XmlNode)pSPanelLogicLink2));
                } else {
                    pSSysViewPanelLogic2.setLogicModel(null);
                }
                if (hashMap2.size() > 0) {
                    for (EntityBase entityBase : hashMap2.values()) {
                        pSPanelLogicLinkService.removeTemp((IEntity)entityBase);
                    }
                }
                if (hashMap.size() > 0) {
                    for (EntityBase entityBase : hashMap.values()) {
                        pSPanelLogicNodeService.removeTemp((IEntity)entityBase);
                    }
                }
                PSSysViewPanelLogicService.this.createTemp(pSSysViewPanelLogic2);
            }
        });
    }

    @Override
    public void getDraftTemp(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        super.getDraftTemp(pSSysViewPanelLogic);
        if (StringHelper.isNullOrEmpty((String)pSSysViewPanelLogic.getPSDEId()) && pSSysViewPanelLogic.getPSSysViewPanel() != null) {
            pSSysViewPanelLogic.setPSDEId(pSSysViewPanelLogic.getPSSysViewPanel().getPSDEId());
            pSSysViewPanelLogic.setPSDEName(pSSysViewPanelLogic.getPSSysViewPanel().getPSDEName());
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysViewPanelLogic.getPSSysViewPanelId())) {
            pSSysViewPanelLogic.setLogicType("CTRLEVENT");
        }
    }

    @Override
    public void getDraftWithModel(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        this.getDraftTemp(pSSysViewPanelLogic);
        pSSysViewPanelLogic.setLogicModel(this.getLogicModel(pSSysViewPanelLogic));
    }

    @Override
    public void getDraftFromWithModel(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        super.getDraftTempFrom(pSSysViewPanelLogic);
        pSSysViewPanelLogic.setLogicModel(this.getLogicModel(pSSysViewPanelLogic));
    }

    @Override
    protected void onAfterGetDraftTemp(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        super.onAfterGetDraftTemp(pSSysViewPanelLogic);
    }

    @Override
    protected void onBeforeCreate(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        pSSysViewPanelLogic.setLogicModel(null);
        super.onBeforeCreate(pSSysViewPanelLogic);
    }

    @Override
    protected void onBeforeUpdate(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        pSSysViewPanelLogic.setLogicModel(null);
        super.onBeforeUpdate(pSSysViewPanelLogic);
    }

    @Override
    protected ArrayList<PSPanelLogicLink> updateRelatedDataTempMajor_removePSPanelLogicLink(PSSysViewPanelLogic pSSysViewPanelLogic, PSSysViewPanelLogic pSSysViewPanelLogic2) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
            return null;
        }
        return super.updateRelatedDataTempMajor_removePSPanelLogicLink(pSSysViewPanelLogic, pSSysViewPanelLogic2);
    }

    @Override
    protected ArrayList<PSPanelLogicNode> updateRelatedDataTempMajor_removePSPanelLogicNode(PSSysViewPanelLogic pSSysViewPanelLogic, PSSysViewPanelLogic pSSysViewPanelLogic2) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
            return null;
        }
        return super.updateRelatedDataTempMajor_removePSPanelLogicNode(pSSysViewPanelLogic, pSSysViewPanelLogic2);
    }

    @Override
    protected ArrayList<PSPanelLogicParam> updateRelatedDataTempMajor_removePSPanelLogicParam(PSSysViewPanelLogic pSSysViewPanelLogic, PSSysViewPanelLogic pSSysViewPanelLogic2) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
            return null;
        }
        return super.updateRelatedDataTempMajor_removePSPanelLogicParam(pSSysViewPanelLogic, pSSysViewPanelLogic2);
    }

    @Override
    protected void updateRelatedDataTempMajor_updatePSPanelLogicLink(PSSysViewPanelLogic pSSysViewPanelLogic, PSSysViewPanelLogic pSSysViewPanelLogic2, ArrayList<PSPanelLogicLink> arrayList) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
            return;
        }
        super.updateRelatedDataTempMajor_updatePSPanelLogicLink(pSSysViewPanelLogic, pSSysViewPanelLogic2, arrayList);
    }

    @Override
    protected void updateRelatedDataTempMajor_updatePSPanelLogicNode(PSSysViewPanelLogic pSSysViewPanelLogic, PSSysViewPanelLogic pSSysViewPanelLogic2, ArrayList<PSPanelLogicNode> arrayList) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
            return;
        }
        super.updateRelatedDataTempMajor_updatePSPanelLogicNode(pSSysViewPanelLogic, pSSysViewPanelLogic2, arrayList);
    }

    @Override
    protected void updateRelatedDataTempMajor_updatePSPanelLogicParam(PSSysViewPanelLogic pSSysViewPanelLogic, PSSysViewPanelLogic pSSysViewPanelLogic2, ArrayList<PSPanelLogicParam> arrayList) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
            return;
        }
        super.updateRelatedDataTempMajor_updatePSPanelLogicParam(pSSysViewPanelLogic, pSSysViewPanelLogic2, arrayList);
    }

    @Override
    protected void getRelatedDataTempMajor_PSPanelLogicLink(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
            return;
        }
        super.getRelatedDataTempMajor_PSPanelLogicLink(pSSysViewPanelLogic);
    }

    @Override
    protected void getRelatedDataTempMajor_PSPanelLogicNode(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
            return;
        }
        super.getRelatedDataTempMajor_PSPanelLogicNode(pSSysViewPanelLogic);
    }

    @Override
    protected void getRelatedDataTempMajor_PSPanelLogicParam(PSSysViewPanelLogic pSSysViewPanelLogic) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
            return;
        }
        super.getRelatedDataTempMajor_PSPanelLogicParam(pSSysViewPanelLogic);
    }
}

