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
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysWFDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysWFDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSys;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysWF;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnWFEngineInst;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnWFEngineInstBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnSysWFServiceBase
extends PSCoreSysServiceBase<PSDepSlnSysWF> {
    private static final Log log = LogFactory.getLog(PSDepSlnSysWFServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnSysWFDEModel pSDepSlnSysWFDEModel;
    private PSDepSlnSysWFDAO pSDepSlnSysWFDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysWFService";
    }

    public PSDepSlnSysWFDEModel getPSDepSlnSysWFDEModel() {
        if (this.pSDepSlnSysWFDEModel == null) {
            try {
                this.pSDepSlnSysWFDEModel = (PSDepSlnSysWFDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysWFDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysWFDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnSysWFDEModel();
    }

    public PSDepSlnSysWFDAO getPSDepSlnSysWFDAO() {
        if (this.pSDepSlnSysWFDAO == null) {
            try {
                this.pSDepSlnSysWFDAO = (PSDepSlnSysWFDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysWFDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysWFDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnSysWFDAO();
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

    protected void onFillParentInfo(PSDepSlnSysWF pSDepSlnSysWF, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSWF_PSDEPSLNSYS_PSDEPSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDepSlnSys pSDepSlnSys = (PSDepSlnSys)iService.getDEModel().createEntity();
            pSDepSlnSys.set("PSDEPSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSlnSys);
            } else {
                iService.get((IEntity)pSDepSlnSys);
            }
            this.onFillParentInfo_PSDepSlnSys(pSDepSlnSysWF, pSDepSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSWF_PSDEPSLNWFENGINEINST_PSDEPSLNWFENGINEINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnWFEngineInstService", (SessionFactory)this.getSessionFactory());
            PSDepSlnWFEngineInst pSDepSlnWFEngineInst = (PSDepSlnWFEngineInst)iService.getDEModel().createEntity();
            pSDepSlnWFEngineInst.set("PSDEPSLNWFENGINEINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSlnWFEngineInst);
            } else {
                iService.get((IEntity)pSDepSlnWFEngineInst);
            }
            this.onFillParentInfo_PSDepSlnWFEngineInst(pSDepSlnSysWF, pSDepSlnWFEngineInst);
            return;
        }
        super.onFillParentInfo((IEntity)pSDepSlnSysWF, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDepSlnSys(PSDepSlnSysWF pSDepSlnSysWF, PSDepSlnSys pSDepSlnSys) throws Exception {
        pSDepSlnSysWF.setPSDepSlnSysId(pSDepSlnSys.getPSDepSlnSysId());
        pSDepSlnSysWF.setPSDepSlnSysName(pSDepSlnSys.getPSDepSlnSysName());
    }

    protected void onFillParentInfo_PSDepSlnWFEngineInst(PSDepSlnSysWF pSDepSlnSysWF, PSDepSlnWFEngineInst pSDepSlnWFEngineInst) throws Exception {
        pSDepSlnSysWF.setPSDepSlnWFEngineInstId(pSDepSlnWFEngineInst.getPSDepSlnWFEngineInstId());
        pSDepSlnSysWF.setPSDepSlnWFEngineInstName(pSDepSlnWFEngineInst.getPSDepSlnWFEngineInstName());
    }

    protected void onFillEntityFullInfo(PSDepSlnSysWF pSDepSlnSysWF, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDepSlnSysWF, bl);
        this.onFillEntityFullInfo_PSDepSlnSys(pSDepSlnSysWF, bl);
        this.onFillEntityFullInfo_PSDepSlnWFEngineInst(pSDepSlnSysWF, bl);
    }

    protected void onFillEntityFullInfo_PSDepSlnSys(PSDepSlnSysWF pSDepSlnSysWF, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSlnWFEngineInst(PSDepSlnSysWF pSDepSlnSysWF, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSlnSysWF pSDepSlnSysWF, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDepSlnSysWF, bl);
    }

    public ArrayList<PSDepSlnSysWF> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase) throws Exception {
        return this.selectByPSDepSlnSys(pSDepSlnSysBase, "", -1);
    }

    public ArrayList<PSDepSlnSysWF> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase, String string) throws Exception {
        return this.selectByPSDepSlnSys(pSDepSlnSysBase, string, -1);
    }

    public ArrayList<PSDepSlnSysWF> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase, String string, int n) throws Exception {
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

    public ArrayList<PSDepSlnSysWF> selectByPSDepSlnWFEngineInst(PSDepSlnWFEngineInstBase pSDepSlnWFEngineInstBase) throws Exception {
        return this.selectByPSDepSlnWFEngineInst(pSDepSlnWFEngineInstBase, "", -1);
    }

    public ArrayList<PSDepSlnSysWF> selectByPSDepSlnWFEngineInst(PSDepSlnWFEngineInstBase pSDepSlnWFEngineInstBase, String string) throws Exception {
        return this.selectByPSDepSlnWFEngineInst(pSDepSlnWFEngineInstBase, string, -1);
    }

    public ArrayList<PSDepSlnSysWF> selectByPSDepSlnWFEngineInst(PSDepSlnWFEngineInstBase pSDepSlnWFEngineInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNWFENGINEINSTID", (Object)pSDepSlnWFEngineInstBase.getPSDepSlnWFEngineInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnWFEngineInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnWFEngineInstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
    }

    public void resetPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysWF> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys);
        for (PSDepSlnSysWF pSDepSlnSysWF : arrayList) {
            PSDepSlnSysWF pSDepSlnSysWF2 = (PSDepSlnSysWF)this.getDEModel().createEntity();
            pSDepSlnSysWF2.setPSDepSlnSysWFId(pSDepSlnSysWF.getPSDepSlnSysWFId());
            pSDepSlnSysWF2.setPSDepSlnSysId(null);
            this.update(pSDepSlnSysWF2);
        }
    }

    public void removeByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        final PSDepSlnSys pSDepSlnSys2 = pSDepSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysWFServiceBase.this.onBeforeRemoveByPSDepSlnSys(pSDepSlnSys2);
                PSDepSlnSysWFServiceBase.this.internalRemoveByPSDepSlnSys(pSDepSlnSys2);
                PSDepSlnSysWFServiceBase.this.onAfterRemoveByPSDepSlnSys(pSDepSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysWF> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys);
        this.onBeforeRemoveByPSDepSlnSys(pSDepSlnSys, arrayList);
        for (PSDepSlnSysWF pSDepSlnSysWF : arrayList) {
            this.remove((IEntity)pSDepSlnSysWF);
        }
        this.onAfterRemoveByPSDepSlnSys(pSDepSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys, ArrayList<PSDepSlnSysWF> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys, ArrayList<PSDepSlnSysWF> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSlnWFEngineInst(PSDepSlnWFEngineInst pSDepSlnWFEngineInst) throws Exception {
        ArrayList<PSDepSlnSysWF> arrayList = this.selectByPSDepSlnWFEngineInst(pSDepSlnWFEngineInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNWFENGINEINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSlnWFEngineInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYSWF_PSDEPSLNWFENGINEINST_PSDEPSLNWFENGINEINSTID", "", iDataEntityModel.getName(), "PSDEPSLNSYSWF", iDataEntityModel.getDataInfo((IEntity)pSDepSlnWFEngineInst), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnWFEngineInst(PSDepSlnWFEngineInst pSDepSlnWFEngineInst) throws Exception {
        ArrayList<PSDepSlnSysWF> arrayList = this.selectByPSDepSlnWFEngineInst(pSDepSlnWFEngineInst);
        for (PSDepSlnSysWF pSDepSlnSysWF : arrayList) {
            PSDepSlnSysWF pSDepSlnSysWF2 = (PSDepSlnSysWF)this.getDEModel().createEntity();
            pSDepSlnSysWF2.setPSDepSlnSysWFId(pSDepSlnSysWF.getPSDepSlnSysWFId());
            pSDepSlnSysWF2.setPSDepSlnWFEngineInstId(null);
            this.update(pSDepSlnSysWF2);
        }
    }

    public void removeByPSDepSlnWFEngineInst(PSDepSlnWFEngineInst pSDepSlnWFEngineInst) throws Exception {
        final PSDepSlnWFEngineInst pSDepSlnWFEngineInst2 = pSDepSlnWFEngineInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysWFServiceBase.this.onBeforeRemoveByPSDepSlnWFEngineInst(pSDepSlnWFEngineInst2);
                PSDepSlnSysWFServiceBase.this.internalRemoveByPSDepSlnWFEngineInst(pSDepSlnWFEngineInst2);
                PSDepSlnSysWFServiceBase.this.onAfterRemoveByPSDepSlnWFEngineInst(pSDepSlnWFEngineInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnWFEngineInst(PSDepSlnWFEngineInst pSDepSlnWFEngineInst) throws Exception {
    }

    protected void internalRemoveByPSDepSlnWFEngineInst(PSDepSlnWFEngineInst pSDepSlnWFEngineInst) throws Exception {
        ArrayList<PSDepSlnSysWF> arrayList = this.selectByPSDepSlnWFEngineInst(pSDepSlnWFEngineInst);
        this.onBeforeRemoveByPSDepSlnWFEngineInst(pSDepSlnWFEngineInst, arrayList);
        for (PSDepSlnSysWF pSDepSlnSysWF : arrayList) {
            this.remove((IEntity)pSDepSlnSysWF);
        }
        this.onAfterRemoveByPSDepSlnWFEngineInst(pSDepSlnWFEngineInst, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnWFEngineInst(PSDepSlnWFEngineInst pSDepSlnWFEngineInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnWFEngineInst(PSDepSlnWFEngineInst pSDepSlnWFEngineInst, ArrayList<PSDepSlnSysWF> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnWFEngineInst(PSDepSlnWFEngineInst pSDepSlnWFEngineInst, ArrayList<PSDepSlnSysWF> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnSysWF pSDepSlnSysWF) throws Exception {
        super.onBeforeRemove(pSDepSlnSysWF);
    }

    protected void replaceParentInfo(PSDepSlnSysWF pSDepSlnSysWF, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDepSlnSysWF, cloneSession);
        if (pSDepSlnSysWF.getPSDepSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNSYS", (Object)pSDepSlnSysWF.getPSDepSlnSysId())) != null) {
            this.onFillParentInfo_PSDepSlnSys(pSDepSlnSysWF, (PSDepSlnSys)iEntity);
        }
        if (pSDepSlnSysWF.getPSDepSlnWFEngineInstId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNWFENGINEINST", (Object)pSDepSlnSysWF.getPSDepSlnWFEngineInstId())) != null) {
            this.onFillParentInfo_PSDepSlnWFEngineInst(pSDepSlnSysWF, (PSDepSlnWFEngineInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnSysWF pSDepSlnSysWF, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDepSlnSysWF, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnSysWF pSDepSlnSysWF, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDepSlnSysWF, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysId(bl, pSDepSlnSysWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysWFId(bl, pSDepSlnSysWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysWFName(bl, pSDepSlnSysWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnWFEngineInstId(bl, pSDepSlnSysWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDepSlnSysWF, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSlnSysWF pSDepSlnSysWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysWF.isMemoDirty() : !pSDepSlnSysWF.isMemoDirty()) {
            return null;
        }
        String string = pSDepSlnSysWF.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDepSlnSysWF, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnSysId(boolean bl, PSDepSlnSysWF pSDepSlnSysWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysWF.isPSDepSlnSysIdDirty() : !pSDepSlnSysWF.isPSDepSlnSysIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysWF.getPSDepSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysId_Default((IEntity)pSDepSlnSysWF, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnSysWFId(boolean bl, PSDepSlnSysWF pSDepSlnSysWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysWF.isPSDepSlnSysWFIdDirty() && !bl2 : !pSDepSlnSysWF.isPSDepSlnSysWFIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysWF.getPSDepSlnSysWFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSWFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysWFId_Default((IEntity)pSDepSlnSysWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSWFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysWFName(boolean bl, PSDepSlnSysWF pSDepSlnSysWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysWF.isPSDepSlnSysWFNameDirty() && !bl2 : !pSDepSlnSysWF.isPSDepSlnSysWFNameDirty()) {
            return null;
        }
        String string = pSDepSlnSysWF.getPSDepSlnSysWFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSWFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysWFName_Default((IEntity)pSDepSlnSysWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSWFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnWFEngineInstId(boolean bl, PSDepSlnSysWF pSDepSlnSysWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysWF.isPSDepSlnWFEngineInstIdDirty() : !pSDepSlnSysWF.isPSDepSlnWFEngineInstIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysWF.getPSDepSlnWFEngineInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnWFEngineInstId_Default((IEntity)pSDepSlnSysWF, bl2, bl3);
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

    protected void onSyncEntity(PSDepSlnSysWF pSDepSlnSysWF, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDepSlnSysWF, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnSysWF pSDepSlnSysWF, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDepSlnSysWF, bl);
    }

    public Object getDataContextValue(PSDepSlnSysWF pSDepSlnSysWF, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDepSlnSysWF, string, iDataContextParam)) != null) {
            return object;
        }
        PSDepSlnSys pSDepSlnSys = pSDepSlnSysWF.getPSDepSlnSys();
        if (pSDepSlnSys != null && pSDepSlnSys.contains(string)) {
            return pSDepSlnSys.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnSysWF pSDepSlnSysWF, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDepSlnSysWF, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSWFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysWFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSWFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysWFName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDepSlnSysWFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSWFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysWFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSWFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDepSlnSysWF pSDepSlnSysWF) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDepSlnSysWF)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnSysWF pSDepSlnSysWF) throws Exception {
        super.onUpdateParent((IEntity)pSDepSlnSysWF);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnSysWF pSDepSlnSysWF, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNSYSWF");
        if (!bl) {
            pSDepSlnSysWF.setCreateDate(null);
            pSDepSlnSysWF.setCreateMan(null);
            pSDepSlnSysWF.setPSDepSlnSysName(null);
            pSDepSlnSysWF.setPSDepSlnSysWFId(null);
            pSDepSlnSysWF.setPSDepSlnWFEngineInstName(null);
            pSDepSlnSysWF.setUpdateDate(null);
            pSDepSlnSysWF.setUpdateMan(null);
            super.exportCurXmlModel(pSDepSlnSysWF, xmlNode, bl);
        }
    }
}

