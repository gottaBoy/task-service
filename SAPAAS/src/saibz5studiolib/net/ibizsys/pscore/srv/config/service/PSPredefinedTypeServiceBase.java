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
 *  net.ibizsys.paas.demodel.IDataEntityModel
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
import net.ibizsys.paas.demodel.IDataEntityModel;
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
import net.ibizsys.pscore.srv.config.dao.PSPredefinedTypeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSPredefinedTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSPFPluginBase;
import net.ibizsys.pscore.srv.config.entity.PSPredefinedType;
import net.ibizsys.pscore.srv.config.entity.PSSFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPredefinedTypeServiceBase
extends PSCoreSysServiceBase<PSPredefinedType> {
    private static final Log log = LogFactory.getLog(PSPredefinedTypeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPredefinedTypeDEModel pSPredefinedTypeDEModel;
    private PSPredefinedTypeDAO pSPredefinedTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSPredefinedTypeService";
    }

    public PSPredefinedTypeDEModel getPSPredefinedTypeDEModel() {
        if (this.pSPredefinedTypeDEModel == null) {
            try {
                this.pSPredefinedTypeDEModel = (PSPredefinedTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPredefinedTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPredefinedTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPredefinedTypeDEModel();
    }

    public PSPredefinedTypeDAO getPSPredefinedTypeDAO() {
        if (this.pSPredefinedTypeDAO == null) {
            try {
                this.pSPredefinedTypeDAO = (PSPredefinedTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSPredefinedTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPredefinedTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPredefinedTypeDAO();
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

    protected void onFillParentInfo(PSPredefinedType pSPredefinedType, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPREDEFINEDTYPE_PSPFPLUGIN_PSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPluginService", (SessionFactory)this.getSessionFactory());
            PSPFPlugin pSPFPlugin = (PSPFPlugin)iService.getDEModel().createEntity();
            pSPFPlugin.set("PSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPFPlugin);
            } else {
                iService.get((IEntity)pSPFPlugin);
            }
            this.onFillParentInfo_PSPFPlugin(pSPredefinedType, pSPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPREDEFINEDTYPE_PSSFPLUGIN_PSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSFPlugin pSSFPlugin = (PSSFPlugin)iService.getDEModel().createEntity();
            pSSFPlugin.set("PSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFPlugin);
            } else {
                iService.get((IEntity)pSSFPlugin);
            }
            this.onFillParentInfo_PSSFPlugin(pSPredefinedType, pSSFPlugin);
            return;
        }
        super.onFillParentInfo((IEntity)pSPredefinedType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSPFPlugin(PSPredefinedType pSPredefinedType, PSPFPlugin pSPFPlugin) throws Exception {
        pSPredefinedType.setPSPFPluginId(pSPFPlugin.getPSPFPluginId());
        pSPredefinedType.setPSPFPluginName(pSPFPlugin.getPSPFPluginName());
    }

    protected void onFillParentInfo_PSSFPlugin(PSPredefinedType pSPredefinedType, PSSFPlugin pSSFPlugin) throws Exception {
        pSPredefinedType.setPSSFPluginId(pSSFPlugin.getPSSFPluginId());
        pSPredefinedType.setPSSFPluginName(pSSFPlugin.getPSSFPluginName());
    }

    protected void onFillEntityFullInfo(PSPredefinedType pSPredefinedType, boolean bl) throws Exception {
        if (bl && pSPredefinedType.getValidFlag() == null) {
            pSPredefinedType.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSPredefinedType, bl);
        this.onFillEntityFullInfo_PSPFPlugin(pSPredefinedType, bl);
        this.onFillEntityFullInfo_PSSFPlugin(pSPredefinedType, bl);
    }

    protected void onFillEntityFullInfo_PSPFPlugin(PSPredefinedType pSPredefinedType, boolean bl) throws Exception {
        if (pSPredefinedType.isPSPFPluginIdDirty()) {
            if (pSPredefinedType.getPSPFPluginId() != null) {
                if (pSPredefinedType.getPSPFPluginId() == null || pSPredefinedType.getPSPFPluginName() == null) {
                    PSPFPlugin pSPFPlugin = pSPredefinedType.getPSPFPlugin();
                    pSPredefinedType.setPSPFPluginName(pSPFPlugin.getPSPFPluginName());
                }
            } else {
                pSPredefinedType.setPSPFPluginName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSFPlugin(PSPredefinedType pSPredefinedType, boolean bl) throws Exception {
        if (pSPredefinedType.isPSSFPluginIdDirty()) {
            if (pSPredefinedType.getPSSFPluginId() != null) {
                if (pSPredefinedType.getPSSFPluginId() == null || pSPredefinedType.getPSSFPluginName() == null) {
                    PSSFPlugin pSSFPlugin = pSPredefinedType.getPSSFPlugin();
                    pSPredefinedType.setPSSFPluginName(pSSFPlugin.getPSSFPluginName());
                }
            } else {
                pSPredefinedType.setPSSFPluginName(null);
            }
        }
    }

    protected void onWriteBackParent(PSPredefinedType pSPredefinedType, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSPredefinedType, bl);
    }

    public ArrayList<PSPredefinedType> selectByPSPFPlugin(PSPFPluginBase pSPFPluginBase) throws Exception {
        return this.selectByPSPFPlugin(pSPFPluginBase, "", -1);
    }

    public ArrayList<PSPredefinedType> selectByPSPFPlugin(PSPFPluginBase pSPFPluginBase, String string) throws Exception {
        return this.selectByPSPFPlugin(pSPFPluginBase, string, -1);
    }

    public ArrayList<PSPredefinedType> selectByPSPFPlugin(PSPFPluginBase pSPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSPredefinedType> selectByPSSFPlugin(PSSFPluginBase pSSFPluginBase) throws Exception {
        return this.selectByPSSFPlugin(pSSFPluginBase, "", -1);
    }

    public ArrayList<PSPredefinedType> selectByPSSFPlugin(PSSFPluginBase pSSFPluginBase, String string) throws Exception {
        return this.selectByPSSFPlugin(pSSFPluginBase, string, -1);
    }

    public ArrayList<PSPredefinedType> selectByPSSFPlugin(PSSFPluginBase pSSFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFPLUGINID", (Object)pSSFPluginBase.getPSSFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFPluginCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
        ArrayList<PSPredefinedType> arrayList = this.selectByPSPFPlugin(pSPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPREDEFINEDTYPE_PSPFPLUGIN_PSPFPLUGINID", "", iDataEntityModel.getName(), "PSPREDEFINEDTYPE", iDataEntityModel.getDataInfo((IEntity)pSPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
        ArrayList<PSPredefinedType> arrayList = this.selectByPSPFPlugin(pSPFPlugin);
        for (PSPredefinedType pSPredefinedType : arrayList) {
            PSPredefinedType pSPredefinedType2 = (PSPredefinedType)this.getDEModel().createEntity();
            pSPredefinedType2.setPSPredefinedTypeId(pSPredefinedType.getPSPredefinedTypeId());
            pSPredefinedType2.setPSPFPluginId(null);
            this.update(pSPredefinedType2);
        }
    }

    public void removeByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
        final PSPFPlugin pSPFPlugin2 = pSPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPredefinedTypeServiceBase.this.onBeforeRemoveByPSPFPlugin(pSPFPlugin2);
                PSPredefinedTypeServiceBase.this.internalRemoveByPSPFPlugin(pSPFPlugin2);
                PSPredefinedTypeServiceBase.this.onAfterRemoveByPSPFPlugin(pSPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
        ArrayList<PSPredefinedType> arrayList = this.selectByPSPFPlugin(pSPFPlugin);
        this.onBeforeRemoveByPSPFPlugin(pSPFPlugin, arrayList);
        for (PSPredefinedType pSPredefinedType : arrayList) {
            this.remove((IEntity)pSPredefinedType);
        }
        this.onAfterRemoveByPSPFPlugin(pSPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin, ArrayList<PSPredefinedType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin, ArrayList<PSPredefinedType> arrayList) throws Exception {
    }

    public void testRemoveByPSSFPlugin(PSSFPlugin pSSFPlugin) throws Exception {
        ArrayList<PSPredefinedType> arrayList = this.selectByPSSFPlugin(pSSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPREDEFINEDTYPE_PSSFPLUGIN_PSSFPLUGINID", "", iDataEntityModel.getName(), "PSPREDEFINEDTYPE", iDataEntityModel.getDataInfo((IEntity)pSSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSFPlugin(PSSFPlugin pSSFPlugin) throws Exception {
        ArrayList<PSPredefinedType> arrayList = this.selectByPSSFPlugin(pSSFPlugin);
        for (PSPredefinedType pSPredefinedType : arrayList) {
            PSPredefinedType pSPredefinedType2 = (PSPredefinedType)this.getDEModel().createEntity();
            pSPredefinedType2.setPSPredefinedTypeId(pSPredefinedType.getPSPredefinedTypeId());
            pSPredefinedType2.setPSSFPluginId(null);
            this.update(pSPredefinedType2);
        }
    }

    public void removeByPSSFPlugin(PSSFPlugin pSSFPlugin) throws Exception {
        final PSSFPlugin pSSFPlugin2 = pSSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPredefinedTypeServiceBase.this.onBeforeRemoveByPSSFPlugin(pSSFPlugin2);
                PSPredefinedTypeServiceBase.this.internalRemoveByPSSFPlugin(pSSFPlugin2);
                PSPredefinedTypeServiceBase.this.onAfterRemoveByPSSFPlugin(pSSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFPlugin(PSSFPlugin pSSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSFPlugin(PSSFPlugin pSSFPlugin) throws Exception {
        ArrayList<PSPredefinedType> arrayList = this.selectByPSSFPlugin(pSSFPlugin);
        this.onBeforeRemoveByPSSFPlugin(pSSFPlugin, arrayList);
        for (PSPredefinedType pSPredefinedType : arrayList) {
            this.remove((IEntity)pSPredefinedType);
        }
        this.onAfterRemoveByPSSFPlugin(pSSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSFPlugin(PSSFPlugin pSSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSFPlugin(PSSFPlugin pSSFPlugin, ArrayList<PSPredefinedType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFPlugin(PSSFPlugin pSSFPlugin, ArrayList<PSPredefinedType> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPredefinedType pSPredefinedType) throws Exception {
        super.onBeforeRemove(pSPredefinedType);
    }

    protected void replaceParentInfo(PSPredefinedType pSPredefinedType, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSPredefinedType, cloneSession);
        if (pSPredefinedType.getPSPFPluginId() != null && (iEntity = cloneSession.getEntity("PSPFPLUGIN", (Object)pSPredefinedType.getPSPFPluginId())) != null) {
            this.onFillParentInfo_PSPFPlugin(pSPredefinedType, (PSPFPlugin)iEntity);
        }
        if (pSPredefinedType.getPSSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSFPLUGIN", (Object)pSPredefinedType.getPSSFPluginId())) != null) {
            this.onFillParentInfo_PSSFPlugin(pSPredefinedType, (PSSFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPredefinedType pSPredefinedType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSPredefinedType, bl);
    }

    protected void onCheckEntity(boolean bl, PSPredefinedType pSPredefinedType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSPredefinedType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSPredefinedType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedType(bl, pSPredefinedType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPluginId(bl, pSPredefinedType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPluginName(bl, pSPredefinedType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPredefinedTypeId(bl, pSPredefinedType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPredefinedTypeName(bl, pSPredefinedType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPluginId(bl, pSPredefinedType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPluginName(bl, pSPredefinedType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeParams(bl, pSPredefinedType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeTag(bl, pSPredefinedType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeTag2(bl, pSPredefinedType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UsageMode(bl, pSPredefinedType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSPredefinedType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSPredefinedType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPredefinedType pSPredefinedType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPredefinedType.isMemoDirty() : !pSPredefinedType.isMemoDirty()) {
            return null;
        }
        String string = pSPredefinedType.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSPredefinedType, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSPredefinedType pSPredefinedType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPredefinedType.isOrderValueDirty() : !pSPredefinedType.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSPredefinedType.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSPredefinedType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PredefinedType(boolean bl, PSPredefinedType pSPredefinedType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPredefinedType.isPredefinedTypeDirty() && !bl2 : !pSPredefinedType.isPredefinedTypeDirty()) {
            return null;
        }
        String string = pSPredefinedType.getPredefinedType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINEDTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedType_Default((IEntity)pSPredefinedType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINEDTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPluginId(boolean bl, PSPredefinedType pSPredefinedType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPredefinedType.isPSPFPluginIdDirty() : !pSPredefinedType.isPSPFPluginIdDirty()) {
            return null;
        }
        String string = pSPredefinedType.getPSPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPluginId_Default((IEntity)pSPredefinedType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFPluginName(boolean bl, PSPredefinedType pSPredefinedType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPredefinedType.isPSPFPluginNameDirty() : !pSPredefinedType.isPSPFPluginNameDirty()) {
            return null;
        }
        String string = pSPredefinedType.getPSPFPluginName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPluginName_Default((IEntity)pSPredefinedType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPredefinedTypeId(boolean bl, PSPredefinedType pSPredefinedType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPredefinedType.isPSPredefinedTypeIdDirty() && !bl2 : !pSPredefinedType.isPSPredefinedTypeIdDirty()) {
            return null;
        }
        String string = pSPredefinedType.getPSPredefinedTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPREDEFINEDTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPredefinedTypeId_Default((IEntity)pSPredefinedType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPREDEFINEDTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPredefinedTypeName(boolean bl, PSPredefinedType pSPredefinedType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPredefinedType.isPSPredefinedTypeNameDirty() && !bl2 : !pSPredefinedType.isPSPredefinedTypeNameDirty()) {
            return null;
        }
        String string = pSPredefinedType.getPSPredefinedTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPREDEFINEDTYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPredefinedTypeName_Default((IEntity)pSPredefinedType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPREDEFINEDTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFPluginId(boolean bl, PSPredefinedType pSPredefinedType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPredefinedType.isPSSFPluginIdDirty() : !pSPredefinedType.isPSSFPluginIdDirty()) {
            return null;
        }
        String string = pSPredefinedType.getPSSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPluginId_Default((IEntity)pSPredefinedType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFPluginName(boolean bl, PSPredefinedType pSPredefinedType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPredefinedType.isPSSFPluginNameDirty() : !pSPredefinedType.isPSSFPluginNameDirty()) {
            return null;
        }
        String string = pSPredefinedType.getPSSFPluginName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPluginName_Default((IEntity)pSPredefinedType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPLUGINNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeParams(boolean bl, PSPredefinedType pSPredefinedType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPredefinedType.isTypeParamsDirty() : !pSPredefinedType.isTypeParamsDirty()) {
            return null;
        }
        String string = pSPredefinedType.getTypeParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeParams_Default((IEntity)pSPredefinedType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPEPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeTag(boolean bl, PSPredefinedType pSPredefinedType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPredefinedType.isTypeTagDirty() : !pSPredefinedType.isTypeTagDirty()) {
            return null;
        }
        String string = pSPredefinedType.getTypeTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeTag_Default((IEntity)pSPredefinedType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeTag2(boolean bl, PSPredefinedType pSPredefinedType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPredefinedType.isTypeTag2Dirty() : !pSPredefinedType.isTypeTag2Dirty()) {
            return null;
        }
        String string = pSPredefinedType.getTypeTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeTag2_Default((IEntity)pSPredefinedType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UsageMode(boolean bl, PSPredefinedType pSPredefinedType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPredefinedType.isUsageModeDirty() && !bl2 : !pSPredefinedType.isUsageModeDirty()) {
            return null;
        }
        String string = pSPredefinedType.getUsageMode();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USAGEMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_UsageMode_Default((IEntity)pSPredefinedType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USAGEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSPredefinedType pSPredefinedType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPredefinedType.isValidFlagDirty() && !bl2 : !pSPredefinedType.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSPredefinedType.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSPredefinedType, bl2, bl3);
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

    protected void onSyncEntity(PSPredefinedType pSPredefinedType, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSPredefinedType, bl);
    }

    protected void onSyncIndexEntities(PSPredefinedType pSPredefinedType, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSPredefinedType, bl);
    }

    public Object getDataContextValue(PSPredefinedType pSPredefinedType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSPredefinedType, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSPredefinedType pSPredefinedType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSPredefinedType, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPREDEFINEDTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPredefinedTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPREDEFINEDTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPredefinedTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPEPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USAGEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UsageMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PredefinedType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_PSPredefinedTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPREDEFINEDTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPredefinedTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPREDEFINEDTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypeParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPEPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypeTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPETAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypeTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPETAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_UsageMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USAGEMODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSPredefinedType pSPredefinedType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSPredefinedType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPredefinedType pSPredefinedType) throws Exception {
        super.onUpdateParent((IEntity)pSPredefinedType);
    }

    @Override
    protected void exportCurXmlModel(PSPredefinedType pSPredefinedType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPREDEFINEDTYPE");
        if (!bl) {
            pSPredefinedType.setCreateDate(null);
            pSPredefinedType.setCreateMan(null);
            pSPredefinedType.setPSPredefinedTypeId(null);
            pSPredefinedType.setUpdateDate(null);
            pSPredefinedType.setUpdateMan(null);
            super.exportCurXmlModel(pSPredefinedType, xmlNode, bl);
        }
    }
}

