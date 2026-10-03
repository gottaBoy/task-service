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
package net.ibizsys.pscore.srv.config.service;

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
import net.ibizsys.pscore.srv.config.dao.PSSFStylePrjDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSFStylePrjDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStylePrj;
import net.ibizsys.pscore.srv.config.service.PSSFCodeFolderService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFStylePrjServiceBase
extends PSCoreSysServiceBase<PSSFStylePrj> {
    private static final Log log = LogFactory.getLog(PSSFStylePrjServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSFStylePrjDEModel pSSFStylePrjDEModel;
    private PSSFStylePrjDAO pSSFStylePrjDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSFStylePrjService";
    }

    public PSSFStylePrjDEModel getPSSFStylePrjDEModel() {
        if (this.pSSFStylePrjDEModel == null) {
            try {
                this.pSSFStylePrjDEModel = (PSSFStylePrjDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFStylePrjDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFStylePrjDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSFStylePrjDEModel();
    }

    public PSSFStylePrjDAO getPSSFStylePrjDAO() {
        if (this.pSSFStylePrjDAO == null) {
            try {
                this.pSSFStylePrjDAO = (PSSFStylePrjDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSFStylePrjDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFStylePrjDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSFStylePrjDAO();
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

    protected void onFillParentInfo(PSSFStylePrj pSSFStylePrj, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFSTYLEPRJ_PSSFSTYLE_PSSFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleService", (SessionFactory)this.getSessionFactory());
            PSSFStyle pSSFStyle = (PSSFStyle)iService.getDEModel().createEntity();
            pSSFStyle.set("PSSFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSFStyle);
            } else {
                iService.get(pSSFStyle);
            }
            this.onFillParentInfo_PSSFStyle(pSSFStylePrj, pSSFStyle);
            return;
        }
        super.onFillParentInfo(pSSFStylePrj, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSFStyle(PSSFStylePrj pSSFStylePrj, PSSFStyle pSSFStyle) throws Exception {
        pSSFStylePrj.setPSSFStyleId(pSSFStyle.getPSSFStyleId());
        pSSFStylePrj.setPSSFStyleName(pSSFStyle.getPSSFStyleName());
    }

    protected void onFillEntityFullInfo(PSSFStylePrj pSSFStylePrj, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSFStylePrj, bl);
        this.onFillEntityFullInfo_PSSFStyle(pSSFStylePrj, bl);
    }

    protected void onFillEntityFullInfo_PSSFStyle(PSSFStylePrj pSSFStylePrj, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSFStylePrj pSSFStylePrj, boolean bl) throws Exception {
        super.onWriteBackParent(pSSFStylePrj, bl);
    }

    public ArrayList<PSSFStylePrj> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase) throws Exception {
        return this.selectByPSSFStyle(pSSFStyleBase, "", -1);
    }

    public ArrayList<PSSFStylePrj> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase, String string) throws Exception {
        return this.selectByPSSFStyle(pSSFStyleBase, string, -1);
    }

    public ArrayList<PSSFStylePrj> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFSTYLEID", (Object)pSSFStyleBase.getPSSFStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFStyleCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    public void resetPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFStylePrj> arrayList = this.selectByPSSFStyle(pSSFStyle);
        for (PSSFStylePrj pSSFStylePrj : arrayList) {
            PSSFStylePrj pSSFStylePrj2 = (PSSFStylePrj)this.getDEModel().createEntity();
            pSSFStylePrj2.setPSSFStylePrjId(pSSFStylePrj.getPSSFStylePrjId());
            pSSFStylePrj2.setPSSFStyleId(null);
            this.update(pSSFStylePrj2);
        }
    }

    public void removeByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        final PSSFStyle pSSFStyle2 = pSSFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFStylePrjServiceBase.this.onBeforeRemoveByPSSFStyle(pSSFStyle2);
                PSSFStylePrjServiceBase.this.internalRemoveByPSSFStyle(pSSFStyle2);
                PSSFStylePrjServiceBase.this.onAfterRemoveByPSSFStyle(pSSFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void internalRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFStylePrj> arrayList = this.selectByPSSFStyle(pSSFStyle);
        this.onBeforeRemoveByPSSFStyle(pSSFStyle, arrayList);
        for (PSSFStylePrj pSSFStylePrj : arrayList) {
            this.remove(pSSFStylePrj);
        }
        this.onAfterRemoveByPSSFStyle(pSSFStyle, arrayList);
    }

    protected void onAfterRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSFStylePrj> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSFStylePrj> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSFStylePrj pSSFStylePrj) throws Exception {
        PSSFCodeFolderService pSSFCodeFolderService = (PSSFCodeFolderService)ServiceGlobal.getService(PSSFCodeFolderService.class, (SessionFactory)this.getSessionFactory());
        pSSFCodeFolderService.testRemoveByPSSFStylePrj(pSSFStylePrj);
        super.onBeforeRemove(pSSFStylePrj);
    }

    protected void replaceParentInfo(PSSFStylePrj pSSFStylePrj, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSFStylePrj, cloneSession);
        if (pSSFStylePrj.getPSSFStyleId() != null && (iEntity = cloneSession.getEntity("PSSFSTYLE", (Object)pSSFStylePrj.getPSSFStyleId())) != null) {
            this.onFillParentInfo_PSSFStyle(pSSFStylePrj, (PSSFStyle)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSFStylePrj pSSFStylePrj, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSFStylePrj, bl);
    }

    protected void onCheckEntity(boolean bl, PSSFStylePrj pSSFStylePrj, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_MavenFlag(bl, pSSFStylePrj, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSFStylePrj, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NameFmt(bl, pSSFStylePrj, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrjType(bl, pSSFStylePrj, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleId(bl, pSSFStylePrj, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStylePrjId(bl, pSSFStylePrj, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStylePrjName(bl, pSSFStylePrj, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReadOnlyMode(bl, pSSFStylePrj, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSFStylePrj, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_MavenFlag(boolean bl, PSSFStylePrj pSSFStylePrj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStylePrj.isMavenFlagDirty() : !pSSFStylePrj.isMavenFlagDirty()) {
            return null;
        }
        Integer n = pSSFStylePrj.getMavenFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MavenFlag_Default(pSSFStylePrj, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAVENFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSFStylePrj pSSFStylePrj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStylePrj.isMemoDirty() : !pSSFStylePrj.isMemoDirty()) {
            return null;
        }
        String string = pSSFStylePrj.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSFStylePrj, bl2, bl3);
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

    protected EntityFieldError onCheckField_NameFmt(boolean bl, PSSFStylePrj pSSFStylePrj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStylePrj.isNameFmtDirty() && !bl2 : !pSSFStylePrj.isNameFmtDirty()) {
            return null;
        }
        String string = pSSFStylePrj.getNameFmt();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAMEFMT");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_NameFmt_Default(pSSFStylePrj, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAMEFMT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrjType(boolean bl, PSSFStylePrj pSSFStylePrj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStylePrj.isPrjTypeDirty() && !bl2 : !pSSFStylePrj.isPrjTypeDirty()) {
            return null;
        }
        String string = pSSFStylePrj.getPrjType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRJTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrjType_Default(pSSFStylePrj, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRJTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFStyleId(boolean bl, PSSFStylePrj pSSFStylePrj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStylePrj.isPSSFStyleIdDirty() : !pSSFStylePrj.isPSSFStyleIdDirty()) {
            return null;
        }
        String string = pSSFStylePrj.getPSSFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleId_Default(pSSFStylePrj, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFStylePrjId(boolean bl, PSSFStylePrj pSSFStylePrj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStylePrj.isPSSFStylePrjIdDirty() && !bl2 : !pSSFStylePrj.isPSSFStylePrjIdDirty()) {
            return null;
        }
        String string = pSSFStylePrj.getPSSFStylePrjId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEPRJID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStylePrjId_Default(pSSFStylePrj, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEPRJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFStylePrjName(boolean bl, PSSFStylePrj pSSFStylePrj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStylePrj.isPSSFStylePrjNameDirty() && !bl2 : !pSSFStylePrj.isPSSFStylePrjNameDirty()) {
            return null;
        }
        String string = pSSFStylePrj.getPSSFStylePrjName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEPRJNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStylePrjName_Default(pSSFStylePrj, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEPRJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ReadOnlyMode(boolean bl, PSSFStylePrj pSSFStylePrj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStylePrj.isReadOnlyModeDirty() && !bl2 : !pSSFStylePrj.isReadOnlyModeDirty()) {
            return null;
        }
        Integer n = pSSFStylePrj.getReadOnlyMode();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("READONLYMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ReadOnlyMode_Default(pSSFStylePrj, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("READONLYMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSFStylePrj pSSFStylePrj, boolean bl) throws Exception {
        super.onSyncEntity(pSSFStylePrj, bl);
    }

    protected void onSyncIndexEntities(PSSFStylePrj pSSFStylePrj, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSFStylePrj, bl);
    }

    public Object getDataContextValue(PSSFStylePrj pSSFStylePrj, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSFStylePrj, string, iDataContextParam)) != null) {
            return object;
        }
        PSSFStyle pSSFStyle = pSSFStylePrj.getPSSFStyle();
        if (pSSFStyle != null && pSSFStyle.contains(string)) {
            return pSSFStyle.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSFStylePrj pSSFStylePrj, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSFStylePrj, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAVENFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MavenFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAMEFMT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NameFmt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRJTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrjType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEPRJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStylePrjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEPRJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStylePrjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"READONLYMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReadOnlyMode_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_MavenFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_NameFmt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAMEFMT", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PrjType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PRJTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStylePrjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEPRJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStylePrjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEPRJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ReadOnlyMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, PSSFStylePrj pSSFStylePrj) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSFStylePrj)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSFStylePrj pSSFStylePrj) throws Exception {
        super.onUpdateParent(pSSFStylePrj);
    }

    @Override
    protected void exportCurXmlModel(PSSFStylePrj pSSFStylePrj, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSFSTYLEPRJ");
        if (!bl) {
            pSSFStylePrj.setCreateDate(null);
            pSSFStylePrj.setCreateMan(null);
            pSSFStylePrj.setPSSFStyleName(null);
            pSSFStylePrj.setPSSFStylePrjId(null);
            pSSFStylePrj.setUpdateDate(null);
            pSSFStylePrj.setUpdateMan(null);
            super.exportCurXmlModel(pSSFStylePrj, xmlNode, bl);
        }
    }
}

