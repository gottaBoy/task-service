/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEField
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEFGridColumn;
import SA.SRFDA.PS.Core.DEField.IPSDEFInputTip;
import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
import SA.SRFDA.PS.Core.DEField.IPSDEFUIMode;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldBase;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldType;
import SA.SRFDA.PS.Core.DEField.Search.IPSDEFSearch;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1NDEFieldMap;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEFLogic;
import SA.SRFDA.PS.Core.Database.IPSDEDBTable;
import SA.SRFDA.PS.Core.Database.IPSDEFDTColumn;
import SA.SRFDA.PS.Core.Database.IPSSysDBColumn;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysSampleValue;
import SA.SRFDA.PS.Core.Res.IPSSysSequence;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Core.Res.IPSSysUnit;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEField;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Data.PSDEFSearchMode;
import SA.SRFDA.PS.Data.PSDEFUIMode;
import SA.SRFDA.PS.Data.PSDEField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEField;

@PSModelInterfaceMeta(implement="PSDEFieldImpl", title="\u5b9e\u4f53\u5c5e\u6027\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEField")
@PSModelPFIgnoreMeta
public interface IPSDEField
extends IPSModelObject,
IDEField,
IPSDataEntityObject,
IPSDEFieldBase {
    public static final String PREDEFINEDTYPE_PARENTTYPE = "PARENTTYPE";
    public static final String PREDEFINEDTYPE_PARENTID = "PARENTID";
    public static final String PREDEFINEDTYPE_PARENTNAME = "PARENTNAME";
    public static final String PREDEFINEDTYPE_PARENTSUBTYPE = "PARENTSUBTYPE";
    public static final String PREDEFINEDTYPE_VERSION = "VERSION";
    public static final String PREDEFINEDTYPE_VERSIONID = "VERSIONID";
    public static final String PREDEFINEDTYPE_PARENTVERSION = "PARENTVERSION";
    public static final String PREDEFINEDTYPE_PARENTVERSIONID = "PARENTVERSIONID";
    public static final String SEQUENCEMODE_NONE = "NONE";
    public static final String SEQUENCEMODE_GETDRAFT = "GETDRAFT";
    public static final String SEQUENCEMODE_CREATE = "CREATE";
    public static final String TRANSLATORMODE_NONE = "NONE";
    public static final String TRANSLATORMODE_DIGEST = "DIGEST";
    public static final String TRANSLATORMODE_ENCRYPT = "ENCRYPT";
    public static final String TRANSLATORMODE_TRANSLATE = "TRANSLATE";
    public static final String TRANSLATORMODE_TRANSLATE2 = "TRANSLATE2";

    public void setInitParam(ISRFDAGlobalHelper var1, IPSDataEntity var2, IPSDEFieldType var3, PSDEField var4);

    public void init() throws Exception;

    public void init2() throws Exception;

    public boolean isInit();

    public IPSDEFieldType getPSDEFieldType();

    public PSDEField getPSDEFieldData();

    @Override
    public IPSDataEntity getPSDataEntity();

    public IPSDEFDTColumn getPSDTColumn(String var1) throws Exception;

    public String getLogicName(String var1);

    public String getLogicName();

    public String getLNLanResTag();

    public IPSLanguageRes getLNPSLanguageRes();

    public boolean isLinkDEField();

    public boolean isInheritDEField();

    public boolean isFormulaDEField();

    public boolean isFormulaPhisical();

    public boolean isPhisicalDEField();

    public boolean isIndexTypeDEField();

    public boolean isFormTypeDEField();

    public boolean isIgnoreInherit();

    public boolean isUserVisible();

    public boolean isPasteReset();

    public boolean isSystemReserver();

    public String getUnit();

    public int getUnitWidth();

    public String getUnitLanResTag();

    public Object getDEFValue(String var1);

    public boolean isEnableAudit();

    public String getAuditInfoFormat();

    @Override
    public int getPrecision();

    public String getDupCheckCode(boolean var1);

    public boolean isEnablePriv();

    public String getStringCase();

    public String getUpdateOVMode();

    @Override
    public String getCodeName();

    public boolean isEnableUserInsert();

    public boolean isEnableUserUpdate();

    public boolean testUserInput(int var1);

    public int getUserInputMode();

    public String getCodeListParam();

    public int getEncryptStorage();

    @Override
    public String getFullName();

    public IPSDEFGridColumn createPSDEFGridColumn(PSDEFUIMode var1) throws Exception;

    public IPSDEFUIMode createPSDEFUIMode(PSDEFUIMode var1) throws Exception;

    public Iterator<IPSDEFUIMode> getAllPSDEFUIModes() throws Exception;

    public IPSDEFUIMode getPSDEFUIMode(String var1) throws Exception;

    public IPSDEFUIMode getPSDEFUIMode(String var1, boolean var2) throws Exception;

    public IPSDEFSearchMode createPSDEFSearchMode(PSDEFSearchMode var1) throws Exception;

    public IPSDEFSearchMode getPSDEFSearchMode(String var1, boolean var2) throws Exception;

    public IPSDEFSearchMode getPSDEFSearchMode(String var1) throws Exception;

    public Iterator<IPSDEFSearchMode> getAllPSDEFSearchModes() throws Exception;

    public boolean isAllowEmpty();

    public IPSDEFValueRule getPSDEFValueRule(String var1) throws Exception;

    public IPSDEFValueRule getPSDEFValueRule(String var1, boolean var2) throws Exception;

    public Iterator<IPSDEFValueRule> getAllPSDEFValueRules() throws Exception;

    public String getValueFormat();

    public void setPreDefinedType(String var1);

    public int getEnableUserInput();

    public String getUnionKeyValue();

    public boolean isMultiFormDEField();

    public IPSCodeList getPSCodeList() throws Exception;

    public String getDupCheckMode();

    public String[] getDupCheckValues();

    public IPSDEField getDupCheckPSDEField() throws Exception;

    public IPSDEField getNo2DupCheckPSDEField() throws Exception;

    public IPSDEField getNo3DupCheckPSDEField() throws Exception;

    public Iterator<IPSDEField> getDupCheckPSDEFields() throws Exception;

    public int getLength();

    @Override
    public int getStringLength();

    public String getDefaultValueType();

    public String getDefaultValue();

    public boolean isQueryColumn();

    public String getPSSysValueRuleId();

    @Override
    public IPSSysValueRule getPSSysValueRule() throws Exception;

    public IPSDEField getRestrictedPSDEField() throws Exception;

    public String getDEMSFieldMode();

    public String getTableName();

    public String getTestDataValue();

    public IPSSysSampleValue getPSSampleValue();

    public IPSSysSampleValue getPSSysSampleValue();

    public String getXmlTagName();

    public boolean isEnableTempData();

    public IPSDEFInputTip getDefaultPSDEFInputTip();

    public IPSDEFInputTip getPSDEFInputTip(String var1) throws Exception;

    public IPSDEFInputTip getPSDEFInputTip(String var1, boolean var2) throws Exception;

    public Iterator<IPSDEFInputTip> getAllPSDEFInputTips() throws Exception;

    public int getOrderValue();

    public IPSSysUnit getPSSysUnit();

    public long getCreateTime();

    public IPSLanguageRes getUnitPSLanguageRes();

    public boolean isCheckRecursion();

    public int getViewLevel();

    public boolean isQueryColumn(int var1);

    @Deprecated
    public IPSDEFDTColumn getPSDETDTColumn(String var1) throws Exception;

    public IPSDEFDTColumn getPSDEFDTColumn(String var1) throws Exception;

    public Iterator<IPSDEFDTColumn> getAllPSDEFDTColumns() throws Exception;

    public IPSDEFSearchMode getDefaultPSDEFSearchMode();

    public String getPredefinedType();

    public String getNullValueOrderMode();

    public String getBizTag();

    public String getServiceCodeName();

    public IPSDEDBTable getPSDEDBTable() throws Exception;

    public IPSSysDBColumn getPSSysDBColumn() throws Exception;

    public IPSSubSysServiceAPIDEField getPSSubSysServiceAPIDEField() throws Exception;

    public IPSDEFSearch getPSDEFSearch(String var1) throws Exception;

    public IPSDEFSearch getPSDEFSearch(String var1, boolean var2) throws Exception;

    public Iterator<IPSDEFSearch> getAllPSDEFSearchs() throws Exception;

    public Iterator<IPSDEFSearch> getAllPSDEFSearches() throws Exception;

    public boolean isUIAssistDEField();

    @Override
    public int getMinStringLength();

    @Override
    public String getMaxValueString();

    @Override
    public String getMinValueString();

    public Iterator<IPSDEFLogic> getAllPSDEFLogics() throws Exception;

    public IPSDEFLogic getDefaultValuePSDEFLogic() throws Exception;

    public IPSDEFLogic getOnChangePSDEFLogic() throws Exception;

    public IPSDEFLogic getComputePSDEFLogic() throws Exception;

    public IPSDEFLogic getCheckPSDEFLogic() throws Exception;

    public int getEnableActions();

    public boolean isEnableCreate();

    public boolean isEnableModify();

    public boolean isEnableUICreate();

    public boolean isEnableUIModify();

    public IPSDEFDTColumn getDefaultPSDEFDTColumn() throws Exception;

    public IPSSysSequence getPSSysSequence() throws Exception;

    public Iterator<IPSDER1NDEFieldMap> getMajorPSDER1NDEFieldMaps() throws Exception;

    public Iterator<IPSDER1NDEFieldMap> getMinorPSDER1NDEFieldMaps() throws Exception;

    public IPSDEField getValuePSDEField() throws Exception;

    public String getComputeExpression();

    public String getSequenceMode();

    public String getTranslatorMode();

    public IPSSysTranslator getPSSysTranslator() throws Exception;

    public boolean isKeyDEField();

    public boolean isUniTagField();

    public boolean isMajorDEField();

    public boolean isKeyNameDEField();

    public String getDataType();

    public int getStdDataType();

    public boolean isEnableQuickSearch();

    public boolean isEnablePrivilege();

    public int getImportOrder();

    public String getImportTag();

    public boolean isEnableDBAutoValue();

    public int getDEFType();

    public boolean isDynaStorageDEField();

    public boolean isDataTypeDEField();

    public IPSDEFLogic getUserPSDEFLogic() throws Exception;

    public IPSDEFLogic getUser2PSDEFLogic() throws Exception;

    public IPSDEFLogic getUser3PSDEFLogic() throws Exception;

    public IPSDEFLogic getUser4PSDEFLogic() throws Exception;

    public String getQueryOption();

    public String getJsonFormat();

    public String getJSFormat();

    public String getFieldTag();

    public String getFieldTag2();

    public IPSSysTranslator getImportPSSysTranslator() throws Exception;

    public IPSSysTranslator getExportPSSysTranslator() throws Exception;

    public String getPredefinedTypeParam();

    public IPSCodeList getInlinePSCodeList();
}

