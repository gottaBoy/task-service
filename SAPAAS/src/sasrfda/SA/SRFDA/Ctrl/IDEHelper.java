/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.ProcParam
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.Data.DEACMode;
import SA.SRFDA.Ctrl.Data.DEAction;
import SA.SRFDA.Ctrl.Data.DEDataCtrl;
import SA.SRFDA.Ctrl.Data.DEDataImport;
import SA.SRFDA.Ctrl.Data.DEDataSync;
import SA.SRFDA.Ctrl.Data.DEField;
import SA.SRFDA.Ctrl.Data.DEMobile;
import SA.SRFDA.Ctrl.Data.DER11;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERCUSTOM;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DESubWF;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.Data.DEWizard;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.Data.DataNotify;
import SA.SRFDA.Ctrl.DataNotify.IDataNotifyHelper;
import SA.SRFDA.Ctrl.IDAConfigHelper;
import SA.SRFDA.Ctrl.IDAMBConfigHelper;
import SA.SRFDA.Ctrl.IDAModelHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEMainActionHelper;
import SA.SRFDA.Ctrl.IDEMainStateHelper;
import SA.SRFDA.Ctrl.IDER11Helper;
import SA.SRFDA.Ctrl.IDER1NHelper;
import SA.SRFDA.Ctrl.IDERGroupHelper;
import SA.SRFDA.Ctrl.IDESubWFHelper;
import SA.SRFDA.Ctrl.IDEWFHelper;
import SA.SRFDA.Ctrl.ISummaryPageHelper;
import SA.SRFDA.Security.IDataAccHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.ProcParam;
import java.sql.Connection;
import java.util.Date;
import java.util.Vector;

public interface IDEHelper {
    public static final String VCFIELD_VCMAN = "SRFVCMAN";
    public static final String VCFIELD_VCDATE = "SRFVCDATE";
    public static final String VCFIELD_VCSTATE = "SRFVCSTATE";
    public static final String VCFIELD_VCVER = "SRFVCVER";
    public static final String VCFIELD_VCMEMO = "SRFVCMEMO";

    public boolean Init(DataEntity var1, IDAModelHelper var2, ISRFDAGlobalHelper var3);

    public String getId();

    public String getName();

    public String getLogicName();

    public ISRFDAGlobalHelper getGlobalHelper();

    public String getLogicName(String var1);

    public String GetFullName();

    public int getVersion();

    public String GetMajorDEId();

    public String GetMajorDERId();

    public String GetMajorDERType();

    public IDEHelper GetMajorDEHelper();

    public String GetMajorDEPickupField();

    public Vector<IDEFHelper> GetDEFHelpers();

    public IDEFHelper GetDEFHelper(DEField var1);

    public IDEFHelper GetDEFHelper(String var1);

    public IDEFHelper GetDEFHelperByPreDefineType(String var1);

    public boolean IsContainDEField(String var1);

    public String GetPickupPageId();

    public String GetMPickupPageId();

    public String GetEditPageId();

    public String GetGridPageId();

    public String GetInfoPageId();

    @Deprecated
    public IDEFHelper GetKeyDEFHelper();

    public IDEFHelper getKeyDEFHelper();

    public IDEFHelper GetMajorDEFHelper();

    public IDEFHelper GetIndexTypeDEFHelper();

    public IDEFHelper GetUpdateDateDEFHelper();

    public String GetDEViewName();

    public DataEntity getDataEntity();

    public boolean PrepareDEFields(boolean var1);

    public String GetMainTable();

    public String GetUserTable();

    public String GetTableSpace();

    public boolean IsLogicValid();

    public String GetInsertProcName();

    public String GetUpdateProcName();

    public String GetDeleteProcName();

    public String GetInsertProcCode();

    public String GetUpdateProcCode();

    public String GetDeleteProcCode();

    public String GetSelectCode(Vector<ProcParam> var1);

    public String GetSelectCode(BaseDataEntity var1, Vector<ProcParam> var2);

    public String GetSelectCode(String var1, ISRFDAWebContext var2, BaseDataEntity var3, Vector<CallParam> var4);

    public String GetCheckKeyCode(Vector<ProcParam> var1);

    public IDEDataCtrl GetDEDataCtrl(String var1, ISRFDAWebContext var2);

    public String GetDataInfo(BaseDataEntity var1);

    public String GetToolTip(BaseDataEntity var1, ISRFDAWebContext var2, String var3);

    public String GetInfoFormat();

    public String GetInfoFields();

    public IPickupDEFHelper FindPickupDEFHelper(String var1);

    public IDEFHelper CreateDEFHelper(DEField var1);

    public boolean IsSupportFA();

    public boolean IsIndexDE();

    public int GetIndexMode();

    public boolean IsDER11DE();

    public boolean IsEnableWF();

    public boolean IsEnableDP();

    public DEWF GetDEWF();

    public IDEWFHelper GetDEWFHelper() throws Exception;

    public String GetDEWFId(String var1);

    public String GetDEWFFormName(String var1, String var2, IDESubWFHelper var3, String var4) throws Exception;

    public IDataAccHelper GetDataAccHelper();

    public boolean IsEnableAudit();

    public boolean IsLogAuditDetail();

    public IPickupDEFHelper GetPickupDEFHelper(ILinkDEFHelper var1);

    public boolean IsInheritMode();

    public IDEHelper GetInheritDEHelper();

    public String GetInheritDERId();

    public DERINDEX GetInheritDER() throws Exception;

    public String GetDBStorage();

    public String GetProperty(String var1);

    public String GetProperty(String var1, String var2);

    public boolean GetProperty(String var1, boolean var2);

    public int GetProperty(String var1, int var2);

    public boolean IsExistingModel();

    public IDAConfigHelper GetDAConfigHelper(String var1, String var2);

    public String GetDBType();

    public Vector<DEDataCtrl> GetDEDC(String var1, String var2);

    public Vector<DER1N> GetDER1Ns(boolean var1);

    public Vector<DER11> GetDER11s(boolean var1);

    public Vector<IDER1NHelper> GetDER1Ns();

    public Vector<IDER11Helper> GetDER11s();

    public Vector<DERINDEX> GetDERINDEXs(boolean var1);

    public DERINDEX FindDERINDEX(String var1);

    public DER1N FindDER1N(String var1);

    public Vector<DERCUSTOM> GetDERCUSTOMs(boolean var1);

    public DERCUSTOM FindDERCUSTOM(boolean var1, String var2);

    public DEACMode GetACMode(String var1);

    public CallResult GetProcParams(String var1, Vector<ProcParam> var2);

    public CallResult GetDBAction(String var1, String var2);

    public void RemoveUncopyValue(BaseDataEntity var1);

    public CallResult PrepareDBProc(boolean var1);

    public CallResult PrepareDBProc(String var1, String var2);

    public boolean IsInheritDEField(IDEFHelper var1);

    public boolean HasDataNotify(int var1, boolean var2);

    public boolean HasDataNotify();

    public void ListDataNotifies(int var1, boolean var2, Vector<DataNotify> var3);

    public Vector<DataNotify> GetDataNotifies();

    public boolean IsEnableUserCreate();

    public boolean IsEnableUserUpdate();

    public boolean IsEnableUserDelete();

    public boolean IsEnableUserView();

    public CallResult RemoveExpiredProc();

    public CallResult GetDynamicTables(Date var1, Date var2, Vector<String> var3);

    public String GetDBSchema();

    public boolean IsDBUnicodeChar();

    public boolean IsEnableDEFieldPriv();

    public DEDataImport GetDataImport(String var1);

    public BaseDataEntity CreateDEObject();

    public DEAction GetDEAction(String var1);

    public DESubWF GetDESubWF(String var1);

    public IDESubWFHelper GetDESubWFHelper(String var1) throws Exception;

    public DEWizard GetDEWizard(String var1);

    public DEWizard GetDefaultCreateWizard();

    public Vector<DEWizard> GetCreateWizards();

    public CallResult PrepareDBObject(String var1);

    public String GetQuickSearchMask(String var1);

    public boolean IsEnableQuickSearch();

    public boolean IsEnablePrint();

    public boolean IsEnableHelp();

    public boolean IsEnableImport();

    public boolean IsEnableExport();

    public String GetDGColumns();

    public String GetSearchableColumns();

    public BaseDAQueryModelHelper GetDAQueryModelHelper(String var1);

    public void RegisterDAQueryModelHelper(String var1, BaseDAQueryModelHelper var2);

    public boolean IsEnableModile();

    public DEMobile GetDEMobile();

    public IDAMBConfigHelper GetDAMBConfigHelper(String var1, String var2) throws Exception;

    public String GetDataLockKey(ISRFDAWebContext var1, BaseDataEntity var2) throws Exception;

    public void LogFieldCaretTempl(BaseDataEntity var1, String var2);

    public IDER11Helper FindDER11(String var1) throws Exception;

    public IDER1NHelper FindDER1N2(String var1) throws Exception;

    public Vector<ISummaryPageHelper> GetSummaryPages() throws Exception;

    public boolean IsExtendDER1N(String var1);

    public int GetDataChangeLogMode();

    public boolean IsExportIncEmpty();

    public Vector<DEDataSync> GetDEDataSyncs(boolean var1);

    public boolean IsEnablePwdStorage();

    public Vector<IDEFHelper> GetPwdStorageFields();

    public boolean IsEnableDEMainState();

    public IDEMainStateHelper GetDefaultDEMainState();

    public IDEMainStateHelper FindDEMainState(String var1) throws Exception;

    public IDEMainStateHelper FindDEMainState(String var1, String var2);

    public boolean HasDEMainStateMapTo(String var1);

    public IDEMainStateHelper CalcDEMainState(Object var1) throws Exception;

    public IDEMainStateHelper CalcDEMainState(BaseDataEntity var1) throws Exception;

    public IDEMainStateHelper CalcDEMainState(Connection var1, BaseDataEntity var2) throws Exception;

    public IDEMainActionHelper FindDEMainAction(String var1) throws Exception;

    public boolean HasDEMainAction(String var1);

    public IDERGroupHelper FindDERGroup(String var1) throws Exception;

    public void SetAttribute(String var1, Object var2);

    public Object GetAttribute(String var1);

    public boolean IsEnableEncryptStorage();

    public Vector<IDEFHelper> GetEncryptStorageFields();

    public IDataNotifyHelper GetDataNotifyHelper(DataNotify var1);

    public boolean IsMultiMajorDE();

    public String CalcMajorDEPickupField(BaseDataEntity var1);

    public String GetMajorDEId(String var1);

    public String GetMajorDERId(String var1);

    public String GetMajorDERType(String var1);

    public IDEHelper GetMajorDEHelper(String var1);

    public boolean IsMajorDE();

    public boolean HasPhisicalFormulaField();

    public boolean GetValidFlag();

    public String GetRuntimeInfo();

    public boolean IsEnableVersionControl();

    public Object getKeyValue(BaseDataEntity var1);
}

