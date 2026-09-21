/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.data.IDataObject
 */
package SA.SRFDA.PS.Core.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionGroup;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInput;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInputDTO;
import SA.SRFDA.PS.Core.DataEntity.BA.IPSDEBDTable;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER11;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERGroup;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERIndex;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERInherit;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERMultiInherit;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERNN;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRGroup;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRItem;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDataRelation;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetInput;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetInputDTO;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEFilterDTO;
import SA.SRFDA.PS.Core.DataEntity.DTS.IPSDEDTSQueue;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExport;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlow;
import SA.SRFDA.PS.Core.DataEntity.DataImport.IPSDEDataImport;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMap;
import SA.SRFDA.PS.Core.DataEntity.DataSync.IPSDEDataSync;
import SA.SRFDA.PS.Core.DataEntity.IPSDEGroup;
import SA.SRFDA.PS.Core.DataEntity.JIT.IPSDESampleData;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEViewLogic;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainStateRS;
import SA.SRFDA.PS.Core.DataEntity.Notify.IPSDENotify;
import SA.SRFDA.PS.Core.DataEntity.Print.IPSDEPrint;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPrivRole;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEUserRole;
import SA.SRFDA.PS.Core.DataEntity.Report.IPSDEReport;
import SA.SRFDA.PS.Core.DataEntity.Search.IPSDESearch;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEActionMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEDataSetMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSLinkDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.DataEntity.UniState.IPSDEUniState;
import SA.SRFDA.PS.Core.DataEntity.Util.IPSDEUtil;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizard;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizardGroup;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizard;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndex;
import SA.SRFDA.PS.Core.Database.IPSDEDBSysProc;
import SA.SRFDA.PS.Core.Database.IPSDEDBTable;
import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.Help.IPSHelpArticle;
import SA.SRFDA.PS.Core.IPSModelData;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFCodeObject;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.System.IPSSysRef;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase;
import SA.SRFDA.PS.Core.Testing.IPSSysTestData;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.PS.Data.PSDEACMode;
import SA.SRFDA.PS.Data.PSDEForm;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.IDataObject;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDataEntity")
public interface IPSDataEntity
extends IPSSystemObject,
IDataEntity,
IPSSFCodeObject,
IPSSysSFPubObject {
    public static final int DETYPE_MAJOR = 1;
    public static final int DETYPE_ATTACHED = 2;
    public static final int DETYPE_RELATED = 3;
    public static final int DETYPE_DYNAATTACHED = 4;
    public static final int DETYPE_AGGDATA = 4;
    public static final int EXTENDMODE_NONE = 0;
    public static final int EXTENDMODE_SUBSYS = 2;
    public static final int ENABLEUIACTION_CREATE = 1;
    public static final int ENABLEUIACTION_UPDATE = 2;
    public static final int ENABLEUIACTION_REMOVE = 4;
    public static final int ENABLEUIACTION_VIEW = 8;
    public static final int ENABLEACTION_CREATE = 1;
    public static final int ENABLEACTION_UPDATE = 2;
    public static final int ENABLEACTION_REMOVE = 4;
    public static final int VIRTUALMODE_NONE = 0;
    public static final int VIRTUALMODE_MINHERIT = 1;
    public static final int VIRTUALMODE_INHERIT = 2;
    public static final int VIRTUALMODE_INDEXMAJOR = 3;
    public static final int VIRTUALMODE_MIXMINHERIT = 4;
    public static final int VIRTUALMODE_MIXMINHERITMERGE = 5;
    public static final Integer SAASMODE_NOTSUPPORTED = 0;
    public static final Integer SAASMODE_STANDARD = 1;
    public static final Integer SAASMODE_STANDARD2 = 2;
    public static final Integer SAASMODE_STANDARD3 = 3;
    public static final Integer SAASMODE_STANDARD4 = 4;
    public static final int TEMPDATAHOLDER_NONE = 0;
    public static final int TEMPDATAHOLDER_BACKEND = 1;
    public static final int TEMPDATAHOLDER_FRONT = 2;
    public static final int TEMPDATAHOLDER_BACKENDANDFRONT = 3;
    public static final int MSACTIONLOGIC_NONE = 0;
    public static final int MSACTIONLOGIC_BACKEND = 1;
    public static final int MSACTIONLOGIC_FRONT = 2;
    public static final int MSACTIONLOGIC_BACKENDANDFRONT = 3;
    public static final int MULTIFORMMODE_NONE = 0;
    public static final int MULTIFORMMODE_DEFAULT = 1;
    public static final int MULTIFORMMODE_MODULEINST = 2;
    public static final String BIZTAG_DATAAUDIT = "DATAAUDIT";
    public static final String BIZTAG_DYNASTORAGE = "DYNASTORAGE";
    public static final String BIZTAG_MEMO = "MEMO";
    public static final int DEHOLDER_BACKEND = 1;
    public static final int DEHOLDER_FRONT = 2;
    public static final int DEHOLDER_BACKENDANDFRONT = 3;
    public static final int DEDYNASYSMODE_DISABLED = 0;
    public static final int DEDYNASYSMODE_ENABLED = 1;
    public static final int DEDYNASYSMODE_SYSTEM = 2;
    public static final int DEDYNASYSMODE_MODELGROUP = 3;
    public static final int DEDYNASYSMODE_MODULE = 4;
    public static final int DEDYNASYSMODE_DATAENTITY = 5;
    public static final int DEDYNASYSMODE_DATA = 99;

    public void setInitParam(ISRFDAGlobalHelper var1, IPSSystem var2, PSDataEntity var3);

    public void init() throws Exception;

    public boolean isInit();

    public boolean preparePSDEFields(boolean var1) throws Exception;

    public Iterator<IPSDEField> getPSDEFields() throws Exception;

    public Iterator<IPSDEField> getAllPSDEFields() throws Exception;

    public IPSDEField getPSDEField(String var1) throws Exception;

    public IPSDEField getPSDEField(String var1, boolean var2) throws Exception;

    @Override
    public String getFullName();

    public boolean isLogicValid();

    public Object getLogicValidValue(boolean var1);

    public String getLogicValidStringValue(boolean var1);

    public Iterator<IPSDEDBConfig> getAllPSDEDBConfigs() throws Exception;

    public IPSDEDBConfig getPSDEDBConfig(String var1) throws Exception;

    public IPSDEDBConfig getPSDEDBConfig(String var1, boolean var2) throws Exception;

    public IPSDEField getKeyPSDEField();

    public IPSDEField getMajorPSDEField();

    public IPSDEField getKeyNamePSDEField();

    public IPSDEField getLogicValidPSDEField() throws Exception;

    public IPSPickupDEField getPSPickupDEField(String var1) throws Exception;

    public IPSDataEntity getInheritPSDataEntity() throws Exception;

    public IPSDERInherit getPSDERInherit() throws Exception;

    public IPSDEField getPSDEFieldByPDT(String var1, boolean var2) throws Exception;

    public IPSDEField getPSDEFieldByBizTag(String var1, boolean var2) throws Exception;

    public Iterator<IPSDEField> getPSDEFieldsByDER(String var1) throws Exception;

    public IPSDERBase getPSDER(boolean var1, String var2, String var3) throws Exception;

    public Iterator<IPSDEUIAction> getAllPSDEUIActions() throws Exception;

    public IPSDEUIAction getPSDEUIAction(String var1) throws Exception;

    public IPSDEUIAction getPSDEUIAction(String var1, boolean var2) throws Exception;

    public void resetPSDEUIAction(String var1) throws Exception;

    public IPSDEUIActionGroup getPSDEUIActionGroup(String var1) throws Exception;

    public IPSDEUIActionGroup getPSDEUIActionGroup(String var1, boolean var2) throws Exception;

    public void resetPSDEUIActionGroup(String var1) throws Exception;

    public IPSDERBase getPSDER(boolean var1, String var2) throws Exception;

    public IPSDERBase getPSDER(boolean var1, String var2, boolean var3) throws Exception;

    public Iterator<IPSDERBase> getPSDERs(boolean var1);

    public Iterator<IPSDERBase> getMajorPSDERs();

    public Iterator<IPSDERBase> getMinorPSDERs();

    public String getDBSchema();

    public IPSDEDataQuery getPSDEDataQuery(String var1) throws Exception;

    public IPSDEDataQuery getPSDEDataQuery(String var1, boolean var2) throws Exception;

    public void resetPSDEDataQuery(String var1) throws Exception;

    public IPSDEDataSet getPSDEDataSet(String var1) throws Exception;

    public IPSDEDataSet getPSDEDataSet(String var1, boolean var2) throws Exception;

    public void resetPSDEDataSet(String var1) throws Exception;

    public Iterator<IPSDEDataSet> getAllPSDEDataSets() throws Exception;

    public PSACHandler getPSAjaxControlHandlerData(String var1) throws Exception;

    public void resetPSAjaxControlHandlerData(String var1);

    public Iterator<IPSDataEntity> getAllMasterPSDataEntities() throws Exception;

    public IPSDataEntity getMasterPSDataEntity(IDataObject var1) throws Exception;

    public IPSDEDBSysProc getPSDEDBSysProc(String var1) throws Exception;

    public void resetPSDEDBSysProc(String var1) throws Exception;

    public Iterator<IPSDEAction> getAllPSDEActions() throws Exception;

    public IPSDEAction getPSDEAction(String var1) throws Exception;

    public IPSDEAction getPSDEAction(String var1, boolean var2) throws Exception;

    public void resetPSDEAction(String var1) throws Exception;

    public IPSDEField getIndexTypePSDEField();

    public Iterator<IPSDEACMode> getAllPSDEACModes() throws Exception;

    public IPSDEACMode getPSDEACMode(String var1) throws Exception;

    public IPSDEACMode getPSDEACMode(String var1, boolean var2) throws Exception;

    public void resetPSDEACMode(String var1) throws Exception;

    public Iterator<IPSDEDataRelation> getAllPSDEDataRelations() throws Exception;

    public IPSDEDataRelation getPSDEDataRelation(String var1) throws Exception;

    public IPSDEDataRelation getPSDEDataRelation(String var1, boolean var2) throws Exception;

    public void resetPSDEDataRelation(String var1) throws Exception;

    public Iterator<IPSDEDRGroup> getAllPSDEDRGroups() throws Exception;

    public IPSDEDRGroup getPSDEDRGroup(String var1) throws Exception;

    public IPSDEDRGroup getPSDEDRGroup(String var1, boolean var2) throws Exception;

    public void resetPSDEDRGroup(String var1) throws Exception;

    public Iterator<IPSDEDRItem> getAllPSDEDRItems() throws Exception;

    public IPSDEDRItem getPSDEDRItem(String var1) throws Exception;

    public IPSDEDRItem getPSDEDRItem(String var1, boolean var2) throws Exception;

    public void resetPSDEDRItem(String var1) throws Exception;

    public Iterator<IPSDEDataQuery> getAllPSDEDataQueries() throws Exception;

    public IPSSystemModule getPSSystemModule();

    @Override
    public String getCodeName();

    public Iterator<IPSDEField> getUnionKeyValuePSDEFields();

    public Iterator<IPSDER1N> getPSDER1Ns(boolean var1, boolean var2);

    public Iterator<IPSDER1N> getPSDER1Ns(boolean var1);

    public Iterator<IPSDER1N> getRemovePSDER1Ns();

    public Iterator<IPSDER1N> getClonePSDER1Ns();

    public Iterator<IPSDER1N> getExportPSDER1Ns();

    public Iterator<IPSDER1N> getTempDataPSDER1Ns(boolean var1);

    public Iterator<IPSDERIndex> getPSDERIndexs(boolean var1);

    public String getIndexDEType();

    public String getLogicName(String var1);

    public String getLNLanResTag();

    public IPSLanguageRes getLNPSLanguageRes();

    public Iterator<IPSDELogic> getAllPSDELogics() throws Exception;

    public IPSDELogic getPSDELogic(String var1) throws Exception;

    public IPSDELogic getPSDELogic(String var1, boolean var2) throws Exception;

    public void resetPSDELogic(String var1) throws Exception;

    public boolean isEnableTempData();

    public boolean isEnableMultiForm();

    public IPSDEField getFormTypePSDEField();

    public PSDEViewBase getPSDEViewDataByPDT(String var1, boolean var2) throws Exception;

    public PSDEViewBase getPSDEViewDataByPDT(String var1, String var2, boolean var3) throws Exception;

    public PSDEViewBase getPSDEViewDataByPDT(String var1, String var2, String var3, boolean var4) throws Exception;

    public Iterator<PSDEViewBase> getPSDEViewDatasByPDT(String var1) throws Exception;

    public int getDEType();

    public int getDEHolder();

    public IPSDERNN getPSDERNN() throws Exception;

    public Iterator<IPSDEMap> getAllPSDEMaps() throws Exception;

    public IPSDEMap getPSDEMap(String var1) throws Exception;

    public IPSDEMap getPSDEMap(String var1, boolean var2) throws Exception;

    public void resetPSDEMap(String var1) throws Exception;

    public Iterator<IPSDEWF> getAllPSDEWFs() throws Exception;

    public IPSDEWF getPSDEWF(String var1) throws Exception;

    public int getPSDEWFCount() throws Exception;

    public void resetPSDEWF(String var1) throws Exception;

    public boolean hasPSDEWF() throws Exception;

    public IPSDEWF getDefaultPSDEWF() throws Exception;

    public IPSDEWF getPSDEWF0() throws Exception;

    public void loadAll() throws Exception;

    public String getTableSpaceId();

    public boolean isEnableMultiDS();

    public Iterator<IPSDEOPPriv> getAllPSDEOPPrivs() throws Exception;

    public IPSDEOPPriv getPSDEOPPriv(String var1) throws Exception;

    public IPSDEOPPriv getPSDEOPPriv(String var1, boolean var2) throws Exception;

    public void resetPSDEOPPriv(String var1) throws Exception;

    public Iterator<IPSDEMainState> getAllPSDEMainStates() throws Exception;

    public IPSDEMainState getPSDEMainState(String var1) throws Exception;

    public IPSDEMainState getPSDEMainState(String var1, boolean var2) throws Exception;

    public void resetPSDEMainState(String var1) throws Exception;

    public boolean isEnableDEMainState();

    public boolean isExistingModel();

    public boolean isEnableOrgModel();

    public Iterator<IPSDEField> getDEMainStateDEFields();

    public IPSDEField getMainStatePSDEField();

    public IPSDEField getMainState2PSDEField();

    public IPSDEField getMainState3PSDEField();

    public boolean isSubSysDE();

    public boolean isSubSysAsCloud();

    public IPSDEFValueRule getPSDEFValueRule(String var1) throws Exception;

    public IPSDEFValueRule getPSDEFValueRule(String var1, boolean var2) throws Exception;

    public Iterator<IPSDEFValueRule> getAllPSDEFValueRules() throws Exception;

    public IPSSysImage getPSSysImage();

    public void checkDataEntity() throws Exception;

    public Iterator<String> getPDTViewNames();

    public String getPSDEViewIdByPDT(String var1) throws Exception;

    public ArrayList<PSDEViewBase> getSDPSDEViewDataList(boolean var1) throws Exception;

    public ArrayList<PSDEViewBase> getSDPSDEViewDataList(boolean var1, boolean var2) throws Exception;

    public Iterator<IPSDEDBIndex> getAllPSDEDBIndexs() throws Exception;

    public Iterator<IPSDEDBIndex> getAllPSDEDBIndices() throws Exception;

    public IPSDEDBIndex getPSDEDBIndex(String var1) throws Exception;

    public IPSDEDBIndex getPSDEDBIndex(String var1, boolean var2) throws Exception;

    public void resetPSDEDBIndex(String var1) throws Exception;

    public Iterator<IPSDEReport> getAllPSDEReports() throws Exception;

    public IPSDEReport getPSDEReport(String var1) throws Exception;

    public IPSDEReport getPSDEReport(String var1, boolean var2) throws Exception;

    public void resetPSDEReport(String var1) throws Exception;

    public PSDEACMode getDefaultPSDEACModeData();

    public Iterator<IPSDEPrint> getAllPSDEPrints() throws Exception;

    public IPSDEPrint getPSDEPrint(String var1) throws Exception;

    public IPSDEPrint getPSDEPrint(String var1, boolean var2) throws Exception;

    public void resetPSDEPrint(String var1) throws Exception;

    public IPSDEPrint getDefaultPSDEPrint() throws Exception;

    public boolean hasPSDEPrint() throws Exception;

    public Iterator<IPSDEViewLogic> getAllPSDEViewLogics() throws Exception;

    public IPSDEViewLogic getPSDEViewLogic(String var1) throws Exception;

    public IPSDEViewLogic getPSDEViewLogic(String var1, boolean var2) throws Exception;

    public void resetPSDEViewLogic(String var1) throws Exception;

    public boolean hasDefaultDEActionTestUnit();

    public String getXmlTagName();

    public Iterator<IPSDEWizard> getAllPSDEWizards() throws Exception;

    public IPSDEWizard getPSDEWizard(String var1) throws Exception;

    public IPSDEWizard getPSDEWizard(String var1, boolean var2) throws Exception;

    public void resetPSDEWizard(String var1) throws Exception;

    public Iterator<IPSDEDataSync> getAllPSDEDataSyncs() throws Exception;

    public IPSDEDataSync getPSDEDataSync(String var1) throws Exception;

    public IPSDEDataSync getPSDEDataSync(String var1, boolean var2) throws Exception;

    public void resetPSDEDataSync(String var1) throws Exception;

    public IPSDER11 getPSDER11() throws Exception;

    public Iterator<IPSDER11> getPSDER11s() throws Exception;

    public boolean isVirtual();

    public Iterator<IPSDERMultiInherit> getPSDERMultiInherits(boolean var1) throws Exception;

    public Iterator<IPSDEBDTable> getAllPSDEBDTables() throws Exception;

    public IPSDEBDTable getPSDEBDTable(String var1) throws Exception;

    public void resetPSDEBDTable(String var1) throws Exception;

    public int getStorageMode();

    public IPSDEDataExport getDefaultPSDEDataExport() throws Exception;

    public Iterator<IPSDEDataExport> getAllPSDEDataExports() throws Exception;

    public IPSDEDataExport getPSDEDataExport(String var1) throws Exception;

    public IPSDEDataExport getPSDEDataExport(String var1, boolean var2) throws Exception;

    public void resetPSDEDataExport(String var1) throws Exception;

    public Iterator<IPSDEDataImport> getAllPSDEDataImports() throws Exception;

    public IPSDEDataImport getPSDEDataImport(String var1) throws Exception;

    public IPSDEDataImport getPSDEDataImport(String var1, boolean var2) throws Exception;

    public void resetPSDEDataImport(String var1) throws Exception;

    public Iterator<IPSDEActionWizard> getAllPSDEActionWizards() throws Exception;

    public IPSDEActionWizard getPSDEActionWizard(String var1) throws Exception;

    public IPSDEActionWizard getPSDEActionWizard(String var1, boolean var2) throws Exception;

    public void resetPSDEActionWizard(String var1) throws Exception;

    public Iterator<IPSDEActionWizardGroup> getAllPSDEActionWizardGroups() throws Exception;

    public IPSDEActionWizardGroup getPSDEActionWizardGroup(String var1) throws Exception;

    public IPSDEActionWizardGroup getPSDEActionWizardGroup(String var1, boolean var2) throws Exception;

    public void resetPSDEActionWizardGroup(String var1) throws Exception;

    public String getPSHelpModuleId();

    public String getVKeySeparator();

    public boolean isEnableViewLevel(int var1);

    public int getEnableViewLevel();

    public String getViewName(int var1);

    public boolean isEnableEntityCache();

    public int getEntityCacheTimeout();

    public int getMaxEntityCacheCount();

    public Iterator<IPSDEUniState> getAllPSDEUniStates() throws Exception;

    public IPSDEUniState getPSDEUniState(String var1) throws Exception;

    public IPSDEUniState getPSDEUniState(String var1, boolean var2) throws Exception;

    public void resetPSDEUniState(String var1) throws Exception;

    public boolean hasPSDEUniState() throws Exception;

    public IPSDEUniState getDefaultPSDEUniState() throws Exception;

    public int getModelImpExpMode();

    public int getServiceAPIMode();

    public Iterator<IPSDEServiceAPI> getAllPSDEServiceAPIs() throws Exception;

    public IPSDEServiceAPI getPSDEServiceAPI(String var1) throws Exception;

    public void resetPSDEServiceAPI(String var1) throws Exception;

    public Iterator<IPSDEDTSQueue> getAllPSDEDTSQueues() throws Exception;

    public IPSDEDTSQueue getPSDEDTSQueue(String var1) throws Exception;

    public IPSDEDTSQueue getPSDEDTSQueue(String var1, boolean var2) throws Exception;

    public void resetPSDEDTSQueue(String var1) throws Exception;

    public boolean hasPSDEDTSQueue() throws Exception;

    public String getServiceCodeName();

    public boolean isEnableSADEAction();

    public boolean isEnableSASelect();

    public boolean isEnableSADEDataSet();

    public int getEnableUIActions();

    public int getEnableActions();

    public Iterator<IPSDEUserRole> getAllPSDEUserRoles() throws Exception;

    public IPSDEUserRole getPSDEUserRole(String var1) throws Exception;

    public IPSDEUserRole getPSDEUserRole(String var1, boolean var2) throws Exception;

    public void resetPSDEUserRole(String var1) throws Exception;

    public Iterator<IPSDEOPPrivRole> getAllPSDEOPPrivRoles() throws Exception;

    public IPSDEOPPrivRole getPSDEOPPrivRole(String var1) throws Exception;

    public IPSDEOPPrivRole getPSDEOPPrivRole(String var1, boolean var2) throws Exception;

    public void resetPSDEOPPrivRole(String var1) throws Exception;

    public Iterator<IPSDEUtil> getAllPSDEUtils() throws Exception;

    public IPSDEUtil getPSDEUtil(String var1) throws Exception;

    public IPSDEUtil getPSDEUtil(String var1, boolean var2) throws Exception;

    public void resetPSDEUtil(String var1) throws Exception;

    public IPSDEDTSQueue getDefaultPSDEDTSQueue() throws Exception;

    public Iterator<PSDEViewBase> getAllPSDEViewDatas();

    public Iterator<PSDEViewBase> getPDTPSDEViewDatas();

    public Iterator<IPSDESampleData> getAllPSDESampleDatas() throws Exception;

    public IPSDESampleData getPSDESampleData(String var1) throws Exception;

    public IPSDESampleData getPSDESampleData(String var1, boolean var2) throws Exception;

    public IPSDESampleData getPSDESampleData(boolean var1) throws Exception;

    public boolean isEnableDynaStorage();

    public int getVirtualMode();

    public boolean isEnableDynaSys();

    public String getPSDynaDETemplId();

    public int getSaaSMode();

    public String getSaaSDataIdColumnName();

    public String getSaaSDCIdColumnName();

    public Iterator<IPSAppView> getDataRedirectPSAppViews() throws Exception;

    public Iterator<IPSAppView> getMobDataRedirectPSAppViews() throws Exception;

    public boolean hasPSDEViewBase();

    public IPSSysRef getPSSysRef();

    public String getSystemTag();

    public IPSDEACMode getDefaultPSDEACMode() throws Exception;

    public IPSDEDataSet getDefaultPSDEDataSet() throws Exception;

    public IPSDEDataQuery getDefaultPSDEDataQuery() throws Exception;

    public IPSDEDataQuery getViewPSDEDataQuery() throws Exception;

    public IPSSubSysServiceAPI getPSSubSysServiceAPI() throws Exception;

    public IPSSubSysServiceAPIDE getPSSubSysServiceAPIDE() throws Exception;

    public Iterator<IPSDER1N> getCustomExportPSDER1Ns(boolean var1);

    public Iterator<IPSDER1N> getCustomExport2PSDER1Ns(boolean var1);

    public Iterator<IPSAppDataEntity> getAllPSAppDataEntities() throws Exception;

    public Iterator<IPSAppView> getAllPSAppViews() throws Exception;

    public IPSAppDataEntity getPSAppDataEntity(String var1, boolean var2) throws Exception;

    public boolean hasPSAppDataEntity() throws Exception;

    public Iterator<IPSDEFGroup> getAllPSDEFGroups() throws Exception;

    public IPSDEFGroup getPSDEFGroup(String var1) throws Exception;

    public IPSDEFGroup getPSDEFGroup(String var1, boolean var2) throws Exception;

    public void resetPSDEFGroup(String var1) throws Exception;

    public boolean isEnableDataVer();

    public Iterator<IPSDEGroup> getAllPSDEGroups() throws Exception;

    public IPSDEGroup getPSDEGroup(String var1) throws Exception;

    public IPSDEGroup getPSDEGroup(String var1, boolean var2) throws Exception;

    public void resetPSDEGroup(String var1) throws Exception;

    public Iterator<IPSDERGroup> getAllPSDERGroups() throws Exception;

    public IPSDERGroup getPSDERGroup(String var1) throws Exception;

    public IPSDERGroup getPSDERGroup(String var1, boolean var2) throws Exception;

    public void resetPSDERGroup(String var1) throws Exception;

    public Iterator<IPSDEActionGroup> getAllPSDEActionGroups() throws Exception;

    public IPSDEActionGroup getPSDEActionGroup(String var1) throws Exception;

    public IPSDEActionGroup getPSDEActionGroup(String var1, boolean var2) throws Exception;

    public void resetPSDEActionGroup(String var1) throws Exception;

    public Iterator<IPSHelpArticle> getAllPSHelpArticles() throws Exception;

    public Iterator<IPSDEDBTable> getAllPSDEDBTables() throws Exception;

    public IPSDEDBTable getPSDEDBTable(String var1) throws Exception;

    public IPSDEDBTable getPSDEDBTable(String var1, boolean var2) throws Exception;

    public IPSSysDBScheme getPSSysDBScheme();

    public Iterator<IPSDESearch> getAllPSDESearchs() throws Exception;

    public Iterator<IPSDESearch> getAllPSDESearches() throws Exception;

    public IPSDESearch getPSDESearch(String var1) throws Exception;

    public boolean isEnableMultiStorage();

    public boolean isEnableSQLStorage() throws Exception;

    public boolean isEnableNoSQLStorage() throws Exception;

    public boolean isEnableAPIStorage() throws Exception;

    public boolean hasPSDEBDTable() throws Exception;

    public boolean hasPSDESearch() throws Exception;

    public int getTempDataHolder();

    public boolean isEnableTempDataBackend();

    public boolean isEnableTempDataFront();

    public String getPSSubSysSADEId();

    public Iterator<IPSDEField> getQuickSearchPSDEFields() throws Exception;

    public IPSDEDataImport getDefaultPSDEDataImport() throws Exception;

    public Iterator<IPSCodeList> getAllPSCodeLists() throws Exception;

    public IPSDEField getOrderValuePSDEField();

    public IPSDEField getVersionPSDEField();

    public IPSDEField getDataTypePSDEField();

    public Iterator<IPSDEMethod> getAllPSDEMethods() throws Exception;

    public IPSDEActionMethod getPSDEActionMethod(IPSDEAction var1, boolean var2) throws Exception;

    public IPSDEDataSetMethod getPSDEDataSetMethod(IPSDEDataSet var1, boolean var2) throws Exception;

    public IPSDEDataSetMethod getPSDEDataSetMethod(IPSDEDataSet var1, IPSDER1N var2, String var3, boolean var4) throws Exception;

    public IPSDER1N getRecursivePSDER1N();

    public Iterator<IPSDER1N> getMajorPSDER1Ns();

    public Iterator<IPSDER1N> getMinorPSDER1Ns();

    public Iterator<IPSDEField> getMainStatePSDEFields();

    public int getMSActionLogicMode();

    public boolean isEnableCreate();

    public boolean isEnableModify();

    public boolean isEnableRemove();

    public boolean isEnableUICreate();

    public boolean isEnableUIModify();

    public boolean isEnableUIRemove();

    public Iterator<IPSDER1N> getMasterPSDER1Ns();

    public String getValidLogicValue();

    public String getInvalidLogicValue();

    @Override
    public int getDynaInstMode();

    @Override
    public String getDynaInstTag();

    @Override
    public String getDynaInstTag2();

    public int getDataAccCtrlMode();

    public int getAuditMode();

    public String getDSLink();

    public int getDataChangeLogMode();

    public int getDataAccCtrlArch();

    public String getLogicName();

    public Iterator<IPSDEMainStateRS> getAllPSDEMainStateRSs() throws Exception;

    public String getTableName();

    public String getUserTable();

    public String getViewName();

    public String getView2Name();

    public String getView3Name();

    public String getView4Name();

    public IPSDEField getUniTagPSDEField();

    public Iterator<IPSDENotify> getAllPSDENotifies() throws Exception;

    public IPSDENotify getPSDENotify(String var1) throws Exception;

    public IPSDENotify getPSDENotify(String var1, boolean var2) throws Exception;

    public void resetPSDENotify(String var1) throws Exception;

    public Iterator<PSDEForm> getAllPSDEEditFormDatas();

    public Iterator<IPSDEMSLogic> getAllPSDEMSLogics() throws Exception;

    public IPSDEMSLogic getPSDEMSLogic(String var1) throws Exception;

    public IPSDEMSLogic getPSDEMSLogic(String var1, boolean var2) throws Exception;

    public void resetPSDEMSLogic(String var1) throws Exception;

    public IPSDEMSLogic getDefaultPSDEMSLogic();

    public String getBizTag();

    public IPSDEField getParentTypePSDEField();

    public IPSDEField getParentIdPSDEField();

    public IPSDEField getParentNamePSDEField();

    public Iterator<IPSDEMethodDTO> getAllPSDEMethodDTOs() throws Exception;

    public IPSDEMethodDTO getDefaultPSDEMethodDTO() throws Exception;

    public IPSDEMethodDTO getPSDEMethodDTO(IPSDEFGroup var1) throws Exception;

    public IPSDEMethodDTO getPSDEMethodDTO(IPSSysDynaModel var1) throws Exception;

    public IPSLinkDEMethodDTO getPSLinkDEMethodDTO(IPSDataEntity var1, IPSDEFGroup var2) throws Exception;

    public IPSLinkDEMethodDTO getPSLinkDEMethodDTO(IPSSysDynaModel var1) throws Exception;

    public IPSDEActionInputDTO getPSDEActionInputDTO(IPSDEActionInput var1) throws Exception;

    public String getDEMethodDTOCodeName(IPSDEMethodDTO var1) throws Exception;

    public IPSDEFilterDTO getPSDEFilterDTO(IPSDEFGroup var1) throws Exception;

    public IPSDEFilterDTO getPSDEFilterDTO(IPSSysDynaModel var1) throws Exception;

    public IPSDEFilterDTO getDefaultPSDEFilterDTO() throws Exception;

    public String getPSSysModelGroupId();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public PSDEViewBase getPSDEViewData(String var1, boolean var2) throws Exception;

    public PSDEForm getPSDEEditFormData(String var1, boolean var2) throws Exception;

    public Iterator<IPSModelData> getAllPSModelDatas() throws Exception;

    public Iterator<IPSSysTestCase> getAllPSSysTestCases() throws Exception;

    public Iterator<IPSSysTestData> getAllPSSysTestDatas() throws Exception;

    public IPSDEField getOrgIdPSDEField();

    public int getExtendMode();

    public String getDETag();

    public String getDETag2();

    public IPSSysBDScheme getPSSysBDScheme();

    public IPSDEDataSetInputDTO getPSDEDataSetInputDTO(IPSDEDataSetInput var1) throws Exception;

    public Iterator<IPSDEDataFlow> getAllPSDEDataFlows() throws Exception;

    public IPSDEDataFlow getPSDEDataFlow(String var1) throws Exception;

    public IPSDEDataFlow getPSDEDataFlow(String var1, boolean var2) throws Exception;

    public void resetPSDEDataFlow(String var1) throws Exception;

    public int getDynaSysMode();

    public String getUnionKeyMode();

    public String getUnionKeyParam();

    public String getAPICodeNameMode();

    public String getAPICodeName(String var1, String var2, String var3);

    public boolean isDTOUseServiceCodeName();

    public boolean isEnablePQL();

    public IPSSysUniRes getPSSysUniRes();
}

