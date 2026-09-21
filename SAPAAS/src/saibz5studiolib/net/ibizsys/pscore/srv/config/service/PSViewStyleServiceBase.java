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
import net.ibizsys.pscore.srv.config.dao.PSViewStyleDAO;
import net.ibizsys.pscore.srv.config.demodel.PSViewStyleDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSPFPluginBase;
import net.ibizsys.pscore.srv.config.entity.PSViewStyle;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSViewStyleServiceBase
extends PSCoreSysServiceBase<PSViewStyle> {
    private static final Log log = LogFactory.getLog(PSViewStyleServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSViewStyleDEModel pSViewStyleDEModel;
    private PSViewStyleDAO pSViewStyleDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSViewStyleService";
    }

    public PSViewStyleDEModel getPSViewStyleDEModel() {
        if (this.pSViewStyleDEModel == null) {
            try {
                this.pSViewStyleDEModel = (PSViewStyleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSViewStyleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewStyleDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSViewStyleDEModel();
    }

    public PSViewStyleDAO getPSViewStyleDAO() {
        if (this.pSViewStyleDAO == null) {
            try {
                this.pSViewStyleDAO = (PSViewStyleDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSViewStyleDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewStyleDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSViewStyleDAO();
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

    protected void onFillParentInfo(PSViewStyle pSViewStyle, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWSTYLE_PSDEVCENTER_PSDCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenter);
            } else {
                iService.get((IEntity)pSDevCenter);
            }
            this.onFillParentInfo_PSDC(pSViewStyle, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWSTYLE_PSPFPLUGIN_PSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPluginService", (SessionFactory)this.getSessionFactory());
            PSPFPlugin pSPFPlugin = (PSPFPlugin)iService.getDEModel().createEntity();
            pSPFPlugin.set("PSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPFPlugin);
            } else {
                iService.get((IEntity)pSPFPlugin);
            }
            this.onFillParentInfo_PSPFPlugin(pSViewStyle, pSPFPlugin);
            return;
        }
        super.onFillParentInfo((IEntity)pSViewStyle, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDC(PSViewStyle pSViewStyle, PSDevCenter pSDevCenter) throws Exception {
        pSViewStyle.setPSDCId(pSDevCenter.getPSDevCenterId());
        pSViewStyle.setPSDCName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSPFPlugin(PSViewStyle pSViewStyle, PSPFPlugin pSPFPlugin) throws Exception {
        pSViewStyle.setPSPFPluginId(pSPFPlugin.getPSPFPluginId());
        pSViewStyle.setPSPFPluginName(pSPFPlugin.getPSPFPluginName());
    }

    protected void onFillEntityFullInfo(PSViewStyle pSViewStyle, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSViewStyle, bl);
        this.onFillEntityFullInfo_PSDC(pSViewStyle, bl);
        this.onFillEntityFullInfo_PSPFPlugin(pSViewStyle, bl);
    }

    protected void onFillEntityFullInfo_PSDC(PSViewStyle pSViewStyle, boolean bl) throws Exception {
        if (pSViewStyle.isPSDCIdDirty()) {
            if (pSViewStyle.getPSDCId() != null) {
                if (pSViewStyle.getPSDCId() == null || pSViewStyle.getPSDCName() == null) {
                    PSDevCenter pSDevCenter = pSViewStyle.getPSDC();
                    pSViewStyle.setPSDCName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSViewStyle.setPSDCName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSPFPlugin(PSViewStyle pSViewStyle, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSViewStyle pSViewStyle, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSViewStyle, bl);
    }

    public ArrayList<PSViewStyle> selectByPSDC(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDC(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSViewStyle> selectByPSDC(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDC(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSViewStyle> selectByPSDC(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSViewStyle> selectByPSPFPlugin(PSPFPluginBase pSPFPluginBase) throws Exception {
        return this.selectByPSPFPlugin(pSPFPluginBase, "", -1);
    }

    public ArrayList<PSViewStyle> selectByPSPFPlugin(PSPFPluginBase pSPFPluginBase, String string) throws Exception {
        return this.selectByPSPFPlugin(pSPFPluginBase, string, -1);
    }

    public ArrayList<PSViewStyle> selectByPSPFPlugin(PSPFPluginBase pSPFPluginBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDC(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSViewStyle> arrayList = this.selectByPSDC(pSDevCenter);
        for (PSViewStyle pSViewStyle : arrayList) {
            PSViewStyle pSViewStyle2 = (PSViewStyle)this.getDEModel().createEntity();
            pSViewStyle2.setPSViewStyleId(pSViewStyle.getPSViewStyleId());
            pSViewStyle2.setPSDCId(null);
            this.update(pSViewStyle2);
        }
    }

    public void removeByPSDC(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewStyleServiceBase.this.onBeforeRemoveByPSDC(pSDevCenter2);
                PSViewStyleServiceBase.this.internalRemoveByPSDC(pSDevCenter2);
                PSViewStyleServiceBase.this.onAfterRemoveByPSDC(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSViewStyle> arrayList = this.selectByPSDC(pSDevCenter);
        this.onBeforeRemoveByPSDC(pSDevCenter, arrayList);
        for (PSViewStyle pSViewStyle : arrayList) {
            this.remove((IEntity)pSViewStyle);
        }
        this.onAfterRemoveByPSDC(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDC(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDC(PSDevCenter pSDevCenter, ArrayList<PSViewStyle> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDC(PSDevCenter pSDevCenter, ArrayList<PSViewStyle> arrayList) throws Exception {
    }

    public void testRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
        ArrayList<PSViewStyle> arrayList = this.selectByPSPFPlugin(pSPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWSTYLE_PSPFPLUGIN_PSPFPLUGINID", "", iDataEntityModel.getName(), "PSVIEWSTYLE", iDataEntityModel.getDataInfo((IEntity)pSPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
        ArrayList<PSViewStyle> arrayList = this.selectByPSPFPlugin(pSPFPlugin);
        for (PSViewStyle pSViewStyle : arrayList) {
            PSViewStyle pSViewStyle2 = (PSViewStyle)this.getDEModel().createEntity();
            pSViewStyle2.setPSViewStyleId(pSViewStyle.getPSViewStyleId());
            pSViewStyle2.setPSPFPluginId(null);
            this.update(pSViewStyle2);
        }
    }

    public void removeByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
        final PSPFPlugin pSPFPlugin2 = pSPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewStyleServiceBase.this.onBeforeRemoveByPSPFPlugin(pSPFPlugin2);
                PSViewStyleServiceBase.this.internalRemoveByPSPFPlugin(pSPFPlugin2);
                PSViewStyleServiceBase.this.onAfterRemoveByPSPFPlugin(pSPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
        ArrayList<PSViewStyle> arrayList = this.selectByPSPFPlugin(pSPFPlugin);
        this.onBeforeRemoveByPSPFPlugin(pSPFPlugin, arrayList);
        for (PSViewStyle pSViewStyle : arrayList) {
            this.remove((IEntity)pSViewStyle);
        }
        this.onAfterRemoveByPSPFPlugin(pSPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin, ArrayList<PSViewStyle> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin, ArrayList<PSViewStyle> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSViewStyle pSViewStyle) throws Exception {
        super.onBeforeRemove(pSViewStyle);
    }

    protected void replaceParentInfo(PSViewStyle pSViewStyle, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSViewStyle, cloneSession);
        if (pSViewStyle.getPSDCId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSViewStyle.getPSDCId())) != null) {
            this.onFillParentInfo_PSDC(pSViewStyle, (PSDevCenter)iEntity);
        }
        if (pSViewStyle.getPSPFPluginId() != null && (iEntity = cloneSession.getEntity("PSPFPLUGIN", (Object)pSViewStyle.getPSPFPluginId())) != null) {
            this.onFillParentInfo_PSPFPlugin(pSViewStyle, (PSPFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSViewStyle pSViewStyle, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSViewStyle, bl);
    }

    protected void onCheckEntity(boolean bl, PSViewStyle pSViewStyle, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ExtendCtrl(bl, pSViewStyle, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtendView(bl, pSViewStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSViewStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NameMode(bl, pSViewStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCId(bl, pSViewStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCName(bl, pSViewStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPluginId(bl, pSViewStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewStyleId(bl, pSViewStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewStyleName(bl, pSViewStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeCode(bl, pSViewStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParams(bl, pSViewStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSViewStyle, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ExtendCtrl(boolean bl, PSViewStyle pSViewStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewStyle.isExtendCtrlDirty() : !pSViewStyle.isExtendCtrlDirty()) {
            return null;
        }
        Integer n = pSViewStyle.getExtendCtrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExtendCtrl_Default((IEntity)pSViewStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTENDCTRL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExtendView(boolean bl, PSViewStyle pSViewStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewStyle.isExtendViewDirty() : !pSViewStyle.isExtendViewDirty()) {
            return null;
        }
        Integer n = pSViewStyle.getExtendView();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExtendView_Default((IEntity)pSViewStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTENDVIEW");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSViewStyle pSViewStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewStyle.isMemoDirty() : !pSViewStyle.isMemoDirty()) {
            return null;
        }
        String string = pSViewStyle.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSViewStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_NameMode(boolean bl, PSViewStyle pSViewStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewStyle.isNameModeDirty() && !bl2 : !pSViewStyle.isNameModeDirty()) {
            return null;
        }
        String string = pSViewStyle.getNameMode();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAMEMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_NameMode_Default((IEntity)pSViewStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAMEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCId(boolean bl, PSViewStyle pSViewStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewStyle.isPSDCIdDirty() : !pSViewStyle.isPSDCIdDirty()) {
            return null;
        }
        String string = pSViewStyle.getPSDCId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCId_Default((IEntity)pSViewStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCName(boolean bl, PSViewStyle pSViewStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewStyle.isPSDCNameDirty() : !pSViewStyle.isPSDCNameDirty()) {
            return null;
        }
        String string = pSViewStyle.getPSDCName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCName_Default((IEntity)pSViewStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFPluginId(boolean bl, PSViewStyle pSViewStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewStyle.isPSPFPluginIdDirty() : !pSViewStyle.isPSPFPluginIdDirty()) {
            return null;
        }
        String string = pSViewStyle.getPSPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPluginId_Default((IEntity)pSViewStyle, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSViewStyleId(boolean bl, PSViewStyle pSViewStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewStyle.isPSViewStyleIdDirty() && !bl2 : !pSViewStyle.isPSViewStyleIdDirty()) {
            return null;
        }
        String string = pSViewStyle.getPSViewStyleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWSTYLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewStyleId_Default((IEntity)pSViewStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewStyleName(boolean bl, PSViewStyle pSViewStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewStyle.isPSViewStyleNameDirty() && !bl2 : !pSViewStyle.isPSViewStyleNameDirty()) {
            return null;
        }
        String string = pSViewStyle.getPSViewStyleName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWSTYLENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewStyleName_Default((IEntity)pSViewStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWSTYLENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeCode(boolean bl, PSViewStyle pSViewStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewStyle.isTypeCodeDirty() && !bl2 : !pSViewStyle.isTypeCodeDirty()) {
            return null;
        }
        String string = pSViewStyle.getTypeCode();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPECODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeCode_Default((IEntity)pSViewStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPECODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewParams(boolean bl, PSViewStyle pSViewStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewStyle.isViewParamsDirty() : !pSViewStyle.isViewParamsDirty()) {
            return null;
        }
        String string = pSViewStyle.getViewParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParams_Default((IEntity)pSViewStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSViewStyle pSViewStyle, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSViewStyle, bl);
    }

    protected void onSyncIndexEntities(PSViewStyle pSViewStyle, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSViewStyle, bl);
    }

    public Object getDataContextValue(PSViewStyle pSViewStyle, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSViewStyle, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSViewStyle pSViewStyle, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSViewStyle, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTENDCTRL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtendCtrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTENDVIEW", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtendView_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAMEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NameMode_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSVIEWSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPECODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParams_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ExtendCtrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExtendView_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_NameMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAMEMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_PSViewStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypeCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPECODE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_ViewParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSViewStyle pSViewStyle) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSViewStyle)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSViewStyle pSViewStyle) throws Exception {
        super.onUpdateParent((IEntity)pSViewStyle);
    }

    @Override
    protected void exportCurXmlModel(PSViewStyle pSViewStyle, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSVIEWSTYLE");
        if (!bl) {
            pSViewStyle.setCreateDate(null);
            pSViewStyle.setCreateMan(null);
            pSViewStyle.setPSViewStyleId(null);
            pSViewStyle.setUpdateDate(null);
            pSViewStyle.setUpdateMan(null);
            super.exportCurXmlModel(pSViewStyle, xmlNode, bl);
        }
    }
}

