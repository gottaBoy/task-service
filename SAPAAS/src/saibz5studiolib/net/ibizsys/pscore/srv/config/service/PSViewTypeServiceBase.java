/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.config.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSViewTypeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSViewTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSVTCtrl;
import net.ibizsys.pscore.srv.config.entity.PSVTCtrlBase;
import net.ibizsys.pscore.srv.config.entity.PSVTRV;
import net.ibizsys.pscore.srv.config.entity.PSVTRVBase;
import net.ibizsys.pscore.srv.config.entity.PSViewEngine;
import net.ibizsys.pscore.srv.config.entity.PSViewEngineBase;
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.service.PSPFViewTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFViewTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFViewTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFViewTypeServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFViewTypeService;
import net.ibizsys.pscore.srv.config.service.PSSFViewTypeServiceBase;
import net.ibizsys.pscore.srv.config.service.PSVTCatDetailService;
import net.ibizsys.pscore.srv.config.service.PSVTCatDetailServiceBase;
import net.ibizsys.pscore.srv.config.service.PSVTCtrlService;
import net.ibizsys.pscore.srv.config.service.PSVTCtrlServiceBase;
import net.ibizsys.pscore.srv.config.service.PSVTRVService;
import net.ibizsys.pscore.srv.config.service.PSVTRVServiceBase;
import net.ibizsys.pscore.srv.config.service.PSVTSampleService;
import net.ibizsys.pscore.srv.config.service.PSVTSampleServiceBase;
import net.ibizsys.pscore.srv.config.service.PSVTStyleService;
import net.ibizsys.pscore.srv.config.service.PSVTStyleServiceBase;
import net.ibizsys.pscore.srv.config.service.PSViewTypeLogicService;
import net.ibizsys.pscore.srv.config.service.PSViewTypeLogicServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSViewTypeServiceBase
extends PSCoreSysServiceBase<PSViewType> {
    private static final Log log = LogFactory.getLog(PSViewTypeServiceBase.class);
    public static final String DATASET_CURCAT = "CurCat";
    public static final String DATASET_CURCAT2 = "CurCat2";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_VALID = "Valid";
    private PSViewTypeDEModel pSViewTypeDEModel;
    private PSViewTypeDAO pSViewTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSViewTypeService";
    }

    public PSViewTypeDEModel getPSViewTypeDEModel() {
        if (this.pSViewTypeDEModel == null) {
            try {
                this.pSViewTypeDEModel = (PSViewTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSViewTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSViewTypeDEModel();
    }

    public PSViewTypeDAO getPSViewTypeDAO() {
        if (this.pSViewTypeDAO == null) {
            try {
                this.pSViewTypeDAO = (PSViewTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSViewTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSViewTypeDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURCAT, (boolean)true) == 0) {
            return this.fetchCurCat(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURCAT2, (boolean)true) == 0) {
            return this.fetchCurCat2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_VALID, (boolean)true) == 0) {
            return this.fetchValid(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurCat(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURCAT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurCat2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURCAT2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchValid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_VALID, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSViewType pSViewType, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWTYPE_PSVIEWENGINE_PSVIEWENGINEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewEngineService", (SessionFactory)this.getSessionFactory());
            PSViewEngine pSViewEngine = (PSViewEngine)iService.getDEModel().createEntity();
            pSViewEngine.set("PSVIEWENGINEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewEngine);
            } else {
                iService.get(pSViewEngine);
            }
            this.onFillParentInfo_PSViewEngine(pSViewType, pSViewEngine);
            return;
        }
        super.onFillParentInfo(pSViewType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSViewEngine(PSViewType pSViewType, PSViewEngine pSViewEngine) throws Exception {
        pSViewType.setPSViewEngineId(pSViewEngine.getPSViewEngineId());
        pSViewType.setPSViewEngineName(pSViewEngine.getPSViewEngineName());
    }

    protected void onFillEntityFullInfo(PSViewType pSViewType, boolean bl) throws Exception {
        if (bl && pSViewType.getValidFlag() == null) {
            pSViewType.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSViewType, bl);
        this.onFillEntityFullInfo_PSViewEngine(pSViewType, bl);
    }

    protected void onFillEntityFullInfo_PSViewEngine(PSViewType pSViewType, boolean bl) throws Exception {
        if (pSViewType.isPSViewEngineIdDirty()) {
            if (pSViewType.getPSViewEngineId() != null) {
                if (pSViewType.getPSViewEngineId() == null || pSViewType.getPSViewEngineName() == null) {
                    PSViewEngine pSViewEngine = pSViewType.getPSViewEngine();
                    pSViewType.setPSViewEngineName(pSViewEngine.getPSViewEngineName());
                }
            } else {
                pSViewType.setPSViewEngineName(null);
            }
        }
    }

    protected void onWriteBackParent(PSViewType pSViewType, boolean bl) throws Exception {
        super.onWriteBackParent(pSViewType, bl);
    }

    public ArrayList<PSViewType> selectByPSViewEngine(PSViewEngineBase pSViewEngineBase) throws Exception {
        return this.selectByPSViewEngine(pSViewEngineBase, "", -1);
    }

    public ArrayList<PSViewType> selectByPSViewEngine(PSViewEngineBase pSViewEngineBase, String string) throws Exception {
        return this.selectByPSViewEngine(pSViewEngineBase, string, -1);
    }

    public ArrayList<PSViewType> selectByPSViewEngine(PSViewEngineBase pSViewEngineBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWENGINEID", (Object)pSViewEngineBase.getPSViewEngineId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSViewEngineCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSViewEngineCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSViewEngine(PSViewEngine pSViewEngine) throws Exception {
    }

    public void resetPSViewEngine(PSViewEngine pSViewEngine) throws Exception {
        ArrayList<PSViewType> arrayList = this.selectByPSViewEngine(pSViewEngine);
        for (PSViewType pSViewType : arrayList) {
            PSViewType pSViewType2 = (PSViewType)this.getDEModel().createEntity();
            pSViewType2.setPSViewTypeId(pSViewType.getPSViewTypeId());
            pSViewType2.setPSViewEngineId(null);
            this.update(pSViewType2);
        }
    }

    public void removeByPSViewEngine(PSViewEngine pSViewEngine) throws Exception {
        final PSViewEngine pSViewEngine2 = pSViewEngine;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewTypeServiceBase.this.onBeforeRemoveByPSViewEngine(pSViewEngine2);
                PSViewTypeServiceBase.this.internalRemoveByPSViewEngine(pSViewEngine2);
                PSViewTypeServiceBase.this.onAfterRemoveByPSViewEngine(pSViewEngine2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewEngine(PSViewEngine pSViewEngine) throws Exception {
    }

    protected void internalRemoveByPSViewEngine(PSViewEngine pSViewEngine) throws Exception {
        ArrayList<PSViewType> arrayList = this.selectByPSViewEngine(pSViewEngine);
        this.onBeforeRemoveByPSViewEngine(pSViewEngine, arrayList);
        for (PSViewType pSViewType : arrayList) {
            this.remove(pSViewType);
        }
        this.onAfterRemoveByPSViewEngine(pSViewEngine, arrayList);
    }

    protected void onAfterRemoveByPSViewEngine(PSViewEngine pSViewEngine) throws Exception {
    }

    protected void onBeforeRemoveByPSViewEngine(PSViewEngine pSViewEngine, ArrayList<PSViewType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewEngine(PSViewEngine pSViewEngine, ArrayList<PSViewType> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSViewType pSViewType) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSPFViewTemplService)ServiceGlobal.getService(PSPFViewTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFViewTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSViewType(pSViewType);
        pSCoreSysServiceBase = (PSPFViewTypeService)ServiceGlobal.getService(PSPFViewTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFViewTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSViewType(pSViewType);
        pSCoreSysServiceBase = (PSSFViewTypeService)ServiceGlobal.getService(PSSFViewTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFViewTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSViewType(pSViewType);
        pSCoreSysServiceBase = (PSViewTypeLogicService)ServiceGlobal.getService(PSViewTypeLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewTypeLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSViewType(pSViewType);
        ((PSViewTypeLogicServiceBase)pSCoreSysServiceBase).removeByPSViewType(pSViewType);
        pSCoreSysServiceBase = (PSVTCatDetailService)ServiceGlobal.getService(PSVTCatDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSVTCatDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSViewType(pSViewType);
        ((PSVTCatDetailServiceBase)pSCoreSysServiceBase).removeByPSViewType(pSViewType);
        pSCoreSysServiceBase = (PSVTCtrlService)ServiceGlobal.getService(PSVTCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSVTCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSViewType(pSViewType);
        ((PSVTCtrlServiceBase)pSCoreSysServiceBase).removeByPSViewType(pSViewType);
        pSCoreSysServiceBase = (PSVTRVService)ServiceGlobal.getService(PSVTRVService.class, (SessionFactory)this.getSessionFactory());
        ((PSVTRVServiceBase)pSCoreSysServiceBase).testRemoveByPSViewType(pSViewType);
        ((PSVTRVServiceBase)pSCoreSysServiceBase).removeByPSViewType(pSViewType);
        pSCoreSysServiceBase = (PSVTSampleService)ServiceGlobal.getService(PSVTSampleService.class, (SessionFactory)this.getSessionFactory());
        ((PSVTSampleServiceBase)pSCoreSysServiceBase).testRemoveByPSViewTYpe(pSViewType);
        ((PSVTSampleServiceBase)pSCoreSysServiceBase).removeByPSViewTYpe(pSViewType);
        pSCoreSysServiceBase = (PSVTStyleService)ServiceGlobal.getService(PSVTStyleService.class, (SessionFactory)this.getSessionFactory());
        ((PSVTStyleServiceBase)pSCoreSysServiceBase).testRemoveByPSViewType(pSViewType);
        ((PSVTStyleServiceBase)pSCoreSysServiceBase).removeByPSViewType(pSViewType);
        super.onBeforeRemove(pSViewType);
    }

    protected void replaceParentInfo(PSViewType pSViewType, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSViewType, cloneSession);
        if (pSViewType.getPSViewEngineId() != null && (iEntity = cloneSession.getEntity("PSVIEWENGINE", (Object)pSViewType.getPSViewEngineId())) != null) {
            this.onFillParentInfo_PSViewEngine(pSViewType, (PSViewEngine)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSViewType pSViewType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSViewType, bl);
    }

    protected void onCheckEntity(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AppViewObj(bl, pSViewType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Color(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DescURL(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEViewMode(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEViewObj(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmbedViewFlag(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDynaTool(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconPath(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LayoutModel(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewEngineId(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewEngineName(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewTypeId(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewTypeName(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Title(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewObjInt(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VTFullSN(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VTSN(bl, pSViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSViewType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AppViewObj(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isAppViewObjDirty() && !bl2 : !pSViewType.isAppViewObjDirty()) {
            return null;
        }
        String string = pSViewType.getAppViewObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPVIEWOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppViewObj_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPVIEWOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isCodeNameDirty() && !bl2 : !pSViewType.isCodeNameDirty()) {
            return null;
        }
        String string = pSViewType.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Color(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isColorDirty() : !pSViewType.isColorDirty()) {
            return null;
        }
        String string = pSViewType.getColor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Color_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DescURL(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isDescURLDirty() : !pSViewType.isDescURLDirty()) {
            return null;
        }
        String string = pSViewType.getDescURL();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DescURL_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DESCURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEViewMode(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isDEViewModeDirty() && !bl2 : !pSViewType.isDEViewModeDirty()) {
            return null;
        }
        Integer n = pSViewType.getDEViewMode();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVIEWMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DEViewMode_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVIEWMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEViewObj(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isDEViewObjDirty() : !pSViewType.isDEViewObjDirty()) {
            return null;
        }
        String string = pSViewType.getDEViewObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEViewObj_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVIEWOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmbedViewFlag(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isEmbedViewFlagDirty() : !pSViewType.isEmbedViewFlagDirty()) {
            return null;
        }
        Integer n = pSViewType.getEmbedViewFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EmbedViewFlag_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMBEDVIEWFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDynaTool(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isEnableDynaToolDirty() : !pSViewType.isEnableDynaToolDirty()) {
            return null;
        }
        Integer n = pSViewType.getEnableDynaTool();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDynaTool_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDYNATOOL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconPath(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isIconPathDirty() : !pSViewType.isIconPathDirty()) {
            return null;
        }
        String string = pSViewType.getIconPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconPath_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LayoutModel(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isLayoutModelDirty() : !pSViewType.isLayoutModelDirty()) {
            return null;
        }
        String string = pSViewType.getLayoutModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LayoutModel_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LAYOUTMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isMemoDirty() : !pSViewType.isMemoDirty()) {
            return null;
        }
        String string = pSViewType.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MEMO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isOrderValueDirty() : !pSViewType.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSViewType.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewEngineId(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isPSViewEngineIdDirty() : !pSViewType.isPSViewEngineIdDirty()) {
            return null;
        }
        String string = pSViewType.getPSViewEngineId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewEngineId_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWENGINEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewEngineName(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isPSViewEngineNameDirty() : !pSViewType.isPSViewEngineNameDirty()) {
            return null;
        }
        String string = pSViewType.getPSViewEngineName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewEngineName_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWENGINENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewTypeId(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isPSViewTypeIdDirty() && !bl2 : !pSViewType.isPSViewTypeIdDirty()) {
            return null;
        }
        String string = pSViewType.getPSViewTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewTypeId_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewTypeName(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isPSViewTypeNameDirty() && !bl2 : !pSViewType.isPSViewTypeNameDirty()) {
            return null;
        }
        String string = pSViewType.getPSViewTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWTYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewTypeName_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Title(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isTitleDirty() : !pSViewType.isTitleDirty()) {
            return null;
        }
        String string = pSViewType.getTitle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Title_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isUserCatDirty() : !pSViewType.isUserCatDirty()) {
            return null;
        }
        String string = pSViewType.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isUserTagDirty() : !pSViewType.isUserTagDirty()) {
            return null;
        }
        String string = pSViewType.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isUserTag2Dirty() : !pSViewType.isUserTag2Dirty()) {
            return null;
        }
        String string = pSViewType.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isUserTag3Dirty() : !pSViewType.isUserTag3Dirty()) {
            return null;
        }
        String string = pSViewType.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isUserTag4Dirty() : !pSViewType.isUserTag4Dirty()) {
            return null;
        }
        String string = pSViewType.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isValidFlagDirty() && !bl2 : !pSViewType.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSViewType.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewObjInt(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isViewObjIntDirty() : !pSViewType.isViewObjIntDirty()) {
            return null;
        }
        String string = pSViewType.getViewObjInt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewObjInt_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWOBJINT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VTFullSN(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isVTFullSNDirty() : !pSViewType.isVTFullSNDirty()) {
            return null;
        }
        String string = pSViewType.getVTFullSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VTFullSN_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VTFULLSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VTSN(boolean bl, PSViewType pSViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewType.isVTSNDirty() : !pSViewType.isVTSNDirty()) {
            return null;
        }
        String string = pSViewType.getVTSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VTSN_Default(pSViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VTSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSViewType pSViewType, boolean bl) throws Exception {
        super.onSyncEntity(pSViewType, bl);
    }

    protected void onSyncIndexEntities(PSViewType pSViewType, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSViewType, bl);
    }

    public Object getDataContextValue(PSViewType pSViewType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSViewType, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSViewType pSViewType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSViewType, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"APPVIEWOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppViewObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Color_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DESCURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DescURL_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVIEWMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEViewMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVIEWOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEViewObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMBEDVIEWFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmbedViewFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDYNATOOL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDynaTool_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LAYOUTMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LayoutModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWENGINEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewEngineId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWENGINENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewEngineName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Title_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWOBJINT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewObjInt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VTFULLSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VTFullSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VTSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VTSN_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AppViewObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPVIEWOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Color_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COLOR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DescURL_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DESCURL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEViewMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEViewObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEVIEWOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmbedViewFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableDynaTool_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IconPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LayoutModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LAYOUTMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSViewEngineId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWENGINEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewEngineName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWENGINENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Title_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCAT", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewObjInt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWOBJINT", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VTFullSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VTFULLSN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VTSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VTSN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSViewType pSViewType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSViewType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSViewType pSViewType) throws Exception {
        super.onUpdateParent(pSViewType);
    }

    @Override
    protected void exportCurXmlModel(PSViewType pSViewType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSVIEWTYPE");
        if (!bl) {
            pSViewType.setCreateDate(null);
            pSViewType.setCreateMan(null);
            pSViewType.setUpdateDate(null);
            pSViewType.setUpdateMan(null);
            super.exportCurXmlModel(pSViewType, xmlNode, bl);
        }
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSVTCTRL_PSVIEWTYPE_PSVIEWTYPEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        if (StringHelper.compare((String)"DER1N_PSVTRV_PSVIEWTYPE_PSVIEWTYPEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 80;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSViewType pSViewType, String string, String string2) throws Exception {
        String string3;
        EntityBase entityBase;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSVTCTRL_PSVIEWTYPE_PSVIEWTYPEID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSVIEWTYPE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSVTCTRL", (Object)pSViewType.getPSViewTypeId()))).exists()) {
            pSCoreSysServiceBase = (PSVTCtrlService)ServiceGlobal.getService(PSVTCtrlService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSVTCtrl();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSVTCtrlServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSVTCtrl)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSVTCTRL", (Object)((PSVTCtrl)entityBase).getPSVTCtrlId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSVTRV_PSVIEWTYPE_PSVIEWTYPEID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSVIEWTYPE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSVTRV", (Object)pSViewType.getPSViewTypeId()))).exists()) {
            pSCoreSysServiceBase = (PSVTRVService)ServiceGlobal.getService(PSVTRVService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSVTRV();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSVTRVServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSVTRV)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSVTRV", (Object)((PSVTRV)entityBase).getPSVTRVId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSViewType, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSViewType pSViewType, ObjectNode objectNode, String string, boolean bl) throws Exception {
        if (bl || !this.isExportRelatedModelV2("DER1N_PSVTCTRL_PSVIEWTYPE_PSVIEWTYPEID")) {
            PSVTCtrlService service = (PSVTCtrlService)ServiceGlobal.getService(PSVTCtrlService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> items = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSVIEWTYPE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSVTCTRL", (Object)pSViewType.getPSViewTypeId()));
                if (file.exists()) {
                    items = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        items.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                items = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSVIEWTYPE#%1$s", (Object)pSViewType.getPSViewTypeId());
                for (PSVTCtrl item : service.selectByPSViewType(pSViewType)) {
                    if (StringHelper.compare(scope, service.getModelV2ResScope(item), false) != 0) continue;
                    items.add(PSModelV2Helper.toJSONObject(item, false));
                }
            }
            if (items != null && !items.isEmpty()) {
                ArrayNode children = objectNode.putArray(service.getModelV2Name(false).toLowerCase());
                Collections.sort(items, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("psvtctrlname")) {
                            string = objectNode.get("psvtctrlname").asText();
                        }
                        if (objectNode2.has("psvtctrlname")) {
                            string2 = objectNode2.get("psvtctrlname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode itemNode : items) {
                    PSVTCtrl item = new PSVTCtrl();
                    PSModelV2Helper.fromJSONObject(item, itemNode, false);
                    children.add(service.exportModelV2(item, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSVTRV_PSVIEWTYPE_PSVIEWTYPEID")) {
            PSVTRVService service = (PSVTRVService)ServiceGlobal.getService(PSVTRVService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> items = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSVIEWTYPE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSVTRV", (Object)pSViewType.getPSViewTypeId()));
                if (file.exists()) {
                    items = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        items.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                items = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSVIEWTYPE#%1$s", (Object)pSViewType.getPSViewTypeId());
                for (PSVTRV item : service.selectByPSViewType(pSViewType)) {
                    if (StringHelper.compare(scope, service.getModelV2ResScope(item), false) != 0) continue;
                    items.add(PSModelV2Helper.toJSONObject(item, false));
                }
            }
            if (items != null && !items.isEmpty()) {
                ArrayNode children = objectNode.putArray(service.getModelV2Name(false).toLowerCase());
                Collections.sort(items, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("psvtrvname")) {
                            string = objectNode.get("psvtrvname").asText();
                        }
                        if (objectNode2.has("psvtrvname")) {
                            string2 = objectNode2.get("psvtrvname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode itemNode : items) {
                    PSVTRV item = new PSVTRV();
                    PSModelV2Helper.fromJSONObject(item, itemNode, false);
                    children.add(service.exportModelV2(item, string));
                }
            }
        }
        super.onExportCurModelV2(pSViewType, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSViewType pSViewType) throws Exception {
        super.onEmptyModelV2(pSViewType);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSVTCtrlService)ServiceGlobal.getService(PSVTCtrlService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSVTRVService)ServiceGlobal.getService(PSVTRVService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSViewType pSViewType, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSVTCtrl();
        entityBase.set("PSVIEWTYPEID", pSViewType.getPSViewTypeId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSVTCtrlService)ServiceGlobal.getService(PSVTCtrlService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSVTRV();
        entityBase.set("PSVIEWTYPEID", pSViewType.getPSViewTypeId());
        pSCoreSysServiceBase = (PSVTRVService)ServiceGlobal.getService(PSVTRVService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSViewType, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSViewType pSViewType, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        String string3;
        ArrayNode arrayNode;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!PSViewTypeServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSVTCtrlService)ServiceGlobal.getService(PSVTCtrlService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    PSVTCtrl ctrl = new PSVTCtrl();
                    ctrl.setPSViewTypeId(pSViewType.getPSViewTypeId());
                    ctrl.setPSViewTypeName(pSViewType.getPSViewTypeName());
                    pSCoreSysServiceBase.compileModelV2(ctrl, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string4);
                if (((File)object2).exists()) {
                    File[] folders = ((File)object2).listFiles();
                    for (File folder : folders) {
                        if (!folder.isDirectory()) continue;
                        PSVTCtrl ctrl = new PSVTCtrl();
                        ctrl.setPSViewTypeId(pSViewType.getPSViewTypeId());
                        ctrl.setPSViewTypeName(pSViewType.getPSViewTypeName());
                        pSCoreSysServiceBase.compileModelV2(ctrl, null, string, folder.getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSViewTypeServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSVTRVService)ServiceGlobal.getService(PSVTRVService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    PSVTRV rv = new PSVTRV();
                    rv.setPSViewTypeId(pSViewType.getPSViewTypeId());
                    rv.setPSViewTypeName(pSViewType.getPSViewTypeName());
                    pSCoreSysServiceBase.compileModelV2(rv, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string5);
                if (((File)object2).exists()) {
                    File[] folders = ((File)object2).listFiles();
                    for (File folder : folders) {
                        if (!folder.isDirectory()) continue;
                        PSVTRV rv = new PSVTRV();
                        rv.setPSViewTypeId(pSViewType.getPSViewTypeId());
                        rv.setPSViewTypeName(pSViewType.getPSViewTypeName());
                        pSCoreSysServiceBase.compileModelV2(rv, null, string, folder.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSViewType, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSViewType pSViewType, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSVTCTRL_PSVIEWTYPE_PSVIEWTYPEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSVTCtrls(pSViewType, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSVTRV_PSVIEWTYPE_PSVIEWTYPEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSVTRVs(pSViewType, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSViewType, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSVTCtrls(PSViewType pSViewType, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSVTCTRL", true), (boolean)false) == 0) {
            PSVTCtrlService pSVTCtrlService = (PSVTCtrlService)ServiceGlobal.getService(PSVTCtrlService.class, (SessionFactory)this.getSessionFactory());
            PSVTCtrl pSVTCtrl = new PSVTCtrl();
            pSVTCtrl.setPSVTCtrlId(pSMOSFile.getPSModelId());
            if (!pSVTCtrlService.get(pSVTCtrl, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSVTCtrl.getPSViewTypeId(), (String)pSViewType.getPSViewTypeId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSVTCtrlService.exportModelV2(pSVTCtrl);
            pSVTCtrl.reset();
            if (!pSVTCtrlService.setModelV2ResScope(pSVTCtrl, "PSVIEWTYPE", pSViewType.getPSViewTypeId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSVTCtrlService.importModelV2(pSVTCtrl, objectNode);
            SessionFactoryManager.commit();
            return pSVTCtrlService.getFile(pSVTCtrl);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSVTRVs(PSViewType pSViewType, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSVTRV", true), (boolean)false) == 0) {
            PSVTRVService pSVTRVService = (PSVTRVService)ServiceGlobal.getService(PSVTRVService.class, (SessionFactory)this.getSessionFactory());
            PSVTRV pSVTRV = new PSVTRV();
            pSVTRV.setPSVTRVId(pSMOSFile.getPSModelId());
            if (!pSVTRVService.get(pSVTRV, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSVTRV.getPSViewTypeId(), (String)pSViewType.getPSViewTypeId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSVTRVService.exportModelV2(pSVTRV);
            pSVTRV.reset();
            if (!pSVTRVService.setModelV2ResScope(pSVTRV, "PSVIEWTYPE", pSViewType.getPSViewTypeId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSVTRVService.importModelV2(pSVTRV, objectNode);
            SessionFactoryManager.commit();
            return pSVTRVService.getFile(pSVTRV);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSViewType pSViewType, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSVTCtrls(pSViewType, list);
        this.onFillPasteHelps_PSVTRVs(pSViewType, list);
        super.onFillPasteHelps(pSViewType, list);
    }

    protected void onFillPasteHelps_PSVTCtrls(PSViewType pSViewType, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSVTCTRL");
        pSHelpSection.setSectionParam2("DER1N_PSVTCTRL_PSVIEWTYPE_PSVIEWTYPEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u4e91\u5e73\u53f0\u89c6\u56fe\u7c7b\u578b]\u7684[\u4e91\u5e73\u53f0\u89c6\u56fe\u7c7b\u578b\u90e8\u4ef6]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSVTRVs(PSViewType pSViewType, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSVTRV");
        pSHelpSection.setSectionParam2("DER1N_PSVTRV_PSVIEWTYPE_PSVIEWTYPEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u4e91\u5e73\u53f0\u89c6\u56fe\u7c7b\u578b]\u7684[\u4e91\u5e73\u53f0\u89c6\u56fe\u7c7b\u578b\u5173\u8054\u89c6\u56fe]");
        list.add(pSHelpSection);
    }
}
