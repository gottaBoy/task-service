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
package net.ibizsys.pscore.srv.paasmgr.service;

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
import net.ibizsys.pscore.srv.paasmgr.dao.PSSysModelInstSumDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSSysModelInstSumDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInstBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInstSum;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelInstSumServiceBase
extends PSCoreSysServiceBase<PSSysModelInstSum> {
    private static final Log log = LogFactory.getLog(PSSysModelInstSumServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysModelInstSumDEModel pSSysModelInstSumDEModel;
    private PSSysModelInstSumDAO pSSysModelInstSumDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstSumService";
    }

    public PSSysModelInstSumDEModel getPSSysModelInstSumDEModel() {
        if (this.pSSysModelInstSumDEModel == null) {
            try {
                this.pSSysModelInstSumDEModel = (PSSysModelInstSumDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSSysModelInstSumDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelInstSumDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysModelInstSumDEModel();
    }

    public PSSysModelInstSumDAO getPSSysModelInstSumDAO() {
        if (this.pSSysModelInstSumDAO == null) {
            try {
                this.pSSysModelInstSumDAO = (PSSysModelInstSumDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSSysModelInstSumDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelInstSumDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysModelInstSumDAO();
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

    protected void onFillParentInfo(PSSysModelInstSum pSSysModelInstSum, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMODELINSTSUM_PSSYSMODELINST_PSSYSMODELINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService", (SessionFactory)this.getSessionFactory());
            PSSysModelInst pSSysModelInst = (PSSysModelInst)iService.getDEModel().createEntity();
            pSSysModelInst.set("PSSYSMODELINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysModelInst);
            } else {
                iService.get((IEntity)pSSysModelInst);
            }
            this.onFillParentInfo_PSSysModelInst(pSSysModelInstSum, pSSysModelInst);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysModelInstSum, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysModelInst(PSSysModelInstSum pSSysModelInstSum, PSSysModelInst pSSysModelInst) throws Exception {
        pSSysModelInstSum.setPSSysModelInstId(pSSysModelInst.getPSSysModelInstId());
        pSSysModelInstSum.setPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
    }

    protected boolean onFillEntityKeyValue(PSSysModelInstSum pSSysModelInstSum, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSysModelInstSum.get("PSSYSMODELINSTID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSysModelInstSum.get("PSSYSMODELINSTSUMNAME");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSSysModelInstSum.set(this.getPSSysModelInstSumDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSysModelInstSum pSSysModelInstSum, boolean bl) throws Exception {
        if (bl) {
            if (pSSysModelInstSum.getCnt() == null) {
                pSSysModelInstSum.setCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysModelInstSum.getTmpCnt() == null) {
                pSSysModelInstSum.setTmpCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysModelInstSum.getTmpUsedSize() == null) {
                pSSysModelInstSum.setTmpUsedSize((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysModelInstSum.getUsedSize() == null) {
                pSSysModelInstSum.setUsedSize((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysModelInstSum, bl);
        this.onFillEntityFullInfo_PSSysModelInst(pSSysModelInstSum, bl);
    }

    protected void onFillEntityFullInfo_PSSysModelInst(PSSysModelInstSum pSSysModelInstSum, boolean bl) throws Exception {
        if (pSSysModelInstSum.isPSSysModelInstIdDirty()) {
            if (pSSysModelInstSum.getPSSysModelInstId() != null) {
                if (pSSysModelInstSum.getPSSysModelInstId() == null || pSSysModelInstSum.getPSSysModelInstName() == null) {
                    PSSysModelInst pSSysModelInst = pSSysModelInstSum.getPSSysModelInst();
                    pSSysModelInstSum.setPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
                }
            } else {
                pSSysModelInstSum.setPSSysModelInstName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysModelInstSum pSSysModelInstSum, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysModelInstSum, bl);
    }

    public ArrayList<PSSysModelInstSum> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase) throws Exception {
        return this.selectByPSSysModelInst(pSSysModelInstBase, "", -1);
    }

    public ArrayList<PSSysModelInstSum> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string) throws Exception {
        return this.selectByPSSysModelInst(pSSysModelInstBase, string, -1);
    }

    public ArrayList<PSSysModelInstSum> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string, int n) throws Exception {
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

    public void testRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    public void resetPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSSysModelInstSum> arrayList = this.selectByPSSysModelInst(pSSysModelInst);
        for (PSSysModelInstSum pSSysModelInstSum : arrayList) {
            PSSysModelInstSum pSSysModelInstSum2 = (PSSysModelInstSum)this.getDEModel().createEntity();
            pSSysModelInstSum2.setPSSysModelInstSumId(pSSysModelInstSum.getPSSysModelInstSumId());
            pSSysModelInstSum2.setPSSysModelInstId(null);
            this.update(pSSysModelInstSum2);
        }
    }

    public void removeByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        final PSSysModelInst pSSysModelInst2 = pSSysModelInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysModelInstSumServiceBase.this.onBeforeRemoveByPSSysModelInst(pSSysModelInst2);
                PSSysModelInstSumServiceBase.this.internalRemoveByPSSysModelInst(pSSysModelInst2);
                PSSysModelInstSumServiceBase.this.onAfterRemoveByPSSysModelInst(pSSysModelInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void internalRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSSysModelInstSum> arrayList = this.selectByPSSysModelInst(pSSysModelInst);
        this.onBeforeRemoveByPSSysModelInst(pSSysModelInst, arrayList);
        for (PSSysModelInstSum pSSysModelInstSum : arrayList) {
            this.remove((IEntity)pSSysModelInstSum);
        }
        this.onAfterRemoveByPSSysModelInst(pSSysModelInst, arrayList);
    }

    protected void onAfterRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void onBeforeRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSSysModelInstSum> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSSysModelInstSum> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysModelInstSum pSSysModelInstSum) throws Exception {
        super.onBeforeRemove(pSSysModelInstSum);
    }

    protected void replaceParentInfo(PSSysModelInstSum pSSysModelInstSum, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysModelInstSum, cloneSession);
        if (pSSysModelInstSum.getPSSysModelInstId() != null && (iEntity = cloneSession.getEntity("PSSYSMODELINST", (Object)pSSysModelInstSum.getPSSysModelInstId())) != null) {
            this.onFillParentInfo_PSSysModelInst(pSSysModelInstSum, (PSSysModelInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysModelInstSum pSSysModelInstSum, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysModelInstSum, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysModelInstSum pSSysModelInstSum, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Cnt(bl, pSSysModelInstSum, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelLogicName(bl, pSSysModelInstSum, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstId(bl, pSSysModelInstSum, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstName(bl, pSSysModelInstSum, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstSumId(bl, pSSysModelInstSum, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstSumName(bl, pSSysModelInstSum, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TmpCnt(bl, pSSysModelInstSum, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TmpUsedSize(bl, pSSysModelInstSum, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UsedSize(bl, pSSysModelInstSum, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysModelInstSum, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Cnt(boolean bl, PSSysModelInstSum pSSysModelInstSum, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstSum.isCntDirty() : !pSSysModelInstSum.isCntDirty()) {
            return null;
        }
        Integer n = pSSysModelInstSum.getCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Cnt_Default((IEntity)pSSysModelInstSum, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModelLogicName(boolean bl, PSSysModelInstSum pSSysModelInstSum, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstSum.isModelLogicNameDirty() : !pSSysModelInstSum.isModelLogicNameDirty()) {
            return null;
        }
        String string = pSSysModelInstSum.getModelLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelLogicName_Default((IEntity)pSSysModelInstSum, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELLOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelInstId(boolean bl, PSSysModelInstSum pSSysModelInstSum, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstSum.isPSSysModelInstIdDirty() && !bl2 : !pSSysModelInstSum.isPSSysModelInstIdDirty()) {
            return null;
        }
        String string = pSSysModelInstSum.getPSSysModelInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstId_Default((IEntity)pSSysModelInstSum, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysModelInstName(boolean bl, PSSysModelInstSum pSSysModelInstSum, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstSum.isPSSysModelInstNameDirty() : !pSSysModelInstSum.isPSSysModelInstNameDirty()) {
            return null;
        }
        String string = pSSysModelInstSum.getPSSysModelInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstName_Default((IEntity)pSSysModelInstSum, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysModelInstSumId(boolean bl, PSSysModelInstSum pSSysModelInstSum, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstSum.isPSSysModelInstSumIdDirty() && !bl2 : !pSSysModelInstSum.isPSSysModelInstSumIdDirty()) {
            return null;
        }
        String string = pSSysModelInstSum.getPSSysModelInstSumId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTSUMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstSumId_Default((IEntity)pSSysModelInstSum, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTSUMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelInstSumName(boolean bl, PSSysModelInstSum pSSysModelInstSum, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstSum.isPSSysModelInstSumNameDirty() && !bl2 : !pSSysModelInstSum.isPSSysModelInstSumNameDirty()) {
            return null;
        }
        String string = pSSysModelInstSum.getPSSysModelInstSumName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTSUMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstSumName_Default((IEntity)pSSysModelInstSum, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTSUMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TmpCnt(boolean bl, PSSysModelInstSum pSSysModelInstSum, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstSum.isTmpCntDirty() : !pSSysModelInstSum.isTmpCntDirty()) {
            return null;
        }
        Integer n = pSSysModelInstSum.getTmpCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TmpCnt_Default((IEntity)pSSysModelInstSum, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TMPCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TmpUsedSize(boolean bl, PSSysModelInstSum pSSysModelInstSum, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstSum.isTmpUsedSizeDirty() : !pSSysModelInstSum.isTmpUsedSizeDirty()) {
            return null;
        }
        Integer n = pSSysModelInstSum.getTmpUsedSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TmpUsedSize_Default((IEntity)pSSysModelInstSum, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TMPUSEDSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UsedSize(boolean bl, PSSysModelInstSum pSSysModelInstSum, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstSum.isUsedSizeDirty() : !pSSysModelInstSum.isUsedSizeDirty()) {
            return null;
        }
        Integer n = pSSysModelInstSum.getUsedSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UsedSize_Default((IEntity)pSSysModelInstSum, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USEDSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysModelInstSum pSSysModelInstSum, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysModelInstSum, bl);
    }

    protected void onSyncIndexEntities(PSSysModelInstSum pSSysModelInstSum, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysModelInstSum, bl);
    }

    public Object getDataContextValue(PSSysModelInstSum pSSysModelInstSum, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysModelInstSum, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysModelInstSum pSSysModelInstSum, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysModelInstSum, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Cnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTSUMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstSumId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTSUMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstSumName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TMPCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TmpCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TMPUSEDSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TmpUsedSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USEDSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UsedSize_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_Cnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ModelLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELLOGICNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSSysModelInstSumId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELINSTSUMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelInstSumName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELINSTSUMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TmpCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TmpUsedSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_UsedSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSSysModelInstSum pSSysModelInstSum) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysModelInstSum)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysModelInstSum pSSysModelInstSum) throws Exception {
        super.onUpdateParent((IEntity)pSSysModelInstSum);
    }

    @Override
    protected void exportCurXmlModel(PSSysModelInstSum pSSysModelInstSum, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSMODELINSTSUM");
        if (!bl) {
            pSSysModelInstSum.setCreateDate(null);
            pSSysModelInstSum.setCreateMan(null);
            pSSysModelInstSum.setPSSysModelInstSumId(null);
            pSSysModelInstSum.setUpdateDate(null);
            pSSysModelInstSum.setUpdateMan(null);
            super.exportCurXmlModel(pSSysModelInstSum, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSysModelInstSum pSSysModelInstSum, PSSystem pSSystem) throws Exception {
        PSSysModelInstSum pSSysModelInstSum2 = new PSSysModelInstSum();
        pSSysModelInstSum2.setPSSysModelInstId(pSSysModelInstSum.getPSSysModelInstId());
        pSSysModelInstSum2.setPSSysModelInstSumName(pSSysModelInstSum.getPSSysModelInstSumName());
        if (this.selectOne((IEntity)pSSysModelInstSum2, true)) {
            return pSSysModelInstSum2.getPSSysModelInstSumId();
        }
        return super.getEntityFolderKeyValue(pSSysModelInstSum, pSSystem);
    }
}

