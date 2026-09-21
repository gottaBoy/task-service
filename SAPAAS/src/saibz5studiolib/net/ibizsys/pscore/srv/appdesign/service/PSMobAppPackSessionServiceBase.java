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
package net.ibizsys.pscore.srv.appdesign.service;

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
import net.ibizsys.pscore.srv.appdesign.dao.PSMobAppPackSessionDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSMobAppPackSessionDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppPack;
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppPackBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppPackSession;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSMobAppPackSessionServiceBase
extends PSCoreSysServiceBase<PSMobAppPackSession> {
    private static final Log log = LogFactory.getLog(PSMobAppPackSessionServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSMobAppPackSessionDEModel pSMobAppPackSessionDEModel;
    private PSMobAppPackSessionDAO pSMobAppPackSessionDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSMobAppPackSessionService";
    }

    public PSMobAppPackSessionDEModel getPSMobAppPackSessionDEModel() {
        if (this.pSMobAppPackSessionDEModel == null) {
            try {
                this.pSMobAppPackSessionDEModel = (PSMobAppPackSessionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSMobAppPackSessionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSMobAppPackSessionDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSMobAppPackSessionDEModel();
    }

    public PSMobAppPackSessionDAO getPSMobAppPackSessionDAO() {
        if (this.pSMobAppPackSessionDAO == null) {
            try {
                this.pSMobAppPackSessionDAO = (PSMobAppPackSessionDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSMobAppPackSessionDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSMobAppPackSessionDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSMobAppPackSessionDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSMobAppPackSession pSMobAppPackSession, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMOBAPPPACKSESSION_PSMOBAPPPACK_PSMOBAPPPACKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSMobAppPackService", (SessionFactory)this.getSessionFactory());
            PSMobAppPack pSMobAppPack = (PSMobAppPack)iService.getDEModel().createEntity();
            pSMobAppPack.set("PSMOBAPPPACKID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSMobAppPack);
            } else {
                iService.get((IEntity)pSMobAppPack);
            }
            this.onFillParentInfo_PSMobAppPack(pSMobAppPackSession, pSMobAppPack);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMOBAPPPACKSESSION_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysApp);
            } else {
                iService.get((IEntity)pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSMobAppPackSession, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMOBAPPPACKSESSION_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSMobAppPackSession, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSMobAppPackSession, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSMobAppPack(PSMobAppPackSession pSMobAppPackSession, PSMobAppPack pSMobAppPack) throws Exception {
        pSMobAppPackSession.setPSMobAppPackId(pSMobAppPack.getPSMobAppPackId());
        pSMobAppPackSession.setPSMobAppPackName(pSMobAppPack.getPSMobAppPackName());
    }

    protected void onFillParentInfo_PSSysApp(PSMobAppPackSession pSMobAppPackSession, PSSysApp pSSysApp) throws Exception {
        pSMobAppPackSession.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSMobAppPackSession.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_PSSystem(PSMobAppPackSession pSMobAppPackSession, PSSystem pSSystem) throws Exception {
        pSMobAppPackSession.setPSSystemId(pSSystem.getPSSystemId());
        pSMobAppPackSession.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSMobAppPackSession pSMobAppPackSession, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSMobAppPackSession, bl);
        this.onFillEntityFullInfo_PSMobAppPack(pSMobAppPackSession, bl);
        this.onFillEntityFullInfo_PSSysApp(pSMobAppPackSession, bl);
        this.onFillEntityFullInfo_PSSystem(pSMobAppPackSession, bl);
    }

    protected void onFillEntityFullInfo_PSMobAppPack(PSMobAppPackSession pSMobAppPackSession, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysApp(PSMobAppPackSession pSMobAppPackSession, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSMobAppPackSession pSMobAppPackSession, boolean bl) throws Exception {
        if (pSMobAppPackSession.isPSSystemIdDirty()) {
            if (pSMobAppPackSession.getPSSystemId() != null) {
                if (pSMobAppPackSession.getPSSystemId() == null || pSMobAppPackSession.getPSSystemName() == null) {
                    PSSystem pSSystem = pSMobAppPackSession.getPSSystem();
                    pSMobAppPackSession.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSMobAppPackSession.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSMobAppPackSession pSMobAppPackSession, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSMobAppPackSession, bl);
    }

    public ArrayList<PSMobAppPackSession> selectByPSMobAppPack(PSMobAppPackBase pSMobAppPackBase) throws Exception {
        return this.selectByPSMobAppPack(pSMobAppPackBase, "", -1);
    }

    public ArrayList<PSMobAppPackSession> selectByPSMobAppPack(PSMobAppPackBase pSMobAppPackBase, String string) throws Exception {
        return this.selectByPSMobAppPack(pSMobAppPackBase, string, -1);
    }

    public ArrayList<PSMobAppPackSession> selectByPSMobAppPack(PSMobAppPackBase pSMobAppPackBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMOBAPPPACKID", (Object)pSMobAppPackBase.getPSMobAppPackId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSMobAppPackCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSMobAppPackCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSMobAppPackSession> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSMobAppPackSession> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSMobAppPackSession> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAPPID", (Object)pSSysAppBase.getPSSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSMobAppPackSession> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSMobAppPackSession> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSMobAppPackSession> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMID", (Object)pSSystemBase.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSMobAppPack(PSMobAppPack pSMobAppPack) throws Exception {
    }

    public void resetPSMobAppPack(PSMobAppPack pSMobAppPack) throws Exception {
        ArrayList<PSMobAppPackSession> arrayList = this.selectByPSMobAppPack(pSMobAppPack);
        for (PSMobAppPackSession pSMobAppPackSession : arrayList) {
            PSMobAppPackSession pSMobAppPackSession2 = (PSMobAppPackSession)this.getDEModel().createEntity();
            pSMobAppPackSession2.setPSMobAppPackSessionId(pSMobAppPackSession.getPSMobAppPackSessionId());
            pSMobAppPackSession2.setPSMobAppPackId(null);
            this.update(pSMobAppPackSession2);
        }
    }

    public void removeByPSMobAppPack(PSMobAppPack pSMobAppPack) throws Exception {
        final PSMobAppPack pSMobAppPack2 = pSMobAppPack;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSMobAppPackSessionServiceBase.this.onBeforeRemoveByPSMobAppPack(pSMobAppPack2);
                PSMobAppPackSessionServiceBase.this.internalRemoveByPSMobAppPack(pSMobAppPack2);
                PSMobAppPackSessionServiceBase.this.onAfterRemoveByPSMobAppPack(pSMobAppPack2);
            }
        });
    }

    protected void onBeforeRemoveByPSMobAppPack(PSMobAppPack pSMobAppPack) throws Exception {
    }

    protected void internalRemoveByPSMobAppPack(PSMobAppPack pSMobAppPack) throws Exception {
        ArrayList<PSMobAppPackSession> arrayList = this.selectByPSMobAppPack(pSMobAppPack);
        this.onBeforeRemoveByPSMobAppPack(pSMobAppPack, arrayList);
        for (PSMobAppPackSession pSMobAppPackSession : arrayList) {
            this.remove((IEntity)pSMobAppPackSession);
        }
        this.onAfterRemoveByPSMobAppPack(pSMobAppPack, arrayList);
    }

    protected void onAfterRemoveByPSMobAppPack(PSMobAppPack pSMobAppPack) throws Exception {
    }

    protected void onBeforeRemoveByPSMobAppPack(PSMobAppPack pSMobAppPack, ArrayList<PSMobAppPackSession> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSMobAppPack(PSMobAppPack pSMobAppPack, ArrayList<PSMobAppPackSession> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSMobAppPackSession> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSMobAppPackSession pSMobAppPackSession : arrayList) {
            PSMobAppPackSession pSMobAppPackSession2 = (PSMobAppPackSession)this.getDEModel().createEntity();
            pSMobAppPackSession2.setPSMobAppPackSessionId(pSMobAppPackSession.getPSMobAppPackSessionId());
            pSMobAppPackSession2.setPSSysAppId(null);
            this.update(pSMobAppPackSession2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSMobAppPackSessionServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSMobAppPackSessionServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSMobAppPackSessionServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSMobAppPackSession> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSMobAppPackSession pSMobAppPackSession : arrayList) {
            this.remove((IEntity)pSMobAppPackSession);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSMobAppPackSession> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSMobAppPackSession> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSMobAppPackSession> arrayList = this.selectByPSSystem(pSSystem);
        for (PSMobAppPackSession pSMobAppPackSession : arrayList) {
            PSMobAppPackSession pSMobAppPackSession2 = (PSMobAppPackSession)this.getDEModel().createEntity();
            pSMobAppPackSession2.setPSMobAppPackSessionId(pSMobAppPackSession.getPSMobAppPackSessionId());
            pSMobAppPackSession2.setPSSystemId(null);
            this.update(pSMobAppPackSession2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSMobAppPackSessionServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSMobAppPackSessionServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSMobAppPackSessionServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSMobAppPackSession> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSMobAppPackSession pSMobAppPackSession : arrayList) {
            this.remove((IEntity)pSMobAppPackSession);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSMobAppPackSession> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSMobAppPackSession> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSMobAppPackSession pSMobAppPackSession) throws Exception {
        super.onBeforeRemove(pSMobAppPackSession);
    }

    protected void replaceParentInfo(PSMobAppPackSession pSMobAppPackSession, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSMobAppPackSession, cloneSession);
        if (pSMobAppPackSession.getPSMobAppPackId() != null && (iEntity = cloneSession.getEntity("PSMOBAPPPACK", (Object)pSMobAppPackSession.getPSMobAppPackId())) != null) {
            this.onFillParentInfo_PSMobAppPack(pSMobAppPackSession, (PSMobAppPack)iEntity);
        }
        if (pSMobAppPackSession.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSMobAppPackSession.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSMobAppPackSession, (PSSysApp)iEntity);
        }
        if (pSMobAppPackSession.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSMobAppPackSession.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSMobAppPackSession, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSMobAppPackSession pSMobAppPackSession, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSMobAppPackSession, bl);
    }

    protected void onCheckEntity(boolean bl, PSMobAppPackSession pSMobAppPackSession, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSMobAppPackId(bl, pSMobAppPackSession, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMobAppPackSessionId(bl, pSMobAppPackSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMobAppPackSessionName(bl, pSMobAppPackSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSMobAppPackSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSMobAppPackSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSMobAppPackSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSMobAppPackSession, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSMobAppPackId(boolean bl, PSMobAppPackSession pSMobAppPackSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPackSession.isPSMobAppPackIdDirty() : !pSMobAppPackSession.isPSMobAppPackIdDirty()) {
            return null;
        }
        String string = pSMobAppPackSession.getPSMobAppPackId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMobAppPackId_Default((IEntity)pSMobAppPackSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOBAPPPACKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMobAppPackSessionId(boolean bl, PSMobAppPackSession pSMobAppPackSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPackSession.isPSMobAppPackSessionIdDirty() && !bl2 : !pSMobAppPackSession.isPSMobAppPackSessionIdDirty()) {
            return null;
        }
        String string = pSMobAppPackSession.getPSMobAppPackSessionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOBAPPPACKSESSIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMobAppPackSessionId_Default((IEntity)pSMobAppPackSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOBAPPPACKSESSIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMobAppPackSessionName(boolean bl, PSMobAppPackSession pSMobAppPackSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPackSession.isPSMobAppPackSessionNameDirty() && !bl2 : !pSMobAppPackSession.isPSMobAppPackSessionNameDirty()) {
            return null;
        }
        String string = pSMobAppPackSession.getPSMobAppPackSessionName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOBAPPPACKSESSIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMobAppPackSessionName_Default((IEntity)pSMobAppPackSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOBAPPPACKSESSIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSMobAppPackSession pSMobAppPackSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPackSession.isPSSysAppIdDirty() : !pSMobAppPackSession.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSMobAppPackSession.getPSSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default((IEntity)pSMobAppPackSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSMobAppPackSession pSMobAppPackSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPackSession.isPSSystemIdDirty() : !pSMobAppPackSession.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSMobAppPackSession.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSMobAppPackSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSMobAppPackSession pSMobAppPackSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPackSession.isPSSystemNameDirty() : !pSMobAppPackSession.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSMobAppPackSession.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSMobAppPackSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSMobAppPackSession pSMobAppPackSession, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSMobAppPackSession, bl);
    }

    protected void onSyncIndexEntities(PSMobAppPackSession pSMobAppPackSession, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSMobAppPackSession, bl);
    }

    public Object getDataContextValue(PSMobAppPackSession pSMobAppPackSession, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSMobAppPackSession, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSMobAppPackSession pSMobAppPackSession, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSMobAppPackSession, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMOBAPPPACKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMobAppPackId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMOBAPPPACKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMobAppPackName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMOBAPPPACKSESSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMobAppPackSessionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMOBAPPPACKSESSIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMobAppPackSessionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSMobAppPackId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMOBAPPPACKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMobAppPackName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMOBAPPPACKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMobAppPackSessionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMOBAPPPACKSESSIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMobAppPackSessionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMOBAPPPACKSESSIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSMobAppPackSession pSMobAppPackSession) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSMobAppPackSession)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSMobAppPackSession pSMobAppPackSession) throws Exception {
        super.onUpdateParent((IEntity)pSMobAppPackSession);
    }

    @Override
    protected void exportCurXmlModel(PSMobAppPackSession pSMobAppPackSession, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMOBAPPPACKSESSION");
        if (!bl) {
            pSMobAppPackSession.setCreateDate(null);
            pSMobAppPackSession.setCreateMan(null);
            pSMobAppPackSession.setPSMobAppPackName(null);
            pSMobAppPackSession.setPSMobAppPackSessionId(null);
            pSMobAppPackSession.setPSSysAppName(null);
            pSMobAppPackSession.setUpdateDate(null);
            pSMobAppPackSession.setUpdateMan(null);
            super.exportCurXmlModel(pSMobAppPackSession, xmlNode, bl);
        }
    }
}

