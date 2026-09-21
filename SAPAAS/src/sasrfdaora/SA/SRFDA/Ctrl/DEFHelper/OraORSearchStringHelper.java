/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFQueryHelper
 *  SA.SRFDA.Ctrl.IDAQueryModelUserContext
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFQueryHelper;
import SA.SRFDA.Ctrl.IDAQueryModelUserContext;
import SA.SRFramework.Utility.StringHelper;

public class OraORSearchStringHelper
implements IDEFQueryHelper {
    public String GetConditionSQL(IDAQueryModelUserContext iQMUserContext, BaseDAQueryModelHelper daQueryModelHelper, String strFieldName, String strCondition, String strValue, String strParamName) {
        if (StringHelper.IsNullOrEmpty((String)strParamName)) {
            strValue = strValue.replace("'", "''");
            if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0) {
                return StringHelper.Format((String)"fu_srforsearch_str(%1$s,  '%2$s')=1", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
        } else if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0) {
            daQueryModelHelper.RegisterCallParam(strParamName, (Object)strValue.toUpperCase());
            return StringHelper.Format((String)"fu_srforsearch_str(%1$s,   ? )=1", (Object)strFieldName);
        }
        return "";
    }
}

