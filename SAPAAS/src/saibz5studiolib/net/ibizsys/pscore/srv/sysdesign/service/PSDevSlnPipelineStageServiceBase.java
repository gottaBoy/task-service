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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippet;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippetBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItem;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItemBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnPipelineStageDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnPipelineStageDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipeline;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStep;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnPipelineStageServiceBase
extends PSCoreSysServiceBase<PSDevSlnPipelineStage> {
    private static final Log log = LogFactory.getLog(PSDevSlnPipelineStageServiceBase.class);
    public static final String DATASET_CURPIPELINE = "CurPipeline";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDevSlnPipelineStageDEModel pSDevSlnPipelineStageDEModel;
    private PSDevSlnPipelineStageDAO pSDevSlnPipelineStageDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStageService";
    }

    public PSDevSlnPipelineStageDEModel getPSDevSlnPipelineStageDEModel() {
        if (this.pSDevSlnPipelineStageDEModel == null) {
            try {
                this.pSDevSlnPipelineStageDEModel = (PSDevSlnPipelineStageDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnPipelineStageDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnPipelineStageDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnPipelineStageDEModel();
    }

    public PSDevSlnPipelineStageDAO getPSDevSlnPipelineStageDAO() {
        if (this.pSDevSlnPipelineStageDAO == null) {
            try {
                this.pSDevSlnPipelineStageDAO = (PSDevSlnPipelineStageDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnPipelineStageDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnPipelineStageDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnPipelineStageDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURPIPELINE, (boolean)true) == 0) {
            return this.fetchCurPipeline(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURPIPELINE, (boolean)true) == 0) {
            return this.fetchTempCurPipeline(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurPipeline(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPIPELINE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurPipeline(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPIPELINE, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDevSlnPipelineStage pSDevSlnPipelineStage, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTAGE_PSDCCODESNIPPET_PSDCCODESNIPPETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetService", (SessionFactory)this.getSessionFactory());
            PSDCCodeSnippet pSDCCodeSnippet = (PSDCCodeSnippet)iService.getDEModel().createEntity();
            pSDCCodeSnippet.set("PSDCCODESNIPPETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCCodeSnippet);
            } else {
                iService.get(pSDCCodeSnippet);
            }
            this.onFillParentInfo_PSDCCodeSnippet(pSDevSlnPipelineStage, pSDCCodeSnippet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTAGE_PSDCREGISTRYITEM_AGENTPSDCREGISTRYITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService", (SessionFactory)this.getSessionFactory());
            PSDCRegistryItem pSDCRegistryItem = (PSDCRegistryItem)iService.getDEModel().createEntity();
            pSDCRegistryItem.set("PSDCREGISTRYITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCRegistryItem);
            } else {
                iService.get(pSDCRegistryItem);
            }
            this.onFillParentInfo_AgentPSDCRegistryItem(pSDevSlnPipelineStage, pSDCRegistryItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNPIPELINESTAGE_PSDEVSLNPIPELINE_PSDEVSLNPIPELINEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService", (SessionFactory)this.getSessionFactory());
            PSDevSlnPipeline pSDevSlnPipeline = (PSDevSlnPipeline)iService.getDEModel().createEntity();
            pSDevSlnPipeline.set("PSDEVSLNPIPELINEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnPipeline);
            } else {
                iService.get(pSDevSlnPipeline);
            }
            this.onFillParentInfo_PSDevSlnPipeline(pSDevSlnPipelineStage, pSDevSlnPipeline);
            return;
        }
        super.onFillParentInfo(pSDevSlnPipelineStage, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCCodeSnippet(PSDevSlnPipelineStage pSDevSlnPipelineStage, PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        pSDevSlnPipelineStage.setPSDCCodeSnippetId(pSDCCodeSnippet.getPSDCCodeSnippetId());
        pSDevSlnPipelineStage.setPSDCCodeSnippetName(pSDCCodeSnippet.getPSDCCodeSnippetName());
    }

    protected void onFillParentInfo_AgentPSDCRegistryItem(PSDevSlnPipelineStage pSDevSlnPipelineStage, PSDCRegistryItem pSDCRegistryItem) throws Exception {
        pSDevSlnPipelineStage.setAgentPSDCRegistryItemId(pSDCRegistryItem.getPSDCRegistryItemId());
        pSDevSlnPipelineStage.setAgentPSDCRegistryItemName(pSDCRegistryItem.getPSDCRegistryItemName());
    }

    protected void onFillParentInfo_PSDevSlnPipeline(PSDevSlnPipelineStage pSDevSlnPipelineStage, PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        pSDevSlnPipelineStage.setPSDevSlnId(pSDevSlnPipeline.getPSDevSlnId());
        pSDevSlnPipelineStage.setPSDevSlnPipelineId(pSDevSlnPipeline.getPSDevSlnPipelineId());
        pSDevSlnPipelineStage.setPSDevSlnPipelineName(pSDevSlnPipeline.getPSDevSlnPipelineName());
    }

    protected void onFillEntityFullInfo(PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl) throws Exception {
        if (bl) {
            if (pSDevSlnPipelineStage.getCodeName() == null) {
                pSDevSlnPipelineStage.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "Stage", 25));
            }
            if (pSDevSlnPipelineStage.getPSDevSlnPipelineStageName() == null) {
                pSDevSlnPipelineStage.setPSDevSlnPipelineStageName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u9636\u6bb5", 25));
            }
            if (pSDevSlnPipelineStage.getStageType() == null) {
                pSDevSlnPipelineStage.setStageType((String)this.getDefaultValue(this.getWebContext(), "", "NORMAL", 25));
            }
            if (pSDevSlnPipelineStage.getValidFlag() == null) {
                pSDevSlnPipelineStage.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDevSlnPipelineStage, bl);
        this.onFillEntityFullInfo_PSDCCodeSnippet(pSDevSlnPipelineStage, bl);
        this.onFillEntityFullInfo_AgentPSDCRegistryItem(pSDevSlnPipelineStage, bl);
        this.onFillEntityFullInfo_PSDevSlnPipeline(pSDevSlnPipelineStage, bl);
    }

    protected void onFillEntityFullInfo_PSDCCodeSnippet(PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_AgentPSDCRegistryItem(PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnPipeline(PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevSlnPipelineStage, bl);
    }

    public ArrayList<PSDevSlnPipelineStage> selectByPSDCCodeSnippet(PSDCCodeSnippetBase pSDCCodeSnippetBase) throws Exception {
        return this.selectByPSDCCodeSnippet(pSDCCodeSnippetBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStage> selectByPSDCCodeSnippet(PSDCCodeSnippetBase pSDCCodeSnippetBase, String string) throws Exception {
        return this.selectByPSDCCodeSnippet(pSDCCodeSnippetBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStage> selectByPSDCCodeSnippet(PSDCCodeSnippetBase pSDCCodeSnippetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCCODESNIPPETID", (Object)pSDCCodeSnippetBase.getPSDCCodeSnippetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCCodeSnippetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCCodeSnippetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStage> selectByAgentPSDCRegistryItem(PSDCRegistryItemBase pSDCRegistryItemBase) throws Exception {
        return this.selectByAgentPSDCRegistryItem(pSDCRegistryItemBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStage> selectByAgentPSDCRegistryItem(PSDCRegistryItemBase pSDCRegistryItemBase, String string) throws Exception {
        return this.selectByAgentPSDCRegistryItem(pSDCRegistryItemBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStage> selectByAgentPSDCRegistryItem(PSDCRegistryItemBase pSDCRegistryItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AGENTPSDCREGISTRYITEMID", (Object)pSDCRegistryItemBase.getPSDCRegistryItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAgentPSDCRegistryItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAgentPSDCRegistryItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStage> selectByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase) throws Exception {
        return this.selectByPSDevSlnPipeline(pSDevSlnPipelineBase, "", -1);
    }

    public ArrayList<PSDevSlnPipelineStage> selectByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase, String string) throws Exception {
        return this.selectByPSDevSlnPipeline(pSDevSlnPipelineBase, string, -1);
    }

    public ArrayList<PSDevSlnPipelineStage> selectByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNPIPELINEID", (Object)pSDevSlnPipelineBase.getPSDevSlnPipelineId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnPipelineCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnPipelineCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnPipelineStage> selectTempByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase) throws Exception {
        return this.selectTempByPSDevSlnPipeline(pSDevSlnPipelineBase, "");
    }

    public ArrayList<PSDevSlnPipelineStage> selectTempByPSDevSlnPipeline(PSDevSlnPipelineBase pSDevSlnPipelineBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNPIPELINEID", (Object)pSDevSlnPipelineBase.getPSDevSlnPipelineId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDevSlnPipelineCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDevSlnPipelineCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        ArrayList<PSDevSlnPipelineStage> arrayList = this.selectByPSDCCodeSnippet(pSDCCodeSnippet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCCODESNIPPET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCCodeSnippet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTAGE_PSDCCODESNIPPET_PSDCCODESNIPPETID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTAGE", iDataEntityModel.getDataInfo(pSDCCodeSnippet), arrayList.get(0)));
        }
    }

    public void resetPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        ArrayList<PSDevSlnPipelineStage> arrayList = this.selectByPSDCCodeSnippet(pSDCCodeSnippet);
        for (PSDevSlnPipelineStage pSDevSlnPipelineStage : arrayList) {
            PSDevSlnPipelineStage pSDevSlnPipelineStage2 = (PSDevSlnPipelineStage)this.getDEModel().createEntity();
            pSDevSlnPipelineStage2.setPSDevSlnPipelineStageId(pSDevSlnPipelineStage.getPSDevSlnPipelineStageId());
            pSDevSlnPipelineStage2.setPSDCCodeSnippetId(null);
            this.update(pSDevSlnPipelineStage2);
        }
    }

    public void removeByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        final PSDCCodeSnippet pSDCCodeSnippet2 = pSDCCodeSnippet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStageServiceBase.this.onBeforeRemoveByPSDCCodeSnippet(pSDCCodeSnippet2);
                PSDevSlnPipelineStageServiceBase.this.internalRemoveByPSDCCodeSnippet(pSDCCodeSnippet2);
                PSDevSlnPipelineStageServiceBase.this.onAfterRemoveByPSDCCodeSnippet(pSDCCodeSnippet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
    }

    protected void internalRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        ArrayList<PSDevSlnPipelineStage> arrayList = this.selectByPSDCCodeSnippet(pSDCCodeSnippet);
        this.onBeforeRemoveByPSDCCodeSnippet(pSDCCodeSnippet, arrayList);
        for (PSDevSlnPipelineStage pSDevSlnPipelineStage : arrayList) {
            this.remove(pSDevSlnPipelineStage);
        }
        this.onAfterRemoveByPSDCCodeSnippet(pSDCCodeSnippet, arrayList);
    }

    protected void onAfterRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
    }

    protected void onBeforeRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet, ArrayList<PSDevSlnPipelineStage> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet, ArrayList<PSDevSlnPipelineStage> arrayList) throws Exception {
    }

    public void testRemoveByAgentPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        ArrayList<PSDevSlnPipelineStage> arrayList = this.selectByAgentPSDCRegistryItem(pSDCRegistryItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCREGISTRYITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCRegistryItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNPIPELINESTAGE_PSDCREGISTRYITEM_AGENTPSDCREGISTRYITEMID", "", iDataEntityModel.getName(), "PSDEVSLNPIPELINESTAGE", iDataEntityModel.getDataInfo(pSDCRegistryItem), arrayList.get(0)));
        }
    }

    public void resetAgentPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        ArrayList<PSDevSlnPipelineStage> arrayList = this.selectByAgentPSDCRegistryItem(pSDCRegistryItem);
        for (PSDevSlnPipelineStage pSDevSlnPipelineStage : arrayList) {
            PSDevSlnPipelineStage pSDevSlnPipelineStage2 = (PSDevSlnPipelineStage)this.getDEModel().createEntity();
            pSDevSlnPipelineStage2.setPSDevSlnPipelineStageId(pSDevSlnPipelineStage.getPSDevSlnPipelineStageId());
            pSDevSlnPipelineStage2.setAgentPSDCRegistryItemId(null);
            this.update(pSDevSlnPipelineStage2);
        }
    }

    public void removeByAgentPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        final PSDCRegistryItem pSDCRegistryItem2 = pSDCRegistryItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStageServiceBase.this.onBeforeRemoveByAgentPSDCRegistryItem(pSDCRegistryItem2);
                PSDevSlnPipelineStageServiceBase.this.internalRemoveByAgentPSDCRegistryItem(pSDCRegistryItem2);
                PSDevSlnPipelineStageServiceBase.this.onAfterRemoveByAgentPSDCRegistryItem(pSDCRegistryItem2);
            }
        });
    }

    protected void onBeforeRemoveByAgentPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
    }

    protected void internalRemoveByAgentPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
        ArrayList<PSDevSlnPipelineStage> arrayList = this.selectByAgentPSDCRegistryItem(pSDCRegistryItem);
        this.onBeforeRemoveByAgentPSDCRegistryItem(pSDCRegistryItem, arrayList);
        for (PSDevSlnPipelineStage pSDevSlnPipelineStage : arrayList) {
            this.remove(pSDevSlnPipelineStage);
        }
        this.onAfterRemoveByAgentPSDCRegistryItem(pSDCRegistryItem, arrayList);
    }

    protected void onAfterRemoveByAgentPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem) throws Exception {
    }

    protected void onBeforeRemoveByAgentPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem, ArrayList<PSDevSlnPipelineStage> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAgentPSDCRegistryItem(PSDCRegistryItem pSDCRegistryItem, ArrayList<PSDevSlnPipelineStage> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    public void resetPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnPipelineStage> arrayList = this.selectByPSDevSlnPipeline(pSDevSlnPipeline);
        for (PSDevSlnPipelineStage pSDevSlnPipelineStage : arrayList) {
            PSDevSlnPipelineStage pSDevSlnPipelineStage2 = (PSDevSlnPipelineStage)this.getDEModel().createEntity();
            pSDevSlnPipelineStage2.setPSDevSlnPipelineStageId(pSDevSlnPipelineStage.getPSDevSlnPipelineStageId());
            pSDevSlnPipelineStage2.setPSDevSlnPipelineId(null);
            this.update(pSDevSlnPipelineStage2);
        }
    }

    public void resetTempPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnPipelineStage> arrayList = this.selectTempByPSDevSlnPipeline(pSDevSlnPipeline);
        for (PSDevSlnPipelineStage pSDevSlnPipelineStage : arrayList) {
            PSDevSlnPipelineStage pSDevSlnPipelineStage2 = (PSDevSlnPipelineStage)this.getDEModel().createEntity();
            pSDevSlnPipelineStage2.setPSDevSlnPipelineStageId(pSDevSlnPipelineStage.getPSDevSlnPipelineStageId());
            pSDevSlnPipelineStage2.setPSDevSlnPipelineId(null);
            this.updateTemp(pSDevSlnPipelineStage2);
        }
    }

    public void removeByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        final PSDevSlnPipeline pSDevSlnPipeline2 = pSDevSlnPipeline;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStageServiceBase.this.onBeforeRemoveByPSDevSlnPipeline(pSDevSlnPipeline2);
                PSDevSlnPipelineStageServiceBase.this.internalRemoveByPSDevSlnPipeline(pSDevSlnPipeline2);
                PSDevSlnPipelineStageServiceBase.this.onAfterRemoveByPSDevSlnPipeline(pSDevSlnPipeline2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    protected void internalRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnPipelineStage> arrayList = this.selectByPSDevSlnPipeline(pSDevSlnPipeline);
        this.onBeforeRemoveByPSDevSlnPipeline(pSDevSlnPipeline, arrayList);
        for (PSDevSlnPipelineStage pSDevSlnPipelineStage : arrayList) {
            this.remove(pSDevSlnPipelineStage);
        }
        this.onAfterRemoveByPSDevSlnPipeline(pSDevSlnPipeline, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<PSDevSlnPipelineStage> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<PSDevSlnPipelineStage> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
        PSDevSlnPipelineStepService pSDevSlnPipelineStepService = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        pSDevSlnPipelineStepService.testRemoveByPSDevSlnPipelineStage(pSDevSlnPipelineStage);
        pSDevSlnPipelineStepService.removeByPSDevSlnPipelineStage(pSDevSlnPipelineStage);
        super.onBeforeRemove(pSDevSlnPipelineStage);
    }

    protected void onBeforeRemoveTemp(PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
        PSDevSlnPipelineStepService pSDevSlnPipelineStepService = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        pSDevSlnPipelineStepService.resetTempPSDevSlnPipelineStage(pSDevSlnPipelineStage);
        super.onBeforeRemoveTemp(pSDevSlnPipelineStage);
    }

    public void removeTempByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        final PSDevSlnPipeline pSDevSlnPipeline2 = pSDevSlnPipeline;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnPipelineStageServiceBase.this.onBeforeRemoveTempByPSDevSlnPipeline(pSDevSlnPipeline2);
                PSDevSlnPipelineStageServiceBase.this.internalRemoveTempByPSDevSlnPipeline(pSDevSlnPipeline2);
                PSDevSlnPipelineStageServiceBase.this.onAfterRemoveTempByPSDevSlnPipeline(pSDevSlnPipeline2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    protected void internalRemoveTempByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
        ArrayList<PSDevSlnPipelineStage> arrayList = this.selectTempByPSDevSlnPipeline(pSDevSlnPipeline);
        this.onBeforeRemoveTempByPSDevSlnPipeline(pSDevSlnPipeline, arrayList);
        for (PSDevSlnPipelineStage pSDevSlnPipelineStage : arrayList) {
            this.removeTemp(pSDevSlnPipelineStage);
        }
        this.onAfterRemoveTempByPSDevSlnPipeline(pSDevSlnPipeline, arrayList);
    }

    protected void onAfterRemoveTempByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<PSDevSlnPipelineStage> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDevSlnPipeline(PSDevSlnPipeline pSDevSlnPipeline, ArrayList<PSDevSlnPipelineStage> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
        super.getRelatedDataTempMajor(pSDevSlnPipelineStage);
    }

    protected void updateRelatedDataTempMajor(PSDevSlnPipelineStage pSDevSlnPipelineStage, PSDevSlnPipelineStage pSDevSlnPipelineStage2) throws Exception {
        super.updateRelatedDataTempMajor(pSDevSlnPipelineStage, pSDevSlnPipelineStage2);
    }

    protected void replaceParentInfo(PSDevSlnPipelineStage pSDevSlnPipelineStage, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevSlnPipelineStage, cloneSession);
        if (pSDevSlnPipelineStage.getPSDCCodeSnippetId() != null && (iEntity = cloneSession.getEntity("PSDCCODESNIPPET", (Object)pSDevSlnPipelineStage.getPSDCCodeSnippetId())) != null) {
            this.onFillParentInfo_PSDCCodeSnippet(pSDevSlnPipelineStage, (PSDCCodeSnippet)iEntity);
        }
        if (pSDevSlnPipelineStage.getAgentPSDCRegistryItemId() != null && (iEntity = cloneSession.getEntity("PSDCREGISTRYITEM", (Object)pSDevSlnPipelineStage.getAgentPSDCRegistryItemId())) != null) {
            this.onFillParentInfo_AgentPSDCRegistryItem(pSDevSlnPipelineStage, (PSDCRegistryItem)iEntity);
        }
        if (pSDevSlnPipelineStage.getPSDevSlnPipelineId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNPIPELINE", (Object)pSDevSlnPipelineStage.getPSDevSlnPipelineId())) != null) {
            this.onFillParentInfo_PSDevSlnPipeline(pSDevSlnPipelineStage, (PSDevSlnPipeline)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevSlnPipelineStage, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AgentDockerFile(bl, pSDevSlnPipelineStage, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AgentImage(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AgentImageArgs(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AgentPSDCRegistryItemId(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AgentReuseMode(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AgentTags(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AgentType(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CondModel(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CondModelFlag(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PostMode(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCCodeSnippetId(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineId(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineStageId(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnPipelineStageName(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StageParams(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StageType(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplateMode(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDevSlnPipelineStage, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevSlnPipelineStage, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AgentDockerFile(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isAgentDockerFileDirty() : !pSDevSlnPipelineStage.isAgentDockerFileDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStage.getAgentDockerFile();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AgentDockerFile_Default(pSDevSlnPipelineStage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGENTDOCKERFILE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AgentImage(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isAgentImageDirty() : !pSDevSlnPipelineStage.isAgentImageDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStage.getAgentImage();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AgentImage_Default(pSDevSlnPipelineStage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGENTIMAGE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AgentImageArgs(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isAgentImageArgsDirty() : !pSDevSlnPipelineStage.isAgentImageArgsDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStage.getAgentImageArgs();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AgentImageArgs_Default(pSDevSlnPipelineStage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGENTIMAGEARGS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AgentPSDCRegistryItemId(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isAgentPSDCRegistryItemIdDirty() : !pSDevSlnPipelineStage.isAgentPSDCRegistryItemIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStage.getAgentPSDCRegistryItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AgentPSDCRegistryItemId_Default(pSDevSlnPipelineStage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGENTPSDCREGISTRYITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AgentReuseMode(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isAgentReuseModeDirty() : !pSDevSlnPipelineStage.isAgentReuseModeDirty()) {
            return null;
        }
        Integer n = pSDevSlnPipelineStage.getAgentReuseMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AgentReuseMode_Default(pSDevSlnPipelineStage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGENTREUSEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AgentTags(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isAgentTagsDirty() : !pSDevSlnPipelineStage.isAgentTagsDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStage.getAgentTags();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AgentTags_Default(pSDevSlnPipelineStage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGENTTAGS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AgentType(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isAgentTypeDirty() : !pSDevSlnPipelineStage.isAgentTypeDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStage.getAgentType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AgentType_Default(pSDevSlnPipelineStage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGENTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isCodeNameDirty() && !bl2 : !pSDevSlnPipelineStage.isCodeNameDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStage.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDevSlnPipelineStage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
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
                string3 = "PSDEVSLNPIPELINEID";
                String string4 = this.checkFieldDupRule(this.getPSDevSlnPipelineStageDEModel(), "CODENAME", string3, pSDevSlnPipelineStage, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CondModel(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isCondModelDirty() : !pSDevSlnPipelineStage.isCondModelDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStage.getCondModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondModel_Default(pSDevSlnPipelineStage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CondModelFlag(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isCondModelFlagDirty() : !pSDevSlnPipelineStage.isCondModelFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnPipelineStage.getCondModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CondModelFlag_Default(pSDevSlnPipelineStage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDMODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isCustomCodeDirty() : !pSDevSlnPipelineStage.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStage.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSDevSlnPipelineStage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isMemoDirty() : !pSDevSlnPipelineStage.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStage.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevSlnPipelineStage, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isOrderValueDirty() && !bl2 : !pSDevSlnPipelineStage.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDevSlnPipelineStage.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDevSlnPipelineStage, bl2, bl3);
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

    protected EntityFieldError onCheckField_PostMode(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isPostModeDirty() : !pSDevSlnPipelineStage.isPostModeDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStage.getPostMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PostMode_Default(pSDevSlnPipelineStage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("POSTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCCodeSnippetId(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isPSDCCodeSnippetIdDirty() : !pSDevSlnPipelineStage.isPSDCCodeSnippetIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStage.getPSDCCodeSnippetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCCodeSnippetId_Default(pSDevSlnPipelineStage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCODESNIPPETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnPipelineId(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isPSDevSlnPipelineIdDirty() && !bl2 : !pSDevSlnPipelineStage.isPSDevSlnPipelineIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStage.getPSDevSlnPipelineId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineId_Default(pSDevSlnPipelineStage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnPipelineStageId(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isPSDevSlnPipelineStageIdDirty() && !bl2 : !pSDevSlnPipelineStage.isPSDevSlnPipelineStageIdDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStage.getPSDevSlnPipelineStageId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINESTAGEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineStageId_Default(pSDevSlnPipelineStage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINESTAGEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnPipelineStageName(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isPSDevSlnPipelineStageNameDirty() && !bl2 : !pSDevSlnPipelineStage.isPSDevSlnPipelineStageNameDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStage.getPSDevSlnPipelineStageName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINESTAGENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnPipelineStageName_Default(pSDevSlnPipelineStage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNPIPELINESTAGENAME");
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
                string3 = "PSDEVSLNPIPELINEID";
                String string4 = this.checkFieldDupRule(this.getPSDevSlnPipelineStageDEModel(), "PSDEVSLNPIPELINESTAGENAME", string3, pSDevSlnPipelineStage, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEVSLNPIPELINESTAGENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StageParams(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isStageParamsDirty() : !pSDevSlnPipelineStage.isStageParamsDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStage.getStageParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StageParams_Default(pSDevSlnPipelineStage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STAGEPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StageType(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isStageTypeDirty() : !pSDevSlnPipelineStage.isStageTypeDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStage.getStageType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StageType_Default(pSDevSlnPipelineStage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STAGETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplateMode(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isTemplateModeDirty() : !pSDevSlnPipelineStage.isTemplateModeDirty()) {
            return null;
        }
        Integer n = pSDevSlnPipelineStage.getTemplateMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TemplateMode_Default(pSDevSlnPipelineStage, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLATEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isUserCatDirty() : !pSDevSlnPipelineStage.isUserCatDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStage.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDevSlnPipelineStage, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isUserTagDirty() : !pSDevSlnPipelineStage.isUserTagDirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStage.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDevSlnPipelineStage, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isUserTag2Dirty() : !pSDevSlnPipelineStage.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStage.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDevSlnPipelineStage, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isUserTag3Dirty() : !pSDevSlnPipelineStage.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStage.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDevSlnPipelineStage, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isUserTag4Dirty() : !pSDevSlnPipelineStage.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDevSlnPipelineStage.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDevSlnPipelineStage, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnPipelineStage.isValidFlagDirty() && !bl2 : !pSDevSlnPipelineStage.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnPipelineStage.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDevSlnPipelineStage, bl2, bl3);
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

    protected void onSyncEntity(PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl) throws Exception {
        super.onSyncEntity(pSDevSlnPipelineStage, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevSlnPipelineStage, bl);
    }

    public Object getDataContextValue(PSDevSlnPipelineStage pSDevSlnPipelineStage, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevSlnPipelineStage, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnPipelineStage pSDevSlnPipelineStage, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevSlnPipelineStage, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AGENTDOCKERFILE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AgentDockerFile_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AGENTIMAGE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AgentImage_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AGENTIMAGEARGS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AgentImageArgs_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AGENTPSDCREGISTRYITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AgentPSDCRegistryItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AGENTPSDCREGISTRYITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AgentPSDCRegistryItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AGENTREUSEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AgentReuseMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AGENTTAGS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AgentTags_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AGENTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AgentType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONDMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONDMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"POSTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PostMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCODESNIPPETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCCodeSnippetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCODESNIPPETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCCodeSnippetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINESTAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineStageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNPIPELINESTAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnPipelineStageName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STAGEPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StageParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STAGETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StageType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLATEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplateMode_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AgentDockerFile_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGENTDOCKERFILE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AgentImage_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGENTIMAGE", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AgentImageArgs_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGENTIMAGEARGS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AgentPSDCRegistryItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGENTPSDCREGISTRYITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AgentPSDCRegistryItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGENTPSDCREGISTRYITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AgentReuseMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AgentTags_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGENTTAGS", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AgentType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGENTTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CondModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CondModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_CustomCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_PostMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("POSTMODE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCCodeSnippetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCODESNIPPETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCCodeSnippetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCODESNIPPETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDevSlnPipelineId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNPIPELINEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnPipelineName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNPIPELINENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnPipelineStageId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNPIPELINESTAGEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnPipelineStageName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNPIPELINESTAGENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StageParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STAGEPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StageType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STAGETYPE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplateMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevSlnPipelineStage)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnPipelineStage pSDevSlnPipelineStage) throws Exception {
        super.onUpdateParent(pSDevSlnPipelineStage);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnPipelineStage pSDevSlnPipelineStage, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNPIPELINESTAGE");
        if (!bl) {
            pSDevSlnPipelineStage.setCreateDate(null);
            pSDevSlnPipelineStage.setCreateMan(null);
            pSDevSlnPipelineStage.setPSDevSlnPipelineStageId(null);
            pSDevSlnPipelineStage.setUpdateDate(null);
            pSDevSlnPipelineStage.setUpdateMan(null);
            pSDevSlnPipelineStage.setPSDevSlnId(null);
            pSDevSlnPipelineStage.setPSDevSlnPipelineId(null);
            pSDevSlnPipelineStage.setPSDevSlnPipelineName(null);
            super.exportCurXmlModel(pSDevSlnPipelineStage, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDevSlnPipelineStage pSDevSlnPipelineStage, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDevSlnPipelineStep(pSDevSlnPipelineStage, xmlNode);
        super.onExportRelatedXmlModel(pSDevSlnPipelineStage, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDevSlnPipelineStep(PSDevSlnPipelineStage pSDevSlnPipelineStage, XmlNode xmlNode) throws Exception {
        PSDevSlnPipelineStepService pSDevSlnPipelineStepService = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDevSlnPipelineStep> arrayList = null;
        String string = pSDevSlnPipelineStage.getPSDevSlnPipelineStageId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDevSlnPipelineStepService.selectByPSDevSlnPipelineStage(pSDevSlnPipelineStage, "ORDER BY ORDERVALUE ASC") : pSDevSlnPipelineStepService.selectTempByPSDevSlnPipelineStage(pSDevSlnPipelineStage, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEVSLNPIPELINESTEPS");
            xmlNode.addNode(xmlNode2);
            for (PSDevSlnPipelineStep pSDevSlnPipelineStep : arrayList) {
                pSDevSlnPipelineStep.set("ORDERVALUE", null);
                pSDevSlnPipelineStepService.exportXmlModel(pSDevSlnPipelineStep, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDevSlnPipelineStage pSDevSlnPipelineStage, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEVSLNPIPELINESTEPS");
        this.importRelatedXmlModel_PSDevSlnPipelineStep(pSDevSlnPipelineStage, xmlNode2);
        super.onImportRelatedXmlModel(pSDevSlnPipelineStage, xmlNode);
    }

    protected void importRelatedXmlModel_PSDevSlnPipelineStep(PSDevSlnPipelineStage pSDevSlnPipelineStage, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDevSlnPipelineStepService pSDevSlnPipelineStepService = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDevSlnPipelineStage.getPSDevSlnPipelineStageId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDevSlnPipelineStepService.removeByPSDevSlnPipelineStage(pSDevSlnPipelineStage);
        } else {
            pSDevSlnPipelineStepService.removeTempByPSDevSlnPipelineStage(pSDevSlnPipelineStage);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDevSlnPipelineStep pSDevSlnPipelineStep = new PSDevSlnPipelineStep();
                pSDevSlnPipelineStep.setOrderValue(n);
                n += 100;
                pSDevSlnPipelineStepService.fillParentInfo(pSDevSlnPipelineStep, "DER1N", "DER1N_PSDEVSLNPIPELINESTEP_PSDEVSLNPIPELINESTAGE_PSDEVSLNPIPELINESTAGEID", pSDevSlnPipelineStage.getPSDevSlnPipelineStageId());
                pSDevSlnPipelineStepService.importXmlModel(pSDevSlnPipelineStep, xmlNode2);
            }
        }
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDevSlnPipelineStage pSDevSlnPipelineStage, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "Stage");
        defaultValueMap.put("PSDEVSLNPIPELINESTAGENAME", "\u9636\u6bb5");
    }
}

