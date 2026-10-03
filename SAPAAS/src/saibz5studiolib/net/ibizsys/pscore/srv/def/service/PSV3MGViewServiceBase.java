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
import net.ibizsys.pscore.srv.def.dao.PSV3MGViewDAO;
import net.ibizsys.pscore.srv.def.demodel.PSV3MGViewDEModel;
import net.ibizsys.pscore.srv.def.entity.PSV3MGView;
import net.ibizsys.pscore.srv.def.entity.PSV3Migrate;
import net.ibizsys.pscore.srv.def.entity.PSV3MigrateBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSV3MGViewServiceBase
extends PSCoreSysServiceBase<PSV3MGView> {
    private static final Log log = LogFactory.getLog(PSV3MGViewServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSV3MGViewDEModel pSV3MGViewDEModel;
    private PSV3MGViewDAO pSV3MGViewDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.def.service.PSV3MGViewService";
    }

    public PSV3MGViewDEModel getPSV3MGViewDEModel() {
        if (this.pSV3MGViewDEModel == null) {
            try {
                this.pSV3MGViewDEModel = (PSV3MGViewDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.def.demodel.PSV3MGViewDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSV3MGViewDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSV3MGViewDEModel();
    }

    public PSV3MGViewDAO getPSV3MGViewDAO() {
        if (this.pSV3MGViewDAO == null) {
            try {
                this.pSV3MGViewDAO = (PSV3MGViewDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.def.dao.PSV3MGViewDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSV3MGViewDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSV3MGViewDAO();
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

    protected void onFillParentInfo(PSV3MGView pSV3MGView, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSV3MGVIEW_PSV3MIGRATE_PSV3MIGRATEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSV3MigrateService", (SessionFactory)this.getSessionFactory());
            PSV3Migrate pSV3Migrate = (PSV3Migrate)iService.getDEModel().createEntity();
            pSV3Migrate.set("PSV3MIGRATEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSV3Migrate);
            } else {
                iService.get(pSV3Migrate);
            }
            this.onFillParentInfo_Psv3migrate(pSV3MGView, pSV3Migrate);
            return;
        }
        super.onFillParentInfo(pSV3MGView, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Psv3migrate(PSV3MGView pSV3MGView, PSV3Migrate pSV3Migrate) throws Exception {
        pSV3MGView.setPSV3MigrateId(pSV3Migrate.getPSV3MigrateId());
        pSV3MGView.setPSV3MigrateName(pSV3Migrate.getPSV3MigrateName());
    }

    protected void onFillEntityFullInfo(PSV3MGView pSV3MGView, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSV3MGView, bl);
        this.onFillEntityFullInfo_Psv3migrate(pSV3MGView, bl);
    }

    protected void onFillEntityFullInfo_Psv3migrate(PSV3MGView pSV3MGView, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSV3MGView pSV3MGView, boolean bl) throws Exception {
        super.onWriteBackParent(pSV3MGView, bl);
    }

    public ArrayList<PSV3MGView> selectByPsv3migrate(PSV3MigrateBase pSV3MigrateBase) throws Exception {
        return this.selectByPsv3migrate(pSV3MigrateBase, "", -1);
    }

    public ArrayList<PSV3MGView> selectByPsv3migrate(PSV3MigrateBase pSV3MigrateBase, String string) throws Exception {
        return this.selectByPsv3migrate(pSV3MigrateBase, string, -1);
    }

    public ArrayList<PSV3MGView> selectByPsv3migrate(PSV3MigrateBase pSV3MigrateBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSV3MIGRATEID", (Object)pSV3MigrateBase.getPSV3MigrateId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPsv3migrateCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPsv3migrateCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPsv3migrate(PSV3Migrate pSV3Migrate) throws Exception {
    }

    public void resetPsv3migrate(PSV3Migrate pSV3Migrate) throws Exception {
        ArrayList<PSV3MGView> arrayList = this.selectByPsv3migrate(pSV3Migrate);
        for (PSV3MGView pSV3MGView : arrayList) {
            PSV3MGView pSV3MGView2 = (PSV3MGView)this.getDEModel().createEntity();
            pSV3MGView2.setPSV3MGViewId(pSV3MGView.getPSV3MGViewId());
            pSV3MGView2.setPSV3MigrateId(null);
            this.update(pSV3MGView2);
        }
    }

    public void removeByPsv3migrate(PSV3Migrate pSV3Migrate) throws Exception {
        final PSV3Migrate pSV3Migrate2 = pSV3Migrate;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSV3MGViewServiceBase.this.onBeforeRemoveByPsv3migrate(pSV3Migrate2);
                PSV3MGViewServiceBase.this.internalRemoveByPsv3migrate(pSV3Migrate2);
                PSV3MGViewServiceBase.this.onAfterRemoveByPsv3migrate(pSV3Migrate2);
            }
        });
    }

    protected void onBeforeRemoveByPsv3migrate(PSV3Migrate pSV3Migrate) throws Exception {
    }

    protected void internalRemoveByPsv3migrate(PSV3Migrate pSV3Migrate) throws Exception {
        ArrayList<PSV3MGView> arrayList = this.selectByPsv3migrate(pSV3Migrate);
        this.onBeforeRemoveByPsv3migrate(pSV3Migrate, arrayList);
        for (PSV3MGView pSV3MGView : arrayList) {
            this.remove(pSV3MGView);
        }
        this.onAfterRemoveByPsv3migrate(pSV3Migrate, arrayList);
    }

    protected void onAfterRemoveByPsv3migrate(PSV3Migrate pSV3Migrate) throws Exception {
    }

    protected void onBeforeRemoveByPsv3migrate(PSV3Migrate pSV3Migrate, ArrayList<PSV3MGView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPsv3migrate(PSV3Migrate pSV3Migrate, ArrayList<PSV3MGView> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSV3MGView pSV3MGView) throws Exception {
        super.onBeforeRemove(pSV3MGView);
    }

    protected void replaceParentInfo(PSV3MGView pSV3MGView, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSV3MGView, cloneSession);
        if (pSV3MGView.getPSV3MigrateId() != null && (iEntity = cloneSession.getEntity("PSV3MIGRATE", (Object)pSV3MGView.getPSV3MigrateId())) != null) {
            this.onFillParentInfo_Psv3migrate(pSV3MGView, (PSV3Migrate)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSV3MGView pSV3MGView, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSV3MGView, bl);
    }

    protected void onCheckEntity(boolean bl, PSV3MGView pSV3MGView, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSV3MGViewId(bl, pSV3MGView, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSV3MGViewName(bl, pSV3MGView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSV3MigrateId(bl, pSV3MGView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSV3MGView, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSV3MGViewId(boolean bl, PSV3MGView pSV3MGView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3MGView.isPSV3MGViewIdDirty() && !bl2 : !pSV3MGView.isPSV3MGViewIdDirty()) {
            return null;
        }
        String string = pSV3MGView.getPSV3MGViewId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSV3MGVIEWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSV3MGViewId_Default(pSV3MGView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSV3MGVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSV3MGViewName(boolean bl, PSV3MGView pSV3MGView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3MGView.isPSV3MGViewNameDirty() && !bl2 : !pSV3MGView.isPSV3MGViewNameDirty()) {
            return null;
        }
        String string = pSV3MGView.getPSV3MGViewName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSV3MGVIEWNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSV3MGViewName_Default(pSV3MGView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSV3MGVIEWNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSV3MigrateId(boolean bl, PSV3MGView pSV3MGView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3MGView.isPSV3MigrateIdDirty() && !bl2 : !pSV3MGView.isPSV3MigrateIdDirty()) {
            return null;
        }
        String string = pSV3MGView.getPSV3MigrateId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSV3MIGRATEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSV3MigrateId_Default(pSV3MGView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSV3MIGRATEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSV3MGView pSV3MGView, boolean bl) throws Exception {
        super.onSyncEntity(pSV3MGView, bl);
    }

    protected void onSyncIndexEntities(PSV3MGView pSV3MGView, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSV3MGView, bl);
    }

    public Object getDataContextValue(PSV3MGView pSV3MGView, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSV3MGView, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSV3MGView pSV3MGView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSV3MGView, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSV3MGVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSV3MGViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSV3MGVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSV3MGViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSV3MIGRATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSV3MigrateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSV3MIGRATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSV3MigrateName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSV3MGViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSV3MGVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSV3MGViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSV3MGVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSV3MigrateId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSV3MIGRATEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSV3MigrateName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSV3MIGRATENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSV3MGView pSV3MGView) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSV3MGView)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSV3MGView pSV3MGView) throws Exception {
        super.onUpdateParent(pSV3MGView);
    }

    @Override
    protected void exportCurXmlModel(PSV3MGView pSV3MGView, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSV3MGVIEW");
        if (!bl) {
            pSV3MGView.setCreateDate(null);
            pSV3MGView.setCreateMan(null);
            pSV3MGView.setPSV3MGViewId(null);
            pSV3MGView.setUpdateDate(null);
            pSV3MGView.setUpdateMan(null);
            super.exportCurXmlModel(pSV3MGView, xmlNode, bl);
        }
    }
}

