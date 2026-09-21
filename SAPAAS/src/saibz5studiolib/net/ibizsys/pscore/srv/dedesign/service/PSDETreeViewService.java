/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeRS;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeRSService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDETreeViewService
extends PSDETreeViewServiceBase {
    private static final Log log = LogFactory.getLog(PSDETreeViewService.class);
    public static final String XMLNODE_DETREECONFIG = "DETREECONFIG";
    public static final String XMLNODE_DETREENODE = "DETREENODE";
    public static final String XMLNODE_DETREENODERS = "DETREENODERS";

    @Override
    protected void onAfterGetDraftTemp(PSDETreeView pSDETreeView) throws Exception {
        PSDETreeNode pSDETreeNode = new PSDETreeNode();
        pSDETreeNode.setRootNode(1);
        pSDETreeNode.setPSDETreeNodeName("\u9ed8\u8ba4\u6839\u8282\u70b9");
        pSDETreeNode.setTreeNodeType("STATIC");
        pSDETreeNode.setNodeValue("root");
        pSDETreeNode.setNodeType("ROOT");
        pSDETreeNode.setAppendPNodeId(0);
        pSDETreeNode.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
        PSDETreeNodeService pSDETreeNodeService = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        pSDETreeNodeService.createTemp(pSDETreeNode);
        super.onAfterGetDraftTemp(pSDETreeView);
    }

    @Override
    public void getDraftWithModel(PSDETreeView pSDETreeView) throws Exception {
        this.getDraftTempMajor((IEntity)pSDETreeView);
        pSDETreeView.setTreeModel(this.getTreeModel(pSDETreeView));
    }

    @Override
    public void getWithModel(PSDETreeView pSDETreeView) throws Exception {
        if (!KeyValueHelper.isTempKey((String)pSDETreeView.getPSDETreeViewId())) {
            this.getTempMajor(pSDETreeView);
        } else {
            this.getTemp((IEntity)pSDETreeView);
        }
        pSDETreeView.setTreeModel(this.getTreeModel(pSDETreeView));
    }

    protected String getTreeModel(PSDETreeView pSDETreeView) throws Exception {
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_DETREECONFIG);
        xmlNode.setAttribute("PSDEID", pSDETreeView.getPSDEId());
        xmlNode.setAttribute("PSDETREEVIEWID", pSDETreeView.getPSDETreeViewId());
        PSDETreeNodeService pSDETreeNodeService = (PSDETreeNodeService)ServiceGlobal.getService((String)PSDETreeNodeService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeNode> arrayList = pSDETreeNodeService.selectTempByPSDETreeView(pSDETreeView, "ORDER BY ROOTNODE DESC,PSDETREENODENAME ASC");
        for (PSDETreeNode serializable2 : arrayList) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName(XMLNODE_DETREENODE);
            serializable2.fillXmlNode(xmlNode2, true);
            xmlNode.addNode(xmlNode2);
        }
        PSDETreeNodeRSService pSDETreeNodeRSService = (PSDETreeNodeRSService)ServiceGlobal.getService((String)PSDETreeNodeRSService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeNodeRS> arrayList2 = pSDETreeNodeRSService.selectTempByPSDETreeView(pSDETreeView, "ORDER BY ORDERVALUE");
        for (PSDETreeNodeRS pSDETreeNodeRS : arrayList2) {
            XmlNode xmlNode3 = new XmlNode();
            xmlNode3.setNodeName(XMLNODE_DETREENODERS);
            pSDETreeNodeRS.fillXmlNode(xmlNode3, true);
            xmlNode.addNode(xmlNode3);
        }
        return XmlNode.export((XmlNode)xmlNode);
    }

    @Override
    public void createWithModel(PSDETreeView pSDETreeView) throws Exception {
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        pSDETreeView2.setSessionFactory(this.getSessionFactory());
        log.debug((Object)"\u5f00\u59cb[createWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeRS pSDETreeNodeRS2;
                PSDETreeNodeService pSDETreeNodeService = (PSDETreeNodeService)ServiceGlobal.getService((String)PSDETreeNodeService.class.getCanonicalName(), (SessionFactory)PSDETreeViewService.this.getSessionFactory());
                ArrayList<PSDETreeNode> arrayList = pSDETreeNodeService.selectTempByPSDETreeView(pSDETreeView2);
                HashMap<String, PSDETreeNode> hashMap = new HashMap<String, PSDETreeNode>();
                for (PSDETreeNode serializable2 : arrayList) {
                    hashMap.put(serializable2.getPSDETreeNodeId(), serializable2);
                }
                PSDETreeNodeRSService pSDETreeNodeRSService = (PSDETreeNodeRSService)ServiceGlobal.getService((String)PSDETreeNodeRSService.class.getCanonicalName(), (SessionFactory)PSDETreeViewService.this.getSessionFactory());
                ArrayList<PSDETreeNodeRS> arrayList2 = pSDETreeNodeRSService.selectTempByPSDETreeView(pSDETreeView2);
                HashMap<String, PSDETreeNodeRS> hashMap2 = new HashMap<String, PSDETreeNodeRS>();
                for (PSDETreeNodeRS pSDETreeNodeRS2 : arrayList2) {
                    hashMap2.put(pSDETreeNodeRS2.getPSDETreeNodeRSId(), pSDETreeNodeRS2);
                }
                String string = pSDETreeView2.getTreeModel();
                pSDETreeNodeRS2 = XmlNode.loadFromXML((String)string);
                if (pSDETreeNodeRS2 != null) {
                    pSDETreeNodeRS2.setAttribute("PSDEID", pSDETreeView2.getPSDEId());
                    pSDETreeNodeRS2.setAttribute("PSDETREEVIEWID", pSDETreeView2.getPSDETreeViewId());
                    PSDETreeViewService.this.updatePSDETreeViewModel(pSDETreeView2, (XmlNode)pSDETreeNodeRS2, hashMap, hashMap2);
                    pSDETreeView2.setTreeModel(XmlNode.export((XmlNode)pSDETreeNodeRS2));
                } else {
                    pSDETreeView2.setTreeModel(null);
                }
                if (hashMap2.size() > 0) {
                    for (EntityBase entityBase : hashMap2.values()) {
                        pSDETreeNodeRSService.removeTemp((IEntity)entityBase);
                    }
                }
                if (hashMap.size() > 0) {
                    for (EntityBase entityBase : hashMap.values()) {
                        pSDETreeNodeService.removeTemp((IEntity)entityBase);
                    }
                }
                PSDETreeViewService.this.createTempMajor((IEntity)pSDETreeView2);
            }
        });
    }

    @Override
    public void updateWithModel(PSDETreeView pSDETreeView) throws Exception {
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        pSDETreeView2.setSessionFactory(this.getSessionFactory());
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeNodeRS pSDETreeNodeRS;
                Object object = null;
                PSDETreeNodeService pSDETreeNodeService = (PSDETreeNodeService)ServiceGlobal.getService((String)PSDETreeNodeService.class.getCanonicalName(), (SessionFactory)PSDETreeViewService.this.getSessionFactory());
                ArrayList<PSDETreeNode> arrayList = pSDETreeNodeService.selectTempByPSDETreeView(pSDETreeView2);
                HashMap<String, PSDETreeNode> hashMap = new HashMap<String, PSDETreeNode>();
                for (PSDETreeNode serializable2 : arrayList) {
                    hashMap.put(serializable2.getPSDETreeNodeId(), serializable2);
                }
                PSDETreeNodeRSService pSDETreeNodeRSService = (PSDETreeNodeRSService)ServiceGlobal.getService((String)PSDETreeNodeRSService.class.getCanonicalName(), (SessionFactory)PSDETreeViewService.this.getSessionFactory());
                ArrayList<PSDETreeNodeRS> arrayList2 = pSDETreeNodeRSService.selectTempByPSDETreeView(pSDETreeView2);
                HashMap<String, PSDETreeNodeRS> hashMap2 = new HashMap<String, PSDETreeNodeRS>();
                Object object2 = arrayList2.iterator();
                while (object2.hasNext()) {
                    pSDETreeNodeRS = object2.next();
                    hashMap2.put(pSDETreeNodeRS.getPSDETreeNodeRSId(), pSDETreeNodeRS);
                }
                object = object2 = pSDETreeView2.getTreeModel();
                pSDETreeNodeRS = XmlNode.loadFromXML((String)object2);
                if (pSDETreeNodeRS != null) {
                    pSDETreeNodeRS.setAttribute("PSDEID", pSDETreeView2.getPSDEId());
                    pSDETreeNodeRS.setAttribute("PSDETREEVIEWID", pSDETreeView2.getPSDETreeViewId());
                    PSDETreeViewService.this.updatePSDETreeViewModel(pSDETreeView2, (XmlNode)pSDETreeNodeRS, hashMap, hashMap2);
                    pSDETreeView2.setTreeModel(XmlNode.export((XmlNode)pSDETreeNodeRS));
                } else {
                    pSDETreeView2.setTreeModel(null);
                }
                boolean bl = false;
                if (hashMap2.size() > 0) {
                    for (EntityBase entityBase : hashMap2.values()) {
                        pSDETreeNodeRSService.removeTemp((IEntity)entityBase);
                        bl = true;
                    }
                }
                if (hashMap.size() > 0) {
                    for (EntityBase entityBase : hashMap.values()) {
                        pSDETreeNodeService.removeTemp((IEntity)entityBase);
                        bl = true;
                    }
                }
                PSDETreeViewService.this.updateTempMajor(pSDETreeView2);
            }
        });
    }

    protected void updatePSDETreeViewModel(PSDETreeView pSDETreeView, XmlNode xmlNode, HashMap<String, PSDETreeNode> hashMap, HashMap<String, PSDETreeNodeRS> hashMap2) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            ArrayList<Object> arrayList2 = new ArrayList<Object>();
            PSDETreeNodeService pSDETreeNodeService = (PSDETreeNodeService)ServiceGlobal.getService((String)PSDETreeNodeService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            PSDETreeNodeRSService pSDETreeNodeRSService = (PSDETreeNodeRSService)ServiceGlobal.getService((String)PSDETreeNodeRSService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            HashMap<String, Integer> hashMap3 = new HashMap<String, Integer>();
            while (iterator.hasNext()) {
                Integer n;
                String string;
                boolean bl;
                EntityBase entityBase;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                if (StringHelper.compare((String)xmlNode2.getNodeName(), (String)XMLNODE_DETREENODE, (boolean)true) == 0) {
                    String string2 = xmlNode2.getAttribute("PSDETREENODEID", "");
                    if (StringHelper.isNullOrEmpty((String)string2) || (entityBase = hashMap.remove(string2)) == null) continue;
                    bl = false;
                    if (StringHelper.compare((String)entityBase.getPSDETreeViewId(), (String)pSDETreeView.getPSDETreeViewId(), (boolean)false) != 0) {
                        entityBase.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)entityBase.getPSDETreeViewName(), (String)pSDETreeView.getPSDETreeViewName(), (boolean)false) != 0) {
                        entityBase.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
                        bl = true;
                    }
                    if (bl) {
                        pSDETreeNodeService.updateTemp((IEntity)entityBase);
                    }
                    xmlNode2.resetAttributes();
                    entityBase.fillXmlNode(xmlNode2, false);
                    arrayList.add(xmlNode2);
                    continue;
                }
                if (StringHelper.compare((String)xmlNode2.getNodeName(), (String)XMLNODE_DETREENODERS, (boolean)true) != 0 || StringHelper.isNullOrEmpty((String)(string = xmlNode2.getAttribute("PSDETREENODERSID", ""))) || (entityBase = hashMap2.remove(string)) == null) continue;
                bl = false;
                if (StringHelper.compare((String)entityBase.getPSDETreeViewId(), (String)pSDETreeView.getPSDETreeViewId(), (boolean)false) != 0) {
                    entityBase.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
                    bl = true;
                }
                if (StringHelper.compare((String)entityBase.getPSDETreeViewName(), (String)pSDETreeView.getPSDETreeViewName(), (boolean)false) != 0) {
                    entityBase.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
                    bl = true;
                }
                if ((n = (Integer)hashMap3.get(entityBase.getPPSDETreeNodeId())) == null) {
                    n = 0;
                }
                n = n + 10;
                hashMap3.put(entityBase.getPPSDETreeNodeId(), n);
                if (entityBase.getOrderValue() == null || entityBase.getOrderValue() != n) {
                    entityBase.setOrderValue(n);
                    bl = true;
                }
                if (bl) {
                    pSDETreeNodeRSService.updateTemp((IEntity)entityBase);
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
    public void getDraftFromWithModel(PSDETreeView pSDETreeView) throws Exception {
        super.getDraftTempMajorFrom(pSDETreeView);
        pSDETreeView.setTreeModel(this.getTreeModel(pSDETreeView));
    }
}

