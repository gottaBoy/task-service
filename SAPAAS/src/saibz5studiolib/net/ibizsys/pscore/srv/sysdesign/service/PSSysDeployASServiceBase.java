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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysDeployASDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDeployASDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDeploy;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDeployAS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDeployBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDeployASServiceBase
extends PSCoreSysServiceBase<PSSysDeployAS> {
    private static final Log log = LogFactory.getLog(PSSysDeployASServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysDeployASDEModel pSSysDeployASDEModel;
    private PSSysDeployASDAO pSSysDeployASDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysDeployASService";
    }

    public PSSysDeployASDEModel getPSSysDeployASDEModel() {
        if (this.pSSysDeployASDEModel == null) {
            try {
                this.pSSysDeployASDEModel = (PSSysDeployASDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDeployASDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDeployASDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysDeployASDEModel();
    }

    public PSSysDeployASDAO getPSSysDeployASDAO() {
        if (this.pSSysDeployASDAO == null) {
            try {
                this.pSSysDeployASDAO = (PSSysDeployASDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysDeployASDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDeployASDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysDeployASDAO();
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

    protected void onFillParentInfo(PSSysDeployAS pSSysDeployAS, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDEPLOYAS_PSSYSDEPLOY_PSSYSDEPLOYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDeployService", (SessionFactory)this.getSessionFactory());
            PSSysDeploy pSSysDeploy = (PSSysDeploy)iService.getDEModel().createEntity();
            pSSysDeploy.set("PSSYSDEPLOYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDeploy);
            } else {
                iService.get((IEntity)pSSysDeploy);
            }
            this.onFillParentInfo_Pssysdeploy(pSSysDeployAS, pSSysDeploy);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysDeployAS, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Pssysdeploy(PSSysDeployAS pSSysDeployAS, PSSysDeploy pSSysDeploy) throws Exception {
        pSSysDeployAS.setPSSysDeployId(pSSysDeploy.getPSSysDeployId());
        pSSysDeployAS.setPSSysDeployName(pSSysDeploy.getPSSysDeployName());
    }

    protected void onFillEntityFullInfo(PSSysDeployAS pSSysDeployAS, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSysDeployAS, bl);
        this.onFillEntityFullInfo_Pssysdeploy(pSSysDeployAS, bl);
    }

    protected void onFillEntityFullInfo_Pssysdeploy(PSSysDeployAS pSSysDeployAS, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysDeployAS pSSysDeployAS, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysDeployAS, bl);
    }

    public ArrayList<PSSysDeployAS> selectByPssysdeploy(PSSysDeployBase pSSysDeployBase) throws Exception {
        return this.selectByPssysdeploy(pSSysDeployBase, "", -1);
    }

    public ArrayList<PSSysDeployAS> selectByPssysdeploy(PSSysDeployBase pSSysDeployBase, String string) throws Exception {
        return this.selectByPssysdeploy(pSSysDeployBase, string, -1);
    }

    public ArrayList<PSSysDeployAS> selectByPssysdeploy(PSSysDeployBase pSSysDeployBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDEPLOYID", (Object)pSSysDeployBase.getPSSysDeployId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPssysdeployCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPssysdeployCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPssysdeploy(PSSysDeploy pSSysDeploy) throws Exception {
    }

    public void resetPssysdeploy(PSSysDeploy pSSysDeploy) throws Exception {
        ArrayList<PSSysDeployAS> arrayList = this.selectByPssysdeploy(pSSysDeploy);
        for (PSSysDeployAS pSSysDeployAS : arrayList) {
            PSSysDeployAS pSSysDeployAS2 = (PSSysDeployAS)this.getDEModel().createEntity();
            pSSysDeployAS2.setPSSysDeployASId(pSSysDeployAS.getPSSysDeployASId());
            pSSysDeployAS2.setPSSysDeployId(null);
            this.update(pSSysDeployAS2);
        }
    }

    public void removeByPssysdeploy(PSSysDeploy pSSysDeploy) throws Exception {
        final PSSysDeploy pSSysDeploy2 = pSSysDeploy;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDeployASServiceBase.this.onBeforeRemoveByPssysdeploy(pSSysDeploy2);
                PSSysDeployASServiceBase.this.internalRemoveByPssysdeploy(pSSysDeploy2);
                PSSysDeployASServiceBase.this.onAfterRemoveByPssysdeploy(pSSysDeploy2);
            }
        });
    }

    protected void onBeforeRemoveByPssysdeploy(PSSysDeploy pSSysDeploy) throws Exception {
    }

    protected void internalRemoveByPssysdeploy(PSSysDeploy pSSysDeploy) throws Exception {
        ArrayList<PSSysDeployAS> arrayList = this.selectByPssysdeploy(pSSysDeploy);
        this.onBeforeRemoveByPssysdeploy(pSSysDeploy, arrayList);
        for (PSSysDeployAS pSSysDeployAS : arrayList) {
            this.remove((IEntity)pSSysDeployAS);
        }
        this.onAfterRemoveByPssysdeploy(pSSysDeploy, arrayList);
    }

    protected void onAfterRemoveByPssysdeploy(PSSysDeploy pSSysDeploy) throws Exception {
    }

    protected void onBeforeRemoveByPssysdeploy(PSSysDeploy pSSysDeploy, ArrayList<PSSysDeployAS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPssysdeploy(PSSysDeploy pSSysDeploy, ArrayList<PSSysDeployAS> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysDeployAS pSSysDeployAS) throws Exception {
        super.onBeforeRemove(pSSysDeployAS);
    }

    protected void replaceParentInfo(PSSysDeployAS pSSysDeployAS, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysDeployAS, cloneSession);
        if (pSSysDeployAS.getPSSysDeployId() != null && (iEntity = cloneSession.getEntity("PSSYSDEPLOY", (Object)pSSysDeployAS.getPSSysDeployId())) != null) {
            this.onFillParentInfo_Pssysdeploy(pSSysDeployAS, (PSSysDeploy)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysDeployAS pSSysDeployAS, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysDeployAS, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysDeployAS pSSysDeployAS, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSSysDeployASId(bl, pSSysDeployAS, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDeployASName(bl, pSSysDeployAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDeployId(bl, pSSysDeployAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysDeployAS, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSSysDeployASId(boolean bl, PSSysDeployAS pSSysDeployAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDeployAS.isPSSysDeployASIdDirty() && !bl2 : !pSSysDeployAS.isPSSysDeployASIdDirty()) {
            return null;
        }
        String string = pSSysDeployAS.getPSSysDeployASId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEPLOYASID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDeployASId_Default((IEntity)pSSysDeployAS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEPLOYASID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDeployASName(boolean bl, PSSysDeployAS pSSysDeployAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDeployAS.isPSSysDeployASNameDirty() && !bl2 : !pSSysDeployAS.isPSSysDeployASNameDirty()) {
            return null;
        }
        String string = pSSysDeployAS.getPSSysDeployASName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEPLOYASNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDeployASName_Default((IEntity)pSSysDeployAS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEPLOYASNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDeployId(boolean bl, PSSysDeployAS pSSysDeployAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDeployAS.isPSSysDeployIdDirty() && !bl2 : !pSSysDeployAS.isPSSysDeployIdDirty()) {
            return null;
        }
        String string = pSSysDeployAS.getPSSysDeployId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEPLOYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDeployId_Default((IEntity)pSSysDeployAS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEPLOYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysDeployAS pSSysDeployAS, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysDeployAS, bl);
    }

    protected void onSyncIndexEntities(PSSysDeployAS pSSysDeployAS, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysDeployAS, bl);
    }

    public Object getDataContextValue(PSSysDeployAS pSSysDeployAS, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysDeployAS, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysDeployAS pSSysDeployAS, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysDeployAS, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDEPLOYASID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDeployASId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDEPLOYASNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDeployASName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDEPLOYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDeployId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDEPLOYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDeployName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSSysDeployASId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDEPLOYASID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDeployASName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDEPLOYASNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDeployId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDEPLOYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDeployName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDEPLOYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysDeployAS pSSysDeployAS) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysDeployAS)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysDeployAS pSSysDeployAS) throws Exception {
        super.onUpdateParent((IEntity)pSSysDeployAS);
    }

    @Override
    protected void exportCurXmlModel(PSSysDeployAS pSSysDeployAS, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSDEPLOYAS");
        if (!bl) {
            pSSysDeployAS.setCreateDate(null);
            pSSysDeployAS.setCreateMan(null);
            pSSysDeployAS.setPSSysDeployASId(null);
            pSSysDeployAS.setUpdateDate(null);
            pSSysDeployAS.setUpdateMan(null);
            super.exportCurXmlModel(pSSysDeployAS, xmlNode, bl);
        }
    }
}

