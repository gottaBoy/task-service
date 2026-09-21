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
package net.ibizsys.pscore.srv.wfdesign.service;

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
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLink;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkCond;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcessBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkCondService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSWFLinkService
extends PSWFLinkServiceBase {
    public static final String XMLNODE_WFLINKCOND = "WFLINKCOND";
    private static final Log log = LogFactory.getLog(PSWFLinkService.class);

    @Override
    public void updateWithModel(PSWFLink pSWFLink) throws Exception {
        final PSWFLink pSWFLink2 = pSWFLink;
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService((String)PSWFLinkCondService.class.getCanonicalName(), (SessionFactory)PSWFLinkService.this.getSessionFactory());
                ArrayList<PSWFLinkCond> arrayList = pSWFLinkCondService.selectTempByPSWFLink(pSWFLink2);
                HashMap<String, PSWFLinkCond> hashMap = new HashMap<String, PSWFLinkCond>();
                for (PSWFLinkCond object2 : arrayList) {
                    hashMap.put(object2.getPSWFLinkCondId(), object2);
                }
                Object object3 = "";
                XmlNode xmlNode = new XmlNode();
                xmlNode.setNodeName(PSWFLinkService.XMLNODE_WFLINKCOND);
                xmlNode.setAttribute("PSWFLINKID", pSWFLink2.getPSWFLinkId());
                xmlNode.setAttribute("PSWFVERSIONID", pSWFLink2.getPSWFVersionId());
                xmlNode.setAttribute("PSWFID", pSWFLink2.getPSWFId());
                object3 = XmlNode.export((XmlNode)xmlNode);
                String string = pSWFLink2.getCondModel();
                XmlNode xmlNode2 = XmlNode.loadFromXML((String)string);
                if (xmlNode2 != null) {
                    PSWFLinkService.this.updatePSWFLinkConds(pSWFLink2, null, xmlNode2, hashMap);
                    xmlNode2.setAttribute("PSWFLINKID", pSWFLink2.getPSWFLinkId());
                    xmlNode2.setAttribute("PSWFVERSIONID", pSWFLink2.getPSWFVersionId());
                    xmlNode2.setAttribute("PSWFID", pSWFLink2.getPSWFId());
                    pSWFLink2.setCondModel(XmlNode.export((XmlNode)xmlNode2));
                } else {
                    pSWFLink2.setCondModel((String)object3);
                }
                if (hashMap.size() > 0) {
                    for (PSWFLinkCond pSWFLinkCond : hashMap.values()) {
                        pSWFLinkCondService.removeTemp((IEntity)pSWFLinkCond);
                    }
                }
                PSWFLinkService.this.updateTemp((IEntity)pSWFLink2);
            }
        });
    }

    protected void updatePSWFLinkConds(PSWFLink pSWFLink, PSWFLinkCond pSWFLinkCond, XmlNode xmlNode, HashMap<String, PSWFLinkCond> hashMap) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService((String)PSWFLinkCondService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            int n = 0;
            while (iterator.hasNext()) {
                PSWFLinkCond pSWFLinkCond2;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                String string = xmlNode2.getAttribute("PSWFLINKCONDID", "");
                if (StringHelper.isNullOrEmpty((String)string) || (pSWFLinkCond2 = hashMap.remove(string)) == null) continue;
                ++n;
                boolean bl = false;
                if (StringHelper.compare((String)pSWFLinkCond2.getPSWFLinkId(), (String)pSWFLink.getPSWFLinkId(), (boolean)false) != 0) {
                    pSWFLinkCond2.setPSWFLinkId(pSWFLink.getPSWFLinkId());
                    bl = true;
                }
                if (StringHelper.compare((String)pSWFLinkCond2.getPSWFLinkName(), (String)pSWFLink.getPSWFLinkName(), (boolean)false) != 0) {
                    pSWFLinkCond2.setPSWFLinkName(pSWFLink.getPSWFLinkName());
                    bl = true;
                }
                if (pSWFLinkCond != null) {
                    if (StringHelper.compare((String)pSWFLinkCond2.getPPSWFLinkCondId(), (String)pSWFLinkCond.getPSWFLinkCondId(), (boolean)false) != 0) {
                        pSWFLinkCond2.setPPSWFLinkCondId(pSWFLinkCond.getPSWFLinkCondId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)pSWFLinkCond2.getPPSWFLinkCondName(), (String)pSWFLinkCond.getPSWFLinkCondName(), (boolean)false) != 0) {
                        pSWFLinkCond2.setPPSWFLinkCondName(pSWFLinkCond.getPSWFLinkCondName());
                        bl = true;
                    }
                }
                if (pSWFLinkCond2.getOrderValue() == null || pSWFLinkCond2.getOrderValue() != n) {
                    pSWFLinkCond2.setOrderValue(n);
                    bl = true;
                }
                if (bl) {
                    pSWFLinkCondService.updateTemp((IEntity)pSWFLinkCond2);
                }
                xmlNode2.resetAttributes();
                pSWFLinkCond2.fillXmlNode(xmlNode2, false);
                arrayList.add(xmlNode2);
                this.updatePSWFLinkConds(pSWFLink, pSWFLinkCond2, xmlNode2, hashMap);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
        }
    }

    protected void createPSWFLinkConds(PSWFLink pSWFLink, String string, PSWFLinkCond pSWFLinkCond, XmlNode xmlNode) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService((String)PSWFLinkCondService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            int n = 0;
            while (iterator.hasNext()) {
                ++n;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSWFLinkCond pSWFLinkCond2 = new PSWFLinkCond();
                DataObject.fromXmlNode((IDataObject)pSWFLinkCond2, (XmlNode)xmlNode2);
                pSWFLinkCond2.resetPSWFLinkCondId();
                pSWFLinkCond2.resetPPSWFLinkCondId();
                pSWFLinkCond2.resetPPSWFLinkCondName();
                pSWFLinkCond2.setPSWFLinkId(pSWFLink.getPSWFLinkId());
                pSWFLinkCond2.setPSWFLinkName(pSWFLink.getPSWFLinkName());
                if (pSWFLinkCond != null) {
                    pSWFLinkCond2.setPPSWFLinkCondId(pSWFLinkCond.getPSWFLinkCondId());
                    pSWFLinkCond2.setPPSWFLinkCondName(pSWFLinkCond.getPSWFLinkCondName());
                }
                pSWFLinkCond2.setOrderValue(n);
                pSWFLinkCondService.create(pSWFLinkCond2);
                this.createPSWFLinkConds(pSWFLink, string, pSWFLinkCond2, xmlNode2);
            }
        }
    }

    @Override
    public void createWithModel(PSWFLink pSWFLink) throws Exception {
        this.updateWithModel(pSWFLink);
    }

    @Override
    public void getWithModel(PSWFLink pSWFLink) throws Exception {
        this.getTemp((IEntity)pSWFLink);
        if (StringHelper.isNullOrEmpty((String)pSWFLink.getCondModel())) {
            this.fillWFLinkModel(pSWFLink);
            this.updateTemp((IEntity)pSWFLink);
        }
    }

    protected void fillWFLinkModel(PSWFLink pSWFLink) throws Exception {
        PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService((String)PSWFLinkCondService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFLinkCond> arrayList = pSWFLinkCondService.selectTempByPSWFLink(pSWFLink, "ORDER BY ORDERVALUE");
        HashMap<String, XmlNode> hashMap = new HashMap<String, XmlNode>();
        for (PSWFLinkCond object : arrayList) {
            XmlNode xmlNode = new XmlNode();
            xmlNode.setNodeName(object.getLogicType());
            object.fillXmlNode(xmlNode, true);
            hashMap.put(object.getPSWFLinkCondId(), xmlNode);
        }
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_WFLINKCOND);
        xmlNode.setAttribute("PSWFLINKID", pSWFLink.getPSWFLinkId());
        xmlNode.setAttribute("PSWFVERSIONID", pSWFLink.getPSWFVersionId());
        xmlNode.setAttribute("PSWFID", pSWFLink.getPSWFId());
        for (PSWFLinkCond pSWFLinkCond : arrayList) {
            XmlNode xmlNode2 = (XmlNode)hashMap.get(pSWFLinkCond.getPSWFLinkCondId());
            if (StringHelper.isNullOrEmpty((String)pSWFLinkCond.getPPSWFLinkCondId())) {
                xmlNode.addNode(xmlNode2);
                continue;
            }
            XmlNode xmlNode3 = (XmlNode)hashMap.get(pSWFLinkCond.getPPSWFLinkCondId());
            if (xmlNode3 != null) {
                xmlNode3.addNode(xmlNode2);
                continue;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6d41\u7a0b\u8fde\u63a5\u7236\u903b\u8f91[%1$s], \u5f53\u524d[%2$s]", (Object)pSWFLinkCond.getPPSWFLinkCondId(), (Object)pSWFLinkCond.getPSWFLinkCondName()));
        }
        pSWFLink.setCondModel(XmlNode.export((XmlNode)xmlNode));
    }

    @Override
    protected void onBeforeGetDraftTemp(PSWFLink pSWFLink) throws Exception {
        super.onBeforeGetDraftTemp(pSWFLink);
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_WFLINKCOND);
        xmlNode.setAttribute("PSWFLINKID", pSWFLink.getPSWFLinkId());
        xmlNode.setAttribute("PSWFVERSIONID", pSWFLink.getPSWFVersionId());
        xmlNode.setAttribute("PSWFID", pSWFLink.getPSWFId());
        String string = XmlNode.export((XmlNode)xmlNode);
        pSWFLink.setCondModel(string);
    }

    @Override
    protected void onBeforeCreate(PSWFLink pSWFLink) throws Exception {
        pSWFLink.setCondModel(null);
        super.onBeforeCreate(pSWFLink);
    }

    @Override
    protected void onBeforeUpdate(PSWFLink pSWFLink) throws Exception {
        pSWFLink.setCondModel(null);
        super.onBeforeUpdate(pSWFLink);
    }

    @Override
    protected void onFillParentInfo_PSWFVersion(PSWFLink pSWFLink, PSWFVersion pSWFVersion) throws Exception {
        super.onFillParentInfo_PSWFVersion(pSWFLink, pSWFVersion);
        pSWFLink.setPSSystemId(pSWFVersion.getPSSystemId());
    }

    @Override
    protected void onBeforeCreateTemp(PSWFLink pSWFLink) throws Exception {
        pSWFLink.setLabel(this.calcPSWFLinkLabel(pSWFLink, null));
        super.onBeforeCreateTemp(pSWFLink);
    }

    @Override
    protected void onBeforeUpdateTemp(PSWFLink pSWFLink) throws Exception {
        pSWFLink.setLabel(this.calcPSWFLinkLabel(pSWFLink, (PSWFLink)this.getLast((IEntity)pSWFLink)));
        super.onBeforeUpdateTemp(pSWFLink);
    }

    protected String calcPSWFLinkLabel(PSWFLink pSWFLink, PSWFLink pSWFLink2) throws Exception {
        String string = "";
        if (pSWFLink.isWFLinkTypeDirty()) {
            string = pSWFLink.getWFLinkType();
        } else if (pSWFLink2 != null) {
            string = pSWFLink2.getWFLinkType();
        }
        Integer n = 0;
        if (pSWFLink.isOrderValueDirty()) {
            n = pSWFLink.getOrderValue();
        } else if (pSWFLink2 != null) {
            n = pSWFLink2.getOrderValue();
        }
        if (n == null) {
            n = 0;
        }
        if (StringHelper.compare((String)string, (String)"ROUTE", (boolean)true) == 0) {
            return StringHelper.format((String)"[\u5e38\u89c4]%1$s:%2$s", (Object)pSWFLink.getPSWFLinkName(), (Object)n);
        }
        if (StringHelper.compare((String)string, (String)"IAACTION", (boolean)true) == 0) {
            return StringHelper.format((String)"[\u4ea4\u4e92]%1$s:%2$s", (Object)pSWFLink.getLogicName(), (Object)n);
        }
        if (StringHelper.compare((String)string, (String)"WFRETURN", (boolean)true) == 0) {
            return StringHelper.format((String)"[\u6d41\u7a0b\u8fd4\u56de]%1$s:%2$s", (Object)pSWFLink.getPSWFLinkName(), (Object)n);
        }
        if (StringHelper.compare((String)string, (String)"TIMEOUT", (boolean)true) == 0) {
            return StringHelper.format((String)"[\u8d85\u65f6]");
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6d41\u7a0b\u8fde\u63a5\u7c7b\u578b[%1$s]", (Object)string));
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    @Override
    protected void importCurXmlModel(PSWFLink pSWFLink, XmlNode xmlNode) throws Exception {
        Object object;
        PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        String string = xmlNode.getAttribute("FROMPSWFPROCNAME", "");
        if (!StringHelper.isNullOrEmpty((String)string)) {
            object = new PSWFProcess();
            ((PSWFProcessBase)object).setPSWFProcessName(string);
            ((PSWFProcessBase)object).setPSWFVersionId(pSWFLink.getPSWFVersionId());
            pSWFProcessService.selectTemp(object, false);
            pSWFLink.setFromPSWFProcId(((PSWFProcessBase)object).getPSWFProcessId());
            xmlNode.setAttribute("FROMPSWFPROCID", ((PSWFProcessBase)object).getPSWFProcessId());
        }
        if (!StringHelper.isNullOrEmpty((String)(object = xmlNode.getAttribute("TOPSWFPROCNAME", "")))) {
            PSWFProcess pSWFProcess = new PSWFProcess();
            pSWFProcess.setPSWFProcessName((String)object);
            pSWFProcess.setPSWFVersionId(pSWFLink.getPSWFVersionId());
            pSWFProcessService.selectTemp(pSWFProcess, false);
            pSWFLink.setToPSWFProcId(pSWFProcess.getPSWFProcessId());
            xmlNode.setAttribute("TOPSWFPROCID", pSWFProcess.getPSWFProcessId());
        }
        super.importCurXmlModel(pSWFLink, xmlNode);
    }

    @Override
    protected void exportCurXmlModel(PSWFLink pSWFLink, XmlNode xmlNode, boolean bl) throws Exception {
        pSWFLink.setCondModel(null);
        super.exportCurXmlModel(pSWFLink, xmlNode, bl);
    }

    @Override
    public String getModelV2Tag(PSWFLink pSWFLink) {
        if (!StringHelper.isNullOrEmpty((String)pSWFLink.getFromPSWFProcName())) {
            if (!StringHelper.isNullOrEmpty((String)pSWFLink.getCodeName()) && !StringHelper.isNullOrEmpty((String)pSWFLink.getPSWFLinkName())) {
                return StringHelper.format((String)"%1$s[%2$s](%3$s)", (Object)pSWFLink.getFromPSWFProcName(), (Object)pSWFLink.getPSWFLinkName(), (Object)pSWFLink.getCodeName());
            }
            if (!StringHelper.isNullOrEmpty((String)pSWFLink.getCodeName())) {
                return StringHelper.format((String)"%1$s(%2$s)", (Object)pSWFLink.getFromPSWFProcName(), (Object)pSWFLink.getCodeName());
            }
            if (!StringHelper.isNullOrEmpty((String)pSWFLink.getPSWFLinkName())) {
                return StringHelper.format((String)"%1$s[%2$s]", (Object)pSWFLink.getFromPSWFProcName(), (Object)pSWFLink.getPSWFLinkName());
            }
        }
        if (!StringHelper.isNullOrEmpty((String)pSWFLink.getCodeName()) && !StringHelper.isNullOrEmpty((String)pSWFLink.getPSWFLinkName())) {
            return StringHelper.format((String)"%1$s(%2$s)", (Object)pSWFLink.getPSWFLinkName(), (Object)pSWFLink.getCodeName());
        }
        if (!StringHelper.isNullOrEmpty((String)pSWFLink.getCodeName())) {
            return pSWFLink.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSWFLink.getPSWFLinkName())) {
            return pSWFLink.getPSWFLinkName();
        }
        return super.getModelV2Tag(pSWFLink);
    }

    @Override
    protected void getRelatedDataTempMajor_PSWFLinkCond(PSWFLink pSWFLink) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFLinkCond> arrayList = null;
        String string = pSWFLink.getPSWFLinkId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSWFLinkCondService.selectByPSWFLink(pSWFLink) : pSWFLinkCondService.selectTempByPSWFLink(pSWFLink);
        PSWFLinkService.sortHierarchyEntities(arrayList, (String)"PSWFLINKCONDID", (String)"PPSWFLINKCONDID");
        for (PSWFLinkCond pSWFLinkCond : arrayList) {
            if (!StringHelper.isNullOrEmpty((String)pSWFLinkCond.getPSWFVersionId())) {
                if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSWFVERSION", (boolean)true) == 0) {
                    continue;
                }
            } else {
                pSWFLinkCond.setPSWFVersionId(pSWFLink.getPSWFVersionId());
            }
            pSWFLinkCondService.getTempMajor(pSWFLinkCond);
        }
    }

    @Override
    protected ArrayList<PSWFLinkCond> updateRelatedDataTempMajor_removePSWFLinkCond(PSWFLink pSWFLink, PSWFLink pSWFLink2) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSWFVERSION", (boolean)true) == 0) {
            return null;
        }
        return super.updateRelatedDataTempMajor_removePSWFLinkCond(pSWFLink, pSWFLink2);
    }

    @Override
    protected void updateRelatedDataTempMajor_updatePSWFLinkCond(PSWFLink pSWFLink, PSWFLink pSWFLink2, ArrayList<PSWFLinkCond> arrayList) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSWFVERSION", (boolean)true) == 0) {
            return;
        }
        super.updateRelatedDataTempMajor_updatePSWFLinkCond(pSWFLink, pSWFLink2, arrayList);
    }
}

