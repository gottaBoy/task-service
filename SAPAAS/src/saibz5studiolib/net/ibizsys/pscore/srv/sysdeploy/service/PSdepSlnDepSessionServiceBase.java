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
package net.ibizsys.pscore.srv.sysdeploy.service;

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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSdepSlnDepSessionDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSdepSlnDepSessionDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnPack;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnPackBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSdepSlnDepSession;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSdepSlnDepSessionServiceBase
extends PSCoreSysServiceBase<PSdepSlnDepSession> {
    private static final Log log = LogFactory.getLog(PSdepSlnDepSessionServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSdepSlnDepSessionDEModel pSdepSlnDepSessionDEModel;
    private PSdepSlnDepSessionDAO pSdepSlnDepSessionDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSdepSlnDepSessionService";
    }

    public PSdepSlnDepSessionDEModel getPSdepSlnDepSessionDEModel() {
        if (this.pSdepSlnDepSessionDEModel == null) {
            try {
                this.pSdepSlnDepSessionDEModel = (PSdepSlnDepSessionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSdepSlnDepSessionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSdepSlnDepSessionDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSdepSlnDepSessionDEModel();
    }

    public PSdepSlnDepSessionDAO getPSdepSlnDepSessionDAO() {
        if (this.pSdepSlnDepSessionDAO == null) {
            try {
                this.pSdepSlnDepSessionDAO = (PSdepSlnDepSessionDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSdepSlnDepSessionDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSdepSlnDepSessionDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSdepSlnDepSessionDAO();
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

    protected void onFillParentInfo(PSdepSlnDepSession pSdepSlnDepSession, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNDEPSESSION_PSDEPSLNPACK_PSDEPSLNPACKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPackService", (SessionFactory)this.getSessionFactory());
            PSDepSlnPack pSDepSlnPack = (PSDepSlnPack)iService.getDEModel().createEntity();
            pSDepSlnPack.set("PSDEPSLNPACKID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSlnPack);
            } else {
                iService.get((IEntity)pSDepSlnPack);
            }
            this.onFillParentInfo_PSDepSlnPack(pSdepSlnDepSession, pSDepSlnPack);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNDEPSESSION_PSDEPSLN_PSDEPSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService", (SessionFactory)this.getSessionFactory());
            PSDepSln pSDepSln = (PSDepSln)iService.getDEModel().createEntity();
            pSDepSln.set("PSDEPSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSln);
            } else {
                iService.get((IEntity)pSDepSln);
            }
            this.onFillParentInfo_PSDepSln(pSdepSlnDepSession, pSDepSln);
            return;
        }
        super.onFillParentInfo((IEntity)pSdepSlnDepSession, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDepSlnPack(PSdepSlnDepSession pSdepSlnDepSession, PSDepSlnPack pSDepSlnPack) throws Exception {
        pSdepSlnDepSession.setPSDepSlnPackId(pSDepSlnPack.getPSDepSlnPackId());
        pSdepSlnDepSession.setPSDepSlnPackName(pSDepSlnPack.getPSDepSlnPackName());
        if (pSDepSlnPack.getPSDepSln() != null) {
            this.onFillParentInfo_PSDepSln(pSdepSlnDepSession, pSDepSlnPack.getPSDepSln());
        }
    }

    protected void onFillParentInfo_PSDepSln(PSdepSlnDepSession pSdepSlnDepSession, PSDepSln pSDepSln) throws Exception {
        pSdepSlnDepSession.setPSDepSlnId(pSDepSln.getPSDepSlnId());
        pSdepSlnDepSession.setPSDepSlnName(pSDepSln.getPSDepSlnName());
    }

    protected void onFillEntityFullInfo(PSdepSlnDepSession pSdepSlnDepSession, boolean bl) throws Exception {
        if (bl && pSdepSlnDepSession.getDepState() == null) {
            pSdepSlnDepSession.setDepState((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSdepSlnDepSession, bl);
        this.onFillEntityFullInfo_PSDepSlnPack(pSdepSlnDepSession, bl);
        this.onFillEntityFullInfo_PSDepSln(pSdepSlnDepSession, bl);
    }

    protected void onFillEntityFullInfo_PSDepSlnPack(PSdepSlnDepSession pSdepSlnDepSession, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSln(PSdepSlnDepSession pSdepSlnDepSession, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSdepSlnDepSession pSdepSlnDepSession, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSdepSlnDepSession, bl);
    }

    public ArrayList<PSdepSlnDepSession> selectByPSDepSlnPack(PSDepSlnPackBase pSDepSlnPackBase) throws Exception {
        return this.selectByPSDepSlnPack(pSDepSlnPackBase, "", -1);
    }

    public ArrayList<PSdepSlnDepSession> selectByPSDepSlnPack(PSDepSlnPackBase pSDepSlnPackBase, String string) throws Exception {
        return this.selectByPSDepSlnPack(pSDepSlnPackBase, string, -1);
    }

    public ArrayList<PSdepSlnDepSession> selectByPSDepSlnPack(PSDepSlnPackBase pSDepSlnPackBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNPACKID", (Object)pSDepSlnPackBase.getPSDepSlnPackId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnPackCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnPackCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSdepSlnDepSession> selectByPSDepSln(PSDepSlnBase pSDepSlnBase) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, "", -1);
    }

    public ArrayList<PSdepSlnDepSession> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, string, -1);
    }

    public ArrayList<PSdepSlnDepSession> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNID", (Object)pSDepSlnBase.getPSDepSlnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDepSlnPack(PSDepSlnPack pSDepSlnPack) throws Exception {
        ArrayList<PSdepSlnDepSession> arrayList = this.selectByPSDepSlnPack(pSDepSlnPack, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNPACK");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSlnPack);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNDEPSESSION_PSDEPSLNPACK_PSDEPSLNPACKID", "", iDataEntityModel.getName(), "PSDEPSLNDEPSESSION", iDataEntityModel.getDataInfo((IEntity)pSDepSlnPack), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnPack(PSDepSlnPack pSDepSlnPack) throws Exception {
        ArrayList<PSdepSlnDepSession> arrayList = this.selectByPSDepSlnPack(pSDepSlnPack);
        for (PSdepSlnDepSession pSdepSlnDepSession : arrayList) {
            PSdepSlnDepSession pSdepSlnDepSession2 = (PSdepSlnDepSession)this.getDEModel().createEntity();
            pSdepSlnDepSession2.setPSDepSlnDepSessionId(pSdepSlnDepSession.getPSDepSlnDepSessionId());
            pSdepSlnDepSession2.setPSDepSlnPackId(null);
            this.update(pSdepSlnDepSession2);
        }
    }

    public void removeByPSDepSlnPack(PSDepSlnPack pSDepSlnPack) throws Exception {
        final PSDepSlnPack pSDepSlnPack2 = pSDepSlnPack;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSdepSlnDepSessionServiceBase.this.onBeforeRemoveByPSDepSlnPack(pSDepSlnPack2);
                PSdepSlnDepSessionServiceBase.this.internalRemoveByPSDepSlnPack(pSDepSlnPack2);
                PSdepSlnDepSessionServiceBase.this.onAfterRemoveByPSDepSlnPack(pSDepSlnPack2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnPack(PSDepSlnPack pSDepSlnPack) throws Exception {
    }

    protected void internalRemoveByPSDepSlnPack(PSDepSlnPack pSDepSlnPack) throws Exception {
        ArrayList<PSdepSlnDepSession> arrayList = this.selectByPSDepSlnPack(pSDepSlnPack);
        this.onBeforeRemoveByPSDepSlnPack(pSDepSlnPack, arrayList);
        for (PSdepSlnDepSession pSdepSlnDepSession : arrayList) {
            this.remove((IEntity)pSdepSlnDepSession);
        }
        this.onAfterRemoveByPSDepSlnPack(pSDepSlnPack, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnPack(PSDepSlnPack pSDepSlnPack) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnPack(PSDepSlnPack pSDepSlnPack, ArrayList<PSdepSlnDepSession> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnPack(PSDepSlnPack pSDepSlnPack, ArrayList<PSdepSlnDepSession> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSdepSlnDepSession> arrayList = this.selectByPSDepSln(pSDepSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNDEPSESSION_PSDEPSLN_PSDEPSLNID", "", iDataEntityModel.getName(), "PSDEPSLNDEPSESSION", iDataEntityModel.getDataInfo((IEntity)pSDepSln), arrayList.get(0)));
        }
    }

    public void resetPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSdepSlnDepSession> arrayList = this.selectByPSDepSln(pSDepSln);
        for (PSdepSlnDepSession pSdepSlnDepSession : arrayList) {
            PSdepSlnDepSession pSdepSlnDepSession2 = (PSdepSlnDepSession)this.getDEModel().createEntity();
            pSdepSlnDepSession2.setPSDepSlnDepSessionId(pSdepSlnDepSession.getPSDepSlnDepSessionId());
            pSdepSlnDepSession2.setPSDepSlnId(null);
            this.update(pSdepSlnDepSession2);
        }
    }

    public void removeByPSDepSln(PSDepSln pSDepSln) throws Exception {
        final PSDepSln pSDepSln2 = pSDepSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSdepSlnDepSessionServiceBase.this.onBeforeRemoveByPSDepSln(pSDepSln2);
                PSdepSlnDepSessionServiceBase.this.internalRemoveByPSDepSln(pSDepSln2);
                PSdepSlnDepSessionServiceBase.this.onAfterRemoveByPSDepSln(pSDepSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void internalRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSdepSlnDepSession> arrayList = this.selectByPSDepSln(pSDepSln);
        this.onBeforeRemoveByPSDepSln(pSDepSln, arrayList);
        for (PSdepSlnDepSession pSdepSlnDepSession : arrayList) {
            this.remove((IEntity)pSdepSlnDepSession);
        }
        this.onAfterRemoveByPSDepSln(pSDepSln, arrayList);
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSdepSlnDepSession> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSdepSlnDepSession> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSdepSlnDepSession pSdepSlnDepSession) throws Exception {
        super.onBeforeRemove(pSdepSlnDepSession);
    }

    protected void replaceParentInfo(PSdepSlnDepSession pSdepSlnDepSession, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSdepSlnDepSession, cloneSession);
        if (pSdepSlnDepSession.getPSDepSlnPackId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNPACK", (Object)pSdepSlnDepSession.getPSDepSlnPackId())) != null) {
            this.onFillParentInfo_PSDepSlnPack(pSdepSlnDepSession, (PSDepSlnPack)iEntity);
        }
        if (pSdepSlnDepSession.getPSDepSlnId() != null && (iEntity = cloneSession.getEntity("PSDEPSLN", (Object)pSdepSlnDepSession.getPSDepSlnId())) != null) {
            this.onFillParentInfo_PSDepSln(pSdepSlnDepSession, (PSDepSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSdepSlnDepSession pSdepSlnDepSession, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSdepSlnDepSession, bl);
    }

    protected void onCheckEntity(boolean bl, PSdepSlnDepSession pSdepSlnDepSession, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BeginTime(bl, pSdepSlnDepSession, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DepInfo(bl, pSdepSlnDepSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DepState(bl, pSdepSlnDepSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndTime(bl, pSdepSlnDepSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSdepSlnDepSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnDepSessionId(bl, pSdepSlnDepSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnDepSessionName(bl, pSdepSlnDepSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnId(bl, pSdepSlnDepSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnPackId(bl, pSdepSlnDepSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSdepSlnDepSession, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BeginTime(boolean bl, PSdepSlnDepSession pSdepSlnDepSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSdepSlnDepSession.isBeginTimeDirty() : !pSdepSlnDepSession.isBeginTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSdepSlnDepSession.getBeginTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BeginTime_Default((IEntity)pSdepSlnDepSession, bl2, bl3);
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

    protected EntityFieldError onCheckField_DepInfo(boolean bl, PSdepSlnDepSession pSdepSlnDepSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSdepSlnDepSession.isDepInfoDirty() : !pSdepSlnDepSession.isDepInfoDirty()) {
            return null;
        }
        String string = pSdepSlnDepSession.getDepInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DepInfo_Default((IEntity)pSdepSlnDepSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DepState(boolean bl, PSdepSlnDepSession pSdepSlnDepSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSdepSlnDepSession.isDepStateDirty() && !bl2 : !pSdepSlnDepSession.isDepStateDirty()) {
            return null;
        }
        Integer n = pSdepSlnDepSession.getDepState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DepState_Default((IEntity)pSdepSlnDepSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndTime(boolean bl, PSdepSlnDepSession pSdepSlnDepSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSdepSlnDepSession.isEndTimeDirty() : !pSdepSlnDepSession.isEndTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSdepSlnDepSession.getEndTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EndTime_Default((IEntity)pSdepSlnDepSession, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSdepSlnDepSession pSdepSlnDepSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSdepSlnDepSession.isMemoDirty() : !pSdepSlnDepSession.isMemoDirty()) {
            return null;
        }
        String string = pSdepSlnDepSession.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSdepSlnDepSession, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnDepSessionId(boolean bl, PSdepSlnDepSession pSdepSlnDepSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSdepSlnDepSession.isPSDepSlnDepSessionIdDirty() && !bl2 : !pSdepSlnDepSession.isPSDepSlnDepSessionIdDirty()) {
            return null;
        }
        String string = pSdepSlnDepSession.getPSDepSlnDepSessionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNDEPSESSIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnDepSessionId_Default((IEntity)pSdepSlnDepSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNDEPSESSIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnDepSessionName(boolean bl, PSdepSlnDepSession pSdepSlnDepSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSdepSlnDepSession.isPSDepSlnDepSessionNameDirty() && !bl2 : !pSdepSlnDepSession.isPSDepSlnDepSessionNameDirty()) {
            return null;
        }
        String string = pSdepSlnDepSession.getPSDepSlnDepSessionName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNDEPSESSIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnDepSessionName_Default((IEntity)pSdepSlnDepSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNDEPSESSIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnId(boolean bl, PSdepSlnDepSession pSdepSlnDepSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSdepSlnDepSession.isPSDepSlnIdDirty() && !bl2 : !pSdepSlnDepSession.isPSDepSlnIdDirty()) {
            return null;
        }
        String string = pSdepSlnDepSession.getPSDepSlnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnId_Default((IEntity)pSdepSlnDepSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnPackId(boolean bl, PSdepSlnDepSession pSdepSlnDepSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSdepSlnDepSession.isPSDepSlnPackIdDirty() && !bl2 : !pSdepSlnDepSession.isPSDepSlnPackIdDirty()) {
            return null;
        }
        String string = pSdepSlnDepSession.getPSDepSlnPackId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNPACKID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnPackId_Default((IEntity)pSdepSlnDepSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNPACKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSdepSlnDepSession pSdepSlnDepSession, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSdepSlnDepSession, bl);
    }

    protected void onSyncIndexEntities(PSdepSlnDepSession pSdepSlnDepSession, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSdepSlnDepSession, bl);
    }

    public Object getDataContextValue(PSdepSlnDepSession pSdepSlnDepSession, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSdepSlnDepSession, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSdepSlnDepSession pSdepSlnDepSession, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSdepSlnDepSession, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BEGINTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DepInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DepState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNDEPSESSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnDepSessionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNDEPSESSIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnDepSessionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNPACKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnPackId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNPACKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnPackName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_DepInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEPINFO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DepState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDepSlnDepSessionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNDEPSESSIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnDepSessionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNDEPSESSIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnPackId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNPACKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnPackName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNPACKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSdepSlnDepSession pSdepSlnDepSession) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSdepSlnDepSession)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSdepSlnDepSession pSdepSlnDepSession) throws Exception {
        super.onUpdateParent((IEntity)pSdepSlnDepSession);
    }

    @Override
    protected void exportCurXmlModel(PSdepSlnDepSession pSdepSlnDepSession, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNDEPSESSION");
        if (!bl) {
            pSdepSlnDepSession.setBeginTime(null);
            pSdepSlnDepSession.setCreateDate(null);
            pSdepSlnDepSession.setCreateMan(null);
            pSdepSlnDepSession.setEndTime(null);
            pSdepSlnDepSession.setPSDepSlnDepSessionId(null);
            pSdepSlnDepSession.setUpdateDate(null);
            pSdepSlnDepSession.setUpdateMan(null);
            super.exportCurXmlModel(pSdepSlnDepSession, xmlNode, bl);
        }
    }
}

