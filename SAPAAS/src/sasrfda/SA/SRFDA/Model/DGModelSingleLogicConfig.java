/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Model;

import SA.SRFDA.Model.DGModelBaseLogicConfig;
import SA.SRFramework.Utility.StringHelper;

public class DGModelSingleLogicConfig
extends DGModelBaseLogicConfig {
    public static final String TAG_DGMODELSINGLELOGIC = "SRFDADGMODELSINGLELOGIC";
    public static final String TAG_DEFIELD = "DEFIELD";
    public static final String TAG_CONDITION = "CONDITION";
    public static final String TAG_FUNC = "FUNC";
    public static final String TAG_VALUE = "VALUE";
    public static final String TAG_VALUE2 = "VALUE2";
    public static final String TAG_PARAMNAME = "PARAMNAME";
    protected String strDEField = "";
    protected String strCondition = "";
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
        if (StringHelper.Compare((String)strName, (String)TAG_CONDITION, (boolean)true) == 0) {
            this.setCondition(strValue);
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
        super.OnSetProperty(strName, strValue);
    }

    public String getDEField() {
        return this.strDEField;
    }

    public void setDEField(String strDEField) {
        this.strDEField = strDEField;
    }

    public String getCondition() {
        return this.strCondition;
    }

    public void setCondition(String strCondition) {
        this.strCondition = strCondition;
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
}

