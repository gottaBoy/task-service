/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DataNotify.Model;

import SA.SRFDA.Ctrl.DataNotify.Model.DataNotifyBaseLogicConfig;
import SA.SRFramework.Utility.StringHelper;

public class DataNotifySingleLogicConfig
extends DataNotifyBaseLogicConfig {
    public static final String TAG_SRFDADATANOTIFYSINGLELOGIC = "SRFDADATANOTIFYSINGLELOGIC";
    public static final String VALUECONDITION_BEFORE = "BEFORE";
    public static final String VALUECONDITION_AFTER = "AFTER";
    public static final String VALUECONDITION_CHANGE = "CHANGE";
    public static final String TAG_VALUECONDITION = "VALUECONDITION";
    public static final String TAG_DEFIELD = "DEFIELD";
    public static final String TAG_FUNC = "FUNC";
    public static final String TAG_VALUE = "VALUE";
    public static final String TAG_VALUE2 = "VALUE2";
    public static final String TAG_PARAMNAME = "PARAMNAME";
    protected String strValueCondition = "AFTER";
    protected String strDEField = "";
    protected String strValue = "";
    protected String strValue2 = "";
    protected String strFunc = "";
    protected String strParamName = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DEFIELD, (boolean)true) == 0) {
            this.setDEField(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_VALUE, (boolean)true) == 0) {
            this.setValue(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_VALUE2, (boolean)true) == 0) {
            this.setValue2(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_FUNC, (boolean)true) == 0) {
            this.setFunc(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PARAMNAME, (boolean)true) == 0) {
            this.setParamName(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_VALUECONDITION, (boolean)true) == 0) {
            this.setValueCondition(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getDEField() {
        return this.strDEField;
    }

    public void setDEField(String strDEField) {
        this.strDEField = strDEField;
    }

    public String getValue() {
        if (StringHelper.IsNullOrEmpty((String)this.strValue)) {
            return this.getValue2();
        }
        return this.strValue;
    }

    public void setValue(String strValue) {
        this.strValue = strValue;
    }

    public String getFunc() {
        return this.strFunc;
    }

    public void setFunc(String strFunc) {
        this.strFunc = strFunc;
    }

    public String getParamName() {
        return this.strParamName;
    }

    public void setParamName(String strParamName) {
        this.strParamName = strParamName;
    }

    public String getValue2() {
        return this.strValue2;
    }

    public void setValue2(String strValue2) {
        this.strValue2 = strValue2;
    }

    public String getValueCondition() {
        return this.strValueCondition;
    }

    public void setValueCondition(String strValueCondition) {
        this.strValueCondition = strValueCondition;
    }
}

