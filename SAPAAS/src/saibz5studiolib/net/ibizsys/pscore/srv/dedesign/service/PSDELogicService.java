/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
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
package net.ibizsys.pscore.srv.dedesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicLink;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicParam;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicLinkService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDELogicService
extends PSDELogicServiceBase {
    public static final String XMLNODE_DELOGIC = "DELOGIC";
    public static final String XMLNODE_DELOGICNODE = "DELOGICNODE";
    public static final String XMLNODE_DELOGICLINK = "DELOGICLINK";
    private static final Log log = LogFactory.getLog(PSDELogicService.class);

    @Override
    public void getWithModel(PSDELogic pSDELogic) throws Exception {
        if (!KeyValueHelper.isTempKey((String)pSDELogic.getPSDELogicId())) {
            this.getTempMajor(pSDELogic);
        } else {
            this.getTemp((IEntity)pSDELogic);
        }
        pSDELogic.setLogicModel(this.getLogicModel(pSDELogic));
    }

    protected String getLogicModel(PSDELogic pSDELogic) throws Exception {
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_DELOGIC);
        xmlNode.setAttribute("PSDEID", pSDELogic.getPSDEId());
        xmlNode.setAttribute("PSDELOGICID", pSDELogic.getPSDELogicId());
        String string = pSDELogic.getLogicType();
        if (StringHelper.isNullOrEmpty((String)string)) {
            string = XMLNODE_DELOGIC;
        }
        xmlNode.setAttribute("LOGICTYPE", string);
        PSDELogicNodeService pSDELogicNodeService = (PSDELogicNodeService)ServiceGlobal.getService((String)PSDELogicNodeService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSDELogicNode> arrayList = pSDELogicNodeService.selectTempByPSDELogic(pSDELogic);
        for (PSDELogicNode serializable2 : arrayList) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName(XMLNODE_DELOGICNODE);
            serializable2.fillXmlNode(xmlNode2, true);
            xmlNode.addNode(xmlNode2);
        }
        PSDELogicLinkService pSDELogicLinkService = (PSDELogicLinkService)ServiceGlobal.getService((String)PSDELogicLinkService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSDELogicLink> arrayList2 = pSDELogicLinkService.selectTempByPSDELogic(pSDELogic);
        for (PSDELogicLink pSDELogicLink : arrayList2) {
            XmlNode xmlNode3 = new XmlNode();
            xmlNode3.setNodeName(XMLNODE_DELOGICLINK);
            pSDELogicLink.fillXmlNode(xmlNode3, true);
            xmlNode.addNode(xmlNode3);
        }
        return XmlNode.export((XmlNode)xmlNode);
    }

    @Override
    public void updateWithModel(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = new PSDELogic();
        pSDELogic.copyTo((IDataObject)pSDELogic2, false);
        this.getTemp((IEntity)pSDELogic2);
        final PSDELogic pSDELogic3 = pSDELogic;
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicLink pSDELogicLink2;
                PSDELogicNodeService pSDELogicNodeService = (PSDELogicNodeService)ServiceGlobal.getService((String)PSDELogicNodeService.class.getCanonicalName(), (SessionFactory)PSDELogicService.this.getSessionFactory());
                ArrayList<PSDELogicNode> arrayList = pSDELogicNodeService.selectTempByPSDELogic(pSDELogic3);
                HashMap<String, PSDELogicNode> hashMap = new HashMap<String, PSDELogicNode>();
                for (PSDELogicNode serializable2 : arrayList) {
                    hashMap.put(serializable2.getPSDELogicNodeId(), serializable2);
                }
                PSDELogicLinkService pSDELogicLinkService = (PSDELogicLinkService)ServiceGlobal.getService((String)PSDELogicLinkService.class.getCanonicalName(), (SessionFactory)PSDELogicService.this.getSessionFactory());
                ArrayList<PSDELogicLink> arrayList2 = pSDELogicLinkService.selectTempByPSDELogic(pSDELogic3);
                HashMap<String, PSDELogicLink> hashMap2 = new HashMap<String, PSDELogicLink>();
                for (PSDELogicLink pSDELogicLink2 : arrayList2) {
                    hashMap2.put(pSDELogicLink2.getPSDELogicLinkId(), pSDELogicLink2);
                }
                String string = pSDELogic3.getLogicModel();
                pSDELogicLink2 = XmlNode.loadFromXML((String)string);
                if (pSDELogicLink2 != null) {
                    pSDELogicLink2.setAttribute("PSDEID", pSDELogic3.getPSDEId());
                    pSDELogicLink2.setAttribute("PSDELOGICID", pSDELogic3.getPSDELogicId());
                    Object object = pSDELogic2.getLogicType();
                    if (StringHelper.isNullOrEmpty((String)object)) {
                        object = PSDELogicService.XMLNODE_DELOGIC;
                    }
                    pSDELogicLink2.setAttribute("LOGICTYPE", (String)object);
                    PSDELogicService.this.updatePSDELogicModel(pSDELogic3, (XmlNode)pSDELogicLink2, hashMap, hashMap2);
                    pSDELogic3.setLogicModel(XmlNode.export((XmlNode)pSDELogicLink2));
                } else {
                    pSDELogic3.setLogicModel(null);
                }
                if (hashMap2.size() > 0) {
                    for (EntityBase entityBase : hashMap2.values()) {
                        pSDELogicLinkService.removeTemp((IEntity)entityBase);
                    }
                }
                if (hashMap.size() > 0) {
                    for (EntityBase entityBase : hashMap.values()) {
                        pSDELogicNodeService.removeTemp((IEntity)entityBase);
                    }
                }
                PSDELogicService.this.updateTempMajor(pSDELogic3);
            }
        });
    }

    protected void updatePSDELogicModel(PSDELogic pSDELogic, XmlNode xmlNode, HashMap<String, PSDELogicNode> hashMap, HashMap<String, PSDELogicLink> hashMap2) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            ArrayList<Object> arrayList2 = new ArrayList<Object>();
            PSDELogicNodeService pSDELogicNodeService = (PSDELogicNodeService)ServiceGlobal.getService((String)PSDELogicNodeService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            PSDELogicLinkService pSDELogicLinkService = (PSDELogicLinkService)ServiceGlobal.getService((String)PSDELogicLinkService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            while (iterator.hasNext()) {
                String string;
                String string2;
                String string3;
                boolean bl;
                EntityBase entityBase;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                if (StringHelper.compare((String)xmlNode2.getNodeName(), (String)XMLNODE_DELOGICNODE, (boolean)true) == 0) {
                    int n;
                    String string4 = xmlNode2.getAttribute("PSDELOGICNODEID", "");
                    if (StringHelper.isNullOrEmpty((String)string4) || (entityBase = hashMap.remove(string4)) == null) continue;
                    bl = false;
                    if (StringHelper.compare((String)entityBase.getPSDELogicId(), (String)pSDELogic.getPSDELogicId(), (boolean)false) != 0) {
                        entityBase.setPSDELogicId(pSDELogic.getPSDELogicId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)entityBase.getPSDELogicName(), (String)pSDELogic.getPSDELogicName(), (boolean)false) != 0) {
                        entityBase.setPSDELogicName(pSDELogic.getPSDELogicName());
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
                        pSDELogicNodeService.updateTemp((IEntity)entityBase);
                    }
                    xmlNode2.resetAttributes();
                    entityBase.fillXmlNode(xmlNode2, false);
                    arrayList.add(xmlNode2);
                    continue;
                }
                if (StringHelper.compare((String)xmlNode2.getNodeName(), (String)XMLNODE_DELOGICLINK, (boolean)true) != 0 || StringHelper.isNullOrEmpty((String)(string = xmlNode2.getAttribute("PSDELOGICLINKID", ""))) || (entityBase = hashMap2.remove(string)) == null) continue;
                bl = false;
                if (StringHelper.compare((String)entityBase.getPSDELogicId(), (String)pSDELogic.getPSDELogicId(), (boolean)false) != 0) {
                    entityBase.setPSDELogicId(pSDELogic.getPSDELogicId());
                    bl = true;
                }
                if (StringHelper.compare((String)entityBase.getPSDELogicName(), (String)pSDELogic.getPSDELogicName(), (boolean)false) != 0) {
                    entityBase.setPSDELogicName(pSDELogic.getPSDELogicName());
                    bl = true;
                }
                string3 = xmlNode2.getAttribute("SRCENDPOINT", "");
                string2 = xmlNode2.getAttribute("DSTENDPOINT", "");
                String string5 = xmlNode2.getAttribute("SRCPSDELOGICNODEID", "");
                String string6 = xmlNode2.getAttribute("DSTPSDELOGICNODEID", "");
                if (StringHelper.compare((String)entityBase.getSrcEndPoint(), (String)string3, (boolean)false) != 0) {
                    entityBase.setSrcEndPoint(string3);
                    bl = true;
                }
                if (StringHelper.compare((String)entityBase.getDstEndPoint(), (String)string2, (boolean)false) != 0) {
                    entityBase.setDstEndPoint(string2);
                    bl = true;
                }
                if (StringHelper.compare((String)entityBase.getSrcPSDELogicNodeId(), (String)string5, (boolean)false) != 0) {
                    entityBase.setSrcPSDELogicNodeId(string5);
                    bl = true;
                }
                if (StringHelper.compare((String)entityBase.getDstPSDELogicNodeId(), (String)string6, (boolean)false) != 0) {
                    entityBase.setDstPSDELogicNodeId(string6);
                    bl = true;
                }
                if (bl) {
                    pSDELogicLinkService.updateTemp((IEntity)entityBase);
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
    public void createWithModel(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        log.debug((Object)"\u5f00\u59cb[createWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELogicLink pSDELogicLink2;
                PSDELogicNodeService pSDELogicNodeService = (PSDELogicNodeService)ServiceGlobal.getService((String)PSDELogicNodeService.class.getCanonicalName(), (SessionFactory)PSDELogicService.this.getSessionFactory());
                ArrayList<PSDELogicNode> arrayList = pSDELogicNodeService.selectTempByPSDELogic(pSDELogic2);
                HashMap<String, PSDELogicNode> hashMap = new HashMap<String, PSDELogicNode>();
                for (PSDELogicNode serializable2 : arrayList) {
                    hashMap.put(serializable2.getPSDELogicNodeId(), serializable2);
                }
                PSDELogicLinkService pSDELogicLinkService = (PSDELogicLinkService)ServiceGlobal.getService((String)PSDELogicLinkService.class.getCanonicalName(), (SessionFactory)PSDELogicService.this.getSessionFactory());
                ArrayList<PSDELogicLink> arrayList2 = pSDELogicLinkService.selectTempByPSDELogic(pSDELogic2);
                HashMap<String, PSDELogicLink> hashMap2 = new HashMap<String, PSDELogicLink>();
                for (PSDELogicLink pSDELogicLink2 : arrayList2) {
                    hashMap2.put(pSDELogicLink2.getPSDELogicLinkId(), pSDELogicLink2);
                }
                String string = pSDELogic2.getLogicModel();
                pSDELogicLink2 = XmlNode.loadFromXML((String)string);
                if (pSDELogicLink2 != null) {
                    pSDELogicLink2.setAttribute("PSDEID", pSDELogic2.getPSDEId());
                    pSDELogicLink2.setAttribute("PSDELOGICID", pSDELogic2.getPSDELogicId());
                    PSDELogicService.this.updatePSDELogicModel(pSDELogic2, (XmlNode)pSDELogicLink2, hashMap, hashMap2);
                    pSDELogic2.setLogicModel(XmlNode.export((XmlNode)pSDELogicLink2));
                } else {
                    pSDELogic2.setLogicModel(null);
                }
                if (hashMap2.size() > 0) {
                    for (EntityBase entityBase : hashMap2.values()) {
                        pSDELogicLinkService.removeTemp((IEntity)entityBase);
                    }
                }
                if (hashMap.size() > 0) {
                    for (EntityBase entityBase : hashMap.values()) {
                        pSDELogicNodeService.removeTemp((IEntity)entityBase);
                    }
                }
                PSDELogicService.this.createTempMajor((IEntity)pSDELogic2);
            }
        });
    }

    @Override
    public void getDraftWithModel(PSDELogic pSDELogic) throws Exception {
        this.getDraftTempMajor((IEntity)pSDELogic);
        pSDELogic.setLogicModel(this.getLogicModel(pSDELogic));
    }

    @Override
    public void getDraftFromWithModel(PSDELogic pSDELogic) throws Exception {
        super.getDraftTempMajorFrom(pSDELogic);
        pSDELogic.setLogicModel(this.getLogicModel(pSDELogic));
    }

    @Override
    protected void onAfterGetDraftTemp(PSDELogic pSDELogic) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase;
        EntityBase entityBase;
        super.onAfterGetDraftTemp(pSDELogic);
        if (StringHelper.isNullOrEmpty((String)pSDELogic.getPSSystemId())) {
            this.fillPSSystemId(pSDELogic);
        }
        if (StringHelper.compare((String)pSDELogic.getLogicType(), (String)"MAINSTATELOGIC", (boolean)true) != 0 && StringHelper.compare((String)pSDELogic.getLogicType(), (String)"DATAFLOWLOGIC", (boolean)true) != 0) {
            entityBase = new PSDELogicNode();
            entityBase.setLogicNodeType("BEGIN");
            entityBase.setPSDELogicNodeName("\u5f00\u59cb");
            entityBase.setCodeName("Begin");
            entityBase.setParallelOutput(1);
            entityBase.setPSDELogicId(pSDELogic.getPSDELogicId());
            entityBase.setLeftPos(200);
            entityBase.setTopPos(200);
            entityBase.setPSSystemId(pSDELogic.getPSSystemId());
            pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
            pSCoreSysServiceBase.createTemp(entityBase);
        }
        if (StringHelper.compare((String)pSDELogic.getLogicType(), (String)"DATAFLOWLOGIC", (boolean)true) != 0 && StringHelper.compare((String)pSDELogic.getLogicType(), (String)"MAINSTATELOGIC", (boolean)true) != 0) {
            entityBase = new PSDELogicParam();
            entityBase.setPSDELogicParamName("Default");
            entityBase.setPSDELogicId(pSDELogic.getPSDELogicId());
            if (StringHelper.compare((String)pSDELogic.getLogicType(), (String)"VIEWLOGIC", (boolean)true) != 0) {
                entityBase.setParamPSDEId(pSDELogic.getPSDEId());
                entityBase.setParamPSDEName(pSDELogic.getPSDEName());
            }
            entityBase.setLogicName("\u4f20\u5165\u53d8\u91cf");
            entityBase.setPSSystemId(pSDELogic.getPSSystemId());
            entityBase.setDefaultParam(1);
            pSCoreSysServiceBase = (PSDELogicParamService)ServiceGlobal.getService(PSDELogicParamService.class, (SessionFactory)this.getSessionFactory());
            pSCoreSysServiceBase.createTemp(entityBase);
        }
        if (StringHelper.compare((String)pSDELogic.getLogicType(), (String)"MAINSTATELOGIC", (boolean)true) != 0) {
            // empty if block
        }
    }

    @Override
    protected void onBeforeCreate(PSDELogic pSDELogic) throws Exception {
        pSDELogic.setLogicModel(null);
        if (StringHelper.isNullOrEmpty((String)pSDELogic.getPSSystemId())) {
            this.fillPSSystemId(pSDELogic);
        }
        super.onBeforeCreate(pSDELogic);
    }

    @Override
    protected void onBeforeUpdate(PSDELogic pSDELogic) throws Exception {
        pSDELogic.setLogicModel(null);
        super.onBeforeUpdate(pSDELogic);
    }

    @Override
    public String getModelV2Tag(PSDELogic pSDELogic) {
        if (!StringHelper.isNullOrEmpty((String)pSDELogic.getCodeName()) && !StringHelper.isNullOrEmpty((String)pSDELogic.getLogicType())) {
            if ("VIEWLOGIC".equals(pSDELogic.getLogicType())) {
                return StringHelper.format((String)"%1$s[U]", (Object)pSDELogic.getCodeName());
            }
            if ("MAINSTATELOGIC".equals(pSDELogic.getLogicType())) {
                return StringHelper.format((String)"%1$s[M]", (Object)pSDELogic.getCodeName());
            }
            if ("DATAFLOWLOGIC".equals(pSDELogic.getLogicType())) {
                return StringHelper.format((String)"%1$s[D]", (Object)pSDELogic.getCodeName());
            }
        }
        return super.getModelV2Tag(pSDELogic);
    }

    protected void fillPSSystemId(PSDELogic pSDELogic) throws Exception {
        pSDELogic.setPSSystemId(PSDELogicService.getCurrentPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)pSDELogic.getPSSystemId())) {
            return;
        }
        if (pSDELogic.getPSDE() != null) {
            pSDELogic.setPSSystemId(pSDELogic.getPSDE().getPSSystemId());
            return;
        }
        if (pSDELogic.getPSModule() != null) {
            pSDELogic.setPSSystemId(pSDELogic.getPSModule().getPSSystemId());
            return;
        }
    }
}

