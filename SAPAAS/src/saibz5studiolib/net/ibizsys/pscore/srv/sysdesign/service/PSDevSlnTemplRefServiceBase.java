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
 *  net.ibizsys.paas.service.IServicePlugin
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
package net.ibizsys.pscore.srv.sysdesign.service;

import java.sql.Timestamp;
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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnTemplRefDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnTemplRefDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTemplBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTemplRef;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnTemplRefServiceBase
extends PSCoreSysServiceBase<PSDevSlnTemplRef> {
    private static final Log log = LogFactory.getLog(PSDevSlnTemplRefServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_UPDATEREFSTATE = "UpdateRefState";
    private PSDevSlnTemplRefDEModel pSDevSlnTemplRefDEModel;
    private PSDevSlnTemplRefDAO pSDevSlnTemplRefDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplRefService";
    }

    public PSDevSlnTemplRefDEModel getPSDevSlnTemplRefDEModel() {
        if (this.pSDevSlnTemplRefDEModel == null) {
            try {
                this.pSDevSlnTemplRefDEModel = (PSDevSlnTemplRefDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnTemplRefDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnTemplRefDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnTemplRefDEModel();
    }

    public PSDevSlnTemplRefDAO getPSDevSlnTemplRefDAO() {
        if (this.pSDevSlnTemplRefDAO == null) {
            try {
                this.pSDevSlnTemplRefDAO = (PSDevSlnTemplRefDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnTemplRefDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnTemplRefDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnTemplRefDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEREFSTATE, (boolean)true) == 0) {
            this.updateRefState((PSDevSlnTemplRef)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void updateRefState(PSDevSlnTemplRef pSDevSlnTemplRef) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEREFSTATE, 0, pSDevSlnTemplRef, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnTemplRef, ACTION_UPDATEREFSTATE);
        final PSDevSlnTemplRef pSDevSlnTemplRef2 = pSDevSlnTemplRef;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnTemplRefServiceBase.this.getService(), PSDevSlnTemplRefServiceBase.ACTION_UPDATEREFSTATE, 40, pSDevSlnTemplRef2, null).getResult() != 1) {
                    PSDevSlnTemplRefServiceBase.this.onUpdateRefState(pSDevSlnTemplRef2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEREFSTATE, 99, pSDevSlnTemplRef, null);
        }
    }

    protected void onUpdateRefState(PSDevSlnTemplRef pSDevSlnTemplRef) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateRefState]");
    }

    protected void onFillParentInfo(PSDevSlnTemplRef pSDevSlnTemplRef, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNTEMPLREF_PSDEVSLNTEMPL_PSDEVSLNTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService", (SessionFactory)this.getSessionFactory());
            PSDevSlnTempl pSDevSlnTempl = (PSDevSlnTempl)iService.getDEModel().createEntity();
            pSDevSlnTempl.set("PSDEVSLNTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnTempl);
            } else {
                iService.get(pSDevSlnTempl);
            }
            this.onFillParentInfo_PSDevSlnTempl(pSDevSlnTemplRef, pSDevSlnTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNTEMPLREF_PSDEVSLNTEMPL_REFPSDEVSLNTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService", (SessionFactory)this.getSessionFactory());
            PSDevSlnTempl pSDevSlnTempl = (PSDevSlnTempl)iService.getDEModel().createEntity();
            pSDevSlnTempl.set("PSDEVSLNTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnTempl);
            } else {
                iService.get(pSDevSlnTempl);
            }
            this.onFillParentInfo_RefPSDevSlnTempl(pSDevSlnTemplRef, pSDevSlnTempl);
            return;
        }
        super.onFillParentInfo(pSDevSlnTemplRef, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevSlnTempl(PSDevSlnTemplRef pSDevSlnTemplRef, PSDevSlnTempl pSDevSlnTempl) throws Exception {
        pSDevSlnTemplRef.setPSDevCenterName(pSDevSlnTempl.getPSDevCenterName());
        pSDevSlnTemplRef.setPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
        pSDevSlnTemplRef.setPSDevSlnTemplName(pSDevSlnTempl.getPSDevSlnTemplName());
    }

    protected void onFillParentInfo_RefPSDevSlnTempl(PSDevSlnTemplRef pSDevSlnTemplRef, PSDevSlnTempl pSDevSlnTempl) throws Exception {
        pSDevSlnTemplRef.setRefPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
        pSDevSlnTemplRef.setRefPSDevSlnTemplName(pSDevSlnTempl.getPSDevSlnTemplName());
    }

    protected void onFillEntityFullInfo(PSDevSlnTemplRef pSDevSlnTemplRef, boolean bl) throws Exception {
        if (bl) {
            if (pSDevSlnTemplRef.getRefState() == null) {
                pSDevSlnTemplRef.setRefState((Integer)this.getDefaultValue(this.getWebContext(), "", "10", 9));
            }
            if (pSDevSlnTemplRef.getValidFlag() == null) {
                pSDevSlnTemplRef.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDevSlnTemplRef, bl);
        this.onFillEntityFullInfo_PSDevSlnTempl(pSDevSlnTemplRef, bl);
        this.onFillEntityFullInfo_RefPSDevSlnTempl(pSDevSlnTemplRef, bl);
    }

    protected void onFillEntityFullInfo_PSDevSlnTempl(PSDevSlnTemplRef pSDevSlnTemplRef, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDevSlnTempl(PSDevSlnTemplRef pSDevSlnTemplRef, boolean bl) throws Exception {
        if (pSDevSlnTemplRef.isRefPSDevSlnTemplIdDirty()) {
            if (pSDevSlnTemplRef.getRefPSDevSlnTemplId() != null) {
                if (pSDevSlnTemplRef.getRefPSDevSlnTemplId() == null || pSDevSlnTemplRef.getRefPSDevSlnTemplName() == null) {
                    PSDevSlnTempl pSDevSlnTempl = pSDevSlnTemplRef.getRefPSDevSlnTempl();
                    pSDevSlnTemplRef.setRefPSDevSlnTemplName(pSDevSlnTempl.getPSDevSlnTemplName());
                }
            } else {
                pSDevSlnTemplRef.setRefPSDevSlnTemplName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDevSlnTemplRef pSDevSlnTemplRef, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevSlnTemplRef, bl);
    }

    public ArrayList<PSDevSlnTemplRef> selectByPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase) throws Exception {
        return this.selectByPSDevSlnTempl(pSDevSlnTemplBase, "", -1);
    }

    public ArrayList<PSDevSlnTemplRef> selectByPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase, String string) throws Exception {
        return this.selectByPSDevSlnTempl(pSDevSlnTemplBase, string, -1);
    }

    public ArrayList<PSDevSlnTemplRef> selectByPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNTEMPLID", (Object)pSDevSlnTemplBase.getPSDevSlnTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnTemplRef> selectByRefPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase) throws Exception {
        return this.selectByRefPSDevSlnTempl(pSDevSlnTemplBase, "", -1);
    }

    public ArrayList<PSDevSlnTemplRef> selectByRefPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase, String string) throws Exception {
        return this.selectByRefPSDevSlnTempl(pSDevSlnTemplBase, string, -1);
    }

    public ArrayList<PSDevSlnTemplRef> selectByRefPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEVSLNTEMPLID", (Object)pSDevSlnTemplBase.getPSDevSlnTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDevSlnTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDevSlnTemplCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
    }

    public void resetPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        ArrayList<PSDevSlnTemplRef> arrayList = this.selectByPSDevSlnTempl(pSDevSlnTempl);
        for (PSDevSlnTemplRef pSDevSlnTemplRef : arrayList) {
            PSDevSlnTemplRef pSDevSlnTemplRef2 = (PSDevSlnTemplRef)this.getDEModel().createEntity();
            pSDevSlnTemplRef2.setPSDevSlnTemplRefId(pSDevSlnTemplRef.getPSDevSlnTemplRefId());
            pSDevSlnTemplRef2.setPSDevSlnTemplId(null);
            this.update(pSDevSlnTemplRef2);
        }
    }

    public void removeByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        final PSDevSlnTempl pSDevSlnTempl2 = pSDevSlnTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnTemplRefServiceBase.this.onBeforeRemoveByPSDevSlnTempl(pSDevSlnTempl2);
                PSDevSlnTemplRefServiceBase.this.internalRemoveByPSDevSlnTempl(pSDevSlnTempl2);
                PSDevSlnTemplRefServiceBase.this.onAfterRemoveByPSDevSlnTempl(pSDevSlnTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
    }

    protected void internalRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        ArrayList<PSDevSlnTemplRef> arrayList = this.selectByPSDevSlnTempl(pSDevSlnTempl);
        this.onBeforeRemoveByPSDevSlnTempl(pSDevSlnTempl, arrayList);
        for (PSDevSlnTemplRef pSDevSlnTemplRef : arrayList) {
            this.remove(pSDevSlnTemplRef);
        }
        this.onAfterRemoveByPSDevSlnTempl(pSDevSlnTempl, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl, ArrayList<PSDevSlnTemplRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl, ArrayList<PSDevSlnTemplRef> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
    }

    public void resetRefPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        ArrayList<PSDevSlnTemplRef> arrayList = this.selectByRefPSDevSlnTempl(pSDevSlnTempl);
        for (PSDevSlnTemplRef pSDevSlnTemplRef : arrayList) {
            PSDevSlnTemplRef pSDevSlnTemplRef2 = (PSDevSlnTemplRef)this.getDEModel().createEntity();
            pSDevSlnTemplRef2.setPSDevSlnTemplRefId(pSDevSlnTemplRef.getPSDevSlnTemplRefId());
            pSDevSlnTemplRef2.setRefPSDevSlnTemplId(null);
            this.update(pSDevSlnTemplRef2);
        }
    }

    public void removeByRefPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        final PSDevSlnTempl pSDevSlnTempl2 = pSDevSlnTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnTemplRefServiceBase.this.onBeforeRemoveByRefPSDevSlnTempl(pSDevSlnTempl2);
                PSDevSlnTemplRefServiceBase.this.internalRemoveByRefPSDevSlnTempl(pSDevSlnTempl2);
                PSDevSlnTemplRefServiceBase.this.onAfterRemoveByRefPSDevSlnTempl(pSDevSlnTempl2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
    }

    protected void internalRemoveByRefPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        ArrayList<PSDevSlnTemplRef> arrayList = this.selectByRefPSDevSlnTempl(pSDevSlnTempl);
        this.onBeforeRemoveByRefPSDevSlnTempl(pSDevSlnTempl, arrayList);
        for (PSDevSlnTemplRef pSDevSlnTemplRef : arrayList) {
            this.remove(pSDevSlnTemplRef);
        }
        this.onAfterRemoveByRefPSDevSlnTempl(pSDevSlnTempl, arrayList);
    }

    protected void onAfterRemoveByRefPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl, ArrayList<PSDevSlnTemplRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl, ArrayList<PSDevSlnTemplRef> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnTemplRef pSDevSlnTemplRef) throws Exception {
        super.onBeforeRemove(pSDevSlnTemplRef);
    }

    protected void replaceParentInfo(PSDevSlnTemplRef pSDevSlnTemplRef, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevSlnTemplRef, cloneSession);
        if (pSDevSlnTemplRef.getPSDevSlnTemplId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNTEMPL", (Object)pSDevSlnTemplRef.getPSDevSlnTemplId())) != null) {
            this.onFillParentInfo_PSDevSlnTempl(pSDevSlnTemplRef, (PSDevSlnTempl)iEntity);
        }
        if (pSDevSlnTemplRef.getRefPSDevSlnTemplId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNTEMPL", (Object)pSDevSlnTemplRef.getRefPSDevSlnTemplId())) != null) {
            this.onFillParentInfo_RefPSDevSlnTempl(pSDevSlnTemplRef, (PSDevSlnTempl)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnTemplRef pSDevSlnTemplRef, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevSlnTemplRef, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnTemplRef pSDevSlnTemplRef, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AccessToken(bl, pSDevSlnTemplRef, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeginTime(bl, pSDevSlnTemplRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndTime(bl, pSDevSlnTemplRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnTemplRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnTemplId(bl, pSDevSlnTemplRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnTemplRefId(bl, pSDevSlnTemplRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnTemplRefName(bl, pSDevSlnTemplRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDevSlnTemplId(bl, pSDevSlnTemplRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDevSlnTemplName(bl, pSDevSlnTemplRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefRepMsg(bl, pSDevSlnTemplRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefReqMsg(bl, pSDevSlnTemplRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefState(bl, pSDevSlnTemplRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefStateInfo(bl, pSDevSlnTemplRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDevSlnTemplRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevSlnTemplRef, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AccessToken(boolean bl, PSDevSlnTemplRef pSDevSlnTemplRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTemplRef.isAccessTokenDirty() && !bl2 : !pSDevSlnTemplRef.isAccessTokenDirty()) {
            return null;
        }
        String string = pSDevSlnTemplRef.getAccessToken();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACCESSTOKEN");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_AccessToken_Default(pSDevSlnTemplRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACCESSTOKEN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BeginTime(boolean bl, PSDevSlnTemplRef pSDevSlnTemplRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTemplRef.isBeginTimeDirty() : !pSDevSlnTemplRef.isBeginTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnTemplRef.getBeginTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BeginTime_Default(pSDevSlnTemplRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndTime(boolean bl, PSDevSlnTemplRef pSDevSlnTemplRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTemplRef.isEndTimeDirty() : !pSDevSlnTemplRef.isEndTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnTemplRef.getEndTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EndTime_Default(pSDevSlnTemplRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnTemplRef pSDevSlnTemplRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTemplRef.isMemoDirty() : !pSDevSlnTemplRef.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnTemplRef.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevSlnTemplRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnTemplId(boolean bl, PSDevSlnTemplRef pSDevSlnTemplRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTemplRef.isPSDevSlnTemplIdDirty() && !bl2 : !pSDevSlnTemplRef.isPSDevSlnTemplIdDirty()) {
            return null;
        }
        String string = pSDevSlnTemplRef.getPSDevSlnTemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNTEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnTemplId_Default(pSDevSlnTemplRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnTemplRefId(boolean bl, PSDevSlnTemplRef pSDevSlnTemplRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTemplRef.isPSDevSlnTemplRefIdDirty() && !bl2 : !pSDevSlnTemplRef.isPSDevSlnTemplRefIdDirty()) {
            return null;
        }
        String string = pSDevSlnTemplRef.getPSDevSlnTemplRefId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNTEMPLREFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnTemplRefId_Default(pSDevSlnTemplRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNTEMPLREFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnTemplRefName(boolean bl, PSDevSlnTemplRef pSDevSlnTemplRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTemplRef.isPSDevSlnTemplRefNameDirty() && !bl2 : !pSDevSlnTemplRef.isPSDevSlnTemplRefNameDirty()) {
            return null;
        }
        String string = pSDevSlnTemplRef.getPSDevSlnTemplRefName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNTEMPLREFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnTemplRefName_Default(pSDevSlnTemplRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNTEMPLREFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSDEVSLNTEMPLID";
                String string4 = this.checkFieldDupRule(this.getPSDevSlnTemplRefDEModel(), "PSDEVSLNTEMPLREFNAME", string3, pSDevSlnTemplRef, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEVSLNTEMPLREFNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDevSlnTemplId(boolean bl, PSDevSlnTemplRef pSDevSlnTemplRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTemplRef.isRefPSDevSlnTemplIdDirty() && !bl2 : !pSDevSlnTemplRef.isRefPSDevSlnTemplIdDirty()) {
            return null;
        }
        String string = pSDevSlnTemplRef.getRefPSDevSlnTemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEVSLNTEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDevSlnTemplId_Default(pSDevSlnTemplRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEVSLNTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSDEVSLNTEMPLID";
                String string4 = this.checkFieldDupRule(this.getPSDevSlnTemplRefDEModel(), "REFPSDEVSLNTEMPLID", string3, pSDevSlnTemplRef, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("REFPSDEVSLNTEMPLID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDevSlnTemplName(boolean bl, PSDevSlnTemplRef pSDevSlnTemplRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTemplRef.isRefPSDevSlnTemplNameDirty() && !bl2 : !pSDevSlnTemplRef.isRefPSDevSlnTemplNameDirty()) {
            return null;
        }
        String string = pSDevSlnTemplRef.getRefPSDevSlnTemplName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEVSLNTEMPLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDevSlnTemplName_Default(pSDevSlnTemplRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEVSLNTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefRepMsg(boolean bl, PSDevSlnTemplRef pSDevSlnTemplRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTemplRef.isRefRepMsgDirty() : !pSDevSlnTemplRef.isRefRepMsgDirty()) {
            return null;
        }
        String string = pSDevSlnTemplRef.getRefRepMsg();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefRepMsg_Default(pSDevSlnTemplRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFREPMSG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefReqMsg(boolean bl, PSDevSlnTemplRef pSDevSlnTemplRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTemplRef.isRefReqMsgDirty() : !pSDevSlnTemplRef.isRefReqMsgDirty()) {
            return null;
        }
        String string = pSDevSlnTemplRef.getRefReqMsg();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefReqMsg_Default(pSDevSlnTemplRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFREQMSG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefState(boolean bl, PSDevSlnTemplRef pSDevSlnTemplRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTemplRef.isRefStateDirty() && !bl2 : !pSDevSlnTemplRef.isRefStateDirty()) {
            return null;
        }
        Integer n = pSDevSlnTemplRef.getRefState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_RefState_Default(pSDevSlnTemplRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefStateInfo(boolean bl, PSDevSlnTemplRef pSDevSlnTemplRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTemplRef.isRefStateInfoDirty() : !pSDevSlnTemplRef.isRefStateInfoDirty()) {
            return null;
        }
        String string = pSDevSlnTemplRef.getRefStateInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefStateInfo_Default(pSDevSlnTemplRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFSTATEINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDevSlnTemplRef pSDevSlnTemplRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTemplRef.isValidFlagDirty() && !bl2 : !pSDevSlnTemplRef.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnTemplRef.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDevSlnTemplRef, bl2, bl3);
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

    protected void onSyncEntity(PSDevSlnTemplRef pSDevSlnTemplRef, boolean bl) throws Exception {
        super.onSyncEntity(pSDevSlnTemplRef, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnTemplRef pSDevSlnTemplRef, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevSlnTemplRef, bl);
    }

    public Object getDataContextValue(PSDevSlnTemplRef pSDevSlnTemplRef, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevSlnTemplRef, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevSlnTempl pSDevSlnTempl = pSDevSlnTemplRef.getPSDevSlnTempl();
        if (pSDevSlnTempl != null && pSDevSlnTempl.contains(string)) {
            return pSDevSlnTempl.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnTemplRef pSDevSlnTemplRef, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevSlnTemplRef, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACCESSTOKEN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AccessToken_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BEGINTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNTEMPLREFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnTemplRefId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNTEMPLREFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnTemplRefName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEVSLNTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDevSlnTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEVSLNTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDevSlnTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFREPMSG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefRepMsg_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFREQMSG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefReqMsg_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFSTATEINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefStateInfo_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AccessToken_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACCESSTOKEN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BeginTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_EndTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDevCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNTEMPLNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnTemplRefId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNTEMPLREFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnTemplRefName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNTEMPLREFNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("PSDEVSLNTEMPLREFNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDevSlnTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEVSLNTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDevSlnTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEVSLNTEMPLNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefRepMsg_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFREPMSG", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefReqMsg_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFREQMSG", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RefStateInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFSTATEINFO", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDevSlnTemplRef pSDevSlnTemplRef) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevSlnTemplRef)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnTemplRef pSDevSlnTemplRef) throws Exception {
        super.onUpdateParent(pSDevSlnTemplRef);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnTemplRef pSDevSlnTemplRef, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNTEMPLREF");
        if (!bl) {
            pSDevSlnTemplRef.setCreateDate(null);
            pSDevSlnTemplRef.setCreateMan(null);
            pSDevSlnTemplRef.setPSDevSlnTemplRefId(null);
            pSDevSlnTemplRef.setRefPSDevSlnTemplId(null);
            pSDevSlnTemplRef.setRefPSDevSlnTemplName(null);
            pSDevSlnTemplRef.setUpdateDate(null);
            pSDevSlnTemplRef.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnTemplRef, xmlNode, bl);
        }
    }
}

