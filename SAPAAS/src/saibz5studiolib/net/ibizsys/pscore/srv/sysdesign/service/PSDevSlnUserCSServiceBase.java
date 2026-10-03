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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnUserCSDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnUserCSDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnCodeServer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnCodeServerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTemplBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnUserCS;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnCSSessionService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnUserCSServiceBase
extends PSCoreSysServiceBase<PSDevSlnUserCS> {
    private static final Log log = LogFactory.getLog(PSDevSlnUserCSServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevSlnUserCSDEModel pSDevSlnUserCSDEModel;
    private PSDevSlnUserCSDAO pSDevSlnUserCSDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserCSService";
    }

    public PSDevSlnUserCSDEModel getPSDevSlnUserCSDEModel() {
        if (this.pSDevSlnUserCSDEModel == null) {
            try {
                this.pSDevSlnUserCSDEModel = (PSDevSlnUserCSDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnUserCSDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnUserCSDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnUserCSDEModel();
    }

    public PSDevSlnUserCSDAO getPSDevSlnUserCSDAO() {
        if (this.pSDevSlnUserCSDAO == null) {
            try {
                this.pSDevSlnUserCSDAO = (PSDevSlnUserCSDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnUserCSDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnUserCSDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnUserCSDAO();
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

    protected void onFillParentInfo(PSDevSlnUserCS pSDevSlnUserCS, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNUSERCS_PSDEVSLNCODESERVER_PSDEVSLNCODESERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnCodeServerService", (SessionFactory)this.getSessionFactory());
            PSDevSlnCodeServer pSDevSlnCodeServer = (PSDevSlnCodeServer)iService.getDEModel().createEntity();
            pSDevSlnCodeServer.set("PSDEVSLNCODESERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnCodeServer);
            } else {
                iService.get(pSDevSlnCodeServer);
            }
            this.onFillParentInfo_PSDevSlnCodeServer(pSDevSlnUserCS, pSDevSlnCodeServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNUSERCS_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSys);
            } else {
                iService.get(pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnUserCS, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNUSERCS_PSDEVSLNTEMPL_PSDEVSLNTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService", (SessionFactory)this.getSessionFactory());
            PSDevSlnTempl pSDevSlnTempl = (PSDevSlnTempl)iService.getDEModel().createEntity();
            pSDevSlnTempl.set("PSDEVSLNTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnTempl);
            } else {
                iService.get(pSDevSlnTempl);
            }
            this.onFillParentInfo_PSDevSlnTempl(pSDevSlnUserCS, pSDevSlnTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNUSERCS_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSln);
            } else {
                iService.get(pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDevSlnUserCS, pSDevSln);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNUSERCS_PSDEVUSER_PSDEVUSERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevUserService", (SessionFactory)this.getSessionFactory());
            PSDevUser pSDevUser = (PSDevUser)iService.getDEModel().createEntity();
            pSDevUser.set("PSDEVUSERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevUser);
            } else {
                iService.get(pSDevUser);
            }
            this.onFillParentInfo_PSDevUser(pSDevSlnUserCS, pSDevUser);
            return;
        }
        super.onFillParentInfo(pSDevSlnUserCS, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevSlnCodeServer(PSDevSlnUserCS pSDevSlnUserCS, PSDevSlnCodeServer pSDevSlnCodeServer) throws Exception {
        pSDevSlnUserCS.setPSDevSlnCodeServerId(pSDevSlnCodeServer.getPSDevSlnCodeServerId());
        pSDevSlnUserCS.setPSDevSlnCodeServerName(pSDevSlnCodeServer.getPSDevSlnCodeServerName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDevSlnUserCS pSDevSlnUserCS, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnUserCS.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSlnUserCS.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillParentInfo_PSDevSlnTempl(PSDevSlnUserCS pSDevSlnUserCS, PSDevSlnTempl pSDevSlnTempl) throws Exception {
        pSDevSlnUserCS.setPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
        pSDevSlnUserCS.setPSDevSlnTemplName(pSDevSlnTempl.getPSDevSlnTemplName());
    }

    protected void onFillParentInfo_PSDevSln(PSDevSlnUserCS pSDevSlnUserCS, PSDevSln pSDevSln) throws Exception {
        pSDevSlnUserCS.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDevSlnUserCS.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillParentInfo_PSDevUser(PSDevSlnUserCS pSDevSlnUserCS, PSDevUser pSDevUser) throws Exception {
        pSDevSlnUserCS.setPSDevUserId(pSDevUser.getPSDevUserId());
        pSDevSlnUserCS.setPSDevUserName(pSDevUser.getPSDevUserName());
    }

    protected void onFillEntityFullInfo(PSDevSlnUserCS pSDevSlnUserCS, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDevSlnUserCS, bl);
        this.onFillEntityFullInfo_PSDevSlnCodeServer(pSDevSlnUserCS, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDevSlnUserCS, bl);
        this.onFillEntityFullInfo_PSDevSlnTempl(pSDevSlnUserCS, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDevSlnUserCS, bl);
        this.onFillEntityFullInfo_PSDevUser(pSDevSlnUserCS, bl);
    }

    protected void onFillEntityFullInfo_PSDevSlnCodeServer(PSDevSlnUserCS pSDevSlnUserCS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDevSlnUserCS pSDevSlnUserCS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnTempl(PSDevSlnUserCS pSDevSlnUserCS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDevSlnUserCS pSDevSlnUserCS, boolean bl) throws Exception {
        if (pSDevSlnUserCS.isPSDevSlnIdDirty()) {
            if (pSDevSlnUserCS.getPSDevSlnId() != null) {
                if (pSDevSlnUserCS.getPSDevSlnId() == null || pSDevSlnUserCS.getPSDevSlnName() == null) {
                    PSDevSln pSDevSln = pSDevSlnUserCS.getPSDevSln();
                    pSDevSlnUserCS.setPSDevSlnName(pSDevSln.getPSDevSlnName());
                }
            } else {
                pSDevSlnUserCS.setPSDevSlnName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevUser(PSDevSlnUserCS pSDevSlnUserCS, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevSlnUserCS pSDevSlnUserCS, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevSlnUserCS, bl);
    }

    public ArrayList<PSDevSlnUserCS> selectByPSDevSlnCodeServer(PSDevSlnCodeServerBase pSDevSlnCodeServerBase) throws Exception {
        return this.selectByPSDevSlnCodeServer(pSDevSlnCodeServerBase, "", -1);
    }

    public ArrayList<PSDevSlnUserCS> selectByPSDevSlnCodeServer(PSDevSlnCodeServerBase pSDevSlnCodeServerBase, String string) throws Exception {
        return this.selectByPSDevSlnCodeServer(pSDevSlnCodeServerBase, string, -1);
    }

    public ArrayList<PSDevSlnUserCS> selectByPSDevSlnCodeServer(PSDevSlnCodeServerBase pSDevSlnCodeServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNCODESERVERID", (Object)pSDevSlnCodeServerBase.getPSDevSlnCodeServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnCodeServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnCodeServerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnUserCS> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnUserCS> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnUserCS> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnUserCS> selectByPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase) throws Exception {
        return this.selectByPSDevSlnTempl(pSDevSlnTemplBase, "", -1);
    }

    public ArrayList<PSDevSlnUserCS> selectByPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase, String string) throws Exception {
        return this.selectByPSDevSlnTempl(pSDevSlnTemplBase, string, -1);
    }

    public ArrayList<PSDevSlnUserCS> selectByPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNTEMPLID", (Object)pSDevSlnTemplBase.getPSDevSlnTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnUserCS> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDevSlnUserCS> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDevSlnUserCS> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnUserCS> selectByPSDevUser(PSDevUserBase pSDevUserBase) throws Exception {
        return this.selectByPSDevUser(pSDevUserBase, "", -1);
    }

    public ArrayList<PSDevSlnUserCS> selectByPSDevUser(PSDevUserBase pSDevUserBase, String string) throws Exception {
        return this.selectByPSDevUser(pSDevUserBase, string, -1);
    }

    public ArrayList<PSDevSlnUserCS> selectByPSDevUser(PSDevUserBase pSDevUserBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVUSERID", (Object)pSDevUserBase.getPSDevUserId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevUserCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevUserCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevSlnCodeServer(PSDevSlnCodeServer pSDevSlnCodeServer) throws Exception {
        ArrayList<PSDevSlnUserCS> arrayList = this.selectByPSDevSlnCodeServer(pSDevSlnCodeServer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNCODESERVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnCodeServer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNUSERCS_PSDEVSLNCODESERVER_PSDEVSLNCODESERVERID", "", iDataEntityModel.getName(), "PSDEVSLNUSERCS", iDataEntityModel.getDataInfo(pSDevSlnCodeServer), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnCodeServer(PSDevSlnCodeServer pSDevSlnCodeServer) throws Exception {
        ArrayList<PSDevSlnUserCS> arrayList = this.selectByPSDevSlnCodeServer(pSDevSlnCodeServer);
        for (PSDevSlnUserCS pSDevSlnUserCS : arrayList) {
            PSDevSlnUserCS pSDevSlnUserCS2 = (PSDevSlnUserCS)this.getDEModel().createEntity();
            pSDevSlnUserCS2.setPSDevSlnUserCSId(pSDevSlnUserCS.getPSDevSlnUserCSId());
            pSDevSlnUserCS2.setPSDevSlnCodeServerId(null);
            this.update(pSDevSlnUserCS2);
        }
    }

    public void removeByPSDevSlnCodeServer(PSDevSlnCodeServer pSDevSlnCodeServer) throws Exception {
        final PSDevSlnCodeServer pSDevSlnCodeServer2 = pSDevSlnCodeServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnUserCSServiceBase.this.onBeforeRemoveByPSDevSlnCodeServer(pSDevSlnCodeServer2);
                PSDevSlnUserCSServiceBase.this.internalRemoveByPSDevSlnCodeServer(pSDevSlnCodeServer2);
                PSDevSlnUserCSServiceBase.this.onAfterRemoveByPSDevSlnCodeServer(pSDevSlnCodeServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnCodeServer(PSDevSlnCodeServer pSDevSlnCodeServer) throws Exception {
    }

    protected void internalRemoveByPSDevSlnCodeServer(PSDevSlnCodeServer pSDevSlnCodeServer) throws Exception {
        ArrayList<PSDevSlnUserCS> arrayList = this.selectByPSDevSlnCodeServer(pSDevSlnCodeServer);
        this.onBeforeRemoveByPSDevSlnCodeServer(pSDevSlnCodeServer, arrayList);
        for (PSDevSlnUserCS pSDevSlnUserCS : arrayList) {
            this.remove(pSDevSlnUserCS);
        }
        this.onAfterRemoveByPSDevSlnCodeServer(pSDevSlnCodeServer, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnCodeServer(PSDevSlnCodeServer pSDevSlnCodeServer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnCodeServer(PSDevSlnCodeServer pSDevSlnCodeServer, ArrayList<PSDevSlnUserCS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnCodeServer(PSDevSlnCodeServer pSDevSlnCodeServer, ArrayList<PSDevSlnUserCS> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnUserCS> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNUSERCS_PSDEVSLNSYS_PSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSDEVSLNUSERCS", iDataEntityModel.getDataInfo(pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnUserCS> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnUserCS pSDevSlnUserCS : arrayList) {
            PSDevSlnUserCS pSDevSlnUserCS2 = (PSDevSlnUserCS)this.getDEModel().createEntity();
            pSDevSlnUserCS2.setPSDevSlnUserCSId(pSDevSlnUserCS.getPSDevSlnUserCSId());
            pSDevSlnUserCS2.setPSDevSlnSysId(null);
            this.update(pSDevSlnUserCS2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnUserCSServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnUserCSServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnUserCSServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnUserCS> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnUserCS pSDevSlnUserCS : arrayList) {
            this.remove(pSDevSlnUserCS);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnUserCS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnUserCS> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        ArrayList<PSDevSlnUserCS> arrayList = this.selectByPSDevSlnTempl(pSDevSlnTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNUSERCS_PSDEVSLNTEMPL_PSDEVSLNTEMPLID", "", iDataEntityModel.getName(), "PSDEVSLNUSERCS", iDataEntityModel.getDataInfo(pSDevSlnTempl), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        ArrayList<PSDevSlnUserCS> arrayList = this.selectByPSDevSlnTempl(pSDevSlnTempl);
        for (PSDevSlnUserCS pSDevSlnUserCS : arrayList) {
            PSDevSlnUserCS pSDevSlnUserCS2 = (PSDevSlnUserCS)this.getDEModel().createEntity();
            pSDevSlnUserCS2.setPSDevSlnUserCSId(pSDevSlnUserCS.getPSDevSlnUserCSId());
            pSDevSlnUserCS2.setPSDevSlnTemplId(null);
            this.update(pSDevSlnUserCS2);
        }
    }

    public void removeByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        final PSDevSlnTempl pSDevSlnTempl2 = pSDevSlnTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnUserCSServiceBase.this.onBeforeRemoveByPSDevSlnTempl(pSDevSlnTempl2);
                PSDevSlnUserCSServiceBase.this.internalRemoveByPSDevSlnTempl(pSDevSlnTempl2);
                PSDevSlnUserCSServiceBase.this.onAfterRemoveByPSDevSlnTempl(pSDevSlnTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
    }

    protected void internalRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        ArrayList<PSDevSlnUserCS> arrayList = this.selectByPSDevSlnTempl(pSDevSlnTempl);
        this.onBeforeRemoveByPSDevSlnTempl(pSDevSlnTempl, arrayList);
        for (PSDevSlnUserCS pSDevSlnUserCS : arrayList) {
            this.remove(pSDevSlnUserCS);
        }
        this.onAfterRemoveByPSDevSlnTempl(pSDevSlnTempl, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl, ArrayList<PSDevSlnUserCS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl, ArrayList<PSDevSlnUserCS> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnUserCS> arrayList = this.selectByPSDevSln(pSDevSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNUSERCS_PSDEVSLN_PSDEVSLNID", "", iDataEntityModel.getName(), "PSDEVSLNUSERCS", iDataEntityModel.getDataInfo(pSDevSln), arrayList.get(0)));
        }
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnUserCS> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDevSlnUserCS pSDevSlnUserCS : arrayList) {
            PSDevSlnUserCS pSDevSlnUserCS2 = (PSDevSlnUserCS)this.getDEModel().createEntity();
            pSDevSlnUserCS2.setPSDevSlnUserCSId(pSDevSlnUserCS.getPSDevSlnUserCSId());
            pSDevSlnUserCS2.setPSDevSlnId(null);
            this.update(pSDevSlnUserCS2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnUserCSServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDevSlnUserCSServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDevSlnUserCSServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnUserCS> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDevSlnUserCS pSDevSlnUserCS : arrayList) {
            this.remove(pSDevSlnUserCS);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnUserCS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnUserCS> arrayList) throws Exception {
    }

    public void testRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
        ArrayList<PSDevSlnUserCS> arrayList = this.selectByPSDevUser(pSDevUser, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVUSER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevUser);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNUSERCS_PSDEVUSER_PSDEVUSERID", "", iDataEntityModel.getName(), "PSDEVSLNUSERCS", iDataEntityModel.getDataInfo(pSDevUser), arrayList.get(0)));
        }
    }

    public void resetPSDevUser(PSDevUser pSDevUser) throws Exception {
        ArrayList<PSDevSlnUserCS> arrayList = this.selectByPSDevUser(pSDevUser);
        for (PSDevSlnUserCS pSDevSlnUserCS : arrayList) {
            PSDevSlnUserCS pSDevSlnUserCS2 = (PSDevSlnUserCS)this.getDEModel().createEntity();
            pSDevSlnUserCS2.setPSDevSlnUserCSId(pSDevSlnUserCS.getPSDevSlnUserCSId());
            pSDevSlnUserCS2.setPSDevUserId(null);
            this.update(pSDevSlnUserCS2);
        }
    }

    public void removeByPSDevUser(PSDevUser pSDevUser) throws Exception {
        final PSDevUser pSDevUser2 = pSDevUser;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnUserCSServiceBase.this.onBeforeRemoveByPSDevUser(pSDevUser2);
                PSDevSlnUserCSServiceBase.this.internalRemoveByPSDevUser(pSDevUser2);
                PSDevSlnUserCSServiceBase.this.onAfterRemoveByPSDevUser(pSDevUser2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
    }

    protected void internalRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
        ArrayList<PSDevSlnUserCS> arrayList = this.selectByPSDevUser(pSDevUser);
        this.onBeforeRemoveByPSDevUser(pSDevUser, arrayList);
        for (PSDevSlnUserCS pSDevSlnUserCS : arrayList) {
            this.remove(pSDevSlnUserCS);
        }
        this.onAfterRemoveByPSDevUser(pSDevUser, arrayList);
    }

    protected void onAfterRemoveByPSDevUser(PSDevUser pSDevUser) throws Exception {
    }

    protected void onBeforeRemoveByPSDevUser(PSDevUser pSDevUser, ArrayList<PSDevSlnUserCS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevUser(PSDevUser pSDevUser, ArrayList<PSDevSlnUserCS> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnUserCS pSDevSlnUserCS) throws Exception {
        PSDevSlnCSSessionService pSDevSlnCSSessionService = (PSDevSlnCSSessionService)ServiceGlobal.getService(PSDevSlnCSSessionService.class, (SessionFactory)this.getSessionFactory());
        pSDevSlnCSSessionService.testRemoveByPSDevSlnUserCS(pSDevSlnUserCS);
        super.onBeforeRemove(pSDevSlnUserCS);
    }

    protected void replaceParentInfo(PSDevSlnUserCS pSDevSlnUserCS, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevSlnUserCS, cloneSession);
        if (pSDevSlnUserCS.getPSDevSlnCodeServerId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNCODESERVER", (Object)pSDevSlnUserCS.getPSDevSlnCodeServerId())) != null) {
            this.onFillParentInfo_PSDevSlnCodeServer(pSDevSlnUserCS, (PSDevSlnCodeServer)iEntity);
        }
        if (pSDevSlnUserCS.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnUserCS.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnUserCS, (PSDevSlnSys)iEntity);
        }
        if (pSDevSlnUserCS.getPSDevSlnTemplId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNTEMPL", (Object)pSDevSlnUserCS.getPSDevSlnTemplId())) != null) {
            this.onFillParentInfo_PSDevSlnTempl(pSDevSlnUserCS, (PSDevSlnTempl)iEntity);
        }
        if (pSDevSlnUserCS.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDevSlnUserCS.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnUserCS, (PSDevSln)iEntity);
        }
        if (pSDevSlnUserCS.getPSDevUserId() != null && (iEntity = cloneSession.getEntity("PSDEVUSER", (Object)pSDevSlnUserCS.getPSDevUserId())) != null) {
            this.onFillParentInfo_PSDevUser(pSDevSlnUserCS, (PSDevUser)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnUserCS pSDevSlnUserCS, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevSlnUserCS, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllUserFlag(bl, pSDevSlnUserCS, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeTarget(bl, pSDevSlnUserCS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CSParam(bl, pSDevSlnUserCS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CSParam2(bl, pSDevSlnUserCS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CSParam3(bl, pSDevSlnUserCS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CSParam4(bl, pSDevSlnUserCS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CSParams(bl, pSDevSlnUserCS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpriedTime(bl, pSDevSlnUserCS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HostPasswd(bl, pSDevSlnUserCS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HostUserName(bl, pSDevSlnUserCS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnUserCS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnCodeServerId(bl, pSDevSlnUserCS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDevSlnUserCS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnName(bl, pSDevSlnUserCS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevSlnUserCS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnTemplId(bl, pSDevSlnUserCS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnUserCSId(bl, pSDevSlnUserCS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnUserCSName(bl, pSDevSlnUserCS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevUserId(bl, pSDevSlnUserCS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReadOnlyMode(bl, pSDevSlnUserCS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResReadyTime(bl, pSDevSlnUserCS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResState(bl, pSDevSlnUserCS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevSlnUserCS, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllUserFlag(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUserCS.isAllUserFlagDirty() && !bl2 : !pSDevSlnUserCS.isAllUserFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnUserCS.getAllUserFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLUSERFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_AllUserFlag_Default(pSDevSlnUserCS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLUSERFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeTarget(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUserCS.isCodeTargetDirty() && !bl2 : !pSDevSlnUserCS.isCodeTargetDirty()) {
            return null;
        }
        String string = pSDevSlnUserCS.getCodeTarget();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODETARGET");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeTarget_Default(pSDevSlnUserCS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODETARGET");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CSParam(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUserCS.isCSParamDirty() : !pSDevSlnUserCS.isCSParamDirty()) {
            return null;
        }
        String string = pSDevSlnUserCS.getCSParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CSParam_Default(pSDevSlnUserCS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CSParam2(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUserCS.isCSParam2Dirty() : !pSDevSlnUserCS.isCSParam2Dirty()) {
            return null;
        }
        String string = pSDevSlnUserCS.getCSParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CSParam2_Default(pSDevSlnUserCS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CSParam3(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUserCS.isCSParam3Dirty() : !pSDevSlnUserCS.isCSParam3Dirty()) {
            return null;
        }
        Integer n = pSDevSlnUserCS.getCSParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CSParam3_Default(pSDevSlnUserCS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CSParam4(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUserCS.isCSParam4Dirty() : !pSDevSlnUserCS.isCSParam4Dirty()) {
            return null;
        }
        Integer n = pSDevSlnUserCS.getCSParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CSParam4_Default(pSDevSlnUserCS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CSParams(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUserCS.isCSParamsDirty() : !pSDevSlnUserCS.isCSParamsDirty()) {
            return null;
        }
        String string = pSDevSlnUserCS.getCSParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CSParams_Default(pSDevSlnUserCS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpriedTime(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUserCS.isExpriedTimeDirty() : !pSDevSlnUserCS.isExpriedTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnUserCS.getExpriedTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpriedTime_Default(pSDevSlnUserCS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPRIEDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HostPasswd(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUserCS.isHostPasswdDirty() : !pSDevSlnUserCS.isHostPasswdDirty()) {
            return null;
        }
        String string = pSDevSlnUserCS.getHostPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HostPasswd_Default(pSDevSlnUserCS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HOSTPASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HostUserName(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUserCS.isHostUserNameDirty() : !pSDevSlnUserCS.isHostUserNameDirty()) {
            return null;
        }
        String string = pSDevSlnUserCS.getHostUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HostUserName_Default(pSDevSlnUserCS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HOSTUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUserCS.isMemoDirty() : !pSDevSlnUserCS.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnUserCS.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevSlnUserCS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnCodeServerId(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUserCS.isPSDevSlnCodeServerIdDirty() : !pSDevSlnUserCS.isPSDevSlnCodeServerIdDirty()) {
            return null;
        }
        String string = pSDevSlnUserCS.getPSDevSlnCodeServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnCodeServerId_Default(pSDevSlnUserCS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNCODESERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUserCS.isPSDevSlnIdDirty() : !pSDevSlnUserCS.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDevSlnUserCS.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default(pSDevSlnUserCS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnName(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUserCS.isPSDevSlnNameDirty() : !pSDevSlnUserCS.isPSDevSlnNameDirty()) {
            return null;
        }
        String string = pSDevSlnUserCS.getPSDevSlnName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnName_Default(pSDevSlnUserCS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUserCS.isPSDevSlnSysIdDirty() : !pSDevSlnUserCS.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnUserCS.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default(pSDevSlnUserCS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnTemplId(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUserCS.isPSDevSlnTemplIdDirty() : !pSDevSlnUserCS.isPSDevSlnTemplIdDirty()) {
            return null;
        }
        String string = pSDevSlnUserCS.getPSDevSlnTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnTemplId_Default(pSDevSlnUserCS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnUserCSId(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUserCS.isPSDevSlnUserCSIdDirty() && !bl2 : !pSDevSlnUserCS.isPSDevSlnUserCSIdDirty()) {
            return null;
        }
        String string = pSDevSlnUserCS.getPSDevSlnUserCSId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNUSERCSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnUserCSId_Default(pSDevSlnUserCS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNUSERCSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnUserCSName(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUserCS.isPSDevSlnUserCSNameDirty() && !bl2 : !pSDevSlnUserCS.isPSDevSlnUserCSNameDirty()) {
            return null;
        }
        String string = pSDevSlnUserCS.getPSDevSlnUserCSName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNUSERCSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnUserCSName_Default(pSDevSlnUserCS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNUSERCSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevUserId(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUserCS.isPSDevUserIdDirty() : !pSDevSlnUserCS.isPSDevUserIdDirty()) {
            return null;
        }
        String string = pSDevSlnUserCS.getPSDevUserId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevUserId_Default(pSDevSlnUserCS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVUSERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ReadOnlyMode(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUserCS.isReadOnlyModeDirty() && !bl2 : !pSDevSlnUserCS.isReadOnlyModeDirty()) {
            return null;
        }
        Integer n = pSDevSlnUserCS.getReadOnlyMode();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("READONLYMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ReadOnlyMode_Default(pSDevSlnUserCS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("READONLYMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResReadyTime(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUserCS.isResReadyTimeDirty() : !pSDevSlnUserCS.isResReadyTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnUserCS.getResReadyTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResReadyTime_Default(pSDevSlnUserCS, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResState(boolean bl, PSDevSlnUserCS pSDevSlnUserCS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnUserCS.isResStateDirty() : !pSDevSlnUserCS.isResStateDirty()) {
            return null;
        }
        Integer n = pSDevSlnUserCS.getResState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResState_Default(pSDevSlnUserCS, bl2, bl3);
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

    protected void onSyncEntity(PSDevSlnUserCS pSDevSlnUserCS, boolean bl) throws Exception {
        super.onSyncEntity(pSDevSlnUserCS, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnUserCS pSDevSlnUserCS, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevSlnUserCS, bl);
    }

    public Object getDataContextValue(PSDevSlnUserCS pSDevSlnUserCS, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevSlnUserCS, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnUserCS pSDevSlnUserCS, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevSlnUserCS, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLUSERFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllUserFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODETARGET", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeTarget_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPRIEDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpriedTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HOSTPASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HostPasswd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HOSTUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HostUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNCODESERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnCodeServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNCODESERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnCodeServerName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEVSLNTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNUSERCSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnUserCSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNUSERCSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnUserCSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVUSERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevUserId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"READONLYMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReadOnlyMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESREADYTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResReadyTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AllUserFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CodeTarget_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODETARGET", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_CSParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSPARAM", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CSParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSPARAM2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CSParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CSParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CSParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExpriedTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HostPasswd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HOSTPASSWD", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HostUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HOSTUSERNAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected String onTestValueRule_PSDevSlnCodeServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNCODESERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnCodeServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNCODESERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDevSlnTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNTEMPLNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnUserCSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNUSERCSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnUserCSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNUSERCSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevUserId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVUSERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVUSERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ReadOnlyMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResReadyTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected boolean onMergeChild(String string, String string2, PSDevSlnUserCS pSDevSlnUserCS) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevSlnUserCS)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnUserCS pSDevSlnUserCS) throws Exception {
        super.onUpdateParent(pSDevSlnUserCS);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnUserCS pSDevSlnUserCS, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNUSERCS");
        if (!bl) {
            pSDevSlnUserCS.setCreateDate(null);
            pSDevSlnUserCS.setCreateMan(null);
            pSDevSlnUserCS.setPSDevSlnCodeServerName(null);
            pSDevSlnUserCS.setPSDevSlnSysName(null);
            pSDevSlnUserCS.setPSDevSlnTemplName(null);
            pSDevSlnUserCS.setPSDevSlnUserCSId(null);
            pSDevSlnUserCS.setPSDevUserName(null);
            pSDevSlnUserCS.setUpdateDate(null);
            pSDevSlnUserCS.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnUserCS, xmlNode, bl);
        }
    }
}

