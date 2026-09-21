/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDERBase
 *  net.ibizsys.paas.ctrlhandler.ICounterHandler
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.GlobalScopeDictCatCodeListModel
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 *  net.ibizsys.paas.sysmodel.ISystemPlugin
 *  net.ibizsys.paas.sysmodel.UserScopeDictCatCodeListModel
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity
 *  net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBDetail
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfgBase
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysDBDetailService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.JIT.SysModel;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCodePublisher;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataQueryException;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.GITPSSystemDBConfig;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.IPSModelStorage;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.JIT.App.IPSJITAppModel;
import SA.SRFDA.PS.Core.JIT.Core.IPSJITCounterType;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCounterHandler;
import SA.SRFDA.PS.Core.JIT.DEModel.PSJITDEModel;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITCodeListModel;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import SA.SRFDA.PS.Core.JIT.SysModel.PSJITDynamicCodeListModel;
import SA.SRFDA.PS.Core.JIT.SysModel.PSJITStaticCodeListModel;
import SA.SRFDA.PS.Core.JIT.SysModel.PSJITSysOperatorCodeListModel;
import SA.SRFDA.PS.Core.JIT.SysModel.PSJITSystemModelBase;
import SA.SRFDA.PS.Core.JIT.SysModel.PSJITUserScopeDynamicCodeListModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFCustomRoleModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFUserGroupRoleModel;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.PSDBPublishContextImpl;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.PS.Core.Res.IPSSysDictCat;
import SA.SRFDA.PS.Core.WF.IPSWFRole;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.ctrlhandler.ICounterHandler;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.GlobalScopeDictCatCodeListModel;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.sysmodel.ISystemPlugin;
import net.ibizsys.paas.sysmodel.UserScopeDictCatCodeListModel;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBDetail;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfgBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBDetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSJITSystemModel
extends PSJITSystemModelBase
implements IPSJITSystemModel {
    private static final Log log = LogFactory.getLog(PSJITSystemModel.class);
    private HashMap<String, ICodeListModel> codeListMap = new HashMap();
    private HashMap<String, IPSJITAppModel> appModelMap = new HashMap();
    private ISRFDAGlobalHelper iDAGlobalHelper = null;
    private HashMap<String, ICounterHandler> counterHandlerMap = new HashMap();
    private IPSSystem iPSSystem = null;
    private String strJITCodeFolder = null;
    private String strJITWorkshopFolder = null;
    private boolean bPreviewMode = false;

    public boolean init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, boolean bPreviewMode) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSSystem = iPSSystem;
        if (StringHelper.isNullOrEmpty((String)this.iPSSystem.getPSDevSlnSysId())) {
            this.setId(this.iPSSystem.getId());
        } else {
            this.setId(this.iPSSystem.getPSDevSlnSysId());
        }
        this.setName(iPSSystem.getName());
        this.bPreviewMode = bPreviewMode;
        if (!this.isPreviewMode() && this.syncSysDBModel() != 0) {
            return false;
        }
        this.prepareDERs();
        this.prepareCodeLists();
        this.prepareSysCounters();
        this.prepareDataEntities();
        this.prepareWorkflows();
        this.prepareBASchemes();
        if (!this.isPreviewMode()) {
            this.installRTDatas();
        }
        String strJITCodeFolder = PSTaskServerEnvImpl.getCurrent().getJITCodeFolder();
        strJITCodeFolder = String.valueOf(strJITCodeFolder) + StringHelper.format((String)"%1$sJ%2$s", (Object)File.separator, (Object)DateHelper.toDateString((Date)new Date()));
        strJITCodeFolder = String.valueOf(strJITCodeFolder) + StringHelper.format((String)"%1$s%2$s", (Object)File.separator, (Object)KeyValueHelper.genGuidEx());
        File folder = new File(strJITCodeFolder);
        folder.mkdirs();
        this.strJITCodeFolder = strJITCodeFolder;
        String strJITWorkshopFolder = PSTaskServerEnvImpl.getCurrent().getJITCodeFolder();
        strJITWorkshopFolder = String.valueOf(strJITWorkshopFolder) + StringHelper.format((String)"%1$sJITW", (Object)File.separator);
        folder = new File(strJITWorkshopFolder);
        folder.mkdirs();
        this.strJITWorkshopFolder = strJITWorkshopFolder;
        return true;
    }

    public IPSSystem getPSSystem() {
        return this.iPSSystem;
    }

    protected int syncSysDBModel() throws Exception {
        IPSDBDevInst jitPSDBDevInst = this.getPSSystem().getJITPSDBDevInst();
        if (jitPSDBDevInst == null) {
            throw new Exception("\u7cfb\u7edfJIT\u6570\u636e\u6e90\u65e0\u6548");
        }
        PSSystem psSystem = new PSSystem();
        psSystem.setPSSystemId(this.getPSSystem().getId());
        PSSystemDBCfg psSystemDBConfig = new PSSystemDBCfg();
        psSystemDBConfig.setPSSystemId(this.getPSSystem().getId());
        psSystemDBConfig.setPSSystemDBCfgName(jitPSDBDevInst.getDBType());
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.getPSSystem().getPSSysModelInstId());
        PSSystemDBCfgService psSystemDBCfgService = (PSSystemDBCfgService)ServiceGlobal.getService(PSSystemDBCfgService.class, (SessionFactory)sessionFactory);
        if (!psSystemDBCfgService.select((IEntity)psSystemDBConfig, true)) {
            throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u6570\u636e\u6e90\u4e0d\u652f\u6301JIT\u6570\u636e\u6e90\u7c7b\u578b[%1$s]", (Object)jitPSDBDevInst.getDBType()));
        }
        PSDataEntityService psDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)sessionFactory);
        PSSysDBDetailService psSysDBDetailService = (PSSysDBDetailService)ServiceGlobal.getService(PSSysDBDetailService.class, (SessionFactory)sessionFactory);
        ArrayList psDataEntityList = psDataEntityService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList psSysDBDetailList = psSysDBDetailService.selectByPSSystemDBCfg((PSSystemDBCfgBase)psSystemDBConfig);
        HashMap<String, PSDataEntity> psDataEntityMap = new HashMap<String, PSDataEntity>();
        for (PSDataEntity psDataEntity : psDataEntityList) {
            psDataEntityMap.put(psDataEntity.getPSDataEntityId(), psDataEntity);
        }
        for (PSSysDBDetail psSysDBDetail : psSysDBDetailList) {
            PSDataEntity psDataEntity;
            if (!psDataEntityMap.containsKey(psSysDBDetail.getPSDEId()) || DataTypeHelper.compare((int)9, (Object)(psDataEntity = (PSDataEntity)psDataEntityMap.get(psSysDBDetail.getPSDEId())).getDBVer(), (Object)psSysDBDetail.getPubDBVer()) != 0L) continue;
            psDataEntityMap.remove(psSysDBDetail.getPSDEId());
        }
        if (psDataEntityMap.size() == 0) {
            return 0;
        }
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        HashMap<String, IPSDataEntity> psDataEntityMap2 = new HashMap<String, IPSDataEntity>();
        for (PSDataEntity psDataEntity : psDataEntityMap.values()) {
            psDataEntityMap2.put(psDataEntity.getPSDataEntityName(), this.iPSSystem.getPSDataEntity2(psDataEntity.getPSDataEntityName()));
        }
        IPSSystemDBConfig iPSSystemDBConfig = this.iPSSystem.getPSSystemDBConfig(psSystemDBConfig.getPSSystemDBCfgName());
        GITPSSystemDBConfig jitPSSystemDBConfig = null;
        if (jitPSDBDevInst != null && StringHelper.compare((String)iPSSystemDBConfig.getDBType(), (String)jitPSDBDevInst.getDBType(), (boolean)true) == 0 && StringHelper.compare((String)iPSSystemDBConfig.getPSDBDevInstId(), (String)jitPSDBDevInst.getId(), (boolean)false) != 0) {
            GITPSSystemDBConfig psSystemDBConfig2 = new GITPSSystemDBConfig();
            psSystemDBConfig2.init(this.getDAGlobalHelper(), this.iPSSystem);
            jitPSSystemDBConfig = psSystemDBConfig2;
        }
        int nTotalCount = psDataEntityMap.size();
        sBuilderEx.append("[v%1$s]\u540c\u6b65\u6570\u636e\u5e93\u6a21\u578b[%2$s]", (Object)this.iPSSystem.getVersion(), (Object)nTotalCount);
        int nIndex = 0;
        for (PSDataEntity psDataEntity : psDataEntityMap.values()) {
            sBuilderEx.append("\r\n[%1$s]\u540c\u6b65\u5b9e\u4f53\u6a21\u578b[%2$s]", (Object)(nIndex + 1), (Object)psDataEntity.getPSDataEntityName());
            ++nIndex;
            this.onPublishDBModel(iPSSystemDBConfig, (IPSDataEntity)psDataEntityMap2.get(psDataEntity.getPSDataEntityName()));
            if (jitPSSystemDBConfig != null) {
                this.onPublishDBModel(jitPSSystemDBConfig, (IPSDataEntity)psDataEntityMap2.get(psDataEntity.getPSDataEntityName()));
            }
            log.info((Object)StringHelper.format((String)"\u53d1\u5e03\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u6a21\u578b\uff0c%2$s/%3$s", (Object)psDataEntity.getPSDataEntityName(), (Object)nIndex, (Object)nTotalCount));
        }
        nIndex = 0;
        for (PSDataEntity psDataEntity : psDataEntityMap.values()) {
            ++nIndex;
            this.onPublishDBModel2(iPSSystemDBConfig, (IPSDataEntity)psDataEntityMap2.get(psDataEntity.getPSDataEntityName()));
            if (jitPSSystemDBConfig != null) {
                this.onPublishDBModel2(jitPSSystemDBConfig, (IPSDataEntity)psDataEntityMap2.get(psDataEntity.getPSDataEntityName()));
            }
            log.info((Object)StringHelper.format((String)"\u53d1\u5e03\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u6a21\u578b2\uff0c%2$s/%3$s", (Object)psDataEntity.getPSDataEntityName(), (Object)nIndex, (Object)nTotalCount));
            PSSysDBDetail psSysDBDetail = new PSSysDBDetail();
            psSysDBDetail.setPSSysDBDetailName(psDataEntity.getPSDataEntityName());
            psSysDBDetail.setPSDEId(psDataEntity.getPSDataEntityId());
            psSysDBDetail.setPSSystemDBCfgId(psSystemDBConfig.getPSSystemDBCfgId());
            psSysDBDetail.setPubDBVer(psDataEntity.getDBVer());
            psSysDBDetailService.save((IEntity)psSysDBDetail);
        }
        log.debug((Object)sBuilderEx.toString());
        return psDataEntityMap.size();
    }

    protected void onPublishDBModel(IPSSystemDBConfig iPSSystemDBConfig, IPSDataEntity iPSDataEntity) throws Exception {
        IPSDEDBConfig iPSDEDBConfig;
        PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getDAGlobalHelper(), null);
        psPublishContextImpl.setPSSysModelInstId(iPSSystemDBConfig.getPSSysModelInstId());
        IPSDBDevInst iPSDBDevInst = null;
        if (!StringHelper.isNullOrEmpty((String)iPSSystemDBConfig.getPSDBDevInstId())) {
            iPSDBDevInst = this.getPSModelStorage().getPSDBDevInst(iPSSystemDBConfig.getPSDBDevInstId());
        }
        if ((iPSDEDBConfig = iPSDataEntity.getPSDEDBConfig(iPSSystemDBConfig.getName())).isValidFlag() && iPSDEDBConfig.isPubModel()) {
            iPSDEDBConfig.publishDBModel(psPublishContextImpl, iPSDBDevInst);
        }
    }

    protected void onPublishDBModel2(IPSSystemDBConfig iPSSystemDBConfig, IPSDataEntity iPSDataEntity) throws Exception {
        IPSDEDBConfig iPSDEDBConfig;
        PSDBPublishContextImpl psPublishContextImpl = new PSDBPublishContextImpl(this.getDAGlobalHelper(), null);
        psPublishContextImpl.setPSSysModelInstId(iPSSystemDBConfig.getPSSysModelInstId());
        psPublishContextImpl.setPSSystemDBConfig(iPSSystemDBConfig);
        IPSDBDevInst iPSDBDevInst = null;
        if (!StringHelper.isNullOrEmpty((String)iPSSystemDBConfig.getPSDBDevInstId())) {
            iPSDBDevInst = this.getPSModelStorage().getPSDBDevInst(iPSSystemDBConfig.getPSDBDevInstId());
        }
        if ((iPSDEDBConfig = iPSDataEntity.getPSDEDBConfig(iPSSystemDBConfig.getName())).isValidFlag() && iPSDEDBConfig.isPubModel()) {
            iPSDEDBConfig.publishDBModel2(psPublishContextImpl, iPSDBDevInst);
        }
        if (iPSDEDBConfig.isValidFlag()) {
            Iterator<IPSDEDataQuery> psDEDataQueries = iPSDataEntity.getAllPSDEDataQueries();
            while (psDEDataQueries.hasNext()) {
                IPSDEDataQuery iPSDEDataQuery = psDEDataQueries.next();
                IPSDBType iDBType = this.getPSModelStorage().getPSDBType(iPSSystemDBConfig.getName());
                IPSDEDQCodePublisher iPSDEDQCodePublisher = iDBType.getPSDEDQCodePublisher();
                try {
                    iPSDEDQCodePublisher.generateCode(psPublishContextImpl, iPSDEDataQuery);
                    iPSDEDQCodePublisher.close();
                }
                catch (Exception ex) {
                    throw new PSDEDataQueryException(iPSDEDataQuery, 20013, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u6570\u636e\u67e5\u8be2[%2$s]\u53d1\u5e03\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)iPSDEDataQuery.getPSDataEntity().getName(), (Object)iPSDEDataQuery.getName(), (Object)ex.getMessage()));
                }
            }
        }
    }

    protected void prepareDERs() throws Exception {
        Iterator<IPSDERBase> psDERBases = this.getPSSystem().getAllPSDERs();
        while (psDERBases.hasNext()) {
            IPSDERBase iPSDERBase = psDERBases.next();
            IDERBase iDERBase = this.createDERBase(iPSDERBase);
            this.registerDERBase(iDERBase);
        }
    }

    protected void prepareCodeLists() throws Exception {
        Iterator<IPSCodeList> psCodeLists = this.getPSSystem().getAllPSCodeLists();
        while (psCodeLists.hasNext()) {
            IPSJITCodeListModel psJITStaticCodeListModel;
            IPSCodeList iPSCodeList = psCodeLists.next();
            if (StringHelper.compare((String)iPSCodeList.getPredefinedType(), (String)"OPERATOR", (boolean)true) == 0) {
                psJITStaticCodeListModel = new PSJITSysOperatorCodeListModel();
                ((PSJITSysOperatorCodeListModel)psJITStaticCodeListModel).init(this, iPSCodeList);
                continue;
            }
            if (StringHelper.compare((String)iPSCodeList.getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0) {
                if (iPSCodeList.isUserScope()) {
                    PSJITUserScopeDynamicCodeListModel psJITUserScopeDynamicCodeListModel = new PSJITUserScopeDynamicCodeListModel();
                    psJITUserScopeDynamicCodeListModel.init(this, iPSCodeList);
                    continue;
                }
                PSJITDynamicCodeListModel psJITDynamicCodeListModel = new PSJITDynamicCodeListModel();
                psJITDynamicCodeListModel.init(this, iPSCodeList);
                continue;
            }
            psJITStaticCodeListModel = new PSJITStaticCodeListModel();
            ((PSJITStaticCodeListModel)psJITStaticCodeListModel).init(this, iPSCodeList);
        }
        Iterator<IPSSysDictCat> psSysDictCats = this.getPSSystem().getAllPSSysDictCats();
        while (psSysDictCats.hasNext()) {
            IPSSysDictCat iPSSysDictCat = psSysDictCats.next();
            GlobalScopeDictCatCodeListModel globalScopeCodeList = new GlobalScopeDictCatCodeListModel();
            globalScopeCodeList.setOwnerType("GLOBAL");
            globalScopeCodeList.setCat(iPSSysDictCat.getId());
            String strId = KeyValueHelper.genUniqueId((String)"USERDICTCAT", (String)"GLOBAL", (String)iPSSysDictCat.getId());
            globalScopeCodeList.setId(strId);
            globalScopeCodeList.setName(StringHelper.format((String)"\u5168\u5c40\u8bcd\u5178\u5206\u7c7b[%1$s]", (Object)iPSSysDictCat.getName()));
            this.registerCodeListModel((ICodeListModel)globalScopeCodeList);
            UserScopeDictCatCodeListModel userScopeCodeList = new UserScopeDictCatCodeListModel();
            userScopeCodeList.setCat(iPSSysDictCat.getId());
            strId = KeyValueHelper.genUniqueId((String)"USERDICTCAT", (String)"USER", (String)iPSSysDictCat.getId());
            userScopeCodeList.setId(strId);
            userScopeCodeList.setName(StringHelper.format((String)"\u7528\u6237\u8bcd\u5178\u5206\u7c7b[%1$s]", (Object)iPSSysDictCat.getName()));
            this.registerCodeListModel((ICodeListModel)userScopeCodeList);
        }
    }

    protected void prepareSysCounters() throws Exception {
        Iterator<IPSSysCounter> psSysCounters = this.getPSSystem().getAllPSSysCounters();
        while (psSysCounters.hasNext()) {
            IPSSysCounter iPSSysCounter = psSysCounters.next();
            try {
                IPSJITCounterHandler iPSJITCounterHandler = ((IPSJITCounterType)iPSSysCounter.getPSCounterType()).createPSJITConterHandler(iPSSysCounter);
                iPSJITCounterHandler.init(this, iPSSysCounter);
                this.registerCounterHandler(iPSSysCounter.getId(), iPSJITCounterHandler);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format((String)"\u521d\u59cb\u5316\u7cfb\u7edf\u8ba1\u6570\u5668[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)iPSSysCounter.getName(), (Object)ex.getMessage()), (Throwable)ex);
            }
        }
    }

    protected void prepareDataEntities() throws Exception {
        Iterator<IPSDataEntity> psDataEntities = this.getPSSystem().getAllPSDataEntities();
        while (psDataEntities.hasNext()) {
            IPSDataEntity iPSDataEntity = psDataEntities.next();
            PSJITDEModel psJITDEModel = new PSJITDEModel();
            psJITDEModel.init(this, iPSDataEntity);
        }
    }

    protected void prepareServices() throws Exception {
    }

    protected void prepareDAOs() throws Exception {
    }

    protected void prepareWorkflows() throws Exception {
        Iterator<IPSWFRole> psWFRoles = this.getPSSystem().getAllPSWFRoles();
        while (psWFRoles.hasNext()) {
            IPSWFRole iPSWFRole = psWFRoles.next();
            if (StringHelper.compare((String)iPSWFRole.getWFRoleType(), (String)"USERGROUP", (boolean)true) == 0) {
                PSJITWFUserGroupRoleModel psJITWFUserGroupRoleModel = new PSJITWFUserGroupRoleModel();
                psJITWFUserGroupRoleModel.init(this, iPSWFRole);
                continue;
            }
            if (StringHelper.compare((String)iPSWFRole.getWFRoleType(), (String)"CUSTOM", (boolean)true) != 0) continue;
            PSJITWFCustomRoleModel psJITWFCustomRoleModel = new PSJITWFCustomRoleModel();
            psJITWFCustomRoleModel.init(this, iPSWFRole);
        }
        Iterator<IPSWorkflow> psWorkflows = this.getPSSystem().getAllPSWorkflows();
        while (psWorkflows.hasNext()) {
            IPSWorkflow iPSWorkflow = psWorkflows.next();
            PSJITWFModel psJITWFModel = new PSJITWFModel();
            psJITWFModel.init(this, iPSWorkflow);
        }
    }

    protected void prepareBASchemes() throws Exception {
    }

    @Override
    protected void onInstallRTDatas() throws Exception {
        super.onInstallRTDatas();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void registerCodeListModel(ICodeListModel iCodeListModel) {
        HashMap<String, ICodeListModel> hashMap = this.codeListMap;
        synchronized (hashMap) {
            this.codeListMap.put(iCodeListModel.getId(), iCodeListModel);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public ICodeListModel getCodeListModel(String strCodeListId) throws Exception {
        HashMap<String, ICodeListModel> hashMap = this.codeListMap;
        synchronized (hashMap) {
            ICodeListModel iCodeListModel = this.codeListMap.get(strCodeListId);
            if (iCodeListModel == null) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u8868\u6a21\u578b, \u6807\u8bc6\u4e3a[%1$s]", (Object)strCodeListId));
            }
            return iCodeListModel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSJITAppModel getAppModel(IPSApplication iPSApplication) throws Exception {
        HashMap<String, IPSJITAppModel> hashMap = this.appModelMap;
        synchronized (hashMap) {
            IPSJITAppModel iPSJITAppModel = this.appModelMap.get(iPSApplication.getId());
            if (iPSJITAppModel != null) {
                return iPSJITAppModel;
            }
            iPSJITAppModel = iPSApplication.getPSPF().createPSJITAppModel();
            iPSJITAppModel.init(this.getDAGlobalHelper(), this, iPSApplication);
            this.appModelMap.put(iPSApplication.getId(), iPSJITAppModel);
            return iPSJITAppModel;
        }
    }

    @Override
    public IService getService(String strDEName, SessionFactory sessionFactory) throws Exception {
        return this.getDataEntityModel(strDEName).getService();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void registerCounterHandler(String strCounterHandlerClsType, ICounterHandler iCounterHandler) {
        HashMap<String, ICounterHandler> hashMap = this.counterHandlerMap;
        synchronized (hashMap) {
            this.counterHandlerMap.put(strCounterHandlerClsType, iCounterHandler);
        }
    }

    @Override
    public ICounterHandler getCounterHandler(Class cls) throws Exception {
        return this.getCounterHandler(cls.getCanonicalName());
    }

    @Override
    public ICounterHandler getCounterHandler(String strCounterHandlerClsType) throws Exception {
        return this.internalGetCounterHandler(strCounterHandlerClsType);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ICounterHandler internalGetCounterHandler(String strCounterHandlerClsType) throws Exception {
        HashMap<String, ICounterHandler> hashMap = this.counterHandlerMap;
        synchronized (hashMap) {
            ICounterHandler iCounterHandler = this.counterHandlerMap.get(strCounterHandlerClsType);
            return iCounterHandler;
        }
    }

    public void setSystemPlugin(ISystemPlugin iSystemPlugin) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public void setSystemPlugin(ISystemPlugin iSystemPlugin, boolean bIgnoreOrigin) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public ISystemPlugin getSystemPlugin() {
        return null;
    }

    public ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    public void setDAGlobalHelper(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    protected IPSModelStorage getPSModelStorage() throws Exception {
        return PSObjectFactory.getPSModelStorage(this.iDAGlobalHelper);
    }

    @Override
    public String getJITCodeFolder() {
        return this.strJITCodeFolder;
    }

    @Override
    public String getJITWorkshopFolder() {
        return this.strJITWorkshopFolder;
    }

    @Override
    public boolean isPreviewMode() {
        return this.bPreviewMode;
    }
}

