/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.SqlParamList
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
package net.ibizsys.pscore.srv.appdesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItem;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItemRS;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppStoryBoard;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemRSService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppStoryBoardServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppStoryBoardService
extends PSAppStoryBoardServiceBase {
    private static final Log log = LogFactory.getLog(PSAppStoryBoardService.class);
    public static final String XMLNODE_APPSTORYBOARD = "APPSTORYBOARD";
    public static final String XMLNODE_APPSBITEM = "APPSBITEM";
    public static final String XMLNODE_APPSBITEMRS = "APPSBITEMRS";

    @Override
    public void getWithModel(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        if (!KeyValueHelper.isTempKey((String)pSAppStoryBoard.getPSAppStoryBoardId())) {
            this.getTempMajor(pSAppStoryBoard);
        } else {
            this.getTemp(pSAppStoryBoard);
        }
        pSAppStoryBoard.setSBModel(this.getSBModel(pSAppStoryBoard));
    }

    protected String getSBModel(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_APPSTORYBOARD);
        xmlNode.setAttribute("PSSYSAPPID", pSAppStoryBoard.getPSSysAppId());
        xmlNode.setAttribute("PSAPPSTORYBOARDID", pSAppStoryBoard.getPSAppStoryBoardId());
        PSAppSBItemService pSAppSBItemService = (PSAppSBItemService)ServiceGlobal.getService((String)PSAppSBItemService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppSBItem> arrayList = pSAppSBItemService.selectTempByPSAppStoryBoard(pSAppStoryBoard);
        for (PSAppSBItem serializable2 : arrayList) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName(XMLNODE_APPSBITEM);
            serializable2.fillXmlNode(xmlNode2, true);
            xmlNode.addNode(xmlNode2);
        }
        PSAppSBItemRSService pSAppSBItemRSService = (PSAppSBItemRSService)ServiceGlobal.getService((String)PSAppSBItemRSService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSAppSBItemRS> arrayList2 = pSAppSBItemRSService.selectTempByPSAppStoryBoard(pSAppStoryBoard);
        for (PSAppSBItemRS pSAppSBItemRS : arrayList2) {
            XmlNode xmlNode3 = new XmlNode();
            xmlNode3.setNodeName(XMLNODE_APPSBITEMRS);
            pSAppSBItemRS.fillXmlNode(xmlNode3, true);
            xmlNode.addNode(xmlNode3);
        }
        return XmlNode.export((XmlNode)xmlNode);
    }

    @Override
    public void updateWithModel(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        PSAppStoryBoard pSAppStoryBoard2 = new PSAppStoryBoard();
        pSAppStoryBoard.copyTo((IDataObject)pSAppStoryBoard2, false);
        this.getTemp(pSAppStoryBoard2);
        final PSAppStoryBoard pSAppStoryBoard3 = pSAppStoryBoard;
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppSBItemService pSAppSBItemService = (PSAppSBItemService)ServiceGlobal.getService((String)PSAppSBItemService.class.getCanonicalName(), (SessionFactory)PSAppStoryBoardService.this.getSessionFactory());
                ArrayList<PSAppSBItem> arrayList = pSAppSBItemService.selectTempByPSAppStoryBoard(pSAppStoryBoard3);
                HashMap<String, PSAppSBItem> hashMap = new HashMap<String, PSAppSBItem>();
                for (PSAppSBItem serializable2 : arrayList) {
                    hashMap.put(serializable2.getPSAppSBItemId(), serializable2);
                }
                PSAppSBItemRSService pSAppSBItemRSService = (PSAppSBItemRSService)ServiceGlobal.getService((String)PSAppSBItemRSService.class.getCanonicalName(), (SessionFactory)PSAppStoryBoardService.this.getSessionFactory());
                ArrayList<PSAppSBItemRS> arrayList2 = pSAppSBItemRSService.selectTempByPSAppStoryBoard(pSAppStoryBoard3);
                HashMap<String, PSAppSBItemRS> hashMap2 = new HashMap<String, PSAppSBItemRS>();
                for (PSAppSBItemRS pSAppSBItemRS2 : arrayList2) {
                    hashMap2.put(pSAppSBItemRS2.getPSAppSBItemRSId(), pSAppSBItemRS2);
                }
                String string = pSAppStoryBoard3.getSBModel();
                XmlNode modelNode = XmlNode.loadFromXML(string);
                if (modelNode != null) {
                    modelNode.setAttribute("PSSYSAPPID", pSAppStoryBoard3.getPSSysAppId());
                    modelNode.setAttribute("PSAPPSTORYBOARDID", pSAppStoryBoard3.getPSAppStoryBoardId());
                    PSAppStoryBoardService.this.updatePSAppStoryBoardModel(pSAppStoryBoard3, modelNode, hashMap, hashMap2);
                    pSAppStoryBoard3.setSBModel(XmlNode.export(modelNode));
                } else {
                    pSAppStoryBoard3.setSBModel(null);
                }
                if (hashMap2.size() > 0) {
                    for (PSAppSBItemRS relation : hashMap2.values()) {
                        pSAppSBItemRSService.removeTemp(relation);
                    }
                }
                if (hashMap.size() > 0) {
                    for (PSAppSBItem item : hashMap.values()) {
                        pSAppSBItemService.removeTemp(item);
                    }
                }
                PSAppStoryBoardService.this.updateTempMajor(pSAppStoryBoard3);
            }
        });
    }

    protected void updatePSAppStoryBoardModel(PSAppStoryBoard pSAppStoryBoard, XmlNode xmlNode, HashMap<String, PSAppSBItem> hashMap, HashMap<String, PSAppSBItemRS> hashMap2) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<XmlNode> arrayList = new ArrayList<XmlNode>();
            ArrayList<XmlNode> arrayList2 = new ArrayList<XmlNode>();
            PSAppSBItemService pSAppSBItemService = (PSAppSBItemService)ServiceGlobal.getService((String)PSAppSBItemService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            PSAppSBItemRSService pSAppSBItemRSService = (PSAppSBItemRSService)ServiceGlobal.getService((String)PSAppSBItemRSService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            while (iterator.hasNext()) {
                String string;
                String string2;
                String string3;
                boolean bl;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                if (StringHelper.compare((String)xmlNode2.getNodeName(), (String)XMLNODE_APPSBITEM, (boolean)true) == 0) {
                    int n;
                    String string4 = xmlNode2.getAttribute("PSAPPSBITEMID", "");
                    if (StringHelper.isNullOrEmpty(string4)) continue;
                    PSAppSBItem item = hashMap.remove(string4);
                    if (item == null) continue;
                    bl = false;
                    if (StringHelper.compare(item.getPSAppStoryBoardId(), pSAppStoryBoard.getPSAppStoryBoardId(), false) != 0) {
                        item.setPSAppStoryBoardId(pSAppStoryBoard.getPSAppStoryBoardId());
                        bl = true;
                    }
                    if (StringHelper.compare(item.getPSAppStoryBoardName(), pSAppStoryBoard.getPSAppStoryBoardName(), false) != 0) {
                        item.setPSAppStoryBoardName(pSAppStoryBoard.getPSAppStoryBoardName());
                        bl = true;
                    }
                    string3 = xmlNode2.getAttribute("LEFTPOS", "");
                    string2 = xmlNode2.getAttribute("TOPPOS", "");
                    if (!StringHelper.isNullOrEmpty((String)string3)) {
                        n = Integer.parseInt(string3);
                        if (item.getLeftPos() == null || item.getLeftPos() != n) {
                            item.setLeftPos(n);
                            bl = true;
                        }
                    }
                    if (!StringHelper.isNullOrEmpty((String)string2)) {
                        n = Integer.parseInt(string2);
                        if (item.getTopPos() == null || item.getTopPos() != n) {
                            item.setTopPos(n);
                            bl = true;
                        }
                    }
                    if (bl) {
                        pSAppSBItemService.updateTemp(item);
                    }
                    xmlNode2.resetAttributes();
                    item.fillXmlNode(xmlNode2, false);
                    arrayList.add(xmlNode2);
                    continue;
                }
                if (StringHelper.compare(xmlNode2.getNodeName(), XMLNODE_APPSBITEMRS, true) != 0 || StringHelper.isNullOrEmpty((string = xmlNode2.getAttribute("PSAPPSBITEMRSID", "")))) continue;
                PSAppSBItemRS relation = hashMap2.remove(string);
                if (relation == null) continue;
                bl = false;
                if (StringHelper.compare(relation.getPSAppStoryBoardId(), pSAppStoryBoard.getPSAppStoryBoardId(), false) != 0) {
                    relation.setPSAppStoryBoardId(pSAppStoryBoard.getPSAppStoryBoardId());
                    bl = true;
                }
                if (StringHelper.compare(relation.getPSAppStoryBoardName(), pSAppStoryBoard.getPSAppStoryBoardName(), false) != 0) {
                    relation.setPSAppStoryBoardName(pSAppStoryBoard.getPSAppStoryBoardName());
                    bl = true;
                }
                string3 = xmlNode2.getAttribute("SRCENDPOINT", "");
                string2 = xmlNode2.getAttribute("DSTENDPOINT", "");
                String string5 = xmlNode2.getAttribute("PPSAPPSBITEMID", "");
                String string6 = xmlNode2.getAttribute("CPSAPPSBITEMID", "");
                if (StringHelper.compare(relation.getSrcEndPoint(), string3, false) != 0) {
                    relation.setSrcEndPoint(string3);
                    bl = true;
                }
                if (StringHelper.compare(relation.getDstEndPoint(), string2, false) != 0) {
                    relation.setDstEndPoint(string2);
                    bl = true;
                }
                if (StringHelper.compare(relation.getPPSAppSBItemId(), string5, false) != 0) {
                    relation.setPPSAppSBItemId(string5);
                    bl = true;
                }
                if (StringHelper.compare(relation.getCPSAppSBItemId(), string6, false) != 0) {
                    relation.setCPSAppSBItemId(string6);
                    bl = true;
                }
                if (bl) {
                    pSAppSBItemRSService.updateTemp(relation);
                }
                xmlNode2.resetAttributes();
                relation.fillXmlNode(xmlNode2, false);
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
    public void createWithModel(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        final PSAppStoryBoard pSAppStoryBoard2 = pSAppStoryBoard;
        log.debug((Object)"\u5f00\u59cb[createWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppSBItemService pSAppSBItemService = (PSAppSBItemService)ServiceGlobal.getService((String)PSAppSBItemService.class.getCanonicalName(), (SessionFactory)PSAppStoryBoardService.this.getSessionFactory());
                ArrayList<PSAppSBItem> arrayList = pSAppSBItemService.selectTempByPSAppStoryBoard(pSAppStoryBoard2);
                HashMap<String, PSAppSBItem> hashMap = new HashMap<String, PSAppSBItem>();
                for (PSAppSBItem serializable2 : arrayList) {
                    hashMap.put(serializable2.getPSAppSBItemId(), serializable2);
                }
                PSAppSBItemRSService pSAppSBItemRSService = (PSAppSBItemRSService)ServiceGlobal.getService((String)PSAppSBItemRSService.class.getCanonicalName(), (SessionFactory)PSAppStoryBoardService.this.getSessionFactory());
                ArrayList<PSAppSBItemRS> arrayList2 = pSAppSBItemRSService.selectTempByPSAppStoryBoard(pSAppStoryBoard2);
                HashMap<String, PSAppSBItemRS> hashMap2 = new HashMap<String, PSAppSBItemRS>();
                for (PSAppSBItemRS pSAppSBItemRS2 : arrayList2) {
                    hashMap2.put(pSAppSBItemRS2.getPSAppSBItemRSId(), pSAppSBItemRS2);
                }
                String string = pSAppStoryBoard2.getSBModel();
                XmlNode modelNode = XmlNode.loadFromXML(string);
                if (modelNode != null) {
                    modelNode.setAttribute("PSSYSAPPID", pSAppStoryBoard2.getPSSysAppId());
                    modelNode.setAttribute("PSAPPSTORYBOARDID", pSAppStoryBoard2.getPSAppStoryBoardId());
                    PSAppStoryBoardService.this.updatePSAppStoryBoardModel(pSAppStoryBoard2, modelNode, hashMap, hashMap2);
                    pSAppStoryBoard2.setSBModel(XmlNode.export(modelNode));
                } else {
                    pSAppStoryBoard2.setSBModel(null);
                }
                if (hashMap2.size() > 0) {
                    for (PSAppSBItemRS relation : hashMap2.values()) {
                        pSAppSBItemRSService.removeTemp(relation);
                    }
                }
                if (hashMap.size() > 0) {
                    for (PSAppSBItem item : hashMap.values()) {
                        pSAppSBItemService.removeTemp(item);
                    }
                }
                PSAppStoryBoardService.this.createTempMajor(pSAppStoryBoard2);
            }
        });
    }

    @Override
    public void getDraftWithModel(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        this.getDraftTempMajor(pSAppStoryBoard);
        pSAppStoryBoard.setSBModel(this.getSBModel(pSAppStoryBoard));
    }

    @Override
    public void getDraftFromWithModel(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        super.getDraftTempMajorFrom(pSAppStoryBoard);
        pSAppStoryBoard.setSBModel(this.getSBModel(pSAppStoryBoard));
    }

    @Override
    protected void onAfterGetDraftTemp(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        super.onAfterGetDraftTemp(pSAppStoryBoard);
    }

    @Override
    protected void onBeforeCreate(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        pSAppStoryBoard.setSBModel(null);
        super.onBeforeCreate(pSAppStoryBoard);
    }

    @Override
    protected void onBeforeUpdate(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        pSAppStoryBoard.setSBModel(null);
        super.onBeforeUpdate(pSAppStoryBoard);
    }

    public void reset(final PSAppStoryBoard pSAppStoryBoard) throws Exception {
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                SqlParamList sqlParamList = new SqlParamList();
                sqlParamList.addString(pSAppStoryBoard.getPSAppStoryBoardId());
                PSAppStoryBoardService.this.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
                PSAppStoryBoardService.this.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSAPPSBITEMRS WHERE PSAPPSTORYBOARDID = ?", sqlParamList);
                PSAppStoryBoardService.this.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSAPPSBITEM WHERE PSAPPSTORYBOARDID = ? AND (USERFLAG IS NULL OR USERFLAG <> 1)", sqlParamList);
            }
        });
    }
}
