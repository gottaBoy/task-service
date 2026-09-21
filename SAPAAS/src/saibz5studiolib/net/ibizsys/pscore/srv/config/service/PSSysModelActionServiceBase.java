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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSSysModelActionDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSysModelActionDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSysModelAction;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInstBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelActionServiceBase
extends PSCoreSysServiceBase<PSSysModelAction> {
    private static final Log log = LogFactory.getLog(PSSysModelActionServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysModelActionDEModel pSSysModelActionDEModel;
    private PSSysModelActionDAO pSSysModelActionDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSysModelActionService";
    }

    public PSSysModelActionDEModel getPSSysModelActionDEModel() {
        if (this.pSSysModelActionDEModel == null) {
            try {
                this.pSSysModelActionDEModel = (PSSysModelActionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSysModelActionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelActionDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysModelActionDEModel();
    }

    public PSSysModelActionDAO getPSSysModelActionDAO() {
        if (this.pSSysModelActionDAO == null) {
            try {
                this.pSSysModelActionDAO = (PSSysModelActionDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSysModelActionDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelActionDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysModelActionDAO();
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

    protected void onFillParentInfo(PSSysModelAction pSSysModelAction, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMODELACTION_PSSYSMODELINST_PSSYSMODELINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService", (SessionFactory)this.getSessionFactory());
            PSSysModelInst pSSysModelInst = (PSSysModelInst)iService.getDEModel().createEntity();
            pSSysModelInst.set("PSSYSMODELINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysModelInst);
            } else {
                iService.get((IEntity)pSSysModelInst);
            }
            this.onFillParentInfo_PSSysModelInst(pSSysModelAction, pSSysModelInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMODELACTION_PSSYSMODELINST_SRCPSSYSMODELINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService", (SessionFactory)this.getSessionFactory());
            PSSysModelInst pSSysModelInst = (PSSysModelInst)iService.getDEModel().createEntity();
            pSSysModelInst.set("PSSYSMODELINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysModelInst);
            } else {
                iService.get((IEntity)pSSysModelInst);
            }
            this.onFillParentInfo_SrcPSSysModelInst(pSSysModelAction, pSSysModelInst);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysModelAction, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysModelInst(PSSysModelAction pSSysModelAction, PSSysModelInst pSSysModelInst) throws Exception {
        pSSysModelAction.setPSSysModelInstId(pSSysModelInst.getPSSysModelInstId());
        pSSysModelAction.setPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
    }

    protected void onFillParentInfo_SrcPSSysModelInst(PSSysModelAction pSSysModelAction, PSSysModelInst pSSysModelInst) throws Exception {
        pSSysModelAction.setSrcPSSysModelInstId(pSSysModelInst.getPSSysModelInstId());
        pSSysModelAction.setSrcPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
    }

    protected void onFillEntityFullInfo(PSSysModelAction pSSysModelAction, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSysModelAction, bl);
        this.onFillEntityFullInfo_PSSysModelInst(pSSysModelAction, bl);
        this.onFillEntityFullInfo_SrcPSSysModelInst(pSSysModelAction, bl);
    }

    protected void onFillEntityFullInfo_PSSysModelInst(PSSysModelAction pSSysModelAction, boolean bl) throws Exception {
        if (pSSysModelAction.isPSSysModelInstIdDirty()) {
            if (pSSysModelAction.getPSSysModelInstId() != null) {
                if (pSSysModelAction.getPSSysModelInstId() == null || pSSysModelAction.getPSSysModelInstName() == null) {
                    PSSysModelInst pSSysModelInst = pSSysModelAction.getPSSysModelInst();
                    pSSysModelAction.setPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
                }
            } else {
                pSSysModelAction.setPSSysModelInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_SrcPSSysModelInst(PSSysModelAction pSSysModelAction, boolean bl) throws Exception {
        if (pSSysModelAction.isSrcPSSysModelInstIdDirty()) {
            if (pSSysModelAction.getSrcPSSysModelInstId() != null) {
                if (pSSysModelAction.getSrcPSSysModelInstId() == null || pSSysModelAction.getSrcPSSysModelInstName() == null) {
                    PSSysModelInst pSSysModelInst = pSSysModelAction.getSrcPSSysModelInst();
                    pSSysModelAction.setSrcPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
                }
            } else {
                pSSysModelAction.setSrcPSSysModelInstName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysModelAction pSSysModelAction, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysModelAction, bl);
    }

    public ArrayList<PSSysModelAction> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase) throws Exception {
        return this.selectByPSSysModelInst(pSSysModelInstBase, "", -1);
    }

    public ArrayList<PSSysModelAction> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string) throws Exception {
        return this.selectByPSSysModelInst(pSSysModelInstBase, string, -1);
    }

    public ArrayList<PSSysModelAction> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMODELINSTID", (Object)pSSysModelInstBase.getPSSysModelInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysModelInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysModelInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysModelAction> selectBySrcPSSysModelInst(PSSysModelInstBase pSSysModelInstBase) throws Exception {
        return this.selectBySrcPSSysModelInst(pSSysModelInstBase, "", -1);
    }

    public ArrayList<PSSysModelAction> selectBySrcPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string) throws Exception {
        return this.selectBySrcPSSysModelInst(pSSysModelInstBase, string, -1);
    }

    public ArrayList<PSSysModelAction> selectBySrcPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SRCPSSYSMODELINSTID", (Object)pSSysModelInstBase.getPSSysModelInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySrcPSSysModelInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySrcPSSysModelInstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    public void resetPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSSysModelAction> arrayList = this.selectByPSSysModelInst(pSSysModelInst);
        for (PSSysModelAction pSSysModelAction : arrayList) {
            PSSysModelAction pSSysModelAction2 = (PSSysModelAction)this.getDEModel().createEntity();
            pSSysModelAction2.setPSSysModelActionId(pSSysModelAction.getPSSysModelActionId());
            pSSysModelAction2.setPSSysModelInstId(null);
            this.update(pSSysModelAction2);
        }
    }

    public void removeByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        final PSSysModelInst pSSysModelInst2 = pSSysModelInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysModelActionServiceBase.this.onBeforeRemoveByPSSysModelInst(pSSysModelInst2);
                PSSysModelActionServiceBase.this.internalRemoveByPSSysModelInst(pSSysModelInst2);
                PSSysModelActionServiceBase.this.onAfterRemoveByPSSysModelInst(pSSysModelInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void internalRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSSysModelAction> arrayList = this.selectByPSSysModelInst(pSSysModelInst);
        this.onBeforeRemoveByPSSysModelInst(pSSysModelInst, arrayList);
        for (PSSysModelAction pSSysModelAction : arrayList) {
            this.remove((IEntity)pSSysModelAction);
        }
        this.onAfterRemoveByPSSysModelInst(pSSysModelInst, arrayList);
    }

    protected void onAfterRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void onBeforeRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSSysModelAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSSysModelAction> arrayList) throws Exception {
    }

    public void testRemoveBySrcPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    public void resetSrcPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSSysModelAction> arrayList = this.selectBySrcPSSysModelInst(pSSysModelInst);
        for (PSSysModelAction pSSysModelAction : arrayList) {
            PSSysModelAction pSSysModelAction2 = (PSSysModelAction)this.getDEModel().createEntity();
            pSSysModelAction2.setPSSysModelActionId(pSSysModelAction.getPSSysModelActionId());
            pSSysModelAction2.setSrcPSSysModelInstId(null);
            this.update(pSSysModelAction2);
        }
    }

    public void removeBySrcPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        final PSSysModelInst pSSysModelInst2 = pSSysModelInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysModelActionServiceBase.this.onBeforeRemoveBySrcPSSysModelInst(pSSysModelInst2);
                PSSysModelActionServiceBase.this.internalRemoveBySrcPSSysModelInst(pSSysModelInst2);
                PSSysModelActionServiceBase.this.onAfterRemoveBySrcPSSysModelInst(pSSysModelInst2);
            }
        });
    }

    protected void onBeforeRemoveBySrcPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void internalRemoveBySrcPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSSysModelAction> arrayList = this.selectBySrcPSSysModelInst(pSSysModelInst);
        this.onBeforeRemoveBySrcPSSysModelInst(pSSysModelInst, arrayList);
        for (PSSysModelAction pSSysModelAction : arrayList) {
            this.remove((IEntity)pSSysModelAction);
        }
        this.onAfterRemoveBySrcPSSysModelInst(pSSysModelInst, arrayList);
    }

    protected void onAfterRemoveBySrcPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void onBeforeRemoveBySrcPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSSysModelAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySrcPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSSysModelAction> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysModelAction pSSysModelAction) throws Exception {
        super.onBeforeRemove(pSSysModelAction);
    }

    protected void replaceParentInfo(PSSysModelAction pSSysModelAction, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysModelAction, cloneSession);
        if (pSSysModelAction.getPSSysModelInstId() != null && (iEntity = cloneSession.getEntity("PSSYSMODELINST", (Object)pSSysModelAction.getPSSysModelInstId())) != null) {
            this.onFillParentInfo_PSSysModelInst(pSSysModelAction, (PSSysModelInst)iEntity);
        }
        if (pSSysModelAction.getSrcPSSysModelInstId() != null && (iEntity = cloneSession.getEntity("PSSYSMODELINST", (Object)pSSysModelAction.getSrcPSSysModelInstId())) != null) {
            this.onFillParentInfo_SrcPSSysModelInst(pSSysModelAction, (PSSysModelInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysModelAction pSSysModelAction, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysModelAction, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysModelAction pSSysModelAction, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSSysModelActionId(bl, pSSysModelAction, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelActionName(bl, pSSysModelAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstId(bl, pSSysModelAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstName(bl, pSSysModelAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSSysModelInstId(bl, pSSysModelAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSSysModelInstName(bl, pSSysModelAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysModelAction, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSSysModelActionId(boolean bl, PSSysModelAction pSSysModelAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelAction.isPSSysModelActionIdDirty() && !bl2 : !pSSysModelAction.isPSSysModelActionIdDirty()) {
            return null;
        }
        String string = pSSysModelAction.getPSSysModelActionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELACTIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelActionId_Default((IEntity)pSSysModelAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelActionName(boolean bl, PSSysModelAction pSSysModelAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelAction.isPSSysModelActionNameDirty() && !bl2 : !pSSysModelAction.isPSSysModelActionNameDirty()) {
            return null;
        }
        String string = pSSysModelAction.getPSSysModelActionName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELACTIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelActionName_Default((IEntity)pSSysModelAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELACTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelInstId(boolean bl, PSSysModelAction pSSysModelAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelAction.isPSSysModelInstIdDirty() : !pSSysModelAction.isPSSysModelInstIdDirty()) {
            return null;
        }
        String string = pSSysModelAction.getPSSysModelInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstId_Default((IEntity)pSSysModelAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelInstName(boolean bl, PSSysModelAction pSSysModelAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelAction.isPSSysModelInstNameDirty() : !pSSysModelAction.isPSSysModelInstNameDirty()) {
            return null;
        }
        String string = pSSysModelAction.getPSSysModelInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstName_Default((IEntity)pSSysModelAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcPSSysModelInstId(boolean bl, PSSysModelAction pSSysModelAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelAction.isSrcPSSysModelInstIdDirty() : !pSSysModelAction.isSrcPSSysModelInstIdDirty()) {
            return null;
        }
        String string = pSSysModelAction.getSrcPSSysModelInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSSysModelInstId_Default((IEntity)pSSysModelAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSSYSMODELINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcPSSysModelInstName(boolean bl, PSSysModelAction pSSysModelAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelAction.isSrcPSSysModelInstNameDirty() : !pSSysModelAction.isSrcPSSysModelInstNameDirty()) {
            return null;
        }
        String string = pSSysModelAction.getSrcPSSysModelInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSSysModelInstName_Default((IEntity)pSSysModelAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSSYSMODELINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysModelAction pSSysModelAction, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysModelAction, bl);
    }

    protected void onSyncIndexEntities(PSSysModelAction pSSysModelAction, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysModelAction, bl);
    }

    public Object getDataContextValue(PSSysModelAction pSSysModelAction, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysModelAction, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysModelAction pSSysModelAction, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysModelAction, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSSYSMODELINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSSysModelInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSSYSMODELINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSSysModelInstName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSSysModelActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELACTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSSysModelInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSSYSMODELINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSSysModelInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSSYSMODELINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysModelAction pSSysModelAction) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysModelAction)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysModelAction pSSysModelAction) throws Exception {
        super.onUpdateParent((IEntity)pSSysModelAction);
    }

    @Override
    protected void exportCurXmlModel(PSSysModelAction pSSysModelAction, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSMODELACTION");
        if (!bl) {
            super.exportCurXmlModel(pSSysModelAction, xmlNode, bl);
        }
    }
}

