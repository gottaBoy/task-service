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
 *  net.ibizsys.paas.db.SelectCond
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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.paas.db.SelectCond;
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
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysDBProcDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDBProcDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBProc;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBProcParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBScheme;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBSchemeBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBProcParamService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDBProcServiceBase
extends PSCoreSysServiceBase<PSSysDBProc> {
    private static final Log log = LogFactory.getLog(PSSysDBProcServiceBase.class);
    public static final String DATASET_CURSCHEME = "CurScheme";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysDBProcDEModel pSSysDBProcDEModel;
    private PSSysDBProcDAO pSSysDBProcDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysDBProcService";
    }

    public PSSysDBProcDEModel getPSSysDBProcDEModel() {
        if (this.pSSysDBProcDEModel == null) {
            try {
                this.pSSysDBProcDEModel = (PSSysDBProcDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDBProcDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDBProcDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysDBProcDEModel();
    }

    public PSSysDBProcDAO getPSSysDBProcDAO() {
        if (this.pSSysDBProcDAO == null) {
            try {
                this.pSSysDBProcDAO = (PSSysDBProcDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysDBProcDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDBProcDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysDBProcDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSCHEME, (boolean)true) == 0) {
            return this.fetchCurScheme(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurScheme(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSCHEME, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysDBProc pSSysDBProc, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDBPROC_PSSYSDBSCHEME_PSSYSDBSCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeService", (SessionFactory)this.getSessionFactory());
            PSSysDBScheme pSSysDBScheme = (PSSysDBScheme)iService.getDEModel().createEntity();
            pSSysDBScheme.set("PSSYSDBSCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDBScheme);
            } else {
                iService.get(pSSysDBScheme);
            }
            this.onFillParentInfo_PSSysDBScheme(pSSysDBProc, pSSysDBScheme);
            return;
        }
        super.onFillParentInfo(pSSysDBProc, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysDBScheme(PSSysDBProc pSSysDBProc, PSSysDBScheme pSSysDBScheme) throws Exception {
        pSSysDBProc.setPSSysDBSchemeId(pSSysDBScheme.getPSSysDBSchemeId());
        pSSysDBProc.setPSSysDBSchemeName(pSSysDBScheme.getPSSysDBSchemeName());
    }

    protected void onFillEntityFullInfo(PSSysDBProc pSSysDBProc, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSysDBProc, bl);
        this.onFillEntityFullInfo_PSSysDBScheme(pSSysDBProc, bl);
    }

    protected void onFillEntityFullInfo_PSSysDBScheme(PSSysDBProc pSSysDBProc, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysDBProc pSSysDBProc, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysDBProc, bl);
    }

    public ArrayList<PSSysDBProc> selectByPSSysDBScheme(PSSysDBSchemeBase pSSysDBSchemeBase) throws Exception {
        return this.selectByPSSysDBScheme(pSSysDBSchemeBase, "", -1);
    }

    public ArrayList<PSSysDBProc> selectByPSSysDBScheme(PSSysDBSchemeBase pSSysDBSchemeBase, String string) throws Exception {
        return this.selectByPSSysDBScheme(pSSysDBSchemeBase, string, -1);
    }

    public ArrayList<PSSysDBProc> selectByPSSysDBScheme(PSSysDBSchemeBase pSSysDBSchemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDBSCHEMEID", (Object)pSSysDBSchemeBase.getPSSysDBSchemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDBSchemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDBSchemeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
        ArrayList<PSSysDBProc> arrayList = this.selectByPSSysDBScheme(pSSysDBScheme, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDBSCHEME");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDBScheme);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDBPROC_PSSYSDBSCHEME_PSSYSDBSCHEMEID", "", iDataEntityModel.getName(), "PSSYSDBPROC", iDataEntityModel.getDataInfo(pSSysDBScheme), arrayList.get(0)));
        }
    }

    public void resetPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
        ArrayList<PSSysDBProc> arrayList = this.selectByPSSysDBScheme(pSSysDBScheme);
        for (PSSysDBProc pSSysDBProc : arrayList) {
            PSSysDBProc pSSysDBProc2 = (PSSysDBProc)this.getDEModel().createEntity();
            pSSysDBProc2.setPSSysDBProcId(pSSysDBProc.getPSSysDBProcId());
            pSSysDBProc2.setPSSysDBSchemeId(null);
            this.update(pSSysDBProc2);
        }
    }

    public void removeByPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
        final PSSysDBScheme pSSysDBScheme2 = pSSysDBScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBProcServiceBase.this.onBeforeRemoveByPSSysDBScheme(pSSysDBScheme2);
                PSSysDBProcServiceBase.this.internalRemoveByPSSysDBScheme(pSSysDBScheme2);
                PSSysDBProcServiceBase.this.onAfterRemoveByPSSysDBScheme(pSSysDBScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
    }

    protected void internalRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
        ArrayList<PSSysDBProc> arrayList = this.selectByPSSysDBScheme(pSSysDBScheme);
        this.onBeforeRemoveByPSSysDBScheme(pSSysDBScheme, arrayList);
        for (PSSysDBProc pSSysDBProc : arrayList) {
            this.remove(pSSysDBProc);
        }
        this.onAfterRemoveByPSSysDBScheme(pSSysDBScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme, ArrayList<PSSysDBProc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme, ArrayList<PSSysDBProc> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysDBProc pSSysDBProc) throws Exception {
        PSSysDBProcParamService pSSysDBProcParamService = (PSSysDBProcParamService)ServiceGlobal.getService(PSSysDBProcParamService.class, (SessionFactory)this.getSessionFactory());
        pSSysDBProcParamService.testRemoveByPSSysDBProc(pSSysDBProc);
        pSSysDBProcParamService.removeByPSSysDBProc(pSSysDBProc);
        super.onBeforeRemove(pSSysDBProc);
    }

    protected void replaceParentInfo(PSSysDBProc pSSysDBProc, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysDBProc, cloneSession);
        if (pSSysDBProc.getPSSysDBSchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSDBSCHEME", (Object)pSSysDBProc.getPSSysDBSchemeId())) != null) {
            this.onFillParentInfo_PSSysDBScheme(pSSysDBProc, (PSSysDBScheme)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysDBProc pSSysDBProc, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysDBProc, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysDBProc pSSysDBProc, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysDBProc, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName2(bl, pSSysDBProc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSSysDBProc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysDBProc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ProcDesc(bl, pSSysDBProc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBProcId(bl, pSSysDBProc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBProcName(bl, pSSysDBProc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBSchemeId(bl, pSSysDBProc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysDBProc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysDBProc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysDBProc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysDBProc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysDBProc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysDBProc, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysDBProc pSSysDBProc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProc.isCodeNameDirty() : !pSSysDBProc.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysDBProc.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysDBProc, bl2, bl3);
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
                string3 = "PSSYSDBSCHEMEID";
                String string4 = this.checkFieldDupRule(this.getPSSysDBProcDEModel(), "CODENAME", string3, pSSysDBProc, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName2(boolean bl, PSSysDBProc pSSysDBProc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProc.isCodeName2Dirty() : !pSSysDBProc.isCodeName2Dirty()) {
            return null;
        }
        String string = pSSysDBProc.getCodeName2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName2_Default(pSSysDBProc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME2");
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
                string3 = "PSSYSDBSCHEMEID";
                String string4 = this.checkFieldDupRule(this.getPSSysDBProcDEModel(), "CODENAME2", string3, pSSysDBProc, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME2");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSSysDBProc pSSysDBProc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProc.isLogicNameDirty() : !pSSysDBProc.isLogicNameDirty()) {
            return null;
        }
        String string = pSSysDBProc.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSSysDBProc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysDBProc pSSysDBProc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProc.isMemoDirty() : !pSSysDBProc.isMemoDirty()) {
            return null;
        }
        String string = pSSysDBProc.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysDBProc, bl2, bl3);
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

    protected EntityFieldError onCheckField_ProcDesc(boolean bl, PSSysDBProc pSSysDBProc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProc.isProcDescDirty() : !pSSysDBProc.isProcDescDirty()) {
            return null;
        }
        String string = pSSysDBProc.getProcDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ProcDesc_Default(pSSysDBProc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROCDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBProcId(boolean bl, PSSysDBProc pSSysDBProc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProc.isPSSysDBProcIdDirty() && !bl2 : !pSSysDBProc.isPSSysDBProcIdDirty()) {
            return null;
        }
        String string = pSSysDBProc.getPSSysDBProcId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBPROCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBProcId_Default(pSSysDBProc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBPROCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBProcName(boolean bl, PSSysDBProc pSSysDBProc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProc.isPSSysDBProcNameDirty() && !bl2 : !pSSysDBProc.isPSSysDBProcNameDirty()) {
            return null;
        }
        String string = pSSysDBProc.getPSSysDBProcName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBPROCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBProcName_Default(pSSysDBProc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBPROCNAME");
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
                string3 = "PSSYSDBSCHEMEID";
                String string4 = this.checkFieldDupRule(this.getPSSysDBProcDEModel(), "PSSYSDBPROCNAME", string3, pSSysDBProc, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSDBPROCNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBSchemeId(boolean bl, PSSysDBProc pSSysDBProc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProc.isPSSysDBSchemeIdDirty() && !bl2 : !pSSysDBProc.isPSSysDBSchemeIdDirty()) {
            return null;
        }
        String string = pSSysDBProc.getPSSysDBSchemeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBSCHEMEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBSchemeId_Default(pSSysDBProc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBSCHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysDBProc pSSysDBProc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProc.isUserCatDirty() : !pSSysDBProc.isUserCatDirty()) {
            return null;
        }
        String string = pSSysDBProc.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysDBProc, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysDBProc pSSysDBProc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProc.isUserTagDirty() : !pSSysDBProc.isUserTagDirty()) {
            return null;
        }
        String string = pSSysDBProc.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysDBProc, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysDBProc pSSysDBProc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProc.isUserTag2Dirty() : !pSSysDBProc.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysDBProc.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysDBProc, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysDBProc pSSysDBProc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProc.isUserTag3Dirty() : !pSSysDBProc.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysDBProc.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysDBProc, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysDBProc pSSysDBProc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBProc.isUserTag4Dirty() : !pSSysDBProc.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysDBProc.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysDBProc, bl2, bl3);
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

    protected void onSyncEntity(PSSysDBProc pSSysDBProc, boolean bl) throws Exception {
        super.onSyncEntity(pSSysDBProc, bl);
    }

    protected void onSyncIndexEntities(PSSysDBProc pSSysDBProc, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysDBProc, bl);
    }

    public Object getDataContextValue(PSSysDBProc pSSysDBProc, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysDBProc, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysDBScheme pSSysDBScheme = pSSysDBProc.getPSSysDBScheme();
        if (pSSysDBScheme != null && pSSysDBScheme.contains(string)) {
            return pSSysDBScheme.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysDBProc pSSysDBProc, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysDBProc, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROCDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ProcDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBPROCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBProcId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBPROCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBProcName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBSCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBSchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBSCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBSchemeName_Default(iEntity, bl, bl2);
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
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME2", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_ProcDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROCDESC", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBProcId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBPROCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBProcName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBPROCNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("PSSYSDBPROCNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBSchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBSCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBSchemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBSCHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysDBProc pSSysDBProc) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysDBProc)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysDBProc pSSysDBProc) throws Exception {
        super.onUpdateParent(pSSysDBProc);
    }

    @Override
    protected void exportCurXmlModel(PSSysDBProc pSSysDBProc, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSDBPROC");
        if (!bl) {
            pSSysDBProc.setCreateDate(null);
            pSSysDBProc.setCreateMan(null);
            pSSysDBProc.setPSSysDBProcId(null);
            pSSysDBProc.setUpdateDate(null);
            pSSysDBProc.setUpdateMan(null);
            super.exportCurXmlModel(pSSysDBProc, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysDBProc pSSysDBProc, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysDBProc, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDBSCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSDBSCHEME#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDBSCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSDBPROC_PSSYSDBSCHEME_PSSYSDBSCHEMEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDBSCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDBSCHEMENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSDBSCHEME", (boolean)true) == 0) {
            iEntity.set("PSSYSDBSCHEMEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSDBSCHEMEID"};
    }

    @Override
    public String getModelV2Tag(PSSysDBProc pSSysDBProc) {
        if (!StringHelper.isNullOrEmpty((String)pSSysDBProc.getPSSysDBProcName())) {
            return pSSysDBProc.getPSSysDBProcName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysDBProc.getPSSysDBProcName())) {
            return pSSysDBProc.getPSSysDBProcName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysDBProc.getCodeName())) {
            return pSSysDBProc.getCodeName();
        }
        return super.getModelV2Tag(pSSysDBProc);
    }

    @Override
    public boolean setModelV2Tag(PSSysDBProc pSSysDBProc, String string) {
        return super.setModelV2Tag(pSSysDBProc, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSDBPROCNAME", "");
        map.put("PSSYSDBPROCNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSDBSCHEMEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysDBProc pSSysDBProc, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysDBProc.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysDBProc, true);
        pSSysDBProc.set("PSSYSDBPROCNAME", string);
        if (this.select(pSSysDBProc, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysDBProc, true);
        return super.getModelV2Entity(pSSysDBProc, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysDBProc pSSysDBProc, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysDBProc, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSDBPROCPARAM_PSSYSDBPROC_PSSYSDBPROCID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysDBProc pSSysDBProc, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSDBPROCPARAM_PSSYSDBPROC_PSSYSDBPROCID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSDBPROC#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSDBPROCPARAM", (Object)pSSysDBProc.getPSSysDBProcId()))).exists()) {
            PSSysDBProcParamService pSSysDBProcParamService = (PSSysDBProcParamService)ServiceGlobal.getService(PSSysDBProcParamService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSSysDBProcParamService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSSysDBProcParam pSSysDBProcParam = new PSSysDBProcParam();
                PSModelV2Helper.fromJSONObject((IDataObject)pSSysDBProcParam, objectNode, false);
                String string6 = pSSysDBProcParamService.getModelV2Tag(pSSysDBProcParam);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSDBPROCPARAM", (Object)pSSysDBProcParam.getPSSysDBProcParamId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSSysDBProcParamService.exportModelV2(pSSysDBProcParam, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysDBProc, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysDBProc pSSysDBProc, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSDBPROCPARAM_PSSYSDBPROC_PSSYSDBPROCID")) {
            PSSysDBProcParamService pSSysDBProcParamService = (PSSysDBProcParamService)ServiceGlobal.getService(PSSysDBProcParamService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSDBPROC#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSDBPROCPARAM", (Object)pSSysDBProc.getPSSysDBProcId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSDBPROC#%1$s", (Object)pSSysDBProc.getPSSysDBProcId());
                for (PSSysDBProcParam item : pSSysDBProcParamService.selectByPSSysDBProc(pSSysDBProc)) {
                    if (StringHelper.compare((String)scope, (String)pSSysDBProcParamService.getModelV2ResScope(item), (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(item, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode related = objectNode.putArray(pSSysDBProcParamService.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pssysdbprocparamname")) {
                            string = objectNode.get("pssysdbprocparamname").asText();
                        }
                        if (objectNode2.has("pssysdbprocparamname")) {
                            string2 = objectNode2.get("pssysdbprocparamname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode itemNode : arrayList) {
                    PSSysDBProcParam item = new PSSysDBProcParam();
                    PSModelV2Helper.fromJSONObject((IDataObject)item, itemNode, false);
                    related.add((JsonNode)pSSysDBProcParamService.exportModelV2(item, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysDBProc, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysDBProc pSSysDBProc) throws Exception {
        super.onEmptyModelV2(pSSysDBProc);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysDBProcParamService pSSysDBProcParamService = (PSSysDBProcParamService)ServiceGlobal.getService(PSSysDBProcParamService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysDBProcParamService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysDBProc pSSysDBProc, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysDBProcParam pSSysDBProcParam = new PSSysDBProcParam();
        pSSysDBProcParam.set("PSSYSDBPROCID", pSSysDBProc.getPSSysDBProcId());
        PSSysDBProcParamService pSSysDBProcParamService = (PSSysDBProcParamService)ServiceGlobal.getService(PSSysDBProcParamService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysDBProcParamService.getModelV2Entity(pSSysDBProcParam, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysDBProc, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysDBProc pSSysDBProc, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSSysDBProcServiceBase.isSimpleImportExportMode("")) {
            PSSysDBProcParamService pSSysDBProcParamService = (PSSysDBProcParamService)ServiceGlobal.getService(PSSysDBProcParamService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSSysDBProcParamService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSSysDBProcParam pSSysDBProcParam = new PSSysDBProcParam();
                    pSSysDBProcParam.setPSSysDBProcId(pSSysDBProc.getPSSysDBProcId());
                    pSSysDBProcParam.setPSSysDBProcName(pSSysDBProc.getPSSysDBProcName());
                    pSSysDBProcParamService.compileModelV2(pSSysDBProcParam, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSSysDBProcParam pSSysDBProcParam = new PSSysDBProcParam();
                        pSSysDBProcParam.setPSSysDBProcId(pSSysDBProc.getPSSysDBProcId());
                        pSSysDBProcParam.setPSSysDBProcName(pSSysDBProc.getPSSysDBProcName());
                        pSSysDBProcParamService.compileModelV2(pSSysDBProcParam, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysDBProc, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysDBProc pSSysDBProc, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSDBPROCPARAM_PSSYSDBPROC_PSSYSDBPROCID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysDBProcParams(pSSysDBProc, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysDBProc, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysDBProcParams(PSSysDBProc pSSysDBProc, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSDBPROCPARAM", true), (boolean)false) == 0) {
            PSSysDBProcParamService pSSysDBProcParamService = (PSSysDBProcParamService)ServiceGlobal.getService(PSSysDBProcParamService.class, (SessionFactory)this.getSessionFactory());
            PSSysDBProcParam pSSysDBProcParam = new PSSysDBProcParam();
            pSSysDBProcParam.setPSSysDBProcParamId(pSMOSFile.getPSModelId());
            if (!pSSysDBProcParamService.get(pSSysDBProcParam, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysDBProcParam.getPSSysDBProcId(), (String)pSSysDBProc.getPSSysDBProcId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysDBProcParamService.exportModelV2(pSSysDBProcParam);
            pSSysDBProcParam.reset();
            if (!pSSysDBProcParamService.setModelV2ResScope(pSSysDBProcParam, "PSSYSDBPROC", pSSysDBProc.getPSSysDBProcId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysDBProcParamService.importModelV2(pSSysDBProcParam, objectNode);
            SessionFactoryManager.commit();
            return pSSysDBProcParamService.getFile(pSSysDBProcParam);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysDBProc pSSysDBProc, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysDBProcParams(pSSysDBProc, list);
        super.onFillPasteHelps(pSSysDBProc, list);
    }

    protected void onFillPasteHelps_PSSysDBProcParams(PSSysDBProc pSSysDBProc, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSDBPROCPARAM");
        pSHelpSection.setSectionParam2("DER1N_PSSYSDBPROCPARAM_PSSYSDBPROC_PSSYSDBPROCID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u6570\u636e\u5e93\u5b58\u50a8\u8fc7\u7a0b]\u7684[\u7cfb\u7edf\u6570\u636e\u5e93\u5b58\u50a8\u8fc7\u7a0b\u53c2\u6570]");
        list.add(pSHelpSection);
    }
}

