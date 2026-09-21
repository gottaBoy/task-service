/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.ParameterDirectionHelper;
import SA.SRFramework.Utility.StringHelper;

public class DBCallerParam
extends XMLConfig {
    public static final String DIRECTION = "DIRECTION";
    public static final String DATATYPE = "DATATYPE";
    public static final String NAME = "NAME";
    public static final String PARAMNAME = "PARAMNAME";
    public static final String VALUE = "VALUE";
    public static final String TAG_KEY = "KEY";
    public static final String TAG_DECLAREPARAM = "DECLAREPARAM";
    public static final String TAG_CASTFUNC = "CASTFUNC";
    public static final String TAG_SEARCHACTION = "SEARCHACTION";
    public static final String TAG_MATCHACTION = "MATCHACTION";
    public static final String TAG_ENDOFDAY = "ENDOFDAY";
    public static final String TAG_UPDATE = "UPDATE";
    public static final String TAG_SEARCH = "SEARCH";
    public static final String TAG_DATATYPEEXT = "DATATYPEEXT";
    public static final String TAG_DATABASE = "DATABASE";
    public static final String TAG_RAWVALUE = "RAWVALUE";
    public static final String TAG_RAWVALUEFORMAT = "RAWVALUEFORMAT";
    public static final String TAG_VALUEMODE = "VALUEMODE";
    public static final String VALUEMODE_IDENTITY = "IDENTITY";
    public static final String VALUEMODE_SEQUENCE = "SEQUENCE";
    public static final String VALUEMODE_GUID = "GUID";
    public static final String TAG_CURTIMECONVERT = "CURTIMECONVERT";
    public static final String CURTIMECONVERT_YEAR = "YEAR";
    public static final String CURTIMECONVERT_MONTH = "MONTH";
    public static final String CURTIMECONVERT_DAY = "DAY";
    public static final String CURTIMECONVERT_HOUR = "HOUR";
    public static final String CURTIMECONVERT_MINUTE = "MINUTE";
    public static final String CURTIMECONVERT_SECOND = "SECOND";
    protected int paramDataType = 25;
    protected String strDataType;
    protected int direction = 1;
    protected String strParamName = "";
    protected String strParamValue = "";
    protected String strOriginParamValue = "";
    protected boolean bEndOfDay = false;
    protected boolean bKey = false;
    protected boolean bUpdate = true;
    protected String strDataTypeExt = "";
    protected String strDatabase = "";
    protected boolean bRawValue = false;
    protected boolean bDeclareParam = true;
    protected String strValueMode = "";
    protected String strMatchAction = "=";
    protected String strCastFunc = "";
    protected String strRawValueFormat = "";
    protected String strCurTimeConvert = "";

    public int getDirection() {
        return this.direction;
    }

    public int getDBType() {
        return this.paramDataType;
    }

    public String getParamName() {
        if (StringHelper.Length(this.strParamName) > 0) {
            return this.strParamName;
        }
        return this.getID();
    }

    public void setParamName(String strParamName) {
        this.strParamName = strParamName;
    }

    public String getParamValue() {
        return this.strParamValue;
    }

    public String getOriginParamValue() {
        return this.strOriginParamValue;
    }

    public void setEndOfDay(boolean bEndOfDay) {
        this.bEndOfDay = bEndOfDay;
    }

    public boolean getEndOfDay() {
        return this.bEndOfDay;
    }

    public void setKey(boolean bKey) {
        this.bKey = bKey;
    }

    public boolean getKey() {
        return this.bKey;
    }

    public void setUpdate(boolean bUpdate) {
        this.bUpdate = bUpdate;
    }

    public boolean getUpdate() {
        return this.bUpdate;
    }

    public void setSearch(boolean bSearch) {
        this.bUpdate = bSearch;
    }

    public boolean getSearch() {
        return this.bUpdate;
    }

    public void setDataTypeExt(String strDataTypeExt) {
        this.strDataTypeExt = strDataTypeExt;
    }

    public String getDataTypeExt() {
        return this.strDataTypeExt;
    }

    public void setMatchAction(String strMatchAction) {
        this.strMatchAction = strMatchAction;
    }

    public String getMatchAction() {
        return this.strMatchAction;
    }

    public void setCastFunc(String strCastFunc) {
        this.strCastFunc = strCastFunc;
    }

    public String getCastFunc() {
        return this.strCastFunc;
    }

    public void setDataType(String strDataType) {
        this.strDataType = strDataType;
    }

    public String getDataType() {
        return this.strDataType;
    }

    public String getDatabase() {
        return this.strDatabase;
    }

    public void setDatabase(String strDatabase) {
        this.strDatabase = strDatabase;
    }

    public void setRawValue(boolean bRawValue) {
        this.bRawValue = bRawValue;
    }

    public boolean getRawValue() {
        return this.bRawValue;
    }

    public void setDeclareParam(boolean bDeclareParam) {
        this.bDeclareParam = bDeclareParam;
    }

    public boolean getDeclareParam() {
        return this.bDeclareParam;
    }

    public String getValueMode() {
        return this.strValueMode;
    }

    public void setValueMode(String strValueMode) {
        this.strValueMode = strValueMode;
    }

    public String getRawValueFormat() {
        return this.strRawValueFormat;
    }

    public void setRawValueFormat(String strRawValueFormat) {
        this.strRawValueFormat = strRawValueFormat;
    }

    public String getCurTimeConvert() {
        return this.strCurTimeConvert;
    }

    public void setCurTimeConvert(String strCurTimeConvert) {
        this.strCurTimeConvert = strCurTimeConvert;
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (strName.compareToIgnoreCase(DIRECTION) == 0) {
            this.direction = ParameterDirectionHelper.FromString(strValue);
            return;
        }
        if (strName.compareToIgnoreCase(DATATYPE) == 0) {
            this.strDataType = strValue;
            this.paramDataType = DataTypeHelper.FromString(strValue);
            return;
        }
        if (strName.compareToIgnoreCase(NAME) == 0 || strName.compareToIgnoreCase(PARAMNAME) == 0) {
            this.strParamName = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(VALUE) == 0) {
            this.strOriginParamValue = this.strParamValue = strValue;
            this.strParamValue = this.strParamValue.toUpperCase();
            return;
        }
        if (StringHelper.Compare(strName, TAG_ENDOFDAY, true) == 0) {
            this.bEndOfDay = DBCallerParam.GetValue(strValue, this.bEndOfDay);
            return;
        }
        if (StringHelper.Compare(strName, TAG_KEY, true) == 0) {
            this.bKey = DBCallerParam.GetValue(strValue, this.bKey);
            return;
        }
        if (StringHelper.Compare(strName, TAG_UPDATE, true) == 0 || StringHelper.Compare(strName, TAG_SEARCH, true) == 0) {
            this.bUpdate = DBCallerParam.GetValue(strValue, this.bUpdate);
            return;
        }
        if (StringHelper.Compare(strName, TAG_DATATYPEEXT, true) == 0) {
            this.strDataTypeExt = strValue;
            return;
        }
        if (StringHelper.Compare(strName, TAG_DATABASE, true) == 0) {
            this.strDatabase = strValue;
            return;
        }
        if (StringHelper.Compare(strName, TAG_RAWVALUE, true) == 0) {
            this.bRawValue = DBCallerParam.GetValue(strValue, this.bRawValue);
            return;
        }
        if (StringHelper.Compare(strName, TAG_DECLAREPARAM, true) == 0) {
            this.bDeclareParam = DBCallerParam.GetValue(strValue, this.bDeclareParam);
            return;
        }
        if (StringHelper.Compare(strName, TAG_VALUEMODE, true) == 0) {
            this.strValueMode = strValue;
            return;
        }
        if (StringHelper.Compare(strName, TAG_SEARCHACTION, true) == 0 || StringHelper.Compare(strName, TAG_MATCHACTION, true) == 0) {
            this.strMatchAction = strValue;
            return;
        }
        if (StringHelper.Compare(strName, TAG_CASTFUNC, true) == 0) {
            this.strCastFunc = strValue;
            return;
        }
        if (StringHelper.Compare(strName, TAG_RAWVALUEFORMAT, true) == 0) {
            this.strRawValueFormat = strValue;
            return;
        }
        if (StringHelper.Compare(strName, TAG_CURTIMECONVERT, true) == 0) {
            this.strCurTimeConvert = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }
}

