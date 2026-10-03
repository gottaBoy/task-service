/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
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
package net.ibizsys.pscore.srv.aidesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
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
import net.ibizsys.pscore.srv.aidesign.dao.PSSysAIPipelineAgentDAO;
import net.ibizsys.pscore.srv.aidesign.demodel.PSSysAIPipelineAgentDEModel;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIFactory;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIFactoryBase;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIPipelineAgent;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIPipelineJob;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIPipelineWorker;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineJobService;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineJobServiceBase;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineWorkerService;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineWorkerServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysAIPipelineAgentServiceBase
extends PSCoreSysServiceBase<PSSysAIPipelineAgent> {
    private static final Log log = LogFactory.getLog(PSSysAIPipelineAgentServiceBase.class);
    public static final String DATASET_CURAIFACTORY = "CurAIFactory";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysAIPipelineAgentDEModel pSSysAIPipelineAgentDEModel;
    private PSSysAIPipelineAgentDAO pSSysAIPipelineAgentDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineAgentService";
    }

    public PSSysAIPipelineAgentDEModel getPSSysAIPipelineAgentDEModel() {
        if (this.pSSysAIPipelineAgentDEModel == null) {
            try {
                this.pSSysAIPipelineAgentDEModel = (PSSysAIPipelineAgentDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.aidesign.demodel.PSSysAIPipelineAgentDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysAIPipelineAgentDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysAIPipelineAgentDEModel();
    }

    public PSSysAIPipelineAgentDAO getPSSysAIPipelineAgentDAO() {
        if (this.pSSysAIPipelineAgentDAO == null) {
            try {
                this.pSSysAIPipelineAgentDAO = (PSSysAIPipelineAgentDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.aidesign.dao.PSSysAIPipelineAgentDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysAIPipelineAgentDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysAIPipelineAgentDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAIFACTORY, (boolean)true) == 0) {
            return this.fetchCurAIFactory(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAIFACTORY, (boolean)true) == 0) {
            return this.fetchTempCurAIFactory(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurAIFactory(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAIFACTORY, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurAIFactory(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAIFACTORY, true);
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

    protected void onFillParentInfo(PSSysAIPipelineAgent pSSysAIPipelineAgent, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAIPIPELINEAGENT_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysAIPipelineAgent, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAIPIPELINEAGENT_PSSYSAIFACTORY_PSSYSAIFACTORYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.aidesign.service.PSSysAIFactoryService", (SessionFactory)this.getSessionFactory());
            PSSysAIFactory pSSysAIFactory = (PSSysAIFactory)iService.getDEModel().createEntity();
            pSSysAIFactory.set("PSSYSAIFACTORYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysAIFactory);
            } else {
                iService.get(pSSysAIFactory);
            }
            this.onFillParentInfo_PSSysAIFactory(pSSysAIPipelineAgent, pSSysAIFactory);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAIPIPELINEAGENT_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSSysAIPipelineAgent, pSSysSFPlugin);
            return;
        }
        super.onFillParentInfo(pSSysAIPipelineAgent, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysAIPipelineAgent pSSysAIPipelineAgent, PSDataEntity pSDataEntity) throws Exception {
        pSSysAIPipelineAgent.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysAIPipelineAgent.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSSysAIFactory(PSSysAIPipelineAgent pSSysAIPipelineAgent, PSSysAIFactory pSSysAIFactory) throws Exception {
        pSSysAIPipelineAgent.setPSSysAIFactoryId(pSSysAIFactory.getPSSysAIFactoryId());
        pSSysAIPipelineAgent.setPSSysAIFactoryName(pSSysAIFactory.getPSSysAIFactoryName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSSysAIPipelineAgent pSSysAIPipelineAgent, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSysAIPipelineAgent.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSysAIPipelineAgent.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillEntityFullInfo(PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl) throws Exception {
        if (bl) {
            if (pSSysAIPipelineAgent.getAIPipelineAgentType() == null) {
                pSSysAIPipelineAgent.setAIPipelineAgentType((String)this.getDefaultValue(this.getWebContext(), "", DATASET_DEFAULT, 25));
            }
            if (pSSysAIPipelineAgent.getValidFlag() == null) {
                pSSysAIPipelineAgent.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSSysAIPipelineAgent, bl);
        this.onFillEntityFullInfo_PSDE(pSSysAIPipelineAgent, bl);
        this.onFillEntityFullInfo_PSSysAIFactory(pSSysAIPipelineAgent, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSSysAIPipelineAgent, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl) throws Exception {
        if (pSSysAIPipelineAgent.isPSDEIdDirty()) {
            if (pSSysAIPipelineAgent.getPSDEId() != null) {
                if (pSSysAIPipelineAgent.getPSDEId() == null || pSSysAIPipelineAgent.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysAIPipelineAgent.getPSDE();
                    pSSysAIPipelineAgent.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysAIPipelineAgent.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysAIFactory(PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysAIPipelineAgent, bl);
    }

    public ArrayList<PSSysAIPipelineAgent> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysAIPipelineAgent> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysAIPipelineAgent> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysAIPipelineAgent> selectByPSSysAIFactory(PSSysAIFactoryBase pSSysAIFactoryBase) throws Exception {
        return this.selectByPSSysAIFactory(pSSysAIFactoryBase, "", -1);
    }

    public ArrayList<PSSysAIPipelineAgent> selectByPSSysAIFactory(PSSysAIFactoryBase pSSysAIFactoryBase, String string) throws Exception {
        return this.selectByPSSysAIFactory(pSSysAIFactoryBase, string, -1);
    }

    public ArrayList<PSSysAIPipelineAgent> selectByPSSysAIFactory(PSSysAIFactoryBase pSSysAIFactoryBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysAIPipelineAgent> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSysAIPipelineAgent> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSysAIPipelineAgent> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSFPLUGINID", (Object)pSSysSFPluginBase.getPSSysSFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSFPluginCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysAIPipelineAgent> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAIPIPELINEAGENT_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSAIPIPELINEAGENT", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysAIPipelineAgent> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysAIPipelineAgent pSSysAIPipelineAgent : arrayList) {
            PSSysAIPipelineAgent pSSysAIPipelineAgent2 = (PSSysAIPipelineAgent)this.getDEModel().createEntity();
            pSSysAIPipelineAgent2.setPSSysAIPipelineAgentId(pSSysAIPipelineAgent.getPSSysAIPipelineAgentId());
            pSSysAIPipelineAgent2.setPSDEId(null);
            this.update(pSSysAIPipelineAgent2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAIPipelineAgentServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysAIPipelineAgentServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysAIPipelineAgentServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysAIPipelineAgent> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysAIPipelineAgent pSSysAIPipelineAgent : arrayList) {
            this.remove(pSSysAIPipelineAgent);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysAIPipelineAgent> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysAIPipelineAgent> arrayList) throws Exception {
    }

    public void testRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        ArrayList<PSSysAIPipelineAgent> arrayList = this.selectByPSSysAIFactory(pSSysAIFactory, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAIFACTORY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysAIFactory);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAIPIPELINEAGENT_PSSYSAIFACTORY_PSSYSAIFACTORYID", "", iDataEntityModel.getName(), "PSSYSAIPIPELINEAGENT", iDataEntityModel.getDataInfo(pSSysAIFactory), arrayList.get(0)));
        }
    }

    public void resetPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        ArrayList<PSSysAIPipelineAgent> arrayList = this.selectByPSSysAIFactory(pSSysAIFactory);
        for (PSSysAIPipelineAgent pSSysAIPipelineAgent : arrayList) {
            PSSysAIPipelineAgent pSSysAIPipelineAgent2 = (PSSysAIPipelineAgent)this.getDEModel().createEntity();
            pSSysAIPipelineAgent2.setPSSysAIPipelineAgentId(pSSysAIPipelineAgent.getPSSysAIPipelineAgentId());
            pSSysAIPipelineAgent2.setPSSysAIFactoryId(null);
            this.update(pSSysAIPipelineAgent2);
        }
    }

    public void removeByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        final PSSysAIFactory pSSysAIFactory2 = pSSysAIFactory;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAIPipelineAgentServiceBase.this.onBeforeRemoveByPSSysAIFactory(pSSysAIFactory2);
                PSSysAIPipelineAgentServiceBase.this.internalRemoveByPSSysAIFactory(pSSysAIFactory2);
                PSSysAIPipelineAgentServiceBase.this.onAfterRemoveByPSSysAIFactory(pSSysAIFactory2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
    }

    protected void internalRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        ArrayList<PSSysAIPipelineAgent> arrayList = this.selectByPSSysAIFactory(pSSysAIFactory);
        this.onBeforeRemoveByPSSysAIFactory(pSSysAIFactory, arrayList);
        for (PSSysAIPipelineAgent pSSysAIPipelineAgent : arrayList) {
            this.remove(pSSysAIPipelineAgent);
        }
        this.onAfterRemoveByPSSysAIFactory(pSSysAIFactory, arrayList);
    }

    protected void onAfterRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
    }

    protected void onBeforeRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory, ArrayList<PSSysAIPipelineAgent> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory, ArrayList<PSSysAIPipelineAgent> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysAIPipelineAgent> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAIPIPELINEAGENT_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSYSAIPIPELINEAGENT", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysAIPipelineAgent> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSSysAIPipelineAgent pSSysAIPipelineAgent : arrayList) {
            PSSysAIPipelineAgent pSSysAIPipelineAgent2 = (PSSysAIPipelineAgent)this.getDEModel().createEntity();
            pSSysAIPipelineAgent2.setPSSysAIPipelineAgentId(pSSysAIPipelineAgent.getPSSysAIPipelineAgentId());
            pSSysAIPipelineAgent2.setPSSysSFPluginId(null);
            this.update(pSSysAIPipelineAgent2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAIPipelineAgentServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysAIPipelineAgentServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysAIPipelineAgentServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysAIPipelineAgent> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSysAIPipelineAgent pSSysAIPipelineAgent : arrayList) {
            this.remove(pSSysAIPipelineAgent);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysAIPipelineAgent> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysAIPipelineAgent> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        pSCoreSysServiceBase = (PSSysAIPipelineJobService)ServiceGlobal.getService(PSSysAIPipelineJobService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAIPipelineJobServiceBase)pSCoreSysServiceBase).testRemoveByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        pSCoreSysServiceBase = (PSSysAIPipelineWorkerService)ServiceGlobal.getService(PSSysAIPipelineWorkerService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAIPipelineWorkerServiceBase)pSCoreSysServiceBase).testRemoveByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        super.onBeforeRemove(pSSysAIPipelineAgent);
    }

    protected void onBeforeRemoveTemp(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysAIPipelineWorkerService)ServiceGlobal.getService(PSSysAIPipelineWorkerService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAIPipelineWorkerServiceBase)pSCoreSysServiceBase).removeTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        pSCoreSysServiceBase = (PSSysAIPipelineJobService)ServiceGlobal.getService(PSSysAIPipelineJobService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAIPipelineJobServiceBase)pSCoreSysServiceBase).removeTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        super.onBeforeRemoveTemp(pSSysAIPipelineAgent);
    }

    protected void getRelatedDataTempMajor(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        this.getRelatedDataTempMajor_PSSysAIPipelineJob(pSSysAIPipelineAgent);
        this.getRelatedDataTempMajor_PSSysAIPipelineWorker(pSSysAIPipelineAgent);
        super.getRelatedDataTempMajor(pSSysAIPipelineAgent);
    }

    protected void getRelatedDataTempMajor_PSSysAIPipelineJob(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        PSSysAIPipelineJobService pSSysAIPipelineJobService = (PSSysAIPipelineJobService)ServiceGlobal.getService(PSSysAIPipelineJobService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysAIPipelineJob> arrayList = null;
        String string = pSSysAIPipelineAgent.getPSSysAIPipelineAgentId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysAIPipelineJobService.selectByPSSysAIPipelineAgent(pSSysAIPipelineAgent) : pSSysAIPipelineJobService.selectTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        for (PSSysAIPipelineJob pSSysAIPipelineJob : arrayList) {
            pSSysAIPipelineJobService.getTempMajor(pSSysAIPipelineJob);
        }
    }

    protected void getRelatedDataTempMajor_PSSysAIPipelineWorker(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        PSSysAIPipelineWorkerService pSSysAIPipelineWorkerService = (PSSysAIPipelineWorkerService)ServiceGlobal.getService(PSSysAIPipelineWorkerService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysAIPipelineWorker> arrayList = null;
        String string = pSSysAIPipelineAgent.getPSSysAIPipelineAgentId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysAIPipelineWorkerService.selectByPSSysAIPipelineAgent(pSSysAIPipelineAgent) : pSSysAIPipelineWorkerService.selectTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        for (PSSysAIPipelineWorker pSSysAIPipelineWorker : arrayList) {
            pSSysAIPipelineWorkerService.getTempMajor(pSSysAIPipelineWorker);
        }
    }

    protected void updateRelatedDataTempMajor(PSSysAIPipelineAgent pSSysAIPipelineAgent, PSSysAIPipelineAgent pSSysAIPipelineAgent2) throws Exception {
        ArrayList<PSSysAIPipelineWorker> arrayList = this.updateRelatedDataTempMajor_removePSSysAIPipelineWorker(pSSysAIPipelineAgent, pSSysAIPipelineAgent2);
        ArrayList<PSSysAIPipelineJob> arrayList2 = this.updateRelatedDataTempMajor_removePSSysAIPipelineJob(pSSysAIPipelineAgent, pSSysAIPipelineAgent2);
        this.updateRelatedDataTempMajor_updatePSSysAIPipelineJob(pSSysAIPipelineAgent, pSSysAIPipelineAgent2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSSysAIPipelineWorker(pSSysAIPipelineAgent, pSSysAIPipelineAgent2, arrayList);
        super.updateRelatedDataTempMajor(pSSysAIPipelineAgent, pSSysAIPipelineAgent2);
    }

    protected ArrayList<PSSysAIPipelineJob> updateRelatedDataTempMajor_removePSSysAIPipelineJob(PSSysAIPipelineAgent pSSysAIPipelineAgent, PSSysAIPipelineAgent pSSysAIPipelineAgent2) throws Exception {
        PSSysAIPipelineJobService pSSysAIPipelineJobService = (PSSysAIPipelineJobService)ServiceGlobal.getService(PSSysAIPipelineJobService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysAIPipelineJob> arrayList = pSSysAIPipelineJobService.selectTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        ArrayList<PSSysAIPipelineJob> arrayList2 = pSSysAIPipelineJobService.selectByPSSysAIPipelineAgent(pSSysAIPipelineAgent2);
        HashMap<String, PSSysAIPipelineJob> hashMap = new HashMap<String, PSSysAIPipelineJob>();
        for (PSSysAIPipelineJob pSSysAIPipelineJob : arrayList2) {
            hashMap.put(pSSysAIPipelineJob.getPSSysAIPipelineJobId(), pSSysAIPipelineJob);
        }
        for (PSSysAIPipelineJob pSSysAIPipelineJob : arrayList) {
            Object object = pSSysAIPipelineJob.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysAIPipelineJob pSSysAIPipelineJob : hashMap.values()) {
            pSSysAIPipelineJobService.remove(pSSysAIPipelineJob);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysAIPipelineJob(PSSysAIPipelineAgent pSSysAIPipelineAgent, PSSysAIPipelineAgent pSSysAIPipelineAgent2, ArrayList<PSSysAIPipelineJob> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysAIPipelineJobService pSSysAIPipelineJobService = (PSSysAIPipelineJobService)ServiceGlobal.getService(PSSysAIPipelineJobService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysAIPipelineJob pSSysAIPipelineJob : arrayList) {
            pSSysAIPipelineJobService.updateTempMajor(pSSysAIPipelineJob);
        }
    }

    protected ArrayList<PSSysAIPipelineWorker> updateRelatedDataTempMajor_removePSSysAIPipelineWorker(PSSysAIPipelineAgent pSSysAIPipelineAgent, PSSysAIPipelineAgent pSSysAIPipelineAgent2) throws Exception {
        PSSysAIPipelineWorkerService pSSysAIPipelineWorkerService = (PSSysAIPipelineWorkerService)ServiceGlobal.getService(PSSysAIPipelineWorkerService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysAIPipelineWorker> arrayList = pSSysAIPipelineWorkerService.selectTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        ArrayList<PSSysAIPipelineWorker> arrayList2 = pSSysAIPipelineWorkerService.selectByPSSysAIPipelineAgent(pSSysAIPipelineAgent2);
        HashMap<String, PSSysAIPipelineWorker> hashMap = new HashMap<String, PSSysAIPipelineWorker>();
        for (PSSysAIPipelineWorker pSSysAIPipelineWorker : arrayList2) {
            hashMap.put(pSSysAIPipelineWorker.getPSSysAIPipelineWorkerId(), pSSysAIPipelineWorker);
        }
        for (PSSysAIPipelineWorker pSSysAIPipelineWorker : arrayList) {
            Object object = pSSysAIPipelineWorker.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysAIPipelineWorker pSSysAIPipelineWorker : hashMap.values()) {
            pSSysAIPipelineWorkerService.remove(pSSysAIPipelineWorker);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysAIPipelineWorker(PSSysAIPipelineAgent pSSysAIPipelineAgent, PSSysAIPipelineAgent pSSysAIPipelineAgent2, ArrayList<PSSysAIPipelineWorker> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysAIPipelineWorkerService pSSysAIPipelineWorkerService = (PSSysAIPipelineWorkerService)ServiceGlobal.getService(PSSysAIPipelineWorkerService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysAIPipelineWorker pSSysAIPipelineWorker : arrayList) {
            pSSysAIPipelineWorkerService.updateTempMajor(pSSysAIPipelineWorker);
        }
    }

    protected void replaceParentInfo(PSSysAIPipelineAgent pSSysAIPipelineAgent, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysAIPipelineAgent, cloneSession);
        if (pSSysAIPipelineAgent.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysAIPipelineAgent.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysAIPipelineAgent, (PSDataEntity)iEntity);
        }
        if (pSSysAIPipelineAgent.getPSSysAIFactoryId() != null && (iEntity = cloneSession.getEntity("PSSYSAIFACTORY", (Object)pSSysAIPipelineAgent.getPSSysAIFactoryId())) != null) {
            this.onFillParentInfo_PSSysAIFactory(pSSysAIPipelineAgent, (PSSysAIFactory)iEntity);
        }
        if (pSSysAIPipelineAgent.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSysAIPipelineAgent.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSSysAIPipelineAgent, (PSSysSFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysAIPipelineAgent, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AgentInfo(bl, pSSysAIPipelineAgent, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIPipelineAgentParams(bl, pSSysAIPipelineAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIPipelineAgentTag(bl, pSSysAIPipelineAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIPipelineAgentTag2(bl, pSSysAIPipelineAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIPipelineAgentType(bl, pSSysAIPipelineAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIPlatformType(bl, pSSysAIPipelineAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysAIPipelineAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSSysAIPipelineAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSSysAIPipelineAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysAIPipelineAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysAIPipelineAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysAIPipelineAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIFactoryId(bl, pSSysAIPipelineAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIPipelineAgentId(bl, pSSysAIPipelineAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIPipelineAgentName(bl, pSSysAIPipelineAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSysAIPipelineAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysAIPipelineAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysAIPipelineAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysAIPipelineAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysAIPipelineAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysAIPipelineAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysAIPipelineAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysAIPipelineAgent, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AgentInfo(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineAgent.isAgentInfoDirty() : !pSSysAIPipelineAgent.isAgentInfoDirty()) {
            return null;
        }
        String string = pSSysAIPipelineAgent.getAgentInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AgentInfo_Default(pSSysAIPipelineAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGENTINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIPipelineAgentParams(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineAgent.isAIPipelineAgentParamsDirty() : !pSSysAIPipelineAgent.isAIPipelineAgentParamsDirty()) {
            return null;
        }
        String string = pSSysAIPipelineAgent.getAIPipelineAgentParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIPipelineAgentParams_Default(pSSysAIPipelineAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIPIPELINEAGENTPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIPipelineAgentTag(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineAgent.isAIPipelineAgentTagDirty() : !pSSysAIPipelineAgent.isAIPipelineAgentTagDirty()) {
            return null;
        }
        String string = pSSysAIPipelineAgent.getAIPipelineAgentTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIPipelineAgentTag_Default(pSSysAIPipelineAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIPIPELINEAGENTTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIPipelineAgentTag2(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineAgent.isAIPipelineAgentTag2Dirty() : !pSSysAIPipelineAgent.isAIPipelineAgentTag2Dirty()) {
            return null;
        }
        String string = pSSysAIPipelineAgent.getAIPipelineAgentTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIPipelineAgentTag2_Default(pSSysAIPipelineAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIPIPELINEAGENTTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIPipelineAgentType(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineAgent.isAIPipelineAgentTypeDirty() && !bl2 : !pSSysAIPipelineAgent.isAIPipelineAgentTypeDirty()) {
            return null;
        }
        String string = pSSysAIPipelineAgent.getAIPipelineAgentType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIPIPELINEAGENTTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIPipelineAgentType_Default(pSSysAIPipelineAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIPIPELINEAGENTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIPlatformType(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineAgent.isAIPlatformTypeDirty() : !pSSysAIPipelineAgent.isAIPlatformTypeDirty()) {
            return null;
        }
        String string = pSSysAIPipelineAgent.getAIPlatformType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIPlatformType_Default(pSSysAIPipelineAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIPLATFORMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineAgent.isCodeNameDirty() && !bl2 : !pSSysAIPipelineAgent.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysAIPipelineAgent.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysAIPipelineAgent, bl2, bl3);
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
                string3 = "PSSYSAIFACTORYID";
                String string4 = this.checkFieldDupRule(this.getPSSysAIPipelineAgentDEModel(), "CODENAME", string3, pSSysAIPipelineAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineAgent.isCustomCodeDirty() : !pSSysAIPipelineAgent.isCustomCodeDirty()) {
            return null;
        }
        String string = pSSysAIPipelineAgent.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSSysAIPipelineAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineAgent.isCustomModeDirty() : !pSSysAIPipelineAgent.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSSysAIPipelineAgent.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default(pSSysAIPipelineAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineAgent.isMemoDirty() : !pSSysAIPipelineAgent.isMemoDirty()) {
            return null;
        }
        String string = pSSysAIPipelineAgent.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysAIPipelineAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineAgent.isPSDEIdDirty() : !pSSysAIPipelineAgent.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysAIPipelineAgent.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSSysAIPipelineAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineAgent.isPSDENameDirty() : !pSSysAIPipelineAgent.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysAIPipelineAgent.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSSysAIPipelineAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAIFactoryId(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineAgent.isPSSysAIFactoryIdDirty() : !pSSysAIPipelineAgent.isPSSysAIFactoryIdDirty()) {
            return null;
        }
        String string = pSSysAIPipelineAgent.getPSSysAIFactoryId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIFactoryId_Default(pSSysAIPipelineAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAIPipelineAgentId(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineAgent.isPSSysAIPipelineAgentIdDirty() && !bl2 : !pSSysAIPipelineAgent.isPSSysAIPipelineAgentIdDirty()) {
            return null;
        }
        String string = pSSysAIPipelineAgent.getPSSysAIPipelineAgentId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIPIPELINEAGENTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIPipelineAgentId_Default(pSSysAIPipelineAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAIPipelineAgentName(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineAgent.isPSSysAIPipelineAgentNameDirty() && !bl2 : !pSSysAIPipelineAgent.isPSSysAIPipelineAgentNameDirty()) {
            return null;
        }
        String string = pSSysAIPipelineAgent.getPSSysAIPipelineAgentName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIPIPELINEAGENTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIPipelineAgentName_Default(pSSysAIPipelineAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIPIPELINEAGENTNAME");
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
                string3 = "PSSYSAIFACTORYID";
                String string4 = this.checkFieldDupRule(this.getPSSysAIPipelineAgentDEModel(), "PSSYSAIPIPELINEAGENTNAME", string3, pSSysAIPipelineAgent, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSAIPIPELINEAGENTNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineAgent.isPSSysSFPluginIdDirty() : !pSSysAIPipelineAgent.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysAIPipelineAgent.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSSysAIPipelineAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineAgent.isUserCatDirty() : !pSSysAIPipelineAgent.isUserCatDirty()) {
            return null;
        }
        String string = pSSysAIPipelineAgent.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysAIPipelineAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineAgent.isUserTagDirty() : !pSSysAIPipelineAgent.isUserTagDirty()) {
            return null;
        }
        String string = pSSysAIPipelineAgent.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysAIPipelineAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineAgent.isUserTag2Dirty() : !pSSysAIPipelineAgent.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysAIPipelineAgent.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysAIPipelineAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineAgent.isUserTag3Dirty() : !pSSysAIPipelineAgent.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysAIPipelineAgent.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysAIPipelineAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineAgent.isUserTag4Dirty() : !pSSysAIPipelineAgent.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysAIPipelineAgent.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysAIPipelineAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIPipelineAgent.isValidFlagDirty() && !bl2 : !pSSysAIPipelineAgent.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysAIPipelineAgent.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysAIPipelineAgent, bl2, bl3);
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

    protected void onSyncEntity(PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl) throws Exception {
        super.onSyncEntity(pSSysAIPipelineAgent, bl);
    }

    protected void onSyncIndexEntities(PSSysAIPipelineAgent pSSysAIPipelineAgent, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysAIPipelineAgent, bl);
    }

    public Object getDataContextValue(PSSysAIPipelineAgent pSSysAIPipelineAgent, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysAIPipelineAgent, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysAIPipelineAgent pSSysAIPipelineAgent, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysAIPipelineAgent, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AGENTINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AgentInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIPIPELINEAGENTPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIPipelineAgentParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIPIPELINEAGENTTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIPipelineAgentTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIPIPELINEAGENTTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIPipelineAgentTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIPIPELINEAGENTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIPipelineAgentType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIPLATFORMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIPlatformType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CUSTOMMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AgentInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGENTINFO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIPipelineAgentParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AIPIPELINEAGENTPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIPipelineAgentTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AIPIPELINEAGENTTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIPipelineAgentTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AIPIPELINEAGENTTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIPipelineAgentType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AIPIPELINEAGENTTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIPlatformType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AIPLATFORMTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("AIPLATFORMTYPE", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_CustomMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_PSSysSFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysAIPipelineAgent)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysAIPipelineAgent pSSysAIPipelineAgent) throws Exception {
        super.onUpdateParent(pSSysAIPipelineAgent);
    }

    @Override
    protected void exportCurXmlModel(PSSysAIPipelineAgent pSSysAIPipelineAgent, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSAIPIPELINEAGENT");
        if (!bl) {
            pSSysAIPipelineAgent.setCreateDate(null);
            pSSysAIPipelineAgent.setCreateMan(null);
            pSSysAIPipelineAgent.setPSSysAIPipelineAgentId(null);
            pSSysAIPipelineAgent.setUpdateDate(null);
            pSSysAIPipelineAgent.setUpdateMan(null);
            super.exportCurXmlModel(pSSysAIPipelineAgent, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysAIPipelineAgent pSSysAIPipelineAgent, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSSysAIPipelineJob(pSSysAIPipelineAgent, xmlNode);
        this.exportRelatedXmlModel_PSSysAIPipelineWorker(pSSysAIPipelineAgent, xmlNode);
        super.onExportRelatedXmlModel(pSSysAIPipelineAgent, xmlNode);
    }

    protected void exportRelatedXmlModel_PSSysAIPipelineJob(PSSysAIPipelineAgent pSSysAIPipelineAgent, XmlNode xmlNode) throws Exception {
        PSSysAIPipelineJobService pSSysAIPipelineJobService = (PSSysAIPipelineJobService)ServiceGlobal.getService(PSSysAIPipelineJobService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysAIPipelineJob> arrayList = null;
        String string = pSSysAIPipelineAgent.getPSSysAIPipelineAgentId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysAIPipelineJobService.selectByPSSysAIPipelineAgent(pSSysAIPipelineAgent, "ORDER BY ORDERVALUE ASC") : pSSysAIPipelineJobService.selectTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSAIPIPELINEJOBS");
            xmlNode.addNode(xmlNode2);
            for (PSSysAIPipelineJob pSSysAIPipelineJob : arrayList) {
                pSSysAIPipelineJob.set("ORDERVALUE", null);
                pSSysAIPipelineJobService.exportXmlModel(pSSysAIPipelineJob, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSSysAIPipelineWorker(PSSysAIPipelineAgent pSSysAIPipelineAgent, XmlNode xmlNode) throws Exception {
        PSSysAIPipelineWorkerService pSSysAIPipelineWorkerService = (PSSysAIPipelineWorkerService)ServiceGlobal.getService(PSSysAIPipelineWorkerService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysAIPipelineWorker> arrayList = null;
        String string = pSSysAIPipelineAgent.getPSSysAIPipelineAgentId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysAIPipelineWorkerService.selectByPSSysAIPipelineAgent(pSSysAIPipelineAgent) : pSSysAIPipelineWorkerService.selectTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSAIPIPELINEWORKERS");
            xmlNode.addNode(xmlNode2);
            for (PSSysAIPipelineWorker pSSysAIPipelineWorker : arrayList) {
                pSSysAIPipelineWorkerService.exportXmlModel(pSSysAIPipelineWorker, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSSysAIPipelineAgent pSSysAIPipelineAgent, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSSYSAIPIPELINEJOBS");
        this.importRelatedXmlModel_PSSysAIPipelineJob(pSSysAIPipelineAgent, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSSYSAIPIPELINEWORKERS");
        this.importRelatedXmlModel_PSSysAIPipelineWorker(pSSysAIPipelineAgent, xmlNode3);
        super.onImportRelatedXmlModel(pSSysAIPipelineAgent, xmlNode);
    }

    protected void importRelatedXmlModel_PSSysAIPipelineJob(PSSysAIPipelineAgent pSSysAIPipelineAgent, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSSysAIPipelineJobService pSSysAIPipelineJobService = (PSSysAIPipelineJobService)ServiceGlobal.getService(PSSysAIPipelineJobService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysAIPipelineAgent.getPSSysAIPipelineAgentId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysAIPipelineJobService.removeByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        } else {
            pSSysAIPipelineJobService.removeTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysAIPipelineJob pSSysAIPipelineJob = new PSSysAIPipelineJob();
                pSSysAIPipelineJob.setOrderValue(n);
                n += 100;
                pSSysAIPipelineJobService.fillParentInfo(pSSysAIPipelineJob, "DER1N", "DER1N_PSSYSAIPIPELINEJOB_PSSYSAIPIPELINEAGENT_PSSYSAIPIPELINEAGENTID", pSSysAIPipelineAgent.getPSSysAIPipelineAgentId());
                pSSysAIPipelineJobService.importXmlModel(pSSysAIPipelineJob, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSSysAIPipelineWorker(PSSysAIPipelineAgent pSSysAIPipelineAgent, XmlNode xmlNode) throws Exception {
        PSSysAIPipelineWorkerService pSSysAIPipelineWorkerService = (PSSysAIPipelineWorkerService)ServiceGlobal.getService(PSSysAIPipelineWorkerService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysAIPipelineAgent.getPSSysAIPipelineAgentId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysAIPipelineWorkerService.removeByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        } else {
            pSSysAIPipelineWorkerService.removeTempByPSSysAIPipelineAgent(pSSysAIPipelineAgent);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysAIPipelineWorker pSSysAIPipelineWorker = new PSSysAIPipelineWorker();
                pSSysAIPipelineWorkerService.fillParentInfo(pSSysAIPipelineWorker, "DER1N", "DER1N_PSSYSAIPIPELINEWORKER_PSSYSAIPIPELINEAGENT_PSSYSAIPIPELINEAGENTID", pSSysAIPipelineAgent.getPSSysAIPipelineAgentId());
                pSSysAIPipelineWorkerService.importXmlModel(pSSysAIPipelineWorker, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysAIPipelineAgent pSSysAIPipelineAgent, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysAIPipelineAgent, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAIFACTORYID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSAIFACTORY#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAIFACTORYID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSAIPIPELINEAGENT_PSSYSAIFACTORY_PSSYSAIFACTORYID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAIFACTORYID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAIFACTORYNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSAIFACTORY", (boolean)true) == 0) {
            iEntity.set("PSSYSAIFACTORYID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSAIFACTORYID"};
    }

    @Override
    public String getModelV2Tag(PSSysAIPipelineAgent pSSysAIPipelineAgent) {
        if (!StringHelper.isNullOrEmpty((String)pSSysAIPipelineAgent.getCodeName())) {
            return pSSysAIPipelineAgent.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysAIPipelineAgent.getPSSysAIPipelineAgentName())) {
            return pSSysAIPipelineAgent.getPSSysAIPipelineAgentName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysAIPipelineAgent.getCodeName())) {
            return pSSysAIPipelineAgent.getCodeName();
        }
        return super.getModelV2Tag(pSSysAIPipelineAgent);
    }

    @Override
    public boolean setModelV2Tag(PSSysAIPipelineAgent pSSysAIPipelineAgent, String string) {
        pSSysAIPipelineAgent.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSAIPIPELINEAGENTNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSAIFACTORYID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysAIPipelineAgent pSSysAIPipelineAgent, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysAIPipelineAgent.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysAIPipelineAgent, true);
        pSSysAIPipelineAgent.set("CODENAME", string);
        if (this.select(pSSysAIPipelineAgent, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysAIPipelineAgent, true);
        return super.getModelV2Entity(pSSysAIPipelineAgent, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysAIPipelineAgent pSSysAIPipelineAgent, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysAIPipelineAgent, objectNode, string, string2, n);
    }
}

