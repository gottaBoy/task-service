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
import net.ibizsys.pscore.srv.aidesign.dao.PSSysAIWorkerAgentDAO;
import net.ibizsys.pscore.srv.aidesign.demodel.PSSysAIWorkerAgentDEModel;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIFactory;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIFactoryBase;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIWorkerAgent;
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

public abstract class PSSysAIWorkerAgentServiceBase
extends PSCoreSysServiceBase<PSSysAIWorkerAgent> {
    private static final Log log = LogFactory.getLog(PSSysAIWorkerAgentServiceBase.class);
    public static final String DATASET_CURAIFACTORY = "CurAIFactory";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysAIWorkerAgentDEModel pSSysAIWorkerAgentDEModel;
    private PSSysAIWorkerAgentDAO pSSysAIWorkerAgentDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.aidesign.service.PSSysAIWorkerAgentService";
    }

    public PSSysAIWorkerAgentDEModel getPSSysAIWorkerAgentDEModel() {
        if (this.pSSysAIWorkerAgentDEModel == null) {
            try {
                this.pSSysAIWorkerAgentDEModel = (PSSysAIWorkerAgentDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.aidesign.demodel.PSSysAIWorkerAgentDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysAIWorkerAgentDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysAIWorkerAgentDEModel();
    }

    public PSSysAIWorkerAgentDAO getPSSysAIWorkerAgentDAO() {
        if (this.pSSysAIWorkerAgentDAO == null) {
            try {
                this.pSSysAIWorkerAgentDAO = (PSSysAIWorkerAgentDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.aidesign.dao.PSSysAIWorkerAgentDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysAIWorkerAgentDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysAIWorkerAgentDAO();
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

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurAIFactory(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAIFACTORY, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysAIWorkerAgent pSSysAIWorkerAgent, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAIWORKERAGENT_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysAIWorkerAgent, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAIWORKERAGENT_PSSYSAIFACTORY_PSSYSAIFACTORYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.aidesign.service.PSSysAIFactoryService", (SessionFactory)this.getSessionFactory());
            PSSysAIFactory pSSysAIFactory = (PSSysAIFactory)iService.getDEModel().createEntity();
            pSSysAIFactory.set("PSSYSAIFACTORYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysAIFactory);
            } else {
                iService.get(pSSysAIFactory);
            }
            this.onFillParentInfo_PSSysAIFactory(pSSysAIWorkerAgent, pSSysAIFactory);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAIWORKERAGENT_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSSysAIWorkerAgent, pSSysSFPlugin);
            return;
        }
        super.onFillParentInfo(pSSysAIWorkerAgent, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysAIWorkerAgent pSSysAIWorkerAgent, PSDataEntity pSDataEntity) throws Exception {
        pSSysAIWorkerAgent.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysAIWorkerAgent.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSSysAIFactory(PSSysAIWorkerAgent pSSysAIWorkerAgent, PSSysAIFactory pSSysAIFactory) throws Exception {
        pSSysAIWorkerAgent.setPSSysAIFactoryId(pSSysAIFactory.getPSSysAIFactoryId());
        pSSysAIWorkerAgent.setPSSysAIFactoryName(pSSysAIFactory.getPSSysAIFactoryName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSSysAIWorkerAgent pSSysAIWorkerAgent, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSysAIWorkerAgent.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSysAIWorkerAgent.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillEntityFullInfo(PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl) throws Exception {
        if (bl && pSSysAIWorkerAgent.getValidFlag() == null) {
            pSSysAIWorkerAgent.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSysAIWorkerAgent, bl);
        this.onFillEntityFullInfo_PSDE(pSSysAIWorkerAgent, bl);
        this.onFillEntityFullInfo_PSSysAIFactory(pSSysAIWorkerAgent, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSSysAIWorkerAgent, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl) throws Exception {
        if (pSSysAIWorkerAgent.isPSDEIdDirty()) {
            if (pSSysAIWorkerAgent.getPSDEId() != null) {
                if (pSSysAIWorkerAgent.getPSDEId() == null || pSSysAIWorkerAgent.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysAIWorkerAgent.getPSDE();
                    pSSysAIWorkerAgent.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysAIWorkerAgent.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysAIFactory(PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysAIWorkerAgent, bl);
    }

    public ArrayList<PSSysAIWorkerAgent> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysAIWorkerAgent> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysAIWorkerAgent> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysAIWorkerAgent> selectByPSSysAIFactory(PSSysAIFactoryBase pSSysAIFactoryBase) throws Exception {
        return this.selectByPSSysAIFactory(pSSysAIFactoryBase, "", -1);
    }

    public ArrayList<PSSysAIWorkerAgent> selectByPSSysAIFactory(PSSysAIFactoryBase pSSysAIFactoryBase, String string) throws Exception {
        return this.selectByPSSysAIFactory(pSSysAIFactoryBase, string, -1);
    }

    public ArrayList<PSSysAIWorkerAgent> selectByPSSysAIFactory(PSSysAIFactoryBase pSSysAIFactoryBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysAIWorkerAgent> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSysAIWorkerAgent> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSysAIWorkerAgent> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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
        ArrayList<PSSysAIWorkerAgent> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAIWORKERAGENT_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSAIWORKERAGENT", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysAIWorkerAgent> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysAIWorkerAgent pSSysAIWorkerAgent : arrayList) {
            PSSysAIWorkerAgent pSSysAIWorkerAgent2 = (PSSysAIWorkerAgent)this.getDEModel().createEntity();
            pSSysAIWorkerAgent2.setPSSysAIWorkerAgentId(pSSysAIWorkerAgent.getPSSysAIWorkerAgentId());
            pSSysAIWorkerAgent2.setPSDEId(null);
            this.update(pSSysAIWorkerAgent2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAIWorkerAgentServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysAIWorkerAgentServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysAIWorkerAgentServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysAIWorkerAgent> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysAIWorkerAgent pSSysAIWorkerAgent : arrayList) {
            this.remove(pSSysAIWorkerAgent);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysAIWorkerAgent> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysAIWorkerAgent> arrayList) throws Exception {
    }

    public void testRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        ArrayList<PSSysAIWorkerAgent> arrayList = this.selectByPSSysAIFactory(pSSysAIFactory, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAIFACTORY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysAIFactory);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAIWORKERAGENT_PSSYSAIFACTORY_PSSYSAIFACTORYID", "", iDataEntityModel.getName(), "PSSYSAIWORKERAGENT", iDataEntityModel.getDataInfo(pSSysAIFactory), arrayList.get(0)));
        }
    }

    public void resetPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        ArrayList<PSSysAIWorkerAgent> arrayList = this.selectByPSSysAIFactory(pSSysAIFactory);
        for (PSSysAIWorkerAgent pSSysAIWorkerAgent : arrayList) {
            PSSysAIWorkerAgent pSSysAIWorkerAgent2 = (PSSysAIWorkerAgent)this.getDEModel().createEntity();
            pSSysAIWorkerAgent2.setPSSysAIWorkerAgentId(pSSysAIWorkerAgent.getPSSysAIWorkerAgentId());
            pSSysAIWorkerAgent2.setPSSysAIFactoryId(null);
            this.update(pSSysAIWorkerAgent2);
        }
    }

    public void removeByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        final PSSysAIFactory pSSysAIFactory2 = pSSysAIFactory;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAIWorkerAgentServiceBase.this.onBeforeRemoveByPSSysAIFactory(pSSysAIFactory2);
                PSSysAIWorkerAgentServiceBase.this.internalRemoveByPSSysAIFactory(pSSysAIFactory2);
                PSSysAIWorkerAgentServiceBase.this.onAfterRemoveByPSSysAIFactory(pSSysAIFactory2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
    }

    protected void internalRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        ArrayList<PSSysAIWorkerAgent> arrayList = this.selectByPSSysAIFactory(pSSysAIFactory);
        this.onBeforeRemoveByPSSysAIFactory(pSSysAIFactory, arrayList);
        for (PSSysAIWorkerAgent pSSysAIWorkerAgent : arrayList) {
            this.remove(pSSysAIWorkerAgent);
        }
        this.onAfterRemoveByPSSysAIFactory(pSSysAIFactory, arrayList);
    }

    protected void onAfterRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
    }

    protected void onBeforeRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory, ArrayList<PSSysAIWorkerAgent> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory, ArrayList<PSSysAIWorkerAgent> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysAIWorkerAgent> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAIWORKERAGENT_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSYSAIWORKERAGENT", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysAIWorkerAgent> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSSysAIWorkerAgent pSSysAIWorkerAgent : arrayList) {
            PSSysAIWorkerAgent pSSysAIWorkerAgent2 = (PSSysAIWorkerAgent)this.getDEModel().createEntity();
            pSSysAIWorkerAgent2.setPSSysAIWorkerAgentId(pSSysAIWorkerAgent.getPSSysAIWorkerAgentId());
            pSSysAIWorkerAgent2.setPSSysSFPluginId(null);
            this.update(pSSysAIWorkerAgent2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAIWorkerAgentServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysAIWorkerAgentServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysAIWorkerAgentServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysAIWorkerAgent> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSysAIWorkerAgent pSSysAIWorkerAgent : arrayList) {
            this.remove(pSSysAIWorkerAgent);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysAIWorkerAgent> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysAIWorkerAgent> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysAIWorkerAgent(pSSysAIWorkerAgent);
        pSCoreSysServiceBase = (PSSysAIPipelineJobService)ServiceGlobal.getService(PSSysAIPipelineJobService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAIPipelineJobServiceBase)pSCoreSysServiceBase).testRemoveByPSSysAIWorkerAgent(pSSysAIWorkerAgent);
        pSCoreSysServiceBase = (PSSysAIPipelineWorkerService)ServiceGlobal.getService(PSSysAIPipelineWorkerService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAIPipelineWorkerServiceBase)pSCoreSysServiceBase).testRemoveByPSSysAIWorkerAgent(pSSysAIWorkerAgent);
        super.onBeforeRemove(pSSysAIWorkerAgent);
    }

    protected void replaceParentInfo(PSSysAIWorkerAgent pSSysAIWorkerAgent, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysAIWorkerAgent, cloneSession);
        if (pSSysAIWorkerAgent.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysAIWorkerAgent.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysAIWorkerAgent, (PSDataEntity)iEntity);
        }
        if (pSSysAIWorkerAgent.getPSSysAIFactoryId() != null && (iEntity = cloneSession.getEntity("PSSYSAIFACTORY", (Object)pSSysAIWorkerAgent.getPSSysAIFactoryId())) != null) {
            this.onFillParentInfo_PSSysAIFactory(pSSysAIWorkerAgent, (PSSysAIFactory)iEntity);
        }
        if (pSSysAIWorkerAgent.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSysAIWorkerAgent.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSSysAIWorkerAgent, (PSSysSFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysAIWorkerAgent, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AgentInfo(bl, pSSysAIWorkerAgent, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIPlatformType(bl, pSSysAIWorkerAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIWorkerAgentParams(bl, pSSysAIWorkerAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIWorkerAgentTag(bl, pSSysAIWorkerAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIWorkerAgentTag2(bl, pSSysAIWorkerAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIWorkerAgentType(bl, pSSysAIWorkerAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysAIWorkerAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSSysAIWorkerAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSSysAIWorkerAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysAIWorkerAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysAIWorkerAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysAIWorkerAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIFactoryId(bl, pSSysAIWorkerAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIWorkerAgentId(bl, pSSysAIWorkerAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIWorkerAgentName(bl, pSSysAIWorkerAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSysAIWorkerAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysAIWorkerAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysAIWorkerAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysAIWorkerAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysAIWorkerAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysAIWorkerAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysAIWorkerAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysAIWorkerAgent, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AgentInfo(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIWorkerAgent.isAgentInfoDirty() : !pSSysAIWorkerAgent.isAgentInfoDirty()) {
            return null;
        }
        String string = pSSysAIWorkerAgent.getAgentInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AgentInfo_Default(pSSysAIWorkerAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_AIPlatformType(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIWorkerAgent.isAIPlatformTypeDirty() : !pSSysAIWorkerAgent.isAIPlatformTypeDirty()) {
            return null;
        }
        String string = pSSysAIWorkerAgent.getAIPlatformType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIPlatformType_Default(pSSysAIWorkerAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_AIWorkerAgentParams(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIWorkerAgent.isAIWorkerAgentParamsDirty() : !pSSysAIWorkerAgent.isAIWorkerAgentParamsDirty()) {
            return null;
        }
        String string = pSSysAIWorkerAgent.getAIWorkerAgentParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIWorkerAgentParams_Default(pSSysAIWorkerAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIWORKERAGENTPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIWorkerAgentTag(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIWorkerAgent.isAIWorkerAgentTagDirty() : !pSSysAIWorkerAgent.isAIWorkerAgentTagDirty()) {
            return null;
        }
        String string = pSSysAIWorkerAgent.getAIWorkerAgentTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIWorkerAgentTag_Default(pSSysAIWorkerAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIWORKERAGENTTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIWorkerAgentTag2(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIWorkerAgent.isAIWorkerAgentTag2Dirty() : !pSSysAIWorkerAgent.isAIWorkerAgentTag2Dirty()) {
            return null;
        }
        String string = pSSysAIWorkerAgent.getAIWorkerAgentTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIWorkerAgentTag2_Default(pSSysAIWorkerAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIWORKERAGENTTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIWorkerAgentType(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIWorkerAgent.isAIWorkerAgentTypeDirty() && !bl2 : !pSSysAIWorkerAgent.isAIWorkerAgentTypeDirty()) {
            return null;
        }
        String string = pSSysAIWorkerAgent.getAIWorkerAgentType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIWORKERAGENTTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIWorkerAgentType_Default(pSSysAIWorkerAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIWORKERAGENTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIWorkerAgent.isCodeNameDirty() : !pSSysAIWorkerAgent.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysAIWorkerAgent.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysAIWorkerAgent, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSSysAIWorkerAgentDEModel(), "CODENAME", string3, pSSysAIWorkerAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIWorkerAgent.isCustomCodeDirty() : !pSSysAIWorkerAgent.isCustomCodeDirty()) {
            return null;
        }
        String string = pSSysAIWorkerAgent.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSSysAIWorkerAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIWorkerAgent.isCustomModeDirty() : !pSSysAIWorkerAgent.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSSysAIWorkerAgent.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default(pSSysAIWorkerAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIWorkerAgent.isMemoDirty() : !pSSysAIWorkerAgent.isMemoDirty()) {
            return null;
        }
        String string = pSSysAIWorkerAgent.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysAIWorkerAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIWorkerAgent.isPSDEIdDirty() : !pSSysAIWorkerAgent.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysAIWorkerAgent.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSSysAIWorkerAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIWorkerAgent.isPSDENameDirty() : !pSSysAIWorkerAgent.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysAIWorkerAgent.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSSysAIWorkerAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAIFactoryId(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIWorkerAgent.isPSSysAIFactoryIdDirty() : !pSSysAIWorkerAgent.isPSSysAIFactoryIdDirty()) {
            return null;
        }
        String string = pSSysAIWorkerAgent.getPSSysAIFactoryId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIFactoryId_Default(pSSysAIWorkerAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAIWorkerAgentId(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIWorkerAgent.isPSSysAIWorkerAgentIdDirty() && !bl2 : !pSSysAIWorkerAgent.isPSSysAIWorkerAgentIdDirty()) {
            return null;
        }
        String string = pSSysAIWorkerAgent.getPSSysAIWorkerAgentId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIWORKERAGENTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIWorkerAgentId_Default(pSSysAIWorkerAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAIWorkerAgentName(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIWorkerAgent.isPSSysAIWorkerAgentNameDirty() && !bl2 : !pSSysAIWorkerAgent.isPSSysAIWorkerAgentNameDirty()) {
            return null;
        }
        String string = pSSysAIWorkerAgent.getPSSysAIWorkerAgentName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIWORKERAGENTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIWorkerAgentName_Default(pSSysAIWorkerAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAIWORKERAGENTNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSSysAIWorkerAgentDEModel(), "PSSYSAIWORKERAGENTNAME", string3, pSSysAIWorkerAgent, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSAIWORKERAGENTNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIWorkerAgent.isPSSysSFPluginIdDirty() : !pSSysAIWorkerAgent.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysAIWorkerAgent.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSSysAIWorkerAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIWorkerAgent.isUserCatDirty() : !pSSysAIWorkerAgent.isUserCatDirty()) {
            return null;
        }
        String string = pSSysAIWorkerAgent.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysAIWorkerAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIWorkerAgent.isUserTagDirty() : !pSSysAIWorkerAgent.isUserTagDirty()) {
            return null;
        }
        String string = pSSysAIWorkerAgent.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysAIWorkerAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIWorkerAgent.isUserTag2Dirty() : !pSSysAIWorkerAgent.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysAIWorkerAgent.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysAIWorkerAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIWorkerAgent.isUserTag3Dirty() : !pSSysAIWorkerAgent.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysAIWorkerAgent.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysAIWorkerAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIWorkerAgent.isUserTag4Dirty() : !pSSysAIWorkerAgent.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysAIWorkerAgent.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysAIWorkerAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIWorkerAgent.isValidFlagDirty() && !bl2 : !pSSysAIWorkerAgent.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysAIWorkerAgent.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysAIWorkerAgent, bl2, bl3);
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

    protected void onSyncEntity(PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl) throws Exception {
        super.onSyncEntity(pSSysAIWorkerAgent, bl);
    }

    protected void onSyncIndexEntities(PSSysAIWorkerAgent pSSysAIWorkerAgent, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysAIWorkerAgent, bl);
    }

    public Object getDataContextValue(PSSysAIWorkerAgent pSSysAIWorkerAgent, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysAIWorkerAgent, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysAIWorkerAgent pSSysAIWorkerAgent, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysAIWorkerAgent, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AGENTINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AgentInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIPLATFORMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIPlatformType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIWORKERAGENTPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIWorkerAgentParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIWORKERAGENTTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIWorkerAgentTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIWORKERAGENTTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIWorkerAgentTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIWORKERAGENTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIWorkerAgentType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSAIWORKERAGENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIWorkerAgentId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAIWORKERAGENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIWorkerAgentName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AIWorkerAgentParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AIWORKERAGENTPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIWorkerAgentTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AIWORKERAGENTTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIWorkerAgentTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AIWORKERAGENTTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIWorkerAgentType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AIWORKERAGENTTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysAIWorkerAgent)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysAIWorkerAgent pSSysAIWorkerAgent) throws Exception {
        super.onUpdateParent(pSSysAIWorkerAgent);
    }

    @Override
    protected void exportCurXmlModel(PSSysAIWorkerAgent pSSysAIWorkerAgent, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSAIWORKERAGENT");
        if (!bl) {
            pSSysAIWorkerAgent.setCreateDate(null);
            pSSysAIWorkerAgent.setCreateMan(null);
            pSSysAIWorkerAgent.setPSSysAIWorkerAgentId(null);
            pSSysAIWorkerAgent.setUpdateDate(null);
            pSSysAIWorkerAgent.setUpdateMan(null);
            super.exportCurXmlModel(pSSysAIWorkerAgent, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysAIWorkerAgent pSSysAIWorkerAgent, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysAIWorkerAgent, string);
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
            return "DER1N_PSSYSAIWORKERAGENT_PSSYSAIFACTORY_PSSYSAIFACTORYID";
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
    public String getModelV2Tag(PSSysAIWorkerAgent pSSysAIWorkerAgent) {
        if (!StringHelper.isNullOrEmpty((String)pSSysAIWorkerAgent.getCodeName())) {
            return pSSysAIWorkerAgent.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysAIWorkerAgent.getPSSysAIWorkerAgentName())) {
            return pSSysAIWorkerAgent.getPSSysAIWorkerAgentName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysAIWorkerAgent.getCodeName())) {
            return pSSysAIWorkerAgent.getCodeName();
        }
        return super.getModelV2Tag(pSSysAIWorkerAgent);
    }

    @Override
    public boolean setModelV2Tag(PSSysAIWorkerAgent pSSysAIWorkerAgent, String string) {
        pSSysAIWorkerAgent.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSAIWORKERAGENTNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSAIFACTORYID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysAIWorkerAgent pSSysAIWorkerAgent, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysAIWorkerAgent.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysAIWorkerAgent, true);
        pSSysAIWorkerAgent.set("CODENAME", string);
        if (this.select(pSSysAIWorkerAgent, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysAIWorkerAgent, true);
        return super.getModelV2Entity(pSSysAIWorkerAgent, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysAIWorkerAgent pSSysAIWorkerAgent, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysAIWorkerAgent, objectNode, string, string2, n);
    }
}

