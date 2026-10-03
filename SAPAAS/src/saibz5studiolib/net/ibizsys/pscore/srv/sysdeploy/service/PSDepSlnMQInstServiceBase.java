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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterMQ;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterMQBase;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnMQInstDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnMQInstDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnHost;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnHostBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnMQInst;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysMQService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnMQInstServiceBase
extends PSCoreSysServiceBase<PSDepSlnMQInst> {
    private static final Log log = LogFactory.getLog(PSDepSlnMQInstServiceBase.class);
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnMQInstDEModel pSDepSlnMQInstDEModel;
    private PSDepSlnMQInstDAO pSDepSlnMQInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnMQInstService";
    }

    public PSDepSlnMQInstDEModel getPSDepSlnMQInstDEModel() {
        if (this.pSDepSlnMQInstDEModel == null) {
            try {
                this.pSDepSlnMQInstDEModel = (PSDepSlnMQInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnMQInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnMQInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnMQInstDEModel();
    }

    public PSDepSlnMQInstDAO getPSDepSlnMQInstDAO() {
        if (this.pSDepSlnMQInstDAO == null) {
            try {
                this.pSDepSlnMQInstDAO = (PSDepSlnMQInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnMQInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnMQInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnMQInstDAO();
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

    protected void onFillParentInfo(PSDepSlnMQInst pSDepSlnMQInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNMQINST_PSDEPSLNHOST_PSDEPSLNHOSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnHostService", (SessionFactory)this.getSessionFactory());
            PSDepSlnHost pSDepSlnHost = (PSDepSlnHost)iService.getDEModel().createEntity();
            pSDepSlnHost.set("PSDEPSLNHOSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSlnHost);
            } else {
                iService.get(pSDepSlnHost);
            }
            this.onFillParentInfo_PSDepSlnHost(pSDepSlnMQInst, pSDepSlnHost);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNMQINST_PSDEPSLN_PSDEPSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService", (SessionFactory)this.getSessionFactory());
            PSDepSln pSDepSln = (PSDepSln)iService.getDEModel().createEntity();
            pSDepSln.set("PSDEPSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSln);
            } else {
                iService.get(pSDepSln);
            }
            this.onFillParentInfo_PSDepSln(pSDepSlnMQInst, pSDepSln);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNMQINST_PSDEVCENTERMQ_PSDEVCENTERMQID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterMQService", (SessionFactory)this.getSessionFactory());
            PSDevCenterMQ pSDevCenterMQ = (PSDevCenterMQ)iService.getDEModel().createEntity();
            pSDevCenterMQ.set("PSDEVCENTERMQID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterMQ);
            } else {
                iService.get(pSDevCenterMQ);
            }
            this.onFillParentInfo_PSDevCenterMQ(pSDepSlnMQInst, pSDevCenterMQ);
            return;
        }
        super.onFillParentInfo(pSDepSlnMQInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDepSlnHost(PSDepSlnMQInst pSDepSlnMQInst, PSDepSlnHost pSDepSlnHost) throws Exception {
        pSDepSlnMQInst.setPSDepSlnHostId(pSDepSlnHost.getPSDepSlnHostId());
        pSDepSlnMQInst.setPSDepSlnHostName(pSDepSlnHost.getPSDepSlnHostName());
    }

    protected void onFillParentInfo_PSDepSln(PSDepSlnMQInst pSDepSlnMQInst, PSDepSln pSDepSln) throws Exception {
        pSDepSlnMQInst.setPSDepSlnId(pSDepSln.getPSDepSlnId());
        pSDepSlnMQInst.setPSDepSlnName(pSDepSln.getPSDepSlnName());
    }

    protected void onFillParentInfo_PSDevCenterMQ(PSDepSlnMQInst pSDepSlnMQInst, PSDevCenterMQ pSDevCenterMQ) throws Exception {
        pSDepSlnMQInst.setPSDevCenterMQId(pSDevCenterMQ.getPSDevCenterMQId());
        pSDepSlnMQInst.setPSDevCenterMQName(pSDevCenterMQ.getPSDevCenterMQName());
    }

    protected void onFillEntityFullInfo(PSDepSlnMQInst pSDepSlnMQInst, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDepSlnMQInst, bl);
        this.onFillEntityFullInfo_PSDepSlnHost(pSDepSlnMQInst, bl);
        this.onFillEntityFullInfo_PSDepSln(pSDepSlnMQInst, bl);
        this.onFillEntityFullInfo_PSDevCenterMQ(pSDepSlnMQInst, bl);
    }

    protected void onFillEntityFullInfo_PSDepSlnHost(PSDepSlnMQInst pSDepSlnMQInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSln(PSDepSlnMQInst pSDepSlnMQInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterMQ(PSDepSlnMQInst pSDepSlnMQInst, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSlnMQInst pSDepSlnMQInst, boolean bl) throws Exception {
        super.onWriteBackParent(pSDepSlnMQInst, bl);
    }

    public ArrayList<PSDepSlnMQInst> selectByPSDepSlnHost(PSDepSlnHostBase pSDepSlnHostBase) throws Exception {
        return this.selectByPSDepSlnHost(pSDepSlnHostBase, "", -1);
    }

    public ArrayList<PSDepSlnMQInst> selectByPSDepSlnHost(PSDepSlnHostBase pSDepSlnHostBase, String string) throws Exception {
        return this.selectByPSDepSlnHost(pSDepSlnHostBase, string, -1);
    }

    public ArrayList<PSDepSlnMQInst> selectByPSDepSlnHost(PSDepSlnHostBase pSDepSlnHostBase, String string, int n) throws Exception {
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

    public ArrayList<PSDepSlnMQInst> selectByPSDepSln(PSDepSlnBase pSDepSlnBase) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, "", -1);
    }

    public ArrayList<PSDepSlnMQInst> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, string, -1);
    }

    public ArrayList<PSDepSlnMQInst> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string, int n) throws Exception {
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

    public ArrayList<PSDepSlnMQInst> selectByPSDevCenterMQ(PSDevCenterMQBase pSDevCenterMQBase) throws Exception {
        return this.selectByPSDevCenterMQ(pSDevCenterMQBase, "", -1);
    }

    public ArrayList<PSDepSlnMQInst> selectByPSDevCenterMQ(PSDevCenterMQBase pSDevCenterMQBase, String string) throws Exception {
        return this.selectByPSDevCenterMQ(pSDevCenterMQBase, string, -1);
    }

    public ArrayList<PSDepSlnMQInst> selectByPSDevCenterMQ(PSDevCenterMQBase pSDevCenterMQBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERMQID", (Object)pSDevCenterMQBase.getPSDevCenterMQId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterMQCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterMQCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
        ArrayList<PSDepSlnMQInst> arrayList = this.selectByPSDepSlnHost(pSDepSlnHost, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNHOST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDepSlnHost);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNMQINST_PSDEPSLNHOST_PSDEPSLNHOSTID", "", iDataEntityModel.getName(), "PSDEPSLNMQINST", iDataEntityModel.getDataInfo(pSDepSlnHost), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
        ArrayList<PSDepSlnMQInst> arrayList = this.selectByPSDepSlnHost(pSDepSlnHost);
        for (PSDepSlnMQInst pSDepSlnMQInst : arrayList) {
            PSDepSlnMQInst pSDepSlnMQInst2 = (PSDepSlnMQInst)this.getDEModel().createEntity();
            pSDepSlnMQInst2.setPSDepSlnMQInstId(pSDepSlnMQInst.getPSDepSlnMQInstId());
            pSDepSlnMQInst2.setPSDepSlnHostId(null);
            this.update(pSDepSlnMQInst2);
        }
    }

    public void removeByPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
        final PSDepSlnHost pSDepSlnHost2 = pSDepSlnHost;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnMQInstServiceBase.this.onBeforeRemoveByPSDepSlnHost(pSDepSlnHost2);
                PSDepSlnMQInstServiceBase.this.internalRemoveByPSDepSlnHost(pSDepSlnHost2);
                PSDepSlnMQInstServiceBase.this.onAfterRemoveByPSDepSlnHost(pSDepSlnHost2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
    }

    protected void internalRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
        ArrayList<PSDepSlnMQInst> arrayList = this.selectByPSDepSlnHost(pSDepSlnHost);
        this.onBeforeRemoveByPSDepSlnHost(pSDepSlnHost, arrayList);
        for (PSDepSlnMQInst pSDepSlnMQInst : arrayList) {
            this.remove(pSDepSlnMQInst);
        }
        this.onAfterRemoveByPSDepSlnHost(pSDepSlnHost, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost, ArrayList<PSDepSlnMQInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost, ArrayList<PSDepSlnMQInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    public void resetPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnMQInst> arrayList = this.selectByPSDepSln(pSDepSln);
        for (PSDepSlnMQInst pSDepSlnMQInst : arrayList) {
            PSDepSlnMQInst pSDepSlnMQInst2 = (PSDepSlnMQInst)this.getDEModel().createEntity();
            pSDepSlnMQInst2.setPSDepSlnMQInstId(pSDepSlnMQInst.getPSDepSlnMQInstId());
            pSDepSlnMQInst2.setPSDepSlnId(null);
            this.update(pSDepSlnMQInst2);
        }
    }

    public void removeByPSDepSln(PSDepSln pSDepSln) throws Exception {
        final PSDepSln pSDepSln2 = pSDepSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnMQInstServiceBase.this.onBeforeRemoveByPSDepSln(pSDepSln2);
                PSDepSlnMQInstServiceBase.this.internalRemoveByPSDepSln(pSDepSln2);
                PSDepSlnMQInstServiceBase.this.onAfterRemoveByPSDepSln(pSDepSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void internalRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnMQInst> arrayList = this.selectByPSDepSln(pSDepSln);
        this.onBeforeRemoveByPSDepSln(pSDepSln, arrayList);
        for (PSDepSlnMQInst pSDepSlnMQInst : arrayList) {
            this.remove(pSDepSlnMQInst);
        }
        this.onAfterRemoveByPSDepSln(pSDepSln, arrayList);
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnMQInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnMQInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterMQ(PSDevCenterMQ pSDevCenterMQ) throws Exception {
        ArrayList<PSDepSlnMQInst> arrayList = this.selectByPSDevCenterMQ(pSDevCenterMQ, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERMQ");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterMQ);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNMQINST_PSDEVCENTERMQ_PSDEVCENTERMQID", "", iDataEntityModel.getName(), "PSDEPSLNMQINST", iDataEntityModel.getDataInfo(pSDevCenterMQ), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterMQ(PSDevCenterMQ pSDevCenterMQ) throws Exception {
        ArrayList<PSDepSlnMQInst> arrayList = this.selectByPSDevCenterMQ(pSDevCenterMQ);
        for (PSDepSlnMQInst pSDepSlnMQInst : arrayList) {
            PSDepSlnMQInst pSDepSlnMQInst2 = (PSDepSlnMQInst)this.getDEModel().createEntity();
            pSDepSlnMQInst2.setPSDepSlnMQInstId(pSDepSlnMQInst.getPSDepSlnMQInstId());
            pSDepSlnMQInst2.setPSDevCenterMQId(null);
            this.update(pSDepSlnMQInst2);
        }
    }

    public void removeByPSDevCenterMQ(PSDevCenterMQ pSDevCenterMQ) throws Exception {
        final PSDevCenterMQ pSDevCenterMQ2 = pSDevCenterMQ;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnMQInstServiceBase.this.onBeforeRemoveByPSDevCenterMQ(pSDevCenterMQ2);
                PSDepSlnMQInstServiceBase.this.internalRemoveByPSDevCenterMQ(pSDevCenterMQ2);
                PSDepSlnMQInstServiceBase.this.onAfterRemoveByPSDevCenterMQ(pSDevCenterMQ2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterMQ(PSDevCenterMQ pSDevCenterMQ) throws Exception {
    }

    protected void internalRemoveByPSDevCenterMQ(PSDevCenterMQ pSDevCenterMQ) throws Exception {
        ArrayList<PSDepSlnMQInst> arrayList = this.selectByPSDevCenterMQ(pSDevCenterMQ);
        this.onBeforeRemoveByPSDevCenterMQ(pSDevCenterMQ, arrayList);
        for (PSDepSlnMQInst pSDepSlnMQInst : arrayList) {
            this.remove(pSDepSlnMQInst);
        }
        this.onAfterRemoveByPSDevCenterMQ(pSDevCenterMQ, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterMQ(PSDevCenterMQ pSDevCenterMQ) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterMQ(PSDevCenterMQ pSDevCenterMQ, ArrayList<PSDepSlnMQInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterMQ(PSDevCenterMQ pSDevCenterMQ, ArrayList<PSDepSlnMQInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnMQInst pSDepSlnMQInst) throws Exception {
        PSDepSlnSysMQService pSDepSlnSysMQService = (PSDepSlnSysMQService)ServiceGlobal.getService(PSDepSlnSysMQService.class, (SessionFactory)this.getSessionFactory());
        pSDepSlnSysMQService.testRemoveByPSDepSlnMQInst(pSDepSlnMQInst);
        super.onBeforeRemove(pSDepSlnMQInst);
    }

    protected void replaceParentInfo(PSDepSlnMQInst pSDepSlnMQInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDepSlnMQInst, cloneSession);
        if (pSDepSlnMQInst.getPSDepSlnHostId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNHOST", (Object)pSDepSlnMQInst.getPSDepSlnHostId())) != null) {
            this.onFillParentInfo_PSDepSlnHost(pSDepSlnMQInst, (PSDepSlnHost)iEntity);
        }
        if (pSDepSlnMQInst.getPSDepSlnId() != null && (iEntity = cloneSession.getEntity("PSDEPSLN", (Object)pSDepSlnMQInst.getPSDepSlnId())) != null) {
            this.onFillParentInfo_PSDepSln(pSDepSlnMQInst, (PSDepSln)iEntity);
        }
        if (pSDepSlnMQInst.getPSDevCenterMQId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERMQ", (Object)pSDepSlnMQInst.getPSDevCenterMQId())) != null) {
            this.onFillParentInfo_PSDevCenterMQ(pSDepSlnMQInst, (PSDevCenterMQ)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnMQInst pSDepSlnMQInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDepSlnMQInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnMQInst pSDepSlnMQInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ConnStr(bl, pSDepSlnMQInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableLocalMode(bl, pSDepSlnMQInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableRemoteMode(bl, pSDepSlnMQInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDepSlnMQInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MQType(bl, pSDepSlnMQInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Passwd(bl, pSDepSlnMQInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnHostId(bl, pSDepSlnMQInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnId(bl, pSDepSlnMQInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnMQInstId(bl, pSDepSlnMQInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnMQInstName(bl, pSDepSlnMQInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterMQId(bl, pSDepSlnMQInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserName(bl, pSDepSlnMQInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDepSlnMQInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ConnStr(boolean bl, PSDepSlnMQInst pSDepSlnMQInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnMQInst.isConnStrDirty() : !pSDepSlnMQInst.isConnStrDirty()) {
            return null;
        }
        String string = pSDepSlnMQInst.getConnStr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ConnStr_Default(pSDepSlnMQInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableLocalMode(boolean bl, PSDepSlnMQInst pSDepSlnMQInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnMQInst.isEnableLocalModeDirty() : !pSDepSlnMQInst.isEnableLocalModeDirty()) {
            return null;
        }
        Integer n = pSDepSlnMQInst.getEnableLocalMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableLocalMode_Default(pSDepSlnMQInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableRemoteMode(boolean bl, PSDepSlnMQInst pSDepSlnMQInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnMQInst.isEnableRemoteModeDirty() : !pSDepSlnMQInst.isEnableRemoteModeDirty()) {
            return null;
        }
        Integer n = pSDepSlnMQInst.getEnableRemoteMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableRemoteMode_Default(pSDepSlnMQInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSlnMQInst pSDepSlnMQInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnMQInst.isMemoDirty() : !pSDepSlnMQInst.isMemoDirty()) {
            return null;
        }
        String string = pSDepSlnMQInst.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDepSlnMQInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_MQType(boolean bl, PSDepSlnMQInst pSDepSlnMQInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnMQInst.isMQTypeDirty() : !pSDepSlnMQInst.isMQTypeDirty()) {
            return null;
        }
        String string = pSDepSlnMQInst.getMQType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MQType_Default(pSDepSlnMQInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MQTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Passwd(boolean bl, PSDepSlnMQInst pSDepSlnMQInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnMQInst.isPasswdDirty() : !pSDepSlnMQInst.isPasswdDirty()) {
            return null;
        }
        String string = pSDepSlnMQInst.getPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Passwd_Default(pSDepSlnMQInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnHostId(boolean bl, PSDepSlnMQInst pSDepSlnMQInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnMQInst.isPSDepSlnHostIdDirty() : !pSDepSlnMQInst.isPSDepSlnHostIdDirty()) {
            return null;
        }
        String string = pSDepSlnMQInst.getPSDepSlnHostId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnHostId_Default(pSDepSlnMQInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnId(boolean bl, PSDepSlnMQInst pSDepSlnMQInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnMQInst.isPSDepSlnIdDirty() && !bl2 : !pSDepSlnMQInst.isPSDepSlnIdDirty()) {
            return null;
        }
        String string = pSDepSlnMQInst.getPSDepSlnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnId_Default(pSDepSlnMQInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnMQInstId(boolean bl, PSDepSlnMQInst pSDepSlnMQInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnMQInst.isPSDepSlnMQInstIdDirty() && !bl2 : !pSDepSlnMQInst.isPSDepSlnMQInstIdDirty()) {
            return null;
        }
        String string = pSDepSlnMQInst.getPSDepSlnMQInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNMQINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnMQInstId_Default(pSDepSlnMQInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNMQINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnMQInstName(boolean bl, PSDepSlnMQInst pSDepSlnMQInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnMQInst.isPSDepSlnMQInstNameDirty() && !bl2 : !pSDepSlnMQInst.isPSDepSlnMQInstNameDirty()) {
            return null;
        }
        String string = pSDepSlnMQInst.getPSDepSlnMQInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNMQINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnMQInstName_Default(pSDepSlnMQInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNMQINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterMQId(boolean bl, PSDepSlnMQInst pSDepSlnMQInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnMQInst.isPSDevCenterMQIdDirty() : !pSDepSlnMQInst.isPSDevCenterMQIdDirty()) {
            return null;
        }
        String string = pSDepSlnMQInst.getPSDevCenterMQId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterMQId_Default(pSDepSlnMQInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERMQID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserName(boolean bl, PSDepSlnMQInst pSDepSlnMQInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnMQInst.isUserNameDirty() : !pSDepSlnMQInst.isUserNameDirty()) {
            return null;
        }
        String string = pSDepSlnMQInst.getUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserName_Default(pSDepSlnMQInst, bl2, bl3);
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

    protected void onSyncEntity(PSDepSlnMQInst pSDepSlnMQInst, boolean bl) throws Exception {
        super.onSyncEntity(pSDepSlnMQInst, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnMQInst pSDepSlnMQInst, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDepSlnMQInst, bl);
    }

    public Object getDataContextValue(PSDepSlnMQInst pSDepSlnMQInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDepSlnMQInst, string, iDataContextParam)) != null) {
            return object;
        }
        PSDepSln pSDepSln = pSDepSlnMQInst.getPSDepSln();
        if (pSDepSln != null && pSDepSln.contains(string)) {
            return pSDepSln.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnMQInst pSDepSlnMQInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDepSlnMQInst, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"ENABLELOCALMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableLocalMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEREMOTEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableRemoteMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MQTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MQType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Passwd_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEPSLNMQINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnMQInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNMQINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnMQInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERMQID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterMQId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERMQNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterMQName_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("CONNSTR", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_MQType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MQTYPE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_PSDepSlnMQInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNMQINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnMQInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNMQINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDevCenterMQId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERMQID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterMQName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERMQNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDepSlnMQInst pSDepSlnMQInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDepSlnMQInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnMQInst pSDepSlnMQInst) throws Exception {
        super.onUpdateParent(pSDepSlnMQInst);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnMQInst pSDepSlnMQInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNMQINST");
        if (!bl) {
            pSDepSlnMQInst.setCreateDate(null);
            pSDepSlnMQInst.setCreateMan(null);
            pSDepSlnMQInst.setPSDepSlnMQInstId(null);
            pSDepSlnMQInst.setUpdateDate(null);
            pSDepSlnMQInst.setUpdateMan(null);
            super.exportCurXmlModel(pSDepSlnMQInst, xmlNode, bl);
        }
    }
}

