/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.BaseRuleConfig;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.Data.RefObject;
import SA.SRFramework.Data.ValueFunctions;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;

public abstract class BaseValueRuleConfig
extends BaseRuleConfig {
    public static String TARGET = "TARGET";
    public static String SRCFUNC = "SRCFUNC";
    protected String strTargetValue = "";
    protected String strSrcFunc = "";

    protected Object GetTargetValue(int type, Hashtable paramList) {
        if (this.strTargetValue == null || this.strTargetValue == "") {
            return null;
        }
        RefObject objValue = new RefObject();
        if (ValueFunctions.GetParam(this.strTargetValue, paramList, objValue)) {
            return objValue.getObject();
        }
        this.strTargetValue = ValueFunctions.Call(this.strTargetValue);
        return DataTypeParse.Parse(type, this.strTargetValue);
    }

    protected Object GetSrcValue(Object objSrc, int dataType, RefObject newDataType) {
        newDataType.setObject(dataType);
        return objSrc;
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare(strName, TARGET, true) == 0) {
            this.strTargetValue = strValue;
            return;
        }
        if (StringHelper.Compare(strName, SRCFUNC, true) == 0) {
            this.strSrcFunc = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }
}

