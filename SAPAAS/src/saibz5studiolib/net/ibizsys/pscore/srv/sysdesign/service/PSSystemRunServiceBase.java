/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
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

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
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
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDInstCfg;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDInstCfgBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSystemRunDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSystemRunDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPubBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemAS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemASBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfgBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemRun;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSystemRunServiceBase
extends PSCoreSysServiceBase<PSSystemRun> {
    private static final Log log = LogFactory.getLog(PSSystemRunServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSystemRunDEModel pSSystemRunDEModel;
    private PSSystemRunDAO pSSystemRunDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSystemRunService";
    }

    public PSSystemRunDEModel getPSSystemRunDEModel() {
        if (this.pSSystemRunDEModel == null) {
            try {
                this.pSSystemRunDEModel = (PSSystemRunDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSystemRunDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSystemRunDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSystemRunDEModel();
    }

    public PSSystemRunDAO getPSSystemRunDAO() {
        if (this.pSSystemRunDAO == null) {
            try {
                this.pSSystemRunDAO = (PSSystemRunDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSystemRunDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSystemRunDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSystemRunDAO();
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

    protected void onFillParentInfo(PSSystemRun pSSystemRun, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTEMRUN_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysApp);
            } else {
                iService.get((IEntity)pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSSystemRun, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTEMRUN_PSSYSAPP_PSSYSAPPID2", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysApp);
            } else {
                iService.get((IEntity)pSSysApp);
            }
            this.onFillParentInfo_PSSysApp2(pSSystemRun, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTEMRUN_PSSYSBDINSTCFG_PSSYSBDINSTCFGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDInstCfgService", (SessionFactory)this.getSessionFactory());
            PSSysBDInstCfg pSSysBDInstCfg = (PSSysBDInstCfg)iService.getDEModel().createEntity();
            pSSysBDInstCfg.set("PSSYSBDINSTCFGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBDInstCfg);
            } else {
                iService.get((IEntity)pSSysBDInstCfg);
            }
            this.onFillParentInfo_PSSysBDInstCfg(pSSystemRun, pSSysBDInstCfg);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTEMRUN_PSSYSDYNAMODEL_RUNPSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_RunPSSysDynaModel(pSSystemRun, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTEMRUN_PSSYSSFPUB_PSSYSSFPUBID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService", (SessionFactory)this.getSessionFactory());
            PSSysSFPub pSSysSFPub = (PSSysSFPub)iService.getDEModel().createEntity();
            pSSysSFPub.set("PSSYSSFPUBID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPub);
            } else {
                iService.get((IEntity)pSSysSFPub);
            }
            this.onFillParentInfo_PSSysSFPub(pSSystemRun, pSSysSFPub);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTEMRUN_PSSYSTEMAS_PSSYSTEMASID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemASService", (SessionFactory)this.getSessionFactory());
            PSSystemAS pSSystemAS = (PSSystemAS)iService.getDEModel().createEntity();
            pSSystemAS.set("PSSYSTEMASID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystemAS);
            } else {
                iService.get((IEntity)pSSystemAS);
            }
            this.onFillParentInfo_PSSystemAS(pSSystemRun, pSSystemAS);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTEMRUN_PSSYSTEMDBCFG_PSSYSTEMDBCFGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService", (SessionFactory)this.getSessionFactory());
            PSSystemDBCfg pSSystemDBCfg = (PSSystemDBCfg)iService.getDEModel().createEntity();
            pSSystemDBCfg.set("PSSYSTEMDBCFGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystemDBCfg);
            } else {
                iService.get((IEntity)pSSystemDBCfg);
            }
            this.onFillParentInfo_PSSystemDBCfg(pSSystemRun, pSSystemDBCfg);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTEMRUN_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSystemRun, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSSystemRun, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysApp(PSSystemRun pSSystemRun, PSSysApp pSSysApp) throws Exception {
        pSSystemRun.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSSystemRun.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_PSSysApp2(PSSystemRun pSSystemRun, PSSysApp pSSysApp) throws Exception {
        pSSystemRun.setPSSysAppId2(pSSysApp.getPSSysAppId());
        pSSystemRun.setPSSysAppName2(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_PSSysBDInstCfg(PSSystemRun pSSystemRun, PSSysBDInstCfg pSSysBDInstCfg) throws Exception {
        pSSystemRun.setPSSysBDInstCfgId(pSSysBDInstCfg.getPSSysBDInstCfgId());
        pSSystemRun.setPSSysBDInstCfgName(pSSysBDInstCfg.getPSSysBDInstCfgName());
    }

    protected void onFillParentInfo_RunPSSysDynaModel(PSSystemRun pSSystemRun, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSystemRun.setRunPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSystemRun.setRunPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysSFPub(PSSystemRun pSSystemRun, PSSysSFPub pSSysSFPub) throws Exception {
        pSSystemRun.setPSSysSFPubId(pSSysSFPub.getPSSysSFPubId());
        pSSystemRun.setPSSysSFPubName(pSSysSFPub.getPSSysSFPubName());
    }

    protected void onFillParentInfo_PSSystemAS(PSSystemRun pSSystemRun, PSSystemAS pSSystemAS) throws Exception {
        pSSystemRun.setPSSystemASId(pSSystemAS.getPSSystemASId());
        pSSystemRun.setPSSystemASName(pSSystemAS.getPSSystemASName());
    }

    protected void onFillParentInfo_PSSystemDBCfg(PSSystemRun pSSystemRun, PSSystemDBCfg pSSystemDBCfg) throws Exception {
        pSSystemRun.setPSSystemDBCfgId(pSSystemDBCfg.getPSSystemDBCfgId());
        pSSystemRun.setPSSystemDBCfgName(pSSystemDBCfg.getPSSystemDBCfgName());
    }

    protected void onFillParentInfo_PSSystem(PSSystemRun pSSystemRun, PSSystem pSSystem) throws Exception {
        pSSystemRun.setPSSystemId(pSSystem.getPSSystemId());
        pSSystemRun.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSystemRun pSSystemRun, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSystemRun, bl);
        this.onFillEntityFullInfo_PSSysApp(pSSystemRun, bl);
        this.onFillEntityFullInfo_PSSysApp2(pSSystemRun, bl);
        this.onFillEntityFullInfo_PSSysBDInstCfg(pSSystemRun, bl);
        this.onFillEntityFullInfo_RunPSSysDynaModel(pSSystemRun, bl);
        this.onFillEntityFullInfo_PSSysSFPub(pSSystemRun, bl);
        this.onFillEntityFullInfo_PSSystemAS(pSSystemRun, bl);
        this.onFillEntityFullInfo_PSSystemDBCfg(pSSystemRun, bl);
        this.onFillEntityFullInfo_PSSystem(pSSystemRun, bl);
    }

    protected void onFillEntityFullInfo_PSSysApp(PSSystemRun pSSystemRun, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysApp2(PSSystemRun pSSystemRun, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBDInstCfg(PSSystemRun pSSystemRun, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RunPSSysDynaModel(PSSystemRun pSSystemRun, boolean bl) throws Exception {
        if (pSSystemRun.isRunPSSysDynaModelIdDirty()) {
            if (pSSystemRun.getRunPSSysDynaModelId() != null) {
                if (pSSystemRun.getRunPSSysDynaModelId() == null || pSSystemRun.getRunPSSysDynaModelName() == null) {
                    PSSysDynaModel pSSysDynaModel = pSSystemRun.getRunPSSysDynaModel();
                    pSSystemRun.setRunPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
                }
            } else {
                pSSystemRun.setRunPSSysDynaModelName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysSFPub(PSSystemRun pSSystemRun, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystemAS(PSSystemRun pSSystemRun, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystemDBCfg(PSSystemRun pSSystemRun, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSystemRun pSSystemRun, boolean bl) throws Exception {
        if (pSSystemRun.isPSSystemIdDirty()) {
            if (pSSystemRun.getPSSystemId() != null) {
                if (pSSystemRun.getPSSystemId() == null || pSSystemRun.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSystemRun.getPSSystem();
                    pSSystemRun.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSystemRun.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSystemRun pSSystemRun, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSystemRun, bl);
    }

    public ArrayList<PSSystemRun> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSSystemRun> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSSystemRun> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAPPID", (Object)pSSysAppBase.getPSSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSystemRun> selectByPSSysApp2(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp2(pSSysAppBase, "", -1);
    }

    public ArrayList<PSSystemRun> selectByPSSysApp2(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp2(pSSysAppBase, string, -1);
    }

    public ArrayList<PSSystemRun> selectByPSSysApp2(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAPPID2", (Object)pSSysAppBase.getPSSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysApp2Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysApp2Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSystemRun> selectByPSSysBDInstCfg(PSSysBDInstCfgBase pSSysBDInstCfgBase) throws Exception {
        return this.selectByPSSysBDInstCfg(pSSysBDInstCfgBase, "", -1);
    }

    public ArrayList<PSSystemRun> selectByPSSysBDInstCfg(PSSysBDInstCfgBase pSSysBDInstCfgBase, String string) throws Exception {
        return this.selectByPSSysBDInstCfg(pSSysBDInstCfgBase, string, -1);
    }

    public ArrayList<PSSystemRun> selectByPSSysBDInstCfg(PSSysBDInstCfgBase pSSysBDInstCfgBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBDINSTCFGID", (Object)pSSysBDInstCfgBase.getPSSysBDInstCfgId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBDInstCfgCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBDInstCfgCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSystemRun> selectByRunPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByRunPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSystemRun> selectByRunPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByRunPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSystemRun> selectByRunPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("RUNPSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRunPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRunPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSystemRun> selectByPSSysSFPub(PSSysSFPubBase pSSysSFPubBase) throws Exception {
        return this.selectByPSSysSFPub(pSSysSFPubBase, "", -1);
    }

    public ArrayList<PSSystemRun> selectByPSSysSFPub(PSSysSFPubBase pSSysSFPubBase, String string) throws Exception {
        return this.selectByPSSysSFPub(pSSysSFPubBase, string, -1);
    }

    public ArrayList<PSSystemRun> selectByPSSysSFPub(PSSysSFPubBase pSSysSFPubBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSFPUBID", (Object)pSSysSFPubBase.getPSSysSFPubId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSFPubCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSFPubCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSystemRun> selectByPSSystemAS(PSSystemASBase pSSystemASBase) throws Exception {
        return this.selectByPSSystemAS(pSSystemASBase, "", -1);
    }

    public ArrayList<PSSystemRun> selectByPSSystemAS(PSSystemASBase pSSystemASBase, String string) throws Exception {
        return this.selectByPSSystemAS(pSSystemASBase, string, -1);
    }

    public ArrayList<PSSystemRun> selectByPSSystemAS(PSSystemASBase pSSystemASBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMASID", (Object)pSSystemASBase.getPSSystemASId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemASCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemASCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSystemRun> selectByPSSystemDBCfg(PSSystemDBCfgBase pSSystemDBCfgBase) throws Exception {
        return this.selectByPSSystemDBCfg(pSSystemDBCfgBase, "", -1);
    }

    public ArrayList<PSSystemRun> selectByPSSystemDBCfg(PSSystemDBCfgBase pSSystemDBCfgBase, String string) throws Exception {
        return this.selectByPSSystemDBCfg(pSSystemDBCfgBase, string, -1);
    }

    public ArrayList<PSSystemRun> selectByPSSystemDBCfg(PSSystemDBCfgBase pSSystemDBCfgBase, String string, int n) throws Exception {
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

    public ArrayList<PSSystemRun> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSystemRun> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSystemRun> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMID", (Object)pSSystemBase.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByPSSysApp(pSSysApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTEMRUN_PSSYSAPP_PSSYSAPPID", "", iDataEntityModel.getName(), "PSSYSTEMRUN", iDataEntityModel.getDataInfo((IEntity)pSSysApp), arrayList.get(0)));
        }
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSSystemRun pSSystemRun : arrayList) {
            PSSystemRun pSSystemRun2 = (PSSystemRun)this.getDEModel().createEntity();
            pSSystemRun2.setPSSystemRunId(pSSystemRun.getPSSystemRunId());
            pSSystemRun2.setPSSysAppId(null);
            this.update(pSSystemRun2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSystemRunServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSSystemRunServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSSystemRunServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSSystemRun pSSystemRun : arrayList) {
            this.remove((IEntity)pSSystemRun);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSSystemRun> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSSystemRun> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp2(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByPSSysApp2(pSSysApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTEMRUN_PSSYSAPP_PSSYSAPPID2", "", iDataEntityModel.getName(), "PSSYSTEMRUN", iDataEntityModel.getDataInfo((IEntity)pSSysApp), arrayList.get(0)));
        }
    }

    public void resetPSSysApp2(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByPSSysApp2(pSSysApp);
        for (PSSystemRun pSSystemRun : arrayList) {
            PSSystemRun pSSystemRun2 = (PSSystemRun)this.getDEModel().createEntity();
            pSSystemRun2.setPSSystemRunId(pSSystemRun.getPSSystemRunId());
            pSSystemRun2.setPSSysAppId2(null);
            this.update(pSSystemRun2);
        }
    }

    public void removeByPSSysApp2(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSystemRunServiceBase.this.onBeforeRemoveByPSSysApp2(pSSysApp2);
                PSSystemRunServiceBase.this.internalRemoveByPSSysApp2(pSSysApp2);
                PSSystemRunServiceBase.this.onAfterRemoveByPSSysApp2(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp2(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp2(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByPSSysApp2(pSSysApp);
        this.onBeforeRemoveByPSSysApp2(pSSysApp, arrayList);
        for (PSSystemRun pSSystemRun : arrayList) {
            this.remove((IEntity)pSSystemRun);
        }
        this.onAfterRemoveByPSSysApp2(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp2(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp2(PSSysApp pSSysApp, ArrayList<PSSystemRun> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp2(PSSysApp pSSysApp, ArrayList<PSSystemRun> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBDInstCfg(PSSysBDInstCfg pSSysBDInstCfg) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByPSSysBDInstCfg(pSSysBDInstCfg, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBDINSTCFG");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysBDInstCfg);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTEMRUN_PSSYSBDINSTCFG_PSSYSBDINSTCFGID", "", iDataEntityModel.getName(), "PSSYSTEMRUN", iDataEntityModel.getDataInfo((IEntity)pSSysBDInstCfg), arrayList.get(0)));
        }
    }

    public void resetPSSysBDInstCfg(PSSysBDInstCfg pSSysBDInstCfg) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByPSSysBDInstCfg(pSSysBDInstCfg);
        for (PSSystemRun pSSystemRun : arrayList) {
            PSSystemRun pSSystemRun2 = (PSSystemRun)this.getDEModel().createEntity();
            pSSystemRun2.setPSSystemRunId(pSSystemRun.getPSSystemRunId());
            pSSystemRun2.setPSSysBDInstCfgId(null);
            this.update(pSSystemRun2);
        }
    }

    public void removeByPSSysBDInstCfg(PSSysBDInstCfg pSSysBDInstCfg) throws Exception {
        final PSSysBDInstCfg pSSysBDInstCfg2 = pSSysBDInstCfg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSystemRunServiceBase.this.onBeforeRemoveByPSSysBDInstCfg(pSSysBDInstCfg2);
                PSSystemRunServiceBase.this.internalRemoveByPSSysBDInstCfg(pSSysBDInstCfg2);
                PSSystemRunServiceBase.this.onAfterRemoveByPSSysBDInstCfg(pSSysBDInstCfg2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBDInstCfg(PSSysBDInstCfg pSSysBDInstCfg) throws Exception {
    }

    protected void internalRemoveByPSSysBDInstCfg(PSSysBDInstCfg pSSysBDInstCfg) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByPSSysBDInstCfg(pSSysBDInstCfg);
        this.onBeforeRemoveByPSSysBDInstCfg(pSSysBDInstCfg, arrayList);
        for (PSSystemRun pSSystemRun : arrayList) {
            this.remove((IEntity)pSSystemRun);
        }
        this.onAfterRemoveByPSSysBDInstCfg(pSSysBDInstCfg, arrayList);
    }

    protected void onAfterRemoveByPSSysBDInstCfg(PSSysBDInstCfg pSSysBDInstCfg) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBDInstCfg(PSSysBDInstCfg pSSysBDInstCfg, ArrayList<PSSystemRun> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBDInstCfg(PSSysBDInstCfg pSSysBDInstCfg, ArrayList<PSSystemRun> arrayList) throws Exception {
    }

    public void testRemoveByRunPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByRunPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTEMRUN_PSSYSDYNAMODEL_RUNPSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSTEMRUN", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetRunPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByRunPSSysDynaModel(pSSysDynaModel);
        for (PSSystemRun pSSystemRun : arrayList) {
            PSSystemRun pSSystemRun2 = (PSSystemRun)this.getDEModel().createEntity();
            pSSystemRun2.setPSSystemRunId(pSSystemRun.getPSSystemRunId());
            pSSystemRun2.setRunPSSysDynaModelId(null);
            this.update(pSSystemRun2);
        }
    }

    public void removeByRunPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSystemRunServiceBase.this.onBeforeRemoveByRunPSSysDynaModel(pSSysDynaModel2);
                PSSystemRunServiceBase.this.internalRemoveByRunPSSysDynaModel(pSSysDynaModel2);
                PSSystemRunServiceBase.this.onAfterRemoveByRunPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByRunPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByRunPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByRunPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByRunPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSystemRun pSSystemRun : arrayList) {
            this.remove((IEntity)pSSystemRun);
        }
        this.onAfterRemoveByRunPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByRunPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByRunPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSystemRun> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRunPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSystemRun> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByPSSysSFPub(pSSysSFPub, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPUB");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPub);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTEMRUN_PSSYSSFPUB_PSSYSSFPUBID", "", iDataEntityModel.getName(), "PSSYSTEMRUN", iDataEntityModel.getDataInfo((IEntity)pSSysSFPub), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByPSSysSFPub(pSSysSFPub);
        for (PSSystemRun pSSystemRun : arrayList) {
            PSSystemRun pSSystemRun2 = (PSSystemRun)this.getDEModel().createEntity();
            pSSystemRun2.setPSSystemRunId(pSSystemRun.getPSSystemRunId());
            pSSystemRun2.setPSSysSFPubId(null);
            this.update(pSSystemRun2);
        }
    }

    public void removeByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        final PSSysSFPub pSSysSFPub2 = pSSysSFPub;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSystemRunServiceBase.this.onBeforeRemoveByPSSysSFPub(pSSysSFPub2);
                PSSystemRunServiceBase.this.internalRemoveByPSSysSFPub(pSSysSFPub2);
                PSSystemRunServiceBase.this.onAfterRemoveByPSSysSFPub(pSSysSFPub2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    protected void internalRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByPSSysSFPub(pSSysSFPub);
        this.onBeforeRemoveByPSSysSFPub(pSSysSFPub, arrayList);
        for (PSSystemRun pSSystemRun : arrayList) {
            this.remove((IEntity)pSSystemRun);
        }
        this.onAfterRemoveByPSSysSFPub(pSSysSFPub, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub, ArrayList<PSSystemRun> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub, ArrayList<PSSystemRun> arrayList) throws Exception {
    }

    public void testRemoveByPSSystemAS(PSSystemAS pSSystemAS) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByPSSystemAS(pSSystemAS, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEMAS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSystemAS);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTEMRUN_PSSYSTEMAS_PSSYSTEMASID", "", iDataEntityModel.getName(), "PSSYSTEMRUN", iDataEntityModel.getDataInfo((IEntity)pSSystemAS), arrayList.get(0)));
        }
    }

    public void resetPSSystemAS(PSSystemAS pSSystemAS) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByPSSystemAS(pSSystemAS);
        for (PSSystemRun pSSystemRun : arrayList) {
            PSSystemRun pSSystemRun2 = (PSSystemRun)this.getDEModel().createEntity();
            pSSystemRun2.setPSSystemRunId(pSSystemRun.getPSSystemRunId());
            pSSystemRun2.setPSSystemASId(null);
            this.update(pSSystemRun2);
        }
    }

    public void removeByPSSystemAS(PSSystemAS pSSystemAS) throws Exception {
        final PSSystemAS pSSystemAS2 = pSSystemAS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSystemRunServiceBase.this.onBeforeRemoveByPSSystemAS(pSSystemAS2);
                PSSystemRunServiceBase.this.internalRemoveByPSSystemAS(pSSystemAS2);
                PSSystemRunServiceBase.this.onAfterRemoveByPSSystemAS(pSSystemAS2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystemAS(PSSystemAS pSSystemAS) throws Exception {
    }

    protected void internalRemoveByPSSystemAS(PSSystemAS pSSystemAS) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByPSSystemAS(pSSystemAS);
        this.onBeforeRemoveByPSSystemAS(pSSystemAS, arrayList);
        for (PSSystemRun pSSystemRun : arrayList) {
            this.remove((IEntity)pSSystemRun);
        }
        this.onAfterRemoveByPSSystemAS(pSSystemAS, arrayList);
    }

    protected void onAfterRemoveByPSSystemAS(PSSystemAS pSSystemAS) throws Exception {
    }

    protected void onBeforeRemoveByPSSystemAS(PSSystemAS pSSystemAS, ArrayList<PSSystemRun> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystemAS(PSSystemAS pSSystemAS, ArrayList<PSSystemRun> arrayList) throws Exception {
    }

    public void testRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByPSSystemDBCfg(pSSystemDBCfg, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEMDBCFG");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSystemDBCfg);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTEMRUN_PSSYSTEMDBCFG_PSSYSTEMDBCFGID", "", iDataEntityModel.getName(), "PSSYSTEMRUN", iDataEntityModel.getDataInfo((IEntity)pSSystemDBCfg), arrayList.get(0)));
        }
    }

    public void resetPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByPSSystemDBCfg(pSSystemDBCfg);
        for (PSSystemRun pSSystemRun : arrayList) {
            PSSystemRun pSSystemRun2 = (PSSystemRun)this.getDEModel().createEntity();
            pSSystemRun2.setPSSystemRunId(pSSystemRun.getPSSystemRunId());
            pSSystemRun2.setPSSystemDBCfgId(null);
            this.update(pSSystemRun2);
        }
    }

    public void removeByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        final PSSystemDBCfg pSSystemDBCfg2 = pSSystemDBCfg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSystemRunServiceBase.this.onBeforeRemoveByPSSystemDBCfg(pSSystemDBCfg2);
                PSSystemRunServiceBase.this.internalRemoveByPSSystemDBCfg(pSSystemDBCfg2);
                PSSystemRunServiceBase.this.onAfterRemoveByPSSystemDBCfg(pSSystemDBCfg2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
    }

    protected void internalRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByPSSystemDBCfg(pSSystemDBCfg);
        this.onBeforeRemoveByPSSystemDBCfg(pSSystemDBCfg, arrayList);
        for (PSSystemRun pSSystemRun : arrayList) {
            this.remove((IEntity)pSSystemRun);
        }
        this.onAfterRemoveByPSSystemDBCfg(pSSystemDBCfg, arrayList);
    }

    protected void onAfterRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
    }

    protected void onBeforeRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg, ArrayList<PSSystemRun> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg, ArrayList<PSSystemRun> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSystemRun pSSystemRun : arrayList) {
            PSSystemRun pSSystemRun2 = (PSSystemRun)this.getDEModel().createEntity();
            pSSystemRun2.setPSSystemRunId(pSSystemRun.getPSSystemRunId());
            pSSystemRun2.setPSSystemId(null);
            this.update(pSSystemRun2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSystemRunServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSystemRunServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSystemRunServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSystemRun> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSystemRun pSSystemRun : arrayList) {
            this.remove((IEntity)pSSystemRun);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSystemRun> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSystemRun> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSystemRun pSSystemRun) throws Exception {
        super.onBeforeRemove(pSSystemRun);
    }

    protected void replaceParentInfo(PSSystemRun pSSystemRun, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSystemRun, cloneSession);
        if (pSSystemRun.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSSystemRun.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSSystemRun, (PSSysApp)iEntity);
        }
        if (pSSystemRun.getPSSysAppId2() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSSystemRun.getPSSysAppId2())) != null) {
            this.onFillParentInfo_PSSysApp2(pSSystemRun, (PSSysApp)iEntity);
        }
        if (pSSystemRun.getPSSysBDInstCfgId() != null && (iEntity = cloneSession.getEntity("PSSYSBDINSTCFG", (Object)pSSystemRun.getPSSysBDInstCfgId())) != null) {
            this.onFillParentInfo_PSSysBDInstCfg(pSSystemRun, (PSSysBDInstCfg)iEntity);
        }
        if (pSSystemRun.getRunPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSystemRun.getRunPSSysDynaModelId())) != null) {
            this.onFillParentInfo_RunPSSysDynaModel(pSSystemRun, (PSSysDynaModel)iEntity);
        }
        if (pSSystemRun.getPSSysSFPubId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPUB", (Object)pSSystemRun.getPSSysSFPubId())) != null) {
            this.onFillParentInfo_PSSysSFPub(pSSystemRun, (PSSysSFPub)iEntity);
        }
        if (pSSystemRun.getPSSystemASId() != null && (iEntity = cloneSession.getEntity("PSSYSTEMAS", (Object)pSSystemRun.getPSSystemASId())) != null) {
            this.onFillParentInfo_PSSystemAS(pSSystemRun, (PSSystemAS)iEntity);
        }
        if (pSSystemRun.getPSSystemDBCfgId() != null && (iEntity = cloneSession.getEntity("PSSYSTEMDBCFG", (Object)pSSystemRun.getPSSystemDBCfgId())) != null) {
            this.onFillParentInfo_PSSystemDBCfg(pSSystemRun, (PSSystemDBCfg)iEntity);
        }
        if (pSSystemRun.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSystemRun.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSystemRun, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSystemRun pSSystemRun, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSystemRun, bl);
    }

    protected void onCheckEntity(boolean bl, PSSystemRun pSSystemRun, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DefaultFlag(bl, pSSystemRun, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSystemRun, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSSystemRun, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId2(bl, pSSystemRun, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDInstCfgId(bl, pSSystemRun, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPubId(bl, pSSystemRun, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemASId(bl, pSSystemRun, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemDBCfgId(bl, pSSystemRun, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSystemRun, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSystemRun, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemRunId(bl, pSSystemRun, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemRunName(bl, pSSystemRun, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RunPSSysDynaModelId(bl, pSSystemRun, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RunPSSysDynaModelName(bl, pSSystemRun, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StopWhenTemplError(bl, pSSystemRun, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSystemRun, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSSystemRun pSSystemRun, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemRun.isDefaultFlagDirty() && !bl2 : !pSSystemRun.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSSystemRun.getDefaultFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSSystemRun, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSSYSTEMID";
                String string2 = this.checkFieldDupRule(this.getPSSystemRunDEModel(), "DEFAULTFLAG", string, pSSystemRun, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DEFAULTFLAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSystemRun pSSystemRun, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemRun.isMemoDirty() : !pSSystemRun.isMemoDirty()) {
            return null;
        }
        String string = pSSystemRun.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSystemRun, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSSystemRun pSSystemRun, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemRun.isPSSysAppIdDirty() : !pSSystemRun.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSSystemRun.getPSSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default((IEntity)pSSystemRun, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId2(boolean bl, PSSystemRun pSSystemRun, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemRun.isPSSysAppId2Dirty() : !pSSystemRun.isPSSysAppId2Dirty()) {
            return null;
        }
        String string = pSSystemRun.getPSSysAppId2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId2_Default((IEntity)pSSystemRun, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDInstCfgId(boolean bl, PSSystemRun pSSystemRun, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemRun.isPSSysBDInstCfgIdDirty() : !pSSystemRun.isPSSysBDInstCfgIdDirty()) {
            return null;
        }
        String string = pSSystemRun.getPSSysBDInstCfgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDInstCfgId_Default((IEntity)pSSystemRun, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDINSTCFGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPubId(boolean bl, PSSystemRun pSSystemRun, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemRun.isPSSysSFPubIdDirty() : !pSSystemRun.isPSSysSFPubIdDirty()) {
            return null;
        }
        String string = pSSystemRun.getPSSysSFPubId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPubId_Default((IEntity)pSSystemRun, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemASId(boolean bl, PSSystemRun pSSystemRun, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemRun.isPSSystemASIdDirty() : !pSSystemRun.isPSSystemASIdDirty()) {
            return null;
        }
        String string = pSSystemRun.getPSSystemASId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemASId_Default((IEntity)pSSystemRun, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMASID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemDBCfgId(boolean bl, PSSystemRun pSSystemRun, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemRun.isPSSystemDBCfgIdDirty() : !pSSystemRun.isPSSystemDBCfgIdDirty()) {
            return null;
        }
        String string = pSSystemRun.getPSSystemDBCfgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemDBCfgId_Default((IEntity)pSSystemRun, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSystemRun pSSystemRun, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemRun.isPSSystemIdDirty() : !pSSystemRun.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSystemRun.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSystemRun, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSystemRun pSSystemRun, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemRun.isPSSystemNameDirty() && !bl2 : !pSSystemRun.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSystemRun.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSystemRun, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemRunId(boolean bl, PSSystemRun pSSystemRun, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemRun.isPSSystemRunIdDirty() && !bl2 : !pSSystemRun.isPSSystemRunIdDirty()) {
            return null;
        }
        String string = pSSystemRun.getPSSystemRunId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMRUNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemRunId_Default((IEntity)pSSystemRun, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMRUNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemRunName(boolean bl, PSSystemRun pSSystemRun, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemRun.isPSSystemRunNameDirty() && !bl2 : !pSSystemRun.isPSSystemRunNameDirty()) {
            return null;
        }
        String string = pSSystemRun.getPSSystemRunName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMRUNNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemRunName_Default((IEntity)pSSystemRun, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMRUNNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSystemRunDEModel(), "PSSYSTEMRUNNAME", string3, pSSystemRun, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSTEMRUNNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RunPSSysDynaModelId(boolean bl, PSSystemRun pSSystemRun, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemRun.isRunPSSysDynaModelIdDirty() : !pSSystemRun.isRunPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSystemRun.getRunPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RunPSSysDynaModelId_Default((IEntity)pSSystemRun, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RUNPSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RunPSSysDynaModelName(boolean bl, PSSystemRun pSSystemRun, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemRun.isRunPSSysDynaModelNameDirty() : !pSSystemRun.isRunPSSysDynaModelNameDirty()) {
            return null;
        }
        String string = pSSystemRun.getRunPSSysDynaModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RunPSSysDynaModelName_Default((IEntity)pSSystemRun, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RUNPSSYSDYNAMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StopWhenTemplError(boolean bl, PSSystemRun pSSystemRun, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemRun.isStopWhenTemplErrorDirty() : !pSSystemRun.isStopWhenTemplErrorDirty()) {
            return null;
        }
        Integer n = pSSystemRun.getStopWhenTemplError();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StopWhenTemplError_Default((IEntity)pSSystemRun, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STOPWHENTEMPLERROR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSystemRun pSSystemRun, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSystemRun, bl);
    }

    protected void onSyncIndexEntities(PSSystemRun pSSystemRun, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSystemRun, bl);
    }

    public Object getDataContextValue(PSSystemRun pSSystemRun, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSystemRun, string, iDataContextParam)) != null) {
            return object;
        }
        PSSystem pSSystem = pSSystemRun.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSystemRun pSSystemRun, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSystemRun, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDINSTCFGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDInstCfgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDINSTCFGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDInstCfgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUBID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPubId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUBNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPubName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMASID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemASId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMASNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemASName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMDBCFGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemDBCfgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMDBCFGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemDBCfgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMRUNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemRunId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMRUNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemRunName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RUNPSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RunPSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RUNPSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RunPSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STOPWHENTEMPLERROR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StopWhenTemplError_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppId2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPID2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppName2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPNAME2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDInstCfgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDINSTCFGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDInstCfgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDINSTCFGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPubId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPUBID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPubName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPUBNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemASId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMASID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemASName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMASNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemRunId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMRUNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemRunName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMRUNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RunPSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RUNPSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RunPSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RUNPSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StopWhenTemplError_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSystemRun pSSystemRun) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSystemRun)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSystemRun pSSystemRun) throws Exception {
        super.onUpdateParent((IEntity)pSSystemRun);
    }

    @Override
    protected void exportCurXmlModel(PSSystemRun pSSystemRun, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSTEMRUN");
        if (!bl) {
            pSSystemRun.setPSSysBDInstCfgName(null);
            super.exportCurXmlModel(pSSystemRun, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSystemRun pSSystemRun, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSystemRun, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTEM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSTEMRUN_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSTEM", (boolean)true) == 0) {
            iEntity.set("PSSYSTEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSystemRun pSSystemRun) {
        if (!StringHelper.isNullOrEmpty((String)pSSystemRun.getPSSystemRunName())) {
            return pSSystemRun.getPSSystemRunName();
        }
        return super.getModelV2Tag(pSSystemRun);
    }

    @Override
    public boolean setModelV2Tag(PSSystemRun pSSystemRun, String string) {
        pSSystemRun.setPSSystemRunName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSTEMRUNNAME", "");
        map.put("PSSYSTEMRUNNAME", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSystemRun pSSystemRun, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSystemRun.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSystemRun, true);
        pSSystemRun.set("PSSYSTEMRUNNAME", string);
        if (this.select(pSSystemRun, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSystemRun, true);
        return super.getModelV2Entity(pSSystemRun, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSystemRun pSSystemRun, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSystemRun, objectNode, string, string2, n);
    }
}

