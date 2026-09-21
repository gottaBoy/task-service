/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.alibaba.fastjson.JSONArray
 *  com.alibaba.fastjson.JSONObject
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.Base64Helper
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.activiti.bpmn.converter.BpmnXMLConverter
 *  org.activiti.bpmn.model.BpmnModel
 *  org.activiti.editor.language.json.converter.BpmnJsonConverter
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.wfdesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DynaSysRefModeCodeListModel;
import net.ibizsys.pscore.srv.codelist.WFUtilUIActionType2CodeListModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupDetailBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWFVer;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLink;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcessBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFUtilUIAction;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFUtilUIActionBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVerLog;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersionBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFUtilUIActionService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVerLogService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionHelper;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionServiceBase;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@Component
public class PSWFVersionService
extends PSWFVersionServiceBase {
    public static final String XMLNODE_WFCONFIG = "WFCONFIG";
    public static final String XMLNODE_WFPROCESS = "WFPROCESS";
    public static final String XMLNODE_WFLINK = "WFLINK";
    private static final Log log = LogFactory.getLog(PSWFVersionService.class);
    private static String[] PREDEFINEDACTIONS = new String[]{"SENDBACK", "SUPPLYINFO", "ADDSTEPAFTER", "ADDSTEPBEFORE", "TAKEADVICE", "REASSIGN", "SENDCOPY", "USERACTION", "USERACTION2", "USERACTION3", "USERACTION4", "USERACTION5", "USERACTION6"};

    @Override
    public void getWithModel(PSWFVersion pSWFVersion) throws Exception {
        if (!KeyValueHelper.isTempKey((String)pSWFVersion.getPSWFVersionId())) {
            this.getTempMajor(pSWFVersion);
        } else {
            this.getTemp((IEntity)pSWFVersion);
        }
        pSWFVersion.setWFModel(this.getWFModel(pSWFVersion));
        if (StringHelper.compare((String)pSWFVersion.getPSWF().getWFEngineType(), (String)"ACTIVITI", (boolean)false) == 0) {
            pSWFVersion.setActivitiModel(this.getActivitiModel(pSWFVersion));
        }
    }

    protected String getWFModel(PSWFVersion pSWFVersion) throws Exception {
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_WFCONFIG);
        xmlNode.setAttribute("PSWFID", pSWFVersion.getPSWFId());
        xmlNode.setAttribute("PSSYSTEMID", pSWFVersion.getPSSystemId());
        xmlNode.setAttribute("PSWFVERSIONID", pSWFVersion.getPSWFVersionId());
        PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService((String)PSWFProcessService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcess> arrayList = pSWFProcessService.selectTempByPSWFVersion(pSWFVersion);
        for (PSWFProcess serializable2 : arrayList) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName(XMLNODE_WFPROCESS);
            serializable2.fillXmlNode(xmlNode2, true);
            xmlNode.addNode(xmlNode2);
        }
        PSWFLinkService pSWFLinkService = (PSWFLinkService)ServiceGlobal.getService((String)PSWFLinkService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFLink> arrayList2 = pSWFLinkService.selectTempByPSWFVersion(pSWFVersion);
        for (PSWFLink pSWFLink : arrayList2) {
            XmlNode xmlNode3 = new XmlNode();
            xmlNode3.setNodeName(XMLNODE_WFLINK);
            pSWFLink.fillXmlNode(xmlNode3, true);
            xmlNode.addNode(xmlNode3);
        }
        return XmlNode.export((XmlNode)xmlNode);
    }

    protected String getActivitiModel(PSWFVersion pSWFVersion) throws Exception {
        XmlNode xmlNode;
        String string = pSWFVersion.getActivitiModel();
        if (!StringHelper.isNullOrEmpty((String)string) && string.charAt(0) != '{') {
            xmlNode = XmlNode.loadFromXML((String)string);
            string = xmlNode.getAttribute("ACTIVITIMODEL", "");
        }
        xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_WFCONFIG);
        xmlNode.setAttribute("PSWFID", pSWFVersion.getPSWFId());
        xmlNode.setAttribute("PSSYSTEMID", pSWFVersion.getPSSystemId());
        xmlNode.setAttribute("PSWFVERSIONID", pSWFVersion.getPSWFVersionId());
        if (StringHelper.isNullOrEmpty((String)string)) {
            xmlNode.setAttribute("ACTIVITIMODEL", "{\"json_xml\":{\"resourceId\":\"\", \"stencilset\":{\"url\":\"stencilsets/bpmn2.0/bpmn2.0.json\",\"namespace\":\"http://b3mn.org/stencilset/bpmn2.0#\"}},\"name\":\"ibiz\",\"description\":\"\"}");
        } else {
            com.alibaba.fastjson.JSONArray jSONArray;
            PSWFLink pSWFLink2;
            PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService((String)PSWFProcessService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            ArrayList<PSWFProcess> arrayList = pSWFProcessService.selectTempByPSWFVersion(pSWFVersion);
            HashMap<String, String> hashMap = new HashMap<String, String>();
            for (PSWFProcess serializable2 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)serializable2.getModelId())) continue;
                hashMap.put(serializable2.getModelId(), serializable2.getPSWFProcessId());
            }
            PSWFLinkService pSWFLinkService = (PSWFLinkService)ServiceGlobal.getService((String)PSWFLinkService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            ArrayList<PSWFLink> arrayList2 = pSWFLinkService.selectTempByPSWFVersion(pSWFVersion);
            for (PSWFLink pSWFLink2 : arrayList2) {
                if (StringHelper.isNullOrEmpty((String)pSWFLink2.getModelId())) continue;
                hashMap.put(pSWFLink2.getModelId(), pSWFLink2.getPSWFLinkId());
            }
            com.alibaba.fastjson.JSONObject jSONObject = com.alibaba.fastjson.JSONObject.parseObject((String)string);
            pSWFLink2 = jSONObject.getJSONObject("json_xml");
            if (pSWFLink2 != null && (jSONArray = pSWFLink2.getJSONArray("childShapes")) != null) {
                int n = jSONArray.size();
                for (int i = 0; i < n; ++i) {
                    com.alibaba.fastjson.JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string2 = jSONObject2.getString("resourceId");
                    com.alibaba.fastjson.JSONObject jSONObject3 = jSONObject2.getJSONObject("properties");
                    String string3 = (String)hashMap.get(string2);
                    if (StringHelper.isNullOrEmpty((String)string3)) {
                        string3 = "";
                    }
                    jSONObject3.put("documentation", (Object)string3);
                }
                string = jSONObject.toString();
            }
            xmlNode.setAttribute("ACTIVITIMODEL", string);
        }
        return XmlNode.export((XmlNode)xmlNode);
    }

    @Override
    public void updateWithModel(PSWFVersion pSWFVersion) throws Exception {
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        pSWFVersion2.setSessionFactory(this.getSessionFactory());
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                XmlNode xmlNode;
                Object object = null;
                PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService((String)PSWFProcessService.class.getCanonicalName(), (SessionFactory)PSWFVersionService.this.getSessionFactory());
                ArrayList<PSWFProcess> arrayList = pSWFProcessService.selectTempByPSWFVersion(pSWFVersion2);
                HashMap<String, PSWFProcess> hashMap = new HashMap<String, PSWFProcess>();
                for (PSWFProcess serializable2 : arrayList) {
                    hashMap.put(serializable2.getPSWFProcessId(), serializable2);
                }
                PSWFLinkService pSWFLinkService = (PSWFLinkService)ServiceGlobal.getService((String)PSWFLinkService.class.getCanonicalName(), (SessionFactory)PSWFVersionService.this.getSessionFactory());
                ArrayList<PSWFLink> arrayList2 = pSWFLinkService.selectTempByPSWFVersion(pSWFVersion2);
                HashMap<String, PSWFLink> hashMap2 = new HashMap<String, PSWFLink>();
                Object bl = arrayList2.iterator();
                while (bl.hasNext()) {
                    xmlNode = bl.next();
                    hashMap2.put(xmlNode.getPSWFLinkId(), (PSWFLink)xmlNode);
                }
                pSWFVersion2.setBPMNModel(null);
                if (StringHelper.compare((String)pSWFVersion2.getPSWF().getWFEngineType(), (String)"ACTIVITI", (boolean)false) == 0) {
                    object = bl = pSWFVersion2.getActivitiModel();
                    xmlNode = XmlNode.loadFromXML((String)bl);
                    if (xmlNode != null) {
                        com.alibaba.fastjson.JSONObject jSONObject;
                        xmlNode.setAttribute("PSWFID", pSWFVersion2.getPSWFId());
                        xmlNode.setAttribute("PSSYSTEMID", pSWFVersion2.getPSSystemId());
                        xmlNode.setAttribute("PSWFVERSIONID", pSWFVersion2.getPSWFVersionId());
                        Object object2 = xmlNode.getAttribute("ACTIVITIMODEL", "");
                        com.alibaba.fastjson.JSONObject jSONObject2 = null;
                        if (!StringHelper.isNullOrEmpty((String)object2) && (jSONObject = (jSONObject2 = com.alibaba.fastjson.JSONObject.parseObject((String)object2)).getJSONObject("json_xml")) != null) {
                            com.alibaba.fastjson.JSONArray jSONArray = jSONObject.getJSONArray("childShapes");
                            int n = DataObject.getIntegerValue((Object)pSWFVersion2.getPSWF().getRemoteEngineFlag(), (Integer)0);
                            if (jSONArray != null) {
                                PSWFVersionHelper pSWFVersionHelper = new PSWFVersionHelper(PSWFVersionService.this.getSessionFactory());
                                if (n == 1) {
                                    pSWFVersionHelper.updatePSWFVersionModel3(pSWFVersion2, jSONArray, hashMap, hashMap2);
                                } else {
                                    pSWFVersionHelper.updatePSWFVersionModel2(pSWFVersion2, jSONArray, hashMap, hashMap2);
                                }
                                object2 = jSONObject2.toString();
                                xmlNode.setAttribute("ACTIVITIMODEL", (String)object2);
                                String string = PSWFVersionService.this.getBPMNModel(jSONObject.toString());
                                if (n == 1) {
                                    string = PSWFVersionService.this.processBPMNModel(string);
                                }
                                pSWFVersion2.setBPMNModel(string);
                            }
                        }
                        pSWFVersion2.setActivitiModel(XmlNode.export(xmlNode));
                    } else {
                        pSWFVersion2.setActivitiModel(null);
                    }
                } else {
                    object = bl = pSWFVersion2.getWFModel();
                    xmlNode = XmlNode.loadFromXML((String)bl);
                    if (xmlNode != null) {
                        xmlNode.setAttribute("PSWFID", pSWFVersion2.getPSWFId());
                        xmlNode.setAttribute("PSWFVERSIONID", pSWFVersion2.getPSWFVersionId());
                        xmlNode.setAttribute("PSSYSTEMID", pSWFVersion2.getPSSystemId());
                        PSWFVersionService.this.updatePSWFVersionModel(pSWFVersion2, xmlNode, hashMap, hashMap2);
                        pSWFVersion2.setWFModel(XmlNode.export(xmlNode));
                    } else {
                        pSWFVersion2.setWFModel(null);
                    }
                }
                boolean bl2 = false;
                if (hashMap2.size() > 0) {
                    for (Object object2 : hashMap2.values()) {
                        if (StringHelper.isNullOrEmpty((String)pSWFVersion2.getPSWFVersionName())) {
                            log.info((Object)StringHelper.format((String)"\u5de5\u4f5c\u6d41\u7248\u672c[%1$s]\u5220\u9664\u8fde\u63a5[%2$s]", (Object)pSWFVersion2.getPSWFVersionId(), (Object)((PSWFLinkBase)object2).getPSWFLinkName()));
                        } else {
                            log.info((Object)StringHelper.format((String)"\u5de5\u4f5c\u6d41\u7248\u672c[%1$s]\u5220\u9664\u8fde\u63a5[%2$s]", (Object)pSWFVersion2.getPSWFVersionName(), (Object)((PSWFLinkBase)object2).getPSWFLinkName()));
                        }
                        pSWFLinkService.removeTemp((IEntity)object2);
                        bl2 = true;
                    }
                }
                if (hashMap.size() > 0) {
                    for (Object object2 : hashMap.values()) {
                        if (StringHelper.isNullOrEmpty((String)pSWFVersion2.getPSWFVersionName())) {
                            log.info((Object)StringHelper.format((String)"\u5de5\u4f5c\u6d41\u7248\u672c[%1$s]\u5220\u9664\u5904\u7406[%2$s]", (Object)pSWFVersion2.getPSWFVersionId(), (Object)((PSWFProcessBase)object2).getPSWFProcessName()));
                        } else {
                            log.info((Object)StringHelper.format((String)"\u5de5\u4f5c\u6d41\u7248\u672c[%1$s]\u5220\u9664\u5904\u7406[%2$s]", (Object)pSWFVersion2.getPSWFVersionName(), (Object)((PSWFProcessBase)object2).getPSWFProcessName()));
                        }
                        pSWFProcessService.removeTemp((IEntity)object2);
                        bl2 = true;
                    }
                }
                if (bl2) {
                    if (StringHelper.isNullOrEmpty((String)pSWFVersion2.getPSWFVersionName())) {
                        log.info((Object)StringHelper.format((String)"\u5de5\u4f5c\u6d41\u7248\u672c[%1$s]Xml\u6a21\u578b\r\n%2$s", (Object)pSWFVersion2.getPSWFVersionId(), (Object)object));
                    } else {
                        log.info((Object)StringHelper.format((String)"\u5de5\u4f5c\u6d41\u7248\u672c[%1$s]Xml\u6a21\u578b\r\n%2$s", (Object)pSWFVersion2.getPSWFVersionName(), (Object)object));
                    }
                }
                PSWFVersionService.this.resetPSDEUIActions(pSWFVersion2);
                PSWFVersionService.this.updateTempMajor(pSWFVersion2);
                PSWFVersionService.this.rebuildPSDEUIActions(pSWFVersion2);
                PSWFVersionService.this.createPSWFVerBak(pSWFVersion2);
            }
        });
    }

    protected void updatePSWFVersionModel(PSWFVersion pSWFVersion, XmlNode xmlNode, HashMap<String, PSWFProcess> hashMap, HashMap<String, PSWFLink> hashMap2) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            ArrayList<Object> arrayList2 = new ArrayList<Object>();
            PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService((String)PSWFProcessService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            PSWFLinkService pSWFLinkService = (PSWFLinkService)ServiceGlobal.getService((String)PSWFLinkService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            while (iterator.hasNext()) {
                String string;
                String string2;
                String string3;
                boolean bl;
                EntityBase entityBase;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                if (StringHelper.compare((String)xmlNode2.getNodeName(), (String)XMLNODE_WFPROCESS, (boolean)true) == 0) {
                    int n;
                    String string4 = xmlNode2.getAttribute("PSWFPROCESSID", "");
                    if (StringHelper.isNullOrEmpty((String)string4) || (entityBase = hashMap.remove(string4)) == null) continue;
                    bl = false;
                    if (StringHelper.compare((String)entityBase.getPSWFVersionId(), (String)pSWFVersion.getPSWFVersionId(), (boolean)false) != 0) {
                        entityBase.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)entityBase.getPSWFVersionName(), (String)pSWFVersion.getPSWFVersionName(), (boolean)false) != 0) {
                        entityBase.setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                        bl = true;
                    }
                    string3 = xmlNode2.getAttribute("LEFTPOS", "");
                    string2 = xmlNode2.getAttribute("TOPPOS", "");
                    if (!StringHelper.isNullOrEmpty((String)string3)) {
                        n = Integer.parseInt(string3);
                        if (entityBase.getLeftPos() == null || entityBase.getLeftPos() != n) {
                            entityBase.setLeftPos(n);
                            bl = true;
                        }
                    }
                    if (!StringHelper.isNullOrEmpty((String)string2)) {
                        n = Integer.parseInt(string2);
                        if (entityBase.getTopPos() == null || entityBase.getTopPos() != n) {
                            entityBase.setTopPos(n);
                            bl = true;
                        }
                    }
                    if (bl) {
                        pSWFProcessService.updateTemp((IEntity)entityBase);
                    }
                    xmlNode2.resetAttributes();
                    entityBase.fillXmlNode(xmlNode2, false);
                    arrayList.add(xmlNode2);
                    continue;
                }
                if (StringHelper.compare((String)xmlNode2.getNodeName(), (String)XMLNODE_WFLINK, (boolean)true) != 0 || StringHelper.isNullOrEmpty((String)(string = xmlNode2.getAttribute("PSWFLINKID", ""))) || (entityBase = hashMap2.remove(string)) == null) continue;
                bl = false;
                string3 = xmlNode2.getAttribute("FROMPSWFPROCID", "");
                string2 = xmlNode2.getAttribute("SRCENDPOINT", "");
                if (StringHelper.compare((String)entityBase.getFromPSWFProcId(), (String)string3, (boolean)false) == 0 && (StringHelper.isNullOrEmpty((String)entityBase.getSrcEndPoint()) || StringHelper.compare((String)entityBase.getSrcEndPoint(), (String)string2, (boolean)false) == 0)) {
                    if (StringHelper.compare((String)entityBase.getPSWFVersionId(), (String)pSWFVersion.getPSWFVersionId(), (boolean)false) != 0) {
                        entityBase.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)entityBase.getPSWFVersionName(), (String)pSWFVersion.getPSWFVersionName(), (boolean)false) != 0) {
                        entityBase.setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                        bl = true;
                    }
                    String string5 = xmlNode2.getAttribute("DSTENDPOINT", "");
                    String string6 = xmlNode2.getAttribute("TOPSWFPROCID", "");
                    if (StringHelper.compare((String)entityBase.getSrcEndPoint(), (String)string2, (boolean)false) != 0) {
                        entityBase.setSrcEndPoint(string2);
                        bl = true;
                    }
                    if (StringHelper.compare((String)entityBase.getDstEndPoint(), (String)string5, (boolean)false) != 0) {
                        entityBase.setDstEndPoint(string5);
                        bl = true;
                    }
                    if (StringHelper.compare((String)entityBase.getToPSWFProcId(), (String)string6, (boolean)false) != 0) {
                        entityBase.setToPSWFProcId(string6);
                        bl = true;
                    }
                    if (bl) {
                        pSWFLinkService.updateTemp((IEntity)entityBase);
                    }
                } else {
                    log.error((Object)StringHelper.format((String)"\u5de5\u4f5c\u6d41\u8fde\u63a5\u7ebf[%1$s]\u8d77\u70b9\u53d1\u751f\u53d8\u5316", (Object)entityBase.getPSWFLinkName()));
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
    public void createWithModel(PSWFVersion pSWFVersion) throws Exception {
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        pSWFVersion2.setSessionFactory(this.getSessionFactory());
        log.debug((Object)"\u5f00\u59cb[createWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                Object object;
                EntityBase entityBase2;
                PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService((String)PSWFProcessService.class.getCanonicalName(), (SessionFactory)PSWFVersionService.this.getSessionFactory());
                ArrayList<PSWFProcess> arrayList = pSWFProcessService.selectTempByPSWFVersion(pSWFVersion2);
                HashMap<String, PSWFProcess> hashMap = new HashMap<String, PSWFProcess>();
                for (PSWFProcess serializable2 : arrayList) {
                    hashMap.put(serializable2.getPSWFProcessId(), serializable2);
                }
                PSWFLinkService pSWFLinkService = (PSWFLinkService)ServiceGlobal.getService((String)PSWFLinkService.class.getCanonicalName(), (SessionFactory)PSWFVersionService.this.getSessionFactory());
                ArrayList<PSWFLink> arrayList2 = pSWFLinkService.selectTempByPSWFVersion(pSWFVersion2);
                HashMap<String, PSWFLink> hashMap2 = new HashMap<String, PSWFLink>();
                for (EntityBase entityBase2 : arrayList2) {
                    hashMap2.put(entityBase2.getPSWFLinkId(), (PSWFLink)entityBase2);
                }
                pSWFVersion2.setBPMNModel(null);
                if (StringHelper.compare((String)pSWFVersion2.getPSWF().getWFEngineType(), (String)"ACTIVITI", (boolean)false) == 0) {
                    object = pSWFVersion2.getActivitiModel();
                    entityBase2 = XmlNode.loadFromXML((String)object);
                    if (entityBase2 != null) {
                        com.alibaba.fastjson.JSONObject jSONObject;
                        entityBase2.setAttribute("PSWFID", pSWFVersion2.getPSWFId());
                        entityBase2.setAttribute("PSSYSTEMID", pSWFVersion2.getPSSystemId());
                        entityBase2.setAttribute("PSWFVERSIONID", pSWFVersion2.getPSWFVersionId());
                        String string = entityBase2.getAttribute("ACTIVITIMODEL", "");
                        com.alibaba.fastjson.JSONObject jSONObject2 = null;
                        if (!StringHelper.isNullOrEmpty((String)string) && (jSONObject = (jSONObject2 = com.alibaba.fastjson.JSONObject.parseObject((String)string)).getJSONObject("json_xml")) != null) {
                            com.alibaba.fastjson.JSONArray jSONArray = jSONObject.getJSONArray("childShapes");
                            int n = DataObject.getIntegerValue((Object)pSWFVersion2.getPSWF().getRemoteEngineFlag(), (Integer)0);
                            if (jSONArray != null) {
                                PSWFVersionHelper pSWFVersionHelper = new PSWFVersionHelper(PSWFVersionService.this.getSessionFactory());
                                if (n == 1) {
                                    pSWFVersionHelper.updatePSWFVersionModel3(pSWFVersion2, jSONArray, hashMap, hashMap2);
                                } else {
                                    pSWFVersionHelper.updatePSWFVersionModel2(pSWFVersion2, jSONArray, hashMap, hashMap2);
                                }
                                string = jSONObject2.toString();
                                entityBase2.setAttribute("ACTIVITIMODEL", string);
                                String string2 = PSWFVersionService.this.getBPMNModel(jSONObject.toString());
                                if (n == 1) {
                                    string2 = PSWFVersionService.this.processBPMNModel(string2);
                                }
                                pSWFVersion2.setBPMNModel(string2);
                            }
                        }
                        pSWFVersion2.setActivitiModel(XmlNode.export((XmlNode)entityBase2));
                    } else {
                        pSWFVersion2.setActivitiModel(null);
                    }
                } else {
                    object = pSWFVersion2.getWFModel();
                    entityBase2 = XmlNode.loadFromXML((String)object);
                    if (entityBase2 != null) {
                        entityBase2.setAttribute("PSWFID", pSWFVersion2.getPSWFId());
                        entityBase2.setAttribute("PSSYSTEMID", pSWFVersion2.getPSSystemId());
                        entityBase2.setAttribute("PSWFVERSIONID", pSWFVersion2.getPSWFVersionId());
                        PSWFVersionService.this.updatePSWFVersionModel(pSWFVersion2, (XmlNode)entityBase2, hashMap, hashMap2);
                        pSWFVersion2.setWFModel(XmlNode.export((XmlNode)entityBase2));
                    } else {
                        pSWFVersion2.setWFModel(null);
                    }
                }
                if (hashMap2.size() > 0) {
                    for (EntityBase entityBase2 : hashMap2.values()) {
                        pSWFLinkService.removeTemp((IEntity)entityBase2);
                    }
                }
                if (hashMap.size() > 0) {
                    for (EntityBase entityBase2 : hashMap.values()) {
                        pSWFProcessService.removeTemp((IEntity)entityBase2);
                    }
                }
                if (!StringHelper.isNullOrEmpty((String)pSWFVersion2.getPSDynaInstId())) {
                    pSWFVersion2.setDynaSysRefMode(DynaSysRefModeCodeListModel.DYNASYSINST);
                }
                PSWFVersionService.this.createTempMajor((IEntity)pSWFVersion2);
                PSWFVersionService.this.rebuildPSDEUIActions(pSWFVersion2);
                PSWFVersionService.this.createPSWFVerBak(pSWFVersion2);
            }
        });
    }

    @Override
    public void getDraftWithModel(PSWFVersion pSWFVersion) throws Exception {
        this.getDraftTempMajor((IEntity)pSWFVersion);
        pSWFVersion.setWFModel(this.getWFModel(pSWFVersion));
        if (StringHelper.compare((String)pSWFVersion.getPSWF().getWFEngineType(), (String)"ACTIVITI", (boolean)false) == 0) {
            pSWFVersion.setActivitiModel(this.getActivitiModel(pSWFVersion));
        }
    }

    @Override
    protected void onAfterGetDraftTemp(PSWFVersion pSWFVersion) throws Exception {
        Object object;
        Object object2;
        super.onAfterGetDraftTemp(pSWFVersion);
        if (pSWFVersion.getWFVersion() == null && !StringHelper.isNullOrEmpty((String)(object2 = pSWFVersion.getPSWF().getPSWorkflowId()))) {
            object = new SelectContext();
            object.addSelectField("WFVERSION", "WFVERSION", "MAX");
            object.set("PSWFID", object2);
            ArrayList arrayList = this.selectEx((ISelectContext)object);
            if (arrayList.size() > 0) {
                int n = DataObject.getIntegerValue((Object)((PSWFVersion)arrayList.get(0)).getWFVersion(), (Integer)0);
                pSWFVersion.setWFVersion(n + 1);
            }
        }
        object2 = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        if (StringHelper.compare((String)pSWFVersion.getPSWF().getWFEngineType(), (String)"ACTIVITI", (boolean)false) != 0) {
            object = new PSWFProcess();
            ((PSWFProcessBase)object).setWFProcessType("START");
            ((PSWFProcessBase)object).setPSWFProcessName("\u5f00\u59cb\u6d41\u7a0b");
            ((PSWFProcessBase)object).setCodeName("Start");
            ((PSWFProcessBase)object).setPSWFVersionId(pSWFVersion.getPSWFVersionId());
            ((PSWFProcessBase)object).setLeftPos(200);
            ((PSWFProcessBase)object).setTopPos(200);
            ((PSWFProcessBase)object).setPSSystemId(pSWFVersion.getPSSystemId());
            ((PSCoreSysServiceBase)object2).createTemp(object);
            object = new PSWFProcess();
            ((PSWFProcessBase)object).setWFProcessType("END");
            ((PSWFProcessBase)object).setPSWFProcessName("\u7ed3\u675f");
            ((PSWFProcessBase)object).setCodeName("End");
            ((PSWFProcessBase)object).setPSWFVersionId(pSWFVersion.getPSWFVersionId());
            ((PSWFProcessBase)object).setLeftPos(400);
            ((PSWFProcessBase)object).setTopPos(400);
            ((PSWFProcessBase)object).setPSSystemId(pSWFVersion.getPSSystemId());
            ((PSCoreSysServiceBase)object2).createTemp(object);
        }
    }

    @Override
    protected void onAfterGetDraft(PSWFVersion pSWFVersion) throws Exception {
        String string;
        super.onAfterGetDraft(pSWFVersion);
        if (pSWFVersion.getWFVersion() == null && !StringHelper.isNullOrEmpty((String)(string = pSWFVersion.getPSWF().getPSWorkflowId()))) {
            SelectContext selectContext = new SelectContext();
            selectContext.addSelectField("WFVERSION", "WFVERSION", "MAX");
            selectContext.set("PSWFID", (Object)string);
            ArrayList arrayList = this.selectEx((ISelectContext)selectContext);
            if (arrayList.size() > 0) {
                int n = DataObject.getIntegerValue((Object)((PSWFVersion)arrayList.get(0)).getWFVersion(), (Integer)0);
                pSWFVersion.setWFVersion(n + 1);
            }
        }
    }

    @Override
    protected void onBeforeCreate(PSWFVersion pSWFVersion) throws Exception {
        if (DataObject.getIntegerValue((Object)pSWFVersion.getPSWF().getWFProxyMode(), (Integer)0) == 1) {
            throw new Exception(StringHelper.format((String)"\u5de5\u4f5c\u6d41[%1$s]\u542f\u52a8\u5916\u90e8\u4ee3\u7406\u6a21\u5f0f\uff0c\u4e0d\u5141\u8bb8\u6dfb\u52a0\u6d41\u7a0b\u7248\u672c", (Object)pSWFVersion.getPSWF().getPSWorkflowName()));
        }
        pSWFVersion.setPSWFVersionName(this.calcPSWFVersionName(pSWFVersion));
        pSWFVersion.setWFModel(null);
        super.onBeforeCreate(pSWFVersion);
    }

    @Override
    protected void onBeforeUpdate(PSWFVersion pSWFVersion) throws Exception {
        pSWFVersion.setPSWFVersionName(this.calcPSWFVersionName(pSWFVersion));
        pSWFVersion.setWFModel(null);
        super.onBeforeUpdate(pSWFVersion);
    }

    protected String calcPSWFVersionName(PSWFVersion pSWFVersion) {
        if (StringHelper.isNullOrEmpty((String)pSWFVersion.getPSWFName())) {
            return pSWFVersion.getPSWFVersionName();
        }
        if (DataObject.getBoolValue((Integer)pSWFVersion.getEnableDynaSys(), (boolean)false)) {
            return StringHelper.format((String)"%1$s", (Object)pSWFVersion.getPSWFName());
        }
        if (pSWFVersion.isWFVersionDirty() && pSWFVersion.getWFVersion() != null) {
            return StringHelper.format((String)"%1$s v%2$s", (Object)pSWFVersion.getPSWFName(), (Object)pSWFVersion.getWFVersion());
        }
        if (pSWFVersion.isDynaWFVerDirty() && pSWFVersion.getDynaWFVer() != null) {
            return StringHelper.format((String)"%1$s v%2$s", (Object)pSWFVersion.getPSWFName(), (Object)pSWFVersion.getDynaWFVer());
        }
        return pSWFVersion.getPSWFVersionName();
    }

    @Override
    public void getDraftFromWithModel(PSWFVersion pSWFVersion) throws Exception {
        super.getDraftTempMajorFrom(pSWFVersion);
        pSWFVersion.setWFModel(this.getWFModel(pSWFVersion));
        if (StringHelper.compare((String)pSWFVersion.getPSWF().getWFEngineType(), (String)"ACTIVITI", (boolean)false) == 0) {
            pSWFVersion.setActivitiModel(this.getActivitiModel(pSWFVersion));
        }
    }

    protected void resetPSDEUIActions(PSWFVersion pSWFVersion) throws Exception {
        PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
        PSDEUAGroupDetailService pSDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        PSWFVersion pSWFVersion2 = new PSWFVersion();
        pSWFVersion2.setPSWFVersionId((String)PSWFVersion.getOriginKey((IEntity)pSWFVersion));
        HashMap<String, PSDEUIAction> hashMap = new HashMap<String, PSDEUIAction>();
        ArrayList<PSDEUAGroup> arrayList = pSDEUAGroupService.selectByPSWFVersion(pSWFVersion2);
        ArrayList<PSDEUIAction> arrayList2 = pSDEUIActionService.selectByPSWFVersion(pSWFVersion2);
        for (PSDEUIAction entityBase : arrayList2) {
            hashMap.put(entityBase.getPSDEUIActionId(), entityBase);
        }
        for (PSDEUAGroup pSDEUAGroup : arrayList) {
            ArrayList<PSDEUAGroupDetail> arrayList3 = pSDEUAGroupDetailService.selectByPSDEUAGroup(pSDEUAGroup);
            for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList3) {
                if (!hashMap.containsKey(pSDEUAGroupDetail.getPSDEUIActionId())) continue;
                pSDEUAGroupDetailService.remove((IEntity)pSDEUAGroupDetail);
            }
        }
    }

    protected void createPSWFVerBak(PSWFVersion pSWFVersion) throws Exception {
        PSWFVerLog pSWFVerLog;
        Serializable serializable;
        boolean bl = false;
        if (pSWFVersion.isEnableLogDirty()) {
            bl = DataObject.getBoolValue((Integer)pSWFVersion.getEnableLog(), (boolean)false);
        } else {
            serializable = (PSWFVersion)this.getLast((IEntity)pSWFVersion);
            if (serializable != null) {
                bl = DataObject.getBoolValue((Integer)((PSWFVersionBase)serializable).getEnableLog(), (boolean)false);
            }
        }
        if (!bl) {
            return;
        }
        serializable = new ArrayList();
        PSWFVersion pSWFVersion2 = new PSWFVersion();
        pSWFVersion2.setPSWFVersionId((String)PSWFVersion.getOriginKey((IEntity)pSWFVersion));
        this.get((IEntity)pSWFVersion2);
        this.exportModel((IEntity)pSWFVersion2, (ArrayList)serializable);
        if (((ArrayList)serializable).size() > 0) {
            ((ArrayList)serializable).remove(0);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("items", (Object)((ArrayList)serializable).toArray());
        String string = jSONObject.toString();
        int n = string.length();
        String string2 = Base64Helper.encodeBytes((byte[])string.getBytes("UTF8"), (int)2);
        int n2 = string2.length();
        String string3 = KeyValueHelper.genUniqueId((String)string2);
        PSWFVerLogService pSWFVerLogService = (PSWFVerLogService)ServiceGlobal.getService(PSWFVerLogService.class, (SessionFactory)this.getSessionFactory());
        SelectContext selectContext = new SelectContext();
        selectContext.addSelectField(SelectField.create((String)"PSWFVERLOGID"));
        selectContext.addSelectField(SelectField.create((String)"BACKDATATAG"));
        selectContext.setMaxRowCount(1);
        selectContext.setConditon("PSWFVERSIONID", (Object)pSWFVersion2.getPSWFVersionId());
        selectContext.setOrderInfo("ORDER BY CREATEDATE DESC");
        ArrayList arrayList = pSWFVerLogService.selectEx((ISelectContext)selectContext);
        if (arrayList.size() > 0 && StringHelper.compare((String)((PSWFVerLog)arrayList.get(0)).getBackDataTag(), (String)string3, (boolean)false) == 0) {
            return;
        }
        selectContext.reset();
        selectContext.addSelectField(SelectField.create((String)"PSWFVERLOGID"));
        selectContext.setMaxRowCount(20);
        selectContext.setConditon("PSWFVERSIONID", (Object)pSWFVersion2.getPSWFVersionId());
        selectContext.setOrderInfo("ORDER BY CREATEDATE");
        arrayList = pSWFVerLogService.selectEx((ISelectContext)selectContext);
        if (arrayList.size() >= 20) {
            pSWFVerLog = (PSWFVerLog)arrayList.get(0);
            pSWFVerLogService.remove((IEntity)pSWFVerLog);
        }
        pSWFVerLog = new PSWFVerLog();
        pSWFVerLog.setPSWFVerLogName(StringHelper.format((String)"[%1$s]\u5907\u4efd", (Object)DateHelper.toDateTimeString((Date)new Date())));
        pSWFVerLog.setPSWFVersionId(pSWFVersion2.getPSWFVersionId());
        pSWFVerLog.setPSWFVersionName(pSWFVersion2.getPSWFVersionName());
        pSWFVerLog.setBackDataTag(string3);
        pSWFVerLog.setBackupData(string2);
        pSWFVerLogService.create(pSWFVerLog, false);
    }

    public void restorePSWFVerLog(PSWFVerLog pSWFVerLog) throws Exception {
        final PSWFVerLog pSWFVerLog2 = pSWFVerLog;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFVersionService.this.onRestorePSWFVerLog(pSWFVerLog2);
            }
        });
    }

    protected void onRestorePSWFVerLog(PSWFVerLog pSWFVerLog) throws Exception {
        String string = new String(Base64Helper.decode((String)pSWFVerLog.getBackupData()), "UTF8");
        JSONObject jSONObject = JSONObjectHelper.fromString((String)string);
        JSONArray jSONArray = jSONObject.optJSONArray("items");
        if (jSONArray == null) {
            throw new Exception("\u5907\u4efd\u6570\u636e\u65e0\u6548");
        }
        for (int i = 0; i < jSONArray.length(); ++i) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string2 = jSONObject2.optString("srfdename", "");
            if (StringHelper.isNullOrEmpty((String)string2)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5bfc\u5165\u7684\u6570\u636e\u5bf9\u8c61\u6807\u8bc6");
            }
            try {
                IService iService = DEModelGlobal.getDEModel((String)string2).getService(this.getSessionFactory());
                String string3 = iService.importModel(jSONObject2);
                if (StringHelper.isNullOrEmpty((String)string3)) continue;
                log.debug((Object)StringHelper.format((String)"[%1$s]\u5bfc\u5165\u6570\u636e[%2$s]", (Object)iService.getDEModel().getName(), (Object)string3));
                continue;
            }
            catch (Exception exception) {
                throw new Exception(StringHelper.format((String)"\u5bfc\u5165\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
        }
        PSWFVersion pSWFVersion = new PSWFVersion();
        pSWFVersion.setPSWFVersionId(pSWFVerLog.getPSWFVersionId());
        this.get((IEntity)pSWFVersion);
        pSWFVersion.set("SRFORIKEY", pSWFVerLog.getPSWFVersionId());
        this.resetPSDEUIActions(pSWFVersion);
        this.rebuildPSDEUIActions(pSWFVersion);
    }

    /*
     * WARNING - void declaration
     */
    public void rebuildPSDEUIActions(PSWFVersion pSWFVersion) throws Exception {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
        PSDEUAGroupDetailService pSDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        PSWFUtilUIActionService pSWFUtilUIActionService = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
        boolean bl = DataObject.getBoolValue((Integer)pSWFVersion.getPSWF().getEnableMob(), (boolean)false);
        PSWFVersion pSWFVersion2 = new PSWFVersion();
        pSWFVersion2.setPSWFVersionId((String)PSWFVersion.getOriginKey((IEntity)pSWFVersion));
        if (StringHelper.isNullOrEmpty((String)pSWFVersion2.getPSWFVersionId())) {
            pSWFVersion2.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
        }
        if (StringHelper.isNullOrEmpty((String)pSWFVersion2.getPSWFVersionId()) || KeyValueHelper.isTempKey((String)pSWFVersion2.getPSWFVersionId())) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u91cd\u5efa\u5de5\u4f5c\u6d41\u754c\u9762\u884c\u4e3a\uff0c\u4f20\u5165\u6d41\u7a0b\u7248\u672c\u6807\u8bc6\u65e0\u6548"));
        }
        ArrayList<PSDEUAGroup> arrayList = pSDEUAGroupService.selectByPSWFVersion(pSWFVersion2);
        ArrayList<PSDEUIAction> arrayList2 = pSDEUIActionService.selectByPSWFVersion(pSWFVersion2);
        HashMap<String, PSDEUAGroup> hashMap = new HashMap<String, PSDEUAGroup>();
        HashMap<String, PSDEUIAction> hashMap2 = new HashMap<String, PSDEUIAction>();
        for (PSDEUAGroup object82 : arrayList) {
            hashMap.put(object82.getPSDEUAGroupId(), object82);
        }
        for (PSDEUIAction pSDEUIAction : arrayList2) {
            hashMap2.put(pSDEUIAction.getPSDEUIActionId(), pSDEUIAction);
        }
        String string = pSWFVersion.getPSWFId();
        String string2 = pSWFVersion2.getPSWFVersionId();
        String string3 = pSWFVersion.getPSSystemId();
        HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
        WFUtilUIActionType2CodeListModel wFUtilUIActionType2CodeListModel = (WFUtilUIActionType2CodeListModel)CodeListGlobal.getCodeList(WFUtilUIActionType2CodeListModel.class);
        HashMap<String, PSWFUtilUIAction> hashMap4 = new HashMap<String, PSWFUtilUIAction>();
        for (String string4 : PREDEFINEDACTIONS) {
            PSWFUtilUIAction pSWFUtilUIAction = new PSWFUtilUIAction();
            pSWFUtilUIAction.setPSWFUtilUIActionId(KeyValueHelper.genUniqueId((String)string3, (String)string4, (String)string, (String)pSWFVersion.getPSWFVersionId()));
            if (pSWFUtilUIActionService.get((IEntity)pSWFUtilUIAction, true)) {
                hashMap4.put(string4, pSWFUtilUIAction);
                continue;
            }
            pSWFUtilUIAction.setPSWFUtilUIActionId(KeyValueHelper.genUniqueId((String)string3, (String)string4, (String)string, (String)"__EMTPY__"));
            if (pSWFUtilUIActionService.get((IEntity)pSWFUtilUIAction, true)) {
                hashMap4.put(string4, pSWFUtilUIAction);
                continue;
            }
            pSWFUtilUIAction.setPSWFUtilUIActionId(KeyValueHelper.genUniqueId((String)string3, (String)string4, (String)"__EMTPY__", (String)"__EMTPY__"));
            if (!pSWFUtilUIActionService.get((IEntity)pSWFUtilUIAction, true)) continue;
            hashMap4.put(string4, pSWFUtilUIAction);
        }
        Object object6 = null;
        PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcess> arrayList3 = pSWFProcessService.selectByPSWFVersion(pSWFVersion2);
        for (PSWFProcess pSWFProcess : arrayList3) {
            if (StringHelper.compare((String)pSWFProcess.getWFProcessType(), (String)"INTERACTIVE", (boolean)true) != 0 && StringHelper.compare((String)pSWFProcess.getWFProcessType(), (String)"START", (boolean)true) != 0) continue;
            if (StringHelper.compare((String)pSWFProcess.getWFProcessType(), (String)"START", (boolean)true) == 0) {
                object6 = pSWFProcess;
            }
            object5 = pSWFProcess.getPSWFProcessId();
            boolean bl2 = false;
            if (hashMap.containsKey(object5)) {
                bl2 = true;
            } else {
                for (PSDEUAGroup pSDEUAGroup : arrayList) {
                    if (StringHelper.compare((String)pSDEUAGroup.getPSWFProcessId(), (String)pSWFProcess.getPSWFProcessId(), (boolean)false) != 0 || StringHelper.compare((String)pSDEUAGroup.getUAGTag(), (String)"IAACTION", (boolean)false) != 0 || !StringHelper.isNullOrEmpty((String)pSDEUAGroup.getUAGTag2())) continue;
                    object5 = pSDEUAGroup.getPSDEUAGroupId();
                    bl2 = true;
                    break;
                }
            }
            object4 = new PSDEUAGroup();
            ((PSDEUAGroupBase)object4).setPSDEUAGroupId((String)object5);
            ((PSDEUAGroupBase)object4).setPSSystemId(pSWFVersion.getPSWF().getPSSystemId());
            ((PSDEUAGroupBase)object4).setPSSystemName(pSWFVersion.getPSWF().getPSSystemName());
            ((PSDEUAGroupBase)object4).setPSWFId(pSWFVersion.getPSWFId());
            ((PSDEUAGroupBase)object4).setPSWFVersionId(pSWFVersion2.getPSWFVersionId());
            ((PSDEUAGroupBase)object4).setPSDEUAGroupName(pSWFProcess.getPSWFProcessName());
            ((PSDEUAGroupBase)object4).setUAGTag("IAACTION");
            ((PSDEUAGroupBase)object4).setUAGTag2(null);
            ((PSDEUAGroupBase)object4).setPSWFProcessId(pSWFProcess.getPSWFProcessId());
            ((PSDEUAGroupBase)object4).setPSWFProcessName(pSWFProcess.getPSWFProcessName());
            if (bl2) {
                pSDEUAGroupService.update(object4);
            } else {
                pSDEUAGroupService.create(object4);
            }
            hashMap.remove(object5);
            hashMap3.put(pSWFProcess.getPSWFProcessId(), object5);
            if (bl) {
                object5 = KeyValueHelper.genUniqueId((String)"MOB", (String)pSWFProcess.getPSWFProcessId());
                bl2 = false;
                if (hashMap.containsKey(object5)) {
                    bl2 = true;
                } else {
                    for (PSDEUAGroup pSDEUAGroup : arrayList) {
                        if (StringHelper.compare((String)pSDEUAGroup.getPSWFProcessId(), (String)pSWFProcess.getPSWFProcessId(), (boolean)false) != 0 || StringHelper.compare((String)pSDEUAGroup.getUAGTag(), (String)"IAACTION", (boolean)false) != 0 || StringHelper.compare((String)pSDEUAGroup.getUAGTag2(), (String)"MOB", (boolean)false) != 0) continue;
                        object5 = pSDEUAGroup.getPSDEUAGroupId();
                        bl2 = true;
                        break;
                    }
                }
                object4 = new PSDEUAGroup();
                ((PSDEUAGroupBase)object4).setPSDEUAGroupId((String)object5);
                ((PSDEUAGroupBase)object4).setPSSystemId(pSWFVersion.getPSWF().getPSSystemId());
                ((PSDEUAGroupBase)object4).setPSSystemName(pSWFVersion.getPSWF().getPSSystemName());
                ((PSDEUAGroupBase)object4).setPSWFId(pSWFVersion.getPSWFId());
                ((PSDEUAGroupBase)object4).setPSWFVersionId(pSWFVersion2.getPSWFVersionId());
                ((PSDEUAGroupBase)object4).setPSDEUAGroupName(pSWFProcess.getPSWFProcessName() + "[\u79fb\u52a8\u7aef]");
                ((PSDEUAGroupBase)object4).setUAGTag("IAACTION");
                ((PSDEUAGroupBase)object4).setUAGTag2("MOB");
                ((PSDEUAGroupBase)object4).setPSWFProcessId(pSWFProcess.getPSWFProcessId());
                ((PSDEUAGroupBase)object4).setPSWFProcessName(pSWFProcess.getPSWFProcessName());
                if (bl2) {
                    pSDEUAGroupService.update(object4);
                } else {
                    pSDEUAGroupService.create(object4);
                }
                hashMap.remove(object5);
                hashMap3.put("MOB:" + pSWFProcess.getPSWFProcessId(), object5);
            }
            if (StringHelper.compare((String)pSWFProcess.getWFProcessType(), (String)"INTERACTIVE", (boolean)true) != 0 || StringHelper.isNullOrEmpty((String)(object5 = pSWFProcess.getPredefinedActions()))) continue;
            String[] stringArray = ((String)object5).split("[;]");
            for (String string5 : stringArray) {
                object3 = wFUtilUIActionType2CodeListModel.getCodeItem(string5);
                object2 = (PSWFUtilUIAction)hashMap4.get(string5);
                if (object2 == null) {
                    throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u83b7\u53d6\u5de5\u4f5c\u6d41\u9884\u5b9a\u4e49\u884c\u4e3a[%1$s]\u8bbe\u5b9a", (Object)object3.getText()));
                }
                object = KeyValueHelper.genUniqueId((String)pSWFProcess.getPSWFProcessId(), (String)string5);
                boolean bl3 = false;
                if (hashMap.containsKey(object)) {
                    bl3 = true;
                } else {
                    for (PSDEUAGroup pSDEUAGroup : arrayList) {
                        if (StringHelper.compare((String)pSDEUAGroup.getPSWFProcessId(), (String)pSWFProcess.getPSWFProcessId(), (boolean)false) != 0 || StringHelper.compare((String)pSDEUAGroup.getUAGTag(), (String)"PDACTION", (boolean)false) != 0 || !StringHelper.isNullOrEmpty((String)pSDEUAGroup.getUAGTag2()) || StringHelper.compare((String)pSDEUAGroup.getUAGTag3(), (String)string5, (boolean)false) != 0) continue;
                        object = pSDEUAGroup.getPSDEUAGroupId();
                        bl3 = true;
                        break;
                    }
                }
                Object object7 = new PSDEUAGroup();
                ((PSDEUAGroupBase)object7).setPSDEUAGroupId((String)object);
                ((PSDEUAGroupBase)object7).setPSSystemId(pSWFVersion.getPSWF().getPSSystemId());
                ((PSDEUAGroupBase)object7).setPSSystemName(pSWFVersion.getPSWF().getPSSystemName());
                ((PSDEUAGroupBase)object7).setPSWFId(pSWFVersion.getPSWFId());
                ((PSDEUAGroupBase)object7).setPSWFVersionId(pSWFVersion2.getPSWFVersionId());
                ((PSDEUAGroupBase)object7).setPSDEUAGroupName(pSWFProcess.getPSWFProcessName() + "[" + object3.getText() + "]");
                ((PSDEUAGroupBase)object7).setUAGTag("PDACTION");
                ((PSDEUAGroupBase)object7).setUAGTag2(null);
                ((PSDEUAGroupBase)object7).setUAGTag3(string5);
                ((PSDEUAGroupBase)object7).setPSWFProcessId(pSWFProcess.getPSWFProcessId());
                ((PSDEUAGroupBase)object7).setPSWFProcessName(pSWFProcess.getPSWFProcessName());
                if (bl3) {
                    pSDEUAGroupService.update(object7);
                } else {
                    pSDEUAGroupService.create(object7);
                }
                hashMap.remove(object);
                PSDEUAGroupDetail pSDEUAGroupDetail = new PSDEUAGroupDetail();
                pSDEUAGroupDetail.setDetailType("DEUIACTION");
                pSDEUAGroupDetail.setPSDEUAGroupId((String)object);
                pSDEUAGroupDetail.setPSDEUIActionId(((PSWFUtilUIActionBase)object2).getPSDEUIActionId());
                pSDEUAGroupDetail.setOrderValue(100);
                pSDEUAGroupDetail.setUIActionParams(StringHelper.format((String)"srfwfid=%1$s\r\nsrfwfversionid=%2$s", (Object)string, (Object)string2));
                pSDEUAGroupDetailService.save((IEntity)pSDEUAGroupDetail);
                if (!bl) continue;
                object = KeyValueHelper.genUniqueId((String)"MOB", (String)pSWFProcess.getPSWFProcessId(), (String)string5);
                bl3 = false;
                if (hashMap.containsKey(object)) {
                    bl3 = true;
                } else {
                    for (PSDEUAGroup pSDEUAGroup : arrayList) {
                        if (StringHelper.compare((String)pSDEUAGroup.getPSWFProcessId(), (String)pSWFProcess.getPSWFProcessId(), (boolean)false) != 0 || StringHelper.compare((String)pSDEUAGroup.getUAGTag(), (String)"PDACTION", (boolean)false) != 0 || StringHelper.compare((String)pSDEUAGroup.getUAGTag2(), (String)"MOB", (boolean)false) != 0 || StringHelper.compare((String)pSDEUAGroup.getUAGTag3(), (String)string5, (boolean)false) != 0) continue;
                        object = pSDEUAGroup.getPSDEUAGroupId();
                        bl3 = true;
                        break;
                    }
                }
                object7 = new PSDEUAGroup();
                ((PSDEUAGroupBase)object7).setPSDEUAGroupId((String)object);
                ((PSDEUAGroupBase)object7).setPSSystemId(pSWFVersion.getPSWF().getPSSystemId());
                ((PSDEUAGroupBase)object7).setPSSystemName(pSWFVersion.getPSWF().getPSSystemName());
                ((PSDEUAGroupBase)object7).setPSWFId(pSWFVersion.getPSWFId());
                ((PSDEUAGroupBase)object7).setPSWFVersionId(pSWFVersion2.getPSWFVersionId());
                ((PSDEUAGroupBase)object7).setPSDEUAGroupName(pSWFProcess.getPSWFProcessName() + "[" + object3.getText() + "][\u79fb\u52a8\u7aef]");
                ((PSDEUAGroupBase)object7).setUAGTag("PDACTION");
                ((PSDEUAGroupBase)object7).setUAGTag2("MOB");
                ((PSDEUAGroupBase)object7).setUAGTag3(string5);
                ((PSDEUAGroupBase)object7).setPSWFProcessId(pSWFProcess.getPSWFProcessId());
                ((PSDEUAGroupBase)object7).setPSWFProcessName(pSWFProcess.getPSWFProcessName());
                if (bl3) {
                    pSDEUAGroupService.update(object7);
                } else {
                    pSDEUAGroupService.create(object7);
                }
                hashMap.remove(object);
                PSDEUAGroupDetail pSDEUAGroupDetail2 = new PSDEUAGroupDetail();
                pSDEUAGroupDetail2.setDetailType("DEUIACTION");
                pSDEUAGroupDetail2.setPSDEUAGroupId((String)object);
                pSDEUAGroupDetail2.setPSDEUIActionId(((PSWFUtilUIActionBase)object2).getPSDEUIActionId());
                pSDEUAGroupDetail2.setOrderValue(100);
                pSDEUAGroupDetail2.setUIActionParams(StringHelper.format((String)"srfwfid=%1$s\r\nsrfwfversionid=%2$s", (Object)string, (Object)string2));
                pSDEUAGroupDetailService.save((IEntity)pSDEUAGroupDetail2);
            }
        }
        PSWFLinkService pSWFLinkService = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFLink> arrayList4 = pSWFLinkService.selectByPSWFVersion(pSWFVersion2);
        for (PSWFLink pSWFLink : arrayList4) {
            if (StringHelper.compare((String)pSWFLink.getWFLinkType(), (String)"IAACTION", (boolean)true) != 0) continue;
            object4 = new PSDEUIAction();
            String string6 = pSWFLink.getPSWFLinkId();
            ((PSDEUIActionBase)object4).setPSDEUIActionId(string6);
            int n = 0;
            if (hashMap2.containsKey(string6)) {
                n = 1;
            }
            ((PSDEUIActionBase)object4).setPSWFId(pSWFVersion.getPSWFId());
            ((PSDEUIActionBase)object4).setPSWFVersionId(pSWFVersion2.getPSWFVersionId());
            ((PSDEUIActionBase)object4).setCaption(pSWFLink.getLogicName());
            ((PSDEUIActionBase)object4).setPSDEUIActionName(pSWFLink.getLogicName());
            ((PSDEUIActionBase)object4).setCodeName(pSWFLink.getPSWFLinkName());
            if (!PSModelV2Helper.isCodeName(pSWFLink.getPSWFLinkName())) {
                ((PSDEUIActionBase)object4).setCodeName("A" + KeyValueHelper.genUniqueId((String)pSWFLink.getPSWFLinkName()).substring(0, 19));
            }
            ((PSDEUIActionBase)object4).setCapPSLanResId(pSWFLink.getLNPSLanResId());
            ((PSDEUIActionBase)object4).setCapPSLanResName(pSWFLink.getLNPSLanResName());
            ((PSDEUIActionBase)object4).setTipPSLanResId(pSWFLink.getTipPSLanResId());
            ((PSDEUIActionBase)object4).setTipPSLanResName(pSWFLink.getTipPSLanResName());
            ((PSDEUIActionBase)object4).setPSWFLinkName(pSWFLink.getPSWFLinkName());
            ((PSDEUIActionBase)object4).setActionTarget("MULTIKEY");
            ((PSDEUIActionBase)object4).setPSWFProcessId(pSWFLink.getFromPSWFProcId());
            ((PSDEUIActionBase)object4).setPSWFProcessName(pSWFLink.getFromPSWFProcName());
            if (StringHelper.isNullOrEmpty((String)pSWFLink.getPSDEViewBaseId())) {
                ((PSDEUIActionBase)object4).setUIActionType("WFBACKEND");
                ((PSDEUIActionBase)object4).setPSDEViewBaseId(null);
                ((PSDEUIActionBase)object4).setPSDEViewBaseName(null);
                ((PSDEUIActionBase)object4).setFrontProType(null);
            } else {
                ((PSDEUIActionBase)object4).setUIActionType("WFFRONT");
                ((PSDEUIActionBase)object4).setPSDEViewBaseId(pSWFLink.getPSDEViewBaseId());
                ((PSDEUIActionBase)object4).setPSDEViewBaseName(pSWFLink.getPSDEViewBaseName());
                ((PSDEUIActionBase)object4).setFrontProType("WIZARD");
            }
            try {
                if (n != 0) {
                    pSDEUIActionService.update(object4);
                } else {
                    ((PSDEUIActionBase)object4).setPSWFLinkId(pSWFLink.getPSWFLinkId());
                    ((PSDEUIActionBase)object4).setTemplMode(0);
                    ((PSDEUIActionBase)object4).setPSSystemId(pSWFVersion.getPSSystemId());
                    pSDEUIActionService.create(object4);
                }
            }
            catch (Exception exception) {
                throw new Exception(String.format("\u5efa\u7acb\u6d41\u7a0b\u8fde\u63a5[%1$s]\u754c\u9762\u884c\u4e3a\u53d1\u751f\u5f02\u5e38\uff0c%2$s", pSWFLink.getPSWFLinkName(), exception.getMessage()), exception);
            }
            hashMap2.remove(string6);
            String string7 = (String)hashMap3.get(pSWFLink.getFromPSWFProcId());
            object3 = new PSDEUAGroupDetail();
            ((PSDEUAGroupDetailBase)object3).setDetailType("DEUIACTION");
            ((PSDEUAGroupDetailBase)object3).setPSDEUAGroupId(string7);
            ((PSDEUAGroupDetailBase)object3).setPSDEUIActionId(string6);
            ((PSDEUAGroupDetailBase)object3).setOrderValue(pSWFLink.getOrderValue());
            pSDEUAGroupDetailService.save((IEntity)object3);
            if (!bl) continue;
            object4 = new PSDEUIAction();
            string6 = KeyValueHelper.genUniqueId((String)"MOB", (String)pSWFLink.getPSWFLinkId());
            ((PSDEUIActionBase)object4).setPSDEUIActionId(string6);
            n = 0;
            if (hashMap2.containsKey(string6)) {
                n = 1;
            }
            ((PSDEUIActionBase)object4).setPSWFId(pSWFVersion.getPSWFId());
            ((PSDEUIActionBase)object4).setPSWFVersionId(pSWFVersion2.getPSWFVersionId());
            ((PSDEUIActionBase)object4).setCaption(pSWFLink.getLogicName());
            ((PSDEUIActionBase)object4).setPSDEUIActionName(pSWFLink.getLogicName() + "[\u79fb\u52a8\u7aef]");
            ((PSDEUIActionBase)object4).setCodeName(pSWFLink.getPSWFLinkName());
            if (!PSModelV2Helper.isCodeName(pSWFLink.getPSWFLinkName())) {
                ((PSDEUIActionBase)object4).setCodeName("A" + KeyValueHelper.genUniqueId((String)pSWFLink.getPSWFLinkName()).substring(0, 19));
            }
            ((PSDEUIActionBase)object4).setCapPSLanResId(pSWFLink.getLNPSLanResId());
            ((PSDEUIActionBase)object4).setCapPSLanResName(pSWFLink.getLNPSLanResName());
            ((PSDEUIActionBase)object4).setTipPSLanResId(pSWFLink.getTipPSLanResId());
            ((PSDEUIActionBase)object4).setTipPSLanResName(pSWFLink.getTipPSLanResName());
            ((PSDEUIActionBase)object4).setPSWFLinkName(pSWFLink.getPSWFLinkName());
            ((PSDEUIActionBase)object4).setActionTarget("MULTIKEY");
            ((PSDEUIActionBase)object4).setPSWFProcessId(pSWFLink.getFromPSWFProcId());
            ((PSDEUIActionBase)object4).setPSWFProcessName(pSWFLink.getFromPSWFProcName());
            if (StringHelper.isNullOrEmpty((String)pSWFLink.getMobPSDEViewId())) {
                ((PSDEUIActionBase)object4).setUIActionType("WFBACKEND");
                ((PSDEUIActionBase)object4).setPSDEViewBaseId(null);
                ((PSDEUIActionBase)object4).setPSDEViewBaseName(null);
                ((PSDEUIActionBase)object4).setFrontProType(null);
            } else {
                ((PSDEUIActionBase)object4).setUIActionType("WFFRONT");
                ((PSDEUIActionBase)object4).setPSDEViewBaseId(pSWFLink.getMobPSDEViewId());
                ((PSDEUIActionBase)object4).setPSDEViewBaseName(pSWFLink.getMobPSDEViewName());
                ((PSDEUIActionBase)object4).setFrontProType("WIZARD");
            }
            if (n != 0) {
                pSDEUIActionService.update(object4);
            } else {
                ((PSDEUIActionBase)object4).setPSWFLinkId(pSWFLink.getPSWFLinkId());
                ((PSDEUIActionBase)object4).setTemplMode(0);
                ((PSDEUIActionBase)object4).setPSSystemId(pSWFVersion.getPSSystemId());
                pSDEUIActionService.create(object4);
            }
            hashMap2.remove(string6);
            String string8 = (String)hashMap3.get("MOB:" + pSWFLink.getFromPSWFProcId());
            object3 = new PSDEUAGroupDetail();
            ((PSDEUAGroupDetailBase)object3).setDetailType("DEUIACTION");
            ((PSDEUAGroupDetailBase)object3).setPSDEUAGroupId(string8);
            ((PSDEUAGroupDetailBase)object3).setPSDEUIActionId(string6);
            ((PSDEUAGroupDetailBase)object3).setOrderValue(pSWFLink.getOrderValue());
            pSDEUAGroupDetailService.save((IEntity)object3);
        }
        if (object6 != null) {
            object5 = new PSDEUIAction();
            String string9 = KeyValueHelper.genUniqueId((String)pSWFVersion.getPSSystemId(), (String)"EDITVIEW_SAVEANDSTARTWFACTION");
            ((PSDEUIActionBase)object5).setPSDEUIActionId(string9);
            if (!pSDEUIActionService.get((IEntity)object5, true)) {
                object5 = null;
            }
            object4 = KeyValueHelper.genUniqueId((String)pSWFVersion.getPSWFId(), (String)pSWFVersion2.getPSWFVersionId(), (String)"SAVEANDSTART");
            boolean bl4 = false;
            if (hashMap2.containsKey(object4)) {
                bl4 = true;
            } else {
                for (PSDEUIAction pSDEUIAction : arrayList2) {
                    if (StringHelper.compare((String)pSDEUIAction.getUATag(), (String)"SAVEANDSTART", (boolean)false) != 0) continue;
                    object4 = pSDEUIAction.getPSDEUIActionId();
                    bl4 = true;
                    break;
                }
            }
            Object object8 = new PSDEUIAction();
            ((PSDEUIActionBase)object8).setPSDEUIActionId((String)object4);
            ((PSDEUIActionBase)object8).setPSWFId(pSWFVersion.getPSWFId());
            ((PSDEUIActionBase)object8).setPSWFVersionId(pSWFVersion2.getPSWFVersionId());
            ((PSDEUIActionBase)object8).setUATag("SAVEANDSTART");
            String string10 = ((PSWFProcessBase)object6).getPSWFProcessName();
            ((PSDEUIActionBase)object8).setCaption(string10);
            ((PSDEUIActionBase)object8).setPSDEUIActionName(string10);
            ((PSDEUIActionBase)object8).setCodeName("SaveAndStart");
            ((PSDEUIActionBase)object8).setUIActionType("SYS");
            ((PSDEUIActionBase)object8).setPSSysUIActionId("EDITVIEW_SAVEANDSTARTWFACTION");
            ((PSDEUIActionBase)object8).setCapPSLanResId(((PSWFProcessBase)object6).getNamePSLanResId());
            ((PSDEUIActionBase)object8).setCapPSLanResName(((PSWFProcessBase)object6).getNamePSLanResName());
            if (object5 != null) {
                ((PSDEUIActionBase)object8).setPSDEOPPrivId(((PSDEUIActionBase)object5).getPSDEOPPrivId());
                ((PSDEUIActionBase)object8).setPSDEOPPrivName(((PSDEUIActionBase)object5).getPSDEOPPrivName());
            }
            ((PSDEUIActionBase)object8).setPSWFProcessId(((PSWFProcessBase)object6).getPSWFProcessId());
            ((PSDEUIActionBase)object8).setPSWFProcessName(((PSWFProcessBase)object6).getPSWFProcessName());
            if (bl4) {
                pSDEUIActionService.update(object8);
            } else {
                void var28_61;
                if (StringHelper.compare((String)string10, (String)"\u5f00\u59cb", (boolean)true) == 0) {
                    String string11 = "\u5f00\u59cb\u6d41\u7a0b";
                }
                ((PSDEUIActionBase)object8).setCaption((String)var28_61);
                ((PSDEUIActionBase)object8).setPSDEUIActionName((String)var28_61);
                if (pSWFVersion.getPSWF() != null) {
                    object3 = KeyValueHelper.genUniqueId((String)pSWFVersion.getPSWF().getPSSystemId(), (String)"IMAGE_010384");
                    object2 = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)this.getSessionFactory());
                    object = new PSSysImage();
                    ((PSSysImageBase)object).setPSSysImageId((String)object3);
                    if (object2.get((IEntity)object, true)) {
                        ((PSDEUIActionBase)object8).setPSSysImageId(((PSSysImageBase)object).getPSSysImageId());
                        ((PSDEUIActionBase)object8).setPSSysImageName(((PSSysImageBase)object).getPSSysImageName());
                    }
                }
                ((PSDEUIActionBase)object8).setTemplMode(0);
                ((PSDEUIActionBase)object8).setPSSystemId(pSWFVersion.getPSSystemId());
                pSDEUIActionService.create(object8);
            }
            hashMap2.remove(object4);
            object3 = (String)hashMap3.get(((PSWFProcessBase)object6).getPSWFProcessId());
            object2 = new PSDEUAGroupDetail();
            ((PSDEUAGroupDetailBase)object2).setDetailType("DEUIACTION");
            ((PSDEUAGroupDetailBase)object2).setPSDEUAGroupId((String)object3);
            ((PSDEUAGroupDetailBase)object2).setPSDEUIActionId((String)object4);
            ((PSDEUAGroupDetailBase)object2).setOrderValue(100);
            pSDEUAGroupDetailService.save((IEntity)object2);
            if (bl) {
                object3 = (String)hashMap3.get("MOB:" + ((PSWFProcessBase)object6).getPSWFProcessId());
                object2 = new PSDEUAGroupDetail();
                ((PSDEUAGroupDetailBase)object2).setDetailType("DEUIACTION");
                ((PSDEUAGroupDetailBase)object2).setPSDEUAGroupId((String)object3);
                ((PSDEUAGroupDetailBase)object2).setPSDEUIActionId((String)object4);
                ((PSDEUAGroupDetailBase)object2).setOrderValue(100);
                pSDEUAGroupDetailService.save((IEntity)object2);
            }
            if (!StringHelper.isNullOrEmpty((String)((PSWFProcessBase)object6).getPSDEViewBaseId())) {
                object4 = KeyValueHelper.genUniqueId((String)pSWFVersion.getPSWFId(), (String)pSWFVersion2.getPSWFVersionId(), (String)"WFSTARTWIZARD");
                bl4 = false;
                if (hashMap2.containsKey(object4)) {
                    bl4 = true;
                } else {
                    for (PSDEUIAction pSDEUIAction : arrayList2) {
                        if (StringHelper.compare((String)pSDEUIAction.getUATag(), (String)"WFSTARTWIZARD", (boolean)false) != 0) continue;
                        object4 = pSDEUIAction.getPSDEUIActionId();
                        bl4 = true;
                        break;
                    }
                }
                object8 = new PSDEUIAction();
                ((PSDEUIActionBase)object8).setPSDEUIActionId((String)object4);
                ((PSDEUIActionBase)object8).setPSWFId(pSWFVersion.getPSWFId());
                ((PSDEUIActionBase)object8).setPSWFVersionId(pSWFVersion2.getPSWFVersionId());
                ((PSDEUIActionBase)object8).setUATag("WFSTARTWIZARD");
                String string12 = ((PSWFProcessBase)object6).getPSWFProcessName();
                ((PSDEUIActionBase)object8).setCaption(string12);
                ((PSDEUIActionBase)object8).setPSDEUIActionName(string12);
                ((PSDEUIActionBase)object8).setCodeName("WFStartWizard");
                ((PSDEUIActionBase)object8).setActionTarget("SINGLEKEY");
                ((PSDEUIActionBase)object8).setUIActionType("WFFRONT");
                ((PSDEUIActionBase)object8).setPSDEViewBaseId(((PSWFProcessBase)object6).getPSDEViewBaseId());
                ((PSDEUIActionBase)object8).setPSDEViewBaseName(((PSWFProcessBase)object6).getPSDEViewBaseName());
                ((PSDEUIActionBase)object8).setFrontProType("WIZARD");
                ((PSDEUIActionBase)object8).setCapPSLanResId(((PSWFProcessBase)object6).getNamePSLanResId());
                ((PSDEUIActionBase)object8).setCapPSLanResName(((PSWFProcessBase)object6).getNamePSLanResName());
                ((PSDEUIActionBase)object8).setPSWFProcessId(((PSWFProcessBase)object6).getPSWFProcessId());
                ((PSDEUIActionBase)object8).setPSWFProcessName(((PSWFProcessBase)object6).getPSWFProcessName());
                if (object5 != null) {
                    ((PSDEUIActionBase)object8).setPSDEOPPrivId(((PSDEUIActionBase)object5).getPSDEOPPrivId());
                    ((PSDEUIActionBase)object8).setPSDEOPPrivName(((PSDEUIActionBase)object5).getPSDEOPPrivName());
                }
                if (bl4) {
                    pSDEUIActionService.update(object8);
                } else {
                    void var28_66;
                    if (StringHelper.compare((String)string12, (String)"\u5f00\u59cb", (boolean)true) == 0) {
                        String string13 = "\u5f00\u59cb\u6d41\u7a0b";
                    }
                    ((PSDEUIActionBase)object8).setCaption((String)var28_66);
                    ((PSDEUIActionBase)object8).setPSDEUIActionName((String)var28_66);
                    ((PSDEUIActionBase)object8).setTemplMode(0);
                    ((PSDEUIActionBase)object8).setPSSystemId(pSWFVersion.getPSSystemId());
                    pSDEUIActionService.create(object8);
                }
                hashMap2.remove(object4);
            }
            if (bl && !StringHelper.isNullOrEmpty((String)((PSWFProcessBase)object6).getMobPSDEViewId())) {
                object4 = KeyValueHelper.genUniqueId((String)pSWFVersion.getPSWFId(), (String)pSWFVersion2.getPSWFVersionId(), (String)"MOBWFSTARTWIZARD");
                bl4 = false;
                if (hashMap2.containsKey(object4)) {
                    bl4 = true;
                } else {
                    for (PSDEUIAction pSDEUIAction : arrayList2) {
                        if (StringHelper.compare((String)pSDEUIAction.getUATag(), (String)"MOBWFSTARTWIZARD", (boolean)false) != 0) continue;
                        object4 = pSDEUIAction.getPSDEUIActionId();
                        bl4 = true;
                        break;
                    }
                }
                object8 = new PSDEUIAction();
                ((PSDEUIActionBase)object8).setPSDEUIActionId((String)object4);
                ((PSDEUIActionBase)object8).setPSWFId(pSWFVersion.getPSWFId());
                ((PSDEUIActionBase)object8).setPSWFVersionId(pSWFVersion2.getPSWFVersionId());
                ((PSDEUIActionBase)object8).setUATag("MOBWFSTARTWIZARD");
                String string14 = ((PSWFProcessBase)object6).getPSWFProcessName();
                ((PSDEUIActionBase)object8).setCaption(string14);
                ((PSDEUIActionBase)object8).setPSDEUIActionName(string14 + "[\u79fb\u52a8\u7aef]");
                ((PSDEUIActionBase)object8).setCodeName("WFStartWizard");
                ((PSDEUIActionBase)object8).setActionTarget("SINGLEKEY");
                ((PSDEUIActionBase)object8).setUIActionType("WFFRONT");
                ((PSDEUIActionBase)object8).setPSDEViewBaseId(((PSWFProcessBase)object6).getMobPSDEViewId());
                ((PSDEUIActionBase)object8).setPSDEViewBaseName(((PSWFProcessBase)object6).getMobPSDEViewName());
                ((PSDEUIActionBase)object8).setFrontProType("WIZARD");
                ((PSDEUIActionBase)object8).setCapPSLanResId(((PSWFProcessBase)object6).getNamePSLanResId());
                ((PSDEUIActionBase)object8).setCapPSLanResName(((PSWFProcessBase)object6).getNamePSLanResName());
                ((PSDEUIActionBase)object8).setPSWFProcessId(((PSWFProcessBase)object6).getPSWFProcessId());
                ((PSDEUIActionBase)object8).setPSWFProcessName(((PSWFProcessBase)object6).getPSWFProcessName());
                if (object5 != null) {
                    ((PSDEUIActionBase)object8).setPSDEOPPrivId(((PSDEUIActionBase)object5).getPSDEOPPrivId());
                    ((PSDEUIActionBase)object8).setPSDEOPPrivName(((PSDEUIActionBase)object5).getPSDEOPPrivName());
                }
                if (bl4) {
                    pSDEUIActionService.update(object8);
                } else {
                    void var28_72;
                    if (StringHelper.compare((String)string14, (String)"\u5f00\u59cb", (boolean)true) == 0) {
                        String string15 = "\u5f00\u59cb\u6d41\u7a0b";
                    }
                    ((PSDEUIActionBase)object8).setCaption((String)var28_72);
                    ((PSDEUIActionBase)object8).setPSDEUIActionName((String)var28_72);
                    ((PSDEUIActionBase)object8).setTemplMode(0);
                    ((PSDEUIActionBase)object8).setPSSystemId(pSWFVersion.getPSSystemId());
                    pSDEUIActionService.create(object8);
                }
                hashMap2.remove(object4);
            }
        }
        for (PSDEUAGroup pSDEUAGroup : hashMap.values()) {
            pSDEUAGroupService.remove((IEntity)pSDEUAGroup);
        }
        for (PSDEUIAction pSDEUIAction : hashMap2.values()) {
            object4 = pSDEUAGroupDetailService.selectByPSDEUAAction(pSDEUIAction);
            Iterator<PSDEUAGroupDetail> iterator = ((ArrayList)object4).iterator();
            while (iterator.hasNext()) {
                PSDEUAGroupDetail pSDEUAGroupDetail = iterator.next();
                pSDEUAGroupDetailService.remove((IEntity)pSDEUAGroupDetail);
            }
            pSDEUIActionService.remove((IEntity)pSDEUIAction);
        }
    }

    public PSWFVersion getLastPSWFVersion(PSWorkflow pSWorkflow) throws Exception {
        final PSWorkflow pSWorkflow2 = pSWorkflow;
        final CallResult callResult = new CallResult();
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                String string = "SELECT *  FROM V_PSWFVERSION WHERE PSWFID=? AND ENABLE = 1 ORDER BY WFVERSION DESC";
                SqlParamList sqlParamList = new SqlParamList();
                sqlParamList.addString(pSWorkflow2.getPSWorkflowId());
                IEntity iEntity = PSWFVersionService.this.getDAO().executeRawSelectOneSql(null, string, sqlParamList);
                if (iEntity != null) {
                    PSWFVersion pSWFVersion = new PSWFVersion();
                    iEntity.copyTo((IDataObject)pSWFVersion, false);
                    callResult.setUserObject((Object)pSWFVersion);
                }
            }
        });
        if (callResult.getUserObject() == null) {
            return null;
        }
        return (PSWFVersion)callResult.getUserObject();
    }

    @Override
    protected void onCalcWFEngineType(PSWFVersion pSWFVersion) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)pSWFVersion.getPSWFId())) {
            pSWFVersion.setWFEngineType(pSWFVersion.getPSWF().getWFEngineType());
        }
    }

    protected String getBPMNModel(String string) throws Exception {
        BpmnJsonConverter bpmnJsonConverter;
        JsonNode jsonNode = new ObjectMapper().readTree(string);
        ObjectNode objectNode = (ObjectNode)jsonNode;
        if (objectNode.has("resourceId")) {
            objectNode.remove("resourceId");
        }
        objectNode.put("resourceId", "__WFVERSIONID__");
        if (objectNode.has("properties")) {
            bpmnJsonConverter = (ObjectNode)objectNode.get("properties");
            if (bpmnJsonConverter.has("process_id")) {
                bpmnJsonConverter.remove("process_id");
            }
            bpmnJsonConverter.put("process_id", "__WFVERSIONID__");
        }
        bpmnJsonConverter = new BpmnJsonConverter();
        BpmnModel bpmnModel = bpmnJsonConverter.convertToBpmnModel(jsonNode);
        return new String(new BpmnXMLConverter().convertToXML(bpmnModel), "UTF-8");
    }

    protected String processBPMNModel(String string) throws Exception {
        try {
            StringReader stringReader = new StringReader(string);
            InputSource inputSource = new InputSource(stringReader);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputSource);
            this.changeXmlTagName(document, "serviceTask", "userTask");
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty("encoding", "UTF-8");
            StringWriter stringWriter = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(stringWriter));
            return stringWriter.toString();
        }
        catch (Exception exception) {
            String string2 = StringHelper.format((String)"Activiti\u6d41\u7a0b\u914d\u7f6e\u6a21\u578b\u5904\u7406\u5f02\u5e38\uff0c\u9519\u8bef\u4fe1\u606f\uff1a%1$s", (Object)exception.getMessage());
            log.error((Object)string2);
            throw new Exception(string2);
        }
    }

    protected void changeXmlTagName(Document document, String string, String string2) throws Exception {
        NodeList nodeList = document.getElementsByTagName(string);
        for (int i = 0; i < nodeList.getLength(); ++i) {
            Element element;
            if (!(nodeList.item(i) instanceof Element) || StringHelper.compare((String)(element = (Element)nodeList.item(i)).getAttribute("activiti:class"), (String)"DEACTION", (boolean)true) != 0) continue;
            document.renameNode(element, element.getNamespaceURI(), string2);
            element.removeAttribute("activiti:class");
        }
    }

    @Override
    protected void onAfterCreate(PSWFVersion pSWFVersion) throws Exception {
        this.initPSDynaWFVer(pSWFVersion);
        super.onAfterCreate(pSWFVersion);
    }

    @Override
    protected void onAfterUpdate(PSWFVersion pSWFVersion) throws Exception {
        this.initPSDynaWFVer(pSWFVersion);
        super.onAfterUpdate(pSWFVersion);
    }

    @Override
    protected void onFillEntityFullInfo_PSDynaWFVer(PSWFVersion pSWFVersion, boolean bl) throws Exception {
        super.onFillEntityFullInfo_PSDynaWFVer(pSWFVersion, bl);
        if (!StringHelper.isNullOrEmpty((String)pSWFVersion.getPSDynaWFVerId())) {
            if (StringHelper.isNullOrEmpty((String)pSWFVersion.getPSWFId())) {
                PSWFVersion pSWFVersion2 = new PSWFVersion();
                pSWFVersion2.setPSWFVersionId(pSWFVersion.getPSDynaWFVerId());
                this.get((IEntity)pSWFVersion2);
                pSWFVersion.setPSWFId(pSWFVersion2.getPSWFId());
                pSWFVersion.setPSWFName(pSWFVersion2.getPSWFName());
                pSWFVersion.setWFEngineType(pSWFVersion2.getWFEngineType());
            }
            pSWFVersion.setDynaSysRefMode(DynaSysRefModeCodeListModel.DYNASYSINST);
        }
    }

    @Override
    protected void onFillParentInfo_PSDynaWFVer(PSWFVersion pSWFVersion, PSDynaWFVer pSDynaWFVer) throws Exception {
        super.onFillParentInfo_PSDynaWFVer(pSWFVersion, pSDynaWFVer);
        if (!StringHelper.isNullOrEmpty((String)pSWFVersion.getPSDynaWFVerId()) && StringHelper.isNullOrEmpty((String)pSWFVersion.getPSWFId())) {
            PSWFVersion pSWFVersion2 = new PSWFVersion();
            pSWFVersion2.setPSWFVersionId(pSWFVersion.getPSDynaWFVerId());
            this.get((IEntity)pSWFVersion2);
            pSWFVersion.setPSWFId(pSWFVersion2.getPSWFId());
            pSWFVersion.setPSWFName(pSWFVersion2.getPSWFName());
            pSWFVersion.setWFEngineType(pSWFVersion2.getWFEngineType());
        }
    }

    protected void initPSDynaWFVer(PSWFVersion pSWFVersion) throws Exception {
        if (PSWFVersionService.isImpSysModelNowEx()) {
            return;
        }
        if (!pSWFVersion.isEnableDynaSysDirty()) {
            return;
        }
        if (!DataObject.getBoolValue((Integer)pSWFVersion.getEnableDynaSys(), (boolean)false)) {
            return;
        }
        if (pSWFVersion.getPSWF() == null) {
            return;
        }
        if (!DataObject.getBoolValue((Integer)pSWFVersion.getPSWF().getEnableDynaSys(), (boolean)false)) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u5de5\u4f5c\u6d41\u6ca1\u6709\u542f\u7528\u52a8\u6001\u7cfb\u7edf\u529f\u80fd\uff0c\u4e0d\u80fd\u542f\u7528\u5de5\u4f5c\u6d41\u7248\u672c\u7684\u52a8\u6001\u529f\u80fd"));
        }
        PSDynaWFVerService pSDynaWFVerService = (PSDynaWFVerService)ServiceGlobal.getService(PSDynaWFVerService.class, (SessionFactory)this.getSessionFactory());
        PSDynaWFVer pSDynaWFVer = new PSDynaWFVer();
        pSDynaWFVer.setPSDynaWFVerId(pSWFVersion.getPSWFVersionId());
        if (pSWFVersion.isPSWFVersionNameDirty()) {
            pSDynaWFVer.setPSDynaWFVerName(pSWFVersion.getPSWFVersionName());
        }
        if (pSWFVersion.getPSWF().getPSSystem() != null) {
            pSDynaWFVer.setPSDynaSysId(pSWFVersion.getPSWF().getPSSystem().getPSSystemId());
            pSDynaWFVer.setPSDynaSysName(pSWFVersion.getPSWF().getPSSystem().getPSSystemName());
        }
        pSDynaWFVer.setPSDynaWFId(pSWFVersion.getPSWF().getPSWorkflowId());
        pSDynaWFVer.setPSDynaWFName(pSWFVersion.getPSWF().getPSWorkflowName());
        pSDynaWFVerService.save((IEntity)pSDynaWFVer);
    }

    @Override
    public String getModelV2Tag(PSWFVersion pSWFVersion) {
        if (pSWFVersion.getWFVersion() != null) {
            return pSWFVersion.getWFVersion().toString();
        }
        return super.getModelV2Tag(pSWFVersion);
    }
}

