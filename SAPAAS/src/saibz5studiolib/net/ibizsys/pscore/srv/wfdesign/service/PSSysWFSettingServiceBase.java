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
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
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
package net.ibizsys.pscore.srv.wfdesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTemplBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.dao.PSSysWFSettingDAO;
import net.ibizsys.pscore.srv.wfdesign.demodel.PSSysWFSettingDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSSysWFSetting;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFUtilUIAction;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFUtilUIActionService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysWFSettingServiceBase
extends PSCoreSysServiceBase<PSSysWFSetting> {
    private static final Log log = LogFactory.getLog(PSSysWFSettingServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysWFSettingDEModel pSSysWFSettingDEModel;
    private PSSysWFSettingDAO pSSysWFSettingDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfdesign.service.PSSysWFSettingService";
    }

    public PSSysWFSettingDEModel getPSSysWFSettingDEModel() {
        if (this.pSSysWFSettingDEModel == null) {
            try {
                this.pSSysWFSettingDEModel = (PSSysWFSettingDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSSysWFSettingDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysWFSettingDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysWFSettingDEModel();
    }

    public PSSysWFSettingDAO getPSSysWFSettingDAO() {
        if (this.pSSysWFSettingDAO == null) {
            try {
                this.pSSysWFSettingDAO = (PSSysWFSettingDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfdesign.dao.PSSysWFSettingDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysWFSettingDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysWFSettingDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysWFSetting pSSysWFSetting, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSWFSETTING_PSSYSMSGTEMPL_PSSYSMSGTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService", (SessionFactory)this.getSessionFactory());
            PSSysMsgTempl pSSysMsgTempl = (PSSysMsgTempl)iService.getDEModel().createEntity();
            pSSysMsgTempl.set("PSSYSMSGTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysMsgTempl);
            } else {
                iService.get(pSSysMsgTempl);
            }
            this.onFillParentInfo_PSSysMsgTempl(pSSysWFSetting, pSSysMsgTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSWFSETTING_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysWFSetting, pSSystem);
            return;
        }
        super.onFillParentInfo(pSSysWFSetting, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysMsgTempl(PSSysWFSetting pSSysWFSetting, PSSysMsgTempl pSSysMsgTempl) throws Exception {
        pSSysWFSetting.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
        pSSysWFSetting.setPSSysMsgTemplName(pSSysMsgTempl.getPSSysMsgTemplName());
    }

    protected void onFillParentInfo_PSSystem(PSSysWFSetting pSSysWFSetting, PSSystem pSSystem) throws Exception {
        pSSysWFSetting.setPSSystemId(pSSystem.getPSSystemId());
        pSSysWFSetting.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysWFSetting pSSysWFSetting, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSysWFSetting, bl);
        this.onFillEntityFullInfo_PSSysMsgTempl(pSSysWFSetting, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysWFSetting, bl);
    }

    protected void onFillEntityFullInfo_PSSysMsgTempl(PSSysWFSetting pSSysWFSetting, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysWFSetting pSSysWFSetting, boolean bl) throws Exception {
        if (pSSysWFSetting.isPSSystemIdDirty()) {
            if (pSSysWFSetting.getPSSystemId() != null) {
                if (pSSysWFSetting.getPSSystemId() == null || pSSysWFSetting.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysWFSetting.getPSSystem();
                    pSSysWFSetting.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysWFSetting.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysWFSetting pSSysWFSetting, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysWFSetting, bl);
    }

    public ArrayList<PSSysWFSetting> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase) throws Exception {
        return this.selectByPSSysMsgTempl(pSSysMsgTemplBase, "", -1);
    }

    public ArrayList<PSSysWFSetting> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase, String string) throws Exception {
        return this.selectByPSSysMsgTempl(pSSysMsgTemplBase, string, -1);
    }

    public ArrayList<PSSysWFSetting> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMSGTEMPLID", (Object)pSSysMsgTemplBase.getPSSysMsgTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysMsgTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysMsgTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysWFSetting> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysWFSetting> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysWFSetting> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMID", (Object)pSSystemBase.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSSysWFSetting> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMSGTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysMsgTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSWFSETTING_PSSYSMSGTEMPL_PSSYSMSGTEMPLID", "", iDataEntityModel.getName(), "PSSYSWFSETTING", iDataEntityModel.getDataInfo(pSSysMsgTempl), arrayList.get(0)));
        }
    }

    public void resetPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSSysWFSetting> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl);
        for (PSSysWFSetting pSSysWFSetting : arrayList) {
            PSSysWFSetting pSSysWFSetting2 = (PSSysWFSetting)this.getDEModel().createEntity();
            pSSysWFSetting2.setPSSysWFSettingId(pSSysWFSetting.getPSSysWFSettingId());
            pSSysWFSetting2.setPSSysMsgTemplId(null);
            this.update(pSSysWFSetting2);
        }
    }

    public void removeByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        final PSSysMsgTempl pSSysMsgTempl2 = pSSysMsgTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysWFSettingServiceBase.this.onBeforeRemoveByPSSysMsgTempl(pSSysMsgTempl2);
                PSSysWFSettingServiceBase.this.internalRemoveByPSSysMsgTempl(pSSysMsgTempl2);
                PSSysWFSettingServiceBase.this.onAfterRemoveByPSSysMsgTempl(pSSysMsgTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
    }

    protected void internalRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSSysWFSetting> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl);
        this.onBeforeRemoveByPSSysMsgTempl(pSSysMsgTempl, arrayList);
        for (PSSysWFSetting pSSysWFSetting : arrayList) {
            this.remove(pSSysWFSetting);
        }
        this.onAfterRemoveByPSSysMsgTempl(pSSysMsgTempl, arrayList);
    }

    protected void onAfterRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl, ArrayList<PSSysWFSetting> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl, ArrayList<PSSysWFSetting> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysWFSetting> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysWFSetting pSSysWFSetting : arrayList) {
            PSSysWFSetting pSSysWFSetting2 = (PSSysWFSetting)this.getDEModel().createEntity();
            pSSysWFSetting2.setPSSysWFSettingId(pSSysWFSetting.getPSSysWFSettingId());
            pSSysWFSetting2.setPSSystemId(null);
            this.update(pSSysWFSetting2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysWFSettingServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysWFSettingServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysWFSettingServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysWFSetting> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysWFSetting pSSysWFSetting : arrayList) {
            this.remove(pSSysWFSetting);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysWFSetting> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysWFSetting> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysWFSetting pSSysWFSetting) throws Exception {
        PSWFUtilUIActionService pSWFUtilUIActionService = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
        pSWFUtilUIActionService.testRemoveByPSSysWFSetting(pSSysWFSetting);
        super.onBeforeRemove(pSSysWFSetting);
    }

    protected void replaceParentInfo(PSSysWFSetting pSSysWFSetting, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysWFSetting, cloneSession);
        if (pSSysWFSetting.getPSSysMsgTemplId() != null && (iEntity = cloneSession.getEntity("PSSYSMSGTEMPL", (Object)pSSysWFSetting.getPSSysMsgTemplId())) != null) {
            this.onFillParentInfo_PSSysMsgTempl(pSSysWFSetting, (PSSysMsgTempl)iEntity);
        }
        if (pSSysWFSetting.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysWFSetting.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysWFSetting, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysWFSetting pSSysWFSetting, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysWFSetting, bl);
        pSSysWFSetting.resetCodeName();
    }

    protected void onCheckEntity(boolean bl, PSSysWFSetting pSSysWFSetting, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysWFSetting, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysWFSetting, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMsgTemplId(bl, pSSysWFSetting, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysWFSetting, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysWFSetting, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysWFSettingId(bl, pSSysWFSetting, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysWFSettingName(bl, pSSysWFSetting, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSSysWFSetting, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysWFSetting, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysWFSetting pSSysWFSetting, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysWFSetting.isCodeNameDirty() : !pSSysWFSetting.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysWFSetting.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysWFSetting, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysWFSettingDEModel(), "CODENAME", string3, pSSysWFSetting, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysWFSetting pSSysWFSetting, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysWFSetting.isMemoDirty() : !pSSysWFSetting.isMemoDirty()) {
            return null;
        }
        String string = pSSysWFSetting.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysWFSetting, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysMsgTemplId(boolean bl, PSSysWFSetting pSSysWFSetting, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysWFSetting.isPSSysMsgTemplIdDirty() : !pSSysWFSetting.isPSSysMsgTemplIdDirty()) {
            return null;
        }
        String string = pSSysWFSetting.getPSSysMsgTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMsgTemplId_Default(pSSysWFSetting, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysWFSetting pSSysWFSetting, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysWFSetting.isPSSystemIdDirty() : !pSSysWFSetting.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysWFSetting.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysWFSetting, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysWFSetting pSSysWFSetting, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysWFSetting.isPSSystemNameDirty() : !pSSysWFSetting.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysWFSetting.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSSysWFSetting, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysWFSettingId(boolean bl, PSSysWFSetting pSSysWFSetting, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysWFSetting.isPSSysWFSettingIdDirty() && !bl2 : !pSSysWFSetting.isPSSysWFSettingIdDirty()) {
            return null;
        }
        String string = pSSysWFSetting.getPSSysWFSettingId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSWFSETTINGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysWFSettingId_Default(pSSysWFSetting, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSWFSETTINGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysWFSettingName(boolean bl, PSSysWFSetting pSSysWFSetting, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysWFSetting.isPSSysWFSettingNameDirty() && !bl2 : !pSSysWFSetting.isPSSysWFSettingNameDirty()) {
            return null;
        }
        String string = pSSysWFSetting.getPSSysWFSettingName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSWFSETTINGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysWFSettingName_Default(pSSysWFSetting, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSWFSETTINGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSSysWFSetting pSSysWFSetting, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysWFSetting.isUserParamsDirty() : !pSSysWFSetting.isUserParamsDirty()) {
            return null;
        }
        String string = pSSysWFSetting.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSSysWFSetting, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysWFSetting pSSysWFSetting, boolean bl) throws Exception {
        super.onSyncEntity(pSSysWFSetting, bl);
    }

    protected void onSyncIndexEntities(PSSysWFSetting pSSysWFSetting, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysWFSetting, bl);
    }

    public Object getDataContextValue(PSSysWFSetting pSSysWFSetting, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysWFSetting, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysWFSetting pSSysWFSetting, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysWFSetting, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSWFSETTINGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysWFSettingId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSWFSETTINGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysWFSettingName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_PSSysMsgTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMsgTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysWFSettingId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSWFSETTINGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysWFSettingName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSWFSETTINGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysWFSetting pSSysWFSetting) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysWFSetting)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysWFSetting pSSysWFSetting) throws Exception {
        super.onUpdateParent(pSSysWFSetting);
    }

    @Override
    protected void exportCurXmlModel(PSSysWFSetting pSSysWFSetting, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSWFSETTING");
        if (!bl) {
            pSSysWFSetting.setCreateDate(null);
            pSSysWFSetting.setCreateMan(null);
            pSSysWFSetting.setPSSysWFSettingId(null);
            pSSysWFSetting.setUpdateDate(null);
            pSSysWFSetting.setUpdateMan(null);
            super.exportCurXmlModel(pSSysWFSetting, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysWFSetting pSSysWFSetting, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysWFSetting, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTEM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSWFSETTING_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSTEM", (boolean)true) == 0) {
            iEntity.set("PSSYSTEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSysWFSetting pSSysWFSetting) {
        if (!StringHelper.isNullOrEmpty((String)pSSysWFSetting.getCodeName())) {
            return pSSysWFSetting.getCodeName();
        }
        return super.getModelV2Tag(pSSysWFSetting);
    }

    @Override
    public boolean setModelV2Tag(PSSysWFSetting pSSysWFSetting, String string) {
        pSSysWFSetting.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysWFSetting pSSysWFSetting, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysWFSetting.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysWFSetting, true);
        pSSysWFSetting.set("CODENAME", string);
        if (this.select(pSSysWFSetting, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysWFSetting, true);
        return super.getModelV2Entity(pSSysWFSetting, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysWFSetting pSSysWFSetting, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysWFSetting, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSWFUTILUIACTION_PSSYSWFSETTING_PSSYSWFSETTINGID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 90;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysWFSetting pSSysWFSetting, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSWFUTILUIACTION_PSSYSWFSETTING_PSSYSWFSETTINGID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSWFSETTING#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSWFUTILUIACTION", (Object)pSSysWFSetting.getPSSysWFSettingId()))).exists()) {
            PSWFUtilUIActionService pSWFUtilUIActionService = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSWFUtilUIActionService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSWFUtilUIAction pSWFUtilUIAction = new PSWFUtilUIAction();
                PSModelV2Helper.fromJSONObject((IDataObject)pSWFUtilUIAction, objectNode, false);
                String string6 = pSWFUtilUIActionService.getModelV2Tag(pSWFUtilUIAction);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSWFUTILUIACTION", (Object)pSWFUtilUIAction.getPSWFUtilUIActionId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSWFUtilUIActionService.exportModelV2(pSWFUtilUIAction, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysWFSetting, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysWFSetting pSSysWFSetting, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWFUTILUIACTION_PSSYSWFSETTING_PSSYSWFSETTINGID")) {
            PSWFUtilUIActionService pSWFUtilUIActionService = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSWFSETTING#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWFUTILUIACTION", (Object)pSSysWFSetting.getPSSysWFSettingId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSWFSETTING#%1$s", (Object)pSSysWFSetting.getPSSysWFSettingId());
                for (PSWFUtilUIAction action : pSWFUtilUIActionService.selectByPSSysWFSetting(pSSysWFSetting)) {
                    String actionScope = pSWFUtilUIActionService.getModelV2ResScope(action);
                    if (StringHelper.compare((String)scope, (String)actionScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(action, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode output = objectNode.putArray(pSWFUtilUIActionService.getModelV2Name(false).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("pswfutiluiactionname")) {
                            string = objectNode.get("pswfutiluiactionname").asText();
                        }
                        if (objectNode2.has("pswfutiluiactionname")) {
                            string2 = objectNode2.get("pswfutiluiactionname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode actionNode : arrayList) {
                    PSWFUtilUIAction action = new PSWFUtilUIAction();
                    PSModelV2Helper.fromJSONObject((IDataObject)action, actionNode, false);
                    output.add((JsonNode)pSWFUtilUIActionService.exportModelV2(action, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysWFSetting, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysWFSetting pSSysWFSetting) throws Exception {
        super.onEmptyModelV2(pSSysWFSetting);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSWFUtilUIActionService pSWFUtilUIActionService = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
        if (pSWFUtilUIActionService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysWFSetting pSSysWFSetting, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSWFUtilUIAction pSWFUtilUIAction = new PSWFUtilUIAction();
        pSWFUtilUIAction.set("PSSYSWFSETTINGID", pSSysWFSetting.getPSSysWFSettingId());
        PSWFUtilUIActionService pSWFUtilUIActionService = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSWFUtilUIActionService.getModelV2Entity(pSWFUtilUIAction, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysWFSetting, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysWFSetting pSSysWFSetting, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSSysWFSettingServiceBase.isSimpleImportExportMode("")) {
            PSWFUtilUIActionService pSWFUtilUIActionService = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSWFUtilUIActionService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSWFUtilUIAction pSWFUtilUIAction = new PSWFUtilUIAction();
                    pSWFUtilUIAction.setPSSysWFSettingId(pSSysWFSetting.getPSSysWFSettingId());
                    pSWFUtilUIAction.setPSSysWFSettingName(pSSysWFSetting.getPSSysWFSettingName());
                    pSWFUtilUIActionService.compileModelV2(pSWFUtilUIAction, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSWFUtilUIAction pSWFUtilUIAction = new PSWFUtilUIAction();
                        pSWFUtilUIAction.setPSSysWFSettingId(pSSysWFSetting.getPSSysWFSettingId());
                        pSWFUtilUIAction.setPSSysWFSettingName(pSSysWFSetting.getPSSysWFSettingName());
                        pSWFUtilUIActionService.compileModelV2(pSWFUtilUIAction, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysWFSetting, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysWFSetting pSSysWFSetting, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSWFUTILUIACTION_PSSYSWFSETTING_PSSYSWFSETTINGID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSWFUtilUIActions(pSSysWFSetting, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysWFSetting, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSWFUtilUIActions(PSSysWFSetting pSSysWFSetting, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSWFUTILUIACTION", true), (boolean)false) == 0) {
            PSWFUtilUIActionService pSWFUtilUIActionService = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
            PSWFUtilUIAction pSWFUtilUIAction = new PSWFUtilUIAction();
            pSWFUtilUIAction.setPSWFUtilUIActionId(pSMOSFile.getPSModelId());
            if (!pSWFUtilUIActionService.get(pSWFUtilUIAction, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSWFUtilUIAction.getPSSysWFSettingId(), (String)pSSysWFSetting.getPSSysWFSettingId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSWFUtilUIActionService.exportModelV2(pSWFUtilUIAction);
            pSWFUtilUIAction.reset();
            if (!pSWFUtilUIActionService.setModelV2ResScope(pSWFUtilUIAction, "PSSYSWFSETTING", pSSysWFSetting.getPSSysWFSettingId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSWFUtilUIActionService.importModelV2(pSWFUtilUIAction, objectNode);
            SessionFactoryManager.commit();
            return pSWFUtilUIActionService.getFile(pSWFUtilUIAction);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysWFSetting pSSysWFSetting, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSWFUtilUIActions(pSSysWFSetting, list);
        super.onFillPasteHelps(pSSysWFSetting, list);
    }

    protected void onFillPasteHelps_PSWFUtilUIActions(PSSysWFSetting pSSysWFSetting, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSWFUTILUIACTION");
        pSHelpSection.setSectionParam2("DER1N_PSWFUTILUIACTION_PSSYSWFSETTING_PSSYSWFSETTINGID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u5de5\u4f5c\u6d41\u8bbe\u7f6e]\u7684[\u5de5\u4f5c\u6d41\u529f\u80fd\u64cd\u4f5c]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u529f\u80fd\u754c\u9762\u884c\u4e3a>", "DER1N_PSWFUTILUIACTION_PSSYSWFSETTING_PSSYSWFSETTINGID", "PSSYSWFSETTINGID", pSMOSFile.getPSModelId(), "", "")) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            if (PSSysWFSettingServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u529f\u80fd\u754c\u9762\u884c\u4e3a>");
            } else if (PSSysWFSettingServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pswfutiluiactions");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSWFUTILUIACTION_PSSYSWFSETTING_PSSYSWFSETTINGID|PSSYSWFSETTINGID");
            pSMOSFile2.setFileTag3("PSWFUTILUIACTION");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSWFUTILUIACTION_PSSYSWFSETTING_PSSYSWFSETTINGID", "PSSYSWFSETTINGID", pSMOSFile.getPSModelId(), "", "")) {
                PSWFUtilUIActionService pSWFUtilUIActionService = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
                SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSWFUtilUIActionService, "DER1N_PSWFUTILUIACTION_PSSYSWFSETTING_PSSYSWFSETTINGID", "PSSYSWFSETTINGID", pSMOSFile.getPSModelId(), "", "");
                SelectField selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                ArrayList arrayList = pSWFUtilUIActionService.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysWFSettingServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (hashMap.size() > 0) {
            return PSMOSFileUtil.append(hashMap.values().toArray(new PSMOSFile[hashMap.size()]), super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter));
        }
        return super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter);
    }

    @Override
    protected PSMOSFile[] onListDRDataFolders(PSMOSFile pSMOSFile, String string, String string2, IPSMOSFileFilter iPSMOSFileFilter, boolean bl) throws Exception {
        ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
        if (PSSysWFSettingServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u529f\u80fd\u754c\u9762\u884c\u4e3a>", (boolean)false) == 0 || PSSysWFSettingServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSWFUtilUIActions", (boolean)true) == 0) {
            PSWFUtilUIActionService pSWFUtilUIActionService = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSWFUtilUIActionService, "DER1N_PSWFUTILUIACTION_PSSYSWFSETTING_PSSYSWFSETTINGID", "PSSYSWFSETTINGID", pSMOSFile.getPSModelId(), "", "");
            ArrayList<PSWFUtilUIAction> arrayList2 = pSWFUtilUIActionService.selectEx((ISelectContext)selectContext);
            for (PSWFUtilUIAction pSWFUtilUIAction : arrayList2) {
                PSMOSFile pSMOSFile2 = pSWFUtilUIActionService.getFile(pSMOSFile, pSWFUtilUIAction, bl);
                if (pSMOSFile2 == null) continue;
                arrayList.add(pSMOSFile2);
            }
        }
        if (arrayList.size() > 0) {
            return PSMOSFileUtil.append(arrayList.toArray(new PSMOSFile[arrayList.size()]), super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl));
        }
        return super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSWFUTILUIACTION_PSSYSWFSETTING_PSSYSWFSETTINGID", (boolean)false) == 0) {
            if (PSSysWFSettingServiceBase.getMOSVer() == 1) {
                return "<\u529f\u80fd\u754c\u9762\u884c\u4e3a>";
            }
            if (PSSysWFSettingServiceBase.getMOSVer() == 2) {
                return "pswfutiluiactions";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }
}

