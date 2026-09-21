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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEDBObjSqlDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDBObjSqlDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDBObjSql;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDBObjSqlServiceBase
extends PSCoreSysServiceBase<PSDEDBObjSql> {
    private static final Log log = LogFactory.getLog(PSDEDBObjSqlServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEDBObjSqlDEModel pSDEDBObjSqlDEModel;
    private PSDEDBObjSqlDAO pSDEDBObjSqlDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEDBObjSqlService";
    }

    public PSDEDBObjSqlDEModel getPSDEDBObjSqlDEModel() {
        if (this.pSDEDBObjSqlDEModel == null) {
            try {
                this.pSDEDBObjSqlDEModel = (PSDEDBObjSqlDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDBObjSqlDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDBObjSqlDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEDBObjSqlDEModel();
    }

    public PSDEDBObjSqlDAO getPSDEDBObjSqlDAO() {
        if (this.pSDEDBObjSqlDAO == null) {
            try {
                this.pSDEDBObjSqlDAO = (PSDEDBObjSqlDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEDBObjSqlDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDBObjSqlDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEDBObjSqlDAO();
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

    protected void onFillParentInfo(PSDEDBObjSql pSDEDBObjSql, String string, String string2, String string3) throws Exception {
        super.onFillParentInfo((IEntity)pSDEDBObjSql, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillEntityFullInfo(PSDEDBObjSql pSDEDBObjSql, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDEDBObjSql, bl);
    }

    protected void onWriteBackParent(PSDEDBObjSql pSDEDBObjSql, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEDBObjSql, bl);
    }

    @Override
    protected void onBeforeRemove(PSDEDBObjSql pSDEDBObjSql) throws Exception {
        super.onBeforeRemove(pSDEDBObjSql);
    }

    protected void onRemoveEntityUncopyValues(PSDEDBObjSql pSDEDBObjSql, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEDBObjSql, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEDBObjSql pSDEDBObjSql, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSDEDBObjSqlId(bl, pSDEDBObjSql, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDBObjSqlName(bl, pSDEDBObjSql, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEDBObjSql, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSDEDBObjSqlId(boolean bl, PSDEDBObjSql pSDEDBObjSql, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBObjSql.isPSDEDBObjSqlIdDirty() && !bl2 : !pSDEDBObjSql.isPSDEDBObjSqlIdDirty()) {
            return null;
        }
        String string = pSDEDBObjSql.getPSDEDBObjSqlId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDBOBJSQLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDBObjSqlId_Default((IEntity)pSDEDBObjSql, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDBOBJSQLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDBObjSqlName(boolean bl, PSDEDBObjSql pSDEDBObjSql, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDBObjSql.isPSDEDBObjSqlNameDirty() && !bl2 : !pSDEDBObjSql.isPSDEDBObjSqlNameDirty()) {
            return null;
        }
        String string = pSDEDBObjSql.getPSDEDBObjSqlName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDBOBJSQLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDBObjSqlName_Default((IEntity)pSDEDBObjSql, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDBOBJSQLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEDBObjSql pSDEDBObjSql, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEDBObjSql, bl);
    }

    protected void onSyncIndexEntities(PSDEDBObjSql pSDEDBObjSql, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEDBObjSql, bl);
    }

    public Object getDataContextValue(PSDEDBObjSql pSDEDBObjSql, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEDBObjSql, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEDBObjSql pSDEDBObjSql, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEDBObjSql, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDBOBJSQLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDBObjSqlId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDBOBJSQLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDBObjSqlName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDEDBObjSqlId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDBOBJSQLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDBObjSqlName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDBOBJSQLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDEDBObjSql pSDEDBObjSql) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEDBObjSql)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEDBObjSql pSDEDBObjSql) throws Exception {
        super.onUpdateParent((IEntity)pSDEDBObjSql);
    }

    @Override
    protected void exportCurXmlModel(PSDEDBObjSql pSDEDBObjSql, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEDBOBJSQL");
        if (!bl) {
            pSDEDBObjSql.setCreateDate(null);
            pSDEDBObjSql.setCreateMan(null);
            pSDEDBObjSql.setPSDEDBObjSqlId(null);
            pSDEDBObjSql.setUpdateDate(null);
            pSDEDBObjSql.setUpdateMan(null);
            super.exportCurXmlModel(pSDEDBObjSql, xmlNode, bl);
        }
    }
}

