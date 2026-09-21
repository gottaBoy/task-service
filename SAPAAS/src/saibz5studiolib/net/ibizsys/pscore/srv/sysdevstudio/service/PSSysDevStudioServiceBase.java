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
package net.ibizsys.pscore.srv.sysdevstudio.service;

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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.dao.PSSysDevStudioDAO;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSSysDevStudioDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevStudio;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDSActionService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDevStudioServiceBase
extends PSCoreSysServiceBase<PSSysDevStudio> {
    private static final Log log = LogFactory.getLog(PSSysDevStudioServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysDevStudioDEModel pSSysDevStudioDEModel;
    private PSSysDevStudioDAO pSSysDevStudioDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevStudioService";
    }

    public PSSysDevStudioDEModel getPSSysDevStudioDEModel() {
        if (this.pSSysDevStudioDEModel == null) {
            try {
                this.pSSysDevStudioDEModel = (PSSysDevStudioDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSSysDevStudioDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDevStudioDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysDevStudioDEModel();
    }

    public PSSysDevStudioDAO getPSSysDevStudioDAO() {
        if (this.pSSysDevStudioDAO == null) {
            try {
                this.pSSysDevStudioDAO = (PSSysDevStudioDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdevstudio.dao.PSSysDevStudioDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDevStudioDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysDevStudioDAO();
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

    protected void onFillParentInfo(PSSysDevStudio pSSysDevStudio, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDEVSTUDIO_PSDEVUSER_PSDEVUSERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevUserService", (SessionFactory)this.getSessionFactory());
            PSDevUser pSDevUser = (PSDevUser)iService.getDEModel().createEntity();
            pSDevUser.set("PSDEVUSERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevUser);
            } else {
                iService.get((IEntity)pSDevUser);
            }
            this.onFillParentInfo_PSDevUser(pSSysDevStudio, pSDevUser);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDEVSTUDIO_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_Pssystem(pSSysDevStudio, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysDevStudio, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevUser(PSSysDevStudio pSSysDevStudio, PSDevUser pSDevUser) throws Exception {
        pSSysDevStudio.setPSDevUserId(pSDevUser.getPSDevUserId());
        pSSysDevStudio.setPSDevUserName(pSDevUser.getPSDevUserName());
    }

    protected void onFillParentInfo_Pssystem(PSSysDevStudio pSSysDevStudio, PSSystem pSSystem) throws Exception {
        pSSysDevStudio.setPSSystemId(pSSystem.getPSSystemId());
        pSSysDevStudio.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected boolean onFillEntityKeyValue(PSSysDevStudio pSSysDevStudio, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSysDevStudio.get("PSSYSTEMID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSysDevStudio.get("PSDEVUSERID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSSysDevStudio.set(this.getPSSysDevStudioDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSysDevStudio pSSysDevStudio, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSysDevStudio, bl);
        this.onFillEntityFullInfo_PSDevUser(pSSysDevStudio, bl);
        this.onFillEntityFullInfo_Pssystem(pSSysDevStudio, bl);
    }

    protected void onFillEntityFullInfo_PSDevUser(PSSysDevStudio pSSysDevStudio, boolean bl) throws Exception {
        if (pSSysDevStudio.isPSDevUserIdDirty()) {
            if (pSSysDevStudio.getPSDevUserId() != null) {
                if (pSSysDevStudio.getPSDevUserId() == null || pSSysDevStudio.getPSDevUserName() == null) {
                    PSDevUser pSDevUser = pSSysDevStudio.getPSDevUser();
                    pSSysDevStudio.setPSDevUserName(pSDevUser.getPSDevUserName());
                }
            } else {
                pSSysDevStudio.setPSDevUserName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Pssystem(PSSysDevStudio pSSysDevStudio, boolean bl) throws Exception {
        if (pSSysDevStudio.isPSSystemIdDirty()) {
            if (pSSysDevStudio.getPSSystemId() != null) {
                if (pSSysDevStudio.getPSSystemId() == null || pSSysDevStudio.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysDevStudio.getPssystem();
                    pSSysDevStudio.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysDevStudio.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysDevStudio pSSysDevStudio, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysDevStudio, bl);
    }

    public ArrayList<PSSysDevStudio> selectByPSDevUser(PSDevUserBase pSDevUserBase) throws Exception {
        return this.selectByPSDevUser(pSDevUserBase, "", -1);
    }

    public ArrayList<PSSysDevStudio> selectByPSDevUser(PSDevUserBase pSDevUserBase, String string) throws Exception {
        return this.selectByPSDevUser(pSDevUserBase, string, -1);
    }

    public ArrayList<PSSysDevStudio> selectByPSDevUser(PSDevUserBase pSDevUserBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVUSERID", (Object)pSDevUserBase.getPSDevUserId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevUserCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevUserCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDevStudio> selectByPssystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPssystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysDevStudio> selectByPssystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPssystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysDevStudio> selectByPssystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMID", (Object)pSSystemBase.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPssystemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPssystemCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
    }

    public void resetPSDevUser(PSDevUser pSDevUser) throws Exception {
        ArrayList<PSSysDevStudio> arrayList = this.selectByPSDevUser(pSDevUser);
        for (PSSysDevStudio pSSysDevStudio : arrayList) {
            PSSysDevStudio pSSysDevStudio2 = (PSSysDevStudio)this.getDEModel().createEntity();
            pSSysDevStudio2.setPSSysDevStudioId(pSSysDevStudio.getPSSysDevStudioId());
            pSSysDevStudio2.setPSDevUserId(null);
            this.update(pSSysDevStudio2);
        }
    }

    public void removeByPSDevUser(PSDevUser pSDevUser) throws Exception {
        final PSDevUser pSDevUser2 = pSDevUser;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDevStudioServiceBase.this.onBeforeRemoveByPSDevUser(pSDevUser2);
                PSSysDevStudioServiceBase.this.internalRemoveByPSDevUser(pSDevUser2);
                PSSysDevStudioServiceBase.this.onAfterRemoveByPSDevUser(pSDevUser2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
    }

    protected void internalRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
        ArrayList<PSSysDevStudio> arrayList = this.selectByPSDevUser(pSDevUser);
        this.onBeforeRemoveByPSDevUser(pSDevUser, arrayList);
        for (PSSysDevStudio pSSysDevStudio : arrayList) {
            this.remove((IEntity)pSSysDevStudio);
        }
        this.onAfterRemoveByPSDevUser(pSDevUser, arrayList);
    }

    protected void onAfterRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
    }

    protected void onBeforeRemoveByPSDevUser(PSDevUser pSDevUser, ArrayList<PSSysDevStudio> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevUser(PSDevUser pSDevUser, ArrayList<PSSysDevStudio> arrayList) throws Exception {
    }

    public void testRemoveByPssystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPssystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysDevStudio> arrayList = this.selectByPssystem(pSSystem);
        for (PSSysDevStudio pSSysDevStudio : arrayList) {
            PSSysDevStudio pSSysDevStudio2 = (PSSysDevStudio)this.getDEModel().createEntity();
            pSSysDevStudio2.setPSSysDevStudioId(pSSysDevStudio.getPSSysDevStudioId());
            pSSysDevStudio2.setPSSystemId(null);
            this.update(pSSysDevStudio2);
        }
    }

    public void removeByPssystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDevStudioServiceBase.this.onBeforeRemoveByPssystem(pSSystem2);
                PSSysDevStudioServiceBase.this.internalRemoveByPssystem(pSSystem2);
                PSSysDevStudioServiceBase.this.onAfterRemoveByPssystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPssystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPssystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysDevStudio> arrayList = this.selectByPssystem(pSSystem);
        this.onBeforeRemoveByPssystem(pSSystem, arrayList);
        for (PSSysDevStudio pSSysDevStudio : arrayList) {
            this.remove((IEntity)pSSysDevStudio);
        }
        this.onAfterRemoveByPssystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPssystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPssystem(PSSystem pSSystem, ArrayList<PSSysDevStudio> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPssystem(PSSystem pSSystem, ArrayList<PSSysDevStudio> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysDevStudio pSSysDevStudio) throws Exception {
        PSSysDSActionService pSSysDSActionService = (PSSysDSActionService)ServiceGlobal.getService(PSSysDSActionService.class, (SessionFactory)this.getSessionFactory());
        pSSysDSActionService.testRemoveByPssysdevstudio(pSSysDevStudio);
        pSSysDSActionService.removeByPssysdevstudio(pSSysDevStudio);
        super.onBeforeRemove(pSSysDevStudio);
    }

    protected void replaceParentInfo(PSSysDevStudio pSSysDevStudio, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysDevStudio, cloneSession);
        if (pSSysDevStudio.getPSDevUserId() != null && (iEntity = cloneSession.getEntity("PSDEVUSER", (Object)pSSysDevStudio.getPSDevUserId())) != null) {
            this.onFillParentInfo_PSDevUser(pSSysDevStudio, (PSDevUser)iEntity);
        }
        if (pSSysDevStudio.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysDevStudio.getPSSystemId())) != null) {
            this.onFillParentInfo_Pssystem(pSSysDevStudio, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysDevStudio pSSysDevStudio, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysDevStudio, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysDevStudio pSSysDevStudio, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSDevUserId(bl, pSSysDevStudio, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevUserName(bl, pSSysDevStudio, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDevStudioId(bl, pSSysDevStudio, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDevStudioName(bl, pSSysDevStudio, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysDevStudio, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysDevStudio, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysDevStudio, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSDevUserId(boolean bl, PSSysDevStudio pSSysDevStudio, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevStudio.isPSDevUserIdDirty() && !bl2 : !pSSysDevStudio.isPSDevUserIdDirty()) {
            return null;
        }
        String string = pSSysDevStudio.getPSDevUserId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevUserId_Default((IEntity)pSSysDevStudio, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevUserName(boolean bl, PSSysDevStudio pSSysDevStudio, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevStudio.isPSDevUserNameDirty() && !bl2 : !pSSysDevStudio.isPSDevUserNameDirty()) {
            return null;
        }
        String string = pSSysDevStudio.getPSDevUserName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevUserName_Default((IEntity)pSSysDevStudio, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDevStudioId(boolean bl, PSSysDevStudio pSSysDevStudio, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevStudio.isPSSysDevStudioIdDirty() && !bl2 : !pSSysDevStudio.isPSSysDevStudioIdDirty()) {
            return null;
        }
        String string = pSSysDevStudio.getPSSysDevStudioId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEVSTUDIOID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDevStudioId_Default((IEntity)pSSysDevStudio, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEVSTUDIOID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDevStudioName(boolean bl, PSSysDevStudio pSSysDevStudio, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevStudio.isPSSysDevStudioNameDirty() && !bl2 : !pSSysDevStudio.isPSSysDevStudioNameDirty()) {
            return null;
        }
        String string = pSSysDevStudio.getPSSysDevStudioName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEVSTUDIONAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDevStudioName_Default((IEntity)pSSysDevStudio, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEVSTUDIONAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysDevStudio pSSysDevStudio, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevStudio.isPSSystemIdDirty() : !pSSysDevStudio.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysDevStudio.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysDevStudio, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysDevStudio pSSysDevStudio, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevStudio.isPSSystemNameDirty() : !pSSysDevStudio.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysDevStudio.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSysDevStudio, bl2, bl3);
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

    protected void onSyncEntity(PSSysDevStudio pSSysDevStudio, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysDevStudio, bl);
    }

    protected void onSyncIndexEntities(PSSysDevStudio pSSysDevStudio, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysDevStudio, bl);
    }

    public Object getDataContextValue(PSSysDevStudio pSSysDevStudio, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysDevStudio, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysDevStudio pSSysDevStudio, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysDevStudio, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVUSERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevUserId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDEVSTUDIOID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDevStudioId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDEVSTUDIONAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDevStudioName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDevUserId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVUSERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVUSERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDevStudioId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDEVSTUDIOID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDevStudioName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDEVSTUDIONAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysDevStudio pSSysDevStudio) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysDevStudio)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysDevStudio pSSysDevStudio) throws Exception {
        super.onUpdateParent((IEntity)pSSysDevStudio);
    }

    @Override
    protected void exportCurXmlModel(PSSysDevStudio pSSysDevStudio, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSDEVSTUDIO");
        if (!bl) {
            super.exportCurXmlModel(pSSysDevStudio, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSysDevStudio pSSysDevStudio, PSSystem pSSystem) throws Exception {
        PSSysDevStudio pSSysDevStudio2 = new PSSysDevStudio();
        pSSysDevStudio2.setPSSystemId(pSSysDevStudio.getPSSystemId());
        pSSysDevStudio2.setPSDevUserId(pSSysDevStudio.getPSDevUserId());
        if (this.selectOne((IEntity)pSSysDevStudio2, true)) {
            return pSSysDevStudio2.getPSSysDevStudioId();
        }
        return super.getEntityFolderKeyValue(pSSysDevStudio, pSSystem);
    }
}

