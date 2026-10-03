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
import net.ibizsys.pscore.srv.sysdevstudio.dao.PSDSSysAppBarFilterDAO;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDSSysAppBarFilterDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDSSysAppBarFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDSSysAppBarFilterServiceBase
extends PSCoreSysServiceBase<PSDSSysAppBarFilter> {
    private static final Log log = LogFactory.getLog(PSDSSysAppBarFilterServiceBase.class);
    private PSDSSysAppBarFilterDEModel pSDSSysAppBarFilterDEModel;
    private PSDSSysAppBarFilterDAO pSDSSysAppBarFilterDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.service.PSDSSysAppBarFilterService";
    }

    public PSDSSysAppBarFilterDEModel getPSDSSysAppBarFilterDEModel() {
        if (this.pSDSSysAppBarFilterDEModel == null) {
            try {
                this.pSDSSysAppBarFilterDEModel = (PSDSSysAppBarFilterDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDSSysAppBarFilterDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDSSysAppBarFilterDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDSSysAppBarFilterDEModel();
    }

    public PSDSSysAppBarFilterDAO getPSDSSysAppBarFilterDAO() {
        if (this.pSDSSysAppBarFilterDAO == null) {
            try {
                this.pSDSSysAppBarFilterDAO = (PSDSSysAppBarFilterDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdevstudio.dao.PSDSSysAppBarFilterDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDSSysAppBarFilterDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDSSysAppBarFilterDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    protected void onFillParentInfo(PSDSSysAppBarFilter pSDSSysAppBarFilter, String string, String string2, String string3) throws Exception {
        super.onFillParentInfo(pSDSSysAppBarFilter, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillEntityFullInfo(PSDSSysAppBarFilter pSDSSysAppBarFilter, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDSSysAppBarFilter, bl);
    }

    protected void onWriteBackParent(PSDSSysAppBarFilter pSDSSysAppBarFilter, boolean bl) throws Exception {
        super.onWriteBackParent(pSDSSysAppBarFilter, bl);
    }

    @Override
    protected void onBeforeRemove(PSDSSysAppBarFilter pSDSSysAppBarFilter) throws Exception {
        super.onBeforeRemove(pSDSSysAppBarFilter);
    }

    protected void onRemoveEntityUncopyValues(PSDSSysAppBarFilter pSDSSysAppBarFilter, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDSSysAppBarFilter, bl);
    }

    protected void onCheckEntity(boolean bl, PSDSSysAppBarFilter pSDSSysAppBarFilter, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSDSSysAppBarFilterId(bl, pSDSSysAppBarFilter, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDSSysAppBarFilterName(bl, pSDSSysAppBarFilter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDSSysAppBarId(bl, pSDSSysAppBarFilter, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDSSysAppBarFilter, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSDSSysAppBarFilterId(boolean bl, PSDSSysAppBarFilter pSDSSysAppBarFilter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSSysAppBarFilter.isPSDSSysAppBarFilterIdDirty() && !bl2 : !pSDSSysAppBarFilter.isPSDSSysAppBarFilterIdDirty()) {
            return null;
        }
        String string = pSDSSysAppBarFilter.getPSDSSysAppBarFilterId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSSYSAPPBARFILTERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDSSysAppBarFilterId_Default(pSDSSysAppBarFilter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSSYSAPPBARFILTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDSSysAppBarFilterName(boolean bl, PSDSSysAppBarFilter pSDSSysAppBarFilter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSSysAppBarFilter.isPSDSSysAppBarFilterNameDirty() && !bl2 : !pSDSSysAppBarFilter.isPSDSSysAppBarFilterNameDirty()) {
            return null;
        }
        String string = pSDSSysAppBarFilter.getPSDSSysAppBarFilterName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSSYSAPPBARFILTERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDSSysAppBarFilterName_Default(pSDSSysAppBarFilter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSSYSAPPBARFILTERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDSSysAppBarId(boolean bl, PSDSSysAppBarFilter pSDSSysAppBarFilter, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSSysAppBarFilter.isPSDSSysAppBarIdDirty() && !bl2 : !pSDSSysAppBarFilter.isPSDSSysAppBarIdDirty()) {
            return null;
        }
        String string = pSDSSysAppBarFilter.getPSDSSysAppBarId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSSYSAPPBARID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDSSysAppBarId_Default(pSDSSysAppBarFilter, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSSYSAPPBARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDSSysAppBarFilter pSDSSysAppBarFilter, boolean bl) throws Exception {
        super.onSyncEntity(pSDSSysAppBarFilter, bl);
    }

    protected void onSyncIndexEntities(PSDSSysAppBarFilter pSDSSysAppBarFilter, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDSSysAppBarFilter, bl);
    }

    public Object getDataContextValue(PSDSSysAppBarFilter pSDSSysAppBarFilter, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDSSysAppBarFilter, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDSSysAppBarFilter pSDSSysAppBarFilter, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDSSysAppBarFilter, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDSSYSAPPBARFILTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDSSysAppBarFilterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDSSYSAPPBARFILTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDSSysAppBarFilterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDSSYSAPPBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDSSysAppBarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
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

    protected String onTestValueRule_PSDSSysAppBarFilterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDSSYSAPPBARFILTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDSSysAppBarFilterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDSSYSAPPBARFILTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDSSysAppBarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDSSYSAPPBARID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected boolean onMergeChild(String string, String string2, PSDSSysAppBarFilter pSDSSysAppBarFilter) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDSSysAppBarFilter)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDSSysAppBarFilter pSDSSysAppBarFilter) throws Exception {
        super.onUpdateParent(pSDSSysAppBarFilter);
    }

    @Override
    protected void exportCurXmlModel(PSDSSysAppBarFilter pSDSSysAppBarFilter, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDSSYSAPPBARFILTER");
        if (!bl) {
            pSDSSysAppBarFilter.setCreateDate(null);
            pSDSSysAppBarFilter.setCreateMan(null);
            pSDSSysAppBarFilter.setPSDSSysAppBarFilterId(null);
            pSDSSysAppBarFilter.setUpdateDate(null);
            pSDSSysAppBarFilter.setUpdateMan(null);
            super.exportCurXmlModel(pSDSSysAppBarFilter, xmlNode, bl);
        }
    }
}

