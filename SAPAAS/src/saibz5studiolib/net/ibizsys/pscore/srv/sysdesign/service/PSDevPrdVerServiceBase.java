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
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdVerDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdVerDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrd;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVerBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdIssueService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdIssueServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSpecService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSpecServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSubVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSubVerServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqModuleServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdVerServiceBase
extends PSCoreSysServiceBase<PSDevPrdVer> {
    private static final Log log = LogFactory.getLog(PSDevPrdVerServiceBase.class);
    public static final String DATASET_CURPRD = "CurPrd";
    public static final String DATASET_CURPRDROOTVER = "CurPrdRootVer";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevPrdVerDEModel pSDevPrdVerDEModel;
    private PSDevPrdVerDAO pSDevPrdVerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdVerService";
    }

    public PSDevPrdVerDEModel getPSDevPrdVerDEModel() {
        if (this.pSDevPrdVerDEModel == null) {
            try {
                this.pSDevPrdVerDEModel = (PSDevPrdVerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdVerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevPrdVerDEModel();
    }

    public PSDevPrdVerDAO getPSDevPrdVerDAO() {
        if (this.pSDevPrdVerDAO == null) {
            try {
                this.pSDevPrdVerDAO = (PSDevPrdVerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdVerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdVerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevPrdVerDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURPRD, (boolean)true) == 0) {
            return this.fetchCurPrd(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURPRDROOTVER, (boolean)true) == 0) {
            return this.fetchCurPrdRootVer(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurPrd(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPRD, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurPrdRootVer(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPRDROOTVER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDevPrdVer pSDevPrdVer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDVER_PSDEVPRDVER_PPSDEVPRDVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdVerService", (SessionFactory)this.getSessionFactory());
            PSDevPrdVer pSDevPrdVer2 = (PSDevPrdVer)iService.getDEModel().createEntity();
            pSDevPrdVer2.set("PSDEVPRDVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevPrdVer2);
            } else {
                iService.get((IEntity)pSDevPrdVer2);
            }
            this.onFillParentInfo_PPSDevPrdVer(pSDevPrdVer, pSDevPrdVer2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDVER_PSDEVPRD_PSDEVPRDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdService", (SessionFactory)this.getSessionFactory());
            PSDevPrd pSDevPrd = (PSDevPrd)iService.getDEModel().createEntity();
            pSDevPrd.set("PSDEVPRDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevPrd);
            } else {
                iService.get((IEntity)pSDevPrd);
            }
            this.onFillParentInfo_PSDevPrd(pSDevPrdVer, pSDevPrd);
            return;
        }
        super.onFillParentInfo((IEntity)pSDevPrdVer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PPSDevPrdVer(PSDevPrdVer pSDevPrdVer, PSDevPrdVer pSDevPrdVer2) throws Exception {
        pSDevPrdVer.setPPSDevPrdVerId(pSDevPrdVer2.getPSDevPrdVerId());
        pSDevPrdVer.setPPSDevPrdVerName(pSDevPrdVer2.getPSDevPrdVerName());
        if (pSDevPrdVer2.getPSDevPrd() != null) {
            this.onFillParentInfo_PSDevPrd(pSDevPrdVer, pSDevPrdVer2.getPSDevPrd());
        }
    }

    protected void onFillParentInfo_PSDevPrd(PSDevPrdVer pSDevPrdVer, PSDevPrd pSDevPrd) throws Exception {
        pSDevPrdVer.setPSDevPrdId(pSDevPrd.getPSDevPrdId());
        pSDevPrdVer.setPSDevPrdName(pSDevPrd.getPSDevPrdName());
    }

    protected void onFillEntityFullInfo(PSDevPrdVer pSDevPrdVer, boolean bl) throws Exception {
        if (bl && pSDevPrdVer.getValidFlag() == null) {
            pSDevPrdVer.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSDevPrdVer, bl);
        this.onFillEntityFullInfo_PPSDevPrdVer(pSDevPrdVer, bl);
        this.onFillEntityFullInfo_PSDevPrd(pSDevPrdVer, bl);
    }

    protected void onFillEntityFullInfo_PPSDevPrdVer(PSDevPrdVer pSDevPrdVer, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevPrd(PSDevPrdVer pSDevPrdVer, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevPrdVer pSDevPrdVer, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDevPrdVer, bl);
    }

    public ArrayList<PSDevPrdVer> selectByPPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase) throws Exception {
        return this.selectByPPSDevPrdVer(pSDevPrdVerBase, "", -1);
    }

    public ArrayList<PSDevPrdVer> selectByPPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase, String string) throws Exception {
        return this.selectByPPSDevPrdVer(pSDevPrdVerBase, string, -1);
    }

    public ArrayList<PSDevPrdVer> selectByPPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDEVPRDVERID", (Object)pSDevPrdVerBase.getPSDevPrdVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSDevPrdVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSDevPrdVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevPrdVer> selectByPSDevPrd(PSDevPrdBase pSDevPrdBase) throws Exception {
        return this.selectByPSDevPrd(pSDevPrdBase, "", -1);
    }

    public ArrayList<PSDevPrdVer> selectByPSDevPrd(PSDevPrdBase pSDevPrdBase, String string) throws Exception {
        return this.selectByPSDevPrd(pSDevPrdBase, string, -1);
    }

    public ArrayList<PSDevPrdVer> selectByPSDevPrd(PSDevPrdBase pSDevPrdBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVPRDID", (Object)pSDevPrdBase.getPSDevPrdId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevPrdCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevPrdCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSDevPrdVer> arrayList = this.selectByPPSDevPrdVer(pSDevPrdVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRDVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevPrdVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVPRDVER_PSDEVPRDVER_PPSDEVPRDVERID", "", iDataEntityModel.getName(), "PSDEVPRDVER", iDataEntityModel.getDataInfo((IEntity)pSDevPrdVer), arrayList.get(0)));
        }
    }

    public void resetPPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSDevPrdVer> arrayList = this.selectByPPSDevPrdVer(pSDevPrdVer);
        for (PSDevPrdVer pSDevPrdVer2 : arrayList) {
            PSDevPrdVer pSDevPrdVer3 = (PSDevPrdVer)this.getDEModel().createEntity();
            pSDevPrdVer3.setPSDevPrdVerId(pSDevPrdVer2.getPSDevPrdVerId());
            pSDevPrdVer3.setPPSDevPrdVerId(null);
            this.update(pSDevPrdVer3);
        }
    }

    public void removeByPPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        final PSDevPrdVer pSDevPrdVer2 = pSDevPrdVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdVerServiceBase.this.onBeforeRemoveByPPSDevPrdVer(pSDevPrdVer2);
                PSDevPrdVerServiceBase.this.internalRemoveByPPSDevPrdVer(pSDevPrdVer2);
                PSDevPrdVerServiceBase.this.onAfterRemoveByPPSDevPrdVer(pSDevPrdVer2);
            }
        });
    }

    protected void onBeforeRemoveByPPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
    }

    protected void internalRemoveByPPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSDevPrdVer> arrayList = this.selectByPPSDevPrdVer(pSDevPrdVer);
        this.onBeforeRemoveByPPSDevPrdVer(pSDevPrdVer, arrayList);
        for (PSDevPrdVer pSDevPrdVer2 : arrayList) {
            this.remove((IEntity)pSDevPrdVer2);
        }
        this.onAfterRemoveByPPSDevPrdVer(pSDevPrdVer, arrayList);
    }

    protected void onAfterRemoveByPPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
    }

    protected void onBeforeRemoveByPPSDevPrdVer(PSDevPrdVer pSDevPrdVer, ArrayList<PSDevPrdVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSDevPrdVer(PSDevPrdVer pSDevPrdVer, ArrayList<PSDevPrdVer> arrayList) throws Exception {
    }

    public void testRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        ArrayList<PSDevPrdVer> arrayList = this.selectByPSDevPrd(pSDevPrd, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevPrd);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVPRDVER_PSDEVPRD_PSDEVPRDID", "", iDataEntityModel.getName(), "PSDEVPRDVER", iDataEntityModel.getDataInfo((IEntity)pSDevPrd), arrayList.get(0)));
        }
    }

    public void resetPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        ArrayList<PSDevPrdVer> arrayList = this.selectByPSDevPrd(pSDevPrd);
        for (PSDevPrdVer pSDevPrdVer : arrayList) {
            PSDevPrdVer pSDevPrdVer2 = (PSDevPrdVer)this.getDEModel().createEntity();
            pSDevPrdVer2.setPSDevPrdVerId(pSDevPrdVer.getPSDevPrdVerId());
            pSDevPrdVer2.setPSDevPrdId(null);
            this.update(pSDevPrdVer2);
        }
    }

    public void removeByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        final PSDevPrd pSDevPrd2 = pSDevPrd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdVerServiceBase.this.onBeforeRemoveByPSDevPrd(pSDevPrd2);
                PSDevPrdVerServiceBase.this.internalRemoveByPSDevPrd(pSDevPrd2);
                PSDevPrdVerServiceBase.this.onAfterRemoveByPSDevPrd(pSDevPrd2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
    }

    protected void internalRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        ArrayList<PSDevPrdVer> arrayList = this.selectByPSDevPrd(pSDevPrd);
        this.onBeforeRemoveByPSDevPrd(pSDevPrd, arrayList);
        for (PSDevPrdVer pSDevPrdVer : arrayList) {
            this.remove((IEntity)pSDevPrdVer);
        }
        this.onAfterRemoveByPSDevPrd(pSDevPrd, arrayList);
    }

    protected void onAfterRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrd(PSDevPrd pSDevPrd, ArrayList<PSDevPrdVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrd(PSDevPrd pSDevPrd, ArrayList<PSDevPrdVer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevPrdVer pSDevPrdVer) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDevPrdIssueService)ServiceGlobal.getService(PSDevPrdIssueService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevPrdIssueServiceBase)pSCoreSysServiceBase).testRemoveByPSDevPrdVer(pSDevPrdVer);
        pSCoreSysServiceBase = (PSDevPrdSpecService)ServiceGlobal.getService(PSDevPrdSpecService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevPrdSpecServiceBase)pSCoreSysServiceBase).testRemoveByPSDevPrdVer(pSDevPrdVer);
        pSCoreSysServiceBase = (PSDevPrdSubVerService)ServiceGlobal.getService(PSDevPrdSubVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevPrdSubVerServiceBase)pSCoreSysServiceBase).testRemoveByPSDevPrdVer(pSDevPrdVer);
        pSCoreSysServiceBase = (PSDevPrdSysService)ServiceGlobal.getService(PSDevPrdSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevPrdSysServiceBase)pSCoreSysServiceBase).testRemoveByPSDevPrdVer(pSDevPrdVer);
        pSCoreSysServiceBase = (PSDevPrdVerService)ServiceGlobal.getService(PSDevPrdVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevPrdVerServiceBase)pSCoreSysServiceBase).testRemoveByPPSDevPrdVer(pSDevPrdVer);
        pSCoreSysServiceBase = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysReqItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDevPrdVer(pSDevPrdVer);
        pSCoreSysServiceBase = (PSSysReqModuleService)ServiceGlobal.getService(PSSysReqModuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysReqModuleServiceBase)pSCoreSysServiceBase).testRemoveByPSDevPrdVer(pSDevPrdVer);
        super.onBeforeRemove(pSDevPrdVer);
    }

    protected void replaceParentInfo(PSDevPrdVer pSDevPrdVer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDevPrdVer, cloneSession);
        if (pSDevPrdVer.getPPSDevPrdVerId() != null && (iEntity = cloneSession.getEntity("PSDEVPRDVER", (Object)pSDevPrdVer.getPPSDevPrdVerId())) != null) {
            this.onFillParentInfo_PPSDevPrdVer(pSDevPrdVer, (PSDevPrdVer)iEntity);
        }
        if (pSDevPrdVer.getPSDevPrdId() != null && (iEntity = cloneSession.getEntity("PSDEVPRD", (Object)pSDevPrdVer.getPSDevPrdId())) != null) {
            this.onFillParentInfo_PSDevPrd(pSDevPrdVer, (PSDevPrd)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevPrdVer pSDevPrdVer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDevPrdVer, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevPrdVer pSDevPrdVer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CurIssueSN(bl, pSDevPrdVer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CurSpecSN(bl, pSDevPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDevPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDevPrdVerId(bl, pSDevPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdId(bl, pSDevPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdVerId(bl, pSDevPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdVerName(bl, pSDevPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StartIssueSN(bl, pSDevPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StartSpecSN(bl, pSDevPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDevPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDevPrdVer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CurIssueSN(boolean bl, PSDevPrdVer pSDevPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdVer.isCurIssueSNDirty() : !pSDevPrdVer.isCurIssueSNDirty()) {
            return null;
        }
        Integer n = pSDevPrdVer.getCurIssueSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CurIssueSN_Default((IEntity)pSDevPrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CURISSUESN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CurSpecSN(boolean bl, PSDevPrdVer pSDevPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdVer.isCurSpecSNDirty() : !pSDevPrdVer.isCurSpecSNDirty()) {
            return null;
        }
        Integer n = pSDevPrdVer.getCurSpecSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CurSpecSN_Default((IEntity)pSDevPrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CURSPECSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevPrdVer pSDevPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdVer.isMemoDirty() : !pSDevPrdVer.isMemoDirty()) {
            return null;
        }
        String string = pSDevPrdVer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDevPrdVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDevPrdVer pSDevPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdVer.isOrderValueDirty() : !pSDevPrdVer.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDevPrdVer.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDevPrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSDevPrdVerId(boolean bl, PSDevPrdVer pSDevPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdVer.isPPSDevPrdVerIdDirty() : !pSDevPrdVer.isPPSDevPrdVerIdDirty()) {
            return null;
        }
        String string = pSDevPrdVer.getPPSDevPrdVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDevPrdVerId_Default((IEntity)pSDevPrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDEVPRDVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdId(boolean bl, PSDevPrdVer pSDevPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdVer.isPSDevPrdIdDirty() && !bl2 : !pSDevPrdVer.isPSDevPrdIdDirty()) {
            return null;
        }
        String string = pSDevPrdVer.getPSDevPrdId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdId_Default((IEntity)pSDevPrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdVerId(boolean bl, PSDevPrdVer pSDevPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdVer.isPSDevPrdVerIdDirty() && !bl2 : !pSDevPrdVer.isPSDevPrdVerIdDirty()) {
            return null;
        }
        String string = pSDevPrdVer.getPSDevPrdVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdVerId_Default((IEntity)pSDevPrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdVerName(boolean bl, PSDevPrdVer pSDevPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdVer.isPSDevPrdVerNameDirty() && !bl2 : !pSDevPrdVer.isPSDevPrdVerNameDirty()) {
            return null;
        }
        String string = pSDevPrdVer.getPSDevPrdVerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdVerName_Default((IEntity)pSDevPrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StartIssueSN(boolean bl, PSDevPrdVer pSDevPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdVer.isStartIssueSNDirty() : !pSDevPrdVer.isStartIssueSNDirty()) {
            return null;
        }
        Integer n = pSDevPrdVer.getStartIssueSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StartIssueSN_Default((IEntity)pSDevPrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STARTISSUESN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StartSpecSN(boolean bl, PSDevPrdVer pSDevPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdVer.isStartSpecSNDirty() : !pSDevPrdVer.isStartSpecSNDirty()) {
            return null;
        }
        Integer n = pSDevPrdVer.getStartSpecSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StartSpecSN_Default((IEntity)pSDevPrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STARTSPECSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDevPrdVer pSDevPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdVer.isValidFlagDirty() && !bl2 : !pSDevPrdVer.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDevPrdVer.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDevPrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevPrdVer pSDevPrdVer, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDevPrdVer, bl);
    }

    protected void onSyncIndexEntities(PSDevPrdVer pSDevPrdVer, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDevPrdVer, bl);
    }

    public Object getDataContextValue(PSDevPrdVer pSDevPrdVer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDevPrdVer, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDevPrdVer pSDevPrdVer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDevPrdVer, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CURISSUESN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CurIssueSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CURSPECSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CurSpecSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEVPRDVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDevPrdVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEVPRDVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDevPrdVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STARTISSUESN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StartIssueSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STARTSPECSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StartSpecSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CurIssueSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CurSpecSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPSDevPrdVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEVPRDVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRecursionRule("PPSDEVPRDVERID", "PSDEVPRDVER", iEntity, bl2, "")) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDevPrdVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEVPRDVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StartIssueSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_StartSpecSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSDevPrdVer pSDevPrdVer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDevPrdVer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevPrdVer pSDevPrdVer) throws Exception {
        super.onUpdateParent((IEntity)pSDevPrdVer);
    }

    @Override
    protected void exportCurXmlModel(PSDevPrdVer pSDevPrdVer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVPRDVER");
        if (!bl) {
            pSDevPrdVer.setCreateDate(null);
            pSDevPrdVer.setCreateMan(null);
            pSDevPrdVer.setPSDevPrdVerId(null);
            pSDevPrdVer.setUpdateDate(null);
            pSDevPrdVer.setUpdateMan(null);
            super.exportCurXmlModel(pSDevPrdVer, xmlNode, bl);
        }
    }
}

