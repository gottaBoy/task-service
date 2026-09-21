/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.ValueRule.ValueRuleConfig;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;
import org.w3c.dom.Node;

public class DataGridEditItemConfig
extends XMLConfig {
    public static final String TAG_DATAGRIDEDITITEM = "SRFEXDATAGRIDEDITITEM";
    public static final String TAG_KEY = "KEY";
    public static final String TAG_DBFIELD = "DBFIELD";
    public static final String TAG_EMPTY = "EMPTY";
    public static final String TAG_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String TAG_NAME = "NAME";
    public static final String TAG_MAXLENGTH = "MAXLENGTH";
    public static final String TAG_ERRORS = "ERRORS";
    public static final String TAG_ENDOFDAY = "ENDOFDAY";
    public static final String TAG_VALUERULEID = "VALUERULEID";
    public static final String TAG_ENABLECOND = "ENABLECOND";
    public static final String TAG_VALIDCOND = "VALIDCOND";
    public static final String TAG_ALLOWEMPTYCOND = "ALLOWEMPTYCOND";
    public static final String TAG_VALUERULECODE = "VALUERULECODE";
    public static final String TAG_VALUERULEINFO = "VALUERULEINFO";
    public static final String TAG_DVT = "DVT";
    public static final String TAG_DV = "DV";
    public static final String TAG_PRECISION = "PRECISION";
    public static final String TAG_STRINGCASE = "STRINGCASE";
    public static final String STRINGCASE_UCASE = "UCASE";
    public static final String STRINGCASE_LCASE = "LCASE";
    protected boolean bKey = false;
    protected String strDBField = "";
    protected boolean bAllowEmpty = true;
    protected String strName = "";
    protected ValueRuleConfig valueRuleConfig = null;
    protected boolean bEndOfDay = false;
    protected String strErrors = "";
    protected int nMaxLength = 0;
    protected String strValueRuleId = "";
    protected String strAllowEmptyCond = "";
    protected String strValueRuleCode = "";
    protected String strValueRuleInfo = "";
    protected DataGridDSItemConfig dataGridDSItemConfig = null;
    protected String strValidCond = "ALL";
    protected String strDVT = "";
    protected String strDV = "";
    protected int nPrecision = -1;
    protected String strStringCase = "";

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)"SRFEXVALUERULE", (String)strName, (boolean)true) == 0) {
            if (this.valueRuleConfig == null) {
                this.valueRuleConfig = new ValueRuleConfig();
                this.valueRuleConfig.LoadConfig(xmlNode);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_KEY, (boolean)true) == 0) {
            this.bKey = DataGridEditItemConfig.GetValue((String)strValue, (boolean)this.bKey);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_EMPTY, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_ALLOWEMPTY, (boolean)true) == 0) {
            this.bAllowEmpty = DataGridEditItemConfig.GetValue((String)strValue, (boolean)this.bAllowEmpty);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DBFIELD, (boolean)true) == 0) {
            this.strDBField = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_NAME, (boolean)true) == 0) {
            this.strName = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ENDOFDAY, (boolean)true) == 0) {
            this.bEndOfDay = DataGridEditItemConfig.GetValue((String)strValue, (boolean)this.bEndOfDay);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ERRORS, (boolean)true) == 0) {
            this.strErrors = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_MAXLENGTH, (boolean)true) == 0) {
            this.nMaxLength = DataGridEditItemConfig.GetValue((String)strValue, (int)0);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_VALUERULEID, (boolean)true) == 0) {
            this.strValueRuleId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ALLOWEMPTYCOND, (boolean)true) == 0) {
            this.strAllowEmptyCond = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_VALUERULECODE, (boolean)true) == 0) {
            this.strValueRuleCode = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_VALUERULEINFO, (boolean)true) == 0) {
            this.strValueRuleInfo = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_VALIDCOND, (boolean)true) == 0) {
            this.strValidCond = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DVT, (boolean)true) == 0) {
            this.strDVT = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DV, (boolean)true) == 0) {
            this.strDV = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PRECISION, (boolean)true) == 0) {
            this.nPrecision = DataGridEditItemConfig.GetValue((String)strValue, (int)-1);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_STRINGCASE, (boolean)true) == 0) {
            this.setStringCase(strValue);
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

    public void setKey(boolean bKey) {
        this.bKey = bKey;
    }

    public boolean getKey() {
        return this.bKey;
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

    public int getMaxLength() {
        return this.nMaxLength;
    }

    public void setMaxLength(int nMaxLength) {
        this.nMaxLength = nMaxLength;
    }

    public String getDBField() {
        if (StringHelper.Length((String)this.strDBField) == 0) {
            return this.dataGridDSItemConfig.getID();
        }
        return this.strDBField;
    }

    public int getDataType() {
        return this.dataGridDSItemConfig.getDataType();
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

    public String getErrors() {
        return this.strErrors;
    }

    public void setErrors(String strErrors) {
        this.strErrors = strErrors;
    }

    public void setValueRuleId(String strValueRuleId) {
        this.strValueRuleId = strValueRuleId;
    }

    public String getValueRuleId() {
        return this.strValueRuleId;
    }

    public DataGridDSItemConfig getDataGridDSItemConfig() {
        return this.dataGridDSItemConfig;
    }

    public void setDataGridDSItemConfig(DataGridDSItemConfig dataGridDSItemConfig) {
        this.dataGridDSItemConfig = dataGridDSItemConfig;
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

    public String getAllowEmptyCond() {
        return this.strAllowEmptyCond;
    }

    public void setAllowEmptyCond(String strAllowEmptyCond) {
        this.strAllowEmptyCond = strAllowEmptyCond;
    }

    public String getValidCond() {
        return this.strValidCond;
    }

    public void setValidCond(String strValidCond) {
        this.strValidCond = strValidCond;
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

    public int getPrecision() {
        return this.nPrecision;
    }

    public void setPrecision(int nPrecision) {
        this.nPrecision = nPrecision;
    }

    public String getStringCase() {
        return this.strStringCase;
    }

    public void setStringCase(String strStringCase) {
        this.strStringCase = strStringCase;
    }
}

