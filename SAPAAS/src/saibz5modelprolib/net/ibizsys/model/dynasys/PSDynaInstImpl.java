/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dynasys;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSysEngineConfig;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.IPSSystemContainer;
import net.ibizsys.model.IPSSystemRuntime;
import net.ibizsys.model.IPSSystemSetting;
import net.ibizsys.model.PSSystemException;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.IPSDataEntityRuntime;
import net.ibizsys.model.dataentity.PSDataEntityImpl;
import net.ibizsys.model.dataentity.field.IPSDEFieldType;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIAction;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup;
import net.ibizsys.model.der.IPSDERBase;
import net.ibizsys.model.dynasys.IPSDynaInst;
import net.ibizsys.model.dynasys.IPSDynaInstRuntime;
import net.ibizsys.model.dynasys.PSDynaAppInstImpl;
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
import net.ibizsys.model.security.IPSSysUniRes;
import net.ibizsys.model.valuerule.IPSSysValueRule;
import net.ibizsys.model.wf.IPSWFRole;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.model.wf.PSWorkflowGlobalModel;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDynaInstImpl
extends PSSystemObjectImpl
implements IPSDynaInstRuntime,
IPSSystemRuntime,
IPSSystemSetting {
    private static final Log log = LogFactory.getLog(PSDynaInstImpl.class);
    private PSDynaInst psDynaInst = null;
    private final Hashtable<String, IPSDataEntity> psDataEntityMap = new Hashtable();
    private final Hashtable<String, Long> psDataEntityRenewMap = new Hashtable();
    private final HashMap<String, IPSApplication> psApplicationMap = new HashMap();
    private final PSWorkflowGlobalModel psWorkflowGlobalModel = new PSWorkflowGlobalModel();
    private String strDynaTag = "";
    private String strDynaInstMode = "DEFAULT";
    private String strPPSDynaInstId = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, PSDynaInst psDynaInst) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setPSSystem(iPSSystem);
        this.psDynaInst = psDynaInst;
        this.setId(iPSSystem.getId());
        this.setName(iPSSystem.getName());
        if (!StringHelper.isNullOrEmpty((String)psDynaInst.getPPSDYNAINSTID())) {
            this.strPPSDynaInstId = psDynaInst.getPPSDYNAINSTID();
        }
        if (psDynaInst.getUPDATEDATE() != null) {
            this.strDynaTag = StringHelper.format((String)"%1$s", (Object)psDynaInst.getUPDATEDATE().getTime());
        }
        if (!StringHelper.isNullOrEmpty((String)psDynaInst.getINSTMODE())) {
            this.strDynaInstMode = psDynaInst.getINSTMODE();
        }
        this.psWorkflowGlobalModel.init(iPSModelStorageContext, this);
        this.onInit();
    }

    public IPSDataEntity getPSDataEntity(String strDEName) throws Exception {
        return this.getPSDataEntity(strDEName, true);
    }

    public IPSDataEntity getPSDataEntity(String strDEName, boolean bCache) throws Exception {
        IPSDataEntity iPSDataEntity = this.psDataEntityMap.get(strDEName.toUpperCase());
        if (iPSDataEntity == null && (iPSDataEntity = this.getParentPSSystem().getPSDataEntity(strDEName, bCache)) != null) {
            return iPSDataEntity;
        }
        if (iPSDataEntity == null) {
            iPSDataEntity = this.internalGetPSDataEntity(strDEName, bCache);
        }
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
            if (StringHelper.isNullOrEmpty((String)strPSDynaInstId) || StringHelper.compare((String)strPSDynaInstId, (String)this.getPSDynaInstId(), (boolean)false) != 0) {
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

    public IPSApplication getPSApplication(String strPSSysAppId) throws Exception {
        IPSApplication iPSApplication = this.psApplicationMap.get(strPSSysAppId);
        if (iPSApplication == null) {
            IPSApplication iPSApplication2 = this.getParentPSSystem().getPSApplication(strPSSysAppId);
            PSDynaAppInstImpl psDynaAppInstImpl = new PSDynaAppInstImpl();
            psDynaAppInstImpl.init(this.getPSModelStorageContext(), this, iPSApplication2);
            this.psApplicationMap.put(strPSSysAppId, psDynaAppInstImpl);
            return psDynaAppInstImpl;
        }
        return iPSApplication;
    }

    public IPSSysUniRes getPSSysUniRes(String strSysUniResId) throws Exception {
        return this.getPSSystem().getPSSysUniRes(strSysUniResId);
    }

    public IPSSysImage getPSSysImage(String strSysImageId) throws Exception {
        return this.getPSSystem().getPSSysImage(strSysImageId);
    }

    public IPSSysCss getPSSysCss(String strSysCssId) throws Exception {
        return this.getPSSystem().getPSSysCss(strSysCssId);
    }

    public IPSSysCounter getPSSysCounter(String strPSSysCounterId, boolean bTryMode) throws Exception {
        return this.getPSSystem().getPSSysCounter(strPSSysCounterId, bTryMode);
    }

    public IPSCodeList getPSCodeList(String strCodeListId) throws Exception {
        return this.getPSSystem().getPSCodeList(strCodeListId);
    }

    public IPSSysEditorStyle getPSSysEditorStyle(String strPSSysEditorStyleId) throws Exception {
        return this.getPSSystem().getPSSysEditorStyle(strPSSysEditorStyleId);
    }

    public IPSSysEditorStyle getDefaultPSSysEditorStyle(String strPSEditorTypeId) {
        return this.getPSSystem().getDefaultPSSysEditorStyle(strPSEditorTypeId);
    }

    public IPSSysDBValueFunc getPSSysDBValueFunc(String strPSSysDBValueFuncId) throws Exception {
        return this.getPSSystem().getPSSysDBValueFunc(strPSSysDBValueFuncId);
    }

    public IPSSysPortlet getPSSysPortlet(String strSysPortletId) throws Exception {
        return this.getPSSystem().getPSSysPortlet(strSysPortletId);
    }

    public IPSLanguageRes getPSLanguageRes(String strLanguageResId) throws Exception {
        return this.getPSSystem().getPSLanguageRes(strLanguageResId);
    }

    public int getVersion() {
        return this.getPSSystem().getVersion();
    }

    public IPSDEUIActionGroup getPSDEUIActionGroup(String strDEUIActionGroupId, boolean bTryMode) throws Exception {
        return this.getPSSystem().getPSDEUIActionGroup(strDEUIActionGroupId, bTryMode);
    }

    public IPSDEOPPriv getPSDEOPPriv(String strPSDEOPPrivId) throws Exception {
        return this.getPSSystem().getPSDEOPPriv(strPSDEOPPrivId);
    }

    public IPSDEUIAction getPSDEUIAction(String strDEUIActionId, boolean bTryMode) throws Exception {
        return this.getPSSystem().getPSDEUIAction(strDEUIActionId, bTryMode);
    }

    public boolean isNoViewMode() {
        return this.getPSSystem().isNoViewMode();
    }

    public IPSWorkflow getPSWorkflow(String strWorkflowId) throws Exception {
        if (this.psWorkflowGlobalModel.containsModel(strWorkflowId)) {
            return (IPSWorkflow)this.psWorkflowGlobalModel.findModelHelper(strWorkflowId);
        }
        IPSWorkflow iPSWorkflow = this.getParentPSSystem().getPSWorkflow(strWorkflowId, true);
        if (iPSWorkflow != null) {
            return iPSWorkflow;
        }
        return (IPSWorkflow)this.psWorkflowGlobalModel.findModelHelper(strWorkflowId);
    }

    public IPSWorkflow getPSWorkflow(String strWorkflowId, boolean bTryMode) throws Exception {
        if (this.psWorkflowGlobalModel.containsModel(strWorkflowId)) {
            return (IPSWorkflow)this.psWorkflowGlobalModel.findModelHelper(strWorkflowId);
        }
        IPSWorkflow iPSWorkflow = this.getParentPSSystem().getPSWorkflow(strWorkflowId, true);
        if (iPSWorkflow != null) {
            return iPSWorkflow;
        }
        return (IPSWorkflow)this.psWorkflowGlobalModel.findModelHelper(strWorkflowId, bTryMode);
    }

    public IPSSysPDTView getPSSysPDTView(String strSysPDTViewId) throws Exception {
        return this.getPSSystem().getPSSysPDTView(strSysPDTViewId);
    }

    public IPSDERBase getPSDER(String strPSDERId) throws Exception {
        return this.getPSSystem().getPSDER(strPSDERId);
    }

    public IPSSysValueRule getPSSysValueRule(String strSysValueRuleId) throws Exception {
        return this.getPSSystem().getPSSysValueRule(strSysValueRuleId);
    }

    public String getSFType() {
        return this.getPSSystem().getSFType();
    }

    public IPSCodeList getPSCodeListByTempl(String strCodeListTemplId) throws Exception {
        return this.getPSSystem().getPSCodeListByTempl(strCodeListTemplId);
    }

    public IPSLanguageItem getPSLanguageItem(String strLanguageItemId, boolean bTryMode) throws Exception {
        return this.getPSSystem().getPSLanguageItem(strLanguageItemId, bTryMode);
    }

    public String getLogicName() {
        return this.getPSSystem().getLogicName();
    }

    public IPSWFRole getPSWFRole(String strWFRoleId) throws Exception {
        return this.getPSSystem().getPSWFRole(strWFRoleId);
    }

    public String getPSSFId() {
        return this.getPSSystem().getPSSFId();
    }

    public String getPSSFName() {
        return this.getPSSystem().getPSSFName();
    }

    public Iterator<IPSSysLan> getAllPSSysLans() throws Exception {
        return this.getPSSystem().getAllPSSysLans();
    }

    public String getDefaultLanguage() {
        return this.getPSSystem().getDefaultLanguage();
    }

    public boolean isEnableMultiLan() {
        return this.getPSSystem().isEnableMultiLan();
    }

    public boolean hasPSWFEngineType(String strEngineType) throws Exception {
        return this.getPSSystem().hasPSWFEngineType(strEngineType);
    }

    public Iterator<IPSWorkflow> getAllPSWorkflows() throws Exception {
        return this.getPSSystem().getAllPSWorkflows();
    }

    public Iterator<IPSWFRole> getAllPSWFRoles() throws Exception {
        return this.getPSSystem().getAllPSWFRoles();
    }

    public int getDBVersion() {
        return this.getPSSystem().getDBVersion();
    }

    public boolean isEnableDynaSys() {
        return this.getPSSystem().isEnableDynaSys();
    }

    public Iterator<IPSApplication> getAllPSApps() throws Exception {
        return this.getPSSystem().getAllPSApps();
    }

    public IDataEntity getDataEntity(String strDataEntityId) throws Exception {
        return this.getPSDataEntity(strDataEntityId);
    }

    public IDERBase getDER(String strDERId) throws Exception {
        return this.getPSSystem().getDER(strDERId);
    }

    public ICodeList getCodeList(String strCodeListId) throws Exception {
        return this.getPSSystem().getCodeList(strCodeListId);
    }

    public IPSDynaInst getPSDynaInst(String strPSDynaInstId) throws Exception {
        if (StringHelper.compare((String)strPSDynaInstId, (String)this.getPSDynaInstId(), (boolean)true) == 0) {
            return this;
        }
        return this.getPSSystem().getPSDynaInst(strPSDynaInstId);
    }

    public void resetAllPSDynaInsts() {
        this.getPSSystem().resetAllPSDynaInsts();
    }

    public void resetPSDynaInst(String strPSDynaInstId) {
        this.getPSSystem().resetPSDynaInst(strPSDynaInstId);
    }

    @Override
    public String getPSDynaInstId() {
        return this.psDynaInst.getPSDYNAINSTID();
    }

    @Override
    public int getDynaModelType() {
        return 2;
    }

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystemContainer iPSSystemContainer, PSSystem psSystem) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public void active() {
        this.getPSSystemRuntime().active();
    }

    @Override
    public void active(boolean bSystemOnly) {
        this.getPSSystemRuntime().active(bSystemOnly);
    }

    @Override
    public PSACHandler getPSAjaxControlHandlerData(String strAjaxControlHandlerId, boolean bTryMode) throws Exception {
        return this.getPSSystemRuntime().getPSAjaxControlHandlerData(strAjaxControlHandlerId, bTryMode);
    }

    @Override
    public IPSSysEngineConfig getPSSysEngineConfig() {
        return this.getPSSystemRuntime().getPSSysEngineConfig();
    }

    @Override
    public IPSDEFieldType getPSDEFieldTypeByDEField(PSDEField psDEField) throws Exception {
        return this.getPSSystemRuntime().getPSDEFieldTypeByDEField(psDEField);
    }

    @Override
    public String getPSDevCenterDomain() {
        return this.getPSSystemRuntime().getPSDevCenterDomain();
    }

    @Override
    public String getPSDevCenterId() {
        return this.getPSSystemRuntime().getPSDevCenterId();
    }

    @Override
    public String getPSDevCenterName() {
        return this.getPSSystemRuntime().getPSDevCenterName();
    }

    @Override
    public String getPubSystemId() {
        return this.getPSSystemRuntime().getPubSystemId();
    }

    @Override
    public String getPSDepSlnSysId() {
        return this.getPSSystemRuntime().getPSDepSlnSysId();
    }

    @Override
    public IPSSysPFPluginTempl getPSSysPFPluginTempl(String strSysPFPluginTemplId, boolean bTryMode) throws Exception {
        return this.getPSSystemRuntime().getPSSysPFPluginTempl(strSysPFPluginTemplId, bTryMode);
    }

    @Override
    public IPSSysPFPlugin getPSSysPFPlugin(String strSysPFPluginId) throws Exception {
        return this.getPSSystemRuntime().getPSSysPFPlugin(strSysPFPluginId);
    }

    @Override
    public void load(int nLoadLevel) throws Exception {
        this.getPSSystemRuntime().load(nLoadLevel);
    }

    public boolean isEnableDBValueInsertUpdateMode() {
        return this.getPSSystemSetting().isEnableDBValueInsertUpdateMode();
    }

    @Override
    public String getDEFieldSortMode() {
        return this.getPSSystemSetting().getDEFieldSortMode();
    }

    @Override
    public String getCLEmptyText() {
        return this.getPSSystemSetting().getCLEmptyText();
    }

    @Override
    public String getCLEmptyTextPSLanguageResId() {
        return this.getPSSystemSetting().getCLEmptyTextPSLanguageResId();
    }

    @Override
    public int getDEDataExportMaxRowCount() {
        return this.getPSSystemSetting().getDEDataExportMaxRowCount();
    }

    @Override
    public int getServiceAPIMode() {
        return this.getPSSystemSetting().getServiceAPIMode();
    }

    @Override
    public int getDataAccCtrlArch() {
        return this.getPSSystemSetting().getDataAccCtrlArch();
    }

    @Override
    public int getEngineBugFixs() {
        return this.getPSSystemSetting().getEngineBugFixs();
    }

    @Override
    public int getDEFSFItemWidth() {
        return this.getPSSystemSetting().getDEFSFItemWidth();
    }

    @Override
    public String getValueFormat() {
        return this.getPSSystemSetting().getValueFormat();
    }

    public String getDynaTag() {
        return this.strDynaTag;
    }

    public String getInstMode() {
        return this.strDynaInstMode;
    }

    @Override
    public boolean isDeployMode() {
        return true;
    }

    public String getPPSDynaInstId() {
        return this.strPPSDynaInstId;
    }

    public IPSSystem getParentPSSystem() throws Exception {
        IPSDynaInst parentPSDynaInst = this.getParentPSDynaInst();
        if (parentPSDynaInst == null) {
            return this.getPSSystem();
        }
        return parentPSDynaInst;
    }

    @Override
    public IPSDynaInst getParentPSDynaInst() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getPPSDynaInstId())) {
            return null;
        }
        return this.getPSSystem().getPSDynaInst(this.getPPSDynaInstId());
    }
}

