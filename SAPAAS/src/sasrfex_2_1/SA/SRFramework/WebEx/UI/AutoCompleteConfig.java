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

public class AutoCompleteConfig
extends XMLConfig {
    public static final String TAG_AUTOCOMPLETE = "SRFEXAUTOCOMPLETE";
    public static final String TAG_TYPE = "TYPE";
    public static final String TAG_CODELIST = "CODELIST";
    public static final String TAG_BACKENDCONFIG = "BACKENDCONFIG";
    public static final String TAG_BACKENDCTRL = "BACKENDCTRL";
    public static final String TAG_CTRLOBJECT = "CTRLOBJECT";
    public static final String TAG_CTRLID = "CTRLID";
    public static final String TAG_MAXRECORD = "MAXRECORD";
    public static final String TAG_TEXTFIELD = "TEXTFIELD";
    public static final String TAG_TEXTFORMAT = "TEXTFORMAT";
    public static final String TAG_REALTEXTFIELD = "REALTEXTFIELD";
    public static final String TAG_REALTEXTFORMAT = "REALTEXTFORMAT";
    public static final String TAG_VALUEFIELD = "VALUEFIELD";
    public static final String TAG_VALUEFORMAT = "VALUEFORMAT";
    public static final String TAG_CONDITION = "CONDITION";
    public static final String TAG_EXTCONDITION = "EXTCONDITION";
    public static final String TAG_EXTFETCH = "EXTFETCH";
    protected String strType = "";
    protected String strCodeList = "";
    protected String strBackEndCtrl = "";
    protected String strBackEndConfig = "";
    protected String strCtrlObject = "";
    protected String strCtrlId = "";
    protected int nMaxRecord = 100;
    protected String strTextField = "";
    protected String strTextFormat = "%1$s";
    protected String strRealTextField = "";
    protected String strRealTextFormat = "%1$s";
    protected String strValueField = "";
    protected String strValueFormat = "%1$s";
    protected String strCondition = "";
    protected String strExtCondition = "";
    protected String strExtFetch = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_TYPE, (boolean)true) == 0) {
            this.strType = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CODELIST, (boolean)true) == 0) {
            this.strCodeList = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_BACKENDCTRL, (boolean)true) == 0) {
            this.strBackEndCtrl = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_BACKENDCONFIG, (boolean)true) == 0) {
            this.strBackEndConfig = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CTRLOBJECT, (boolean)true) == 0) {
            this.strCtrlObject = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CTRLID, (boolean)true) == 0) {
            this.strCtrlId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_MAXRECORD, (boolean)true) == 0) {
            this.setMaxRecord(AutoCompleteConfig.GetValue((String)strValue, (int)this.nMaxRecord));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TEXTFIELD, (boolean)true) == 0) {
            this.strTextField = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TEXTFORMAT, (boolean)true) == 0) {
            this.strTextFormat = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_REALTEXTFIELD, (boolean)true) == 0) {
            this.strRealTextField = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_REALTEXTFORMAT, (boolean)true) == 0) {
            this.strRealTextFormat = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_VALUEFIELD, (boolean)true) == 0) {
            this.strValueField = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_VALUEFORMAT, (boolean)true) == 0) {
            this.strValueFormat = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CONDITION, (boolean)true) == 0) {
            this.strCondition = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_EXTCONDITION, (boolean)true) == 0) {
            this.strExtCondition = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_EXTFETCH, (boolean)true) == 0) {
            this.strExtFetch = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getType() {
        return this.strType;
    }

    public void setType(String strType) {
        this.strType = strType;
    }

    public String getCodeList() {
        return this.strCodeList;
    }

    public void setCodeList(String strCodeList) {
        this.strCodeList = strCodeList;
    }

    public String getBackEndCtrl() {
        return this.strBackEndCtrl;
    }

    public void setBackEndCtrl(String strBackEndCtrl) {
        this.strBackEndCtrl = strBackEndCtrl;
    }

    public String getBackEndConfig() {
        return this.strBackEndConfig;
    }

    public void setBackEndConfig(String strBackEndConfig) {
        this.strBackEndConfig = strBackEndConfig;
    }

    public String getCtrlObject() {
        return this.strCtrlObject;
    }

    public void setCtrlObject(String strCtrlObject) {
        this.strCtrlObject = strCtrlObject;
    }

    public String getCtrlId() {
        return this.strCtrlId;
    }

    public void setCtrlId(String strCtrlId) {
        this.strCtrlId = strCtrlId;
    }

    public int getMaxRecord() {
        return this.nMaxRecord;
    }

    public void setMaxRecord(int maxRecord) {
        this.nMaxRecord = maxRecord;
        if (this.nMaxRecord < 0) {
            this.nMaxRecord = 100;
        }
    }

    public String getTextField() {
        return this.strTextField;
    }

    public void setTextField(String strTextField) {
        this.strTextField = strTextField;
    }

    public String getTextFormat() {
        return this.strTextFormat;
    }

    public void setTextFormat(String strTextFormat) {
        this.strTextFormat = strTextFormat;
    }

    public String getRealTextField() {
        return this.strRealTextField;
    }

    public void setRealTextField(String strRealTextField) {
        this.strRealTextField = strRealTextField;
    }

    public String getRealTextFormat() {
        return this.strRealTextFormat;
    }

    public void setRealTextFormat(String strRealTextFormat) {
        this.strRealTextFormat = strRealTextFormat;
    }

    public String getValueField() {
        return this.strValueField;
    }

    public void setValueField(String strValueField) {
        this.strValueField = strValueField;
    }

    public String getValueFormat() {
        return this.strValueFormat;
    }

    public void setValueFormat(String strValueFormat) {
        this.strValueFormat = strValueFormat;
    }

    public String getCondition() {
        return this.strCondition;
    }

    public void setCondition(String strCondition) {
        this.strCondition = strCondition;
    }

    public String getExtCondition() {
        return this.strExtCondition;
    }

    public void setExtCondition(String strExtCondition) {
        this.strExtCondition = strExtCondition;
    }

    public String getExtFetch() {
        return this.strExtFetch;
    }

    public void setExtFetch(String strExtFetch) {
        this.strExtFetch = strExtFetch;
    }
}

