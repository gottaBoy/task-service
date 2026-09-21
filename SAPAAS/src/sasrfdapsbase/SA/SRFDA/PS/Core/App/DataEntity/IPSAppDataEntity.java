/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.Control.IPSAppPortlet;
import SA.SRFDA.PS.Core.App.Control.IPSAppPortletCat;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEACMode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataExport;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataImport;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMap;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTO;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEPrint;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDERS;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEReport;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIActionGroup;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroup;
import SA.SRFDA.PS.Core.App.IPSAppModule;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.Mob.IPSAppLocalDE;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Data.PSAppLocalDE;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSAppDataEntity")
public interface IPSAppDataEntity
extends IPSAppLocalDE {
    public static final Integer STORAGEMODE_NOLOCAL = 0;
    public static final Integer STORAGEMODE_LOCALONLY = 1;
    public static final Integer STORAGEMODE_LOCALANDREMOTE = 3;
    public static final Integer STORAGEMODE_DTOONLY = 4;

    @Override
    public void init(ISRFDAGlobalHelper var1, IPSApplication var2, PSAppLocalDE var3) throws Exception;

    @Override
    public IPSDataEntity getPSDE();

    @Override
    public IPSDataEntity getPSDataEntity();

    public void registerPSControl(IPSControl var1) throws Exception;

    public Iterator<IPSControl> getPSControls() throws Exception;

    public Iterator<IPSControl> getAllPSControls() throws Exception;

    public Iterator<IPSControl> getAllRefPSControls() throws Exception;

    public void registerRefPSDEDataSet(IPSDEDataSet var1, Object var2) throws Exception;

    public Iterator<IPSDEDataSet> getRefPSDEDataSets() throws Exception;

    public void registerRefPSAppView(IPSAppView var1, Object var2) throws Exception;

    public Iterator<IPSAppView> getRefPSAppViews() throws Exception;

    public Iterator<IPSDEACMode> getAllPSDEACModes() throws Exception;

    public IPSDEACMode getPSDEACMode(String var1) throws Exception;

    public void resetPSDEACMode(String var1) throws Exception;

    public Iterator<IPSAppView> getAllPSAppViews() throws Exception;

    public int getDataAccCtrlArch();

    public int getDataAccCtrlMode();

    public boolean isMajor();

    public String getLogicName();

    @Override
    public String getCodeName();

    public IPSAppDataEntity getMajorPSAppDataEntity() throws Exception;

    public String getMajorPSAppDataEntityId();

    public IPSDER1N getPSDER1N();

    public boolean isDefaultMode();

    public String getCodeName2();

    public IPSSysServiceAPI getPSSysServiceAPI();

    public IPSDEServiceAPI getPSDEServiceAPI();

    public Iterator<? extends IPSAppDEMethod> getAllPSAppDEMethods();

    public int getStorageMode();

    public Iterator<? extends IPSAppDERS> getPSAppDERSs(boolean var1);

    public Iterator<? extends IPSAppDERS> getPSAppDERSs();

    public Iterator<? extends IPSAppDERS> getMajorPSAppDERSs();

    public Iterator<? extends IPSAppDERS> getMinorPSAppDERSs();

    public int getPSAppDERSPathCount() throws Exception;

    public Iterator<? extends IPSAppDERS> getPSAppDERSPath(int var1) throws Exception;

    public IPSAppDERS getPSAppDERSPathFirst(int var1) throws Exception;

    public IPSAppDERS getPSAppDERSPathLast(int var1) throws Exception;

    public Iterator<? extends IPSAppDERS> getPSAppDERSPath0() throws Exception;

    public Iterator<? extends IPSAppDERS> getPSAppDERSPath1() throws Exception;

    public Iterator<? extends IPSAppDERS> getPSAppDERSPath2() throws Exception;

    public Iterator<? extends IPSAppDERS> getPSAppDERSPath3() throws Exception;

    public Iterator<? extends IPSAppDERS> getPSAppDERSPath4() throws Exception;

    public Iterator<? extends IPSAppDEField> getAllPSAppDEFields();

    public IPSAppDEField getPSAppDEField(String var1) throws Exception;

    public IPSAppDEField getPSAppDEField(String var1, boolean var2) throws Exception;

    public IPSAppDEField getPSAppDEField(IPSDEField var1, boolean var2) throws Exception;

    public String getDEFGroupMode();

    public IPSDEFGroup getPSDEFGroup();

    public IPSAppDEMethod getPSAppDEMethod(Object var1) throws Exception;

    public IPSAppDEMethod getPSAppDEMethod(Object var1, boolean var2) throws Exception;

    public IPSAppDEMethod getPSAppDEMethod(String var1, String var2, boolean var3) throws Exception;

    public IPSAppDEField getKeyPSAppDEField();

    public IPSAppDEField getMajorPSAppDEField();

    public Iterator<IPSAppDEUIAction> getAllPSAppDEUIActions() throws Exception;

    public IPSAppDEUIAction getPSAppDEUIAction(String var1) throws Exception;

    public IPSAppDEUIAction getPSAppDEUIAction(String var1, boolean var2) throws Exception;

    public IPSAppDEUIAction getPSAppDEUIAction(String var1, boolean var2, IPSModelObject var3) throws Exception;

    public IPSAppDEUIAction getPSAppDEUIAction2(String var1, boolean var2) throws Exception;

    public void resetPSAppDEUIAction(String var1) throws Exception;

    public Iterator<IPSAppDEUIActionGroup> getAllPSAppDEUIActionGroups() throws Exception;

    public IPSAppDEUIActionGroup getPSAppDEUIActionGroup(String var1) throws Exception;

    public IPSAppDEUIActionGroup getPSAppDEUIActionGroup(String var1, boolean var2) throws Exception;

    public IPSAppDEUIActionGroup getPSAppDEUIActionGroup(String var1, boolean var2, IPSModelObject var3) throws Exception;

    public void resetPSAppDEUIActionGroup(String var1) throws Exception;

    public Iterator<IPSAppDELogic> getAllPSAppDELogics() throws Exception;

    public IPSAppDELogic getPSAppDELogic(String var1) throws Exception;

    public IPSAppDELogic getPSAppDELogic(String var1, boolean var2) throws Exception;

    public void resetPSAppDELogic(String var1) throws Exception;

    public Iterator<IPSAppDEUILogic> getAllPSAppDEUILogics() throws Exception;

    public IPSAppDEUILogic getPSAppDEUILogic(String var1) throws Exception;

    public IPSAppDEUILogic getPSAppDEUILogic(String var1, boolean var2) throws Exception;

    public void resetPSAppDEUILogic(String var1) throws Exception;

    public Iterator<IPSAppDEUILogicGroup> getAllPSAppDEUILogicGroups() throws Exception;

    public IPSAppDEUILogicGroup getPSAppDEUILogicGroup(String var1) throws Exception;

    public IPSAppDEUILogicGroup getPSAppDEUILogicGroup(String var1, boolean var2) throws Exception;

    public void resetPSAppDEUILogicGroup(String var1) throws Exception;

    public Iterator<IPSAppDEACMode> getAllPSAppDEACModes() throws Exception;

    public IPSAppDEACMode getPSAppDEACMode(String var1) throws Exception;

    public IPSAppDEACMode getPSAppDEACMode(String var1, boolean var2) throws Exception;

    public void resetPSAppDEACMode(String var1) throws Exception;

    public void loadAll() throws Exception;

    public IPSAppDEAction getPSAppDEAction(String var1, boolean var2) throws Exception;

    public IPSAppDEAction getPSAppDEAction(IPSDEAction var1, boolean var2) throws Exception;

    public IPSAppDEDataSet getPSAppDEDataSet(String var1, boolean var2) throws Exception;

    public IPSAppDEDataSet getPSAppDEDataSet(IPSDEDataSet var1, boolean var2) throws Exception;

    public IPSAppDEDataSet getPSAppDEDataSetTempMode(String var1, boolean var2) throws Exception;

    public IPSAppDEDataSet getPSAppDEDataSetTempMode(IPSDEDataSet var1, boolean var2) throws Exception;

    public boolean isEnableTempData();

    public boolean isEnableFilterActions();

    public boolean isEnableWFActions();

    public IPSAppWF getPSAppWF();

    public Iterator<IPSAppDataEntity> getSiblings() throws Exception;

    public Iterator<IPSAppPortletCat> getAllPSAppPortletCats() throws Exception;

    public Iterator<IPSAppPortlet> getAllPSAppPortlets() throws Exception;

    public Iterator<IPSAppDEMap> getAllPSAppDEMaps() throws Exception;

    public String getRefLinkPSDEViewId();

    public String getRefMPickupPSDEViewId();

    public String getRefPickupPSDEViewId();

    public Iterator<? extends IPSAppDEField> getQuickSearchPSAppDEFields() throws Exception;

    public IPSAppDEPrint getDefaultPSAppDEPrint() throws Exception;

    public Iterator<IPSAppDEPrint> getAllPSAppDEPrints() throws Exception;

    public IPSAppDEPrint getPSAppDEPrint(String var1) throws Exception;

    public IPSAppDEPrint getPSAppDEPrint(String var1, boolean var2) throws Exception;

    public void resetPSAppDEPrint(String var1) throws Exception;

    public IPSAppDEDataImport getDefaultPSAppDEDataImport() throws Exception;

    public Iterator<IPSAppDEDataImport> getAllPSAppDEDataImports() throws Exception;

    public IPSAppDEDataImport getPSAppDEDataImport(String var1) throws Exception;

    public IPSAppDEDataImport getPSAppDEDataImport(String var1, boolean var2) throws Exception;

    public void resetPSAppDEDataImport(String var1) throws Exception;

    public IPSAppDEDataExport getDefaultPSAppDEDataExport() throws Exception;

    public Iterator<IPSAppDEDataExport> getAllPSAppDEDataExports() throws Exception;

    public IPSAppDEDataExport getPSAppDEDataExport(String var1) throws Exception;

    public IPSAppDEDataExport getPSAppDEDataExport(String var1, boolean var2) throws Exception;

    public void resetPSAppDEDataExport(String var1) throws Exception;

    public Iterator<IPSAppCodeList> getAllPSAppCodeLists() throws Exception;

    public int getEnableUIActions();

    public boolean isEnableUICreate();

    public boolean isEnableUIModify();

    public boolean isEnableUIRemove();

    public IPSSysImage getPSSysImage();

    public IPSAppModule getPSAppModule() throws Exception;

    public String getPSAppModuleId();

    public Iterator<IPSDEMainState> getAllPSDEMainStates() throws Exception;

    public Iterator<IPSDEOPPriv> getAllPSDEOPPrivs() throws Exception;

    public Iterator<IPSAppDEAction> getAllPSAppDEActions();

    public Iterator<IPSAppDEDataSet> getAllPSAppDEDataSets();

    public String getPSDEName();

    public IPSLanguageRes getLNPSLanguageRes();

    public Iterator<IPSAppDEMethodDTO> getAllPSAppDEMethodDTOs() throws Exception;

    public IPSAppDEMethodDTO getPSAppDEMethodDTO(IPSDEMethodDTO var1) throws Exception;

    public IPSSysSFPlugin getPSSysSFPlugin() throws Exception;

    public String getSysAPITag();

    public String getAPICodeNameMode();

    public String getDEAPITag();

    public String getDEAPICodeName();

    public String getDEAPICodeName2();

    public Iterator<IPSAppDEField> getMainStatePSAppDEFields() throws Exception;

    public boolean isEnableDEMainState();

    public IPSAppDEField getFormTypePSAppDEField() throws Exception;

    public IPSAppDEField getDataTypePSAppDEField() throws Exception;

    public IPSAppDEField getIndexTypePSAppDEField() throws Exception;

    public IPSAppDEField getOrgIdPSAppDEField() throws Exception;

    @Override
    public String getDynaInstTag();

    public Iterator<IPSAppDEReport> getAllPSAppDEReports() throws Exception;

    public IPSAppDEReport getPSAppDEReport(String var1) throws Exception;

    public IPSAppDEReport getPSAppDEReport(String var1, boolean var2) throws Exception;

    public void resetPSAppDEReport(String var1) throws Exception;

    public String[] getRequestPaths();

    public Iterator<IPSAppDEField> getUnionKeyValuePSAppDEFields() throws Exception;

    public int getDynaSysMode();

    public String getDEName();

    public String getDECodeName();

    public String getDEFullTag();

    public IPSSysUniRes getPSSysUniRes();
}

