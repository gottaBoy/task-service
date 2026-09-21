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
package net.ibizsys.pscore.srv.sysdeploy.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysVer;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysVerBase;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSaaSSysVerDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSaaSSysVerDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSaaSSysVer;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSaaSSysVerServiceBase
extends PSCoreSysServiceBase<PSDepSaaSSysVer> {
    private static final Log log = LogFactory.getLog(PSDepSaaSSysVerServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSaaSSysVerDEModel pSDepSaaSSysVerDEModel;
    private PSDepSaaSSysVerDAO pSDepSaaSSysVerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSaaSSysVerService";
    }

    public PSDepSaaSSysVerDEModel getPSDepSaaSSysVerDEModel() {
        if (this.pSDepSaaSSysVerDEModel == null) {
            try {
                this.pSDepSaaSSysVerDEModel = (PSDepSaaSSysVerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSaaSSysVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSaaSSysVerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSaaSSysVerDEModel();
    }

    public PSDepSaaSSysVerDAO getPSDepSaaSSysVerDAO() {
        if (this.pSDepSaaSSysVerDAO == null) {
            try {
                this.pSDepSaaSSysVerDAO = (PSDepSaaSSysVerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSaaSSysVerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSaaSSysVerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSaaSSysVerDAO();
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

    protected void onFillParentInfo(PSDepSaaSSysVer pSDepSaaSSysVer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSAASSYSVER_PSSAASSYSVER_PSSAASSYSVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerService", (SessionFactory)this.getSessionFactory());
            PSSaaSSysVer pSSaaSSysVer = (PSSaaSSysVer)iService.getDEModel().createEntity();
            pSSaaSSysVer.set("PSSAASSYSVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSaaSSysVer);
            } else {
                iService.get((IEntity)pSSaaSSysVer);
            }
            this.onFillParentInfo_PSSaaSSysVer(pSDepSaaSSysVer, pSSaaSSysVer);
            return;
        }
        super.onFillParentInfo((IEntity)pSDepSaaSSysVer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSaaSSysVer(PSDepSaaSSysVer pSDepSaaSSysVer, PSSaaSSysVer pSSaaSSysVer) throws Exception {
        pSDepSaaSSysVer.setPSSaaSSysVerId(pSSaaSSysVer.getPSSaaSSysVerId());
        pSDepSaaSSysVer.setPSSaaSSysVerName(pSSaaSSysVer.getPSSaaSSysVerName());
    }

    protected void onFillEntityFullInfo(PSDepSaaSSysVer pSDepSaaSSysVer, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDepSaaSSysVer, bl);
        this.onFillEntityFullInfo_PSSaaSSysVer(pSDepSaaSSysVer, bl);
    }

    protected void onFillEntityFullInfo_PSSaaSSysVer(PSDepSaaSSysVer pSDepSaaSSysVer, boolean bl) throws Exception {
        if (pSDepSaaSSysVer.isPSSaaSSysVerIdDirty()) {
            if (pSDepSaaSSysVer.getPSSaaSSysVerId() != null) {
                if (pSDepSaaSSysVer.getPSSaaSSysVerId() == null || pSDepSaaSSysVer.getPSSaaSSysVerName() == null) {
                    PSSaaSSysVer pSSaaSSysVer = pSDepSaaSSysVer.getPSSaaSSysVer();
                    pSDepSaaSSysVer.setPSSaaSSysVerName(pSSaaSSysVer.getPSSaaSSysVerName());
                }
            } else {
                pSDepSaaSSysVer.setPSSaaSSysVerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDepSaaSSysVer pSDepSaaSSysVer, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDepSaaSSysVer, bl);
    }

    public ArrayList<PSDepSaaSSysVer> selectByPSSaaSSysVer(PSSaaSSysVerBase pSSaaSSysVerBase) throws Exception {
        return this.selectByPSSaaSSysVer(pSSaaSSysVerBase, "", -1);
    }

    public ArrayList<PSDepSaaSSysVer> selectByPSSaaSSysVer(PSSaaSSysVerBase pSSaaSSysVerBase, String string) throws Exception {
        return this.selectByPSSaaSSysVer(pSSaaSSysVerBase, string, -1);
    }

    public ArrayList<PSDepSaaSSysVer> selectByPSSaaSSysVer(PSSaaSSysVerBase pSSaaSSysVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSAASSYSVERID", (Object)pSSaaSSysVerBase.getPSSaaSSysVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSaaSSysVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSaaSSysVerCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
    }

    public void resetPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
        ArrayList<PSDepSaaSSysVer> arrayList = this.selectByPSSaaSSysVer(pSSaaSSysVer);
        for (PSDepSaaSSysVer pSDepSaaSSysVer : arrayList) {
            PSDepSaaSSysVer pSDepSaaSSysVer2 = (PSDepSaaSSysVer)this.getDEModel().createEntity();
            pSDepSaaSSysVer2.setPSDepSaaSSysVerId(pSDepSaaSSysVer.getPSDepSaaSSysVerId());
            pSDepSaaSSysVer2.setPSSaaSSysVerId(null);
            this.update(pSDepSaaSSysVer2);
        }
    }

    public void removeByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
        final PSSaaSSysVer pSSaaSSysVer2 = pSSaaSSysVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSaaSSysVerServiceBase.this.onBeforeRemoveByPSSaaSSysVer(pSSaaSSysVer2);
                PSDepSaaSSysVerServiceBase.this.internalRemoveByPSSaaSSysVer(pSSaaSSysVer2);
                PSDepSaaSSysVerServiceBase.this.onAfterRemoveByPSSaaSSysVer(pSSaaSSysVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
    }

    protected void internalRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
        ArrayList<PSDepSaaSSysVer> arrayList = this.selectByPSSaaSSysVer(pSSaaSSysVer);
        this.onBeforeRemoveByPSSaaSSysVer(pSSaaSSysVer, arrayList);
        for (PSDepSaaSSysVer pSDepSaaSSysVer : arrayList) {
            this.remove((IEntity)pSDepSaaSSysVer);
        }
        this.onAfterRemoveByPSSaaSSysVer(pSSaaSSysVer, arrayList);
    }

    protected void onAfterRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
    }

    protected void onBeforeRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer, ArrayList<PSDepSaaSSysVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer, ArrayList<PSDepSaaSSysVer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSaaSSysVer pSDepSaaSSysVer) throws Exception {
        super.onBeforeRemove(pSDepSaaSSysVer);
    }

    protected void replaceParentInfo(PSDepSaaSSysVer pSDepSaaSSysVer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDepSaaSSysVer, cloneSession);
        if (pSDepSaaSSysVer.getPSSaaSSysVerId() != null && (iEntity = cloneSession.getEntity("PSSAASSYSVER", (Object)pSDepSaaSSysVer.getPSSaaSSysVerId())) != null) {
            this.onFillParentInfo_PSSaaSSysVer(pSDepSaaSSysVer, (PSSaaSSysVer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSaaSSysVer pSDepSaaSSysVer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDepSaaSSysVer, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSaaSSysVer pSDepSaaSSysVer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSDepSaaSSysVerId(bl, pSDepSaaSSysVer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSaaSSysVerName(bl, pSDepSaaSSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysVerId(bl, pSDepSaaSSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysVerName(bl, pSDepSaaSSysVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDepSaaSSysVer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSDepSaaSSysVerId(boolean bl, PSDepSaaSSysVer pSDepSaaSSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSaaSSysVer.isPSDepSaaSSysVerIdDirty() && !bl2 : !pSDepSaaSSysVer.isPSDepSaaSSysVerIdDirty()) {
            return null;
        }
        String string = pSDepSaaSSysVer.getPSDepSaaSSysVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSAASSYSVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSaaSSysVerId_Default((IEntity)pSDepSaaSSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSAASSYSVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSaaSSysVerName(boolean bl, PSDepSaaSSysVer pSDepSaaSSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSaaSSysVer.isPSDepSaaSSysVerNameDirty() && !bl2 : !pSDepSaaSSysVer.isPSDepSaaSSysVerNameDirty()) {
            return null;
        }
        String string = pSDepSaaSSysVer.getPSDepSaaSSysVerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSAASSYSVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSaaSSysVerName_Default((IEntity)pSDepSaaSSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSAASSYSVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaaSSysVerId(boolean bl, PSDepSaaSSysVer pSDepSaaSSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSaaSSysVer.isPSSaaSSysVerIdDirty() : !pSDepSaaSSysVer.isPSSaaSSysVerIdDirty()) {
            return null;
        }
        String string = pSDepSaaSSysVer.getPSSaaSSysVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysVerId_Default((IEntity)pSDepSaaSSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaaSSysVerName(boolean bl, PSDepSaaSSysVer pSDepSaaSSysVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSaaSSysVer.isPSSaaSSysVerNameDirty() : !pSDepSaaSSysVer.isPSSaaSSysVerNameDirty()) {
            return null;
        }
        String string = pSDepSaaSSysVer.getPSSaaSSysVerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysVerName_Default((IEntity)pSDepSaaSSysVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDepSaaSSysVer pSDepSaaSSysVer, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDepSaaSSysVer, bl);
    }

    protected void onSyncIndexEntities(PSDepSaaSSysVer pSDepSaaSSysVer, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDepSaaSSysVer, bl);
    }

    public Object getDataContextValue(PSDepSaaSSysVer pSDepSaaSSysVer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDepSaaSSysVer, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSaaSSysVer pSDepSaaSSysVer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDepSaaSSysVer, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSAASSYSVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSaaSSysVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSAASSYSVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSaaSSysVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDepSaaSSysVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSAASSYSVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSaaSSysVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSAASSYSVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDepSaaSSysVer pSDepSaaSSysVer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDepSaaSSysVer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSaaSSysVer pSDepSaaSSysVer) throws Exception {
        super.onUpdateParent((IEntity)pSDepSaaSSysVer);
    }

    @Override
    protected void exportCurXmlModel(PSDepSaaSSysVer pSDepSaaSSysVer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSAASSYSVER");
        if (!bl) {
            pSDepSaaSSysVer.setCreateDate(null);
            pSDepSaaSSysVer.setCreateMan(null);
            pSDepSaaSSysVer.setPSDepSaaSSysVerId(null);
            pSDepSaaSSysVer.setUpdateDate(null);
            pSDepSaaSSysVer.setUpdateMan(null);
            super.exportCurXmlModel(pSDepSaaSSysVer, xmlNode, bl);
        }
    }
}

