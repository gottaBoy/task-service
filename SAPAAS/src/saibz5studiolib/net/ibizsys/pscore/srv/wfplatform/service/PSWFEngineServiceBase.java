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
import net.ibizsys.pscore.srv.wfplatform.dao.PSWFEngineDAO;
import net.ibizsys.pscore.srv.wfplatform.demodel.PSWFEngineDEModel;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWFEngine;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPEngineInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFEngineServiceBase
extends PSCoreSysServiceBase<PSWFEngine> {
    private static final Log log = LogFactory.getLog(PSWFEngineServiceBase.class);
    private PSWFEngineDEModel pSWFEngineDEModel;
    private PSWFEngineDAO pSWFEngineDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfplatform.service.PSWFEngineService";
    }

    public PSWFEngineDEModel getPSWFEngineDEModel() {
        if (this.pSWFEngineDEModel == null) {
            try {
                this.pSWFEngineDEModel = (PSWFEngineDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfplatform.demodel.PSWFEngineDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFEngineDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWFEngineDEModel();
    }

    public PSWFEngineDAO getPSWFEngineDAO() {
        if (this.pSWFEngineDAO == null) {
            try {
                this.pSWFEngineDAO = (PSWFEngineDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfplatform.dao.PSWFEngineDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFEngineDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWFEngineDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    protected void onFillParentInfo(PSWFEngine pSWFEngine, String string, String string2, String string3) throws Exception {
        super.onFillParentInfo((IEntity)pSWFEngine, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillEntityFullInfo(PSWFEngine pSWFEngine, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSWFEngine, bl);
    }

    protected void onWriteBackParent(PSWFEngine pSWFEngine, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSWFEngine, bl);
    }

    @Override
    protected void onBeforeRemove(PSWFEngine pSWFEngine) throws Exception {
        PSWPEngineInstService pSWPEngineInstService = (PSWPEngineInstService)ServiceGlobal.getService(PSWPEngineInstService.class, (SessionFactory)this.getSessionFactory());
        pSWPEngineInstService.testRemoveByPSWPEngine(pSWFEngine);
        super.onBeforeRemove(pSWFEngine);
    }

    protected void onRemoveEntityUncopyValues(PSWFEngine pSWFEngine, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSWFEngine, bl);
    }

    protected void onCheckEntity(boolean bl, PSWFEngine pSWFEngine, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSWPEngineId(bl, pSWFEngine, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWPEngineName(bl, pSWFEngine, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSWFEngine, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSWPEngineId(boolean bl, PSWFEngine pSWFEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFEngine.isPSWPEngineIdDirty() && !bl2 : !pSWFEngine.isPSWPEngineIdDirty()) {
            return null;
        }
        String string = pSWFEngine.getPSWPEngineId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPENGINEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPEngineId_Default((IEntity)pSWFEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPENGINEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWPEngineName(boolean bl, PSWFEngine pSWFEngine, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFEngine.isPSWPEngineNameDirty() && !bl2 : !pSWFEngine.isPSWPEngineNameDirty()) {
            return null;
        }
        String string = pSWFEngine.getPSWPEngineName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPENGINENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPEngineName_Default((IEntity)pSWFEngine, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPENGINENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWFEngine pSWFEngine, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSWFEngine, bl);
    }

    protected void onSyncIndexEntities(PSWFEngine pSWFEngine, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSWFEngine, bl);
    }

    public Object getDataContextValue(PSWFEngine pSWFEngine, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSWFEngine, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSWFEngine pSWFEngine, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSWFEngine, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPENGINEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSWPEngineId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPENGINENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSWPEngineName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSWPEngineId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPENGINEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPEngineName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPENGINENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSWFEngine pSWFEngine) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSWFEngine)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWFEngine pSWFEngine) throws Exception {
        super.onUpdateParent((IEntity)pSWFEngine);
    }

    @Override
    protected void exportCurXmlModel(PSWFEngine pSWFEngine, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWFENGINE");
        if (!bl) {
            pSWFEngine.setCreateDate(null);
            pSWFEngine.setCreateMan(null);
            pSWFEngine.setPSWPEngineId(null);
            pSWFEngine.setUpdateDate(null);
            pSWFEngine.setUpdateMan(null);
            super.exportCurXmlModel(pSWFEngine, xmlNode, bl);
        }
    }
}

