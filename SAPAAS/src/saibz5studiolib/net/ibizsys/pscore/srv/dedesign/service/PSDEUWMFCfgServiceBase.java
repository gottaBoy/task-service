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
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEUWMFCfgDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEUWMFCfgDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUWMFCfg;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEUWMFCfgServiceBase
extends PSCoreSysServiceBase<PSDEUWMFCfg> {
    private static final Log log = LogFactory.getLog(PSDEUWMFCfgServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEUWMFCfgDEModel pSDEUWMFCfgDEModel;
    private PSDEUWMFCfgDAO pSDEUWMFCfgDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEUWMFCfgService";
    }

    public PSDEUWMFCfgDEModel getPSDEUWMFCfgDEModel() {
        if (this.pSDEUWMFCfgDEModel == null) {
            try {
                this.pSDEUWMFCfgDEModel = (PSDEUWMFCfgDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEUWMFCfgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEUWMFCfgDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEUWMFCfgDEModel();
    }

    public PSDEUWMFCfgDAO getPSDEUWMFCfgDAO() {
        if (this.pSDEUWMFCfgDAO == null) {
            try {
                this.pSDEUWMFCfgDAO = (PSDEUWMFCfgDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEUWMFCfgDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEUWMFCfgDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEUWMFCfgDAO();
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

    protected void onFillParentInfo(PSDEUWMFCfg pSDEUWMFCfg, String string, String string2, String string3) throws Exception {
        super.onFillParentInfo((IEntity)pSDEUWMFCfg, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillEntityFullInfo(PSDEUWMFCfg pSDEUWMFCfg, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDEUWMFCfg, bl);
    }

    protected void onWriteBackParent(PSDEUWMFCfg pSDEUWMFCfg, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEUWMFCfg, bl);
    }

    @Override
    protected void onBeforeRemove(PSDEUWMFCfg pSDEUWMFCfg) throws Exception {
        super.onBeforeRemove(pSDEUWMFCfg);
    }

    protected void onRemoveEntityUncopyValues(PSDEUWMFCfg pSDEUWMFCfg, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEUWMFCfg, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEUWMFCfg pSDEUWMFCfg, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_EnaMultiForm(bl, pSDEUWMFCfg, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDataEntityId(bl, pSDEUWMFCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDataEntityName(bl, pSDEUWMFCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEUWMFCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEUWMFCfg, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_EnaMultiForm(boolean bl, PSDEUWMFCfg pSDEUWMFCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUWMFCfg.isEnaMultiFormDirty() : !pSDEUWMFCfg.isEnaMultiFormDirty()) {
            return null;
        }
        Integer n = pSDEUWMFCfg.getEnaMultiForm();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnaMultiForm_Default((IEntity)pSDEUWMFCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENAMULTIFORM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDataEntityId(boolean bl, PSDEUWMFCfg pSDEUWMFCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUWMFCfg.isPSDataEntityIdDirty() && !bl2 : !pSDEUWMFCfg.isPSDataEntityIdDirty()) {
            return null;
        }
        String string = pSDEUWMFCfg.getPSDataEntityId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDATAENTITYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDataEntityId_Default((IEntity)pSDEUWMFCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDATAENTITYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDataEntityName(boolean bl, PSDEUWMFCfg pSDEUWMFCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUWMFCfg.isPSDataEntityNameDirty() && !bl2 : !pSDEUWMFCfg.isPSDataEntityNameDirty()) {
            return null;
        }
        String string = pSDEUWMFCfg.getPSDataEntityName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDATAENTITYNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDataEntityName_Default((IEntity)pSDEUWMFCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDATAENTITYNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEUWMFCfg pSDEUWMFCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUWMFCfg.isUserTagDirty() : !pSDEUWMFCfg.isUserTagDirty()) {
            return null;
        }
        String string = pSDEUWMFCfg.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEUWMFCfg, bl2, bl3);
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

    protected void onSyncEntity(PSDEUWMFCfg pSDEUWMFCfg, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEUWMFCfg, bl);
    }

    protected void onSyncIndexEntities(PSDEUWMFCfg pSDEUWMFCfg, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEUWMFCfg, bl);
    }

    public Object getDataContextValue(PSDEUWMFCfg pSDEUWMFCfg, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEUWMFCfg, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEUWMFCfg pSDEUWMFCfg, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEUWMFCfg, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ENAMULTIFORM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnaMultiForm_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDATAENTITYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDataEntityId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDATAENTITYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDataEntityName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_EnaMultiForm_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDataEntityId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDATAENTITYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDataEntityName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDATAENTITYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("PSDATAENTITYNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected boolean onMergeChild(String string, String string2, PSDEUWMFCfg pSDEUWMFCfg) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEUWMFCfg)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEUWMFCfg pSDEUWMFCfg) throws Exception {
        super.onUpdateParent((IEntity)pSDEUWMFCfg);
    }

    @Override
    protected void exportCurXmlModel(PSDEUWMFCfg pSDEUWMFCfg, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEUWMFCFG");
        if (!bl) {
            pSDEUWMFCfg.setPSDataEntityId(null);
            pSDEUWMFCfg.setUpdateDate(null);
            pSDEUWMFCfg.setUpdateMan(null);
            super.exportCurXmlModel(pSDEUWMFCfg, xmlNode, bl);
        }
    }
}

