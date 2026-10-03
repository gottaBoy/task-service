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
import net.ibizsys.pscore.srv.wfplatform.dao.PSWPDCEngineInstDAO;
import net.ibizsys.pscore.srv.wfplatform.demodel.PSWPDCEngineInstDEModel;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPDCEngineInst;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPEngineInst;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPEngineInstBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWPDCEngineInstServiceBase
extends PSCoreSysServiceBase<PSWPDCEngineInst> {
    private static final Log log = LogFactory.getLog(PSWPDCEngineInstServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSWPDCEngineInstDEModel pSWPDCEngineInstDEModel;
    private PSWPDCEngineInstDAO pSWPDCEngineInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfplatform.service.PSWPDCEngineInstService";
    }

    public PSWPDCEngineInstDEModel getPSWPDCEngineInstDEModel() {
        if (this.pSWPDCEngineInstDEModel == null) {
            try {
                this.pSWPDCEngineInstDEModel = (PSWPDCEngineInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfplatform.demodel.PSWPDCEngineInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWPDCEngineInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWPDCEngineInstDEModel();
    }

    public PSWPDCEngineInstDAO getPSWPDCEngineInstDAO() {
        if (this.pSWPDCEngineInstDAO == null) {
            try {
                this.pSWPDCEngineInstDAO = (PSWPDCEngineInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfplatform.dao.PSWPDCEngineInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWPDCEngineInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWPDCEngineInstDAO();
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

    protected void onFillParentInfo(PSWPDCEngineInst pSWPDCEngineInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWPDCENGINEINST_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSWPDCEngineInst, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWPDCENGINEINST_PSWPENGINEINST_PSWPENGINEINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfplatform.service.PSWPEngineInstService", (SessionFactory)this.getSessionFactory());
            PSWPEngineInst pSWPEngineInst = (PSWPEngineInst)iService.getDEModel().createEntity();
            pSWPEngineInst.set("PSWPENGINEINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWPEngineInst);
            } else {
                iService.get(pSWPEngineInst);
            }
            this.onFillParentInfo_PSWPEngineInst(pSWPDCEngineInst, pSWPEngineInst);
            return;
        }
        super.onFillParentInfo(pSWPDCEngineInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSWPDCEngineInst pSWPDCEngineInst, PSDevCenter pSDevCenter) throws Exception {
        pSWPDCEngineInst.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSWPDCEngineInst.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSWPEngineInst(PSWPDCEngineInst pSWPDCEngineInst, PSWPEngineInst pSWPEngineInst) throws Exception {
        pSWPDCEngineInst.setPSWPEngineInstId(pSWPEngineInst.getPSWPEngineInstId());
        pSWPDCEngineInst.setPSWPEngineInstName(pSWPEngineInst.getPSWPEngineInstName());
    }

    protected void onFillEntityFullInfo(PSWPDCEngineInst pSWPDCEngineInst, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSWPDCEngineInst, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSWPDCEngineInst, bl);
        this.onFillEntityFullInfo_PSWPEngineInst(pSWPDCEngineInst, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSWPDCEngineInst pSWPDCEngineInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWPEngineInst(PSWPDCEngineInst pSWPDCEngineInst, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSWPDCEngineInst pSWPDCEngineInst, boolean bl) throws Exception {
        super.onWriteBackParent(pSWPDCEngineInst, bl);
    }

    public ArrayList<PSWPDCEngineInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSWPDCEngineInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSWPDCEngineInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSWPDCEngineInst> selectByPSWPEngineInst(PSWPEngineInstBase pSWPEngineInstBase) throws Exception {
        return this.selectByPSWPEngineInst(pSWPEngineInstBase, "", -1);
    }

    public ArrayList<PSWPDCEngineInst> selectByPSWPEngineInst(PSWPEngineInstBase pSWPEngineInstBase, String string) throws Exception {
        return this.selectByPSWPEngineInst(pSWPEngineInstBase, string, -1);
    }

    public ArrayList<PSWPDCEngineInst> selectByPSWPEngineInst(PSWPEngineInstBase pSWPEngineInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWPENGINEINSTID", (Object)pSWPEngineInstBase.getPSWPEngineInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWPEngineInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWPEngineInstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSWPDCEngineInst> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWPDCENGINEINST_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSWPDCENGINEINST", iDataEntityModel.getDataInfo(pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSWPDCEngineInst> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSWPDCEngineInst pSWPDCEngineInst : arrayList) {
            PSWPDCEngineInst pSWPDCEngineInst2 = (PSWPDCEngineInst)this.getDEModel().createEntity();
            pSWPDCEngineInst2.setPSWPDCEngineInstId(pSWPDCEngineInst.getPSWPDCEngineInstId());
            pSWPDCEngineInst2.setPSDevCenterId(null);
            this.update(pSWPDCEngineInst2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWPDCEngineInstServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSWPDCEngineInstServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSWPDCEngineInstServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSWPDCEngineInst> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSWPDCEngineInst pSWPDCEngineInst : arrayList) {
            this.remove(pSWPDCEngineInst);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSWPDCEngineInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSWPDCEngineInst> arrayList) throws Exception {
    }

    public void testRemoveByPSWPEngineInst(PSWPEngineInst pSWPEngineInst) throws Exception {
        ArrayList<PSWPDCEngineInst> arrayList = this.selectByPSWPEngineInst(pSWPEngineInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWPENGINEINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWPEngineInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWPDCENGINEINST_PSWPENGINEINST_PSWPENGINEINSTID", "", iDataEntityModel.getName(), "PSWPDCENGINEINST", iDataEntityModel.getDataInfo(pSWPEngineInst), arrayList.get(0)));
        }
    }

    public void resetPSWPEngineInst(PSWPEngineInst pSWPEngineInst) throws Exception {
        ArrayList<PSWPDCEngineInst> arrayList = this.selectByPSWPEngineInst(pSWPEngineInst);
        for (PSWPDCEngineInst pSWPDCEngineInst : arrayList) {
            PSWPDCEngineInst pSWPDCEngineInst2 = (PSWPDCEngineInst)this.getDEModel().createEntity();
            pSWPDCEngineInst2.setPSWPDCEngineInstId(pSWPDCEngineInst.getPSWPDCEngineInstId());
            pSWPDCEngineInst2.setPSWPEngineInstId(null);
            this.update(pSWPDCEngineInst2);
        }
    }

    public void removeByPSWPEngineInst(PSWPEngineInst pSWPEngineInst) throws Exception {
        final PSWPEngineInst pSWPEngineInst2 = pSWPEngineInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWPDCEngineInstServiceBase.this.onBeforeRemoveByPSWPEngineInst(pSWPEngineInst2);
                PSWPDCEngineInstServiceBase.this.internalRemoveByPSWPEngineInst(pSWPEngineInst2);
                PSWPDCEngineInstServiceBase.this.onAfterRemoveByPSWPEngineInst(pSWPEngineInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSWPEngineInst(PSWPEngineInst pSWPEngineInst) throws Exception {
    }

    protected void internalRemoveByPSWPEngineInst(PSWPEngineInst pSWPEngineInst) throws Exception {
        ArrayList<PSWPDCEngineInst> arrayList = this.selectByPSWPEngineInst(pSWPEngineInst);
        this.onBeforeRemoveByPSWPEngineInst(pSWPEngineInst, arrayList);
        for (PSWPDCEngineInst pSWPDCEngineInst : arrayList) {
            this.remove(pSWPDCEngineInst);
        }
        this.onAfterRemoveByPSWPEngineInst(pSWPEngineInst, arrayList);
    }

    protected void onAfterRemoveByPSWPEngineInst(PSWPEngineInst pSWPEngineInst) throws Exception {
    }

    protected void onBeforeRemoveByPSWPEngineInst(PSWPEngineInst pSWPEngineInst, ArrayList<PSWPDCEngineInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWPEngineInst(PSWPEngineInst pSWPEngineInst, ArrayList<PSWPDCEngineInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWPDCEngineInst pSWPDCEngineInst) throws Exception {
        super.onBeforeRemove(pSWPDCEngineInst);
    }

    protected void replaceParentInfo(PSWPDCEngineInst pSWPDCEngineInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSWPDCEngineInst, cloneSession);
        if (pSWPDCEngineInst.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSWPDCEngineInst.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSWPDCEngineInst, (PSDevCenter)iEntity);
        }
        if (pSWPDCEngineInst.getPSWPEngineInstId() != null && (iEntity = cloneSession.getEntity("PSWPENGINEINST", (Object)pSWPDCEngineInst.getPSWPEngineInstId())) != null) {
            this.onFillParentInfo_PSWPEngineInst(pSWPDCEngineInst, (PSWPEngineInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWPDCEngineInst pSWPDCEngineInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWPDCEngineInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSWPDCEngineInst pSWPDCEngineInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSDevCenterId(bl, pSWPDCEngineInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWPDCEngineInstId(bl, pSWPDCEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWPDCEngineInstName(bl, pSWPDCEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWPEngineInstId(bl, pSWPDCEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWPDCEngineInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSWPDCEngineInst pSWPDCEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPDCEngineInst.isPSDevCenterIdDirty() && !bl2 : !pSWPDCEngineInst.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSWPDCEngineInst.getPSDevCenterId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSWPDCEngineInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWPDCEngineInstId(boolean bl, PSWPDCEngineInst pSWPDCEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPDCEngineInst.isPSWPDCEngineInstIdDirty() && !bl2 : !pSWPDCEngineInst.isPSWPDCEngineInstIdDirty()) {
            return null;
        }
        String string = pSWPDCEngineInst.getPSWPDCEngineInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPDCENGINEINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPDCEngineInstId_Default(pSWPDCEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPDCENGINEINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWPDCEngineInstName(boolean bl, PSWPDCEngineInst pSWPDCEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPDCEngineInst.isPSWPDCEngineInstNameDirty() && !bl2 : !pSWPDCEngineInst.isPSWPDCEngineInstNameDirty()) {
            return null;
        }
        String string = pSWPDCEngineInst.getPSWPDCEngineInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPDCENGINEINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPDCEngineInstName_Default(pSWPDCEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPDCENGINEINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWPEngineInstId(boolean bl, PSWPDCEngineInst pSWPDCEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPDCEngineInst.isPSWPEngineInstIdDirty() : !pSWPDCEngineInst.isPSWPEngineInstIdDirty()) {
            return null;
        }
        String string = pSWPDCEngineInst.getPSWPEngineInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPEngineInstId_Default(pSWPDCEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPENGINEINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWPDCEngineInst pSWPDCEngineInst, boolean bl) throws Exception {
        super.onSyncEntity(pSWPDCEngineInst, bl);
    }

    protected void onSyncIndexEntities(PSWPDCEngineInst pSWPDCEngineInst, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWPDCEngineInst, bl);
    }

    public Object getDataContextValue(PSWPDCEngineInst pSWPDCEngineInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSWPDCEngineInst, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSWPDCEngineInst pSWPDCEngineInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSWPDCEngineInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPDCENGINEINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWPDCEngineInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPDCENGINEINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWPDCEngineInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPENGINEINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWPEngineInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPENGINEINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWPEngineInstName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSWPDCEngineInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPDCENGINEINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPDCEngineInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPDCENGINEINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPEngineInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPENGINEINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPEngineInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPENGINEINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSWPDCEngineInst pSWPDCEngineInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSWPDCEngineInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWPDCEngineInst pSWPDCEngineInst) throws Exception {
        super.onUpdateParent(pSWPDCEngineInst);
    }

    @Override
    protected void exportCurXmlModel(PSWPDCEngineInst pSWPDCEngineInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWPDCENGINEINST");
        if (!bl) {
            pSWPDCEngineInst.setCreateDate(null);
            pSWPDCEngineInst.setCreateMan(null);
            pSWPDCEngineInst.setPSWPDCEngineInstId(null);
            pSWPDCEngineInst.setUpdateDate(null);
            pSWPDCEngineInst.setUpdateMan(null);
            super.exportCurXmlModel(pSWPDCEngineInst, xmlNode, bl);
        }
    }
}

