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
package net.ibizsys.pscore.srv.devcenter.service;

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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCTaskLogDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCTaskLogDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCTaskLog;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCTaskLogServiceBase
extends PSCoreSysServiceBase<PSDCTaskLog> {
    private static final Log log = LogFactory.getLog(PSDCTaskLogServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCTaskLogDEModel pSDCTaskLogDEModel;
    private PSDCTaskLogDAO pSDCTaskLogDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCTaskLogService";
    }

    public PSDCTaskLogDEModel getPSDCTaskLogDEModel() {
        if (this.pSDCTaskLogDEModel == null) {
            try {
                this.pSDCTaskLogDEModel = (PSDCTaskLogDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCTaskLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCTaskLogDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCTaskLogDEModel();
    }

    public PSDCTaskLogDAO getPSDCTaskLogDAO() {
        if (this.pSDCTaskLogDAO == null) {
            try {
                this.pSDCTaskLogDAO = (PSDCTaskLogDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCTaskLogDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCTaskLogDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCTaskLogDAO();
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

    protected void onFillParentInfo(PSDCTaskLog pSDCTaskLog, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCTASKLOG_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCTaskLog, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCTASKLOG_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSys);
            } else {
                iService.get(pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDCTaskLog, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCTASKLOG_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSln);
            } else {
                iService.get(pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDCTaskLog, pSDevSln);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCTASKLOG_PSTASKSERVER_PSTASKSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService", (SessionFactory)this.getSessionFactory());
            PSTaskServer pSTaskServer = (PSTaskServer)iService.getDEModel().createEntity();
            pSTaskServer.set("PSTASKSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSTaskServer);
            } else {
                iService.get(pSTaskServer);
            }
            this.onFillParentInfo_PSTaskServer(pSDCTaskLog, pSTaskServer);
            return;
        }
        super.onFillParentInfo(pSDCTaskLog, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSDCTaskLog pSDCTaskLog, PSDevCenter pSDevCenter) throws Exception {
        pSDCTaskLog.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCTaskLog.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDCTaskLog pSDCTaskLog, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDCTaskLog.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDCTaskLog.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillParentInfo_PSDevSln(PSDCTaskLog pSDCTaskLog, PSDevSln pSDevSln) throws Exception {
        pSDCTaskLog.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDCTaskLog.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillParentInfo_PSTaskServer(PSDCTaskLog pSDCTaskLog, PSTaskServer pSTaskServer) throws Exception {
        pSDCTaskLog.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
        pSDCTaskLog.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
    }

    protected void onFillEntityFullInfo(PSDCTaskLog pSDCTaskLog, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDCTaskLog, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCTaskLog, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDCTaskLog, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDCTaskLog, bl);
        this.onFillEntityFullInfo_PSTaskServer(pSDCTaskLog, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCTaskLog pSDCTaskLog, boolean bl) throws Exception {
        if (pSDCTaskLog.isPSDevCenterIdDirty()) {
            if (pSDCTaskLog.getPSDevCenterId() != null) {
                if (pSDCTaskLog.getPSDevCenterId() == null || pSDCTaskLog.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCTaskLog.getPSDevCenter();
                    pSDCTaskLog.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCTaskLog.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDCTaskLog pSDCTaskLog, boolean bl) throws Exception {
        if (pSDCTaskLog.isPSDevSlnSysIdDirty()) {
            if (pSDCTaskLog.getPSDevSlnSysId() != null) {
                if (pSDCTaskLog.getPSDevSlnSysId() == null || pSDCTaskLog.getPSDevSlnSysName() == null) {
                    PSDevSlnSys pSDevSlnSys = pSDCTaskLog.getPSDevSlnSys();
                    pSDCTaskLog.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
                }
            } else {
                pSDCTaskLog.setPSDevSlnSysName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDCTaskLog pSDCTaskLog, boolean bl) throws Exception {
        if (pSDCTaskLog.isPSDevSlnIdDirty()) {
            if (pSDCTaskLog.getPSDevSlnId() != null) {
                if (pSDCTaskLog.getPSDevSlnId() == null || pSDCTaskLog.getPSDevSlnName() == null) {
                    PSDevSln pSDevSln = pSDCTaskLog.getPSDevSln();
                    pSDCTaskLog.setPSDevSlnName(pSDevSln.getPSDevSlnName());
                }
            } else {
                pSDCTaskLog.setPSDevSlnName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSTaskServer(PSDCTaskLog pSDCTaskLog, boolean bl) throws Exception {
        if (pSDCTaskLog.isPSTaskServerIdDirty()) {
            if (pSDCTaskLog.getPSTaskServerId() != null) {
                if (pSDCTaskLog.getPSTaskServerId() == null || pSDCTaskLog.getPSTaskServerName() == null) {
                    PSTaskServer pSTaskServer = pSDCTaskLog.getPSTaskServer();
                    pSDCTaskLog.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
                }
            } else {
                pSDCTaskLog.setPSTaskServerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCTaskLog pSDCTaskLog, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCTaskLog, bl);
    }

    public ArrayList<PSDCTaskLog> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCTaskLog> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCTaskLog> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCTaskLog> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDCTaskLog> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDCTaskLog> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCTaskLog> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDCTaskLog> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDCTaskLog> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNID", (Object)pSDevSlnBase.getPSDevSlnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCTaskLog> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, "", -1);
    }

    public ArrayList<PSDCTaskLog> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, string, -1);
    }

    public ArrayList<PSDCTaskLog> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSTASKSERVERID", (Object)pSTaskServerBase.getPSTaskServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSTaskServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSTaskServerCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCTaskLog> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCTASKLOG_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSDCTASKLOG", iDataEntityModel.getDataInfo(pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCTaskLog> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCTaskLog pSDCTaskLog : arrayList) {
            PSDCTaskLog pSDCTaskLog2 = (PSDCTaskLog)this.getDEModel().createEntity();
            pSDCTaskLog2.setPSDCTaskLogId(pSDCTaskLog.getPSDCTaskLogId());
            pSDCTaskLog2.setPSDevCenterId(null);
            this.update(pSDCTaskLog2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCTaskLogServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCTaskLogServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCTaskLogServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCTaskLog> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCTaskLog pSDCTaskLog : arrayList) {
            this.remove(pSDCTaskLog);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCTaskLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCTaskLog> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDCTaskLog> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCTASKLOG_PSDEVSLNSYS_PSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSDCTASKLOG", iDataEntityModel.getDataInfo(pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDCTaskLog> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDCTaskLog pSDCTaskLog : arrayList) {
            PSDCTaskLog pSDCTaskLog2 = (PSDCTaskLog)this.getDEModel().createEntity();
            pSDCTaskLog2.setPSDCTaskLogId(pSDCTaskLog.getPSDCTaskLogId());
            pSDCTaskLog2.setPSDevSlnSysId(null);
            this.update(pSDCTaskLog2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCTaskLogServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDCTaskLogServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDCTaskLogServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDCTaskLog> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDCTaskLog pSDCTaskLog : arrayList) {
            this.remove(pSDCTaskLog);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDCTaskLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDCTaskLog> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCTaskLog> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDCTaskLog pSDCTaskLog : arrayList) {
            PSDCTaskLog pSDCTaskLog2 = (PSDCTaskLog)this.getDEModel().createEntity();
            pSDCTaskLog2.setPSDCTaskLogId(pSDCTaskLog.getPSDCTaskLogId());
            pSDCTaskLog2.setPSDevSlnId(null);
            this.update(pSDCTaskLog2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCTaskLogServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDCTaskLogServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDCTaskLogServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCTaskLog> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDCTaskLog pSDCTaskLog : arrayList) {
            this.remove(pSDCTaskLog);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDCTaskLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDCTaskLog> arrayList) throws Exception {
    }

    public void testRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    public void resetPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSDCTaskLog> arrayList = this.selectByPSTaskServer(pSTaskServer);
        for (PSDCTaskLog pSDCTaskLog : arrayList) {
            PSDCTaskLog pSDCTaskLog2 = (PSDCTaskLog)this.getDEModel().createEntity();
            pSDCTaskLog2.setPSDCTaskLogId(pSDCTaskLog.getPSDCTaskLogId());
            pSDCTaskLog2.setPSTaskServerId(null);
            this.update(pSDCTaskLog2);
        }
    }

    public void removeByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        final PSTaskServer pSTaskServer2 = pSTaskServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCTaskLogServiceBase.this.onBeforeRemoveByPSTaskServer(pSTaskServer2);
                PSDCTaskLogServiceBase.this.internalRemoveByPSTaskServer(pSTaskServer2);
                PSDCTaskLogServiceBase.this.onAfterRemoveByPSTaskServer(pSTaskServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void internalRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSDCTaskLog> arrayList = this.selectByPSTaskServer(pSTaskServer);
        this.onBeforeRemoveByPSTaskServer(pSTaskServer, arrayList);
        for (PSDCTaskLog pSDCTaskLog : arrayList) {
            this.remove(pSDCTaskLog);
        }
        this.onAfterRemoveByPSTaskServer(pSTaskServer, arrayList);
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSDCTaskLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSDCTaskLog> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCTaskLog pSDCTaskLog) throws Exception {
        super.onBeforeRemove(pSDCTaskLog);
    }

    protected void replaceParentInfo(PSDCTaskLog pSDCTaskLog, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCTaskLog, cloneSession);
        if (pSDCTaskLog.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCTaskLog.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCTaskLog, (PSDevCenter)iEntity);
        }
        if (pSDCTaskLog.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDCTaskLog.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDCTaskLog, (PSDevSlnSys)iEntity);
        }
        if (pSDCTaskLog.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDCTaskLog.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDCTaskLog, (PSDevSln)iEntity);
        }
        if (pSDCTaskLog.getPSTaskServerId() != null && (iEntity = cloneSession.getEntity("PSTASKSERVER", (Object)pSDCTaskLog.getPSTaskServerId())) != null) {
            this.onFillParentInfo_PSTaskServer(pSDCTaskLog, (PSTaskServer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCTaskLog pSDCTaskLog, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCTaskLog, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCTaskLog pSDCTaskLog, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BeginTime(bl, pSDCTaskLog, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Cost(bl, pSDCTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CostLevel(bl, pSDCTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndTime(bl, pSDCTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCTaskLogId(bl, pSDCTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCTaskLogName(bl, pSDCTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDCTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnName(bl, pSDCTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDCTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysName(bl, pSDCTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerId(bl, pSDCTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerName(bl, pSDCTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCTaskLog, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BeginTime(boolean bl, PSDCTaskLog pSDCTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCTaskLog.isBeginTimeDirty() : !pSDCTaskLog.isBeginTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCTaskLog.getBeginTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BeginTime_Default(pSDCTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_Cost(boolean bl, PSDCTaskLog pSDCTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCTaskLog.isCostDirty() : !pSDCTaskLog.isCostDirty()) {
            return null;
        }
        Integer n = pSDCTaskLog.getCost();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Cost_Default(pSDCTaskLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COST");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CostLevel(boolean bl, PSDCTaskLog pSDCTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCTaskLog.isCostLevelDirty() : !pSDCTaskLog.isCostLevelDirty()) {
            return null;
        }
        Integer n = pSDCTaskLog.getCostLevel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CostLevel_Default(pSDCTaskLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COSTLEVEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndTime(boolean bl, PSDCTaskLog pSDCTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCTaskLog.isEndTimeDirty() : !pSDCTaskLog.isEndTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCTaskLog.getEndTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EndTime_Default(pSDCTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCTaskLogId(boolean bl, PSDCTaskLog pSDCTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCTaskLog.isPSDCTaskLogIdDirty() && !bl2 : !pSDCTaskLog.isPSDCTaskLogIdDirty()) {
            return null;
        }
        String string = pSDCTaskLog.getPSDCTaskLogId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCTASKLOGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCTaskLogId_Default(pSDCTaskLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCTASKLOGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCTaskLogName(boolean bl, PSDCTaskLog pSDCTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCTaskLog.isPSDCTaskLogNameDirty() && !bl2 : !pSDCTaskLog.isPSDCTaskLogNameDirty()) {
            return null;
        }
        String string = pSDCTaskLog.getPSDCTaskLogName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCTASKLOGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCTaskLogName_Default(pSDCTaskLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCTASKLOGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCTaskLog pSDCTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCTaskLog.isPSDevCenterIdDirty() : !pSDCTaskLog.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCTaskLog.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDCTaskLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCTaskLog pSDCTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCTaskLog.isPSDevCenterNameDirty() : !pSDCTaskLog.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCTaskLog.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDCTaskLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDCTaskLog pSDCTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCTaskLog.isPSDevSlnIdDirty() : !pSDCTaskLog.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDCTaskLog.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default(pSDCTaskLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnName(boolean bl, PSDCTaskLog pSDCTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCTaskLog.isPSDevSlnNameDirty() : !pSDCTaskLog.isPSDevSlnNameDirty()) {
            return null;
        }
        String string = pSDCTaskLog.getPSDevSlnName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnName_Default(pSDCTaskLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDCTaskLog pSDCTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCTaskLog.isPSDevSlnSysIdDirty() : !pSDCTaskLog.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDCTaskLog.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default(pSDCTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysName(boolean bl, PSDCTaskLog pSDCTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCTaskLog.isPSDevSlnSysNameDirty() : !pSDCTaskLog.isPSDevSlnSysNameDirty()) {
            return null;
        }
        String string = pSDCTaskLog.getPSDevSlnSysName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysName_Default(pSDCTaskLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTaskServerId(boolean bl, PSDCTaskLog pSDCTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCTaskLog.isPSTaskServerIdDirty() : !pSDCTaskLog.isPSTaskServerIdDirty()) {
            return null;
        }
        String string = pSDCTaskLog.getPSTaskServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerId_Default(pSDCTaskLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTASKSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTaskServerName(boolean bl, PSDCTaskLog pSDCTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCTaskLog.isPSTaskServerNameDirty() : !pSDCTaskLog.isPSTaskServerNameDirty()) {
            return null;
        }
        String string = pSDCTaskLog.getPSTaskServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerName_Default(pSDCTaskLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTASKSERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCTaskLog pSDCTaskLog, boolean bl) throws Exception {
        super.onSyncEntity(pSDCTaskLog, bl);
    }

    protected void onSyncIndexEntities(PSDCTaskLog pSDCTaskLog, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCTaskLog, bl);
    }

    public Object getDataContextValue(PSDCTaskLog pSDCTaskLog, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCTaskLog, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCTaskLog pSDCTaskLog, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCTaskLog, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BEGINTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COST", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Cost_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COSTLEVEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CostLevel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCTASKLOGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCTaskLogId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCTASKLOGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCTaskLogName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_Cost_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CostLevel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_EndTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDCTaskLogId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCTASKLOGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCTaskLogName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCTASKLOGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSTaskServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSTASKSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSTaskServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSTASKSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDCTaskLog pSDCTaskLog) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCTaskLog)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCTaskLog pSDCTaskLog) throws Exception {
        super.onUpdateParent(pSDCTaskLog);
    }

    @Override
    protected void exportCurXmlModel(PSDCTaskLog pSDCTaskLog, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCTASKLOG");
        if (!bl) {
            pSDCTaskLog.setCreateDate(null);
            pSDCTaskLog.setCreateMan(null);
            pSDCTaskLog.setPSDCTaskLogId(null);
            pSDCTaskLog.setUpdateDate(null);
            pSDCTaskLog.setUpdateMan(null);
            super.exportCurXmlModel(pSDCTaskLog, xmlNode, bl);
        }
    }
}

