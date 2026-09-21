/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.IDBStorage
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.IDBStorage;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.sql.Timestamp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SqlServerDAQueryModelHelper
extends BaseDAQueryModelHelper {
    private static final Log log = LogFactory.getLog(SqlServerDAQueryModelHelper.class);
    public static final String TAG_UNICODECHAR_PREFIX = "N";
    protected boolean bUnicodeChar = false;

    public boolean isUnicodeChar() {
        return this.bUnicodeChar;
    }

    public CallResult Init(IDEHelper iDEHelper, ISRFDAGlobalHelper globalHelper) {
        CallResult callResult = super.Init(iDEHelper, globalHelper);
        if (!StringHelper.IsNullOrEmpty((String)iDEHelper.GetDBStorage())) {
            IDBStorage iDBStorage = globalHelper.getDAModelStorage().FindDBStorage(iDEHelper.GetDBStorage());
            if (iDBStorage == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6570\u636e\u5b58\u50a8[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)iDEHelper.GetDBStorage()));
                return callResult;
            }
            String strUnicodeChar = iDBStorage.GetProperty("UNICODECHAR");
            if (!StringHelper.IsNullOrEmpty((String)strUnicodeChar)) {
                this.bUnicodeChar = StringHelper.Compare((String)strUnicodeChar, (String)"TRUE", (boolean)true) == 0;
            }
        } else {
            this.bUnicodeChar = globalHelper.getWebExConfig().GetValue("SRFDA.SQLSERVER", "UNICODECHAR", this.bUnicodeChar);
        }
        return callResult;
    }

    protected String GetDateTimeConditionSQL(String strFieldName, int dataType, String strCondition, String strValue, String strParamName) {
        if (!StringHelper.IsNullOrEmpty((String)strValue)) {
            Object objValue = DataTypeParse.TestDateTime((String)strValue);
            if (objValue == null) {
                log.error((Object)StringHelper.Format((String)"\u503c[%1$s]\u975e\u65e5\u671f\u65f6\u95f4\u6027", (Object)strValue));
                return "";
            }
            Timestamp ts = (Timestamp)objValue;
            strValue = StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)ts);
        }
        if (StringHelper.IsNullOrEmpty((String)strParamName)) {
            strValue = strValue.replace("'", "''");
            if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s = convert (datetime,'%2$s',120)  ", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s <> convert (datetime,'%2$s',120)  ", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)">", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s >convert (datetime,'%2$s',120)  ", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)">=", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s >=convert (datetime,'%2$s',120)  ", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)"<", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s < convert (datetime,'%2$s',120)  ", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)"<=", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s <= convert (datetime,'%2$s',120)  ", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
        } else {
            CallParam callParam = new CallParam();
            callParam.setParamName(strParamName);
            callParam.setValue((Object)strValue.toUpperCase());
            if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0) {
                this.callParams.add(callParam);
                return StringHelper.Format((String)"%1$s = convert (datetime,?,120)  ", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
                this.callParams.add(callParam);
                return StringHelper.Format((String)"%1$s <> convert (datetime,?,120)", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)">", (boolean)true) == 0) {
                this.callParams.add(callParam);
                return StringHelper.Format((String)"%1$s >convert (datetime,?,120)", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)">=", (boolean)true) == 0) {
                this.callParams.add(callParam);
                return StringHelper.Format((String)"%1$s >=convert (datetime,?,120)", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)"<", (boolean)true) == 0) {
                this.callParams.add(callParam);
                return StringHelper.Format((String)"%1$s < convert (datetime,?,120)", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)"<=", (boolean)true) == 0) {
                this.callParams.add(callParam);
                return StringHelper.Format((String)"%1$s <= convert (datetime,?,120)", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
        }
        return "";
    }

    protected String GetStringConditionSQL(String strFieldName, int dataType, String strCondition, String strValue, String strParamName) {
        if (StringHelper.IsNullOrEmpty((String)strParamName)) {
            boolean bCaseSensitive = this.isFieldQueryCaseSensitive(strFieldName, strCondition);
            strValue = strValue.replace("'", "''");
            if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0 || StringHelper.Compare((String)strCondition, (String)"==", (boolean)true) == 0) {
                if (bCaseSensitive) {
                    return StringHelper.Format((String)"%1$s = %3$s'%2$s'", (Object)strFieldName, (Object)strValue, (Object)(this.bUnicodeChar ? TAG_UNICODECHAR_PREFIX : ""));
                }
                return StringHelper.Format((String)"UPPER(%1$s) = %3$s'%2$s'", (Object)strFieldName, (Object)strValue.toUpperCase(), (Object)(this.bUnicodeChar ? TAG_UNICODECHAR_PREFIX : ""));
            }
            if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
                if (bCaseSensitive) {
                    return StringHelper.Format((String)"%1$s <> %3$s'%2$s'", (Object)strFieldName, (Object)strValue, (Object)(this.bUnicodeChar ? TAG_UNICODECHAR_PREFIX : ""));
                }
                return StringHelper.Format((String)"UPPER(%1$s) <> %3$s'%2$s'", (Object)strFieldName, (Object)strValue.toUpperCase(), (Object)(this.bUnicodeChar ? TAG_UNICODECHAR_PREFIX : ""));
            }
            if (StringHelper.Compare((String)strCondition, (String)"LIKE", (boolean)true) == 0) {
                strValue = "%" + strValue + "%";
                if (bCaseSensitive) {
                    return StringHelper.Format((String)"%1$s LIKE %3$s'%2$s'", (Object)strFieldName, (Object)strValue, (Object)(this.bUnicodeChar ? TAG_UNICODECHAR_PREFIX : ""));
                }
                return StringHelper.Format((String)"UPPER(%1$s) LIKE %3$s'%2$s'", (Object)strFieldName, (Object)strValue.toUpperCase(), (Object)(this.bUnicodeChar ? TAG_UNICODECHAR_PREFIX : ""));
            }
            if (StringHelper.Compare((String)strCondition, (String)"LEFTLIKE", (boolean)true) == 0) {
                strValue = String.valueOf(strValue) + "%";
                if (bCaseSensitive) {
                    return StringHelper.Format((String)"%1$s LIKE %3$s'%2$s'", (Object)strFieldName, (Object)strValue, (Object)(this.bUnicodeChar ? TAG_UNICODECHAR_PREFIX : ""));
                }
                return StringHelper.Format((String)"UPPER(%1$s) LIKE %3$s'%2$s'", (Object)strFieldName, (Object)strValue.toUpperCase(), (Object)(this.bUnicodeChar ? TAG_UNICODECHAR_PREFIX : ""));
            }
            if (StringHelper.Compare((String)strCondition, (String)"RIGHTLIKE", (boolean)true) == 0) {
                strValue = "%" + strValue;
                if (bCaseSensitive) {
                    return StringHelper.Format((String)"%1$s LIKE %3$s'%2$s'", (Object)strFieldName, (Object)strValue, (Object)(this.bUnicodeChar ? TAG_UNICODECHAR_PREFIX : ""));
                }
                return StringHelper.Format((String)"UPPER(%1$s) LIKE %3$s'%2$s'", (Object)strFieldName, (Object)strValue.toUpperCase(), (Object)(this.bUnicodeChar ? TAG_UNICODECHAR_PREFIX : ""));
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
                    strSQL = bCaseSensitive ? String.valueOf(strSQL) + StringHelper.Format((String)"%2$s'%1$s'", (Object)items[i], (Object)(this.bUnicodeChar ? TAG_UNICODECHAR_PREFIX : "")) : String.valueOf(strSQL) + StringHelper.Format((String)"%2$s'%1$s'", (Object)items[i].toUpperCase(), (Object)(this.bUnicodeChar ? TAG_UNICODECHAR_PREFIX : ""));
                    ++i;
                }
                strSQL = String.valueOf(strSQL) + ")";
                return strSQL;
            }
        } else {
            CallParam callParam = new CallParam();
            callParam.setParamName(strParamName);
            callParam.setValue((Object)strValue.toUpperCase());
            CallParam callParam2 = new CallParam();
            callParam2.setParamName(strParamName);
            callParam2.setValue((Object)strValue.toUpperCase());
            CallParam callParam3 = new CallParam();
            callParam3.setParamName(strParamName);
            callParam3.setValue((Object)strValue.toUpperCase());
            if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0) {
                this.callParams.add(callParam);
                this.callParams.add(callParam2);
                this.callParams.add(callParam3);
                return StringHelper.Format((String)"(?='' or ? is null or %1$s =  ? )", (Object)strFieldName);
            }
            if (StringHelper.Compare((String)strCondition, (String)"==", (boolean)true) == 0) {
                this.callParams.add(callParam);
                this.callParams.add(callParam2);
                this.callParams.add(callParam3);
                return StringHelper.Format((String)"(?='' or ? is null or %1$s =  ? )", (Object)strFieldName);
            }
            if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
                this.callParams.add(callParam);
                return StringHelper.Format((String)"  %1$s <>  ?  ", (Object)strFieldName);
            }
            if (StringHelper.Compare((String)strCondition, (String)"LIKE", (boolean)true) == 0) {
                this.callParams.add(callParam);
                this.callParams.add(callParam2);
                this.callParams.add(callParam3);
                return StringHelper.Format((String)"(?='' or ? is null or %1$s LIKE  '%%'+ ? +'%%')", (Object)strFieldName);
            }
            if (StringHelper.Compare((String)strCondition, (String)"LEFTLIKE", (boolean)true) == 0) {
                this.callParams.add(callParam);
                this.callParams.add(callParam2);
                this.callParams.add(callParam3);
                return StringHelper.Format((String)"(?='' or ? is null or %1$s LIKE  ? +'%%')", (Object)strFieldName);
            }
            if (StringHelper.Compare((String)strCondition, (String)"RIGHTLIKE", (boolean)true) == 0) {
                this.callParams.add(callParam);
                this.callParams.add(callParam2);
                this.callParams.add(callParam3);
                return StringHelper.Format((String)"(?='' or ? is null or %1$s LIKE  '%%'+ ? )", (Object)strFieldName);
            }
        }
        return super.GetStringConditionSQL(strFieldName, dataType, strCondition, strValue, strParamName);
    }

    public String GetCountSQL(String strSQL) {
        return StringHelper.Format((String)"select count(*) as TOTALROW from (%1$s) m1", (Object)strSQL);
    }

    public String GetPagingSQL(String strSQL, int nStartPos, int nPageSize, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection) {
        StringBuilderEx script = new StringBuilderEx();
        if (StringHelper.IsNullOrEmpty((String)strMajor) && !StringHelper.IsNullOrEmpty((String)strMinor)) {
            strMajor = strMinor;
            strMajorDirection = strMinorDirection;
            strMinor = "";
            strMinorDirection = "";
        }
        if (!StringHelper.IsNullOrEmpty((String)strMajor)) {
            if (StringHelper.IsNullOrEmpty((String)strMinor) || StringHelper.Compare((String)strMajor, (String)strMinor, (boolean)true) == 0) {
                script.Append("SELECT * FROM (Select m1.*,  ROW_NUMBER() over (order by  m1.[%2$s] %3$s)   as SRFROWINDEX from ( select * from (%1$s) pagetemp ) m1 ", (Object)strSQL, (Object)strMajor, (Object)strMajorDirection);
            } else {
                script.Append("SELECT * FROM (Select m1.*,  ROW_NUMBER() over (order by  m1.[%2$s] %3$s, m1.[%4$s] %5$s)   as SRFROWINDEX from ( select * from (%1$s) pagetemp ) m1 ", (Object)strSQL, (Object)strMajor, (Object)strMajorDirection, (Object)strMinor, (Object)strMinorDirection);
            }
        } else {
            script.Append("SELECT * FROM (Select m1.*,  ROW_NUMBER() over (order by  m1.[updatedate] desc)   as SRFROWINDEX from ( select * from (%1$s) pagetemp ) m1 ", (Object)strSQL);
        }
        script.Append(" ) a1 WHERE a1.SRFROWINDEX >= %1$s and a1.SRFROWINDEX < %2$s ", (Object)(nStartPos + 1), (Object)(nStartPos + nPageSize + 1));
        return script.toString();
    }

    public String GetPagingSQL(String strSQL, int nStartPos, int nPageSize, String strGroup, String strGroupDir, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection) {
        if (StringHelper.IsNullOrEmpty((String)strGroup)) {
            return this.GetPagingSQL(strSQL, nStartPos, nPageSize, strMajor, strMajorDirection, strMinor, strMinorDirection);
        }
        String strOrderInfo = StringHelper.Format((String)"m1.[%1$s] %2$s", (Object)strGroup, (Object)strGroupDir);
        if (!StringHelper.IsNullOrEmpty((String)strMajor) && StringHelper.Compare((String)strGroup, (String)strMajor, (boolean)true) != 0) {
            strOrderInfo = String.valueOf(strOrderInfo) + ",";
            strOrderInfo = String.valueOf(strOrderInfo) + StringHelper.Format((String)"m1.[%1$s] %2$s", (Object)strMajor, (Object)strMajorDirection);
        }
        if (!StringHelper.IsNullOrEmpty((String)strMinor) && StringHelper.Compare((String)strGroup, (String)strMinor, (boolean)true) != 0 && StringHelper.Compare((String)strMajor, (String)strMinor, (boolean)true) != 0) {
            strOrderInfo = String.valueOf(strOrderInfo) + ",";
            strOrderInfo = String.valueOf(strOrderInfo) + StringHelper.Format((String)"m1.[%1$s] %2$s", (Object)strMinor, (Object)strMinorDirection);
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("SELECT * FROM (Select m1.*,  ROW_NUMBER() over (order by  %2$s) as SRFROWINDEX from ( select * from (%1$s) pagetemp ) m1 ", (Object)strSQL, (Object)strOrderInfo);
        script.Append(" ) a1 WHERE a1.SRFROWINDEX >= %1$s and a1.SRFROWINDEX < %2$s ", (Object)(nStartPos + 1), (Object)(nStartPos + nPageSize + 1));
        return script.toString();
    }

    public String GetFetchTopRowSQL(String strSQL, int topCount) {
        return StringHelper.Format((String)" select top %2$s * from (%1$s) toprow  ", (Object)strSQL, (Object)topCount);
    }

    public String GetSortSQL(String strSQL, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection) {
        if (StringHelper.IsNullOrEmpty((String)strMajor) && StringHelper.IsNullOrEmpty((String)strMinor)) {
            return strSQL;
        }
        String strSortParams = "";
        if (!StringHelper.IsNullOrEmpty((String)strMajor)) {
            strSortParams = String.valueOf(strSortParams) + StringHelper.Format((String)"m1.[%1$s] %2$s", (Object)strMajor, (Object)strMajorDirection);
        }
        if (!StringHelper.IsNullOrEmpty((String)strMinor)) {
            if (!StringHelper.IsNullOrEmpty((String)strSortParams)) {
                strSortParams = String.valueOf(strSortParams) + ",";
            }
            strSortParams = String.valueOf(strSortParams) + StringHelper.Format((String)"m1.[%1$s] %2$s", (Object)strMinor, (Object)strMinorDirection);
        }
        return StringHelper.Format((String)"Select m1.* from (%1$s) m1 ORDER BY %2$s", (Object)strSQL, (Object)strSortParams);
    }

    public String GetDBType() {
        return "MSSQL";
    }
}

