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
package net.ibizsys.pscore.srv.wfplatform.service;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.wfplatform.dao.PSWPDCAppInstDAO;
import net.ibizsys.pscore.srv.wfplatform.demodel.PSWPDCAppInstDEModel;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPAppInst;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPAppInstBase;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPDCAppInst;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPDCAppEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWPDCAppInstServiceBase
extends PSCoreSysServiceBase<PSWPDCAppInst> {
    private static final Log log = LogFactory.getLog(PSWPDCAppInstServiceBase.class);
    private PSWPDCAppInstDEModel pSWPDCAppInstDEModel;
    private PSWPDCAppInstDAO pSWPDCAppInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfplatform.service.PSWPDCAppInstService";
    }

    public PSWPDCAppInstDEModel getPSWPDCAppInstDEModel() {
        if (this.pSWPDCAppInstDEModel == null) {
            try {
                this.pSWPDCAppInstDEModel = (PSWPDCAppInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfplatform.demodel.PSWPDCAppInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWPDCAppInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWPDCAppInstDEModel();
    }

    public PSWPDCAppInstDAO getPSWPDCAppInstDAO() {
        if (this.pSWPDCAppInstDAO == null) {
            try {
                this.pSWPDCAppInstDAO = (PSWPDCAppInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfplatform.dao.PSWPDCAppInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWPDCAppInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWPDCAppInstDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    protected void onFillParentInfo(PSWPDCAppInst pSWPDCAppInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWPDCAPPINST_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSWPDCAppInst, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWPDCAPPINST_PSWPAPPINST_PSWPAPPINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfplatform.service.PSWPAppInstService", (SessionFactory)this.getSessionFactory());
            PSWPAppInst pSWPAppInst = (PSWPAppInst)iService.getDEModel().createEntity();
            pSWPAppInst.set("PSWPAPPINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWPAppInst);
            } else {
                iService.get(pSWPAppInst);
            }
            this.onFillParentInfo_Pswpappinst(pSWPDCAppInst, pSWPAppInst);
            return;
        }
        super.onFillParentInfo(pSWPDCAppInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSWPDCAppInst pSWPDCAppInst, PSDevCenter pSDevCenter) throws Exception {
        pSWPDCAppInst.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSWPDCAppInst.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_Pswpappinst(PSWPDCAppInst pSWPDCAppInst, PSWPAppInst pSWPAppInst) throws Exception {
        pSWPDCAppInst.setPSWPAppInstId(pSWPAppInst.getPSWPAppInstId());
        pSWPDCAppInst.setPSWPAppInstName(pSWPAppInst.getPSWPAppInstName());
    }

    protected void onFillEntityFullInfo(PSWPDCAppInst pSWPDCAppInst, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSWPDCAppInst, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSWPDCAppInst, bl);
        this.onFillEntityFullInfo_Pswpappinst(pSWPDCAppInst, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSWPDCAppInst pSWPDCAppInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_Pswpappinst(PSWPDCAppInst pSWPDCAppInst, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSWPDCAppInst pSWPDCAppInst, boolean bl) throws Exception {
        super.onWriteBackParent(pSWPDCAppInst, bl);
    }

    public ArrayList<PSWPDCAppInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSWPDCAppInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSWPDCAppInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSWPDCAppInst> selectByPswpappinst(PSWPAppInstBase pSWPAppInstBase) throws Exception {
        return this.selectByPswpappinst(pSWPAppInstBase, "", -1);
    }

    public ArrayList<PSWPDCAppInst> selectByPswpappinst(PSWPAppInstBase pSWPAppInstBase, String string) throws Exception {
        return this.selectByPswpappinst(pSWPAppInstBase, string, -1);
    }

    public ArrayList<PSWPDCAppInst> selectByPswpappinst(PSWPAppInstBase pSWPAppInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWPAPPINSTID", (Object)pSWPAppInstBase.getPSWPAppInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPswpappinstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPswpappinstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSWPDCAppInst> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWPDCAPPINST_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSWPDCAPPINST", iDataEntityModel.getDataInfo(pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSWPDCAppInst> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSWPDCAppInst pSWPDCAppInst : arrayList) {
            PSWPDCAppInst pSWPDCAppInst2 = (PSWPDCAppInst)this.getDEModel().createEntity();
            pSWPDCAppInst2.setPSWPDCAppInstId(pSWPDCAppInst.getPSWPDCAppInstId());
            pSWPDCAppInst2.setPSDevCenterId(null);
            this.update(pSWPDCAppInst2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWPDCAppInstServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSWPDCAppInstServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSWPDCAppInstServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSWPDCAppInst> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSWPDCAppInst pSWPDCAppInst : arrayList) {
            this.remove(pSWPDCAppInst);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSWPDCAppInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSWPDCAppInst> arrayList) throws Exception {
    }

    public void testRemoveByPswpappinst(PSWPAppInst pSWPAppInst) throws Exception {
        ArrayList<PSWPDCAppInst> arrayList = this.selectByPswpappinst(pSWPAppInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWPAPPINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWPAppInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWPDCAPPINST_PSWPAPPINST_PSWPAPPINSTID", "", iDataEntityModel.getName(), "PSWPDCAPPINST", iDataEntityModel.getDataInfo(pSWPAppInst), arrayList.get(0)));
        }
    }

    public void resetPswpappinst(PSWPAppInst pSWPAppInst) throws Exception {
        ArrayList<PSWPDCAppInst> arrayList = this.selectByPswpappinst(pSWPAppInst);
        for (PSWPDCAppInst pSWPDCAppInst : arrayList) {
            PSWPDCAppInst pSWPDCAppInst2 = (PSWPDCAppInst)this.getDEModel().createEntity();
            pSWPDCAppInst2.setPSWPDCAppInstId(pSWPDCAppInst.getPSWPDCAppInstId());
            pSWPDCAppInst2.setPSWPAppInstId(null);
            this.update(pSWPDCAppInst2);
        }
    }

    public void removeByPswpappinst(PSWPAppInst pSWPAppInst) throws Exception {
        final PSWPAppInst pSWPAppInst2 = pSWPAppInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWPDCAppInstServiceBase.this.onBeforeRemoveByPswpappinst(pSWPAppInst2);
                PSWPDCAppInstServiceBase.this.internalRemoveByPswpappinst(pSWPAppInst2);
                PSWPDCAppInstServiceBase.this.onAfterRemoveByPswpappinst(pSWPAppInst2);
            }
        });
    }

    protected void onBeforeRemoveByPswpappinst(PSWPAppInst pSWPAppInst) throws Exception {
    }

    protected void internalRemoveByPswpappinst(PSWPAppInst pSWPAppInst) throws Exception {
        ArrayList<PSWPDCAppInst> arrayList = this.selectByPswpappinst(pSWPAppInst);
        this.onBeforeRemoveByPswpappinst(pSWPAppInst, arrayList);
        for (PSWPDCAppInst pSWPDCAppInst : arrayList) {
            this.remove(pSWPDCAppInst);
        }
        this.onAfterRemoveByPswpappinst(pSWPAppInst, arrayList);
    }

    protected void onAfterRemoveByPswpappinst(PSWPAppInst pSWPAppInst) throws Exception {
    }

    protected void onBeforeRemoveByPswpappinst(PSWPAppInst pSWPAppInst, ArrayList<PSWPDCAppInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPswpappinst(PSWPAppInst pSWPAppInst, ArrayList<PSWPDCAppInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWPDCAppInst pSWPDCAppInst) throws Exception {
        PSWPDCAppEntityService pSWPDCAppEntityService = (PSWPDCAppEntityService)ServiceGlobal.getService(PSWPDCAppEntityService.class, (SessionFactory)this.getSessionFactory());
        pSWPDCAppEntityService.testRemoveByPSWPDCAppInst(pSWPDCAppInst);
        super.onBeforeRemove(pSWPDCAppInst);
    }

    protected void replaceParentInfo(PSWPDCAppInst pSWPDCAppInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSWPDCAppInst, cloneSession);
        if (pSWPDCAppInst.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSWPDCAppInst.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSWPDCAppInst, (PSDevCenter)iEntity);
        }
        if (pSWPDCAppInst.getPSWPAppInstId() != null && (iEntity = cloneSession.getEntity("PSWPAPPINST", (Object)pSWPDCAppInst.getPSWPAppInstId())) != null) {
            this.onFillParentInfo_Pswpappinst(pSWPDCAppInst, (PSWPAppInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWPDCAppInst pSWPDCAppInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWPDCAppInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSWPDCAppInst pSWPDCAppInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSDevCenterId(bl, pSWPDCAppInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWPAppInstId(bl, pSWPDCAppInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWPDCAppInstId(bl, pSWPDCAppInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWPDCAppInstName(bl, pSWPDCAppInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWPDCAppInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSWPDCAppInst pSWPDCAppInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPDCAppInst.isPSDevCenterIdDirty() : !pSWPDCAppInst.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSWPDCAppInst.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSWPDCAppInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWPAppInstId(boolean bl, PSWPDCAppInst pSWPDCAppInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPDCAppInst.isPSWPAppInstIdDirty() && !bl2 : !pSWPDCAppInst.isPSWPAppInstIdDirty()) {
            return null;
        }
        String string = pSWPDCAppInst.getPSWPAppInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPAPPINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPAppInstId_Default(pSWPDCAppInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPAPPINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWPDCAppInstId(boolean bl, PSWPDCAppInst pSWPDCAppInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPDCAppInst.isPSWPDCAppInstIdDirty() && !bl2 : !pSWPDCAppInst.isPSWPDCAppInstIdDirty()) {
            return null;
        }
        String string = pSWPDCAppInst.getPSWPDCAppInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPDCAPPINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPDCAppInstId_Default(pSWPDCAppInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPDCAPPINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWPDCAppInstName(boolean bl, PSWPDCAppInst pSWPDCAppInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPDCAppInst.isPSWPDCAppInstNameDirty() && !bl2 : !pSWPDCAppInst.isPSWPDCAppInstNameDirty()) {
            return null;
        }
        String string = pSWPDCAppInst.getPSWPDCAppInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPDCAPPINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPDCAppInstName_Default(pSWPDCAppInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPDCAPPINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWPDCAppInst pSWPDCAppInst, boolean bl) throws Exception {
        super.onSyncEntity(pSWPDCAppInst, bl);
    }

    protected void onSyncIndexEntities(PSWPDCAppInst pSWPDCAppInst, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWPDCAppInst, bl);
    }

    public Object getDataContextValue(PSWPDCAppInst pSWPDCAppInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSWPDCAppInst, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSWPDCAppInst pSWPDCAppInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSWPDCAppInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPAPPINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSWPAppInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPAPPINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSWPAppInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPDCAPPINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSWPDCAppInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPDCAPPINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSWPDCAppInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
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

    protected String onTestValueRule_PSWPAppInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPAPPINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPAppInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPAPPINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPDCAppInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPDCAPPINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPDCAppInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPDCAPPINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSWPDCAppInst pSWPDCAppInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSWPDCAppInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWPDCAppInst pSWPDCAppInst) throws Exception {
        super.onUpdateParent(pSWPDCAppInst);
    }

    @Override
    protected void exportCurXmlModel(PSWPDCAppInst pSWPDCAppInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWPDCAPPINST");
        if (!bl) {
            pSWPDCAppInst.setCreateDate(null);
            pSWPDCAppInst.setCreateMan(null);
            pSWPDCAppInst.setPSDevCenterName(null);
            pSWPDCAppInst.setPSWPAppInstName(null);
            pSWPDCAppInst.setPSWPDCAppInstId(null);
            pSWPDCAppInst.setUpdateDate(null);
            pSWPDCAppInst.setUpdateMan(null);
            super.exportCurXmlModel(pSWPDCAppInst, xmlNode, bl);
        }
    }
}

