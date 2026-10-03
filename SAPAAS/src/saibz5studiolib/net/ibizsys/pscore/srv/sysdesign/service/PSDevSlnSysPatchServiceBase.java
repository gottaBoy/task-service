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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysPatchDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysPatchDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysPatch;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysVerBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysPatchServiceBase
extends PSCoreSysServiceBase<PSDevSlnSysPatch> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysPatchServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevSlnSysPatchDEModel pSDevSlnSysPatchDEModel;
    private PSDevSlnSysPatchDAO pSDevSlnSysPatchDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysPatchService";
    }

    public PSDevSlnSysPatchDEModel getPSDevSlnSysPatchDEModel() {
        if (this.pSDevSlnSysPatchDEModel == null) {
            try {
                this.pSDevSlnSysPatchDEModel = (PSDevSlnSysPatchDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysPatchDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysPatchDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnSysPatchDEModel();
    }

    public PSDevSlnSysPatchDAO getPSDevSlnSysPatchDAO() {
        if (this.pSDevSlnSysPatchDAO == null) {
            try {
                this.pSDevSlnSysPatchDAO = (PSDevSlnSysPatchDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysPatchDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysPatchDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnSysPatchDAO();
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

    protected void onFillParentInfo(PSDevSlnSysPatch pSDevSlnSysPatch, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSPATCH_PSDEVSLNSYSVER_FROMPSDEVSLNSYSVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysVer pSDevSlnSysVer = (PSDevSlnSysVer)iService.getDEModel().createEntity();
            pSDevSlnSysVer.set("PSDEVSLNSYSVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSysVer);
            } else {
                iService.get(pSDevSlnSysVer);
            }
            this.onFillParentInfo_FromPSDevSlnSysVer(pSDevSlnSysPatch, pSDevSlnSysVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSPATCH_PSDEVSLNSYSVER_PSDEVSLNSYSVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysVer pSDevSlnSysVer = (PSDevSlnSysVer)iService.getDEModel().createEntity();
            pSDevSlnSysVer.set("PSDEVSLNSYSVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSysVer);
            } else {
                iService.get(pSDevSlnSysVer);
            }
            this.onFillParentInfo_PSDevSlnSysVer(pSDevSlnSysPatch, pSDevSlnSysVer);
            return;
        }
        super.onFillParentInfo(pSDevSlnSysPatch, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_FromPSDevSlnSysVer(PSDevSlnSysPatch pSDevSlnSysPatch, PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        pSDevSlnSysPatch.setFromPSDevSlnSysVerId(pSDevSlnSysVer.getPSDevSlnSysVerId());
        pSDevSlnSysPatch.setFromPSDevSlnSysVerName(pSDevSlnSysVer.getPSDevSlnSysVerName());
    }

    protected void onFillParentInfo_PSDevSlnSysVer(PSDevSlnSysPatch pSDevSlnSysPatch, PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        pSDevSlnSysPatch.setPSDevSlnSysId(pSDevSlnSysVer.getPSDevSlnSysId());
        pSDevSlnSysPatch.setPSDevSlnSysVerId(pSDevSlnSysVer.getPSDevSlnSysVerId());
        pSDevSlnSysPatch.setPSDevSlnSysVerName(pSDevSlnSysVer.getPSDevSlnSysVerName());
    }

    protected void onFillEntityFullInfo(PSDevSlnSysPatch pSDevSlnSysPatch, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDevSlnSysPatch, bl);
        this.onFillEntityFullInfo_FromPSDevSlnSysVer(pSDevSlnSysPatch, bl);
        this.onFillEntityFullInfo_PSDevSlnSysVer(pSDevSlnSysPatch, bl);
    }

    protected void onFillEntityFullInfo_FromPSDevSlnSysVer(PSDevSlnSysPatch pSDevSlnSysPatch, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSysVer(PSDevSlnSysPatch pSDevSlnSysPatch, boolean bl) throws Exception {
        if (pSDevSlnSysPatch.isPSDevSlnSysVerIdDirty()) {
            if (pSDevSlnSysPatch.getPSDevSlnSysVerId() != null) {
                if (pSDevSlnSysPatch.getPSDevSlnSysId() == null || pSDevSlnSysPatch.getPSDevSlnSysVerId() == null) {
                    PSDevSlnSysVer pSDevSlnSysVer = pSDevSlnSysPatch.getPSDevSlnSysVer();
                    pSDevSlnSysPatch.setPSDevSlnSysId(pSDevSlnSysVer.getPSDevSlnSysId());
                    pSDevSlnSysPatch.setPSDevSlnSysVerName(pSDevSlnSysVer.getPSDevSlnSysVerName());
                }
            } else {
                pSDevSlnSysPatch.setPSDevSlnSysId(null);
                pSDevSlnSysPatch.setPSDevSlnSysVerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDevSlnSysPatch pSDevSlnSysPatch, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevSlnSysPatch, bl);
    }

    public ArrayList<PSDevSlnSysPatch> selectByFromPSDevSlnSysVer(PSDevSlnSysVerBase pSDevSlnSysVerBase) throws Exception {
        return this.selectByFromPSDevSlnSysVer(pSDevSlnSysVerBase, "", -1);
    }

    public ArrayList<PSDevSlnSysPatch> selectByFromPSDevSlnSysVer(PSDevSlnSysVerBase pSDevSlnSysVerBase, String string) throws Exception {
        return this.selectByFromPSDevSlnSysVer(pSDevSlnSysVerBase, string, -1);
    }

    public ArrayList<PSDevSlnSysPatch> selectByFromPSDevSlnSysVer(PSDevSlnSysVerBase pSDevSlnSysVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("FROMPSDEVSLNSYSVERID", (Object)pSDevSlnSysVerBase.getPSDevSlnSysVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByFromPSDevSlnSysVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByFromPSDevSlnSysVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysPatch> selectByPSDevSlnSysVer(PSDevSlnSysVerBase pSDevSlnSysVerBase) throws Exception {
        return this.selectByPSDevSlnSysVer(pSDevSlnSysVerBase, "", -1);
    }

    public ArrayList<PSDevSlnSysPatch> selectByPSDevSlnSysVer(PSDevSlnSysVerBase pSDevSlnSysVerBase, String string) throws Exception {
        return this.selectByPSDevSlnSysVer(pSDevSlnSysVerBase, string, -1);
    }

    public ArrayList<PSDevSlnSysPatch> selectByPSDevSlnSysVer(PSDevSlnSysVerBase pSDevSlnSysVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSVERID", (Object)pSDevSlnSysVerBase.getPSDevSlnSysVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysVerCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByFromPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        ArrayList<PSDevSlnSysPatch> arrayList = this.selectByFromPSDevSlnSysVer(pSDevSlnSysVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYSVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnSysVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSPATCH_PSDEVSLNSYSVER_FROMPSDEVSLNSYSVERID", "", iDataEntityModel.getName(), "PSDEVSLNSYSPATCH", iDataEntityModel.getDataInfo(pSDevSlnSysVer), arrayList.get(0)));
        }
    }

    public void resetFromPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        ArrayList<PSDevSlnSysPatch> arrayList = this.selectByFromPSDevSlnSysVer(pSDevSlnSysVer);
        for (PSDevSlnSysPatch pSDevSlnSysPatch : arrayList) {
            PSDevSlnSysPatch pSDevSlnSysPatch2 = (PSDevSlnSysPatch)this.getDEModel().createEntity();
            pSDevSlnSysPatch2.setPSDevSlnSysPatchId(pSDevSlnSysPatch.getPSDevSlnSysPatchId());
            pSDevSlnSysPatch2.setFromPSDevSlnSysVerId(null);
            this.update(pSDevSlnSysPatch2);
        }
    }

    public void removeByFromPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        final PSDevSlnSysVer pSDevSlnSysVer2 = pSDevSlnSysVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysPatchServiceBase.this.onBeforeRemoveByFromPSDevSlnSysVer(pSDevSlnSysVer2);
                PSDevSlnSysPatchServiceBase.this.internalRemoveByFromPSDevSlnSysVer(pSDevSlnSysVer2);
                PSDevSlnSysPatchServiceBase.this.onAfterRemoveByFromPSDevSlnSysVer(pSDevSlnSysVer2);
            }
        });
    }

    protected void onBeforeRemoveByFromPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
    }

    protected void internalRemoveByFromPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        ArrayList<PSDevSlnSysPatch> arrayList = this.selectByFromPSDevSlnSysVer(pSDevSlnSysVer);
        this.onBeforeRemoveByFromPSDevSlnSysVer(pSDevSlnSysVer, arrayList);
        for (PSDevSlnSysPatch pSDevSlnSysPatch : arrayList) {
            this.remove(pSDevSlnSysPatch);
        }
        this.onAfterRemoveByFromPSDevSlnSysVer(pSDevSlnSysVer, arrayList);
    }

    protected void onAfterRemoveByFromPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
    }

    protected void onBeforeRemoveByFromPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer, ArrayList<PSDevSlnSysPatch> arrayList) throws Exception {
    }

    protected void onAfterRemoveByFromPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer, ArrayList<PSDevSlnSysPatch> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        ArrayList<PSDevSlnSysPatch> arrayList = this.selectByPSDevSlnSysVer(pSDevSlnSysVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYSVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnSysVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSPATCH_PSDEVSLNSYSVER_PSDEVSLNSYSVERID", "", iDataEntityModel.getName(), "PSDEVSLNSYSPATCH", iDataEntityModel.getDataInfo(pSDevSlnSysVer), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        ArrayList<PSDevSlnSysPatch> arrayList = this.selectByPSDevSlnSysVer(pSDevSlnSysVer);
        for (PSDevSlnSysPatch pSDevSlnSysPatch : arrayList) {
            PSDevSlnSysPatch pSDevSlnSysPatch2 = (PSDevSlnSysPatch)this.getDEModel().createEntity();
            pSDevSlnSysPatch2.setPSDevSlnSysPatchId(pSDevSlnSysPatch.getPSDevSlnSysPatchId());
            pSDevSlnSysPatch2.setPSDevSlnSysVerId(null);
            this.update(pSDevSlnSysPatch2);
        }
    }

    public void removeByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        final PSDevSlnSysVer pSDevSlnSysVer2 = pSDevSlnSysVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysPatchServiceBase.this.onBeforeRemoveByPSDevSlnSysVer(pSDevSlnSysVer2);
                PSDevSlnSysPatchServiceBase.this.internalRemoveByPSDevSlnSysVer(pSDevSlnSysVer2);
                PSDevSlnSysPatchServiceBase.this.onAfterRemoveByPSDevSlnSysVer(pSDevSlnSysVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
        ArrayList<PSDevSlnSysPatch> arrayList = this.selectByPSDevSlnSysVer(pSDevSlnSysVer);
        this.onBeforeRemoveByPSDevSlnSysVer(pSDevSlnSysVer, arrayList);
        for (PSDevSlnSysPatch pSDevSlnSysPatch : arrayList) {
            this.remove(pSDevSlnSysPatch);
        }
        this.onAfterRemoveByPSDevSlnSysVer(pSDevSlnSysVer, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer, ArrayList<PSDevSlnSysPatch> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysVer(PSDevSlnSysVer pSDevSlnSysVer, ArrayList<PSDevSlnSysPatch> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnSysPatch pSDevSlnSysPatch) throws Exception {
        super.onBeforeRemove(pSDevSlnSysPatch);
    }

    protected void replaceParentInfo(PSDevSlnSysPatch pSDevSlnSysPatch, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevSlnSysPatch, cloneSession);
        if (pSDevSlnSysPatch.getFromPSDevSlnSysVerId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSVER", (Object)pSDevSlnSysPatch.getFromPSDevSlnSysVerId())) != null) {
            this.onFillParentInfo_FromPSDevSlnSysVer(pSDevSlnSysPatch, (PSDevSlnSysVer)iEntity);
        }
        if (pSDevSlnSysPatch.getPSDevSlnSysVerId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSVER", (Object)pSDevSlnSysPatch.getPSDevSlnSysVerId())) != null) {
            this.onFillParentInfo_PSDevSlnSysVer(pSDevSlnSysPatch, (PSDevSlnSysVer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnSysPatch pSDevSlnSysPatch, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevSlnSysPatch, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnSysPatch pSDevSlnSysPatch, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_FromPSDevSlnSysVerId(bl, pSDevSlnSysPatch, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnSysPatch, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevSlnSysPatch, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysPatchId(bl, pSDevSlnSysPatch, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysPatchName(bl, pSDevSlnSysPatch, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysVerId(bl, pSDevSlnSysPatch, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevSlnSysPatch, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_FromPSDevSlnSysVerId(boolean bl, PSDevSlnSysPatch pSDevSlnSysPatch, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysPatch.isFromPSDevSlnSysVerIdDirty() && !bl2 : !pSDevSlnSysPatch.isFromPSDevSlnSysVerIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysPatch.getFromPSDevSlnSysVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FROMPSDEVSLNSYSVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_FromPSDevSlnSysVerId_Default(pSDevSlnSysPatch, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FROMPSDEVSLNSYSVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnSysPatch pSDevSlnSysPatch, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysPatch.isMemoDirty() : !pSDevSlnSysPatch.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnSysPatch.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevSlnSysPatch, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevSlnSysPatch pSDevSlnSysPatch, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysPatch.isPSDevSlnSysIdDirty() : !pSDevSlnSysPatch.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysPatch.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default(pSDevSlnSysPatch, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysPatchId(boolean bl, PSDevSlnSysPatch pSDevSlnSysPatch, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysPatch.isPSDevSlnSysPatchIdDirty() && !bl2 : !pSDevSlnSysPatch.isPSDevSlnSysPatchIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysPatch.getPSDevSlnSysPatchId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSPATCHID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysPatchId_Default(pSDevSlnSysPatch, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSPATCHID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysPatchName(boolean bl, PSDevSlnSysPatch pSDevSlnSysPatch, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysPatch.isPSDevSlnSysPatchNameDirty() && !bl2 : !pSDevSlnSysPatch.isPSDevSlnSysPatchNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysPatch.getPSDevSlnSysPatchName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSPATCHNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysPatchName_Default(pSDevSlnSysPatch, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSPATCHNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysVerId(boolean bl, PSDevSlnSysPatch pSDevSlnSysPatch, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysPatch.isPSDevSlnSysVerIdDirty() && !bl2 : !pSDevSlnSysPatch.isPSDevSlnSysVerIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysPatch.getPSDevSlnSysVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysVerId_Default(pSDevSlnSysPatch, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevSlnSysPatch pSDevSlnSysPatch, boolean bl) throws Exception {
        super.onSyncEntity(pSDevSlnSysPatch, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnSysPatch pSDevSlnSysPatch, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevSlnSysPatch, bl);
    }

    public Object getDataContextValue(PSDevSlnSysPatch pSDevSlnSysPatch, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevSlnSysPatch, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnSysPatch pSDevSlnSysPatch, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevSlnSysPatch, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FROMPSDEVSLNSYSVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FromPSDevSlnSysVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FROMPSDEVSLNSYSVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FromPSDevSlnSysVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSPATCHID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysPatchId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSPATCHNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysPatchName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysVerName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_FromPSDevSlnSysVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FROMPSDEVSLNSYSVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FromPSDevSlnSysVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FROMPSDEVSLNSYSVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysPatchId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSPATCHID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysPatchName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSPATCHNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDevSlnSysPatch pSDevSlnSysPatch) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevSlnSysPatch)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnSysPatch pSDevSlnSysPatch) throws Exception {
        super.onUpdateParent(pSDevSlnSysPatch);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnSysPatch pSDevSlnSysPatch, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNSYSPATCH");
        if (!bl) {
            pSDevSlnSysPatch.setCreateDate(null);
            pSDevSlnSysPatch.setCreateMan(null);
            pSDevSlnSysPatch.setPSDevSlnSysPatchId(null);
            pSDevSlnSysPatch.setUpdateDate(null);
            pSDevSlnSysPatch.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnSysPatch, xmlNode, bl);
        }
    }
}

