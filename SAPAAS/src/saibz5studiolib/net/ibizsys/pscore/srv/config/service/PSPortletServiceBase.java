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
package net.ibizsys.pscore.srv.config.service;

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
import net.ibizsys.pscore.srv.config.dao.PSPortletDAO;
import net.ibizsys.pscore.srv.config.demodel.PSPortletDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSPFPluginBase;
import net.ibizsys.pscore.srv.config.entity.PSPortlet;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPortletServiceBase
extends PSCoreSysServiceBase<PSPortlet> {
    private static final Log log = LogFactory.getLog(PSPortletServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPortletDEModel pSPortletDEModel;
    private PSPortletDAO pSPortletDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSPortletService";
    }

    public PSPortletDEModel getPSPortletDEModel() {
        if (this.pSPortletDEModel == null) {
            try {
                this.pSPortletDEModel = (PSPortletDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPortletDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPortletDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPortletDEModel();
    }

    public PSPortletDAO getPSPortletDAO() {
        if (this.pSPortletDAO == null) {
            try {
                this.pSPortletDAO = (PSPortletDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSPortletDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPortletDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPortletDAO();
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

    protected void onFillParentInfo(PSPortlet pSPortlet, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPORTLET_PSPFPLUGIN_PSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPluginService", (SessionFactory)this.getSessionFactory());
            PSPFPlugin pSPFPlugin = (PSPFPlugin)iService.getDEModel().createEntity();
            pSPFPlugin.set("PSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFPlugin);
            } else {
                iService.get(pSPFPlugin);
            }
            this.onFillParentInfo_PSPFPlugin(pSPortlet, pSPFPlugin);
            return;
        }
        super.onFillParentInfo(pSPortlet, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSPFPlugin(PSPortlet pSPortlet, PSPFPlugin pSPFPlugin) throws Exception {
        pSPortlet.setPSPFPluginId(pSPFPlugin.getPSPFPluginId());
        pSPortlet.setPSPFPluginName(pSPFPlugin.getPSPFPluginName());
    }

    protected void onFillEntityFullInfo(PSPortlet pSPortlet, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSPortlet, bl);
        this.onFillEntityFullInfo_PSPFPlugin(pSPortlet, bl);
    }

    protected void onFillEntityFullInfo_PSPFPlugin(PSPortlet pSPortlet, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSPortlet pSPortlet, boolean bl) throws Exception {
        super.onWriteBackParent(pSPortlet, bl);
    }

    public ArrayList<PSPortlet> selectByPSPFPlugin(PSPFPluginBase pSPFPluginBase) throws Exception {
        return this.selectByPSPFPlugin(pSPFPluginBase, "", -1);
    }

    public ArrayList<PSPortlet> selectByPSPFPlugin(PSPFPluginBase pSPFPluginBase, String string) throws Exception {
        return this.selectByPSPFPlugin(pSPFPluginBase, string, -1);
    }

    public ArrayList<PSPortlet> selectByPSPFPlugin(PSPFPluginBase pSPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFPLUGINID", (Object)pSPFPluginBase.getPSPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
    }

    public void resetPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
        ArrayList<PSPortlet> arrayList = this.selectByPSPFPlugin(pSPFPlugin);
        for (PSPortlet pSPortlet : arrayList) {
            PSPortlet pSPortlet2 = (PSPortlet)this.getDEModel().createEntity();
            pSPortlet2.setPSPortletId(pSPortlet.getPSPortletId());
            pSPortlet2.setPSPFPluginId(null);
            this.update(pSPortlet2);
        }
    }

    public void removeByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
        final PSPFPlugin pSPFPlugin2 = pSPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPortletServiceBase.this.onBeforeRemoveByPSPFPlugin(pSPFPlugin2);
                PSPortletServiceBase.this.internalRemoveByPSPFPlugin(pSPFPlugin2);
                PSPortletServiceBase.this.onAfterRemoveByPSPFPlugin(pSPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
        ArrayList<PSPortlet> arrayList = this.selectByPSPFPlugin(pSPFPlugin);
        this.onBeforeRemoveByPSPFPlugin(pSPFPlugin, arrayList);
        for (PSPortlet pSPortlet : arrayList) {
            this.remove(pSPortlet);
        }
        this.onAfterRemoveByPSPFPlugin(pSPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin, ArrayList<PSPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin, ArrayList<PSPortlet> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPortlet pSPortlet) throws Exception {
        PSSysPortletService pSSysPortletService = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        pSSysPortletService.testRemoveByPSPortlet(pSPortlet);
        super.onBeforeRemove(pSPortlet);
    }

    protected void replaceParentInfo(PSPortlet pSPortlet, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSPortlet, cloneSession);
        if (pSPortlet.getPSPFPluginId() != null && (iEntity = cloneSession.getEntity("PSPFPLUGIN", (Object)pSPortlet.getPSPFPluginId())) != null) {
            this.onFillParentInfo_PSPFPlugin(pSPortlet, (PSPFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPortlet pSPortlet, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSPortlet, bl);
    }

    protected void onCheckEntity(boolean bl, PSPortlet pSPortlet, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BaseClsParams(bl, pSPortlet, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PortletType(bl, pSPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPluginId(bl, pSPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPortletId(bl, pSPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPortletName(bl, pSPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSPortlet, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BaseClsParams(boolean bl, PSPortlet pSPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPortlet.isBaseClsParamsDirty() : !pSPortlet.isBaseClsParamsDirty()) {
            return null;
        }
        String string = pSPortlet.getBaseClsParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BaseClsParams_Default(pSPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BASECLSPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSPortlet pSPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPortlet.isCodeNameDirty() && !bl2 : !pSPortlet.isCodeNameDirty()) {
            return null;
        }
        String string = pSPortlet.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPortlet pSPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPortlet.isMemoDirty() : !pSPortlet.isMemoDirty()) {
            return null;
        }
        String string = pSPortlet.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PortletType(boolean bl, PSPortlet pSPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPortlet.isPortletTypeDirty() && !bl2 : !pSPortlet.isPortletTypeDirty()) {
            return null;
        }
        String string = pSPortlet.getPortletType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PORTLETTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PortletType_Default(pSPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PORTLETTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPluginId(boolean bl, PSPortlet pSPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPortlet.isPSPFPluginIdDirty() && !bl2 : !pSPortlet.isPSPFPluginIdDirty()) {
            return null;
        }
        String string = pSPortlet.getPSPFPluginId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPLUGINID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPluginId_Default(pSPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPortletId(boolean bl, PSPortlet pSPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPortlet.isPSPortletIdDirty() && !bl2 : !pSPortlet.isPSPortletIdDirty()) {
            return null;
        }
        String string = pSPortlet.getPSPortletId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPORTLETID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPortletId_Default(pSPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPORTLETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPortletName(boolean bl, PSPortlet pSPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPortlet.isPSPortletNameDirty() && !bl2 : !pSPortlet.isPSPortletNameDirty()) {
            return null;
        }
        String string = pSPortlet.getPSPortletName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPORTLETNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPortletName_Default(pSPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPORTLETNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSPortlet pSPortlet, boolean bl) throws Exception {
        super.onSyncEntity(pSPortlet, bl);
    }

    protected void onSyncIndexEntities(PSPortlet pSPortlet, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSPortlet, bl);
    }

    public Object getDataContextValue(PSPortlet pSPortlet, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSPortlet, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSPortlet pSPortlet, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSPortlet, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BASECLSPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BaseClsParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PORTLETTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PortletType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPORTLETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPortletId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPORTLETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPortletName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BaseClsParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BASECLSPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PortletType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PORTLETTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPortletId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPORTLETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPortletName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPORTLETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSPortlet pSPortlet) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSPortlet)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPortlet pSPortlet) throws Exception {
        super.onUpdateParent(pSPortlet);
    }

    @Override
    protected void exportCurXmlModel(PSPortlet pSPortlet, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPORTLET");
        if (!bl) {
            super.exportCurXmlModel(pSPortlet, xmlNode, bl);
        }
    }
}

