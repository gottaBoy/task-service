/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.ActionContext
 *  net.ibizsys.paas.core.IActionContext
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDELogicModel
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
package net.ibizsys.pscore.srv.wfdesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.ActionContext;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDELogicModel;
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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.wfdesign.dao.PSWFProcSubWFDAO;
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFProcSubWFDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDEBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcSubWF;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcessBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersionBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflowBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFProcSubWFServiceBase
extends PSCoreSysServiceBase<PSWFProcSubWF> {
    private static final Log log = LogFactory.getLog(PSWFProcSubWFServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CALCEMBEDDEIDBYEMBEDWFDE = "CalcEmbedDEIdByEmbedWFDE";
    private PSWFProcSubWFDEModel pSWFProcSubWFDEModel;
    private PSWFProcSubWFDAO pSWFProcSubWFDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfdesign.service.PSWFProcSubWFService";
    }

    public PSWFProcSubWFDEModel getPSWFProcSubWFDEModel() {
        if (this.pSWFProcSubWFDEModel == null) {
            try {
                this.pSWFProcSubWFDEModel = (PSWFProcSubWFDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFProcSubWFDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFProcSubWFDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWFProcSubWFDEModel();
    }

    public PSWFProcSubWFDAO getPSWFProcSubWFDAO() {
        if (this.pSWFProcSubWFDAO == null) {
            try {
                this.pSWFProcSubWFDAO = (PSWFProcSubWFDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfdesign.dao.PSWFProcSubWFDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFProcSubWFDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWFProcSubWFDAO();
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
        if (StringHelper.compare((String)string, (String)ACTION_CALCEMBEDDEIDBYEMBEDWFDE, (boolean)true) == 0) {
            this.calcEmbedDEIdByEmbedWFDE((PSWFProcSubWF)iEntity);
            return;
        }
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

    public void calcEmbedDEIdByEmbedWFDE(PSWFProcSubWF pSWFProcSubWF) throws Exception {
        final PSWFProcSubWF pSWFProcSubWF2 = pSWFProcSubWF;
        pSWFProcSubWF2.setSessionFactory(this.getSessionFactory());
        this.testDEMainStateAction(pSWFProcSubWF, ACTION_CALCEMBEDDEIDBYEMBEDWFDE);
        final IDELogicModel iDELogicModel = (IDELogicModel)this.getPSWFProcSubWFDEModel().getDELogic(ACTION_CALCEMBEDDEIDBYEMBEDWFDE);
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                ActionContext actionContext = new ActionContext(null);
                actionContext.setParam(iDELogicModel.getDefaultParamName(), (Object)pSWFProcSubWF2);
                actionContext.setSessionFactory(PSWFProcSubWFServiceBase.this.getSessionFactory());
                iDELogicModel.execute((IActionContext)actionContext);
            }
        });
    }

    protected void onFillParentInfo(PSWFProcSubWF pSWFProcSubWF, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCSUBWF_PSDEDATASET_EMBEDPSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_EmbedPSDEDS(pSWFProcSubWF, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCSUBWF_PSWFDE_EMBEDPSWFDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService", (SessionFactory)this.getSessionFactory());
            PSWFDE pSWFDE = (PSWFDE)iService.getDEModel().createEntity();
            pSWFDE.set("PSWFDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWFDE);
            } else {
                iService.get(pSWFDE);
            }
            this.onFillParentInfo_EmbedPSWFDE(pSWFProcSubWF, pSWFDE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCSUBWF_PSWFPROCESS_PSWFPROCESSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService", (SessionFactory)this.getSessionFactory());
            PSWFProcess pSWFProcess = (PSWFProcess)iService.getDEModel().createEntity();
            pSWFProcess.set("PSWFPROCESSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWFProcess);
            } else {
                iService.get(pSWFProcess);
            }
            this.onFillParentInfo_PSWFProcess(pSWFProcSubWF, pSWFProcess);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCSUBWF_PSWFVERSION_EMBEDPSWFVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService", (SessionFactory)this.getSessionFactory());
            PSWFVersion pSWFVersion = (PSWFVersion)iService.getDEModel().createEntity();
            pSWFVersion.set("PSWFVERSIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWFVersion);
            } else {
                iService.get(pSWFVersion);
            }
            this.onFillParentInfo_EmbedPSWFVer(pSWFProcSubWF, pSWFVersion);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFPROCSUBWF_PSWORKFLOW_EMBEDPSWFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService", (SessionFactory)this.getSessionFactory());
            PSWorkflow pSWorkflow = (PSWorkflow)iService.getDEModel().createEntity();
            pSWorkflow.set("PSWORKFLOWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWorkflow);
            } else {
                iService.get(pSWorkflow);
            }
            this.onFillParentInfo_EmbedPSWF(pSWFProcSubWF, pSWorkflow);
            return;
        }
        super.onFillParentInfo(pSWFProcSubWF, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSWFPROCSUBWF_PSWFPROCESS_PSWFPROCESSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService", (SessionFactory)this.getSessionFactory());
            PSWFProcess pSWFProcess = (PSWFProcess)iService.getDEModel().createEntity();
            pSWFProcess.set("PSWFPROCESSID", string2);
            return this.onSyncDER1NData_PSWFProcess(pSWFProcess, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_EmbedPSDEDS(PSWFProcSubWF pSWFProcSubWF, PSDEDataSet pSDEDataSet) throws Exception {
        pSWFProcSubWF.setEmbedPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSWFProcSubWF.setEmbedPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_EmbedPSWFDE(PSWFProcSubWF pSWFProcSubWF, PSWFDE pSWFDE) throws Exception {
        pSWFProcSubWF.setEmbedPSDEId(pSWFDE.getPSDEId());
        pSWFProcSubWF.setEmbedPSWFDEId(pSWFDE.getPSWFDEId());
        pSWFProcSubWF.setEmbedPSWFDEName(pSWFDE.getPSWFDEName());
        if (pSWFDE.getPSWF() != null) {
            this.onFillParentInfo_EmbedPSWF(pSWFProcSubWF, pSWFDE.getPSWF());
        }
    }

    protected void onFillParentInfo_PSWFProcess(PSWFProcSubWF pSWFProcSubWF, PSWFProcess pSWFProcess) throws Exception {
        pSWFProcSubWF.setPSSystemId(pSWFProcess.getPSSystemId());
        pSWFProcSubWF.setPSWFId(pSWFProcess.getPSWFId());
        pSWFProcSubWF.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
        pSWFProcSubWF.setPSWFProcessName(pSWFProcess.getPSWFProcessName());
        pSWFProcSubWF.setPSWFVersionId(pSWFProcess.getPSWFVersionId());
    }

    protected String onSyncDER1NData_PSWFProcess(PSWFProcess pSWFProcess, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSWFProcess(pSWFProcess);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSWFProcSubWF> arrayList = this.selectByPSWFProcess(pSWFProcess);
            for (PSWFProcSubWF pSWFProcSubWF : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSWFProcSubWF, (String)"PSWFPROCSUBWFID", (String)""))) continue;
                this.remove(pSWFProcSubWF);
            }
        }
        return null;
    }

    protected void onFillParentInfo_EmbedPSWFVer(PSWFProcSubWF pSWFProcSubWF, PSWFVersion pSWFVersion) throws Exception {
        pSWFProcSubWF.setEmbedPSWFVerId(pSWFVersion.getPSWFVersionId());
        pSWFProcSubWF.setEmbedPSWFVerName(pSWFVersion.getPSWFVersionName());
    }

    protected void onFillParentInfo_EmbedPSWF(PSWFProcSubWF pSWFProcSubWF, PSWorkflow pSWorkflow) throws Exception {
        pSWFProcSubWF.setEmbedPSWFId(pSWorkflow.getPSWorkflowId());
        pSWFProcSubWF.setEmbedPSWFName(pSWorkflow.getPSWorkflowName());
    }

    protected void onFillEntityFullInfo(PSWFProcSubWF pSWFProcSubWF, boolean bl) throws Exception {
        if (bl && pSWFProcSubWF.getSuspendDefault() == null) {
            pSWFProcSubWF.setSuspendDefault((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo(pSWFProcSubWF, bl);
        this.onFillEntityFullInfo_EmbedPSDEDS(pSWFProcSubWF, bl);
        this.onFillEntityFullInfo_EmbedPSWFDE(pSWFProcSubWF, bl);
        this.onFillEntityFullInfo_PSWFProcess(pSWFProcSubWF, bl);
        this.onFillEntityFullInfo_EmbedPSWFVer(pSWFProcSubWF, bl);
        this.onFillEntityFullInfo_EmbedPSWF(pSWFProcSubWF, bl);
    }

    protected void onFillEntityFullInfo_EmbedPSDEDS(PSWFProcSubWF pSWFProcSubWF, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_EmbedPSWFDE(PSWFProcSubWF pSWFProcSubWF, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWFProcess(PSWFProcSubWF pSWFProcSubWF, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_EmbedPSWFVer(PSWFProcSubWF pSWFProcSubWF, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_EmbedPSWF(PSWFProcSubWF pSWFProcSubWF, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSWFProcSubWF pSWFProcSubWF, boolean bl) throws Exception {
        super.onWriteBackParent(pSWFProcSubWF, bl);
    }

    public ArrayList<PSWFProcSubWF> selectByEmbedPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByEmbedPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSWFProcSubWF> selectByEmbedPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByEmbedPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSWFProcSubWF> selectByEmbedPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("EMBEDPSDEDSID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByEmbedPSDEDSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByEmbedPSDEDSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcSubWF> selectByEmbedPSWFDE(PSWFDEBase pSWFDEBase) throws Exception {
        return this.selectByEmbedPSWFDE(pSWFDEBase, "", -1);
    }

    public ArrayList<PSWFProcSubWF> selectByEmbedPSWFDE(PSWFDEBase pSWFDEBase, String string) throws Exception {
        return this.selectByEmbedPSWFDE(pSWFDEBase, string, -1);
    }

    public ArrayList<PSWFProcSubWF> selectByEmbedPSWFDE(PSWFDEBase pSWFDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("EMBEDPSWFDEID", (Object)pSWFDEBase.getPSWFDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByEmbedPSWFDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByEmbedPSWFDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcSubWF> selectByPSWFProcess(PSWFProcessBase pSWFProcessBase) throws Exception {
        return this.selectByPSWFProcess(pSWFProcessBase, "", -1);
    }

    public ArrayList<PSWFProcSubWF> selectByPSWFProcess(PSWFProcessBase pSWFProcessBase, String string) throws Exception {
        return this.selectByPSWFProcess(pSWFProcessBase, string, -1);
    }

    public ArrayList<PSWFProcSubWF> selectByPSWFProcess(PSWFProcessBase pSWFProcessBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFPROCESSID", (Object)pSWFProcessBase.getPSWFProcessId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFProcessCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFProcessCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcSubWF> selectTempByPSWFProcess(PSWFProcessBase pSWFProcessBase) throws Exception {
        return this.selectTempByPSWFProcess(pSWFProcessBase, "");
    }

    public ArrayList<PSWFProcSubWF> selectTempByPSWFProcess(PSWFProcessBase pSWFProcessBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFPROCESSID", (Object)pSWFProcessBase.getPSWFProcessId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSWFProcessCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSWFProcessCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcSubWF> selectByEmbedPSWFVer(PSWFVersionBase pSWFVersionBase) throws Exception {
        return this.selectByEmbedPSWFVer(pSWFVersionBase, "", -1);
    }

    public ArrayList<PSWFProcSubWF> selectByEmbedPSWFVer(PSWFVersionBase pSWFVersionBase, String string) throws Exception {
        return this.selectByEmbedPSWFVer(pSWFVersionBase, string, -1);
    }

    public ArrayList<PSWFProcSubWF> selectByEmbedPSWFVer(PSWFVersionBase pSWFVersionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("EMBEDPSWFVERID", (Object)pSWFVersionBase.getPSWFVersionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByEmbedPSWFVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByEmbedPSWFVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFProcSubWF> selectByEmbedPSWF(PSWorkflowBase pSWorkflowBase) throws Exception {
        return this.selectByEmbedPSWF(pSWorkflowBase, "", -1);
    }

    public ArrayList<PSWFProcSubWF> selectByEmbedPSWF(PSWorkflowBase pSWorkflowBase, String string) throws Exception {
        return this.selectByEmbedPSWF(pSWorkflowBase, string, -1);
    }

    public ArrayList<PSWFProcSubWF> selectByEmbedPSWF(PSWorkflowBase pSWorkflowBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("EMBEDPSWFID", (Object)pSWorkflowBase.getPSWorkflowId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByEmbedPSWFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByEmbedPSWFCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByEmbedPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSWFProcSubWF> arrayList = this.selectByEmbedPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCSUBWF_PSDEDATASET_EMBEDPSDEDSID", "", iDataEntityModel.getName(), "PSWFPROCSUBWF", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetEmbedPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSWFProcSubWF> arrayList = this.selectByEmbedPSDEDS(pSDEDataSet);
        for (PSWFProcSubWF pSWFProcSubWF : arrayList) {
            PSWFProcSubWF pSWFProcSubWF2 = (PSWFProcSubWF)this.getDEModel().createEntity();
            pSWFProcSubWF2.setPSWFProcSubWFId(pSWFProcSubWF.getPSWFProcSubWFId());
            pSWFProcSubWF2.setEmbedPSDEDSId(null);
            this.update(pSWFProcSubWF2);
        }
    }

    public void removeByEmbedPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcSubWFServiceBase.this.onBeforeRemoveByEmbedPSDEDS(pSDEDataSet2);
                PSWFProcSubWFServiceBase.this.internalRemoveByEmbedPSDEDS(pSDEDataSet2);
                PSWFProcSubWFServiceBase.this.onAfterRemoveByEmbedPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByEmbedPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByEmbedPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSWFProcSubWF> arrayList = this.selectByEmbedPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByEmbedPSDEDS(pSDEDataSet, arrayList);
        for (PSWFProcSubWF pSWFProcSubWF : arrayList) {
            this.remove(pSWFProcSubWF);
        }
        this.onAfterRemoveByEmbedPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByEmbedPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByEmbedPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSWFProcSubWF> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEmbedPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSWFProcSubWF> arrayList) throws Exception {
    }

    public void testRemoveByEmbedPSWFDE(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSWFProcSubWF> arrayList = this.selectByEmbedPSWFDE(pSWFDE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWFDE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWFDE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCSUBWF_PSWFDE_EMBEDPSWFDEID", "", iDataEntityModel.getName(), "PSWFPROCSUBWF", iDataEntityModel.getDataInfo(pSWFDE), arrayList.get(0)));
        }
    }

    public void resetEmbedPSWFDE(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSWFProcSubWF> arrayList = this.selectByEmbedPSWFDE(pSWFDE);
        for (PSWFProcSubWF pSWFProcSubWF : arrayList) {
            PSWFProcSubWF pSWFProcSubWF2 = (PSWFProcSubWF)this.getDEModel().createEntity();
            pSWFProcSubWF2.setPSWFProcSubWFId(pSWFProcSubWF.getPSWFProcSubWFId());
            pSWFProcSubWF2.setEmbedPSWFDEId(null);
            this.update(pSWFProcSubWF2);
        }
    }

    public void removeByEmbedPSWFDE(PSWFDE pSWFDE) throws Exception {
        final PSWFDE pSWFDE2 = pSWFDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcSubWFServiceBase.this.onBeforeRemoveByEmbedPSWFDE(pSWFDE2);
                PSWFProcSubWFServiceBase.this.internalRemoveByEmbedPSWFDE(pSWFDE2);
                PSWFProcSubWFServiceBase.this.onAfterRemoveByEmbedPSWFDE(pSWFDE2);
            }
        });
    }

    protected void onBeforeRemoveByEmbedPSWFDE(PSWFDE pSWFDE) throws Exception {
    }

    protected void internalRemoveByEmbedPSWFDE(PSWFDE pSWFDE) throws Exception {
        ArrayList<PSWFProcSubWF> arrayList = this.selectByEmbedPSWFDE(pSWFDE);
        this.onBeforeRemoveByEmbedPSWFDE(pSWFDE, arrayList);
        for (PSWFProcSubWF pSWFProcSubWF : arrayList) {
            this.remove(pSWFProcSubWF);
        }
        this.onAfterRemoveByEmbedPSWFDE(pSWFDE, arrayList);
    }

    protected void onAfterRemoveByEmbedPSWFDE(PSWFDE pSWFDE) throws Exception {
    }

    protected void onBeforeRemoveByEmbedPSWFDE(PSWFDE pSWFDE, ArrayList<PSWFProcSubWF> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEmbedPSWFDE(PSWFDE pSWFDE, ArrayList<PSWFProcSubWF> arrayList) throws Exception {
    }

    public void testRemoveByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
    }

    public void resetPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
        ArrayList<PSWFProcSubWF> arrayList = this.selectByPSWFProcess(pSWFProcess);
        for (PSWFProcSubWF pSWFProcSubWF : arrayList) {
            PSWFProcSubWF pSWFProcSubWF2 = (PSWFProcSubWF)this.getDEModel().createEntity();
            pSWFProcSubWF2.setPSWFProcSubWFId(pSWFProcSubWF.getPSWFProcSubWFId());
            pSWFProcSubWF2.setPSWFProcessId(null);
            this.update(pSWFProcSubWF2);
        }
    }

    public void resetTempPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
        ArrayList<PSWFProcSubWF> arrayList = this.selectTempByPSWFProcess(pSWFProcess);
        for (PSWFProcSubWF pSWFProcSubWF : arrayList) {
            PSWFProcSubWF pSWFProcSubWF2 = (PSWFProcSubWF)this.getDEModel().createEntity();
            pSWFProcSubWF2.setPSWFProcSubWFId(pSWFProcSubWF.getPSWFProcSubWFId());
            pSWFProcSubWF2.setPSWFProcessId(null);
            this.updateTemp(pSWFProcSubWF2);
        }
    }

    public void removeByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
        final PSWFProcess pSWFProcess2 = pSWFProcess;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcSubWFServiceBase.this.onBeforeRemoveByPSWFProcess(pSWFProcess2);
                PSWFProcSubWFServiceBase.this.internalRemoveByPSWFProcess(pSWFProcess2);
                PSWFProcSubWFServiceBase.this.onAfterRemoveByPSWFProcess(pSWFProcess2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
    }

    protected void internalRemoveByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
        ArrayList<PSWFProcSubWF> arrayList = this.selectByPSWFProcess(pSWFProcess);
        this.onBeforeRemoveByPSWFProcess(pSWFProcess, arrayList);
        for (PSWFProcSubWF pSWFProcSubWF : arrayList) {
            this.remove(pSWFProcSubWF);
        }
        this.onAfterRemoveByPSWFProcess(pSWFProcess, arrayList);
    }

    protected void onAfterRemoveByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
    }

    protected void onBeforeRemoveByPSWFProcess(PSWFProcess pSWFProcess, ArrayList<PSWFProcSubWF> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFProcess(PSWFProcess pSWFProcess, ArrayList<PSWFProcSubWF> arrayList) throws Exception {
    }

    public void testRemoveByEmbedPSWFVer(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFProcSubWF> arrayList = this.selectByEmbedPSWFVer(pSWFVersion, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWFVERSION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWFVersion);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCSUBWF_PSWFVERSION_EMBEDPSWFVERID", "", iDataEntityModel.getName(), "PSWFPROCSUBWF", iDataEntityModel.getDataInfo(pSWFVersion), arrayList.get(0)));
        }
    }

    public void resetEmbedPSWFVer(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFProcSubWF> arrayList = this.selectByEmbedPSWFVer(pSWFVersion);
        for (PSWFProcSubWF pSWFProcSubWF : arrayList) {
            PSWFProcSubWF pSWFProcSubWF2 = (PSWFProcSubWF)this.getDEModel().createEntity();
            pSWFProcSubWF2.setPSWFProcSubWFId(pSWFProcSubWF.getPSWFProcSubWFId());
            pSWFProcSubWF2.setEmbedPSWFVerId(null);
            this.update(pSWFProcSubWF2);
        }
    }

    public void removeByEmbedPSWFVer(PSWFVersion pSWFVersion) throws Exception {
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcSubWFServiceBase.this.onBeforeRemoveByEmbedPSWFVer(pSWFVersion2);
                PSWFProcSubWFServiceBase.this.internalRemoveByEmbedPSWFVer(pSWFVersion2);
                PSWFProcSubWFServiceBase.this.onAfterRemoveByEmbedPSWFVer(pSWFVersion2);
            }
        });
    }

    protected void onBeforeRemoveByEmbedPSWFVer(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void internalRemoveByEmbedPSWFVer(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFProcSubWF> arrayList = this.selectByEmbedPSWFVer(pSWFVersion);
        this.onBeforeRemoveByEmbedPSWFVer(pSWFVersion, arrayList);
        for (PSWFProcSubWF pSWFProcSubWF : arrayList) {
            this.remove(pSWFProcSubWF);
        }
        this.onAfterRemoveByEmbedPSWFVer(pSWFVersion, arrayList);
    }

    protected void onAfterRemoveByEmbedPSWFVer(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void onBeforeRemoveByEmbedPSWFVer(PSWFVersion pSWFVersion, ArrayList<PSWFProcSubWF> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEmbedPSWFVer(PSWFVersion pSWFVersion, ArrayList<PSWFProcSubWF> arrayList) throws Exception {
    }

    public void testRemoveByEmbedPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFProcSubWF> arrayList = this.selectByEmbedPSWF(pSWorkflow, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWORKFLOW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWorkflow);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFPROCSUBWF_PSWORKFLOW_EMBEDPSWFID", "", iDataEntityModel.getName(), "PSWFPROCSUBWF", iDataEntityModel.getDataInfo(pSWorkflow), arrayList.get(0)));
        }
    }

    public void resetEmbedPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFProcSubWF> arrayList = this.selectByEmbedPSWF(pSWorkflow);
        for (PSWFProcSubWF pSWFProcSubWF : arrayList) {
            PSWFProcSubWF pSWFProcSubWF2 = (PSWFProcSubWF)this.getDEModel().createEntity();
            pSWFProcSubWF2.setPSWFProcSubWFId(pSWFProcSubWF.getPSWFProcSubWFId());
            pSWFProcSubWF2.setEmbedPSWFId(null);
            this.update(pSWFProcSubWF2);
        }
    }

    public void removeByEmbedPSWF(PSWorkflow pSWorkflow) throws Exception {
        final PSWorkflow pSWorkflow2 = pSWorkflow;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcSubWFServiceBase.this.onBeforeRemoveByEmbedPSWF(pSWorkflow2);
                PSWFProcSubWFServiceBase.this.internalRemoveByEmbedPSWF(pSWorkflow2);
                PSWFProcSubWFServiceBase.this.onAfterRemoveByEmbedPSWF(pSWorkflow2);
            }
        });
    }

    protected void onBeforeRemoveByEmbedPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void internalRemoveByEmbedPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFProcSubWF> arrayList = this.selectByEmbedPSWF(pSWorkflow);
        this.onBeforeRemoveByEmbedPSWF(pSWorkflow, arrayList);
        for (PSWFProcSubWF pSWFProcSubWF : arrayList) {
            this.remove(pSWFProcSubWF);
        }
        this.onAfterRemoveByEmbedPSWF(pSWorkflow, arrayList);
    }

    protected void onAfterRemoveByEmbedPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void onBeforeRemoveByEmbedPSWF(PSWorkflow pSWorkflow, ArrayList<PSWFProcSubWF> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEmbedPSWF(PSWorkflow pSWorkflow, ArrayList<PSWFProcSubWF> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWFProcSubWF pSWFProcSubWF) throws Exception {
        super.onBeforeRemove(pSWFProcSubWF);
    }

    public void removeTempByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
        final PSWFProcess pSWFProcess2 = pSWFProcess;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFProcSubWFServiceBase.this.onBeforeRemoveTempByPSWFProcess(pSWFProcess2);
                PSWFProcSubWFServiceBase.this.internalRemoveTempByPSWFProcess(pSWFProcess2);
                PSWFProcSubWFServiceBase.this.onAfterRemoveTempByPSWFProcess(pSWFProcess2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
    }

    protected void internalRemoveTempByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
        ArrayList<PSWFProcSubWF> arrayList = this.selectTempByPSWFProcess(pSWFProcess);
        this.onBeforeRemoveTempByPSWFProcess(pSWFProcess, arrayList);
        for (PSWFProcSubWF pSWFProcSubWF : arrayList) {
            this.removeTemp(pSWFProcSubWF);
        }
        this.onAfterRemoveTempByPSWFProcess(pSWFProcess, arrayList);
    }

    protected void onAfterRemoveTempByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
    }

    protected void onBeforeRemoveTempByPSWFProcess(PSWFProcess pSWFProcess, ArrayList<PSWFProcSubWF> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSWFProcess(PSWFProcess pSWFProcess, ArrayList<PSWFProcSubWF> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSWFProcSubWF pSWFProcSubWF, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSWFProcSubWF, cloneSession);
        if (pSWFProcSubWF.getEmbedPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSWFProcSubWF.getEmbedPSDEDSId())) != null) {
            this.onFillParentInfo_EmbedPSDEDS(pSWFProcSubWF, (PSDEDataSet)iEntity);
        }
        if (pSWFProcSubWF.getEmbedPSWFDEId() != null && (iEntity = cloneSession.getEntity("PSWFDE", (Object)pSWFProcSubWF.getEmbedPSWFDEId())) != null) {
            this.onFillParentInfo_EmbedPSWFDE(pSWFProcSubWF, (PSWFDE)iEntity);
        }
        if (pSWFProcSubWF.getPSWFProcessId() != null && (iEntity = cloneSession.getEntity("PSWFPROCESS", (Object)pSWFProcSubWF.getPSWFProcessId())) != null) {
            this.onFillParentInfo_PSWFProcess(pSWFProcSubWF, (PSWFProcess)iEntity);
        }
        if (pSWFProcSubWF.getEmbedPSWFVerId() != null && (iEntity = cloneSession.getEntity("PSWFVERSION", (Object)pSWFProcSubWF.getEmbedPSWFVerId())) != null) {
            this.onFillParentInfo_EmbedPSWFVer(pSWFProcSubWF, (PSWFVersion)iEntity);
        }
        if (pSWFProcSubWF.getEmbedPSWFId() != null && (iEntity = cloneSession.getEntity("PSWORKFLOW", (Object)pSWFProcSubWF.getEmbedPSWFId())) != null) {
            this.onFillParentInfo_EmbedPSWF(pSWFProcSubWF, (PSWorkflow)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWFProcSubWF pSWFProcSubWF, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWFProcSubWF, bl);
    }

    protected void onCheckEntity(boolean bl, PSWFProcSubWF pSWFProcSubWF, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSWFProcSubWF, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSWFProcSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmbedPSDEDSId(bl, pSWFProcSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmbedPSWFDEId(bl, pSWFProcSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmbedPSWFId(bl, pSWFProcSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmbedPSWFVerId(bl, pSWFProcSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSWFProcSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSWFProcSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFProcessId(bl, pSWFProcSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFProcSubWFId(bl, pSWFProcSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFProcSubWFName(bl, pSWFProcSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SuspendDefault(bl, pSWFProcSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSWFProcSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData(bl, pSWFProcSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData2(bl, pSWFProcSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSWFProcSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSWFProcSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSWFProcSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSWFProcSubWF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWFProcSubWF, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSWFProcSubWF pSWFProcSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcSubWF.isCodeNameDirty() && !bl2 : !pSWFProcSubWF.isCodeNameDirty()) {
            return null;
        }
        String string = pSWFProcSubWF.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSWFProcSubWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSWFProcSubWF pSWFProcSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcSubWF.isDynaModelFlagDirty() : !pSWFProcSubWF.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSWFProcSubWF.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSWFProcSubWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmbedPSDEDSId(boolean bl, PSWFProcSubWF pSWFProcSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcSubWF.isEmbedPSDEDSIdDirty() && !bl2 : !pSWFProcSubWF.isEmbedPSDEDSIdDirty()) {
            return null;
        }
        String string = pSWFProcSubWF.getEmbedPSDEDSId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMBEDPSDEDSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmbedPSDEDSId_Default(pSWFProcSubWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMBEDPSDEDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmbedPSWFDEId(boolean bl, PSWFProcSubWF pSWFProcSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcSubWF.isEmbedPSWFDEIdDirty() && !bl2 : !pSWFProcSubWF.isEmbedPSWFDEIdDirty()) {
            return null;
        }
        String string = pSWFProcSubWF.getEmbedPSWFDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMBEDPSWFDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmbedPSWFDEId_Default(pSWFProcSubWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMBEDPSWFDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmbedPSWFId(boolean bl, PSWFProcSubWF pSWFProcSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcSubWF.isEmbedPSWFIdDirty() && !bl2 : !pSWFProcSubWF.isEmbedPSWFIdDirty()) {
            return null;
        }
        String string = pSWFProcSubWF.getEmbedPSWFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMBEDPSWFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmbedPSWFId_Default(pSWFProcSubWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMBEDPSWFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmbedPSWFVerId(boolean bl, PSWFProcSubWF pSWFProcSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcSubWF.isEmbedPSWFVerIdDirty() : !pSWFProcSubWF.isEmbedPSWFVerIdDirty()) {
            return null;
        }
        String string = pSWFProcSubWF.getEmbedPSWFVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmbedPSWFVerId_Default(pSWFProcSubWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMBEDPSWFVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSWFProcSubWF pSWFProcSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcSubWF.isMemoDirty() : !pSWFProcSubWF.isMemoDirty()) {
            return null;
        }
        String string = pSWFProcSubWF.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSWFProcSubWF, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSWFProcSubWF pSWFProcSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcSubWF.isPSDynaInstIdDirty() : !pSWFProcSubWF.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSWFProcSubWF.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSWFProcSubWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFProcessId(boolean bl, PSWFProcSubWF pSWFProcSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcSubWF.isPSWFProcessIdDirty() && !bl2 : !pSWFProcSubWF.isPSWFProcessIdDirty()) {
            return null;
        }
        String string = pSWFProcSubWF.getPSWFProcessId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFPROCESSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFProcessId_Default(pSWFProcSubWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFPROCESSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFProcSubWFId(boolean bl, PSWFProcSubWF pSWFProcSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcSubWF.isPSWFProcSubWFIdDirty() && !bl2 : !pSWFProcSubWF.isPSWFProcSubWFIdDirty()) {
            return null;
        }
        String string = pSWFProcSubWF.getPSWFProcSubWFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFPROCSUBWFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFProcSubWFId_Default(pSWFProcSubWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFPROCSUBWFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFProcSubWFName(boolean bl, PSWFProcSubWF pSWFProcSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcSubWF.isPSWFProcSubWFNameDirty() : !pSWFProcSubWF.isPSWFProcSubWFNameDirty()) {
            return null;
        }
        String string = pSWFProcSubWF.getPSWFProcSubWFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFProcSubWFName_Default(pSWFProcSubWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFPROCSUBWFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SuspendDefault(boolean bl, PSWFProcSubWF pSWFProcSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcSubWF.isSuspendDefaultDirty() : !pSWFProcSubWF.isSuspendDefaultDirty()) {
            return null;
        }
        Integer n = pSWFProcSubWF.getSuspendDefault();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SuspendDefault_Default(pSWFProcSubWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUSPENDDEFAULT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSWFProcSubWF pSWFProcSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcSubWF.isUserCatDirty() : !pSWFProcSubWF.isUserCatDirty()) {
            return null;
        }
        String string = pSWFProcSubWF.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSWFProcSubWF, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserData(boolean bl, PSWFProcSubWF pSWFProcSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcSubWF.isUserDataDirty() : !pSWFProcSubWF.isUserDataDirty()) {
            return null;
        }
        String string = pSWFProcSubWF.getUserData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserData_Default(pSWFProcSubWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserData2(boolean bl, PSWFProcSubWF pSWFProcSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcSubWF.isUserData2Dirty() : !pSWFProcSubWF.isUserData2Dirty()) {
            return null;
        }
        String string = pSWFProcSubWF.getUserData2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserData2_Default(pSWFProcSubWF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATA2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSWFProcSubWF pSWFProcSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcSubWF.isUserTagDirty() : !pSWFProcSubWF.isUserTagDirty()) {
            return null;
        }
        String string = pSWFProcSubWF.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSWFProcSubWF, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSWFProcSubWF pSWFProcSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcSubWF.isUserTag2Dirty() : !pSWFProcSubWF.isUserTag2Dirty()) {
            return null;
        }
        String string = pSWFProcSubWF.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSWFProcSubWF, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSWFProcSubWF pSWFProcSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcSubWF.isUserTag3Dirty() : !pSWFProcSubWF.isUserTag3Dirty()) {
            return null;
        }
        String string = pSWFProcSubWF.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSWFProcSubWF, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSWFProcSubWF pSWFProcSubWF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFProcSubWF.isUserTag4Dirty() : !pSWFProcSubWF.isUserTag4Dirty()) {
            return null;
        }
        String string = pSWFProcSubWF.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSWFProcSubWF, bl2, bl3);
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

    protected void onSyncEntity(PSWFProcSubWF pSWFProcSubWF, boolean bl) throws Exception {
        super.onSyncEntity(pSWFProcSubWF, bl);
    }

    protected void onSyncIndexEntities(PSWFProcSubWF pSWFProcSubWF, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWFProcSubWF, bl);
    }

    public Object getDataContextValue(PSWFProcSubWF pSWFProcSubWF, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATASET", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"EMBEDPSDEDSID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"EMBEDPSDEDSNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSWFProcSubWF, "embedpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSWFDE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSWFID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"EMBEDPSDEID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"EMBEDPSWFDEID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"EMBEDPSWFDENAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSWFProcSubWF, "embedpswfid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSWFVERSION", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSWFID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"EMBEDPSWFVERID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"EMBEDPSWFVERNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSWFProcSubWF, "embedpswfid", iDataContextParam)) != null) {
                return object;
            }
        }
        if ((object = super.getDataContextValue(pSWFProcSubWF, string, iDataContextParam)) != null) {
            return object;
        }
        PSWFProcess pSWFProcess = pSWFProcSubWF.getPSWFProcess();
        if (pSWFProcess != null && pSWFProcess.contains(string)) {
            return pSWFProcess.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSWFProcSubWF pSWFProcSubWF, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSWFProcSubWF, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMBEDPSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmbedPSDEDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMBEDPSDEDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmbedPSDEDSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMBEDPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmbedPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMBEDPSWFDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmbedPSWFDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMBEDPSWFDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmbedPSWFDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMBEDPSWFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmbedPSWFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMBEDPSWFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmbedPSWFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMBEDPSWFVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmbedPSWFVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMBEDPSWFVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmbedPSWFVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFPROCESSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFProcessId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFPROCESSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFProcessName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFPROCSUBWFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFProcSubWFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFPROCSUBWFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFProcSubWFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUSPENDDEFAULT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SuspendDefault_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERDATA2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserData2_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EmbedPSDEDSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMBEDPSDEDSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmbedPSDEDSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMBEDPSDEDSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmbedPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMBEDPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmbedPSWFDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMBEDPSWFDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmbedPSWFDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMBEDPSWFDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmbedPSWFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMBEDPSWFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmbedPSWFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMBEDPSWFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmbedPSWFVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMBEDPSWFVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmbedPSWFVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMBEDPSWFVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_PSWFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFProcessId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFPROCESSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFProcessName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFPROCESSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFProcSubWFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFPROCSUBWFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFProcSubWFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFPROCSUBWFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFVersionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFVERSIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SuspendDefault_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_UserData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserData2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected boolean onMergeChild(String string, String string2, PSWFProcSubWF pSWFProcSubWF) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSWFProcSubWF)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWFProcSubWF pSWFProcSubWF) throws Exception {
        super.onUpdateParent(pSWFProcSubWF);
    }

    @Override
    protected void exportCurXmlModel(PSWFProcSubWF pSWFProcSubWF, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWFPROCSUBWF");
        if (!bl) {
            pSWFProcSubWF.setPSSystemId(null);
            pSWFProcSubWF.setPSWFId(null);
            pSWFProcSubWF.setPSWFProcessId(null);
            pSWFProcSubWF.setPSWFProcessName(null);
            pSWFProcSubWF.setPSWFVersionId(null);
            super.exportCurXmlModel(pSWFProcSubWF, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSWFProcSubWF pSWFProcSubWF, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSWFProcSubWF, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFPROCESSID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWFPROCESS#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFPROCESSID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWFPROCSUBWF_PSWFPROCESS_PSWFPROCESSID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFPROCESSID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFPROCESSNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSWFPROCESS", (boolean)true) == 0) {
            iEntity.set("PSWFPROCESSID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSWFPROCESSID"};
    }

    @Override
    public String getModelV2Tag(PSWFProcSubWF pSWFProcSubWF) {
        return super.getModelV2Tag(pSWFProcSubWF);
    }

    @Override
    public boolean setModelV2Tag(PSWFProcSubWF pSWFProcSubWF, String string) {
        return super.setModelV2Tag(pSWFProcSubWF, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSWFPROCESSID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSWFProcSubWF pSWFProcSubWF, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSWFProcSubWF.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSWFProcSubWF, true);
        return super.getModelV2Entity(pSWFProcSubWF, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSWFProcSubWF pSWFProcSubWF, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSWFProcSubWF, objectNode, string, string2, n);
    }
}

