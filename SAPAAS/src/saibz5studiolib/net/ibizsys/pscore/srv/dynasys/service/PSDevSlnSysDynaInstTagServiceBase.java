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
package net.ibizsys.pscore.srv.dynasys.service;

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
import net.ibizsys.pscore.srv.dynasys.dao.PSDevSlnSysDynaInstTagDAO;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDevSlnSysDynaInstTagDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInstBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInstTag;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysDynaInstTagServiceBase
extends PSCoreSysServiceBase<PSDevSlnSysDynaInstTag> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysDynaInstTagServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_REVERT = "Revert";
    private PSDevSlnSysDynaInstTagDEModel pSDevSlnSysDynaInstTagDEModel;
    private PSDevSlnSysDynaInstTagDAO pSDevSlnSysDynaInstTagDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstTagService";
    }

    public PSDevSlnSysDynaInstTagDEModel getPSDevSlnSysDynaInstTagDEModel() {
        if (this.pSDevSlnSysDynaInstTagDEModel == null) {
            try {
                this.pSDevSlnSysDynaInstTagDEModel = (PSDevSlnSysDynaInstTagDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDevSlnSysDynaInstTagDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysDynaInstTagDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnSysDynaInstTagDEModel();
    }

    public PSDevSlnSysDynaInstTagDAO getPSDevSlnSysDynaInstTagDAO() {
        if (this.pSDevSlnSysDynaInstTagDAO == null) {
            try {
                this.pSDevSlnSysDynaInstTagDAO = (PSDevSlnSysDynaInstTagDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dynasys.dao.PSDevSlnSysDynaInstTagDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysDynaInstTagDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnSysDynaInstTagDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_REVERT, (boolean)true) == 0) {
            this.revert((PSDevSlnSysDynaInstTag)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void revert(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_REVERT, 0, pSDevSlnSysDynaInstTag, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSysDynaInstTag, ACTION_REVERT);
        final PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag2 = pSDevSlnSysDynaInstTag;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysDynaInstTagServiceBase.this.getService(), PSDevSlnSysDynaInstTagServiceBase.ACTION_REVERT, 40, pSDevSlnSysDynaInstTag2, null).getResult() != 1) {
                    PSDevSlnSysDynaInstTagServiceBase.this.onRevert(pSDevSlnSysDynaInstTag2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_REVERT, 99, pSDevSlnSysDynaInstTag, null);
        }
    }

    protected void onRevert(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[Revert]");
    }

    protected void onFillParentInfo(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSDYNAINSTTAG_PSDEVSLNSYSDYNAINST_PSDEVSLNSYSDYNAINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysDynaInst pSDevSlnSysDynaInst = (PSDevSlnSysDynaInst)iService.getDEModel().createEntity();
            pSDevSlnSysDynaInst.set("PSDEVSLNSYSDYNAINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSysDynaInst);
            } else {
                iService.get(pSDevSlnSysDynaInst);
            }
            this.onFillParentInfo_PSDevSlnSysDynaInst(pSDevSlnSysDynaInstTag, pSDevSlnSysDynaInst);
            return;
        }
        super.onFillParentInfo(pSDevSlnSysDynaInstTag, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevSlnSysDynaInst(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        pSDevSlnSysDynaInstTag.setPSDevSlnSysDynaInstId(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
        pSDevSlnSysDynaInstTag.setPSDevSlnSysDynaInstName(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstName());
    }

    protected void onFillEntityFullInfo(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDevSlnSysDynaInstTag, bl);
        this.onFillEntityFullInfo_PSDevSlnSysDynaInst(pSDevSlnSysDynaInstTag, bl);
    }

    protected void onFillEntityFullInfo_PSDevSlnSysDynaInst(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, boolean bl) throws Exception {
        if (pSDevSlnSysDynaInstTag.isPSDevSlnSysDynaInstIdDirty()) {
            if (pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstId() != null) {
                if (pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstId() == null || pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstName() == null) {
                    PSDevSlnSysDynaInst pSDevSlnSysDynaInst = pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInst();
                    pSDevSlnSysDynaInstTag.setPSDevSlnSysDynaInstName(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstName());
                }
            } else {
                pSDevSlnSysDynaInstTag.setPSDevSlnSysDynaInstName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevSlnSysDynaInstTag, bl);
    }

    public ArrayList<PSDevSlnSysDynaInstTag> selectByPSDevSlnSysDynaInst(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase) throws Exception {
        return this.selectByPSDevSlnSysDynaInst(pSDevSlnSysDynaInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSysDynaInstTag> selectByPSDevSlnSysDynaInst(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase, String string) throws Exception {
        return this.selectByPSDevSlnSysDynaInst(pSDevSlnSysDynaInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSysDynaInstTag> selectByPSDevSlnSysDynaInst(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSDYNAINSTID", (Object)pSDevSlnSysDynaInstBase.getPSDevSlnSysDynaInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysDynaInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysDynaInstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
    }

    public void resetPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        ArrayList<PSDevSlnSysDynaInstTag> arrayList = this.selectByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst);
        for (PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag : arrayList) {
            PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag2 = (PSDevSlnSysDynaInstTag)this.getDEModel().createEntity();
            pSDevSlnSysDynaInstTag2.setPSDevSlnSysDynaInstTagId(pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstTagId());
            pSDevSlnSysDynaInstTag2.setPSDevSlnSysDynaInstId(null);
            this.update(pSDevSlnSysDynaInstTag2);
        }
    }

    public void removeByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        final PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 = pSDevSlnSysDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysDynaInstTagServiceBase.this.onBeforeRemoveByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst2);
                PSDevSlnSysDynaInstTagServiceBase.this.internalRemoveByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst2);
                PSDevSlnSysDynaInstTagServiceBase.this.onAfterRemoveByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        ArrayList<PSDevSlnSysDynaInstTag> arrayList = this.selectByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst);
        this.onBeforeRemoveByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst, arrayList);
        for (PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag : arrayList) {
            this.remove(pSDevSlnSysDynaInstTag);
        }
        this.onAfterRemoveByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, ArrayList<PSDevSlnSysDynaInstTag> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, ArrayList<PSDevSlnSysDynaInstTag> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag) throws Exception {
        super.onBeforeRemove(pSDevSlnSysDynaInstTag);
    }

    protected void replaceParentInfo(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevSlnSysDynaInstTag, cloneSession);
        if (pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSDYNAINST", (Object)pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstId())) != null) {
            this.onFillParentInfo_PSDevSlnSysDynaInst(pSDevSlnSysDynaInstTag, (PSDevSlnSysDynaInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevSlnSysDynaInstTag, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDevSlnSysDynaInstTag, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysDynaInstId(bl, pSDevSlnSysDynaInstTag, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysDynaInstName(bl, pSDevSlnSysDynaInstTag, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysDynaInstTagId(bl, pSDevSlnSysDynaInstTag, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysDynaInstTagName(bl, pSDevSlnSysDynaInstTag, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TagTag(bl, pSDevSlnSysDynaInstTag, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TagTag2(bl, pSDevSlnSysDynaInstTag, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TagTag3(bl, pSDevSlnSysDynaInstTag, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TagTag4(bl, pSDevSlnSysDynaInstTag, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TagTag5(bl, pSDevSlnSysDynaInstTag, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TagTag6(bl, pSDevSlnSysDynaInstTag, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TagTag7(bl, pSDevSlnSysDynaInstTag, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TagTag8(bl, pSDevSlnSysDynaInstTag, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevSlnSysDynaInstTag, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstTag.isMemoDirty() : !pSDevSlnSysDynaInstTag.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstTag.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevSlnSysDynaInstTag, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysDynaInstId(boolean bl, PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstTag.isPSDevSlnSysDynaInstIdDirty() : !pSDevSlnSysDynaInstTag.isPSDevSlnSysDynaInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysDynaInstId_Default(pSDevSlnSysDynaInstTag, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysDynaInstName(boolean bl, PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstTag.isPSDevSlnSysDynaInstNameDirty() : !pSDevSlnSysDynaInstTag.isPSDevSlnSysDynaInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysDynaInstName_Default(pSDevSlnSysDynaInstTag, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSDYNAINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysDynaInstTagId(boolean bl, PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstTag.isPSDevSlnSysDynaInstTagIdDirty() && !bl2 : !pSDevSlnSysDynaInstTag.isPSDevSlnSysDynaInstTagIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstTagId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSDYNAINSTTAGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysDynaInstTagId_Default(pSDevSlnSysDynaInstTag, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSDYNAINSTTAGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysDynaInstTagName(boolean bl, PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstTag.isPSDevSlnSysDynaInstTagNameDirty() && !bl2 : !pSDevSlnSysDynaInstTag.isPSDevSlnSysDynaInstTagNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstTag.getPSDevSlnSysDynaInstTagName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSDYNAINSTTAGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysDynaInstTagName_Default(pSDevSlnSysDynaInstTag, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSDYNAINSTTAGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TagTag(boolean bl, PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstTag.isTagTagDirty() : !pSDevSlnSysDynaInstTag.isTagTagDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstTag.getTagTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TagTag_Default(pSDevSlnSysDynaInstTag, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAGTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TagTag2(boolean bl, PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstTag.isTagTag2Dirty() : !pSDevSlnSysDynaInstTag.isTagTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstTag.getTagTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TagTag2_Default(pSDevSlnSysDynaInstTag, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAGTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TagTag3(boolean bl, PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstTag.isTagTag3Dirty() : !pSDevSlnSysDynaInstTag.isTagTag3Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstTag.getTagTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TagTag3_Default(pSDevSlnSysDynaInstTag, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAGTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TagTag4(boolean bl, PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstTag.isTagTag4Dirty() : !pSDevSlnSysDynaInstTag.isTagTag4Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstTag.getTagTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TagTag4_Default(pSDevSlnSysDynaInstTag, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAGTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TagTag5(boolean bl, PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstTag.isTagTag5Dirty() : !pSDevSlnSysDynaInstTag.isTagTag5Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstTag.getTagTag5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TagTag5_Default(pSDevSlnSysDynaInstTag, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAGTAG5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TagTag6(boolean bl, PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstTag.isTagTag6Dirty() : !pSDevSlnSysDynaInstTag.isTagTag6Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstTag.getTagTag6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TagTag6_Default(pSDevSlnSysDynaInstTag, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAGTAG6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TagTag7(boolean bl, PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstTag.isTagTag7Dirty() : !pSDevSlnSysDynaInstTag.isTagTag7Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstTag.getTagTag7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TagTag7_Default(pSDevSlnSysDynaInstTag, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAGTAG7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TagTag8(boolean bl, PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstTag.isTagTag8Dirty() : !pSDevSlnSysDynaInstTag.isTagTag8Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstTag.getTagTag8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TagTag8_Default(pSDevSlnSysDynaInstTag, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAGTAG8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, boolean bl) throws Exception {
        super.onSyncEntity(pSDevSlnSysDynaInstTag, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevSlnSysDynaInstTag, bl);
    }

    public Object getDataContextValue(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevSlnSysDynaInstTag, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevSlnSysDynaInstTag, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSDYNAINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysDynaInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSDYNAINSTTAGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysDynaInstTagId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSDYNAINSTTAGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysDynaInstTagName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAGTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TagTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAGTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TagTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAGTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TagTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAGTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TagTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAGTAG5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TagTag5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAGTAG6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TagTag6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAGTAG7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TagTag7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAGTAG8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TagTag8_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDevSlnSysDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSDYNAINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysDynaInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSDYNAINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysDynaInstTagId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSDYNAINSTTAGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysDynaInstTagName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSDYNAINSTTAGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("PSDEVSLNSYSDYNAINSTTAGNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TagTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAGTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TagTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAGTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TagTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAGTAG3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TagTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAGTAG4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TagTag5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAGTAG5", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TagTag6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAGTAG6", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TagTag7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAGTAG7", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TagTag8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAGTAG8", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevSlnSysDynaInstTag)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag) throws Exception {
        super.onUpdateParent(pSDevSlnSysDynaInstTag);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnSysDynaInstTag pSDevSlnSysDynaInstTag, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNSYSDYNAINSTTAG");
        if (!bl) {
            pSDevSlnSysDynaInstTag.setCreateDate(null);
            pSDevSlnSysDynaInstTag.setCreateMan(null);
            pSDevSlnSysDynaInstTag.setPSDevSlnSysDynaInstTagId(null);
            pSDevSlnSysDynaInstTag.setUpdateDate(null);
            pSDevSlnSysDynaInstTag.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnSysDynaInstTag, xmlNode, bl);
        }
    }
}

