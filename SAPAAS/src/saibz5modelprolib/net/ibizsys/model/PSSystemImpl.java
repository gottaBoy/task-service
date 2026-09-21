/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSDepSlnSys
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.app.IPSApplication
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.counter.IPSSysCounter
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.priv.IPSDEOPPriv
 *  net.ibizsys.model.dataentity.uiaction.IPSDEUIAction
 *  net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup
 *  net.ibizsys.model.der.IPSDERBase
 *  net.ibizsys.model.dynasys.IPSDynaInst
 *  net.ibizsys.model.res.IPSLanguageItem
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.model.res.IPSSysCss
 *  net.ibizsys.model.res.IPSSysDBValueFunc
 *  net.ibizsys.model.res.IPSSysEditorStyle
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.model.res.IPSSysLan
 *  net.ibizsys.model.res.IPSSysPDTView
 *  net.ibizsys.model.res.IPSSysPortlet
 *  net.ibizsys.model.security.IPSSysUniRes
 *  net.ibizsys.model.valuerule.IPSSysValueRule
 *  net.ibizsys.model.wf.IPSWFRole
 *  net.ibizsys.model.wf.IPSWorkflow
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.IDERBase
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import net.ibizsys.model.IPSDepSlnSys;
import net.ibizsys.model.IPSModelQueryHelper;
import net.ibizsys.model.IPSModelQueryHelperContainer;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSysEngineConfig;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.IPSSystemContainer;
import net.ibizsys.model.IPSSystemRuntime;
import net.ibizsys.model.IPSSystemSetting;
import net.ibizsys.model.PSModelQueryHelperFactory;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.PSSystemException;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.PSApplicationGlobalModel;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.codelist.PSCodeListGlobalModel;
import net.ibizsys.model.control.ajax.PSSysAjaxControlHandlerGlobalModel;
import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.model.control.counter.PSSysCounterGlobalModel;
import net.ibizsys.model.database.PSSysDBValueFuncGlobalModel;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.IPSDataEntityRuntime;
import net.ibizsys.model.dataentity.PSDataEntityImpl;
import net.ibizsys.model.dataentity.field.IPSDEFieldType;
import net.ibizsys.model.dataentity.field.PSSysDEFTypeGlobalModel;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.model.dataentity.priv.PSDEOPPrivGlobalModel;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIAction;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup;
import net.ibizsys.model.dataentity.uiaction.PSSysDEUIActionGlobalModel;
import net.ibizsys.model.dataentity.uiaction.PSSysDEUIActionGroupGlobalModel;
import net.ibizsys.model.der.IPSDERBase;
import net.ibizsys.model.der.PSDERGlobalModel;
import net.ibizsys.model.dynasys.IPSDynaInst;
import net.ibizsys.model.dynasys.PSDynaInstGlobalModel;
import net.ibizsys.model.entity.PSACHandler;
import net.ibizsys.model.entity.PSDEField;
import net.ibizsys.model.entity.PSDataEntity;
import net.ibizsys.model.entity.PSDynaInst;
import net.ibizsys.model.entity.PSSystem;
import net.ibizsys.model.res.IPSLanguageItem;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysDBValueFunc;
import net.ibizsys.model.res.IPSSysEditorStyle;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.model.res.IPSSysLan;
import net.ibizsys.model.res.IPSSysPDTView;
import net.ibizsys.model.res.IPSSysPFPlugin;
import net.ibizsys.model.res.IPSSysPFPluginTempl;
import net.ibizsys.model.res.IPSSysPortlet;
import net.ibizsys.model.res.PSLanguageItemGlobalModel;
import net.ibizsys.model.res.PSLanguageResGlobalModel;
import net.ibizsys.model.res.PSSysCssGlobalModel;
import net.ibizsys.model.res.PSSysEditorStyleGlobalModel;
import net.ibizsys.model.res.PSSysImageGlobalModel;
import net.ibizsys.model.res.PSSysLanGlobalModel;
import net.ibizsys.model.res.PSSysPDTViewGlobalModel;
import net.ibizsys.model.res.PSSysPFPluginGlobalModel;
import net.ibizsys.model.res.PSSysPFPluginTemplGlobalModel;
import net.ibizsys.model.res.PSSysPortletGlobalModel;
import net.ibizsys.model.security.IPSSysUniRes;
import net.ibizsys.model.security.PSSysUniResGlobalModel;
import net.ibizsys.model.valuerule.IPSSysValueRule;
import net.ibizsys.model.valuerule.PSSysValueRuleGlobalModel;
import net.ibizsys.model.wf.IPSWFRole;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.model.wf.PSWFRoleGlobalModel;
import net.ibizsys.model.wf.PSWorkflowGlobalModel;
import net.ibizsys.model.zookeeper.PSModelEntityKeeperGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSystemImpl
extends PSObjectImpl
implements IPSSystem,
IPSSystemSetting,
IPSSystemRuntime {
    private static final Log log = LogFactory.getLog(PSSystemImpl.class);
    protected PSSystem psSystem = null;
    protected PSCodeListGlobalModel psCodeListGlobalModel = new PSCodeListGlobalModel();
    protected PSSysImageGlobalModel psSysImageGlobalModel = new PSSysImageGlobalModel();
    protected PSSysCssGlobalModel psSysCssGlobalModel = new PSSysCssGlobalModel();
    protected PSSysDEFTypeGlobalModel psSysDEFTypeGlobalModel = new PSSysDEFTypeGlobalModel();
    protected PSSysLanGlobalModel psSysLanGlobalModel = new PSSysLanGlobalModel();
    protected PSLanguageResGlobalModel psLanguageResGlobalModel = new PSLanguageResGlobalModel();
    protected PSLanguageItemGlobalModel psLanguageItemGlobalModel = new PSLanguageItemGlobalModel();
    protected PSSysValueRuleGlobalModel psSysValueRuleGlobalModel = new PSSysValueRuleGlobalModel();
    protected PSSysPortletGlobalModel psSysPortletGlobalModel = new PSSysPortletGlobalModel();
    protected PSSysPDTViewGlobalModel psSysPDTViewGlobalModel = new PSSysPDTViewGlobalModel();
    protected PSApplicationGlobalModel psSystemApplicationGlobalModel = new PSApplicationGlobalModel();
    protected PSSysDEUIActionGlobalModel psSysDEUIActionGlobalModel = new PSSysDEUIActionGlobalModel();
    protected PSSysDEUIActionGroupGlobalModel psSysDEUIActionGroupGlobalModel = new PSSysDEUIActionGroupGlobalModel();
    protected PSSysAjaxControlHandlerGlobalModel psSysAjaxControlHandlerGlobalModel = new PSSysAjaxControlHandlerGlobalModel();
    protected PSWorkflowGlobalModel psWorkflowGlobalModel = new PSWorkflowGlobalModel();
    protected PSWFRoleGlobalModel psWFRoleGlobalModel = new PSWFRoleGlobalModel();
    protected PSSysUniResGlobalModel psSysUniResGlobalModel = new PSSysUniResGlobalModel();
    protected PSSysPFPluginGlobalModel psSysPFPluginGlobalModel = new PSSysPFPluginGlobalModel();
    protected PSSysPFPluginTemplGlobalModel psSysPFPluginTemplGlobalModel = new PSSysPFPluginTemplGlobalModel();
    protected PSSysCounterGlobalModel psSysCounterGlobalModel = new PSSysCounterGlobalModel();
    protected PSSysEditorStyleGlobalModel psSysEditorStyleGlobalModel = new PSSysEditorStyleGlobalModel();
    private final Hashtable<String, IPSDataEntity> psDataEntityMap = new Hashtable();
    private final Hashtable<String, Long> psDataEntityRenewMap = new Hashtable();
    protected PSDEOPPrivGlobalModel psDEOPPrivGlobalModel = new PSDEOPPrivGlobalModel();
    protected ArrayList<String> supportDBTypeList = new ArrayList();
    private PSDERGlobalModel psDERGlobalModel = new PSDERGlobalModel();
    private PSSysDBValueFuncGlobalModel psSysDBValueFuncGlobalModel = new PSSysDBValueFuncGlobalModel();
    protected PSDynaInstGlobalModel psDynaInstGlobalModel = new PSDynaInstGlobalModel();
    protected ArrayList<IPSDataEntity> allPSDataEntityList = null;
    private HashMap<String, IPSSysEditorStyle> defaultPSSysEditorStyleMap = new HashMap();
    private int nLoadedLevel = IPSSystemRuntime.LOADLEVEL_NONE;
    private int nLoadingLevel = IPSSystemRuntime.LOADLEVEL_NONE;
    private IPSDepSlnSys iPSDepSlnSys = null;
    private String strPubSystemId = null;
    private String strVCName = null;
    private String strCodeName = "";
    private int nEngineVer = 0;
    private String strSystemLogFilePath = "";
    private File sysLogFile = null;
    private String strDEFieldSortMode = "NAME";
    private boolean bEnableMultiLan = false;
    private String strDefaultLanguageId = "ZH_CN";
    private String strCLEmptyText = null;
    private String strCLEmptyTextPSLanguageResId = null;
    private IPSSysEngineConfig iPSSysEngineConfig = null;
    private int nDEDataExpMaxRowCount = 1000;
    private long nLastActiveTime = 0L;
    private long nLastDBActiveTime = 0L;
    private int nCheckModelVer = 0;
    private boolean bChecking = false;
    private boolean bNoViewMode = false;
    private boolean bLoading = false;
    private int nServiceAPIMode = 0;
    private int nDataAccCtrlArch = 1;
    private int nEngineBugFixs = 0;
    private int nDEFSFItemWidth = -1;
    private String strDefaultValueFormat = "%1$s";
    private boolean bPubDBModel = true;
    private boolean bEnableDBValueInsertUpdateMode = false;
    private int nDBVersion = 0;
    private boolean bEnableDynaSys = false;
    private int nModelVersion = 0;
    private PSModelEntityKeeperGlobal psModelEntityKeeperGlobal = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystemContainer iPSSystemContainer, PSSystem psSystem) throws Exception {
        String[] dbTypes;
        if (iPSSystemContainer instanceof IPSDepSlnSys) {
            this.iPSDepSlnSys = (IPSDepSlnSys)iPSSystemContainer;
        }
        this.psSystem = psSystem;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psSystem.getPSSYSTEMID());
        this.setName(psSystem.getPSSYSTEMNAME());
        this.setVersion(psSystem.getMODELVER());
        if (!this.psSystem.isDBVERSIONNull()) {
            this.nDBVersion = this.psSystem.getDBVERSION();
        }
        if (!this.psSystem.isCHECKMODELVERNull()) {
            this.nCheckModelVer = this.psSystem.getCHECKMODELVER();
        }
        this.setPSObjectData(this.psSystem);
        if (!StringHelper.isNullOrEmpty((String)this.psSystem.getDEFSORTMODE())) {
            this.strDEFieldSortMode = this.psSystem.getDEFSORTMODE();
        }
        if (!this.psSystem.isDEEXPMAXROWCNTNull()) {
            this.nDEDataExpMaxRowCount = this.psSystem.getDEEXPMAXROWCNT();
            if (this.nDEDataExpMaxRowCount < -1) {
                this.nDEDataExpMaxRowCount = 1000;
            }
        }
        if (!this.psSystem.isNOVIEWMODENull()) {
            this.bNoViewMode = this.psSystem.getNOVIEWMODE();
        }
        if (!this.psSystem.isACCCTRLARCHNull()) {
            this.nDataAccCtrlArch = this.psSystem.getACCCTRLARCH();
        }
        if (!this.psSystem.isBUGFIXSNull()) {
            this.nEngineBugFixs = this.psSystem.getBUGFIXS();
        }
        if (!this.psSystem.isDEFSFITEMWIDTHNull()) {
            this.nDEFSFItemWidth = this.psSystem.getDEFSFITEMWIDTH();
        }
        if (!this.psSystem.isPUBDBMODELFLAGNull()) {
            this.bPubDBModel = this.psSystem.getPUBDBMODELFLAG();
        }
        if (!this.psSystem.isENABLEDBVALUEMODENull()) {
            this.bEnableDBValueInsertUpdateMode = this.psSystem.getENABLEDBVALUEMODE();
        }
        if (!this.psSystem.isENABLEDYNASYSNull()) {
            this.bEnableDynaSys = this.psSystem.getENABLEDYNASYS();
        }
        this.psSysEditorStyleGlobalModel.init(iPSModelStorageContext, this);
        this.psSysUniResGlobalModel.init(iPSModelStorageContext, this);
        this.psCodeListGlobalModel.init(iPSModelStorageContext, this);
        this.psSysImageGlobalModel.init(iPSModelStorageContext, this);
        this.psSysCssGlobalModel.init(iPSModelStorageContext, this);
        this.psSysDEFTypeGlobalModel.init(iPSModelStorageContext, this);
        this.psLanguageResGlobalModel.init(iPSModelStorageContext, this);
        this.psLanguageItemGlobalModel.init(iPSModelStorageContext, this);
        this.psSysValueRuleGlobalModel.init(iPSModelStorageContext, this);
        this.psSystemApplicationGlobalModel.init(iPSModelStorageContext, this);
        this.psSysDEUIActionGlobalModel.init(iPSModelStorageContext, this);
        this.psSysDEUIActionGroupGlobalModel.init(iPSModelStorageContext, this);
        this.psDERGlobalModel.init(iPSModelStorageContext, this);
        this.psSysDBValueFuncGlobalModel.init(iPSModelStorageContext, this);
        this.psSysAjaxControlHandlerGlobalModel.init(iPSModelStorageContext, this);
        this.psWorkflowGlobalModel.init(iPSModelStorageContext, this);
        this.psWFRoleGlobalModel.init(iPSModelStorageContext, this);
        this.psSysPortletGlobalModel.init(iPSModelStorageContext, this);
        this.psSysPDTViewGlobalModel.init(iPSModelStorageContext, this);
        this.psSysCounterGlobalModel.init(iPSModelStorageContext, this);
        this.psDEOPPrivGlobalModel.init(this.getPSModelStorageContext(), this);
        this.psSysPFPluginTemplGlobalModel.init(iPSModelStorageContext, this);
        this.psSysPFPluginGlobalModel.init(iPSModelStorageContext, this);
        this.psDynaInstGlobalModel.init(iPSModelStorageContext, this);
        String strDBTypes = this.psSystem.getDBTYPES();
        String[] stringArray = dbTypes = strDBTypes.split("[;]");
        int n = dbTypes.length;
        int n2 = 0;
        while (n2 < n) {
            String strDBType = stringArray[n2];
            if (!StringHelper.isNullOrEmpty((String)(strDBType = strDBType.trim()))) {
                this.supportDBTypeList.add(strDBType);
            }
            ++n2;
        }
        this.strPubSystemId = this.getPSDepSlnSysId();
        if (StringHelper.isNullOrEmpty((String)this.getPSDepSlnSysId())) {
            this.strPubSystemId = this.getId();
        }
        if (!this.psSystem.isENABLEMULTILANNull()) {
            this.bEnableMultiLan = this.psSystem.getENABLEMULTILAN();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSystem.getPSLANGUAGEID())) {
            this.strDefaultLanguageId = this.psSystem.getPSLANGUAGEID();
        }
        this.strCLEmptyText = this.psSystem.getCLEMPTYTEXT();
        this.strCLEmptyTextPSLanguageResId = this.psSystem.getCLEMPTYTEXTPSLANRESID();
        if (!this.psSystem.isSERVICEAPIFLAGNull()) {
            this.nServiceAPIMode = this.psSystem.getSERVICEAPIFLAG();
        }
        this.strDefaultValueFormat = "%1$s";
        this.psModelEntityKeeperGlobal = new PSModelEntityKeeperGlobal(this.getPSSysModelInstId());
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    public IPSCodeList getPSCodeList(String strCodeListId) throws Exception {
        IPSCodeList iPSCodeList = (IPSCodeList)this.psCodeListGlobalModel.findModelHelper(strCodeListId);
        return iPSCodeList;
    }

    public IPSCodeList getPSCodeListByTempl(String strCodeListTemplId) throws Exception {
        return (IPSCodeList)this.psCodeListGlobalModel.findModelHelper(KeyValueHelper.genUniqueId((String)this.getId(), (String)strCodeListTemplId));
    }

    public final IPSDataEntity getPSDataEntity2(String strDEName) throws Exception {
        IPSDataEntity iPSDataEntity = this.getPSDataEntity(strDEName);
        if (iPSDataEntity == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEName));
        }
        return iPSDataEntity;
    }

    public final IPSDataEntity getPSDataEntity2(String strDEName, boolean bCache) throws Exception {
        IPSDataEntity iPSDataEntity = this.getPSDataEntity(strDEName);
        if (iPSDataEntity == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEName));
        }
        return iPSDataEntity;
    }

    public IPSDataEntity getPSDataEntity(String strDEName) throws Exception {
        return this.getPSDataEntity(strDEName, true);
    }

    public IPSDataEntity getPSDataEntity(String strDEName, boolean bCache) throws Exception {
        IPSDataEntity iPSDataEntity = this.internalGetPSDataEntity(strDEName, bCache);
        if (iPSDataEntity != null && !((IPSDataEntityRuntime)iPSDataEntity).isInit()) {
            ((IPSDataEntityRuntime)iPSDataEntity).init();
        }
        return iPSDataEntity;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IPSDataEntity internalGetPSDataEntity(String strDEName, boolean bCache) throws Exception {
        IPSDataEntity lastPSDataEntity;
        block25: {
            String strOriginDEID = strDEName;
            strDEName = strDEName.toUpperCase();
            Long curTime = new Date().getTime();
            lastPSDataEntity = null;
            Hashtable<String, IPSDataEntity> hashtable = this.psDataEntityMap;
            synchronized (hashtable) {
                if (this.psDataEntityMap.containsKey(strDEName)) {
                    lastPSDataEntity = this.psDataEntityMap.get(strDEName);
                    if (bCache) {
                        return lastPSDataEntity;
                    }
                }
            }
            PSDataEntity psDataEntity = new PSDataEntity();
            CallResult callResult = this.getPSModelQueryHelper().getPSDataEntity(this.getId(), strOriginDEID, psDataEntity);
            if (callResult == null || callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5931\u8d25", (Object)strOriginDEID));
                return null;
            }
            String strPSDynaInstId = psDataEntity.getParamStringValue("PSDYNAINSTID", null);
            if (!StringHelper.isNullOrEmpty((String)strPSDynaInstId)) {
                String strInfo = StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53[%1$s]\u53d1\u751f\u9519\u8bef\uff0c\u9519\u8bef\u7684\u52a8\u6001\u5b9e\u4f8b[%2$s]\uff0c\u5f53\u524d\u5b9e\u4f8b[%3$s]", (Object)strDEName, (Object)strPSDynaInstId, (Object)this.getPSDynaInstId());
                log.warn((Object)strInfo);
                return null;
            }
            if (psDataEntity.getParamIntValue("VALIDFLAG", 1) == 0) {
                throw new PSSystemException(this, 10002, StringHelper.format((String)"\u7cfb\u7edf[%1$s]\u5b9e\u4f53[%2$s]\u6ca1\u6709\u88ab\u542f\u7528", (Object)this.getName(), (Object)psDataEntity.getPSDATAENTITYNAME()));
            }
            if (lastPSDataEntity != null) {
                if (lastPSDataEntity.getVersion() == psDataEntity.getMODELVER()) {
                    return lastPSDataEntity;
                }
                lastPSDataEntity = null;
            }
            if ((lastPSDataEntity = this.getPSDataEntity(psDataEntity)) == null) {
                return lastPSDataEntity;
            }
            Hashtable<String, IPSDataEntity> strInfo = this.psDataEntityMap;
            synchronized (strInfo) {
                this.psDataEntityMap.put(lastPSDataEntity.getId().toUpperCase(), lastPSDataEntity);
                this.psDataEntityRenewMap.put(lastPSDataEntity.getId().toUpperCase(), new Date().getTime());
                this.psDataEntityMap.put(lastPSDataEntity.getName().toUpperCase(), lastPSDataEntity);
                this.psDataEntityRenewMap.put(lastPSDataEntity.getName().toUpperCase(), new Date().getTime());
            }
            try {
                if (!((IPSDataEntityRuntime)lastPSDataEntity).isInit()) {
                    ((IPSDataEntityRuntime)lastPSDataEntity).init();
                }
            }
            catch (Exception ex) {
                this.psDataEntityMap.put(lastPSDataEntity.getId().toUpperCase(), lastPSDataEntity);
                this.psDataEntityRenewMap.put(lastPSDataEntity.getId().toUpperCase(), new Date().getTime());
                this.psDataEntityMap.put(lastPSDataEntity.getName().toUpperCase(), lastPSDataEntity);
                this.psDataEntityRenewMap.put(lastPSDataEntity.getName().toUpperCase(), new Date().getTime());
                throw ex;
            }
            try {
                if (((IPSDataEntityRuntime)lastPSDataEntity).preparePSDEFields(true)) break block25;
                log.error((Object)StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u51c6\u5907\u5c5e\u6027\u5931\u8d25", (Object)strOriginDEID));
                Hashtable<String, IPSDataEntity> ex = this.psDataEntityMap;
                synchronized (ex) {
                    this.psDataEntityMap.remove(lastPSDataEntity.getId().toUpperCase());
                    this.psDataEntityRenewMap.remove(lastPSDataEntity.getId().toUpperCase());
                    this.psDataEntityMap.remove(lastPSDataEntity.getName().toUpperCase());
                    this.psDataEntityRenewMap.remove(lastPSDataEntity.getName().toUpperCase());
                }
                return null;
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u51c6\u5907\u5c5e\u6027\u5931\u8d25", (Object)strOriginDEID), (Throwable)ex);
                Hashtable<String, IPSDataEntity> hashtable2 = this.psDataEntityMap;
                synchronized (hashtable2) {
                    this.psDataEntityMap.remove(lastPSDataEntity.getId().toUpperCase());
                    this.psDataEntityRenewMap.remove(lastPSDataEntity.getId().toUpperCase());
                    this.psDataEntityMap.remove(lastPSDataEntity.getName().toUpperCase());
                    this.psDataEntityRenewMap.remove(lastPSDataEntity.getName().toUpperCase());
                }
                return null;
            }
        }
        return lastPSDataEntity;
    }

    private final IPSDataEntity getPSDataEntity(PSDataEntity psDataEntity) throws Exception {
        PSDataEntityImpl iPSDataEntity = new PSDataEntityImpl();
        iPSDataEntity.setInitParam(this.getPSModelStorageContext(), this, psDataEntity);
        return iPSDataEntity;
    }

    public IPSApplication getPSApplication(String strSystemApplicationId) throws Exception {
        this.active();
        return (IPSApplication)this.psSystemApplicationGlobalModel.findModelHelper(strSystemApplicationId);
    }

    public IPSDEUIAction getPSDEUIAction(String strDEUIActionId, boolean bTryMode) throws Exception {
        return (IPSDEUIAction)this.psSysDEUIActionGlobalModel.findModelHelper(strDEUIActionId, bTryMode);
    }

    public IDataEntity getDataEntity(String strDataEntityId) throws Exception {
        return this.getPSDataEntity(strDataEntityId);
    }

    public IPSDERBase getPSDER(String strPSDERId) throws Exception {
        return (IPSDERBase)this.psDERGlobalModel.findModelHelper(strPSDERId);
    }

    public IPSSysDBValueFunc getPSSysDBValueFunc(String strPSSysDBValueFuncId) throws Exception {
        return (IPSSysDBValueFunc)this.psSysDBValueFuncGlobalModel.findModelHelper(strPSSysDBValueFuncId);
    }

    public IDERBase getDER(String strDERId) throws Exception {
        return this.getPSDER(strDERId);
    }

    public String getSFType() {
        return this.psSystem.getPSSFID();
    }

    @PSModelRTMeta(description="\u5e94\u7528\u96c6\u5408")
    public Iterator<IPSApplication> getAllPSApps() throws Exception {
        this.active();
        return this.psSystemApplicationGlobalModel.getAllModelHelpers();
    }

    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u96c6\u5408")
    public Iterator<IPSWorkflow> getAllPSWorkflows() throws Exception {
        return this.psWorkflowGlobalModel.getAllModelHelpers();
    }

    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u89d2\u8272\u96c6\u5408")
    public Iterator<IPSWFRole> getAllPSWFRoles() throws Exception {
        return this.psWFRoleGlobalModel.getAllModelHelpers();
    }

    @Override
    public PSACHandler getPSAjaxControlHandlerData(String strAjaxControlHandlerId, boolean bTryMode) throws Exception {
        PSACHandler psACHandler = (PSACHandler)((Object)this.psSysAjaxControlHandlerGlobalModel.findModel(strAjaxControlHandlerId));
        if (psACHandler == null) {
            if (!bTryMode) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u540e\u53f0\u5904\u7406\u5bf9\u8c61[%1$s]", (Object)strAjaxControlHandlerId));
            }
            return psACHandler;
        }
        return psACHandler;
    }

    public ICodeList getCodeList(String strCodeListId) throws Exception {
        return this.getPSCodeList(strCodeListId);
    }

    public IPSWorkflow getPSWorkflow(String strWorkflowId) throws Exception {
        return (IPSWorkflow)this.psWorkflowGlobalModel.findModelHelper(strWorkflowId);
    }

    public IPSWorkflow getPSWorkflow(String strWorkflowId, boolean bTryMode) throws Exception {
        return (IPSWorkflow)this.psWorkflowGlobalModel.findModelHelper(strWorkflowId, bTryMode);
    }

    public IPSWFRole getPSWFRole(String strWFRoleId) throws Exception {
        return (IPSWFRole)this.psWFRoleGlobalModel.findModelHelper(strWFRoleId);
    }

    public IPSSysImage getPSSysImage(String strSysImageId) throws Exception {
        return (IPSSysImage)this.psSysImageGlobalModel.findModelHelper(strSysImageId);
    }

    public IPSSysCss getPSSysCss(String strSysCssId) throws Exception {
        return (IPSSysCss)this.psSysCssGlobalModel.findModelHelper(strSysCssId);
    }

    public IPSSysPortlet getPSSysPortlet(String strSysPortletId) throws Exception {
        return (IPSSysPortlet)this.psSysPortletGlobalModel.findModelHelper(strSysPortletId);
    }

    public IPSSysValueRule getPSSysValueRule(String strSysValueRuleId) throws Exception {
        return (IPSSysValueRule)this.psSysValueRuleGlobalModel.findModelHelper(strSysValueRuleId);
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.iPSDepSlnSys != null) {
            return this.iPSDepSlnSys.getPSSysModelInstId();
        }
        return null;
    }

    @Override
    public String getPSDepSlnSysId() {
        if (this.iPSDepSlnSys != null) {
            return this.iPSDepSlnSys.getId();
        }
        return null;
    }

    @Override
    public String getPSDevCenterDomain() {
        return this.psSystem.getDOMAINNAME();
    }

    @Override
    public String getPSDevCenterId() {
        return this.psSystem.getPSDEVCENTERID();
    }

    @Override
    public String getPSDevCenterName() {
        return this.psSystem.getPSDEVCENTERNAME();
    }

    @Override
    public String getPubSystemId() {
        return this.strPubSystemId;
    }

    public String getPSSFId() {
        return this.psSystem.getPSSFID();
    }

    public String getPSSFName() {
        return this.psSystem.getPSSFNAME();
    }

    public IPSSysPDTView getPSSysPDTView(String strSysPDTViewId) throws Exception {
        return (IPSSysPDTView)this.psSysPDTViewGlobalModel.findModelHelper(strSysPDTViewId);
    }

    @Override
    public IPSSysPFPlugin getPSSysPFPlugin(String strSysPFPluginId) throws Exception {
        return (IPSSysPFPlugin)this.psSysPFPluginGlobalModel.findModelHelper(strSysPFPluginId);
    }

    @Override
    public IPSSysPFPluginTempl getPSSysPFPluginTempl(String strSysPFPluginTemplId, boolean bTryMode) throws Exception {
        return (IPSSysPFPluginTempl)this.psSysPFPluginTemplGlobalModel.findModelHelper(strSysPFPluginTemplId, bTryMode);
    }

    public IPSSysCounter getPSSysCounter(String strSysCounterId, boolean bTryMode) throws Exception {
        return (IPSSysCounter)this.psSysCounterGlobalModel.findModelHelper(strSysCounterId, bTryMode);
    }

    public IPSSysUniRes getPSSysUniRes(String strSysUniResId) throws Exception {
        return (IPSSysUniRes)this.psSysUniResGlobalModel.findModelHelper(strSysUniResId);
    }

    public IPSDEOPPriv getPSDEOPPriv(String strDEOPPrivId) throws Exception {
        return (IPSDEOPPriv)this.psDEOPPrivGlobalModel.findModelHelper(strDEOPPrivId);
    }

    public IPSSysEditorStyle getPSSysEditorStyle(String strSysEditorStyleId) throws Exception {
        return (IPSSysEditorStyle)this.psSysEditorStyleGlobalModel.findModelHelper(strSysEditorStyleId);
    }

    public IPSSysEditorStyle getDefaultPSSysEditorStyle(String strPSEditorTypeId) {
        return this.defaultPSSysEditorStyleMap.get(strPSEditorTypeId);
    }

    public IPSDEUIActionGroup getPSDEUIActionGroup(String strDEUIActionGroupId, boolean bTryMode) throws Exception {
        return (IPSDEUIActionGroup)this.psSysDEUIActionGroupGlobalModel.findModelHelper(strDEUIActionGroupId, bTryMode);
    }

    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getLogicName() {
        return this.psSystem.getLOGICNAME();
    }

    public IPSLanguageRes getPSLanguageRes(String strLanguageResId) throws Exception {
        IPSLanguageRes iPSLanguageRes = (IPSLanguageRes)this.psLanguageResGlobalModel.findModelHelper(strLanguageResId);
        iPSLanguageRes.markSysRef();
        return iPSLanguageRes;
    }

    public IPSLanguageItem getPSLanguageItem(String strLanguageItemId, boolean bTryMode) throws Exception {
        return (IPSLanguageItem)this.psLanguageItemGlobalModel.findModelHelper(strLanguageItemId, bTryMode);
    }

    public Iterator<IPSSysLan> getAllPSSysLans() throws Exception {
        return this.psSysLanGlobalModel.getAllModelHelpers();
    }

    @Override
    public String getDEFieldSortMode() {
        return this.strDEFieldSortMode;
    }

    public String getDefaultLanguage() {
        return this.strDefaultLanguageId;
    }

    @Override
    public String getCLEmptyText() {
        return this.strCLEmptyText;
    }

    public boolean isEnableMultiLan() {
        return this.bEnableMultiLan;
    }

    @Override
    public String getCLEmptyTextPSLanguageResId() {
        return this.strCLEmptyTextPSLanguageResId;
    }

    @Override
    public IPSSysEngineConfig getPSSysEngineConfig() {
        return this.iPSSysEngineConfig;
    }

    @Override
    public int getDEDataExportMaxRowCount() {
        return this.nDEDataExpMaxRowCount;
    }

    @Override
    public IPSDEFieldType getPSDEFieldTypeByDEField(PSDEField psDEField) throws Exception {
        String strDataType = psDEField.getPSDATATYPEID();
        String strDERType = PSDEField.toDEFTypeString(psDEField.getDEFTYPE());
        boolean bMatchName = true;
        if (StringHelper.compare((String)strDataType, (String)"PICKUP", (boolean)true) == 0 || StringHelper.compare((String)strDataType, (String)"PICKUPDATA", (boolean)true) == 0 || StringHelper.compare((String)strDataType, (String)"PICKUPTEXT", (boolean)true) == 0) {
            bMatchName = false;
        }
        if (bMatchName && (psDEField.getDEFTYPE() == 2 || psDEField.getDEFTYPE() == 3)) {
            bMatchName = false;
        }
        String strTag = StringHelper.format((String)"[*:%1$s]", (Object)psDEField.getPSDEFIELDNAME());
        IPSDEFieldType iPSDEFieldType = null;
        if (bMatchName && (iPSDEFieldType = this.psSysDEFTypeGlobalModel.getPSDEFieldTypeByTag(strTag)) != null) {
            return iPSDEFieldType;
        }
        strTag = StringHelper.format((String)"%1$s:%2$s", (Object)strDERType, (Object)strDataType);
        iPSDEFieldType = this.psSysDEFTypeGlobalModel.getPSDEFieldTypeByTag(strTag);
        if (iPSDEFieldType != null) {
            return iPSDEFieldType;
        }
        strTag = StringHelper.format((String)"%1$s:*", (Object)strDERType);
        iPSDEFieldType = this.psSysDEFTypeGlobalModel.getPSDEFieldTypeByTag(strTag);
        if (iPSDEFieldType != null) {
            return iPSDEFieldType;
        }
        strTag = StringHelper.format((String)"*:%1$s", (Object)strDataType);
        iPSDEFieldType = this.psSysDEFTypeGlobalModel.getPSDEFieldTypeByTag(strTag);
        if (iPSDEFieldType != null) {
            return iPSDEFieldType;
        }
        strTag = StringHelper.format((String)"*");
        iPSDEFieldType = this.psSysDEFTypeGlobalModel.getPSDEFieldTypeByTag(strTag);
        if (iPSDEFieldType != null) {
            return iPSDEFieldType;
        }
        return null;
    }

    public boolean isNoViewMode() {
        return this.bNoViewMode;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u63a5\u53e3\u6a21\u5f0f", codelist="SysServiceApiMode")
    public int getServiceAPIMode() {
        return this.nServiceAPIMode;
    }

    @Override
    public int getDataAccCtrlArch() {
        return this.nDataAccCtrlArch;
    }

    @Override
    public int getEngineBugFixs() {
        return this.nEngineBugFixs;
    }

    @Override
    public int getDEFSFItemWidth() {
        return this.nDEFSFItemWidth;
    }

    @Override
    public String getValueFormat() {
        return this.strDefaultValueFormat;
    }

    public boolean hasPSWFEngineType(String strEngineType) throws Exception {
        Iterator<IPSWorkflow> psWorkflows = this.getAllPSWorkflows();
        while (psWorkflows.hasNext()) {
            IPSWorkflow iPSWorkflow = psWorkflows.next();
            if (StringHelper.compare((String)iPSWorkflow.getWFEngineType(), (String)strEngineType, (boolean)false) != 0) continue;
            return true;
        }
        return false;
    }

    public boolean isEnableDBValueInsertUpdateMode() {
        return this.bEnableDBValueInsertUpdateMode;
    }

    public int getDBVersion() {
        return this.nDBVersion;
    }

    @PSModelRTMeta(description="\u652f\u6301\u52a8\u6001\u7cfb\u7edf")
    public boolean isEnableDynaSys() {
        return this.bEnableDynaSys;
    }

    public int getVersion() {
        return this.nModelVersion;
    }

    protected void setVersion(int nModelVersion) {
        this.nModelVersion = nModelVersion;
    }

    @Override
    public void active() {
    }

    @Override
    public void active(boolean bSystemOnly) {
    }

    @Override
    public void load(int nLoadLevel) throws Exception {
        this.nLoadedLevel = nLoadLevel;
    }

    @Override
    protected void onRefreshModelVer() {
        this.psSystemApplicationGlobalModel.refreshModelVer();
        super.onRefreshModelVer();
    }

    public IPSDynaInst getPSDynaInst(String strPSDynaInstId) throws Exception {
        return this.getPSDynaInst(strPSDynaInstId, 1);
    }

    protected IPSDynaInst getPSDynaInst(String strPSDynaInstId, int nCount) throws Exception {
        PSDynaInst psDynaInst;
        IPSDynaInst iPSDynaInst = (IPSDynaInst)this.psDynaInstGlobalModel.findModelHelper(strPSDynaInstId);
        if (iPSDynaInst != null && (psDynaInst = this.psModelEntityKeeperGlobal.getPSDynaInst(strPSDynaInstId)) != null) {
            String strDynaTag = psDynaInst.getParamStringValue("DYNATAG", "");
            if (StringHelper.compare((String)iPSDynaInst.getDynaTag(), (String)strDynaTag, (boolean)true) != 0) {
                this.resetPSDynaInst(strPSDynaInstId);
                if (nCount >= 10) {
                    throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f8b[%1$s]\u914d\u7f6e\u6709\u8bef"));
                }
                return this.getPSDynaInst(strPSDynaInstId, nCount + 1);
            }
        }
        return iPSDynaInst;
    }

    public void resetAllPSDynaInsts() {
        this.psDynaInstGlobalModel.resetAll();
    }

    public void resetPSDynaInst(String strPSDynaInstId) {
        this.psDynaInstGlobalModel.resetModel(strPSDynaInstId);
        try {
            IPSModelQueryHelper iPSModelQueryHelper = PSModelQueryHelperFactory.getInstance(this.getPSSysModelInstId());
            if (iPSModelQueryHelper instanceof IPSModelQueryHelperContainer) {
                ((IPSModelQueryHelperContainer)((Object)iPSModelQueryHelper)).resetPSModelQueryHelper(strPSDynaInstId);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    public boolean isDeployMode() {
        return true;
    }
}

