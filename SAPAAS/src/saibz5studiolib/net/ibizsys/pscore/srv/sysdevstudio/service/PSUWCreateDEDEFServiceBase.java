/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdevstudio.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdevstudio.dao.PSUWCreateDEDEFDAO;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWCreateDEDEFDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWCreateDEDEF;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUWCreateDEDEFServiceBase
extends PSCoreSysServiceBase<PSUWCreateDEDEF> {
    private static final Log log = LogFactory.getLog(PSUWCreateDEDEFServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSUWCreateDEDEFDEModel pSUWCreateDEDEFDEModel;
    private PSUWCreateDEDEFDAO pSUWCreateDEDEFDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.service.PSUWCreateDEDEFService";
    }

    public PSUWCreateDEDEFDEModel getPSUWCreateDEDEFDEModel() {
        if (this.pSUWCreateDEDEFDEModel == null) {
            try {
                this.pSUWCreateDEDEFDEModel = (PSUWCreateDEDEFDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWCreateDEDEFDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUWCreateDEDEFDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSUWCreateDEDEFDEModel();
    }

    public PSUWCreateDEDEFDAO getPSUWCreateDEDEFDAO() {
        if (this.pSUWCreateDEDEFDAO == null) {
            try {
                this.pSUWCreateDEDEFDAO = (PSUWCreateDEDEFDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdevstudio.dao.PSUWCreateDEDEFDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUWCreateDEDEFDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSUWCreateDEDEFDAO();
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

    protected void onFillParentInfo(PSUWCreateDEDEF pSUWCreateDEDEF, String string, String string2, String string3) throws Exception {
        super.onFillParentInfo(pSUWCreateDEDEF, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillEntityFullInfo(PSUWCreateDEDEF pSUWCreateDEDEF, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSUWCreateDEDEF, bl);
    }

    protected void onWriteBackParent(PSUWCreateDEDEF pSUWCreateDEDEF, boolean bl) throws Exception {
        super.onWriteBackParent(pSUWCreateDEDEF, bl);
    }

    @Override
    protected void onBeforeRemove(PSUWCreateDEDEF pSUWCreateDEDEF) throws Exception {
        super.onBeforeRemove(pSUWCreateDEDEF);
    }

    protected void onRemoveEntityUncopyValues(PSUWCreateDEDEF pSUWCreateDEDEF, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSUWCreateDEDEF, bl);
    }

    protected void onCheckEntity(boolean bl, PSUWCreateDEDEF pSUWCreateDEDEF, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSUWCreateDEDEF, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEFParam(bl, pSUWCreateDEDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEFParam2(bl, pSUWCreateDEDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEFParam3(bl, pSUWCreateDEDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEFParam4(bl, pSUWCreateDEDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NewCodeName(bl, pSUWCreateDEDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NewDEFLogicName(bl, pSUWCreateDEDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NewDEFName(bl, pSUWCreateDEDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSUWCreateDEDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFName(bl, pSUWCreateDEDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSUWCreateDEDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUWCreateDEDEFId(bl, pSUWCreateDEDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUWCreateDEDEFName(bl, pSUWCreateDEDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUWCreateDEId(bl, pSUWCreateDEDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WizardMode(bl, pSUWCreateDEDEF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSUWCreateDEDEF, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSUWCreateDEDEF pSUWCreateDEDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEDEF.isCodeNameDirty() : !pSUWCreateDEDEF.isCodeNameDirty()) {
            return null;
        }
        String string = pSUWCreateDEDEF.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSUWCreateDEDEF, bl2, bl3);
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

    protected EntityFieldError onCheckField_DEFParam(boolean bl, PSUWCreateDEDEF pSUWCreateDEDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEDEF.isDEFParamDirty() : !pSUWCreateDEDEF.isDEFParamDirty()) {
            return null;
        }
        String string = pSUWCreateDEDEF.getDEFParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEFParam_Default(pSUWCreateDEDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEFParam2(boolean bl, PSUWCreateDEDEF pSUWCreateDEDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEDEF.isDEFParam2Dirty() : !pSUWCreateDEDEF.isDEFParam2Dirty()) {
            return null;
        }
        String string = pSUWCreateDEDEF.getDEFParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEFParam2_Default(pSUWCreateDEDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEFParam3(boolean bl, PSUWCreateDEDEF pSUWCreateDEDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEDEF.isDEFParam3Dirty() : !pSUWCreateDEDEF.isDEFParam3Dirty()) {
            return null;
        }
        Integer n = pSUWCreateDEDEF.getDEFParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEFParam3_Default(pSUWCreateDEDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEFParam4(boolean bl, PSUWCreateDEDEF pSUWCreateDEDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEDEF.isDEFParam4Dirty() : !pSUWCreateDEDEF.isDEFParam4Dirty()) {
            return null;
        }
        Integer n = pSUWCreateDEDEF.getDEFParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEFParam4_Default(pSUWCreateDEDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NewCodeName(boolean bl, PSUWCreateDEDEF pSUWCreateDEDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEDEF.isNewCodeNameDirty() : !pSUWCreateDEDEF.isNewCodeNameDirty()) {
            return null;
        }
        String string = pSUWCreateDEDEF.getNewCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NewCodeName_Default(pSUWCreateDEDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEWCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NewDEFLogicName(boolean bl, PSUWCreateDEDEF pSUWCreateDEDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEDEF.isNewDEFLogicNameDirty() : !pSUWCreateDEDEF.isNewDEFLogicNameDirty()) {
            return null;
        }
        String string = pSUWCreateDEDEF.getNewDEFLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NewDEFLogicName_Default(pSUWCreateDEDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEWDEFLOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NewDEFName(boolean bl, PSUWCreateDEDEF pSUWCreateDEDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEDEF.isNewDEFNameDirty() : !pSUWCreateDEDEF.isNewDEFNameDirty()) {
            return null;
        }
        String string = pSUWCreateDEDEF.getNewDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NewDEFName_Default(pSUWCreateDEDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEWDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSUWCreateDEDEF pSUWCreateDEDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEDEF.isPSDEFIdDirty() : !pSUWCreateDEDEF.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSUWCreateDEDEF.getPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_Default(pSUWCreateDEDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFName(boolean bl, PSUWCreateDEDEF pSUWCreateDEDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEDEF.isPSDEFNameDirty() : !pSUWCreateDEDEF.isPSDEFNameDirty()) {
            return null;
        }
        String string = pSUWCreateDEDEF.getPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFName_Default(pSUWCreateDEDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSUWCreateDEDEF pSUWCreateDEDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEDEF.isPSDynaInstIdDirty() : !pSUWCreateDEDEF.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSUWCreateDEDEF.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSUWCreateDEDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUWCreateDEDEFId(boolean bl, PSUWCreateDEDEF pSUWCreateDEDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEDEF.isPSUWCreateDEDEFIdDirty() && !bl2 : !pSUWCreateDEDEF.isPSUWCreateDEDEFIdDirty()) {
            return null;
        }
        String string = pSUWCreateDEDEF.getPSUWCreateDEDEFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUWCREATEDEDEFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUWCreateDEDEFId_Default(pSUWCreateDEDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUWCREATEDEDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUWCreateDEDEFName(boolean bl, PSUWCreateDEDEF pSUWCreateDEDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEDEF.isPSUWCreateDEDEFNameDirty() && !bl2 : !pSUWCreateDEDEF.isPSUWCreateDEDEFNameDirty()) {
            return null;
        }
        String string = pSUWCreateDEDEF.getPSUWCreateDEDEFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUWCREATEDEDEFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUWCreateDEDEFName_Default(pSUWCreateDEDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUWCREATEDEDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUWCreateDEId(boolean bl, PSUWCreateDEDEF pSUWCreateDEDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEDEF.isPSUWCreateDEIdDirty() : !pSUWCreateDEDEF.isPSUWCreateDEIdDirty()) {
            return null;
        }
        String string = pSUWCreateDEDEF.getPSUWCreateDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUWCreateDEId_Default(pSUWCreateDEDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUWCREATEDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WizardMode(boolean bl, PSUWCreateDEDEF pSUWCreateDEDEF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWCreateDEDEF.isWizardModeDirty() : !pSUWCreateDEDEF.isWizardModeDirty()) {
            return null;
        }
        String string = pSUWCreateDEDEF.getWizardMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WizardMode_Default(pSUWCreateDEDEF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIZARDMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSUWCreateDEDEF pSUWCreateDEDEF, boolean bl) throws Exception {
        super.onSyncEntity(pSUWCreateDEDEF, bl);
    }

    protected void onSyncIndexEntities(PSUWCreateDEDEF pSUWCreateDEDEF, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSUWCreateDEDEF, bl);
    }

    public Object getDataContextValue(PSUWCreateDEDEF pSUWCreateDEDEF, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSUWCreateDEDEF, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSUWCreateDEDEF pSUWCreateDEDEF, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSUWCreateDEDEF, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"DEFPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEFParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEFParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEFParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEFParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEWCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NewCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEWDEFLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NewDEFLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEWDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NewDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUWCREATEDEDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUWCreateDEDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUWCREATEDEDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUWCreateDEDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUWCREATEDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUWCreateDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIZARDMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WizardMode_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_DEFParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEFParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFPARAM2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEFParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEFParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NewCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEWCODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NewDEFLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEWDEFLOGICNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NewDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEWDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUWCreateDEDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUWCREATEDEDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUWCreateDEDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUWCREATEDEDEFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUWCreateDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUWCREATEDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_WizardMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WIZARDMODE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSUWCreateDEDEF pSUWCreateDEDEF) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSUWCreateDEDEF)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSUWCreateDEDEF pSUWCreateDEDEF) throws Exception {
        super.onUpdateParent(pSUWCreateDEDEF);
    }

    @Override
    protected void exportCurXmlModel(PSUWCreateDEDEF pSUWCreateDEDEF, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSUWCREATEDEDEF");
        if (!bl) {
            pSUWCreateDEDEF.setCreateDate(null);
            pSUWCreateDEDEF.setCreateMan(null);
            pSUWCreateDEDEF.setPSUWCreateDEDEFId(null);
            pSUWCreateDEDEF.setUpdateDate(null);
            pSUWCreateDEDEF.setUpdateMan(null);
            super.exportCurXmlModel(pSUWCreateDEDEF, xmlNode, bl);
        }
    }
}

