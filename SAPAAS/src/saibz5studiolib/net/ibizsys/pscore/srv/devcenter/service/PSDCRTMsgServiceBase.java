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
package net.ibizsys.pscore.srv.devcenter.service;

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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCRTMsgDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCRTMsgDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRTMsg;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCRTMsgServiceBase
extends PSCoreSysServiceBase<PSDCRTMsg> {
    private static final Log log = LogFactory.getLog(PSDCRTMsgServiceBase.class);
    private PSDCRTMsgDEModel pSDCRTMsgDEModel;
    private PSDCRTMsgDAO pSDCRTMsgDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCRTMsgService";
    }

    public PSDCRTMsgDEModel getPSDCRTMsgDEModel() {
        if (this.pSDCRTMsgDEModel == null) {
            try {
                this.pSDCRTMsgDEModel = (PSDCRTMsgDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCRTMsgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCRTMsgDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCRTMsgDEModel();
    }

    public PSDCRTMsgDAO getPSDCRTMsgDAO() {
        if (this.pSDCRTMsgDAO == null) {
            try {
                this.pSDCRTMsgDAO = (PSDCRTMsgDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCRTMsgDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCRTMsgDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCRTMsgDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    protected void onFillParentInfo(PSDCRTMsg pSDCRTMsg, String string, String string2, String string3) throws Exception {
        super.onFillParentInfo(pSDCRTMsg, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillEntityFullInfo(PSDCRTMsg pSDCRTMsg, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDCRTMsg, bl);
    }

    protected void onWriteBackParent(PSDCRTMsg pSDCRTMsg, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCRTMsg, bl);
    }

    @Override
    protected void onBeforeRemove(PSDCRTMsg pSDCRTMsg) throws Exception {
        super.onBeforeRemove(pSDCRTMsg);
    }

    protected void onRemoveEntityUncopyValues(PSDCRTMsg pSDCRTMsg, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCRTMsg, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCRTMsg pSDCRTMsg, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSDCRTMsgId(bl, pSDCRTMsg, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRTMsgName(bl, pSDCRTMsg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCRTMsg, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSDCRTMsgId(boolean bl, PSDCRTMsg pSDCRTMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRTMsg.isPSDCRTMsgIdDirty() && !bl2 : !pSDCRTMsg.isPSDCRTMsgIdDirty()) {
            return null;
        }
        String string = pSDCRTMsg.getPSDCRTMsgId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCRTMSGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRTMsgId_Default(pSDCRTMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCRTMSGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCRTMsgName(boolean bl, PSDCRTMsg pSDCRTMsg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRTMsg.isPSDCRTMsgNameDirty() && !bl2 : !pSDCRTMsg.isPSDCRTMsgNameDirty()) {
            return null;
        }
        String string = pSDCRTMsg.getPSDCRTMsgName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCRTMSGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRTMsgName_Default(pSDCRTMsg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCRTMSGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCRTMsg pSDCRTMsg, boolean bl) throws Exception {
        super.onSyncEntity(pSDCRTMsg, bl);
    }

    protected void onSyncIndexEntities(PSDCRTMsg pSDCRTMsg, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCRTMsg, bl);
    }

    public Object getDataContextValue(PSDCRTMsg pSDCRTMsg, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCRTMsg, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCRTMsg pSDCRTMsg, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCRTMsg, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCRTMSGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRTMsgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCRTMSGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRTMsgName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDCRTMsgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCRTMSGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCRTMsgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCRTMSGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDCRTMsg pSDCRTMsg) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCRTMsg)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCRTMsg pSDCRTMsg) throws Exception {
        super.onUpdateParent(pSDCRTMsg);
    }

    @Override
    protected void exportCurXmlModel(PSDCRTMsg pSDCRTMsg, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCRTMSG");
        if (!bl) {
            pSDCRTMsg.setCreateDate(null);
            pSDCRTMsg.setCreateMan(null);
            pSDCRTMsg.setPSDCRTMsgId(null);
            pSDCRTMsg.setUpdateDate(null);
            pSDCRTMsg.setUpdateMan(null);
            super.exportCurXmlModel(pSDCRTMsg, xmlNode, bl);
        }
    }
}

