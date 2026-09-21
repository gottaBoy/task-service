/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ActionSession
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.PSCoreSysServiceBaseBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewService;
import net.ibizsys.pscore.srv.config.entity.PSVTCtrl;
import net.ibizsys.pscore.srv.config.entity.PSVTCtrlBase;
import net.ibizsys.pscore.srv.config.entity.PSVTRV;
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeStruct;
import net.ibizsys.pscore.srv.config.service.PSViewTypeService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRDetailBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataRelation;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataRelationBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEList;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewEngine;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewLogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewRV;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewRVBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewEngineService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewEngineServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewRVService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.service.IPSModelService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTViewBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPDTViewService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDEInitCfg;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersionBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEViewBaseService
extends PSDEViewBaseServiceBase
implements IPSModelService<PSDEViewBase> {
    private static final Log log = LogFactory.getLog(PSDEViewBaseService.class);
    private static final String[] initViewTypes = new String[]{"DEEDITVIEW", "DEEDITVIEW2", "DEGRIDVIEW", "DEINDEXPICKUPDATAVIEW", "DEFORMPICKUPDATAVIEW", "DEPICKUPGRIDVIEW", "DEPICKUPVIEW", "DEMPICKUPVIEW", "DEREDIRECTVIEW"};
    private static final String[] initMobViewTypes = new String[]{"DEMOBEDITVIEW", "DEMOBMDVIEW", "DEMOBINDEXPICKUPMDVIEW", "DEMOBFORMPICKUPMDVIEW", "DEMOBPICKUPMDVIEW", "DEMOBPICKUPVIEW", "DEMOBMPICKUPVIEW", "DEMOBREDIRECTVIEW"};
    private static final String[] initWFViewTypes = new String[]{"DEWFEXPVIEW", "DEWFGRIDVIEW", "DEWFEDITVIEW3"};
    private static final String[] initMobWFViewTypes = new String[]{"DEMOBWFMDVIEW", "DEMOBWFEDITVIEW"};
    private static final String[] initMSViewTypes = new String[]{"DEEDITVIEW3"};
    protected static final String LOGNAME_INITWFVIEW = "\u521d\u59cb\u5316\u6d41\u7a0b\u89c6\u56fe";
    public static final String XMLNODE_DEVIEWCONFIG = "DEVIEWCONFIG";
    public static final String XMLNODE_DEVIEWCTRL = "DEVIEWCTRL";
    public static final String XMLNODE_DEVIEWRV = "DEVIEWRV";
    public static final String XMLNODE_DEVIEWLOGIC = "DEVIEWLOGIC";
    public static final String XMLNODE_DEVIEWENGINE = "DEVIEWENGINE";

    @Override
    protected void onFillParentInfo_PSDE(PSDEViewBase pSDEViewBase, PSDataEntity pSDataEntity) throws Exception {
        super.onFillParentInfo_PSDE(pSDEViewBase, pSDataEntity);
        pSDEViewBase.setPSSystemId(pSDataEntity.getPSSystemId());
        pSDEViewBase.setPSSystemName(pSDataEntity.getPSSystemName());
    }

    @Override
    protected void onAfterGetDraftTemp(PSDEViewBase pSDEViewBase) throws Exception {
        EntityBase entityBase;
        String string = pSDEViewBase.getPSDEViewBaseType();
        PSViewType pSViewType = new PSViewType();
        pSViewType.setPSViewTypeId(string);
        PSViewTypeService pSViewTypeService = (PSViewTypeService)ServiceGlobal.getService(PSViewTypeService.class);
        pSViewTypeService.getCache((IEntity)pSViewType);
        if (pSDEViewBase.getPSDE() != null) {
            if (StringHelper.isNullOrEmpty((String)pSDEViewBase.getPSDEViewBaseName())) {
                pSDEViewBase.setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s", (Object)pSDEViewBase.getPSDE().getLogicName(), (Object)pSViewType.getPSViewTypeName()));
            }
            if (StringHelper.isNullOrEmpty((String)pSDEViewBase.getTitle()) && !StringHelper.isNullOrEmpty((String)pSViewType.getTitle())) {
                pSDEViewBase.setTitle(StringHelper.format((String)"%1$s%2$s", (Object)pSDEViewBase.getPSDE().getLogicName(), (Object)pSViewType.getTitle()));
            }
        }
        if (StringHelper.isNullOrEmpty((String)pSDEViewBase.getCodeName())) {
            pSDEViewBase.setCodeName(pSViewType.getCodeName());
        }
        PSDEViewRVService pSDEViewRVService = (PSDEViewRVService)ServiceGlobal.getService(PSDEViewRVService.class, (SessionFactory)this.getSessionFactory());
        PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        PSDataEntity pSDataEntity = pSDEViewBase.getPSDE();
        PSViewTypeStruct pSViewTypeStruct = PSModelGlobal.getPSViewType(string);
        ArrayList<PSVTRV> arrayList = pSViewType.getPSVTRVs();
        for (PSVTRV object2 : arrayList) {
            if (!DataObject.getBoolValue((Integer)object2.getValidFlag(), (boolean)true) || !DataObject.getBoolValue((Integer)object2.getDefaultFlag(), (boolean)true)) continue;
            entityBase = new PSDEViewRV();
            entityBase.setMajorPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
            entityBase.setMajorPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
            entityBase.setPSDEViewRVName(object2.getPSVTRVName());
            if (pSDEViewRVService.checkKeyTemp((IEntity)entityBase) != 0) continue;
            entityBase.setDefViewType(object2.getDEFViewType());
            entityBase.setMemo(object2.getMemo());
            entityBase.setRefModeText(object2.getLogicName());
            if (pSDataEntity != null) {
                this.fillDEViewRV((PSDEViewRV)entityBase, pSDataEntity.getPSSystem(), pSDataEntity, pSViewTypeStruct, pSDEViewBase, object2, null, null);
            }
            pSDEViewRVService.createTemp(entityBase);
        }
        ArrayList<PSVTCtrl> arrayList2 = pSViewType.getPSVTCtrls();
        Iterator iterator = arrayList2.iterator();
        while (iterator.hasNext()) {
            entityBase = (PSVTCtrl)iterator.next();
            if (!DataObject.getBoolValue((Integer)entityBase.getValidFlag(), (boolean)true)) continue;
            PSDEViewCtrl pSDEViewCtrl = new PSDEViewCtrl();
            pSDEViewCtrl.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            pSDEViewCtrl.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
            pSDEViewCtrl.setPSDEViewCtrlName(entityBase.getPSVTCtrlName());
            pSDEViewCtrl.setPSDEViewCtrlType(entityBase.getCtrlType());
            if (entityBase.getDefaultFlag() != null) {
                pSDEViewCtrl.setDefaultFlag(entityBase.getDefaultFlag());
            } else {
                pSDEViewCtrl.setDefaultFlag(1);
            }
            this.fillDEViewCtrlParams(pSDEViewCtrl, (PSVTCtrl)entityBase);
            if (entityBase.getOrderValue() != null) {
                pSDEViewCtrl.setOrderValue(entityBase.getOrderValue());
            }
            if (entityBase.getEnableViewActions() != null) {
                pSDEViewCtrl.setEnableViewActions(entityBase.getEnableViewActions());
            }
            if (pSDataEntity != null) {
                this.fillDEViewCtrl(pSDEViewCtrl, pSDataEntity.getPSSystem(), pSDataEntity, pSViewTypeStruct, pSDEViewBase, (PSVTCtrl)entityBase, null, null);
            }
            if (pSDEViewCtrlService.checkKeyTemp((IEntity)pSDEViewCtrl) != 0) continue;
            pSDEViewCtrlService.createTemp(pSDEViewCtrl);
        }
        super.onAfterGetDraftTemp(pSDEViewBase);
    }

    @Override
    public void initModel(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            PSViewTypeStruct pSViewTypeStruct;
            PSDataEntity pSDataEntity = new PSDataEntity();
            pSDataEntity.proxy((IDataObject)iEntity);
            PSDEInitCfg pSDEInitCfg = PSModelGlobal.getPSDEInitCfg(pSDataEntity.getPSDataEntityId(), this.getSessionFactory());
            if (pSDEInitCfg != null && DataObject.getBoolValue((Integer)pSDEInitCfg.getIgnoreUIModel(), (boolean)false)) {
                return;
            }
            for (String string3 : initViewTypes) {
                pSViewTypeStruct = PSModelGlobal.getPSViewType(string3);
                this.initDEView(pSDataEntity, pSViewTypeStruct);
            }
            if (DataObject.getBoolValue((Integer)pSDataEntity.getEnableMob(), (boolean)false)) {
                for (String string3 : initMobViewTypes) {
                    pSViewTypeStruct = PSModelGlobal.getPSViewType(string3);
                    this.initDEView(pSDataEntity, pSViewTypeStruct);
                }
            }
            this.initDEWFViews(pSDataEntity);
            return;
        }
    }

    protected void initDEView(PSDataEntity pSDataEntity, PSViewTypeStruct pSViewTypeStruct) throws Exception {
        PSDEViewBase pSDEViewBase;
        String string;
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEINDEXPICKUPDATAVIEW", (boolean)true) == 0) {
            String string2 = pSDataEntity.getIndexDEType();
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                this.initDEView(pSDataEntity, pSViewTypeStruct, "INDEXDETYPE", string2, null, null, null);
            }
            return;
        }
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEFORMPICKUPDATAVIEW", (boolean)true) == 0) {
            if (DataObject.getIntegerValue((Object)pSDataEntity.getEnaMultiForm(), (Integer)0) > 0) {
                this.initDEView(pSDataEntity, pSViewTypeStruct, "FORMTYPE", "", null, null, null);
            }
            return;
        }
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEMOBINDEXPICKUPMDVIEW", (boolean)true) == 0) {
            String string3 = pSDataEntity.getIndexDEType();
            if (!StringHelper.isNullOrEmpty((String)string3)) {
                this.initDEView(pSDataEntity, pSViewTypeStruct, "INDEXDETYPE", string3, null, null, null);
            }
            return;
        }
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEMOBFORMPICKUPMDVIEW", (boolean)true) == 0) {
            if (DataObject.getIntegerValue((Object)pSDataEntity.getEnaMultiForm(), (Integer)0) > 0) {
                this.initDEView(pSDataEntity, pSViewTypeStruct, "FORMTYPE", "", null, null, null);
            }
            return;
        }
        String string4 = "";
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEREDIRECTVIEW", (boolean)true) == 0) {
            string4 = "REDIRECTVIEW";
        }
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEEDITVIEW", (boolean)true) == 0) {
            string4 = "EDITVIEW";
        }
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEGRIDVIEW", (boolean)true) == 0) {
            string4 = "MDATAVIEW";
        }
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEPICKUPVIEW", (boolean)true) == 0) {
            string4 = "PICKUPVIEW";
        }
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEMPICKUPVIEW", (boolean)true) == 0) {
            string4 = "MPICKUPVIEW";
        }
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEMOBREDIRECTVIEW", (boolean)true) == 0) {
            string4 = "MOBREDIRECTVIEW";
        }
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEMOBEDITVIEW", (boolean)true) == 0) {
            string4 = "MOBEDITVIEW";
        }
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEMOBMDVIEW", (boolean)true) == 0) {
            string4 = "MOBMDATAVIEW";
        }
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEMOBPICKUPVIEW", (boolean)true) == 0) {
            string4 = "MOBPICKUPVIEW";
        }
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEMOBMPICKUPVIEW", (boolean)true) == 0) {
            string4 = "MOBMPICKUPVIEW";
        }
        this.initDEView(pSDataEntity, pSViewTypeStruct, "", "", null, string4, null);
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEPICKUPVIEW", (boolean)true) == 0) {
            string = pSDataEntity.getIndexDEType();
            if (!StringHelper.isNullOrEmpty((String)string)) {
                pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseName(StringHelper.format((String)"%1$s(\u7d22\u5f15\u5b9e\u4f53)%2$s", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getPSViewTypeName()));
                if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                    pSDEViewBase.setTitle(StringHelper.format((String)"%1$s%2$s", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getTitle()));
                }
                pSDEViewBase.setCodeName("Index" + pSViewTypeStruct.getCodeName());
                this.initDEView(pSDataEntity, pSViewTypeStruct, "INDEXDETYPE", string, pSDEViewBase, "INDEXDEPICKUPVIEW", null);
            }
            if (DataObject.getIntegerValue((Object)pSDataEntity.getEnaMultiForm(), (Integer)0) > 0) {
                pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseName(StringHelper.format((String)"%1$s(\u8868\u5355\u7c7b\u578b)%2$s", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getPSViewTypeName()));
                if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                    pSDEViewBase.setTitle(StringHelper.format((String)"%1$s%2$s", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getTitle()));
                }
                pSDEViewBase.setCodeName("Form" + pSViewTypeStruct.getCodeName());
                this.initDEView(pSDataEntity, pSViewTypeStruct, "FORMTYPE", "", pSDEViewBase, "FORMPICKUPVIEW", null);
            }
        }
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEMOBPICKUPVIEW", (boolean)true) == 0) {
            string = pSDataEntity.getIndexDEType();
            if (!StringHelper.isNullOrEmpty((String)string)) {
                pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseName(StringHelper.format((String)"%1$s(\u7d22\u5f15\u5b9e\u4f53)%2$s", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getPSViewTypeName()));
                if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                    pSDEViewBase.setTitle(StringHelper.format((String)"%1$s%2$s", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getTitle()));
                }
                pSDEViewBase.setCodeName("MobIndex" + pSViewTypeStruct.getCodeName());
                this.initDEView(pSDataEntity, pSViewTypeStruct, "INDEXDETYPE", string, pSDEViewBase, "MOBINDEXDEPICKUPVIEW", null);
            }
            if (DataObject.getIntegerValue((Object)pSDataEntity.getEnaMultiForm(), (Integer)0) > 0) {
                pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseName(StringHelper.format((String)"%1$s(\u8868\u5355\u7c7b\u578b)%2$s", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getPSViewTypeName()));
                if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                    pSDEViewBase.setTitle(StringHelper.format((String)"%1$s%2$s", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getTitle()));
                }
                pSDEViewBase.setCodeName("MobForm" + pSViewTypeStruct.getCodeName());
                this.initDEView(pSDataEntity, pSViewTypeStruct, "FORMTYPE", "", pSDEViewBase, "MOBFORMPICKUPVIEW", null);
            }
        }
    }

    protected PSDEViewBase initDEView(PSDataEntity pSDataEntity, PSViewTypeStruct pSViewTypeStruct, String string, String string2, PSDEViewBase pSDEViewBase, String string3, String string4) throws Exception {
        Object object;
        Serializable serializable;
        String string5;
        boolean bl = this.isEnableFolderKey((IEntity)pSDataEntity);
        PSDEViewBase pSDEViewBase2 = new PSDEViewBase();
        boolean bl2 = false;
        if (bl) {
            string5 = "";
            string5 = StringHelper.isNullOrEmpty((String)string) ? KeyValueHelper.genUniqueId((String)pSViewTypeStruct.getPSViewTypeId()) : KeyValueHelper.genUniqueId((String)pSViewTypeStruct.getPSViewTypeId(), (String)string, (String)string2);
            pSDEViewBase2.setDEViewTag(string5);
            pSDEViewBase2.setPSDEId(pSDataEntity.getPSDataEntityId());
            bl2 = !this.selectOne((IEntity)pSDEViewBase2, true);
        } else {
            string5 = "";
            string5 = StringHelper.isNullOrEmpty((String)string) ? KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)pSViewTypeStruct.getPSViewTypeId()) : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)pSViewTypeStruct.getPSViewTypeId(), (String)string, (String)string2);
            pSDEViewBase2.setPSDEViewBaseId(string5);
            if (this.get((IEntity)pSDEViewBase2, true)) {
                if (!StringHelper.isNullOrEmpty((String)string)) {
                    if (StringHelper.isNullOrEmpty((String)pSDEViewBase2.getDEViewTag3())) {
                        pSDEViewBase2.setDEViewTag3(string);
                        pSDEViewBase2.setDEViewTag4(string2);
                        this.update(pSDEViewBase2);
                    }
                } else if (!StringHelper.isNullOrEmpty((String)pSDEViewBase2.getDEViewTag3())) {
                    pSDEViewBase2.setDEViewTag3(string);
                    pSDEViewBase2.setDEViewTag4(string2);
                    this.update(pSDEViewBase2);
                }
            } else {
                pSDEViewBase2.reset();
                SelectCond selectCond = new SelectCond();
                selectCond.setFetchFirst(true);
                selectCond.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
                selectCond.set("PSDEVIEWBASETYPE", (Object)pSViewTypeStruct.getPSViewTypeId());
                if (StringHelper.isNullOrEmpty((String)string)) {
                    selectCond.setIsNull("DEVIEWTAG3");
                    selectCond.setIsNull("DEVIEWTAG4");
                } else {
                    selectCond.set("DEVIEWTAG3", (Object)string);
                    if (!StringHelper.isNullOrEmpty((String)string2)) {
                        selectCond.set("DEVIEWTAG4", (Object)string2);
                    } else {
                        selectCond.setIsNull("DEVIEWTAG4");
                    }
                }
                serializable = this.select((ISelectCond)selectCond);
                if (((ArrayList)serializable).size() == 0) {
                    object = pSViewTypeStruct.getCodeName();
                    if (pSDEViewBase != null && !StringHelper.isNullOrEmpty((String)pSDEViewBase.getCodeName())) {
                        object = pSDEViewBase.getCodeName();
                    }
                    if (!StringHelper.isNullOrEmpty((String)object)) {
                        pSDEViewBase2.reset();
                        pSDEViewBase2.setPSDEId(pSDataEntity.getPSDataEntityId());
                        pSDEViewBase2.setPSDEViewBaseType(pSViewTypeStruct.getPSViewTypeId());
                        pSDEViewBase2.setCodeName((String)object);
                        if (this.selectOne((IEntity)pSDEViewBase2, true)) {
                            return pSDEViewBase2;
                        }
                    }
                    pSDEViewBase2.reset();
                    pSDEViewBase2.setPSDEViewBaseId(string5);
                    bl2 = true;
                } else {
                    return (PSDEViewBase)((ArrayList)serializable).get(0);
                }
            }
        }
        if (bl2) {
            Object object2;
            Object object3;
            pSDEViewBase2.setPSSystemId(pSDataEntity.getPSSystemId());
            pSDEViewBase2.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEViewBase2.setPSDEName(pSDataEntity.getPSDataEntityName());
            pSDEViewBase2.setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getPSViewTypeName()));
            if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                pSDEViewBase2.setTitle(StringHelper.format((String)"%1$s%2$s", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getTitle()));
            }
            pSDEViewBase2.setPSDEViewBaseType(pSViewTypeStruct.getPSViewTypeId());
            pSDEViewBase2.setCodeName(pSViewTypeStruct.getCodeName());
            if (pSDEViewBase != null) {
                pSDEViewBase.copyTo((IDataObject)pSDEViewBase2, false);
            }
            string5 = pSDEViewBase2.getCodeName();
            int n = 1;
            do {
                if (n > 1) {
                    string5 = StringHelper.format((String)"Usr%1$s%2$s", (Object)(n == 1 ? "" : Integer.valueOf(n)), (Object)pSDEViewBase2.getCodeName());
                }
                ++n;
                serializable = new PSDEViewBase();
                ((PSDEViewBaseBase)serializable).setPSDEId(pSDataEntity.getPSDataEntityId());
                ((PSDEViewBaseBase)serializable).setCodeName(string5);
            } while (this.select(serializable, true));
            pSDEViewBase2.setCodeName(string5);
            if (!StringHelper.isNullOrEmpty((String)string3)) {
                serializable = new PSDEViewBase();
                ((PSDEViewBaseBase)serializable).setPSDEId(pSDataEntity.getPSDataEntityId());
                ((PSDEViewBaseBase)serializable).setPredefinedViewType(string3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    ((PSDEViewBaseBase)serializable).setPDVTParam(string4);
                }
                if (!this.select(serializable, true)) {
                    pSDEViewBase2.setPredefinedViewType(string3);
                    pSDEViewBase2.setPDVTParam(string4);
                }
            }
            pSDEViewBase2.setDEViewTag3(string);
            pSDEViewBase2.setDEViewTag4(string2);
            try {
                this.create(pSDEViewBase2);
            }
            catch (Exception exception) {
                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5b9e\u4f53\u89c6\u56fe[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)pSDEViewBase2.getPSDEViewBaseName(), (Object)exception.getMessage()), exception);
            }
            serializable = pSDataEntity.getPSSystem();
            object = pSViewTypeStruct.getPSVTCtrls();
            if (object != null) {
                object3 = ((ArrayList)object).iterator();
                while (object3.hasNext()) {
                    object2 = (PSVTCtrl)object3.next();
                    if (!DataObject.getBoolValue((Integer)((PSVTCtrlBase)object2).getValidFlag(), (boolean)true)) continue;
                    try {
                        this.initDEViewCtrl((PSSystem)serializable, pSDataEntity, pSViewTypeStruct, pSDEViewBase2, (PSVTCtrl)object2, string, string2);
                    }
                    catch (Exception exception) {
                        throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5b9e\u4f53\u89c6\u56fe[%1$s]\u90e8\u4ef6[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDEViewBase2.getPSDEViewBaseName(), (Object)((PSVTCtrlBase)object2).getPSVTCtrlName(), (Object)exception.getMessage()), exception);
                    }
                }
            }
            if ((object3 = pSViewTypeStruct.getPSVTRVs()) != null) {
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    PSVTRV pSVTRV = (PSVTRV)object2.next();
                    if (!DataObject.getBoolValue((Integer)pSVTRV.getValidFlag(), (boolean)true) || !DataObject.getBoolValue((Integer)pSVTRV.getDefaultFlag(), (boolean)true)) continue;
                    try {
                        this.initDEViewRV((PSSystem)serializable, pSDataEntity, pSViewTypeStruct, pSDEViewBase2, pSVTRV, string, string2);
                    }
                    catch (Exception exception) {
                        throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5b9e\u4f53\u89c6\u56fe[%1$s]\u89c6\u56fe\u5f15\u7528[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDEViewBase2.getPSDEViewBaseName(), (Object)pSVTRV.getPSVTRVName(), (Object)exception.getMessage()), exception);
                    }
                }
            }
        }
        return pSDEViewBase2;
    }

    protected void initDEViewCtrl(PSSystem pSSystem, PSDataEntity pSDataEntity, PSViewTypeStruct pSViewTypeStruct, PSDEViewBase pSDEViewBase, PSVTCtrl pSVTCtrl, String string, String string2) throws Exception {
        if (!DataObject.getBoolValue((Integer)pSVTCtrl.getValidFlag(), (boolean)true)) {
            return;
        }
        PSDEViewCtrl pSDEViewCtrl = new PSDEViewCtrl();
        pSDEViewCtrl.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSDEViewCtrl.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
        pSDEViewCtrl.setPSDEViewCtrlName(pSVTCtrl.getPSVTCtrlName());
        pSDEViewCtrl.setPSDEViewCtrlType(pSVTCtrl.getCtrlType());
        pSDEViewCtrl.setPSDEId(pSDEViewBase.getPSDEId());
        pSDEViewCtrl.setPSDEName(pSDEViewBase.getPSDEName());
        if (pSVTCtrl.getDefaultFlag() != null) {
            pSDEViewCtrl.setDefaultFlag(pSVTCtrl.getDefaultFlag());
        } else {
            pSDEViewCtrl.setDefaultFlag(1);
        }
        this.fillDEViewCtrlParams(pSDEViewCtrl, pSVTCtrl);
        if (pSVTCtrl.getOrderValue() != null) {
            pSDEViewCtrl.setOrderValue(pSVTCtrl.getOrderValue());
        }
        if (pSVTCtrl.getEnableViewActions() != null) {
            pSDEViewCtrl.setEnableViewActions(pSVTCtrl.getEnableViewActions());
        }
        this.fillDEViewCtrl(pSDEViewCtrl, pSSystem, pSDataEntity, pSViewTypeStruct, pSDEViewBase, pSVTCtrl, string, string2);
        PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        pSDEViewCtrlService.create(pSDEViewCtrl);
        pSDEViewCtrlService.update(pSDEViewCtrl);
    }

    protected void fillDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, PSSystem pSSystem, PSDataEntity pSDataEntity, PSViewTypeStruct pSViewTypeStruct, PSDEViewBase pSDEViewBase, PSVTCtrl pSVTCtrl, String string, String string2) throws Exception {
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"FORM", (boolean)true) == 0) {
            String string3;
            boolean bl = false;
            if (pSViewTypeStruct != null && pSViewTypeStruct.getPSViewTypeId().indexOf("DEMOB") != -1) {
                bl = true;
            }
            if (!StringHelper.isNullOrEmpty((String)(string3 = this.getPSDEEditFormId(pSDataEntity, bl)))) {
                pSDEViewCtrl.setPSDEFormId(string3);
            }
            if (!StringHelper.isNullOrEmpty((String)pSVTCtrl.getPSSysACHandlerId())) {
                pSDEViewCtrl.setPSACHandlerId(this.getPSACHandlerId(pSVTCtrl.getPSSysACHandlerId(), pSSystem));
            }
            return;
        }
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"SEARCHFORM", (boolean)true) == 0) {
            String string4;
            boolean bl = false;
            if (pSViewTypeStruct != null && pSViewTypeStruct.getPSViewTypeId().indexOf("DEMOB") != -1) {
                bl = true;
            }
            if (!StringHelper.isNullOrEmpty((String)(string4 = this.getPSDESearchFormId(pSDataEntity, bl)))) {
                pSDEViewCtrl.setPSDEFormId(string4);
            }
            if (!StringHelper.isNullOrEmpty((String)pSVTCtrl.getPSSysACHandlerId())) {
                pSDEViewCtrl.setPSACHandlerId(this.getPSACHandlerId(pSVTCtrl.getPSSysACHandlerId(), pSSystem));
            }
            return;
        }
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"GRID", (boolean)true) == 0) {
            String string5;
            boolean bl = false;
            if (pSViewTypeStruct != null && pSViewTypeStruct.getPSViewTypeId().indexOf("DEMOB") != -1) {
                bl = true;
            }
            if (!StringHelper.isNullOrEmpty((String)(string5 = this.getPSDEGridId(pSDataEntity, bl)))) {
                pSDEViewCtrl.setPSDEGridId(string5);
            }
            pSDEViewCtrl.setPSDEDataSetId(this.getPSDEDataSetId(pSDataEntity));
            if (!StringHelper.isNullOrEmpty((String)pSVTCtrl.getPSSysACHandlerId())) {
                pSDEViewCtrl.setPSACHandlerId(this.getPSACHandlerId(pSVTCtrl.getPSSysACHandlerId(), pSSystem));
            }
            return;
        }
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"TOOLBAR", (boolean)true) == 0) {
            if (!StringHelper.isNullOrEmpty((String)pSVTCtrl.getPSSysToolbarId())) {
                pSDEViewCtrl.setPSDEToolbarId(this.getPSDEToolbarId(pSVTCtrl.getPSSysToolbarId(), pSSystem));
            }
            return;
        }
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"PICKUPVIEWPANEL", (boolean)true) == 0) {
            String string6 = this.getPSDEViewBaseId(pSDataEntity, pSViewTypeStruct, string, string2);
            if (!StringHelper.isNullOrEmpty((String)string6)) {
                pSDEViewCtrl.setPSDEViewId(string6);
            }
            return;
        }
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"DRBAR", (boolean)true) == 0 || StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"DRTAB", (boolean)true) == 0) {
            boolean bl = false;
            if (pSViewTypeStruct != null && pSViewTypeStruct.getPSViewTypeId().indexOf("DEMOB") != -1) {
                bl = true;
            }
            pSDEViewCtrl.setPSDEDRId(this.getPSDEDataRelationId(pSDataEntity, pSDEViewBase, bl));
            return;
        }
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"DATAVIEW", (boolean)true) == 0) {
            pSDEViewCtrl.setPSDEDataViewId(this.getPSDEDataViewId(pSDataEntity, string, string2));
            pSDEViewCtrl.setPSDEDataSetId(this.getPSDEDataSetId(pSDataEntity, string, string2));
            if (StringHelper.isNullOrEmpty((String)string)) {
                if (!StringHelper.isNullOrEmpty((String)pSVTCtrl.getPSSysACHandlerId())) {
                    pSDEViewCtrl.setPSACHandlerId(this.getPSACHandlerId(pSVTCtrl.getPSSysACHandlerId(), pSSystem));
                }
            } else {
                String string7 = "";
                if (StringHelper.compare((String)string, (String)"INDEXDETYPE", (boolean)true) == 0) {
                    string7 = "INDEXPICKUPDATAVIEWHANDLER";
                } else if (StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0) {
                    string7 = "FORMPICKUPDATAVIEWHANDLER";
                }
                pSDEViewCtrl.setPSACHandlerId(this.getPSACHandlerId(string7, pSSystem));
            }
            return;
        }
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"MOBMDCTRL", (boolean)true) == 0) {
            pSDEViewCtrl.setPSDEListId(this.getPSDEListId(pSDataEntity, string, string2, true));
            pSDEViewCtrl.setPSDEDataSetId(this.getPSDEDataSetId(pSDataEntity, string, string2));
            if (StringHelper.isNullOrEmpty((String)string)) {
                if (!StringHelper.isNullOrEmpty((String)pSVTCtrl.getPSSysACHandlerId())) {
                    pSDEViewCtrl.setPSACHandlerId(this.getPSACHandlerId(pSVTCtrl.getPSSysACHandlerId(), pSSystem));
                }
            } else {
                String string8 = pSVTCtrl.getPSSysACHandlerId();
                pSDEViewCtrl.setPSACHandlerId(this.getPSACHandlerId(string8, pSSystem));
            }
            pSDEViewCtrl.setCtrlParam("LISTVIEW");
            return;
        }
    }

    protected String getPSACHandlerId(String string, PSSystem pSSystem) throws Exception {
        Object object;
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        String string2 = StringHelper.format((String)"%1$s#%2$s", (Object)"PSACHANDLER", (Object)string);
        if (actionSession != null && (object = actionSession.getActionParam(string2)) != null) {
            if (object instanceof String) {
                return (String)object;
            }
            return null;
        }
        object = this.getPSACHandlerIdReal(string, pSSystem);
        if (actionSession != null) {
            if (object == null) {
                actionSession.setActionParam(string2, EntityBase.EMPTY);
            } else {
                actionSession.setActionParam(string2, object);
            }
        }
        return object;
    }

    protected String getPSACHandlerIdReal(String string, PSSystem pSSystem) throws Exception {
        String string2 = KeyValueHelper.genUniqueId((String)string, (String)pSSystem.getPSSFId());
        String string3 = KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)string2);
        PSACHandlerService pSACHandlerService = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        PSACHandler pSACHandler = new PSACHandler();
        pSACHandler.setPSACHandlerId(string3);
        if (pSACHandlerService.checkKey(pSACHandler) == 1) {
            return string3;
        }
        SelectCond selectCond = new SelectCond();
        selectCond.setFetchFirst(true);
        selectCond.setIsNull("PSDEID");
        selectCond.set("PSSYSTEMID", (Object)pSSystem.getPSSystemId());
        selectCond.set("PSSFACHANDLERID", (Object)string2);
        ArrayList arrayList = pSACHandlerService.select((ISelectCond)selectCond);
        if (arrayList.size() > 0) {
            return ((PSACHandler)arrayList.get(0)).getPSACHandlerId();
        }
        return null;
    }

    protected String getPSDEToolbarId(String string, PSSystem pSSystem) throws Exception {
        Object object;
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        String string2 = StringHelper.format((String)"%1$s#%2$s", (Object)"PSDETOOLBAR", (Object)string);
        if (actionSession != null && (object = actionSession.getActionParam(string2)) != null) {
            if (object instanceof String) {
                return (String)object;
            }
            return null;
        }
        object = this.getPSDEToolbarIdReal(string, pSSystem);
        if (actionSession != null) {
            if (object == null) {
                actionSession.setActionParam(string2, EntityBase.EMPTY);
            } else {
                actionSession.setActionParam(string2, object);
            }
        }
        return object;
    }

    protected String getPSDEToolbarIdReal(String string, PSSystem pSSystem) throws Exception {
        String string2 = KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)string);
        PSDEToolbarService pSDEToolbarService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        PSDEToolbar pSDEToolbar = new PSDEToolbar();
        pSDEToolbar.setPSDEToolbarId(string2);
        if (pSDEToolbarService.checkKey(pSDEToolbar) == 1) {
            return string2;
        }
        SelectCond selectCond = new SelectCond();
        selectCond.setFetchFirst(true);
        selectCond.setIsNull("PSDEID");
        selectCond.set("PSSYSTEMID", (Object)pSSystem.getPSSystemId());
        selectCond.set("PSSYSTOOLBARID", (Object)string);
        ArrayList arrayList = pSDEToolbarService.select((ISelectCond)selectCond);
        if (arrayList.size() > 0) {
            return ((PSDEToolbar)arrayList.get(0)).getPSDEToolbarId();
        }
        return null;
    }

    protected String getPSDEEditFormId(PSDataEntity pSDataEntity, boolean bl) throws Exception {
        Object object;
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        String string = StringHelper.format((String)"%1$s#%2$s#%3$s", (Object)"PSEDITFORM", (Object)pSDataEntity.getPSDataEntityId(), (Object)bl);
        if (actionSession != null && (object = actionSession.getActionParam(string)) != null) {
            if (object instanceof String) {
                return (String)object;
            }
            return null;
        }
        object = this.getPSDEEditFormIdReal(pSDataEntity, bl);
        if (actionSession != null) {
            if (object == null) {
                actionSession.setActionParam(string, EntityBase.EMPTY);
            } else {
                actionSession.setActionParam(string, object);
            }
        }
        return object;
    }

    protected String getPSDEEditFormIdReal(PSDataEntity pSDataEntity, boolean bl) throws Exception {
        boolean bl2 = this.isEnableFolderKey((IEntity)pSDataEntity);
        String string = null;
        if (bl2) {
            string = StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R1");
            if (bl) {
                string = StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R3");
            }
        } else {
            string = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"EDITFORM");
            if (bl) {
                string = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"EDITFORM", (String)"MOB");
            }
        }
        PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        PSDEForm pSDEForm = new PSDEForm();
        pSDEForm.setPSDEFormId(string);
        if (pSDEFormService.checkKey(pSDEForm) == 1) {
            return string;
        }
        SelectCond selectCond = new SelectCond();
        selectCond.set("FORMTYPE", (Object)"EDITFORM");
        selectCond.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
        ArrayList arrayList = pSDEFormService.select((ISelectCond)selectCond);
        for (PSDEForm pSDEForm2 : arrayList) {
            if (bl) {
                if (DataObject.getBoolValue((Integer)pSDEForm2.getMobFlag(), (boolean)false)) {
                    return pSDEForm2.getPSDEFormId();
                }
                if (pSDEForm2.getCodeName().indexOf("Mob") == -1) continue;
                return pSDEForm2.getPSDEFormId();
            }
            if (DataObject.getBoolValue((Integer)pSDEForm2.getMobFlag(), (boolean)false) || pSDEForm2.getCodeName().indexOf("Mob") != -1) continue;
            return pSDEForm2.getPSDEFormId();
        }
        return null;
    }

    protected String getPSDESearchFormId(PSDataEntity pSDataEntity, boolean bl) throws Exception {
        Object object;
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        String string = StringHelper.format((String)"%1$s#%2$s#%3$s", (Object)"PSSEARCHFORM", (Object)pSDataEntity.getPSDataEntityId(), (Object)bl);
        if (actionSession != null && (object = actionSession.getActionParam(string)) != null) {
            if (object instanceof String) {
                return (String)object;
            }
            return null;
        }
        object = this.getPSDESearchFormIdReal(pSDataEntity, bl);
        if (actionSession != null) {
            if (object == null) {
                actionSession.setActionParam(string, EntityBase.EMPTY);
            } else {
                actionSession.setActionParam(string, object);
            }
        }
        return object;
    }

    protected String getPSDESearchFormIdReal(PSDataEntity pSDataEntity, boolean bl) throws Exception {
        boolean bl2 = this.isEnableFolderKey((IEntity)pSDataEntity);
        String string = null;
        if (bl2) {
            string = StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R2");
            if (bl) {
                string = StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R4");
            }
        } else {
            string = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"SEARCHFORM");
            if (bl) {
                string = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"SEARCHFORM", (String)"MOB");
            }
        }
        PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        PSDEForm pSDEForm = new PSDEForm();
        pSDEForm.setPSDEFormId(string);
        if (pSDEFormService.checkKey(pSDEForm) == 1) {
            return string;
        }
        SelectCond selectCond = new SelectCond();
        selectCond.set("FORMTYPE", (Object)"SEARCHFORM");
        selectCond.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
        ArrayList arrayList = pSDEFormService.select((ISelectCond)selectCond);
        for (PSDEForm pSDEForm2 : arrayList) {
            if (bl) {
                if (DataObject.getBoolValue((Integer)pSDEForm2.getMobFlag(), (boolean)false)) {
                    return pSDEForm2.getPSDEFormId();
                }
                if (pSDEForm2.getCodeName().indexOf("Mob") == -1) continue;
                return pSDEForm2.getPSDEFormId();
            }
            if (DataObject.getBoolValue((Integer)pSDEForm2.getMobFlag(), (boolean)false) || pSDEForm2.getCodeName().indexOf("Mob") != -1) continue;
            return pSDEForm2.getPSDEFormId();
        }
        return null;
    }

    protected String getPSDEGridId(PSDataEntity pSDataEntity, boolean bl) throws Exception {
        Object object;
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        String string = StringHelper.format((String)"%1$s#%2$s#%3$s", (Object)"PSDEGRID", (Object)pSDataEntity.getPSDataEntityId(), (Object)bl);
        if (actionSession != null && (object = actionSession.getActionParam(string)) != null) {
            if (object instanceof String) {
                return (String)object;
            }
            return null;
        }
        object = this.getPSDEGridIdReal(pSDataEntity, bl);
        if (actionSession != null) {
            if (object == null) {
                actionSession.setActionParam(string, EntityBase.EMPTY);
            } else {
                actionSession.setActionParam(string, object);
            }
        }
        return object;
    }

    protected String getPSDEGridIdReal(PSDataEntity pSDataEntity, boolean bl) throws Exception {
        boolean bl2 = this.isEnableFolderKey((IEntity)pSDataEntity);
        String string = null;
        string = bl2 ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R1") : pSDataEntity.getPSDataEntityId();
        PSDEGridService pSDEGridService = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        PSDEGrid pSDEGrid = new PSDEGrid();
        pSDEGrid.setPSDEGridId(string);
        if (pSDEGridService.checkKey(pSDEGrid) == 1) {
            return string;
        }
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
        ArrayList arrayList = pSDEGridService.select((ISelectCond)selectCond);
        for (PSDEGrid pSDEGrid2 : arrayList) {
            if (!(bl ? pSDEGrid2.getCodeName().indexOf("Mob") != -1 : pSDEGrid2.getCodeName().indexOf("Mob") == -1)) continue;
            return pSDEGrid2.getPSDEGridId();
        }
        return null;
    }

    protected String getPSDEDataSetId(PSDataEntity pSDataEntity) throws Exception {
        return this.getPSDEDataSetId(pSDataEntity, null, null);
    }

    protected String getPSDEDataSetId(PSDataEntity pSDataEntity, String string, String string2) throws Exception {
        Object object;
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        String string3 = StringHelper.format((String)"%1$s#%2$s#%3$s#%4$s", (Object)"PSDEDATASET", (Object)pSDataEntity.getPSDataEntityId(), (Object)string, (Object)string2);
        if (actionSession != null && (object = actionSession.getActionParam(string3)) != null) {
            if (object instanceof String) {
                return (String)object;
            }
            return null;
        }
        object = this.getPSDEDataSetIdReal(pSDataEntity, string, string2);
        if (actionSession != null) {
            if (object == null) {
                actionSession.setActionParam(string3, EntityBase.EMPTY);
            } else {
                actionSession.setActionParam(string3, object);
            }
        }
        return object;
    }

    protected String getPSDEDataSetIdReal(PSDataEntity pSDataEntity, String string, String string2) throws Exception {
        boolean bl = this.isEnableFolderKey((IEntity)pSDataEntity);
        String string3 = null;
        if (bl) {
            string3 = StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R1");
        } else {
            string3 = pSDataEntity.getPSDataEntityId();
            if (!StringHelper.isNullOrEmpty((String)string)) {
                if (StringHelper.compare((String)string, (String)"INDEXDETYPE", (boolean)true) == 0) {
                    string3 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"INDEXDETYPE", (String)string2);
                } else if (StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0) {
                    string3 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"FORMTYPE", (String)"");
                }
            }
        }
        PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        PSDEDataSet pSDEDataSet = new PSDEDataSet();
        pSDEDataSet.setPSDEDataSetId(string3);
        if (pSDEDataSetService.checkKey(pSDEDataSet) == 1) {
            return string3;
        }
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
        ArrayList arrayList = pSDEDataSetService.select((ISelectCond)selectCond);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            for (PSDEDataSet pSDEDataSet2 : arrayList) {
                if (!(StringHelper.compare((String)string, (String)"INDEXDETYPE", (boolean)true) == 0 ? "INDEXDE".equals(pSDEDataSet2.getPredefineType()) : StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0 && "MULTIFORM".equals(pSDEDataSet2.getPredefineType()))) continue;
                return pSDEDataSet2.getPSDEDataSetId();
            }
        } else {
            for (PSDEDataSet pSDEDataSet3 : arrayList) {
                if (!DataObject.getBoolValue((Integer)pSDEDataSet3.getDefaultMode(), (boolean)false)) continue;
                return pSDEDataSet3.getPSDEDataSetId();
            }
            Iterator iterator = arrayList.iterator();
            if (iterator.hasNext()) {
                PSDEDataSet pSDEDataSet3;
                pSDEDataSet3 = (PSDEDataSet)iterator.next();
                return pSDEDataSet3.getPSDEDataSetId();
            }
        }
        return null;
    }

    protected String getPSDEDataViewId(PSDataEntity pSDataEntity, String string, String string2) throws Exception {
        Object object;
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        String string3 = StringHelper.format((String)"%1$s#%2$s#%3$s#%4$s", (Object)"PSDEDATAVIEW", (Object)pSDataEntity.getPSDataEntityId(), (Object)string, (Object)string2);
        if (actionSession != null && (object = actionSession.getActionParam(string3)) != null) {
            if (object instanceof String) {
                return (String)object;
            }
            return null;
        }
        object = this.getPSDEDataViewIdReal(pSDataEntity, string, string2);
        if (actionSession != null) {
            if (object == null) {
                actionSession.setActionParam(string3, EntityBase.EMPTY);
            } else {
                actionSession.setActionParam(string3, object);
            }
        }
        return object;
    }

    protected String getPSDEDataViewIdReal(PSDataEntity pSDataEntity, String string, String string2) throws Exception {
        String string3 = "";
        boolean bl = this.isEnableFolderKey((IEntity)pSDataEntity);
        if (bl) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                if (StringHelper.compare((String)string, (String)"INDEXDETYPE", (boolean)true) == 0) {
                    string3 = StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R2");
                } else if (StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0) {
                    string3 = StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R3");
                }
            }
        } else {
            string3 = StringHelper.isNullOrEmpty((String)string) ? pSDataEntity.getPSDataEntityId() : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)string, (String)string2);
        }
        PSDEDataViewService pSDEDataViewService = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        PSDEDataView pSDEDataView = new PSDEDataView();
        pSDEDataView.setPSDEDataViewId(string3);
        if (pSDEDataViewService.checkKey(pSDEDataView) == 1) {
            return string3;
        }
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
        ArrayList arrayList = pSDEDataViewService.select((ISelectCond)selectCond);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            for (PSDEDataView pSDEDataView2 : arrayList) {
                if (!(StringHelper.compare((String)string, (String)"INDEXDETYPE", (boolean)true) == 0 ? "IndexType".equals(pSDEDataView2.getCodeName()) : StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0 && "FormType".equals(pSDEDataView2.getCodeName()))) continue;
                return pSDEDataView2.getPSDEDataViewId();
            }
        } else {
            Iterator iterator = arrayList.iterator();
            if (iterator.hasNext()) {
                PSDEDataView pSDEDataView3 = (PSDEDataView)iterator.next();
                return pSDEDataView3.getPSDEDataViewId();
            }
        }
        return null;
    }

    protected String getPSDEListId(PSDataEntity pSDataEntity, String string, String string2, boolean bl) throws Exception {
        Object object;
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        String string3 = StringHelper.format((String)"%1$s#%2$s#%3$s#%4$s#%5$s", (Object)"PSDELIST", (Object)pSDataEntity.getPSDataEntityId(), (Object)string, (Object)string2, (Object)bl);
        if (actionSession != null && (object = actionSession.getActionParam(string3)) != null) {
            if (object instanceof String) {
                return (String)object;
            }
            return null;
        }
        object = this.getPSDEListIdReal(pSDataEntity, string, string2, bl);
        if (actionSession != null) {
            if (object == null) {
                actionSession.setActionParam(string3, EntityBase.EMPTY);
            } else {
                actionSession.setActionParam(string3, object);
            }
        }
        return object;
    }

    protected String getPSDEListIdReal(PSDataEntity pSDataEntity, String string, String string2, boolean bl) throws Exception {
        boolean bl2 = this.isEnableFolderKey((IEntity)pSDataEntity);
        String string3 = "";
        if (bl2) {
            if (StringHelper.isNullOrEmpty((String)string)) {
                string3 = StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R1");
            } else if (StringHelper.compare((String)string, (String)"INDEXDETYPE", (boolean)true) == 0) {
                string3 = StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R2");
            } else if (StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0) {
                string3 = StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R3");
            }
        } else {
            string3 = bl ? (StringHelper.isNullOrEmpty((String)string) ? KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"MOB") : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)string, (String)string2, (String)"MOB")) : (StringHelper.isNullOrEmpty((String)string) ? pSDataEntity.getPSDataEntityId() : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)string, (String)string2));
        }
        PSDEListService pSDEListService = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        PSDEList pSDEList = new PSDEList();
        pSDEList.setPSDEListId(string3);
        if (pSDEListService.checkKey(pSDEList) == 1) {
            return string3;
        }
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
        ArrayList arrayList = pSDEListService.select((ISelectCond)selectCond);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            for (PSDEList pSDEList2 : arrayList) {
                if (!(StringHelper.compare((String)string, (String)"INDEXDETYPE", (boolean)true) == 0 ? (bl ? "MobIndexType".equals(pSDEList2.getCodeName()) : "IndexType".equals(pSDEList2.getCodeName())) : StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0 && (bl ? "MobFormType".equals(pSDEList2.getCodeName()) : "FormType".equals(pSDEList2.getCodeName())))) continue;
                return pSDEList2.getPSDEListId();
            }
        } else {
            for (PSDEList pSDEList3 : arrayList) {
                if (!bl || !"Mob".equals(pSDEList3.getCodeName())) continue;
                return pSDEList3.getPSDEListId();
            }
            Iterator iterator = arrayList.iterator();
            if (iterator.hasNext()) {
                PSDEList pSDEList3;
                pSDEList3 = (PSDEList)iterator.next();
                return pSDEList3.getPSDEListId();
            }
        }
        return null;
    }

    protected String getPSDEViewBaseId(PSDataEntity pSDataEntity, PSViewTypeStruct pSViewTypeStruct, String string, String string2) throws Exception {
        Object object;
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        String string3 = StringHelper.format((String)"%1$s#%2$s#%3$s#%4$s#%5$s", (Object)"PSDEDATASET", (Object)pSDataEntity.getPSDataEntityId(), (Object)(pSViewTypeStruct == null ? "" : pSViewTypeStruct.getPSViewTypeId()), (Object)string, (Object)string2);
        if (actionSession != null && (object = actionSession.getActionParam(string3)) != null) {
            if (object instanceof String) {
                return (String)object;
            }
            return null;
        }
        object = this.getPSDEViewBaseIdReal(pSDataEntity, pSViewTypeStruct, string, string2);
        if (actionSession != null) {
            if (object == null) {
                actionSession.setActionParam(string3, EntityBase.EMPTY);
            } else {
                actionSession.setActionParam(string3, object);
            }
        }
        return object;
    }

    protected String getPSDEViewBaseIdReal(PSDataEntity pSDataEntity, PSViewTypeStruct pSViewTypeStruct, String string, String string2) throws Exception {
        boolean bl = this.isEnableFolderKey((IEntity)pSDataEntity);
        if (bl) {
            String string3 = "";
            string3 = pSViewTypeStruct != null && pSViewTypeStruct.getPSViewTypeId().indexOf("DEMOB") != -1 ? (StringHelper.compare((String)string, (String)"INDEXDETYPE", (boolean)true) == 0 ? KeyValueHelper.genUniqueId((String)"DEMOBINDEXPICKUPMDVIEW", (String)string, (String)string2) : (StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0 ? KeyValueHelper.genUniqueId((String)"DEMOBFORMPICKUPMDVIEW", (String)string, (String)string2) : KeyValueHelper.genUniqueId((String)"DEMOBPICKUPMDVIEW"))) : (StringHelper.compare((String)string, (String)"INDEXDETYPE", (boolean)true) == 0 ? KeyValueHelper.genUniqueId((String)"DEINDEXPICKUPDATAVIEW", (String)string, (String)string2) : (StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0 ? KeyValueHelper.genUniqueId((String)"DEFORMPICKUPDATAVIEW", (String)string, (String)string2) : KeyValueHelper.genUniqueId((String)"DEPICKUPGRIDVIEW")));
            PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = new PSDEViewBase();
            pSDEViewBase.setDEViewTag(string3);
            pSDEViewBase.setPSDEId(pSDataEntity.getPSDataEntityId());
            if (pSDEViewBaseService.selectOne((IEntity)pSDEViewBase, true)) {
                return pSDEViewBase.getPSDEViewBaseId();
            }
        } else {
            String string4 = "";
            String string5 = "";
            if (pSViewTypeStruct != null && pSViewTypeStruct.getPSViewTypeId().indexOf("DEMOB") != -1) {
                if (StringHelper.compare((String)string, (String)"INDEXDETYPE", (boolean)true) == 0) {
                    string4 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"DEMOBINDEXPICKUPMDVIEW", (String)string, (String)string2);
                    string5 = "DEMOBINDEXPICKUPMDVIEW";
                } else if (StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0) {
                    string4 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"DEMOBFORMPICKUPMDVIEW", (String)string, (String)string2);
                    string5 = "DEMOBFORMPICKUPMDVIEW";
                } else {
                    string4 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"DEMOBPICKUPMDVIEW");
                    string5 = "DEMOBPICKUPMDVIEW";
                }
            } else if (StringHelper.compare((String)string, (String)"INDEXDETYPE", (boolean)true) == 0) {
                string4 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"DEINDEXPICKUPDATAVIEW", (String)string, (String)string2);
                string5 = "DEINDEXPICKUPDATAVIEW";
            } else if (StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0) {
                string4 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"DEFORMPICKUPDATAVIEW", (String)string, (String)string2);
                string5 = "DEFORMPICKUPDATAVIEW";
            } else {
                string4 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"DEPICKUPGRIDVIEW");
                string5 = "DEPICKUPGRIDVIEW";
            }
            PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = new PSDEViewBase();
            pSDEViewBase.setPSDEViewBaseId(string4);
            if (pSDEViewBaseService.checkKey(pSDEViewBase) == 1) {
                return pSDEViewBase.getPSDEViewBaseId();
            }
            SelectCond selectCond = new SelectCond();
            selectCond.setFetchFirst(true);
            selectCond.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
            selectCond.set("PSDEVIEWBASETYPE", (Object)string5);
            if (StringHelper.isNullOrEmpty((String)string)) {
                selectCond.setIsNull("DEVIEWTAG3");
                selectCond.setIsNull("DEVIEWTAG4");
            } else {
                selectCond.set("DEVIEWTAG3", (Object)string);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    selectCond.set("DEVIEWTAG4", (Object)string2);
                } else {
                    selectCond.setIsNull("DEVIEWTAG4");
                }
            }
            ArrayList arrayList = this.select((ISelectCond)selectCond);
            if (arrayList.size() == 0) {
                return null;
            }
            return ((PSDEViewBase)arrayList.get(0)).getPSDEViewBaseId();
        }
        return null;
    }

    protected String getPSDEDataRelationId(PSDataEntity pSDataEntity, PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
        Object object;
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        String string = StringHelper.format((String)"%1$s#%2$s#%3$s#%4$s", (Object)"PSDEDATARELATION", (Object)pSDataEntity.getPSDataEntityId(), (Object)pSDEViewBase.getPSWFDEId(), (Object)bl);
        if (actionSession != null && (object = actionSession.getActionParam(string)) != null) {
            if (object instanceof String) {
                return (String)object;
            }
            return null;
        }
        object = this.getPSDEDataRelationIdReal(pSDataEntity, pSDEViewBase, bl);
        if (actionSession != null) {
            if (object == null) {
                actionSession.setActionParam(string, EntityBase.EMPTY);
            } else {
                actionSession.setActionParam(string, object);
            }
        }
        return object;
    }

    protected String getPSDEDataRelationIdReal(PSDataEntity pSDataEntity, PSDEViewBase pSDEViewBase, boolean bl) throws Exception {
        boolean bl2 = this.isEnableFolderKey((IEntity)pSDataEntity);
        String string = null;
        string = bl2 ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R1") : pSDataEntity.getPSDataEntityId();
        if (!StringHelper.isNullOrEmpty((String)pSDEViewBase.getPSWFId())) {
            string = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)pSDEViewBase.getPSWFId());
            if (bl) {
                string = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)pSDEViewBase.getPSWFId(), (String)"MOB");
            }
        }
        PSDEDataRelation pSDEDataRelation = new PSDEDataRelation();
        pSDEDataRelation.setPSDEDataRelationId(string);
        PSDEDataRelationService pSDEDataRelationService = (PSDEDataRelationService)ServiceGlobal.getService(PSDEDataRelationService.class, (SessionFactory)this.getSessionFactory());
        if (pSDEDataRelationService.checkKey(pSDEDataRelation) == 1) {
            return string;
        }
        SelectCond selectCond = new SelectCond();
        selectCond.setFetchFirst(true);
        selectCond.set("PSDEID", (Object)pSDEViewBase.getPSDEId());
        if (StringHelper.isNullOrEmpty((String)pSDEViewBase.getPSWFDEId())) {
            selectCond.setIsNull("PSWFDEID");
        } else {
            selectCond.set("PSWFDEID", (Object)pSDEViewBase.getPSWFDEId());
        }
        if (bl) {
            selectCond.set("DRTAG", (Object)"MOB");
        } else {
            selectCond.setIsNull("DRTAG");
        }
        ArrayList arrayList = pSDEDataRelationService.select((ISelectCond)selectCond);
        if (arrayList.size() > 0) {
            return ((PSDEDataRelation)arrayList.get(0)).getPSDEDataRelationId();
        }
        return null;
    }

    protected void initDEViewRV(PSSystem pSSystem, PSDataEntity pSDataEntity, PSViewTypeStruct pSViewTypeStruct, PSDEViewBase pSDEViewBase, PSVTRV pSVTRV, String string, String string2) throws Exception {
        PSDEViewRV pSDEViewRV = new PSDEViewRV();
        pSDEViewRV.setMajorPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDEViewRV.setMajorPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
        pSDEViewRV.setPSDEViewRVName(pSVTRV.getPSVTRVName());
        pSDEViewRV.setRefModeText(pSVTRV.getLogicName());
        pSDEViewRV.setMemo(pSVTRV.getMemo());
        pSDEViewRV.setDefViewType(pSVTRV.getDEFViewType());
        this.fillDEViewRV(pSDEViewRV, pSSystem, pSDataEntity, pSViewTypeStruct, pSDEViewBase, pSVTRV, string, string2);
        PSDEViewRVService pSDEViewRVService = (PSDEViewRVService)ServiceGlobal.getService(PSDEViewRVService.class, (SessionFactory)this.getSessionFactory());
        try {
            pSDEViewRVService.create(pSDEViewRV);
        }
        catch (Exception exception) {
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5b9e\u4f53\u89c6\u56fe[%1$s]\u5f15\u7528[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDEViewBase.getPSDEViewBaseName(), (Object)pSDEViewRV.getPSDEViewRVName(), (Object)exception.getMessage()), exception);
        }
    }

    protected void fillDEViewRV(PSDEViewRV pSDEViewRV, PSSystem pSSystem, PSDataEntity pSDataEntity, PSViewTypeStruct pSViewTypeStruct, PSDEViewBase pSDEViewBase, PSVTRV pSVTRV, String string, String string2) throws Exception {
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEGRIDVIEW", (boolean)true) == 0 || StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEMDCUSTOMVIEW", (boolean)true) == 0) {
            boolean bl = this.isEnableFolderKey((IEntity)pSDataEntity);
            PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase2 = new PSDEViewBase();
            if (bl) {
                if (StringHelper.compare((String)pSVTRV.getPSVTRVName(), (String)"NEWDATA", (boolean)true) == 0) {
                    String string3 = KeyValueHelper.genUniqueId((String)"DEEDITVIEW");
                    pSDEViewBase2.setDEViewTag(string3);
                    pSDEViewBase2.setPSDEId(pSDataEntity.getPSDataEntityId());
                    if (pSDEViewBaseService.selectOne((IEntity)pSDEViewBase2, true)) {
                        pSDEViewRV.setMinorPSDEViewId(pSDEViewBase2.getPSDEViewBaseId());
                    }
                    return;
                }
                if (StringHelper.compare((String)pSVTRV.getPSVTRVName(), (String)"EDITDATA", (boolean)true) == 0) {
                    String string4 = KeyValueHelper.genUniqueId((String)"DEEDITVIEW");
                    pSDEViewBase2.setDEViewTag(string4);
                    pSDEViewBase2.setPSDEId(pSDataEntity.getPSDataEntityId());
                    if (pSDEViewBaseService.selectOne((IEntity)pSDEViewBase2, true)) {
                        pSDEViewRV.setMinorPSDEViewId(pSDEViewBase2.getPSDEViewBaseId());
                    }
                    return;
                }
            } else {
                if (StringHelper.compare((String)pSVTRV.getPSVTRVName(), (String)"NEWDATA", (boolean)true) == 0) {
                    String string5 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"DEEDITVIEW");
                    pSDEViewBase2.setPSDEViewBaseId(string5);
                    if (pSDEViewBaseService.checkKey(pSDEViewBase2) == 1) {
                        pSDEViewRV.setMinorPSDEViewId(string5);
                    }
                    return;
                }
                if (StringHelper.compare((String)pSVTRV.getPSVTRVName(), (String)"EDITDATA", (boolean)true) == 0) {
                    String string6 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"DEEDITVIEW");
                    pSDEViewBase2.setPSDEViewBaseId(string6);
                    if (pSDEViewBaseService.checkKey(pSDEViewBase2) == 1) {
                        pSDEViewRV.setMinorPSDEViewId(string6);
                    }
                    return;
                }
            }
        }
    }

    protected void initDEWFViews(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSWFDE> arrayList = pSDataEntity.getPSWFDEs();
        if (arrayList.size() == 0) {
            return;
        }
        for (PSWFDE pSWFDE : arrayList) {
            this.initWFDEViews(pSWFDE, pSDataEntity);
        }
    }

    public void initWFDEViews(PSWFDE pSWFDE, PSDataEntity pSDataEntity) throws Exception {
        final PSWFDE pSWFDE2 = pSWFDE;
        final PSDataEntity pSDataEntity2 = pSDataEntity != null ? pSDataEntity : pSWFDE.getPSDE();
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                block54: {
                    Object object;
                    PSCodeList pSCodeList;
                    PSCodeList pSCodeList2;
                    boolean bl;
                    ArrayList<PSWFVersion> arrayList;
                    block53: {
                        Serializable serializable;
                        Object object2;
                        EntityBase entityBase;
                        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)PSDEViewBaseService.this.getSessionFactory());
                        PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)PSDEViewBaseService.this.getSessionFactory());
                        PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)PSDEViewBaseService.this.getSessionFactory());
                        PSWFVersionService pSWFVersionService = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)PSDEViewBaseService.this.getSessionFactory());
                        if (!pSDataEntity2.isFullEntity()) {
                            pSDataEntityService.get((IEntity)pSDataEntity2);
                        }
                        arrayList = null;
                        int n = DataObject.getIntegerValue((Object)pSWFDE2.getWFProxyMode(), (Integer)0);
                        boolean bl2 = (n & 1) == 1;
                        boolean bl3 = n != 1;
                        boolean bl4 = DataObject.getBoolValue((Integer)pSWFDE2.getPSWF().getEnableDynaSys(), (boolean)false);
                        bl = false;
                        if (DataObject.getBoolValue((Integer)pSWFDE2.getPSWF().getEnableMob(), (boolean)false)) {
                            bl = true;
                        }
                        if (bl2) {
                            bl4 = false;
                        }
                        if (bl4) {
                            entityBase = new PSWFVersion();
                            entityBase.setPSWFId(pSWFDE2.getPSWFId());
                            entityBase.setEnableDynaSys(1);
                            if (pSWFVersionService.select(entityBase, true)) {
                                arrayList = new ArrayList();
                                arrayList.add((PSWFVersion)entityBase);
                            }
                        } else if (bl3) {
                            arrayList = pSWFVersionService.selectByPSWF(pSWFDE2.getPSWF(), "ORDER BY WFVERSION DESC");
                        }
                        entityBase = null;
                        PSCodeList pSCodeList3 = null;
                        pSCodeList2 = null;
                        pSCodeList = null;
                        if (!bl4 && bl3) {
                            if (DataObject.getIntegerValue((Object)pSDataEntity2.getEnaMultiForm(), (Integer)0) > 0) {
                                entityBase = new PSDEField();
                                entityBase.setPSDEId(pSDataEntity2.getPSDataEntityId());
                                entityBase.setMultiFormField(1);
                                if (!pSDEFieldService.select(entityBase, false)) {
                                    throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u6ca1\u6709\u5b9a\u4e49\u591a\u8868\u5355\u8bc6\u522b\u5c5e\u6027", (Object)pSDataEntity2.getPSDataEntityName()));
                                }
                                if (StringHelper.isNullOrEmpty((String)entityBase.getPSCodeListId())) {
                                    throw new Exception(StringHelper.format((String)"\u5c5e\u6027[%1$s]\u6ca1\u6709\u5b9a\u4e49\u4ee3\u7801\u8868", (Object)entityBase.getPSDEFieldName()));
                                }
                                pSCodeList3 = new PSCodeList();
                                pSCodeList3.setPSCodeListId(entityBase.getPSCodeListId());
                                pSCodeListService.getCache((IEntity)pSCodeList3);
                            }
                            if (!StringHelper.isNullOrEmpty((String)pSWFDE2.getWFStepPSDEFId())) {
                                object2 = new PSDEField();
                                ((PSDEFieldBase)object2).setPSDEFieldId(pSWFDE2.getWFStepPSDEFId());
                                pSDEFieldService.getCache((IEntity)object2);
                                if (!StringHelper.isNullOrEmpty((String)((PSDEFieldBase)object2).getPSCodeListId())) {
                                    pSCodeList = new PSCodeList();
                                    pSCodeList.setPSCodeListId(((PSDEFieldBase)object2).getPSCodeListId());
                                    pSCodeListService.getCache((IEntity)pSCodeList);
                                } else {
                                    PSDEViewBaseService.this.getConsole().warn(PSDEViewBaseService.LOGNAME_INITWFVIEW, StringHelper.format((String)"\u5b9e\u4f53\u5c5e\u6027[%1$s|%2$s]\u6ca1\u6709\u6307\u5b9a\u6d41\u7a0b\u6b65\u9aa4\u4ee3\u7801\u8868\uff0c\u53ef\u80fd\u65e0\u6cd5\u6b63\u786e\u521d\u59cb\u5316\u76f8\u5173\u6d41\u7a0b\u89c6\u56fe", (Object)((PSDEFieldBase)object2).getPSDEName(), (Object)((PSDEFieldBase)object2).getPSDEFieldName()));
                                }
                            } else {
                                PSDEViewBaseService.this.getConsole().warn(PSDEViewBaseService.LOGNAME_INITWFVIEW, StringHelper.format((String)"\u5b9e\u4f53\u5de5\u4f5c\u6d41[%1$s|%2$s]\u6ca1\u6709\u6307\u5b9a\u6d41\u7a0b\u6b65\u9aa4\u5c5e\u6027\uff0c\u53ef\u80fd\u65e0\u6cd5\u6b63\u786e\u521d\u59cb\u5316\u76f8\u5173\u6d41\u7a0b\u89c6\u56fe", (Object)pSWFDE2.getPSDEName(), (Object)pSWFDE2.getPSWFName()));
                            }
                        }
                        object2 = new PSDEField();
                        ((PSDEFieldBase)object2).setPSDEFieldId(pSWFDE2.getStatePSDEFId());
                        pSDEFieldService.getCache((IEntity)object2);
                        if (!StringHelper.isNullOrEmpty((String)((PSDEFieldBase)object2).getPSCodeListId())) {
                            pSCodeList2 = new PSCodeList();
                            pSCodeList2.setPSCodeListId(((PSDEFieldBase)object2).getPSCodeListId());
                            pSCodeListService.getCache((IEntity)pSCodeList2);
                        } else {
                            PSDEViewBaseService.this.getConsole().warn(PSDEViewBaseService.LOGNAME_INITWFVIEW, StringHelper.format((String)"\u5b9e\u4f53\u5c5e\u6027[%1$s|%2$s]\u6ca1\u6709\u6307\u5b9a\u6d41\u7a0b\u7528\u6237\u6570\u636e\u72b6\u6001\u4ee3\u7801\u8868\uff0c\u53ef\u80fd\u65e0\u6cd5\u6b63\u786e\u521d\u59cb\u5316\u76f8\u5173\u6d41\u7a0b\u89c6\u56fe", (Object)((PSDEFieldBase)object2).getPSDEName(), (Object)((PSDEFieldBase)object2).getPSDEFieldName()));
                        }
                        object2 = (PSDEDRGroupService)ServiceGlobal.getService(PSDEDRGroupService.class, (SessionFactory)PSDEViewBaseService.this.getSessionFactory());
                        PSDEDRGroup pSDEDRGroup = new PSDEDRGroup();
                        pSDEDRGroup.setPSDEDRGroupId(pSDataEntity2.getPSDataEntityId());
                        if (!object2.get((IEntity)pSDEDRGroup, true)) {
                            pSDEDRGroup.reset();
                            pSDEDRGroup.setPSDEId(pSDataEntity2.getPSDataEntityId());
                            if (!object2.selectOne((IEntity)pSDEDRGroup, true)) {
                                pSDEDRGroup.setPSDEDRGroupId(pSDataEntity2.getPSDataEntityId());
                                pSDEDRGroup.setOrderValue(10000);
                                pSDEDRGroup.setPSDEId(pSDataEntity2.getPSDataEntityId());
                                pSDEDRGroup.setPSDEDRGroupName("\u8be6\u7ec6\u4fe1\u606f");
                                ((PSCoreSysServiceBaseBase)((Object)object2)).create(pSDEDRGroup);
                            }
                        }
                        PSSysPDTViewService pSSysPDTViewService = (PSSysPDTViewService)ServiceGlobal.getService(PSSysPDTViewService.class, (SessionFactory)PSDEViewBaseService.this.getSessionFactory());
                        PSSysPDTView pSSysPDTView = new PSSysPDTView();
                        Object object3 = KeyValueHelper.genUniqueId((String)pSDataEntity2.getPSSystemId(), (String)"WF_STEPDATALIST");
                        pSSysPDTView.setPSSysPDTViewId((String)object3);
                        if (!pSSysPDTViewService.get((IEntity)pSSysPDTView, true)) {
                            pSSysPDTView.reset();
                            pSSysPDTView.setPSPDTViewId("WF_STEPDATALIST");
                            if (!pSSysPDTViewService.selectOne((IEntity)pSSysPDTView, true)) {
                                pSSysPDTView = null;
                            }
                        }
                        object3 = new PSSysPDTView();
                        Object object4 = KeyValueHelper.genUniqueId((String)pSDataEntity2.getPSSystemId(), (String)"WF_STEPACTORLIST");
                        ((PSSysPDTViewBase)object3).setPSSysPDTViewId((String)object4);
                        if (!pSSysPDTViewService.get((IEntity)object3, true)) {
                            object3.reset();
                            ((PSSysPDTViewBase)object3).setPSPDTViewId("WF_STEPACTORLIST");
                            if (!pSSysPDTViewService.selectOne((IEntity)object3, true)) {
                                object3 = null;
                            }
                        }
                        object4 = new PSSysPDTView();
                        Object object5 = KeyValueHelper.genUniqueId((String)pSDataEntity2.getPSSystemId(), (String)"WF_STEPTRACECHART");
                        ((PSSysPDTViewBase)object4).setPSSysPDTViewId((String)object5);
                        if (!pSSysPDTViewService.get((IEntity)object4, true)) {
                            object4.reset();
                            ((PSSysPDTViewBase)object4).setPSPDTViewId("WF_STEPTRACECHART");
                            if (!pSSysPDTViewService.selectOne((IEntity)object4, true)) {
                                object4 = null;
                            }
                        }
                        object5 = new PSDEDataRelation();
                        Object object6 = KeyValueHelper.genUniqueId((String)pSDataEntity2.getPSDataEntityId(), (String)pSWFDE2.getPSWFId());
                        ((PSDEDataRelationBase)object5).setPSDEDataRelationId((String)object6);
                        Object object7 = (PSDEDataRelationService)ServiceGlobal.getService(PSDEDataRelationService.class, (SessionFactory)PSDEViewBaseService.this.getSessionFactory());
                        boolean bl5 = true;
                        if (object7.get((IEntity)object5, true)) {
                            bl5 = false;
                            if (StringHelper.isNullOrEmpty((String)((PSDEDataRelationBase)object5).getPSWFDEId())) {
                                ((PSDEDataRelationBase)object5).setPSWFDEId(pSWFDE2.getPSWFDEId());
                                ((PSDEDataRelationBase)object5).setDRTag(null);
                                ((PSCoreSysServiceBaseBase)((Object)object7)).update(object5);
                            }
                        } else {
                            object5.reset();
                            object = new SelectCond();
                            object.setFetchFirst(true);
                            object.set("PSDEID", (Object)pSDataEntity2.getPSDataEntityId());
                            object.set("PSWFDEID", (Object)pSWFDE2.getPSWFDEId());
                            object.setIsNull("DRTAG");
                            serializable = object7.select((ISelectCond)object);
                            if (((ArrayList)serializable).size() > 0) {
                                bl5 = false;
                                ((PSDEDataRelation)((ArrayList)serializable).get(0)).copyTo((IDataObject)object5, true);
                            } else {
                                object5.reset();
                                ((PSDEDataRelationBase)object5).setCodeName(pSWFDE2.getCodeName() + "DR");
                                ((PSDEDataRelationBase)object5).setPSDEId(pSDataEntity2.getPSDataEntityId());
                                if (((PSCoreSysServiceBaseBase)((Object)object7)).select(object5, true)) {
                                    bl5 = false;
                                    if (StringHelper.isNullOrEmpty((String)((PSDEDataRelationBase)object5).getPSWFDEId())) {
                                        ((PSDEDataRelationBase)object5).setPSWFDEId(pSWFDE2.getPSWFDEId());
                                        ((PSDEDataRelationBase)object5).setDRTag(null);
                                        ((PSCoreSysServiceBaseBase)((Object)object7)).update(object5);
                                    }
                                }
                            }
                        }
                        if (bl5) {
                            ((PSDEDataRelationBase)object5).setPSDEDataRelationId((String)object6);
                            ((PSDEDataRelationBase)object5).setPSDEId(pSDataEntity2.getPSDataEntityId());
                            ((PSDEDataRelationBase)object5).setPSDEDataRelationName(StringHelper.format((String)"%1$s/%2$s\u5173\u7cfb\u754c\u9762\u7ec4", (Object)pSDataEntity2.getLogicName(), (Object)pSWFDE2.getPSWFName()));
                            ((PSDEDataRelationBase)object5).setCodeName(pSWFDE2.getCodeName() + "DR");
                            ((PSDEDataRelationBase)object5).setPSWFDEId(pSWFDE2.getPSWFDEId());
                            ((PSCoreSysServiceBaseBase)((Object)object7)).create(object5);
                            object = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)PSDEViewBaseService.this.getSessionFactory());
                            if (pSSysPDTView != null) {
                                serializable = new PSDEDRDetail();
                                ((PSDEDRDetailBase)serializable).setPSDEDRId((String)object6);
                                ((PSDEDRDetailBase)serializable).setPSDEDRDetailName("dritem1");
                                ((PSDEDRDetailBase)serializable).setCaption("\u6d41\u7a0b\u5904\u7406");
                                ((PSDEDRDetailBase)serializable).setDetailType("PDTVIEW");
                                ((PSDEDRDetailBase)serializable).setOrderValue(1000);
                                ((PSDEDRDetailBase)serializable).setPSSysPDTViewId(pSSysPDTView.getPSSysPDTViewId());
                                ((PSDEDRDetailBase)serializable).setPSDEDRGroupId(pSDEDRGroup.getPSDEDRGroupId());
                                ((PSCoreSysServiceBaseBase)((Object)object)).create(serializable);
                            }
                            if (object3 != null) {
                                serializable = new PSDEDRDetail();
                                ((PSDEDRDetailBase)serializable).setPSDEDRId((String)object6);
                                ((PSDEDRDetailBase)serializable).setPSDEDRDetailName("dritem2");
                                ((PSDEDRDetailBase)serializable).setCaption("\u6d41\u7a0b\u50ac\u529e");
                                ((PSDEDRDetailBase)serializable).setDetailType("PDTVIEW");
                                ((PSDEDRDetailBase)serializable).setOrderValue(1100);
                                ((PSDEDRDetailBase)serializable).setPSSysPDTViewId(((PSSysPDTViewBase)object3).getPSSysPDTViewId());
                                ((PSDEDRDetailBase)serializable).setPSDEDRGroupId(pSDEDRGroup.getPSDEDRGroupId());
                                ((PSCoreSysServiceBaseBase)((Object)object)).create(serializable);
                            }
                            if (object4 != null) {
                                serializable = new PSDEDRDetail();
                                ((PSDEDRDetailBase)serializable).setPSDEDRId((String)object6);
                                ((PSDEDRDetailBase)serializable).setPSDEDRDetailName("dritem3");
                                ((PSDEDRDetailBase)serializable).setCaption("\u6d41\u7a0b\u8ddf\u8e2a");
                                ((PSDEDRDetailBase)serializable).setDetailType("PDTVIEW");
                                ((PSDEDRDetailBase)serializable).setOrderValue(1200);
                                ((PSDEDRDetailBase)serializable).setPSSysPDTViewId(((PSSysPDTViewBase)object4).getPSSysPDTViewId());
                                ((PSDEDRDetailBase)serializable).setPSDEDRGroupId(pSDEDRGroup.getPSDEDRGroupId());
                                ((PSCoreSysServiceBaseBase)((Object)object)).create(serializable);
                            }
                        }
                        if (bl) {
                            object5 = new PSDEDataRelation();
                            object6 = KeyValueHelper.genUniqueId((String)pSDataEntity2.getPSDataEntityId(), (String)pSWFDE2.getPSWFId(), (String)"MOB");
                            ((PSDEDataRelationBase)object5).setPSDEDataRelationId((String)object6);
                            object7 = (PSDEDataRelationService)ServiceGlobal.getService(PSDEDataRelationService.class, (SessionFactory)PSDEViewBaseService.this.getSessionFactory());
                            bl5 = true;
                            if (object7.get((IEntity)object5, true)) {
                                bl5 = false;
                                if (StringHelper.isNullOrEmpty((String)((PSDEDataRelationBase)object5).getPSWFDEId())) {
                                    ((PSDEDataRelationBase)object5).setPSWFDEId(pSWFDE2.getPSWFDEId());
                                    ((PSDEDataRelationBase)object5).setDRTag("MOB");
                                    ((PSCoreSysServiceBaseBase)((Object)object7)).update(object5);
                                }
                            } else {
                                object5.reset();
                                ((PSDEDataRelationBase)object5).setPSDEId(pSDataEntity2.getPSDataEntityId());
                                ((PSDEDataRelationBase)object5).setPSWFDEId(pSWFDE2.getPSWFDEId());
                                ((PSDEDataRelationBase)object5).setDRTag("MOB");
                                if (object7.selectOne((IEntity)object5, true)) {
                                    bl5 = false;
                                } else {
                                    object5.reset();
                                    ((PSDEDataRelationBase)object5).setCodeName(pSWFDE2.getCodeName() + "MobDR");
                                    ((PSDEDataRelationBase)object5).setPSDEId(pSDataEntity2.getPSDataEntityId());
                                    if (((PSCoreSysServiceBaseBase)((Object)object7)).select(object5, true)) {
                                        bl5 = false;
                                        if (StringHelper.isNullOrEmpty((String)((PSDEDataRelationBase)object5).getPSWFDEId())) {
                                            ((PSDEDataRelationBase)object5).setPSWFDEId(pSWFDE2.getPSWFDEId());
                                            ((PSDEDataRelationBase)object5).setDRTag("MOB");
                                            ((PSCoreSysServiceBaseBase)((Object)object7)).update(object5);
                                        }
                                    }
                                }
                            }
                            if (bl5) {
                                ((PSDEDataRelationBase)object5).setPSDEDataRelationId((String)object6);
                                ((PSDEDataRelationBase)object5).setPSDEId(pSDataEntity2.getPSDataEntityId());
                                ((PSDEDataRelationBase)object5).setPSDEDataRelationName(StringHelper.format((String)"%1$s/%2$s\u5173\u7cfb\u754c\u9762\u7ec4\uff08\u79fb\u52a8\u7aef\uff09", (Object)pSDataEntity2.getLogicName(), (Object)pSWFDE2.getPSWFName()));
                                ((PSDEDataRelationBase)object5).setCodeName(pSWFDE2.getCodeName() + "MobDR");
                                ((PSDEDataRelationBase)object5).setPSWFDEId(pSWFDE2.getPSWFDEId());
                                ((PSDEDataRelationBase)object5).setDRTag("MOB");
                                ((PSCoreSysServiceBaseBase)((Object)object7)).create(object5);
                                object = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)PSDEViewBaseService.this.getSessionFactory());
                                if (pSSysPDTView != null) {
                                    serializable = new PSDEDRDetail();
                                    ((PSDEDRDetailBase)serializable).setPSDEDRId((String)object6);
                                    ((PSDEDRDetailBase)serializable).setPSDEDRDetailName("dritem1");
                                    ((PSDEDRDetailBase)serializable).setCaption("\u6d41\u7a0b\u5904\u7406");
                                    ((PSDEDRDetailBase)serializable).setDetailType("PDTVIEW");
                                    ((PSDEDRDetailBase)serializable).setOrderValue(1000);
                                    ((PSDEDRDetailBase)serializable).setPSSysPDTViewId(pSSysPDTView.getPSSysPDTViewId());
                                    ((PSDEDRDetailBase)serializable).setPSDEDRGroupId(pSDEDRGroup.getPSDEDRGroupId());
                                    ((PSCoreSysServiceBaseBase)((Object)object)).create(serializable);
                                }
                                if (object3 != null) {
                                    serializable = new PSDEDRDetail();
                                    ((PSDEDRDetailBase)serializable).setPSDEDRId((String)object6);
                                    ((PSDEDRDetailBase)serializable).setPSDEDRDetailName("dritem2");
                                    ((PSDEDRDetailBase)serializable).setCaption("\u6d41\u7a0b\u50ac\u529e");
                                    ((PSDEDRDetailBase)serializable).setDetailType("PDTVIEW");
                                    ((PSDEDRDetailBase)serializable).setOrderValue(1100);
                                    ((PSDEDRDetailBase)serializable).setPSSysPDTViewId(((PSSysPDTViewBase)object3).getPSSysPDTViewId());
                                    ((PSDEDRDetailBase)serializable).setPSDEDRGroupId(pSDEDRGroup.getPSDEDRGroupId());
                                    ((PSCoreSysServiceBaseBase)((Object)object)).create(serializable);
                                }
                                if (object4 != null) {
                                    serializable = new PSDEDRDetail();
                                    ((PSDEDRDetailBase)serializable).setPSDEDRId((String)object6);
                                    ((PSDEDRDetailBase)serializable).setPSDEDRDetailName("dritem3");
                                    ((PSDEDRDetailBase)serializable).setCaption("\u6d41\u7a0b\u8ddf\u8e2a");
                                    ((PSDEDRDetailBase)serializable).setDetailType("PDTVIEW");
                                    ((PSDEDRDetailBase)serializable).setOrderValue(1200);
                                    ((PSDEDRDetailBase)serializable).setPSSysPDTViewId(((PSSysPDTViewBase)object4).getPSSysPDTViewId());
                                    ((PSDEDRDetailBase)serializable).setPSDEDRGroupId(pSDEDRGroup.getPSDEDRGroupId());
                                    ((PSCoreSysServiceBaseBase)((Object)object)).create(serializable);
                                }
                            }
                        }
                        if (pSCodeList3 == null) break block53;
                        object5 = pSCodeList3.getPSCodeItems();
                        object6 = ((ArrayList)object5).iterator();
                        while (object6.hasNext()) {
                            PSViewTypeStruct pSViewTypeStruct;
                            object7 = (PSCodeItem)object6.next();
                            for (String string : initWFViewTypes) {
                                pSViewTypeStruct = PSModelGlobal.getPSViewType(string);
                                PSDEViewBaseService.this.initDEWFView(pSDataEntity2, (PSCodeItem)object7, pSViewTypeStruct, pSWFDE2, pSCodeList, pSCodeList2, arrayList);
                            }
                            if (!bl) continue;
                            for (String string : initMobWFViewTypes) {
                                pSViewTypeStruct = PSModelGlobal.getPSViewType(string);
                                PSDEViewBaseService.this.initDEWFView(pSDataEntity2, (PSCodeItem)object7, pSViewTypeStruct, pSWFDE2, pSCodeList, pSCodeList2, arrayList);
                            }
                        }
                        break block54;
                    }
                    for (String string : initWFViewTypes) {
                        object = PSModelGlobal.getPSViewType(string);
                        PSDEViewBaseService.this.initDEWFView(pSDataEntity2, null, (PSViewTypeStruct)object, pSWFDE2, pSCodeList, pSCodeList2, arrayList);
                    }
                    if (!bl) break block54;
                    for (String string : initMobWFViewTypes) {
                        object = PSModelGlobal.getPSViewType(string);
                        PSDEViewBaseService.this.initDEWFView(pSDataEntity2, null, (PSViewTypeStruct)object, pSWFDE2, pSCodeList, pSCodeList2, arrayList);
                    }
                }
            }
        });
    }

    /*
     * WARNING - void declaration
     */
    protected void initDEWFView(PSDataEntity pSDataEntity, PSCodeItem pSCodeItem, PSViewTypeStruct pSViewTypeStruct, PSWFDE pSWFDE, PSCodeList pSCodeList, PSCodeList pSCodeList2, ArrayList<PSWFVersion> arrayList) throws Exception {
        boolean bl;
        boolean bl2 = DataObject.getBoolValue((Integer)pSWFDE.getPSWF().getEnableDynaSys(), (boolean)false);
        int n = DataObject.getIntegerValue((Object)pSWFDE.getWFProxyMode(), (Integer)0);
        boolean bl3 = (n & 1) == 1;
        boolean bl4 = bl = n != 1;
        if (bl3) {
            bl2 = false;
        }
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEWFEXPVIEW", (boolean)true) == 0) {
            PSWorkflow pSWorkflow = pSWFDE.getPSWF();
            PSDEViewBase pSDEViewBase = new PSDEViewBase();
            pSDEViewBase.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSDEViewBase.setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getPSViewTypeName(), (Object)pSWorkflow.getPSWorkflowName()));
            if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                pSDEViewBase.setTitle(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getTitle(), (Object)pSWorkflow.getPSWorkflowName()));
            }
            pSDEViewBase.setCodeName(StringHelper.format((String)"%1$s_%2$s", (Object)pSWFDE.getCodeName(), (Object)pSViewTypeStruct.getCodeName()));
            pSDEViewBase.setDyncMode(bl2 ? 1 : 0);
            this.initDEView(pSDataEntity, pSViewTypeStruct, pSWorkflow.getPSWorkflowId(), "", pSDEViewBase, "", "");
            return;
        }
        String string = "";
        if (pSCodeItem != null && StringHelper.isNullOrEmpty((String)(string = pSCodeItem.getCodeName()))) {
            string = pSCodeItem.getCodeItemValue();
        }
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEWFGRIDVIEW", (boolean)true) == 0) {
            String string2;
            PSWorkflow pSWorkflow = pSWFDE.getPSWF();
            ArrayList<PSCodeItem> arrayList2 = StringHelper.format((String)"%1$s:D", (Object)pSWFDE.getCodeName());
            arrayList2 = ((String)((Object)arrayList2)).toUpperCase();
            Iterator<PSCodeItem> iterator = new PSDEViewBase();
            ((PSDEViewBaseBase)((Object)iterator)).setWFViewParam(0);
            ((PSDEViewBaseBase)((Object)iterator)).setPSWFDEId(pSWFDE.getPSWFDEId());
            ((PSDEViewBaseBase)((Object)iterator)).setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getPSViewTypeName(), (Object)pSWorkflow.getPSWorkflowName()));
            if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                ((PSDEViewBaseBase)((Object)iterator)).setTitle(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getTitle(), (Object)pSWorkflow.getPSWorkflowName()));
            }
            ((PSDEViewBaseBase)((Object)iterator)).setCodeName(StringHelper.format((String)"%1$s_D_%2$s", (Object)pSWFDE.getCodeName(), (Object)pSViewTypeStruct.getCodeName()));
            ((PSDEViewBaseBase)((Object)iterator)).setDyncMode(bl2 ? 1 : 0);
            this.initDEView(pSDataEntity, pSViewTypeStruct, pSWorkflow.getPSWorkflowId(), "D", (PSDEViewBase)((Object)iterator), "WFMDATAVIEW", (String)((Object)arrayList2));
            if (pSCodeList2 != null && pSCodeList2.getPSCodeItems() != null) {
                arrayList2 = pSCodeList2.getPSCodeItems();
                for (PSCodeItem pSCodeItem2 : arrayList2) {
                    string2 = StringHelper.format((String)"%1$s:D:%2$s", (Object)pSWFDE.getCodeName(), (Object)pSCodeItem2.getCodeItemValue());
                    string2 = string2.toUpperCase();
                    PSDEViewBase pSDEViewBase = new PSDEViewBase();
                    pSDEViewBase.setWFViewParam(0);
                    pSDEViewBase.setPSWFDEId(pSWFDE.getPSWFDEId());
                    pSDEViewBase.setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s(%3$s:%4$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getPSViewTypeName(), (Object)pSWorkflow.getPSWorkflowName(), (Object)pSCodeItem2.getPSCodeItemName()));
                    if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                        pSDEViewBase.setTitle(StringHelper.format((String)"%1$s%2$s(%3$s:%4$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getTitle(), (Object)pSWorkflow.getPSWorkflowName(), (Object)pSCodeItem2.getPSCodeItemName()));
                    }
                    pSDEViewBase.setCodeName(StringHelper.format((String)"%1$s_D%2$s_%3$s", (Object)pSWFDE.getCodeName(), (Object)pSCodeItem2.getCodeItemValue(), (Object)pSViewTypeStruct.getCodeName()));
                    pSDEViewBase.setDyncMode(bl2 ? 1 : 0);
                    this.initDEView(pSDataEntity, pSViewTypeStruct, pSWorkflow.getPSWorkflowId(), "D:" + pSCodeItem2.getCodeItemValue(), pSDEViewBase, "WFMDATAVIEW", string2);
                }
            }
            arrayList2 = StringHelper.format((String)"%1$s:W", (Object)pSWFDE.getCodeName());
            arrayList2 = ((String)((Object)arrayList2)).toUpperCase();
            iterator = new PSDEViewBase();
            ((PSDEViewBaseBase)((Object)iterator)).setWFViewParam(1);
            ((PSDEViewBaseBase)((Object)iterator)).setPSWFDEId(pSWFDE.getPSWFDEId());
            ((PSDEViewBaseBase)((Object)iterator)).setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getPSViewTypeName(), (Object)pSWorkflow.getPSWorkflowName()));
            if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                ((PSDEViewBaseBase)((Object)iterator)).setTitle(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getTitle(), (Object)pSWorkflow.getPSWorkflowName()));
            }
            ((PSDEViewBaseBase)((Object)iterator)).setCodeName(StringHelper.format((String)"%1$s_W_%2$s", (Object)pSWFDE.getCodeName(), (Object)pSViewTypeStruct.getCodeName()));
            ((PSDEViewBaseBase)((Object)iterator)).setDyncMode(bl2 ? 1 : 0);
            this.initDEView(pSDataEntity, pSViewTypeStruct, pSWorkflow.getPSWorkflowId(), "W", (PSDEViewBase)((Object)iterator), "WFMDATAVIEW", (String)((Object)arrayList2));
            if (pSCodeList != null && pSCodeList.getPSCodeItems() != null) {
                arrayList2 = pSCodeList.getPSCodeItems();
                for (PSCodeItem pSCodeItem2 : arrayList2) {
                    string2 = StringHelper.format((String)"%1$s:W:%2$s", (Object)pSWFDE.getCodeName(), (Object)pSCodeItem2.getCodeItemValue());
                    string2 = string2.toUpperCase();
                    PSDEViewBase pSWFVersion = new PSDEViewBase();
                    pSWFVersion.setWFViewParam(1);
                    pSWFVersion.setWFViewParam3(pSCodeItem2.getCodeItemValue());
                    pSWFVersion.setPSWFDEId(pSWFDE.getPSWFDEId());
                    pSWFVersion.setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s(%3$s:%4$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getPSViewTypeName(), (Object)pSWorkflow.getPSWorkflowName(), (Object)pSCodeItem2.getPSCodeItemName()));
                    if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                        pSWFVersion.setTitle(StringHelper.format((String)"%1$s%2$s(%3$s:%4$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getTitle(), (Object)pSWorkflow.getPSWorkflowName(), (Object)pSCodeItem2.getPSCodeItemName()));
                    }
                    pSWFVersion.setCodeName(StringHelper.format((String)"%1$s_W%2$s_%3$s", (Object)pSWFDE.getCodeName(), (Object)pSCodeItem2.getCodeItemValue(), (Object)pSViewTypeStruct.getCodeName()));
                    this.initDEView(pSDataEntity, pSViewTypeStruct, pSWorkflow.getPSWorkflowId(), "W:" + pSCodeItem2.getCodeItemValue(), pSWFVersion, "WFMDATAVIEW", string2);
                }
            }
            return;
        }
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEWFEDITVIEW", (boolean)true) == 0 || StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEWFEDITVIEW2", (boolean)true) == 0 || StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEWFEDITVIEW3", (boolean)true) == 0 || StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEWFEDITVIEW4", (boolean)true) == 0) {
            PSWorkflow pSWorkflow = pSWFDE.getPSWF();
            PSViewTypeStruct pSViewTypeStruct2 = pSViewTypeStruct;
            if (!StringHelper.isNullOrEmpty((String)pSWorkflow.getWFEditViewType())) {
                pSViewTypeStruct2 = PSModelGlobal.getPSViewType(pSWorkflow.getWFEditViewType());
            }
            Object object2 = StringHelper.format((String)"%1$s:D", (Object)pSWFDE.getCodeName());
            if (pSCodeItem != null) {
                object2 = StringHelper.format((String)"%1$s:%2$s", (Object)pSCodeItem.getCodeItemValue(), (Object)object2);
            }
            object2 = ((String)object2).toUpperCase();
            Object object3 = new PSDEViewBase();
            ((PSDEViewBaseBase)object3).setWFViewParam(0);
            ((PSDEViewBaseBase)object3).setPSWFDEId(pSWFDE.getPSWFDEId());
            if (pSCodeItem != null) {
                ((PSDEViewBaseBase)object3).setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s(%3$s)(%4$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct2.getPSViewTypeName(), (Object)pSCodeItem.getPSCodeItemName(), (Object)pSWorkflow.getPSWorkflowName()));
                if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                    ((PSDEViewBaseBase)object3).setTitle(StringHelper.format((String)"%1$s%2$s(%3$s)(%4$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct2.getTitle(), (Object)pSCodeItem.getPSCodeItemName(), (Object)pSWorkflow.getPSWorkflowName()));
                }
            } else {
                ((PSDEViewBaseBase)object3).setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct2.getPSViewTypeName(), (Object)pSWorkflow.getPSWorkflowName()));
                if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                    ((PSDEViewBaseBase)object3).setTitle(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct2.getTitle(), (Object)pSWorkflow.getPSWorkflowName()));
                }
            }
            if (pSCodeItem != null) {
                ((PSDEViewBaseBase)object3).setCodeName(StringHelper.format((String)"%3$s_%1$s_D_%2$s", (Object)pSWFDE.getCodeName(), (Object)pSViewTypeStruct2.getCodeName(), (Object)string));
            } else {
                ((PSDEViewBaseBase)object3).setCodeName(StringHelper.format((String)"%1$s_D_%2$s", (Object)pSWFDE.getCodeName(), (Object)pSViewTypeStruct2.getCodeName()));
            }
            Object object4 = "";
            object4 = pSCodeItem != null ? StringHelper.format((String)"%1$s:D", (Object)pSCodeItem.getCodeItemValue()) : StringHelper.format((String)"D");
            ((PSDEViewBaseBase)object3).setDyncMode(bl2 ? 1 : 0);
            this.initDEView(pSDataEntity, pSViewTypeStruct2, pSWorkflow.getPSWorkflowId(), (String)object4, (PSDEViewBase)object3, "WFEDITVIEW", (String)object2);
            if (bl3) {
                void var18_39;
                object2 = PSModelGlobal.getPSViewType("DEWFEDITVIEW9");
                object3 = StringHelper.format((String)"%1$s:ED", (Object)pSWFDE.getCodeName());
                if (pSCodeItem != null) {
                    object3 = StringHelper.format((String)"%1$s:%2$s", (Object)pSCodeItem.getCodeItemValue(), (Object)object3);
                }
                object3 = ((String)object3).toUpperCase();
                object4 = new PSDEViewBase();
                ((PSDEViewBaseBase)object4).setWFViewParam(0);
                ((PSDEViewBaseBase)object4).setPSWFDEId(pSWFDE.getPSWFDEId());
                if (pSCodeItem != null) {
                    ((PSDEViewBaseBase)object4).setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s(%3$s)(%4$s)", (Object)pSDataEntity.getLogicName(), (Object)((PSViewTypeBase)object2).getPSViewTypeName(), (Object)pSCodeItem.getPSCodeItemName(), (Object)pSWorkflow.getPSWorkflowName()));
                    if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                        ((PSDEViewBaseBase)object4).setTitle(StringHelper.format((String)"%1$s%2$s(%3$s)(%4$s)", (Object)pSDataEntity.getLogicName(), (Object)((PSViewTypeBase)object2).getTitle(), (Object)pSCodeItem.getPSCodeItemName(), (Object)pSWorkflow.getPSWorkflowName()));
                    }
                } else {
                    ((PSDEViewBaseBase)object4).setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)((PSViewTypeBase)object2).getPSViewTypeName(), (Object)pSWorkflow.getPSWorkflowName()));
                    if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                        ((PSDEViewBaseBase)object4).setTitle(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)((PSViewTypeBase)object2).getTitle(), (Object)pSWorkflow.getPSWorkflowName()));
                    }
                }
                if (pSCodeItem != null) {
                    ((PSDEViewBaseBase)object4).setCodeName(StringHelper.format((String)"%3$s_%1$s_ED_%2$s", (Object)pSWFDE.getCodeName(), (Object)((PSViewTypeBase)object2).getCodeName(), (Object)string));
                } else {
                    ((PSDEViewBaseBase)object4).setCodeName(StringHelper.format((String)"%1$s_ED_%2$s", (Object)pSWFDE.getCodeName(), (Object)((PSViewTypeBase)object2).getCodeName()));
                }
                String pSDEViewBase = "";
                if (pSCodeItem != null) {
                    String string2 = StringHelper.format((String)"%1$s:ED", (Object)pSCodeItem.getCodeItemValue());
                } else {
                    String string3 = StringHelper.format((String)"ED");
                }
                ((PSDEViewBaseBase)object4).setDyncMode(bl2 ? 1 : 0);
                this.initDEView(pSDataEntity, (PSViewTypeStruct)object2, pSWorkflow.getPSWorkflowId(), (String)var18_39, (PSDEViewBase)object4, "WFEDITVIEW", (String)object3);
            }
            if (bl && pSCodeList != null && pSCodeList.getPSCodeItems() != null) {
                object2 = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
                object3 = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
                for (PSWFVersion pSWFVersion : arrayList) {
                    int n2 = pSWFVersion.getWFVersion();
                    HashMap<String, PSWFProcess> hashMap = new HashMap<String, PSWFProcess>();
                    ArrayList<PSWFProcess> arrayList2 = ((PSWFProcessServiceBase)object2).selectByPSWFVersion(pSWFVersion);
                    for (PSWFProcess pSWFProcess : arrayList2) {
                        if (StringHelper.isNullOrEmpty((String)pSWFProcess.getWFStepValue())) continue;
                        hashMap.put(pSWFProcess.getWFStepValue(), pSWFProcess);
                    }
                    ArrayList<PSCodeItem> arrayList3 = pSCodeList.getPSCodeItems();
                    Iterator iterator = arrayList3.iterator();
                    while (iterator.hasNext()) {
                        PSCodeItem pSCodeItem2 = (PSCodeItem)iterator.next();
                        PSWFProcess pSWFProcess = (PSWFProcess)hashMap.get(pSCodeItem2.getCodeItemValue());
                        if (pSWFProcess == null) continue;
                        PSViewTypeStruct pSViewTypeStruct3 = pSViewTypeStruct2;
                        if (!StringHelper.isNullOrEmpty((String)pSWFProcess.getWFEditViewType())) {
                            pSViewTypeStruct3 = PSModelGlobal.getPSViewType(pSWFProcess.getWFEditViewType());
                        }
                        String string4 = StringHelper.format((String)"%1$s:%3$sW:%2$s", (Object)pSWFDE.getCodeName(), (Object)pSCodeItem2.getCodeItemValue(), (Object)(n2 == 1 ? "" : Integer.valueOf(n2)));
                        if (pSCodeItem != null) {
                            string4 = StringHelper.format((String)"%1$s:%2$s", (Object)pSCodeItem.getCodeItemValue(), (Object)string4);
                        }
                        string4 = string4.toUpperCase();
                        PSDEViewBase pSDEViewBase = new PSDEViewBase();
                        pSDEViewBase.setWFViewParam(1);
                        pSDEViewBase.setWFViewParam3(pSCodeItem2.getCodeItemValue());
                        pSDEViewBase.setPSWFDEId(pSWFDE.getPSWFDEId());
                        pSDEViewBase.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
                        pSDEViewBase.setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                        if (pSCodeItem != null) {
                            pSDEViewBase.setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s(%3$s)(%4$sv%6$s:%5$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct3.getPSViewTypeName(), (Object)pSCodeItem.getPSCodeItemName(), (Object)pSWorkflow.getPSWorkflowName(), (Object)pSCodeItem2.getPSCodeItemName(), (Object)n2));
                            if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                                pSDEViewBase.setTitle(StringHelper.format((String)"%1$s%2$s(%3$s)(%4$sv%6$s:%5$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct3.getTitle(), (Object)pSCodeItem.getPSCodeItemName(), (Object)pSWorkflow.getPSWorkflowName(), (Object)pSCodeItem2.getPSCodeItemName(), (Object)n2));
                            }
                        } else {
                            pSDEViewBase.setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s(%3$sv%5$s:%4$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct3.getPSViewTypeName(), (Object)pSWorkflow.getPSWorkflowName(), (Object)pSCodeItem2.getPSCodeItemName(), (Object)n2));
                            if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                                pSDEViewBase.setTitle(StringHelper.format((String)"%1$s%2$s(%3$sv%5$s:%4$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct3.getTitle(), (Object)pSWorkflow.getPSWorkflowName(), (Object)pSCodeItem2.getPSCodeItemName(), (Object)n2));
                            }
                        }
                        if (pSCodeItem != null) {
                            pSDEViewBase.setCodeName(StringHelper.format((String)"%4$s_%1$s_%5$sW%2$s_%3$s", (Object)pSWFDE.getCodeName(), (Object)pSCodeItem2.getCodeItemValue(), (Object)pSViewTypeStruct3.getCodeName(), (Object)string, (Object)(n2 == 1 ? "" : Integer.valueOf(n2))));
                        } else {
                            pSDEViewBase.setCodeName(StringHelper.format((String)"%1$s_%4$sW%2$s_%3$s", (Object)pSWFDE.getCodeName(), (Object)pSCodeItem2.getCodeItemValue(), (Object)pSViewTypeStruct3.getCodeName(), (Object)(n2 == 1 ? "" : Integer.valueOf(n2))));
                        }
                        String string5 = "";
                        string5 = pSCodeItem != null ? StringHelper.format((String)"%1$s:%3$sD:%2$s", (Object)pSCodeItem.getCodeItemValue(), (Object)pSCodeItem2.getCodeItemValue(), (Object)(n2 == 1 ? "" : Integer.valueOf(n2))) : StringHelper.format((String)"%2$sW:%1$s", (Object)pSCodeItem2.getCodeItemValue(), (Object)(n2 == 1 ? "" : Integer.valueOf(n2)));
                        PSDEViewBase pSDEViewBase2 = this.initDEView(pSDataEntity, pSViewTypeStruct3, pSWorkflow.getPSWorkflowId(), string5, pSDEViewBase, "WFEDITVIEW", string4);
                        if (pSDEViewBase2 == null || pSWFProcess == null || StringHelper.isNullOrEmpty((String)pSWFProcess.getPSDEFormId())) continue;
                        PSDEViewCtrl pSDEViewCtrl = new PSDEViewCtrl();
                        pSDEViewCtrl.setPSDEViewBaseId(pSDEViewBase2.getPSDEViewBaseId());
                        pSDEViewCtrl.setPSDEViewCtrlType("FORM");
                        if (!((PSCoreSysServiceBaseBase)((Object)object3)).select(pSDEViewCtrl, true) || StringHelper.compare((String)pSWFProcess.getPSDEFormId(), (String)pSDEViewCtrl.getPSDEFormId(), (boolean)false) == 0) continue;
                        pSDEViewCtrl.setPSDEFormId(pSWFProcess.getPSDEFormId());
                        pSDEViewCtrl.setPSDEFormName(pSWFProcess.getPSDEFormName());
                        ((PSCoreSysServiceBase)object3).update(pSDEViewCtrl, false);
                    }
                }
            } else if (bl3) {
                object2 = pSViewTypeStruct2;
                object3 = StringHelper.format((String)"%1$s:W", (Object)pSWFDE.getCodeName());
                object3 = ((String)object3).toUpperCase();
                object4 = new PSDEViewBase();
                ((PSDEViewBaseBase)object4).setWFViewParam(1);
                ((PSDEViewBaseBase)object4).setPSWFDEId(pSWFDE.getPSWFDEId());
                ((PSDEViewBaseBase)object4).setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)((PSViewTypeBase)object2).getPSViewTypeName(), (Object)pSWorkflow.getPSWorkflowName()));
                if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                    ((PSDEViewBaseBase)object4).setTitle(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)((PSViewTypeBase)object2).getTitle(), (Object)pSWorkflow.getPSWorkflowName()));
                }
                ((PSDEViewBaseBase)object4).setCodeName(StringHelper.format((String)"%1$s_W_%2$s", (Object)pSWFDE.getCodeName(), (Object)((PSViewTypeBase)object2).getCodeName()));
                String string6 = "W";
                ((PSDEViewBaseBase)object4).setDyncMode(bl2 ? 1 : 0);
                PSDEViewBase pSDEViewBase = this.initDEView(pSDataEntity, (PSViewTypeStruct)object2, pSWorkflow.getPSWorkflowId(), string6, (PSDEViewBase)object4, "WFEDITVIEW", (String)object3);
            } else if (bl2 && arrayList.size() > 0) {
                object2 = arrayList.get(0);
                object3 = pSViewTypeStruct2;
                object4 = StringHelper.format((String)"%1$s:W", (Object)pSWFDE.getCodeName());
                object4 = ((String)object4).toUpperCase();
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setWFViewParam(1);
                pSDEViewBase.setPSWFDEId(pSWFDE.getPSWFDEId());
                pSDEViewBase.setPSWFVersionId(((PSWFVersionBase)object2).getPSWFVersionId());
                pSDEViewBase.setPSWFVersionName(((PSWFVersionBase)object2).getPSWFVersionName());
                pSDEViewBase.setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)((PSViewTypeBase)object3).getPSViewTypeName(), (Object)pSWorkflow.getPSWorkflowName()));
                if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                    pSDEViewBase.setTitle(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)((PSViewTypeBase)object3).getTitle(), (Object)pSWorkflow.getPSWorkflowName()));
                }
                pSDEViewBase.setCodeName(StringHelper.format((String)"%1$s_W_%2$s", (Object)pSWFDE.getCodeName(), (Object)((PSViewTypeBase)object3).getCodeName()));
                String string7 = "W";
                pSDEViewBase.setDyncMode(bl2 ? 1 : 0);
                PSDEViewBase pSDEViewBase3 = this.initDEView(pSDataEntity, (PSViewTypeStruct)object3, pSWorkflow.getPSWorkflowId(), string7, pSDEViewBase, "WFEDITVIEW", (String)object4);
            }
            return;
        }
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEMOBWFMDVIEW", (boolean)true) == 0) {
            PSWorkflow pSWorkflow = pSWFDE.getPSWF();
            String string6 = StringHelper.format((String)"%1$s:D", (Object)pSWFDE.getCodeName());
            string6 = string6.toUpperCase();
            PSDEViewBase pSDEViewBase = new PSDEViewBase();
            pSDEViewBase.setWFViewParam(0);
            pSDEViewBase.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSDEViewBase.setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getPSViewTypeName(), (Object)pSWorkflow.getPSWorkflowName()));
            if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                pSDEViewBase.setTitle(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getTitle(), (Object)pSWorkflow.getPSWorkflowName()));
            }
            pSDEViewBase.setCodeName(StringHelper.format((String)"%1$s_D_%2$s", (Object)pSWFDE.getCodeName(), (Object)pSViewTypeStruct.getCodeName()));
            pSDEViewBase.setDyncMode(bl2 ? 1 : 0);
            this.initDEView(pSDataEntity, pSViewTypeStruct, pSWorkflow.getPSWorkflowId(), "D", pSDEViewBase, "MOBWFMDATAVIEW", string6);
            string6 = StringHelper.format((String)"%1$s:W", (Object)pSWFDE.getCodeName());
            string6 = string6.toUpperCase();
            pSDEViewBase = new PSDEViewBase();
            pSDEViewBase.setWFViewParam(1);
            pSDEViewBase.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSDEViewBase.setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getPSViewTypeName(), (Object)pSWorkflow.getPSWorkflowName()));
            if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                pSDEViewBase.setTitle(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getTitle(), (Object)pSWorkflow.getPSWorkflowName()));
            }
            pSDEViewBase.setCodeName(StringHelper.format((String)"%1$s_W_%2$s", (Object)pSWFDE.getCodeName(), (Object)pSViewTypeStruct.getCodeName()));
            pSDEViewBase.setDyncMode(bl2 ? 1 : 0);
            this.initDEView(pSDataEntity, pSViewTypeStruct, pSWorkflow.getPSWorkflowId(), "W", pSDEViewBase, "MOBWFMDATAVIEW", string6);
            return;
        }
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEMOBWFEDITVIEW", (boolean)true) == 0 || StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEMOBWFEDITVIEW2", (boolean)true) == 0 || StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEMOBWFEDITVIEW3", (boolean)true) == 0 || StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEMOBWFEDITVIEW4", (boolean)true) == 0) {
            PSWorkflow pSWorkflow = pSWFDE.getPSWF();
            PSViewTypeStruct pSViewTypeStruct4 = pSViewTypeStruct;
            if (!StringHelper.isNullOrEmpty((String)pSWorkflow.getMobWFEditViewType())) {
                pSViewTypeStruct4 = PSModelGlobal.getPSViewType(pSWorkflow.getMobWFEditViewType());
            }
            Object object = StringHelper.format((String)"%1$s:D", (Object)pSWFDE.getCodeName());
            if (pSCodeItem != null) {
                object = StringHelper.format((String)"%1$s:%2$s", (Object)pSCodeItem.getCodeItemValue(), (Object)object);
            }
            object = ((String)object).toUpperCase();
            Object object7 = new PSDEViewBase();
            ((PSDEViewBaseBase)object7).setWFViewParam(0);
            ((PSDEViewBaseBase)object7).setPSWFDEId(pSWFDE.getPSWFDEId());
            if (pSCodeItem != null) {
                ((PSDEViewBaseBase)object7).setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s(%3$s)(%4$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct4.getPSViewTypeName(), (Object)pSCodeItem.getPSCodeItemName(), (Object)pSWorkflow.getPSWorkflowName()));
                if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct4.getTitle())) {
                    ((PSDEViewBaseBase)object7).setTitle(StringHelper.format((String)"%1$s%2$s(%3$s)(%4$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct4.getTitle(), (Object)pSCodeItem.getPSCodeItemName(), (Object)pSWorkflow.getPSWorkflowName()));
                }
            } else {
                ((PSDEViewBaseBase)object7).setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct4.getPSViewTypeName(), (Object)pSWorkflow.getPSWorkflowName()));
                if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct4.getTitle())) {
                    ((PSDEViewBaseBase)object7).setTitle(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct4.getTitle(), (Object)pSWorkflow.getPSWorkflowName()));
                }
            }
            if (pSCodeItem != null) {
                ((PSDEViewBaseBase)object7).setCodeName(StringHelper.format((String)"%3$s_%1$s_D_%2$s", (Object)pSWFDE.getCodeName(), (Object)pSViewTypeStruct4.getCodeName(), (Object)string));
            } else {
                ((PSDEViewBaseBase)object7).setCodeName(StringHelper.format((String)"%1$s_D_%2$s", (Object)pSWFDE.getCodeName(), (Object)pSViewTypeStruct4.getCodeName()));
            }
            Object object8 = "";
            object8 = pSCodeItem != null ? StringHelper.format((String)"%1$s:D", (Object)pSCodeItem.getCodeItemValue()) : StringHelper.format((String)"D");
            this.initDEView(pSDataEntity, pSViewTypeStruct4, pSWorkflow.getPSWorkflowId(), (String)object8, (PSDEViewBase)object7, "MOBWFEDITVIEW", (String)object);
            if (pSCodeList != null && pSCodeList.getPSCodeItems() != null) {
                object = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
                object7 = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
                for (PSWFVersion pSWFVersion : arrayList) {
                    int n3 = pSWFVersion.getWFVersion();
                    HashMap<String, PSWFProcess> hashMap = new HashMap<String, PSWFProcess>();
                    ArrayList<PSWFProcess> arrayList4 = ((PSWFProcessServiceBase)object).selectByPSWFVersion(pSWFVersion);
                    for (PSWFProcess pSWFProcess : arrayList4) {
                        if (StringHelper.isNullOrEmpty((String)pSWFProcess.getWFStepValue())) continue;
                        hashMap.put(pSWFProcess.getWFStepValue(), pSWFProcess);
                    }
                    ArrayList<PSCodeItem> arrayList5 = pSCodeList.getPSCodeItems();
                    Iterator iterator = arrayList5.iterator();
                    while (iterator.hasNext()) {
                        PSCodeItem pSCodeItem3 = (PSCodeItem)iterator.next();
                        PSWFProcess pSWFProcess = (PSWFProcess)hashMap.get(pSCodeItem3.getCodeItemValue());
                        if (pSWFProcess == null) continue;
                        String string8 = StringHelper.format((String)"%1$s:%3$sW:%2$s", (Object)pSWFDE.getCodeName(), (Object)pSCodeItem3.getCodeItemValue(), (Object)(n3 == 1 ? "" : Integer.valueOf(n3)));
                        if (pSCodeItem != null) {
                            string8 = StringHelper.format((String)"%1$s:%2$s", (Object)pSCodeItem.getCodeItemValue(), (Object)string8);
                        }
                        string8 = string8.toUpperCase();
                        PSDEViewBase pSDEViewBase = new PSDEViewBase();
                        pSDEViewBase.setWFViewParam(1);
                        pSDEViewBase.setWFViewParam3(pSCodeItem3.getCodeItemValue());
                        pSDEViewBase.setPSWFDEId(pSWFDE.getPSWFDEId());
                        pSDEViewBase.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
                        pSDEViewBase.setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                        if (pSCodeItem != null) {
                            pSDEViewBase.setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s(%3$s)(%4$sv%6$s:%5$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct4.getPSViewTypeName(), (Object)pSCodeItem.getPSCodeItemName(), (Object)pSWorkflow.getPSWorkflowName(), (Object)pSCodeItem3.getPSCodeItemName(), (Object)n3));
                            if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct4.getTitle())) {
                                pSDEViewBase.setTitle(StringHelper.format((String)"%1$s%2$s(%3$s)(%4$sv%6$s:%5$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct4.getTitle(), (Object)pSCodeItem.getPSCodeItemName(), (Object)pSWorkflow.getPSWorkflowName(), (Object)pSCodeItem3.getPSCodeItemName(), (Object)n3));
                            }
                        } else {
                            pSDEViewBase.setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s(%3$sv%5$s:%4$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct4.getPSViewTypeName(), (Object)pSWorkflow.getPSWorkflowName(), (Object)pSCodeItem3.getPSCodeItemName(), (Object)n3));
                            if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct4.getTitle())) {
                                pSDEViewBase.setTitle(StringHelper.format((String)"%1$s%2$s(%3$sv%5$s:%4$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct4.getTitle(), (Object)pSWorkflow.getPSWorkflowName(), (Object)pSCodeItem3.getPSCodeItemName(), (Object)n3));
                            }
                        }
                        if (pSCodeItem != null) {
                            pSDEViewBase.setCodeName(StringHelper.format((String)"%4$s_%1$s_%5$sW%2$s_%3$s", (Object)pSWFDE.getCodeName(), (Object)pSCodeItem3.getCodeItemValue(), (Object)pSViewTypeStruct4.getCodeName(), (Object)string, (Object)(n3 == 1 ? "" : Integer.valueOf(n3))));
                        } else {
                            pSDEViewBase.setCodeName(StringHelper.format((String)"%1$s_%4$sW%2$s_%3$s", (Object)pSWFDE.getCodeName(), (Object)pSCodeItem3.getCodeItemValue(), (Object)pSViewTypeStruct4.getCodeName(), (Object)(n3 == 1 ? "" : Integer.valueOf(n3))));
                        }
                        String string9 = "";
                        string9 = pSCodeItem != null ? StringHelper.format((String)"%1$s:%3$sD:%2$s", (Object)pSCodeItem.getCodeItemValue(), (Object)pSCodeItem3.getCodeItemValue(), (Object)(n3 == 1 ? "" : Integer.valueOf(n3))) : StringHelper.format((String)"%2$sW:%1$s", (Object)pSCodeItem3.getCodeItemValue(), (Object)(n3 == 1 ? "" : Integer.valueOf(n3)));
                        PSDEViewBase pSDEViewBase4 = this.initDEView(pSDataEntity, pSViewTypeStruct4, pSWorkflow.getPSWorkflowId(), string9, pSDEViewBase, "MOBWFEDITVIEW", string8);
                        if (pSDEViewBase4 == null || pSWFProcess == null || StringHelper.isNullOrEmpty((String)pSWFProcess.getMobPSDEFormId())) continue;
                        PSDEViewCtrl pSDEViewCtrl = new PSDEViewCtrl();
                        pSDEViewCtrl.setPSDEViewBaseId(pSDEViewBase4.getPSDEViewBaseId());
                        pSDEViewCtrl.setPSDEViewCtrlType("FORM");
                        if (!((PSCoreSysServiceBaseBase)((Object)object7)).select(pSDEViewCtrl, true) || StringHelper.compare((String)pSWFProcess.getMobPSDEFormId(), (String)pSDEViewCtrl.getPSDEFormId(), (boolean)false) == 0) continue;
                        pSDEViewCtrl.setPSDEFormId(pSWFProcess.getMobPSDEFormId());
                        pSDEViewCtrl.setPSDEFormName(pSWFProcess.getMobPSDEFormName());
                        ((PSCoreSysServiceBase)object7).update(pSDEViewCtrl, false);
                    }
                }
            } else if (bl2 && arrayList.size() > 0) {
                object = arrayList.get(0);
                object7 = pSViewTypeStruct4;
                object8 = StringHelper.format((String)"%1$s:W", (Object)pSWFDE.getCodeName());
                object8 = ((String)object8).toUpperCase();
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setWFViewParam(1);
                pSDEViewBase.setPSWFDEId(pSWFDE.getPSWFDEId());
                pSDEViewBase.setPSWFVersionId(((PSWFVersionBase)object).getPSWFVersionId());
                pSDEViewBase.setPSWFVersionName(((PSWFVersionBase)object).getPSWFVersionName());
                pSDEViewBase.setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)((PSViewTypeBase)object7).getPSViewTypeName(), (Object)pSWorkflow.getPSWorkflowName()));
                if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                    pSDEViewBase.setTitle(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)((PSViewTypeBase)object7).getTitle(), (Object)pSWorkflow.getPSWorkflowName()));
                }
                pSDEViewBase.setCodeName(StringHelper.format((String)"%1$s_W_%2$s", (Object)pSWFDE.getCodeName(), (Object)((PSViewTypeBase)object7).getCodeName()));
                String string10 = "W";
                pSDEViewBase.setDyncMode(bl2 ? 1 : 0);
                PSDEViewBase pSDEViewBase5 = this.initDEView(pSDataEntity, (PSViewTypeStruct)object7, pSWorkflow.getPSWorkflowId(), string10, pSDEViewBase, "MOBWFEDITVIEW", (String)object8);
            }
            return;
        }
    }

    public void initDEMSViews(PSDEMainState pSDEMainState, PSDataEntity pSDataEntity) throws Exception {
        final PSDEMainState pSDEMainState2 = pSDEMainState;
        final PSDataEntity pSDataEntity2 = pSDataEntity != null ? pSDataEntity : pSDEMainState.getPSDE();
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (StringHelper.isNullOrEmpty((String)pSDEMainState2.getEditViewType())) {
                    for (String string : initMSViewTypes) {
                        PSViewTypeStruct pSViewTypeStruct = PSModelGlobal.getPSViewType(string);
                        PSDEViewBaseService.this.initDMSView(pSDataEntity2, pSViewTypeStruct, pSDEMainState2);
                    }
                } else {
                    PSViewTypeStruct pSViewTypeStruct = PSModelGlobal.getPSViewType(pSDEMainState2.getEditViewType());
                    PSDEViewBaseService.this.initDMSView(pSDataEntity2, pSViewTypeStruct, pSDEMainState2);
                }
            }
        });
    }

    protected void initDMSView(PSDataEntity pSDataEntity, PSViewTypeStruct pSViewTypeStruct, PSDEMainState pSDEMainState) throws Exception {
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEEDITVIEW", (boolean)true) == 0 || StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEEDITVIEW2", (boolean)true) == 0 || StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEEDITVIEW3", (boolean)true) == 0 || StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEEDITVIEW4", (boolean)true) == 0) {
            String string = StringHelper.format((String)"MSTAG:%1$s", (Object)pSDEMainState.getMSTag());
            string = string.toUpperCase();
            PSDEViewBase pSDEViewBase = new PSDEViewBase();
            pSDEViewBase.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
            pSDEViewBase.setPSDEViewBaseName(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getPSViewTypeName(), (Object)pSDEMainState.getPSDEMainStateName()));
            if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                pSDEViewBase.setTitle(StringHelper.format((String)"%1$s%2$s(%3$s)", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getTitle(), (Object)pSDEMainState.getPSDEMainStateName()));
            }
            pSDEViewBase.setCodeName(StringHelper.format((String)"%1$s%2$s", (Object)pSDEMainState.getCodeName(), (Object)pSViewTypeStruct.getCodeName()));
            PSDEViewBase pSDEViewBase2 = this.initDEView(pSDataEntity, pSViewTypeStruct, pSDEMainState.getPSDEMainStateId(), "", pSDEViewBase, "EDITVIEW", string);
            if (pSDEViewBase2 != null && pSDEMainState != null && !StringHelper.isNullOrEmpty((String)pSDEMainState.getPSDEFormId())) {
                PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
                PSDEViewCtrl pSDEViewCtrl = new PSDEViewCtrl();
                pSDEViewCtrl.setPSDEViewBaseId(pSDEViewBase2.getPSDEViewBaseId());
                pSDEViewCtrl.setPSDEViewCtrlType("FORM");
                if (pSDEViewCtrlService.select(pSDEViewCtrl, true) && StringHelper.compare((String)pSDEMainState.getPSDEFormId(), (String)pSDEViewCtrl.getPSDEFormId(), (boolean)false) != 0) {
                    pSDEViewCtrl.setPSDEFormId(pSDEMainState.getPSDEFormId());
                    pSDEViewCtrl.setPSDEFormName(pSDEMainState.getPSDEFormName());
                    pSDEViewCtrlService.update(pSDEViewCtrl, false);
                }
            }
            return;
        }
    }

    @Override
    protected void onBeforeRemove(PSDEViewBase pSDEViewBase) throws Exception {
        PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEViewCtrl> arrayList = pSDEViewCtrlService.selectByPSDEViewBase(pSDEViewBase);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            if (!DataObject.getBoolValue((Integer)pSDEViewCtrl.getDefaultFlag(), (boolean)false)) continue;
            pSDEViewCtrl.setDefaultFlag(0);
            pSDEViewCtrlService.update(pSDEViewCtrl, false);
        }
        super.onBeforeRemove(pSDEViewBase);
    }

    @Override
    protected void onBeforeRemoveTemp(PSDEViewBase pSDEViewBase) throws Exception {
        PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEViewCtrl> arrayList = pSDEViewCtrlService.selectTempByPSDEViewBase(pSDEViewBase);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            if (!DataObject.getBoolValue((Integer)pSDEViewCtrl.getDefaultFlag(), (boolean)false)) continue;
            pSDEViewCtrl.setDefaultFlag(0);
            pSDEViewCtrlService.updateTemp((IEntity)pSDEViewCtrl, false);
        }
        super.onBeforeRemoveTemp(pSDEViewBase);
    }

    @Override
    protected void onAfterCreate(PSDEViewBase pSDEViewBase) throws Exception {
        super.onAfterCreate(pSDEViewBase);
    }

    @Override
    protected void onAfterUpdate(PSDEViewBase pSDEViewBase) throws Exception {
        String string = pSDEViewBase.getPSDE().getCodeName() + pSDEViewBase.getCodeName();
        PSAppDEViewService pSAppDEViewService = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
        ArrayList arrayList = pSAppDEViewService.selectByPSDEViewBase(pSDEViewBase);
        for (PSAppDEView pSAppDEView : arrayList) {
            if (!DataObject.getBoolValue((Integer)pSAppDEView.getSyncCodeName(), (boolean)true) || StringHelper.compare((String)pSAppDEView.getPSAppDEViewName(), (String)string, (boolean)false) == 0) continue;
            PSAppDEView pSAppDEView2 = new PSAppDEView();
            pSAppDEView2.setPSAppDEViewId(pSAppDEView.getPSAppDEViewId());
            pSAppDEView2.setPSAppDEViewName(string);
            pSAppDEViewService.update(pSAppDEView2, false);
        }
        super.onAfterUpdate(pSDEViewBase);
    }

    protected void onAfterUpdateTempMajor(PSDEViewBase pSDEViewBase) throws Exception {
        if (!DataObject.getBoolValue((Integer)pSDEViewBase.getDyncMode(), (boolean)false)) {
            return;
        }
        PSAppDEViewService pSAppDEViewService = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
        ArrayList arrayList = pSAppDEViewService.selectByPSDEViewBase(pSDEViewBase);
        for (PSAppDEView pSAppDEView : arrayList) {
            pSAppDEViewService.initDynaView(pSAppDEView);
        }
        super.onAfterUpdateTempMajor((IEntity)pSDEViewBase);
    }

    @Override
    protected void onJITPreview(PSDEViewBase pSDEViewBase) throws Exception {
        if (this.getWebContext() == null || this.getWebContext().getCurAjaxActionResult() == null) {
            throw new Exception("\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u4e0d\u6b63\u786e");
        }
        String string = pSDEViewBase.getPSDEViewBaseId();
        if (KeyValueHelper.isTempKey((String)pSDEViewBase.getPSDEViewBaseId())) {
            this.getTemp((IEntity)pSDEViewBase);
            string = (String)EntityBase.getOriginKey((IEntity)pSDEViewBase);
            if (StringHelper.isNullOrEmpty((String)string)) {
                throw new Exception(StringHelper.format((String)"\u5b9e\u4f53\u89c6\u56fe\u8fd8\u672a\u4fdd\u5b58"));
            }
        }
        PSDEViewBase pSDEViewBase2 = new PSDEViewBase();
        pSDEViewBase2.setPSDEViewBaseId(string);
        this.get((IEntity)pSDEViewBase2);
        PSAppDEViewService pSAppDEViewService = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
        ArrayList arrayList = pSAppDEViewService.selectByPSDEViewBase(pSDEViewBase2);
        if (arrayList.size() == 0) {
            throw new Exception("\u5b9e\u4f53\u89c6\u56fe\u8fd8\u672a\u52a0\u5165\u5230\u5e94\u7528");
        }
        PSSysApp pSSysApp = null;
        PSAppDEView pSAppDEView = null;
        for (PSAppDEView pSAppDEView2 : arrayList) {
            if (pSSysApp == null) {
                pSSysApp = pSAppDEView2.getPSSysApp();
                pSAppDEView = pSAppDEView2;
                if (!DataObject.getBoolValue((Integer)pSSysApp.getDefaultPub(), (boolean)false)) continue;
                break;
            }
            PSSysApp pSSysApp2 = pSAppDEView2.getPSSysApp();
            if (!DataObject.getBoolValue((Integer)pSSysApp2.getDefaultPub(), (boolean)false)) continue;
            pSSysApp = pSSysApp2;
            pSAppDEView = pSAppDEView2;
            break;
        }
        pSAppDEViewService.jITPreview(pSAppDEView);
    }

    protected void fillDEViewCtrlParams(PSDEViewCtrl pSDEViewCtrl, PSVTCtrl pSVTCtrl) throws Exception {
        if (pSVTCtrl.getCtrlParam() != null) {
            pSDEViewCtrl.setCtrlParam(pSVTCtrl.getCtrlParam());
        }
        if (pSVTCtrl.getCtrlParam2() != null) {
            pSDEViewCtrl.setCtrlParam2(pSVTCtrl.getCtrlParam2());
        }
        if (pSVTCtrl.getCtrlParam3() != null) {
            pSDEViewCtrl.setCtrlParam3(pSVTCtrl.getCtrlParam3());
        }
        if (pSVTCtrl.getCtrlParam4() != null) {
            pSDEViewCtrl.setCtrlParam4(pSVTCtrl.getCtrlParam4());
        }
        if (pSVTCtrl.getCtrlParam5() != null) {
            pSDEViewCtrl.setCtrlParam5(pSVTCtrl.getCtrlParam5());
        }
        if (pSVTCtrl.getCtrlParam6() != null) {
            pSDEViewCtrl.setCtrlParam6(pSVTCtrl.getCtrlParam6());
        }
        if (pSVTCtrl.getCtrlParam7() != null) {
            pSDEViewCtrl.setCtrlParam7(pSVTCtrl.getCtrlParam7());
        }
        if (pSVTCtrl.getCtrlParam8() != null) {
            pSDEViewCtrl.setCtrlParam8(pSVTCtrl.getCtrlParam8());
        }
        if (pSVTCtrl.getCtrlParam9() != null) {
            pSDEViewCtrl.setCtrlParam9(pSVTCtrl.getCtrlParam9());
        }
        if (pSVTCtrl.getCtrlParam10() != null) {
            pSDEViewCtrl.setCtrlParam10(pSVTCtrl.getCtrlParam10());
        }
    }

    @Override
    public void getDraftWithModel(PSDEViewBase pSDEViewBase) throws Exception {
        this.getDraftTempMajor((IEntity)pSDEViewBase);
        pSDEViewBase.setViewModel(this.getViewModel(pSDEViewBase));
    }

    @Override
    public void getWithModel(PSDEViewBase pSDEViewBase) throws Exception {
        if (!KeyValueHelper.isTempKey((String)pSDEViewBase.getPSDEViewBaseId())) {
            this.getTempMajor(pSDEViewBase);
        } else {
            this.getTemp((IEntity)pSDEViewBase);
        }
        pSDEViewBase.setViewModel(this.getViewModel(pSDEViewBase));
    }

    protected String getViewModel(PSDEViewBase pSDEViewBase) throws Exception {
        Object object;
        Serializable serializable;
        Object object2;
        Serializable serializable22;
        Object object3;
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_DEVIEWCONFIG);
        xmlNode.setAttribute("PSDEID", pSDEViewBase.getPSDEId());
        xmlNode.setAttribute("PSSYSTEMID", pSDEViewBase.getPSSystemId());
        xmlNode.setAttribute("PSDEVIEWBASEID", pSDEViewBase.getPSDEViewBaseId());
        PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService((String)PSDEViewCtrlService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEViewCtrl> arrayList = pSDEViewCtrlService.selectTempByPSDEViewBase(pSDEViewBase);
        Collections.sort(arrayList, new Comparator<PSDEViewCtrl>(){

            @Override
            public int compare(PSDEViewCtrl pSDEViewCtrl, PSDEViewCtrl pSDEViewCtrl2) {
                return StringHelper.compare((String)pSDEViewCtrl.getPSDEViewCtrlName(), (String)pSDEViewCtrl2.getPSDEViewCtrlName(), (boolean)false);
            }
        });
        for (PSDEViewCtrl serializable32 : arrayList) {
            object3 = new XmlNode();
            object3.setNodeName(XMLNODE_DEVIEWCTRL);
            serializable32.fillXmlNode((XmlNode)object3, true);
            xmlNode.addNode((XmlNode)object3);
        }
        PSDEViewRVService pSDEViewRVService = (PSDEViewRVService)ServiceGlobal.getService((String)PSDEViewRVService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEViewRV> arrayList2 = pSDEViewRVService.selectTempByMajorPSDEView(pSDEViewBase);
        Collections.sort(arrayList2, new Comparator<PSDEViewRV>(){

            @Override
            public int compare(PSDEViewRV pSDEViewRV, PSDEViewRV pSDEViewRV2) {
                return StringHelper.compare((String)pSDEViewRV.getPSDEViewRVName(), (String)pSDEViewRV2.getPSDEViewRVName(), (boolean)false);
            }
        });
        for (Serializable serializable22 : arrayList2) {
            object2 = new XmlNode();
            object2.setNodeName(XMLNODE_DEVIEWRV);
            serializable22.fillXmlNode((XmlNode)object2, true);
            xmlNode.addNode((XmlNode)object2);
        }
        object3 = (PSDEViewLogicService)ServiceGlobal.getService((String)PSDEViewLogicService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        serializable22 = ((PSDEViewLogicServiceBase)object3).selectTempByPSDEViewBase(pSDEViewBase);
        object2 = ((ArrayList)serializable22).iterator();
        while (object2.hasNext()) {
            serializable = (PSDEViewLogic)object2.next();
            object = new XmlNode();
            object.setNodeName(XMLNODE_DEVIEWLOGIC);
            serializable.fillXmlNode((XmlNode)object, true);
            xmlNode.addNode((XmlNode)object);
        }
        object2 = (PSDEViewEngineService)ServiceGlobal.getService((String)PSDEViewEngineService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        serializable = ((PSDEViewEngineServiceBase)object2).selectTempByPSDEViewBase(pSDEViewBase);
        object = ((ArrayList)serializable).iterator();
        while (object.hasNext()) {
            PSDEViewEngine pSDEViewEngine = (PSDEViewEngine)object.next();
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName(XMLNODE_DEVIEWENGINE);
            pSDEViewEngine.fillXmlNode(xmlNode2, true);
            xmlNode.addNode(xmlNode2);
        }
        return XmlNode.export((XmlNode)xmlNode);
    }

    @Override
    public void createWithModel(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        pSDEViewBase2.setSessionFactory(this.getSessionFactory());
        log.debug((Object)"\u5f00\u59cb[createWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngine pSDEViewEngine;
                Serializable serializable;
                Serializable serializable22;
                PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService((String)PSDEViewCtrlService.class.getCanonicalName(), (SessionFactory)PSDEViewBaseService.this.getSessionFactory());
                ArrayList<PSDEViewCtrl> arrayList = pSDEViewCtrlService.selectTempByPSDEViewBase(pSDEViewBase2);
                HashMap<String, PSDEViewCtrl> hashMap = new HashMap<String, PSDEViewCtrl>();
                for (PSDEViewCtrl serializable32 : arrayList) {
                    hashMap.put(serializable32.getPSDEViewCtrlId(), serializable32);
                }
                PSDEViewRVService pSDEViewRVService = (PSDEViewRVService)ServiceGlobal.getService((String)PSDEViewRVService.class.getCanonicalName(), (SessionFactory)PSDEViewBaseService.this.getSessionFactory());
                ArrayList<PSDEViewRV> arrayList2 = pSDEViewRVService.selectTempByMajorPSDEView(pSDEViewBase2);
                HashMap<String, PSDEViewRV> hashMap2 = new HashMap<String, PSDEViewRV>();
                for (Serializable serializable22 : arrayList2) {
                    hashMap2.put(((PSDEViewRVBase)serializable22).getPSDEViewRVId(), (PSDEViewRV)serializable22);
                }
                PSDEViewLogicService pSDEViewLogicService = (PSDEViewLogicService)ServiceGlobal.getService((String)PSDEViewLogicService.class.getCanonicalName(), (SessionFactory)PSDEViewBaseService.this.getSessionFactory());
                serializable22 = pSDEViewLogicService.selectTempByPSDEViewBase(pSDEViewBase2);
                HashMap<String, PSDEViewLogic> hashMap3 = new HashMap<String, PSDEViewLogic>();
                Object object = ((ArrayList)serializable22).iterator();
                while (object.hasNext()) {
                    serializable = (PSDEViewLogic)object.next();
                    hashMap3.put(((PSDEViewLogicBase)serializable).getPSDEViewLogicId(), (PSDEViewLogic)serializable);
                }
                object = (PSDEViewEngineService)ServiceGlobal.getService((String)PSDEViewEngineService.class.getCanonicalName(), (SessionFactory)PSDEViewBaseService.this.getSessionFactory());
                serializable = ((PSDEViewEngineServiceBase)object).selectTempByPSDEViewBase(pSDEViewBase2);
                HashMap<String, PSDEViewEngine> hashMap4 = new HashMap<String, PSDEViewEngine>();
                Object object2 = ((ArrayList)serializable).iterator();
                while (object2.hasNext()) {
                    pSDEViewEngine = (PSDEViewEngine)object2.next();
                    hashMap4.put(pSDEViewEngine.getPSDEViewEngineId(), pSDEViewEngine);
                }
                object2 = pSDEViewBase2.getViewModel();
                pSDEViewEngine = XmlNode.loadFromXML((String)object2);
                if (pSDEViewEngine != null) {
                    pSDEViewEngine.setAttribute("PSDEID", pSDEViewBase2.getPSDEId());
                    pSDEViewEngine.setAttribute("PSSYSTEMID", pSDEViewBase2.getPSSystemId());
                    pSDEViewEngine.setAttribute("PSDEVIEWBASEID", pSDEViewBase2.getPSDEViewBaseId());
                    PSDEViewBaseService.this.updatePSDEViewModel(pSDEViewBase2, (XmlNode)pSDEViewEngine, hashMap, hashMap2, hashMap3, hashMap4);
                    pSDEViewBase2.setViewModel(XmlNode.export((XmlNode)pSDEViewEngine));
                } else {
                    pSDEViewBase2.setViewModel(null);
                }
                if (hashMap3.size() > 0) {
                    for (EntityBase entityBase : hashMap3.values()) {
                        pSDEViewLogicService.removeTemp((IEntity)entityBase);
                    }
                }
                if (hashMap2.size() > 0) {
                    for (EntityBase entityBase : hashMap2.values()) {
                        pSDEViewRVService.removeTemp((IEntity)entityBase);
                    }
                }
                if (hashMap.size() > 0) {
                    for (EntityBase entityBase : hashMap.values()) {
                        pSDEViewCtrlService.removeTemp((IEntity)entityBase);
                    }
                }
                PSDEViewBaseService.this.createTempMajor((IEntity)pSDEViewBase2);
            }
        });
    }

    @Override
    public void updateWithModel(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        pSDEViewBase2.setSessionFactory(this.getSessionFactory());
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngine pSDEViewEngine;
                Serializable serializable;
                Serializable serializable22;
                Object object = null;
                PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService((String)PSDEViewCtrlService.class.getCanonicalName(), (SessionFactory)PSDEViewBaseService.this.getSessionFactory());
                ArrayList<PSDEViewCtrl> arrayList = pSDEViewCtrlService.selectTempByPSDEViewBase(pSDEViewBase2);
                HashMap<String, PSDEViewCtrl> hashMap = new HashMap<String, PSDEViewCtrl>();
                for (PSDEViewCtrl serializable32 : arrayList) {
                    hashMap.put(serializable32.getPSDEViewCtrlId(), serializable32);
                }
                PSDEViewRVService pSDEViewRVService = (PSDEViewRVService)ServiceGlobal.getService((String)PSDEViewRVService.class.getCanonicalName(), (SessionFactory)PSDEViewBaseService.this.getSessionFactory());
                ArrayList<PSDEViewRV> arrayList2 = pSDEViewRVService.selectTempByMajorPSDEView(pSDEViewBase2);
                HashMap<String, PSDEViewRV> hashMap2 = new HashMap<String, PSDEViewRV>();
                for (Serializable serializable22 : arrayList2) {
                    hashMap2.put(((PSDEViewRVBase)serializable22).getPSDEViewRVId(), (PSDEViewRV)serializable22);
                }
                PSDEViewLogicService pSDEViewLogicService = (PSDEViewLogicService)ServiceGlobal.getService((String)PSDEViewLogicService.class.getCanonicalName(), (SessionFactory)PSDEViewBaseService.this.getSessionFactory());
                serializable22 = pSDEViewLogicService.selectTempByPSDEViewBase(pSDEViewBase2);
                HashMap<String, PSDEViewLogic> hashMap3 = new HashMap<String, PSDEViewLogic>();
                Object object2 = ((ArrayList)serializable22).iterator();
                while (object2.hasNext()) {
                    serializable = (PSDEViewLogic)object2.next();
                    hashMap3.put(((PSDEViewLogicBase)serializable).getPSDEViewLogicId(), (PSDEViewLogic)serializable);
                }
                object2 = (PSDEViewEngineService)ServiceGlobal.getService((String)PSDEViewEngineService.class.getCanonicalName(), (SessionFactory)PSDEViewBaseService.this.getSessionFactory());
                serializable = ((PSDEViewEngineServiceBase)object2).selectTempByPSDEViewBase(pSDEViewBase2);
                HashMap<String, PSDEViewEngine> hashMap4 = new HashMap<String, PSDEViewEngine>();
                Object object3 = ((ArrayList)serializable).iterator();
                while (object3.hasNext()) {
                    pSDEViewEngine = (PSDEViewEngine)object3.next();
                    hashMap4.put(pSDEViewEngine.getPSDEViewEngineId(), pSDEViewEngine);
                }
                object = object3 = pSDEViewBase2.getViewModel();
                pSDEViewEngine = XmlNode.loadFromXML((String)object3);
                if (pSDEViewEngine != null) {
                    pSDEViewEngine.setAttribute("PSDEID", pSDEViewBase2.getPSDEId());
                    pSDEViewEngine.setAttribute("PSDEVIEWBASEID", pSDEViewBase2.getPSDEViewBaseId());
                    pSDEViewEngine.setAttribute("PSSYSTEMID", pSDEViewBase2.getPSSystemId());
                    PSDEViewBaseService.this.updatePSDEViewModel(pSDEViewBase2, (XmlNode)pSDEViewEngine, hashMap, hashMap2, hashMap3, hashMap4);
                    pSDEViewBase2.setViewModel(XmlNode.export((XmlNode)pSDEViewEngine));
                } else {
                    pSDEViewBase2.setViewModel(null);
                }
                boolean bl = false;
                if (hashMap3.size() > 0) {
                    for (EntityBase entityBase : hashMap3.values()) {
                        pSDEViewLogicService.removeTemp((IEntity)entityBase);
                        bl = true;
                    }
                }
                if (hashMap2.size() > 0) {
                    for (EntityBase entityBase : hashMap2.values()) {
                        pSDEViewRVService.removeTemp((IEntity)entityBase);
                        bl = true;
                    }
                }
                if (hashMap.size() > 0) {
                    for (EntityBase entityBase : hashMap.values()) {
                        pSDEViewCtrlService.removeTemp((IEntity)entityBase);
                        bl = true;
                    }
                }
                PSDEViewBaseService.this.updateTempMajor(pSDEViewBase2);
            }
        });
    }

    @Override
    public void previewSave(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        pSDEViewBase2.setSessionFactory(this.getSessionFactory());
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewEngine pSDEViewEngine;
                Serializable serializable;
                Serializable serializable22;
                Object object = null;
                PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService((String)PSDEViewCtrlService.class.getCanonicalName(), (SessionFactory)PSDEViewBaseService.this.getSessionFactory());
                ArrayList<PSDEViewCtrl> arrayList = pSDEViewCtrlService.selectTempByPSDEViewBase(pSDEViewBase2);
                HashMap<String, PSDEViewCtrl> hashMap = new HashMap<String, PSDEViewCtrl>();
                for (PSDEViewCtrl serializable32 : arrayList) {
                    hashMap.put(serializable32.getPSDEViewCtrlId(), serializable32);
                }
                PSDEViewRVService pSDEViewRVService = (PSDEViewRVService)ServiceGlobal.getService((String)PSDEViewRVService.class.getCanonicalName(), (SessionFactory)PSDEViewBaseService.this.getSessionFactory());
                ArrayList<PSDEViewRV> arrayList2 = pSDEViewRVService.selectTempByMajorPSDEView(pSDEViewBase2);
                HashMap<String, PSDEViewRV> hashMap2 = new HashMap<String, PSDEViewRV>();
                for (Serializable serializable22 : arrayList2) {
                    hashMap2.put(((PSDEViewRVBase)serializable22).getPSDEViewRVId(), (PSDEViewRV)serializable22);
                }
                PSDEViewLogicService pSDEViewLogicService = (PSDEViewLogicService)ServiceGlobal.getService((String)PSDEViewLogicService.class.getCanonicalName(), (SessionFactory)PSDEViewBaseService.this.getSessionFactory());
                serializable22 = pSDEViewLogicService.selectTempByPSDEViewBase(pSDEViewBase2);
                HashMap<String, PSDEViewLogic> hashMap3 = new HashMap<String, PSDEViewLogic>();
                Object object2 = ((ArrayList)serializable22).iterator();
                while (object2.hasNext()) {
                    serializable = (PSDEViewLogic)object2.next();
                    hashMap3.put(((PSDEViewLogicBase)serializable).getPSDEViewLogicId(), (PSDEViewLogic)serializable);
                }
                object2 = (PSDEViewEngineService)ServiceGlobal.getService((String)PSDEViewEngineService.class.getCanonicalName(), (SessionFactory)PSDEViewBaseService.this.getSessionFactory());
                serializable = ((PSDEViewEngineServiceBase)object2).selectTempByPSDEViewBase(pSDEViewBase2);
                HashMap<String, PSDEViewEngine> hashMap4 = new HashMap<String, PSDEViewEngine>();
                Object object3 = ((ArrayList)serializable).iterator();
                while (object3.hasNext()) {
                    pSDEViewEngine = (PSDEViewEngine)object3.next();
                    hashMap4.put(pSDEViewEngine.getPSDEViewEngineId(), pSDEViewEngine);
                }
                object = object3 = pSDEViewBase2.getViewModel();
                pSDEViewEngine = XmlNode.loadFromXML((String)object3);
                if (pSDEViewEngine != null) {
                    pSDEViewEngine.setAttribute("PSDEID", pSDEViewBase2.getPSDEId());
                    pSDEViewEngine.setAttribute("PSDEVIEWBASEID", pSDEViewBase2.getPSDEViewBaseId());
                    pSDEViewEngine.setAttribute("PSSYSTEMID", pSDEViewBase2.getPSSystemId());
                    PSDEViewBaseService.this.updatePSDEViewModel(pSDEViewBase2, (XmlNode)pSDEViewEngine, hashMap, hashMap2, hashMap3, hashMap4);
                    pSDEViewBase2.setViewModel(XmlNode.export((XmlNode)pSDEViewEngine));
                } else {
                    pSDEViewBase2.setViewModel(null);
                }
                boolean bl = false;
                if (hashMap3.size() > 0) {
                    for (EntityBase entityBase : hashMap3.values()) {
                        pSDEViewLogicService.removeTemp((IEntity)entityBase);
                        bl = true;
                    }
                }
                if (hashMap2.size() > 0) {
                    for (EntityBase entityBase : hashMap2.values()) {
                        pSDEViewRVService.removeTemp((IEntity)entityBase);
                        bl = true;
                    }
                }
                if (hashMap.size() > 0) {
                    for (EntityBase entityBase : hashMap.values()) {
                        pSDEViewCtrlService.removeTemp((IEntity)entityBase);
                        bl = true;
                    }
                }
            }
        });
    }

    protected void updatePSDEViewModel(PSDEViewBase pSDEViewBase, XmlNode xmlNode, HashMap<String, PSDEViewCtrl> hashMap, HashMap<String, PSDEViewRV> hashMap2, HashMap<String, PSDEViewLogic> hashMap3, HashMap<String, PSDEViewEngine> hashMap4) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            ArrayList<Object> arrayList2 = new ArrayList<Object>();
            ArrayList<Object> arrayList3 = new ArrayList<Object>();
            ArrayList<Object> arrayList4 = new ArrayList<Object>();
            PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService((String)PSDEViewCtrlService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            PSDEViewRVService pSDEViewRVService = (PSDEViewRVService)ServiceGlobal.getService((String)PSDEViewRVService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            PSDEViewLogicService pSDEViewLogicService = (PSDEViewLogicService)ServiceGlobal.getService((String)PSDEViewLogicService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            PSDEViewEngineService pSDEViewEngineService = (PSDEViewEngineService)ServiceGlobal.getService((String)PSDEViewEngineService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            while (iterator.hasNext()) {
                String string;
                boolean bl;
                EntityBase entityBase;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                if (StringHelper.compare((String)xmlNode2.getNodeName(), (String)XMLNODE_DEVIEWCTRL, (boolean)true) == 0) {
                    String string2 = xmlNode2.getAttribute("PSDEVIEWCTRLID", "");
                    if (StringHelper.isNullOrEmpty((String)string2) || (entityBase = hashMap.remove(string2)) == null) continue;
                    bl = false;
                    if (StringHelper.compare((String)entityBase.getPSDEViewBaseId(), (String)pSDEViewBase.getPSDEViewBaseId(), (boolean)false) != 0) {
                        entityBase.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)entityBase.getPSDEViewBaseName(), (String)pSDEViewBase.getPSDEViewBaseName(), (boolean)false) != 0) {
                        entityBase.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
                        bl = true;
                    }
                    if (bl) {
                        pSDEViewCtrlService.updateTemp((IEntity)entityBase);
                    }
                    xmlNode2.resetAttributes();
                    entityBase.fillXmlNode(xmlNode2, false);
                    arrayList.add(xmlNode2);
                    continue;
                }
                if (StringHelper.compare((String)xmlNode2.getNodeName(), (String)XMLNODE_DEVIEWRV, (boolean)true) == 0) {
                    String string3 = xmlNode2.getAttribute("PSDEVIEWRVID", "");
                    if (StringHelper.isNullOrEmpty((String)string3) || (entityBase = hashMap2.remove(string3)) == null) continue;
                    bl = false;
                    if (StringHelper.compare((String)entityBase.getMajorPSDEViewId(), (String)pSDEViewBase.getPSDEViewBaseId(), (boolean)false) != 0) {
                        entityBase.setMajorPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)entityBase.getMajorPSDEViewName(), (String)pSDEViewBase.getPSDEViewBaseName(), (boolean)false) != 0) {
                        entityBase.setMajorPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
                        bl = true;
                    }
                    if (bl) {
                        pSDEViewRVService.updateTemp((IEntity)entityBase);
                    }
                    xmlNode2.resetAttributes();
                    entityBase.fillXmlNode(xmlNode2, false);
                    arrayList2.add(xmlNode2);
                    continue;
                }
                if (StringHelper.compare((String)xmlNode2.getNodeName(), (String)XMLNODE_DEVIEWLOGIC, (boolean)true) == 0) {
                    String string4 = xmlNode2.getAttribute("PSDEVIEWLOGICID", "");
                    if (StringHelper.isNullOrEmpty((String)string4) || (entityBase = hashMap3.remove(string4)) == null) continue;
                    bl = false;
                    if (StringHelper.compare((String)entityBase.getPSDEViewBaseId(), (String)pSDEViewBase.getPSDEViewBaseId(), (boolean)false) != 0) {
                        entityBase.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)entityBase.getPSDEViewBaseName(), (String)pSDEViewBase.getPSDEViewBaseName(), (boolean)false) != 0) {
                        entityBase.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
                        bl = true;
                    }
                    if (bl) {
                        pSDEViewLogicService.updateTemp((IEntity)entityBase);
                    }
                    xmlNode2.resetAttributes();
                    entityBase.fillXmlNode(xmlNode2, false);
                    arrayList3.add(xmlNode2);
                    continue;
                }
                if (StringHelper.compare((String)xmlNode2.getNodeName(), (String)XMLNODE_DEVIEWENGINE, (boolean)true) != 0 || StringHelper.isNullOrEmpty((String)(string = xmlNode2.getAttribute("PSDEVIEWENGINEID", ""))) || (entityBase = hashMap4.remove(string)) == null) continue;
                bl = false;
                if (StringHelper.compare((String)entityBase.getPSDEViewBaseId(), (String)pSDEViewBase.getPSDEViewBaseId(), (boolean)false) != 0) {
                    entityBase.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
                    bl = true;
                }
                if (StringHelper.compare((String)entityBase.getPSDEViewBaseName(), (String)pSDEViewBase.getPSDEViewBaseName(), (boolean)false) != 0) {
                    entityBase.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
                    bl = true;
                }
                if (bl) {
                    pSDEViewEngineService.updateTemp((IEntity)entityBase);
                }
                xmlNode2.resetAttributes();
                entityBase.fillXmlNode(xmlNode2, false);
                arrayList4.add(xmlNode2);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
            for (XmlNode xmlNode3 : arrayList2) {
                xmlNode.addNode(xmlNode3);
            }
            for (XmlNode xmlNode4 : arrayList3) {
                xmlNode.addNode(xmlNode4);
            }
            for (XmlNode xmlNode5 : arrayList4) {
                xmlNode.addNode(xmlNode5);
            }
        }
    }

    @Override
    public void getDraftFromWithModel(PSDEViewBase pSDEViewBase) throws Exception {
        super.getDraftTempMajorFrom(pSDEViewBase);
        pSDEViewBase.setViewModel(this.getViewModel(pSDEViewBase));
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEViewBase pSDEViewBase, String string) throws Exception {
        if (!((objectNode = super.fillModelV2(objectNode, pSDEViewBase, string)) == null || StringHelper.compare((String)pSDEViewBase.getPSDEViewBaseType(), (String)"DEREDIRECTVIEW", (boolean)false) != 0 && StringHelper.compare((String)pSDEViewBase.getPSDEViewBaseType(), (String)"DEMOBREDIRECTVIEW", (boolean)false) != 0 || StringHelper.isNullOrEmpty((String)pSDEViewBase.getViewParam7()))) {
            try {
                String string2 = this.getModelV2UniqueTag("PSDEACTION", pSDEViewBase.getViewParam7(), string);
                objectNode.remove("viewparam7");
                objectNode.put("viewparam7", string2);
            }
            catch (Exception exception) {
                log.error((Object)exception);
            }
        }
        return objectNode;
    }

    @Override
    public boolean fillModelV2Key(PSDEViewBase pSDEViewBase, ObjectNode objectNode, String string, String string2, boolean bl) throws Exception {
        boolean bl2 = super.fillModelV2Key(pSDEViewBase, objectNode, string, string2, bl);
        if (bl && objectNode != null && (StringHelper.compare((String)pSDEViewBase.getPSDEViewBaseType(), (String)"DEREDIRECTVIEW", (boolean)false) == 0 || StringHelper.compare((String)pSDEViewBase.getPSDEViewBaseType(), (String)"DEMOBREDIRECTVIEW", (boolean)false) == 0)) {
            try {
                String string3 = JsonNodeHelper.getString((ObjectNode)objectNode, (String)"viewparam7", null);
                if (!StringHelper.isNullOrEmpty((String)string3)) {
                    string3 = this.getModelV2Key("PSDEACTION", string3, string, "VIEWPARAM7");
                    pSDEViewBase.setViewParam7(string3);
                }
            }
            catch (Exception exception) {
                log.error((Object)exception);
                pSDEViewBase.setViewParam7(null);
            }
        }
        return bl2;
    }

    @Override
    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEViewBase> arrayList) throws Exception {
        PSDEViewRVService pSDEViewRVService = (PSDEViewRVService)ServiceGlobal.getService(PSDEViewRVService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEViewBase pSDEViewBase : arrayList) {
            pSDEViewRVService.removeByMajorPSDEView(pSDEViewBase);
        }
    }
}

