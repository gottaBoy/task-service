/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.data.DataObject
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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.data.DataObject;
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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysERMap;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysERMapNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysERMapNodeBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysERMapService
extends PSSysERMapServiceBase {
    public static final String XMLNODE_ERCONFIG = "ERCONFIG";
    public static final String XMLNODE_ERNODE = "ERNODE";
    private static final Log log = LogFactory.getLog(PSSysERMapService.class);

    @Override
    protected void onAddDataEntities(PSSysERMap pSSysERMap) throws Exception {
        this.get((IEntity)pSSysERMap);
        if (!DataObject.getBoolValue((Integer)pSSysERMap.getAllEntityFlag(), (boolean)true)) {
            throw new Exception("ER\u56fe\u6ca1\u6709\u8bbe\u7f6e\u4e3a\u5168\u90e8\u5b9e\u4f53\uff0c\u65e0\u6cd5\u6dfb\u52a0");
        }
        boolean bl = DataObject.getBoolValue((Integer)pSSysERMap.getIncSubSysFlag(), (boolean)false);
        PSSystem pSSystem = new PSSystem();
        pSSystem.setPSSystemId(pSSysERMap.getPSSystemId());
        PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
        PSSysERMapNodeService pSSysERMapNodeService = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDataEntity> arrayList = pSDataEntityService.selectByPSSystem(pSSystem);
        ArrayList<PSModule> arrayList2 = pSModuleService.selectByPSSystem(pSSystem);
        ArrayList<PSSysERMapNode> arrayList3 = pSSysERMapNodeService.selectByPSSysERMap(pSSysERMap);
        HashMap<String, PSModule> hashMap = new HashMap<String, PSModule>();
        for (PSModule object : arrayList2) {
            if (DataObject.getBoolValue((Integer)object.getSubSysModule(), (boolean)false) && !bl) continue;
            hashMap.put(object.getPSModuleId(), object);
        }
        HashMap hashMap2 = new HashMap();
        for (PSSysERMapNode pSSysERMapNode : arrayList3) {
            hashMap2.put(pSSysERMapNode.getPSDEId(), pSSysERMapNode);
        }
        for (PSDataEntity pSDataEntity : arrayList) {
            if (!hashMap.containsKey(pSDataEntity.getPSModuleId()) || hashMap2.containsKey(pSDataEntity.getPSDataEntityId())) continue;
            PSSysERMapNode pSSysERMapNode = new PSSysERMapNode();
            pSSysERMapNode.setPSSysERMapId(pSSysERMap.getPSSysERMapId());
            pSSysERMapNode.setPSSysERMapName(pSSysERMap.getPSSysERMapName());
            pSSysERMapNode.setPSSysERMapNodeName(pSDataEntity.getPSDataEntityName());
            pSSysERMapNode.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSSysERMapNode.setPSDEName(pSDataEntity.getPSDataEntityName());
            pSSysERMapNodeService.create(pSSysERMapNode, false);
        }
    }

    @Override
    public void getWithModel(PSSysERMap pSSysERMap) throws Exception {
        if (!KeyValueHelper.isTempKey((String)pSSysERMap.getPSSysERMapId())) {
            this.getTempMajor(pSSysERMap);
        } else {
            this.getTemp((IEntity)pSSysERMap);
        }
        pSSysERMap.setERModel(this.getERModel(pSSysERMap));
    }

    @Override
    public void getWithModel2(PSSysERMap pSSysERMap) throws Exception {
        this.get((IEntity)pSSysERMap);
        pSSysERMap.setERModel(this.getERModel(pSSysERMap));
    }

    protected String getERModel(PSSysERMap pSSysERMap) throws Exception {
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_ERCONFIG);
        xmlNode.setAttribute("PSSYSTEMID", pSSysERMap.getPSSystemId());
        xmlNode.setAttribute("PSSYSERMAPID", pSSysERMap.getPSSysERMapId());
        String string = pSSysERMap.getDefViewMode();
        if (StringHelper.isNullOrEmpty((String)string)) {
            string = "PV";
        }
        xmlNode.setAttribute("DEFVIEWMODE", string);
        PSSysERMapNodeService pSSysERMapNodeService = (PSSysERMapNodeService)ServiceGlobal.getService((String)PSSysERMapNodeService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysERMapNode> arrayList = null;
        arrayList = !KeyValueHelper.isTempKey((String)pSSysERMap.getPSSysERMapId()) ? pSSysERMapNodeService.selectByPSSysERMap(pSSysERMap) : pSSysERMapNodeService.selectTempByPSSysERMap(pSSysERMap);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName(XMLNODE_ERNODE);
            this.fillXmlNode((IEntity)pSSysERMapNode, xmlNode2, false);
            xmlNode.addNode(xmlNode2);
        }
        return XmlNode.export((XmlNode)xmlNode);
    }

    @Override
    public void updateWithModel(PSSysERMap pSSysERMap) throws Exception {
        final PSSysERMap pSSysERMap2 = pSSysERMap;
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysERMapNode pSSysERMapNode2;
                PSSysERMapNodeService pSSysERMapNodeService = (PSSysERMapNodeService)ServiceGlobal.getService((String)PSSysERMapNodeService.class.getCanonicalName(), (SessionFactory)PSSysERMapService.this.getSessionFactory());
                ArrayList<PSSysERMapNode> arrayList = pSSysERMapNodeService.selectTempByPSSysERMap(pSSysERMap2);
                HashMap<String, PSSysERMapNode> hashMap = new HashMap<String, PSSysERMapNode>();
                for (PSSysERMapNode pSSysERMapNode2 : arrayList) {
                    hashMap.put(pSSysERMapNode2.getPSSysERMapNodeId(), pSSysERMapNode2);
                }
                String string = pSSysERMap2.getERModel();
                pSSysERMapNode2 = XmlNode.loadFromXML((String)string);
                if (pSSysERMapNode2 != null) {
                    pSSysERMap2.setDefViewMode(pSSysERMapNode2.getAttribute("DEFVIEWMODE", "PV"));
                    pSSysERMapNode2.setAttribute("PSSYSERMAPID", pSSysERMap2.getPSSysERMapId());
                    pSSysERMapNode2.setAttribute("PSSYSTEMID", pSSysERMap2.getPSSystemId());
                    pSSysERMapNode2.setAttribute("DEFVIEWMODE", pSSysERMap2.getDefViewMode());
                    PSSysERMapService.this.updatePSSysERMapModel(pSSysERMap2, (XmlNode)pSSysERMapNode2, hashMap);
                    pSSysERMap2.setERModel(XmlNode.export((XmlNode)pSSysERMapNode2));
                } else {
                    pSSysERMap2.setERModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSSysERMapNode pSSysERMapNode3 : hashMap.values()) {
                        pSSysERMapNodeService.removeTemp((IEntity)pSSysERMapNode3);
                    }
                }
                PSSysERMapService.this.updateTempMajor(pSSysERMap2);
            }
        });
    }

    protected void updatePSSysERMapModel(PSSysERMap pSSysERMap, XmlNode xmlNode, HashMap<String, PSSysERMapNode> hashMap) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            PSSysERMapNodeService pSSysERMapNodeService = (PSSysERMapNodeService)ServiceGlobal.getService((String)PSSysERMapNodeService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            while (iterator.hasNext()) {
                int n;
                PSSysERMapNode pSSysERMapNode;
                String object;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                if (StringHelper.compare((String)xmlNode2.getNodeName(), (String)XMLNODE_ERNODE, (boolean)true) != 0 || StringHelper.isNullOrEmpty((String)(object = xmlNode2.getAttribute("PSSYSERMAPNODEID", ""))) || (pSSysERMapNode = hashMap.remove(object)) == null) continue;
                boolean bl = false;
                if (StringHelper.compare((String)pSSysERMapNode.getPSSysERMapId(), (String)pSSysERMap.getPSSysERMapId(), (boolean)false) != 0) {
                    pSSysERMapNode.setPSSysERMapId(pSSysERMap.getPSSysERMapId());
                    bl = true;
                }
                if (StringHelper.compare((String)pSSysERMapNode.getPSSysERMapName(), (String)pSSysERMap.getPSSysERMapName(), (boolean)false) != 0) {
                    pSSysERMapNode.setPSSysERMapName(pSSysERMap.getPSSysERMapName());
                    bl = true;
                }
                String string = xmlNode2.getAttribute("LEFTPOS", "");
                String string2 = xmlNode2.getAttribute("TOPPOS", "");
                if (!StringHelper.isNullOrEmpty((String)string)) {
                    n = Integer.parseInt(string);
                    if (pSSysERMapNode.getLeftPos() == null || pSSysERMapNode.getLeftPos() != n) {
                        pSSysERMapNode.setLeftPos(n);
                        bl = true;
                    }
                }
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    n = Integer.parseInt(string2);
                    if (pSSysERMapNode.getTopPos() == null || pSSysERMapNode.getTopPos() != n) {
                        pSSysERMapNode.setTopPos(n);
                        bl = true;
                    }
                }
                if (bl) {
                    pSSysERMapNodeService.updateTemp((IEntity)pSSysERMapNode);
                }
                xmlNode2.resetAttributes();
                pSSysERMapNode.fillXmlNode(xmlNode2, false);
                arrayList.add(xmlNode2);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
        }
    }

    @Override
    public void createWithModel(PSSysERMap pSSysERMap) throws Exception {
        final PSSysERMap pSSysERMap2 = pSSysERMap;
        log.debug((Object)"\u5f00\u59cb[createWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysERMapNode pSSysERMapNode2;
                PSSysERMapNodeService pSSysERMapNodeService = (PSSysERMapNodeService)ServiceGlobal.getService((String)PSSysERMapNodeService.class.getCanonicalName(), (SessionFactory)PSSysERMapService.this.getSessionFactory());
                ArrayList<PSSysERMapNode> arrayList = pSSysERMapNodeService.selectTempByPSSysERMap(pSSysERMap2);
                HashMap<String, PSSysERMapNode> hashMap = new HashMap<String, PSSysERMapNode>();
                for (PSSysERMapNode pSSysERMapNode2 : arrayList) {
                    hashMap.put(pSSysERMapNode2.getPSSysERMapNodeId(), pSSysERMapNode2);
                }
                String string = pSSysERMap2.getERModel();
                pSSysERMapNode2 = XmlNode.loadFromXML((String)string);
                if (pSSysERMapNode2 != null) {
                    pSSysERMap2.setDefViewMode(pSSysERMapNode2.getAttribute("DEFVIEWMODE", "PV"));
                    pSSysERMapNode2.setAttribute("PSSYSTEMID", pSSysERMap2.getPSSystemId());
                    pSSysERMapNode2.setAttribute("PSSYSERMAPID", pSSysERMap2.getPSSysERMapId());
                    pSSysERMapNode2.setAttribute("DEFVIEWMODE", pSSysERMap2.getDefViewMode());
                    PSSysERMapService.this.updatePSSysERMapModel(pSSysERMap2, (XmlNode)pSSysERMapNode2, hashMap);
                    pSSysERMap2.setERModel(XmlNode.export((XmlNode)pSSysERMapNode2));
                } else {
                    pSSysERMap2.setERModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSSysERMapNode pSSysERMapNode3 : hashMap.values()) {
                        pSSysERMapNodeService.removeTemp((IEntity)pSSysERMapNode3);
                    }
                }
                PSSysERMapService.this.createTempMajor((IEntity)pSSysERMap2);
            }
        });
    }

    @Override
    public void getDraftWithModel(PSSysERMap pSSysERMap) throws Exception {
        this.getDraftTempMajor((IEntity)pSSysERMap);
        pSSysERMap.setERModel(this.getERModel(pSSysERMap));
    }

    @Override
    protected void onAfterGetDraftTemp(PSSysERMap pSSysERMap) throws Exception {
        super.onAfterGetDraftTemp(pSSysERMap);
    }

    @Override
    protected void onBeforeCreate(PSSysERMap pSSysERMap) throws Exception {
        pSSysERMap.setERModel(null);
        if (StringHelper.isNullOrEmpty((String)pSSysERMap.getCodeName())) {
            PSSysERMap pSSysERMap2;
            String string = "ERMap";
            int n = 1;
            do {
                if (n > 1) {
                    string = StringHelper.format((String)"ERMap%1$s", (Object)n);
                }
                ++n;
                pSSysERMap2 = new PSSysERMap();
                pSSysERMap2.setSessionFactory(this.getSessionFactory());
                pSSysERMap2.setPSSystemId(pSSysERMap.getPSSystemId());
                pSSysERMap2.setCodeName(string);
            } while (pSSysERMap2.select(true));
            pSSysERMap.setCodeName(string);
        }
        super.onBeforeCreate(pSSysERMap);
    }

    @Override
    protected void onBeforeUpdate(PSSysERMap pSSysERMap) throws Exception {
        pSSysERMap.setERModel(null);
        super.onBeforeUpdate(pSSysERMap);
    }

    @Override
    public void getDraftFromWithModel(PSSysERMap pSSysERMap) throws Exception {
        super.getDraftTempMajorFrom(pSSysERMap);
        pSSysERMap.setERModel(this.getERModel(pSSysERMap));
    }

    @Override
    protected void onCalcConnection(PSSysERMap pSSysERMap) throws Exception {
        Object object;
        if (WebContext.getCurrent() == null || WebContext.getCurrent().getCurAjaxActionResult() == null) {
            throw new Exception("\u8bf7\u6c42\u73af\u5883\u4e0d\u6b63\u786e");
        }
        MDAjaxActionResult mDAjaxActionResult = (MDAjaxActionResult)WebContext.getCurrent().getCurAjaxActionResult();
        PSSysERMapNodeService pSSysERMapNodeService = (PSSysERMapNodeService)ServiceGlobal.getService((String)PSSysERMapNodeService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysERMapNode> arrayList = null;
        arrayList = !KeyValueHelper.isTempKey((String)pSSysERMap.getPSSysERMapId()) ? pSSysERMapNodeService.selectByPSSysERMap(pSSysERMap) : pSSysERMapNodeService.selectTempByPSSysERMap(pSSysERMap);
        HashMap<String, PSSysERMapNode> hashMap = new HashMap<String, PSSysERMapNode>();
        for (PSSysERMapNode object22 : arrayList) {
            hashMap.put(object22.getPSDEName(), object22);
        }
        HashMap hashMap2 = new HashMap();
        for (Object object2 : hashMap.values()) {
            Object object3;
            Serializable serializable = ((PSSysERMapNodeBase)object2).getPSDE().getMinorPSDERs();
            object = ((ArrayList)serializable).iterator();
            while (object.hasNext()) {
                object3 = object.next();
                if (!hashMap.containsKey(((PSDERBase)object3).getMajorPSDEName())) continue;
                hashMap2.put(((PSDERBase)object3).getPSDERId(), object3);
            }
            object = ((PSSysERMapNodeBase)object2).getPSDE().getPSDEFields();
            object3 = ((ArrayList)object).iterator();
            while (object3.hasNext()) {
                PSDEField pSDEField = (PSDEField)object3.next();
                if (!DataObject.getBoolValue((Integer)pSDEField.getPKey(), (boolean)false) && StringHelper.compare((String)pSDEField.getPSDataTypeId(), (String)"PICKUP", (boolean)true) != 0) continue;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", (Object)"defield");
                jSONObject.put("pssysermapnodeid", (Object)((PSSysERMapNodeBase)object2).getPSSysERMapNodeId());
                jSONObject.put("psdefieldid", (Object)pSDEField.getPSDEFieldId());
                jSONObject.put("psdefieldname", (Object)pSDEField.getPSDEFieldName());
                jSONObject.put("logicname", (Object)pSDEField.getLogicName());
                jSONObject.put("pkey", DataObject.getBoolValue((Integer)pSDEField.getPKey(), (boolean)false));
                jSONObject.put("fkey", StringHelper.compare((String)pSDEField.getPSDataTypeId(), (String)"PICKUP", (boolean)true) == 0);
                if (DataObject.getBoolValue((Integer)pSDEField.getPKey(), (boolean)false)) {
                    mDAjaxActionResult.getRows().add(0, jSONObject);
                    continue;
                }
                mDAjaxActionResult.getRows().add(jSONObject);
            }
        }
        ICodeList iCodeList = CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DERTypeCodeListModel");
        for (Serializable serializable : hashMap2.values()) {
            object = new JSONObject();
            object.put("type", (Object)"link");
            object.put("psderid", (Object)((PSDERBase)serializable).getPSDERId());
            object.put("psdername", (Object)((PSDERBase)serializable).getPSDERName());
            object.put("logicname", (Object)((PSDERBase)serializable).getLogicName());
            object.put("majorpsdename", (Object)((PSDERBase)serializable).getMajorPSDEName());
            object.put("minorpsdename", (Object)((PSDERBase)serializable).getMinorPSDEName());
            object.put("majorpsdeid", (Object)((PSDERBase)serializable).getMajorPSDEId());
            object.put("minorpsdeid", (Object)((PSDERBase)serializable).getMinorPSDEId());
            object.put("derfieldname", (Object)((PSDERBase)serializable).getDERFieldName());
            object.put("dertype", (Object)((PSDERBase)serializable).getDERType());
            object.put("dertypename", (Object)iCodeList.getCodeListText(((PSDERBase)serializable).getDERType(), true));
            object.put("frompsernodeid", (Object)((PSSysERMapNode)hashMap.get(((PSDERBase)serializable).getMinorPSDEName())).getPSSysERMapNodeId());
            object.put("topsernodeid", (Object)((PSSysERMapNode)hashMap.get(((PSDERBase)serializable).getMajorPSDEName())).getPSSysERMapNodeId());
            mDAjaxActionResult.getRows().add(object);
        }
    }
}

