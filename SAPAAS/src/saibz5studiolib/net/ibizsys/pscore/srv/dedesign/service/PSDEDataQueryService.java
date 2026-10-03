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
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQJoin;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDSDQ;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQJoinService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSDQService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEDataQueryService
extends PSDEDataQueryServiceBase {
    private static final Log log = LogFactory.getLog(PSDEDataQueryService.class);
    public static final String XMLNODE_DEDQJOIN = "DEDQJOIN";
    public static final String XMLNODE_DEDATAQUERY = "DEDATAQUERY";

    @Override
    public void getWithModel(PSDEDataQuery pSDEDataQuery) throws Exception {
        if (!KeyValueHelper.isTempKey((String)pSDEDataQuery.getPSDEDataQueryId())) {
            this.getTempMajor(pSDEDataQuery);
        } else {
            this.getTemp(pSDEDataQuery);
        }
        pSDEDataQuery.setDQJoinModel(this.getDQJoinModel(pSDEDataQuery));
    }

    protected String getDQJoinModel(PSDEDataQuery pSDEDataQuery) throws Exception {
        PSDEDQJoinService pSDEDQJoinService = (PSDEDQJoinService)ServiceGlobal.getService((String)PSDEDQJoinService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDQJoin> arrayList = pSDEDQJoinService.selectTempByPSDEDQ(pSDEDataQuery, "ORDER BY ORDERVALUE");
        HashMap<String, XmlNode> hashMap = new HashMap<String, XmlNode>();
        for (PSDEDQJoin entityBase2 : arrayList) {
            XmlNode xmlNode = new XmlNode();
            xmlNode.setNodeName(XMLNODE_DEDQJOIN);
            entityBase2.fillXmlNode(xmlNode, true);
            hashMap.put(entityBase2.getPSDEDQJoinId(), xmlNode);
        }
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_DEDATAQUERY);
        PSSystem pSSystem = pSDEDataQuery.getPSDE().getPSSystem();
        xmlNode.setAttribute("PSSYSTEMID", pSSystem.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)pSSystem.getPSDevSlnSysId())) {
            xmlNode.setAttribute("PSDEVSLNSYSID", pSSystem.getPSDevSlnSysId());
            xmlNode.setAttribute("TASKSERVERURL", pSSystem.getPSDevCenterTS().getPSTaskServer().getServerUrl());
        } else {
            xmlNode.setAttribute("PSDEVSLNSYSID", "");
            xmlNode.setAttribute("TASKSERVERURL", "http://lionlau-w530:8000/SAEAM/");
        }
        xmlNode.setAttribute("PSDEID", pSDEDataQuery.getPSDEId());
        xmlNode.setAttribute("PSDEDATAQUERYID", pSDEDataQuery.getPSDEDataQueryId());
        for (PSDEDQJoin pSDEDQJoin : arrayList) {
            XmlNode xmlNode2 = (XmlNode)hashMap.get(pSDEDQJoin.getPSDEDQJoinId());
            if (StringHelper.isNullOrEmpty((String)pSDEDQJoin.getPPSDEDQJoinId())) {
                xmlNode.addNode(xmlNode2);
                continue;
            }
            XmlNode xmlNode3 = (XmlNode)hashMap.get(pSDEDQJoin.getPPSDEDQJoinId());
            if (xmlNode3 != null) {
                xmlNode3.addNode(xmlNode2);
                continue;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7236\u6570\u636e\u8fde\u63a5\u6210\u5458[%1$s], \u5f53\u524d[%2$s]", (Object)pSDEDQJoin.getPPSDEDQJoinId(), (Object)pSDEDQJoin.getPSDEDQJoinName()));
        }
        return XmlNode.export((XmlNode)xmlNode);
    }

    @Override
    public void previewSave(PSDEDataQuery pSDEDataQuery) throws Exception {
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        log.debug((Object)"\u5f00\u59cb[previewSave]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQJoinService pSDEDQJoinService = (PSDEDQJoinService)ServiceGlobal.getService((String)PSDEDQJoinService.class.getCanonicalName(), (SessionFactory)PSDEDataQueryService.this.getSessionFactory());
                ArrayList<PSDEDQJoin> arrayList = pSDEDQJoinService.selectTempByPSDEDQ(pSDEDataQuery2);
                HashMap<String, PSDEDQJoin> hashMap = new HashMap<String, PSDEDQJoin>();
                for (PSDEDQJoin pSDEDQJoin2 : arrayList) {
                    hashMap.put(pSDEDQJoin2.getPSDEDQJoinId(), pSDEDQJoin2);
                }
                Object object = pSDEDataQuery2.getDQJoinModel();
                if (StringHelper.isNullOrEmpty((String)object)) {
                    object = WebContext.getCurrent().getPostValue("dqmodel");
                }
                XmlNode queryModel = XmlNode.loadFromXML((String)object);
                if (queryModel != null) {
                    PSDEDataQueryService.this.updatePSDEDQJoins(pSDEDataQuery2, null, queryModel, hashMap);
                    pSDEDataQuery2.setDQJoinModel(XmlNode.export(queryModel));
                } else {
                    pSDEDataQuery2.setDQJoinModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSDEDQJoin pSDEDQJoin3 : hashMap.values()) {
                        pSDEDQJoinService.removeTemp(pSDEDQJoin3);
                    }
                }
            }
        });
    }

    @Override
    public void updateWithModel(PSDEDataQuery pSDEDataQuery) throws Exception {
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQJoinService pSDEDQJoinService = (PSDEDQJoinService)ServiceGlobal.getService((String)PSDEDQJoinService.class.getCanonicalName(), (SessionFactory)PSDEDataQueryService.this.getSessionFactory());
                ArrayList<PSDEDQJoin> arrayList = pSDEDQJoinService.selectTempByPSDEDQ(pSDEDataQuery2);
                HashMap<String, PSDEDQJoin> hashMap = new HashMap<String, PSDEDQJoin>();
                for (PSDEDQJoin pSDEDQJoin2 : arrayList) {
                    hashMap.put(pSDEDQJoin2.getPSDEDQJoinId(), pSDEDQJoin2);
                }
                String string = pSDEDataQuery2.getDQJoinModel();
                XmlNode queryModel = XmlNode.loadFromXML(string);
                if (queryModel != null) {
                    queryModel.setAttribute("PSDEID", pSDEDataQuery2.getPSDEId());
                    queryModel.setAttribute("PSDEDATAQUERYID", pSDEDataQuery2.getPSDEDataQueryId());
                    PSDEDataQueryService.this.updatePSDEDQJoins(pSDEDataQuery2, null, queryModel, hashMap);
                    pSDEDataQuery2.setDQJoinModel(XmlNode.export(queryModel));
                } else {
                    pSDEDataQuery2.setDQJoinModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSDEDQJoin pSDEDQJoin3 : hashMap.values()) {
                        pSDEDQJoinService.removeTemp(pSDEDQJoin3);
                    }
                }
                PSDEDataQueryService.this.updateTempMajor(pSDEDataQuery2);
            }
        });
    }

    protected void updatePSDEDQJoins(PSDEDataQuery pSDEDataQuery, PSDEDQJoin pSDEDQJoin, XmlNode xmlNode, HashMap<String, PSDEDQJoin> hashMap) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<XmlNode> arrayList = new ArrayList<XmlNode>();
            PSDEDQJoinService pSDEDQJoinService = (PSDEDQJoinService)ServiceGlobal.getService((String)PSDEDQJoinService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            int n = 0;
            while (iterator.hasNext()) {
                PSDEDQJoin pSDEDQJoin2;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                String string = xmlNode2.getAttribute("PSDEDQJOINID", "");
                if (StringHelper.isNullOrEmpty((String)string) || (pSDEDQJoin2 = hashMap.remove(string)) == null) continue;
                ++n;
                boolean bl = false;
                if (StringHelper.compare((String)pSDEDQJoin2.getPSDEDQId(), (String)pSDEDataQuery.getPSDEDataQueryId(), (boolean)false) != 0) {
                    pSDEDQJoin2.setPSDEDQId(pSDEDataQuery.getPSDEDataQueryId());
                    bl = true;
                }
                if (StringHelper.compare((String)pSDEDQJoin2.getPSDEDQName(), (String)pSDEDataQuery.getPSDEDataQueryName(), (boolean)false) != 0) {
                    pSDEDQJoin2.setPSDEDQName(pSDEDataQuery.getPSDEDataQueryName());
                    bl = true;
                }
                if (pSDEDQJoin != null) {
                    if (StringHelper.compare((String)pSDEDQJoin2.getPPSDEDQJoinId(), (String)pSDEDQJoin.getPSDEDQJoinId(), (boolean)false) != 0) {
                        pSDEDQJoin2.setPPSDEDQJoinId(pSDEDQJoin.getPSDEDQJoinId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)pSDEDQJoin2.getPPSDEDQJoinName(), (String)pSDEDQJoin.getPSDEDQJoinName(), (boolean)false) != 0) {
                        pSDEDQJoin2.setPPSDEDQJoinName(pSDEDQJoin.getPSDEDQJoinName());
                        bl = true;
                    }
                }
                if (pSDEDQJoin2.getOrderValue() == null || pSDEDQJoin2.getOrderValue() != n) {
                    pSDEDQJoin2.setOrderValue(n);
                    bl = true;
                }
                if (bl) {
                    pSDEDQJoinService.updateTemp(pSDEDQJoin2);
                }
                xmlNode2.resetAttributes();
                pSDEDQJoin2.fillXmlNode(xmlNode2, false);
                arrayList.add(xmlNode2);
                this.updatePSDEDQJoins(pSDEDataQuery, pSDEDQJoin2, xmlNode2, hashMap);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
        }
    }

    @Override
    public void createWithModel(PSDEDataQuery pSDEDataQuery) throws Exception {
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        log.debug((Object)"\u5f00\u59cb[createWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDQJoinService pSDEDQJoinService = (PSDEDQJoinService)ServiceGlobal.getService((String)PSDEDQJoinService.class.getCanonicalName(), (SessionFactory)PSDEDataQueryService.this.getSessionFactory());
                ArrayList<PSDEDQJoin> arrayList = pSDEDQJoinService.selectTempByPSDEDQ(pSDEDataQuery2);
                HashMap<String, PSDEDQJoin> hashMap = new HashMap<String, PSDEDQJoin>();
                for (PSDEDQJoin pSDEDQJoin2 : arrayList) {
                    hashMap.put(pSDEDQJoin2.getPSDEDQJoinId(), pSDEDQJoin2);
                }
                String string = pSDEDataQuery2.getDQJoinModel();
                XmlNode queryModel = XmlNode.loadFromXML(string);
                if (queryModel != null) {
                    queryModel.setAttribute("PSDEID", pSDEDataQuery2.getPSDEId());
                    queryModel.setAttribute("PSDEDATAQUERYID", pSDEDataQuery2.getPSDEDataQueryId());
                    PSDEDataQueryService.this.updatePSDEDQJoins(pSDEDataQuery2, null, queryModel, hashMap);
                    pSDEDataQuery2.setDQJoinModel(XmlNode.export(queryModel));
                } else {
                    pSDEDataQuery2.setDQJoinModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSDEDQJoin pSDEDQJoin3 : hashMap.values()) {
                        pSDEDQJoinService.removeTemp(pSDEDQJoin3);
                    }
                }
                PSDEDataQueryService.this.createTempMajor(pSDEDataQuery2);
            }
        });
    }

    @Override
    public void getDraftWithModel(PSDEDataQuery pSDEDataQuery) throws Exception {
        this.getDraftTempMajor(pSDEDataQuery);
        pSDEDataQuery.setDQJoinModel(this.getDQJoinModel(pSDEDataQuery));
    }

    @Override
    protected void onBeforeCreate(PSDEDataQuery pSDEDataQuery) throws Exception {
        pSDEDataQuery.setDQJoinModel(null);
        super.onBeforeCreate(pSDEDataQuery);
    }

    @Override
    protected void onBeforeUpdate(PSDEDataQuery pSDEDataQuery) throws Exception {
        pSDEDataQuery.setDQJoinModel(null);
        super.onBeforeUpdate(pSDEDataQuery);
    }

    @Override
    protected void onAfterGetDraftTemp(PSDEDataQuery pSDEDataQuery) throws Exception {
        super.onAfterGetDraftTemp(pSDEDataQuery);
        PSDEDQJoin pSDEDQJoin = new PSDEDQJoin();
        pSDEDQJoin.setPSDEDQId(pSDEDataQuery.getPSDEDataQueryId());
        pSDEDQJoin.setPSDEDQName(pSDEDataQuery.getPSDEDataQueryName());
        pSDEDQJoin.setJoinPSDEId(pSDEDataQuery.getPSDEId());
        pSDEDQJoin.setJoinPSDEName(pSDEDataQuery.getPSDEName());
        pSDEDQJoin.setMainFlag(1);
        pSDEDQJoin.setPSDEJoinTypeId("MAIN");
        PSDEDQJoinService pSDEDQJoinService = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
        pSDEDQJoinService.createTemp(pSDEDQJoin);
    }

    @Override
    public void getDraftFromWithModel(PSDEDataQuery pSDEDataQuery) throws Exception {
        super.getDraftTempMajorFrom(pSDEDataQuery);
        pSDEDataQuery.setDQJoinModel(this.getDQJoinModel(pSDEDataQuery));
    }

    @Override
    protected void onAfterCreate(PSDEDataQuery pSDEDataQuery) throws Exception {
        super.onAfterCreate(pSDEDataQuery);
    }

    @Override
    protected void onCreateDEDataSet(PSDEDataQuery pSDEDataQuery) throws Exception {
        this.get(pSDEDataQuery);
        PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        PSDEDataSet pSDEDataSet = new PSDEDataSet();
        pSDEDataSet.setPSDEDataSetId(pSDEDataQuery.getPSDEDataQueryId());
        if (pSDEDataSetService.get(pSDEDataSet, true)) {
            throw new Exception("\u5bf9\u5e94\u6570\u636e\u96c6\u5408\u5df2\u7ecf\u5b58\u5728");
        }
        pSDEDataSet.setPSDEDataSetName(pSDEDataQuery.getPSDEDataQueryName());
        pSDEDataSet.setLogicName(pSDEDataQuery.getLogicName());
        pSDEDataSet.setCodeName(pSDEDataQuery.getCodeName());
        pSDEDataSet.setPSDEId(pSDEDataQuery.getPSDEId());
        pSDEDataSetService.create(pSDEDataSet);
        PSDEDSDQService pSDEDSDQService = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
        PSDEDSDQ pSDEDSDQ = new PSDEDSDQ();
        pSDEDSDQ.setPSDEDSDQName(pSDEDataQuery.getPSDEDataQueryName());
        pSDEDSDQ.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSDEDSDQ.setPSDEDQId(pSDEDataQuery.getPSDEDataQueryId());
        pSDEDSDQService.create(pSDEDSDQ);
    }
}
