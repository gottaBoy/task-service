/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
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
 *  net.ibizsys.paas.service.IServicePlugin
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInstBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInstBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSystemDBCfgDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSystemDBCfgDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBDetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBDetailServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemLogService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemLogServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMVerItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMVerItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemRunService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemRunServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSystemDBCfgServiceBase
extends PSCoreSysServiceBase<PSSystemDBCfg> {
    private static final Log log = LogFactory.getLog(PSSystemDBCfgServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURSYS2 = "CurSys2";
    public static final String DATASET_CURSYS3 = "CurSys3";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_X_ADDPUBSYSDBMODELTASK = "X_ADDPUBSYSDBMODELTASK";
    public static final String ACTION_X_ADDSYNCSUBSYSDBMODELTASK = "X_ADDSYNCSUBSYSDBMODELTASK";
    public static final String ACTION_X_ADDSYNCSYSDBMODELTASK = "X_ADDSYNCSYSDBMODELTASK";
    public static final String ACTION_OPENDBTOOL = "OPENDBTOOL";
    public static final String ACTION_OPENJITDBTOOL = "OPENJITDBTOOL";
    private PSSystemDBCfgDEModel pSSystemDBCfgDEModel;
    private PSSystemDBCfgDAO pSSystemDBCfgDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService";
    }

    public PSSystemDBCfgDEModel getPSSystemDBCfgDEModel() {
        if (this.pSSystemDBCfgDEModel == null) {
            try {
                this.pSSystemDBCfgDEModel = (PSSystemDBCfgDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSystemDBCfgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSystemDBCfgDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSystemDBCfgDEModel();
    }

    public PSSystemDBCfgDAO getPSSystemDBCfgDAO() {
        if (this.pSSystemDBCfgDAO == null) {
            try {
                this.pSSystemDBCfgDAO = (PSSystemDBCfgDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSystemDBCfgDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSystemDBCfgDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSystemDBCfgDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS2, (boolean)true) == 0) {
            return this.fetchCurSys2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS3, (boolean)true) == 0) {
            return this.fetchCurSys3(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_X_ADDPUBSYSDBMODELTASK, (boolean)true) == 0) {
            this.addPubSysDBModelTask((PSSystemDBCfg)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X_ADDSYNCSUBSYSDBMODELTASK, (boolean)true) == 0) {
            this.addSyncSubSysDBModelTask((PSSystemDBCfg)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X_ADDSYNCSYSDBMODELTASK, (boolean)true) == 0) {
            this.addSyncSysDBModelTask((PSSystemDBCfg)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_OPENDBTOOL, (boolean)true) == 0) {
            this.openDBTool((PSSystemDBCfg)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_OPENJITDBTOOL, (boolean)true) == 0) {
            this.openJITDBTool((PSSystemDBCfg)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSys2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSys3(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS3, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void addPubSysDBModelTask(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDPUBSYSDBMODELTASK, 0, (IEntity)pSSystemDBCfg, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSystemDBCfg, ACTION_X_ADDPUBSYSDBMODELTASK);
        final PSSystemDBCfg pSSystemDBCfg2 = pSSystemDBCfg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSystemDBCfgServiceBase.this.getService(), PSSystemDBCfgServiceBase.ACTION_X_ADDPUBSYSDBMODELTASK, 40, (IEntity)pSSystemDBCfg2, null).getResult() != 1) {
                    PSSystemDBCfgServiceBase.this.onAddPubSysDBModelTask(pSSystemDBCfg2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDPUBSYSDBMODELTASK, 99, (IEntity)pSSystemDBCfg, null);
        }
    }

    protected void onAddPubSysDBModelTask(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_ADDPUBSYSDBMODELTASK]");
    }

    public void addSyncSubSysDBModelTask(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDSYNCSUBSYSDBMODELTASK, 0, (IEntity)pSSystemDBCfg, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSystemDBCfg, ACTION_X_ADDSYNCSUBSYSDBMODELTASK);
        final PSSystemDBCfg pSSystemDBCfg2 = pSSystemDBCfg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSystemDBCfgServiceBase.this.getService(), PSSystemDBCfgServiceBase.ACTION_X_ADDSYNCSUBSYSDBMODELTASK, 40, (IEntity)pSSystemDBCfg2, null).getResult() != 1) {
                    PSSystemDBCfgServiceBase.this.onAddSyncSubSysDBModelTask(pSSystemDBCfg2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDSYNCSUBSYSDBMODELTASK, 99, (IEntity)pSSystemDBCfg, null);
        }
    }

    protected void onAddSyncSubSysDBModelTask(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_ADDSYNCSUBSYSDBMODELTASK]");
    }

    public void addSyncSysDBModelTask(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDSYNCSYSDBMODELTASK, 0, (IEntity)pSSystemDBCfg, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSystemDBCfg, ACTION_X_ADDSYNCSYSDBMODELTASK);
        final PSSystemDBCfg pSSystemDBCfg2 = pSSystemDBCfg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSystemDBCfgServiceBase.this.getService(), PSSystemDBCfgServiceBase.ACTION_X_ADDSYNCSYSDBMODELTASK, 40, (IEntity)pSSystemDBCfg2, null).getResult() != 1) {
                    PSSystemDBCfgServiceBase.this.onAddSyncSysDBModelTask(pSSystemDBCfg2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDSYNCSYSDBMODELTASK, 99, (IEntity)pSSystemDBCfg, null);
        }
    }

    protected void onAddSyncSysDBModelTask(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_ADDSYNCSYSDBMODELTASK]");
    }

    public void openDBTool(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_OPENDBTOOL, 0, (IEntity)pSSystemDBCfg, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSystemDBCfg, ACTION_OPENDBTOOL);
        final PSSystemDBCfg pSSystemDBCfg2 = pSSystemDBCfg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSystemDBCfgServiceBase.this.getService(), PSSystemDBCfgServiceBase.ACTION_OPENDBTOOL, 40, (IEntity)pSSystemDBCfg2, null).getResult() != 1) {
                    PSSystemDBCfgServiceBase.this.onOpenDBTool(pSSystemDBCfg2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_OPENDBTOOL, 99, (IEntity)pSSystemDBCfg, null);
        }
    }

    protected void onOpenDBTool(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[OPENDBTOOL]");
    }

    public void openJITDBTool(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_OPENJITDBTOOL, 0, (IEntity)pSSystemDBCfg, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSystemDBCfg, ACTION_OPENJITDBTOOL);
        final PSSystemDBCfg pSSystemDBCfg2 = pSSystemDBCfg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSystemDBCfgServiceBase.this.getService(), PSSystemDBCfgServiceBase.ACTION_OPENJITDBTOOL, 40, (IEntity)pSSystemDBCfg2, null).getResult() != 1) {
                    PSSystemDBCfgServiceBase.this.onOpenJITDBTool(pSSystemDBCfg2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_OPENJITDBTOOL, 99, (IEntity)pSSystemDBCfg, null);
        }
    }

    protected void onOpenJITDBTool(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[OPENJITDBTOOL]");
    }

    protected void onFillParentInfo(PSSystemDBCfg pSSystemDBCfg, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTEMDBCFG_PSDBDEVINST_NO2PSDBDEVINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService", (SessionFactory)this.getSessionFactory());
            PSDBDevInst pSDBDevInst = (PSDBDevInst)iService.getDEModel().createEntity();
            pSDBDevInst.set("PSDBDEVINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDBDevInst);
            } else {
                iService.get((IEntity)pSDBDevInst);
            }
            this.onFillParentInfo_No2PSDBDevInst(pSSystemDBCfg, pSDBDevInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTEMDBCFG_PSDBDEVINST_PSDBDEVINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService", (SessionFactory)this.getSessionFactory());
            PSDBDevInst pSDBDevInst = (PSDBDevInst)iService.getDEModel().createEntity();
            pSDBDevInst.set("PSDBDEVINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDBDevInst);
            } else {
                iService.get((IEntity)pSDBDevInst);
            }
            this.onFillParentInfo_PSDBDevInst(pSSystemDBCfg, pSDBDevInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTEMDBCFG_PSDEVCENTERDBINST_NO2PSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenterDBInst);
            } else {
                iService.get((IEntity)pSDevCenterDBInst);
            }
            this.onFillParentInfo_No2PSDCDBInst(pSSystemDBCfg, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTEMDBCFG_PSDEVCENTERDBINST_PSDEVCENTERDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenterDBInst);
            } else {
                iService.get((IEntity)pSDevCenterDBInst);
            }
            this.onFillParentInfo_PSDevCenterDBInst(pSSystemDBCfg, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTEMDBCFG_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSystemDBCfg, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSSystemDBCfg, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_No2PSDBDevInst(PSSystemDBCfg pSSystemDBCfg, PSDBDevInst pSDBDevInst) throws Exception {
        pSSystemDBCfg.setNo2PSDBDevInstId(pSDBDevInst.getPSDBDevInstId());
        pSSystemDBCfg.setNo2PSDBDevInstName(pSDBDevInst.getPSDBDevInstName());
    }

    protected void onFillParentInfo_PSDBDevInst(PSSystemDBCfg pSSystemDBCfg, PSDBDevInst pSDBDevInst) throws Exception {
        pSSystemDBCfg.setPSDBDevInstId(pSDBDevInst.getPSDBDevInstId());
        pSSystemDBCfg.setPSDBDevInstName(pSDBDevInst.getPSDBDevInstName());
    }

    protected void onFillParentInfo_No2PSDCDBInst(PSSystemDBCfg pSSystemDBCfg, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSSystemDBCfg.setNo2PSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSSystemDBCfg.setNo2PSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_PSDevCenterDBInst(PSSystemDBCfg pSSystemDBCfg, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSSystemDBCfg.setPSDevCenterDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSSystemDBCfg.setPSDevCenterDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_PSSystem(PSSystemDBCfg pSSystemDBCfg, PSSystem pSSystem) throws Exception {
        pSSystemDBCfg.setPSSystemId(pSSystem.getPSSystemId());
        pSSystemDBCfg.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected boolean onFillEntityKeyValue(PSSystemDBCfg pSSystemDBCfg, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSystemDBCfg.get("PSSYSTEMID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSystemDBCfg.get("PSSYSTEMDBCFGNAME");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSSystemDBCfg.set(this.getPSSystemDBCfgDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSystemDBCfg pSSystemDBCfg, boolean bl) throws Exception {
        if (bl) {
            if (pSSystemDBCfg.getDefaultFlag() == null) {
                pSSystemDBCfg.setDefaultFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSystemDBCfg.getEnableWebTool() == null) {
                pSSystemDBCfg.setEnableWebTool((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSystemDBCfg, bl);
        this.onFillEntityFullInfo_No2PSDBDevInst(pSSystemDBCfg, bl);
        this.onFillEntityFullInfo_PSDBDevInst(pSSystemDBCfg, bl);
        this.onFillEntityFullInfo_No2PSDCDBInst(pSSystemDBCfg, bl);
        this.onFillEntityFullInfo_PSDevCenterDBInst(pSSystemDBCfg, bl);
        this.onFillEntityFullInfo_PSSystem(pSSystemDBCfg, bl);
    }

    protected void onFillEntityFullInfo_No2PSDBDevInst(PSSystemDBCfg pSSystemDBCfg, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDBDevInst(PSSystemDBCfg pSSystemDBCfg, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_No2PSDCDBInst(PSSystemDBCfg pSSystemDBCfg, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterDBInst(PSSystemDBCfg pSSystemDBCfg, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSystemDBCfg pSSystemDBCfg, boolean bl) throws Exception {
        if (pSSystemDBCfg.isPSSystemIdDirty()) {
            if (pSSystemDBCfg.getPSSystemId() != null) {
                if (pSSystemDBCfg.getPSSystemId() == null || pSSystemDBCfg.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSystemDBCfg.getPSSystem();
                    pSSystemDBCfg.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSystemDBCfg.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSystemDBCfg pSSystemDBCfg, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSystemDBCfg, bl);
    }

    public ArrayList<PSSystemDBCfg> selectByNo2PSDBDevInst(PSDBDevInstBase pSDBDevInstBase) throws Exception {
        return this.selectByNo2PSDBDevInst(pSDBDevInstBase, "", -1);
    }

    public ArrayList<PSSystemDBCfg> selectByNo2PSDBDevInst(PSDBDevInstBase pSDBDevInstBase, String string) throws Exception {
        return this.selectByNo2PSDBDevInst(pSDBDevInstBase, string, -1);
    }

    public ArrayList<PSSystemDBCfg> selectByNo2PSDBDevInst(PSDBDevInstBase pSDBDevInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO2PSDBDEVINSTID", (Object)pSDBDevInstBase.getPSDBDevInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo2PSDBDevInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo2PSDBDevInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSystemDBCfg> selectByPSDBDevInst(PSDBDevInstBase pSDBDevInstBase) throws Exception {
        return this.selectByPSDBDevInst(pSDBDevInstBase, "", -1);
    }

    public ArrayList<PSSystemDBCfg> selectByPSDBDevInst(PSDBDevInstBase pSDBDevInstBase, String string) throws Exception {
        return this.selectByPSDBDevInst(pSDBDevInstBase, string, -1);
    }

    public ArrayList<PSSystemDBCfg> selectByPSDBDevInst(PSDBDevInstBase pSDBDevInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDBDEVINSTID", (Object)pSDBDevInstBase.getPSDBDevInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDBDevInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDBDevInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSystemDBCfg> selectByNo2PSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByNo2PSDCDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSSystemDBCfg> selectByNo2PSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByNo2PSDCDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSSystemDBCfg> selectByNo2PSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO2PSDCDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo2PSDCDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo2PSDCDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSystemDBCfg> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByPSDevCenterDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSSystemDBCfg> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByPSDevCenterDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSSystemDBCfg> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSystemDBCfg> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSystemDBCfg> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSystemDBCfg> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByNo2PSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
        ArrayList<PSSystemDBCfg> arrayList = this.selectByNo2PSDBDevInst(pSDBDevInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDBDEVINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDBDevInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTEMDBCFG_PSDBDEVINST_NO2PSDBDEVINSTID", "", iDataEntityModel.getName(), "PSSYSTEMDBCFG", iDataEntityModel.getDataInfo((IEntity)pSDBDevInst), arrayList.get(0)));
        }
    }

    public void resetNo2PSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
        ArrayList<PSSystemDBCfg> arrayList = this.selectByNo2PSDBDevInst(pSDBDevInst);
        for (PSSystemDBCfg pSSystemDBCfg : arrayList) {
            PSSystemDBCfg pSSystemDBCfg2 = (PSSystemDBCfg)this.getDEModel().createEntity();
            pSSystemDBCfg2.setPSSystemDBCfgId(pSSystemDBCfg.getPSSystemDBCfgId());
            pSSystemDBCfg2.setNo2PSDBDevInstId(null);
            this.update(pSSystemDBCfg2);
        }
    }

    public void removeByNo2PSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
        final PSDBDevInst pSDBDevInst2 = pSDBDevInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSystemDBCfgServiceBase.this.onBeforeRemoveByNo2PSDBDevInst(pSDBDevInst2);
                PSSystemDBCfgServiceBase.this.internalRemoveByNo2PSDBDevInst(pSDBDevInst2);
                PSSystemDBCfgServiceBase.this.onAfterRemoveByNo2PSDBDevInst(pSDBDevInst2);
            }
        });
    }

    protected void onBeforeRemoveByNo2PSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
    }

    protected void internalRemoveByNo2PSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
        ArrayList<PSSystemDBCfg> arrayList = this.selectByNo2PSDBDevInst(pSDBDevInst);
        this.onBeforeRemoveByNo2PSDBDevInst(pSDBDevInst, arrayList);
        for (PSSystemDBCfg pSSystemDBCfg : arrayList) {
            this.remove((IEntity)pSSystemDBCfg);
        }
        this.onAfterRemoveByNo2PSDBDevInst(pSDBDevInst, arrayList);
    }

    protected void onAfterRemoveByNo2PSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
    }

    protected void onBeforeRemoveByNo2PSDBDevInst(PSDBDevInst pSDBDevInst, ArrayList<PSSystemDBCfg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo2PSDBDevInst(PSDBDevInst pSDBDevInst, ArrayList<PSSystemDBCfg> arrayList) throws Exception {
    }

    public void testRemoveByPSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
        ArrayList<PSSystemDBCfg> arrayList = this.selectByPSDBDevInst(pSDBDevInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDBDEVINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDBDevInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTEMDBCFG_PSDBDEVINST_PSDBDEVINSTID", "", iDataEntityModel.getName(), "PSSYSTEMDBCFG", iDataEntityModel.getDataInfo((IEntity)pSDBDevInst), arrayList.get(0)));
        }
    }

    public void resetPSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
        ArrayList<PSSystemDBCfg> arrayList = this.selectByPSDBDevInst(pSDBDevInst);
        for (PSSystemDBCfg pSSystemDBCfg : arrayList) {
            PSSystemDBCfg pSSystemDBCfg2 = (PSSystemDBCfg)this.getDEModel().createEntity();
            pSSystemDBCfg2.setPSSystemDBCfgId(pSSystemDBCfg.getPSSystemDBCfgId());
            pSSystemDBCfg2.setPSDBDevInstId(null);
            this.update(pSSystemDBCfg2);
        }
    }

    public void removeByPSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
        final PSDBDevInst pSDBDevInst2 = pSDBDevInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSystemDBCfgServiceBase.this.onBeforeRemoveByPSDBDevInst(pSDBDevInst2);
                PSSystemDBCfgServiceBase.this.internalRemoveByPSDBDevInst(pSDBDevInst2);
                PSSystemDBCfgServiceBase.this.onAfterRemoveByPSDBDevInst(pSDBDevInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
    }

    protected void internalRemoveByPSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
        ArrayList<PSSystemDBCfg> arrayList = this.selectByPSDBDevInst(pSDBDevInst);
        this.onBeforeRemoveByPSDBDevInst(pSDBDevInst, arrayList);
        for (PSSystemDBCfg pSSystemDBCfg : arrayList) {
            this.remove((IEntity)pSSystemDBCfg);
        }
        this.onAfterRemoveByPSDBDevInst(pSDBDevInst, arrayList);
    }

    protected void onAfterRemoveByPSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDBDevInst(PSDBDevInst pSDBDevInst, ArrayList<PSSystemDBCfg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDBDevInst(PSDBDevInst pSDBDevInst, ArrayList<PSSystemDBCfg> arrayList) throws Exception {
    }

    public void testRemoveByNo2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSSystemDBCfg> arrayList = this.selectByNo2PSDCDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTEMDBCFG_PSDEVCENTERDBINST_NO2PSDCDBINSTID", "", iDataEntityModel.getName(), "PSSYSTEMDBCFG", iDataEntityModel.getDataInfo((IEntity)pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetNo2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSSystemDBCfg> arrayList = this.selectByNo2PSDCDBInst(pSDevCenterDBInst);
        for (PSSystemDBCfg pSSystemDBCfg : arrayList) {
            PSSystemDBCfg pSSystemDBCfg2 = (PSSystemDBCfg)this.getDEModel().createEntity();
            pSSystemDBCfg2.setPSSystemDBCfgId(pSSystemDBCfg.getPSSystemDBCfgId());
            pSSystemDBCfg2.setNo2PSDCDBInstId(null);
            this.update(pSSystemDBCfg2);
        }
    }

    public void removeByNo2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSystemDBCfgServiceBase.this.onBeforeRemoveByNo2PSDCDBInst(pSDevCenterDBInst2);
                PSSystemDBCfgServiceBase.this.internalRemoveByNo2PSDCDBInst(pSDevCenterDBInst2);
                PSSystemDBCfgServiceBase.this.onAfterRemoveByNo2PSDCDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByNo2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByNo2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSSystemDBCfg> arrayList = this.selectByNo2PSDCDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByNo2PSDCDBInst(pSDevCenterDBInst, arrayList);
        for (PSSystemDBCfg pSSystemDBCfg : arrayList) {
            this.remove((IEntity)pSSystemDBCfg);
        }
        this.onAfterRemoveByNo2PSDCDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByNo2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByNo2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSSystemDBCfg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSSystemDBCfg> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSSystemDBCfg> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTEMDBCFG_PSDEVCENTERDBINST_PSDEVCENTERDBINSTID", "", iDataEntityModel.getName(), "PSSYSTEMDBCFG", iDataEntityModel.getDataInfo((IEntity)pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSSystemDBCfg> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst);
        for (PSSystemDBCfg pSSystemDBCfg : arrayList) {
            PSSystemDBCfg pSSystemDBCfg2 = (PSSystemDBCfg)this.getDEModel().createEntity();
            pSSystemDBCfg2.setPSSystemDBCfgId(pSSystemDBCfg.getPSSystemDBCfgId());
            pSSystemDBCfg2.setPSDevCenterDBInstId(null);
            this.update(pSSystemDBCfg2);
        }
    }

    public void removeByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSystemDBCfgServiceBase.this.onBeforeRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
                PSSystemDBCfgServiceBase.this.internalRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
                PSSystemDBCfgServiceBase.this.onAfterRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSSystemDBCfg> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByPSDevCenterDBInst(pSDevCenterDBInst, arrayList);
        for (PSSystemDBCfg pSSystemDBCfg : arrayList) {
            this.remove((IEntity)pSSystemDBCfg);
        }
        this.onAfterRemoveByPSDevCenterDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSSystemDBCfg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSSystemDBCfg> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSystemDBCfg> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSystemDBCfg pSSystemDBCfg : arrayList) {
            PSSystemDBCfg pSSystemDBCfg2 = (PSSystemDBCfg)this.getDEModel().createEntity();
            pSSystemDBCfg2.setPSSystemDBCfgId(pSSystemDBCfg.getPSSystemDBCfgId());
            pSSystemDBCfg2.setPSSystemId(null);
            this.update(pSSystemDBCfg2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSystemDBCfgServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSystemDBCfgServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSystemDBCfgServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSystemDBCfg> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSystemDBCfg pSSystemDBCfg : arrayList) {
            this.remove((IEntity)pSSystemDBCfg);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSystemDBCfg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSystemDBCfg> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysDBDetailService)ServiceGlobal.getService(PSSysDBDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDBDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSSystemDBCfg(pSSystemDBCfg);
        ((PSSysDBDetailServiceBase)pSCoreSysServiceBase).removeByPSSystemDBCfg(pSSystemDBCfg);
        pSCoreSysServiceBase = (PSSysDMItemLogService)ServiceGlobal.getService(PSSysDMItemLogService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDMItemLogServiceBase)pSCoreSysServiceBase).testRemoveByPSSystemDBCfg(pSSystemDBCfg);
        ((PSSysDMItemLogServiceBase)pSCoreSysServiceBase).removeByPSSystemDBCfg(pSSystemDBCfg);
        pSCoreSysServiceBase = (PSSysDMItemService)ServiceGlobal.getService(PSSysDMItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDMItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSystemDBCfg(pSSystemDBCfg);
        ((PSSysDMItemServiceBase)pSCoreSysServiceBase).removeByPSSystemDBCfg(pSSystemDBCfg);
        pSCoreSysServiceBase = (PSSysDMVerItemService)ServiceGlobal.getService(PSSysDMVerItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDMVerItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSystemDBCfg(pSSystemDBCfg);
        ((PSSysDMVerItemServiceBase)pSCoreSysServiceBase).removeByPSSystemDBCfg(pSSystemDBCfg);
        pSCoreSysServiceBase = (PSSystemRunService)ServiceGlobal.getService(PSSystemRunService.class, (SessionFactory)this.getSessionFactory());
        ((PSSystemRunServiceBase)pSCoreSysServiceBase).testRemoveByPSSystemDBCfg(pSSystemDBCfg);
        super.onBeforeRemove(pSSystemDBCfg);
    }

    protected void replaceParentInfo(PSSystemDBCfg pSSystemDBCfg, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSystemDBCfg, cloneSession);
        if (pSSystemDBCfg.getNo2PSDBDevInstId() != null && (iEntity = cloneSession.getEntity("PSDBDEVINST", (Object)pSSystemDBCfg.getNo2PSDBDevInstId())) != null) {
            this.onFillParentInfo_No2PSDBDevInst(pSSystemDBCfg, (PSDBDevInst)iEntity);
        }
        if (pSSystemDBCfg.getPSDBDevInstId() != null && (iEntity = cloneSession.getEntity("PSDBDEVINST", (Object)pSSystemDBCfg.getPSDBDevInstId())) != null) {
            this.onFillParentInfo_PSDBDevInst(pSSystemDBCfg, (PSDBDevInst)iEntity);
        }
        if (pSSystemDBCfg.getNo2PSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSSystemDBCfg.getNo2PSDCDBInstId())) != null) {
            this.onFillParentInfo_No2PSDCDBInst(pSSystemDBCfg, (PSDevCenterDBInst)iEntity);
        }
        if (pSSystemDBCfg.getPSDevCenterDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSSystemDBCfg.getPSDevCenterDBInstId())) != null) {
            this.onFillParentInfo_PSDevCenterDBInst(pSSystemDBCfg, (PSDevCenterDBInst)iEntity);
        }
        if (pSSystemDBCfg.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSystemDBCfg.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSystemDBCfg, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSystemDBCfg pSSystemDBCfg, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSystemDBCfg, bl);
    }

    protected void onCheckEntity(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AppendSchema(bl, pSSystemDBCfg, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DBSchemaName(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableWebTool(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PSDBDevInstId(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PSDCDBInstId(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NoDBInstMode(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NullValOrder(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ObjNameCase(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBDevInstId(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterDBInstId(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemDBCfgId(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemDBCfgName(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubCommentFlag(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubDBModelFlag(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubFKeyFlag(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubIndexFlag(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubViewFlag(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResInfo(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResReadyTime(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResState(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TabSpace(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TabSpace2(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TabSpace3(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TabSpace4(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSystemDBCfg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSystemDBCfg, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AppendSchema(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isAppendSchemaDirty() : !pSSystemDBCfg.isAppendSchemaDirty()) {
            return null;
        }
        Integer n = pSSystemDBCfg.getAppendSchema();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AppendSchema_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPENDSCHEMA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DBSchemaName(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isDBSchemaNameDirty() : !pSSystemDBCfg.isDBSchemaNameDirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getDBSchemaName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DBSchemaName_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBSCHEMANAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isDefaultFlagDirty() : !pSSystemDBCfg.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSSystemDBCfg.getDefaultFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSSystemDBCfg, bl2, bl3);
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
                String string2 = this.checkFieldDupRule(this.getPSSystemDBCfgDEModel(), "DEFAULTFLAG", string, pSSystemDBCfg, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableWebTool(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isEnableWebToolDirty() : !pSSystemDBCfg.isEnableWebToolDirty()) {
            return null;
        }
        Integer n = pSSystemDBCfg.getEnableWebTool();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableWebTool_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEWEBTOOL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isMemoDirty() : !pSSystemDBCfg.isMemoDirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSystemDBCfg, bl2, bl3);
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

    protected EntityFieldError onCheckField_No2PSDBDevInstId(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isNo2PSDBDevInstIdDirty() : !pSSystemDBCfg.isNo2PSDBDevInstIdDirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getNo2PSDBDevInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PSDBDevInstId_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PSDBDEVINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2PSDCDBInstId(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isNo2PSDCDBInstIdDirty() : !pSSystemDBCfg.isNo2PSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getNo2PSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PSDCDBInstId_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PSDCDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NoDBInstMode(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isNoDBInstModeDirty() : !pSSystemDBCfg.isNoDBInstModeDirty()) {
            return null;
        }
        Integer n = pSSystemDBCfg.getNoDBInstMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NoDBInstMode_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODBINSTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NullValOrder(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isNullValOrderDirty() : !pSSystemDBCfg.isNullValOrderDirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getNullValOrder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NullValOrder_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NULLVALORDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ObjNameCase(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isObjNameCaseDirty() : !pSSystemDBCfg.isObjNameCaseDirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getObjNameCase();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ObjNameCase_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OBJNAMECASE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBDevInstId(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isPSDBDevInstIdDirty() : !pSSystemDBCfg.isPSDBDevInstIdDirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getPSDBDevInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBDevInstId_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBDEVINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterDBInstId(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isPSDevCenterDBInstIdDirty() : !pSSystemDBCfg.isPSDevCenterDBInstIdDirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getPSDevCenterDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterDBInstId_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemDBCfgId(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isPSSystemDBCfgIdDirty() && !bl2 : !pSSystemDBCfg.isPSSystemDBCfgIdDirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getPSSystemDBCfgId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMDBCFGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemDBCfgId_Default((IEntity)pSSystemDBCfg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemDBCfgName(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isPSSystemDBCfgNameDirty() && !bl2 : !pSSystemDBCfg.isPSSystemDBCfgNameDirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getPSSystemDBCfgName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMDBCFGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemDBCfgName_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMDBCFGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSystemDBCfgDEModel(), "PSSYSTEMDBCFGNAME", string3, pSSystemDBCfg, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSTEMDBCFGNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isPSSystemIdDirty() && !bl2 : !pSSystemDBCfg.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSystemDBCfg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isPSSystemNameDirty() && !bl2 : !pSSystemDBCfg.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSystemDBCfg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PubCommentFlag(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isPubCommentFlagDirty() : !pSSystemDBCfg.isPubCommentFlagDirty()) {
            return null;
        }
        Integer n = pSSystemDBCfg.getPubCommentFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PubCommentFlag_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBCOMMENTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubDBModelFlag(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isPubDBModelFlagDirty() : !pSSystemDBCfg.isPubDBModelFlagDirty()) {
            return null;
        }
        Integer n = pSSystemDBCfg.getPubDBModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PubDBModelFlag_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBDBMODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubFKeyFlag(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isPubFKeyFlagDirty() : !pSSystemDBCfg.isPubFKeyFlagDirty()) {
            return null;
        }
        Integer n = pSSystemDBCfg.getPubFKeyFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PubFKeyFlag_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBFKEYFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubIndexFlag(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isPubIndexFlagDirty() : !pSSystemDBCfg.isPubIndexFlagDirty()) {
            return null;
        }
        Integer n = pSSystemDBCfg.getPubIndexFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PubIndexFlag_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBINDEXFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubViewFlag(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isPubViewFlagDirty() : !pSSystemDBCfg.isPubViewFlagDirty()) {
            return null;
        }
        Integer n = pSSystemDBCfg.getPubViewFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PubViewFlag_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBVIEWFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResInfo(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isResInfoDirty() : !pSSystemDBCfg.isResInfoDirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getResInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ResInfo_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResReadyTime(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isResReadyTimeDirty() : !pSSystemDBCfg.isResReadyTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSSystemDBCfg.getResReadyTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResReadyTime_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESREADYTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResState(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isResStateDirty() : !pSSystemDBCfg.isResStateDirty()) {
            return null;
        }
        Integer n = pSSystemDBCfg.getResState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResState_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TabSpace(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isTabSpaceDirty() : !pSSystemDBCfg.isTabSpaceDirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getTabSpace();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TabSpace_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TABSPACE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TabSpace2(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isTabSpace2Dirty() : !pSSystemDBCfg.isTabSpace2Dirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getTabSpace2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TabSpace2_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TABSPACE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TabSpace3(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isTabSpace3Dirty() : !pSSystemDBCfg.isTabSpace3Dirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getTabSpace3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TabSpace3_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TABSPACE3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TabSpace4(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isTabSpace4Dirty() : !pSSystemDBCfg.isTabSpace4Dirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getTabSpace4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TabSpace4_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TABSPACE4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isUserCatDirty() : !pSSystemDBCfg.isUserCatDirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isUserParamsDirty() : !pSSystemDBCfg.isUserParamsDirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isUserTagDirty() : !pSSystemDBCfg.isUserTagDirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isUserTag2Dirty() : !pSSystemDBCfg.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isUserTag3Dirty() : !pSSystemDBCfg.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSystemDBCfg pSSystemDBCfg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemDBCfg.isUserTag4Dirty() : !pSSystemDBCfg.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSystemDBCfg.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSystemDBCfg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSystemDBCfg pSSystemDBCfg, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSystemDBCfg, bl);
    }

    protected void onSyncIndexEntities(PSSystemDBCfg pSSystemDBCfg, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSystemDBCfg, bl);
    }

    public Object getDataContextValue(PSSystemDBCfg pSSystemDBCfg, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSystemDBCfg, string, iDataContextParam)) != null) {
            return object;
        }
        PSSystem pSSystem = pSSystemDBCfg.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSystemDBCfg pSSystemDBCfg, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSystemDBCfg, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"APPENDSCHEMA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppendSchema_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBSCHEMANAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBSchemaName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEWEBTOOL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableWebTool_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSDBDEVINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSDBDevInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSDBDEVINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSDBDevInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSDCDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODBINSTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NoDBInstMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NULLVALORDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NullValOrder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OBJNAMECASE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ObjNameCase_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBDEVINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBDevInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBDEVINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBDevInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterDBInstName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PUBCOMMENTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubCommentFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBDBMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubDBModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBFKEYFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubFKeyFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBINDEXFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubIndexFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBVIEWFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubViewFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESREADYTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResReadyTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TABSPACE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TabSpace_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TABSPACE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TabSpace2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TABSPACE3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TabSpace3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TABSPACE4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TabSpace4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AppendSchema_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_DBSchemaName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DBSCHEMANAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableWebTool_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_No2PSDBDevInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSDBDEVINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2PSDBDevInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSDBDEVINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2PSDCDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSDCDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2PSDCDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSDCDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NoDBInstMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NullValOrder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NULLVALORDER", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ObjNameCase_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OBJNAMECASE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBDevInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBDEVINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBDevInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBDEVINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PubCommentFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PubDBModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PubFKeyFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PubIndexFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PubViewFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESINFO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ResReadyTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TabSpace_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TABSPACE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TabSpace2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TABSPACE2", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TabSpace3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TABSPACE3", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TabSpace4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TABSPACE4", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_UserCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCAT", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSystemDBCfg pSSystemDBCfg) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSystemDBCfg)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        super.onUpdateParent((IEntity)pSSystemDBCfg);
    }

    @Override
    protected void exportCurXmlModel(PSSystemDBCfg pSSystemDBCfg, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSTEMDBCFG");
        if (!bl) {
            pSSystemDBCfg.setCreateDate(null);
            pSSystemDBCfg.setCreateMan(null);
            pSSystemDBCfg.setEnableWebTool(null);
            pSSystemDBCfg.setNoDBInstMode(null);
            pSSystemDBCfg.setPSSystemDBCfgId(null);
            pSSystemDBCfg.setUpdateDate(null);
            pSSystemDBCfg.setUpdateMan(null);
            super.exportCurXmlModel(pSSystemDBCfg, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSystemDBCfg pSSystemDBCfg, PSSystem pSSystem) throws Exception {
        PSSystemDBCfg pSSystemDBCfg2 = new PSSystemDBCfg();
        pSSystemDBCfg2.setPSSystemId(pSSystemDBCfg.getPSSystemId());
        pSSystemDBCfg2.setPSSystemDBCfgName(pSSystemDBCfg.getPSSystemDBCfgName());
        if (this.selectOne((IEntity)pSSystemDBCfg2, true)) {
            return pSSystemDBCfg2.getPSSystemDBCfgId();
        }
        return super.getEntityFolderKeyValue(pSSystemDBCfg, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSystemDBCfg pSSystemDBCfg, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSystemDBCfg, string);
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
            return "DER1N_PSSYSTEMDBCFG_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSystemDBCfg pSSystemDBCfg) {
        if (!StringHelper.isNullOrEmpty((String)pSSystemDBCfg.getPSSystemDBCfgName())) {
            return pSSystemDBCfg.getPSSystemDBCfgName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSystemDBCfg.getPSSystemDBCfgName())) {
            return pSSystemDBCfg.getPSSystemDBCfgName();
        }
        return super.getModelV2Tag(pSSystemDBCfg);
    }

    @Override
    public boolean setModelV2Tag(PSSystemDBCfg pSSystemDBCfg, String string) {
        pSSystemDBCfg.setPSSystemDBCfgName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSTEMDBCFGNAME", "");
        map.put("PSSYSTEMDBCFGNAME", "");
        map.put("PSSYSTEMDBCFGNAME", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSystemDBCfg pSSystemDBCfg, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSystemDBCfg.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSystemDBCfg, true);
        pSSystemDBCfg.set("PSSYSTEMDBCFGNAME", string);
        if (this.select(pSSystemDBCfg, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSystemDBCfg, true);
        return super.getModelV2Entity(pSSystemDBCfg, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSystemDBCfg pSSystemDBCfg, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSystemDBCfg, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSDMITEM_PSSYSTEMDBCFG_PSSYSTEMDBCFGID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 80;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSystemDBCfg pSSystemDBCfg, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSDMITEM_PSSYSTEMDBCFG_PSSYSTEMDBCFGID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSTEMDBCFG#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSDMITEM", (Object)pSSystemDBCfg.getPSSystemDBCfgId()))).exists()) {
            PSSysDMItemService pSSysDMItemService = (PSSysDMItemService)ServiceGlobal.getService(PSSysDMItemService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSSysDMItemService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSSysDMItem pSSysDMItem = new PSSysDMItem();
                PSModelV2Helper.fromJSONObject((IDataObject)pSSysDMItem, objectNode, false);
                String string6 = pSSysDMItemService.getModelV2Tag(pSSysDMItem);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSDMITEM", (Object)pSSysDMItem.getPSSysDMItemId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSSysDMItemService.exportModelV2(pSSysDMItem, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSSystemDBCfg, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSystemDBCfg pSSystemDBCfg, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSDMITEM_PSSYSTEMDBCFG_PSSYSTEMDBCFGID")) {
            Object object;
            PSSysDMItem pSSysDMItem2;
            Object object2;
            Object object3;
            Object object4;
            PSSysDMItemService pSSysDMItemService = (PSSysDMItemService)ServiceGlobal.getService(PSSysDMItemService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSSysDMItem> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSTEMDBCFG#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSDMITEM", (Object)pSSystemDBCfg.getPSSystemDBCfgId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSSysDMItem2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSSysDMItem2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysDMItem>();
                object4 = pSSysDMItemService.selectByPSSystemDBCfg(pSSystemDBCfg);
                object3 = StringHelper.format((String)"PSSYSTEMDBCFG#%1$s", (Object)pSSystemDBCfg.getPSSystemDBCfgId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSSysDMItem2 = object2.next();
                    object = pSSysDMItemService.getModelV2ResScope((IEntity)pSSysDMItem2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysDMItem)PSModelV2Helper.toJSONObject((IEntity)pSSysDMItem2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSSysDMItemService.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("pssysdmitemname")) {
                            string = objectNode.get("pssysdmitemname").asText();
                        }
                        if (objectNode2.has("pssysdmitemname")) {
                            string2 = objectNode2.get("pssysdmitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSSysDMItem pSSysDMItem2 : arrayList) {
                    object = new PSSysDMItem();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSSysDMItem2, false);
                    object3.add((JsonNode)pSSysDMItemService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSystemDBCfg, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        super.onEmptyModelV2(pSSystemDBCfg);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysDMItemService pSSysDMItemService = (PSSysDMItemService)ServiceGlobal.getService(PSSysDMItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysDMItemService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSystemDBCfg pSSystemDBCfg, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysDMItem pSSysDMItem = new PSSysDMItem();
        pSSysDMItem.set("PSSYSTEMDBCFGID", pSSystemDBCfg.getPSSystemDBCfgId());
        PSSysDMItemService pSSysDMItemService = (PSSysDMItemService)ServiceGlobal.getService(PSSysDMItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysDMItemService.getModelV2Entity(pSSysDMItem, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSystemDBCfg, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSystemDBCfg pSSystemDBCfg, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSSystemDBCfgServiceBase.isSimpleImportExportMode("")) {
            PSSysDMItemService pSSysDMItemService = (PSSysDMItemService)ServiceGlobal.getService(PSSysDMItemService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSSysDMItemService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSSysDMItem pSSysDMItem = new PSSysDMItem();
                    pSSysDMItem.setPSSystemDBCfgId(pSSystemDBCfg.getPSSystemDBCfgId());
                    pSSysDMItem.setPSSystemDBCfgName(pSSystemDBCfg.getPSSystemDBCfgName());
                    pSSysDMItemService.compileModelV2(pSSysDMItem, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSSysDMItem pSSysDMItem = new PSSysDMItem();
                        pSSysDMItem.setPSSystemDBCfgId(pSSystemDBCfg.getPSSystemDBCfgId());
                        pSSysDMItem.setPSSystemDBCfgName(pSSystemDBCfg.getPSSystemDBCfgName());
                        pSSysDMItemService.compileModelV2(pSSysDMItem, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSystemDBCfg, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSystemDBCfg pSSystemDBCfg, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        Object var5_5 = null;
        return super.onPasteFile(pSSystemDBCfg, pSMOSFile, string, iPSMOSFileAction);
    }

    @Override
    protected void onFillPasteHelps(PSSystemDBCfg pSSystemDBCfg, List<PSHelpSection> list) throws Exception {
        super.onFillPasteHelps(pSSystemDBCfg, list);
    }
}

