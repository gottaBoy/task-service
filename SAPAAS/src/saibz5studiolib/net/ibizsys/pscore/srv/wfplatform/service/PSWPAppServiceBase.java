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
package net.ibizsys.pscore.srv.wfplatform.service;

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
import net.ibizsys.pscore.srv.wfplatform.dao.PSWPAppDAO;
import net.ibizsys.pscore.srv.wfplatform.demodel.PSWPAppDEModel;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPApp;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPAppEntityService;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPAppEntityServiceBase;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPAppInstService;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPAppInstServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWPAppServiceBase
extends PSCoreSysServiceBase<PSWPApp> {
    private static final Log log = LogFactory.getLog(PSWPAppServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSWPAppDEModel pSWPAppDEModel;
    private PSWPAppDAO pSWPAppDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfplatform.service.PSWPAppService";
    }

    public PSWPAppDEModel getPSWPAppDEModel() {
        if (this.pSWPAppDEModel == null) {
            try {
                this.pSWPAppDEModel = (PSWPAppDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfplatform.demodel.PSWPAppDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWPAppDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWPAppDEModel();
    }

    public PSWPAppDAO getPSWPAppDAO() {
        if (this.pSWPAppDAO == null) {
            try {
                this.pSWPAppDAO = (PSWPAppDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfplatform.dao.PSWPAppDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWPAppDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWPAppDAO();
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

    protected void onFillParentInfo(PSWPApp pSWPApp, String string, String string2, String string3) throws Exception {
        super.onFillParentInfo((IEntity)pSWPApp, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillEntityFullInfo(PSWPApp pSWPApp, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSWPApp, bl);
    }

    protected void onWriteBackParent(PSWPApp pSWPApp, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSWPApp, bl);
    }

    @Override
    protected void onBeforeRemove(PSWPApp pSWPApp) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSWPAppEntityService)ServiceGlobal.getService(PSWPAppEntityService.class, (SessionFactory)this.getSessionFactory());
        ((PSWPAppEntityServiceBase)pSCoreSysServiceBase).testRemoveByPSWPApp(pSWPApp);
        pSCoreSysServiceBase = (PSWPAppInstService)ServiceGlobal.getService(PSWPAppInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSWPAppInstServiceBase)pSCoreSysServiceBase).testRemoveByPSWPApp(pSWPApp);
        super.onBeforeRemove(pSWPApp);
    }

    protected void onRemoveEntityUncopyValues(PSWPApp pSWPApp, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSWPApp, bl);
    }

    protected void onCheckEntity(boolean bl, PSWPApp pSWPApp, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSWPAppId(bl, pSWPApp, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWPAppName(bl, pSWPApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSWPApp, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSWPAppId(boolean bl, PSWPApp pSWPApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPApp.isPSWPAppIdDirty() && !bl2 : !pSWPApp.isPSWPAppIdDirty()) {
            return null;
        }
        String string = pSWPApp.getPSWPAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPAppId_Default((IEntity)pSWPApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWPAppName(boolean bl, PSWPApp pSWPApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPApp.isPSWPAppNameDirty() && !bl2 : !pSWPApp.isPSWPAppNameDirty()) {
            return null;
        }
        String string = pSWPApp.getPSWPAppName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPAPPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPAppName_Default((IEntity)pSWPApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWPApp pSWPApp, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSWPApp, bl);
    }

    protected void onSyncIndexEntities(PSWPApp pSWPApp, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSWPApp, bl);
    }

    public Object getDataContextValue(PSWPApp pSWPApp, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSWPApp, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSWPApp pSWPApp, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSWPApp, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWPAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWPAppName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSWPAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSWPApp pSWPApp) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSWPApp)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWPApp pSWPApp) throws Exception {
        super.onUpdateParent((IEntity)pSWPApp);
    }

    @Override
    protected void exportCurXmlModel(PSWPApp pSWPApp, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWPAPP");
        if (!bl) {
            pSWPApp.setCreateDate(null);
            pSWPApp.setCreateMan(null);
            pSWPApp.setPSWPAppId(null);
            pSWPApp.setUpdateDate(null);
            pSWPApp.setUpdateMan(null);
            super.exportCurXmlModel(pSWPApp, xmlNode, bl);
        }
    }
}

