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
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysBDDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysBDDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnBDInst;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnBDInstBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSys;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysBD;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnSysBDServiceBase
extends PSCoreSysServiceBase<PSDepSlnSysBD> {
    private static final Log log = LogFactory.getLog(PSDepSlnSysBDServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnSysBDDEModel pSDepSlnSysBDDEModel;
    private PSDepSlnSysBDDAO pSDepSlnSysBDDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysBDService";
    }

    public PSDepSlnSysBDDEModel getPSDepSlnSysBDDEModel() {
        if (this.pSDepSlnSysBDDEModel == null) {
            try {
                this.pSDepSlnSysBDDEModel = (PSDepSlnSysBDDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysBDDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysBDDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnSysBDDEModel();
    }

    public PSDepSlnSysBDDAO getPSDepSlnSysBDDAO() {
        if (this.pSDepSlnSysBDDAO == null) {
            try {
                this.pSDepSlnSysBDDAO = (PSDepSlnSysBDDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysBDDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysBDDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnSysBDDAO();
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

    protected void onFillParentInfo(PSDepSlnSysBD pSDepSlnSysBD, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSBD_PSDEPSLNBDINST_PSDEPSLNBDINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnBDInstService", (SessionFactory)this.getSessionFactory());
            PSDepSlnBDInst pSDepSlnBDInst = (PSDepSlnBDInst)iService.getDEModel().createEntity();
            pSDepSlnBDInst.set("PSDEPSLNBDINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSlnBDInst);
            } else {
                iService.get(pSDepSlnBDInst);
            }
            this.onFillParentInfo_PSDepSlnBDInst(pSDepSlnSysBD, pSDepSlnBDInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSBD_PSDEPSLNSYS_PSDEPSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDepSlnSys pSDepSlnSys = (PSDepSlnSys)iService.getDEModel().createEntity();
            pSDepSlnSys.set("PSDEPSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSlnSys);
            } else {
                iService.get(pSDepSlnSys);
            }
            this.onFillParentInfo_PSDepSlnSys(pSDepSlnSysBD, pSDepSlnSys);
            return;
        }
        super.onFillParentInfo(pSDepSlnSysBD, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDepSlnBDInst(PSDepSlnSysBD pSDepSlnSysBD, PSDepSlnBDInst pSDepSlnBDInst) throws Exception {
        pSDepSlnSysBD.setPSDepSlnBDInstId(pSDepSlnBDInst.getPSDepSlnBDInstId());
        pSDepSlnSysBD.setPSDepSlnBDInstName(pSDepSlnBDInst.getPSDepSlnBDInstName());
    }

    protected void onFillParentInfo_PSDepSlnSys(PSDepSlnSysBD pSDepSlnSysBD, PSDepSlnSys pSDepSlnSys) throws Exception {
        pSDepSlnSysBD.setPSDepSlnSysId(pSDepSlnSys.getPSDepSlnSysId());
        pSDepSlnSysBD.setPSDepSlnSysName(pSDepSlnSys.getPSDepSlnSysName());
    }

    protected void onFillEntityFullInfo(PSDepSlnSysBD pSDepSlnSysBD, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDepSlnSysBD, bl);
        this.onFillEntityFullInfo_PSDepSlnBDInst(pSDepSlnSysBD, bl);
        this.onFillEntityFullInfo_PSDepSlnSys(pSDepSlnSysBD, bl);
    }

    protected void onFillEntityFullInfo_PSDepSlnBDInst(PSDepSlnSysBD pSDepSlnSysBD, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSlnSys(PSDepSlnSysBD pSDepSlnSysBD, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSlnSysBD pSDepSlnSysBD, boolean bl) throws Exception {
        super.onWriteBackParent(pSDepSlnSysBD, bl);
    }

    public ArrayList<PSDepSlnSysBD> selectByPSDepSlnBDInst(PSDepSlnBDInstBase pSDepSlnBDInstBase) throws Exception {
        return this.selectByPSDepSlnBDInst(pSDepSlnBDInstBase, "", -1);
    }

    public ArrayList<PSDepSlnSysBD> selectByPSDepSlnBDInst(PSDepSlnBDInstBase pSDepSlnBDInstBase, String string) throws Exception {
        return this.selectByPSDepSlnBDInst(pSDepSlnBDInstBase, string, -1);
    }

    public ArrayList<PSDepSlnSysBD> selectByPSDepSlnBDInst(PSDepSlnBDInstBase pSDepSlnBDInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNBDINSTID", (Object)pSDepSlnBDInstBase.getPSDepSlnBDInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnBDInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnBDInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnSysBD> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase) throws Exception {
        return this.selectByPSDepSlnSys(pSDepSlnSysBase, "", -1);
    }

    public ArrayList<PSDepSlnSysBD> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase, String string) throws Exception {
        return this.selectByPSDepSlnSys(pSDepSlnSysBase, string, -1);
    }

    public ArrayList<PSDepSlnSysBD> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNSYSID", (Object)pSDepSlnSysBase.getPSDepSlnSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnSysCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDepSlnBDInst(PSDepSlnBDInst pSDepSlnBDInst) throws Exception {
        ArrayList<PSDepSlnSysBD> arrayList = this.selectByPSDepSlnBDInst(pSDepSlnBDInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNBDINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDepSlnBDInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYSBD_PSDEPSLNBDINST_PSDEPSLNBDINSTID", "", iDataEntityModel.getName(), "PSDEPSLNSYSBD", iDataEntityModel.getDataInfo(pSDepSlnBDInst), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnBDInst(PSDepSlnBDInst pSDepSlnBDInst) throws Exception {
        ArrayList<PSDepSlnSysBD> arrayList = this.selectByPSDepSlnBDInst(pSDepSlnBDInst);
        for (PSDepSlnSysBD pSDepSlnSysBD : arrayList) {
            PSDepSlnSysBD pSDepSlnSysBD2 = (PSDepSlnSysBD)this.getDEModel().createEntity();
            pSDepSlnSysBD2.setPSDepSlnSysBDId(pSDepSlnSysBD.getPSDepSlnSysBDId());
            pSDepSlnSysBD2.setPSDepSlnBDInstId(null);
            this.update(pSDepSlnSysBD2);
        }
    }

    public void removeByPSDepSlnBDInst(PSDepSlnBDInst pSDepSlnBDInst) throws Exception {
        final PSDepSlnBDInst pSDepSlnBDInst2 = pSDepSlnBDInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysBDServiceBase.this.onBeforeRemoveByPSDepSlnBDInst(pSDepSlnBDInst2);
                PSDepSlnSysBDServiceBase.this.internalRemoveByPSDepSlnBDInst(pSDepSlnBDInst2);
                PSDepSlnSysBDServiceBase.this.onAfterRemoveByPSDepSlnBDInst(pSDepSlnBDInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnBDInst(PSDepSlnBDInst pSDepSlnBDInst) throws Exception {
    }

    protected void internalRemoveByPSDepSlnBDInst(PSDepSlnBDInst pSDepSlnBDInst) throws Exception {
        ArrayList<PSDepSlnSysBD> arrayList = this.selectByPSDepSlnBDInst(pSDepSlnBDInst);
        this.onBeforeRemoveByPSDepSlnBDInst(pSDepSlnBDInst, arrayList);
        for (PSDepSlnSysBD pSDepSlnSysBD : arrayList) {
            this.remove(pSDepSlnSysBD);
        }
        this.onAfterRemoveByPSDepSlnBDInst(pSDepSlnBDInst, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnBDInst(PSDepSlnBDInst pSDepSlnBDInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnBDInst(PSDepSlnBDInst pSDepSlnBDInst, ArrayList<PSDepSlnSysBD> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnBDInst(PSDepSlnBDInst pSDepSlnBDInst, ArrayList<PSDepSlnSysBD> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
    }

    public void resetPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysBD> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys);
        for (PSDepSlnSysBD pSDepSlnSysBD : arrayList) {
            PSDepSlnSysBD pSDepSlnSysBD2 = (PSDepSlnSysBD)this.getDEModel().createEntity();
            pSDepSlnSysBD2.setPSDepSlnSysBDId(pSDepSlnSysBD.getPSDepSlnSysBDId());
            pSDepSlnSysBD2.setPSDepSlnSysId(null);
            this.update(pSDepSlnSysBD2);
        }
    }

    public void removeByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        final PSDepSlnSys pSDepSlnSys2 = pSDepSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysBDServiceBase.this.onBeforeRemoveByPSDepSlnSys(pSDepSlnSys2);
                PSDepSlnSysBDServiceBase.this.internalRemoveByPSDepSlnSys(pSDepSlnSys2);
                PSDepSlnSysBDServiceBase.this.onAfterRemoveByPSDepSlnSys(pSDepSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysBD> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys);
        this.onBeforeRemoveByPSDepSlnSys(pSDepSlnSys, arrayList);
        for (PSDepSlnSysBD pSDepSlnSysBD : arrayList) {
            this.remove(pSDepSlnSysBD);
        }
        this.onAfterRemoveByPSDepSlnSys(pSDepSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys, ArrayList<PSDepSlnSysBD> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys, ArrayList<PSDepSlnSysBD> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnSysBD pSDepSlnSysBD) throws Exception {
        super.onBeforeRemove(pSDepSlnSysBD);
    }

    protected void replaceParentInfo(PSDepSlnSysBD pSDepSlnSysBD, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDepSlnSysBD, cloneSession);
        if (pSDepSlnSysBD.getPSDepSlnBDInstId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNBDINST", (Object)pSDepSlnSysBD.getPSDepSlnBDInstId())) != null) {
            this.onFillParentInfo_PSDepSlnBDInst(pSDepSlnSysBD, (PSDepSlnBDInst)iEntity);
        }
        if (pSDepSlnSysBD.getPSDepSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNSYS", (Object)pSDepSlnSysBD.getPSDepSlnSysId())) != null) {
            this.onFillParentInfo_PSDepSlnSys(pSDepSlnSysBD, (PSDepSlnSys)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnSysBD pSDepSlnSysBD, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDepSlnSysBD, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnSysBD pSDepSlnSysBD, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDepSlnSysBD, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnBDInstId(bl, pSDepSlnSysBD, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysBDId(bl, pSDepSlnSysBD, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysBDName(bl, pSDepSlnSysBD, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysId(bl, pSDepSlnSysBD, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDepSlnSysBD, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSlnSysBD pSDepSlnSysBD, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysBD.isMemoDirty() : !pSDepSlnSysBD.isMemoDirty()) {
            return null;
        }
        String string = pSDepSlnSysBD.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDepSlnSysBD, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnBDInstId(boolean bl, PSDepSlnSysBD pSDepSlnSysBD, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysBD.isPSDepSlnBDInstIdDirty() : !pSDepSlnSysBD.isPSDepSlnBDInstIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysBD.getPSDepSlnBDInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnBDInstId_Default(pSDepSlnSysBD, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnSysBDId(boolean bl, PSDepSlnSysBD pSDepSlnSysBD, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysBD.isPSDepSlnSysBDIdDirty() && !bl2 : !pSDepSlnSysBD.isPSDepSlnSysBDIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysBD.getPSDepSlnSysBDId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSBDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysBDId_Default(pSDepSlnSysBD, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSBDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysBDName(boolean bl, PSDepSlnSysBD pSDepSlnSysBD, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysBD.isPSDepSlnSysBDNameDirty() && !bl2 : !pSDepSlnSysBD.isPSDepSlnSysBDNameDirty()) {
            return null;
        }
        String string = pSDepSlnSysBD.getPSDepSlnSysBDName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSBDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysBDName_Default(pSDepSlnSysBD, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSBDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysId(boolean bl, PSDepSlnSysBD pSDepSlnSysBD, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysBD.isPSDepSlnSysIdDirty() : !pSDepSlnSysBD.isPSDepSlnSysIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysBD.getPSDepSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysId_Default(pSDepSlnSysBD, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDepSlnSysBD pSDepSlnSysBD, boolean bl) throws Exception {
        super.onSyncEntity(pSDepSlnSysBD, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnSysBD pSDepSlnSysBD, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDepSlnSysBD, bl);
    }

    public Object getDataContextValue(PSDepSlnSysBD pSDepSlnSysBD, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDepSlnSysBD, string, iDataContextParam)) != null) {
            return object;
        }
        PSDepSlnSys pSDepSlnSys = pSDepSlnSysBD.getPSDepSlnSys();
        if (pSDepSlnSys != null && pSDepSlnSys.contains(string)) {
            return pSDepSlnSys.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnSysBD pSDepSlnSysBD, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDepSlnSysBD, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDEPSLNBDINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnBDInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNBDINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnBDInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSBDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysBDId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSBDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysBDName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDepSlnSysBDId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSBDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysBDName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSBDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDepSlnSysBD pSDepSlnSysBD) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDepSlnSysBD)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnSysBD pSDepSlnSysBD) throws Exception {
        super.onUpdateParent(pSDepSlnSysBD);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnSysBD pSDepSlnSysBD, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNSYSBD");
        if (!bl) {
            pSDepSlnSysBD.setCreateDate(null);
            pSDepSlnSysBD.setCreateMan(null);
            pSDepSlnSysBD.setPSDepSlnBDInstName(null);
            pSDepSlnSysBD.setPSDepSlnSysBDId(null);
            pSDepSlnSysBD.setPSDepSlnSysName(null);
            pSDepSlnSysBD.setUpdateDate(null);
            pSDepSlnSysBD.setUpdateMan(null);
            super.exportCurXmlModel(pSDepSlnSysBD, xmlNode, bl);
        }
    }
}

