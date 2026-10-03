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
import net.ibizsys.pscore.srv.aidesign.dao.PSSysAIChatAgentDAO;
import net.ibizsys.pscore.srv.aidesign.demodel.PSSysAIChatAgentDEModel;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIChatAgent;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIFactory;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIFactoryBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeServiceBase;
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

public abstract class PSSysAIChatAgentServiceBase
extends PSCoreSysServiceBase<PSSysAIChatAgent> {
    private static final Log log = LogFactory.getLog(PSSysAIChatAgentServiceBase.class);
    public static final String DATASET_CURAIFACTORY = "CurAIFactory";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysAIChatAgentDEModel pSSysAIChatAgentDEModel;
    private PSSysAIChatAgentDAO pSSysAIChatAgentDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.aidesign.service.PSSysAIChatAgentService";
    }

    public PSSysAIChatAgentDEModel getPSSysAIChatAgentDEModel() {
        if (this.pSSysAIChatAgentDEModel == null) {
            try {
                this.pSSysAIChatAgentDEModel = (PSSysAIChatAgentDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.aidesign.demodel.PSSysAIChatAgentDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysAIChatAgentDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysAIChatAgentDEModel();
    }

    public PSSysAIChatAgentDAO getPSSysAIChatAgentDAO() {
        if (this.pSSysAIChatAgentDAO == null) {
            try {
                this.pSSysAIChatAgentDAO = (PSSysAIChatAgentDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.aidesign.dao.PSSysAIChatAgentDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysAIChatAgentDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysAIChatAgentDAO();
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

    protected void onFillParentInfo(PSSysAIChatAgent pSSysAIChatAgent, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAICHATAGENT_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysAIChatAgent, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAICHATAGENT_PSSYSAIFACTORY_PSSYSAIFACTORYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.aidesign.service.PSSysAIFactoryService", (SessionFactory)this.getSessionFactory());
            PSSysAIFactory pSSysAIFactory = (PSSysAIFactory)iService.getDEModel().createEntity();
            pSSysAIFactory.set("PSSYSAIFACTORYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysAIFactory);
            } else {
                iService.get(pSSysAIFactory);
            }
            this.onFillParentInfo_PSSysAIFactory(pSSysAIChatAgent, pSSysAIFactory);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAICHATAGENT_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSSysAIChatAgent, pSSysSFPlugin);
            return;
        }
        super.onFillParentInfo(pSSysAIChatAgent, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysAIChatAgent pSSysAIChatAgent, PSDataEntity pSDataEntity) throws Exception {
        pSSysAIChatAgent.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysAIChatAgent.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSSysAIFactory(PSSysAIChatAgent pSSysAIChatAgent, PSSysAIFactory pSSysAIFactory) throws Exception {
        pSSysAIChatAgent.setPSSysAIFactoryId(pSSysAIFactory.getPSSysAIFactoryId());
        pSSysAIChatAgent.setPSSysAIFactoryName(pSSysAIFactory.getPSSysAIFactoryName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSSysAIChatAgent pSSysAIChatAgent, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSysAIChatAgent.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSysAIChatAgent.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillEntityFullInfo(PSSysAIChatAgent pSSysAIChatAgent, boolean bl) throws Exception {
        if (bl && pSSysAIChatAgent.getValidFlag() == null) {
            pSSysAIChatAgent.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSysAIChatAgent, bl);
        this.onFillEntityFullInfo_PSDE(pSSysAIChatAgent, bl);
        this.onFillEntityFullInfo_PSSysAIFactory(pSSysAIChatAgent, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSSysAIChatAgent, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysAIChatAgent pSSysAIChatAgent, boolean bl) throws Exception {
        if (pSSysAIChatAgent.isPSDEIdDirty()) {
            if (pSSysAIChatAgent.getPSDEId() != null) {
                if (pSSysAIChatAgent.getPSDEId() == null || pSSysAIChatAgent.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysAIChatAgent.getPSDE();
                    pSSysAIChatAgent.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysAIChatAgent.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysAIFactory(PSSysAIChatAgent pSSysAIChatAgent, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSSysAIChatAgent pSSysAIChatAgent, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysAIChatAgent pSSysAIChatAgent, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysAIChatAgent, bl);
    }

    public ArrayList<PSSysAIChatAgent> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysAIChatAgent> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysAIChatAgent> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysAIChatAgent> selectByPSSysAIFactory(PSSysAIFactoryBase pSSysAIFactoryBase) throws Exception {
        return this.selectByPSSysAIFactory(pSSysAIFactoryBase, "", -1);
    }

    public ArrayList<PSSysAIChatAgent> selectByPSSysAIFactory(PSSysAIFactoryBase pSSysAIFactoryBase, String string) throws Exception {
        return this.selectByPSSysAIFactory(pSSysAIFactoryBase, string, -1);
    }

    public ArrayList<PSSysAIChatAgent> selectByPSSysAIFactory(PSSysAIFactoryBase pSSysAIFactoryBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysAIChatAgent> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSysAIChatAgent> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSysAIChatAgent> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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
        ArrayList<PSSysAIChatAgent> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAICHATAGENT_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSAICHATAGENT", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysAIChatAgent> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysAIChatAgent pSSysAIChatAgent : arrayList) {
            PSSysAIChatAgent pSSysAIChatAgent2 = (PSSysAIChatAgent)this.getDEModel().createEntity();
            pSSysAIChatAgent2.setPSSysAIChatAgentId(pSSysAIChatAgent.getPSSysAIChatAgentId());
            pSSysAIChatAgent2.setPSDEId(null);
            this.update(pSSysAIChatAgent2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAIChatAgentServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysAIChatAgentServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysAIChatAgentServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysAIChatAgent> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysAIChatAgent pSSysAIChatAgent : arrayList) {
            this.remove(pSSysAIChatAgent);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysAIChatAgent> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysAIChatAgent> arrayList) throws Exception {
    }

    public void testRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        ArrayList<PSSysAIChatAgent> arrayList = this.selectByPSSysAIFactory(pSSysAIFactory, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAIFACTORY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysAIFactory);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAICHATAGENT_PSSYSAIFACTORY_PSSYSAIFACTORYID", "", iDataEntityModel.getName(), "PSSYSAICHATAGENT", iDataEntityModel.getDataInfo(pSSysAIFactory), arrayList.get(0)));
        }
    }

    public void resetPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        ArrayList<PSSysAIChatAgent> arrayList = this.selectByPSSysAIFactory(pSSysAIFactory);
        for (PSSysAIChatAgent pSSysAIChatAgent : arrayList) {
            PSSysAIChatAgent pSSysAIChatAgent2 = (PSSysAIChatAgent)this.getDEModel().createEntity();
            pSSysAIChatAgent2.setPSSysAIChatAgentId(pSSysAIChatAgent.getPSSysAIChatAgentId());
            pSSysAIChatAgent2.setPSSysAIFactoryId(null);
            this.update(pSSysAIChatAgent2);
        }
    }

    public void removeByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        final PSSysAIFactory pSSysAIFactory2 = pSSysAIFactory;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAIChatAgentServiceBase.this.onBeforeRemoveByPSSysAIFactory(pSSysAIFactory2);
                PSSysAIChatAgentServiceBase.this.internalRemoveByPSSysAIFactory(pSSysAIFactory2);
                PSSysAIChatAgentServiceBase.this.onAfterRemoveByPSSysAIFactory(pSSysAIFactory2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
    }

    protected void internalRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
        ArrayList<PSSysAIChatAgent> arrayList = this.selectByPSSysAIFactory(pSSysAIFactory);
        this.onBeforeRemoveByPSSysAIFactory(pSSysAIFactory, arrayList);
        for (PSSysAIChatAgent pSSysAIChatAgent : arrayList) {
            this.remove(pSSysAIChatAgent);
        }
        this.onAfterRemoveByPSSysAIFactory(pSSysAIFactory, arrayList);
    }

    protected void onAfterRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory) throws Exception {
    }

    protected void onBeforeRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory, ArrayList<PSSysAIChatAgent> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysAIFactory(PSSysAIFactory pSSysAIFactory, ArrayList<PSSysAIChatAgent> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysAIChatAgent> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAICHATAGENT_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSYSAICHATAGENT", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysAIChatAgent> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSSysAIChatAgent pSSysAIChatAgent : arrayList) {
            PSSysAIChatAgent pSSysAIChatAgent2 = (PSSysAIChatAgent)this.getDEModel().createEntity();
            pSSysAIChatAgent2.setPSSysAIChatAgentId(pSSysAIChatAgent.getPSSysAIChatAgentId());
            pSSysAIChatAgent2.setPSSysSFPluginId(null);
            this.update(pSSysAIChatAgent2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAIChatAgentServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysAIChatAgentServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysAIChatAgentServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysAIChatAgent> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSysAIChatAgent pSSysAIChatAgent : arrayList) {
            this.remove(pSSysAIChatAgent);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysAIChatAgent> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysAIChatAgent> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysAIChatAgent pSSysAIChatAgent) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEACModeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysAIChatAgent(pSSysAIChatAgent);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysAIChatAgent(pSSysAIChatAgent);
        super.onBeforeRemove(pSSysAIChatAgent);
    }

    protected void replaceParentInfo(PSSysAIChatAgent pSSysAIChatAgent, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysAIChatAgent, cloneSession);
        if (pSSysAIChatAgent.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysAIChatAgent.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysAIChatAgent, (PSDataEntity)iEntity);
        }
        if (pSSysAIChatAgent.getPSSysAIFactoryId() != null && (iEntity = cloneSession.getEntity("PSSYSAIFACTORY", (Object)pSSysAIChatAgent.getPSSysAIFactoryId())) != null) {
            this.onFillParentInfo_PSSysAIFactory(pSSysAIChatAgent, (PSSysAIFactory)iEntity);
        }
        if (pSSysAIChatAgent.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSysAIChatAgent.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSSysAIChatAgent, (PSSysSFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysAIChatAgent pSSysAIChatAgent, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysAIChatAgent, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AgentInfo(bl, pSSysAIChatAgent, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIChatAgentParams(bl, pSSysAIChatAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIChatAgentTag(bl, pSSysAIChatAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIChatAgentTag2(bl, pSSysAIChatAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIChatAgentType(bl, pSSysAIChatAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIPlatformType(bl, pSSysAIChatAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysAIChatAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSSysAIChatAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSSysAIChatAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysAIChatAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PromptSource(bl, pSSysAIChatAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysAIChatAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysAIChatAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIChatAgentId(bl, pSSysAIChatAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIChatAgentName(bl, pSSysAIChatAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAIFactoryId(bl, pSSysAIChatAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSysAIChatAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysAIChatAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysAIChatAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysAIChatAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysAIChatAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysAIChatAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysAIChatAgent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysAIChatAgent, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AgentInfo(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isAgentInfoDirty() : !pSSysAIChatAgent.isAgentInfoDirty()) {
            return null;
        }
        String string = pSSysAIChatAgent.getAgentInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AgentInfo_Default(pSSysAIChatAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_AIChatAgentParams(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isAIChatAgentParamsDirty() : !pSSysAIChatAgent.isAIChatAgentParamsDirty()) {
            return null;
        }
        String string = pSSysAIChatAgent.getAIChatAgentParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIChatAgentParams_Default(pSSysAIChatAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AICHATAGENTPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIChatAgentTag(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isAIChatAgentTagDirty() : !pSSysAIChatAgent.isAIChatAgentTagDirty()) {
            return null;
        }
        String string = pSSysAIChatAgent.getAIChatAgentTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIChatAgentTag_Default(pSSysAIChatAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AICHATAGENTTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIChatAgentTag2(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isAIChatAgentTag2Dirty() : !pSSysAIChatAgent.isAIChatAgentTag2Dirty()) {
            return null;
        }
        String string = pSSysAIChatAgent.getAIChatAgentTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIChatAgentTag2_Default(pSSysAIChatAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AICHATAGENTTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIChatAgentType(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isAIChatAgentTypeDirty() && !bl2 : !pSSysAIChatAgent.isAIChatAgentTypeDirty()) {
            return null;
        }
        String string = pSSysAIChatAgent.getAIChatAgentType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AICHATAGENTTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIChatAgentType_Default(pSSysAIChatAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AICHATAGENTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIPlatformType(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isAIPlatformTypeDirty() : !pSSysAIChatAgent.isAIPlatformTypeDirty()) {
            return null;
        }
        String string = pSSysAIChatAgent.getAIPlatformType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIPlatformType_Default(pSSysAIChatAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isCodeNameDirty() && !bl2 : !pSSysAIChatAgent.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysAIChatAgent.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysAIChatAgent, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSSysAIChatAgentDEModel(), "CODENAME", string3, pSSysAIChatAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isCustomCodeDirty() : !pSSysAIChatAgent.isCustomCodeDirty()) {
            return null;
        }
        String string = pSSysAIChatAgent.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSSysAIChatAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isCustomModeDirty() : !pSSysAIChatAgent.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSSysAIChatAgent.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default(pSSysAIChatAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isMemoDirty() : !pSSysAIChatAgent.isMemoDirty()) {
            return null;
        }
        String string = pSSysAIChatAgent.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysAIChatAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_PromptSource(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isPromptSourceDirty() : !pSSysAIChatAgent.isPromptSourceDirty()) {
            return null;
        }
        String string = pSSysAIChatAgent.getPromptSource();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PromptSource_Default(pSSysAIChatAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROMPTSOURCE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isPSDEIdDirty() : !pSSysAIChatAgent.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysAIChatAgent.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSSysAIChatAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isPSDENameDirty() : !pSSysAIChatAgent.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysAIChatAgent.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSSysAIChatAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAIChatAgentId(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isPSSysAIChatAgentIdDirty() && !bl2 : !pSSysAIChatAgent.isPSSysAIChatAgentIdDirty()) {
            return null;
        }
        String string = pSSysAIChatAgent.getPSSysAIChatAgentId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAICHATAGENTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIChatAgentId_Default(pSSysAIChatAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAICHATAGENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAIChatAgentName(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isPSSysAIChatAgentNameDirty() && !bl2 : !pSSysAIChatAgent.isPSSysAIChatAgentNameDirty()) {
            return null;
        }
        String string = pSSysAIChatAgent.getPSSysAIChatAgentName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAICHATAGENTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIChatAgentName_Default(pSSysAIChatAgent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAICHATAGENTNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSSysAIChatAgentDEModel(), "PSSYSAICHATAGENTNAME", string3, pSSysAIChatAgent, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSAICHATAGENTNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAIFactoryId(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isPSSysAIFactoryIdDirty() : !pSSysAIChatAgent.isPSSysAIFactoryIdDirty()) {
            return null;
        }
        String string = pSSysAIChatAgent.getPSSysAIFactoryId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAIFactoryId_Default(pSSysAIChatAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isPSSysSFPluginIdDirty() : !pSSysAIChatAgent.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysAIChatAgent.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSSysAIChatAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isUserCatDirty() : !pSSysAIChatAgent.isUserCatDirty()) {
            return null;
        }
        String string = pSSysAIChatAgent.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysAIChatAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isUserTagDirty() : !pSSysAIChatAgent.isUserTagDirty()) {
            return null;
        }
        String string = pSSysAIChatAgent.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysAIChatAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isUserTag2Dirty() : !pSSysAIChatAgent.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysAIChatAgent.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysAIChatAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isUserTag3Dirty() : !pSSysAIChatAgent.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysAIChatAgent.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysAIChatAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isUserTag4Dirty() : !pSSysAIChatAgent.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysAIChatAgent.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysAIChatAgent, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysAIChatAgent pSSysAIChatAgent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysAIChatAgent.isValidFlagDirty() && !bl2 : !pSSysAIChatAgent.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysAIChatAgent.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysAIChatAgent, bl2, bl3);
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

    protected void onSyncEntity(PSSysAIChatAgent pSSysAIChatAgent, boolean bl) throws Exception {
        super.onSyncEntity(pSSysAIChatAgent, bl);
    }

    protected void onSyncIndexEntities(PSSysAIChatAgent pSSysAIChatAgent, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysAIChatAgent, bl);
    }

    public Object getDataContextValue(PSSysAIChatAgent pSSysAIChatAgent, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysAIChatAgent, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysAIChatAgent pSSysAIChatAgent, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysAIChatAgent, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AGENTINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AgentInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AICHATAGENTPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIChatAgentParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AICHATAGENTTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIChatAgentTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AICHATAGENTTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIChatAgentTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AICHATAGENTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIChatAgentType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PROMPTSOURCE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PromptSource_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAICHATAGENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIChatAgentId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAICHATAGENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIChatAgentName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAIFACTORYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIFactoryId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAIFACTORYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAIFactoryName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AIChatAgentParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AICHATAGENTPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIChatAgentTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AICHATAGENTTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIChatAgentTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AICHATAGENTTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIChatAgentType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AICHATAGENTTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
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

    protected String onTestValueRule_PromptSource_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROMPTSOURCE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_PSSysAIChatAgentId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAICHATAGENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAIChatAgentName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAICHATAGENTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected boolean onMergeChild(String string, String string2, PSSysAIChatAgent pSSysAIChatAgent) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysAIChatAgent)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysAIChatAgent pSSysAIChatAgent) throws Exception {
        super.onUpdateParent(pSSysAIChatAgent);
    }

    @Override
    protected void exportCurXmlModel(PSSysAIChatAgent pSSysAIChatAgent, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSAICHATAGENT");
        if (!bl) {
            pSSysAIChatAgent.setCreateDate(null);
            pSSysAIChatAgent.setCreateMan(null);
            pSSysAIChatAgent.setPSSysAIChatAgentId(null);
            pSSysAIChatAgent.setUpdateDate(null);
            pSSysAIChatAgent.setUpdateMan(null);
            super.exportCurXmlModel(pSSysAIChatAgent, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysAIChatAgent pSSysAIChatAgent, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysAIChatAgent, string);
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
            return "DER1N_PSSYSAICHATAGENT_PSSYSAIFACTORY_PSSYSAIFACTORYID";
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
    public String getModelV2Tag(PSSysAIChatAgent pSSysAIChatAgent) {
        if (!StringHelper.isNullOrEmpty((String)pSSysAIChatAgent.getCodeName())) {
            return pSSysAIChatAgent.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysAIChatAgent.getPSSysAIChatAgentName())) {
            return pSSysAIChatAgent.getPSSysAIChatAgentName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysAIChatAgent.getCodeName())) {
            return pSSysAIChatAgent.getCodeName();
        }
        return super.getModelV2Tag(pSSysAIChatAgent);
    }

    @Override
    public boolean setModelV2Tag(PSSysAIChatAgent pSSysAIChatAgent, String string) {
        pSSysAIChatAgent.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSAICHATAGENTNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSAIFACTORYID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysAIChatAgent pSSysAIChatAgent, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysAIChatAgent.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysAIChatAgent, true);
        pSSysAIChatAgent.set("CODENAME", string);
        if (this.select(pSSysAIChatAgent, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysAIChatAgent, true);
        return super.getModelV2Entity(pSSysAIChatAgent, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysAIChatAgent pSSysAIChatAgent, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysAIChatAgent, objectNode, string, string2, n);
    }
}

