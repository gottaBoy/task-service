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
package net.ibizsys.pscore.srv.devcenter.service;

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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCWorkspaceUserDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCWorkspaceUserDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspaceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspaceUser;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCWorkspaceUserServiceBase
extends PSCoreSysServiceBase<PSDCWorkspaceUser> {
    private static final Log log = LogFactory.getLog(PSDCWorkspaceUserServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCWorkspaceUserDEModel pSDCWorkspaceUserDEModel;
    private PSDCWorkspaceUserDAO pSDCWorkspaceUserDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceUserService";
    }

    public PSDCWorkspaceUserDEModel getPSDCWorkspaceUserDEModel() {
        if (this.pSDCWorkspaceUserDEModel == null) {
            try {
                this.pSDCWorkspaceUserDEModel = (PSDCWorkspaceUserDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCWorkspaceUserDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCWorkspaceUserDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCWorkspaceUserDEModel();
    }

    public PSDCWorkspaceUserDAO getPSDCWorkspaceUserDAO() {
        if (this.pSDCWorkspaceUserDAO == null) {
            try {
                this.pSDCWorkspaceUserDAO = (PSDCWorkspaceUserDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCWorkspaceUserDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCWorkspaceUserDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCWorkspaceUserDAO();
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

    protected void onFillParentInfo(PSDCWorkspaceUser pSDCWorkspaceUser, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCWORKSPACEUSER_PSDCWORKSPACE_PSDCWORKSPACEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService", (SessionFactory)this.getSessionFactory());
            PSDCWorkspace pSDCWorkspace = (PSDCWorkspace)iService.getDEModel().createEntity();
            pSDCWorkspace.set("PSDCWORKSPACEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCWorkspace);
            } else {
                iService.get(pSDCWorkspace);
            }
            this.onFillParentInfo_PSDCWorkspace(pSDCWorkspaceUser, pSDCWorkspace);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCWORKSPACEUSER_PSDEVUSER_PSDEVUSERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevUserService", (SessionFactory)this.getSessionFactory());
            PSDevUser pSDevUser = (PSDevUser)iService.getDEModel().createEntity();
            pSDevUser.set("PSDEVUSERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevUser);
            } else {
                iService.get(pSDevUser);
            }
            this.onFillParentInfo_PSDevUser(pSDCWorkspaceUser, pSDevUser);
            return;
        }
        super.onFillParentInfo(pSDCWorkspaceUser, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCWorkspace(PSDCWorkspaceUser pSDCWorkspaceUser, PSDCWorkspace pSDCWorkspace) throws Exception {
        pSDCWorkspaceUser.setPSDCWorkspaceId(pSDCWorkspace.getPSDCWorkspaceId());
        pSDCWorkspaceUser.setPSDCWorkspaceName(pSDCWorkspace.getPSDCWorkspaceName());
    }

    protected void onFillParentInfo_PSDevUser(PSDCWorkspaceUser pSDCWorkspaceUser, PSDevUser pSDevUser) throws Exception {
        pSDCWorkspaceUser.setPSDevUserId(pSDevUser.getPSDevUserId());
        pSDCWorkspaceUser.setPSDevUserName(pSDevUser.getPSDevUserName());
    }

    protected boolean onFillEntityKeyValue(PSDCWorkspaceUser pSDCWorkspaceUser, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDCWorkspaceUser.get("PSDCWORKSPACEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDCWorkspaceUser.get("PSDCWORKSPACEUSERNAME");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDCWorkspaceUser.set(this.getPSDCWorkspaceUserDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDCWorkspaceUser pSDCWorkspaceUser, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDCWorkspaceUser, bl);
        this.onFillEntityFullInfo_PSDCWorkspace(pSDCWorkspaceUser, bl);
        this.onFillEntityFullInfo_PSDevUser(pSDCWorkspaceUser, bl);
    }

    protected void onFillEntityFullInfo_PSDCWorkspace(PSDCWorkspaceUser pSDCWorkspaceUser, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevUser(PSDCWorkspaceUser pSDCWorkspaceUser, boolean bl) throws Exception {
        if (pSDCWorkspaceUser.isPSDevUserIdDirty()) {
            if (pSDCWorkspaceUser.getPSDevUserId() != null) {
                if (pSDCWorkspaceUser.getPSDevUserId() == null || pSDCWorkspaceUser.getPSDevUserName() == null) {
                    PSDevUser pSDevUser = pSDCWorkspaceUser.getPSDevUser();
                    pSDCWorkspaceUser.setPSDevUserName(pSDevUser.getPSDevUserName());
                }
            } else {
                pSDCWorkspaceUser.setPSDevUserName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCWorkspaceUser pSDCWorkspaceUser, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCWorkspaceUser, bl);
    }

    public ArrayList<PSDCWorkspaceUser> selectByPSDCWorkspace(PSDCWorkspaceBase pSDCWorkspaceBase) throws Exception {
        return this.selectByPSDCWorkspace(pSDCWorkspaceBase, "", -1);
    }

    public ArrayList<PSDCWorkspaceUser> selectByPSDCWorkspace(PSDCWorkspaceBase pSDCWorkspaceBase, String string) throws Exception {
        return this.selectByPSDCWorkspace(pSDCWorkspaceBase, string, -1);
    }

    public ArrayList<PSDCWorkspaceUser> selectByPSDCWorkspace(PSDCWorkspaceBase pSDCWorkspaceBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCWORKSPACEID", (Object)pSDCWorkspaceBase.getPSDCWorkspaceId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCWorkspaceCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCWorkspaceCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCWorkspaceUser> selectByPSDevUser(PSDevUserBase pSDevUserBase) throws Exception {
        return this.selectByPSDevUser(pSDevUserBase, "", -1);
    }

    public ArrayList<PSDCWorkspaceUser> selectByPSDevUser(PSDevUserBase pSDevUserBase, String string) throws Exception {
        return this.selectByPSDevUser(pSDevUserBase, string, -1);
    }

    public ArrayList<PSDCWorkspaceUser> selectByPSDevUser(PSDevUserBase pSDevUserBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDCWorkspace(PSDCWorkspace pSDCWorkspace) throws Exception {
    }

    public void resetPSDCWorkspace(PSDCWorkspace pSDCWorkspace) throws Exception {
        ArrayList<PSDCWorkspaceUser> arrayList = this.selectByPSDCWorkspace(pSDCWorkspace);
        for (PSDCWorkspaceUser pSDCWorkspaceUser : arrayList) {
            PSDCWorkspaceUser pSDCWorkspaceUser2 = (PSDCWorkspaceUser)this.getDEModel().createEntity();
            pSDCWorkspaceUser2.setPSDCWorkspaceUserId(pSDCWorkspaceUser.getPSDCWorkspaceUserId());
            pSDCWorkspaceUser2.setPSDCWorkspaceId(null);
            this.update(pSDCWorkspaceUser2);
        }
    }

    public void removeByPSDCWorkspace(PSDCWorkspace pSDCWorkspace) throws Exception {
        final PSDCWorkspace pSDCWorkspace2 = pSDCWorkspace;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCWorkspaceUserServiceBase.this.onBeforeRemoveByPSDCWorkspace(pSDCWorkspace2);
                PSDCWorkspaceUserServiceBase.this.internalRemoveByPSDCWorkspace(pSDCWorkspace2);
                PSDCWorkspaceUserServiceBase.this.onAfterRemoveByPSDCWorkspace(pSDCWorkspace2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCWorkspace(PSDCWorkspace pSDCWorkspace) throws Exception {
    }

    protected void internalRemoveByPSDCWorkspace(PSDCWorkspace pSDCWorkspace) throws Exception {
        ArrayList<PSDCWorkspaceUser> arrayList = this.selectByPSDCWorkspace(pSDCWorkspace);
        this.onBeforeRemoveByPSDCWorkspace(pSDCWorkspace, arrayList);
        for (PSDCWorkspaceUser pSDCWorkspaceUser : arrayList) {
            this.remove(pSDCWorkspaceUser);
        }
        this.onAfterRemoveByPSDCWorkspace(pSDCWorkspace, arrayList);
    }

    protected void onAfterRemoveByPSDCWorkspace(PSDCWorkspace pSDCWorkspace) throws Exception {
    }

    protected void onBeforeRemoveByPSDCWorkspace(PSDCWorkspace pSDCWorkspace, ArrayList<PSDCWorkspaceUser> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCWorkspace(PSDCWorkspace pSDCWorkspace, ArrayList<PSDCWorkspaceUser> arrayList) throws Exception {
    }

    public void testRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
    }

    public void resetPSDevUser(PSDevUser pSDevUser) throws Exception {
        ArrayList<PSDCWorkspaceUser> arrayList = this.selectByPSDevUser(pSDevUser);
        for (PSDCWorkspaceUser pSDCWorkspaceUser : arrayList) {
            PSDCWorkspaceUser pSDCWorkspaceUser2 = (PSDCWorkspaceUser)this.getDEModel().createEntity();
            pSDCWorkspaceUser2.setPSDCWorkspaceUserId(pSDCWorkspaceUser.getPSDCWorkspaceUserId());
            pSDCWorkspaceUser2.setPSDevUserId(null);
            this.update(pSDCWorkspaceUser2);
        }
    }

    public void removeByPSDevUser(PSDevUser pSDevUser) throws Exception {
        final PSDevUser pSDevUser2 = pSDevUser;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCWorkspaceUserServiceBase.this.onBeforeRemoveByPSDevUser(pSDevUser2);
                PSDCWorkspaceUserServiceBase.this.internalRemoveByPSDevUser(pSDevUser2);
                PSDCWorkspaceUserServiceBase.this.onAfterRemoveByPSDevUser(pSDevUser2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
    }

    protected void internalRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
        ArrayList<PSDCWorkspaceUser> arrayList = this.selectByPSDevUser(pSDevUser);
        this.onBeforeRemoveByPSDevUser(pSDevUser, arrayList);
        for (PSDCWorkspaceUser pSDCWorkspaceUser : arrayList) {
            this.remove(pSDCWorkspaceUser);
        }
        this.onAfterRemoveByPSDevUser(pSDevUser, arrayList);
    }

    protected void onAfterRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
    }

    protected void onBeforeRemoveByPSDevUser(PSDevUser pSDevUser, ArrayList<PSDCWorkspaceUser> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevUser(PSDevUser pSDevUser, ArrayList<PSDCWorkspaceUser> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCWorkspaceUser pSDCWorkspaceUser) throws Exception {
        super.onBeforeRemove(pSDCWorkspaceUser);
    }

    protected void replaceParentInfo(PSDCWorkspaceUser pSDCWorkspaceUser, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCWorkspaceUser, cloneSession);
        if (pSDCWorkspaceUser.getPSDCWorkspaceId() != null && (iEntity = cloneSession.getEntity("PSDCWORKSPACE", (Object)pSDCWorkspaceUser.getPSDCWorkspaceId())) != null) {
            this.onFillParentInfo_PSDCWorkspace(pSDCWorkspaceUser, (PSDCWorkspace)iEntity);
        }
        if (pSDCWorkspaceUser.getPSDevUserId() != null && (iEntity = cloneSession.getEntity("PSDEVUSER", (Object)pSDCWorkspaceUser.getPSDevUserId())) != null) {
            this.onFillParentInfo_PSDevUser(pSDCWorkspaceUser, (PSDevUser)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCWorkspaceUser pSDCWorkspaceUser, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCWorkspaceUser, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCWorkspaceUser pSDCWorkspaceUser, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AccessTime(bl, pSDCWorkspaceUser, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCWorkspaceUser, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCWorkspaceId(bl, pSDCWorkspaceUser, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCWorkspaceUserId(bl, pSDCWorkspaceUser, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCWorkspaceUserName(bl, pSDCWorkspaceUser, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevUserId(bl, pSDCWorkspaceUser, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevUserName(bl, pSDCWorkspaceUser, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDCWorkspaceUser, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDCWorkspaceUser, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCWorkspaceUser, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AccessTime(boolean bl, PSDCWorkspaceUser pSDCWorkspaceUser, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkspaceUser.isAccessTimeDirty() : !pSDCWorkspaceUser.isAccessTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCWorkspaceUser.getAccessTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AccessTime_Default(pSDCWorkspaceUser, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACCESSTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCWorkspaceUser pSDCWorkspaceUser, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkspaceUser.isMemoDirty() : !pSDCWorkspaceUser.isMemoDirty()) {
            return null;
        }
        String string = pSDCWorkspaceUser.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCWorkspaceUser, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCWorkspaceId(boolean bl, PSDCWorkspaceUser pSDCWorkspaceUser, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkspaceUser.isPSDCWorkspaceIdDirty() && !bl2 : !pSDCWorkspaceUser.isPSDCWorkspaceIdDirty()) {
            return null;
        }
        String string = pSDCWorkspaceUser.getPSDCWorkspaceId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCWORKSPACEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCWorkspaceId_Default(pSDCWorkspaceUser, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCWORKSPACEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCWorkspaceUserId(boolean bl, PSDCWorkspaceUser pSDCWorkspaceUser, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkspaceUser.isPSDCWorkspaceUserIdDirty() && !bl2 : !pSDCWorkspaceUser.isPSDCWorkspaceUserIdDirty()) {
            return null;
        }
        String string = pSDCWorkspaceUser.getPSDCWorkspaceUserId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCWORKSPACEUSERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCWorkspaceUserId_Default(pSDCWorkspaceUser, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCWORKSPACEUSERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCWorkspaceUserName(boolean bl, PSDCWorkspaceUser pSDCWorkspaceUser, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkspaceUser.isPSDCWorkspaceUserNameDirty() && !bl2 : !pSDCWorkspaceUser.isPSDCWorkspaceUserNameDirty()) {
            return null;
        }
        String string = pSDCWorkspaceUser.getPSDCWorkspaceUserName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCWORKSPACEUSERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCWorkspaceUserName_Default(pSDCWorkspaceUser, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCWORKSPACEUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevUserId(boolean bl, PSDCWorkspaceUser pSDCWorkspaceUser, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkspaceUser.isPSDevUserIdDirty() : !pSDCWorkspaceUser.isPSDevUserIdDirty()) {
            return null;
        }
        String string = pSDCWorkspaceUser.getPSDevUserId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevUserId_Default(pSDCWorkspaceUser, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevUserName(boolean bl, PSDCWorkspaceUser pSDCWorkspaceUser, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkspaceUser.isPSDevUserNameDirty() : !pSDCWorkspaceUser.isPSDevUserNameDirty()) {
            return null;
        }
        String string = pSDCWorkspaceUser.getPSDevUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevUserName_Default(pSDCWorkspaceUser, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDCWorkspaceUser pSDCWorkspaceUser, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkspaceUser.isUserTagDirty() : !pSDCWorkspaceUser.isUserTagDirty()) {
            return null;
        }
        String string = pSDCWorkspaceUser.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDCWorkspaceUser, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDCWorkspaceUser pSDCWorkspaceUser, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCWorkspaceUser.isUserTag2Dirty() : !pSDCWorkspaceUser.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDCWorkspaceUser.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDCWorkspaceUser, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCWorkspaceUser pSDCWorkspaceUser, boolean bl) throws Exception {
        super.onSyncEntity(pSDCWorkspaceUser, bl);
    }

    protected void onSyncIndexEntities(PSDCWorkspaceUser pSDCWorkspaceUser, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCWorkspaceUser, bl);
    }

    public Object getDataContextValue(PSDCWorkspaceUser pSDCWorkspaceUser, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCWorkspaceUser, string, iDataContextParam)) != null) {
            return object;
        }
        PSDCWorkspace pSDCWorkspace = pSDCWorkspaceUser.getPSDCWorkspace();
        if (pSDCWorkspace != null && pSDCWorkspace.contains(string)) {
            return pSDCWorkspace.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDCWorkspaceUser pSDCWorkspaceUser, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCWorkspaceUser, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACCESSTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AccessTime_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDCWORKSPACEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCWorkspaceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCWORKSPACENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCWorkspaceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCWORKSPACEUSERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCWorkspaceUserId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCWORKSPACEUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCWorkspaceUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVUSERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevUserId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AccessTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCWorkspaceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCWORKSPACEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCWorkspaceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCWORKSPACENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCWorkspaceUserId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCWORKSPACEUSERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCWorkspaceUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCWORKSPACEUSERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDCWorkspaceUser pSDCWorkspaceUser) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCWorkspaceUser)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCWorkspaceUser pSDCWorkspaceUser) throws Exception {
        super.onUpdateParent(pSDCWorkspaceUser);
    }

    @Override
    protected void exportCurXmlModel(PSDCWorkspaceUser pSDCWorkspaceUser, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCWORKSPACEUSER");
        if (!bl) {
            pSDCWorkspaceUser.setCreateDate(null);
            pSDCWorkspaceUser.setCreateMan(null);
            pSDCWorkspaceUser.setPSDCWorkspaceName(null);
            pSDCWorkspaceUser.setPSDCWorkspaceUserId(null);
            pSDCWorkspaceUser.setUpdateDate(null);
            pSDCWorkspaceUser.setUpdateMan(null);
            super.exportCurXmlModel(pSDCWorkspaceUser, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDCWorkspaceUser pSDCWorkspaceUser, PSSystem pSSystem) throws Exception {
        PSDCWorkspaceUser pSDCWorkspaceUser2 = new PSDCWorkspaceUser();
        pSDCWorkspaceUser2.setPSDCWorkspaceId(pSDCWorkspaceUser.getPSDCWorkspaceId());
        pSDCWorkspaceUser2.setPSDCWorkspaceUserName(pSDCWorkspaceUser.getPSDCWorkspaceUserName());
        if (this.selectOne(pSDCWorkspaceUser2, true)) {
            return pSDCWorkspaceUser2.getPSDCWorkspaceUserId();
        }
        return super.getEntityFolderKeyValue(pSDCWorkspaceUser, pSSystem);
    }
}

