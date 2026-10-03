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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCMSPlatformFuncDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCMSPlatformFuncDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatform;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformFunc;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMSPlatformFunc;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMSPlatformFuncBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCMSPlatformFuncServiceBase
extends PSCoreSysServiceBase<PSDCMSPlatformFunc> {
    private static final Log log = LogFactory.getLog(PSDCMSPlatformFuncServiceBase.class);
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_FORMTYPE = "FormType";
    private PSDCMSPlatformFuncDEModel pSDCMSPlatformFuncDEModel;
    private PSDCMSPlatformFuncDAO pSDCMSPlatformFuncDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformFuncService";
    }

    public PSDCMSPlatformFuncDEModel getPSDCMSPlatformFuncDEModel() {
        if (this.pSDCMSPlatformFuncDEModel == null) {
            try {
                this.pSDCMSPlatformFuncDEModel = (PSDCMSPlatformFuncDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCMSPlatformFuncDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMSPlatformFuncDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCMSPlatformFuncDEModel();
    }

    public PSDCMSPlatformFuncDAO getPSDCMSPlatformFuncDAO() {
        if (this.pSDCMSPlatformFuncDAO == null) {
            try {
                this.pSDCMSPlatformFuncDAO = (PSDCMSPlatformFuncDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCMSPlatformFuncDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMSPlatformFuncDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCMSPlatformFuncDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN, (boolean)true) == 0) {
            return this.fetchCurSln(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMTYPE, (boolean)true) == 0) {
            return this.fetchFormType(iDEDataSetFetchContext);
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

    public DBFetchResult fetchFormType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FORMTYPE, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDCMSPlatformFunc pSDCMSPlatformFunc, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCMSPLATFORMFUNC_PSDCMSPLATFORM_PSDCMSPLATFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformService", (SessionFactory)this.getSessionFactory());
            PSDCMSPlatform pSDCMSPlatform = (PSDCMSPlatform)iService.getDEModel().createEntity();
            pSDCMSPlatform.set("PSDCMSPLATFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCMSPlatform);
            } else {
                iService.get(pSDCMSPlatform);
            }
            this.onFillParentInfo_PSDCMSPlatform(pSDCMSPlatformFunc, pSDCMSPlatform);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCMSPLATFORMFUNC_PSMSPLATFORMFUNC_PSMSPLATFORMFUNCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformFuncService", (SessionFactory)this.getSessionFactory());
            PSMSPlatformFunc pSMSPlatformFunc = (PSMSPlatformFunc)iService.getDEModel().createEntity();
            pSMSPlatformFunc.set("PSMSPLATFORMFUNCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSMSPlatformFunc);
            } else {
                iService.get(pSMSPlatformFunc);
            }
            this.onFillParentInfo_PSMSPlatformFunc(pSDCMSPlatformFunc, pSMSPlatformFunc);
            return;
        }
        super.onFillParentInfo(pSDCMSPlatformFunc, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCMSPlatform(PSDCMSPlatformFunc pSDCMSPlatformFunc, PSDCMSPlatform pSDCMSPlatform) throws Exception {
        pSDCMSPlatformFunc.setPSDCMSPlatformId(pSDCMSPlatform.getPSDCMSPlatformId());
        pSDCMSPlatformFunc.setPSDCMSPlatformName(pSDCMSPlatform.getPSDCMSPlatformName());
        pSDCMSPlatformFunc.setPSDevSlnId(pSDCMSPlatform.getPSDevSlnId());
        pSDCMSPlatformFunc.setPSDevSlnName(pSDCMSPlatform.getPSDevSlnName());
    }

    protected void onFillParentInfo_PSMSPlatformFunc(PSDCMSPlatformFunc pSDCMSPlatformFunc, PSMSPlatformFunc pSMSPlatformFunc) throws Exception {
        pSDCMSPlatformFunc.setPSMSPlatformFuncId(pSMSPlatformFunc.getPSMSPlatformFuncId());
        pSDCMSPlatformFunc.setPSMSPlatformFuncName(pSMSPlatformFunc.getPSMSPlatformFuncName());
    }

    protected void onFillEntityFullInfo(PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl) throws Exception {
        if (bl && pSDCMSPlatformFunc.getValidFlag() == null) {
            pSDCMSPlatformFunc.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDCMSPlatformFunc, bl);
        this.onFillEntityFullInfo_PSDCMSPlatform(pSDCMSPlatformFunc, bl);
        this.onFillEntityFullInfo_PSMSPlatformFunc(pSDCMSPlatformFunc, bl);
    }

    protected void onFillEntityFullInfo_PSDCMSPlatform(PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl) throws Exception {
        if (pSDCMSPlatformFunc.isPSDCMSPlatformIdDirty()) {
            if (pSDCMSPlatformFunc.getPSDCMSPlatformId() != null) {
                if (pSDCMSPlatformFunc.getPSDCMSPlatformId() == null || pSDCMSPlatformFunc.getPSDCMSPlatformName() == null) {
                    PSDCMSPlatform pSDCMSPlatform = pSDCMSPlatformFunc.getPSDCMSPlatform();
                    pSDCMSPlatformFunc.setPSDCMSPlatformName(pSDCMSPlatform.getPSDCMSPlatformName());
                    pSDCMSPlatformFunc.setPSDevSlnId(pSDCMSPlatform.getPSDevSlnId());
                    pSDCMSPlatformFunc.setPSDevSlnName(pSDCMSPlatform.getPSDevSlnName());
                }
            } else {
                pSDCMSPlatformFunc.setPSDCMSPlatformName(null);
                pSDCMSPlatformFunc.setPSDevSlnId(null);
                pSDCMSPlatformFunc.setPSDevSlnName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSMSPlatformFunc(PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl) throws Exception {
        if (pSDCMSPlatformFunc.isPSMSPlatformFuncIdDirty()) {
            if (pSDCMSPlatformFunc.getPSMSPlatformFuncId() != null) {
                if (pSDCMSPlatformFunc.getPSMSPlatformFuncId() == null || pSDCMSPlatformFunc.getPSMSPlatformFuncName() == null) {
                    PSMSPlatformFunc pSMSPlatformFunc = pSDCMSPlatformFunc.getPSMSPlatformFunc();
                    pSDCMSPlatformFunc.setPSMSPlatformFuncName(pSMSPlatformFunc.getPSMSPlatformFuncName());
                }
            } else {
                pSDCMSPlatformFunc.setPSMSPlatformFuncName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCMSPlatformFunc, bl);
    }

    public ArrayList<PSDCMSPlatformFunc> selectByPSDCMSPlatform(PSDCMSPlatformBase pSDCMSPlatformBase) throws Exception {
        return this.selectByPSDCMSPlatform(pSDCMSPlatformBase, "", -1);
    }

    public ArrayList<PSDCMSPlatformFunc> selectByPSDCMSPlatform(PSDCMSPlatformBase pSDCMSPlatformBase, String string) throws Exception {
        return this.selectByPSDCMSPlatform(pSDCMSPlatformBase, string, -1);
    }

    public ArrayList<PSDCMSPlatformFunc> selectByPSDCMSPlatform(PSDCMSPlatformBase pSDCMSPlatformBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCMSPLATFORMID", (Object)pSDCMSPlatformBase.getPSDCMSPlatformId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCMSPlatformCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCMSPlatformCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCMSPlatformFunc> selectByPSMSPlatformFunc(PSMSPlatformFuncBase pSMSPlatformFuncBase) throws Exception {
        return this.selectByPSMSPlatformFunc(pSMSPlatformFuncBase, "", -1);
    }

    public ArrayList<PSDCMSPlatformFunc> selectByPSMSPlatformFunc(PSMSPlatformFuncBase pSMSPlatformFuncBase, String string) throws Exception {
        return this.selectByPSMSPlatformFunc(pSMSPlatformFuncBase, string, -1);
    }

    public ArrayList<PSDCMSPlatformFunc> selectByPSMSPlatformFunc(PSMSPlatformFuncBase pSMSPlatformFuncBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMSPLATFORMFUNCID", (Object)pSMSPlatformFuncBase.getPSMSPlatformFuncId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSMSPlatformFuncCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSMSPlatformFuncCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
    }

    public void resetPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        ArrayList<PSDCMSPlatformFunc> arrayList = this.selectByPSDCMSPlatform(pSDCMSPlatform);
        for (PSDCMSPlatformFunc pSDCMSPlatformFunc : arrayList) {
            PSDCMSPlatformFunc pSDCMSPlatformFunc2 = (PSDCMSPlatformFunc)this.getDEModel().createEntity();
            pSDCMSPlatformFunc2.setPSDCMSPlatformFuncId(pSDCMSPlatformFunc.getPSDCMSPlatformFuncId());
            pSDCMSPlatformFunc2.setPSDCMSPlatformId(null);
            this.update(pSDCMSPlatformFunc2);
        }
    }

    public void removeByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        final PSDCMSPlatform pSDCMSPlatform2 = pSDCMSPlatform;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCMSPlatformFuncServiceBase.this.onBeforeRemoveByPSDCMSPlatform(pSDCMSPlatform2);
                PSDCMSPlatformFuncServiceBase.this.internalRemoveByPSDCMSPlatform(pSDCMSPlatform2);
                PSDCMSPlatformFuncServiceBase.this.onAfterRemoveByPSDCMSPlatform(pSDCMSPlatform2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
    }

    protected void internalRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
        ArrayList<PSDCMSPlatformFunc> arrayList = this.selectByPSDCMSPlatform(pSDCMSPlatform);
        this.onBeforeRemoveByPSDCMSPlatform(pSDCMSPlatform, arrayList);
        for (PSDCMSPlatformFunc pSDCMSPlatformFunc : arrayList) {
            this.remove(pSDCMSPlatformFunc);
        }
        this.onAfterRemoveByPSDCMSPlatform(pSDCMSPlatform, arrayList);
    }

    protected void onAfterRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform) throws Exception {
    }

    protected void onBeforeRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform, ArrayList<PSDCMSPlatformFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCMSPlatform(PSDCMSPlatform pSDCMSPlatform, ArrayList<PSDCMSPlatformFunc> arrayList) throws Exception {
    }

    public void testRemoveByPSMSPlatformFunc(PSMSPlatformFunc pSMSPlatformFunc) throws Exception {
    }

    public void resetPSMSPlatformFunc(PSMSPlatformFunc pSMSPlatformFunc) throws Exception {
        ArrayList<PSDCMSPlatformFunc> arrayList = this.selectByPSMSPlatformFunc(pSMSPlatformFunc);
        for (PSDCMSPlatformFunc pSDCMSPlatformFunc : arrayList) {
            PSDCMSPlatformFunc pSDCMSPlatformFunc2 = (PSDCMSPlatformFunc)this.getDEModel().createEntity();
            pSDCMSPlatformFunc2.setPSDCMSPlatformFuncId(pSDCMSPlatformFunc.getPSDCMSPlatformFuncId());
            pSDCMSPlatformFunc2.setPSMSPlatformFuncId(null);
            this.update(pSDCMSPlatformFunc2);
        }
    }

    public void removeByPSMSPlatformFunc(PSMSPlatformFunc pSMSPlatformFunc) throws Exception {
        final PSMSPlatformFunc pSMSPlatformFunc2 = pSMSPlatformFunc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCMSPlatformFuncServiceBase.this.onBeforeRemoveByPSMSPlatformFunc(pSMSPlatformFunc2);
                PSDCMSPlatformFuncServiceBase.this.internalRemoveByPSMSPlatformFunc(pSMSPlatformFunc2);
                PSDCMSPlatformFuncServiceBase.this.onAfterRemoveByPSMSPlatformFunc(pSMSPlatformFunc2);
            }
        });
    }

    protected void onBeforeRemoveByPSMSPlatformFunc(PSMSPlatformFunc pSMSPlatformFunc) throws Exception {
    }

    protected void internalRemoveByPSMSPlatformFunc(PSMSPlatformFunc pSMSPlatformFunc) throws Exception {
        ArrayList<PSDCMSPlatformFunc> arrayList = this.selectByPSMSPlatformFunc(pSMSPlatformFunc);
        this.onBeforeRemoveByPSMSPlatformFunc(pSMSPlatformFunc, arrayList);
        for (PSDCMSPlatformFunc pSDCMSPlatformFunc : arrayList) {
            this.remove(pSDCMSPlatformFunc);
        }
        this.onAfterRemoveByPSMSPlatformFunc(pSMSPlatformFunc, arrayList);
    }

    protected void onAfterRemoveByPSMSPlatformFunc(PSMSPlatformFunc pSMSPlatformFunc) throws Exception {
    }

    protected void onBeforeRemoveByPSMSPlatformFunc(PSMSPlatformFunc pSMSPlatformFunc, ArrayList<PSDCMSPlatformFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSMSPlatformFunc(PSMSPlatformFunc pSMSPlatformFunc, ArrayList<PSDCMSPlatformFunc> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCMSPlatformFunc pSDCMSPlatformFunc) throws Exception {
        PSDevSlnPipelineStepService pSDevSlnPipelineStepService = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        pSDevSlnPipelineStepService.testRemoveByPSDCMSPlatformFunc(pSDCMSPlatformFunc);
        super.onBeforeRemove(pSDCMSPlatformFunc);
    }

    protected void replaceParentInfo(PSDCMSPlatformFunc pSDCMSPlatformFunc, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCMSPlatformFunc, cloneSession);
        if (pSDCMSPlatformFunc.getPSDCMSPlatformId() != null && (iEntity = cloneSession.getEntity("PSDCMSPLATFORM", (Object)pSDCMSPlatformFunc.getPSDCMSPlatformId())) != null) {
            this.onFillParentInfo_PSDCMSPlatform(pSDCMSPlatformFunc, (PSDCMSPlatform)iEntity);
        }
        if (pSDCMSPlatformFunc.getPSMSPlatformFuncId() != null && (iEntity = cloneSession.getEntity("PSMSPLATFORMFUNC", (Object)pSDCMSPlatformFunc.getPSMSPlatformFuncId())) != null) {
            this.onFillParentInfo_PSMSPlatformFunc(pSDCMSPlatformFunc, (PSMSPlatformFunc)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCMSPlatformFunc, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_FuncParam(bl, pSDCMSPlatformFunc, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncParam10(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncParam2(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncParam3(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncParam4(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncParam5(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncParam6(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncParam7(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncParam8(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncParam9(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncParams(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr2(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxCPU(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxMem(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinCPU(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinMem(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MSFuncType(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Passwd(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Port(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMSPlatformFuncId(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMSPlatformFuncName(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMSPlatformId(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMSPlatformName(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMSPlatformFuncId(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMSPlatformFuncName(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceUrl(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SSHIPAddr(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SSHPort(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UploadFileMode(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UploadPath(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserName(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WorkshopPath(bl, pSDCMSPlatformFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCMSPlatformFunc, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_FuncParam(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isFuncParamDirty() : !pSDCMSPlatformFunc.isFuncParamDirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getFuncParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncParam_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FuncParam10(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isFuncParam10Dirty() : !pSDCMSPlatformFunc.isFuncParam10Dirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getFuncParam10();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncParam10_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCPARAM10");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FuncParam2(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isFuncParam2Dirty() : !pSDCMSPlatformFunc.isFuncParam2Dirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getFuncParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncParam2_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FuncParam3(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isFuncParam3Dirty() : !pSDCMSPlatformFunc.isFuncParam3Dirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getFuncParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncParam3_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FuncParam4(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isFuncParam4Dirty() : !pSDCMSPlatformFunc.isFuncParam4Dirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getFuncParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncParam4_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FuncParam5(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isFuncParam5Dirty() : !pSDCMSPlatformFunc.isFuncParam5Dirty()) {
            return null;
        }
        Integer n = pSDCMSPlatformFunc.getFuncParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FuncParam5_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCPARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FuncParam6(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isFuncParam6Dirty() : !pSDCMSPlatformFunc.isFuncParam6Dirty()) {
            return null;
        }
        Integer n = pSDCMSPlatformFunc.getFuncParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FuncParam6_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCPARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FuncParam7(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isFuncParam7Dirty() : !pSDCMSPlatformFunc.isFuncParam7Dirty()) {
            return null;
        }
        Integer n = pSDCMSPlatformFunc.getFuncParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FuncParam7_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCPARAM7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FuncParam8(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isFuncParam8Dirty() : !pSDCMSPlatformFunc.isFuncParam8Dirty()) {
            return null;
        }
        Integer n = pSDCMSPlatformFunc.getFuncParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FuncParam8_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCPARAM8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FuncParam9(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isFuncParam9Dirty() : !pSDCMSPlatformFunc.isFuncParam9Dirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getFuncParam9();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncParam9_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCPARAM9");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FuncParams(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isFuncParamsDirty() : !pSDCMSPlatformFunc.isFuncParamsDirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getFuncParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncParams_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IpAddr(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isIpAddrDirty() : !pSDCMSPlatformFunc.isIpAddrDirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getIpAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IPADDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IpAddr2(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isIpAddr2Dirty() : !pSDCMSPlatformFunc.isIpAddr2Dirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getIpAddr2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr2_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IPADDR2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxCPU(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isMaxCPUDirty() : !pSDCMSPlatformFunc.isMaxCPUDirty()) {
            return null;
        }
        Double d = pSDCMSPlatformFunc.getMaxCPU();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxCPU_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXCPU");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxMem(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isMaxMemDirty() : !pSDCMSPlatformFunc.isMaxMemDirty()) {
            return null;
        }
        Double d = pSDCMSPlatformFunc.getMaxMem();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxMem_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXMEN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isMemoDirty() : !pSDCMSPlatformFunc.isMemoDirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCMSPlatformFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinCPU(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isMinCPUDirty() : !pSDCMSPlatformFunc.isMinCPUDirty()) {
            return null;
        }
        Double d = pSDCMSPlatformFunc.getMinCPU();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MinCPU_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINCPU");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinMem(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isMinMemDirty() : !pSDCMSPlatformFunc.isMinMemDirty()) {
            return null;
        }
        Double d = pSDCMSPlatformFunc.getMinMem();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MinMem_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINMEN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MSFuncType(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isMSFuncTypeDirty() && !bl2 : !pSDCMSPlatformFunc.isMSFuncTypeDirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getMSFuncType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSFUNCTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MSFuncType_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSFUNCTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Passwd(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isPasswdDirty() : !pSDCMSPlatformFunc.isPasswdDirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Passwd_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Port(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isPortDirty() : !pSDCMSPlatformFunc.isPortDirty()) {
            return null;
        }
        Integer n = pSDCMSPlatformFunc.getPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Port_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMSPlatformFuncId(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isPSDCMSPlatformFuncIdDirty() && !bl2 : !pSDCMSPlatformFunc.isPSDCMSPlatformFuncIdDirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getPSDCMSPlatformFuncId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMFUNCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMSPlatformFuncId_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMFUNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMSPlatformFuncName(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isPSDCMSPlatformFuncNameDirty() && !bl2 : !pSDCMSPlatformFunc.isPSDCMSPlatformFuncNameDirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getPSDCMSPlatformFuncName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMFUNCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMSPlatformFuncName_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMFUNCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSDCMSPLATFORMID";
                String string4 = this.checkFieldDupRule(this.getPSDCMSPlatformFuncDEModel(), "PSDCMSPLATFORMFUNCNAME", string3, pSDCMSPlatformFunc, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDCMSPLATFORMFUNCNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMSPlatformId(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isPSDCMSPlatformIdDirty() && !bl2 : !pSDCMSPlatformFunc.isPSDCMSPlatformIdDirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getPSDCMSPlatformId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMSPlatformId_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMSPlatformName(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isPSDCMSPlatformNameDirty() : !pSDCMSPlatformFunc.isPSDCMSPlatformNameDirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getPSDCMSPlatformName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMSPlatformName_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMSPLATFORMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMSPlatformFuncId(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isPSMSPlatformFuncIdDirty() : !pSDCMSPlatformFunc.isPSMSPlatformFuncIdDirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getPSMSPlatformFuncId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMSPlatformFuncId_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMSPLATFORMFUNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMSPlatformFuncName(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isPSMSPlatformFuncNameDirty() : !pSDCMSPlatformFunc.isPSMSPlatformFuncNameDirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getPSMSPlatformFuncName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMSPlatformFuncName_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMSPLATFORMFUNCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServiceUrl(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isServiceUrlDirty() : !pSDCMSPlatformFunc.isServiceUrlDirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getServiceUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceUrl_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SSHIPAddr(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isSSHIPAddrDirty() : !pSDCMSPlatformFunc.isSSHIPAddrDirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getSSHIPAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SSHIPAddr_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SSHIPADDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SSHPort(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isSSHPortDirty() : !pSDCMSPlatformFunc.isSSHPortDirty()) {
            return null;
        }
        Integer n = pSDCMSPlatformFunc.getSSHPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SSHPort_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SSHPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UploadFileMode(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isUploadFileModeDirty() : !pSDCMSPlatformFunc.isUploadFileModeDirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getUploadFileMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UploadFileMode_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPLOADFILEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UploadPath(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isUploadPathDirty() : !pSDCMSPlatformFunc.isUploadPathDirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getUploadPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UploadPath_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPLOADPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserName(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isUserNameDirty() : !pSDCMSPlatformFunc.isUserNameDirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserName_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isValidFlagDirty() && !bl2 : !pSDCMSPlatformFunc.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDCMSPlatformFunc.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDCMSPlatformFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_WorkshopPath(boolean bl, PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMSPlatformFunc.isWorkshopPathDirty() : !pSDCMSPlatformFunc.isWorkshopPathDirty()) {
            return null;
        }
        String string = pSDCMSPlatformFunc.getWorkshopPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WorkshopPath_Default(pSDCMSPlatformFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WORKSHOPPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl) throws Exception {
        super.onSyncEntity(pSDCMSPlatformFunc, bl);
    }

    protected void onSyncIndexEntities(PSDCMSPlatformFunc pSDCMSPlatformFunc, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCMSPlatformFunc, bl);
    }

    public Object getDataContextValue(PSDCMSPlatformFunc pSDCMSPlatformFunc, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCMSPlatformFunc, string, iDataContextParam)) != null) {
            return object;
        }
        PSDCMSPlatform pSDCMSPlatform = pSDCMSPlatformFunc.getPSDCMSPlatform();
        if (pSDCMSPlatform != null && pSDCMSPlatform.contains(string)) {
            return pSDCMSPlatform.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDCMSPlatformFunc pSDCMSPlatformFunc, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCMSPlatformFunc, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCPARAM10", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncParam10_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCPARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncParam5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCPARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncParam6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCPARAM7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncParam7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCPARAM8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncParam8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCPARAM9", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncParam9_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IpAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPADDR2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IpAddr2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXCPU", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxCPU_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXMEN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxMem_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINCPU", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinCPU_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINMEN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinMem_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSFUNCTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MSFuncType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Passwd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Port_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformFuncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMSPLATFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMSPlatformName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMSPLATFORMFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMSPlatformFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMSPLATFORMFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMSPlatformFuncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SSHIPADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SSHIPAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SSHPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SSHPort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPLOADFILEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UploadFileMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPLOADPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UploadPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WORKSHOPPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WorkshopPath_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_FuncParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FuncParam10_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCPARAM10", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FuncParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCPARAM2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FuncParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCPARAM3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FuncParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCPARAM4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FuncParam5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FuncParam6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FuncParam7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FuncParam8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FuncParam9_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCPARAM9", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FuncParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IpAddr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IPADDR", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IpAddr2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IPADDR2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MaxCPU_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MaxMem_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_MinCPU_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MinMem_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MSFuncType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSFUNCTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Passwd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PASSWD", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Port_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDCMSPlatformFuncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMSPLATFORMFUNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMSPlatformFuncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMSPLATFORMFUNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMSPlatformId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMSPLATFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMSPlatformName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMSPLATFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMSPlatformFuncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMSPLATFORMFUNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMSPlatformFuncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMSPLATFORMFUNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServiceUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICEURL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SSHIPAddr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SSHIPADDR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SSHPort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_UploadFileMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPLOADFILEMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UploadPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPLOADPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERNAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WorkshopPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WORKSHOPPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDCMSPlatformFunc pSDCMSPlatformFunc) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCMSPlatformFunc)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCMSPlatformFunc pSDCMSPlatformFunc) throws Exception {
        super.onUpdateParent(pSDCMSPlatformFunc);
    }

    @Override
    protected void exportCurXmlModel(PSDCMSPlatformFunc pSDCMSPlatformFunc, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCMSPLATFORMFUNC");
        if (!bl) {
            pSDCMSPlatformFunc.setCreateDate(null);
            pSDCMSPlatformFunc.setCreateMan(null);
            pSDCMSPlatformFunc.setPSDCMSPlatformFuncId(null);
            pSDCMSPlatformFunc.setUpdateDate(null);
            pSDCMSPlatformFunc.setUpdateMan(null);
            super.exportCurXmlModel(pSDCMSPlatformFunc, xmlNode, bl);
        }
    }

    @Override
    public Object getDataType(PSDCMSPlatformFunc pSDCMSPlatformFunc) throws Exception {
        return pSDCMSPlatformFunc.getMSFuncType();
    }
}

