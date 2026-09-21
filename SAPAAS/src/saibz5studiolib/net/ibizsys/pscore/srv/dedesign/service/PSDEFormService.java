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
            this.getTemp((IEntity)pSDEForm);
        }
        pSDEForm.setFormModel(this.getFormModel(pSDEForm));
    }

    protected String getFormModel(PSDEForm pSDEForm) throws Exception {
        XmlNode xmlNode;
        Object object;
        Object object2;
        Object object3;
        final PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService((String)PSDEFormDetailService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        final ArrayList<PSDEFormDetail> arrayList = pSDEFormDetailService.selectTempByPSDEForm(pSDEForm, "ORDER BY ORDERVALUE");
        final HashMap hashMap = new HashMap();
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                for (PSDEFormDetail pSDEFormDetail : arrayList) {
                    pSDEFormDetailService.fillPreviewHtml(pSDEFormDetail, false);
                    XmlNode xmlNode = new XmlNode();
                    xmlNode.setNodeName(pSDEFormDetail.getDetailType());
                    pSDEFormDetailService.fillXmlNode((IEntity)pSDEFormDetail, xmlNode, false);
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
            object3 = (PSDEFieldService)ServiceGlobal.getService((String)PSDEFieldService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            ArrayList<PSDEField> selectCond2 = ((PSDEFieldService)object3).selectByDataEntity(pSDEForm.getPSDEId());
            object2 = new XmlNode();
            object2.setNodeName("DEFIELDS");
            xmlNode2.addNode((XmlNode)object2);
            for (Object object4 : selectCond2) {
                object = new XmlNode();
                object.setNodeName("DEFIELD");
                object.setAttribute("PSDEFID", ((PSDEFieldBase)object4).getPSDEFieldId());
                object.setAttribute("PSDEFNAME", ((PSDEFieldBase)object4).getPSDEFieldName().toLowerCase());
                object.setAttribute("LOGICNAME", ((PSDEFieldBase)object4).getLogicName());
                object2.addNode((XmlNode)object);
            }
        } else if (StringHelper.compare((String)pSDEForm.getFormType(), (String)"SEARCHFORM", (boolean)true) == 0) {
            Object object4;
            object3 = (PSDEFSFItemService)ServiceGlobal.getService((String)PSDEFSFItemService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            SelectCond selectCond = new SelectCond();
            selectCond.setOrderInfo("ORDER BY PSDEFNAME");
            selectCond.setConditon("PSDEID", (Object)pSDEForm.getPSDEId());
            object2 = object3.select((ISelectCond)selectCond);
            xmlNode = new XmlNode();
            xmlNode.setNodeName("DEFSFITEMS");
            xmlNode2.addNode(xmlNode);
            object4 = ((ArrayList)object2).iterator();
            while (object4.hasNext()) {
                object = (PSDEFSFItem)object4.next();
                XmlNode xmlNode3 = new XmlNode();
                xmlNode3.setNodeName("DEFSFITEM");
                xmlNode3.setAttribute("PSDEFID", ((PSDEFSFItemBase)object).getPSDEFId());
                xmlNode3.setAttribute("PSDEFNAME", ((PSDEFSFItemBase)object).getPSDEFName().toLowerCase());
                xmlNode3.setAttribute("PSDEFSFITEMNAME", ((PSDEFSFItemBase)object).getPSDEFSFItemName());
                xmlNode3.setAttribute("PSDEFSFITEMID", ((PSDEFSFItemBase)object).getPSDEFSFItemId());
                String string = ((PSDEFSFItemBase)object).getCaption();
                if (StringHelper.isNullOrEmpty((String)string)) {
                    string = StringHelper.isNullOrEmpty((String)((PSDEFSFItemBase)object).getPSSysDBVFName()) ? StringHelper.format((String)"%1$s(%2$s)", (Object)((PSDEFSFItemBase)object).getLogicName(), (Object)((PSDEFSFItemBase)object).getPSDBValueOPName()) : StringHelper.format((String)"%1$s[%3$s](%2$s)", (Object)((PSDEFSFItemBase)object).getLogicName(), (Object)((PSDEFSFItemBase)object).getPSDBValueOPName(), (Object)((PSDEFSFItemBase)object).getPSSysDBVFName());
                }
                xmlNode3.setAttribute("CAPTION", string);
                xmlNode.addNode(xmlNode3);
            }
        }
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            object2 = (XmlNode)hashMap.get(pSDEFormDetail.getPSDEFormDetailId());
            if (StringHelper.isNullOrEmpty((String)pSDEFormDetail.getPPSDEFormDetailId())) {
                xmlNode2.addNode((XmlNode)object2);
                continue;
            }
            xmlNode = (XmlNode)hashMap.get(pSDEFormDetail.getPPSDEFormDetailId());
            if (xmlNode != null) {
                xmlNode.addNode((XmlNode)object2);
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
                PSDEFormDetail pSDEFormDetail2;
                PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService((String)PSDEFormDetailService.class.getCanonicalName(), (SessionFactory)PSDEFormService.this.getSessionFactory());
                ArrayList<PSDEFormDetail> arrayList = pSDEFormDetailService.selectTempByPSDEForm(pSDEForm2);
                HashMap<String, PSDEFormDetail> hashMap = new HashMap<String, PSDEFormDetail>();
                for (PSDEFormDetail pSDEFormDetail2 : arrayList) {
                    hashMap.put(pSDEFormDetail2.getPSDEFormDetailId(), pSDEFormDetail2);
                }
                String string = pSDEForm2.getFormModel();
                pSDEFormDetail2 = XmlNode.loadFromXML((String)string);
                if (pSDEFormDetail2 != null) {
                    pSDEFormDetail2.setAttribute("PSDEID", pSDEForm2.getPSDEId());
                    pSDEFormDetail2.setAttribute("PSDEFORMID", pSDEForm2.getPSDEFormId());
                    pSDEFormDetail2.setAttribute("FORMTYPE", pSDEForm2.getFormType());
                    PSDEFormService.this.updatePSDEFormDetails(pSDEForm2, null, (XmlNode)pSDEFormDetail2, hashMap);
                    pSDEForm2.setFormModel(XmlNode.export((XmlNode)pSDEFormDetail2));
                } else {
                    pSDEForm2.setFormModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSDEFormDetail pSDEFormDetail3 : hashMap.values()) {
                        pSDEFormDetailService.removeTemp((IEntity)pSDEFormDetail3);
                    }
                }
                PSDEFormService.this.updateTempMajor(pSDEForm2);
            }
        });
    }

    protected void updatePSDEFormDetails(PSDEForm pSDEForm, PSDEFormDetail pSDEFormDetail, XmlNode xmlNode, HashMap<String, PSDEFormDetail> hashMap) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
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
                    pSDEFormDetailService.updateTemp((IEntity)pSDEFormDetail2);
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
                pSDEFormDetailService.fillXmlNode((IEntity)pSDEFormDetail2, xmlNode2, false);
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
                PSDEFormDetail pSDEFormDetail2;
                PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService((String)PSDEFormDetailService.class.getCanonicalName(), (SessionFactory)PSDEFormService.this.getSessionFactory());
                ArrayList<PSDEFormDetail> arrayList = pSDEFormDetailService.selectTempByPSDEForm(pSDEForm2);
                HashMap<String, PSDEFormDetail> hashMap = new HashMap<String, PSDEFormDetail>();
                for (PSDEFormDetail pSDEFormDetail2 : arrayList) {
                    hashMap.put(pSDEFormDetail2.getPSDEFormDetailId(), pSDEFormDetail2);
                }
                String string = pSDEForm2.getFormModel();
                pSDEFormDetail2 = XmlNode.loadFromXML((String)string);
                if (pSDEFormDetail2 != null) {
                    pSDEFormDetail2.setAttribute("PSDEID", pSDEForm2.getPSDEId());
                    pSDEFormDetail2.setAttribute("PSDEFORMID", pSDEForm2.getPSDEFormId());
                    pSDEFormDetail2.setAttribute("FORMTYPE", pSDEForm2.getFormType());
                    PSDEFormService.this.updatePSDEFormDetails(pSDEForm2, null, (XmlNode)pSDEFormDetail2, hashMap);
                    pSDEForm2.setFormModel(XmlNode.export((XmlNode)pSDEFormDetail2));
                } else {
                    pSDEForm2.setFormModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSDEFormDetail pSDEFormDetail3 : hashMap.values()) {
                        pSDEFormDetailService.removeTemp((IEntity)pSDEFormDetail3);
                    }
                }
                PSDEFormService.this.createTempMajor((IEntity)pSDEForm2);
            }
        });
    }

    @Override
    public void previewSave(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        log.debug((Object)"\u5f00\u59cb[previewSave]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetail pSDEFormDetail2;
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
                if ((pSDEFormDetail2 = XmlNode.loadFromXML((String)object)) != null) {
                    PSDEFormService.this.updatePSDEFormDetails(pSDEForm2, null, (XmlNode)pSDEFormDetail2, hashMap);
                    pSDEForm2.setFormModel(XmlNode.export((XmlNode)pSDEFormDetail2));
                } else {
                    pSDEForm2.setFormModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSDEFormDetail pSDEFormDetail3 : hashMap.values()) {
                        pSDEFormDetailService.removeTemp((IEntity)pSDEFormDetail3);
                    }
                }
            }
        });
    }

    @Override
    public void getDraftWithModel(PSDEForm pSDEForm) throws Exception {
        this.getDraftTempMajor((IEntity)pSDEForm);
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
        string = this.isEnableFolderKey((IEntity)pSDataEntity) ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_EDITFORM) : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"EDITFORM");
        PSDEForm pSDEForm = new PSDEForm();
        pSDEForm.setPSDEFormId(string);
        if (this.checkKey(pSDEForm) == 0) {
            PSDEFormDetail pSDEFormDetail;
            EntityBase entityBase;
            pSDEForm.reset();
            pSDEForm.setFormType("EDITFORM");
            pSDEForm.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEForm.setCodeName("Main");
            if (this.selectOne((IEntity)pSDEForm, true)) {
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
                entityBase = new PSDEFormDetail();
                entityBase.setPSDEFormId(pSDEForm.getPSDEFormId());
                entityBase.setPSDEFormDetailName(entityBase3.getPSDEFieldName().toLowerCase());
                entityBase.setPPSDEFormDetailId(pSDEFormDetail3.getPSDEFormDetailId());
                entityBase.setDetailType("FORMITEM");
                entityBase.setOrderValue(1);
                entityBase.setPSDEFId(entityBase3.getPSDEFieldId());
                entityBase.setPSDEFName(entityBase3.getPSDEFieldName());
                pSDEFormDetailService.create(entityBase);
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
            entityBase = (PSDEField)hashMap.get("CREATEMAN");
            if (entityBase != null) {
                pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
                pSDEFormDetail.setPSDEFormDetailName(entityBase.getPSDEFieldName().toLowerCase());
                pSDEFormDetail.setPPSDEFormDetailId(pSDEFormDetail3.getPSDEFormDetailId());
                pSDEFormDetail.setDetailType("FORMITEM");
                pSDEFormDetail.setOrderValue(1);
                pSDEFormDetail.setPSDEFId(entityBase.getPSDEFieldId());
                pSDEFormDetail.setPSDEFName(entityBase.getPSDEFieldName());
                pSDEFormDetailService.create(pSDEFormDetail);
            }
            if ((entityBase = (PSDEField)hashMap.get("CREATEDATE")) != null) {
                pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
                pSDEFormDetail.setPSDEFormDetailName(entityBase.getPSDEFieldName().toLowerCase());
                pSDEFormDetail.setPPSDEFormDetailId(pSDEFormDetail3.getPSDEFormDetailId());
                pSDEFormDetail.setDetailType("FORMITEM");
                pSDEFormDetail.setOrderValue(2);
                pSDEFormDetail.setPSDEFId(entityBase.getPSDEFieldId());
                pSDEFormDetail.setPSDEFName(entityBase.getPSDEFieldName());
                pSDEFormDetailService.create(pSDEFormDetail);
            }
            if ((entityBase = (PSDEField)hashMap.get("UPDATEMAN")) != null) {
                pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
                pSDEFormDetail.setPSDEFormDetailName(entityBase.getPSDEFieldName().toLowerCase());
                pSDEFormDetail.setPPSDEFormDetailId(pSDEFormDetail3.getPSDEFormDetailId());
                pSDEFormDetail.setDetailType("FORMITEM");
                pSDEFormDetail.setOrderValue(3);
                pSDEFormDetail.setPSDEFId(entityBase.getPSDEFieldId());
                pSDEFormDetail.setPSDEFName(entityBase.getPSDEFieldName());
                pSDEFormDetailService.create(pSDEFormDetail);
            }
            if ((entityBase = (PSDEField)hashMap.get("UPDATEDATE")) != null) {
                pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
                pSDEFormDetail.setPSDEFormDetailName(entityBase.getPSDEFieldName().toLowerCase());
                pSDEFormDetail.setPPSDEFormDetailId(pSDEFormDetail3.getPSDEFormDetailId());
                pSDEFormDetail.setDetailType("FORMITEM");
                pSDEFormDetail.setOrderValue(4);
                pSDEFormDetail.setPSDEFId(entityBase.getPSDEFieldId());
                pSDEFormDetail.setPSDEFName(entityBase.getPSDEFieldName());
                pSDEFormDetailService.create(pSDEFormDetail);
            }
        }
    }

    protected void initDefaultSearchForm(PSDataEntity pSDataEntity) throws Exception {
        String string = null;
        string = this.isEnableFolderKey((IEntity)pSDataEntity) ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_SEARCHFORM) : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"SEARCHFORM");
        PSDEForm pSDEForm = new PSDEForm();
        pSDEForm.setPSDEFormId(string);
        if (this.checkKey(pSDEForm) == 0) {
            pSDEForm.reset();
            pSDEForm.setFormType("SEARCHFORM");
            pSDEForm.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEForm.setCodeName("Default");
            if (this.selectOne((IEntity)pSDEForm, true)) {
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
        string = this.isEnableFolderKey((IEntity)pSDataEntity) ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_MOBEDITFORM) : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"EDITFORM", (String)"MOB");
        PSDEForm pSDEForm = new PSDEForm();
        pSDEForm.setPSDEFormId(string);
        if (this.checkKey(pSDEForm) == 0) {
            PSDEFormDetail pSDEFormDetail;
            EntityBase entityBase;
            Object object;
            pSDEForm.reset();
            pSDEForm.setFormType("EDITFORM");
            pSDEForm.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEForm.setCodeName("MobMain");
            if (this.selectOne((IEntity)pSDEForm, true)) {
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
                object = new PSDEForm();
                ((PSDEFormBase)object).setPSDEId(pSDataEntity.getPSDataEntityId());
                ((PSDEFormBase)object).setCodeName(string2);
            } while (this.select(object, true));
            pSDEForm.setCodeName(string2);
            pSDEForm.setPSDEFormName("\u79fb\u52a8\u7aef\u9ed8\u8ba4\u7f16\u8f91\u8868\u5355");
            pSDEForm.setMobFlag(1);
            this.create(pSDEForm);
            object = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSDEField> arrayList = ((PSDEFieldServiceBase)object).selectByPSDE(pSDataEntity);
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
                entityBase = new PSDEFormDetail();
                entityBase.setPSDEFormId(pSDEForm.getPSDEFormId());
                entityBase.setPSDEFormDetailName(entityBase3.getPSDEFieldName().toLowerCase());
                entityBase.setPPSDEFormDetailId(pSDEFormDetail3.getPSDEFormDetailId());
                entityBase.setDetailType("FORMITEM");
                entityBase.setOrderValue(1);
                entityBase.setPSDEFId(entityBase3.getPSDEFieldId());
                entityBase.setPSDEFName(entityBase3.getPSDEFieldName());
                pSDEFormDetailService.create(entityBase);
            }
            pSDEFormDetail3 = new PSDEFormDetail();
            pSDEFormDetail3.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEFormDetail3.setPSDEFormDetailName("group2");
            pSDEFormDetail3.setPPSDEFormDetailId(pSDEFormDetail2.getPSDEFormDetailId());
            pSDEFormDetail3.setDetailType("GROUPPANEL");
            pSDEFormDetail3.setOrderValue(2);
            pSDEFormDetail3.setCaption("\u64cd\u4f5c\u4fe1\u606f");
            pSDEFormDetailService.create(pSDEFormDetail3);
            entityBase = (PSDEField)hashMap.get("CREATEMAN");
            if (entityBase != null) {
                pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
                pSDEFormDetail.setPSDEFormDetailName(entityBase.getPSDEFieldName().toLowerCase());
                pSDEFormDetail.setPPSDEFormDetailId(pSDEFormDetail3.getPSDEFormDetailId());
                pSDEFormDetail.setDetailType("FORMITEM");
                pSDEFormDetail.setOrderValue(1);
                pSDEFormDetail.setPSDEFId(entityBase.getPSDEFieldId());
                pSDEFormDetail.setPSDEFName(entityBase.getPSDEFieldName());
                pSDEFormDetailService.create(pSDEFormDetail);
            }
            if ((entityBase = (PSDEField)hashMap.get("CREATEDATE")) != null) {
                pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
                pSDEFormDetail.setPSDEFormDetailName(entityBase.getPSDEFieldName().toLowerCase());
                pSDEFormDetail.setPPSDEFormDetailId(pSDEFormDetail3.getPSDEFormDetailId());
                pSDEFormDetail.setDetailType("FORMITEM");
                pSDEFormDetail.setOrderValue(2);
                pSDEFormDetail.setPSDEFId(entityBase.getPSDEFieldId());
                pSDEFormDetail.setPSDEFName(entityBase.getPSDEFieldName());
                pSDEFormDetailService.create(pSDEFormDetail);
            }
            if ((entityBase = (PSDEField)hashMap.get("UPDATEMAN")) != null) {
                pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
                pSDEFormDetail.setPSDEFormDetailName(entityBase.getPSDEFieldName().toLowerCase());
                pSDEFormDetail.setPPSDEFormDetailId(pSDEFormDetail3.getPSDEFormDetailId());
                pSDEFormDetail.setDetailType("FORMITEM");
                pSDEFormDetail.setOrderValue(3);
                pSDEFormDetail.setPSDEFId(entityBase.getPSDEFieldId());
                pSDEFormDetail.setPSDEFName(entityBase.getPSDEFieldName());
                pSDEFormDetailService.create(pSDEFormDetail);
            }
            if ((entityBase = (PSDEField)hashMap.get("UPDATEDATE")) != null) {
                pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
                pSDEFormDetail.setPSDEFormDetailName(entityBase.getPSDEFieldName().toLowerCase());
                pSDEFormDetail.setPPSDEFormDetailId(pSDEFormDetail3.getPSDEFormDetailId());
                pSDEFormDetail.setDetailType("FORMITEM");
                pSDEFormDetail.setOrderValue(4);
                pSDEFormDetail.setPSDEFId(entityBase.getPSDEFieldId());
                pSDEFormDetail.setPSDEFName(entityBase.getPSDEFieldName());
                pSDEFormDetailService.create(pSDEFormDetail);
            }
        }
    }

    protected void initDefaultMobSearchForm(PSDataEntity pSDataEntity) throws Exception {
        String string = null;
        string = this.isEnableFolderKey((IEntity)pSDataEntity) ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_MOBSEARCHFORM) : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"SEARCHFORM", (String)"MOB");
        PSDEForm pSDEForm = new PSDEForm();
        pSDEForm.setPSDEFormId(string);
        if (this.checkKey(pSDEForm) == 0) {
            Object object;
            pSDEForm.reset();
            pSDEForm.setFormType("SEARCHFORM");
            pSDEForm.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEForm.setCodeName("MobDef");
            if (this.selectOne((IEntity)pSDEForm, true)) {
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
                object = new PSDEForm();
                ((PSDEFormBase)object).setPSDEId(pSDataEntity.getPSDataEntityId());
                ((PSDEFormBase)object).setCodeName(string2);
            } while (this.select(object, true));
            pSDEForm.setMobFlag(1);
            pSDEForm.setCodeName(string2);
            pSDEForm.setPSDEFormName("\u79fb\u52a8\u7aef\u641c\u7d22\u8868\u5355");
            this.create(pSDEForm);
            object = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEFormDetail pSDEFormDetail = new PSDEFormDetail();
            pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEFormDetail.setPSDEFormDetailName("formpage1");
            pSDEFormDetail.setCaption("\u5e38\u89c4\u6761\u4ef6");
            pSDEFormDetail.setDetailType("FORMPAGE");
            pSDEFormDetail.setOrderValue(1);
            pSDEFormDetail.setShowCaption(0);
            ((PSCoreSysServiceBaseBase)((Object)object)).create(pSDEFormDetail);
        }
    }

    protected void initDefaultFormDetail(PSDataEntity pSDataEntity, PSDEForm pSDEForm, boolean bl) throws Exception {
        if (StringHelper.compare((String)pSDEForm.getFormType(), (String)"EDITFORM", (boolean)true) == 0) {
            this.initDefaultEditFormDetail(pSDataEntity, pSDEForm, bl);
        }
    }

    protected void initDefaultEditFormDetail(PSDataEntity pSDataEntity, PSDEForm pSDEForm, boolean bl) throws Exception {
        PSDEFormDetail pSDEFormDetail;
        EntityBase entityBase;
        Object object;
        Serializable serializable;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        PSDEField pSDEField = null;
        HashMap<String, PSDEField> hashMap = new HashMap<String, PSDEField>();
        if (pSDataEntity != null) {
            pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            serializable = ((PSDEFieldServiceBase)pSCoreSysServiceBase).selectByPSDE(pSDataEntity);
            object = ((ArrayList)serializable).iterator();
            while (object.hasNext()) {
                entityBase = (PSDEField)object.next();
                hashMap.put(entityBase.getPSDEFieldName(), (PSDEField)entityBase);
                if (!DataObject.getBoolValue((Integer)entityBase.getMajorField(), (boolean)false)) continue;
                pSDEField = entityBase;
            }
        }
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        serializable = new PSDEFormDetail();
        ((PSDEFormDetailBase)serializable).setPSDEFormId(pSDEForm.getPSDEFormId());
        ((PSDEFormDetailBase)serializable).setPSDEFormDetailName("formpage1");
        ((PSDEFormDetailBase)serializable).setDetailType("FORMPAGE");
        ((PSDEFormDetailBase)serializable).setOrderValue(1);
        ((PSDEFormDetailBase)serializable).setCaption("\u57fa\u672c\u4fe1\u606f");
        if (bl) {
            pSCoreSysServiceBase.createTemp(serializable);
        } else {
            pSCoreSysServiceBase.create(serializable);
        }
        object = new PSDEFormDetail();
        ((PSDEFormDetailBase)object).setPSDEFormId(pSDEForm.getPSDEFormId());
        ((PSDEFormDetailBase)object).setPSDEFormDetailName("group1");
        ((PSDEFormDetailBase)object).setPPSDEFormDetailId(((PSDEFormDetailBase)serializable).getPSDEFormDetailId());
        ((PSDEFormDetailBase)object).setDetailType("GROUPPANEL");
        ((PSDEFormDetailBase)object).setOrderValue(1);
        if (pSDataEntity != null) {
            ((PSDEFormDetailBase)object).setCaption(StringHelper.format((String)"%1$s\u57fa\u672c\u4fe1\u606f", (Object)pSDataEntity.getLogicName()));
        } else {
            ((PSDEFormDetailBase)object).setCaption(StringHelper.format((String)"\u57fa\u672c\u4fe1\u606f"));
        }
        ((PSDEFormDetailBase)object).setColModel("50%;50%");
        if (bl) {
            pSCoreSysServiceBase.createTemp(object);
        } else {
            pSCoreSysServiceBase.create(object);
        }
        if (pSDEField != null) {
            entityBase = new PSDEFormDetail();
            entityBase.setPSDEFormId(pSDEForm.getPSDEFormId());
            entityBase.setPSDEFormDetailName(pSDEField.getPSDEFieldName().toLowerCase());
            entityBase.setPPSDEFormDetailId(((PSDEFormDetailBase)object).getPSDEFormDetailId());
            entityBase.setDetailType("FORMITEM");
            entityBase.setOrderValue(1);
            entityBase.setPSDEFId(pSDEField.getPSDEFieldId());
            entityBase.setPSDEFName(pSDEField.getPSDEFieldName());
            if (bl) {
                pSCoreSysServiceBase.createTemp(entityBase);
            } else {
                pSCoreSysServiceBase.create(entityBase);
            }
        }
        serializable = new PSDEFormDetail();
        ((PSDEFormDetailBase)serializable).setPSDEFormId(pSDEForm.getPSDEFormId());
        ((PSDEFormDetailBase)serializable).setPSDEFormDetailName("formpage2");
        ((PSDEFormDetailBase)serializable).setDetailType("FORMPAGE");
        ((PSDEFormDetailBase)serializable).setOrderValue(2);
        ((PSDEFormDetailBase)serializable).setCaption("\u5176\u5b83");
        if (bl) {
            pSCoreSysServiceBase.createTemp(serializable);
        } else {
            pSCoreSysServiceBase.create(serializable);
        }
        object = new PSDEFormDetail();
        ((PSDEFormDetailBase)object).setPSDEFormId(pSDEForm.getPSDEFormId());
        ((PSDEFormDetailBase)object).setPSDEFormDetailName("group2");
        ((PSDEFormDetailBase)object).setPPSDEFormDetailId(((PSDEFormDetailBase)serializable).getPSDEFormDetailId());
        ((PSDEFormDetailBase)object).setDetailType("GROUPPANEL");
        ((PSDEFormDetailBase)object).setOrderValue(2);
        ((PSDEFormDetailBase)object).setCaption("\u64cd\u4f5c\u4fe1\u606f");
        ((PSDEFormDetailBase)object).setColModel("50%;50%");
        if (bl) {
            pSCoreSysServiceBase.createTemp(object);
        } else {
            pSCoreSysServiceBase.create(object);
        }
        entityBase = (PSDEField)hashMap.get("CREATEMAN");
        if (entityBase != null) {
            pSDEFormDetail = new PSDEFormDetail();
            pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEFormDetail.setPSDEFormDetailName(entityBase.getPSDEFieldName().toLowerCase());
            pSDEFormDetail.setPPSDEFormDetailId(((PSDEFormDetailBase)object).getPSDEFormDetailId());
            pSDEFormDetail.setDetailType("FORMITEM");
            pSDEFormDetail.setOrderValue(1);
            pSDEFormDetail.setPSDEFId(entityBase.getPSDEFieldId());
            pSDEFormDetail.setPSDEFName(entityBase.getPSDEFieldName());
            if (bl) {
                pSCoreSysServiceBase.createTemp(pSDEFormDetail);
            } else {
                pSCoreSysServiceBase.create(pSDEFormDetail);
            }
        }
        if ((entityBase = (PSDEField)hashMap.get("CREATEDATE")) != null) {
            pSDEFormDetail = new PSDEFormDetail();
            pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEFormDetail.setPSDEFormDetailName(entityBase.getPSDEFieldName().toLowerCase());
            pSDEFormDetail.setPPSDEFormDetailId(((PSDEFormDetailBase)object).getPSDEFormDetailId());
            pSDEFormDetail.setDetailType("FORMITEM");
            pSDEFormDetail.setOrderValue(2);
            pSDEFormDetail.setPSDEFId(entityBase.getPSDEFieldId());
            pSDEFormDetail.setPSDEFName(entityBase.getPSDEFieldName());
            if (bl) {
                pSCoreSysServiceBase.createTemp(pSDEFormDetail);
            } else {
                pSCoreSysServiceBase.create(pSDEFormDetail);
            }
        }
        if ((entityBase = (PSDEField)hashMap.get("UPDATEMAN")) != null) {
            pSDEFormDetail = new PSDEFormDetail();
            pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEFormDetail.setPSDEFormDetailName(entityBase.getPSDEFieldName().toLowerCase());
            pSDEFormDetail.setPPSDEFormDetailId(((PSDEFormDetailBase)object).getPSDEFormDetailId());
            pSDEFormDetail.setDetailType("FORMITEM");
            pSDEFormDetail.setOrderValue(3);
            pSDEFormDetail.setPSDEFId(entityBase.getPSDEFieldId());
            pSDEFormDetail.setPSDEFName(entityBase.getPSDEFieldName());
            if (bl) {
                pSCoreSysServiceBase.createTemp(pSDEFormDetail);
            } else {
                pSCoreSysServiceBase.create(pSDEFormDetail);
            }
        }
        if ((entityBase = (PSDEField)hashMap.get("UPDATEDATE")) != null) {
            pSDEFormDetail = new PSDEFormDetail();
            pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
            pSDEFormDetail.setPSDEFormDetailName(entityBase.getPSDEFieldName().toLowerCase());
            pSDEFormDetail.setPPSDEFormDetailId(((PSDEFormDetailBase)object).getPSDEFormDetailId());
            pSDEFormDetail.setDetailType("FORMITEM");
            pSDEFormDetail.setOrderValue(4);
            pSDEFormDetail.setPSDEFId(entityBase.getPSDEFieldId());
            pSDEFormDetail.setPSDEFName(entityBase.getPSDEFieldName());
            if (bl) {
                pSCoreSysServiceBase.createTemp(pSDEFormDetail);
            } else {
                pSCoreSysServiceBase.create(pSDEFormDetail);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEForm pSDEForm, XmlNode xmlNode) throws Exception {
        Object object;
        Object object2;
        Iterator iterator;
        HashMap<Object, XmlNode> hashMap = new HashMap<Object, XmlNode>();
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEFIUPDATES");
        if (xmlNode2 != null && (iterator = xmlNode2.getChildNodes()) != null) {
            while (iterator.hasNext()) {
                object2 = (XmlNode)iterator.next();
                object = object2.getChildNodeByNodeName("PSDEFIDETAILS");
                if (object == null) continue;
                hashMap.put(object2, (XmlNode)object);
                object2.removeNode((XmlNode)object);
            }
        }
        this.importRelatedXmlModel_PSDEFIUpdate(pSDEForm, xmlNode2);
        iterator = xmlNode.getChildNodeByNodeName("PSDEFORMDETAILS");
        this.importRelatedXmlModel_PSDEFormDetail(pSDEForm, (XmlNode)iterator);
        if (xmlNode2 != null && (object2 = xmlNode2.getChildNodes()) != null) {
            object = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
            while (object2.hasNext()) {
                Iterator iterator2;
                XmlNode xmlNode3 = (XmlNode)object2.next();
                XmlNode xmlNode4 = (XmlNode)hashMap.get(xmlNode3);
                if (xmlNode4 == null || (iterator2 = xmlNode4.getChildNodes()) == null) continue;
                while (iterator2.hasNext()) {
                    XmlNode xmlNode5 = (XmlNode)iterator2.next();
                    PSDEFIUDetail pSDEFIUDetail = new PSDEFIUDetail();
                    object.fillParentInfo((IEntity)pSDEFIUDetail, "DER1N", "DER1N_PSDEFIUDETAIL_PSDEFIUPDATE_PSDEFIUPDATEID", xmlNode3.getAttribute("PSDEFIUPDATEID", ""));
                    ((PSCoreSysServiceBase)object).importXmlModel(pSDEFIUDetail, xmlNode5);
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
            this.getTemp((IEntity)pSDEForm);
            string = (String)EntityBase.getOriginKey((IEntity)pSDEForm);
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
            ArrayList arrayList2 = pSAppDEViewService.selectByPSDEViewBase(pSDEViewCtrl.getPSDEViewBase());
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
        Object object = EntityBase.getOriginKey((IEntity)pSDEForm);
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
    protected void onImportModelV2(boolean bl, PSDEForm pSDEForm, ArrayList<PSCoreSysServiceBase.ModelV2> arrayList) throws Exception {
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
                for (PSCoreSysServiceBase.ModelV2 modelV2 : arrayList) {
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
        EntityBase entityBase;
        EntityBase entityBase2;
        Serializable serializable;
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFormDetail> arrayList = pSDEFormDetailService.selectByPSDEForm(pSDEForm2);
        ArrayList<PSDEFDLogic> arrayList2 = pSDEFDLogicService.selectByPSDEForm(pSDEForm2);
        try {
            serializable = new PSDEFormDetail();
            ((PSDEFormDetailBase)serializable).setPSDEFormDetailId(KeyValueHelper.genUniqueId((String)pSDEForm.getPSDEFormId(), (String)"formpage1"));
            if (pSDEFormDetailService.checkKey(serializable) == 1) {
                pSDEFormDetailService.remove((IEntity)serializable);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        serializable = new HashMap();
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
            EntityBase.setIgnoreCheck((IEntity)pSDEFormDetail, (boolean)true);
            EntityBase.setIgnoreCheckKey((IEntity)pSDEFormDetail, (boolean)true);
            pSDEFormDetailService.create(pSDEFormDetail, false);
            hashMap.put(iterator.getPSDEFormDetailId(), pSDEFormDetail);
        }
        HashMap hashMap2 = new HashMap();
        for (PSDEFDLogic pSDEFDLogic : arrayList2) {
            entityBase2 = new PSDEFDLogic();
            pSDEFDLogic.copyTo((IDataObject)entityBase2, false);
            entityBase2.setPSDEFDLogicId(KeyValueHelper.genUniqueId((String)pSDEForm.getPSDEFormId(), (String)pSDEFDLogic.getPSDEFDLogicId()));
            entityBase2.setPPSDEFDLogicId(null);
            entityBase2.setPPSDEFDLogicName(null);
            if (!StringHelper.isNullOrEmpty((String)pSDEFDLogic.getPSDEFormDetailId())) {
                entityBase2.setPSDEFormDetailId(KeyValueHelper.genUniqueId((String)pSDEForm.getPSDEFormId(), (String)pSDEFDLogic.getPSDEFormDetailId()));
            }
            entityBase2.setPSDEFormId(pSDEForm.getPSDEFormId());
            entityBase2.setPSDEFormName(pSDEForm.getPSDEFormName());
            EntityBase.setIgnoreCheck((IEntity)entityBase2, (boolean)true);
            EntityBase.setIgnoreCheckKey((IEntity)entityBase2, (boolean)true);
            pSDEFDLogicService.create(entityBase2, false);
            if (!StringHelper.isNullOrEmpty((String)pSDEFDLogic.getFDName())) {
                hashMap2.put(pSDEFDLogic.getFDName().toLowerCase(), "");
            }
            ((HashMap)serializable).put(pSDEFDLogic.getPSDEFDLogicId(), entityBase2);
        }
        for (PSDEFDLogic pSDEFDLogic : arrayList2) {
            entityBase2 = new PSDEFDLogic();
            if (StringHelper.isNullOrEmpty((String)pSDEFDLogic.getPPSDEFDLogicId())) continue;
            entityBase = (PSDEFDLogic)((HashMap)serializable).get(pSDEFDLogic.getPPSDEFDLogicId());
            entityBase2.setPSDEFDLogicId(KeyValueHelper.genUniqueId((String)pSDEForm.getPSDEFormId(), (String)pSDEFDLogic.getPSDEFDLogicId()));
            if (entityBase != null) {
                entityBase2.setPPSDEFDLogicId(entityBase.getPSDEFDLogicId());
                pSDEFDLogicService.sysUpdate(entityBase2, false);
                continue;
            }
            log.error((Object)StringHelper.format((String)"\u8868\u5355\u9879\u903b\u8f91[%1$s]\u7236[%2$s]\u65e0\u6548", (Object)pSDEFDLogic.getPSDEFDLogicId(), (Object)pSDEFDLogic.getPPSDEFDLogicId()));
        }
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            entityBase2 = new PSDEFormDetail();
            entityBase2.setPSDEFormDetailId(KeyValueHelper.genUniqueId((String)pSDEForm.getPSDEFormId(), (String)pSDEFormDetail.getPSDEFormDetailId()));
            if (!StringHelper.isNullOrEmpty((String)pSDEFormDetail.getPPSDEFormDetailId())) {
                entityBase = (PSDEFormDetail)hashMap.get(pSDEFormDetail.getPPSDEFormDetailId());
                if (entityBase != null) {
                    entityBase2.setPPSDEFormDetailId(entityBase.getPSDEFormDetailId());
                } else {
                    log.error((Object)StringHelper.format((String)"\u8868\u5355\u9879[%1$s]\u7236[%2$s]\u65e0\u6548", (Object)pSDEFormDetail.getPSDEFormDetailId(), (Object)pSDEFormDetail.getPPSDEFormDetailId()));
                    continue;
                }
            }
            if (StringHelper.compare((String)pSDEFormDetail.getDetailType(), (String)"GROUPPANEL", (boolean)false) == 0) {
                entityBase2.setChild_Col_LG(null);
                entityBase2.setChild_Col_MD(null);
                entityBase2.setChild_Col_SM(null);
                entityBase2.setChild_Col_XS(null);
                entityBase2.setEnableCond(null);
            }
            entityBase2.setCol_LG(null);
            entityBase2.setCol_MD(null);
            entityBase2.setCol_SM(null);
            entityBase2.setCol_XS(null);
            entityBase2.setPSDEFUIModeId(null);
            if (hashMap2.containsKey(pSDEFormDetail.getPSDEFormDetailName().toLowerCase())) {
                entityBase2.setEditorType("HIDDEN");
                entityBase = new PSDEFormDetail();
                pSDEFormDetail.copyTo((IDataObject)entityBase, false);
                entityBase.setPSDEFormDetailId(KeyValueHelper.genUniqueId((String)pSDEForm.getPSDEFormId(), (String)pSDEFormDetail.getPSDEFormDetailId(), (String)"mostext"));
                entityBase.setPSDEFormDetailName(pSDEFormDetail.getPSDEFormDetailName() + "_mostext");
                entityBase.setPSDEFUIModeId(null);
                entityBase.setPSDEFIUpdateId(null);
                entityBase.setPSDEFIUpdateName(null);
                entityBase.setResetItemName(null);
                if (!StringHelper.isNullOrEmpty((String)pSDEFormDetail.getPPSDEFormDetailId())) {
                    entityBase.setPPSDEFormDetailId(KeyValueHelper.genUniqueId((String)pSDEForm.getPSDEFormId(), (String)pSDEFormDetail.getPPSDEFormDetailId()));
                }
                entityBase.setPSDEFormId(pSDEForm.getPSDEFormId());
                entityBase.setPSDEFormName(pSDEForm.getPSDEFormName());
                EntityBase.setIgnoreCheck((IEntity)entityBase, (boolean)true);
                EntityBase.setIgnoreCheckKey((IEntity)entityBase, (boolean)true);
                pSDEFormDetailService.create(entityBase, false);
            } else if (!StringHelper.isNullOrEmpty((String)pSDEFormDetail.getEditorType()) && StringHelper.compare((String)pSDEFormDetail.getEditorType(), (String)"HIDDEN", (boolean)true) != 0) {
                entityBase2.setEditorType(null);
            }
            pSDEFormDetailService.sysUpdate(entityBase2, false);
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
        ArrayList arrayList = pSDEFormDetailService.select((ISelectCond)selectCond);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = new PSDEFormDetail();
            pSDEFormDetail2.setPSDEFormDetailId(KeyValueHelper.genUniqueId((String)pSDEForm.getPSDEFormId(), (String)pSDEFormDetail.getPSDEFormDetailId()));
        }
    }
}

