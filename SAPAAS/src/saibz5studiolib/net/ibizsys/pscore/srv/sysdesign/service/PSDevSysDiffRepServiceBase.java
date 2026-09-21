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
 *  net.ibizsys.paas.service.IServicePlugin
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

import java.sql.Timestamp;
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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSysDiffRepDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSysDiffRepDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSysDiffRep;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSysDiffItemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSysDiffRepServiceBase
extends PSCoreSysServiceBase<PSDevSysDiffRep> {
    private static final Log log = LogFactory.getLog(PSDevSysDiffRepServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_X_STARTANALYSISTASK = "X_STARTANALYSISTASK";
    public static final String ACTION_X_STOPANALYSISTASK = "X_STOPANALYSISTASK";
    private PSDevSysDiffRepDEModel pSDevSysDiffRepDEModel;
    private PSDevSysDiffRepDAO pSDevSysDiffRepDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSysDiffRepService";
    }

    public PSDevSysDiffRepDEModel getPSDevSysDiffRepDEModel() {
        if (this.pSDevSysDiffRepDEModel == null) {
            try {
                this.pSDevSysDiffRepDEModel = (PSDevSysDiffRepDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSysDiffRepDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSysDiffRepDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSysDiffRepDEModel();
    }

    public PSDevSysDiffRepDAO getPSDevSysDiffRepDAO() {
        if (this.pSDevSysDiffRepDAO == null) {
            try {
                this.pSDevSysDiffRepDAO = (PSDevSysDiffRepDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSysDiffRepDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSysDiffRepDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSysDiffRepDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_X_STARTANALYSISTASK, (boolean)true) == 0) {
            this.startAnalysisTask((PSDevSysDiffRep)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X_STOPANALYSISTASK, (boolean)true) == 0) {
            this.stopAnalysisTask((PSDevSysDiffRep)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void startAnalysisTask(PSDevSysDiffRep pSDevSysDiffRep) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_STARTANALYSISTASK, 0, (IEntity)pSDevSysDiffRep, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevSysDiffRep, ACTION_X_STARTANALYSISTASK);
        final PSDevSysDiffRep pSDevSysDiffRep2 = pSDevSysDiffRep;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSysDiffRepServiceBase.this.getService(), PSDevSysDiffRepServiceBase.ACTION_X_STARTANALYSISTASK, 40, (IEntity)pSDevSysDiffRep2, null).getResult() != 1) {
                    PSDevSysDiffRepServiceBase.this.onStartAnalysisTask(pSDevSysDiffRep2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_STARTANALYSISTASK, 99, (IEntity)pSDevSysDiffRep, null);
        }
    }

    protected void onStartAnalysisTask(PSDevSysDiffRep pSDevSysDiffRep) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_STARTANALYSISTASK]");
    }

    public void stopAnalysisTask(PSDevSysDiffRep pSDevSysDiffRep) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_STOPANALYSISTASK, 0, (IEntity)pSDevSysDiffRep, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevSysDiffRep, ACTION_X_STOPANALYSISTASK);
        final PSDevSysDiffRep pSDevSysDiffRep2 = pSDevSysDiffRep;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSysDiffRepServiceBase.this.getService(), PSDevSysDiffRepServiceBase.ACTION_X_STOPANALYSISTASK, 40, (IEntity)pSDevSysDiffRep2, null).getResult() != 1) {
                    PSDevSysDiffRepServiceBase.this.onStopAnalysisTask(pSDevSysDiffRep2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_STOPANALYSISTASK, 99, (IEntity)pSDevSysDiffRep, null);
        }
    }

    protected void onStopAnalysisTask(PSDevSysDiffRep pSDevSysDiffRep) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_STOPANALYSISTASK]");
    }

    protected void onFillParentInfo(PSDevSysDiffRep pSDevSysDiffRep, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSYSDIFFREP_PSDEVSLNSYS_DSTPSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSys);
            } else {
                iService.get((IEntity)pSDevSlnSys);
            }
            this.onFillParentInfo_DstPSDevSlnSys(pSDevSysDiffRep, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSYSDIFFREP_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSys);
            } else {
                iService.get((IEntity)pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDevSysDiffRep, pSDevSlnSys);
            return;
        }
        super.onFillParentInfo((IEntity)pSDevSysDiffRep, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_DstPSDevSlnSys(PSDevSysDiffRep pSDevSysDiffRep, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSysDiffRep.setDstPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSysDiffRep.setDstPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDevSysDiffRep pSDevSysDiffRep, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSysDiffRep.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSysDiffRep.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillEntityFullInfo(PSDevSysDiffRep pSDevSysDiffRep, boolean bl) throws Exception {
        if (bl && pSDevSysDiffRep.getRepState() == null) {
            pSDevSysDiffRep.setRepState((Integer)this.getDefaultValue(this.getWebContext(), "", "10", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSDevSysDiffRep, bl);
        this.onFillEntityFullInfo_DstPSDevSlnSys(pSDevSysDiffRep, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDevSysDiffRep, bl);
    }

    protected void onFillEntityFullInfo_DstPSDevSlnSys(PSDevSysDiffRep pSDevSysDiffRep, boolean bl) throws Exception {
        if (pSDevSysDiffRep.isDstPSDevSlnSysIdDirty()) {
            if (pSDevSysDiffRep.getDstPSDevSlnSysId() != null) {
                if (pSDevSysDiffRep.getDstPSDevSlnSysId() == null || pSDevSysDiffRep.getDstPSDevSlnSysName() == null) {
                    PSDevSlnSys pSDevSlnSys = pSDevSysDiffRep.getDstPSDevSlnSys();
                    pSDevSysDiffRep.setDstPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
                }
            } else {
                pSDevSysDiffRep.setDstPSDevSlnSysName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDevSysDiffRep pSDevSysDiffRep, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevSysDiffRep pSDevSysDiffRep, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDevSysDiffRep, bl);
    }

    public ArrayList<PSDevSysDiffRep> selectByDstPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByDstPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSysDiffRep> selectByDstPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByDstPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSysDiffRep> selectByDstPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEVSLNSYSID", (Object)pSDevSlnSysBase.getPSDevSlnSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDevSlnSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDevSlnSysCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSysDiffRep> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSysDiffRep> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSysDiffRep> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSID", (Object)pSDevSlnSysBase.getPSDevSlnSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByDstPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSysDiffRep> arrayList = this.selectByDstPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSYSDIFFREP_PSDEVSLNSYS_DSTPSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSDEVSYSDIFFREP", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetDstPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSysDiffRep> arrayList = this.selectByDstPSDevSlnSys(pSDevSlnSys);
        for (PSDevSysDiffRep pSDevSysDiffRep : arrayList) {
            PSDevSysDiffRep pSDevSysDiffRep2 = (PSDevSysDiffRep)this.getDEModel().createEntity();
            pSDevSysDiffRep2.setPSDevSysDiffRepId(pSDevSysDiffRep.getPSDevSysDiffRepId());
            pSDevSysDiffRep2.setDstPSDevSlnSysId(null);
            this.update(pSDevSysDiffRep2);
        }
    }

    public void removeByDstPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSysDiffRepServiceBase.this.onBeforeRemoveByDstPSDevSlnSys(pSDevSlnSys2);
                PSDevSysDiffRepServiceBase.this.internalRemoveByDstPSDevSlnSys(pSDevSlnSys2);
                PSDevSysDiffRepServiceBase.this.onAfterRemoveByDstPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByDstPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSysDiffRep> arrayList = this.selectByDstPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByDstPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSysDiffRep pSDevSysDiffRep : arrayList) {
            this.remove((IEntity)pSDevSysDiffRep);
        }
        this.onAfterRemoveByDstPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByDstPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSysDiffRep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSysDiffRep> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSysDiffRep> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDevSysDiffRep pSDevSysDiffRep : arrayList) {
            PSDevSysDiffRep pSDevSysDiffRep2 = (PSDevSysDiffRep)this.getDEModel().createEntity();
            pSDevSysDiffRep2.setPSDevSysDiffRepId(pSDevSysDiffRep.getPSDevSysDiffRepId());
            pSDevSysDiffRep2.setPSDevSlnSysId(null);
            this.update(pSDevSysDiffRep2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSysDiffRepServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSysDiffRepServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSysDiffRepServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSysDiffRep> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSysDiffRep pSDevSysDiffRep : arrayList) {
            this.remove((IEntity)pSDevSysDiffRep);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSysDiffRep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSysDiffRep> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSysDiffRep pSDevSysDiffRep) throws Exception {
        PSDevSysDiffItemService pSDevSysDiffItemService = (PSDevSysDiffItemService)ServiceGlobal.getService(PSDevSysDiffItemService.class, (SessionFactory)this.getSessionFactory());
        pSDevSysDiffItemService.testRemoveByPSDevSysDiffRep(pSDevSysDiffRep);
        pSDevSysDiffItemService.removeByPSDevSysDiffRep(pSDevSysDiffRep);
        super.onBeforeRemove(pSDevSysDiffRep);
    }

    protected void replaceParentInfo(PSDevSysDiffRep pSDevSysDiffRep, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDevSysDiffRep, cloneSession);
        if (pSDevSysDiffRep.getDstPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSysDiffRep.getDstPSDevSlnSysId())) != null) {
            this.onFillParentInfo_DstPSDevSlnSys(pSDevSysDiffRep, (PSDevSlnSys)iEntity);
        }
        if (pSDevSysDiffRep.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSysDiffRep.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDevSysDiffRep, (PSDevSlnSys)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSysDiffRep pSDevSysDiffRep, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDevSysDiffRep, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSysDiffRep pSDevSysDiffRep, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BeginTime(bl, pSDevSysDiffRep, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDevSlnSysId(bl, pSDevSysDiffRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDevSlnSysName(bl, pSDevSysDiffRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstSysModelVer(bl, pSDevSysDiffRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndTime(bl, pSDevSysDiffRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSysDiffRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevSysDiffRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSysDiffRepId(bl, pSDevSysDiffRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSysDiffRepName(bl, pSDevSysDiffRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RepState(bl, pSDevSysDiffRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysModelVer(bl, pSDevSysDiffRep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDevSysDiffRep, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BeginTime(boolean bl, PSDevSysDiffRep pSDevSysDiffRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffRep.isBeginTimeDirty() : !pSDevSysDiffRep.isBeginTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSysDiffRep.getBeginTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BeginTime_Default((IEntity)pSDevSysDiffRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDevSlnSysId(boolean bl, PSDevSysDiffRep pSDevSysDiffRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffRep.isDstPSDevSlnSysIdDirty() && !bl2 : !pSDevSysDiffRep.isDstPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSysDiffRep.getDstPSDevSlnSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEVSLNSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDevSlnSysId_Default((IEntity)pSDevSysDiffRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEVSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDevSlnSysName(boolean bl, PSDevSysDiffRep pSDevSysDiffRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffRep.isDstPSDevSlnSysNameDirty() && !bl2 : !pSDevSysDiffRep.isDstPSDevSlnSysNameDirty()) {
            return null;
        }
        String string = pSDevSysDiffRep.getDstPSDevSlnSysName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEVSLNSYSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDevSlnSysName_Default((IEntity)pSDevSysDiffRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEVSLNSYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstSysModelVer(boolean bl, PSDevSysDiffRep pSDevSysDiffRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffRep.isDstSysModelVerDirty() : !pSDevSysDiffRep.isDstSysModelVerDirty()) {
            return null;
        }
        Integer n = pSDevSysDiffRep.getDstSysModelVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DstSysModelVer_Default((IEntity)pSDevSysDiffRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTSYSMODELVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndTime(boolean bl, PSDevSysDiffRep pSDevSysDiffRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffRep.isEndTimeDirty() : !pSDevSysDiffRep.isEndTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSysDiffRep.getEndTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EndTime_Default((IEntity)pSDevSysDiffRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSysDiffRep pSDevSysDiffRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffRep.isMemoDirty() : !pSDevSysDiffRep.isMemoDirty()) {
            return null;
        }
        String string = pSDevSysDiffRep.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDevSysDiffRep, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevSysDiffRep pSDevSysDiffRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffRep.isPSDevSlnSysIdDirty() && !bl2 : !pSDevSysDiffRep.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSysDiffRep.getPSDevSlnSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default((IEntity)pSDevSysDiffRep, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSysDiffRepId(boolean bl, PSDevSysDiffRep pSDevSysDiffRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffRep.isPSDevSysDiffRepIdDirty() && !bl2 : !pSDevSysDiffRep.isPSDevSysDiffRepIdDirty()) {
            return null;
        }
        String string = pSDevSysDiffRep.getPSDevSysDiffRepId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSYSDIFFREPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSysDiffRepId_Default((IEntity)pSDevSysDiffRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSYSDIFFREPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSysDiffRepName(boolean bl, PSDevSysDiffRep pSDevSysDiffRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffRep.isPSDevSysDiffRepNameDirty() && !bl2 : !pSDevSysDiffRep.isPSDevSysDiffRepNameDirty()) {
            return null;
        }
        String string = pSDevSysDiffRep.getPSDevSysDiffRepName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSYSDIFFREPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSysDiffRepName_Default((IEntity)pSDevSysDiffRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSYSDIFFREPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RepState(boolean bl, PSDevSysDiffRep pSDevSysDiffRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffRep.isRepStateDirty() && !bl2 : !pSDevSysDiffRep.isRepStateDirty()) {
            return null;
        }
        Integer n = pSDevSysDiffRep.getRepState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REPSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_RepState_Default((IEntity)pSDevSysDiffRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REPSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysModelVer(boolean bl, PSDevSysDiffRep pSDevSysDiffRep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSysDiffRep.isSysModelVerDirty() : !pSDevSysDiffRep.isSysModelVerDirty()) {
            return null;
        }
        Integer n = pSDevSysDiffRep.getSysModelVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysModelVer_Default((IEntity)pSDevSysDiffRep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSMODELVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevSysDiffRep pSDevSysDiffRep, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDevSysDiffRep, bl);
    }

    protected void onSyncIndexEntities(PSDevSysDiffRep pSDevSysDiffRep, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDevSysDiffRep, bl);
    }

    public Object getDataContextValue(PSDevSysDiffRep pSDevSysDiffRep, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDevSysDiffRep, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevSlnSys pSDevSlnSys = pSDevSysDiffRep.getPSDevSlnSys();
        if (pSDevSlnSys != null && pSDevSlnSys.contains(string)) {
            return pSDevSlnSys.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSysDiffRep pSDevSysDiffRep, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDevSysDiffRep, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BEGINTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTSYSMODELVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstSysModelVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSYSDIFFREPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSysDiffRepId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSYSDIFFREPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSysDiffRepName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REPSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RepState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSMODELVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysModelVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BeginTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_DstPSDevSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEVSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDevSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEVSLNSYSNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstSysModelVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EndTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDevSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSysDiffRepId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSYSDIFFREPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSysDiffRepName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSYSDIFFREPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RepState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SysModelVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected boolean onMergeChild(String string, String string2, PSDevSysDiffRep pSDevSysDiffRep) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDevSysDiffRep)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSysDiffRep pSDevSysDiffRep) throws Exception {
        super.onUpdateParent((IEntity)pSDevSysDiffRep);
    }

    @Override
    protected void exportCurXmlModel(PSDevSysDiffRep pSDevSysDiffRep, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSYSDIFFREP");
        if (!bl) {
            pSDevSysDiffRep.setBeginTime(null);
            pSDevSysDiffRep.setDstSysModelVer(null);
            pSDevSysDiffRep.setEndTime(null);
            pSDevSysDiffRep.setRepState(null);
            pSDevSysDiffRep.setSysModelVer(null);
            super.exportCurXmlModel(pSDevSysDiffRep, xmlNode, bl);
        }
    }
}

