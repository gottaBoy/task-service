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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdSepcPlanXXXXDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdSepcPlanXXXXDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSepcPlanXXXX;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdSepcPlanXXXXServiceBase
extends PSCoreSysServiceBase<PSDevPrdSepcPlanXXXX> {
    private static final Log log = LogFactory.getLog(PSDevPrdSepcPlanXXXXServiceBase.class);
    private PSDevPrdSepcPlanXXXXDEModel pSDevPrdSepcPlanXXXXDEModel;
    private PSDevPrdSepcPlanXXXXDAO pSDevPrdSepcPlanXXXXDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSepcPlanXXXXService";
    }

    public PSDevPrdSepcPlanXXXXDEModel getPSDevPrdSepcPlanXXXXDEModel() {
        if (this.pSDevPrdSepcPlanXXXXDEModel == null) {
            try {
                this.pSDevPrdSepcPlanXXXXDEModel = (PSDevPrdSepcPlanXXXXDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdSepcPlanXXXXDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdSepcPlanXXXXDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevPrdSepcPlanXXXXDEModel();
    }

    public PSDevPrdSepcPlanXXXXDAO getPSDevPrdSepcPlanXXXXDAO() {
        if (this.pSDevPrdSepcPlanXXXXDAO == null) {
            try {
                this.pSDevPrdSepcPlanXXXXDAO = (PSDevPrdSepcPlanXXXXDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdSepcPlanXXXXDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdSepcPlanXXXXDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevPrdSepcPlanXXXXDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    protected void onFillParentInfo(PSDevPrdSepcPlanXXXX pSDevPrdSepcPlanXXXX, String string, String string2, String string3) throws Exception {
        super.onFillParentInfo((IEntity)pSDevPrdSepcPlanXXXX, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillEntityFullInfo(PSDevPrdSepcPlanXXXX pSDevPrdSepcPlanXXXX, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDevPrdSepcPlanXXXX, bl);
    }

    protected void onWriteBackParent(PSDevPrdSepcPlanXXXX pSDevPrdSepcPlanXXXX, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDevPrdSepcPlanXXXX, bl);
    }

    @Override
    protected void onBeforeRemove(PSDevPrdSepcPlanXXXX pSDevPrdSepcPlanXXXX) throws Exception {
        super.onBeforeRemove(pSDevPrdSepcPlanXXXX);
    }

    protected void onRemoveEntityUncopyValues(PSDevPrdSepcPlanXXXX pSDevPrdSepcPlanXXXX, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDevPrdSepcPlanXXXX, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevPrdSepcPlanXXXX pSDevPrdSepcPlanXXXX, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDevPrdSepcPlanXXXX, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDevPrdSepcPlanXXXX, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PlanState(bl, pSDevPrdSepcPlanXXXX, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdSepcPlanId(bl, pSDevPrdSepcPlanXXXX, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdSepcPlanName(bl, pSDevPrdSepcPlanXXXX, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDevPrdSepcPlanXXXX, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevPrdSepcPlanXXXX pSDevPrdSepcPlanXXXX, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSepcPlanXXXX.isMemoDirty() : !pSDevPrdSepcPlanXXXX.isMemoDirty()) {
            return null;
        }
        String string = pSDevPrdSepcPlanXXXX.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDevPrdSepcPlanXXXX, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDevPrdSepcPlanXXXX pSDevPrdSepcPlanXXXX, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSepcPlanXXXX.isOrderValueDirty() : !pSDevPrdSepcPlanXXXX.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDevPrdSepcPlanXXXX.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDevPrdSepcPlanXXXX, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PlanState(boolean bl, PSDevPrdSepcPlanXXXX pSDevPrdSepcPlanXXXX, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSepcPlanXXXX.isPlanStateDirty() : !pSDevPrdSepcPlanXXXX.isPlanStateDirty()) {
            return null;
        }
        Integer n = pSDevPrdSepcPlanXXXX.getPlanState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PlanState_Default((IEntity)pSDevPrdSepcPlanXXXX, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLANSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdSepcPlanId(boolean bl, PSDevPrdSepcPlanXXXX pSDevPrdSepcPlanXXXX, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSepcPlanXXXX.isPSDevPrdSepcPlanIdDirty() && !bl2 : !pSDevPrdSepcPlanXXXX.isPSDevPrdSepcPlanIdDirty()) {
            return null;
        }
        String string = pSDevPrdSepcPlanXXXX.getPSDevPrdSepcPlanId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSEPCPLANID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdSepcPlanId_Default((IEntity)pSDevPrdSepcPlanXXXX, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSEPCPLANID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdSepcPlanName(boolean bl, PSDevPrdSepcPlanXXXX pSDevPrdSepcPlanXXXX, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSepcPlanXXXX.isPSDevPrdSepcPlanNameDirty() && !bl2 : !pSDevPrdSepcPlanXXXX.isPSDevPrdSepcPlanNameDirty()) {
            return null;
        }
        String string = pSDevPrdSepcPlanXXXX.getPSDevPrdSepcPlanName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSEPCPLANNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdSepcPlanName_Default((IEntity)pSDevPrdSepcPlanXXXX, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSEPCPLANNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevPrdSepcPlanXXXX pSDevPrdSepcPlanXXXX, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDevPrdSepcPlanXXXX, bl);
    }

    protected void onSyncIndexEntities(PSDevPrdSepcPlanXXXX pSDevPrdSepcPlanXXXX, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDevPrdSepcPlanXXXX, bl);
    }

    public Object getDataContextValue(PSDevPrdSepcPlanXXXX pSDevPrdSepcPlanXXXX, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDevPrdSepcPlanXXXX, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDevPrdSepcPlanXXXX pSDevPrdSepcPlanXXXX, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDevPrdSepcPlanXXXX, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLANSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PlanState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDSEPCPLANID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdSepcPlanId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDSEPCPLANNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdSepcPlanName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PlanState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDevPrdSepcPlanId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDSEPCPLANID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdSepcPlanName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDSEPCPLANNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDevPrdSepcPlanXXXX pSDevPrdSepcPlanXXXX) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDevPrdSepcPlanXXXX)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevPrdSepcPlanXXXX pSDevPrdSepcPlanXXXX) throws Exception {
        super.onUpdateParent((IEntity)pSDevPrdSepcPlanXXXX);
    }

    @Override
    protected void exportCurXmlModel(PSDevPrdSepcPlanXXXX pSDevPrdSepcPlanXXXX, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVPRDSEPCPLANXXXX");
        if (!bl) {
            pSDevPrdSepcPlanXXXX.setCreateDate(null);
            pSDevPrdSepcPlanXXXX.setCreateMan(null);
            pSDevPrdSepcPlanXXXX.setPSDevPrdSepcPlanId(null);
            pSDevPrdSepcPlanXXXX.setUpdateDate(null);
            pSDevPrdSepcPlanXXXX.setUpdateMan(null);
            super.exportCurXmlModel(pSDevPrdSepcPlanXXXX, xmlNode, bl);
        }
    }
}

