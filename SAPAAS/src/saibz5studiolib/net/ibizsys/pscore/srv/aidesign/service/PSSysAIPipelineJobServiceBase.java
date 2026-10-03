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
import net.ibizsys.pscore.srv.aidesign.dao.PSSysAIPipelineJobDAO;
import net.ibizsys.pscore.srv.aidesign.demodel.PSSysAIPipelineJobDEModel;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIFactory;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIFactoryBase;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIPipelineAgent;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIPipelineAgentBase;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIPipelineJob;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIWorkerAgent;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIWorkerAgentBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysAIPipelineJobServiceBase
extends PSCoreSysServiceBase<PSSysAIPipelineJob> {
    private static final Log log = LogFactory.getLog(PSSysAIPipelineJobServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysAIPipelineJobDEModel pSSysAIPipelineJobDEModel;
    private PSSysAIPipelineJobDAO pSSysAIPipelineJobDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineJobService";
    }

    public PSSysAIPipelineJobDEModel getPSSysAIPipelineJobDEModel() {
        if (this.pSSysAIPipelineJobDEModel == null) {
            try {
                this.pSSysAIPipelineJobDEModel = (PSSysAIPipelineJobDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.aidesign.demodel.PSSysAIPipelineJobDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysAIPipelineJobDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysAIPipelineJobDEModel();
    }

    public PSSysAIPipelineJobDAO getPSSysAIPipelineJobDAO() {
        if (this.pSSysAIPipelineJobDAO == null) {
            try {
                this.pSSysAIPipelineJobDAO = (PSSysAIPipelineJobDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.aidesign.dao.PSSysAIPipelineJobDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysAIPipelineJobDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysAIPipelineJobDAO();
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

    protected void onFillParentInfo(PSSysAIPipelineJob pSSysAIPipelineJob, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAIPIPELINEJOB_PSCODELIST_STEPPSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCodeList);
            } else {
                iService.get(pSCodeList);
            }
            this.onFillParentInfo_StepPSCodeList(pSSysAIPipelineJob, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAIPIPELINEJOB_PSDEDATASET_PSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDataSet(pSSysAIPipelineJob, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAIPIPELINEJOB_PSSYSAIFACTORY_PSSYSAIFACTORYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.aidesign.service.PSSysAIFactoryService", (SessionFactory)this.getSessionFactory());
            PSSysAIFactory pSSysAIFactory = (PSSysAIFactory)iService.getDEModel().createEntity();
            pSSysAIFactory.set("PSSYSAIFACTORYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysAIFactory);
            } else {
                iService.get(pSSysAIFactory);
            }
            this.onFillParentInfo_PSSysAIFactory(pSSysAIPipelineJob, pSSysAIFactory);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAIPIPELINEJOB_PSSYSAIPIPELINEAGENT_PSSYSAIPIPELINEAGENTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineAgentService", (SessionFactory)this.getSessionFactory());
            PSSysAIPipelineAgent pSSysAIPipelineAgent = (PSSysAIPipelineAgent)iService.getDEModel().createEntity();
            pSSysAIPipelineAgent.set("PSSYSAIPIPELINEAGENTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysAIPipelineAgent);
            } else {
                iService.get(pSSysAIPipelineAgent);
            }
            this.onFillParentInfo_PSSysAIPipelineAgent(pSSysAIPipelineJob, pSSysAIPipelineAgent);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAIPIPELINEJOB_PSSYSAIWORKERAGENT_PSSYSAIWORKERAGENTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.aidesign.service.PSSysAIWorkerAgentService", (SessionFactory)this.getSessionFactory());
            PSSysAIWorkerAgent pSSysAIWorkerAgent = (PSSysAIWorkerAgent)iService.getDEModel().createEntity();
            pSSysAIWorkerAgent.set("PSSYSAIWORKERAGENTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysAIWorkerAgent);
            } else {
                iService.get(pSSysAIWorkerAgent);
            }
            this.onFillParentInfo_PSSysAIWorkerAgent(pSSysAIPipelineJob, pSSysAIWorkerAgent);
            return;
        }
        super.onFillParentInfo(pSSysAIPipelineJob, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_StepPSCodeList(PSSysAIPipelineJob pSSysAIPipelineJob, PSCodeList pSCodeList) throws Exception {
        pSSysAIPipelineJob.setStepPSCodeListId(pSCodeList.getPSCodeListId());
        pSSysAIPipelineJob.setStepPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_PSDEDataSet(PSSysAIPipelineJob pSSysAIPipelineJob, PSDEDataSet pSDEDataSet) throws Exception {
        pSSysAIPipelineJob.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSSysAIPipelineJob.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSSysAIFactory(PSSysAIPipelineJob pSSysAIPipelineJob, PSSysAIFactory pSSysAIFactory) throws Exception {
        pSSysAIPipelineJob.setPSSysAIFactoryId(pSSysAIFactory.getPSSysAIFactoryId());
        pSSysAIPipelineJob.setPSSysAIFactoryName(pSSysAIFactory.getPSSysAIFactoryName());
    }

    protected void onFillParentInfo_PSSysAIPipelineAgent(PSSysAIPipelineJob pSSysAIPipelineJob, PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        pSSysAIPipelineJob.setPSSysAIPipelineAgentId(pSSysAIPipelineAgent.getPSSysAIPipelineAgentId());
        pSSysAIPipelineJob.setPSSysAIPipelineAgentName(pSSysAIPipelineAgent.getPSSysAIPipelineAgentName());
        if (pSSysAIPipelineAgent.getPSSysAIFactory() != null) {
            this.onFillParentInfo_PSSysAIFactory(pSSysAIPipelineJob, pSSysAIPipelineAgent.getPSSysAIFactory());
        }
    }

    protected void onFillParentInfo_PSSysAIWorkerAgent(PSSysAIPipelineJob pSSysAIPipelineJob, PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
        pSSysAIPipelineJob.setPSDEId(pSSysAIWorkerAgent.getPSDEId());
        pSSysAIPipelineJob.setPSSysAIWorkerAgentId(pSSysAIWorkerAgent.getPSSysAIWorkerAgentId());
        pSSysAIPipelineJob.setPSSysAIWorkerAgentName(pSSysAIWorkerAgent.getPSSysAIWorkerAgentName());
    }

    protected void onFillEntityFullInfo(PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl) throws Exception {
        if (bl && pSSysAIPipelineJob.getValidFlag() == null) {
            pSSysAIPipelineJob.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSysAIPipelineJob, bl);
        this.onFillEntityFullInfo_StepPSCodeList(pSSysAIPipelineJob, bl);
        this.onFillEntityFullInfo_PSDEDataSet(pSSysAIPipelineJob, bl);
        this.onFillEntityFullInfo_PSSysAIFactory(pSSysAIPipelineJob, bl);
        this.onFillEntityFullInfo_PSSysAIPipelineAgent(pSSysAIPipelineJob, bl);
        this.onFillEntityFullInfo_PSSysAIWorkerAgent(pSSysAIPipelineJob, bl);
    }

    protected void onFillEntityFullInfo_StepPSCodeList(PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDataSet(PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysAIFactory(PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysAIPipelineAgent(PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysAIWorkerAgent(PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysAIPipelineJob, bl);
    }

    public ArrayList<PSSysAIPipelineJob> selectByStepPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByStepPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSSysAIPipelineJob> selectByStepPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByStepPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSSysAIPipelineJob> selectByStepPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("STEPPSCODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByStepPSCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByStepPSCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysAIPipelineJob> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSSysAIPipelineJob> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSSysAIPipelineJob> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDATASETID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDataSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDataSetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysAIPipelineJob> selectByPSSysAIFactory(PSSysAIFactoryBase pSSysAIFactoryBase) throws Exception {
        return this.selectByPSSysAIFactory(pSSysAIFactoryBase, "", -1);
    }

    public ArrayList<PSSysAIPipelineJob> selectByPSSysAIFactory(PSSysAIFactoryBase pSSysAIFactoryBase, String string) throws Exception {
        return this.selectByPSSysAIFactory(pSSysAIFactoryBase, string, -1);
    }

    public ArrayList<PSSysAIPipelineJob> selectByPSSysAIFactory(PSSysAIFactoryBase pSSysAIFactoryBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysAIPipelineJob> selectByPSSysAIPipelineAgent(PSSysAIPipelineAgentBase pSSysAIPipelineAgentBase) throws Exception {
        return this.selectByPSSysAIPipelineAgent(pSSysAIPipelineAgentBase, "", -1);
    }

    public ArrayList<PSSysAIPipelineJob> selectByPSSysAIPipelineAgent(PSSysAIPipelineAgentBase pSSysAIPipelineAgentBase, String string) throws Exception {
        return this.selectByPSSysAIPipelineAgent(pSSysAIPipelineAgentBase, string, -1);
    }

    public ArrayList<PSSysAIPipelineJob> selectByPSSysAIPipelineAgent(PSSysAIPipelineAgentBase pSSysAIPipelineAgentBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysAIPipelineJob> selectTempByPSSysAIPipelineAgent(PSSysAIPipelineAgentBase pSSysAIPipelineAgentBase) throws Exception {
        return this.selectTempByPSSysAIPipelineAgent(pSSysAIPipelineAgentBase, "");
    }

    public ArrayList<PSSysAIPipelineJob> selectTempByPSSysAIPipelineAgent(PSSysAIPipelineAgentBase pSSysAIPipelineAgentBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAIPIPELINEAGENTID", (Object)pSSysAIPipelineAgentBase.getPSSysAIPipelineAgentId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysAIPipelineAgentCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysAIPipelineAgentCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysAIPipelineJob> selectByPSSysAIWorkerAgent(PSSysAIWorkerAgentBase pSSysAIWorkerAgentBase) throws Exception {
        return this.selectByPSSysAIWorkerAgent(pSSysAIWorkerAgentBase, "", -1);
    }

    public ArrayList<PSSysAIPipelineJob> selectByPSSysAIWorkerAgent(PSSysAIWorkerAgentBase pSSysAIWorkerAgentBase, String string) throws Exception {
        return this.selectByPSSysAIWorkerAgent(pSSysAIWorkerAgentBase, string, -1);
    }

    public ArrayList<PSSysAIPipelineJob> selectByPSSysAIWorkerAgent(PSSysAIWorkerAgentBase pSSysAIWorkerAgentBase, String string, int n) throws Exception {
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

    public void testRemoveByStepPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysAIPipelineJob> arrayList = this.selectByStepPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAIPIPELINEJOB_PSCODELIST_STEPPSCODELISTID", "", iDataEntityModel.getName(), "PSSYSAIPIPELINEJOB", iDataEntityModel.getDataInfo(pSCodeList), arrayList.get(0)));
        }
    }

    public void resetStepPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysAIPipelineJob> arrayList = this.selectByStepPSCodeList(pSCodeList);
        for (PSSysAIPipelineJob pSSysAIPipelineJob : arrayList) {
            PSSysAIPipelineJob pSSysAIPipelineJob2 = (PSSysAIPipelineJob)this.getDEModel().createEntity();
            pSSysAIPipelineJob2.setPSSysAIPipelineJobId(pSSysAIPipelineJob.getPSSysAIPipelineJobId());
            pSSysAIPipelineJob2.setStepPSCodeListId(null);
            this.update(pSSysAIPipelineJob2);
        }
    }

    public void removeByStepPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAIPipelineJobServiceBase.this.onBeforeRemoveByStepPSCodeList(pSCodeList2);
                PSSysAIPipelineJobServiceBase.this.internalRemoveByStepPSCodeList(pSCodeList2);
                PSSysAIPipelineJobServiceBase.this.onAfterRemoveByStepPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByStepPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByStepPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysAIPipelineJob> arrayList = this.selectByStepPSCodeList(pSCodeList);
        this.onBeforeRemoveByStepPSCodeList(pSCodeList, arrayList);
        for (PSSysAIPipelineJob pSSysAIPipelineJob : arrayList) {
            this.remove(pSSysAIPipelineJob);
        }
        this.onAfterRemoveByStepPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByStepPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByStepPSCodeList(PSCodeList pSCodeList, ArrayList<PSSysAIPipelineJob> arrayList) throws Exception {
    }

    protected void onAfterRemoveByStepPSCodeList(PSCodeList pSCodeList, ArrayList<PSSysAIPipelineJob> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysAIPipelineJob> arrayList = this.selectByPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAIPIPELINEJOB_PSDEDATASET_PSDEDATASETID", "", iDataEntityModel.getName(), "PSSYSAIPIPELINEJOB", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysAIPipelineJob> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        for (PSSysAIPipelineJob pSSysAIPipelineJob : arrayList) {
            PSSysAIPipelineJob pSSysAIPipelineJob2 = (PSSysAIPipelineJob)this.getDEModel().createEntity();
            pSSysAIPipelineJob2.setPSSysAIPipelineJobId(pSSysAIPipelineJob.getPSSysAIPipelineJobId());
            pSSysAIPipelineJob2.setPSDEDataSetId(null);
            this.update(pSSysAIPipelineJob2);
        }
    }

    public void removeByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAIPipelineJobServiceBase.this.onBeforeRemoveByPSDEDataSet(pSDEDataSet2);
                PSSysAIPipelineJobServiceBase.this.internalRemoveByPSDEDataSet(pSDEDataSet2);
                PSSysAIPipelineJobServiceBase.this.onAfterRemoveByPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysAIPipelineJob> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByPSDEDataSet(pSDEDataSet, arrayList);
        for (PSSysAIPipelineJob pSSysAIPipelineJob : arrayList) {
            this.remove(pSSysAIPipelineJob);
        }
        this.onAfterRemoveByPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSSysAIPipelineJob> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSSysAIPipelineJob> arrayList) throws Exception {
    }

    public void testRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        ArrayList<PSSysAIPipelineJob> arrayList = this.selectByPSSysAIFactory(pSSysAIFactory, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAIFACTORY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysAIFactory);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAIPIPELINEJOB_PSSYSAIFACTORY_PSSYSAIFACTORYID", "", iDataEntityModel.getName(), "PSSYSAIPIPELINEJOB", iDataEntityModel.getDataInfo(pSSysAIFactory), arrayList.get(0)));
        }
    }

    public void resetPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        ArrayList<PSSysAIPipelineJob> arrayList = this.selectByPSSysAIFactory(pSSysAIFactory);
        for (PSSysAIPipelineJob pSSysAIPipelineJob : arrayList) {
            PSSysAIPipelineJob pSSysAIPipelineJob2 = (PSSysAIPipelineJob)this.getDEModel().createEntity();
            pSSysAIPipelineJob2.setPSSysAIPipelineJobId(pSSysAIPipelineJob.getPSSysAIPipelineJobId());
            pSSysAIPipelineJob2.setPSSysAIFactoryId(null);
            this.update(pSSysAIPipelineJob2);
        }
    }

    public void removeByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        final PSSysAIFactory pSSysAIFactory2 = pSSysAIFactory;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAIPipelineJobServiceBase.this.onBeforeRemoveByPSSysAIFactory(pSSysAIFactory2);
                PSSysAIPipelineJobServiceBase.this.internalRemoveByPSSysAIFactory(pSSysAIFactory2);
                PSSysAIPipelineJobServiceBase.this.onAfterRemoveByPSSysAIFactory(pSSysAIFactory2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
    }

    protected void internalRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        ArrayList<PSSysAIPipelineJob> arrayList = this.selectByPSSysAIFactory(pSSysAIFactory);
        this.onBeforeRemoveByPSSysAIFactory(pSSysAIFactory, arrayList);
        for (PSSysAIPipelineJob pSSysAIPipelineJob : arrayList) {
            this.remove(pSSysAIPipelineJob);
        }
        this.onAfterRemoveByPSSysAIFactory(pSSysAIFactory, arrayList);
    }

    protected void onAfterRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
    }

    protected void onBeforeRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory, ArrayList<PSSysAIPipelineJob> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory, ArrayList<PSSysAIPipelineJob> arrayList) throws Exception {
    }

    public void testRemoveByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        ArrayList<PSSysAIPipelineJob> arrayList = this.selectByPSSysAIPipelineAgent(pSSysAIPipelineAgent, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAIPIPELINEAGENT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysAIPipelineAgent);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAIPIPELINEJOB_PSSYSAIPIPELINEAGENT_PSSYSAIPIPELINEAGENTID", "", iDataEntityModel.getName(), "PSSYSAIPIPELINEJOB", iDataEntityModel.getDataInfo(pSSysAIPipelineAgent), arrayList.get(0)));
        }
    }

    public void resetPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        ArrayList<PSSysAIPipelineJob> arrayList = this.selectByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        for (PSSysAIPipelineJob pSSysAIPipelineJob : arrayList) {
            PSSysAIPipelineJob pSSysAIPipelineJob2 = (PSSysAIPipelineJob)this.getDEModel().createEntity();
            pSSysAIPipelineJob2.setPSSysAIPipelineJobId(pSSysAIPipelineJob.getPSSysAIPipelineJobId());
            pSSysAIPipelineJob2.setPSSysAIPipelineAgentId(null);
            this.update(pSSysAIPipelineJob2);
        }
    }

    public void resetTempPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        ArrayList<PSSysAIPipelineJob> arrayList = this.selectTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        for (PSSysAIPipelineJob pSSysAIPipelineJob : arrayList) {
            PSSysAIPipelineJob pSSysAIPipelineJob2 = (PSSysAIPipelineJob)this.getDEModel().createEntity();
            pSSysAIPipelineJob2.setPSSysAIPipelineJobId(pSSysAIPipelineJob.getPSSysAIPipelineJobId());
            pSSysAIPipelineJob2.setPSSysAIPipelineAgentId(null);
            this.updateTemp(pSSysAIPipelineJob2);
        }
    }

    public void removeByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        final PSSysAIPipelineAgent pSSysAIPipelineAgent2 = pSSysAIPipelineAgent;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAIPipelineJobServiceBase.this.onBeforeRemoveByPSSysAIPipelineAgent(pSSysAIPipelineAgent2);
                PSSysAIPipelineJobServiceBase.this.internalRemoveByPSSysAIPipelineAgent(pSSysAIPipelineAgent2);
                PSSysAIPipelineJobServiceBase.this.onAfterRemoveByPSSysAIPipelineAgent(pSSysAIPipelineAgent2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
    }

    protected void internalRemoveByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        ArrayList<PSSysAIPipelineJob> arrayList = this.selectByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        this.onBeforeRemoveByPSSysAIPipelineAgent(pSSysAIPipelineAgent, arrayList);
        for (PSSysAIPipelineJob pSSysAIPipelineJob : arrayList) {
            this.remove(pSSysAIPipelineJob);
        }
        this.onAfterRemoveByPSSysAIPipelineAgent(pSSysAIPipelineAgent, arrayList);
    }

    protected void onAfterRemoveByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
    }

    protected void onBeforeRemoveByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent, ArrayList<PSSysAIPipelineJob> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent, ArrayList<PSSysAIPipelineJob> arrayList) throws Exception {
    }

    public void testRemoveByPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
        ArrayList<PSSysAIPipelineJob> arrayList = this.selectByPSSysAIWorkerAgent(pSSysAIWorkerAgent, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAIWORKERAGENT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysAIWorkerAgent);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAIPIPELINEJOB_PSSYSAIWORKERAGENT_PSSYSAIWORKERAGENTID", "", iDataEntityModel.getName(), "PSSYSAIPIPELINEJOB", iDataEntityModel.getDataInfo(pSSysAIWorkerAgent), arrayList.get(0)));
        }
    }

    public void resetPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
        ArrayList<PSSysAIPipelineJob> arrayList = this.selectByPSSysAIWorkerAgent(pSSysAIWorkerAgent);
        for (PSSysAIPipelineJob pSSysAIPipelineJob : arrayList) {
            PSSysAIPipelineJob pSSysAIPipelineJob2 = (PSSysAIPipelineJob)this.getDEModel().createEntity();
            pSSysAIPipelineJob2.setPSSysAIPipelineJobId(pSSysAIPipelineJob.getPSSysAIPipelineJobId());
            pSSysAIPipelineJob2.setPSSysAIWorkerAgentId(null);
            this.update(pSSysAIPipelineJob2);
        }
    }

    public void removeByPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
        final PSSysAIWorkerAgent pSSysAIWorkerAgent2 = pSSysAIWorkerAgent;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAIPipelineJobServiceBase.this.onBeforeRemoveByPSSysAIWorkerAgent(pSSysAIWorkerAgent2);
                PSSysAIPipelineJobServiceBase.this.internalRemoveByPSSysAIWorkerAgent(pSSysAIWorkerAgent2);
                PSSysAIPipelineJobServiceBase.this.onAfterRemoveByPSSysAIWorkerAgent(pSSysAIWorkerAgent2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
    }

    protected void internalRemoveByPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
        ArrayList<PSSysAIPipelineJob> arrayList = this.selectByPSSysAIWorkerAgent(pSSysAIWorkerAgent);
        this.onBeforeRemoveByPSSysAIWorkerAgent(pSSysAIWorkerAgent, arrayList);
        for (PSSysAIPipelineJob pSSysAIPipelineJob : arrayList) {
            this.remove(pSSysAIPipelineJob);
        }
        this.onAfterRemoveByPSSysAIWorkerAgent(pSSysAIWorkerAgent, arrayList);
    }

    protected void onAfterRemoveByPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
    }

    protected void onBeforeRemoveByPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent, ArrayList<PSSysAIPipelineJob> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysAIWorkerAgent(PSSysAIWorkerAgent pSSysAIWorkerAgent, ArrayList<PSSysAIPipelineJob> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysAIPipelineJob pSSysAIPipelineJob) throws Exception {
        super.onBeforeRemove(pSSysAIPipelineJob);
    }

    public void removeTempByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        final PSSysAIPipelineAgent pSSysAIPipelineAgent2 = pSSysAIPipelineAgent;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAIPipelineJobServiceBase.this.onBeforeRemoveTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent2);
                PSSysAIPipelineJobServiceBase.this.internalRemoveTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent2);
                PSSysAIPipelineJobServiceBase.this.onAfterRemoveTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
    }

    protected void internalRemoveTempByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        ArrayList<PSSysAIPipelineJob> arrayList = this.selectTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        this.onBeforeRemoveTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent, arrayList);
        for (PSSysAIPipelineJob pSSysAIPipelineJob : arrayList) {
            this.removeTemp(pSSysAIPipelineJob);
        }
        this.onAfterRemoveTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent, arrayList);
    }

    protected void onAfterRemoveTempByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent, ArrayList<PSSysAIPipelineJob> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysAIPipelineAgent(PSSysAIPipelineAgent pSSysAIPipelineAgent, ArrayList<PSSysAIPipelineJob> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSSysAIPipelineJob pSSysAIPipelineJob, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysAIPipelineJob, cloneSession);
        if (pSSysAIPipelineJob.getStepPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSSysAIPipelineJob.getStepPSCodeListId())) != null) {
            this.onFillParentInfo_StepPSCodeList(pSSysAIPipelineJob, (PSCodeList)iEntity);
        }
        if (pSSysAIPipelineJob.getPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSSysAIPipelineJob.getPSDEDataSetId())) != null) {
            this.onFillParentInfo_PSDEDataSet(pSSysAIPipelineJob, (PSDEDataSet)iEntity);
        }
        if (pSSysAIPipelineJob.getPSSysAIFactoryId() != null && (iEntity = cloneSession.getEntity("PSSYSAIFACTORY", (Object)pSSysAIPipelineJob.getPSSysAIFactoryId())) != null) {
            this.onFillParentInfo_PSSysAIFactory(pSSysAIPipelineJob, (PSSysAIFactory)iEntity);
        }
        if (pSSysAIPipelineJob.getPSSysAIPipelineAgentId() != null && (iEntity = cloneSession.getEntity("PSSYSAIPIPELINEAGENT", (Object)pSSysAIPipelineJob.getPSSysAIPipelineAgentId())) != null) {
            this.onFillParentInfo_PSSysAIPipelineAgent(pSSysAIPipelineJob, (PSSysAIPipelineAgent)iEntity);
        }
        if (pSSysAIPipelineJob.getPSSysAIWorkerAgentId() != null && (iEntity = cloneSession.getEntity("PSSYSAIWORKERAGENT", (Object)pSSysAIPipelineJob.getPSSysAIWorkerAgentId())) != null) {
            this.onFillParentInfo_PSSysAIWorkerAgent(pSSysAIPipelineJob, (PSSysAIWorkerAgent)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysAIPipelineJob, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_JobParams(bl, pSSysAIPipelineJob, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JobTag(bl, pSSysAIPipelineJob, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysAIPipelineJob, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysAIPipelineJob, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSetId(bl, pSSysAIPipelineJob, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIFactoryId(bl, pSSysAIPipelineJob, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIPipelineAgentId(bl, pSSysAIPipelineJob, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIPipelineJobId(bl, pSSysAIPipelineJob, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIPipelineJobName(bl, pSSysAIPipelineJob, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIWorkerAgentId(bl, pSSysAIPipelineJob, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StepPSCodeListId(bl, pSSysAIPipelineJob, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysAIPipelineJob, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysAIPipelineJob, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysAIPipelineJob, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysAIPipelineJob, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysAIPipelineJob, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysAIPipelineJob, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysAIPipelineJob, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_JobParams(boolean bl, PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineJob.isJobParamsDirty() : !pSSysAIPipelineJob.isJobParamsDirty()) {
            return null;
        }
        String string = pSSysAIPipelineJob.getJobParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JobParams_Default(pSSysAIPipelineJob, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JOBPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JobTag(boolean bl, PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineJob.isJobTagDirty() : !pSSysAIPipelineJob.isJobTagDirty()) {
            return null;
        }
        String string = pSSysAIPipelineJob.getJobTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JobTag_Default(pSSysAIPipelineJob, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JOBTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineJob.isMemoDirty() : !pSSysAIPipelineJob.isMemoDirty()) {
            return null;
        }
        String string = pSSysAIPipelineJob.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysAIPipelineJob, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineJob.isOrderValueDirty() : !pSSysAIPipelineJob.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysAIPipelineJob.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysAIPipelineJob, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataSetId(boolean bl, PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineJob.isPSDEDataSetIdDirty() : !pSSysAIPipelineJob.isPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSSysAIPipelineJob.getPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSetId_Default(pSSysAIPipelineJob, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAIFactoryId(boolean bl, PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineJob.isPSSysAIFactoryIdDirty() : !pSSysAIPipelineJob.isPSSysAIFactoryIdDirty()) {
            return null;
        }
        String string = pSSysAIPipelineJob.getPSSysAIFactoryId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIFactoryId_Default(pSSysAIPipelineJob, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAIPipelineAgentId(boolean bl, PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineJob.isPSSysAIPipelineAgentIdDirty() : !pSSysAIPipelineJob.isPSSysAIPipelineAgentIdDirty()) {
            return null;
        }
        String string = pSSysAIPipelineJob.getPSSysAIPipelineAgentId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIPipelineAgentId_Default(pSSysAIPipelineJob, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAIPipelineJobId(boolean bl, PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineJob.isPSSysAIPipelineJobIdDirty() && !bl2 : !pSSysAIPipelineJob.isPSSysAIPipelineJobIdDirty()) {
            return null;
        }
        String string = pSSysAIPipelineJob.getPSSysAIPipelineJobId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIPIPELINEJOBID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIPipelineJobId_Default(pSSysAIPipelineJob, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIPIPELINEJOBID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAIPipelineJobName(boolean bl, PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineJob.isPSSysAIPipelineJobNameDirty() && !bl2 : !pSSysAIPipelineJob.isPSSysAIPipelineJobNameDirty()) {
            return null;
        }
        String string = pSSysAIPipelineJob.getPSSysAIPipelineJobName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIPIPELINEJOBNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIPipelineJobName_Default(pSSysAIPipelineJob, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIPIPELINEJOBNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAIWorkerAgentId(boolean bl, PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineJob.isPSSysAIWorkerAgentIdDirty() : !pSSysAIPipelineJob.isPSSysAIWorkerAgentIdDirty()) {
            return null;
        }
        String string = pSSysAIPipelineJob.getPSSysAIWorkerAgentId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIWorkerAgentId_Default(pSSysAIPipelineJob, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIWORKERAGENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StepPSCodeListId(boolean bl, PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineJob.isStepPSCodeListIdDirty() : !pSSysAIPipelineJob.isStepPSCodeListIdDirty()) {
            return null;
        }
        String string = pSSysAIPipelineJob.getStepPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StepPSCodeListId_Default(pSSysAIPipelineJob, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STEPPSCODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineJob.isUserCatDirty() : !pSSysAIPipelineJob.isUserCatDirty()) {
            return null;
        }
        String string = pSSysAIPipelineJob.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysAIPipelineJob, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineJob.isUserTagDirty() : !pSSysAIPipelineJob.isUserTagDirty()) {
            return null;
        }
        String string = pSSysAIPipelineJob.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysAIPipelineJob, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineJob.isUserTag2Dirty() : !pSSysAIPipelineJob.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysAIPipelineJob.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysAIPipelineJob, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineJob.isUserTag3Dirty() : !pSSysAIPipelineJob.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysAIPipelineJob.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysAIPipelineJob, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineJob.isUserTag4Dirty() : !pSSysAIPipelineJob.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysAIPipelineJob.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysAIPipelineJob, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineJob.isValidFlagDirty() && !bl2 : !pSSysAIPipelineJob.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysAIPipelineJob.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysAIPipelineJob, bl2, bl3);
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

    protected void onSyncEntity(PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl) throws Exception {
        super.onSyncEntity(pSSysAIPipelineJob, bl);
    }

    protected void onSyncIndexEntities(PSSysAIPipelineJob pSSysAIPipelineJob, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysAIPipelineJob, bl);
    }

    public Object getDataContextValue(PSSysAIPipelineJob pSSysAIPipelineJob, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysAIPipelineJob, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysAIPipelineAgent pSSysAIPipelineAgent = pSSysAIPipelineJob.getPSSysAIPipelineAgent();
        if (pSSysAIPipelineAgent != null && pSSysAIPipelineAgent.contains(string)) {
            return pSSysAIPipelineAgent.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysAIPipelineJob pSSysAIPipelineJob, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysAIPipelineJob, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JOBPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JobParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JOBTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JobTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSAIPIPELINEJOBID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIPipelineJobId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAIPIPELINEJOBNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIPipelineJobName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAIWORKERAGENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIWorkerAgentId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAIWORKERAGENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIWorkerAgentName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STEPPSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StepPSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STEPPSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StepPSCodeListName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_JobParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JOBPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JobTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JOBTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEDataSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysAIPipelineJobId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAIPIPELINEJOBID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAIPipelineJobName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAIPIPELINEJOBNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_StepPSCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STEPPSCODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StepPSCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STEPPSCODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysAIPipelineJob pSSysAIPipelineJob) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysAIPipelineJob)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysAIPipelineJob pSSysAIPipelineJob) throws Exception {
        super.onUpdateParent(pSSysAIPipelineJob);
    }

    @Override
    protected void exportCurXmlModel(PSSysAIPipelineJob pSSysAIPipelineJob, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSAIPIPELINEJOB");
        if (!bl) {
            pSSysAIPipelineJob.setCreateDate(null);
            pSSysAIPipelineJob.setCreateMan(null);
            pSSysAIPipelineJob.setPSSysAIPipelineJobId(null);
            pSSysAIPipelineJob.setUpdateDate(null);
            pSSysAIPipelineJob.setUpdateMan(null);
            pSSysAIPipelineJob.setPSSysAIPipelineAgentId(null);
            pSSysAIPipelineJob.setPSSysAIPipelineAgentName(null);
            super.exportCurXmlModel(pSSysAIPipelineJob, xmlNode, bl);
        }
    }
}

