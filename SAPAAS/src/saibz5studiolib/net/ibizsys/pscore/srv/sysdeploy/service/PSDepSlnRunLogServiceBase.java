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
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnRunLogDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnRunLogDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnAS;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnASBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnMode;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnModeBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnPrd;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnPrdBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnRunLog;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnRunLogServiceBase
extends PSCoreSysServiceBase<PSDepSlnRunLog> {
    private static final Log log = LogFactory.getLog(PSDepSlnRunLogServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnRunLogDEModel pSDepSlnRunLogDEModel;
    private PSDepSlnRunLogDAO pSDepSlnRunLogDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnRunLogService";
    }

    public PSDepSlnRunLogDEModel getPSDepSlnRunLogDEModel() {
        if (this.pSDepSlnRunLogDEModel == null) {
            try {
                this.pSDepSlnRunLogDEModel = (PSDepSlnRunLogDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnRunLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnRunLogDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnRunLogDEModel();
    }

    public PSDepSlnRunLogDAO getPSDepSlnRunLogDAO() {
        if (this.pSDepSlnRunLogDAO == null) {
            try {
                this.pSDepSlnRunLogDAO = (PSDepSlnRunLogDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnRunLogDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnRunLogDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnRunLogDAO();
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

    protected void onFillParentInfo(PSDepSlnRunLog pSDepSlnRunLog, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNRUNLOG_PSDEPSLNAS_PSDEPSLNASID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASService", (SessionFactory)this.getSessionFactory());
            PSDepSlnAS pSDepSlnAS = (PSDepSlnAS)iService.getDEModel().createEntity();
            pSDepSlnAS.set("PSDEPSLNASID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSlnAS);
            } else {
                iService.get(pSDepSlnAS);
            }
            this.onFillParentInfo_PSDepSlnAS(pSDepSlnRunLog, pSDepSlnAS);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNRUNLOG_PSDEPSLNMODE_PSDEPSLNMODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnModeService", (SessionFactory)this.getSessionFactory());
            PSDepSlnMode pSDepSlnMode = (PSDepSlnMode)iService.getDEModel().createEntity();
            pSDepSlnMode.set("PSDEPSLNMODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSlnMode);
            } else {
                iService.get(pSDepSlnMode);
            }
            this.onFillParentInfo_PSDepSlnMode(pSDepSlnRunLog, pSDepSlnMode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNRUNLOG_PSDEPSLNPRD_PSDEPSLNPRDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPrdService", (SessionFactory)this.getSessionFactory());
            PSDepSlnPrd pSDepSlnPrd = (PSDepSlnPrd)iService.getDEModel().createEntity();
            pSDepSlnPrd.set("PSDEPSLNPRDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSlnPrd);
            } else {
                iService.get(pSDepSlnPrd);
            }
            this.onFillParentInfo_PSDepSlnPrd(pSDepSlnRunLog, pSDepSlnPrd);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNRUNLOG_PSDEPSLN_PSDEPSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService", (SessionFactory)this.getSessionFactory());
            PSDepSln pSDepSln = (PSDepSln)iService.getDEModel().createEntity();
            pSDepSln.set("PSDEPSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSln);
            } else {
                iService.get(pSDepSln);
            }
            this.onFillParentInfo_PSDepSln(pSDepSlnRunLog, pSDepSln);
            return;
        }
        super.onFillParentInfo(pSDepSlnRunLog, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDepSlnAS(PSDepSlnRunLog pSDepSlnRunLog, PSDepSlnAS pSDepSlnAS) throws Exception {
        pSDepSlnRunLog.setPSDeSlnASId(pSDepSlnAS.getPSDepSlnASId());
        pSDepSlnRunLog.setPSDepSlnASName(pSDepSlnAS.getPSDepSlnASName());
    }

    protected void onFillParentInfo_PSDepSlnMode(PSDepSlnRunLog pSDepSlnRunLog, PSDepSlnMode pSDepSlnMode) throws Exception {
        pSDepSlnRunLog.setPSDepSlnModeId(pSDepSlnMode.getPSDepSlnModeId());
        pSDepSlnRunLog.setPSDepSlnModeName(pSDepSlnMode.getPSDepSlnModeName());
    }

    protected void onFillParentInfo_PSDepSlnPrd(PSDepSlnRunLog pSDepSlnRunLog, PSDepSlnPrd pSDepSlnPrd) throws Exception {
        pSDepSlnRunLog.setPSDepSlnPrdId(pSDepSlnPrd.getPSDepSlnPrdId());
        pSDepSlnRunLog.setPSDepSlnPrdName(pSDepSlnPrd.getPSDepSlnPrdName());
    }

    protected void onFillParentInfo_PSDepSln(PSDepSlnRunLog pSDepSlnRunLog, PSDepSln pSDepSln) throws Exception {
        pSDepSlnRunLog.setPSDepSlnId(pSDepSln.getPSDepSlnId());
        pSDepSlnRunLog.setPSDepSlnName(pSDepSln.getPSDepSlnName());
    }

    protected void onFillEntityFullInfo(PSDepSlnRunLog pSDepSlnRunLog, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDepSlnRunLog, bl);
        this.onFillEntityFullInfo_PSDepSlnAS(pSDepSlnRunLog, bl);
        this.onFillEntityFullInfo_PSDepSlnMode(pSDepSlnRunLog, bl);
        this.onFillEntityFullInfo_PSDepSlnPrd(pSDepSlnRunLog, bl);
        this.onFillEntityFullInfo_PSDepSln(pSDepSlnRunLog, bl);
    }

    protected void onFillEntityFullInfo_PSDepSlnAS(PSDepSlnRunLog pSDepSlnRunLog, boolean bl) throws Exception {
        if (pSDepSlnRunLog.isPSDeSlnASIdDirty()) {
            if (pSDepSlnRunLog.getPSDeSlnASId() != null) {
                if (pSDepSlnRunLog.getPSDeSlnASId() == null || pSDepSlnRunLog.getPSDepSlnASName() == null) {
                    PSDepSlnAS pSDepSlnAS = pSDepSlnRunLog.getPSDepSlnAS();
                    pSDepSlnRunLog.setPSDepSlnASName(pSDepSlnAS.getPSDepSlnASName());
                }
            } else {
                pSDepSlnRunLog.setPSDepSlnASName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDepSlnMode(PSDepSlnRunLog pSDepSlnRunLog, boolean bl) throws Exception {
        if (pSDepSlnRunLog.isPSDepSlnModeIdDirty()) {
            if (pSDepSlnRunLog.getPSDepSlnModeId() != null) {
                if (pSDepSlnRunLog.getPSDepSlnModeId() == null || pSDepSlnRunLog.getPSDepSlnModeName() == null) {
                    PSDepSlnMode pSDepSlnMode = pSDepSlnRunLog.getPSDepSlnMode();
                    pSDepSlnRunLog.setPSDepSlnModeName(pSDepSlnMode.getPSDepSlnModeName());
                }
            } else {
                pSDepSlnRunLog.setPSDepSlnModeName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDepSlnPrd(PSDepSlnRunLog pSDepSlnRunLog, boolean bl) throws Exception {
        if (pSDepSlnRunLog.isPSDepSlnPrdIdDirty()) {
            if (pSDepSlnRunLog.getPSDepSlnPrdId() != null) {
                if (pSDepSlnRunLog.getPSDepSlnPrdId() == null || pSDepSlnRunLog.getPSDepSlnPrdName() == null) {
                    PSDepSlnPrd pSDepSlnPrd = pSDepSlnRunLog.getPSDepSlnPrd();
                    pSDepSlnRunLog.setPSDepSlnPrdName(pSDepSlnPrd.getPSDepSlnPrdName());
                }
            } else {
                pSDepSlnRunLog.setPSDepSlnPrdName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDepSln(PSDepSlnRunLog pSDepSlnRunLog, boolean bl) throws Exception {
        if (pSDepSlnRunLog.isPSDepSlnIdDirty()) {
            if (pSDepSlnRunLog.getPSDepSlnId() != null) {
                if (pSDepSlnRunLog.getPSDepSlnId() == null || pSDepSlnRunLog.getPSDepSlnName() == null) {
                    PSDepSln pSDepSln = pSDepSlnRunLog.getPSDepSln();
                    pSDepSlnRunLog.setPSDepSlnName(pSDepSln.getPSDepSlnName());
                }
            } else {
                pSDepSlnRunLog.setPSDepSlnName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDepSlnRunLog pSDepSlnRunLog, boolean bl) throws Exception {
        super.onWriteBackParent(pSDepSlnRunLog, bl);
    }

    public ArrayList<PSDepSlnRunLog> selectByPSDepSlnAS(PSDepSlnASBase pSDepSlnASBase) throws Exception {
        return this.selectByPSDepSlnAS(pSDepSlnASBase, "", -1);
    }

    public ArrayList<PSDepSlnRunLog> selectByPSDepSlnAS(PSDepSlnASBase pSDepSlnASBase, String string) throws Exception {
        return this.selectByPSDepSlnAS(pSDepSlnASBase, string, -1);
    }

    public ArrayList<PSDepSlnRunLog> selectByPSDepSlnAS(PSDepSlnASBase pSDepSlnASBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNASID", (Object)pSDepSlnASBase.getPSDepSlnASId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnASCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnASCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnRunLog> selectByPSDepSlnMode(PSDepSlnModeBase pSDepSlnModeBase) throws Exception {
        return this.selectByPSDepSlnMode(pSDepSlnModeBase, "", -1);
    }

    public ArrayList<PSDepSlnRunLog> selectByPSDepSlnMode(PSDepSlnModeBase pSDepSlnModeBase, String string) throws Exception {
        return this.selectByPSDepSlnMode(pSDepSlnModeBase, string, -1);
    }

    public ArrayList<PSDepSlnRunLog> selectByPSDepSlnMode(PSDepSlnModeBase pSDepSlnModeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNMODEID", (Object)pSDepSlnModeBase.getPSDepSlnModeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnModeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnModeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnRunLog> selectByPSDepSlnPrd(PSDepSlnPrdBase pSDepSlnPrdBase) throws Exception {
        return this.selectByPSDepSlnPrd(pSDepSlnPrdBase, "", -1);
    }

    public ArrayList<PSDepSlnRunLog> selectByPSDepSlnPrd(PSDepSlnPrdBase pSDepSlnPrdBase, String string) throws Exception {
        return this.selectByPSDepSlnPrd(pSDepSlnPrdBase, string, -1);
    }

    public ArrayList<PSDepSlnRunLog> selectByPSDepSlnPrd(PSDepSlnPrdBase pSDepSlnPrdBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNPRDID", (Object)pSDepSlnPrdBase.getPSDepSlnPrdId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnPrdCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnPrdCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnRunLog> selectByPSDepSln(PSDepSlnBase pSDepSlnBase) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, "", -1);
    }

    public ArrayList<PSDepSlnRunLog> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, string, -1);
    }

    public ArrayList<PSDepSlnRunLog> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDepSlnAS(PSDepSlnAS pSDepSlnAS) throws Exception {
        ArrayList<PSDepSlnRunLog> arrayList = this.selectByPSDepSlnAS(pSDepSlnAS, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNAS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDepSlnAS);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNRUNLOG_PSDEPSLNAS_PSDEPSLNASID", "", iDataEntityModel.getName(), "PSDEPSLNRUNLOG", iDataEntityModel.getDataInfo(pSDepSlnAS), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnAS(PSDepSlnAS pSDepSlnAS) throws Exception {
        ArrayList<PSDepSlnRunLog> arrayList = this.selectByPSDepSlnAS(pSDepSlnAS);
        for (PSDepSlnRunLog pSDepSlnRunLog : arrayList) {
            PSDepSlnRunLog pSDepSlnRunLog2 = (PSDepSlnRunLog)this.getDEModel().createEntity();
            pSDepSlnRunLog2.setPSDepSlnRunLogId(pSDepSlnRunLog.getPSDepSlnRunLogId());
            pSDepSlnRunLog2.setPSDeSlnASId(null);
            this.update(pSDepSlnRunLog2);
        }
    }

    public void removeByPSDepSlnAS(PSDepSlnAS pSDepSlnAS) throws Exception {
        final PSDepSlnAS pSDepSlnAS2 = pSDepSlnAS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnRunLogServiceBase.this.onBeforeRemoveByPSDepSlnAS(pSDepSlnAS2);
                PSDepSlnRunLogServiceBase.this.internalRemoveByPSDepSlnAS(pSDepSlnAS2);
                PSDepSlnRunLogServiceBase.this.onAfterRemoveByPSDepSlnAS(pSDepSlnAS2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnAS(PSDepSlnAS pSDepSlnAS) throws Exception {
    }

    protected void internalRemoveByPSDepSlnAS(PSDepSlnAS pSDepSlnAS) throws Exception {
        ArrayList<PSDepSlnRunLog> arrayList = this.selectByPSDepSlnAS(pSDepSlnAS);
        this.onBeforeRemoveByPSDepSlnAS(pSDepSlnAS, arrayList);
        for (PSDepSlnRunLog pSDepSlnRunLog : arrayList) {
            this.remove(pSDepSlnRunLog);
        }
        this.onAfterRemoveByPSDepSlnAS(pSDepSlnAS, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnAS(PSDepSlnAS pSDepSlnAS) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnAS(PSDepSlnAS pSDepSlnAS, ArrayList<PSDepSlnRunLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnAS(PSDepSlnAS pSDepSlnAS, ArrayList<PSDepSlnRunLog> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSlnMode(PSDepSlnMode pSDepSlnMode) throws Exception {
    }

    public void resetPSDepSlnMode(PSDepSlnMode pSDepSlnMode) throws Exception {
        ArrayList<PSDepSlnRunLog> arrayList = this.selectByPSDepSlnMode(pSDepSlnMode);
        for (PSDepSlnRunLog pSDepSlnRunLog : arrayList) {
            PSDepSlnRunLog pSDepSlnRunLog2 = (PSDepSlnRunLog)this.getDEModel().createEntity();
            pSDepSlnRunLog2.setPSDepSlnRunLogId(pSDepSlnRunLog.getPSDepSlnRunLogId());
            pSDepSlnRunLog2.setPSDepSlnModeId(null);
            this.update(pSDepSlnRunLog2);
        }
    }

    public void removeByPSDepSlnMode(PSDepSlnMode pSDepSlnMode) throws Exception {
        final PSDepSlnMode pSDepSlnMode2 = pSDepSlnMode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnRunLogServiceBase.this.onBeforeRemoveByPSDepSlnMode(pSDepSlnMode2);
                PSDepSlnRunLogServiceBase.this.internalRemoveByPSDepSlnMode(pSDepSlnMode2);
                PSDepSlnRunLogServiceBase.this.onAfterRemoveByPSDepSlnMode(pSDepSlnMode2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnMode(PSDepSlnMode pSDepSlnMode) throws Exception {
    }

    protected void internalRemoveByPSDepSlnMode(PSDepSlnMode pSDepSlnMode) throws Exception {
        ArrayList<PSDepSlnRunLog> arrayList = this.selectByPSDepSlnMode(pSDepSlnMode);
        this.onBeforeRemoveByPSDepSlnMode(pSDepSlnMode, arrayList);
        for (PSDepSlnRunLog pSDepSlnRunLog : arrayList) {
            this.remove(pSDepSlnRunLog);
        }
        this.onAfterRemoveByPSDepSlnMode(pSDepSlnMode, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnMode(PSDepSlnMode pSDepSlnMode) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnMode(PSDepSlnMode pSDepSlnMode, ArrayList<PSDepSlnRunLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnMode(PSDepSlnMode pSDepSlnMode, ArrayList<PSDepSlnRunLog> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSlnPrd(PSDepSlnPrd pSDepSlnPrd) throws Exception {
        ArrayList<PSDepSlnRunLog> arrayList = this.selectByPSDepSlnPrd(pSDepSlnPrd, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNPRD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDepSlnPrd);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNRUNLOG_PSDEPSLNPRD_PSDEPSLNPRDID", "", iDataEntityModel.getName(), "PSDEPSLNRUNLOG", iDataEntityModel.getDataInfo(pSDepSlnPrd), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnPrd(PSDepSlnPrd pSDepSlnPrd) throws Exception {
        ArrayList<PSDepSlnRunLog> arrayList = this.selectByPSDepSlnPrd(pSDepSlnPrd);
        for (PSDepSlnRunLog pSDepSlnRunLog : arrayList) {
            PSDepSlnRunLog pSDepSlnRunLog2 = (PSDepSlnRunLog)this.getDEModel().createEntity();
            pSDepSlnRunLog2.setPSDepSlnRunLogId(pSDepSlnRunLog.getPSDepSlnRunLogId());
            pSDepSlnRunLog2.setPSDepSlnPrdId(null);
            this.update(pSDepSlnRunLog2);
        }
    }

    public void removeByPSDepSlnPrd(PSDepSlnPrd pSDepSlnPrd) throws Exception {
        final PSDepSlnPrd pSDepSlnPrd2 = pSDepSlnPrd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnRunLogServiceBase.this.onBeforeRemoveByPSDepSlnPrd(pSDepSlnPrd2);
                PSDepSlnRunLogServiceBase.this.internalRemoveByPSDepSlnPrd(pSDepSlnPrd2);
                PSDepSlnRunLogServiceBase.this.onAfterRemoveByPSDepSlnPrd(pSDepSlnPrd2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnPrd(PSDepSlnPrd pSDepSlnPrd) throws Exception {
    }

    protected void internalRemoveByPSDepSlnPrd(PSDepSlnPrd pSDepSlnPrd) throws Exception {
        ArrayList<PSDepSlnRunLog> arrayList = this.selectByPSDepSlnPrd(pSDepSlnPrd);
        this.onBeforeRemoveByPSDepSlnPrd(pSDepSlnPrd, arrayList);
        for (PSDepSlnRunLog pSDepSlnRunLog : arrayList) {
            this.remove(pSDepSlnRunLog);
        }
        this.onAfterRemoveByPSDepSlnPrd(pSDepSlnPrd, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnPrd(PSDepSlnPrd pSDepSlnPrd) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnPrd(PSDepSlnPrd pSDepSlnPrd, ArrayList<PSDepSlnRunLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnPrd(PSDepSlnPrd pSDepSlnPrd, ArrayList<PSDepSlnRunLog> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    public void resetPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnRunLog> arrayList = this.selectByPSDepSln(pSDepSln);
        for (PSDepSlnRunLog pSDepSlnRunLog : arrayList) {
            PSDepSlnRunLog pSDepSlnRunLog2 = (PSDepSlnRunLog)this.getDEModel().createEntity();
            pSDepSlnRunLog2.setPSDepSlnRunLogId(pSDepSlnRunLog.getPSDepSlnRunLogId());
            pSDepSlnRunLog2.setPSDepSlnId(null);
            this.update(pSDepSlnRunLog2);
        }
    }

    public void removeByPSDepSln(PSDepSln pSDepSln) throws Exception {
        final PSDepSln pSDepSln2 = pSDepSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnRunLogServiceBase.this.onBeforeRemoveByPSDepSln(pSDepSln2);
                PSDepSlnRunLogServiceBase.this.internalRemoveByPSDepSln(pSDepSln2);
                PSDepSlnRunLogServiceBase.this.onAfterRemoveByPSDepSln(pSDepSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void internalRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnRunLog> arrayList = this.selectByPSDepSln(pSDepSln);
        this.onBeforeRemoveByPSDepSln(pSDepSln, arrayList);
        for (PSDepSlnRunLog pSDepSlnRunLog : arrayList) {
            this.remove(pSDepSlnRunLog);
        }
        this.onAfterRemoveByPSDepSln(pSDepSln, arrayList);
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnRunLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnRunLog> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnRunLog pSDepSlnRunLog) throws Exception {
        super.onBeforeRemove(pSDepSlnRunLog);
    }

    protected void replaceParentInfo(PSDepSlnRunLog pSDepSlnRunLog, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDepSlnRunLog, cloneSession);
        if (pSDepSlnRunLog.getPSDeSlnASId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNAS", (Object)pSDepSlnRunLog.getPSDeSlnASId())) != null) {
            this.onFillParentInfo_PSDepSlnAS(pSDepSlnRunLog, (PSDepSlnAS)iEntity);
        }
        if (pSDepSlnRunLog.getPSDepSlnModeId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNMODE", (Object)pSDepSlnRunLog.getPSDepSlnModeId())) != null) {
            this.onFillParentInfo_PSDepSlnMode(pSDepSlnRunLog, (PSDepSlnMode)iEntity);
        }
        if (pSDepSlnRunLog.getPSDepSlnPrdId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNPRD", (Object)pSDepSlnRunLog.getPSDepSlnPrdId())) != null) {
            this.onFillParentInfo_PSDepSlnPrd(pSDepSlnRunLog, (PSDepSlnPrd)iEntity);
        }
        if (pSDepSlnRunLog.getPSDepSlnId() != null && (iEntity = cloneSession.getEntity("PSDEPSLN", (Object)pSDepSlnRunLog.getPSDepSlnId())) != null) {
            this.onFillParentInfo_PSDepSln(pSDepSlnRunLog, (PSDepSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnRunLog pSDepSlnRunLog, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDepSlnRunLog, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnRunLog pSDepSlnRunLog, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_LogInfo(bl, pSDepSlnRunLog, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogInfo2(bl, pSDepSlnRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogLevel(bl, pSDepSlnRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogLevel2(bl, pSDepSlnRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogTime(bl, pSDepSlnRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDeSlnASId(bl, pSDepSlnRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnASName(bl, pSDepSlnRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnId(bl, pSDepSlnRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnModeId(bl, pSDepSlnRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnModeName(bl, pSDepSlnRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnName(bl, pSDepSlnRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnPrdId(bl, pSDepSlnRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnPrdName(bl, pSDepSlnRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnRunLogId(bl, pSDepSlnRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnRunLogName(bl, pSDepSlnRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDepSlnRunLog, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_LogInfo(boolean bl, PSDepSlnRunLog pSDepSlnRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnRunLog.isLogInfoDirty() : !pSDepSlnRunLog.isLogInfoDirty()) {
            return null;
        }
        String string = pSDepSlnRunLog.getLogInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogInfo_Default(pSDepSlnRunLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogInfo2(boolean bl, PSDepSlnRunLog pSDepSlnRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnRunLog.isLogInfo2Dirty() : !pSDepSlnRunLog.isLogInfo2Dirty()) {
            return null;
        }
        String string = pSDepSlnRunLog.getLogInfo2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogInfo2_Default(pSDepSlnRunLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGINFO2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogLevel(boolean bl, PSDepSlnRunLog pSDepSlnRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnRunLog.isLogLevelDirty() : !pSDepSlnRunLog.isLogLevelDirty()) {
            return null;
        }
        String string = pSDepSlnRunLog.getLogLevel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogLevel_Default(pSDepSlnRunLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGLEVEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogLevel2(boolean bl, PSDepSlnRunLog pSDepSlnRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnRunLog.isLogLevel2Dirty() : !pSDepSlnRunLog.isLogLevel2Dirty()) {
            return null;
        }
        Integer n = pSDepSlnRunLog.getLogLevel2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LogLevel2_Default(pSDepSlnRunLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGLEVEL2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogTime(boolean bl, PSDepSlnRunLog pSDepSlnRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnRunLog.isLogTimeDirty() && !bl2 : !pSDepSlnRunLog.isLogTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDepSlnRunLog.getLogTime();
        if (bl) {
            if (bl2 && timestamp == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGTIME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_LogTime_Default(pSDepSlnRunLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDeSlnASId(boolean bl, PSDepSlnRunLog pSDepSlnRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnRunLog.isPSDeSlnASIdDirty() : !pSDepSlnRunLog.isPSDeSlnASIdDirty()) {
            return null;
        }
        String string = pSDepSlnRunLog.getPSDeSlnASId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDeSlnASId_Default(pSDepSlnRunLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNASID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnASName(boolean bl, PSDepSlnRunLog pSDepSlnRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnRunLog.isPSDepSlnASNameDirty() : !pSDepSlnRunLog.isPSDepSlnASNameDirty()) {
            return null;
        }
        String string = pSDepSlnRunLog.getPSDepSlnASName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnASName_Default(pSDepSlnRunLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNASNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnId(boolean bl, PSDepSlnRunLog pSDepSlnRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnRunLog.isPSDepSlnIdDirty() : !pSDepSlnRunLog.isPSDepSlnIdDirty()) {
            return null;
        }
        String string = pSDepSlnRunLog.getPSDepSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnId_Default(pSDepSlnRunLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnModeId(boolean bl, PSDepSlnRunLog pSDepSlnRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnRunLog.isPSDepSlnModeIdDirty() : !pSDepSlnRunLog.isPSDepSlnModeIdDirty()) {
            return null;
        }
        String string = pSDepSlnRunLog.getPSDepSlnModeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnModeId_Default(pSDepSlnRunLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNMODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnModeName(boolean bl, PSDepSlnRunLog pSDepSlnRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnRunLog.isPSDepSlnModeNameDirty() : !pSDepSlnRunLog.isPSDepSlnModeNameDirty()) {
            return null;
        }
        String string = pSDepSlnRunLog.getPSDepSlnModeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnModeName_Default(pSDepSlnRunLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNMODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnName(boolean bl, PSDepSlnRunLog pSDepSlnRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnRunLog.isPSDepSlnNameDirty() : !pSDepSlnRunLog.isPSDepSlnNameDirty()) {
            return null;
        }
        String string = pSDepSlnRunLog.getPSDepSlnName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnName_Default(pSDepSlnRunLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnPrdId(boolean bl, PSDepSlnRunLog pSDepSlnRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnRunLog.isPSDepSlnPrdIdDirty() : !pSDepSlnRunLog.isPSDepSlnPrdIdDirty()) {
            return null;
        }
        String string = pSDepSlnRunLog.getPSDepSlnPrdId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnPrdId_Default(pSDepSlnRunLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNPRDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnPrdName(boolean bl, PSDepSlnRunLog pSDepSlnRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnRunLog.isPSDepSlnPrdNameDirty() : !pSDepSlnRunLog.isPSDepSlnPrdNameDirty()) {
            return null;
        }
        String string = pSDepSlnRunLog.getPSDepSlnPrdName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnPrdName_Default(pSDepSlnRunLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNPRDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnRunLogId(boolean bl, PSDepSlnRunLog pSDepSlnRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnRunLog.isPSDepSlnRunLogIdDirty() && !bl2 : !pSDepSlnRunLog.isPSDepSlnRunLogIdDirty()) {
            return null;
        }
        String string = pSDepSlnRunLog.getPSDepSlnRunLogId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNRUNLOGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnRunLogId_Default(pSDepSlnRunLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNRUNLOGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnRunLogName(boolean bl, PSDepSlnRunLog pSDepSlnRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnRunLog.isPSDepSlnRunLogNameDirty() && !bl2 : !pSDepSlnRunLog.isPSDepSlnRunLogNameDirty()) {
            return null;
        }
        String string = pSDepSlnRunLog.getPSDepSlnRunLogName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNRUNLOGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnRunLogName_Default(pSDepSlnRunLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNRUNLOGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDepSlnRunLog pSDepSlnRunLog, boolean bl) throws Exception {
        super.onSyncEntity(pSDepSlnRunLog, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnRunLog pSDepSlnRunLog, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDepSlnRunLog, bl);
    }

    public Object getDataContextValue(PSDepSlnRunLog pSDepSlnRunLog, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDepSlnRunLog, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnRunLog pSDepSlnRunLog, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDepSlnRunLog, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGINFO2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogInfo2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGLEVEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogLevel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGLEVEL2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogLevel2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNASID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDeSlnASId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNASNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnASName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNMODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnModeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNMODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnModeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNPRDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnPrdId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNPRDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnPrdName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNRUNLOGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnRunLogId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNRUNLOGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnRunLogName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_LogInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGINFO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogInfo2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGINFO2", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogLevel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGLEVEL", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogLevel2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDeSlnASId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNASID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnASName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNASNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDepSlnModeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNMODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnModeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNMODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDepSlnPrdId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNPRDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnPrdName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNPRDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnRunLogId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNRUNLOGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnRunLogName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNRUNLOGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDepSlnRunLog pSDepSlnRunLog) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDepSlnRunLog)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnRunLog pSDepSlnRunLog) throws Exception {
        super.onUpdateParent(pSDepSlnRunLog);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnRunLog pSDepSlnRunLog, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNRUNLOG");
        if (!bl) {
            pSDepSlnRunLog.setLogLevel2(null);
            super.exportCurXmlModel(pSDepSlnRunLog, xmlNode, bl);
        }
    }
}

