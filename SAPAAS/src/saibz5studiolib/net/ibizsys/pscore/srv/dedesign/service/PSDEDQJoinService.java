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
 *  net.ibizsys.paas.util.StringBuilderEx
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
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.CloneSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQJoin;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQJoinServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEDQJoinService
extends PSDEDQJoinServiceBase {
    private static final Log log = LogFactory.getLog(PSDEDQJoinService.class);
    public static final String XMLNODE_DEDQCOND = "DEDQCOND";

    @Override
    public void updateWithModel(PSDEDQJoin pSDEDQJoin) throws Exception {
        final PSDEDQJoin pSDEDQJoin2 = pSDEDQJoin;
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQCondService pSDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService((String)PSDEDQCondService.class.getCanonicalName(), (SessionFactory)PSDEDQJoinService.this.getSessionFactory());
                ArrayList<PSDEDQCond> arrayList = pSDEDQCondService.selectTempByPSDEDQJoin(pSDEDQJoin2);
                HashMap<String, PSDEDQCond> hashMap = new HashMap<String, PSDEDQCond>();
                for (PSDEDQCond object2 : arrayList) {
                    hashMap.put(object2.getPSDEDQCondId(), object2);
                }
                Object object3 = "";
                XmlNode xmlNode = new XmlNode();
                xmlNode.setNodeName(PSDEDQJoinService.XMLNODE_DEDQCOND);
                xmlNode.setAttribute("PSDEDQJOINID", pSDEDQJoin2.getPSDEDQJoinId());
                xmlNode.setAttribute("PSDEDQID", pSDEDQJoin2.getPSDEDQId());
                xmlNode.setAttribute("PSDEID", pSDEDQJoin2.getJoinPSDEId());
                object3 = XmlNode.export((XmlNode)xmlNode);
                String string = pSDEDQJoin2.getCondModel();
                XmlNode xmlNode2 = XmlNode.loadFromXML((String)string);
                if (xmlNode2 != null) {
                    PSDEDQJoinService.this.updatePSDEDQConds(pSDEDQJoin2, null, xmlNode2, hashMap);
                    xmlNode2.setAttribute("PSDEDQJOINID", pSDEDQJoin2.getPSDEDQJoinId());
                    xmlNode2.setAttribute("PSDEDQID", pSDEDQJoin2.getPSDEDQId());
                    xmlNode2.setAttribute("PSDEID", pSDEDQJoin2.getJoinPSDEId());
                    pSDEDQJoin2.setCondModel(XmlNode.export((XmlNode)xmlNode2));
                    if (xmlNode2.getChildNodes() != null) {
                        pSDEDQJoin2.setCondFlag(1);
                    } else {
                        pSDEDQJoin2.setCondFlag(0);
                    }
                } else {
                    pSDEDQJoin2.setCondModel((String)object3);
                    pSDEDQJoin2.setCondFlag(0);
                }
                int n = DataObject.getIntegerValue((Object)pSDEDQJoin2.getModelState(), (Integer)0);
                n = DataObject.getIntegerValue((Object)pSDEDQJoin2.getCondFlag()) == 1 ? (n |= 0x400) : (n ^= 0x400);
                pSDEDQJoin2.setModelState(n);
                if (hashMap.size() > 0) {
                    for (PSDEDQCond pSDEDQCond : hashMap.values()) {
                        pSDEDQCondService.removeTemp(pSDEDQCond);
                    }
                }
                PSDEDQJoinService.this.updateTemp(pSDEDQJoin2);
            }
        });
    }

    protected void updatePSDEDQConds(PSDEDQJoin pSDEDQJoin, PSDEDQCond pSDEDQCond, XmlNode xmlNode, HashMap<String, PSDEDQCond> hashMap) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<XmlNode> arrayList = new ArrayList<XmlNode>();
            PSDEDQCondService pSDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService((String)PSDEDQCondService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            int n = 0;
            while (iterator.hasNext()) {
                PSDEDQCond pSDEDQCond2;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                String string = xmlNode2.getAttribute("PSDEDQCONDID", "");
                if (StringHelper.isNullOrEmpty((String)string) || (pSDEDQCond2 = hashMap.remove(string)) == null) continue;
                ++n;
                boolean bl = false;
                if (StringHelper.compare((String)pSDEDQCond2.getPSDEDQJoinId(), (String)pSDEDQJoin.getPSDEDQJoinId(), (boolean)false) != 0) {
                    pSDEDQCond2.setPSDEDQJoinId(pSDEDQJoin.getPSDEDQJoinId());
                    bl = true;
                }
                if (StringHelper.compare((String)pSDEDQCond2.getPSDEDQJoinName(), (String)pSDEDQJoin.getPSDEDQJoinName(), (boolean)false) != 0) {
                    pSDEDQCond2.setPSDEDQJoinName(pSDEDQJoin.getPSDEDQJoinName());
                    bl = true;
                }
                if (pSDEDQCond != null) {
                    if (StringHelper.compare((String)pSDEDQCond2.getPPSDEDQCondId(), (String)pSDEDQCond.getPSDEDQCondId(), (boolean)false) != 0) {
                        pSDEDQCond2.setPPSDEDQCondId(pSDEDQCond.getPSDEDQCondId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)pSDEDQCond2.getPPSDEDQCondName(), (String)pSDEDQCond.getPSDEDQCondName(), (boolean)false) != 0) {
                        pSDEDQCond2.setPPSDEDQCondName(pSDEDQCond.getPSDEDQCondName());
                        bl = true;
                    }
                }
                if (pSDEDQCond2.getOrderValue() == null || pSDEDQCond2.getOrderValue() != n) {
                    pSDEDQCond2.setOrderValue(n);
                    bl = true;
                }
                if (bl) {
                    pSDEDQCondService.updateTemp(pSDEDQCond2);
                }
                xmlNode2.resetAttributes();
                pSDEDQCond2.fillXmlNode(xmlNode2, false);
                arrayList.add(xmlNode2);
                this.updatePSDEDQConds(pSDEDQJoin, pSDEDQCond2, xmlNode2, hashMap);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
        }
    }

    protected void createPSDEDQConds(PSDEDQJoin pSDEDQJoin, String string, PSDEDQCond pSDEDQCond, XmlNode xmlNode) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            PSDEDQCondService pSDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService((String)PSDEDQCondService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            int n = 0;
            while (iterator.hasNext()) {
                ++n;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEDQCond pSDEDQCond2 = new PSDEDQCond();
                DataObject.fromXmlNode((IDataObject)pSDEDQCond2, (XmlNode)xmlNode2);
                pSDEDQCond2.resetPSDEDQCondId();
                pSDEDQCond2.resetPPSDEDQCondId();
                pSDEDQCond2.resetPPSDEDQCondName();
                pSDEDQCond2.setPSDEDQJoinId(pSDEDQJoin.getPSDEDQJoinId());
                pSDEDQCond2.setPSDEDQJoinName(pSDEDQJoin.getPSDEDQJoinName());
                if (pSDEDQCond != null) {
                    pSDEDQCond2.setPPSDEDQCondId(pSDEDQCond.getPSDEDQCondId());
                    pSDEDQCond2.setPPSDEDQCondName(pSDEDQCond.getPSDEDQCondName());
                }
                pSDEDQCond2.setOrderValue(n);
                pSDEDQCondService.create(pSDEDQCond2);
                this.createPSDEDQConds(pSDEDQJoin, string, pSDEDQCond2, xmlNode2);
            }
        }
    }

    @Override
    public void createWithModel(PSDEDQJoin pSDEDQJoin) throws Exception {
        this.updateWithModel(pSDEDQJoin);
    }

    @Override
    public void getWithModel(PSDEDQJoin pSDEDQJoin) throws Exception {
        this.getTemp(pSDEDQJoin);
        if (StringHelper.isNullOrEmpty((String)pSDEDQJoin.getCondModel())) {
            this.fillCondModel(pSDEDQJoin);
            this.updateTemp(pSDEDQJoin);
        }
    }

    protected void fillCondModel(PSDEDQJoin pSDEDQJoin) throws Exception {
        PSDEDQCondService pSDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService((String)PSDEDQCondService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDQCond> arrayList = pSDEDQCondService.selectTempByPSDEDQJoin(pSDEDQJoin, "ORDER BY ORDERVALUE");
        HashMap<String, XmlNode> hashMap = new HashMap<String, XmlNode>();
        for (PSDEDQCond object : arrayList) {
            XmlNode xmlNode = new XmlNode();
            xmlNode.setNodeName(object.getCondType());
            object.fillXmlNode(xmlNode, true);
            hashMap.put(object.getPSDEDQCondId(), xmlNode);
        }
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_DEDQCOND);
        xmlNode.setAttribute("PSDEDQJOINID", pSDEDQJoin.getPSDEDQJoinId());
        xmlNode.setAttribute("PSDEDQID", pSDEDQJoin.getPSDEDQId());
        xmlNode.setAttribute("PSDEID", pSDEDQJoin.getJoinPSDEId());
        for (PSDEDQCond pSDEDQCond : arrayList) {
            XmlNode xmlNode2 = (XmlNode)hashMap.get(pSDEDQCond.getPSDEDQCondId());
            if (StringHelper.isNullOrEmpty((String)pSDEDQCond.getPPSDEDQCondId())) {
                xmlNode.addNode(xmlNode2);
                continue;
            }
            XmlNode xmlNode3 = (XmlNode)hashMap.get(pSDEDQCond.getPPSDEDQCondId());
            if (xmlNode3 != null) {
                xmlNode3.addNode(xmlNode2);
                continue;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u903b\u8f91\u8fde\u63a5\u7236\u903b\u8f91[%1$s], \u5f53\u524d[%2$s]", (Object)pSDEDQCond.getPPSDEDQCondId(), (Object)pSDEDQCond.getPSDEDQCondName()));
        }
        pSDEDQJoin.setCondModel(XmlNode.export((XmlNode)xmlNode));
    }

    @Override
    protected void onBeforeGetDraftTemp(PSDEDQJoin pSDEDQJoin) throws Exception {
        super.onBeforeGetDraftTemp(pSDEDQJoin);
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_DEDQCOND);
        xmlNode.setAttribute("PSDEDQJOINID", pSDEDQJoin.getPSDEDQJoinId());
        xmlNode.setAttribute("PSDEDQID", pSDEDQJoin.getPSDEDQId());
        xmlNode.setAttribute("PSDEID", pSDEDQJoin.getJoinPSDEId());
        String string = XmlNode.export((XmlNode)xmlNode);
        pSDEDQJoin.setCondModel(string);
    }

    @Override
    protected void onBeforeCreate(PSDEDQJoin pSDEDQJoin) throws Exception {
        pSDEDQJoin.setCondModel(null);
        super.onBeforeCreate(pSDEDQJoin);
    }

    @Override
    protected void onBeforeUpdate(PSDEDQJoin pSDEDQJoin) throws Exception {
        pSDEDQJoin.setCondModel(null);
        super.onBeforeUpdate(pSDEDQJoin);
    }

    @Override
    public void calcJoinPSDEId(PSDEDQJoin pSDEDQJoin) throws Exception {
        String string = pSDEDQJoin.getJoinPSDEId();
        pSDEDQJoin.resetCondModel();
        pSDEDQJoin.setSessionFactory(this.getSessionFactory());
        this.fillJoinPSDE(pSDEDQJoin);
        if (StringHelper.compare((String)string, (String)pSDEDQJoin.getJoinPSDEId(), (boolean)false) != 0) {
            XmlNode xmlNode = new XmlNode();
            xmlNode.setNodeName(XMLNODE_DEDQCOND);
            xmlNode.setAttribute("PSDEDQJOINID", pSDEDQJoin.getPSDEDQJoinId());
            xmlNode.setAttribute("PSDEDQID", pSDEDQJoin.getPSDEDQId());
            xmlNode.setAttribute("PSDEID", pSDEDQJoin.getJoinPSDEId());
            String string2 = XmlNode.export((XmlNode)xmlNode);
            pSDEDQJoin.setCondModel(string2);
        }
    }

    protected void fillJoinPSDE(PSDEDQJoin pSDEDQJoin) throws Exception {
        String string = pSDEDQJoin.getPSDEJoinTypeId();
        if (StringHelper.isNullOrEmpty((String)string)) {
            return;
        }
        PSDER pSDER = pSDEDQJoin.getPSDER();
        if (pSDER == null) {
            return;
        }
        if (StringHelper.compare((String)string, (String)"N1", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"N1RIGHT", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"INDEX", (boolean)true) == 0) {
            pSDEDQJoin.setJoinPSDEId(pSDER.getMajorPSDEId());
            pSDEDQJoin.setJoinPSDEName(pSDER.getMajorPSDEName());
            return;
        }
        if (StringHelper.compare((String)string, (String)"1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"1NNOT", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"1NLEFTOUT", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"INDEXM", (boolean)true) == 0) {
            pSDEDQJoin.setJoinPSDEId(pSDER.getMinorPSDEId());
            pSDEDQJoin.setJoinPSDEName(pSDER.getMinorPSDEName());
            return;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8fde\u63a5\u7c7b\u578b[%1$s]", (Object)string));
    }

    protected String calcPSDEDQJoinName(PSDEDQJoin pSDEDQJoin) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        if (pSDEDQJoin.getMainFlag() != null && pSDEDQJoin.getMainFlag() == 1) {
            return pSDEDQJoin.getJoinPSDEName();
        }
        if (StringHelper.isNullOrEmpty((String)pSDEDQJoin.getJoinPSDEName())) {
            return "?";
        }
        stringBuilderEx.append("%1$s", (Object)pSDEDQJoin.getJoinPSDEName());
        if (pSDEDQJoin.getCondFlag() != null && pSDEDQJoin.getCondFlag() == 1) {
            stringBuilderEx.append("*");
        }
        if (StringHelper.isNullOrEmpty((String)pSDEDQJoin.getPSDEJoinTypeName())) {
            return "?";
        }
        stringBuilderEx.append(" [%1$s]", (Object)pSDEDQJoin.getPSDEJoinTypeName());
        if (StringHelper.isNullOrEmpty((String)pSDEDQJoin.getPSDERName())) {
            return "?";
        }
        stringBuilderEx.append("(%1$s)", (Object)pSDEDQJoin.getPSDERName());
        return stringBuilderEx.toString();
    }

    @Override
    protected void onBeforeCreateTemp(PSDEDQJoin pSDEDQJoin) throws Exception {
        pSDEDQJoin.setPSDEDQJoinName(this.calcPSDEDQJoinName(pSDEDQJoin));
        super.onBeforeCreateTemp(pSDEDQJoin);
    }

    @Override
    protected void onBeforeUpdateTemp(PSDEDQJoin pSDEDQJoin) throws Exception {
        pSDEDQJoin.setPSDEDQJoinName(this.calcPSDEDQJoinName(pSDEDQJoin));
        super.onBeforeUpdateTemp(pSDEDQJoin);
    }

    @Override
    protected void getRelatedDataTempMajor_PSDEDQCond(PSDEDQJoin pSDEDQJoin) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSDEDATAQUERY", (boolean)true) == 0) {
            return;
        }
        super.getRelatedDataTempMajor_PSDEDQCond(pSDEDQJoin);
    }

    @Override
    protected ArrayList<PSDEDQCond> updateRelatedDataTempMajor_removePSDEDQCond(PSDEDQJoin pSDEDQJoin, PSDEDQJoin pSDEDQJoin2) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSDEDATAQUERY", (boolean)true) == 0) {
            return null;
        }
        return super.updateRelatedDataTempMajor_removePSDEDQCond(pSDEDQJoin, pSDEDQJoin2);
    }

    protected boolean onFillEntityKeyValue(PSDEDQJoin pSDEDQJoin, boolean bl) throws Exception {
        if (pSDEDQJoin.getMainFlag() != null && pSDEDQJoin.getMainFlag() == 1) {
            pSDEDQJoin.setPSDEDQJoinId(pSDEDQJoin.getPSDEDQId());
            return true;
        }
        return super.onFillEntityKeyValue(pSDEDQJoin, bl);
    }

    @Override
    protected void onAfterCreateTemp(PSDEDQJoin pSDEDQJoin) throws Exception {
        super.onAfterCreateTemp(pSDEDQJoin);
    }
}
