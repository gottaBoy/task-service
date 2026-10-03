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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInstBase;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnDBInstDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnDBInstDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnDBInst;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnHost;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnHostBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysDBService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnDBInstServiceBase
extends PSCoreSysServiceBase<PSDepSlnDBInst> {
    private static final Log log = LogFactory.getLog(PSDepSlnDBInstServiceBase.class);
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnDBInstDEModel pSDepSlnDBInstDEModel;
    private PSDepSlnDBInstDAO pSDepSlnDBInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnDBInstService";
    }

    public PSDepSlnDBInstDEModel getPSDepSlnDBInstDEModel() {
        if (this.pSDepSlnDBInstDEModel == null) {
            try {
                this.pSDepSlnDBInstDEModel = (PSDepSlnDBInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnDBInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnDBInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnDBInstDEModel();
    }

    public PSDepSlnDBInstDAO getPSDepSlnDBInstDAO() {
        if (this.pSDepSlnDBInstDAO == null) {
            try {
                this.pSDepSlnDBInstDAO = (PSDepSlnDBInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnDBInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnDBInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnDBInstDAO();
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

    protected void onFillParentInfo(PSDepSlnDBInst pSDepSlnDBInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNDBINST_PSDEPSLNHOST_PSDEPSLNHOSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnHostService", (SessionFactory)this.getSessionFactory());
            PSDepSlnHost pSDepSlnHost = (PSDepSlnHost)iService.getDEModel().createEntity();
            pSDepSlnHost.set("PSDEPSLNHOSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSlnHost);
            } else {
                iService.get(pSDepSlnHost);
            }
            this.onFillParentInfo_PSDepSlnHost(pSDepSlnDBInst, pSDepSlnHost);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNDBINST_PSDEPSLN_PSDEPSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService", (SessionFactory)this.getSessionFactory());
            PSDepSln pSDepSln = (PSDepSln)iService.getDEModel().createEntity();
            pSDepSln.set("PSDEPSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSln);
            } else {
                iService.get(pSDepSln);
            }
            this.onFillParentInfo_PSDepSln(pSDepSlnDBInst, pSDepSln);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNDBINST_PSDEVCENTERDBINST_PSDEVCENTERDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_PSDevCenterDBInst(pSDepSlnDBInst, pSDevCenterDBInst);
            return;
        }
        super.onFillParentInfo(pSDepSlnDBInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDepSlnHost(PSDepSlnDBInst pSDepSlnDBInst, PSDepSlnHost pSDepSlnHost) throws Exception {
        pSDepSlnDBInst.setPSDepSlnHostId(pSDepSlnHost.getPSDepSlnHostId());
        pSDepSlnDBInst.setPSDepSlnHostName(pSDepSlnHost.getPSDepSlnHostName());
    }

    protected void onFillParentInfo_PSDepSln(PSDepSlnDBInst pSDepSlnDBInst, PSDepSln pSDepSln) throws Exception {
        pSDepSlnDBInst.setPSDepSlnId(pSDepSln.getPSDepSlnId());
        pSDepSlnDBInst.setPSDepSlnName(pSDepSln.getPSDepSlnName());
    }

    protected void onFillParentInfo_PSDevCenterDBInst(PSDepSlnDBInst pSDepSlnDBInst, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDepSlnDBInst.setPSDevCenterDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDepSlnDBInst.setPSDevCenterDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillEntityFullInfo(PSDepSlnDBInst pSDepSlnDBInst, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDepSlnDBInst, bl);
        this.onFillEntityFullInfo_PSDepSlnHost(pSDepSlnDBInst, bl);
        this.onFillEntityFullInfo_PSDepSln(pSDepSlnDBInst, bl);
        this.onFillEntityFullInfo_PSDevCenterDBInst(pSDepSlnDBInst, bl);
    }

    protected void onFillEntityFullInfo_PSDepSlnHost(PSDepSlnDBInst pSDepSlnDBInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSln(PSDepSlnDBInst pSDepSlnDBInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterDBInst(PSDepSlnDBInst pSDepSlnDBInst, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSlnDBInst pSDepSlnDBInst, boolean bl) throws Exception {
        super.onWriteBackParent(pSDepSlnDBInst, bl);
    }

    public ArrayList<PSDepSlnDBInst> selectByPSDepSlnHost(PSDepSlnHostBase pSDepSlnHostBase) throws Exception {
        return this.selectByPSDepSlnHost(pSDepSlnHostBase, "", -1);
    }

    public ArrayList<PSDepSlnDBInst> selectByPSDepSlnHost(PSDepSlnHostBase pSDepSlnHostBase, String string) throws Exception {
        return this.selectByPSDepSlnHost(pSDepSlnHostBase, string, -1);
    }

    public ArrayList<PSDepSlnDBInst> selectByPSDepSlnHost(PSDepSlnHostBase pSDepSlnHostBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNHOSTID", (Object)pSDepSlnHostBase.getPSDepSlnHostId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnHostCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnHostCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnDBInst> selectByPSDepSln(PSDepSlnBase pSDepSlnBase) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, "", -1);
    }

    public ArrayList<PSDepSlnDBInst> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, string, -1);
    }

    public ArrayList<PSDepSlnDBInst> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string, int n) throws Exception {
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

    public ArrayList<PSDepSlnDBInst> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByPSDevCenterDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDepSlnDBInst> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByPSDevCenterDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDepSlnDBInst> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
        ArrayList<PSDepSlnDBInst> arrayList = this.selectByPSDepSlnHost(pSDepSlnHost, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNHOST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDepSlnHost);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNDBINST_PSDEPSLNHOST_PSDEPSLNHOSTID", "", iDataEntityModel.getName(), "PSDEPSLNDBINST", iDataEntityModel.getDataInfo(pSDepSlnHost), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
        ArrayList<PSDepSlnDBInst> arrayList = this.selectByPSDepSlnHost(pSDepSlnHost);
        for (PSDepSlnDBInst pSDepSlnDBInst : arrayList) {
            PSDepSlnDBInst pSDepSlnDBInst2 = (PSDepSlnDBInst)this.getDEModel().createEntity();
            pSDepSlnDBInst2.setPSDepSlnDBInstId(pSDepSlnDBInst.getPSDepSlnDBInstId());
            pSDepSlnDBInst2.setPSDepSlnHostId(null);
            this.update(pSDepSlnDBInst2);
        }
    }

    public void removeByPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
        final PSDepSlnHost pSDepSlnHost2 = pSDepSlnHost;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnDBInstServiceBase.this.onBeforeRemoveByPSDepSlnHost(pSDepSlnHost2);
                PSDepSlnDBInstServiceBase.this.internalRemoveByPSDepSlnHost(pSDepSlnHost2);
                PSDepSlnDBInstServiceBase.this.onAfterRemoveByPSDepSlnHost(pSDepSlnHost2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
    }

    protected void internalRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
        ArrayList<PSDepSlnDBInst> arrayList = this.selectByPSDepSlnHost(pSDepSlnHost);
        this.onBeforeRemoveByPSDepSlnHost(pSDepSlnHost, arrayList);
        for (PSDepSlnDBInst pSDepSlnDBInst : arrayList) {
            this.remove(pSDepSlnDBInst);
        }
        this.onAfterRemoveByPSDepSlnHost(pSDepSlnHost, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost, ArrayList<PSDepSlnDBInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost, ArrayList<PSDepSlnDBInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    public void resetPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnDBInst> arrayList = this.selectByPSDepSln(pSDepSln);
        for (PSDepSlnDBInst pSDepSlnDBInst : arrayList) {
            PSDepSlnDBInst pSDepSlnDBInst2 = (PSDepSlnDBInst)this.getDEModel().createEntity();
            pSDepSlnDBInst2.setPSDepSlnDBInstId(pSDepSlnDBInst.getPSDepSlnDBInstId());
            pSDepSlnDBInst2.setPSDepSlnId(null);
            this.update(pSDepSlnDBInst2);
        }
    }

    public void removeByPSDepSln(PSDepSln pSDepSln) throws Exception {
        final PSDepSln pSDepSln2 = pSDepSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnDBInstServiceBase.this.onBeforeRemoveByPSDepSln(pSDepSln2);
                PSDepSlnDBInstServiceBase.this.internalRemoveByPSDepSln(pSDepSln2);
                PSDepSlnDBInstServiceBase.this.onAfterRemoveByPSDepSln(pSDepSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void internalRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnDBInst> arrayList = this.selectByPSDepSln(pSDepSln);
        this.onBeforeRemoveByPSDepSln(pSDepSln, arrayList);
        for (PSDepSlnDBInst pSDepSlnDBInst : arrayList) {
            this.remove(pSDepSlnDBInst);
        }
        this.onAfterRemoveByPSDepSln(pSDepSln, arrayList);
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnDBInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnDBInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDepSlnDBInst> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNDBINST_PSDEVCENTERDBINST_PSDEVCENTERDBINSTID", "", iDataEntityModel.getName(), "PSDEPSLNDBINST", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDepSlnDBInst> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst);
        for (PSDepSlnDBInst pSDepSlnDBInst : arrayList) {
            PSDepSlnDBInst pSDepSlnDBInst2 = (PSDepSlnDBInst)this.getDEModel().createEntity();
            pSDepSlnDBInst2.setPSDepSlnDBInstId(pSDepSlnDBInst.getPSDepSlnDBInstId());
            pSDepSlnDBInst2.setPSDevCenterDBInstId(null);
            this.update(pSDepSlnDBInst2);
        }
    }

    public void removeByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnDBInstServiceBase.this.onBeforeRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
                PSDepSlnDBInstServiceBase.this.internalRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
                PSDepSlnDBInstServiceBase.this.onAfterRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDepSlnDBInst> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByPSDevCenterDBInst(pSDevCenterDBInst, arrayList);
        for (PSDepSlnDBInst pSDepSlnDBInst : arrayList) {
            this.remove(pSDepSlnDBInst);
        }
        this.onAfterRemoveByPSDevCenterDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDepSlnDBInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDepSlnDBInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnDBInst pSDepSlnDBInst) throws Exception {
        PSDepSlnSysDBService pSDepSlnSysDBService = (PSDepSlnSysDBService)ServiceGlobal.getService(PSDepSlnSysDBService.class, (SessionFactory)this.getSessionFactory());
        pSDepSlnSysDBService.testRemoveByPSDepSlnDBInst(pSDepSlnDBInst);
        super.onBeforeRemove(pSDepSlnDBInst);
    }

    protected void replaceParentInfo(PSDepSlnDBInst pSDepSlnDBInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDepSlnDBInst, cloneSession);
        if (pSDepSlnDBInst.getPSDepSlnHostId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNHOST", (Object)pSDepSlnDBInst.getPSDepSlnHostId())) != null) {
            this.onFillParentInfo_PSDepSlnHost(pSDepSlnDBInst, (PSDepSlnHost)iEntity);
        }
        if (pSDepSlnDBInst.getPSDepSlnId() != null && (iEntity = cloneSession.getEntity("PSDEPSLN", (Object)pSDepSlnDBInst.getPSDepSlnId())) != null) {
            this.onFillParentInfo_PSDepSln(pSDepSlnDBInst, (PSDepSln)iEntity);
        }
        if (pSDepSlnDBInst.getPSDevCenterDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDepSlnDBInst.getPSDevCenterDBInstId())) != null) {
            this.onFillParentInfo_PSDevCenterDBInst(pSDepSlnDBInst, (PSDevCenterDBInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnDBInst pSDepSlnDBInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDepSlnDBInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnDBInst pSDepSlnDBInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ConnStr(bl, pSDepSlnDBInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DBType(bl, pSDepSlnDBInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableLocalMode(bl, pSDepSlnDBInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableRemoteMode(bl, pSDepSlnDBInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDepSlnDBInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Passwd(bl, pSDepSlnDBInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnDBInstId(bl, pSDepSlnDBInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnDBInstName(bl, pSDepSlnDBInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnHostId(bl, pSDepSlnDBInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnId(bl, pSDepSlnDBInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterDBInstId(bl, pSDepSlnDBInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserName(bl, pSDepSlnDBInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDepSlnDBInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ConnStr(boolean bl, PSDepSlnDBInst pSDepSlnDBInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnDBInst.isConnStrDirty() : !pSDepSlnDBInst.isConnStrDirty()) {
            return null;
        }
        String string = pSDepSlnDBInst.getConnStr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ConnStr_Default(pSDepSlnDBInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONNSTR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DBType(boolean bl, PSDepSlnDBInst pSDepSlnDBInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnDBInst.isDBTypeDirty() : !pSDepSlnDBInst.isDBTypeDirty()) {
            return null;
        }
        String string = pSDepSlnDBInst.getDBType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DBType_Default(pSDepSlnDBInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableLocalMode(boolean bl, PSDepSlnDBInst pSDepSlnDBInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnDBInst.isEnableLocalModeDirty() : !pSDepSlnDBInst.isEnableLocalModeDirty()) {
            return null;
        }
        Integer n = pSDepSlnDBInst.getEnableLocalMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableLocalMode_Default(pSDepSlnDBInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLELOCALMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableRemoteMode(boolean bl, PSDepSlnDBInst pSDepSlnDBInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnDBInst.isEnableRemoteModeDirty() : !pSDepSlnDBInst.isEnableRemoteModeDirty()) {
            return null;
        }
        Integer n = pSDepSlnDBInst.getEnableRemoteMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableRemoteMode_Default(pSDepSlnDBInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEREMOTEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSlnDBInst pSDepSlnDBInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnDBInst.isMemoDirty() : !pSDepSlnDBInst.isMemoDirty()) {
            return null;
        }
        String string = pSDepSlnDBInst.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDepSlnDBInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_Passwd(boolean bl, PSDepSlnDBInst pSDepSlnDBInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnDBInst.isPasswdDirty() : !pSDepSlnDBInst.isPasswdDirty()) {
            return null;
        }
        String string = pSDepSlnDBInst.getPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Passwd_Default(pSDepSlnDBInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnDBInstId(boolean bl, PSDepSlnDBInst pSDepSlnDBInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnDBInst.isPSDepSlnDBInstIdDirty() && !bl2 : !pSDepSlnDBInst.isPSDepSlnDBInstIdDirty()) {
            return null;
        }
        String string = pSDepSlnDBInst.getPSDepSlnDBInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNDBINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnDBInstId_Default(pSDepSlnDBInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnDBInstName(boolean bl, PSDepSlnDBInst pSDepSlnDBInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnDBInst.isPSDepSlnDBInstNameDirty() && !bl2 : !pSDepSlnDBInst.isPSDepSlnDBInstNameDirty()) {
            return null;
        }
        String string = pSDepSlnDBInst.getPSDepSlnDBInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNDBINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnDBInstName_Default(pSDepSlnDBInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNDBINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnHostId(boolean bl, PSDepSlnDBInst pSDepSlnDBInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnDBInst.isPSDepSlnHostIdDirty() : !pSDepSlnDBInst.isPSDepSlnHostIdDirty()) {
            return null;
        }
        String string = pSDepSlnDBInst.getPSDepSlnHostId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnHostId_Default(pSDepSlnDBInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNHOSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnId(boolean bl, PSDepSlnDBInst pSDepSlnDBInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnDBInst.isPSDepSlnIdDirty() && !bl2 : !pSDepSlnDBInst.isPSDepSlnIdDirty()) {
            return null;
        }
        String string = pSDepSlnDBInst.getPSDepSlnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnId_Default(pSDepSlnDBInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterDBInstId(boolean bl, PSDepSlnDBInst pSDepSlnDBInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnDBInst.isPSDevCenterDBInstIdDirty() : !pSDepSlnDBInst.isPSDevCenterDBInstIdDirty()) {
            return null;
        }
        String string = pSDepSlnDBInst.getPSDevCenterDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterDBInstId_Default(pSDepSlnDBInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserName(boolean bl, PSDepSlnDBInst pSDepSlnDBInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnDBInst.isUserNameDirty() : !pSDepSlnDBInst.isUserNameDirty()) {
            return null;
        }
        String string = pSDepSlnDBInst.getUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserName_Default(pSDepSlnDBInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDepSlnDBInst pSDepSlnDBInst, boolean bl) throws Exception {
        super.onSyncEntity(pSDepSlnDBInst, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnDBInst pSDepSlnDBInst, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDepSlnDBInst, bl);
    }

    public Object getDataContextValue(PSDepSlnDBInst pSDepSlnDBInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDepSlnDBInst, string, iDataContextParam)) != null) {
            return object;
        }
        PSDepSln pSDepSln = pSDepSlnDBInst.getPSDepSln();
        if (pSDepSln != null && pSDepSln.contains(string)) {
            return pSDepSln.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnDBInst pSDepSlnDBInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDepSlnDBInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONNSTR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ConnStr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLELOCALMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableLocalMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEREMOTEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableRemoteMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Passwd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNHOSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnHostId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNHOSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnHostName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserName_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ConnStr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONNSTR", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected String onTestValueRule_DBType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DBTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnableLocalMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableRemoteMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Passwd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PASSWD", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnHostId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNHOSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnHostName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNHOSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERNAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDepSlnDBInst pSDepSlnDBInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDepSlnDBInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnDBInst pSDepSlnDBInst) throws Exception {
        super.onUpdateParent(pSDepSlnDBInst);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnDBInst pSDepSlnDBInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNDBINST");
        if (!bl) {
            super.exportCurXmlModel(pSDepSlnDBInst, xmlNode, bl);
        }
    }
}

