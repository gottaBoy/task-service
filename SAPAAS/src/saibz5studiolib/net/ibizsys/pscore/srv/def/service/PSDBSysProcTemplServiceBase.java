/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.def.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSDBType;
import net.ibizsys.pscore.srv.config.entity.PSDBTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.def.dao.PSDBSysProcTemplDAO;
import net.ibizsys.pscore.srv.def.demodel.PSDBSysProcTemplDEModel;
import net.ibizsys.pscore.srv.def.entity.PSDBSysProcTempl;
import net.ibizsys.pscore.srv.def.entity.PSDBSysProcType;
import net.ibizsys.pscore.srv.def.entity.PSDBSysProcTypeBase;
import net.ibizsys.pscore.srv.def.service.PSDBSPPartTemplService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDBSysProcTemplServiceBase
extends PSCoreSysServiceBase<PSDBSysProcTempl> {
    private static final Log log = LogFactory.getLog(PSDBSysProcTemplServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDBSysProcTemplDEModel pSDBSysProcTemplDEModel;
    private PSDBSysProcTemplDAO pSDBSysProcTemplDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.def.service.PSDBSysProcTemplService";
    }

    public PSDBSysProcTemplDEModel getPSDBSysProcTemplDEModel() {
        if (this.pSDBSysProcTemplDEModel == null) {
            try {
                this.pSDBSysProcTemplDEModel = (PSDBSysProcTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.def.demodel.PSDBSysProcTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDBSysProcTemplDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDBSysProcTemplDEModel();
    }

    public PSDBSysProcTemplDAO getPSDBSysProcTemplDAO() {
        if (this.pSDBSysProcTemplDAO == null) {
            try {
                this.pSDBSysProcTemplDAO = (PSDBSysProcTemplDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.def.dao.PSDBSysProcTemplDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDBSysProcTemplDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDBSysProcTemplDAO();
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

    protected void onFillParentInfo(PSDBSysProcTempl pSDBSysProcTempl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDBSYSPROCTEMPL_PSDBSYSPROCTYPE_PSDBSYSPROCTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSDBSysProcTypeService", (SessionFactory)this.getSessionFactory());
            PSDBSysProcType pSDBSysProcType = (PSDBSysProcType)iService.getDEModel().createEntity();
            pSDBSysProcType.set("PSDBSYSPROCTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDBSysProcType);
            } else {
                iService.get((IEntity)pSDBSysProcType);
            }
            this.onFillParentInfo_PSDBSysProcType(pSDBSysProcTempl, pSDBSysProcType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDBSYSPROCTEMPL_PSDBTYPE_PSDBTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDBTypeService", (SessionFactory)this.getSessionFactory());
            PSDBType pSDBType = (PSDBType)iService.getDEModel().createEntity();
            pSDBType.set("PSDBTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDBType);
            } else {
                iService.get((IEntity)pSDBType);
            }
            this.onFillParentInfo_PSDBType(pSDBSysProcTempl, pSDBType);
            return;
        }
        super.onFillParentInfo((IEntity)pSDBSysProcTempl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDBSysProcType(PSDBSysProcTempl pSDBSysProcTempl, PSDBSysProcType pSDBSysProcType) throws Exception {
        pSDBSysProcTempl.setPSDBSysProcTypeId(pSDBSysProcType.getPSDBSysProcTypeId());
        pSDBSysProcTempl.setPSDBSysProcTypeName(pSDBSysProcType.getPSDBSysProcTypeName());
    }

    protected void onFillParentInfo_PSDBType(PSDBSysProcTempl pSDBSysProcTempl, PSDBType pSDBType) throws Exception {
        pSDBSysProcTempl.setPSDBTypeId(pSDBType.getPSDBTypeId());
        pSDBSysProcTempl.setPSDBTypeName(pSDBType.getPSDBTypeName());
    }

    protected void onFillEntityFullInfo(PSDBSysProcTempl pSDBSysProcTempl, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDBSysProcTempl, bl);
        this.onFillEntityFullInfo_PSDBSysProcType(pSDBSysProcTempl, bl);
        this.onFillEntityFullInfo_PSDBType(pSDBSysProcTempl, bl);
    }

    protected void onFillEntityFullInfo_PSDBSysProcType(PSDBSysProcTempl pSDBSysProcTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDBType(PSDBSysProcTempl pSDBSysProcTempl, boolean bl) throws Exception {
        if (pSDBSysProcTempl.isPSDBTypeIdDirty()) {
            if (pSDBSysProcTempl.getPSDBTypeId() != null) {
                if (pSDBSysProcTempl.getPSDBTypeId() == null || pSDBSysProcTempl.getPSDBTypeName() == null) {
                    PSDBType pSDBType = pSDBSysProcTempl.getPSDBType();
                    pSDBSysProcTempl.setPSDBTypeName(pSDBType.getPSDBTypeName());
                }
            } else {
                pSDBSysProcTempl.setPSDBTypeName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDBSysProcTempl pSDBSysProcTempl, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDBSysProcTempl, bl);
    }

    public ArrayList<PSDBSysProcTempl> selectByPSDBSysProcType(PSDBSysProcTypeBase pSDBSysProcTypeBase) throws Exception {
        return this.selectByPSDBSysProcType(pSDBSysProcTypeBase, "", -1);
    }

    public ArrayList<PSDBSysProcTempl> selectByPSDBSysProcType(PSDBSysProcTypeBase pSDBSysProcTypeBase, String string) throws Exception {
        return this.selectByPSDBSysProcType(pSDBSysProcTypeBase, string, -1);
    }

    public ArrayList<PSDBSysProcTempl> selectByPSDBSysProcType(PSDBSysProcTypeBase pSDBSysProcTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDBSYSPROCTYPEID", (Object)pSDBSysProcTypeBase.getPSDBSysProcTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDBSysProcTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDBSysProcTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDBSysProcTempl> selectByPSDBType(PSDBTypeBase pSDBTypeBase) throws Exception {
        return this.selectByPSDBType(pSDBTypeBase, "", -1);
    }

    public ArrayList<PSDBSysProcTempl> selectByPSDBType(PSDBTypeBase pSDBTypeBase, String string) throws Exception {
        return this.selectByPSDBType(pSDBTypeBase, string, -1);
    }

    public ArrayList<PSDBSysProcTempl> selectByPSDBType(PSDBTypeBase pSDBTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDBTYPEID", (Object)pSDBTypeBase.getPSDBTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDBTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDBTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDBSysProcType(PSDBSysProcType pSDBSysProcType) throws Exception {
        ArrayList<PSDBSysProcTempl> arrayList = this.selectByPSDBSysProcType(pSDBSysProcType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDBSYSPROCTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDBSysProcType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDBSYSPROCTEMPL_PSDBSYSPROCTYPE_PSDBSYSPROCTYPEID", "", iDataEntityModel.getName(), "PSDBSYSPROCTEMPL", iDataEntityModel.getDataInfo((IEntity)pSDBSysProcType), arrayList.get(0)));
        }
    }

    public void resetPSDBSysProcType(PSDBSysProcType pSDBSysProcType) throws Exception {
        ArrayList<PSDBSysProcTempl> arrayList = this.selectByPSDBSysProcType(pSDBSysProcType);
        for (PSDBSysProcTempl pSDBSysProcTempl : arrayList) {
            PSDBSysProcTempl pSDBSysProcTempl2 = (PSDBSysProcTempl)this.getDEModel().createEntity();
            pSDBSysProcTempl2.setPSDBSysProcTemplId(pSDBSysProcTempl.getPSDBSysProcTemplId());
            pSDBSysProcTempl2.setPSDBSysProcTypeId(null);
            this.update(pSDBSysProcTempl2);
        }
    }

    public void removeByPSDBSysProcType(PSDBSysProcType pSDBSysProcType) throws Exception {
        final PSDBSysProcType pSDBSysProcType2 = pSDBSysProcType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDBSysProcTemplServiceBase.this.onBeforeRemoveByPSDBSysProcType(pSDBSysProcType2);
                PSDBSysProcTemplServiceBase.this.internalRemoveByPSDBSysProcType(pSDBSysProcType2);
                PSDBSysProcTemplServiceBase.this.onAfterRemoveByPSDBSysProcType(pSDBSysProcType2);
            }
        });
    }

    protected void onBeforeRemoveByPSDBSysProcType(PSDBSysProcType pSDBSysProcType) throws Exception {
    }

    protected void internalRemoveByPSDBSysProcType(PSDBSysProcType pSDBSysProcType) throws Exception {
        ArrayList<PSDBSysProcTempl> arrayList = this.selectByPSDBSysProcType(pSDBSysProcType);
        this.onBeforeRemoveByPSDBSysProcType(pSDBSysProcType, arrayList);
        for (PSDBSysProcTempl pSDBSysProcTempl : arrayList) {
            this.remove((IEntity)pSDBSysProcTempl);
        }
        this.onAfterRemoveByPSDBSysProcType(pSDBSysProcType, arrayList);
    }

    protected void onAfterRemoveByPSDBSysProcType(PSDBSysProcType pSDBSysProcType) throws Exception {
    }

    protected void onBeforeRemoveByPSDBSysProcType(PSDBSysProcType pSDBSysProcType, ArrayList<PSDBSysProcTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDBSysProcType(PSDBSysProcType pSDBSysProcType, ArrayList<PSDBSysProcTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSDBType(PSDBType pSDBType) throws Exception {
    }

    public void resetPSDBType(PSDBType pSDBType) throws Exception {
        ArrayList<PSDBSysProcTempl> arrayList = this.selectByPSDBType(pSDBType);
        for (PSDBSysProcTempl pSDBSysProcTempl : arrayList) {
            PSDBSysProcTempl pSDBSysProcTempl2 = (PSDBSysProcTempl)this.getDEModel().createEntity();
            pSDBSysProcTempl2.setPSDBSysProcTemplId(pSDBSysProcTempl.getPSDBSysProcTemplId());
            pSDBSysProcTempl2.setPSDBTypeId(null);
            this.update(pSDBSysProcTempl2);
        }
    }

    public void removeByPSDBType(PSDBType pSDBType) throws Exception {
        final PSDBType pSDBType2 = pSDBType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDBSysProcTemplServiceBase.this.onBeforeRemoveByPSDBType(pSDBType2);
                PSDBSysProcTemplServiceBase.this.internalRemoveByPSDBType(pSDBType2);
                PSDBSysProcTemplServiceBase.this.onAfterRemoveByPSDBType(pSDBType2);
            }
        });
    }

    protected void onBeforeRemoveByPSDBType(PSDBType pSDBType) throws Exception {
    }

    protected void internalRemoveByPSDBType(PSDBType pSDBType) throws Exception {
        ArrayList<PSDBSysProcTempl> arrayList = this.selectByPSDBType(pSDBType);
        this.onBeforeRemoveByPSDBType(pSDBType, arrayList);
        for (PSDBSysProcTempl pSDBSysProcTempl : arrayList) {
            this.remove((IEntity)pSDBSysProcTempl);
        }
        this.onAfterRemoveByPSDBType(pSDBType, arrayList);
    }

    protected void onAfterRemoveByPSDBType(PSDBType pSDBType) throws Exception {
    }

    protected void onBeforeRemoveByPSDBType(PSDBType pSDBType, ArrayList<PSDBSysProcTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDBType(PSDBType pSDBType, ArrayList<PSDBSysProcTempl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDBSysProcTempl pSDBSysProcTempl) throws Exception {
        PSDBSPPartTemplService pSDBSPPartTemplService = (PSDBSPPartTemplService)ServiceGlobal.getService(PSDBSPPartTemplService.class, (SessionFactory)this.getSessionFactory());
        pSDBSPPartTemplService.testRemoveByPSDBSysProcTempl(pSDBSysProcTempl);
        pSDBSPPartTemplService.removeByPSDBSysProcTempl(pSDBSysProcTempl);
        super.onBeforeRemove(pSDBSysProcTempl);
    }

    protected void replaceParentInfo(PSDBSysProcTempl pSDBSysProcTempl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDBSysProcTempl, cloneSession);
        if (pSDBSysProcTempl.getPSDBSysProcTypeId() != null && (iEntity = cloneSession.getEntity("PSDBSYSPROCTYPE", (Object)pSDBSysProcTempl.getPSDBSysProcTypeId())) != null) {
            this.onFillParentInfo_PSDBSysProcType(pSDBSysProcTempl, (PSDBSysProcType)iEntity);
        }
        if (pSDBSysProcTempl.getPSDBTypeId() != null && (iEntity = cloneSession.getEntity("PSDBTYPE", (Object)pSDBSysProcTempl.getPSDBTypeId())) != null) {
            this.onFillParentInfo_PSDBType(pSDBSysProcTempl, (PSDBType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDBSysProcTempl pSDBSysProcTempl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDBSysProcTempl, bl);
    }

    protected void onCheckEntity(boolean bl, PSDBSysProcTempl pSDBSysProcTempl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeTempl(bl, pSDBSysProcTempl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDBSysProcTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBSysProcTemplId(bl, pSDBSysProcTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBSysProcTemplName(bl, pSDBSysProcTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBSysProcTypeId(bl, pSDBSysProcTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBTypeId(bl, pSDBSysProcTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBTypeName(bl, pSDBSysProcTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubObj(bl, pSDBSysProcTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDBSysProcTempl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeTempl(boolean bl, PSDBSysProcTempl pSDBSysProcTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBSysProcTempl.isCodeTemplDirty() && !bl2 : !pSDBSysProcTempl.isCodeTemplDirty()) {
            return null;
        }
        String string = pSDBSysProcTempl.getCodeTempl();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODETEMPL");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeTempl_Default((IEntity)pSDBSysProcTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODETEMPL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDBSysProcTempl pSDBSysProcTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBSysProcTempl.isMemoDirty() : !pSDBSysProcTempl.isMemoDirty()) {
            return null;
        }
        String string = pSDBSysProcTempl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDBSysProcTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDBSysProcTemplId(boolean bl, PSDBSysProcTempl pSDBSysProcTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBSysProcTempl.isPSDBSysProcTemplIdDirty() && !bl2 : !pSDBSysProcTempl.isPSDBSysProcTemplIdDirty()) {
            return null;
        }
        String string = pSDBSysProcTempl.getPSDBSysProcTemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBSYSPROCTEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBSysProcTemplId_Default((IEntity)pSDBSysProcTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBSYSPROCTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBSysProcTemplName(boolean bl, PSDBSysProcTempl pSDBSysProcTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBSysProcTempl.isPSDBSysProcTemplNameDirty() && !bl2 : !pSDBSysProcTempl.isPSDBSysProcTemplNameDirty()) {
            return null;
        }
        String string = pSDBSysProcTempl.getPSDBSysProcTemplName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBSYSPROCTEMPLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBSysProcTemplName_Default((IEntity)pSDBSysProcTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBSYSPROCTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBSysProcTypeId(boolean bl, PSDBSysProcTempl pSDBSysProcTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBSysProcTempl.isPSDBSysProcTypeIdDirty() && !bl2 : !pSDBSysProcTempl.isPSDBSysProcTypeIdDirty()) {
            return null;
        }
        String string = pSDBSysProcTempl.getPSDBSysProcTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBSYSPROCTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBSysProcTypeId_Default((IEntity)pSDBSysProcTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBSYSPROCTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBTypeId(boolean bl, PSDBSysProcTempl pSDBSysProcTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBSysProcTempl.isPSDBTypeIdDirty() && !bl2 : !pSDBSysProcTempl.isPSDBTypeIdDirty()) {
            return null;
        }
        String string = pSDBSysProcTempl.getPSDBTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBTypeId_Default((IEntity)pSDBSysProcTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBTypeName(boolean bl, PSDBSysProcTempl pSDBSysProcTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBSysProcTempl.isPSDBTypeNameDirty() && !bl2 : !pSDBSysProcTempl.isPSDBTypeNameDirty()) {
            return null;
        }
        String string = pSDBSysProcTempl.getPSDBTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBTYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBTypeName_Default((IEntity)pSDBSysProcTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubObj(boolean bl, PSDBSysProcTempl pSDBSysProcTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBSysProcTempl.isPubObjDirty() && !bl2 : !pSDBSysProcTempl.isPubObjDirty()) {
            return null;
        }
        String string = pSDBSysProcTempl.getPubObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubObj_Default((IEntity)pSDBSysProcTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDBSysProcTempl pSDBSysProcTempl, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDBSysProcTempl, bl);
    }

    protected void onSyncIndexEntities(PSDBSysProcTempl pSDBSysProcTempl, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDBSysProcTempl, bl);
    }

    public Object getDataContextValue(PSDBSysProcTempl pSDBSysProcTempl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDBSysProcTempl, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDBSysProcTempl pSDBSysProcTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDBSysProcTempl, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODETEMPL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeTempl_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDBSYSPROCTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBSysProcTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBSYSPROCTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBSysProcTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBSYSPROCTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBSysProcTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBSYSPROCTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBSysProcTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeTempl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODETEMPL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_PSDBSysProcTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBSYSPROCTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBSysProcTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBSYSPROCTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBSysProcTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBSYSPROCTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBSysProcTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBSYSPROCTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected boolean onMergeChild(String string, String string2, PSDBSysProcTempl pSDBSysProcTempl) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDBSysProcTempl)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDBSysProcTempl pSDBSysProcTempl) throws Exception {
        super.onUpdateParent((IEntity)pSDBSysProcTempl);
    }

    @Override
    protected void exportCurXmlModel(PSDBSysProcTempl pSDBSysProcTempl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDBSYSPROCTEMPL");
        if (!bl) {
            pSDBSysProcTempl.setCreateDate(null);
            pSDBSysProcTempl.setCreateMan(null);
            pSDBSysProcTempl.setPSDBSysProcTemplId(null);
            pSDBSysProcTempl.setUpdateDate(null);
            pSDBSysProcTempl.setUpdateMan(null);
            super.exportCurXmlModel(pSDBSysProcTempl, xmlNode, bl);
        }
    }
}

