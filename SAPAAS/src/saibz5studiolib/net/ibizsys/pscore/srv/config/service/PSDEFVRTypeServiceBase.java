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
import net.ibizsys.pscore.srv.config.dao.PSDEFVRTypeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSDEFVRTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSDEFVRType;
import net.ibizsys.pscore.srv.config.service.PSDEFVRTypeDetailService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFVRTypeServiceBase
extends PSCoreSysServiceBase<PSDEFVRType> {
    private static final Log log = LogFactory.getLog(PSDEFVRTypeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEFVRTypeDEModel pSDEFVRTypeDEModel;
    private PSDEFVRTypeDAO pSDEFVRTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSDEFVRTypeService";
    }

    public PSDEFVRTypeDEModel getPSDEFVRTypeDEModel() {
        if (this.pSDEFVRTypeDEModel == null) {
            try {
                this.pSDEFVRTypeDEModel = (PSDEFVRTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSDEFVRTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFVRTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEFVRTypeDEModel();
    }

    public PSDEFVRTypeDAO getPSDEFVRTypeDAO() {
        if (this.pSDEFVRTypeDAO == null) {
            try {
                this.pSDEFVRTypeDAO = (PSDEFVRTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSDEFVRTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFVRTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEFVRTypeDAO();
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

    protected void onFillParentInfo(PSDEFVRType pSDEFVRType, String string, String string2, String string3) throws Exception {
        super.onFillParentInfo(pSDEFVRType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillEntityFullInfo(PSDEFVRType pSDEFVRType, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDEFVRType, bl);
    }

    protected void onWriteBackParent(PSDEFVRType pSDEFVRType, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEFVRType, bl);
    }

    @Override
    protected void onBeforeRemove(PSDEFVRType pSDEFVRType) throws Exception {
        PSDEFVRTypeDetailService pSDEFVRTypeDetailService = (PSDEFVRTypeDetailService)ServiceGlobal.getService(PSDEFVRTypeDetailService.class, (SessionFactory)this.getSessionFactory());
        pSDEFVRTypeDetailService.testRemoveByPSDEFVRType(pSDEFVRType);
        pSDEFVRTypeDetailService.removeByPSDEFVRType(pSDEFVRType);
        super.onBeforeRemove(pSDEFVRType);
    }

    protected void onRemoveEntityUncopyValues(PSDEFVRType pSDEFVRType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEFVRType, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEFVRType pSDEFVRType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_IconPath(bl, pSDEFVRType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEFVRType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ProcessObj(bl, pSDEFVRType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFVRTypeId(bl, pSDEFVRType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFVRTypeName(bl, pSDEFVRType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEFVRType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_IconPath(boolean bl, PSDEFVRType pSDEFVRType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRType.isIconPathDirty() : !pSDEFVRType.isIconPathDirty()) {
            return null;
        }
        String string = pSDEFVRType.getIconPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconPath_Default(pSDEFVRType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEFVRType pSDEFVRType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRType.isMemoDirty() : !pSDEFVRType.isMemoDirty()) {
            return null;
        }
        String string = pSDEFVRType.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEFVRType, bl2, bl3);
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

    protected EntityFieldError onCheckField_ProcessObj(boolean bl, PSDEFVRType pSDEFVRType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRType.isProcessObjDirty() && !bl2 : !pSDEFVRType.isProcessObjDirty()) {
            return null;
        }
        String string = pSDEFVRType.getProcessObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROCESSOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ProcessObj_Default(pSDEFVRType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROCESSOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFVRTypeId(boolean bl, PSDEFVRType pSDEFVRType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRType.isPSDEFVRTypeIdDirty() && !bl2 : !pSDEFVRType.isPSDEFVRTypeIdDirty()) {
            return null;
        }
        String string = pSDEFVRType.getPSDEFVRTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFVRTypeId_Default(pSDEFVRType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFVRTypeName(boolean bl, PSDEFVRType pSDEFVRType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFVRType.isPSDEFVRTypeNameDirty() && !bl2 : !pSDEFVRType.isPSDEFVRTypeNameDirty()) {
            return null;
        }
        String string = pSDEFVRType.getPSDEFVRTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRTYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFVRTypeName_Default(pSDEFVRType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEFVRType pSDEFVRType, boolean bl) throws Exception {
        super.onSyncEntity(pSDEFVRType, bl);
    }

    protected void onSyncIndexEntities(PSDEFVRType pSDEFVRType, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEFVRType, bl);
    }

    public Object getDataContextValue(PSDEFVRType pSDEFVRType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEFVRType, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEFVRType pSDEFVRType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEFVRType, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROCESSOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ProcessObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVRTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFVRTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVRTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFVRTypeName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_IconPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected String onTestValueRule_ProcessObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROCESSOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFVRTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVRTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFVRTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVRTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDEFVRType pSDEFVRType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEFVRType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEFVRType pSDEFVRType) throws Exception {
        super.onUpdateParent(pSDEFVRType);
    }

    @Override
    protected void exportCurXmlModel(PSDEFVRType pSDEFVRType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEFVRTYPE");
        if (!bl) {
            pSDEFVRType.setCreateDate(null);
            pSDEFVRType.setCreateMan(null);
            pSDEFVRType.setUpdateDate(null);
            pSDEFVRType.setUpdateMan(null);
            super.exportCurXmlModel(pSDEFVRType, xmlNode, bl);
        }
    }
}

