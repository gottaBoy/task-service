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
import SA.SRFDA.Ctrl.SqlServerDAQueryModelHelper;
import SA.SRFramework.Utility.StringHelper;

public class SqlServerStringDEFQueryHelper
implements IDEFQueryHelper {
    public String GetConditionSQL(IDAQueryModelUserContext iQMUserContext, BaseDAQueryModelHelper daQueryModelHelper, String strFieldName, String strCondition, String strValue, String strParamName) {
        boolean bUnicodeChar = false;
        if (daQueryModelHelper instanceof SqlServerDAQueryModelHelper) {
            bUnicodeChar = ((SqlServerDAQueryModelHelper)daQueryModelHelper).isUnicodeChar();
        }
        if (StringHelper.IsNullOrEmpty((String)strParamName)) {
            boolean bCaseSensitive = daQueryModelHelper.isFieldQueryCaseSensitive(strFieldName, strCondition);
            strValue = strValue.replace("'", "''");
            if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0 || StringHelper.Compare((String)strCondition, (String)"==", (boolean)true) == 0) {
                if (bCaseSensitive) {
                    return StringHelper.Format((String)"%1$s = %3$s'%2$s'", (Object)strFieldName, (Object)strValue, (Object)(bUnicodeChar ? "N" : ""));
                }
                return StringHelper.Format((String)"UPPER(%1$s) = %3$s'%2$s'", (Object)strFieldName, (Object)strValue.toUpperCase(), (Object)(bUnicodeChar ? "N" : ""));
            }
            if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
                if (bCaseSensitive) {
                    return StringHelper.Format((String)"%1$s <> %3$s'%2$s'", (Object)strFieldName, (Object)strValue, (Object)(bUnicodeChar ? "N" : ""));
                }
                return StringHelper.Format((String)"UPPER(%1$s) <> %3$s'%2$s'", (Object)strFieldName, (Object)strValue.toUpperCase(), (Object)(bUnicodeChar ? "N" : ""));
            }
            if (StringHelper.Compare((String)strCondition, (String)"LIKE", (boolean)true) == 0) {
                strValue = "%" + strValue + "%";
                if (bCaseSensitive) {
                    return StringHelper.Format((String)"%1$s LIKE %3$s'%2$s'", (Object)strFieldName, (Object)strValue, (Object)(bUnicodeChar ? "N" : ""));
                }
                return StringHelper.Format((String)"UPPER(%1$s) LIKE %3$s'%2$s'", (Object)strFieldName, (Object)strValue.toUpperCase(), (Object)(bUnicodeChar ? "N" : ""));
            }
            if (StringHelper.Compare((String)strCondition, (String)"LEFTLIKE", (boolean)true) == 0) {
                strValue = String.valueOf(strValue) + "%";
                if (bCaseSensitive) {
                    return StringHelper.Format((String)"%1$s LIKE %3$s'%2$s'", (Object)strFieldName, (Object)strValue, (Object)(bUnicodeChar ? "N" : ""));
                }
                return StringHelper.Format((String)"UPPER(%1$s) LIKE %3$s'%2$s'", (Object)strFieldName, (Object)strValue.toUpperCase(), (Object)(bUnicodeChar ? "N" : ""));
            }
            if (StringHelper.Compare((String)strCondition, (String)"RIGHTLIKE", (boolean)true) == 0) {
                strValue = "%" + strValue;
                if (bCaseSensitive) {
                    return StringHelper.Format((String)"%1$s LIKE %3$s'%2$s'", (Object)strFieldName, (Object)strValue, (Object)(bUnicodeChar ? "N" : ""));
                }
                return StringHelper.Format((String)"UPPER(%1$s) LIKE %3$s'%2$s'", (Object)strFieldName, (Object)strValue.toUpperCase(), (Object)(bUnicodeChar ? "N" : ""));
            }
            if (StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0 || StringHelper.Compare((String)strCondition, (String)"NOTIN", (boolean)true) == 0) {
                if (StringHelper.IsNullOrEmpty((String)strValue)) {
                    if (StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0) {
                        return "1<>1";
                    }
                    return "1=1";
                }
                String[] items = strValue.split("[;]");
                String strSQL = "";
                strSQL = StringHelper.Compare((String)strCondition, (String)"IN", (boolean)true) == 0 ? (bCaseSensitive ? StringHelper.Format((String)"%1$s IN (", (Object)strFieldName) : StringHelper.Format((String)"UPPER(%1$s) IN (", (Object)strFieldName)) : (bCaseSensitive ? StringHelper.Format((String)"%1$s NOT IN (", (Object)strFieldName) : StringHelper.Format((String)"UPPER(%1$s) NOT IN (", (Object)strFieldName));
                int i = 0;
                while (i < items.length) {
                    if (i != 0) {
                        strSQL = String.valueOf(strSQL) + ",";
                    }
                    strSQL = bCaseSensitive ? String.valueOf(strSQL) + StringHelper.Format((String)"%2$s'%1$s'", (Object)items[i], (Object)(bUnicodeChar ? "N" : "")) : String.valueOf(strSQL) + StringHelper.Format((String)"%2$s'%1$s'", (Object)items[i].toUpperCase(), (Object)(bUnicodeChar ? "N" : ""));
                    ++i;
                }
                strSQL = String.valueOf(strSQL) + ")";
                return strSQL;
            }
        } else {
            if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0) {
                daQueryModelHelper.RegisterCallParam(strParamName, (Object)strValue.toUpperCase());
                daQueryModelHelper.RegisterCallParam(strParamName, (Object)strValue.toUpperCase());
                daQueryModelHelper.RegisterCallParam(strParamName, (Object)strValue.toUpperCase());
                return StringHelper.Format((String)"(?='' or ? is null or %1$s =  ? )", (Object)strFieldName);
            }
            if (StringHelper.Compare((String)strCondition, (String)"==", (boolean)true) == 0) {
                daQueryModelHelper.RegisterCallParam(strParamName, (Object)strValue.toUpperCase());
                daQueryModelHelper.RegisterCallParam(strParamName, (Object)strValue.toUpperCase());
                daQueryModelHelper.RegisterCallParam(strParamName, (Object)strValue.toUpperCase());
                return StringHelper.Format((String)"(?='' or ? is null or %1$s =  ? )", (Object)strFieldName);
            }
            if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
                daQueryModelHelper.RegisterCallParam(strParamName, (Object)strValue.toUpperCase());
                return StringHelper.Format((String)"  %1$s <>  ?  ", (Object)strFieldName);
            }
            if (StringHelper.Compare((String)strCondition, (String)"LIKE", (boolean)true) == 0) {
                daQueryModelHelper.RegisterCallParam(strParamName, (Object)strValue.toUpperCase());
                daQueryModelHelper.RegisterCallParam(strParamName, (Object)strValue.toUpperCase());
                daQueryModelHelper.RegisterCallParam(strParamName, (Object)strValue.toUpperCase());
                return StringHelper.Format((String)"(?='' or ? is null or %1$s LIKE  '%%'+ ? +'%%')", (Object)strFieldName);
            }
            if (StringHelper.Compare((String)strCondition, (String)"LEFTLIKE", (boolean)true) == 0) {
                daQueryModelHelper.RegisterCallParam(strParamName, (Object)strValue.toUpperCase());
                daQueryModelHelper.RegisterCallParam(strParamName, (Object)strValue.toUpperCase());
                daQueryModelHelper.RegisterCallParam(strParamName, (Object)strValue.toUpperCase());
                return StringHelper.Format((String)"(?='' or ? is null or %1$s LIKE   ? +'%%')", (Object)strFieldName);
            }
            if (StringHelper.Compare((String)strCondition, (String)"RIGHTLIKE", (boolean)true) == 0) {
                daQueryModelHelper.RegisterCallParam(strParamName, (Object)strValue.toUpperCase());
                daQueryModelHelper.RegisterCallParam(strParamName, (Object)strValue.toUpperCase());
                daQueryModelHelper.RegisterCallParam(strParamName, (Object)strValue.toUpperCase());
                return StringHelper.Format((String)"(?='' or ? is null or %1$s LIKE  '%%'+ ? )", (Object)strFieldName);
            }
        }
        return "";
    }
}

