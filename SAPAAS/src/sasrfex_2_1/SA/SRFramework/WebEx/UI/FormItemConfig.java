/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Common.SRFGlobal
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Common.SRFGlobal;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.ValueRule.ValueRuleConfig;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.BaseControlConfig;
import SA.SRFramework.WebEx.UI.FormItemErrorsConfig;
import SA.SRFramework.WebEx.UI.ItemParamConfig;
import SA.SRFramework.WebEx.UI.ItemParamsConfig;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.TimeZone;
import org.w3c.dom.Node;

public class FormItemConfig
extends XMLConfig {
    public static final String TAG_FORMITEM = "SRFEXFORMITEM";
    public static final String TAG_FORMID = "FORMID";
    public static final String TAG_ERRORREGIONID = "ERRORREGIONID";
    public static final String TAG_KEY = "KEY";
    public static final String TAG_DATATYPE = "DATATYPE";
    public static final String TAG_DBFIELD = "DBFIELD";
    public static final String TAG_EMPTY = "EMPTY";
    public static final String TAG_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String TAG_NAME = "NAME";
    public static final String TAG_ITEMFORMAT = "ITEMFORMAT";
    public static final String TAG_ENABLECOND = "ENABLECOND";
    public static final String TAG_ENABLECOND_ALL = "ALL";
    public static final String TAG_ENABLECOND_CREATE = "CREATE";
    public static final String TAG_ENABLECOND_UPDATE = "UPDATE";
    public static final String TAG_ENABLECOND_NONE = "NONE";
    public static final String TAG_MAINDATA = "MAINDATA";
    public static final String TAG_VALUERULEID = "VALUERULEID";
    public static final String TAG_MODE = "MODE";
    public static final String TAG_MAXLENGTH = "MAXLENGTH";
    public static final String TAG_VALUETRANSFORM = "VALUETRANSFORM";
    public static final String TAG_ERRORS = "ERRORS";
    public static final String TAG_ENDOFDAY = "ENDOFDAY";
    public static final String TAG_VALIDCOND = "VALIDCOND";
    public static final String TAG_ALLOWEMPTYCOND = "ALLOWEMPTYCOND";
    public static final String TAG_IGNOREVALUE = "IGNOREVALUE";
    public static final String TAG_VALUERULECODE = "VALUERULECODE";
    public static final String TAG_VALUERULEINFO = "VALUERULEINFO";
    public static final String TAG_DVT = "DVT";
    public static final String TAG_DV = "DV";
    public static final String TAG_DVT2 = "DVT2";
    public static final String TAG_DV2 = "DV2";
    public static final String TAG_REALID = "REALID";
    public static final String TAG_PRECISION = "PRECISION";
    public static final String TAG_PRIVILEGEID = "PRIVILEGEID";
    public static final String TAG_STRINGCASE = "STRINGCASE";
    public static final String STRINGCASE_UCASE = "UCASE";
    public static final String STRINGCASE_LCASE = "LCASE";
    protected String strFormId = "";
    protected String strErrorRegionId = "";
    protected boolean bKey = false;
    protected int nDataType = 25;
    protected String strDBField = "";
    protected boolean bAllowEmpty = true;
    protected String strName = "";
    protected BaseControlConfig controlConfig = null;
    protected FormItemErrorsConfig formItemErrorsConfig = null;
    protected ItemParamsConfig itemParamsConfig = null;
    protected ValueRuleConfig valueRuleConfig = null;
    protected String strItemFormat = "";
    protected boolean bEndOfDay = false;
    protected String strErrors = "";
    protected String strValueTransform = "";
    protected String strMode = "";
    protected int nMaxLength = 0;
    protected String strValueRuleId = "";
    protected boolean bMainData;
    protected String strEnableCond = "ALL";
    protected String strValidCond = "ALL";
    protected String strDVT = "";
    protected String strDV = "";
    protected String strDVT2 = "";
    protected String strDV2 = "";
    protected String strAllowEmptyCond = "";
    protected String strValueRuleCode = "";
    protected String strValueRuleInfo = "";
    protected int nPrecision = -1;
    protected boolean bOutputRealId = false;
    protected String strPrivilegeId = "";
    protected String strStringCase = "";
    static final int INDEX_FORMID = 1;
    static final int INDEX_ERRORREGIONID = 2;
    static final int INDEX_KEY = 3;
    static final int INDEX_DBFIELD = 4;
    static final int INDEX_NAME = 5;
    static final int INDEX_ITEMFORMAT = 6;
    static final int INDEX_ENDOFDAY = 7;
    static final int INDEX_ERRORS = 8;
    static final int INDEX_VALUETRANSFORM = 9;
    static final int INDEX_MODE = 10;
    static final int INDEX_MAXLENGTH = 11;
    static final int INDEX_VALUERULEID = 12;
    static final int INDEX_MAINDATA = 13;
    static final int INDEX_ENABLECOND = 14;
    static final int INDEX_VALIDCOND = 15;
    static final int INDEX_DVT = 16;
    static final int INDEX_DV = 17;
    static final int INDEX_DVT2 = 18;
    static final int INDEX_DV2 = 19;
    static final int INDEX_ALLOWEMPTYCOND = 20;
    static final int INDEX_VALUERULECODE = 21;
    static final int INDEX_VALUERULEINFO = 22;
    static final int INDEX_PRECISION = 23;
    static final int INDEX_REALID = 24;
    static final int INDEX_DATATYPE = 25;
    static final int INDEX_EMPTY = 26;
    static final int INDEX_ALLOWEMPTY = 27;
    static final int INDEX_PRIVILEGEID = 28;
    static final int INDEX_STRINGCASE = 29;
    private static HashMap<String, Integer> propertyMap = new HashMap();

    static {
        propertyMap.put(TAG_FORMID, 1);
        propertyMap.put(TAG_ERRORREGIONID, 2);
        propertyMap.put(TAG_KEY, 3);
        propertyMap.put(TAG_DBFIELD, 4);
        propertyMap.put(TAG_NAME, 5);
        propertyMap.put(TAG_ITEMFORMAT, 6);
        propertyMap.put(TAG_ENDOFDAY, 7);
        propertyMap.put(TAG_ERRORS, 8);
        propertyMap.put(TAG_VALUETRANSFORM, 9);
        propertyMap.put(TAG_MODE, 10);
        propertyMap.put(TAG_MAXLENGTH, 11);
        propertyMap.put(TAG_VALUERULEID, 12);
        propertyMap.put(TAG_MAINDATA, 13);
        propertyMap.put(TAG_ENABLECOND, 14);
        propertyMap.put(TAG_VALIDCOND, 15);
        propertyMap.put(TAG_DVT, 16);
        propertyMap.put(TAG_DV, 17);
        propertyMap.put(TAG_DVT2, 18);
        propertyMap.put(TAG_DV2, 19);
        propertyMap.put(TAG_ALLOWEMPTYCOND, 20);
        propertyMap.put(TAG_VALUERULECODE, 21);
        propertyMap.put(TAG_VALUERULEINFO, 22);
        propertyMap.put(TAG_PRECISION, 23);
        propertyMap.put(TAG_REALID, 24);
        propertyMap.put(TAG_DATATYPE, 25);
        propertyMap.put(TAG_EMPTY, 26);
        propertyMap.put(TAG_ALLOWEMPTY, 27);
        propertyMap.put(TAG_PRIVILEGEID, 28);
        propertyMap.put(TAG_STRINGCASE, 29);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)"SRFEXITEMPARAMS", (String)strName, (boolean)true) == 0) {
            if (this.itemParamsConfig == null) {
                this.itemParamsConfig = new ItemParamsConfig();
            }
            this.itemParamsConfig.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)"SRFEXVALUERULE", (String)strName, (boolean)true) == 0) {
            if (this.valueRuleConfig == null) {
                this.valueRuleConfig = new ValueRuleConfig();
                this.valueRuleConfig.LoadConfig(xmlNode);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public FormItemErrorsConfig getFormItemErrorsConfig() {
        return this.formItemErrorsConfig;
    }

    public ItemParamsConfig getItemParamsConfig() {
        return this.itemParamsConfig;
    }

    public void setControlConfig(BaseControlConfig controlConfig) {
        this.controlConfig = controlConfig;
    }

    public BaseControlConfig getControlConfig() {
        return this.controlConfig;
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (propertyMap.containsKey(strName.toUpperCase())) {
            switch (propertyMap.get(strName.toUpperCase())) {
                case 26: 
                case 27: {
                    this.bAllowEmpty = FormItemConfig.GetValue((String)strValue, (boolean)this.bAllowEmpty);
                    return;
                }
                case 25: {
                    this.nDataType = DataTypeHelper.FromString((String)strValue);
                    return;
                }
                case 3: {
                    this.bKey = FormItemConfig.GetValue((String)strValue, (boolean)this.bKey);
                    return;
                }
                case 5: {
                    this.strName = strValue;
                    return;
                }
                case 6: {
                    this.strItemFormat = strValue;
                    return;
                }
                case 1: {
                    this.strFormId = strValue;
                    return;
                }
                case 2: {
                    this.strErrorRegionId = strValue;
                    return;
                }
                case 4: {
                    this.strDBField = strValue;
                    return;
                }
                case 7: {
                    this.bEndOfDay = FormItemConfig.GetValue((String)strValue, (boolean)this.bEndOfDay);
                    return;
                }
                case 8: {
                    this.strErrors = strValue;
                    return;
                }
                case 9: {
                    this.strValueTransform = strValue;
                    return;
                }
                case 10: {
                    this.strMode = strValue;
                    return;
                }
                case 11: {
                    this.nMaxLength = FormItemConfig.GetValue((String)strValue, (int)0);
                    return;
                }
                case 12: {
                    this.strValueRuleId = strValue;
                    return;
                }
                case 13: {
                    this.bMainData = FormItemConfig.GetValue((String)strValue, (boolean)this.bMainData);
                    return;
                }
                case 14: {
                    this.strEnableCond = strValue;
                    return;
                }
                case 15: {
                    this.strValidCond = strValue;
                    return;
                }
                case 16: {
                    this.strDVT = strValue;
                    return;
                }
                case 17: {
                    this.strDV = strValue;
                    return;
                }
                case 18: {
                    this.strDVT2 = strValue;
                    return;
                }
                case 19: {
                    this.strDV2 = strValue;
                    return;
                }
                case 20: {
                    this.strAllowEmptyCond = strValue;
                    return;
                }
                case 21: {
                    this.strValueRuleCode = strValue;
                    return;
                }
                case 22: {
                    this.strValueRuleInfo = strValue;
                    return;
                }
                case 23: {
                    this.nPrecision = FormItemConfig.GetValue((String)strValue, (int)-1);
                    return;
                }
                case 24: {
                    this.bOutputRealId = FormItemConfig.GetValue((String)strValue, (boolean)this.bOutputRealId);
                    return;
                }
                case 28: {
                    this.setPrivilegeId(strValue);
                    return;
                }
                case 29: {
                    this.setStringCase(strValue);
                    return;
                }
            }
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public ValueRuleConfig getValueRuleConfig() {
        return this.valueRuleConfig;
    }

    public void setValueRuleConfig(ValueRuleConfig valueRuleConfig) {
        this.valueRuleConfig = valueRuleConfig;
    }

    public String getFormId() {
        return this.strFormId;
    }

    public void setFormId(String strFormId) {
        this.strFormId = strFormId;
    }

    public String getErrorRegionId() {
        return this.strErrorRegionId;
    }

    public void setErrorRegionId(String strErrorRegionId) {
        this.strErrorRegionId = strErrorRegionId;
    }

    public void setKey(boolean bKey) {
        this.bKey = bKey;
    }

    public boolean getKey() {
        return this.bKey;
    }

    public void setMainData(boolean bMainData) {
        this.bMainData = bMainData;
    }

    public boolean getMainData() {
        return this.bMainData || this.bKey;
    }

    public void setMode(String strMode) {
        this.strMode = strMode;
    }

    public String getMode() {
        return this.strMode;
    }

    public void setValueRuleId(String strValueRuleId) {
        this.strValueRuleId = strValueRuleId;
    }

    public String getValueRuleId() {
        return this.strValueRuleId;
    }

    public String getRealFormItemId() {
        String strFormItemId = this.getID();
        if (StringHelper.Length((String)strFormItemId) == 0) {
            strFormItemId = this.getDBField();
        }
        if (StringHelper.Length((String)this.strMode) > 0) {
            return StringHelper.Format((String)"%1$s#%2$s", (Object)strFormItemId, (Object)this.strMode);
        }
        return strFormItemId;
    }

    public void setEndOfDay(boolean bEndOfDay) {
        this.bEndOfDay = bEndOfDay;
    }

    public boolean getEndOfDay() {
        return this.bEndOfDay;
    }

    public void setAllowEmpty(boolean bAllowEmpty) {
        this.bAllowEmpty = bAllowEmpty;
    }

    public boolean getAllowEmpty() {
        return this.bAllowEmpty;
    }

    public int getDataType() {
        return this.nDataType;
    }

    public void setDataType(int nDataType) {
        this.nDataType = nDataType;
    }

    public int getMaxLength() {
        return this.nMaxLength;
    }

    public void setMaxLength(int nMaxLength) {
        this.nMaxLength = nMaxLength;
    }

    public String getDBField() {
        if (StringHelper.Length((String)this.strDBField) == 0 && this.controlConfig != null) {
            return this.controlConfig.getID();
        }
        return this.strDBField;
    }

    public void setDBField(String strDBField) {
        this.strDBField = strDBField;
    }

    public String getName() {
        return this.strName;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public String getEnableCond() {
        return this.strEnableCond;
    }

    public void setEnableCond(String strEnableCond) {
        this.strEnableCond = strEnableCond;
    }

    public String getItemFormat() {
        return this.strItemFormat;
    }

    public void setItemFormat(String strItemFormat) {
        this.strItemFormat = strItemFormat;
    }

    public String getValidCond() {
        return this.strValidCond;
    }

    public void setValidCond(String strValidCond) {
        this.strValidCond = strValidCond;
    }

    public String getErrors() {
        return this.strErrors;
    }

    public void setErrors(String strErrors) {
        this.strErrors = strErrors;
    }

    public String getValueTransform() {
        return this.strValueTransform;
    }

    public void setValueTransform(String strValueTransform) {
        this.strValueTransform = strValueTransform;
    }

    public String GetFormItemValue(SRFExWebContext webContext, BaseDataEntity dataEntity) {
        return FormItemConfig.GetFormItemValue(webContext, this, dataEntity);
    }

    public String getDVT() {
        return this.strDVT;
    }

    public void setDVT(String strDVT) {
        this.strDVT = strDVT;
    }

    public String getDV() {
        return this.strDV;
    }

    public void setDV(String strDV) {
        this.strDV = strDV;
    }

    public String getDVT2() {
        return this.strDVT2;
    }

    public void setDVT2(String strDVT) {
        this.strDVT2 = strDVT;
    }

    public String getDV2() {
        return this.strDV2;
    }

    public void setDV2(String strDV) {
        this.strDV2 = strDV;
    }

    public String getAllowEmptyCond() {
        return this.strAllowEmptyCond;
    }

    public void setAllowEmptyCond(String strAllowEmptyCond) {
        this.strAllowEmptyCond = strAllowEmptyCond;
    }

    public String getValueRuleCode() {
        return this.strValueRuleCode;
    }

    public String getValueRuleInfo() {
        return this.strValueRuleInfo;
    }

    public void setValueRuleCode(String strValueRuleCode) {
        this.strValueRuleCode = strValueRuleCode;
    }

    public void setValueRuleInfo(String strValueRuleInfo) {
        this.strValueRuleInfo = strValueRuleInfo;
    }

    public int getPrecision() {
        return this.nPrecision;
    }

    public void setPrecision(int nPrecision) {
        this.nPrecision = nPrecision;
    }

    public void setRealId(boolean bOutputRealId) {
        this.bOutputRealId = bOutputRealId;
    }

    public boolean isOutputRealId() {
        return this.bOutputRealId;
    }

    public void setOutputRealId(boolean bOutputRealId) {
        this.bOutputRealId = bOutputRealId;
    }

    public String getPrivilegeId() {
        return this.strPrivilegeId;
    }

    public void setPrivilegeId(String strPrivilegeId) {
        this.strPrivilegeId = strPrivilegeId;
    }

    public String getStringCase() {
        return this.strStringCase;
    }

    public void setStringCase(String strStringCase) {
        this.strStringCase = strStringCase;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected static String GetFormItemValue(SRFExWebContext webContext, FormItemConfig formItemConfig, BaseDataEntity dataEntity) {
        try {
            String strItemFormat = formItemConfig.getItemFormat();
            ItemParamsConfig itemParamsConfig = formItemConfig.getItemParamsConfig();
            if (StringHelper.Length((String)strItemFormat) == 0) {
                Object objValue = dataEntity.GetParamValue(formItemConfig.getDBField());
                if (objValue == null) {
                    return "";
                }
                if (SRFGlobal.isMultiTimeZone() && DateParser.isDateTimeType((Object)objValue)) {
                    objValue = DateParser.AdjustByTimeZone((Object)objValue, (TimeZone)webContext.getCurTimeZone(), (boolean)false);
                }
                if (objValue instanceof Timestamp) {
                    Timestamp ti = (Timestamp)objValue;
                    if (String.format("%1$tH:%1$tM:%1$tS", ti).equals("00:00:00")) {
                        return String.format("%1$tY-%1$tm-%1$td", ti);
                    }
                    return String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", ti);
                }
                if (objValue instanceof Time) {
                    Time ti = (Time)objValue;
                    if (String.format("%1$tH:%1$tM:%1$tS", ti).equals("00:00:00")) {
                        return String.format("%1$tY-%1$tm-%1$td", ti);
                    }
                    return String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", ti);
                }
                if (!(objValue instanceof Date)) {
                    return objValue.toString();
                }
                Date ti = (Date)objValue;
                if (String.format("%1$tH:%1$tM:%1$tS", ti).equals("00:00:00")) {
                    return String.format("%1$tY-%1$tm-%1$td", ti);
                }
                return String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", ti);
            }
            if (itemParamsConfig == null) {
                Object objValue = dataEntity.GetParamValue(formItemConfig.getDBField());
                if (objValue == null) {
                    return "";
                }
                if (SRFGlobal.isMultiTimeZone() && DateParser.isDateTimeType((Object)objValue)) {
                    return StringHelper.Format((String)strItemFormat, (Object)DateParser.AdjustByTimeZone((Object)objValue, (TimeZone)webContext.getCurTimeZone(), (boolean)false));
                }
                return StringHelper.Format((String)strItemFormat, (Object)objValue);
            }
            Object[] valueObj = new Object[itemParamsConfig.getList().size()];
            int i = 0;
            while (true) {
                if (i >= itemParamsConfig.getList().size()) {
                    return StringHelper.Format((String)strItemFormat, (Object[])valueObj);
                }
                ItemParamConfig itemParamConfig = (ItemParamConfig)((Object)itemParamsConfig.getList().get(i));
                valueObj[i] = itemParamConfig.GetParamValue(webContext, dataEntity);
                if (SRFGlobal.isMultiTimeZone() && DateParser.isDateTimeType((Object)valueObj[i])) {
                    valueObj[i] = DateParser.AdjustByTimeZone((Object)valueObj[i], (TimeZone)webContext.getCurTimeZone(), (boolean)false);
                }
                ++i;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
}

