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
import net.ibizsys.pscore.srv.config.dao.PSVTStyleDAO;
import net.ibizsys.pscore.srv.config.demodel.PSVTStyleDEModel;
import net.ibizsys.pscore.srv.config.entity.PSVTStyle;
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSVTStyleServiceBase
extends PSCoreSysServiceBase<PSVTStyle> {
    private static final Log log = LogFactory.getLog(PSVTStyleServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSVTStyleDEModel pSVTStyleDEModel;
    private PSVTStyleDAO pSVTStyleDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSVTStyleService";
    }

    public PSVTStyleDEModel getPSVTStyleDEModel() {
        if (this.pSVTStyleDEModel == null) {
            try {
                this.pSVTStyleDEModel = (PSVTStyleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSVTStyleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSVTStyleDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSVTStyleDEModel();
    }

    public PSVTStyleDAO getPSVTStyleDAO() {
        if (this.pSVTStyleDAO == null) {
            try {
                this.pSVTStyleDAO = (PSVTStyleDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSVTStyleDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSVTStyleDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSVTStyleDAO();
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

    protected void onFillParentInfo(PSVTStyle pSVTStyle, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVTSTYLE_PSVIEWTYPE_PSVIEWTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewTypeService", (SessionFactory)this.getSessionFactory());
            PSViewType pSViewType = (PSViewType)iService.getDEModel().createEntity();
            pSViewType.set("PSVIEWTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewType);
            } else {
                iService.get(pSViewType);
            }
            this.onFillParentInfo_PSViewType(pSVTStyle, pSViewType);
            return;
        }
        super.onFillParentInfo(pSVTStyle, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSViewType(PSVTStyle pSVTStyle, PSViewType pSViewType) throws Exception {
        pSVTStyle.setPSViewTypeId(pSViewType.getPSViewTypeId());
        pSVTStyle.setPSViewTypeName(pSViewType.getPSViewTypeName());
    }

    protected void onFillEntityFullInfo(PSVTStyle pSVTStyle, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSVTStyle, bl);
        this.onFillEntityFullInfo_PSViewType(pSVTStyle, bl);
    }

    protected void onFillEntityFullInfo_PSViewType(PSVTStyle pSVTStyle, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSVTStyle pSVTStyle, boolean bl) throws Exception {
        super.onWriteBackParent(pSVTStyle, bl);
    }

    public ArrayList<PSVTStyle> selectByPSViewType(PSViewTypeBase pSViewTypeBase) throws Exception {
        return this.selectByPSViewType(pSViewTypeBase, "", -1);
    }

    public ArrayList<PSVTStyle> selectByPSViewType(PSViewTypeBase pSViewTypeBase, String string) throws Exception {
        return this.selectByPSViewType(pSViewTypeBase, string, -1);
    }

    public ArrayList<PSVTStyle> selectByPSViewType(PSViewTypeBase pSViewTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWTYPEID", (Object)pSViewTypeBase.getPSViewTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSViewTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSViewTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSViewType(PSViewType pSViewType) throws Exception {
    }

    public void resetPSViewType(PSViewType pSViewType) throws Exception {
        ArrayList<PSVTStyle> arrayList = this.selectByPSViewType(pSViewType);
        for (PSVTStyle pSVTStyle : arrayList) {
            PSVTStyle pSVTStyle2 = (PSVTStyle)this.getDEModel().createEntity();
            pSVTStyle2.setPSVTStyleId(pSVTStyle.getPSVTStyleId());
            pSVTStyle2.setPSViewTypeId(null);
            this.update(pSVTStyle2);
        }
    }

    public void removeByPSViewType(PSViewType pSViewType) throws Exception {
        final PSViewType pSViewType2 = pSViewType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSVTStyleServiceBase.this.onBeforeRemoveByPSViewType(pSViewType2);
                PSVTStyleServiceBase.this.internalRemoveByPSViewType(pSViewType2);
                PSVTStyleServiceBase.this.onAfterRemoveByPSViewType(pSViewType2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewType(PSViewType pSViewType) throws Exception {
    }

    protected void internalRemoveByPSViewType(PSViewType pSViewType) throws Exception {
        ArrayList<PSVTStyle> arrayList = this.selectByPSViewType(pSViewType);
        this.onBeforeRemoveByPSViewType(pSViewType, arrayList);
        for (PSVTStyle pSVTStyle : arrayList) {
            this.remove(pSVTStyle);
        }
        this.onAfterRemoveByPSViewType(pSViewType, arrayList);
    }

    protected void onAfterRemoveByPSViewType(PSViewType pSViewType) throws Exception {
    }

    protected void onBeforeRemoveByPSViewType(PSViewType pSViewType, ArrayList<PSVTStyle> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewType(PSViewType pSViewType, ArrayList<PSVTStyle> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSVTStyle pSVTStyle) throws Exception {
        PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        pSDEViewBaseService.testRemoveByPSVTStyle(pSVTStyle);
        super.onBeforeRemove(pSVTStyle);
    }

    protected void replaceParentInfo(PSVTStyle pSVTStyle, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSVTStyle, cloneSession);
        if (pSVTStyle.getPSViewTypeId() != null && (iEntity = cloneSession.getEntity("PSVIEWTYPE", (Object)pSVTStyle.getPSViewTypeId())) != null) {
            this.onFillParentInfo_PSViewType(pSVTStyle, (PSViewType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSVTStyle pSVTStyle, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSVTStyle, bl);
    }

    protected void onCheckEntity(boolean bl, PSVTStyle pSVTStyle, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_LogicName(bl, pSVTStyle, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSVTStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewTypeId(bl, pSVTStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSVTStyleId(bl, pSVTStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSVTStyleName(bl, pSVTStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSVTStyle, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSVTStyle pSVTStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTStyle.isLogicNameDirty() && !bl2 : !pSVTStyle.isLogicNameDirty()) {
            return null;
        }
        String string = pSVTStyle.getLogicName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSVTStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSVTStyle pSVTStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTStyle.isMemoDirty() : !pSVTStyle.isMemoDirty()) {
            return null;
        }
        String string = pSVTStyle.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSVTStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSViewTypeId(boolean bl, PSVTStyle pSVTStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTStyle.isPSViewTypeIdDirty() && !bl2 : !pSVTStyle.isPSViewTypeIdDirty()) {
            return null;
        }
        String string = pSVTStyle.getPSViewTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewTypeId_Default(pSVTStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSVTStyleId(boolean bl, PSVTStyle pSVTStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTStyle.isPSVTStyleIdDirty() && !bl2 : !pSVTStyle.isPSVTStyleIdDirty()) {
            return null;
        }
        String string = pSVTStyle.getPSVTStyleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVTSTYLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSVTStyleId_Default(pSVTStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVTSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSVTStyleName(boolean bl, PSVTStyle pSVTStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTStyle.isPSVTStyleNameDirty() && !bl2 : !pSVTStyle.isPSVTStyleNameDirty()) {
            return null;
        }
        String string = pSVTStyle.getPSVTStyleName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVTSTYLENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSVTStyleName_Default(pSVTStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVTSTYLENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSVTStyle pSVTStyle, boolean bl) throws Exception {
        super.onSyncEntity(pSVTStyle, bl);
    }

    protected void onSyncIndexEntities(PSVTStyle pSVTStyle, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSVTStyle, bl);
    }

    public Object getDataContextValue(PSVTStyle pSVTStyle, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSVTStyle, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSVTStyle pSVTStyle, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSVTStyle, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVTSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSVTStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVTSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSVTStyleName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSVTStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVTSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSVTStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVTSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSVTStyle pSVTStyle) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSVTStyle)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSVTStyle pSVTStyle) throws Exception {
        super.onUpdateParent(pSVTStyle);
    }

    @Override
    protected void exportCurXmlModel(PSVTStyle pSVTStyle, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSVTSTYLE");
        if (!bl) {
            pSVTStyle.setCreateDate(null);
            pSVTStyle.setCreateMan(null);
            pSVTStyle.setPSVTStyleId(null);
            pSVTStyle.setUpdateDate(null);
            pSVTStyle.setUpdateMan(null);
            super.exportCurXmlModel(pSVTStyle, xmlNode, bl);
        }
    }
}

