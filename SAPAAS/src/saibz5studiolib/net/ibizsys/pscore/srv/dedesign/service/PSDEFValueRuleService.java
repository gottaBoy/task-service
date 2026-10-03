/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
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
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFVRCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFVRCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEFValueRuleService
extends PSDEFValueRuleServiceBase {
    private static final Log log = LogFactory.getLog(PSDEFValueRuleService.class);

    @Override
    public void getWithModel(PSDEFValueRule pSDEFValueRule) throws Exception {
        if (!KeyValueHelper.isTempKey((String)pSDEFValueRule.getPSDEFValueRuleId())) {
            this.getTempMajor(pSDEFValueRule);
        } else {
            this.getTemp(pSDEFValueRule);
        }
        pSDEFValueRule.setVRModel(this.getVRModel(pSDEFValueRule));
    }

    protected String getVRModel(PSDEFValueRule pSDEFValueRule) throws Exception {
        PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService((String)PSDEFVRCondService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFVRCond> arrayList = pSDEFVRCondService.selectTempByPSDEFVR(pSDEFValueRule, "ORDER BY ORDERVALUE");
        HashMap<String, XmlNode> hashMap = new HashMap<String, XmlNode>();
        for (PSDEFVRCond entityBase2 : arrayList) {
            XmlNode xmlNode = new XmlNode();
            xmlNode.setNodeName(entityBase2.getCondType());
            entityBase2.fillXmlNode(xmlNode, true);
            hashMap.put(entityBase2.getPSDEFVRCondId(), xmlNode);
        }
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName("DEFVR");
        PSSystem pSSystem = pSDEFValueRule.getPSDE().getPSSystem();
        xmlNode.setAttribute("PSSYSTEMID", pSSystem.getPSSystemId());
        xmlNode.setAttribute("PSDEID", pSDEFValueRule.getPSDEId());
        if (!StringHelper.isNullOrEmpty((String)pSSystem.getPSDevSlnSysId())) {
            xmlNode.setAttribute("PSDEVSLNSYSID", pSSystem.getPSDevSlnSysId());
            xmlNode.setAttribute("TASKSERVERURL", pSSystem.getPSDevCenterTS().getPSTaskServer().getServerUrl());
        } else {
            xmlNode.setAttribute("PSDEVSLNSYSID", "");
            xmlNode.setAttribute("TASKSERVERURL", "http://lionlau-w530:8000/SAEAM/");
        }
        xmlNode.setAttribute("PSDEFID", pSDEFValueRule.getPSDEFId());
        xmlNode.setAttribute("PSDEFVALUERULEID", pSDEFValueRule.getPSDEFValueRuleId());
        xmlNode.setAttribute("PSDEFVRID", pSDEFValueRule.getPSDEFValueRuleId());
        for (PSDEFVRCond pSDEFVRCond : arrayList) {
            XmlNode xmlNode2 = (XmlNode)hashMap.get(pSDEFVRCond.getPSDEFVRCondId());
            if (StringHelper.isNullOrEmpty((String)pSDEFVRCond.getPPSDEFVRCondId())) {
                xmlNode.addNode(xmlNode2);
                continue;
            }
            XmlNode xmlNode3 = (XmlNode)hashMap.get(pSDEFVRCond.getPPSDEFVRCondId());
            if (xmlNode3 != null) {
                xmlNode3.addNode(xmlNode2);
                continue;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7236\u89c4\u5219\u9879[%1$s], \u5f53\u524d[%2$s]", (Object)pSDEFVRCond.getPPSDEFVRCondId(), (Object)pSDEFVRCond.getPSDEFVRCondName()));
        }
        return XmlNode.export((XmlNode)xmlNode);
    }

    @Override
    public void updateWithModel(PSDEFValueRule pSDEFValueRule) throws Exception {
        final PSDEFValueRule pSDEFValueRule2 = pSDEFValueRule;
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService((String)PSDEFVRCondService.class.getCanonicalName(), (SessionFactory)PSDEFValueRuleService.this.getSessionFactory());
                ArrayList<PSDEFVRCond> arrayList = pSDEFVRCondService.selectTempByPSDEFVR(pSDEFValueRule2);
                HashMap<String, PSDEFVRCond> hashMap = new HashMap<String, PSDEFVRCond>();
                for (PSDEFVRCond pSDEFVRCond2 : arrayList) {
                    hashMap.put(pSDEFVRCond2.getPSDEFVRCondId(), pSDEFVRCond2);
                }
                String string = pSDEFValueRule2.getVRModel();
                XmlNode xmlNode = XmlNode.loadFromXML((String)string);
                if (xmlNode != null) {
                    xmlNode.setAttribute("PSDEFID", pSDEFValueRule2.getPSDEFId());
                    xmlNode.setAttribute("PSDEFVALUERULEID", pSDEFValueRule2.getPSDEFValueRuleId());
                    xmlNode.setAttribute("PSDEFVRID", pSDEFValueRule2.getPSDEFValueRuleId());
                    PSDEFValueRuleService.this.updatePSDEFVRConds(pSDEFValueRule2, null, xmlNode, hashMap);
                    pSDEFValueRule2.setVRModel(XmlNode.export(xmlNode));
                } else {
                    pSDEFValueRule2.setVRModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSDEFVRCond pSDEFVRCond3 : hashMap.values()) {
                        pSDEFVRCondService.removeTemp(pSDEFVRCond3);
                    }
                }
                PSDEFValueRuleService.this.updateTempMajor(pSDEFValueRule2);
            }
        });
    }

    protected void updatePSDEFVRConds(PSDEFValueRule pSDEFValueRule, PSDEFVRCond pSDEFVRCond, XmlNode xmlNode, HashMap<String, PSDEFVRCond> hashMap) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<XmlNode> arrayList = new ArrayList<XmlNode>();
            PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService((String)PSDEFVRCondService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            int n = 0;
            while (iterator.hasNext()) {
                PSDEFVRCond pSDEFVRCond2;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                String string = xmlNode2.getAttribute("PSDEFVRCONDID", "");
                if (StringHelper.isNullOrEmpty((String)string) || (pSDEFVRCond2 = hashMap.remove(string)) == null) continue;
                ++n;
                boolean bl = false;
                if (StringHelper.compare((String)pSDEFVRCond2.getPSDEFVRId(), (String)pSDEFValueRule.getPSDEFValueRuleId(), (boolean)false) != 0) {
                    pSDEFVRCond2.setPSDEFVRId(pSDEFValueRule.getPSDEFValueRuleId());
                    bl = true;
                }
                if (StringHelper.compare((String)pSDEFVRCond2.getPSDEFVRName(), (String)pSDEFValueRule.getPSDEFValueRuleName(), (boolean)false) != 0) {
                    pSDEFVRCond2.setPSDEFVRName(pSDEFValueRule.getPSDEFValueRuleName());
                    bl = true;
                }
                if (pSDEFVRCond != null) {
                    if (StringHelper.compare((String)pSDEFVRCond2.getPPSDEFVRCondId(), (String)pSDEFVRCond.getPSDEFVRCondId(), (boolean)false) != 0) {
                        pSDEFVRCond2.setPPSDEFVRCondId(pSDEFVRCond.getPSDEFVRCondId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)pSDEFVRCond2.getPPSDEFVRCondName(), (String)pSDEFVRCond.getPSDEFVRCondName(), (boolean)false) != 0) {
                        pSDEFVRCond2.setPPSDEFVRCondName(pSDEFVRCond.getPSDEFVRCondName());
                        bl = true;
                    }
                }
                if (pSDEFVRCond2.getOrderValue() == null || pSDEFVRCond2.getOrderValue() != n) {
                    pSDEFVRCond2.setOrderValue(n);
                    bl = true;
                }
                if (bl) {
                    pSDEFVRCondService.updateTemp(pSDEFVRCond2);
                }
                xmlNode2.resetAttributes();
                pSDEFVRCond2.fillXmlNode(xmlNode2, false);
                arrayList.add(xmlNode2);
                this.updatePSDEFVRConds(pSDEFValueRule, pSDEFVRCond2, xmlNode2, hashMap);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
        }
    }

    @Override
    public void createWithModel(PSDEFValueRule pSDEFValueRule) throws Exception {
        final PSDEFValueRule pSDEFValueRule2 = pSDEFValueRule;
        log.debug((Object)"\u5f00\u59cb[createWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService((String)PSDEFVRCondService.class.getCanonicalName(), (SessionFactory)PSDEFValueRuleService.this.getSessionFactory());
                ArrayList<PSDEFVRCond> arrayList = pSDEFVRCondService.selectTempByPSDEFVR(pSDEFValueRule2);
                HashMap<String, PSDEFVRCond> hashMap = new HashMap<String, PSDEFVRCond>();
                for (PSDEFVRCond pSDEFVRCond2 : arrayList) {
                    hashMap.put(pSDEFVRCond2.getPSDEFVRCondId(), pSDEFVRCond2);
                }
                String string = pSDEFValueRule2.getVRModel();
                XmlNode xmlNode = XmlNode.loadFromXML((String)string);
                if (xmlNode != null) {
                    xmlNode.setAttribute("PSDEFID", pSDEFValueRule2.getPSDEFId());
                    xmlNode.setAttribute("PSDEFVALUERULEID", pSDEFValueRule2.getPSDEFValueRuleId());
                    xmlNode.setAttribute("PSDEFVRID", pSDEFValueRule2.getPSDEFValueRuleId());
                    PSDEFValueRuleService.this.updatePSDEFVRConds(pSDEFValueRule2, null, xmlNode, hashMap);
                    pSDEFValueRule2.setVRModel(XmlNode.export(xmlNode));
                } else {
                    pSDEFValueRule2.setVRModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSDEFVRCond pSDEFVRCond3 : hashMap.values()) {
                        pSDEFVRCondService.removeTemp(pSDEFVRCond3);
                    }
                }
                PSDEFValueRuleService.this.createTempMajor(pSDEFValueRule2);
            }
        });
    }

    @Override
    public void previewSave(PSDEFValueRule pSDEFValueRule) throws Exception {
        final PSDEFValueRule pSDEFValueRule2 = pSDEFValueRule;
        log.debug((Object)"\u5f00\u59cb[previewSave]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService((String)PSDEFVRCondService.class.getCanonicalName(), (SessionFactory)PSDEFValueRuleService.this.getSessionFactory());
                ArrayList<PSDEFVRCond> arrayList = pSDEFVRCondService.selectTempByPSDEFVR(pSDEFValueRule2);
                HashMap<String, PSDEFVRCond> hashMap = new HashMap<String, PSDEFVRCond>();
                for (PSDEFVRCond pSDEFVRCond2 : arrayList) {
                    hashMap.put(pSDEFVRCond2.getPSDEFVRCondId(), pSDEFVRCond2);
                }
                Object object = pSDEFValueRule2.getVRModel();
                if (StringHelper.isNullOrEmpty((String)object)) {
                    object = WebContext.getCurrent().getPostValue("vrmodel");
                }
                XmlNode xmlNode = XmlNode.loadFromXML((String)object);
                if (xmlNode != null) {
                    PSDEFValueRuleService.this.updatePSDEFVRConds(pSDEFValueRule2, null, xmlNode, hashMap);
                    pSDEFValueRule2.setVRModel(XmlNode.export(xmlNode));
                } else {
                    pSDEFValueRule2.setVRModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSDEFVRCond pSDEFVRCond3 : hashMap.values()) {
                        pSDEFVRCondService.removeTemp(pSDEFVRCond3);
                    }
                }
            }
        });
    }

    @Override
    public void getDraftWithModel(PSDEFValueRule pSDEFValueRule) throws Exception {
        this.getDraftTempMajor(pSDEFValueRule);
        pSDEFValueRule.setVRModel(this.getVRModel(pSDEFValueRule));
    }

    @Override
    public void getDraftFromWithModel(PSDEFValueRule pSDEFValueRule) throws Exception {
        super.getDraftTempMajorFrom(pSDEFValueRule);
        pSDEFValueRule.setVRModel(this.getVRModel(pSDEFValueRule));
    }

    @Override
    protected void onBeforeCreate(PSDEFValueRule pSDEFValueRule) throws Exception {
        pSDEFValueRule.setVRModel(null);
        super.onBeforeCreate(pSDEFValueRule);
    }

    @Override
    protected void onBeforeUpdate(PSDEFValueRule pSDEFValueRule) throws Exception {
        pSDEFValueRule.setVRModel(null);
        super.onBeforeUpdate(pSDEFValueRule);
    }

    public void createDER1NDefaultVR(PSDER pSDER) throws Exception {
        PSDEFValueRule pSDEFValueRule = new PSDEFValueRule();
        pSDEFValueRule.setPSDEFValueRuleId(pSDER.getPSDERId());
        if (this.get(pSDEFValueRule, true)) {
            return;
        }
        if (StringHelper.isNullOrEmpty((String)pSDER.getPSDEDataSetId())) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53\u5173\u7cfb[%1$s]\u6ca1\u6709\u5b9a\u4e49\u6570\u636e\u96c6\u5408", (Object)pSDER.getPSDERName()));
        }
        PSDEField pSDEField = new PSDEField();
        pSDEField.setPSDEId(pSDER.getMinorPSDEId());
        pSDEField.setPSDEFieldName(pSDER.getDERFieldName().toUpperCase());
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        if (!pSDEFieldService.select(pSDEField, true)) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u4e0d\u5b58\u5728", (Object)pSDER.getMinorPSDEName(), (Object)pSDER.getDERFieldName()));
        }
        pSDEFValueRule.setPSDEFValueRuleName(StringHelper.format((String)"\u5b9e\u4f53\u5173\u7cfb[%1$s]\u9ed8\u8ba4\u5173\u7cfb\u503c\u89c4\u5219", (Object)pSDER.getPSDERName()));
        pSDEFValueRule.setPSDEId(pSDEField.getPSDEId());
        pSDEFValueRule.setPSDEName(pSDEField.getPSDEName());
        pSDEFValueRule.setPSDEFId(pSDEField.getPSDEFieldId());
        pSDEFValueRule.setPSDEFName(pSDEField.getPSDEFieldName());
        pSDEFValueRule.setCheckDefault(1);
        pSDEFValueRule.setDefaultMode(0);
        pSDEFValueRule.setCodeName(pSDER.getCodeName());
        pSDEFValueRule.setRuleInfo(StringHelper.format((String)"%1$s\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", (Object)pSDEField.getLogicName()));
        this.create(pSDEFValueRule);
        PSDEFVRCond pSDEFVRCond = new PSDEFVRCond();
        pSDEFVRCond.setCondType("VALUERANGE");
        pSDEFVRCond.setMajorPSDEId(pSDER.getMajorPSDEId());
        pSDEFVRCond.setMajorPSDEName(pSDER.getMajorPSDEName());
        pSDEFVRCond.setMajorPSDEDSId(pSDER.getPSDEDataSetId());
        pSDEFVRCond.setMajorPSDEDSName(pSDER.getPSDEDataSetName());
        pSDEFVRCond.setPSDEFVRId(pSDEFValueRule.getPSDEFValueRuleId());
        pSDEFVRCond.setOrderValue(100);
        pSDEFVRCond.setParam9(1);
        if (DataObject.getBoolValue((Integer)pSDER.getEnaExtRange(), (boolean)false)) {
            pSDEFVRCond.setExtMajorPSDEFId(pSDER.getEXTMajorPSDEFId());
            pSDEFVRCond.setExtMajorPSDEFName(pSDER.getEXTMajorPSDEFName());
            pSDEFVRCond.setExtMinorPSDEFId(pSDER.getEXTMinorPSDEFId());
            pSDEFVRCond.setExtMinorPSDEFName(pSDER.getEXTMinorPSDEFName());
        }
        pSDEFVRCond.setRuleInfo("\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d");
        PSDEFVRCondService pSDEFVRCondService = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        pSDEFVRCondService.create(pSDEFVRCond);
    }

    @Override
    public String getModelV2Tag(PSDEFValueRule pSDEFValueRule) {
        if (!StringHelper.isNullOrEmpty((String)pSDEFValueRule.getCodeName()) && !StringHelper.isNullOrEmpty((String)pSDEFValueRule.getPSDEFName())) {
            return StringHelper.format((String)"%1$s(%2$s)", (Object)pSDEFValueRule.getPSDEFName(), (Object)pSDEFValueRule.getCodeName());
        }
        return super.getModelV2Tag(pSDEFValueRule);
    }
}
