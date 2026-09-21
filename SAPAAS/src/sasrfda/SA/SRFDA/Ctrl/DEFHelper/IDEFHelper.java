/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.ValueError
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.DEFHelper.DEFHelperConfig;
import SA.SRFDA.Ctrl.DEFHelper.IDEFDGItem;
import SA.SRFDA.Ctrl.DEFHelper.IDEFDTColumn;
import SA.SRFDA.Ctrl.DEFHelper.IDEFFormCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFMobileSetting;
import SA.SRFDA.Ctrl.DEFHelper.IDEFQueryHelper;
import SA.SRFDA.Ctrl.Data.DEField;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Model.SearchItemConfig;
import SA.SRFDA.Model.SearchModelConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.ValueError;
import java.util.Vector;

public interface IDEFHelper {
    public void SetParam(IDEHelper var1, DEField var2, DEFHelperConfig var3, ISRFDAGlobalHelper var4);

    public CallResult Init();

    public CallResult PrepareCreateDEField(Vector<ValueError> var1);

    public boolean IsInit();

    public IDEHelper getDEHelper();

    public DEField getDEField();

    public IDEFFormCtrl GetFormCtrl();

    public IDEFDTColumn GetDTColumn();

    public IDEFDGItem getDGItem();

    public String getId();

    public String getName();

    public String getLogicName();

    public String getLogicName(String var1);

    public String GetFullName();

    public String GetFormItemStyle();

    public String GetCodeList();

    public boolean IsLinkDEField();

    public boolean IsInheritDEField();

    public boolean IsFormulaDEField();

    public boolean IsFormulaPhisical();

    public boolean IsPhisicalDEField();

    public boolean IsMajorDEField();

    public boolean IsKeyDEField();

    public boolean IsIndexTypeDEField();

    public boolean IsIgnoreInherit();

    public boolean IsUserVisible();

    public String GetDataType();

    public boolean IsDupCheck();

    public IDEFHelper GetDupCheckRangeDEFHelper();

    public boolean IsPasteReset();

    public boolean IsSystemReserver();

    public SearchModelConfig GetSearchModel();

    public boolean IsSupportSearchAction(SearchItemConfig var1);

    public String GetUnit();

    public int GetUnitWidth();

    public String GetStdDataType();

    public IDEFQueryHelper GetQueryHelper();

    public String GetValueRule();

    public String GetValueRuleInfo();

    public Object GetDEFValue(String var1);

    public boolean IsEnableAudit();

    public String GetAuditInfoFormat();

    public int GetPrecision();

    public String GetDupCheckCode(boolean var1);

    public String GetProperty(String var1);

    public String GetProperty(String var1, String var2);

    public boolean IsEnableDEFieldPriv();

    public String GetStringCase();

    public IDEFMobileSetting getMobileSetting() throws Exception;

    public String getCaretTemplGroupId();

    public String getCaretRetMode();

    public String getUpdateOVMode();

    public String getCodeName();

    public int getPwdStorage();

    public boolean isEnableUpdate();

    public String getCodeListParam();

    public boolean isUIAssistField();

    public int getEncryptStorage();

    public String getInputTips();

    public boolean getValidFlag();
}

