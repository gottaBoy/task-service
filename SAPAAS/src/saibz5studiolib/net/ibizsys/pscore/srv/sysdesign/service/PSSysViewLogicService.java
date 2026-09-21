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
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogicParam;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysViewLogicService
extends PSSysViewLogicServiceBase {
    private static final Log log = LogFactory.getLog(PSSysViewLogicService.class);
    public static final String XMLNODE_SYSVIEWLOGICCONFIG = "SYSVIEWLOGICCONFIG";
    public static final String XMLNODE_SYSVIEWLOGICPARAM = "SYSVIEWLOGICPARAM";

    @Override
    public void getDraftWithModel(PSSysViewLogic pSSysViewLogic) throws Exception {
        this.getDraftTempMajor((IEntity)pSSysViewLogic);
        pSSysViewLogic.setLogicModel(this.getLogicModel(pSSysViewLogic));
    }

    @Override
    public void getWithModel(PSSysViewLogic pSSysViewLogic) throws Exception {
        if (!KeyValueHelper.isTempKey((String)pSSysViewLogic.getPSSysViewLogicId())) {
            this.getTempMajor(pSSysViewLogic);
        } else {
            this.getTemp((IEntity)pSSysViewLogic);
        }
        pSSysViewLogic.setLogicModel(this.getLogicModel(pSSysViewLogic));
    }

    protected String getLogicModel(PSSysViewLogic pSSysViewLogic) throws Exception {
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_SYSVIEWLOGICCONFIG);
        xmlNode.setAttribute("PSDEID", pSSysViewLogic.getPSDEId());
        xmlNode.setAttribute("PSSYSTEMID", pSSysViewLogic.getPSSystemId());
        xmlNode.setAttribute("PSSYSVIEWLOGICID", pSSysViewLogic.getPSSysViewLogicId());
        PSSysViewLogicParamService pSSysViewLogicParamService = (PSSysViewLogicParamService)ServiceGlobal.getService((String)PSSysViewLogicParamService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysViewLogicParam> arrayList = pSSysViewLogicParamService.selectTempByPSSysViewLogic(pSSysViewLogic);
        for (PSSysViewLogicParam pSSysViewLogicParam : arrayList) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName(XMLNODE_SYSVIEWLOGICPARAM);
            pSSysViewLogicParam.fillXmlNode(xmlNode2, true);
            xmlNode.addNode(xmlNode2);
        }
        return XmlNode.export((XmlNode)xmlNode);
    }

    @Override
    public void createWithModel(PSSysViewLogic pSSysViewLogic) throws Exception {
        final PSSysViewLogic pSSysViewLogic2 = pSSysViewLogic;
        pSSysViewLogic2.setSessionFactory(this.getSessionFactory());
        log.debug((Object)"\u5f00\u59cb[createWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewLogicParam pSSysViewLogicParam2;
                PSSysViewLogicParamService pSSysViewLogicParamService = (PSSysViewLogicParamService)ServiceGlobal.getService((String)PSSysViewLogicParamService.class.getCanonicalName(), (SessionFactory)PSSysViewLogicService.this.getSessionFactory());
                ArrayList<PSSysViewLogicParam> arrayList = pSSysViewLogicParamService.selectTempByPSSysViewLogic(pSSysViewLogic2);
                HashMap<String, PSSysViewLogicParam> hashMap = new HashMap<String, PSSysViewLogicParam>();
                for (PSSysViewLogicParam pSSysViewLogicParam2 : arrayList) {
                    hashMap.put(pSSysViewLogicParam2.getPSSysViewLogicParamId(), pSSysViewLogicParam2);
                }
                String string = pSSysViewLogic2.getLogicModel();
                pSSysViewLogicParam2 = XmlNode.loadFromXML((String)string);
                if (pSSysViewLogicParam2 != null) {
                    pSSysViewLogicParam2.setAttribute("PSDEID", pSSysViewLogic2.getPSDEId());
                    pSSysViewLogicParam2.setAttribute("PSSYSTEMID", pSSysViewLogic2.getPSSystemId());
                    pSSysViewLogicParam2.setAttribute("PSSYSVIEWLOGICID", pSSysViewLogic2.getPSSysViewLogicId());
                    PSSysViewLogicService.this.updatePSSysViewLogicModel(pSSysViewLogic2, (XmlNode)pSSysViewLogicParam2, hashMap);
                    pSSysViewLogic2.setLogicModel(XmlNode.export((XmlNode)pSSysViewLogicParam2));
                } else {
                    pSSysViewLogic2.setLogicModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSSysViewLogicParam pSSysViewLogicParam3 : hashMap.values()) {
                        pSSysViewLogicParamService.removeTemp((IEntity)pSSysViewLogicParam3);
                    }
                }
                PSSysViewLogicService.this.createTempMajor((IEntity)pSSysViewLogic2);
            }
        });
    }

    @Override
    public void updateWithModel(PSSysViewLogic pSSysViewLogic) throws Exception {
        final PSSysViewLogic pSSysViewLogic2 = pSSysViewLogic;
        pSSysViewLogic2.setSessionFactory(this.getSessionFactory());
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewLogicParam pSSysViewLogicParam;
                Object object = null;
                PSSysViewLogicParamService pSSysViewLogicParamService = (PSSysViewLogicParamService)ServiceGlobal.getService((String)PSSysViewLogicParamService.class.getCanonicalName(), (SessionFactory)PSSysViewLogicService.this.getSessionFactory());
                ArrayList<PSSysViewLogicParam> arrayList = pSSysViewLogicParamService.selectTempByPSSysViewLogic(pSSysViewLogic2);
                HashMap<String, PSSysViewLogicParam> hashMap = new HashMap<String, PSSysViewLogicParam>();
                Object object2 = arrayList.iterator();
                while (object2.hasNext()) {
                    pSSysViewLogicParam = object2.next();
                    hashMap.put(pSSysViewLogicParam.getPSSysViewLogicParamId(), pSSysViewLogicParam);
                }
                object = object2 = pSSysViewLogic2.getLogicModel();
                pSSysViewLogicParam = XmlNode.loadFromXML((String)object2);
                if (pSSysViewLogicParam != null) {
                    pSSysViewLogicParam.setAttribute("PSDEID", pSSysViewLogic2.getPSDEId());
                    pSSysViewLogicParam.setAttribute("PSSYSVIEWLOGICID", pSSysViewLogic2.getPSSysViewLogicId());
                    pSSysViewLogicParam.setAttribute("PSSYSTEMID", pSSysViewLogic2.getPSSystemId());
                    PSSysViewLogicService.this.updatePSSysViewLogicModel(pSSysViewLogic2, (XmlNode)pSSysViewLogicParam, hashMap);
                    pSSysViewLogic2.setLogicModel(XmlNode.export((XmlNode)pSSysViewLogicParam));
                } else {
                    pSSysViewLogic2.setLogicModel(null);
                }
                boolean bl = false;
                if (hashMap.size() > 0) {
                    for (PSSysViewLogicParam pSSysViewLogicParam2 : hashMap.values()) {
                        pSSysViewLogicParamService.removeTemp((IEntity)pSSysViewLogicParam2);
                        bl = true;
                    }
                }
                PSSysViewLogicService.this.updateTempMajor(pSSysViewLogic2);
            }
        });
    }

    protected void updatePSSysViewLogicModel(PSSysViewLogic pSSysViewLogic, XmlNode xmlNode, HashMap<String, PSSysViewLogicParam> hashMap) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            PSSysViewLogicParamService pSSysViewLogicParamService = (PSSysViewLogicParamService)ServiceGlobal.getService((String)PSSysViewLogicParamService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            while (iterator.hasNext()) {
                PSSysViewLogicParam pSSysViewLogicParam;
                String object;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                if (StringHelper.compare((String)xmlNode2.getNodeName(), (String)XMLNODE_SYSVIEWLOGICPARAM, (boolean)true) != 0 || StringHelper.isNullOrEmpty((String)(object = xmlNode2.getAttribute("PSSYSVIEWLOGICPARAMID", ""))) || (pSSysViewLogicParam = hashMap.remove(object)) == null) continue;
                boolean bl = false;
                if (StringHelper.compare((String)pSSysViewLogicParam.getPSSysViewLogicId(), (String)pSSysViewLogic.getPSSysViewLogicId(), (boolean)false) != 0) {
                    pSSysViewLogicParam.setPSSysViewLogicId(pSSysViewLogic.getPSSysViewLogicId());
                    bl = true;
                }
                if (StringHelper.compare((String)pSSysViewLogicParam.getPSSysViewLogicName(), (String)pSSysViewLogic.getPSSysViewLogicName(), (boolean)false) != 0) {
                    pSSysViewLogicParam.setPSSysViewLogicName(pSSysViewLogic.getPSSysViewLogicName());
                    bl = true;
                }
                if (bl) {
                    pSSysViewLogicParamService.updateTemp((IEntity)pSSysViewLogicParam);
                }
                xmlNode2.resetAttributes();
                pSSysViewLogicParam.fillXmlNode(xmlNode2, false);
                arrayList.add(xmlNode2);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
        }
    }

    @Override
    public void getDraftFromWithModel(PSSysViewLogic pSSysViewLogic) throws Exception {
        super.getDraftTempMajorFrom(pSSysViewLogic);
        pSSysViewLogic.setLogicModel(this.getLogicModel(pSSysViewLogic));
    }
}

