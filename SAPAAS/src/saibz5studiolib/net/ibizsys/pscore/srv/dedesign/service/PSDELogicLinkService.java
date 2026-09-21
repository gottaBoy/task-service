/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
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
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELLCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicLink;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicNodeBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELLCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicLinkServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDELogicLinkService
extends PSDELogicLinkServiceBase {
    public static final String XMLNODE_DELLCOND = "DELLCOND";
    private static final Log log = LogFactory.getLog(PSDELogicLinkService.class);

    @Override
    public void updateWithModel(PSDELogicLink pSDELogicLink) throws Exception {
        final PSDELogicLink pSDELogicLink2 = pSDELogicLink;
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService((String)PSDELLCondService.class.getCanonicalName(), (SessionFactory)PSDELogicLinkService.this.getSessionFactory());
                ArrayList<PSDELLCond> arrayList = pSDELLCondService.selectTempByPSDELogicLink(pSDELogicLink2);
                HashMap<String, PSDELLCond> hashMap = new HashMap<String, PSDELLCond>();
                for (PSDELLCond object2 : arrayList) {
                    hashMap.put(object2.getPSDELLCondId(), object2);
                }
                Object object3 = "";
                XmlNode xmlNode = new XmlNode();
                xmlNode.setNodeName(PSDELogicLinkService.XMLNODE_DELLCOND);
                xmlNode.setAttribute("PSDELOGICLINKID", pSDELogicLink2.getPSDELogicLinkId());
                xmlNode.setAttribute("PSDELOGICID", pSDELogicLink2.getPSDELogicId());
                object3 = XmlNode.export((XmlNode)xmlNode);
                String string = pSDELogicLink2.getCondModel();
                XmlNode xmlNode2 = XmlNode.loadFromXML((String)string);
                if (xmlNode2 != null) {
                    PSDELogicLinkService.this.updatePSDELLConds(pSDELogicLink2, null, xmlNode2, hashMap);
                    xmlNode2.setAttribute("PSDELOGICLINKID", pSDELogicLink2.getPSDELogicLinkId());
                    xmlNode2.setAttribute("PSDELOGICID", pSDELogicLink2.getPSDELogicId());
                    pSDELogicLink2.setCondModel(XmlNode.export((XmlNode)xmlNode2));
                } else {
                    pSDELogicLink2.setCondModel((String)object3);
                }
                if (hashMap.size() > 0) {
                    for (PSDELLCond pSDELLCond : hashMap.values()) {
                        pSDELLCondService.removeTemp((IEntity)pSDELLCond);
                    }
                }
                PSDELogicLinkService.this.updateTemp((IEntity)pSDELogicLink2);
            }
        });
    }

    protected void updatePSDELLConds(PSDELogicLink pSDELogicLink, PSDELLCond pSDELLCond, XmlNode xmlNode, HashMap<String, PSDELLCond> hashMap) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService((String)PSDELLCondService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            int n = 0;
            while (iterator.hasNext()) {
                PSDELLCond pSDELLCond2;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                String string = xmlNode2.getAttribute("PSDELLCONDID", "");
                if (StringHelper.isNullOrEmpty((String)string) || (pSDELLCond2 = hashMap.remove(string)) == null) continue;
                ++n;
                boolean bl = false;
                if (StringHelper.compare((String)pSDELLCond2.getPSDELogicLinkId(), (String)pSDELogicLink.getPSDELogicLinkId(), (boolean)false) != 0) {
                    pSDELLCond2.setPSDELogicLinkId(pSDELogicLink.getPSDELogicLinkId());
                    bl = true;
                }
                if (StringHelper.compare((String)pSDELLCond2.getPSDELogicLinkName(), (String)pSDELogicLink.getPSDELogicLinkName(), (boolean)false) != 0) {
                    pSDELLCond2.setPSDELogicLinkName(pSDELogicLink.getPSDELogicLinkName());
                    bl = true;
                }
                if (pSDELLCond != null) {
                    if (StringHelper.compare((String)pSDELLCond2.getPPSDELLCondId(), (String)pSDELLCond.getPSDELLCondId(), (boolean)false) != 0) {
                        pSDELLCond2.setPPSDELLCondId(pSDELLCond.getPSDELLCondId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)pSDELLCond2.getPPSDELLCondName(), (String)pSDELLCond.getPSDELLCondName(), (boolean)false) != 0) {
                        pSDELLCond2.setPPSDELLCondName(pSDELLCond.getPSDELLCondName());
                        bl = true;
                    }
                }
                if (pSDELLCond2.getOrderValue() == null || pSDELLCond2.getOrderValue() != n) {
                    pSDELLCond2.setOrderValue(n);
                    bl = true;
                }
                if (bl) {
                    pSDELLCondService.updateTemp((IEntity)pSDELLCond2);
                }
                xmlNode2.resetAttributes();
                pSDELLCond2.fillXmlNode(xmlNode2, false);
                arrayList.add(xmlNode2);
                this.updatePSDELLConds(pSDELogicLink, pSDELLCond2, xmlNode2, hashMap);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
        }
    }

    protected void createPSDELLConds(PSDELogicLink pSDELogicLink, String string, PSDELLCond pSDELLCond, XmlNode xmlNode) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService((String)PSDELLCondService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            int n = 0;
            while (iterator.hasNext()) {
                ++n;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDELLCond pSDELLCond2 = new PSDELLCond();
                DataObject.fromXmlNode((IDataObject)pSDELLCond2, (XmlNode)xmlNode2);
                pSDELLCond2.resetPSDELLCondId();
                pSDELLCond2.resetPPSDELLCondId();
                pSDELLCond2.resetPPSDELLCondName();
                pSDELLCond2.setPSDELogicLinkId(pSDELogicLink.getPSDELogicLinkId());
                pSDELLCond2.setPSDELogicLinkName(pSDELogicLink.getPSDELogicLinkName());
                if (pSDELLCond != null) {
                    pSDELLCond2.setPPSDELLCondId(pSDELLCond.getPSDELLCondId());
                    pSDELLCond2.setPPSDELLCondName(pSDELLCond.getPSDELLCondName());
                }
                pSDELLCond2.setOrderValue(n);
                pSDELLCondService.create(pSDELLCond2);
                this.createPSDELLConds(pSDELogicLink, string, pSDELLCond2, xmlNode2);
            }
        }
    }

    @Override
    public void createWithModel(PSDELogicLink pSDELogicLink) throws Exception {
        this.updateWithModel(pSDELogicLink);
    }

    @Override
    protected void getRelatedDataTempMajor_PSDELLCond(PSDELogicLink pSDELogicLink) throws Exception {
        super.getRelatedDataTempMajor_PSDELLCond(pSDELogicLink);
    }

    @Override
    public void getWithModel(final PSDELogicLink pSDELogicLink) throws Exception {
        this.getTemp((IEntity)pSDELogicLink);
        if (StringHelper.isNullOrEmpty((String)pSDELogicLink.getCondModel())) {
            this.doServiceWork(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDELogicLinkService.this.setEnableStateInform(false);
                    PSDELogicLinkService.this.fillLogicLinkModel(pSDELogicLink);
                    PSDELogicLinkService.this.updateTemp((IEntity)pSDELogicLink);
                }
            });
        }
    }

    protected void fillLogicLinkModel(PSDELogicLink pSDELogicLink) throws Exception {
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService((String)PSDELLCondService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSDELLCond> arrayList = pSDELLCondService.selectTempByPSDELogicLink(pSDELogicLink, "ORDER BY ORDERVALUE");
        HashMap<String, XmlNode> hashMap = new HashMap<String, XmlNode>();
        for (PSDELLCond object : arrayList) {
            XmlNode xmlNode = new XmlNode();
            xmlNode.setNodeName(object.getLogicType());
            object.fillXmlNode(xmlNode, true);
            hashMap.put(object.getPSDELLCondId(), xmlNode);
        }
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_DELLCOND);
        xmlNode.setAttribute("PSDELOGICLINKID", pSDELogicLink.getPSDELogicLinkId());
        xmlNode.setAttribute("PSDELOGICID", pSDELogicLink.getPSDELogicId());
        for (PSDELLCond pSDELLCond : arrayList) {
            XmlNode xmlNode2 = (XmlNode)hashMap.get(pSDELLCond.getPSDELLCondId());
            if (StringHelper.isNullOrEmpty((String)pSDELLCond.getPPSDELLCondId())) {
                xmlNode.addNode(xmlNode2);
                continue;
            }
            XmlNode xmlNode3 = (XmlNode)hashMap.get(pSDELLCond.getPPSDELLCondId());
            if (xmlNode3 != null) {
                xmlNode3.addNode(xmlNode2);
                continue;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u903b\u8f91\u8fde\u63a5\u7236\u903b\u8f91[%1$s], \u5f53\u524d[%2$s]", (Object)pSDELLCond.getPPSDELLCondId(), (Object)pSDELLCond.getPSDELLCondName()));
        }
        pSDELogicLink.setCondModel(XmlNode.export((XmlNode)xmlNode));
    }

    @Override
    protected void onBeforeGetDraftTemp(PSDELogicLink pSDELogicLink) throws Exception {
        super.onBeforeGetDraftTemp(pSDELogicLink);
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_DELLCOND);
        xmlNode.setAttribute("PSDELOGICLINKID", pSDELogicLink.getPSDELogicLinkId());
        xmlNode.setAttribute("PSDELOGICID", pSDELogicLink.getPSDELogicId());
        String string = XmlNode.export((XmlNode)xmlNode);
        pSDELogicLink.setCondModel(string);
    }

    @Override
    protected void onBeforeCreate(PSDELogicLink pSDELogicLink) throws Exception {
        pSDELogicLink.setCondModel(null);
        super.onBeforeCreate(pSDELogicLink);
    }

    @Override
    protected void onBeforeUpdate(PSDELogicLink pSDELogicLink) throws Exception {
        pSDELogicLink.setCondModel(null);
        super.onBeforeUpdate(pSDELogicLink);
    }

    @Override
    protected void onBeforeCreateTemp(PSDELogicLink pSDELogicLink) throws Exception {
        pSDELogicLink.setLinkInfo(this.calcPSDELogicLinkLabel(pSDELogicLink, null));
        super.onBeforeCreateTemp(pSDELogicLink);
    }

    @Override
    protected void onBeforeUpdateTemp(PSDELogicLink pSDELogicLink) throws Exception {
        pSDELogicLink.setLinkInfo(this.calcPSDELogicLinkLabel(pSDELogicLink, (PSDELogicLink)this.getLast((IEntity)pSDELogicLink)));
        super.onBeforeUpdateTemp(pSDELogicLink);
    }

    protected String calcPSDELogicLinkLabel(PSDELogicLink pSDELogicLink, PSDELogicLink pSDELogicLink2) throws Exception {
        Integer n = 0;
        if (pSDELogicLink.isOrderValueDirty()) {
            n = pSDELogicLink.getOrderValue();
        } else if (pSDELogicLink2 != null) {
            n = pSDELogicLink2.getOrderValue();
        }
        if (n == null) {
            n = 0;
        }
        Integer n2 = 0;
        if (pSDELogicLink.isDefaultLinkDirty()) {
            n2 = pSDELogicLink.getDefaultLink();
        } else if (pSDELogicLink2 != null) {
            n2 = pSDELogicLink2.getDefaultLink();
        }
        if (n2 == 0) {
            return StringHelper.format((String)"%1$s:%2$s", (Object)pSDELogicLink.getPSDELogicLinkName(), (Object)n);
        }
        return StringHelper.format((String)"%1$s:%2$s:[\u9ed8\u8ba4]", (Object)pSDELogicLink.getPSDELogicLinkName(), (Object)n);
    }

    @Override
    protected void importCurXmlModel(PSDELogicLink pSDELogicLink, XmlNode xmlNode) throws Exception {
        Object object;
        PSDELogicNodeService pSDELogicNodeService = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        String string = xmlNode.getAttribute("SRCPSDELOGICNODENAME", "");
        if (!StringHelper.isNullOrEmpty((String)string)) {
            object = new PSDELogicNode();
            ((PSDELogicNodeBase)object).setPSDELogicNodeName(string);
            ((PSDELogicNodeBase)object).setPSDELogicId(pSDELogicLink.getPSDELogicId());
            pSDELogicNodeService.selectTemp(object, false);
            pSDELogicLink.setSrcPSDELogicNodeId(((PSDELogicNodeBase)object).getPSDELogicNodeId());
            xmlNode.setAttribute("SRCPSDELOGICNODEID", ((PSDELogicNodeBase)object).getPSDELogicNodeId());
        }
        if (!StringHelper.isNullOrEmpty((String)(object = xmlNode.getAttribute("DSTPSDELOGICNODENAME", "")))) {
            PSDELogicNode pSDELogicNode = new PSDELogicNode();
            pSDELogicNode.setPSDELogicNodeName((String)object);
            pSDELogicNode.setPSDELogicId(pSDELogicLink.getPSDELogicId());
            pSDELogicNodeService.selectTemp(pSDELogicNode, false);
            pSDELogicLink.setDstPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
            xmlNode.setAttribute("DSTPSDELOGICNODEID", pSDELogicNode.getPSDELogicNodeId());
        }
        super.importCurXmlModel(pSDELogicLink, xmlNode);
    }

    @Override
    protected void exportCurXmlModel(PSDELogicLink pSDELogicLink, XmlNode xmlNode, boolean bl) throws Exception {
        pSDELogicLink.setCondModel(null);
        super.exportCurXmlModel(pSDELogicLink, xmlNode, bl);
    }

    @Override
    protected void fillInformObject(PSDELogicLink pSDELogicLink, String string, JSONObject jSONObject) throws Exception {
        JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkinfo", (Object)pSDELogicLink.getLinkInfo());
        super.fillInformObject(pSDELogicLink, string, jSONObject);
    }
}

