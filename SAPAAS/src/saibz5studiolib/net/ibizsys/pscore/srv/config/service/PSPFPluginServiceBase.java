/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
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
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
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
import net.ibizsys.pscore.srv.config.dao.PSPFPluginDAO;
import net.ibizsys.pscore.srv.config.demodel.PSPFPluginDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSPFPluginTempl;
import net.ibizsys.pscore.srv.config.service.PSPFPluginTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFPluginTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPortletService;
import net.ibizsys.pscore.srv.config.service.PSPortletServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPredefinedTypeService;
import net.ibizsys.pscore.srv.config.service.PSPredefinedTypeServiceBase;
import net.ibizsys.pscore.srv.config.service.PSViewStyleService;
import net.ibizsys.pscore.srv.config.service.PSViewStyleServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFPluginServiceBase
extends PSCoreSysServiceBase<PSPFPlugin> {
    private static final Log log = LogFactory.getLog(PSPFPluginServiceBase.class);
    public static final String DATASET_CURDCALLVALID = "CurDCAllValid";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPFPluginDEModel pSPFPluginDEModel;
    private PSPFPluginDAO pSPFPluginDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSPFPluginService";
    }

    public PSPFPluginDEModel getPSPFPluginDEModel() {
        if (this.pSPFPluginDEModel == null) {
            try {
                this.pSPFPluginDEModel = (PSPFPluginDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFPluginDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFPluginDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPFPluginDEModel();
    }

    public PSPFPluginDAO getPSPFPluginDAO() {
        if (this.pSPFPluginDAO == null) {
            try {
                this.pSPFPluginDAO = (PSPFPluginDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSPFPluginDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFPluginDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPFPluginDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDCALLVALID, (boolean)true) == 0) {
            return this.fetchCurDCAllValid(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDCAllValid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCALLVALID, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSPFPlugin pSPFPlugin, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFPLUGIN_PSDEVCENTER_PSDCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenter);
            } else {
                iService.get((IEntity)pSDevCenter);
            }
            this.onFillParentInfo_PSDC(pSPFPlugin, pSDevCenter);
            return;
        }
        super.onFillParentInfo((IEntity)pSPFPlugin, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDC(PSPFPlugin pSPFPlugin, PSDevCenter pSDevCenter) throws Exception {
        pSPFPlugin.setPSDCId(pSDevCenter.getPSDevCenterId());
        pSPFPlugin.setPSDCName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillEntityFullInfo(PSPFPlugin pSPFPlugin, boolean bl) throws Exception {
        if (bl && pSPFPlugin.getValidFlag() == null) {
            pSPFPlugin.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSPFPlugin, bl);
        this.onFillEntityFullInfo_PSDC(pSPFPlugin, bl);
    }

    protected void onFillEntityFullInfo_PSDC(PSPFPlugin pSPFPlugin, boolean bl) throws Exception {
        if (pSPFPlugin.isPSDCIdDirty()) {
            if (pSPFPlugin.getPSDCId() != null) {
                if (pSPFPlugin.getPSDCId() == null || pSPFPlugin.getPSDCName() == null) {
                    PSDevCenter pSDevCenter = pSPFPlugin.getPSDC();
                    pSPFPlugin.setPSDCName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSPFPlugin.setPSDCName(null);
            }
        }
    }

    protected void onWriteBackParent(PSPFPlugin pSPFPlugin, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSPFPlugin, bl);
    }

    public ArrayList<PSPFPlugin> selectByPSDC(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDC(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSPFPlugin> selectByPSDC(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDC(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSPFPlugin> selectByPSDC(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDC(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSPFPlugin> arrayList = this.selectByPSDC(pSDevCenter);
        for (PSPFPlugin pSPFPlugin : arrayList) {
            PSPFPlugin pSPFPlugin2 = (PSPFPlugin)this.getDEModel().createEntity();
            pSPFPlugin2.setPSPFPluginId(pSPFPlugin.getPSPFPluginId());
            pSPFPlugin2.setPSDCId(null);
            this.update(pSPFPlugin2);
        }
    }

    public void removeByPSDC(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFPluginServiceBase.this.onBeforeRemoveByPSDC(pSDevCenter2);
                PSPFPluginServiceBase.this.internalRemoveByPSDC(pSDevCenter2);
                PSPFPluginServiceBase.this.onAfterRemoveByPSDC(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSPFPlugin> arrayList = this.selectByPSDC(pSDevCenter);
        this.onBeforeRemoveByPSDC(pSDevCenter, arrayList);
        for (PSPFPlugin pSPFPlugin : arrayList) {
            this.remove((IEntity)pSPFPlugin);
        }
        this.onAfterRemoveByPSDC(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDC(PSDevCenter pSDevCenter, ArrayList<PSPFPlugin> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDC(PSDevCenter pSDevCenter, ArrayList<PSPFPlugin> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPFPlugin pSPFPlugin) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSPFPluginTemplService)ServiceGlobal.getService(PSPFPluginTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFPluginTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPFPlugin(pSPFPlugin);
        ((PSPFPluginTemplServiceBase)pSCoreSysServiceBase).removeByPSPFPlugin(pSPFPlugin);
        pSCoreSysServiceBase = (PSPortletService)ServiceGlobal.getService(PSPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSPortletServiceBase)pSCoreSysServiceBase).testRemoveByPSPFPlugin(pSPFPlugin);
        ((PSPortletServiceBase)pSCoreSysServiceBase).resetPSPFPlugin(pSPFPlugin);
        pSCoreSysServiceBase = (PSPredefinedTypeService)ServiceGlobal.getService(PSPredefinedTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSPredefinedTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSPFPlugin(pSPFPlugin);
        pSCoreSysServiceBase = (PSViewStyleService)ServiceGlobal.getService(PSViewStyleService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewStyleServiceBase)pSCoreSysServiceBase).testRemoveByPSPFPlugin(pSPFPlugin);
        super.onBeforeRemove(pSPFPlugin);
    }

    protected void replaceParentInfo(PSPFPlugin pSPFPlugin, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSPFPlugin, cloneSession);
        if (pSPFPlugin.getPSDCId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSPFPlugin.getPSDCId())) != null) {
            this.onFillParentInfo_PSDC(pSPFPlugin, (PSDevCenter)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPFPlugin pSPFPlugin, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSPFPlugin, bl);
    }

    protected void onCheckEntity(boolean bl, PSPFPlugin pSPFPlugin, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllDCFlag(bl, pSPFPlugin, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BaseClsParams(bl, pSPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Keywords(bl, pSPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PluginDesc(bl, pSPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PluginType(bl, pSPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreviewHtml(bl, pSPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreviewPSNDFileId(bl, pSPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreviewUrl(bl, pSPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCId(bl, pSPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCName(bl, pSPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPluginId(bl, pSPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPluginName(bl, pSPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RTObjectMode(bl, pSPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RTObjectName(bl, pSPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RTObjectRepo(bl, pSPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StudioIcon(bl, pSPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSPFPlugin, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSPFPlugin, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllDCFlag(boolean bl, PSPFPlugin pSPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPlugin.isAllDCFlagDirty() && !bl2 : !pSPFPlugin.isAllDCFlagDirty()) {
            return null;
        }
        Integer n = pSPFPlugin.getAllDCFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLDCFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_AllDCFlag_Default((IEntity)pSPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLDCFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BaseClsParams(boolean bl, PSPFPlugin pSPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPlugin.isBaseClsParamsDirty() : !pSPFPlugin.isBaseClsParamsDirty()) {
            return null;
        }
        String string = pSPFPlugin.getBaseClsParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BaseClsParams_Default((IEntity)pSPFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_Keywords(boolean bl, PSPFPlugin pSPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPlugin.isKeywordsDirty() : !pSPFPlugin.isKeywordsDirty()) {
            return null;
        }
        String string = pSPFPlugin.getKeywords();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Keywords_Default((IEntity)pSPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KEYWORDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPFPlugin pSPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPlugin.isMemoDirty() : !pSPFPlugin.isMemoDirty()) {
            return null;
        }
        String string = pSPFPlugin.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSPFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_PluginDesc(boolean bl, PSPFPlugin pSPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPlugin.isPluginDescDirty() : !pSPFPlugin.isPluginDescDirty()) {
            return null;
        }
        String string = pSPFPlugin.getPluginDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PluginDesc_Default((IEntity)pSPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLUGINDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PluginType(boolean bl, PSPFPlugin pSPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPlugin.isPluginTypeDirty() && !bl2 : !pSPFPlugin.isPluginTypeDirty()) {
            return null;
        }
        String string = pSPFPlugin.getPluginType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLUGINTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PluginType_Default((IEntity)pSPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLUGINTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PreviewHtml(boolean bl, PSPFPlugin pSPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPlugin.isPreviewHtmlDirty() : !pSPFPlugin.isPreviewHtmlDirty()) {
            return null;
        }
        String string = pSPFPlugin.getPreviewHtml();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PreviewHtml_Default((IEntity)pSPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVIEWHTML");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PreviewPSNDFileId(boolean bl, PSPFPlugin pSPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPlugin.isPreviewPSNDFileIdDirty() : !pSPFPlugin.isPreviewPSNDFileIdDirty()) {
            return null;
        }
        String string = pSPFPlugin.getPreviewPSNDFileId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PreviewPSNDFileId_Default((IEntity)pSPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVIEWPSNDFILEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PreviewUrl(boolean bl, PSPFPlugin pSPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPlugin.isPreviewUrlDirty() : !pSPFPlugin.isPreviewUrlDirty()) {
            return null;
        }
        String string = pSPFPlugin.getPreviewUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PreviewUrl_Default((IEntity)pSPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVIEWURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCId(boolean bl, PSPFPlugin pSPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPlugin.isPSDCIdDirty() : !pSPFPlugin.isPSDCIdDirty()) {
            return null;
        }
        String string = pSPFPlugin.getPSDCId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCId_Default((IEntity)pSPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCName(boolean bl, PSPFPlugin pSPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPlugin.isPSDCNameDirty() : !pSPFPlugin.isPSDCNameDirty()) {
            return null;
        }
        String string = pSPFPlugin.getPSDCName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCName_Default((IEntity)pSPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPluginId(boolean bl, PSPFPlugin pSPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPlugin.isPSPFPluginIdDirty() && !bl2 : !pSPFPlugin.isPSPFPluginIdDirty()) {
            return null;
        }
        String string = pSPFPlugin.getPSPFPluginId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPLUGINID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPluginId_Default((IEntity)pSPFPlugin, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFPluginName(boolean bl, PSPFPlugin pSPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPlugin.isPSPFPluginNameDirty() && !bl2 : !pSPFPlugin.isPSPFPluginNameDirty()) {
            return null;
        }
        String string = pSPFPlugin.getPSPFPluginName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPLUGINNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPluginName_Default((IEntity)pSPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPLUGINNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RTObjectMode(boolean bl, PSPFPlugin pSPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPlugin.isRTObjectModeDirty() : !pSPFPlugin.isRTObjectModeDirty()) {
            return null;
        }
        Integer n = pSPFPlugin.getRTObjectMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RTObjectMode_Default((IEntity)pSPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RTOBJECTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RTObjectName(boolean bl, PSPFPlugin pSPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPlugin.isRTObjectNameDirty() : !pSPFPlugin.isRTObjectNameDirty()) {
            return null;
        }
        String string = pSPFPlugin.getRTObjectName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RTObjectName_Default((IEntity)pSPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RTOBJECTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RTObjectRepo(boolean bl, PSPFPlugin pSPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPlugin.isRTObjectRepoDirty() : !pSPFPlugin.isRTObjectRepoDirty()) {
            return null;
        }
        String string = pSPFPlugin.getRTObjectRepo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RTObjectRepo_Default((IEntity)pSPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RTOBJECTREPO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StudioIcon(boolean bl, PSPFPlugin pSPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPlugin.isStudioIconDirty() : !pSPFPlugin.isStudioIconDirty()) {
            return null;
        }
        String string = pSPFPlugin.getStudioIcon();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StudioIcon_Default((IEntity)pSPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STUDIOICON");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSPFPlugin pSPFPlugin, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPlugin.isValidFlagDirty() && !bl2 : !pSPFPlugin.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSPFPlugin.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSPFPlugin, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSPFPlugin pSPFPlugin, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSPFPlugin, bl);
    }

    protected void onSyncIndexEntities(PSPFPlugin pSPFPlugin, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSPFPlugin, bl);
    }

    public Object getDataContextValue(PSPFPlugin pSPFPlugin, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSPFPlugin, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportRelatedModel(PSPFPlugin pSPFPlugin, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSPFPluginTempl_PSPFPlugin(pSPFPlugin, arrayList, n);
        super.onExportRelatedModel((IEntity)pSPFPlugin, arrayList, n);
    }

    protected void onExportRelatedModel_PSPFPluginTempl_PSPFPlugin(PSPFPlugin pSPFPlugin, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSPFPluginTemplService pSPFPluginTemplService = (PSPFPluginTemplService)ServiceGlobal.getService(PSPFPluginTemplService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPFPluginTempl> arrayList2 = pSPFPluginTemplService.selectByPSPFPlugin(pSPFPlugin);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"758d283f48d3ee39244fc105a4b95a73");
            jSONObject.put("srfdename", (Object)"PSPFPLUGINTEMPL");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSPFPLUGINTEMPL_PSPFPLUGIN_PSPFPLUGINID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSPFPlugin, (String)"PSPFPLUGINID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSPFPluginTempl pSPFPluginTempl : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSPFPluginTempl, (String)"srfsyspub", (int)1) == 0) continue;
            pSPFPluginTemplService.exportModel(pSPFPluginTempl, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSPFPlugin pSPFPlugin, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSPFPlugin, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLDCFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllDCFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BASECLSPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BaseClsParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KEYWORDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Keywords_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLUGINDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PluginDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLUGINTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PluginType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVIEWHTML", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreviewHtml_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVIEWPSNDFILEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreviewPSNDFileId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVIEWURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreviewUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RTOBJECTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RTObjectMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RTOBJECTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RTObjectName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RTOBJECTREPO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RTObjectRepo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STUDIOICON", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StudioIcon_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AllDCFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BaseClsParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BASECLSPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_Keywords_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("KEYWORDS", iEntity, bl2, null, false, 300, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[300]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[300]";
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

    protected String onTestValueRule_PluginDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLUGINDESC", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PluginType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLUGINTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PreviewHtml_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVIEWHTML", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PreviewPSNDFileId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVIEWPSNDFILEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PreviewUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVIEWURL", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_RTObjectMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RTObjectName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RTOBJECTNAME", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RTObjectRepo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RTOBJECTREPO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StudioIcon_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STUDIOICON", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSPFPlugin pSPFPlugin) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSPFPlugin)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPFPlugin pSPFPlugin) throws Exception {
        super.onUpdateParent((IEntity)pSPFPlugin);
    }

    @Override
    protected void exportCurXmlModel(PSPFPlugin pSPFPlugin, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPFPLUGIN");
        if (!bl) {
            super.exportCurXmlModel(pSPFPlugin, xmlNode, bl);
        }
    }
}

