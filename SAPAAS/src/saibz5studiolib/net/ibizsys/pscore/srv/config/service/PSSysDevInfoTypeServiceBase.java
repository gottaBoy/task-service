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
package net.ibizsys.pscore.srv.config.service;

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
import net.ibizsys.pscore.srv.config.dao.PSSysDevInfoTypeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSysDevInfoTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSysDevInfoType;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDevInfoTypeServiceBase
extends PSCoreSysServiceBase<PSSysDevInfoType> {
    private static final Log log = LogFactory.getLog(PSSysDevInfoTypeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysDevInfoTypeDEModel pSSysDevInfoTypeDEModel;
    private PSSysDevInfoTypeDAO pSSysDevInfoTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSysDevInfoTypeService";
    }

    public PSSysDevInfoTypeDEModel getPSSysDevInfoTypeDEModel() {
        if (this.pSSysDevInfoTypeDEModel == null) {
            try {
                this.pSSysDevInfoTypeDEModel = (PSSysDevInfoTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSysDevInfoTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDevInfoTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysDevInfoTypeDEModel();
    }

    public PSSysDevInfoTypeDAO getPSSysDevInfoTypeDAO() {
        if (this.pSSysDevInfoTypeDAO == null) {
            try {
                this.pSSysDevInfoTypeDAO = (PSSysDevInfoTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSysDevInfoTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDevInfoTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysDevInfoTypeDAO();
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

    protected void onFillParentInfo(PSSysDevInfoType pSSysDevInfoType, String string, String string2, String string3) throws Exception {
        super.onFillParentInfo(pSSysDevInfoType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillEntityFullInfo(PSSysDevInfoType pSSysDevInfoType, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSysDevInfoType, bl);
    }

    protected void onWriteBackParent(PSSysDevInfoType pSSysDevInfoType, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysDevInfoType, bl);
    }

    @Override
    protected void onBeforeRemove(PSSysDevInfoType pSSysDevInfoType) throws Exception {
        super.onBeforeRemove(pSSysDevInfoType);
    }

    protected void onRemoveEntityUncopyValues(PSSysDevInfoType pSSysDevInfoType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysDevInfoType, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysDevInfoType pSSysDevInfoType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSSysDevInfoTypeId(bl, pSSysDevInfoType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDevInfoTypeName(bl, pSSysDevInfoType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysDevInfoType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSSysDevInfoTypeId(boolean bl, PSSysDevInfoType pSSysDevInfoType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevInfoType.isPSSysDevInfoTypeIdDirty() && !bl2 : !pSSysDevInfoType.isPSSysDevInfoTypeIdDirty()) {
            return null;
        }
        String string = pSSysDevInfoType.getPSSysDevInfoTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEVINFOTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDevInfoTypeId_Default(pSSysDevInfoType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEVINFOTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDevInfoTypeName(boolean bl, PSSysDevInfoType pSSysDevInfoType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevInfoType.isPSSysDevInfoTypeNameDirty() && !bl2 : !pSSysDevInfoType.isPSSysDevInfoTypeNameDirty()) {
            return null;
        }
        String string = pSSysDevInfoType.getPSSysDevInfoTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEVINFOTYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDevInfoTypeName_Default(pSSysDevInfoType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEVINFOTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysDevInfoType pSSysDevInfoType, boolean bl) throws Exception {
        super.onSyncEntity(pSSysDevInfoType, bl);
    }

    protected void onSyncIndexEntities(PSSysDevInfoType pSSysDevInfoType, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysDevInfoType, bl);
    }

    public Object getDataContextValue(PSSysDevInfoType pSSysDevInfoType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysDevInfoType, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysDevInfoType pSSysDevInfoType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysDevInfoType, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDEVINFOTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDevInfoTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDEVINFOTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDevInfoTypeName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSSysDevInfoTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDEVINFOTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDevInfoTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDEVINFOTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysDevInfoType pSSysDevInfoType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysDevInfoType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysDevInfoType pSSysDevInfoType) throws Exception {
        super.onUpdateParent(pSSysDevInfoType);
    }

    @Override
    protected void exportCurXmlModel(PSSysDevInfoType pSSysDevInfoType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSDEVINFOTYPE");
        if (!bl) {
            super.exportCurXmlModel(pSSysDevInfoType, xmlNode, bl);
        }
    }
}

