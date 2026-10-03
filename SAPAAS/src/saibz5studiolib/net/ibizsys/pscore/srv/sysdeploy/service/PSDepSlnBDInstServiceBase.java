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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBDInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBDInstBase;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnBDInstDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnBDInstDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnBDInst;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysBDService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnBDInstServiceBase
extends PSCoreSysServiceBase<PSDepSlnBDInst> {
    private static final Log log = LogFactory.getLog(PSDepSlnBDInstServiceBase.class);
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnBDInstDEModel pSDepSlnBDInstDEModel;
    private PSDepSlnBDInstDAO pSDepSlnBDInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnBDInstService";
    }

    public PSDepSlnBDInstDEModel getPSDepSlnBDInstDEModel() {
        if (this.pSDepSlnBDInstDEModel == null) {
            try {
                this.pSDepSlnBDInstDEModel = (PSDepSlnBDInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnBDInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnBDInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnBDInstDEModel();
    }

    public PSDepSlnBDInstDAO getPSDepSlnBDInstDAO() {
        if (this.pSDepSlnBDInstDAO == null) {
            try {
                this.pSDepSlnBDInstDAO = (PSDepSlnBDInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnBDInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnBDInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnBDInstDAO();
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

    protected void onFillParentInfo(PSDepSlnBDInst pSDepSlnBDInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNBDINST_PSDCBDINST_PSDCBDINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCBDInstService", (SessionFactory)this.getSessionFactory());
            PSDCBDInst pSDCBDInst = (PSDCBDInst)iService.getDEModel().createEntity();
            pSDCBDInst.set("PSDCBDINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCBDInst);
            } else {
                iService.get(pSDCBDInst);
            }
            this.onFillParentInfo_PSDCBDInst(pSDepSlnBDInst, pSDCBDInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNBDINST_PSDEPSLN_PSDEPSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService", (SessionFactory)this.getSessionFactory());
            PSDepSln pSDepSln = (PSDepSln)iService.getDEModel().createEntity();
            pSDepSln.set("PSDEPSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSln);
            } else {
                iService.get(pSDepSln);
            }
            this.onFillParentInfo_PSDepSln(pSDepSlnBDInst, pSDepSln);
            return;
        }
        super.onFillParentInfo(pSDepSlnBDInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCBDInst(PSDepSlnBDInst pSDepSlnBDInst, PSDCBDInst pSDCBDInst) throws Exception {
        pSDepSlnBDInst.setPSDCBDInstId(pSDCBDInst.getPSDCBDInstId());
        pSDepSlnBDInst.setPSDCBDInstName(pSDCBDInst.getPSDCBDInstName());
    }

    protected void onFillParentInfo_PSDepSln(PSDepSlnBDInst pSDepSlnBDInst, PSDepSln pSDepSln) throws Exception {
        pSDepSlnBDInst.setPSDepSlnId(pSDepSln.getPSDepSlnId());
        pSDepSlnBDInst.setPSDepSlnName(pSDepSln.getPSDepSlnName());
    }

    protected void onFillEntityFullInfo(PSDepSlnBDInst pSDepSlnBDInst, boolean bl) throws Exception {
        if (bl && pSDepSlnBDInst.getValidFlag() == null) {
            pSDepSlnBDInst.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDepSlnBDInst, bl);
        this.onFillEntityFullInfo_PSDCBDInst(pSDepSlnBDInst, bl);
        this.onFillEntityFullInfo_PSDepSln(pSDepSlnBDInst, bl);
    }

    protected void onFillEntityFullInfo_PSDCBDInst(PSDepSlnBDInst pSDepSlnBDInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSln(PSDepSlnBDInst pSDepSlnBDInst, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSlnBDInst pSDepSlnBDInst, boolean bl) throws Exception {
        super.onWriteBackParent(pSDepSlnBDInst, bl);
    }

    public ArrayList<PSDepSlnBDInst> selectByPSDCBDInst(PSDCBDInstBase pSDCBDInstBase) throws Exception {
        return this.selectByPSDCBDInst(pSDCBDInstBase, "", -1);
    }

    public ArrayList<PSDepSlnBDInst> selectByPSDCBDInst(PSDCBDInstBase pSDCBDInstBase, String string) throws Exception {
        return this.selectByPSDCBDInst(pSDCBDInstBase, string, -1);
    }

    public ArrayList<PSDepSlnBDInst> selectByPSDCBDInst(PSDCBDInstBase pSDCBDInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCBDINSTID", (Object)pSDCBDInstBase.getPSDCBDInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCBDInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCBDInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnBDInst> selectByPSDepSln(PSDepSlnBase pSDepSlnBase) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, "", -1);
    }

    public ArrayList<PSDepSlnBDInst> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, string, -1);
    }

    public ArrayList<PSDepSlnBDInst> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
        ArrayList<PSDepSlnBDInst> arrayList = this.selectByPSDCBDInst(pSDCBDInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCBDINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCBDInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNBDINST_PSDCBDINST_PSDCBDINSTID", "", iDataEntityModel.getName(), "PSDEPSLNBDINST", iDataEntityModel.getDataInfo(pSDCBDInst), arrayList.get(0)));
        }
    }

    public void resetPSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
        ArrayList<PSDepSlnBDInst> arrayList = this.selectByPSDCBDInst(pSDCBDInst);
        for (PSDepSlnBDInst pSDepSlnBDInst : arrayList) {
            PSDepSlnBDInst pSDepSlnBDInst2 = (PSDepSlnBDInst)this.getDEModel().createEntity();
            pSDepSlnBDInst2.setPSDepSlnBDInstId(pSDepSlnBDInst.getPSDepSlnBDInstId());
            pSDepSlnBDInst2.setPSDCBDInstId(null);
            this.update(pSDepSlnBDInst2);
        }
    }

    public void removeByPSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
        final PSDCBDInst pSDCBDInst2 = pSDCBDInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnBDInstServiceBase.this.onBeforeRemoveByPSDCBDInst(pSDCBDInst2);
                PSDepSlnBDInstServiceBase.this.internalRemoveByPSDCBDInst(pSDCBDInst2);
                PSDepSlnBDInstServiceBase.this.onAfterRemoveByPSDCBDInst(pSDCBDInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
    }

    protected void internalRemoveByPSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
        ArrayList<PSDepSlnBDInst> arrayList = this.selectByPSDCBDInst(pSDCBDInst);
        this.onBeforeRemoveByPSDCBDInst(pSDCBDInst, arrayList);
        for (PSDepSlnBDInst pSDepSlnBDInst : arrayList) {
            this.remove(pSDepSlnBDInst);
        }
        this.onAfterRemoveByPSDCBDInst(pSDCBDInst, arrayList);
    }

    protected void onAfterRemoveByPSDCBDInst(PSDCBDInst pSDCBDInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDCBDInst(PSDCBDInst pSDCBDInst, ArrayList<PSDepSlnBDInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCBDInst(PSDCBDInst pSDCBDInst, ArrayList<PSDepSlnBDInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    public void resetPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnBDInst> arrayList = this.selectByPSDepSln(pSDepSln);
        for (PSDepSlnBDInst pSDepSlnBDInst : arrayList) {
            PSDepSlnBDInst pSDepSlnBDInst2 = (PSDepSlnBDInst)this.getDEModel().createEntity();
            pSDepSlnBDInst2.setPSDepSlnBDInstId(pSDepSlnBDInst.getPSDepSlnBDInstId());
            pSDepSlnBDInst2.setPSDepSlnId(null);
            this.update(pSDepSlnBDInst2);
        }
    }

    public void removeByPSDepSln(PSDepSln pSDepSln) throws Exception {
        final PSDepSln pSDepSln2 = pSDepSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnBDInstServiceBase.this.onBeforeRemoveByPSDepSln(pSDepSln2);
                PSDepSlnBDInstServiceBase.this.internalRemoveByPSDepSln(pSDepSln2);
                PSDepSlnBDInstServiceBase.this.onAfterRemoveByPSDepSln(pSDepSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void internalRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnBDInst> arrayList = this.selectByPSDepSln(pSDepSln);
        this.onBeforeRemoveByPSDepSln(pSDepSln, arrayList);
        for (PSDepSlnBDInst pSDepSlnBDInst : arrayList) {
            this.remove(pSDepSlnBDInst);
        }
        this.onAfterRemoveByPSDepSln(pSDepSln, arrayList);
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnBDInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnBDInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnBDInst pSDepSlnBDInst) throws Exception {
        PSDepSlnSysBDService pSDepSlnSysBDService = (PSDepSlnSysBDService)ServiceGlobal.getService(PSDepSlnSysBDService.class, (SessionFactory)this.getSessionFactory());
        pSDepSlnSysBDService.testRemoveByPSDepSlnBDInst(pSDepSlnBDInst);
        super.onBeforeRemove(pSDepSlnBDInst);
    }

    protected void replaceParentInfo(PSDepSlnBDInst pSDepSlnBDInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDepSlnBDInst, cloneSession);
        if (pSDepSlnBDInst.getPSDCBDInstId() != null && (iEntity = cloneSession.getEntity("PSDCBDINST", (Object)pSDepSlnBDInst.getPSDCBDInstId())) != null) {
            this.onFillParentInfo_PSDCBDInst(pSDepSlnBDInst, (PSDCBDInst)iEntity);
        }
        if (pSDepSlnBDInst.getPSDepSlnId() != null && (iEntity = cloneSession.getEntity("PSDEPSLN", (Object)pSDepSlnBDInst.getPSDepSlnId())) != null) {
            this.onFillParentInfo_PSDepSln(pSDepSlnBDInst, (PSDepSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnBDInst pSDepSlnBDInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDepSlnBDInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnBDInst pSDepSlnBDInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDepSlnBDInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCBDInstId(bl, pSDepSlnBDInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnBDInstId(bl, pSDepSlnBDInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnBDInstName(bl, pSDepSlnBDInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnId(bl, pSDepSlnBDInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDepSlnBDInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDepSlnBDInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSlnBDInst pSDepSlnBDInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnBDInst.isMemoDirty() : !pSDepSlnBDInst.isMemoDirty()) {
            return null;
        }
        String string = pSDepSlnBDInst.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDepSlnBDInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCBDInstId(boolean bl, PSDepSlnBDInst pSDepSlnBDInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnBDInst.isPSDCBDInstIdDirty() : !pSDepSlnBDInst.isPSDCBDInstIdDirty()) {
            return null;
        }
        String string = pSDepSlnBDInst.getPSDCBDInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCBDInstId_Default(pSDepSlnBDInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCBDINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnBDInstId(boolean bl, PSDepSlnBDInst pSDepSlnBDInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnBDInst.isPSDepSlnBDInstIdDirty() && !bl2 : !pSDepSlnBDInst.isPSDepSlnBDInstIdDirty()) {
            return null;
        }
        String string = pSDepSlnBDInst.getPSDepSlnBDInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNBDINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnBDInstId_Default(pSDepSlnBDInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNBDINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnBDInstName(boolean bl, PSDepSlnBDInst pSDepSlnBDInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnBDInst.isPSDepSlnBDInstNameDirty() && !bl2 : !pSDepSlnBDInst.isPSDepSlnBDInstNameDirty()) {
            return null;
        }
        String string = pSDepSlnBDInst.getPSDepSlnBDInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNBDINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnBDInstName_Default(pSDepSlnBDInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNBDINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnId(boolean bl, PSDepSlnBDInst pSDepSlnBDInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnBDInst.isPSDepSlnIdDirty() : !pSDepSlnBDInst.isPSDepSlnIdDirty()) {
            return null;
        }
        String string = pSDepSlnBDInst.getPSDepSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnId_Default(pSDepSlnBDInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDepSlnBDInst pSDepSlnBDInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnBDInst.isValidFlagDirty() && !bl2 : !pSDepSlnBDInst.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDepSlnBDInst.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDepSlnBDInst, bl2, bl3);
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

    protected void onSyncEntity(PSDepSlnBDInst pSDepSlnBDInst, boolean bl) throws Exception {
        super.onSyncEntity(pSDepSlnBDInst, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnBDInst pSDepSlnBDInst, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDepSlnBDInst, bl);
    }

    public Object getDataContextValue(PSDepSlnBDInst pSDepSlnBDInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDepSlnBDInst, string, iDataContextParam)) != null) {
            return object;
        }
        PSDepSln pSDepSln = pSDepSlnBDInst.getPSDepSln();
        if (pSDepSln != null && pSDepSln.contains(string)) {
            return pSDepSln.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnBDInst pSDepSlnBDInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDepSlnBDInst, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDCBDINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCBDInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCBDINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCBDInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNBDINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnBDInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNBDINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnBDInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDCBDInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCBDINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCBDInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCBDINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnBDInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNBDINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnBDInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNBDINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDepSlnBDInst pSDepSlnBDInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDepSlnBDInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnBDInst pSDepSlnBDInst) throws Exception {
        super.onUpdateParent(pSDepSlnBDInst);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnBDInst pSDepSlnBDInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNBDINST");
        if (!bl) {
            pSDepSlnBDInst.setCreateDate(null);
            pSDepSlnBDInst.setCreateMan(null);
            pSDepSlnBDInst.setPSDCBDInstName(null);
            pSDepSlnBDInst.setPSDepSlnBDInstId(null);
            pSDepSlnBDInst.setPSDepSlnName(null);
            pSDepSlnBDInst.setUpdateDate(null);
            pSDepSlnBDInst.setUpdateMan(null);
            super.exportCurXmlModel(pSDepSlnBDInst, xmlNode, bl);
        }
    }
}

