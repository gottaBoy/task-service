/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.BaseValueRuleConfig;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.Data.RefObject;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;

public class BaseStrValueRuleConfig
extends BaseValueRuleConfig {
    public static String INGORECASE = "INGORECASE";
    public static String SRCFUNC_LENGTH = "LENGTH";
    protected boolean bIngoreCase = true;

    @Override
    protected Object GetSrcValue(Object objSrc, int dataType, RefObject newDataType) {
        if (DataTypeParse.IsStringDataType(dataType)) {
            if (this.bIngoreCase) {
                objSrc = objSrc.toString().toLowerCase();
            }
            if (StringHelper.Compare(this.strSrcFunc, SRCFUNC_LENGTH, true) == 0) {
                newDataType.setObject(9);
                return objSrc.toString().length();
            }
        }
        return super.GetSrcValue(objSrc, dataType, newDataType);
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare(strName, INGORECASE, true) == 0) {
            this.bIngoreCase = BaseStrValueRuleConfig.GetValue(strValue, this.bIngoreCase);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    @Override
    protected Object GetTargetValue(int type, Hashtable paramList) {
        Object objValue = super.GetTargetValue(type, paramList);
        if (objValue != null && DataTypeParse.IsStringDataType(type) && this.bIngoreCase) {
            objValue = objValue.toString().toLowerCase();
        }
        return objValue;
    }
}

