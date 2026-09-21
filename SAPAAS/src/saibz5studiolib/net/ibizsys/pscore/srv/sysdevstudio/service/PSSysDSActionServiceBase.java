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
package net.ibizsys.pscore.srv.sysdevstudio.service;

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
import net.ibizsys.pscore.srv.sysdevstudio.dao.PSSysDSActionDAO;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSSysDSActionDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDSAction;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevStudio;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevStudioBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDSActionServiceBase
extends PSCoreSysServiceBase<PSSysDSAction> {
    private static final Log log = LogFactory.getLog(PSSysDSActionServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysDSActionDEModel pSSysDSActionDEModel;
    private PSSysDSActionDAO pSSysDSActionDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDSActionService";
    }

    public PSSysDSActionDEModel getPSSysDSActionDEModel() {
        if (this.pSSysDSActionDEModel == null) {
            try {
                this.pSSysDSActionDEModel = (PSSysDSActionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSSysDSActionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDSActionDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysDSActionDEModel();
    }

    public PSSysDSActionDAO getPSSysDSActionDAO() {
        if (this.pSSysDSActionDAO == null) {
            try {
                this.pSSysDSActionDAO = (PSSysDSActionDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdevstudio.dao.PSSysDSActionDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDSActionDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysDSActionDAO();
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

    protected void onFillParentInfo(PSSysDSAction pSSysDSAction, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDSACTION_PSSYSDEVSTUDIO_PSSYSDEVSTUDIOID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevStudioService", (SessionFactory)this.getSessionFactory());
            PSSysDevStudio pSSysDevStudio = (PSSysDevStudio)iService.getDEModel().createEntity();
            pSSysDevStudio.set("PSSYSDEVSTUDIOID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDevStudio);
            } else {
                iService.get((IEntity)pSSysDevStudio);
            }
            this.onFillParentInfo_Pssysdevstudio(pSSysDSAction, pSSysDevStudio);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysDSAction, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Pssysdevstudio(PSSysDSAction pSSysDSAction, PSSysDevStudio pSSysDevStudio) throws Exception {
        pSSysDSAction.setPSSysDevStudioId(pSSysDevStudio.getPSSysDevStudioId());
        pSSysDSAction.setPSSysDevStudioName(pSSysDevStudio.getPSSysDevStudioName());
    }

    protected void onFillEntityFullInfo(PSSysDSAction pSSysDSAction, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSysDSAction, bl);
        this.onFillEntityFullInfo_Pssysdevstudio(pSSysDSAction, bl);
    }

    protected void onFillEntityFullInfo_Pssysdevstudio(PSSysDSAction pSSysDSAction, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysDSAction pSSysDSAction, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysDSAction, bl);
    }

    public ArrayList<PSSysDSAction> selectByPssysdevstudio(PSSysDevStudioBase pSSysDevStudioBase) throws Exception {
        return this.selectByPssysdevstudio(pSSysDevStudioBase, "", -1);
    }

    public ArrayList<PSSysDSAction> selectByPssysdevstudio(PSSysDevStudioBase pSSysDevStudioBase, String string) throws Exception {
        return this.selectByPssysdevstudio(pSSysDevStudioBase, string, -1);
    }

    public ArrayList<PSSysDSAction> selectByPssysdevstudio(PSSysDevStudioBase pSSysDevStudioBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDEVSTUDIOID", (Object)pSSysDevStudioBase.getPSSysDevStudioId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPssysdevstudioCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPssysdevstudioCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPssysdevstudio(PSSysDevStudio pSSysDevStudio) throws Exception {
    }

    public void resetPssysdevstudio(PSSysDevStudio pSSysDevStudio) throws Exception {
        ArrayList<PSSysDSAction> arrayList = this.selectByPssysdevstudio(pSSysDevStudio);
        for (PSSysDSAction pSSysDSAction : arrayList) {
            PSSysDSAction pSSysDSAction2 = (PSSysDSAction)this.getDEModel().createEntity();
            pSSysDSAction2.setPSSysDSActionId(pSSysDSAction.getPSSysDSActionId());
            pSSysDSAction2.setPSSysDevStudioId(null);
            this.update(pSSysDSAction2);
        }
    }

    public void removeByPssysdevstudio(PSSysDevStudio pSSysDevStudio) throws Exception {
        final PSSysDevStudio pSSysDevStudio2 = pSSysDevStudio;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDSActionServiceBase.this.onBeforeRemoveByPssysdevstudio(pSSysDevStudio2);
                PSSysDSActionServiceBase.this.internalRemoveByPssysdevstudio(pSSysDevStudio2);
                PSSysDSActionServiceBase.this.onAfterRemoveByPssysdevstudio(pSSysDevStudio2);
            }
        });
    }

    protected void onBeforeRemoveByPssysdevstudio(PSSysDevStudio pSSysDevStudio) throws Exception {
    }

    protected void internalRemoveByPssysdevstudio(PSSysDevStudio pSSysDevStudio) throws Exception {
        ArrayList<PSSysDSAction> arrayList = this.selectByPssysdevstudio(pSSysDevStudio);
        this.onBeforeRemoveByPssysdevstudio(pSSysDevStudio, arrayList);
        for (PSSysDSAction pSSysDSAction : arrayList) {
            this.remove((IEntity)pSSysDSAction);
        }
        this.onAfterRemoveByPssysdevstudio(pSSysDevStudio, arrayList);
    }

    protected void onAfterRemoveByPssysdevstudio(PSSysDevStudio pSSysDevStudio) throws Exception {
    }

    protected void onBeforeRemoveByPssysdevstudio(PSSysDevStudio pSSysDevStudio, ArrayList<PSSysDSAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPssysdevstudio(PSSysDevStudio pSSysDevStudio, ArrayList<PSSysDSAction> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysDSAction pSSysDSAction) throws Exception {
        super.onBeforeRemove(pSSysDSAction);
    }

    protected void replaceParentInfo(PSSysDSAction pSSysDSAction, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysDSAction, cloneSession);
        if (pSSysDSAction.getPSSysDevStudioId() != null && (iEntity = cloneSession.getEntity("PSSYSDEVSTUDIO", (Object)pSSysDSAction.getPSSysDevStudioId())) != null) {
            this.onFillParentInfo_Pssysdevstudio(pSSysDSAction, (PSSysDevStudio)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysDSAction pSSysDSAction, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysDSAction, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysDSAction pSSysDSAction, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSSysDevStudioId(bl, pSSysDSAction, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDSActionId(bl, pSSysDSAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDSActionName(bl, pSSysDSAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysDSAction, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSSysDevStudioId(boolean bl, PSSysDSAction pSSysDSAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDSAction.isPSSysDevStudioIdDirty() : !pSSysDSAction.isPSSysDevStudioIdDirty()) {
            return null;
        }
        String string = pSSysDSAction.getPSSysDevStudioId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDevStudioId_Default((IEntity)pSSysDSAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEVSTUDIOID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDSActionId(boolean bl, PSSysDSAction pSSysDSAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDSAction.isPSSysDSActionIdDirty() && !bl2 : !pSSysDSAction.isPSSysDSActionIdDirty()) {
            return null;
        }
        String string = pSSysDSAction.getPSSysDSActionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDSACTIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDSActionId_Default((IEntity)pSSysDSAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDSACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDSActionName(boolean bl, PSSysDSAction pSSysDSAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDSAction.isPSSysDSActionNameDirty() && !bl2 : !pSSysDSAction.isPSSysDSActionNameDirty()) {
            return null;
        }
        String string = pSSysDSAction.getPSSysDSActionName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDSACTIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDSActionName_Default((IEntity)pSSysDSAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDSACTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysDSAction pSSysDSAction, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysDSAction, bl);
    }

    protected void onSyncIndexEntities(PSSysDSAction pSSysDSAction, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysDSAction, bl);
    }

    public Object getDataContextValue(PSSysDSAction pSSysDSAction, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysDSAction, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysDSAction pSSysDSAction, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysDSAction, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDEVSTUDIOID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDevStudioId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDEVSTUDIONAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDevStudioName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDSACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDSActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDSACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDSActionName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSSysDevStudioId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDEVSTUDIOID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDevStudioName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDEVSTUDIONAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDSActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDSACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDSActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDSACTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysDSAction pSSysDSAction) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysDSAction)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysDSAction pSSysDSAction) throws Exception {
        super.onUpdateParent((IEntity)pSSysDSAction);
    }

    @Override
    protected void exportCurXmlModel(PSSysDSAction pSSysDSAction, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSDSACTION");
        if (!bl) {
            pSSysDSAction.setPSSysDevStudioName(null);
            super.exportCurXmlModel(pSSysDSAction, xmlNode, bl);
        }
    }
}

