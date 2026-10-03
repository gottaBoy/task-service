/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.MDAjaxActionResult
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUCMap;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUCMapNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCaseRS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUCMapNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUCMapServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseRSService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysUCMapService
extends PSSysUCMapServiceBase {
    public static final String XMLNODE_UCCONFIG = "UCCONFIG";
    public static final String XMLNODE_UCNODE = "UCNODE";
    private static final Log log = LogFactory.getLog(PSSysUCMapService.class);

    @Override
    protected void onAddActors(PSSysUCMap pSSysUCMap) throws Exception {
    }

    @Override
    protected void onAddUserCases(PSSysUCMap pSSysUCMap) throws Exception {
        this.get(pSSysUCMap);
    }

    @Override
    public void getWithModel(PSSysUCMap pSSysUCMap) throws Exception {
        if (!KeyValueHelper.isTempKey((String)pSSysUCMap.getPSSysUCMapId())) {
            this.getTempMajor(pSSysUCMap);
        } else {
            this.getTemp(pSSysUCMap);
        }
        pSSysUCMap.setUCModel(this.getUCModel(pSSysUCMap));
    }

    @Override
    public void getWithModel2(PSSysUCMap pSSysUCMap) throws Exception {
        this.get(pSSysUCMap);
        pSSysUCMap.setUCModel(this.getUCModel(pSSysUCMap));
    }

    protected String getUCModel(PSSysUCMap pSSysUCMap) throws Exception {
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_UCCONFIG);
        xmlNode.setAttribute("PSSYSTEMID", pSSysUCMap.getPSSystemId());
        xmlNode.setAttribute("PSSYSUCMAPID", pSSysUCMap.getPSSysUCMapId());
        PSSysUCMapNodeService pSSysUCMapNodeService = (PSSysUCMapNodeService)ServiceGlobal.getService((String)PSSysUCMapNodeService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysUCMapNode> arrayList = null;
        arrayList = !KeyValueHelper.isTempKey((String)pSSysUCMap.getPSSysUCMapId()) ? pSSysUCMapNodeService.selectByPSSysUCMap(pSSysUCMap) : pSSysUCMapNodeService.selectTempByPSSysUCMap(pSSysUCMap);
        for (PSSysUCMapNode pSSysUCMapNode : arrayList) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName(XMLNODE_UCNODE);
            this.fillXmlNode(pSSysUCMapNode, xmlNode2, false);
            xmlNode.addNode(xmlNode2);
        }
        return XmlNode.export((XmlNode)xmlNode);
    }

    @Override
    public void updateWithModel(PSSysUCMap pSSysUCMap) throws Exception {
        final PSSysUCMap pSSysUCMap2 = pSSysUCMap;
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUCMapNodeService pSSysUCMapNodeService = (PSSysUCMapNodeService)ServiceGlobal.getService((String)PSSysUCMapNodeService.class.getCanonicalName(), (SessionFactory)PSSysUCMapService.this.getSessionFactory());
                ArrayList<PSSysUCMapNode> arrayList = pSSysUCMapNodeService.selectTempByPSSysUCMap(pSSysUCMap2);
                HashMap<String, PSSysUCMapNode> hashMap = new HashMap<String, PSSysUCMapNode>();
                for (PSSysUCMapNode pSSysUCMapNode2 : arrayList) {
                    hashMap.put(pSSysUCMapNode2.getPSSysUCMapNodeId(), pSSysUCMapNode2);
                }
                String string = pSSysUCMap2.getUCModel();
                XmlNode xmlNode = XmlNode.loadFromXML((String)string);
                if (xmlNode != null) {
                    xmlNode.setAttribute("PSSYSUCMAPID", pSSysUCMap2.getPSSysUCMapId());
                    xmlNode.setAttribute("PSSYSTEMID", pSSysUCMap2.getPSSystemId());
                    PSSysUCMapService.this.updatePSSysUCMapModel(pSSysUCMap2, xmlNode, hashMap);
                    pSSysUCMap2.setUCModel(XmlNode.export(xmlNode));
                } else {
                    pSSysUCMap2.setUCModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSSysUCMapNode pSSysUCMapNode3 : hashMap.values()) {
                        pSSysUCMapNodeService.removeTemp(pSSysUCMapNode3);
                    }
                }
                PSSysUCMapService.this.updateTempMajor(pSSysUCMap2);
            }
        });
    }

    protected void updatePSSysUCMapModel(PSSysUCMap pSSysUCMap, XmlNode xmlNode, HashMap<String, PSSysUCMapNode> hashMap) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<XmlNode> arrayList = new ArrayList<XmlNode>();
            PSSysUCMapNodeService pSSysUCMapNodeService = (PSSysUCMapNodeService)ServiceGlobal.getService((String)PSSysUCMapNodeService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            while (iterator.hasNext()) {
                int n;
                PSSysUCMapNode pSSysUCMapNode;
                String object;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                if (StringHelper.compare((String)xmlNode2.getNodeName(), (String)XMLNODE_UCNODE, (boolean)true) != 0 || StringHelper.isNullOrEmpty((String)(object = xmlNode2.getAttribute("PSSYSUCMAPNODEID", ""))) || (pSSysUCMapNode = hashMap.remove(object)) == null) continue;
                boolean bl = false;
                if (StringHelper.compare((String)pSSysUCMapNode.getPSSysUCMapId(), (String)pSSysUCMap.getPSSysUCMapId(), (boolean)false) != 0) {
                    pSSysUCMapNode.setPSSysUCMapId(pSSysUCMap.getPSSysUCMapId());
                    bl = true;
                }
                if (StringHelper.compare((String)pSSysUCMapNode.getPSSysUCMapName(), (String)pSSysUCMap.getPSSysUCMapName(), (boolean)false) != 0) {
                    pSSysUCMapNode.setPSSysUCMapName(pSSysUCMap.getPSSysUCMapName());
                    bl = true;
                }
                String string = xmlNode2.getAttribute("LEFTPOS", "");
                String string2 = xmlNode2.getAttribute("TOPPOS", "");
                if (!StringHelper.isNullOrEmpty((String)string)) {
                    n = Integer.parseInt(string);
                    if (pSSysUCMapNode.getLeftPos() == null || pSSysUCMapNode.getLeftPos() != n) {
                        pSSysUCMapNode.setLeftPos(n);
                        bl = true;
                    }
                }
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    n = Integer.parseInt(string2);
                    if (pSSysUCMapNode.getTopPos() == null || pSSysUCMapNode.getTopPos() != n) {
                        pSSysUCMapNode.setTopPos(n);
                        bl = true;
                    }
                }
                if (bl) {
                    pSSysUCMapNodeService.updateTemp(pSSysUCMapNode);
                }
                xmlNode2.resetAttributes();
                pSSysUCMapNode.fillXmlNode(xmlNode2, false);
                arrayList.add(xmlNode2);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
        }
    }

    @Override
    public void createWithModel(PSSysUCMap pSSysUCMap) throws Exception {
        final PSSysUCMap pSSysUCMap2 = pSSysUCMap;
        log.debug((Object)"\u5f00\u59cb[createWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUCMapNodeService pSSysUCMapNodeService = (PSSysUCMapNodeService)ServiceGlobal.getService((String)PSSysUCMapNodeService.class.getCanonicalName(), (SessionFactory)PSSysUCMapService.this.getSessionFactory());
                ArrayList<PSSysUCMapNode> arrayList = pSSysUCMapNodeService.selectTempByPSSysUCMap(pSSysUCMap2);
                HashMap<String, PSSysUCMapNode> hashMap = new HashMap<String, PSSysUCMapNode>();
                for (PSSysUCMapNode pSSysUCMapNode2 : arrayList) {
                    hashMap.put(pSSysUCMapNode2.getPSSysUCMapNodeId(), pSSysUCMapNode2);
                }
                String string = pSSysUCMap2.getUCModel();
                XmlNode xmlNode = XmlNode.loadFromXML((String)string);
                if (xmlNode != null) {
                    xmlNode.setAttribute("PSSYSTEMID", pSSysUCMap2.getPSSystemId());
                    xmlNode.setAttribute("PSSYSUCMAPID", pSSysUCMap2.getPSSysUCMapId());
                    PSSysUCMapService.this.updatePSSysUCMapModel(pSSysUCMap2, xmlNode, hashMap);
                    pSSysUCMap2.setUCModel(XmlNode.export(xmlNode));
                } else {
                    pSSysUCMap2.setUCModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSSysUCMapNode pSSysUCMapNode3 : hashMap.values()) {
                        pSSysUCMapNodeService.removeTemp(pSSysUCMapNode3);
                    }
                }
                PSSysUCMapService.this.createTempMajor(pSSysUCMap2);
            }
        });
    }

    @Override
    public void getDraftWithModel(PSSysUCMap pSSysUCMap) throws Exception {
        this.getDraftTempMajor(pSSysUCMap);
        pSSysUCMap.setUCModel(this.getUCModel(pSSysUCMap));
    }

    @Override
    protected void onAfterGetDraftTemp(PSSysUCMap pSSysUCMap) throws Exception {
        super.onAfterGetDraftTemp(pSSysUCMap);
    }

    @Override
    protected void onBeforeCreate(PSSysUCMap pSSysUCMap) throws Exception {
        pSSysUCMap.setUCModel(null);
        if (StringHelper.isNullOrEmpty((String)pSSysUCMap.getCodeName())) {
            PSSysUCMap pSSysUCMap2;
            String string = "UCMap";
            int n = 1;
            do {
                if (n > 1) {
                    string = StringHelper.format((String)"UCMap%1$s", (Object)n);
                }
                ++n;
                pSSysUCMap2 = new PSSysUCMap();
                pSSysUCMap2.setSessionFactory(this.getSessionFactory());
                pSSysUCMap2.setPSSystemId(pSSysUCMap.getPSSystemId());
                pSSysUCMap2.setCodeName(string);
            } while (pSSysUCMap2.select(true));
            pSSysUCMap.setCodeName(string);
        }
        super.onBeforeCreate(pSSysUCMap);
    }

    @Override
    protected void onBeforeUpdate(PSSysUCMap pSSysUCMap) throws Exception {
        pSSysUCMap.setUCModel(null);
        super.onBeforeUpdate(pSSysUCMap);
    }

    @Override
    public void getDraftFromWithModel(PSSysUCMap pSSysUCMap) throws Exception {
        super.getDraftTempMajorFrom(pSSysUCMap);
        pSSysUCMap.setUCModel(this.getUCModel(pSSysUCMap));
    }

    @Override
    protected void onCalcConnection(PSSysUCMap pSSysUCMap) throws Exception {
        if (WebContext.getCurrent() == null || WebContext.getCurrent().getCurAjaxActionResult() == null) {
            throw new Exception("\u8bf7\u6c42\u73af\u5883\u4e0d\u6b63\u786e");
        }
        this.autoGet(pSSysUCMap);
        MDAjaxActionResult mDAjaxActionResult = (MDAjaxActionResult)WebContext.getCurrent().getCurAjaxActionResult();
        PSSysUCMapNodeService pSSysUCMapNodeService = (PSSysUCMapNodeService)ServiceGlobal.getService((String)PSSysUCMapNodeService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysUCMapNode> arrayList = null;
        arrayList = !KeyValueHelper.isTempKey((String)pSSysUCMap.getPSSysUCMapId()) ? pSSysUCMapNodeService.selectByPSSysUCMap(pSSysUCMap) : pSSysUCMapNodeService.selectTempByPSSysUCMap(pSSysUCMap);
        HashMap<String, PSSysUCMapNode> hashMap = new HashMap<String, PSSysUCMapNode>();
        HashMap<String, PSSysUCMapNode> hashMap2 = new HashMap<String, PSSysUCMapNode>();
        for (PSSysUCMapNode pSSysUCMapNode2 : arrayList) {
            if (!StringHelper.isNullOrEmpty((String)pSSysUCMapNode2.getPSSysActorId())) {
                hashMap.put(pSSysUCMapNode2.getPSSysActorId(), pSSysUCMapNode2);
                continue;
            }
            if (StringHelper.isNullOrEmpty((String)pSSysUCMapNode2.getPSSysUserCaseId())) continue;
            hashMap2.put(pSSysUCMapNode2.getPSSysUserCaseId(), pSSysUCMapNode2);
        }
        PSSystem pSSystem = new PSSystem();
        pSSystem.setPSSystemId(pSSysUCMap.getPSSystemId());
        ICodeList iCodeList = CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.UseCaseRSTypeCodeListModel");
        PSSysUserCaseRSService pSSysUserCaseRSService = (PSSysUserCaseRSService)ServiceGlobal.getService(PSSysUserCaseRSService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysUserCaseRS> arrayList2 = pSSysUserCaseRSService.selectByPSSystem(pSSystem);
        for (PSSysUserCaseRS pSSysUserCaseRS : arrayList2) {
            PSSysUCMapNode pSSysUCMapNode3 = null;
            PSSysUCMapNode pSSysUCMapNode4 = null;
            if (!StringHelper.isNullOrEmpty((String)pSSysUserCaseRS.getPPSSysUserCaseId()) && (pSSysUCMapNode3 = (PSSysUCMapNode)hashMap2.get(pSSysUserCaseRS.getPPSSysUserCaseId())) == null || !StringHelper.isNullOrEmpty((String)pSSysUserCaseRS.getPPSSysActorId()) && (pSSysUCMapNode3 = (PSSysUCMapNode)hashMap.get(pSSysUserCaseRS.getPPSSysActorId())) == null || !StringHelper.isNullOrEmpty((String)pSSysUserCaseRS.getPSSysUserCaseId()) && (pSSysUCMapNode4 = (PSSysUCMapNode)hashMap2.get(pSSysUserCaseRS.getPSSysUserCaseId())) == null || !StringHelper.isNullOrEmpty((String)pSSysUserCaseRS.getPSSysActorId()) && (pSSysUCMapNode4 = (PSSysUCMapNode)hashMap.get(pSSysUserCaseRS.getPSSysActorId())) == null || pSSysUCMapNode3 == null || pSSysUCMapNode4 == null) continue;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object)"link");
            jSONObject.put("psucrsid", (Object)pSSysUserCaseRS.getPSSysUserCaseRSId());
            jSONObject.put("psucrsname", (Object)pSSysUserCaseRS.getPSSysUserCaseRSName());
            if (!StringHelper.isNullOrEmpty((String)pSSysUCMapNode3.getPSSysActorId())) {
                jSONObject.put("majorpsucobjname", (Object)pSSysUCMapNode3.getPSSysActorName());
                jSONObject.put("majorpsucobjid", (Object)pSSysUCMapNode3.getPSSysActorId());
            } else if (!StringHelper.isNullOrEmpty((String)pSSysUCMapNode3.getPSSysUserCaseId())) {
                jSONObject.put("majorpsucobjname", (Object)pSSysUCMapNode3.getPSSysUserCaseName());
                jSONObject.put("majorpsucobjid", (Object)pSSysUCMapNode3.getPSSysUserCaseId());
            }
            if (!StringHelper.isNullOrEmpty((String)pSSysUCMapNode4.getPSSysActorId())) {
                jSONObject.put("minorpsucobjname", (Object)pSSysUCMapNode4.getPSSysActorName());
                jSONObject.put("minorpsucobjid", (Object)pSSysUCMapNode4.getPSSysActorId());
            } else if (!StringHelper.isNullOrEmpty((String)pSSysUCMapNode4.getPSSysUserCaseId())) {
                jSONObject.put("minorpsucobjname", (Object)pSSysUCMapNode4.getPSSysUserCaseName());
                jSONObject.put("minorpsucobjid", (Object)pSSysUCMapNode4.getPSSysUserCaseId());
            }
            jSONObject.put("rstype", (Object)pSSysUserCaseRS.getRSType());
            jSONObject.put("rstypename", (Object)iCodeList.getCodeListText(pSSysUserCaseRS.getRSType(), true));
            jSONObject.put("frompsucnodeid", (Object)pSSysUCMapNode3.getPSSysUCMapNodeId());
            jSONObject.put("topsucnodeid", (Object)pSSysUCMapNode4.getPSSysUCMapNodeId());
            mDAjaxActionResult.getRows().add(jSONObject);
        }
    }
}
