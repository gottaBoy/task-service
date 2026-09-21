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
package net.ibizsys.pscore.srv.aidesign.service;

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
import net.ibizsys.pscore.srv.aidesign.dao.PSSysAIPipelineWorkerDAO;
import net.ibizsys.pscore.srv.aidesign.demodel.PSSysAIPipelineWorkerDEModel;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIFactory;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIFactoryBase;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIPipelineAgent;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIPipelineAgentBase;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIPipelineWorker;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIWorkerAgent;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIWorkerAgentBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysAIPipelineWorkerServiceBase
extends PSCoreSysServiceBase<PSSysAIPipelineWorker> {
    private static final Log log = LogFactory.getLog(PSSysAIPipelineWorkerServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysAIPipelineWorkerDEModel pSSysAIPipelineWorkerDEModel;
    private PSSysAIPipelineWorkerDAO pSSysAIPipelineWorkerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineWorkerService";
    }

    public PSSysAIPipelineWorkerDEModel getPSSysAIPipelineWorkerDEModel() {
        if (this.pSSysAIPipelineWorkerDEModel == null) {
            try {
                this.pSSysAIPipelineWorkerDEModel = (PSSysAIPipelineWorkerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.aidesign.demodel.PSSysAIPipelineWorkerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysAIPipelineWorkerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysAIPipelineWorkerDEModel();
    }

    public PSSysAIPipelineWorkerDAO getPSSysAIPipelineWorkerDAO() {
        if (this.pSSysAIPipelineWorkerDAO == null) {
            try {
                this.pSSysAIPipelineWorkerDAO = (PSSysAIPipelineWorkerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.aidesign.dao.PSSysAIPipelineWorkerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysAIPipelineWorkerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysAIPipelineWorkerDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysAIPipelineWorker pSSysAIPipelineWorker, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAIPIPELINEWORKER_PSSYSAIFACTORY_PSSYSAIFACTORYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.aidesign.service.PSSysAIFactoryService", (SessionFactory)this.getSessionFactory());
            PSSysAIFactory pSSysAIFactory = (PSSysAIFactory)iService.getDEModel().createEntity();
            pSSysAIFactory.set("PSSYSAIFACTORYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysAIFactory);
            } else {
                iService.get((IEntity)pSSysAIFactory);
            }
            this.onFillParentInfo_PSSysAIFactory(pSSysAIPipelineWorker, pSSysAIFactory);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAIPIPELINEWORKER_PSSYSAIPIPELINEAGENT_PSSYSAIPIPELINEAGENTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineAgentService", (SessionFactory)this.getSessionFactory());
            PSSysAIPipelineAgent pSSysAIPipelineAgent = (PSSysAIPipelineAgent)iService.getDEModel().createEntity();
            pSSysAIPipelineAgent.set("PSSYSAIPIPELINEAGENTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysAIPipelineAgent);
            } else {
                iService.get((IEntity)pSSysAIPipelineAgent);
            }
            this.onFillParentInfo_PSSysAIPipelineAgent(pSSysAIPipelineWorker, pSSysAIPipelineAgent);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAIPIPELINEWORKER_PSSYSAIWORKERAGENT_PSSYSAIWORKERAGENTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.aidesign.service.PSSysAIWorkerAgentService", (SessionFactory)this.getSessionFactory());
            PSSysAIWorkerAgent pSSysAIWorkerAgent = (PSSysAIWorkerAgent)iService.getDEModel().createEntity();
            pSSysAIWorkerAgent.set("PSSYSAIWORKERAGENTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysAIWorkerAgent);
            } else {
                iService.get((IEntity)pSSysAIWorkerAgent);
            }
            this.onFillParentInfo_PSSysAIWorkerAgent(pSSysAIPipelineWorker, pSSysAIWorkerAgent);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysAIPipelineWorker, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysAIFactory(PSSysAIPipelineWorker pSSysAIPipelineWorker, PSSysAIFactory pSSysAIFactory) throws Exception {
        pSSysAIPipelineWorker.setPSSysAIFactoryId(pSSysAIFactory.getPSSysAIFactoryId());
        pSSysAIPipelineWorker.setPSSysAIFactoryName(pSSysAIFactory.getPSSysAIFactoryName());
    }

    protected void onFillParentInfo_PSSysAIPipelineAgent(PSSysAIPipelineWorker pSSysAIPipelineWorker, PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        pSSysAIPipelineWorker.setPSSysAIPipelineAgentId(pSSysAIPipelineAgent.getPSSysAIPipelineAgentId());
        pSSysAIPipelineWorker.setPSSysAIPipelineAgentName(pSSysAIPipelineAgent.getPSSysAIPipelineAgentName());
        if (pSSysAIPipelineAgent.getPSSysAIFactory() != null) {
            this.onFillParentInfo_PSSysAIFactory(pSSysAIPipelineWorker, pSSysAIPipelineAgent.getPSSysAIFactory());
        }
    }

    protected void onFillParentInfo_PSSysAIWorkerAgent(PSSysAIPipelineWorker pSSysAIPipelineWorker, PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
        pSSysAIPipelineWorker.setPSSysAIWorkerAgentId(pSSysAIWorkerAgent.getPSSysAIWorkerAgentId());
        pSSysAIPipelineWorker.setPSSysAIWorkerAgentName(pSSysAIWorkerAgent.getPSSysAIWorkerAgentName());
    }

    protected void onFillEntityFullInfo(PSSysAIPipelineWorker pSSysAIPipelineWorker, boolean bl) throws Exception {
        if (bl && pSSysAIPipelineWorker.getValidFlag() == null) {
            pSSysAIPipelineWorker.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSSysAIPipelineWorker, bl);
        this.onFillEntityFullInfo_PSSysAIFactory(pSSysAIPipelineWorker, bl);
        this.onFillEntityFullInfo_PSSysAIPipelineAgent(pSSysAIPipelineWorker, bl);
        this.onFillEntityFullInfo_PSSysAIWorkerAgent(pSSysAIPipelineWorker, bl);
    }

    protected void onFillEntityFullInfo_PSSysAIFactory(PSSysAIPipelineWorker pSSysAIPipelineWorker, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysAIPipelineAgent(PSSysAIPipelineWorker pSSysAIPipelineWorker, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysAIWorkerAgent(PSSysAIPipelineWorker pSSysAIPipelineWorker, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysAIPipelineWorker pSSysAIPipelineWorker, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysAIPipelineWorker, bl);
    }

    public ArrayList<PSSysAIPipelineWorker> selectByPSSysAIFactory(PSSysAIFactoryBase pSSysAIFactoryBase) throws Exception {
        return this.selectByPSSysAIFactory(pSSysAIFactoryBase, "", -1);
    }

    public ArrayList<PSSysAIPipelineWorker> selectByPSSysAIFactory(PSSysAIFactoryBase pSSysAIFactoryBase, String string) throws Exception {
        return this.selectByPSSysAIFactory(pSSysAIFactoryBase, string, -1);
    }

    public ArrayList<PSSysAIPipelineWorker> selectByPSSysAIFactory(PSSysAIFactoryBase pSSysAIFactoryBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAIFACTORYID", (Object)pSSysAIFactoryBase.getPSSysAIFactoryId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAIFactoryCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAIFactoryCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysAIPipelineWorker> selectByPSSysAIPipelineAgent(PSSysAIPipelineAgentBase pSSysAIPipelineAgentBase) throws Exception {
        return this.selectByPSSysAIPipelineAgent(pSSysAIPipelineAgentBase, "", -1);
    }

    public ArrayList<PSSysAIPipelineWorker> selectByPSSysAIPipelineAgent(PSSysAIPipelineAgentBase pSSysAIPipelineAgentBase, String string) throws Exception {
        return this.selectByPSSysAIPipelineAgent(pSSysAIPipelineAgentBase, string, -1);
    }

    public ArrayList<PSSysAIPipelineWorker> selectByPSSysAIPipelineAgent(PSSysAIPipelineAgentBase pSSysAIPipelineAgentBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAIPIPELINEAGENTID", (Object)pSSysAIPipelineAgentBase.getPSSysAIPipelineAgentId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAIPipelineAgentCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAIPipelineAgentCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysAIPipelineWorker> selectTempByPSSysAIPipelineAgent(PSSysAIPipelineAgentBase pSSysAIPipelineAgentBase) throws Exception {
        return this.selectTempByPSSysAIPipelineAgent(pSSysAIPipelineAgentBase, "");
    }

    public ArrayList<PSSysAIPipelineWorker> selectTempByPSSysAIPipelineAgent(PSSysAIPipelineAgentBase pSSysAIPipelineAgentBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAIPIPELINEAGENTID", (Object)pSSysAIPipelineAgentBase.getPSSysAIPipelineAgentId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysAIPipelineAgentCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysAIPipelineAgentCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysAIPipelineWorker> selectByPSSysAIWorkerAgent(PSSysAIWorkerAgentBase pSSysAIWorkerAgentBase) throws Exception {
        return this.selectByPSSysAIWorkerAgent(pSSysAIWorkerAgentBase, "", -1);
    }

    public ArrayList<PSSysAIPipelineWorker> selectByPSSysAIWorkerAgent(PSSysAIWorkerAgentBase pSSysAIWorkerAgentBase, String string) throws Exception {
        return this.selectByPSSysAIWorkerAgent(pSSysAIWorkerAgentBase, string, -1);
    }

    public ArrayList<PSSysAIPipelineWorker> selectByPSSysAIWorkerAgent(PSSysAIWorkerAgentBase pSSysAIWorkerAgentBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAIWORKERAGENTID", (Object)pSSysAIWorkerAgentBase.getPSSysAIWorkerAgentId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAIWorkerAgentCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAIWorkerAgentCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        ArrayList<PSSysAIPipelineWorker> arrayList = this.selectByPSSysAIFactory(pSSysAIFactory, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAIFACTORY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysAIFactory);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAIPIPELINEWORKER_PSSYSAIFACTORY_PSSYSAIFACTORYID", "", iDataEntityModel.getName(), "PSSYSAIPIPELINEWORKER", iDataEntityModel.getDataInfo((IEntity)pSSysAIFactory), arrayList.get(0)));
        }
    }

    public void resetPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        ArrayList<PSSysAIPipelineWorker> arrayList = this.selectByPSSysAIFactory(pSSysAIFactory);
        for (PSSysAIPipelineWorker pSSysAIPipelineWorker : arrayList) {
            PSSysAIPipelineWorker pSSysAIPipelineWorker2 = (PSSysAIPipelineWorker)this.getDEModel().createEntity();
            pSSysAIPipelineWorker2.setPSSysAIPipelineWorkerId(pSSysAIPipelineWorker.getPSSysAIPipelineWorkerId());
            pSSysAIPipelineWorker2.setPSSysAIFactoryId(null);
            this.update(pSSysAIPipelineWorker2);
        }
    }

    public void removeByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        final PSSysAIFactory pSSysAIFactory2 = pSSysAIFactory;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAIPipelineWorkerServiceBase.this.onBeforeRemoveByPSSysAIFactory(pSSysAIFactory2);
                PSSysAIPipelineWorkerServiceBase.this.internalRemoveByPSSysAIFactory(pSSysAIFactory2);
                PSSysAIPipelineWorkerServiceBase.this.onAfterRemoveByPSSysAIFactory(pSSysAIFactory2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
    }

    protected void internalRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        ArrayList<PSSysAIPipelineWorker> arrayList = this.selectByPSSysAIFactory(pSSysAIFactory);
        this.onBeforeRemoveByPSSysAIFactory(pSSysAIFactory, arrayList);
        for (PSSysAIPipelineWorker pSSysAIPipelineWorker : arrayList) {
            this.remove((IEntity)pSSysAIPipelineWorker);
        }
        this.onAfterRemoveByPSSysAIFactory(pSSysAIFactory, arrayList);
    }

    protected void onAfterRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
    }

    protected void onBeforeRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory, ArrayList<PSSysAIPipelineWorker> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory, ArrayList<PSSysAIPipelineWorker> arrayList) throws Exception {
    }

    public void testRemoveByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        ArrayList<PSSysAIPipelineWorker> arrayList = this.selectByPSSysAIPipelineAgent(pSSysAIPipelineAgent, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAIPIPELINEAGENT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysAIPipelineAgent);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAIPIPELINEWORKER_PSSYSAIPIPELINEAGENT_PSSYSAIPIPELINEAGENTID", "", iDataEntityModel.getName(), "PSSYSAIPIPELINEWORKER", iDataEntityModel.getDataInfo((IEntity)pSSysAIPipelineAgent), arrayList.get(0)));
        }
    }

    public void resetPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        ArrayList<PSSysAIPipelineWorker> arrayList = this.selectByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        for (PSSysAIPipelineWorker pSSysAIPipelineWorker : arrayList) {
            PSSysAIPipelineWorker pSSysAIPipelineWorker2 = (PSSysAIPipelineWorker)this.getDEModel().createEntity();
            pSSysAIPipelineWorker2.setPSSysAIPipelineWorkerId(pSSysAIPipelineWorker.getPSSysAIPipelineWorkerId());
            pSSysAIPipelineWorker2.setPSSysAIPipelineAgentId(null);
            this.update(pSSysAIPipelineWorker2);
        }
    }

    public void resetTempPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        ArrayList<PSSysAIPipelineWorker> arrayList = this.selectTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        for (PSSysAIPipelineWorker pSSysAIPipelineWorker : arrayList) {
            PSSysAIPipelineWorker pSSysAIPipelineWorker2 = (PSSysAIPipelineWorker)this.getDEModel().createEntity();
            pSSysAIPipelineWorker2.setPSSysAIPipelineWorkerId(pSSysAIPipelineWorker.getPSSysAIPipelineWorkerId());
            pSSysAIPipelineWorker2.setPSSysAIPipelineAgentId(null);
            this.updateTemp((IEntity)pSSysAIPipelineWorker2);
        }
    }

    public void removeByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        final PSSysAIPipelineAgent pSSysAIPipelineAgent2 = pSSysAIPipelineAgent;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAIPipelineWorkerServiceBase.this.onBeforeRemoveByPSSysAIPipelineAgent(pSSysAIPipelineAgent2);
                PSSysAIPipelineWorkerServiceBase.this.internalRemoveByPSSysAIPipelineAgent(pSSysAIPipelineAgent2);
                PSSysAIPipelineWorkerServiceBase.this.onAfterRemoveByPSSysAIPipelineAgent(pSSysAIPipelineAgent2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
    }

    protected void internalRemoveByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        ArrayList<PSSysAIPipelineWorker> arrayList = this.selectByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        this.onBeforeRemoveByPSSysAIPipelineAgent(pSSysAIPipelineAgent, arrayList);
        for (PSSysAIPipelineWorker pSSysAIPipelineWorker : arrayList) {
            this.remove((IEntity)pSSysAIPipelineWorker);
        }
        this.onAfterRemoveByPSSysAIPipelineAgent(pSSysAIPipelineAgent, arrayList);
    }

    protected void onAfterRemoveByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
    }

    protected void onBeforeRemoveByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent, ArrayList<PSSysAIPipelineWorker> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent, ArrayList<PSSysAIPipelineWorker> arrayList) throws Exception {
    }

    public void testRemoveByPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
        ArrayList<PSSysAIPipelineWorker> arrayList = this.selectByPSSysAIWorkerAgent(pSSysAIWorkerAgent, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAIWORKERAGENT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysAIWorkerAgent);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAIPIPELINEWORKER_PSSYSAIWORKERAGENT_PSSYSAIWORKERAGENTID", "", iDataEntityModel.getName(), "PSSYSAIPIPELINEWORKER", iDataEntityModel.getDataInfo((IEntity)pSSysAIWorkerAgent), arrayList.get(0)));
        }
    }

    public void resetPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
        ArrayList<PSSysAIPipelineWorker> arrayList = this.selectByPSSysAIWorkerAgent(pSSysAIWorkerAgent);
        for (PSSysAIPipelineWorker pSSysAIPipelineWorker : arrayList) {
            PSSysAIPipelineWorker pSSysAIPipelineWorker2 = (PSSysAIPipelineWorker)this.getDEModel().createEntity();
            pSSysAIPipelineWorker2.setPSSysAIPipelineWorkerId(pSSysAIPipelineWorker.getPSSysAIPipelineWorkerId());
            pSSysAIPipelineWorker2.setPSSysAIWorkerAgentId(null);
            this.update(pSSysAIPipelineWorker2);
        }
    }

    public void removeByPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
        final PSSysAIWorkerAgent pSSysAIWorkerAgent2 = pSSysAIWorkerAgent;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAIPipelineWorkerServiceBase.this.onBeforeRemoveByPSSysAIWorkerAgent(pSSysAIWorkerAgent2);
                PSSysAIPipelineWorkerServiceBase.this.internalRemoveByPSSysAIWorkerAgent(pSSysAIWorkerAgent2);
                PSSysAIPipelineWorkerServiceBase.this.onAfterRemoveByPSSysAIWorkerAgent(pSSysAIWorkerAgent2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
    }

    protected void internalRemoveByPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
        ArrayList<PSSysAIPipelineWorker> arrayList = this.selectByPSSysAIWorkerAgent(pSSysAIWorkerAgent);
        this.onBeforeRemoveByPSSysAIWorkerAgent(pSSysAIWorkerAgent, arrayList);
        for (PSSysAIPipelineWorker pSSysAIPipelineWorker : arrayList) {
            this.remove((IEntity)pSSysAIPipelineWorker);
        }
        this.onAfterRemoveByPSSysAIWorkerAgent(pSSysAIWorkerAgent, arrayList);
    }

    protected void onAfterRemoveByPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
    }

    protected void onBeforeRemoveByPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent, ArrayList<PSSysAIPipelineWorker> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent, ArrayList<PSSysAIPipelineWorker> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysAIPipelineWorker pSSysAIPipelineWorker) throws Exception {
        super.onBeforeRemove(pSSysAIPipelineWorker);
    }

    public void removeTempByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        final PSSysAIPipelineAgent pSSysAIPipelineAgent2 = pSSysAIPipelineAgent;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAIPipelineWorkerServiceBase.this.onBeforeRemoveTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent2);
                PSSysAIPipelineWorkerServiceBase.this.internalRemoveTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent2);
                PSSysAIPipelineWorkerServiceBase.this.onAfterRemoveTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
    }

    protected void internalRemoveTempByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        ArrayList<PSSysAIPipelineWorker> arrayList = this.selectTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        this.onBeforeRemoveTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent, arrayList);
        for (PSSysAIPipelineWorker pSSysAIPipelineWorker : arrayList) {
            this.removeTemp((IEntity)pSSysAIPipelineWorker);
        }
        this.onAfterRemoveTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent, arrayList);
    }

    protected void onAfterRemoveTempByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent, ArrayList<PSSysAIPipelineWorker> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent, ArrayList<PSSysAIPipelineWorker> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSSysAIPipelineWorker pSSysAIPipelineWorker, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysAIPipelineWorker, cloneSession);
        if (pSSysAIPipelineWorker.getPSSysAIFactoryId() != null && (iEntity = cloneSession.getEntity("PSSYSAIFACTORY", (Object)pSSysAIPipelineWorker.getPSSysAIFactoryId())) != null) {
            this.onFillParentInfo_PSSysAIFactory(pSSysAIPipelineWorker, (PSSysAIFactory)iEntity);
        }
        if (pSSysAIPipelineWorker.getPSSysAIPipelineAgentId() != null && (iEntity = cloneSession.getEntity("PSSYSAIPIPELINEAGENT", (Object)pSSysAIPipelineWorker.getPSSysAIPipelineAgentId())) != null) {
            this.onFillParentInfo_PSSysAIPipelineAgent(pSSysAIPipelineWorker, (PSSysAIPipelineAgent)iEntity);
        }
        if (pSSysAIPipelineWorker.getPSSysAIWorkerAgentId() != null && (iEntity = cloneSession.getEntity("PSSYSAIWORKERAGENT", (Object)pSSysAIPipelineWorker.getPSSysAIWorkerAgentId())) != null) {
            this.onFillParentInfo_PSSysAIWorkerAgent(pSSysAIPipelineWorker, (PSSysAIWorkerAgent)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysAIPipelineWorker pSSysAIPipelineWorker, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysAIPipelineWorker, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysAIPipelineWorker pSSysAIPipelineWorker, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSSysAIPipelineWorker, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIFactoryId(bl, pSSysAIPipelineWorker, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIPipelineAgentId(bl, pSSysAIPipelineWorker, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIPipelineWorkerId(bl, pSSysAIPipelineWorker, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIPipelineWorkerName(bl, pSSysAIPipelineWorker, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIWorkerAgentId(bl, pSSysAIPipelineWorker, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysAIPipelineWorker, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysAIPipelineWorker, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysAIPipelineWorker, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysAIPipelineWorker, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysAIPipelineWorker, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysAIPipelineWorker, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysAIPipelineWorker, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysAIPipelineWorker pSSysAIPipelineWorker, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineWorker.isMemoDirty() : !pSSysAIPipelineWorker.isMemoDirty()) {
            return null;
        }
        String string = pSSysAIPipelineWorker.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysAIPipelineWorker, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAIFactoryId(boolean bl, PSSysAIPipelineWorker pSSysAIPipelineWorker, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineWorker.isPSSysAIFactoryIdDirty() : !pSSysAIPipelineWorker.isPSSysAIFactoryIdDirty()) {
            return null;
        }
        String string = pSSysAIPipelineWorker.getPSSysAIFactoryId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIFactoryId_Default((IEntity)pSSysAIPipelineWorker, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIFACTORYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAIPipelineAgentId(boolean bl, PSSysAIPipelineWorker pSSysAIPipelineWorker, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineWorker.isPSSysAIPipelineAgentIdDirty() : !pSSysAIPipelineWorker.isPSSysAIPipelineAgentIdDirty()) {
            return null;
        }
        String string = pSSysAIPipelineWorker.getPSSysAIPipelineAgentId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIPipelineAgentId_Default((IEntity)pSSysAIPipelineWorker, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIPIPELINEAGENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAIPipelineWorkerId(boolean bl, PSSysAIPipelineWorker pSSysAIPipelineWorker, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineWorker.isPSSysAIPipelineWorkerIdDirty() && !bl2 : !pSSysAIPipelineWorker.isPSSysAIPipelineWorkerIdDirty()) {
            return null;
        }
        String string = pSSysAIPipelineWorker.getPSSysAIPipelineWorkerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIPIPELINEWORKERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIPipelineWorkerId_Default((IEntity)pSSysAIPipelineWorker, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIPIPELINEWORKERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAIPipelineWorkerName(boolean bl, PSSysAIPipelineWorker pSSysAIPipelineWorker, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineWorker.isPSSysAIPipelineWorkerNameDirty() && !bl2 : !pSSysAIPipelineWorker.isPSSysAIPipelineWorkerNameDirty()) {
            return null;
        }
        String string = pSSysAIPipelineWorker.getPSSysAIPipelineWorkerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIPIPELINEWORKERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIPipelineWorkerName_Default((IEntity)pSSysAIPipelineWorker, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIPIPELINEWORKERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAIWorkerAgentId(boolean bl, PSSysAIPipelineWorker pSSysAIPipelineWorker, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineWorker.isPSSysAIWorkerAgentIdDirty() && !bl2 : !pSSysAIPipelineWorker.isPSSysAIWorkerAgentIdDirty()) {
            return null;
        }
        String string = pSSysAIPipelineWorker.getPSSysAIWorkerAgentId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIWORKERAGENTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIWorkerAgentId_Default((IEntity)pSSysAIPipelineWorker, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIWORKERAGENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSAIPIPELINEAGENTID";
                String string4 = this.checkFieldDupRule(this.getPSSysAIPipelineWorkerDEModel(), "PSSYSAIWORKERAGENTID", string3, pSSysAIPipelineWorker, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSAIWORKERAGENTID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysAIPipelineWorker pSSysAIPipelineWorker, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineWorker.isUserCatDirty() : !pSSysAIPipelineWorker.isUserCatDirty()) {
            return null;
        }
        String string = pSSysAIPipelineWorker.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysAIPipelineWorker, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysAIPipelineWorker pSSysAIPipelineWorker, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineWorker.isUserTagDirty() : !pSSysAIPipelineWorker.isUserTagDirty()) {
            return null;
        }
        String string = pSSysAIPipelineWorker.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysAIPipelineWorker, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysAIPipelineWorker pSSysAIPipelineWorker, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineWorker.isUserTag2Dirty() : !pSSysAIPipelineWorker.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysAIPipelineWorker.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysAIPipelineWorker, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysAIPipelineWorker pSSysAIPipelineWorker, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineWorker.isUserTag3Dirty() : !pSSysAIPipelineWorker.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysAIPipelineWorker.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysAIPipelineWorker, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysAIPipelineWorker pSSysAIPipelineWorker, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineWorker.isUserTag4Dirty() : !pSSysAIPipelineWorker.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysAIPipelineWorker.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysAIPipelineWorker, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysAIPipelineWorker pSSysAIPipelineWorker, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineWorker.isValidFlagDirty() && !bl2 : !pSSysAIPipelineWorker.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysAIPipelineWorker.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysAIPipelineWorker, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysAIPipelineWorker pSSysAIPipelineWorker, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysAIPipelineWorker, bl);
    }

    protected void onSyncIndexEntities(PSSysAIPipelineWorker pSSysAIPipelineWorker, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysAIPipelineWorker, bl);
    }

    public Object getDataContextValue(PSSysAIPipelineWorker pSSysAIPipelineWorker, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysAIPipelineWorker, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysAIPipelineAgent pSSysAIPipelineAgent = pSSysAIPipelineWorker.getPSSysAIPipelineAgent();
        if (pSSysAIPipelineAgent != null && pSSysAIPipelineAgent.contains(string)) {
            return pSSysAIPipelineAgent.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysAIPipelineWorker pSSysAIPipelineWorker, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysAIPipelineWorker, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAIFACTORYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIFactoryId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAIFACTORYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIFactoryName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAIPIPELINEAGENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIPipelineAgentId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAIPIPELINEAGENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIPipelineAgentName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAIPIPELINEWORKERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIPipelineWorkerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAIPIPELINEWORKERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIPipelineWorkerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAIWORKERAGENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIWorkerAgentId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAIWORKERAGENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIWorkerAgentName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSSysAIFactoryId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAIFACTORYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAIFactoryName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAIFACTORYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAIPipelineAgentId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAIPIPELINEAGENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAIPipelineAgentName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAIPIPELINEAGENTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAIPipelineWorkerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAIPIPELINEWORKERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAIPipelineWorkerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAIPIPELINEWORKERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAIWorkerAgentId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAIWORKERAGENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAIWorkerAgentName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAIWORKERAGENTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysAIPipelineWorker pSSysAIPipelineWorker) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysAIPipelineWorker)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysAIPipelineWorker pSSysAIPipelineWorker) throws Exception {
        super.onUpdateParent((IEntity)pSSysAIPipelineWorker);
    }

    @Override
    protected void exportCurXmlModel(PSSysAIPipelineWorker pSSysAIPipelineWorker, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSAIPIPELINEWORKER");
        if (!bl) {
            pSSysAIPipelineWorker.setCreateDate(null);
            pSSysAIPipelineWorker.setCreateMan(null);
            pSSysAIPipelineWorker.setPSSysAIPipelineWorkerId(null);
            pSSysAIPipelineWorker.setUpdateDate(null);
            pSSysAIPipelineWorker.setUpdateMan(null);
            pSSysAIPipelineWorker.setPSSysAIPipelineAgentId(null);
            pSSysAIPipelineWorker.setPSSysAIPipelineAgentName(null);
            super.exportCurXmlModel(pSSysAIPipelineWorker, xmlNode, bl);
        }
    }
}

