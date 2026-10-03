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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSSFPluginTemplDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSFPluginTemplDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFBase;
import net.ibizsys.pscore.srv.config.entity.PSSFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSFPluginBase;
import net.ibizsys.pscore.srv.config.entity.PSSFPluginTempl;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFPluginTemplServiceBase
extends PSCoreSysServiceBase<PSSFPluginTempl> {
    private static final Log log = LogFactory.getLog(PSSFPluginTemplServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSFPluginTemplDEModel pSSFPluginTemplDEModel;
    private PSSFPluginTemplDAO pSSFPluginTemplDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSFPluginTemplService";
    }

    public PSSFPluginTemplDEModel getPSSFPluginTemplDEModel() {
        if (this.pSSFPluginTemplDEModel == null) {
            try {
                this.pSSFPluginTemplDEModel = (PSSFPluginTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFPluginTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFPluginTemplDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSFPluginTemplDEModel();
    }

    public PSSFPluginTemplDAO getPSSFPluginTemplDAO() {
        if (this.pSSFPluginTemplDAO == null) {
            try {
                this.pSSFPluginTemplDAO = (PSSFPluginTemplDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSFPluginTemplDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFPluginTemplDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSFPluginTemplDAO();
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

    protected void onFillParentInfo(PSSFPluginTempl pSSFPluginTempl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFPLUGINTEMPL_PSSFPLUGIN_PSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSFPlugin pSSFPlugin = (PSSFPlugin)iService.getDEModel().createEntity();
            pSSFPlugin.set("PSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSFPlugin);
            } else {
                iService.get(pSSFPlugin);
            }
            this.onFillParentInfo_PSSFPlugin(pSSFPluginTempl, pSSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFPLUGINTEMPL_PSSF_PSSFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFService", (SessionFactory)this.getSessionFactory());
            PSSF pSSF = (PSSF)iService.getDEModel().createEntity();
            pSSF.set("PSSFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSF);
            } else {
                iService.get(pSSF);
            }
            this.onFillParentInfo_PSSF(pSSFPluginTempl, pSSF);
            return;
        }
        super.onFillParentInfo(pSSFPluginTempl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSFPlugin(PSSFPluginTempl pSSFPluginTempl, PSSFPlugin pSSFPlugin) throws Exception {
        pSSFPluginTempl.setPSSFPluginId(pSSFPlugin.getPSSFPluginId());
        pSSFPluginTempl.setPSSFPluginName(pSSFPlugin.getPSSFPluginName());
    }

    protected void onFillParentInfo_PSSF(PSSFPluginTempl pSSFPluginTempl, PSSF pSSF) throws Exception {
        pSSFPluginTempl.setPSSFId(pSSF.getPSSFId());
        pSSFPluginTempl.setPSSFName(pSSF.getPSSFName());
    }

    protected boolean onFillEntityKeyValue(PSSFPluginTempl pSSFPluginTempl, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSFPluginTempl.get("PSSFPLUGINID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSFPluginTempl.get("PSSFID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSSFPluginTempl.set(this.getPSSFPluginTemplDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSFPluginTempl pSSFPluginTempl, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSFPluginTempl, bl);
        this.onFillEntityFullInfo_PSSFPlugin(pSSFPluginTempl, bl);
        this.onFillEntityFullInfo_PSSF(pSSFPluginTempl, bl);
    }

    protected void onFillEntityFullInfo_PSSFPlugin(PSSFPluginTempl pSSFPluginTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSF(PSSFPluginTempl pSSFPluginTempl, boolean bl) throws Exception {
        if (pSSFPluginTempl.isPSSFIdDirty()) {
            if (pSSFPluginTempl.getPSSFId() != null) {
                if (pSSFPluginTempl.getPSSFId() == null || pSSFPluginTempl.getPSSFName() == null) {
                    PSSF pSSF = pSSFPluginTempl.getPSSF();
                    pSSFPluginTempl.setPSSFName(pSSF.getPSSFName());
                }
            } else {
                pSSFPluginTempl.setPSSFName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSFPluginTempl pSSFPluginTempl, boolean bl) throws Exception {
        super.onWriteBackParent(pSSFPluginTempl, bl);
    }

    public ArrayList<PSSFPluginTempl> selectByPSSFPlugin(PSSFPluginBase pSSFPluginBase) throws Exception {
        return this.selectByPSSFPlugin(pSSFPluginBase, "", -1);
    }

    public ArrayList<PSSFPluginTempl> selectByPSSFPlugin(PSSFPluginBase pSSFPluginBase, String string) throws Exception {
        return this.selectByPSSFPlugin(pSSFPluginBase, string, -1);
    }

    public ArrayList<PSSFPluginTempl> selectByPSSFPlugin(PSSFPluginBase pSSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSFPluginTempl> selectByPSSF(PSSFBase pSSFBase) throws Exception {
        return this.selectByPSSF(pSSFBase, "", -1);
    }

    public ArrayList<PSSFPluginTempl> selectByPSSF(PSSFBase pSSFBase, String string) throws Exception {
        return this.selectByPSSF(pSSFBase, string, -1);
    }

    public ArrayList<PSSFPluginTempl> selectByPSSF(PSSFBase pSSFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFID", (Object)pSSFBase.getPSSFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSFPlugin(PSSFPlugin pSSFPlugin) throws Exception {
    }

    public void resetPSSFPlugin(PSSFPlugin pSSFPlugin) throws Exception {
        ArrayList<PSSFPluginTempl> arrayList = this.selectByPSSFPlugin(pSSFPlugin);
        for (PSSFPluginTempl pSSFPluginTempl : arrayList) {
            PSSFPluginTempl pSSFPluginTempl2 = (PSSFPluginTempl)this.getDEModel().createEntity();
            pSSFPluginTempl2.setPSSFPluginTemplId(pSSFPluginTempl.getPSSFPluginTemplId());
            pSSFPluginTempl2.setPSSFPluginId(null);
            this.update(pSSFPluginTempl2);
        }
    }

    public void removeByPSSFPlugin(PSSFPlugin pSSFPlugin) throws Exception {
        final PSSFPlugin pSSFPlugin2 = pSSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFPluginTemplServiceBase.this.onBeforeRemoveByPSSFPlugin(pSSFPlugin2);
                PSSFPluginTemplServiceBase.this.internalRemoveByPSSFPlugin(pSSFPlugin2);
                PSSFPluginTemplServiceBase.this.onAfterRemoveByPSSFPlugin(pSSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFPlugin(PSSFPlugin pSSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSFPlugin(PSSFPlugin pSSFPlugin) throws Exception {
        ArrayList<PSSFPluginTempl> arrayList = this.selectByPSSFPlugin(pSSFPlugin);
        this.onBeforeRemoveByPSSFPlugin(pSSFPlugin, arrayList);
        for (PSSFPluginTempl pSSFPluginTempl : arrayList) {
            this.remove(pSSFPluginTempl);
        }
        this.onAfterRemoveByPSSFPlugin(pSSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSFPlugin(PSSFPlugin pSSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSFPlugin(PSSFPlugin pSSFPlugin, ArrayList<PSSFPluginTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFPlugin(PSSFPlugin pSSFPlugin, ArrayList<PSSFPluginTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    public void resetPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSFPluginTempl> arrayList = this.selectByPSSF(pSSF);
        for (PSSFPluginTempl pSSFPluginTempl : arrayList) {
            PSSFPluginTempl pSSFPluginTempl2 = (PSSFPluginTempl)this.getDEModel().createEntity();
            pSSFPluginTempl2.setPSSFPluginTemplId(pSSFPluginTempl.getPSSFPluginTemplId());
            pSSFPluginTempl2.setPSSFId(null);
            this.update(pSSFPluginTempl2);
        }
    }

    public void removeByPSSF(PSSF pSSF) throws Exception {
        final PSSF pSSF2 = pSSF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFPluginTemplServiceBase.this.onBeforeRemoveByPSSF(pSSF2);
                PSSFPluginTemplServiceBase.this.internalRemoveByPSSF(pSSF2);
                PSSFPluginTemplServiceBase.this.onAfterRemoveByPSSF(pSSF2);
            }
        });
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void internalRemoveByPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSFPluginTempl> arrayList = this.selectByPSSF(pSSF);
        this.onBeforeRemoveByPSSF(pSSF, arrayList);
        for (PSSFPluginTempl pSSFPluginTempl : arrayList) {
            this.remove(pSSFPluginTempl);
        }
        this.onAfterRemoveByPSSF(pSSF, arrayList);
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF, ArrayList<PSSFPluginTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF, ArrayList<PSSFPluginTempl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSFPluginTempl pSSFPluginTempl) throws Exception {
        super.onBeforeRemove(pSSFPluginTempl);
    }

    protected void replaceParentInfo(PSSFPluginTempl pSSFPluginTempl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSFPluginTempl, cloneSession);
        if (pSSFPluginTempl.getPSSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSFPLUGIN", (Object)pSSFPluginTempl.getPSSFPluginId())) != null) {
            this.onFillParentInfo_PSSFPlugin(pSSFPluginTempl, (PSSFPlugin)iEntity);
        }
        if (pSSFPluginTempl.getPSSFId() != null && (iEntity = cloneSession.getEntity("PSSF", (Object)pSSFPluginTempl.getPSSFId())) != null) {
            this.onFillParentInfo_PSSF(pSSFPluginTempl, (PSSF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSFPluginTempl pSSFPluginTempl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSFPluginTempl, bl);
    }

    protected void onCheckEntity(boolean bl, PSSFPluginTempl pSSFPluginTempl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSSFPluginTempl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFId(bl, pSSFPluginTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFName(bl, pSSFPluginTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPluginId(bl, pSSFPluginTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPluginTemplId(bl, pSSFPluginTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPluginTemplName(bl, pSSFPluginTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode(bl, pSSFPluginTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode2(bl, pSSFPluginTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSFPluginTempl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSFPluginTempl pSSFPluginTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPluginTempl.isMemoDirty() : !pSSFPluginTempl.isMemoDirty()) {
            return null;
        }
        String string = pSSFPluginTempl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSFPluginTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFId(boolean bl, PSSFPluginTempl pSSFPluginTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPluginTempl.isPSSFIdDirty() && !bl2 : !pSSFPluginTempl.isPSSFIdDirty()) {
            return null;
        }
        String string = pSSFPluginTempl.getPSSFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFId_Default(pSSFPluginTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFName(boolean bl, PSSFPluginTempl pSSFPluginTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPluginTempl.isPSSFNameDirty() && !bl2 : !pSSFPluginTempl.isPSSFNameDirty()) {
            return null;
        }
        String string = pSSFPluginTempl.getPSSFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFName_Default(pSSFPluginTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFPluginId(boolean bl, PSSFPluginTempl pSSFPluginTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPluginTempl.isPSSFPluginIdDirty() && !bl2 : !pSSFPluginTempl.isPSSFPluginIdDirty()) {
            return null;
        }
        String string = pSSFPluginTempl.getPSSFPluginId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPLUGINID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPluginId_Default(pSSFPluginTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFPluginTemplId(boolean bl, PSSFPluginTempl pSSFPluginTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPluginTempl.isPSSFPluginTemplIdDirty() && !bl2 : !pSSFPluginTempl.isPSSFPluginTemplIdDirty()) {
            return null;
        }
        String string = pSSFPluginTempl.getPSSFPluginTemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPLUGINTEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPluginTemplId_Default(pSSFPluginTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPLUGINTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFPluginTemplName(boolean bl, PSSFPluginTempl pSSFPluginTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPluginTempl.isPSSFPluginTemplNameDirty() && !bl2 : !pSSFPluginTempl.isPSSFPluginTemplNameDirty()) {
            return null;
        }
        String string = pSSFPluginTempl.getPSSFPluginTemplName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPLUGINTEMPLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPluginTemplName_Default(pSSFPluginTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPLUGINTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode(boolean bl, PSSFPluginTempl pSSFPluginTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPluginTempl.isTemplCodeDirty() && !bl2 : !pSSFPluginTempl.isTemplCodeDirty()) {
            return null;
        }
        String string = pSSFPluginTempl.getTemplCode();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode_Default(pSSFPluginTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode2(boolean bl, PSSFPluginTempl pSSFPluginTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPluginTempl.isTemplCode2Dirty() : !pSSFPluginTempl.isTemplCode2Dirty()) {
            return null;
        }
        String string = pSSFPluginTempl.getTemplCode2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode2_Default(pSSFPluginTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSFPluginTempl pSSFPluginTempl, boolean bl) throws Exception {
        super.onSyncEntity(pSSFPluginTempl, bl);
    }

    protected void onSyncIndexEntities(PSSFPluginTempl pSSFPluginTempl, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSFPluginTempl, bl);
    }

    public Object getDataContextValue(PSSFPluginTempl pSSFPluginTempl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSFPluginTempl, string, iDataContextParam)) != null) {
            return object;
        }
        PSSFPlugin pSSFPlugin = pSSFPluginTempl.getPSSFPlugin();
        if (pSSFPlugin != null && pSSFPlugin.contains(string)) {
            return pSSFPlugin.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSFPluginTempl pSSFPluginTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSFPluginTempl, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSSFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPLUGINTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPluginTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPLUGINTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPluginTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode2_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSSFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSFPluginTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPLUGINTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFPluginTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPLUGINTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplCode2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE2", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected boolean onMergeChild(String string, String string2, PSSFPluginTempl pSSFPluginTempl) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSFPluginTempl)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSFPluginTempl pSSFPluginTempl) throws Exception {
        super.onUpdateParent(pSSFPluginTempl);
    }

    @Override
    protected void exportCurXmlModel(PSSFPluginTempl pSSFPluginTempl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSFPLUGINTEMPL");
        if (!bl) {
            pSSFPluginTempl.setCreateDate(null);
            pSSFPluginTempl.setCreateMan(null);
            pSSFPluginTempl.setPSSFPluginTemplId(null);
            pSSFPluginTempl.setUpdateDate(null);
            pSSFPluginTempl.setUpdateMan(null);
            super.exportCurXmlModel(pSSFPluginTempl, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSFPluginTempl pSSFPluginTempl, PSSystem pSSystem) throws Exception {
        PSSFPluginTempl pSSFPluginTempl2 = new PSSFPluginTempl();
        pSSFPluginTempl2.setPSSFPluginId(pSSFPluginTempl.getPSSFPluginId());
        pSSFPluginTempl2.setPSSFId(pSSFPluginTempl.getPSSFId());
        if (this.selectOne(pSSFPluginTempl2, true)) {
            return pSSFPluginTempl2.getPSSFPluginTemplId();
        }
        return super.getEntityFolderKeyValue(pSSFPluginTempl, pSSystem);
    }
}

