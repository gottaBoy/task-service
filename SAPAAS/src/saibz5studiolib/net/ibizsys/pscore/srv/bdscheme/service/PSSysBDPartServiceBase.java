/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.bdscheme.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
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
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDPartDAO;
import net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDPartDEModel;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDPart;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDScheme;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDSchemeBase;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBDPartServiceBase
extends PSCoreSysServiceBase<PSSysBDPart> {
    private static final Log log = LogFactory.getLog(PSSysBDPartServiceBase.class);
    public static final String DATASET_CURBDS = "CurBDS";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysBDPartDEModel pSSysBDPartDEModel;
    private PSSysBDPartDAO pSSysBDPartDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.bdscheme.service.PSSysBDPartService";
    }

    public PSSysBDPartDEModel getPSSysBDPartDEModel() {
        if (this.pSSysBDPartDEModel == null) {
            try {
                this.pSSysBDPartDEModel = (PSSysBDPartDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDPartDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDPartDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysBDPartDEModel();
    }

    public PSSysBDPartDAO getPSSysBDPartDAO() {
        if (this.pSSysBDPartDAO == null) {
            try {
                this.pSSysBDPartDAO = (PSSysBDPartDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDPartDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDPartDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysBDPartDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURBDS, (boolean)true) == 0) {
            return this.fetchCurBDS(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurBDS(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURBDS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysBDPart pSSysBDPart, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDPART_PSSYSBDSCHEME_PSSYSBDSCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeService", (SessionFactory)this.getSessionFactory());
            PSSysBDScheme pSSysBDScheme = (PSSysBDScheme)iService.getDEModel().createEntity();
            pSSysBDScheme.set("PSSYSBDSCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBDScheme);
            } else {
                iService.get(pSSysBDScheme);
            }
            this.onFillParentInfo_PSSysBDScheme(pSSysBDPart, pSSysBDScheme);
            return;
        }
        super.onFillParentInfo(pSSysBDPart, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysBDScheme(PSSysBDPart pSSysBDPart, PSSysBDScheme pSSysBDScheme) throws Exception {
        pSSysBDPart.setPSSysBDSchemeId(pSSysBDScheme.getPSSysBDSchemeId());
        pSSysBDPart.setPSSysBDSchemeName(pSSysBDScheme.getPSSysBDSchemeName());
    }

    protected void onFillEntityFullInfo(PSSysBDPart pSSysBDPart, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSysBDPart, bl);
        this.onFillEntityFullInfo_PSSysBDScheme(pSSysBDPart, bl);
    }

    protected void onFillEntityFullInfo_PSSysBDScheme(PSSysBDPart pSSysBDPart, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysBDPart pSSysBDPart, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysBDPart, bl);
    }

    public ArrayList<PSSysBDPart> selectByPSSysBDScheme(PSSysBDSchemeBase pSSysBDSchemeBase) throws Exception {
        return this.selectByPSSysBDScheme(pSSysBDSchemeBase, "", -1);
    }

    public ArrayList<PSSysBDPart> selectByPSSysBDScheme(PSSysBDSchemeBase pSSysBDSchemeBase, String string) throws Exception {
        return this.selectByPSSysBDScheme(pSSysBDSchemeBase, string, -1);
    }

    public ArrayList<PSSysBDPart> selectByPSSysBDScheme(PSSysBDSchemeBase pSSysBDSchemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBDSCHEMEID", (Object)pSSysBDSchemeBase.getPSSysBDSchemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBDSchemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBDSchemeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
        ArrayList<PSSysBDPart> arrayList = this.selectByPSSysBDScheme(pSSysBDScheme, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBDSCHEME");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysBDScheme);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDPART_PSSYSBDSCHEME_PSSYSBDSCHEMEID", "", iDataEntityModel.getName(), "PSSYSBDPART", iDataEntityModel.getDataInfo(pSSysBDScheme), arrayList.get(0)));
        }
    }

    public void resetPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
        ArrayList<PSSysBDPart> arrayList = this.selectByPSSysBDScheme(pSSysBDScheme);
        for (PSSysBDPart pSSysBDPart : arrayList) {
            PSSysBDPart pSSysBDPart2 = (PSSysBDPart)this.getDEModel().createEntity();
            pSSysBDPart2.setPSSysBDPartId(pSSysBDPart.getPSSysBDPartId());
            pSSysBDPart2.setPSSysBDSchemeId(null);
            this.update(pSSysBDPart2);
        }
    }

    public void removeByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
        final PSSysBDScheme pSSysBDScheme2 = pSSysBDScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDPartServiceBase.this.onBeforeRemoveByPSSysBDScheme(pSSysBDScheme2);
                PSSysBDPartServiceBase.this.internalRemoveByPSSysBDScheme(pSSysBDScheme2);
                PSSysBDPartServiceBase.this.onAfterRemoveByPSSysBDScheme(pSSysBDScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
    }

    protected void internalRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
        ArrayList<PSSysBDPart> arrayList = this.selectByPSSysBDScheme(pSSysBDScheme);
        this.onBeforeRemoveByPSSysBDScheme(pSSysBDScheme, arrayList);
        for (PSSysBDPart pSSysBDPart : arrayList) {
            this.remove(pSSysBDPart);
        }
        this.onAfterRemoveByPSSysBDScheme(pSSysBDScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme, ArrayList<PSSysBDPart> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme, ArrayList<PSSysBDPart> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysBDPart pSSysBDPart) throws Exception {
        PSSysBDTableService pSSysBDTableService = (PSSysBDTableService)ServiceGlobal.getService(PSSysBDTableService.class, (SessionFactory)this.getSessionFactory());
        pSSysBDTableService.testRemoveByPSSysBDPart(pSSysBDPart);
        super.onBeforeRemove(pSSysBDPart);
    }

    protected void replaceParentInfo(PSSysBDPart pSSysBDPart, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysBDPart, cloneSession);
        if (pSSysBDPart.getPSSysBDSchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSBDSCHEME", (Object)pSSysBDPart.getPSSysBDSchemeId())) != null) {
            this.onFillParentInfo_PSSysBDScheme(pSSysBDPart, (PSSysBDScheme)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysBDPart pSSysBDPart, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysBDPart, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysBDPart pSSysBDPart, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysBDPart, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysBDPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDPartId(bl, pSSysBDPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDPartName(bl, pSSysBDPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDSchemeId(bl, pSSysBDPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysBDPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysBDPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysBDPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysBDPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysBDPart, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysBDPart, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysBDPart pSSysBDPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDPart.isCodeNameDirty() && !bl2 : !pSSysBDPart.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysBDPart.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysBDPart, bl2, bl3);
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
                string3 = "PSSYSBDSCHEMEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBDPartDEModel(), "CODENAME", string3, pSSysBDPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysBDPart pSSysBDPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDPart.isMemoDirty() : !pSSysBDPart.isMemoDirty()) {
            return null;
        }
        String string = pSSysBDPart.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysBDPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBDPartId(boolean bl, PSSysBDPart pSSysBDPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDPart.isPSSysBDPartIdDirty() && !bl2 : !pSSysBDPart.isPSSysBDPartIdDirty()) {
            return null;
        }
        String string = pSSysBDPart.getPSSysBDPartId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDPARTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDPartId_Default(pSSysBDPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDPARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDPartName(boolean bl, PSSysBDPart pSSysBDPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDPart.isPSSysBDPartNameDirty() && !bl2 : !pSSysBDPart.isPSSysBDPartNameDirty()) {
            return null;
        }
        String string = pSSysBDPart.getPSSysBDPartName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDPARTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDPartName_Default(pSSysBDPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDPARTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDSchemeId(boolean bl, PSSysBDPart pSSysBDPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDPart.isPSSysBDSchemeIdDirty() && !bl2 : !pSSysBDPart.isPSSysBDSchemeIdDirty()) {
            return null;
        }
        String string = pSSysBDPart.getPSSysBDSchemeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDSCHEMEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDSchemeId_Default(pSSysBDPart, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDSCHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysBDPart pSSysBDPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDPart.isUserCatDirty() : !pSSysBDPart.isUserCatDirty()) {
            return null;
        }
        String string = pSSysBDPart.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysBDPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysBDPart pSSysBDPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDPart.isUserTagDirty() : !pSSysBDPart.isUserTagDirty()) {
            return null;
        }
        String string = pSSysBDPart.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysBDPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysBDPart pSSysBDPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDPart.isUserTag2Dirty() : !pSSysBDPart.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysBDPart.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysBDPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysBDPart pSSysBDPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDPart.isUserTag3Dirty() : !pSSysBDPart.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysBDPart.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysBDPart, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysBDPart pSSysBDPart, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDPart.isUserTag4Dirty() : !pSSysBDPart.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysBDPart.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysBDPart, bl2, bl3);
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

    protected void onSyncEntity(PSSysBDPart pSSysBDPart, boolean bl) throws Exception {
        super.onSyncEntity(pSSysBDPart, bl);
    }

    protected void onSyncIndexEntities(PSSysBDPart pSSysBDPart, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysBDPart, bl);
    }

    public Object getDataContextValue(PSSysBDPart pSSysBDPart, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysBDPart, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysBDScheme pSSysBDScheme = pSSysBDPart.getPSSysBDScheme();
        if (pSSysBDScheme != null && pSSysBDScheme.contains(string)) {
            return pSSysBDScheme.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysBDPart pSSysBDPart, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysBDPart, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSSYSBDPARTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDPartId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDPARTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDPartName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDSCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDSchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDSCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDSchemeName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSSysBDPartId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDPARTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDPartName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDPARTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDSchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDSCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDSchemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDSCHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysBDPart pSSysBDPart) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysBDPart)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysBDPart pSSysBDPart) throws Exception {
        Object object = pSSysBDPart.get("PSSYSBDSCHEMEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSSYSBDPART_PSSYSBDSCHEME_PSSYSBDSCHEMEID", object);
        }
        super.onUpdateParent(pSSysBDPart);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSSysBDPart pSSysBDPart, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSBDPART");
        if (!bl) {
            pSSysBDPart.setCreateDate(null);
            pSSysBDPart.setCreateMan(null);
            pSSysBDPart.setPSSysBDPartId(null);
            pSSysBDPart.setUpdateDate(null);
            pSSysBDPart.setUpdateMan(null);
            super.exportCurXmlModel(pSSysBDPart, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysBDPart pSSysBDPart, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysBDPart, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBDSCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSBDSCHEME#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBDSCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSBDPART_PSSYSBDSCHEME_PSSYSBDSCHEMEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBDSCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBDSCHEMENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSBDSCHEME", (boolean)true) == 0) {
            iEntity.set("PSSYSBDSCHEMEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSBDSCHEMEID"};
    }

    @Override
    public String getModelV2Tag(PSSysBDPart pSSysBDPart) {
        if (!StringHelper.isNullOrEmpty((String)pSSysBDPart.getCodeName())) {
            return pSSysBDPart.getCodeName();
        }
        return super.getModelV2Tag(pSSysBDPart);
    }

    @Override
    public boolean setModelV2Tag(PSSysBDPart pSSysBDPart, String string) {
        pSSysBDPart.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSBDSCHEMEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysBDPart pSSysBDPart, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysBDPart.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysBDPart, true);
        pSSysBDPart.set("CODENAME", string);
        if (this.select(pSSysBDPart, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysBDPart, true);
        return super.getModelV2Entity(pSSysBDPart, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysBDPart pSSysBDPart, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysBDPart, objectNode, string, string2, n);
    }
}

