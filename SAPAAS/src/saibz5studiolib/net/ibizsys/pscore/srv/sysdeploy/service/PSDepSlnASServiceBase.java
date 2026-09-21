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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterASBase;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnASDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnASDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnAS;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnHost;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnHostBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASItemService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASItemServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnRunLogService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnRunLogServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysASService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysASServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnASServiceBase
extends PSCoreSysServiceBase<PSDepSlnAS> {
    private static final Log log = LogFactory.getLog(PSDepSlnASServiceBase.class);
    public static final String DATASET_CURDEPSLN = "CurDepSln";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnASDEModel pSDepSlnASDEModel;
    private PSDepSlnASDAO pSDepSlnASDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASService";
    }

    public PSDepSlnASDEModel getPSDepSlnASDEModel() {
        if (this.pSDepSlnASDEModel == null) {
            try {
                this.pSDepSlnASDEModel = (PSDepSlnASDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnASDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnASDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnASDEModel();
    }

    public PSDepSlnASDAO getPSDepSlnASDAO() {
        if (this.pSDepSlnASDAO == null) {
            try {
                this.pSDepSlnASDAO = (PSDepSlnASDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnASDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnASDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnASDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDEPSLN, (boolean)true) == 0) {
            return this.fetchCurDepSln(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurDepSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEPSLN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDepSlnAS pSDepSlnAS, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNAS_PSDEPSLNHOST_PSDEPSLNHOSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnHostService", (SessionFactory)this.getSessionFactory());
            PSDepSlnHost pSDepSlnHost = (PSDepSlnHost)iService.getDEModel().createEntity();
            pSDepSlnHost.set("PSDEPSLNHOSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSlnHost);
            } else {
                iService.get((IEntity)pSDepSlnHost);
            }
            this.onFillParentInfo_PSDepSlnHost(pSDepSlnAS, pSDepSlnHost);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNAS_PSDEPSLN_PSDEPSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService", (SessionFactory)this.getSessionFactory());
            PSDepSln pSDepSln = (PSDepSln)iService.getDEModel().createEntity();
            pSDepSln.set("PSDEPSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSln);
            } else {
                iService.get((IEntity)pSDepSln);
            }
            this.onFillParentInfo_PSDepSln(pSDepSlnAS, pSDepSln);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNAS_PSDEVCENTERAS_PSDEVCENTERASID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService", (SessionFactory)this.getSessionFactory());
            PSDevCenterAS pSDevCenterAS = (PSDevCenterAS)iService.getDEModel().createEntity();
            pSDevCenterAS.set("PSDEVCENTERASID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenterAS);
            } else {
                iService.get((IEntity)pSDevCenterAS);
            }
            this.onFillParentInfo_PSDevcenterAS(pSDepSlnAS, pSDevCenterAS);
            return;
        }
        super.onFillParentInfo((IEntity)pSDepSlnAS, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDepSlnHost(PSDepSlnAS pSDepSlnAS, PSDepSlnHost pSDepSlnHost) throws Exception {
        pSDepSlnAS.setPSDepSlnHostId(pSDepSlnHost.getPSDepSlnHostId());
        pSDepSlnAS.setPSDepSlnHostName(pSDepSlnHost.getPSDepSlnHostName());
    }

    protected void onFillParentInfo_PSDepSln(PSDepSlnAS pSDepSlnAS, PSDepSln pSDepSln) throws Exception {
        pSDepSlnAS.setPSDepSlnId(pSDepSln.getPSDepSlnId());
        pSDepSlnAS.setPSDepSlnName(pSDepSln.getPSDepSlnName());
    }

    protected void onFillParentInfo_PSDevcenterAS(PSDepSlnAS pSDepSlnAS, PSDevCenterAS pSDevCenterAS) throws Exception {
        pSDepSlnAS.setPSDevCenterASId(pSDevCenterAS.getPSDevCenterASId());
        pSDepSlnAS.setPSDevCenterASName(pSDevCenterAS.getPSDevCenterASName());
    }

    protected void onFillEntityFullInfo(PSDepSlnAS pSDepSlnAS, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDepSlnAS, bl);
        this.onFillEntityFullInfo_PSDepSlnHost(pSDepSlnAS, bl);
        this.onFillEntityFullInfo_PSDepSln(pSDepSlnAS, bl);
        this.onFillEntityFullInfo_PSDevcenterAS(pSDepSlnAS, bl);
    }

    protected void onFillEntityFullInfo_PSDepSlnHost(PSDepSlnAS pSDepSlnAS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSln(PSDepSlnAS pSDepSlnAS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevcenterAS(PSDepSlnAS pSDepSlnAS, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSlnAS pSDepSlnAS, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDepSlnAS, bl);
    }

    public ArrayList<PSDepSlnAS> selectByPSDepSlnHost(PSDepSlnHostBase pSDepSlnHostBase) throws Exception {
        return this.selectByPSDepSlnHost(pSDepSlnHostBase, "", -1);
    }

    public ArrayList<PSDepSlnAS> selectByPSDepSlnHost(PSDepSlnHostBase pSDepSlnHostBase, String string) throws Exception {
        return this.selectByPSDepSlnHost(pSDepSlnHostBase, string, -1);
    }

    public ArrayList<PSDepSlnAS> selectByPSDepSlnHost(PSDepSlnHostBase pSDepSlnHostBase, String string, int n) throws Exception {
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

    public ArrayList<PSDepSlnAS> selectByPSDepSln(PSDepSlnBase pSDepSlnBase) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, "", -1);
    }

    public ArrayList<PSDepSlnAS> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, string, -1);
    }

    public ArrayList<PSDepSlnAS> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string, int n) throws Exception {
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

    public ArrayList<PSDepSlnAS> selectByPSDevcenterAS(PSDevCenterASBase pSDevCenterASBase) throws Exception {
        return this.selectByPSDevcenterAS(pSDevCenterASBase, "", -1);
    }

    public ArrayList<PSDepSlnAS> selectByPSDevcenterAS(PSDevCenterASBase pSDevCenterASBase, String string) throws Exception {
        return this.selectByPSDevcenterAS(pSDevCenterASBase, string, -1);
    }

    public ArrayList<PSDepSlnAS> selectByPSDevcenterAS(PSDevCenterASBase pSDevCenterASBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERASID", (Object)pSDevCenterASBase.getPSDevCenterASId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevcenterASCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevcenterASCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
        ArrayList<PSDepSlnAS> arrayList = this.selectByPSDepSlnHost(pSDepSlnHost, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNHOST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSlnHost);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNAS_PSDEPSLNHOST_PSDEPSLNHOSTID", "", iDataEntityModel.getName(), "PSDEPSLNAS", iDataEntityModel.getDataInfo((IEntity)pSDepSlnHost), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
        ArrayList<PSDepSlnAS> arrayList = this.selectByPSDepSlnHost(pSDepSlnHost);
        for (PSDepSlnAS pSDepSlnAS : arrayList) {
            PSDepSlnAS pSDepSlnAS2 = (PSDepSlnAS)this.getDEModel().createEntity();
            pSDepSlnAS2.setPSDepSlnASId(pSDepSlnAS.getPSDepSlnASId());
            pSDepSlnAS2.setPSDepSlnHostId(null);
            this.update(pSDepSlnAS2);
        }
    }

    public void removeByPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
        final PSDepSlnHost pSDepSlnHost2 = pSDepSlnHost;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnASServiceBase.this.onBeforeRemoveByPSDepSlnHost(pSDepSlnHost2);
                PSDepSlnASServiceBase.this.internalRemoveByPSDepSlnHost(pSDepSlnHost2);
                PSDepSlnASServiceBase.this.onAfterRemoveByPSDepSlnHost(pSDepSlnHost2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
    }

    protected void internalRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
        ArrayList<PSDepSlnAS> arrayList = this.selectByPSDepSlnHost(pSDepSlnHost);
        this.onBeforeRemoveByPSDepSlnHost(pSDepSlnHost, arrayList);
        for (PSDepSlnAS pSDepSlnAS : arrayList) {
            this.remove((IEntity)pSDepSlnAS);
        }
        this.onAfterRemoveByPSDepSlnHost(pSDepSlnHost, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost, ArrayList<PSDepSlnAS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost, ArrayList<PSDepSlnAS> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    public void resetPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnAS> arrayList = this.selectByPSDepSln(pSDepSln);
        for (PSDepSlnAS pSDepSlnAS : arrayList) {
            PSDepSlnAS pSDepSlnAS2 = (PSDepSlnAS)this.getDEModel().createEntity();
            pSDepSlnAS2.setPSDepSlnASId(pSDepSlnAS.getPSDepSlnASId());
            pSDepSlnAS2.setPSDepSlnId(null);
            this.update(pSDepSlnAS2);
        }
    }

    public void removeByPSDepSln(PSDepSln pSDepSln) throws Exception {
        final PSDepSln pSDepSln2 = pSDepSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnASServiceBase.this.onBeforeRemoveByPSDepSln(pSDepSln2);
                PSDepSlnASServiceBase.this.internalRemoveByPSDepSln(pSDepSln2);
                PSDepSlnASServiceBase.this.onAfterRemoveByPSDepSln(pSDepSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void internalRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnAS> arrayList = this.selectByPSDepSln(pSDepSln);
        this.onBeforeRemoveByPSDepSln(pSDepSln, arrayList);
        for (PSDepSlnAS pSDepSlnAS : arrayList) {
            this.remove((IEntity)pSDepSlnAS);
        }
        this.onAfterRemoveByPSDepSln(pSDepSln, arrayList);
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnAS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnAS> arrayList) throws Exception {
    }

    public void testRemoveByPSDevcenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDepSlnAS> arrayList = this.selectByPSDevcenterAS(pSDevCenterAS, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERAS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenterAS);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNAS_PSDEVCENTERAS_PSDEVCENTERASID", "", iDataEntityModel.getName(), "PSDEPSLNAS", iDataEntityModel.getDataInfo((IEntity)pSDevCenterAS), arrayList.get(0)));
        }
    }

    public void resetPSDevcenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDepSlnAS> arrayList = this.selectByPSDevcenterAS(pSDevCenterAS);
        for (PSDepSlnAS pSDepSlnAS : arrayList) {
            PSDepSlnAS pSDepSlnAS2 = (PSDepSlnAS)this.getDEModel().createEntity();
            pSDepSlnAS2.setPSDepSlnASId(pSDepSlnAS.getPSDepSlnASId());
            pSDepSlnAS2.setPSDevCenterASId(null);
            this.update(pSDepSlnAS2);
        }
    }

    public void removeByPSDevcenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        final PSDevCenterAS pSDevCenterAS2 = pSDevCenterAS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnASServiceBase.this.onBeforeRemoveByPSDevcenterAS(pSDevCenterAS2);
                PSDepSlnASServiceBase.this.internalRemoveByPSDevcenterAS(pSDevCenterAS2);
                PSDepSlnASServiceBase.this.onAfterRemoveByPSDevcenterAS(pSDevCenterAS2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevcenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
    }

    protected void internalRemoveByPSDevcenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDepSlnAS> arrayList = this.selectByPSDevcenterAS(pSDevCenterAS);
        this.onBeforeRemoveByPSDevcenterAS(pSDevCenterAS, arrayList);
        for (PSDepSlnAS pSDepSlnAS : arrayList) {
            this.remove((IEntity)pSDepSlnAS);
        }
        this.onAfterRemoveByPSDevcenterAS(pSDevCenterAS, arrayList);
    }

    protected void onAfterRemoveByPSDevcenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
    }

    protected void onBeforeRemoveByPSDevcenterAS(PSDevCenterAS pSDevCenterAS, ArrayList<PSDepSlnAS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevcenterAS(PSDevCenterAS pSDevCenterAS, ArrayList<PSDepSlnAS> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnAS pSDepSlnAS) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDepSlnASItemService)ServiceGlobal.getService(PSDepSlnASItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnASItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSlnAS(pSDepSlnAS);
        pSCoreSysServiceBase = (PSDepSlnRunLogService)ServiceGlobal.getService(PSDepSlnRunLogService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnRunLogServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSlnAS(pSDepSlnAS);
        pSCoreSysServiceBase = (PSDepSlnSysASService)ServiceGlobal.getService(PSDepSlnSysASService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysASServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSlnAS(pSDepSlnAS);
        super.onBeforeRemove(pSDepSlnAS);
    }

    protected void replaceParentInfo(PSDepSlnAS pSDepSlnAS, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDepSlnAS, cloneSession);
        if (pSDepSlnAS.getPSDepSlnHostId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNHOST", (Object)pSDepSlnAS.getPSDepSlnHostId())) != null) {
            this.onFillParentInfo_PSDepSlnHost(pSDepSlnAS, (PSDepSlnHost)iEntity);
        }
        if (pSDepSlnAS.getPSDepSlnId() != null && (iEntity = cloneSession.getEntity("PSDEPSLN", (Object)pSDepSlnAS.getPSDepSlnId())) != null) {
            this.onFillParentInfo_PSDepSln(pSDepSlnAS, (PSDepSln)iEntity);
        }
        if (pSDepSlnAS.getPSDevCenterASId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERAS", (Object)pSDepSlnAS.getPSDevCenterASId())) != null) {
            this.onFillParentInfo_PSDevcenterAS(pSDepSlnAS, (PSDevCenterAS)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnAS pSDepSlnAS, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDepSlnAS, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnAS pSDepSlnAS, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ASType(bl, pSDepSlnAS, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableLocalMode(bl, pSDepSlnAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableRemoteMode(bl, pSDepSlnAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HttpPort(bl, pSDepSlnAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDepSlnAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnASId(bl, pSDepSlnAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnASName(bl, pSDepSlnAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnHostId(bl, pSDepSlnAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnId(bl, pSDepSlnAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterASId(bl, pSDepSlnAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDepSlnAS, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ASType(boolean bl, PSDepSlnAS pSDepSlnAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnAS.isASTypeDirty() : !pSDepSlnAS.isASTypeDirty()) {
            return null;
        }
        String string = pSDepSlnAS.getASType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ASType_Default((IEntity)pSDepSlnAS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableLocalMode(boolean bl, PSDepSlnAS pSDepSlnAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnAS.isEnableLocalModeDirty() : !pSDepSlnAS.isEnableLocalModeDirty()) {
            return null;
        }
        Integer n = pSDepSlnAS.getEnableLocalMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableLocalMode_Default((IEntity)pSDepSlnAS, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableRemoteMode(boolean bl, PSDepSlnAS pSDepSlnAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnAS.isEnableRemoteModeDirty() : !pSDepSlnAS.isEnableRemoteModeDirty()) {
            return null;
        }
        Integer n = pSDepSlnAS.getEnableRemoteMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableRemoteMode_Default((IEntity)pSDepSlnAS, bl2, bl3);
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

    protected EntityFieldError onCheckField_HttpPort(boolean bl, PSDepSlnAS pSDepSlnAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnAS.isHttpPortDirty() : !pSDepSlnAS.isHttpPortDirty()) {
            return null;
        }
        Integer n = pSDepSlnAS.getHttpPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HttpPort_Default((IEntity)pSDepSlnAS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTTPPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSlnAS pSDepSlnAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnAS.isMemoDirty() : !pSDepSlnAS.isMemoDirty()) {
            return null;
        }
        String string = pSDepSlnAS.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDepSlnAS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnASId(boolean bl, PSDepSlnAS pSDepSlnAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnAS.isPSDepSlnASIdDirty() && !bl2 : !pSDepSlnAS.isPSDepSlnASIdDirty()) {
            return null;
        }
        String string = pSDepSlnAS.getPSDepSlnASId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNASID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnASId_Default((IEntity)pSDepSlnAS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnASName(boolean bl, PSDepSlnAS pSDepSlnAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnAS.isPSDepSlnASNameDirty() && !bl2 : !pSDepSlnAS.isPSDepSlnASNameDirty()) {
            return null;
        }
        String string = pSDepSlnAS.getPSDepSlnASName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNASNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnASName_Default((IEntity)pSDepSlnAS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnHostId(boolean bl, PSDepSlnAS pSDepSlnAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnAS.isPSDepSlnHostIdDirty() : !pSDepSlnAS.isPSDepSlnHostIdDirty()) {
            return null;
        }
        String string = pSDepSlnAS.getPSDepSlnHostId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnHostId_Default((IEntity)pSDepSlnAS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnId(boolean bl, PSDepSlnAS pSDepSlnAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnAS.isPSDepSlnIdDirty() && !bl2 : !pSDepSlnAS.isPSDepSlnIdDirty()) {
            return null;
        }
        String string = pSDepSlnAS.getPSDepSlnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnId_Default((IEntity)pSDepSlnAS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterASId(boolean bl, PSDepSlnAS pSDepSlnAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnAS.isPSDevCenterASIdDirty() : !pSDepSlnAS.isPSDevCenterASIdDirty()) {
            return null;
        }
        String string = pSDepSlnAS.getPSDevCenterASId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterASId_Default((IEntity)pSDepSlnAS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERASID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDepSlnAS pSDepSlnAS, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDepSlnAS, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnAS pSDepSlnAS, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDepSlnAS, bl);
    }

    public Object getDataContextValue(PSDepSlnAS pSDepSlnAS, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDepSlnAS, string, iDataContextParam)) != null) {
            return object;
        }
        PSDepSln pSDepSln = pSDepSlnAS.getPSDepSln();
        if (pSDepSln != null && pSDepSln.contains(string)) {
            return pSDepSln.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnAS pSDepSlnAS, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDepSlnAS, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ASTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ASType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"HTTPPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HttpPort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNASID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnASId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNASNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnASName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERASID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterASId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERASNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterASName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ASType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ASTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected String onTestValueRule_HttpPort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDepSlnASId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDevCenterASId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERASID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterASName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERASNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDepSlnAS pSDepSlnAS) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDepSlnAS)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnAS pSDepSlnAS) throws Exception {
        super.onUpdateParent((IEntity)pSDepSlnAS);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnAS pSDepSlnAS, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNAS");
        if (!bl) {
            super.exportCurXmlModel(pSDepSlnAS, xmlNode, bl);
        }
    }
}

