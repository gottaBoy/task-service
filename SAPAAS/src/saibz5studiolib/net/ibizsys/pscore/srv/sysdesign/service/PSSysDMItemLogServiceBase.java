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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysDMItemLogDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDMItemLogDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMItemLog;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMVerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfgBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDMItemLogServiceBase
extends PSCoreSysServiceBase<PSSysDMItemLog> {
    private static final Log log = LogFactory.getLog(PSSysDMItemLogServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysDMItemLogDEModel pSSysDMItemLogDEModel;
    private PSSysDMItemLogDAO pSSysDMItemLogDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemLogService";
    }

    public PSSysDMItemLogDEModel getPSSysDMItemLogDEModel() {
        if (this.pSSysDMItemLogDEModel == null) {
            try {
                this.pSSysDMItemLogDEModel = (PSSysDMItemLogDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDMItemLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDMItemLogDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysDMItemLogDEModel();
    }

    public PSSysDMItemLogDAO getPSSysDMItemLogDAO() {
        if (this.pSSysDMItemLogDAO == null) {
            try {
                this.pSSysDMItemLogDAO = (PSSysDMItemLogDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysDMItemLogDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDMItemLogDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysDMItemLogDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysDMItemLog pSSysDMItemLog, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDMITEMLOG_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysDMItemLog, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDMITEMLOG_PSSYSDMVER_PSSYSDMVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDMVerService", (SessionFactory)this.getSessionFactory());
            PSSysDMVer pSSysDMVer = (PSSysDMVer)iService.getDEModel().createEntity();
            pSSysDMVer.set("PSSYSDMVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDMVer);
            } else {
                iService.get((IEntity)pSSysDMVer);
            }
            this.onFillParentInfo_PSSysDMVer(pSSysDMItemLog, pSSysDMVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDMITEMLOG_PSSYSTEMDBCFG_PSSYSTEMDBCFGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService", (SessionFactory)this.getSessionFactory());
            PSSystemDBCfg pSSystemDBCfg = (PSSystemDBCfg)iService.getDEModel().createEntity();
            pSSystemDBCfg.set("PSSYSTEMDBCFGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystemDBCfg);
            } else {
                iService.get((IEntity)pSSystemDBCfg);
            }
            this.onFillParentInfo_PSSystemDBCfg(pSSysDMItemLog, pSSystemDBCfg);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysDMItemLog, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysDMItemLog pSSysDMItemLog, PSDataEntity pSDataEntity) throws Exception {
        pSSysDMItemLog.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysDMItemLog.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSSysDMVer(PSSysDMItemLog pSSysDMItemLog, PSSysDMVer pSSysDMVer) throws Exception {
        pSSysDMItemLog.setPSSysDMVerId(pSSysDMVer.getPSSysDMVerId());
        pSSysDMItemLog.setPSSysDMVerName(pSSysDMVer.getPSSysDMVerName());
    }

    protected void onFillParentInfo_PSSystemDBCfg(PSSysDMItemLog pSSysDMItemLog, PSSystemDBCfg pSSystemDBCfg) throws Exception {
        pSSysDMItemLog.setPSSystemDBCfgId(pSSystemDBCfg.getPSSystemDBCfgId());
        pSSysDMItemLog.setPSSystemDBCfgName(pSSystemDBCfg.getPSSystemDBCfgName());
    }

    protected void onFillEntityFullInfo(PSSysDMItemLog pSSysDMItemLog, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSysDMItemLog, bl);
        this.onFillEntityFullInfo_PSDE(pSSysDMItemLog, bl);
        this.onFillEntityFullInfo_PSSysDMVer(pSSysDMItemLog, bl);
        this.onFillEntityFullInfo_PSSystemDBCfg(pSSysDMItemLog, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysDMItemLog pSSysDMItemLog, boolean bl) throws Exception {
        if (pSSysDMItemLog.isPSDEIdDirty()) {
            if (pSSysDMItemLog.getPSDEId() != null) {
                if (pSSysDMItemLog.getPSDEId() == null || pSSysDMItemLog.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysDMItemLog.getPSDE();
                    pSSysDMItemLog.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysDMItemLog.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysDMVer(PSSysDMItemLog pSSysDMItemLog, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystemDBCfg(PSSysDMItemLog pSSysDMItemLog, boolean bl) throws Exception {
        if (pSSysDMItemLog.isPSSystemDBCfgIdDirty()) {
            if (pSSysDMItemLog.getPSSystemDBCfgId() != null) {
                if (pSSysDMItemLog.getPSSystemDBCfgId() == null || pSSysDMItemLog.getPSSystemDBCfgName() == null) {
                    PSSystemDBCfg pSSystemDBCfg = pSSysDMItemLog.getPSSystemDBCfg();
                    pSSysDMItemLog.setPSSystemDBCfgName(pSSystemDBCfg.getPSSystemDBCfgName());
                }
            } else {
                pSSysDMItemLog.setPSSystemDBCfgName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysDMItemLog pSSysDMItemLog, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysDMItemLog, bl);
    }

    public ArrayList<PSSysDMItemLog> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysDMItemLog> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysDMItemLog> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDMItemLog> selectByPSSysDMVer(PSSysDMVerBase pSSysDMVerBase) throws Exception {
        return this.selectByPSSysDMVer(pSSysDMVerBase, "", -1);
    }

    public ArrayList<PSSysDMItemLog> selectByPSSysDMVer(PSSysDMVerBase pSSysDMVerBase, String string) throws Exception {
        return this.selectByPSSysDMVer(pSSysDMVerBase, string, -1);
    }

    public ArrayList<PSSysDMItemLog> selectByPSSysDMVer(PSSysDMVerBase pSSysDMVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDMVERID", (Object)pSSysDMVerBase.getPSSysDMVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDMVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDMVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDMItemLog> selectByPSSystemDBCfg(PSSystemDBCfgBase pSSystemDBCfgBase) throws Exception {
        return this.selectByPSSystemDBCfg(pSSystemDBCfgBase, "", -1);
    }

    public ArrayList<PSSysDMItemLog> selectByPSSystemDBCfg(PSSystemDBCfgBase pSSystemDBCfgBase, String string) throws Exception {
        return this.selectByPSSystemDBCfg(pSSystemDBCfgBase, string, -1);
    }

    public ArrayList<PSSysDMItemLog> selectByPSSystemDBCfg(PSSystemDBCfgBase pSSystemDBCfgBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMDBCFGID", (Object)pSSystemDBCfgBase.getPSSystemDBCfgId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemDBCfgCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemDBCfgCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysDMItemLog> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDMITEMLOG_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSDMITEMLOG", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysDMItemLog> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysDMItemLog pSSysDMItemLog : arrayList) {
            PSSysDMItemLog pSSysDMItemLog2 = (PSSysDMItemLog)this.getDEModel().createEntity();
            pSSysDMItemLog2.setPSSysDMItemLogId(pSSysDMItemLog.getPSSysDMItemLogId());
            pSSysDMItemLog2.setPSDEId(null);
            this.update(pSSysDMItemLog2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDMItemLogServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysDMItemLogServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysDMItemLogServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysDMItemLog> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysDMItemLog pSSysDMItemLog : arrayList) {
            this.remove((IEntity)pSSysDMItemLog);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysDMItemLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysDMItemLog> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
        ArrayList<PSSysDMItemLog> arrayList = this.selectByPSSysDMVer(pSSysDMVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDMVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDMVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDMITEMLOG_PSSYSDMVER_PSSYSDMVERID", "", iDataEntityModel.getName(), "PSSYSDMITEMLOG", iDataEntityModel.getDataInfo((IEntity)pSSysDMVer), arrayList.get(0)));
        }
    }

    public void resetPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
        ArrayList<PSSysDMItemLog> arrayList = this.selectByPSSysDMVer(pSSysDMVer);
        for (PSSysDMItemLog pSSysDMItemLog : arrayList) {
            PSSysDMItemLog pSSysDMItemLog2 = (PSSysDMItemLog)this.getDEModel().createEntity();
            pSSysDMItemLog2.setPSSysDMItemLogId(pSSysDMItemLog.getPSSysDMItemLogId());
            pSSysDMItemLog2.setPSSysDMVerId(null);
            this.update(pSSysDMItemLog2);
        }
    }

    public void removeByPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
        final PSSysDMVer pSSysDMVer2 = pSSysDMVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDMItemLogServiceBase.this.onBeforeRemoveByPSSysDMVer(pSSysDMVer2);
                PSSysDMItemLogServiceBase.this.internalRemoveByPSSysDMVer(pSSysDMVer2);
                PSSysDMItemLogServiceBase.this.onAfterRemoveByPSSysDMVer(pSSysDMVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
    }

    protected void internalRemoveByPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
        ArrayList<PSSysDMItemLog> arrayList = this.selectByPSSysDMVer(pSSysDMVer);
        this.onBeforeRemoveByPSSysDMVer(pSSysDMVer, arrayList);
        for (PSSysDMItemLog pSSysDMItemLog : arrayList) {
            this.remove((IEntity)pSSysDMItemLog);
        }
        this.onAfterRemoveByPSSysDMVer(pSSysDMVer, arrayList);
    }

    protected void onAfterRemoveByPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDMVer(PSSysDMVer pSSysDMVer, ArrayList<PSSysDMItemLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDMVer(PSSysDMVer pSSysDMVer, ArrayList<PSSysDMItemLog> arrayList) throws Exception {
    }

    public void testRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
    }

    public void resetPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        ArrayList<PSSysDMItemLog> arrayList = this.selectByPSSystemDBCfg(pSSystemDBCfg);
        for (PSSysDMItemLog pSSysDMItemLog : arrayList) {
            PSSysDMItemLog pSSysDMItemLog2 = (PSSysDMItemLog)this.getDEModel().createEntity();
            pSSysDMItemLog2.setPSSysDMItemLogId(pSSysDMItemLog.getPSSysDMItemLogId());
            pSSysDMItemLog2.setPSSystemDBCfgId(null);
            this.update(pSSysDMItemLog2);
        }
    }

    public void removeByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        final PSSystemDBCfg pSSystemDBCfg2 = pSSystemDBCfg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDMItemLogServiceBase.this.onBeforeRemoveByPSSystemDBCfg(pSSystemDBCfg2);
                PSSysDMItemLogServiceBase.this.internalRemoveByPSSystemDBCfg(pSSystemDBCfg2);
                PSSysDMItemLogServiceBase.this.onAfterRemoveByPSSystemDBCfg(pSSystemDBCfg2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
    }

    protected void internalRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        ArrayList<PSSysDMItemLog> arrayList = this.selectByPSSystemDBCfg(pSSystemDBCfg);
        this.onBeforeRemoveByPSSystemDBCfg(pSSystemDBCfg, arrayList);
        for (PSSysDMItemLog pSSysDMItemLog : arrayList) {
            this.remove((IEntity)pSSysDMItemLog);
        }
        this.onAfterRemoveByPSSystemDBCfg(pSSystemDBCfg, arrayList);
    }

    protected void onAfterRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
    }

    protected void onBeforeRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg, ArrayList<PSSysDMItemLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg, ArrayList<PSSysDMItemLog> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysDMItemLog pSSysDMItemLog) throws Exception {
        super.onBeforeRemove(pSSysDMItemLog);
    }

    protected void replaceParentInfo(PSSysDMItemLog pSSysDMItemLog, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysDMItemLog, cloneSession);
        if (pSSysDMItemLog.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysDMItemLog.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysDMItemLog, (PSDataEntity)iEntity);
        }
        if (pSSysDMItemLog.getPSSysDMVerId() != null && (iEntity = cloneSession.getEntity("PSSYSDMVER", (Object)pSSysDMItemLog.getPSSysDMVerId())) != null) {
            this.onFillParentInfo_PSSysDMVer(pSSysDMItemLog, (PSSysDMVer)iEntity);
        }
        if (pSSysDMItemLog.getPSSystemDBCfgId() != null && (iEntity = cloneSession.getEntity("PSSYSTEMDBCFG", (Object)pSSysDMItemLog.getPSSystemDBCfgId())) != null) {
            this.onFillParentInfo_PSSystemDBCfg(pSSysDMItemLog, (PSSystemDBCfg)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysDMItemLog pSSysDMItemLog, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysDMItemLog, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysDMItemLog pSSysDMItemLog, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DBObjType(bl, pSSysDMItemLog, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FixSql(bl, pSSysDMItemLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysDMItemLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NewSql(bl, pSSysDMItemLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NewTag(bl, pSSysDMItemLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NewTag2(bl, pSSysDMItemLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OldSql(bl, pSSysDMItemLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OldTag(bl, pSSysDMItemLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OldTag2(bl, pSSysDMItemLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysDMItemLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysDMItemLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSOBJId(bl, pSSysDMItemLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSOBJName(bl, pSSysDMItemLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDMItemLogId(bl, pSSysDMItemLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDMItemLogName(bl, pSSysDMItemLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDMVerId(bl, pSSysDMItemLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemDBCfgId(bl, pSSysDMItemLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemDBCfgName(bl, pSSysDMItemLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysDBVer(bl, pSSysDMItemLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysDMItemLog, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DBObjType(boolean bl, PSSysDMItemLog pSSysDMItemLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItemLog.isDBObjTypeDirty() && !bl2 : !pSSysDMItemLog.isDBObjTypeDirty()) {
            return null;
        }
        String string = pSSysDMItemLog.getDBObjType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBOBJTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DBObjType_Default((IEntity)pSSysDMItemLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBOBJTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FixSql(boolean bl, PSSysDMItemLog pSSysDMItemLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItemLog.isFixSqlDirty() : !pSSysDMItemLog.isFixSqlDirty()) {
            return null;
        }
        String string = pSSysDMItemLog.getFixSql();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FixSql_Default((IEntity)pSSysDMItemLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIXSQL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysDMItemLog pSSysDMItemLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItemLog.isMemoDirty() : !pSSysDMItemLog.isMemoDirty()) {
            return null;
        }
        String string = pSSysDMItemLog.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysDMItemLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_NewSql(boolean bl, PSSysDMItemLog pSSysDMItemLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItemLog.isNewSqlDirty() : !pSSysDMItemLog.isNewSqlDirty()) {
            return null;
        }
        String string = pSSysDMItemLog.getNewSql();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NewSql_Default((IEntity)pSSysDMItemLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEWSQL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NewTag(boolean bl, PSSysDMItemLog pSSysDMItemLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItemLog.isNewTagDirty() : !pSSysDMItemLog.isNewTagDirty()) {
            return null;
        }
        String string = pSSysDMItemLog.getNewTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NewTag_Default((IEntity)pSSysDMItemLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEWTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NewTag2(boolean bl, PSSysDMItemLog pSSysDMItemLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItemLog.isNewTag2Dirty() : !pSSysDMItemLog.isNewTag2Dirty()) {
            return null;
        }
        String string = pSSysDMItemLog.getNewTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NewTag2_Default((IEntity)pSSysDMItemLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEWTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OldSql(boolean bl, PSSysDMItemLog pSSysDMItemLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItemLog.isOldSqlDirty() : !pSSysDMItemLog.isOldSqlDirty()) {
            return null;
        }
        String string = pSSysDMItemLog.getOldSql();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OldSql_Default((IEntity)pSSysDMItemLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OLDSQL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OldTag(boolean bl, PSSysDMItemLog pSSysDMItemLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItemLog.isOldTagDirty() : !pSSysDMItemLog.isOldTagDirty()) {
            return null;
        }
        String string = pSSysDMItemLog.getOldTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OldTag_Default((IEntity)pSSysDMItemLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OLDTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OldTag2(boolean bl, PSSysDMItemLog pSSysDMItemLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItemLog.isOldTag2Dirty() : !pSSysDMItemLog.isOldTag2Dirty()) {
            return null;
        }
        String string = pSSysDMItemLog.getOldTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OldTag2_Default((IEntity)pSSysDMItemLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OLDTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysDMItemLog pSSysDMItemLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItemLog.isPSDEIdDirty() : !pSSysDMItemLog.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysDMItemLog.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSSysDMItemLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysDMItemLog pSSysDMItemLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItemLog.isPSDENameDirty() : !pSSysDMItemLog.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysDMItemLog.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSSysDMItemLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSOBJId(boolean bl, PSSysDMItemLog pSSysDMItemLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItemLog.isPSOBJIdDirty() : !pSSysDMItemLog.isPSOBJIdDirty()) {
            return null;
        }
        String string = pSSysDMItemLog.getPSOBJId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSOBJId_Default((IEntity)pSSysDMItemLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSOBJName(boolean bl, PSSysDMItemLog pSSysDMItemLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItemLog.isPSOBJNameDirty() : !pSSysDMItemLog.isPSOBJNameDirty()) {
            return null;
        }
        String string = pSSysDMItemLog.getPSOBJName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSOBJName_Default((IEntity)pSSysDMItemLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDMItemLogId(boolean bl, PSSysDMItemLog pSSysDMItemLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItemLog.isPSSysDMItemLogIdDirty() && !bl2 : !pSSysDMItemLog.isPSSysDMItemLogIdDirty()) {
            return null;
        }
        String string = pSSysDMItemLog.getPSSysDMItemLogId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDMITEMLOGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDMItemLogId_Default((IEntity)pSSysDMItemLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDMITEMLOGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDMItemLogName(boolean bl, PSSysDMItemLog pSSysDMItemLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItemLog.isPSSysDMItemLogNameDirty() && !bl2 : !pSSysDMItemLog.isPSSysDMItemLogNameDirty()) {
            return null;
        }
        String string = pSSysDMItemLog.getPSSysDMItemLogName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDMITEMLOGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDMItemLogName_Default((IEntity)pSSysDMItemLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDMITEMLOGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDMVerId(boolean bl, PSSysDMItemLog pSSysDMItemLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItemLog.isPSSysDMVerIdDirty() : !pSSysDMItemLog.isPSSysDMVerIdDirty()) {
            return null;
        }
        String string = pSSysDMItemLog.getPSSysDMVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDMVerId_Default((IEntity)pSSysDMItemLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDMVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemDBCfgId(boolean bl, PSSysDMItemLog pSSysDMItemLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItemLog.isPSSystemDBCfgIdDirty() && !bl2 : !pSSysDMItemLog.isPSSystemDBCfgIdDirty()) {
            return null;
        }
        String string = pSSysDMItemLog.getPSSystemDBCfgId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMDBCFGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemDBCfgId_Default((IEntity)pSSysDMItemLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMDBCFGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemDBCfgName(boolean bl, PSSysDMItemLog pSSysDMItemLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItemLog.isPSSystemDBCfgNameDirty() && !bl2 : !pSSysDMItemLog.isPSSystemDBCfgNameDirty()) {
            return null;
        }
        String string = pSSysDMItemLog.getPSSystemDBCfgName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMDBCFGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemDBCfgName_Default((IEntity)pSSysDMItemLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMDBCFGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysDBVer(boolean bl, PSSysDMItemLog pSSysDMItemLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItemLog.isSysDBVerDirty() : !pSSysDMItemLog.isSysDBVerDirty()) {
            return null;
        }
        Integer n = pSSysDMItemLog.getSysDBVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysDBVer_Default((IEntity)pSSysDMItemLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSDBVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysDMItemLog pSSysDMItemLog, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysDMItemLog, bl);
    }

    protected void onSyncIndexEntities(PSSysDMItemLog pSSysDMItemLog, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysDMItemLog, bl);
    }

    public Object getDataContextValue(PSSysDMItemLog pSSysDMItemLog, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysDMItemLog, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysDMItemLog pSSysDMItemLog, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysDMItemLog, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBOBJTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBObjType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIXSQL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FixSql_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEWSQL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NewSql_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEWTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NewTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEWTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NewTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OLDSQL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OldSql_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OLDTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OldTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OLDTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OldTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSOBJId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSOBJName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDMITEMLOGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDMItemLogId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDMITEMLOGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDMItemLogName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDMVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDMVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDMVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDMVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMDBCFGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemDBCfgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMDBCFGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemDBCfgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSDBVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysDBVer_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DBObjType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DBOBJTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FixSql_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIXSQL", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected String onTestValueRule_NewSql_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEWSQL", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NewTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEWTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NewTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEWTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OldSql_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OLDSQL", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OldTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OLDTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OldTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OLDTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSOBJId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSOBJName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDMItemLogId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDMITEMLOGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDMItemLogName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDMITEMLOGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDMVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDMVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDMVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDMVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemDBCfgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMDBCFGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemDBCfgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMDBCFGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysDBVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected boolean onMergeChild(String string, String string2, PSSysDMItemLog pSSysDMItemLog) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysDMItemLog)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysDMItemLog pSSysDMItemLog) throws Exception {
        super.onUpdateParent((IEntity)pSSysDMItemLog);
    }

    @Override
    protected void exportCurXmlModel(PSSysDMItemLog pSSysDMItemLog, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSDMITEMLOG");
        if (!bl) {
            pSSysDMItemLog.setCreateDate(null);
            pSSysDMItemLog.setCreateMan(null);
            pSSysDMItemLog.setDBObjType(null);
            pSSysDMItemLog.setNewSql(null);
            pSSysDMItemLog.setOldSql(null);
            pSSysDMItemLog.setPSDEId(null);
            pSSysDMItemLog.setPSDEName(null);
            pSSysDMItemLog.setPSOBJId(null);
            pSSysDMItemLog.setPSOBJName(null);
            pSSysDMItemLog.setPSSysDMItemLogId(null);
            pSSysDMItemLog.setPSSysDMItemLogName(null);
            pSSysDMItemLog.setPSSysDMVerId(null);
            pSSysDMItemLog.setPSSysDMVerName(null);
            pSSysDMItemLog.setPSSystemDBCfgId(null);
            pSSysDMItemLog.setPSSystemDBCfgName(null);
            pSSysDMItemLog.setSysDBVer(null);
            pSSysDMItemLog.setUpdateDate(null);
            pSSysDMItemLog.setUpdateMan(null);
            super.exportCurXmlModel(pSSysDMItemLog, xmlNode, bl);
        }
    }
}

