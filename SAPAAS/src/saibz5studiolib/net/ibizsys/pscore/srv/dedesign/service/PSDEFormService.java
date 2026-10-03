/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.entity.EntityBase
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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.PSCoreSysServiceBaseBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFDLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIUDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItemBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetailBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFDLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIUDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.service.IPSModelService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDEInitCfg;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEFormService
extends PSDEFormServiceBase
implements IPSModelService<PSDEForm> {
    private static final Log log = LogFactory.getLog(PSDEFormService.class);
    public static final String RESERVERTAG_EDITFORM = "R1";
    public static final String RESERVERTAG_SEARCHFORM = "R2";
    public static final String RESERVERTAG_MOBEDITFORM = "R3";
    public static final String RESERVERTAG_MOBSEARCHFORM = "R4";

    @Override
    public void getWithModel(PSDEForm pSDEForm) throws Exception {
        if (!KeyValueHelper.isTempKey((String)pSDEForm.getPSDEFormId())) {
            this.getTempMajor(pSDEForm);
        } else {
            this.getTemp(pSDEForm);
        }
        pSDEForm.setFormModel(this.getFormModel(pSDEForm));
    }

    protected String getFormModel(PSDEForm pSDEForm) throws Exception {
        final PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService((String)PSDEFormDetailService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        final ArrayList<PSDEFormDetail> arrayList = pSDEFormDetailService.selectTempByPSDEForm(pSDEForm, "ORDER BY ORDERVALUE");
        final HashMap<String, XmlNode> hashMap = new HashMap<String, XmlNode>();
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                for (PSDEFormDetail pSDEFormDetail : arrayList) {
                    pSDEFormDetailService.fillPreviewHtml(pSDEFormDetail, false);
                    XmlNode xmlNode = new XmlNode();
                    xmlNode.setNodeName(pSDEFormDetail.getDetailType());
                    pSDEFormDetailService.fillXmlNode(pSDEFormDetail, xmlNode, false);
                    hashMap.put(pSDEFormDetail.getPSDEFormDetailId(), xmlNode);
                }
            }
        }, false);
        XmlNode xmlNode2 = new XmlNode();
        xmlNode2.setNodeName("DEFORM");
        PSSystem pSSystem = pSDEForm.getPSDE().getPSSystem();
        xmlNode2.setAttribute("PSSYSTEMID", pSSystem.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)pSSystem.getPSDevSlnSysId())) {
            xmlNode2.setAttribute("PSDEVSLNSYSID", pSSystem.getPSDevSlnSysId());
            xmlNode2.setAttribute("TASKSERVERURL", pSSystem.getPSDevCenterTS().getPSTaskServer().getServerUrl());
        } else {
            xmlNode2.setAttribute("PSDEVSLNSYSID", "");
            xmlNode2.setAttribute("TASKSERVERURL", "http://lionlau-w530:8000/SAEAM/");
        }
        xmlNode2.setAttribute("PSDEID", pSDEForm.getPSDEId());
        xmlNode2.setAttribute("PSDEFORMID", pSDEForm.getPSDEFormId());
        xmlNode2.setAttribute("FORMTYPE", pSDEForm.getFormType());
        xmlNode2.setAttribute("TABHEADERPOS", pSDEForm.getTabHeaderPos());
        xmlNode2.setAttribute("FORMWIDTH", StringHelper.format((String)"%1$s", (Object)pSDEForm.getFormWidth()));
        if (StringHelper.compare((String)pSDEForm.getFormType(), (String)"EDITFORM", (boolean)true) == 0) {
            PSDEFieldService fieldService = (PSDEFieldService)ServiceGlobal.getService((String)PSDEFieldService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            ArrayList<PSDEField> fields = fieldService.selectByDataEntity(pSDEForm.getPSDEId());
            XmlNode fieldNodes = new XmlNode();
            fieldNodes.setNodeName("DEFIELDS");
            xmlNode2.addNode(fieldNodes);
            for (PSDEField field : fields) {
                XmlNode fieldNode = new XmlNode();
                fieldNode.setNodeName("DEFIELD");
                fieldNode.setAttribute("PSDEFID", field.getPSDEFieldId());
                fieldNode.setAttribute("PSDEFNAME", field.getPSDEFieldName().toLowerCase());
                fieldNode.setAttribute("LOGICNAME", field.getLogicName());
                fieldNodes.addNode(fieldNode);
            }
        } else if (StringHelper.compare((String)pSDEForm.getFormType(), (String)"SEARCHFORM", (boolean)true) == 0) {
            PSDEFSFItemService itemService = (PSDEFSFItemService)ServiceGlobal.getService((String)PSDEFSFItemService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            SelectCond selectCond = new SelectCond();
            selectCond.setOrderInfo("ORDER BY PSDEFNAME");
            selectCond.setConditon("PSDEID", (Object)pSDEForm.getPSDEId());
            ArrayList<PSDEFSFItem> items = itemService.select((ISelectCond)selectCond);
            XmlNode xmlNode = new XmlNode();
            xmlNode.setNodeName("DEFSFITEMS");
            xmlNode2.addNode(xmlNode);
            for (PSDEFSFItem item : items) {
                XmlNode xmlNode3 = new XmlNode();
                xmlNode3.setNodeName("DEFSFITEM");
                xmlNode3.setAttribute("PSDEFID", item.getPSDEFId());
                xmlNode3.setAttribute("PSDEFNAME", item.getPSDEFName().toLowerCase());
                xmlNode3.setAttribute("PSDEFSFITEMNAME", item.getPSDEFSFItemName());
                xmlNode3.setAttribute("PSDEFSFITEMID", item.getPSDEFSFItemId());
                String string = item.getCaption();
                if (StringHelper.isNullOrEmpty((String)string)) {
                    string = StringHelper.isNullOrEmpty((String)item.getPSSysDBVFName()) ? StringHelper.format((String)"%1$s(%2$s)", (Object)item.getLogicName(), (Object)item.getPSDBValueOPName()) : StringHelper.format((String)"%1$s[%3$s](%2$s)", (Object)item.getLogicName(), (Object)item.getPSDBValueOPName(), (Object)item.getPSSysDBVFName());
                }
                xmlNode3.setAttribute("CAPTION", string);
                xmlNode.addNode(xmlNode3);
            }
        }
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            XmlNode detailNode = hashMap.get(pSDEFormDetail.getPSDEFormDetailId());
            if (StringHelper.isNullOrEmpty((String)pSDEFormDetail.getPPSDEFormDetailId())) {
                xmlNode2.addNode(detailNode);
                continue;
            }
            XmlNode parentNode = hashMap.get(pSDEFormDetail.getPPSDEFormDetailId());
            if (parentNode != null) {
                parentNode.addNode(detailNode);
                continue;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7236\u8868\u5355\u6210\u5458[%1$s], \u5f53\u524d[%2$s]", (Object)pSDEFormDetail.getPPSDEFormDetailId(), (Object)pSDEFormDetail.getPSDEFormDetailName()));
        }
        return XmlNode.export((XmlNode)xmlNode2);
    }

    @Override
    public void updateWithModel(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService((String)PSDEFormDetailService.class.getCanonicalName(), (SessionFactory)PSDEFormService.this.getSessionFactory());
                ArrayList<PSDEFormDetail> arrayList = pSDEFormDetailService.selectTempByPSDEForm(pSDEForm2);
                HashMap<String, PSDEFormDetail> hashMap = new HashMap<String, PSDEFormDetail>();
                for (PSDEFormDetail pSDEFormDetail2 : arrayList) {
                    hashMap.put(pSDEFormDetail2.getPSDEFormDetailId(), pSDEFormDetail2);
                }
                String string = pSDEForm2.getFormModel();
                XmlNode formNode = XmlNode.loadFromXML((String)string);
                if (formNode != null) {
                    formNode.setAttribute("PSDEID", pSDEForm2.getPSDEId());
                    formNode.setAttribute("PSDEFORMID", pSDEForm2.getPSDEFormId());
                    formNode.setAttribute("FORMTYPE", pSDEForm2.getFormType());
                    PSDEFormService.this.updatePSDEFormDetails(pSDEForm2, null, formNode, hashMap);
                    pSDEForm2.setFormModel(XmlNode.export(formNode));
                } else {
                    pSDEForm2.setFormModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSDEFormDetail pSDEFormDetail3 : hashMap.values()) {
                        pSDEFormDetailService.removeTemp(pSDEFormDetail3);
                    }
                }
                PSDEFormService.this.updateTempMajor(pSDEForm2);
            }
        });
    }

    protected void updatePSDEFormDetails(PSDEForm pSDEForm, PSDEFormDetail pSDEFormDetail, XmlNode xmlNode, HashMap<String, PSDEFormDetail> hashMap) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<XmlNode> arrayList = new ArrayList<XmlNode>();
            PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService((String)PSDEFormDetailService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            int n = 0;
            while (iterator.hasNext()) {
                PSDEFormDetail pSDEFormDetail2;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                String string = xmlNode2.getAttribute("PSDEFORMDETAILID", "");
                if (StringHelper.isNullOrEmpty((String)string) || (pSDEFormDetail2 = hashMap.remove(string)) == null) continue;
                ++n;
                boolean bl = false;
                if (StringHelper.compare((String)pSDEFormDetail2.getPSDEFormId(), (String)pSDEForm.getPSDEFormId(), (boolean)false) != 0) {
                    pSDEFormDetail2.setPSDEFormId(pSDEForm.getPSDEFormId());
                    bl = true;
                }
                if (StringHelper.compare((String)pSDEFormDetail2.getPSDEFormName(), (String)pSDEForm.getPSDEFormName(), (boolean)false) != 0) {
                    pSDEFormDetail2.setPSDEFormName(pSDEForm.getPSDEFormName());
                    bl = true;
                }
                if (pSDEFormDetail != null) {
                    if (StringHelper.compare((String)pSDEFormDetail2.getPPSDEFormDetailId(), (String)pSDEFormDetail.getPSDEFormDetailId(), (boolean)false) != 0) {
                        pSDEFormDetail2.setPPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)pSDEFormDetail2.getPPSDEFormDetailName(), (String)pSDEFormDetail.getPSDEFormDetailName(), (boolean)false) != 0) {
                        pSDEFormDetail2.setPPSDEFormDetailName(pSDEFormDetail.getPSDEFormDetailName());
                        bl = true;
                    }
                }
                if (pSDEFormDetail2.getOrderValue() == null || pSDEFormDetail2.getOrderValue() != n) {
                    pSDEFormDetail2.setOrderValue(n);
                    bl = true;
                }
                if (bl) {
                    pSDEFormDetailService.updateTemp(pSDEFormDetail2);
                }
                if (StringHelper.compare((String)pSDEFormDetail2.getDetailType(), (String)"FORMITEMEX", (boolean)true) == 0) {
                    ArrayList<String> arrayList2 = new ArrayList<String>();
                    for (String string2 : hashMap.keySet()) {
                        PSDEFormDetail pSDEFormDetail3 = hashMap.get(string2);
                        if (StringHelper.compare((String)pSDEFormDetail3.getPPSDEFormDetailId(), (String)pSDEFormDetail2.getPSDEFormDetailId(), (boolean)true) != 0) continue;
                        arrayList2.add(string2);
                    }
                    for (String string2 : arrayList2) {
                        hashMap.remove(string2);
                    }
                }
                xmlNode2.resetAttributes();
                pSDEFormDetailService.fillPreviewHtml(pSDEFormDetail2, false);
                pSDEFormDetailService.fillXmlNode(pSDEFormDetail2, xmlNode2, false);
                arrayList.add(xmlNode2);
                this.updatePSDEFormDetails(pSDEForm, pSDEFormDetail2, xmlNode2, hashMap);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
        }
    }

    @Override
    public void createWithModel(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        log.debug((Object)"\u5f00\u59cb[createWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService((String)PSDEFormDetailService.class.getCanonicalName(), (SessionFactory)PSDEFormService.this.getSessionFactory());
                ArrayList<PSDEFormDetail> arrayList = pSDEFormDetailService.selectTempByPSDEForm(pSDEForm2);
                HashMap<String, PSDEFormDetail> hashMap = new HashMap<String, PSDEFormDetail>();
                for (PSDEFormDetail pSDEFormDetail2 : arrayList) {
                    hashMap.put(pSDEFormDetail2.getPSDEFormDetailId(), pSDEFormDetail2);
                }
                String string = pSDEForm2.getFormModel();
                XmlNode formNode = XmlNode.loadFromXML((String)string);
                if (formNode != null) {
                    formNode.setAttribute("PSDEID", pSDEForm2.getPSDEId());
                    formNode.setAttribute("PSDEFORMID", pSDEForm2.getPSDEFormId());
                    formNode.setAttribute("FORMTYPE", pSDEForm2.getFormType());
                    PSDEFormService.this.updatePSDEFormDetails(pSDEForm2, null, formNode, hashMap);
                    pSDEForm2.setFormModel(XmlNode.export(formNode));
                } else {
                    pSDEForm2.setFormModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSDEFormDetail pSDEFormDetail3 : hashMap.values()) {
                        pSDEFormDetailService.removeTemp(pSDEFormDetail3);
                    }
                }
                PSDEFormService.this.createTempMajor(pSDEForm2);
            }
        });
    }

    @Override
    public void previewSave(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        log.debug((Object)"\u5f00\u59cb[previewSave]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService((String)PSDEFormDetailService.class.getCanonicalName(), (SessionFactory)PSDEFormService.this.getSessionFactory());
                ArrayList<PSDEFormDetail> arrayList = pSDEFormDetailService.selectTempByPSDEForm(pSDEForm2);
                HashMap<String, PSDEFormDetail> hashMap = new HashMap<String, PSDEFormDetail>();
                for (PSDEFormDetail pSDEFormDetail2 : arrayList) {
                    hashMap.put(pSDEFormDetail2.getPSDEFormDetailId(), pSDEFormDetail2);
                }
                Object object = pSDEForm2.getFormModel();
                if (StringHelper.isNullOrEmpty((String)object)) {
                    object = WebContext.getCurrent().getPostValue("formmodel");
                }
                XmlNode formNode = XmlNode.loadFromXML((String)object);
                if (formNode != null) {
                    PSDEFormService.this.updatePSDEFormDetails(pSDEForm2, null, formNode, hashMap);
                    pSDEForm2.setFormModel(XmlNode.export(formNode));
                } else {
                    pSDEForm2.setFormModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSDEFormDetail pSDEFormDetail3 : hashMap.values()) {
                        pSDEFormDetailService.removeTemp(pSDEFormDetail3);
                    }
                }
            }
        });
    }

    @Override
    public void getDraftWithModel(PSDEForm pSDEForm) throws Exception {
        this.getDraftTempMajor(pSDEForm);
        this.initDefaultFormDetail(pSDEForm.getPSDE(), pSDEForm, true);
        pSDEForm.setFormModel(this.getFormModel(pSDEForm));
    }

    @Override
    public void getDraftFromWithModel(PSDEForm pSDEForm) throws Exception {
        this.getDraftTempMajorFrom(pSDEForm);
        pSDEForm.setFormModel(this.getFormModel(pSDEForm));
    }

    @Override
    protected void onBeforeCreate(PSDEForm pSDEForm) throws Exception {
        pSDEForm.setFormModel(null);
        super.onBeforeCreate(pSDEForm);
    }

    @Override
    protected void onBeforeUpdate(PSDEForm pSDEForm) throws Exception {
        pSDEForm.setFormModel(null);
        super.onBeforeUpdate(pSDEForm);
    }

    @Override
    public void initModel(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            PSDataEntity pSDataEntity = new PSDataEntity();
            pSDataEntity.proxy((IDataObject)iEntity);
            PSDEInitCfg pSDEInitCfg = PSModelGlobal.getPSDEInitCfg(pSDataEntity.getPSDataEntityId(), this.getSessionFactory());
            if (pSDEInitCfg != null && DataObject.getBoolValue((Integer)pSDEInitCfg.getIgnoreUIModel(), (boolean)false)) {
                return;
            }
            this.initDefaultEditForm(pSDataEntity);
            this.initDefaultSearchForm(pSDataEntity);
            if (DataObject.getBoolValue((Integer)pSDataEntity.getEnableMob(), (boolean)false)) {
                this.initDefaultMobEditForm(pSDataEntity);
                this.initDefaultMobSearchForm(pSDataEntity);
            }
            return;
        }
    }

    protected void initDefaultEditForm(PSDataEntity pSDataEntity) throws Exception {
        String string = null;
        string = this.isEnableFolderKey(pSDataEntity) ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_EDITFORM) : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"EDITFORM");
        PSDEForm pSDEForm = new PSDEForm();
        pSDEForm.setPSDEFormId(string);
        if (this.checkKey(pSDEForm) == 0) {
            PSDEFormDetail pSDEFormDetail;
            PSDEField field;
            pSDEForm.reset();
            pSDEForm.setFormType("EDITFORM");
            pSDEForm.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEForm.setCodeName("Main");
            if (this.selectOne(pSDEForm, true)) {
                return;
            }
            pSDEForm.reset();
            pSDEForm.setPSDEFormId(string);
            pSDEForm.setFormType("EDITFORM");
            pSDEForm.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEForm.setCodeName("Main");
            pSDEForm.setPSDEFormName("\u4e3b\u7f16\u8f91\u8868\u5355");
            pSDEForm.setMobFlag(0);
            this.create(pSDEForm);
            PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSDEField> arrayList = pSDEFieldService.selectByPSDE(pSDataEntity);
            HashMap<String, PSDEField> hashMap = new HashMap<String, PSDEField>();
            PSDEField entityBase3 = null;
            for (PSDEField entityBase22 : arrayList) {
                hashMap.put(entityBase22.getPSDEFieldName(), entityBase22);
                if (!DataObject.getBoolValue((Integer)entityBase22.getMajorField(), (boolean)false)) continue;
                entityBase3 = entityBase22;
            }
            PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEFormDetail pSDEFormDetail2 = new PSDEFormDetail();
            pSDEFormDetail2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEFormDetail2.setPSDEFormDetailName("formpage1");
            pSDEFormDetail2.setDetailType("FORMPAGE");
            pSDEFormDetail2.setOrderValue(1);
            pSDEFormDetail2.setCaption("\u57fa\u672c\u4fe1\u606f");
            pSDEFormDetailService.create(pSDEFormDetail2);
            PSDEFormDetail pSDEFormDetail3 = new PSDEFormDetail();
            pSDEFormDetail3.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEFormDetail3.setPSDEFormDetailName("group1");
            pSDEFormDetail3.setPPSDEFormDetailId(pSDEFormDetail2.getPSDEFormDetailId());
            pSDEFormDetail3.setDetailType("GROUPPANEL");
            pSDEFormDetail3.setOrderValue(1);
            pSDEFormDetail3.setCaption(StringHelper.format((String)"%1$s\u57fa\u672c\u4fe1\u606f", (Object)pSDataEntity.getLogicName()));
            pSDEFormDetail3.setColModel("50%;50%");
            pSDEFormDetailService.create(pSDEFormDetail3);
            if (entityBase3 != null) {
                PSDEFormDetail majorItem = new PSDEFormDetail();
                majorItem.setPSDEFormId(pSDEForm.getPSDEFormId());
                majorItem.setPSDEFormDetailName(entityBase3.getPSDEFieldName().toLowerCase());
                majorItem.setPPSDEFormDetailId(pSDEFormDetail3.getPSDEFormDetailId());
                majorItem.setDetailType("FORMITEM");
                majorItem.setOrderValue(1);
                majorItem.setPSDEFId(entityBase3.getPSDEFieldId());
                majorItem.setPSDEFName(entityBase3.getPSDEFieldName());
                pSDEFormDetailService.create(majorItem);
            }
            PSDEFormDetail pSDEFormDetail4 = new PSDEFormDetail();
            pSDEFormDetail4.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEFormDetail4.setPSDEFormDetailName("formpage2");
            pSDEFormDetail4.setDetailType("FORMPAGE");
            pSDEFormDetail4.setOrderValue(2);
            pSDEFormDetail4.setCaption("\u5176\u5b83");
            pSDEFormDetailService.create(pSDEFormDetail4);
            pSDEFormDetail3 = new PSDEFormDetail();
            pSDEFormDetail3.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEFormDetail3.setPSDEFormDetailName("group2");
            pSDEFormDetail3.setPPSDEFormDetailId(pSDEFormDetail4.getPSDEFormDetailId());
            pSDEFormDetail3.setDetailType("GROUPPANEL");
            pSDEFormDetail3.setOrderValue(2);
            pSDEFormDetail3.setCaption("\u64cd\u4f5c\u4fe1\u606f");
            pSDEFormDetail3.setColModel("50%;50%");
            pSDEFormDetailService.create(pSDEFormDetail3);
            field = hashMap.get("CREATEMAN");
            if (field != null) {
                pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
                pSDEFormDetail.setPSDEFormDetailName(field.getPSDEFieldName().toLowerCase());
                pSDEFormDetail.setPPSDEFormDetailId(pSDEFormDetail3.getPSDEFormDetailId());
                pSDEFormDetail.setDetailType("FORMITEM");
                pSDEFormDetail.setOrderValue(1);
                pSDEFormDetail.setPSDEFId(field.getPSDEFieldId());
                pSDEFormDetail.setPSDEFName(field.getPSDEFieldName());
                pSDEFormDetailService.create(pSDEFormDetail);
            }
            if ((field = hashMap.get("CREATEDATE")) != null) {
                pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
                pSDEFormDetail.setPSDEFormDetailName(field.getPSDEFieldName().toLowerCase());
                pSDEFormDetail.setPPSDEFormDetailId(pSDEFormDetail3.getPSDEFormDetailId());
                pSDEFormDetail.setDetailType("FORMITEM");
                pSDEFormDetail.setOrderValue(2);
                pSDEFormDetail.setPSDEFId(field.getPSDEFieldId());
                pSDEFormDetail.setPSDEFName(field.getPSDEFieldName());
                pSDEFormDetailService.create(pSDEFormDetail);
            }
            if ((field = hashMap.get("UPDATEMAN")) != null) {
                pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
                pSDEFormDetail.setPSDEFormDetailName(field.getPSDEFieldName().toLowerCase());
                pSDEFormDetail.setPPSDEFormDetailId(pSDEFormDetail3.getPSDEFormDetailId());
                pSDEFormDetail.setDetailType("FORMITEM");
                pSDEFormDetail.setOrderValue(3);
                pSDEFormDetail.setPSDEFId(field.getPSDEFieldId());
                pSDEFormDetail.setPSDEFName(field.getPSDEFieldName());
                pSDEFormDetailService.create(pSDEFormDetail);
            }
            if ((field = hashMap.get("UPDATEDATE")) != null) {
                pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
                pSDEFormDetail.setPSDEFormDetailName(field.getPSDEFieldName().toLowerCase());
                pSDEFormDetail.setPPSDEFormDetailId(pSDEFormDetail3.getPSDEFormDetailId());
                pSDEFormDetail.setDetailType("FORMITEM");
                pSDEFormDetail.setOrderValue(4);
                pSDEFormDetail.setPSDEFId(field.getPSDEFieldId());
                pSDEFormDetail.setPSDEFName(field.getPSDEFieldName());
                pSDEFormDetailService.create(pSDEFormDetail);
            }
        }
    }

    protected void initDefaultSearchForm(PSDataEntity pSDataEntity) throws Exception {
        String string = null;
        string = this.isEnableFolderKey(pSDataEntity) ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_SEARCHFORM) : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"SEARCHFORM");
        PSDEForm pSDEForm = new PSDEForm();
        pSDEForm.setPSDEFormId(string);
        if (this.checkKey(pSDEForm) == 0) {
            pSDEForm.reset();
            pSDEForm.setFormType("SEARCHFORM");
            pSDEForm.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEForm.setCodeName("Default");
            if (this.selectOne(pSDEForm, true)) {
                return;
            }
            pSDEForm.reset();
            pSDEForm.setPSDEFormId(string);
            pSDEForm.setFormType("SEARCHFORM");
            pSDEForm.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEForm.setCodeName("Default");
            pSDEForm.setMobFlag(0);
            pSDEForm.setPSDEFormName("\u9ed8\u8ba4\u641c\u7d22\u8868\u5355");
            this.create(pSDEForm);
            PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEFormDetail pSDEFormDetail = new PSDEFormDetail();
            pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEFormDetail.setPSDEFormDetailName("formpage1");
            pSDEFormDetail.setCaption("\u5e38\u89c4\u6761\u4ef6");
            pSDEFormDetail.setDetailType("FORMPAGE");
            pSDEFormDetail.setOrderValue(1);
            pSDEFormDetail.setShowCaption(0);
            pSDEFormDetail.setColModel("33%;33%;34%");
            pSDEFormDetailService.create(pSDEFormDetail);
        }
    }

    protected void initDefaultMobEditForm(PSDataEntity pSDataEntity) throws Exception {
        String string = null;
        string = this.isEnableFolderKey(pSDataEntity) ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_MOBEDITFORM) : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"EDITFORM", (String)"MOB");
        PSDEForm pSDEForm = new PSDEForm();
        pSDEForm.setPSDEFormId(string);
        if (this.checkKey(pSDEForm) == 0) {
            PSDEFormDetail pSDEFormDetail;
            PSDEField field;
            pSDEForm.reset();
            pSDEForm.setFormType("EDITFORM");
            pSDEForm.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEForm.setCodeName("MobMain");
            if (this.selectOne(pSDEForm, true)) {
                return;
            }
            pSDEForm.reset();
            pSDEForm.setPSDEFormId(string);
            pSDEForm.setFormType("EDITFORM");
            pSDEForm.setPSDEId(pSDataEntity.getPSDataEntityId());
            int n = 1;
            String string2 = null;
            do {
                string2 = StringHelper.format((String)"MobMain%1$s", (Object)(n == 1 ? "" : Integer.valueOf(n)));
                ++n;
                PSDEForm candidate = new PSDEForm();
                candidate.setPSDEId(pSDataEntity.getPSDataEntityId());
                candidate.setCodeName(string2);
                if (!this.select(candidate, true)) {
                    break;
                }
            } while (true);
            pSDEForm.setCodeName(string2);
            pSDEForm.setPSDEFormName("\u79fb\u52a8\u7aef\u9ed8\u8ba4\u7f16\u8f91\u8868\u5355");
            pSDEForm.setMobFlag(1);
            this.create(pSDEForm);
            PSDEFieldService fieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSDEField> arrayList = fieldService.selectByPSDE(pSDataEntity);
            HashMap<String, PSDEField> hashMap = new HashMap<String, PSDEField>();
            PSDEField entityBase3 = null;
            for (PSDEField entityBase22 : arrayList) {
                hashMap.put(entityBase22.getPSDEFieldName(), entityBase22);
                if (!DataObject.getBoolValue((Integer)entityBase22.getMajorField(), (boolean)false)) continue;
                entityBase3 = entityBase22;
            }
            PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEFormDetail pSDEFormDetail2 = new PSDEFormDetail();
            pSDEFormDetail2.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEFormDetail2.setPSDEFormDetailName("formpage1");
            pSDEFormDetail2.setDetailType("FORMPAGE");
            pSDEFormDetail2.setOrderValue(1);
            pSDEFormDetail2.setCaption("\u57fa\u672c\u4fe1\u606f");
            pSDEFormDetailService.create(pSDEFormDetail2);
            PSDEFormDetail pSDEFormDetail3 = new PSDEFormDetail();
            pSDEFormDetail3.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEFormDetail3.setPSDEFormDetailName("group1");
            pSDEFormDetail3.setPPSDEFormDetailId(pSDEFormDetail2.getPSDEFormDetailId());
            pSDEFormDetail3.setDetailType("GROUPPANEL");
            pSDEFormDetail3.setOrderValue(1);
            pSDEFormDetail3.setCaption(StringHelper.format((String)"%1$s\u57fa\u672c\u4fe1\u606f", (Object)pSDataEntity.getLogicName()));
            pSDEFormDetailService.create(pSDEFormDetail3);
            if (entityBase3 != null) {
                PSDEFormDetail majorItem = new PSDEFormDetail();
                majorItem.setPSDEFormId(pSDEForm.getPSDEFormId());
                majorItem.setPSDEFormDetailName(entityBase3.getPSDEFieldName().toLowerCase());
                majorItem.setPPSDEFormDetailId(pSDEFormDetail3.getPSDEFormDetailId());
                majorItem.setDetailType("FORMITEM");
                majorItem.setOrderValue(1);
                majorItem.setPSDEFId(entityBase3.getPSDEFieldId());
                majorItem.setPSDEFName(entityBase3.getPSDEFieldName());
                pSDEFormDetailService.create(majorItem);
            }
            pSDEFormDetail3 = new PSDEFormDetail();
            pSDEFormDetail3.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEFormDetail3.setPSDEFormDetailName("group2");
            pSDEFormDetail3.setPPSDEFormDetailId(pSDEFormDetail2.getPSDEFormDetailId());
            pSDEFormDetail3.setDetailType("GROUPPANEL");
            pSDEFormDetail3.setOrderValue(2);
            pSDEFormDetail3.setCaption("\u64cd\u4f5c\u4fe1\u606f");
            pSDEFormDetailService.create(pSDEFormDetail3);
            field = hashMap.get("CREATEMAN");
            if (field != null) {
                pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
                pSDEFormDetail.setPSDEFormDetailName(field.getPSDEFieldName().toLowerCase());
                pSDEFormDetail.setPPSDEFormDetailId(pSDEFormDetail3.getPSDEFormDetailId());
                pSDEFormDetail.setDetailType("FORMITEM");
                pSDEFormDetail.setOrderValue(1);
                pSDEFormDetail.setPSDEFId(field.getPSDEFieldId());
                pSDEFormDetail.setPSDEFName(field.getPSDEFieldName());
                pSDEFormDetailService.create(pSDEFormDetail);
            }
            if ((field = hashMap.get("CREATEDATE")) != null) {
                pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
                pSDEFormDetail.setPSDEFormDetailName(field.getPSDEFieldName().toLowerCase());
                pSDEFormDetail.setPPSDEFormDetailId(pSDEFormDetail3.getPSDEFormDetailId());
                pSDEFormDetail.setDetailType("FORMITEM");
                pSDEFormDetail.setOrderValue(2);
                pSDEFormDetail.setPSDEFId(field.getPSDEFieldId());
                pSDEFormDetail.setPSDEFName(field.getPSDEFieldName());
                pSDEFormDetailService.create(pSDEFormDetail);
            }
            if ((field = hashMap.get("UPDATEMAN")) != null) {
                pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
                pSDEFormDetail.setPSDEFormDetailName(field.getPSDEFieldName().toLowerCase());
                pSDEFormDetail.setPPSDEFormDetailId(pSDEFormDetail3.getPSDEFormDetailId());
                pSDEFormDetail.setDetailType("FORMITEM");
                pSDEFormDetail.setOrderValue(3);
                pSDEFormDetail.setPSDEFId(field.getPSDEFieldId());
                pSDEFormDetail.setPSDEFName(field.getPSDEFieldName());
                pSDEFormDetailService.create(pSDEFormDetail);
            }
            if ((field = hashMap.get("UPDATEDATE")) != null) {
                pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
                pSDEFormDetail.setPSDEFormDetailName(field.getPSDEFieldName().toLowerCase());
                pSDEFormDetail.setPPSDEFormDetailId(pSDEFormDetail3.getPSDEFormDetailId());
                pSDEFormDetail.setDetailType("FORMITEM");
                pSDEFormDetail.setOrderValue(4);
                pSDEFormDetail.setPSDEFId(field.getPSDEFieldId());
                pSDEFormDetail.setPSDEFName(field.getPSDEFieldName());
                pSDEFormDetailService.create(pSDEFormDetail);
            }
        }
    }

    protected void initDefaultMobSearchForm(PSDataEntity pSDataEntity) throws Exception {
        String string = null;
        string = this.isEnableFolderKey(pSDataEntity) ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_MOBSEARCHFORM) : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"SEARCHFORM", (String)"MOB");
        PSDEForm pSDEForm = new PSDEForm();
        pSDEForm.setPSDEFormId(string);
        if (this.checkKey(pSDEForm) == 0) {
            pSDEForm.reset();
            pSDEForm.setFormType("SEARCHFORM");
            pSDEForm.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEForm.setCodeName("MobDef");
            if (this.selectOne(pSDEForm, true)) {
                return;
            }
            pSDEForm.reset();
            pSDEForm.setPSDEFormId(string);
            pSDEForm.setFormType("SEARCHFORM");
            pSDEForm.setPSDEId(pSDataEntity.getPSDataEntityId());
            int n = 1;
            String string2 = null;
            do {
                string2 = StringHelper.format((String)"MobDef%1$s", (Object)(n == 1 ? "" : Integer.valueOf(n)));
                ++n;
                PSDEForm candidate = new PSDEForm();
                candidate.setPSDEId(pSDataEntity.getPSDataEntityId());
                candidate.setCodeName(string2);
                if (!this.select(candidate, true)) {
                    break;
                }
            } while (true);
            pSDEForm.setMobFlag(1);
            pSDEForm.setCodeName(string2);
            pSDEForm.setPSDEFormName("\u79fb\u52a8\u7aef\u641c\u7d22\u8868\u5355");
            this.create(pSDEForm);
            PSDEFormDetailService detailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEFormDetail pSDEFormDetail = new PSDEFormDetail();
            pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEFormDetail.setPSDEFormDetailName("formpage1");
            pSDEFormDetail.setCaption("\u5e38\u89c4\u6761\u4ef6");
            pSDEFormDetail.setDetailType("FORMPAGE");
            pSDEFormDetail.setOrderValue(1);
            pSDEFormDetail.setShowCaption(0);
            detailService.create(pSDEFormDetail);
        }
    }

    protected void initDefaultFormDetail(PSDataEntity pSDataEntity, PSDEForm pSDEForm, boolean bl) throws Exception {
        if (StringHelper.compare((String)pSDEForm.getFormType(), (String)"EDITFORM", (boolean)true) == 0) {
            this.initDefaultEditFormDetail(pSDataEntity, pSDEForm, bl);
        }
    }

    protected void initDefaultEditFormDetail(PSDataEntity pSDataEntity, PSDEForm pSDEForm, boolean bl) throws Exception {
        PSDEFormDetail pSDEFormDetail;
        PSDEField field;
        PSDEField pSDEField = null;
        HashMap<String, PSDEField> hashMap = new HashMap<String, PSDEField>();
        if (pSDataEntity != null) {
            PSDEFieldService fieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSDEField> fields = fieldService.selectByPSDE(pSDataEntity);
            for (PSDEField selectedField : fields) {
                hashMap.put(selectedField.getPSDEFieldName(), selectedField);
                if (!DataObject.getBoolValue((Integer)selectedField.getMajorField(), (boolean)false)) continue;
                pSDEField = selectedField;
            }
        }
        PSDEFormDetailService detailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        PSDEFormDetail page = new PSDEFormDetail();
        page.setPSDEFormId(pSDEForm.getPSDEFormId());
        page.setPSDEFormDetailName("formpage1");
        page.setDetailType("FORMPAGE");
        page.setOrderValue(1);
        page.setCaption("\u57fa\u672c\u4fe1\u606f");
        if (bl) {
            detailService.createTemp(page);
        } else {
            detailService.create(page);
        }
        PSDEFormDetail group = new PSDEFormDetail();
        group.setPSDEFormId(pSDEForm.getPSDEFormId());
        group.setPSDEFormDetailName("group1");
        group.setPPSDEFormDetailId(page.getPSDEFormDetailId());
        group.setDetailType("GROUPPANEL");
        group.setOrderValue(1);
        if (pSDataEntity != null) {
            group.setCaption(StringHelper.format((String)"%1$s\u57fa\u672c\u4fe1\u606f", (Object)pSDataEntity.getLogicName()));
        } else {
            group.setCaption(StringHelper.format((String)"\u57fa\u672c\u4fe1\u606f"));
        }
        group.setColModel("50%;50%");
        if (bl) {
            detailService.createTemp(group);
        } else {
            detailService.create(group);
        }
        if (pSDEField != null) {
            PSDEFormDetail majorItem = new PSDEFormDetail();
            majorItem.setPSDEFormId(pSDEForm.getPSDEFormId());
            majorItem.setPSDEFormDetailName(pSDEField.getPSDEFieldName().toLowerCase());
            majorItem.setPPSDEFormDetailId(group.getPSDEFormDetailId());
            majorItem.setDetailType("FORMITEM");
            majorItem.setOrderValue(1);
            majorItem.setPSDEFId(pSDEField.getPSDEFieldId());
            majorItem.setPSDEFName(pSDEField.getPSDEFieldName());
            if (bl) {
                detailService.createTemp(majorItem);
            } else {
                detailService.create(majorItem);
            }
        }
        page = new PSDEFormDetail();
        page.setPSDEFormId(pSDEForm.getPSDEFormId());
        page.setPSDEFormDetailName("formpage2");
        page.setDetailType("FORMPAGE");
        page.setOrderValue(2);
        page.setCaption("\u5176\u5b83");
        if (bl) {
            detailService.createTemp(page);
        } else {
            detailService.create(page);
        }
        group = new PSDEFormDetail();
        group.setPSDEFormId(pSDEForm.getPSDEFormId());
        group.setPSDEFormDetailName("group2");
        group.setPPSDEFormDetailId(page.getPSDEFormDetailId());
        group.setDetailType("GROUPPANEL");
        group.setOrderValue(2);
        group.setCaption("\u64cd\u4f5c\u4fe1\u606f");
        group.setColModel("50%;50%");
        if (bl) {
            detailService.createTemp(group);
        } else {
            detailService.create(group);
        }
        field = hashMap.get("CREATEMAN");
        if (field != null) {
            pSDEFormDetail = new PSDEFormDetail();
            pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEFormDetail.setPSDEFormDetailName(field.getPSDEFieldName().toLowerCase());
            pSDEFormDetail.setPPSDEFormDetailId(group.getPSDEFormDetailId());
            pSDEFormDetail.setDetailType("FORMITEM");
            pSDEFormDetail.setOrderValue(1);
            pSDEFormDetail.setPSDEFId(field.getPSDEFieldId());
            pSDEFormDetail.setPSDEFName(field.getPSDEFieldName());
            if (bl) {
                detailService.createTemp(pSDEFormDetail);
            } else {
                detailService.create(pSDEFormDetail);
            }
        }
        if ((field = hashMap.get("CREATEDATE")) != null) {
            pSDEFormDetail = new PSDEFormDetail();
            pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEFormDetail.setPSDEFormDetailName(field.getPSDEFieldName().toLowerCase());
            pSDEFormDetail.setPPSDEFormDetailId(group.getPSDEFormDetailId());
            pSDEFormDetail.setDetailType("FORMITEM");
            pSDEFormDetail.setOrderValue(2);
            pSDEFormDetail.setPSDEFId(field.getPSDEFieldId());
            pSDEFormDetail.setPSDEFName(field.getPSDEFieldName());
            if (bl) {
                detailService.createTemp(pSDEFormDetail);
            } else {
                detailService.create(pSDEFormDetail);
            }
        }
        if ((field = hashMap.get("UPDATEMAN")) != null) {
            pSDEFormDetail = new PSDEFormDetail();
            pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEFormDetail.setPSDEFormDetailName(field.getPSDEFieldName().toLowerCase());
            pSDEFormDetail.setPPSDEFormDetailId(group.getPSDEFormDetailId());
            pSDEFormDetail.setDetailType("FORMITEM");
            pSDEFormDetail.setOrderValue(3);
            pSDEFormDetail.setPSDEFId(field.getPSDEFieldId());
            pSDEFormDetail.setPSDEFName(field.getPSDEFieldName());
            if (bl) {
                detailService.createTemp(pSDEFormDetail);
            } else {
                detailService.create(pSDEFormDetail);
            }
        }
        if ((field = hashMap.get("UPDATEDATE")) != null) {
            pSDEFormDetail = new PSDEFormDetail();
            pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEFormDetail.setPSDEFormDetailName(field.getPSDEFieldName().toLowerCase());
            pSDEFormDetail.setPPSDEFormDetailId(group.getPSDEFormDetailId());
            pSDEFormDetail.setDetailType("FORMITEM");
            pSDEFormDetail.setOrderValue(4);
            pSDEFormDetail.setPSDEFId(field.getPSDEFieldId());
            pSDEFormDetail.setPSDEFName(field.getPSDEFieldName());
            if (bl) {
                detailService.createTemp(pSDEFormDetail);
            } else {
                detailService.create(pSDEFormDetail);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEForm pSDEForm, XmlNode xmlNode) throws Exception {
        HashMap<XmlNode, XmlNode> hashMap = new HashMap<XmlNode, XmlNode>();
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEFIUPDATES");
        Iterator updateNodes = xmlNode2 != null ? xmlNode2.getChildNodes() : null;
        if (updateNodes != null) {
            while (updateNodes.hasNext()) {
                XmlNode updateNode = (XmlNode)updateNodes.next();
                XmlNode detailNode = updateNode.getChildNodeByNodeName("PSDEFIDETAILS");
                if (detailNode == null) continue;
                hashMap.put(updateNode, detailNode);
                updateNode.removeNode(detailNode);
            }
        }
        this.importRelatedXmlModel_PSDEFIUpdate(pSDEForm, xmlNode2);
        XmlNode formDetails = xmlNode.getChildNodeByNodeName("PSDEFORMDETAILS");
        this.importRelatedXmlModel_PSDEFormDetail(pSDEForm, formDetails);
        updateNodes = xmlNode2 != null ? xmlNode2.getChildNodes() : null;
        if (updateNodes != null) {
            PSDEFIUDetailService detailService = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
            while (updateNodes.hasNext()) {
                Iterator iterator2;
                XmlNode xmlNode3 = (XmlNode)updateNodes.next();
                XmlNode xmlNode4 = (XmlNode)hashMap.get(xmlNode3);
                if (xmlNode4 == null || (iterator2 = xmlNode4.getChildNodes()) == null) continue;
                while (iterator2.hasNext()) {
                    XmlNode xmlNode5 = (XmlNode)iterator2.next();
                    PSDEFIUDetail pSDEFIUDetail = new PSDEFIUDetail();
                    detailService.fillParentInfo(pSDEFIUDetail, "DER1N", "DER1N_PSDEFIUDETAIL_PSDEFIUPDATE_PSDEFIUPDATEID", xmlNode3.getAttribute("PSDEFIUPDATEID", ""));
                    detailService.importXmlModel(pSDEFIUDetail, xmlNode5);
                }
            }
        }
    }

    @Override
    protected void onJITPreview(PSDEForm pSDEForm) throws Exception {
        if (this.getWebContext() == null || this.getWebContext().getCurAjaxActionResult() == null) {
            throw new Exception("\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u4e0d\u6b63\u786e");
        }
        String string = pSDEForm.getPSDEFormId();
        if (KeyValueHelper.isTempKey((String)string)) {
            this.getTemp(pSDEForm);
            string = (String)EntityBase.getOriginKey(pSDEForm);
        }
        PSDEForm pSDEForm2 = new PSDEForm();
        pSDEForm2.setPSDEFormId(string);
        PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEViewCtrl> arrayList = pSDEViewCtrlService.selectByPSDEForm(pSDEForm2);
        if (arrayList.size() == 0) {
            throw new Exception("\u5b9e\u4f53\u8868\u5355\u8fd8\u672a\u88ab\u89c6\u56fe\u5f15\u7528");
        }
        PSAppDEViewService pSAppDEViewService = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
        PSAppDEView pSAppDEView = null;
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            ArrayList<PSAppDEView> arrayList2 = pSAppDEViewService.selectByPSDEViewBase(pSDEViewCtrl.getPSDEViewBase());
            if (arrayList2.size() == 0) continue;
            PSSysAppBase pSSysAppBase = null;
            for (PSAppDEView pSAppDEView2 : arrayList2) {
                if (pSAppDEView == null) {
                    pSAppDEView = pSAppDEView2;
                }
                if (!DataObject.getBoolValue((Integer)(pSSysAppBase = pSAppDEView2.getPSSysApp()).getDefaultPub(), (boolean)false)) continue;
                pSAppDEView = pSAppDEView2;
                break;
            }
            if (pSSysAppBase == null || !DataObject.getBoolValue((Integer)pSSysAppBase.getDefaultPub(), (boolean)false)) continue;
            break;
        }
        if (pSAppDEView == null) {
            throw new Exception("\u5b9e\u4f53\u8868\u5355\u88ab\u5f15\u7528\u7684\u89c6\u56fe\u8fd8\u672a\u52a0\u5165\u5230\u5e94\u7528");
        }
        pSAppDEViewService.jITPreview(pSAppDEView);
    }

    @Override
    public void getDraftTempMajorFrom(PSDEForm pSDEForm) throws Exception {
        Object object = EntityBase.getOriginKey(pSDEForm);
        if (StringHelper.isNullOrEmpty((Object)object)) {
            object = pSDEForm.getPSDEFormId();
        }
        super.getDraftTempMajorFrom(pSDEForm);
        if (!StringHelper.isNullOrEmpty((Object)object)) {
            PSDEForm pSDEForm2;
            PSDEForm pSDEForm3 = new PSDEForm();
            pSDEForm3.setSessionFactory(this.getSessionFactory());
            pSDEForm3.setPSDEFormId((String)object);
            if (!pSDEForm3.get(true)) {
                return;
            }
            int n = 2;
            while (true) {
                pSDEForm2 = new PSDEForm();
                pSDEForm2.setSessionFactory(this.getSessionFactory());
                pSDEForm2.setPSDEId(pSDEForm3.getPSDEId());
                pSDEForm2.setFormType(pSDEForm3.getFormType());
                pSDEForm2.setPSDEFormName(StringHelper.format((String)"%1$s(%2$s)", (Object)pSDEForm3.getPSDEFormName(), (Object)n));
                if (!pSDEForm2.select(true)) break;
                ++n;
            }
            pSDEForm.setPSDEFormName(pSDEForm2.getPSDEFormName());
            n = 2;
            while (true) {
                pSDEForm2 = new PSDEForm();
                pSDEForm2.setSessionFactory(this.getSessionFactory());
                pSDEForm2.setPSDEId(pSDEForm3.getPSDEId());
                pSDEForm2.setFormType(pSDEForm3.getFormType());
                pSDEForm2.setCodeName(StringHelper.format((String)"%1$s_%2$s", (Object)pSDEForm3.getCodeName(), (Object)n));
                if (!pSDEForm2.select(true)) {
                    pSDEForm.setCodeName(pSDEForm2.getCodeName());
                    break;
                }
                ++n;
            }
        }
    }

    @Override
    protected void onImportModelV2(boolean bl, PSDEForm pSDEForm, ArrayList<PSCoreSysServiceBase<PSDEForm>.ModelV2> arrayList) throws Exception {
        Object object;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        if (!StringHelper.isNullOrEmpty((String)pSDEForm.getPSDEFormId())) {
            String string = "select t1.PSDEFORMDETAILID,T1.REFPSDEFORMDETAILID,T2.PSDEFORMDETAILNAME AS REFPSDEFORMDETAILNAME from t_srfpsdeformdetail t1 INNER JOIN T_SRFPSDEFORMDETAIL T2 ON T1.REFPSDEFORMDETAILID = T2.PSDEFORMDETAILID WHERE T2.PSDEFORMID = ?";
            SqlParamList object2 = new SqlParamList();
            object2.addString(pSDEForm.getPSDEFormId());
            object = this.selectRaw(string, object2);
            Iterator iterator = ((ArrayList)object).iterator();
            while (iterator.hasNext()) {
                IEntity iEntity = (IEntity)iterator.next();
                String string2 = DataObject.getStringValue((Object)iEntity.get("REFPSDEFORMDETAILNAME"));
                String string3 = DataObject.getStringValue((Object)iEntity.get("REFPSDEFORMDETAILID"));
                String string4 = null;
                for (PSCoreSysServiceBase<PSDEForm>.ModelV2 modelV2 : arrayList) {
                    if (StringHelper.compare((String)modelV2.type, (String)"PSDEFORMDETAIL", (boolean)false) != 0 || StringHelper.compare((String)modelV2.text, (String)string2, (boolean)true) != 0) continue;
                    string4 = modelV2.key;
                    break;
                }
                if (StringHelper.isNullOrEmpty(string4)) {
                    throw new Exception(StringHelper.format((String)"\u8868\u5355\u9879[%1$s]\u5b58\u5728\u5916\u90e8\u5f15\u7528\uff0c\u4f46\u5bfc\u5165\u6570\u636e\u672a\u5305\u62ec", (Object)string2));
                }
                hashMap.put(string3, string4);
            }
        }
        super.onImportModelV2(bl, pSDEForm, arrayList);
        for (Map.Entry entry : hashMap.entrySet()) {
            object = StringHelper.format((String)"UPDATE t_srfpsdeformdetail SET REFPSDEFORMDETAILID = '%1$s' WHERE REFPSDEFORMDETAILID = '%2$s'", entry.getValue(), entry.getKey());
            this.executeRaw((String)object, null);
        }
    }

    public void initMOSForm(final PSDEForm pSDEForm, final PSDEForm pSDEForm2) throws Exception {
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormService.this.onInitMOSForm(pSDEForm, pSDEForm2);
            }
        }, true);
    }

    protected void onInitMOSForm(PSDEForm pSDEForm, PSDEForm pSDEForm2) throws Exception {
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFormDetail> arrayList = pSDEFormDetailService.selectByPSDEForm(pSDEForm2);
        ArrayList<PSDEFDLogic> arrayList2 = pSDEFDLogicService.selectByPSDEForm(pSDEForm2);
        try {
            PSDEFormDetail page = new PSDEFormDetail();
            page.setPSDEFormDetailId(KeyValueHelper.genUniqueId((String)pSDEForm.getPSDEFormId(), (String)"formpage1"));
            if (pSDEFormDetailService.checkKey(page) == 1) {
                pSDEFormDetailService.remove(page);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        HashMap<String, PSDEFDLogic> copiedLogics = new HashMap<String, PSDEFDLogic>();
        HashMap<String, PSDEFormDetail> hashMap = new HashMap<String, PSDEFormDetail>();
        for (PSDEFormDetail iterator : arrayList) {
            PSDEFormDetail pSDEFormDetail = new PSDEFormDetail();
            iterator.copyTo((IDataObject)pSDEFormDetail, false);
            pSDEFormDetail.setPSDEFormDetailId(KeyValueHelper.genUniqueId((String)pSDEForm.getPSDEFormId(), (String)iterator.getPSDEFormDetailId()));
            pSDEFormDetail.setPSDEFIUpdateId(null);
            pSDEFormDetail.setPSDEFIUpdateName(null);
            pSDEFormDetail.setResetItemName(null);
            pSDEFormDetail.setPPSDEFormDetailId(null);
            pSDEFormDetail.setPPSDEFormDetailName(null);
            pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEFormDetail.setPSDEFormName(pSDEForm.getPSDEFormName());
            EntityBase.setIgnoreCheck(pSDEFormDetail, (boolean)true);
            EntityBase.setIgnoreCheckKey(pSDEFormDetail, (boolean)true);
            pSDEFormDetailService.create(pSDEFormDetail, false);
            hashMap.put(iterator.getPSDEFormDetailId(), pSDEFormDetail);
        }
        HashMap hashMap2 = new HashMap();
        for (PSDEFDLogic pSDEFDLogic : arrayList2) {
            PSDEFDLogic copiedLogic = new PSDEFDLogic();
            pSDEFDLogic.copyTo((IDataObject)copiedLogic, false);
            copiedLogic.setPSDEFDLogicId(KeyValueHelper.genUniqueId((String)pSDEForm.getPSDEFormId(), (String)pSDEFDLogic.getPSDEFDLogicId()));
            copiedLogic.setPPSDEFDLogicId(null);
            copiedLogic.setPPSDEFDLogicName(null);
            if (!StringHelper.isNullOrEmpty((String)pSDEFDLogic.getPSDEFormDetailId())) {
                copiedLogic.setPSDEFormDetailId(KeyValueHelper.genUniqueId((String)pSDEForm.getPSDEFormId(), (String)pSDEFDLogic.getPSDEFormDetailId()));
            }
            copiedLogic.setPSDEFormId(pSDEForm.getPSDEFormId());
            copiedLogic.setPSDEFormName(pSDEForm.getPSDEFormName());
            EntityBase.setIgnoreCheck(copiedLogic, (boolean)true);
            EntityBase.setIgnoreCheckKey(copiedLogic, (boolean)true);
            pSDEFDLogicService.create(copiedLogic, false);
            if (!StringHelper.isNullOrEmpty((String)pSDEFDLogic.getFDName())) {
                hashMap2.put(pSDEFDLogic.getFDName().toLowerCase(), "");
            }
            copiedLogics.put(pSDEFDLogic.getPSDEFDLogicId(), copiedLogic);
        }
        for (PSDEFDLogic pSDEFDLogic : arrayList2) {
            PSDEFDLogic copiedLogic = new PSDEFDLogic();
            if (StringHelper.isNullOrEmpty((String)pSDEFDLogic.getPPSDEFDLogicId())) continue;
            PSDEFDLogic parentLogic = copiedLogics.get(pSDEFDLogic.getPPSDEFDLogicId());
            copiedLogic.setPSDEFDLogicId(KeyValueHelper.genUniqueId((String)pSDEForm.getPSDEFormId(), (String)pSDEFDLogic.getPSDEFDLogicId()));
            if (parentLogic != null) {
                copiedLogic.setPPSDEFDLogicId(parentLogic.getPSDEFDLogicId());
                pSDEFDLogicService.sysUpdate(copiedLogic, false);
                continue;
            }
            log.error((Object)StringHelper.format((String)"\u8868\u5355\u9879\u903b\u8f91[%1$s]\u7236[%2$s]\u65e0\u6548", (Object)pSDEFDLogic.getPSDEFDLogicId(), (Object)pSDEFDLogic.getPPSDEFDLogicId()));
        }
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail copiedDetail = new PSDEFormDetail();
            copiedDetail.setPSDEFormDetailId(KeyValueHelper.genUniqueId((String)pSDEForm.getPSDEFormId(), (String)pSDEFormDetail.getPSDEFormDetailId()));
            if (!StringHelper.isNullOrEmpty((String)pSDEFormDetail.getPPSDEFormDetailId())) {
                PSDEFormDetail parentDetail = hashMap.get(pSDEFormDetail.getPPSDEFormDetailId());
                if (parentDetail != null) {
                    copiedDetail.setPPSDEFormDetailId(parentDetail.getPSDEFormDetailId());
                } else {
                    log.error((Object)StringHelper.format((String)"\u8868\u5355\u9879[%1$s]\u7236[%2$s]\u65e0\u6548", (Object)pSDEFormDetail.getPSDEFormDetailId(), (Object)pSDEFormDetail.getPPSDEFormDetailId()));
                    continue;
                }
            }
            if (StringHelper.compare((String)pSDEFormDetail.getDetailType(), (String)"GROUPPANEL", (boolean)false) == 0) {
                copiedDetail.setChild_Col_LG(null);
                copiedDetail.setChild_Col_MD(null);
                copiedDetail.setChild_Col_SM(null);
                copiedDetail.setChild_Col_XS(null);
                copiedDetail.setEnableCond(null);
            }
            copiedDetail.setCol_LG(null);
            copiedDetail.setCol_MD(null);
            copiedDetail.setCol_SM(null);
            copiedDetail.setCol_XS(null);
            copiedDetail.setPSDEFUIModeId(null);
            if (hashMap2.containsKey(pSDEFormDetail.getPSDEFormDetailName().toLowerCase())) {
                copiedDetail.setEditorType("HIDDEN");
                PSDEFormDetail textDetail = new PSDEFormDetail();
                pSDEFormDetail.copyTo((IDataObject)textDetail, false);
                textDetail.setPSDEFormDetailId(KeyValueHelper.genUniqueId((String)pSDEForm.getPSDEFormId(), (String)pSDEFormDetail.getPSDEFormDetailId(), (String)"mostext"));
                textDetail.setPSDEFormDetailName(pSDEFormDetail.getPSDEFormDetailName() + "_mostext");
                textDetail.setPSDEFUIModeId(null);
                textDetail.setPSDEFIUpdateId(null);
                textDetail.setPSDEFIUpdateName(null);
                textDetail.setResetItemName(null);
                if (!StringHelper.isNullOrEmpty((String)pSDEFormDetail.getPPSDEFormDetailId())) {
                    textDetail.setPPSDEFormDetailId(KeyValueHelper.genUniqueId((String)pSDEForm.getPSDEFormId(), (String)pSDEFormDetail.getPPSDEFormDetailId()));
                }
                textDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
                textDetail.setPSDEFormName(pSDEForm.getPSDEFormName());
                EntityBase.setIgnoreCheck(textDetail, (boolean)true);
                EntityBase.setIgnoreCheckKey(textDetail, (boolean)true);
                pSDEFormDetailService.create(textDetail, false);
            } else if (!StringHelper.isNullOrEmpty((String)pSDEFormDetail.getEditorType()) && StringHelper.compare((String)pSDEFormDetail.getEditorType(), (String)"HIDDEN", (boolean)true) != 0) {
                copiedDetail.setEditorType(null);
            }
            pSDEFormDetailService.sysUpdate(copiedDetail, false);
        }
    }

    public void fixMOSForm(final PSDEForm pSDEForm, final PSDEForm pSDEForm2) throws Exception {
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormService.this.onFixMOSForm(pSDEForm, pSDEForm2);
            }
        }, true);
    }

    protected void onFixMOSForm(PSDEForm pSDEForm, PSDEForm pSDEForm2) throws Exception {
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSDEFORMID", (Object)pSDEForm2.getPSDEFormId());
        selectCond.set("DETAILTYPE", (Object)"FORMPART");
        ArrayList<PSDEFormDetail> arrayList = pSDEFormDetailService.select((ISelectCond)selectCond);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = new PSDEFormDetail();
            pSDEFormDetail2.setPSDEFormDetailId(KeyValueHelper.genUniqueId((String)pSDEForm.getPSDEFormId(), (String)pSDEFormDetail.getPSDEFormDetailId()));
        }
    }
}
