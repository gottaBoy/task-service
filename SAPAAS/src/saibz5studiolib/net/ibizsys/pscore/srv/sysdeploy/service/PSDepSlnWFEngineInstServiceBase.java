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
package net.ibizsys.pscore.srv.sysdeploy.service;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWFEngineInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWFEngineInstBase;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnWFEngineInstDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnWFEngineInstDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnWFEngineInst;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysWFService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnWFEngineInstServiceBase
extends PSCoreSysServiceBase<PSDepSlnWFEngineInst> {
    private static final Log log = LogFactory.getLog(PSDepSlnWFEngineInstServiceBase.class);
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnWFEngineInstDEModel pSDepSlnWFEngineInstDEModel;
    private PSDepSlnWFEngineInstDAO pSDepSlnWFEngineInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnWFEngineInstService";
    }

    public PSDepSlnWFEngineInstDEModel getPSDepSlnWFEngineInstDEModel() {
        if (this.pSDepSlnWFEngineInstDEModel == null) {
            try {
                this.pSDepSlnWFEngineInstDEModel = (PSDepSlnWFEngineInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnWFEngineInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnWFEngineInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnWFEngineInstDEModel();
    }

    public PSDepSlnWFEngineInstDAO getPSDepSlnWFEngineInstDAO() {
        if (this.pSDepSlnWFEngineInstDAO == null) {
            try {
                this.pSDepSlnWFEngineInstDAO = (PSDepSlnWFEngineInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnWFEngineInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnWFEngineInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnWFEngineInstDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN, (boolean)true) == 0) {
            return this.fetchCurSln(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDepSlnWFEngineInst pSDepSlnWFEngineInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNWFENGINEINST_PSDCWFENGINEINST_PSDCWFENGINEINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCWFEngineInstService", (SessionFactory)this.getSessionFactory());
            PSDCWFEngineInst pSDCWFEngineInst = (PSDCWFEngineInst)iService.getDEModel().createEntity();
            pSDCWFEngineInst.set("PSDCWFENGINEINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCWFEngineInst);
            } else {
                iService.get((IEntity)pSDCWFEngineInst);
            }
            this.onFillParentInfo_PSDCWFEngineInst(pSDepSlnWFEngineInst, pSDCWFEngineInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNWFENGINEINST_PSDEPSLN_PSDEPSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService", (SessionFactory)this.getSessionFactory());
            PSDepSln pSDepSln = (PSDepSln)iService.getDEModel().createEntity();
            pSDepSln.set("PSDEPSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSln);
            } else {
                iService.get((IEntity)pSDepSln);
            }
            this.onFillParentInfo_PSDepSln(pSDepSlnWFEngineInst, pSDepSln);
            return;
        }
        super.onFillParentInfo((IEntity)pSDepSlnWFEngineInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCWFEngineInst(PSDepSlnWFEngineInst pSDepSlnWFEngineInst, PSDCWFEngineInst pSDCWFEngineInst) throws Exception {
        pSDepSlnWFEngineInst.setPSDCWFEngineInstId(pSDCWFEngineInst.getPSDCWFEngineInstId());
        pSDepSlnWFEngineInst.setPSDCWFEngineInstName(pSDCWFEngineInst.getPSDCWFEngineInstName());
    }

    protected void onFillParentInfo_PSDepSln(PSDepSlnWFEngineInst pSDepSlnWFEngineInst, PSDepSln pSDepSln) throws Exception {
        pSDepSlnWFEngineInst.setPSDepSlnId(pSDepSln.getPSDepSlnId());
        pSDepSlnWFEngineInst.setPSDepSlnName(pSDepSln.getPSDepSlnName());
    }

    protected void onFillEntityFullInfo(PSDepSlnWFEngineInst pSDepSlnWFEngineInst, boolean bl) throws Exception {
        if (bl && pSDepSlnWFEngineInst.getDefaultFlag() == null) {
            pSDepSlnWFEngineInst.setDefaultFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSDepSlnWFEngineInst, bl);
        this.onFillEntityFullInfo_PSDCWFEngineInst(pSDepSlnWFEngineInst, bl);
        this.onFillEntityFullInfo_PSDepSln(pSDepSlnWFEngineInst, bl);
    }

    protected void onFillEntityFullInfo_PSDCWFEngineInst(PSDepSlnWFEngineInst pSDepSlnWFEngineInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSln(PSDepSlnWFEngineInst pSDepSlnWFEngineInst, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSlnWFEngineInst pSDepSlnWFEngineInst, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDepSlnWFEngineInst, bl);
    }

    public ArrayList<PSDepSlnWFEngineInst> selectByPSDCWFEngineInst(PSDCWFEngineInstBase pSDCWFEngineInstBase) throws Exception {
        return this.selectByPSDCWFEngineInst(pSDCWFEngineInstBase, "", -1);
    }

    public ArrayList<PSDepSlnWFEngineInst> selectByPSDCWFEngineInst(PSDCWFEngineInstBase pSDCWFEngineInstBase, String string) throws Exception {
        return this.selectByPSDCWFEngineInst(pSDCWFEngineInstBase, string, -1);
    }

    public ArrayList<PSDepSlnWFEngineInst> selectByPSDCWFEngineInst(PSDCWFEngineInstBase pSDCWFEngineInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCWFENGINEINSTID", (Object)pSDCWFEngineInstBase.getPSDCWFEngineInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCWFEngineInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCWFEngineInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnWFEngineInst> selectByPSDepSln(PSDepSlnBase pSDepSlnBase) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, "", -1);
    }

    public ArrayList<PSDepSlnWFEngineInst> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, string, -1);
    }

    public ArrayList<PSDepSlnWFEngineInst> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNID", (Object)pSDepSlnBase.getPSDepSlnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCWFEngineInst(PSDCWFEngineInst pSDCWFEngineInst) throws Exception {
        ArrayList<PSDepSlnWFEngineInst> arrayList = this.selectByPSDCWFEngineInst(pSDCWFEngineInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCWFENGINEINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCWFEngineInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNWFENGINEINST_PSDCWFENGINEINST_PSDCWFENGINEINSTID", "", iDataEntityModel.getName(), "PSDEPSLNWFENGINEINST", iDataEntityModel.getDataInfo((IEntity)pSDCWFEngineInst), arrayList.get(0)));
        }
    }

    public void resetPSDCWFEngineInst(PSDCWFEngineInst pSDCWFEngineInst) throws Exception {
        ArrayList<PSDepSlnWFEngineInst> arrayList = this.selectByPSDCWFEngineInst(pSDCWFEngineInst);
        for (PSDepSlnWFEngineInst pSDepSlnWFEngineInst : arrayList) {
            PSDepSlnWFEngineInst pSDepSlnWFEngineInst2 = (PSDepSlnWFEngineInst)this.getDEModel().createEntity();
            pSDepSlnWFEngineInst2.setPSDepSlnWFEngineInstId(pSDepSlnWFEngineInst.getPSDepSlnWFEngineInstId());
            pSDepSlnWFEngineInst2.setPSDCWFEngineInstId(null);
            this.update(pSDepSlnWFEngineInst2);
        }
    }

    public void removeByPSDCWFEngineInst(PSDCWFEngineInst pSDCWFEngineInst) throws Exception {
        final PSDCWFEngineInst pSDCWFEngineInst2 = pSDCWFEngineInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnWFEngineInstServiceBase.this.onBeforeRemoveByPSDCWFEngineInst(pSDCWFEngineInst2);
                PSDepSlnWFEngineInstServiceBase.this.internalRemoveByPSDCWFEngineInst(pSDCWFEngineInst2);
                PSDepSlnWFEngineInstServiceBase.this.onAfterRemoveByPSDCWFEngineInst(pSDCWFEngineInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCWFEngineInst(PSDCWFEngineInst pSDCWFEngineInst) throws Exception {
    }

    protected void internalRemoveByPSDCWFEngineInst(PSDCWFEngineInst pSDCWFEngineInst) throws Exception {
        ArrayList<PSDepSlnWFEngineInst> arrayList = this.selectByPSDCWFEngineInst(pSDCWFEngineInst);
        this.onBeforeRemoveByPSDCWFEngineInst(pSDCWFEngineInst, arrayList);
        for (PSDepSlnWFEngineInst pSDepSlnWFEngineInst : arrayList) {
            this.remove((IEntity)pSDepSlnWFEngineInst);
        }
        this.onAfterRemoveByPSDCWFEngineInst(pSDCWFEngineInst, arrayList);
    }

    protected void onAfterRemoveByPSDCWFEngineInst(PSDCWFEngineInst pSDCWFEngineInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDCWFEngineInst(PSDCWFEngineInst pSDCWFEngineInst, ArrayList<PSDepSlnWFEngineInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCWFEngineInst(PSDCWFEngineInst pSDCWFEngineInst, ArrayList<PSDepSlnWFEngineInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    public void resetPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnWFEngineInst> arrayList = this.selectByPSDepSln(pSDepSln);
        for (PSDepSlnWFEngineInst pSDepSlnWFEngineInst : arrayList) {
            PSDepSlnWFEngineInst pSDepSlnWFEngineInst2 = (PSDepSlnWFEngineInst)this.getDEModel().createEntity();
            pSDepSlnWFEngineInst2.setPSDepSlnWFEngineInstId(pSDepSlnWFEngineInst.getPSDepSlnWFEngineInstId());
            pSDepSlnWFEngineInst2.setPSDepSlnId(null);
            this.update(pSDepSlnWFEngineInst2);
        }
    }

    public void removeByPSDepSln(PSDepSln pSDepSln) throws Exception {
        final PSDepSln pSDepSln2 = pSDepSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnWFEngineInstServiceBase.this.onBeforeRemoveByPSDepSln(pSDepSln2);
                PSDepSlnWFEngineInstServiceBase.this.internalRemoveByPSDepSln(pSDepSln2);
                PSDepSlnWFEngineInstServiceBase.this.onAfterRemoveByPSDepSln(pSDepSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void internalRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnWFEngineInst> arrayList = this.selectByPSDepSln(pSDepSln);
        this.onBeforeRemoveByPSDepSln(pSDepSln, arrayList);
        for (PSDepSlnWFEngineInst pSDepSlnWFEngineInst : arrayList) {
            this.remove((IEntity)pSDepSlnWFEngineInst);
        }
        this.onAfterRemoveByPSDepSln(pSDepSln, arrayList);
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnWFEngineInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnWFEngineInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnWFEngineInst pSDepSlnWFEngineInst) throws Exception {
        PSDepSlnSysWFService pSDepSlnSysWFService = (PSDepSlnSysWFService)ServiceGlobal.getService(PSDepSlnSysWFService.class, (SessionFactory)this.getSessionFactory());
        pSDepSlnSysWFService.testRemoveByPSDepSlnWFEngineInst(pSDepSlnWFEngineInst);
        super.onBeforeRemove(pSDepSlnWFEngineInst);
    }

    protected void replaceParentInfo(PSDepSlnWFEngineInst pSDepSlnWFEngineInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDepSlnWFEngineInst, cloneSession);
        if (pSDepSlnWFEngineInst.getPSDCWFEngineInstId() != null && (iEntity = cloneSession.getEntity("PSDCWFENGINEINST", (Object)pSDepSlnWFEngineInst.getPSDCWFEngineInstId())) != null) {
            this.onFillParentInfo_PSDCWFEngineInst(pSDepSlnWFEngineInst, (PSDCWFEngineInst)iEntity);
        }
        if (pSDepSlnWFEngineInst.getPSDepSlnId() != null && (iEntity = cloneSession.getEntity("PSDEPSLN", (Object)pSDepSlnWFEngineInst.getPSDepSlnId())) != null) {
            this.onFillParentInfo_PSDepSln(pSDepSlnWFEngineInst, (PSDepSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnWFEngineInst pSDepSlnWFEngineInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDepSlnWFEngineInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnWFEngineInst pSDepSlnWFEngineInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DefaultFlag(bl, pSDepSlnWFEngineInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDepSlnWFEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCWFEngineInstId(bl, pSDepSlnWFEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnId(bl, pSDepSlnWFEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnWFEngineInstId(bl, pSDepSlnWFEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnWFEngineInstName(bl, pSDepSlnWFEngineInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDepSlnWFEngineInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSDepSlnWFEngineInst pSDepSlnWFEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnWFEngineInst.isDefaultFlagDirty() && !bl2 : !pSDepSlnWFEngineInst.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSDepSlnWFEngineInst.getDefaultFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSDepSlnWFEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSlnWFEngineInst pSDepSlnWFEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnWFEngineInst.isMemoDirty() : !pSDepSlnWFEngineInst.isMemoDirty()) {
            return null;
        }
        String string = pSDepSlnWFEngineInst.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDepSlnWFEngineInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCWFEngineInstId(boolean bl, PSDepSlnWFEngineInst pSDepSlnWFEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnWFEngineInst.isPSDCWFEngineInstIdDirty() : !pSDepSlnWFEngineInst.isPSDCWFEngineInstIdDirty()) {
            return null;
        }
        String string = pSDepSlnWFEngineInst.getPSDCWFEngineInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCWFEngineInstId_Default((IEntity)pSDepSlnWFEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCWFENGINEINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnId(boolean bl, PSDepSlnWFEngineInst pSDepSlnWFEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnWFEngineInst.isPSDepSlnIdDirty() : !pSDepSlnWFEngineInst.isPSDepSlnIdDirty()) {
            return null;
        }
        String string = pSDepSlnWFEngineInst.getPSDepSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnId_Default((IEntity)pSDepSlnWFEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnWFEngineInstId(boolean bl, PSDepSlnWFEngineInst pSDepSlnWFEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnWFEngineInst.isPSDepSlnWFEngineInstIdDirty() && !bl2 : !pSDepSlnWFEngineInst.isPSDepSlnWFEngineInstIdDirty()) {
            return null;
        }
        String string = pSDepSlnWFEngineInst.getPSDepSlnWFEngineInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNWFENGINEINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnWFEngineInstId_Default((IEntity)pSDepSlnWFEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNWFENGINEINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnWFEngineInstName(boolean bl, PSDepSlnWFEngineInst pSDepSlnWFEngineInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnWFEngineInst.isPSDepSlnWFEngineInstNameDirty() && !bl2 : !pSDepSlnWFEngineInst.isPSDepSlnWFEngineInstNameDirty()) {
            return null;
        }
        String string = pSDepSlnWFEngineInst.getPSDepSlnWFEngineInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNWFENGINEINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnWFEngineInstName_Default((IEntity)pSDepSlnWFEngineInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNWFENGINEINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDepSlnWFEngineInst pSDepSlnWFEngineInst, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDepSlnWFEngineInst, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnWFEngineInst pSDepSlnWFEngineInst, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDepSlnWFEngineInst, bl);
    }

    public Object getDataContextValue(PSDepSlnWFEngineInst pSDepSlnWFEngineInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDepSlnWFEngineInst, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnWFEngineInst pSDepSlnWFEngineInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDepSlnWFEngineInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCWFENGINEINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCWFEngineInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCWFENGINEINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCWFEngineInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNWFENGINEINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnWFEngineInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNWFENGINEINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnWFEngineInstName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDCWFEngineInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCWFENGINEINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCWFEngineInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCWFENGINEINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnWFEngineInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNWFENGINEINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnWFEngineInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNWFENGINEINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDepSlnWFEngineInst pSDepSlnWFEngineInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDepSlnWFEngineInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnWFEngineInst pSDepSlnWFEngineInst) throws Exception {
        super.onUpdateParent((IEntity)pSDepSlnWFEngineInst);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnWFEngineInst pSDepSlnWFEngineInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNWFENGINEINST");
        if (!bl) {
            pSDepSlnWFEngineInst.setCreateDate(null);
            pSDepSlnWFEngineInst.setCreateMan(null);
            pSDepSlnWFEngineInst.setPSDCWFEngineInstName(null);
            pSDepSlnWFEngineInst.setPSDepSlnName(null);
            pSDepSlnWFEngineInst.setPSDepSlnWFEngineInstId(null);
            pSDepSlnWFEngineInst.setUpdateDate(null);
            pSDepSlnWFEngineInst.setUpdateMan(null);
            super.exportCurXmlModel(pSDepSlnWFEngineInst, xmlNode, bl);
        }
    }
}

