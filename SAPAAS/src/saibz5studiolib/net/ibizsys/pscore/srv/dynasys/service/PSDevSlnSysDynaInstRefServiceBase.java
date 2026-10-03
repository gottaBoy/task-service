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
import net.ibizsys.pscore.srv.dynasys.dao.PSDevSlnSysDynaInstRefDAO;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDevSlnSysDynaInstRefDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInstBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInstRef;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysDynaInstRefServiceBase
extends PSCoreSysServiceBase<PSDevSlnSysDynaInstRef> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysDynaInstRefServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevSlnSysDynaInstRefDEModel pSDevSlnSysDynaInstRefDEModel;
    private PSDevSlnSysDynaInstRefDAO pSDevSlnSysDynaInstRefDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstRefService";
    }

    public PSDevSlnSysDynaInstRefDEModel getPSDevSlnSysDynaInstRefDEModel() {
        if (this.pSDevSlnSysDynaInstRefDEModel == null) {
            try {
                this.pSDevSlnSysDynaInstRefDEModel = (PSDevSlnSysDynaInstRefDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDevSlnSysDynaInstRefDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysDynaInstRefDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnSysDynaInstRefDEModel();
    }

    public PSDevSlnSysDynaInstRefDAO getPSDevSlnSysDynaInstRefDAO() {
        if (this.pSDevSlnSysDynaInstRefDAO == null) {
            try {
                this.pSDevSlnSysDynaInstRefDAO = (PSDevSlnSysDynaInstRefDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dynasys.dao.PSDevSlnSysDynaInstRefDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysDynaInstRefDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnSysDynaInstRefDAO();
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

    protected void onFillParentInfo(PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSDYNAINSTREF_PSDEVSLNSYSDYNAINST_PSDEVSLNSYSDYNAINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysDynaInst pSDevSlnSysDynaInst = (PSDevSlnSysDynaInst)iService.getDEModel().createEntity();
            pSDevSlnSysDynaInst.set("PSDEVSLNSYSDYNAINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSysDynaInst);
            } else {
                iService.get(pSDevSlnSysDynaInst);
            }
            this.onFillParentInfo_PSDevSlnSysDynaInst(pSDevSlnSysDynaInstRef, pSDevSlnSysDynaInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSDYNAINSTREF_PSDEVSLNSYSDYNAINST_REFPSDEVSLNSYSDYNAINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysDynaInst pSDevSlnSysDynaInst = (PSDevSlnSysDynaInst)iService.getDEModel().createEntity();
            pSDevSlnSysDynaInst.set("PSDEVSLNSYSDYNAINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSysDynaInst);
            } else {
                iService.get(pSDevSlnSysDynaInst);
            }
            this.onFillParentInfo_RefPSDevSlnSysDynaInst(pSDevSlnSysDynaInstRef, pSDevSlnSysDynaInst);
            return;
        }
        super.onFillParentInfo(pSDevSlnSysDynaInstRef, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevSlnSysDynaInst(PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        pSDevSlnSysDynaInstRef.setPSDevSlnSysDepInstId(pSDevSlnSysDynaInst.getPSDevSlnSysDepInstId());
        pSDevSlnSysDynaInstRef.setPSDevSlnSysDynaInstId(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
        pSDevSlnSysDynaInstRef.setPSDevSlnSysDynaInstName(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstName());
    }

    protected void onFillParentInfo_RefPSDevSlnSysDynaInst(PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        pSDevSlnSysDynaInstRef.setRefPSDevSlnSysDynaInstId(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
        pSDevSlnSysDynaInstRef.setRefPSDevSlnSysDynaInstName(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstName());
    }

    protected void onFillEntityFullInfo(PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl) throws Exception {
        if (bl && pSDevSlnSysDynaInstRef.getValidFlag() == null) {
            pSDevSlnSysDynaInstRef.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDevSlnSysDynaInstRef, bl);
        this.onFillEntityFullInfo_PSDevSlnSysDynaInst(pSDevSlnSysDynaInstRef, bl);
        this.onFillEntityFullInfo_RefPSDevSlnSysDynaInst(pSDevSlnSysDynaInstRef, bl);
    }

    protected void onFillEntityFullInfo_PSDevSlnSysDynaInst(PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl) throws Exception {
        if (pSDevSlnSysDynaInstRef.isPSDevSlnSysDynaInstIdDirty()) {
            if (pSDevSlnSysDynaInstRef.getPSDevSlnSysDynaInstId() != null) {
                if (pSDevSlnSysDynaInstRef.getPSDevSlnSysDynaInstId() == null || pSDevSlnSysDynaInstRef.getPSDevSlnSysDynaInstName() == null) {
                    PSDevSlnSysDynaInst pSDevSlnSysDynaInst = pSDevSlnSysDynaInstRef.getPSDevSlnSysDynaInst();
                    pSDevSlnSysDynaInstRef.setPSDevSlnSysDepInstId(pSDevSlnSysDynaInst.getPSDevSlnSysDepInstId());
                    pSDevSlnSysDynaInstRef.setPSDevSlnSysDynaInstName(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstName());
                }
            } else {
                pSDevSlnSysDynaInstRef.setPSDevSlnSysDepInstId(null);
                pSDevSlnSysDynaInstRef.setPSDevSlnSysDynaInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RefPSDevSlnSysDynaInst(PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl) throws Exception {
        if (pSDevSlnSysDynaInstRef.isRefPSDevSlnSysDynaInstIdDirty()) {
            if (pSDevSlnSysDynaInstRef.getRefPSDevSlnSysDynaInstId() != null) {
                if (pSDevSlnSysDynaInstRef.getRefPSDevSlnSysDynaInstId() == null || pSDevSlnSysDynaInstRef.getRefPSDevSlnSysDynaInstName() == null) {
                    PSDevSlnSysDynaInst pSDevSlnSysDynaInst = pSDevSlnSysDynaInstRef.getRefPSDevSlnSysDynaInst();
                    pSDevSlnSysDynaInstRef.setRefPSDevSlnSysDynaInstName(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstName());
                }
            } else {
                pSDevSlnSysDynaInstRef.setRefPSDevSlnSysDynaInstName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevSlnSysDynaInstRef, bl);
    }

    public ArrayList<PSDevSlnSysDynaInstRef> selectByPSDevSlnSysDynaInst(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase) throws Exception {
        return this.selectByPSDevSlnSysDynaInst(pSDevSlnSysDynaInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSysDynaInstRef> selectByPSDevSlnSysDynaInst(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase, String string) throws Exception {
        return this.selectByPSDevSlnSysDynaInst(pSDevSlnSysDynaInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSysDynaInstRef> selectByPSDevSlnSysDynaInst(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnSysDynaInstRef> selectByRefPSDevSlnSysDynaInst(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase) throws Exception {
        return this.selectByRefPSDevSlnSysDynaInst(pSDevSlnSysDynaInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSysDynaInstRef> selectByRefPSDevSlnSysDynaInst(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase, String string) throws Exception {
        return this.selectByRefPSDevSlnSysDynaInst(pSDevSlnSysDynaInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSysDynaInstRef> selectByRefPSDevSlnSysDynaInst(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEVSLNSYSDYNAINSTID", (Object)pSDevSlnSysDynaInstBase.getPSDevSlnSysDynaInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDevSlnSysDynaInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDevSlnSysDynaInstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
    }

    public void resetPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        ArrayList<PSDevSlnSysDynaInstRef> arrayList = this.selectByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst);
        for (PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef : arrayList) {
            PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef2 = (PSDevSlnSysDynaInstRef)this.getDEModel().createEntity();
            pSDevSlnSysDynaInstRef2.setPSDevSlnSysDynaInstRefId(pSDevSlnSysDynaInstRef.getPSDevSlnSysDynaInstRefId());
            pSDevSlnSysDynaInstRef2.setPSDevSlnSysDynaInstId(null);
            this.update(pSDevSlnSysDynaInstRef2);
        }
    }

    public void removeByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        final PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 = pSDevSlnSysDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysDynaInstRefServiceBase.this.onBeforeRemoveByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst2);
                PSDevSlnSysDynaInstRefServiceBase.this.internalRemoveByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst2);
                PSDevSlnSysDynaInstRefServiceBase.this.onAfterRemoveByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        ArrayList<PSDevSlnSysDynaInstRef> arrayList = this.selectByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst);
        this.onBeforeRemoveByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst, arrayList);
        for (PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef : arrayList) {
            this.remove(pSDevSlnSysDynaInstRef);
        }
        this.onAfterRemoveByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, ArrayList<PSDevSlnSysDynaInstRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, ArrayList<PSDevSlnSysDynaInstRef> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        ArrayList<PSDevSlnSysDynaInstRef> arrayList = this.selectByRefPSDevSlnSysDynaInst(pSDevSlnSysDynaInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYSDYNAINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnSysDynaInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSDYNAINSTREF_PSDEVSLNSYSDYNAINST_REFPSDEVSLNSYSDYNAINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYSDYNAINSTREF", iDataEntityModel.getDataInfo(pSDevSlnSysDynaInst), arrayList.get(0)));
        }
    }

    public void resetRefPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        ArrayList<PSDevSlnSysDynaInstRef> arrayList = this.selectByRefPSDevSlnSysDynaInst(pSDevSlnSysDynaInst);
        for (PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef : arrayList) {
            PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef2 = (PSDevSlnSysDynaInstRef)this.getDEModel().createEntity();
            pSDevSlnSysDynaInstRef2.setPSDevSlnSysDynaInstRefId(pSDevSlnSysDynaInstRef.getPSDevSlnSysDynaInstRefId());
            pSDevSlnSysDynaInstRef2.setRefPSDevSlnSysDynaInstId(null);
            this.update(pSDevSlnSysDynaInstRef2);
        }
    }

    public void removeByRefPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        final PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 = pSDevSlnSysDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysDynaInstRefServiceBase.this.onBeforeRemoveByRefPSDevSlnSysDynaInst(pSDevSlnSysDynaInst2);
                PSDevSlnSysDynaInstRefServiceBase.this.internalRemoveByRefPSDevSlnSysDynaInst(pSDevSlnSysDynaInst2);
                PSDevSlnSysDynaInstRefServiceBase.this.onAfterRemoveByRefPSDevSlnSysDynaInst(pSDevSlnSysDynaInst2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
    }

    protected void internalRemoveByRefPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        ArrayList<PSDevSlnSysDynaInstRef> arrayList = this.selectByRefPSDevSlnSysDynaInst(pSDevSlnSysDynaInst);
        this.onBeforeRemoveByRefPSDevSlnSysDynaInst(pSDevSlnSysDynaInst, arrayList);
        for (PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef : arrayList) {
            this.remove(pSDevSlnSysDynaInstRef);
        }
        this.onAfterRemoveByRefPSDevSlnSysDynaInst(pSDevSlnSysDynaInst, arrayList);
    }

    protected void onAfterRemoveByRefPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, ArrayList<PSDevSlnSysDynaInstRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, ArrayList<PSDevSlnSysDynaInstRef> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef) throws Exception {
        super.onBeforeRemove(pSDevSlnSysDynaInstRef);
    }

    protected void replaceParentInfo(PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevSlnSysDynaInstRef, cloneSession);
        if (pSDevSlnSysDynaInstRef.getPSDevSlnSysDynaInstId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSDYNAINST", (Object)pSDevSlnSysDynaInstRef.getPSDevSlnSysDynaInstId())) != null) {
            this.onFillParentInfo_PSDevSlnSysDynaInst(pSDevSlnSysDynaInstRef, (PSDevSlnSysDynaInst)iEntity);
        }
        if (pSDevSlnSysDynaInstRef.getRefPSDevSlnSysDynaInstId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSDYNAINST", (Object)pSDevSlnSysDynaInstRef.getRefPSDevSlnSysDynaInstId())) != null) {
            this.onFillParentInfo_RefPSDevSlnSysDynaInst(pSDevSlnSysDynaInstRef, (PSDevSlnSysDynaInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevSlnSysDynaInstRef, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_InstModelPath(bl, pSDevSlnSysDynaInstRef, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnSysDynaInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDevSlnSysDynaInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysDynaInstId(bl, pSDevSlnSysDynaInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysDynaInstName(bl, pSDevSlnSysDynaInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysDynaInstRefId(bl, pSDevSlnSysDynaInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysDynaInstRefName(bl, pSDevSlnSysDynaInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDevSlnSysDynaInstId(bl, pSDevSlnSysDynaInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDevSlnSysDynaInstName(bl, pSDevSlnSysDynaInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefTag(bl, pSDevSlnSysDynaInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefTag2(bl, pSDevSlnSysDynaInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefTag3(bl, pSDevSlnSysDynaInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefTag4(bl, pSDevSlnSysDynaInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefTag5(bl, pSDevSlnSysDynaInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefTag6(bl, pSDevSlnSysDynaInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefTag7(bl, pSDevSlnSysDynaInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefTag8(bl, pSDevSlnSysDynaInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDevSlnSysDynaInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevSlnSysDynaInstRef, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_InstModelPath(boolean bl, PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstRef.isInstModelPathDirty() : !pSDevSlnSysDynaInstRef.isInstModelPathDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstRef.getInstModelPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InstModelPath_Default(pSDevSlnSysDynaInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTMODELPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstRef.isMemoDirty() : !pSDevSlnSysDynaInstRef.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstRef.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevSlnSysDynaInstRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstRef.isOrderValueDirty() && !bl2 : !pSDevSlnSysDynaInstRef.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysDynaInstRef.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDevSlnSysDynaInstRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysDynaInstId(boolean bl, PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstRef.isPSDevSlnSysDynaInstIdDirty() : !pSDevSlnSysDynaInstRef.isPSDevSlnSysDynaInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstRef.getPSDevSlnSysDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysDynaInstId_Default(pSDevSlnSysDynaInstRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysDynaInstName(boolean bl, PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstRef.isPSDevSlnSysDynaInstNameDirty() : !pSDevSlnSysDynaInstRef.isPSDevSlnSysDynaInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstRef.getPSDevSlnSysDynaInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysDynaInstName_Default(pSDevSlnSysDynaInstRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysDynaInstRefId(boolean bl, PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstRef.isPSDevSlnSysDynaInstRefIdDirty() && !bl2 : !pSDevSlnSysDynaInstRef.isPSDevSlnSysDynaInstRefIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstRef.getPSDevSlnSysDynaInstRefId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSDYNAINSTREFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysDynaInstRefId_Default(pSDevSlnSysDynaInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSDYNAINSTREFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysDynaInstRefName(boolean bl, PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstRef.isPSDevSlnSysDynaInstRefNameDirty() && !bl2 : !pSDevSlnSysDynaInstRef.isPSDevSlnSysDynaInstRefNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstRef.getPSDevSlnSysDynaInstRefName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSDYNAINSTREFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysDynaInstRefName_Default(pSDevSlnSysDynaInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSDYNAINSTREFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDevSlnSysDynaInstId(boolean bl, PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstRef.isRefPSDevSlnSysDynaInstIdDirty() : !pSDevSlnSysDynaInstRef.isRefPSDevSlnSysDynaInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstRef.getRefPSDevSlnSysDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDevSlnSysDynaInstId_Default(pSDevSlnSysDynaInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEVSLNSYSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDevSlnSysDynaInstName(boolean bl, PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstRef.isRefPSDevSlnSysDynaInstNameDirty() : !pSDevSlnSysDynaInstRef.isRefPSDevSlnSysDynaInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstRef.getRefPSDevSlnSysDynaInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDevSlnSysDynaInstName_Default(pSDevSlnSysDynaInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEVSLNSYSDYNAINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefTag(boolean bl, PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstRef.isRefTagDirty() : !pSDevSlnSysDynaInstRef.isRefTagDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstRef.getRefTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefTag_Default(pSDevSlnSysDynaInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefTag2(boolean bl, PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstRef.isRefTag2Dirty() : !pSDevSlnSysDynaInstRef.isRefTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstRef.getRefTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefTag2_Default(pSDevSlnSysDynaInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefTag3(boolean bl, PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstRef.isRefTag3Dirty() : !pSDevSlnSysDynaInstRef.isRefTag3Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstRef.getRefTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefTag3_Default(pSDevSlnSysDynaInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefTag4(boolean bl, PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstRef.isRefTag4Dirty() : !pSDevSlnSysDynaInstRef.isRefTag4Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstRef.getRefTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefTag4_Default(pSDevSlnSysDynaInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefTag5(boolean bl, PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstRef.isRefTag5Dirty() : !pSDevSlnSysDynaInstRef.isRefTag5Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstRef.getRefTag5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefTag5_Default(pSDevSlnSysDynaInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFTAG5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefTag6(boolean bl, PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstRef.isRefTag6Dirty() : !pSDevSlnSysDynaInstRef.isRefTag6Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstRef.getRefTag6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefTag6_Default(pSDevSlnSysDynaInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFTAG6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefTag7(boolean bl, PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstRef.isRefTag7Dirty() : !pSDevSlnSysDynaInstRef.isRefTag7Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstRef.getRefTag7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefTag7_Default(pSDevSlnSysDynaInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFTAG7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefTag8(boolean bl, PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstRef.isRefTag8Dirty() : !pSDevSlnSysDynaInstRef.isRefTag8Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInstRef.getRefTag8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefTag8_Default(pSDevSlnSysDynaInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFTAG8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInstRef.isValidFlagDirty() && !bl2 : !pSDevSlnSysDynaInstRef.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysDynaInstRef.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDevSlnSysDynaInstRef, bl2, bl3);
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

    protected void onSyncEntity(PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl) throws Exception {
        super.onSyncEntity(pSDevSlnSysDynaInstRef, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevSlnSysDynaInstRef, bl);
    }

    public Object getDataContextValue(PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevSlnSysDynaInstRef, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevSlnSysDynaInst pSDevSlnSysDynaInst = pSDevSlnSysDynaInstRef.getPSDevSlnSysDynaInst();
        if (pSDevSlnSysDynaInst != null && pSDevSlnSysDynaInst.contains(string)) {
            return pSDevSlnSysDynaInst.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevSlnSysDynaInstRef, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTMODELPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstModelPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSDEPINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysDepInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSDYNAINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysDynaInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSDYNAINSTREFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysDynaInstRefId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSDYNAINSTREFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysDynaInstRefName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEVSLNSYSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDevSlnSysDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEVSLNSYSDYNAINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDevSlnSysDynaInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFTAG5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefTag5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFTAG6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefTag6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFTAG7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefTag7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFTAG8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefTag8_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_InstModelPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INSTMODELPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDevSlnSysDepInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSDEPINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSDevSlnSysDynaInstRefId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSDYNAINSTREFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysDynaInstRefName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSDYNAINSTREFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDevSlnSysDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEVSLNSYSDYNAINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDevSlnSysDynaInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEVSLNSYSDYNAINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFTAG3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFTAG4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefTag5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFTAG5", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefTag6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFTAG6", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefTag7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFTAG7", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefTag8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFTAG8", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevSlnSysDynaInstRef)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef) throws Exception {
        super.onUpdateParent(pSDevSlnSysDynaInstRef);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNSYSDYNAINSTREF");
        if (!bl) {
            pSDevSlnSysDynaInstRef.setCreateDate(null);
            pSDevSlnSysDynaInstRef.setCreateMan(null);
            pSDevSlnSysDynaInstRef.setPSDevSlnSysDynaInstRefId(null);
            pSDevSlnSysDynaInstRef.setUpdateDate(null);
            pSDevSlnSysDynaInstRef.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnSysDynaInstRef, xmlNode, bl);
        }
    }
}

