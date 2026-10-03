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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.dao.PSDevUserRecentDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDevUserRecentDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserRecent;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevUserRecentServiceBase
extends PSCoreSysServiceBase<PSDevUserRecent> {
    private static final Log log = LogFactory.getLog(PSDevUserRecentServiceBase.class);
    public static final String DATASET_CURUSER = "CurUser";
    public static final String DATASET_CURUSERDE = "CurUserDE";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevUserRecentDEModel pSDevUserRecentDEModel;
    private PSDevUserRecentDAO pSDevUserRecentDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDevUserRecentService";
    }

    public PSDevUserRecentDEModel getPSDevUserRecentDEModel() {
        if (this.pSDevUserRecentDEModel == null) {
            try {
                this.pSDevUserRecentDEModel = (PSDevUserRecentDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDevUserRecentDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevUserRecentDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevUserRecentDEModel();
    }

    public PSDevUserRecentDAO getPSDevUserRecentDAO() {
        if (this.pSDevUserRecentDAO == null) {
            try {
                this.pSDevUserRecentDAO = (PSDevUserRecentDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDevUserRecentDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevUserRecentDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevUserRecentDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURUSER, (boolean)true) == 0) {
            return this.fetchCurUser(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURUSERDE, (boolean)true) == 0) {
            return this.fetchCurUserDE(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurUser(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurUserDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSERDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDevUserRecent pSDevUserRecent, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVUSERRECENT_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDevUserRecent, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVUSERRECENT_PSDEVUSER_PSDEVUSERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevUserService", (SessionFactory)this.getSessionFactory());
            PSDevUser pSDevUser = (PSDevUser)iService.getDEModel().createEntity();
            pSDevUser.set("PSDEVUSERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevUser);
            } else {
                iService.get(pSDevUser);
            }
            this.onFillParentInfo_PSDevUser(pSDevUserRecent, pSDevUser);
            return;
        }
        super.onFillParentInfo(pSDevUserRecent, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSDevUserRecent pSDevUserRecent, PSDevCenter pSDevCenter) throws Exception {
        pSDevUserRecent.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDevUserRecent.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevUser(PSDevUserRecent pSDevUserRecent, PSDevUser pSDevUser) throws Exception {
        pSDevUserRecent.setPSDevUserId(pSDevUser.getPSDevUserId());
        pSDevUserRecent.setPSDevUserName(pSDevUser.getPSDevUserName());
    }

    protected boolean onFillEntityKeyValue(PSDevUserRecent pSDevUserRecent, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDevUserRecent.get("PSDEVUSERID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDevUserRecent.get("OBJTYPE");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        stringBuilderEx.append("||");
        Object object3 = pSDevUserRecent.get("OBJID");
        if (object3 == null) {
            object3 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object3);
        String string = stringBuilderEx.toString();
        pSDevUserRecent.set(this.getPSDevUserRecentDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDevUserRecent pSDevUserRecent, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDevUserRecent, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDevUserRecent, bl);
        this.onFillEntityFullInfo_PSDevUser(pSDevUserRecent, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDevUserRecent pSDevUserRecent, boolean bl) throws Exception {
        if (pSDevUserRecent.isPSDevCenterIdDirty()) {
            if (pSDevUserRecent.getPSDevCenterId() != null) {
                if (pSDevUserRecent.getPSDevCenterId() == null || pSDevUserRecent.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDevUserRecent.getPSDevCenter();
                    pSDevUserRecent.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDevUserRecent.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevUser(PSDevUserRecent pSDevUserRecent, boolean bl) throws Exception {
        if (pSDevUserRecent.isPSDevUserIdDirty()) {
            if (pSDevUserRecent.getPSDevUserId() != null) {
                if (pSDevUserRecent.getPSDevUserId() == null || pSDevUserRecent.getPSDevUserName() == null) {
                    PSDevUser pSDevUser = pSDevUserRecent.getPSDevUser();
                    pSDevUserRecent.setPSDevUserName(pSDevUser.getPSDevUserName());
                }
            } else {
                pSDevUserRecent.setPSDevUserName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDevUserRecent pSDevUserRecent, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevUserRecent, bl);
    }

    public ArrayList<PSDevUserRecent> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDevUserRecent> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDevUserRecent> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevUserRecent> selectByPSDevUser(PSDevUserBase pSDevUserBase) throws Exception {
        return this.selectByPSDevUser(pSDevUserBase, "", -1);
    }

    public ArrayList<PSDevUserRecent> selectByPSDevUser(PSDevUserBase pSDevUserBase, String string) throws Exception {
        return this.selectByPSDevUser(pSDevUserBase, string, -1);
    }

    public ArrayList<PSDevUserRecent> selectByPSDevUser(PSDevUserBase pSDevUserBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevUserRecent> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVUSERRECENT_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSDEVUSERRECENT", iDataEntityModel.getDataInfo(pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevUserRecent> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDevUserRecent pSDevUserRecent : arrayList) {
            PSDevUserRecent pSDevUserRecent2 = (PSDevUserRecent)this.getDEModel().createEntity();
            pSDevUserRecent2.setPSDevUserRecentId(pSDevUserRecent.getPSDevUserRecentId());
            pSDevUserRecent2.setPSDevCenterId(null);
            this.update(pSDevUserRecent2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevUserRecentServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDevUserRecentServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDevUserRecentServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevUserRecent> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDevUserRecent pSDevUserRecent : arrayList) {
            this.remove(pSDevUserRecent);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDevUserRecent> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDevUserRecent> arrayList) throws Exception {
    }

    public void testRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
    }

    public void resetPSDevUser(PSDevUser pSDevUser) throws Exception {
        ArrayList<PSDevUserRecent> arrayList = this.selectByPSDevUser(pSDevUser);
        for (PSDevUserRecent pSDevUserRecent : arrayList) {
            PSDevUserRecent pSDevUserRecent2 = (PSDevUserRecent)this.getDEModel().createEntity();
            pSDevUserRecent2.setPSDevUserRecentId(pSDevUserRecent.getPSDevUserRecentId());
            pSDevUserRecent2.setPSDevUserId(null);
            this.update(pSDevUserRecent2);
        }
    }

    public void removeByPSDevUser(PSDevUser pSDevUser) throws Exception {
        final PSDevUser pSDevUser2 = pSDevUser;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevUserRecentServiceBase.this.onBeforeRemoveByPSDevUser(pSDevUser2);
                PSDevUserRecentServiceBase.this.internalRemoveByPSDevUser(pSDevUser2);
                PSDevUserRecentServiceBase.this.onAfterRemoveByPSDevUser(pSDevUser2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
    }

    protected void internalRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
        ArrayList<PSDevUserRecent> arrayList = this.selectByPSDevUser(pSDevUser);
        this.onBeforeRemoveByPSDevUser(pSDevUser, arrayList);
        for (PSDevUserRecent pSDevUserRecent : arrayList) {
            this.remove(pSDevUserRecent);
        }
        this.onAfterRemoveByPSDevUser(pSDevUser, arrayList);
    }

    protected void onAfterRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
    }

    protected void onBeforeRemoveByPSDevUser(PSDevUser pSDevUser, ArrayList<PSDevUserRecent> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevUser(PSDevUser pSDevUser, ArrayList<PSDevUserRecent> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevUserRecent pSDevUserRecent) throws Exception {
        super.onBeforeRemove(pSDevUserRecent);
    }

    protected void replaceParentInfo(PSDevUserRecent pSDevUserRecent, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevUserRecent, cloneSession);
        if (pSDevUserRecent.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDevUserRecent.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDevUserRecent, (PSDevCenter)iEntity);
        }
        if (pSDevUserRecent.getPSDevUserId() != null && (iEntity = cloneSession.getEntity("PSDEVUSER", (Object)pSDevUserRecent.getPSDevUserId())) != null) {
            this.onFillParentInfo_PSDevUser(pSDevUserRecent, (PSDevUser)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevUserRecent pSDevUserRecent, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevUserRecent, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevUserRecent pSDevUserRecent, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ObjId(bl, pSDevUserRecent, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ObjName(bl, pSDevUserRecent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ObjType(bl, pSDevUserRecent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDevUserRecent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDevUserRecent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevUserId(bl, pSDevUserRecent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevUserName(bl, pSDevUserRecent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevUserRecentId(bl, pSDevUserRecent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevUserRecentName(bl, pSDevUserRecent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevUserRecent, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ObjId(boolean bl, PSDevUserRecent pSDevUserRecent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevUserRecent.isObjIdDirty() && !bl2 : !pSDevUserRecent.isObjIdDirty()) {
            return null;
        }
        String string = pSDevUserRecent.getObjId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OBJID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ObjId_Default(pSDevUserRecent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ObjName(boolean bl, PSDevUserRecent pSDevUserRecent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevUserRecent.isObjNameDirty() && !bl2 : !pSDevUserRecent.isObjNameDirty()) {
            return null;
        }
        String string = pSDevUserRecent.getObjName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OBJNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ObjName_Default(pSDevUserRecent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OBJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ObjType(boolean bl, PSDevUserRecent pSDevUserRecent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevUserRecent.isObjTypeDirty() && !bl2 : !pSDevUserRecent.isObjTypeDirty()) {
            return null;
        }
        String string = pSDevUserRecent.getObjType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OBJTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ObjType_Default(pSDevUserRecent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OBJTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDevUserRecent pSDevUserRecent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevUserRecent.isPSDevCenterIdDirty() : !pSDevUserRecent.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDevUserRecent.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDevUserRecent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDevUserRecent pSDevUserRecent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevUserRecent.isPSDevCenterNameDirty() : !pSDevUserRecent.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDevUserRecent.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDevUserRecent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevUserId(boolean bl, PSDevUserRecent pSDevUserRecent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevUserRecent.isPSDevUserIdDirty() && !bl2 : !pSDevUserRecent.isPSDevUserIdDirty()) {
            return null;
        }
        String string = pSDevUserRecent.getPSDevUserId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevUserId_Default(pSDevUserRecent, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevUserName(boolean bl, PSDevUserRecent pSDevUserRecent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevUserRecent.isPSDevUserNameDirty() : !pSDevUserRecent.isPSDevUserNameDirty()) {
            return null;
        }
        String string = pSDevUserRecent.getPSDevUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevUserName_Default(pSDevUserRecent, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevUserRecentId(boolean bl, PSDevUserRecent pSDevUserRecent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevUserRecent.isPSDevUserRecentIdDirty() && !bl2 : !pSDevUserRecent.isPSDevUserRecentIdDirty()) {
            return null;
        }
        String string = pSDevUserRecent.getPSDevUserRecentId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSERRECENTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevUserRecentId_Default(pSDevUserRecent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSERRECENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevUserRecentName(boolean bl, PSDevUserRecent pSDevUserRecent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevUserRecent.isPSDevUserRecentNameDirty() && !bl2 : !pSDevUserRecent.isPSDevUserRecentNameDirty()) {
            return null;
        }
        String string = pSDevUserRecent.getPSDevUserRecentName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSERRECENTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevUserRecentName_Default(pSDevUserRecent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSERRECENTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevUserRecent pSDevUserRecent, boolean bl) throws Exception {
        super.onSyncEntity(pSDevUserRecent, bl);
    }

    protected void onSyncIndexEntities(PSDevUserRecent pSDevUserRecent, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevUserRecent, bl);
    }

    public Object getDataContextValue(PSDevUserRecent pSDevUserRecent, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevUserRecent, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDevUserRecent pSDevUserRecent, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevUserRecent, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OBJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ObjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OBJTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ObjType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVUSERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevUserId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVUSERRECENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevUserRecentId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVUSERRECENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevUserRecentName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OBJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ObjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OBJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ObjType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OBJTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSDevUserRecentId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVUSERRECENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevUserRecentName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVUSERRECENTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDevUserRecent pSDevUserRecent) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevUserRecent)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevUserRecent pSDevUserRecent) throws Exception {
        super.onUpdateParent(pSDevUserRecent);
    }

    @Override
    protected void exportCurXmlModel(PSDevUserRecent pSDevUserRecent, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVUSERRECENT");
        if (!bl) {
            pSDevUserRecent.setCreateDate(null);
            pSDevUserRecent.setCreateMan(null);
            pSDevUserRecent.setPSDevUserName(null);
            pSDevUserRecent.setPSDevUserRecentId(null);
            pSDevUserRecent.setUpdateDate(null);
            pSDevUserRecent.setUpdateMan(null);
            super.exportCurXmlModel(pSDevUserRecent, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDevUserRecent pSDevUserRecent, PSSystem pSSystem) throws Exception {
        PSDevUserRecent pSDevUserRecent2 = new PSDevUserRecent();
        pSDevUserRecent2.setPSDevUserId(pSDevUserRecent.getPSDevUserId());
        pSDevUserRecent2.setObjType(pSDevUserRecent.getObjType());
        pSDevUserRecent2.setObjId(pSDevUserRecent.getObjId());
        if (this.selectOne(pSDevUserRecent2, true)) {
            return pSDevUserRecent2.getPSDevUserRecentId();
        }
        return super.getEntityFolderKeyValue(pSDevUserRecent, pSSystem);
    }
}

