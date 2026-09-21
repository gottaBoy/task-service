/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.sql.Timestamp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class OraDAQueryModelHelper
extends BaseDAQueryModelHelper {
    private static final Log log = LogFactory.getLog(OraDAQueryModelHelper.class);

    protected String GetDateTimeConditionSQL(String strFieldName, int dataType, String strCondition, String strValue, String strParamName) {
        if (!StringHelper.IsNullOrEmpty((String)strValue) && StringHelper.Compare((String)strCondition, (String)"LIKE", (boolean)true) != 0) {
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
                return StringHelper.Format((String)"%1$s = to_date('%2$s','yyyy-mm-dd hh24:mi:ss')", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s <> to_date('%2$s','yyyy-mm-dd hh24:mi:ss')", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)">", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s > to_date('%2$s','yyyy-mm-dd hh24:mi:ss')", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)">=", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s >= to_date('%2$s','yyyy-mm-dd hh24:mi:ss')", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)"<", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s < to_date('%2$s','yyyy-mm-dd hh24:mi:ss')", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)"<=", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s <= to_date('%2$s','yyyy-mm-dd hh24:mi:ss')", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)"LIKE", (boolean)true) == 0) {
                return StringHelper.Format((String)"to_char(%1$s,'yyyy-mm-dd hh24:mi:ss') like  '%%%2$s%%' ", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
        } else {
            CallParam callParam = new CallParam();
            callParam.setParamName(strParamName);
            callParam.setValue((Object)strValue.toUpperCase());
            if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0) {
                this.callParams.add(callParam);
                return StringHelper.Format((String)"%1$s = to_date(?,'yyyy-mm-dd hh24:mi:ss')", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
                this.callParams.add(callParam);
                return StringHelper.Format((String)"%1$s <> to_date(?,'yyyy-mm-dd hh24:mi:ss')", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)">", (boolean)true) == 0) {
                this.callParams.add(callParam);
                return StringHelper.Format((String)"%1$s > to_date(?,'yyyy-mm-dd hh24:mi:ss')", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)">=", (boolean)true) == 0) {
                this.callParams.add(callParam);
                return StringHelper.Format((String)"%1$s >= to_date(?,'yyyy-mm-dd hh24:mi:ss')", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)"<", (boolean)true) == 0) {
                this.callParams.add(callParam);
                return StringHelper.Format((String)"%1$s < to_date(?,'yyyy-mm-dd hh24:mi:ss')", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)"<=", (boolean)true) == 0) {
                this.callParams.add(callParam);
                return StringHelper.Format((String)"%1$s <= to_date(?,'yyyy-mm-dd hh24:mi:ss')", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
        }
        return "";
    }

    protected String GetStringConditionSQL(String strFieldName, int dataType, String strCondition, String strValue, String strParamName) {
        if (StringHelper.IsNullOrEmpty((String)strParamName)) {
            boolean bCaseSensitive = this.isFieldQueryCaseSensitive(strFieldName, strCondition);
            if (StringHelper.Compare((String)(strValue = strValue.replace("'", "''")), (String)"__SRFQMVALUE_ISNULL__", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s IS NULL", (Object)strFieldName);
            }
            if (StringHelper.Compare((String)strValue, (String)"__SRFQMVALUE_ISNOTNULL__", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s IS NOT NULL", (Object)strFieldName);
            }
            if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0 || StringHelper.Compare((String)strCondition, (String)"==", (boolean)true) == 0) {
                if (bCaseSensitive) {
                    return StringHelper.Format((String)"%1$s = '%2$s'", (Object)strFieldName, (Object)strValue);
                }
                return StringHelper.Format((String)"UPPER(%1$s) = '%2$s'", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
                if (bCaseSensitive) {
                    return StringHelper.Format((String)"%1$s <> '%2$s'", (Object)strFieldName, (Object)strValue);
                }
                return StringHelper.Format((String)"UPPER(%1$s) <> '%2$s'", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)"LIKE", (boolean)true) == 0) {
                if (this.TestQueryOption(strFieldName, 4) && !StringHelper.IsNullOrEmpty((String)strValue)) {
                    String[] items = strValue.split("[ ]");
                    StringBuilderEx sb = new StringBuilderEx();
                    boolean bFirst = true;
                    String[] stringArray = items;
                    int n = items.length;
                    int n2 = 0;
                    while (n2 < n) {
                        String strItem = stringArray[n2];
                        if (!StringHelper.IsNullOrEmpty((String)strItem)) {
                            if (bFirst) {
                                bFirst = false;
                            } else {
                                sb.Append(" OR ");
                            }
                            strItem = "%" + strItem + "%";
                            if (bCaseSensitive) {
                                sb.Append("(%1$s LIKE '%2$s')", (Object)strFieldName, (Object)strItem);
                            } else {
                                sb.Append("(UPPER(%1$s) LIKE '%2$s')", (Object)strFieldName, (Object)strItem.toUpperCase());
                            }
                        }
                        ++n2;
                    }
                    String strFullCondition = sb.toString();
                    if (!StringHelper.IsNullOrEmpty((String)strFullCondition)) {
                        strFullCondition = "(" + strFullCondition + ")";
                    }
                    return strFullCondition;
                }
                strValue = "%" + strValue + "%";
                if (bCaseSensitive) {
                    return StringHelper.Format((String)"%1$s LIKE '%2$s'", (Object)strFieldName, (Object)strValue);
                }
                return StringHelper.Format((String)"UPPER(%1$s) LIKE '%2$s'", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)"LEFTLIKE", (boolean)true) == 0) {
                if (this.TestQueryOption(strFieldName, 4) && !StringHelper.IsNullOrEmpty((String)strValue)) {
                    String[] items = strValue.split("[ ]");
                    StringBuilderEx sb = new StringBuilderEx();
                    boolean bFirst = true;
                    String[] stringArray = items;
                    int n = items.length;
                    int n3 = 0;
                    while (n3 < n) {
                        String strItem = stringArray[n3];
                        if (!StringHelper.IsNullOrEmpty((String)strItem)) {
                            if (bFirst) {
                                bFirst = false;
                            } else {
                                sb.Append(" OR ");
                            }
                            strItem = String.valueOf(strItem) + "%";
                            if (bCaseSensitive) {
                                sb.Append("(%1$s LIKE '%2$s')", (Object)strFieldName, (Object)strItem);
                            } else {
                                sb.Append("(UPPER(%1$s) LIKE '%2$s')", (Object)strFieldName, (Object)strItem.toUpperCase());
                            }
                        }
                        ++n3;
                    }
                    String strFullCondition = sb.toString();
                    if (!StringHelper.IsNullOrEmpty((String)strFullCondition)) {
                        strFullCondition = "(" + strFullCondition + ")";
                    }
                    return strFullCondition;
                }
                strValue = String.valueOf(strValue) + "%";
                if (bCaseSensitive) {
                    return StringHelper.Format((String)"%1$s LIKE '%2$s'", (Object)strFieldName, (Object)strValue);
                }
                return StringHelper.Format((String)"UPPER(%1$s) LIKE '%2$s'", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.Compare((String)strCondition, (String)"RIGHTLIKE", (boolean)true) == 0) {
                if (this.TestQueryOption(strFieldName, 4) && !StringHelper.IsNullOrEmpty((String)strValue)) {
                    String[] items = strValue.split("[ ]");
                    StringBuilderEx sb = new StringBuilderEx();
                    boolean bFirst = true;
                    String[] stringArray = items;
                    int n = items.length;
                    int n4 = 0;
                    while (n4 < n) {
                        String strItem = stringArray[n4];
                        if (!StringHelper.IsNullOrEmpty((String)strItem)) {
                            if (bFirst) {
                                bFirst = false;
                            } else {
                                sb.Append(" OR ");
                            }
                            strItem = "%" + strItem;
                            if (bCaseSensitive) {
                                sb.Append("(%1$s LIKE '%2$s')", (Object)strFieldName, (Object)strItem);
                            } else {
                                sb.Append("(UPPER(%1$s) LIKE '%2$s')", (Object)strFieldName, (Object)strItem.toUpperCase());
                            }
                        }
                        ++n4;
                    }
                    String strFullCondition = sb.toString();
                    if (!StringHelper.IsNullOrEmpty((String)strFullCondition)) {
                        strFullCondition = "(" + strFullCondition + ")";
                    }
                    return strFullCondition;
                }
                strValue = "%" + strValue;
                if (bCaseSensitive) {
                    return StringHelper.Format((String)"%1$s LIKE '%2$s'", (Object)strFieldName, (Object)strValue);
                }
                return StringHelper.Format((String)"UPPER(%1$s) LIKE '%2$s'", (Object)strFieldName, (Object)strValue.toUpperCase());
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
                    strSQL = bCaseSensitive ? String.valueOf(strSQL) + StringHelper.Format((String)"'%1$s'", (Object)items[i]) : String.valueOf(strSQL) + StringHelper.Format((String)"'%1$s'", (Object)items[i].toUpperCase());
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
                this.callParams.add(callParam3);
                return StringHelper.Format((String)"( %1$s =  ? )", (Object)strFieldName);
            }
            if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
                this.callParams.add(callParam);
                return StringHelper.Format((String)"  %1$s <>  ?  ", (Object)strFieldName);
            }
            if (StringHelper.Compare((String)strCondition, (String)"LIKE", (boolean)true) == 0) {
                this.callParams.add(callParam);
                this.callParams.add(callParam2);
                this.callParams.add(callParam3);
                return StringHelper.Format((String)"(?='' or ? is null or %1$s LIKE  '%%'|| ? ||'%%')", (Object)strFieldName);
            }
            if (StringHelper.Compare((String)strCondition, (String)"LEFTLIKE", (boolean)true) == 0) {
                this.callParams.add(callParam);
                this.callParams.add(callParam2);
                this.callParams.add(callParam3);
                return StringHelper.Format((String)"(?='' or ? is null or %1$s LIKE  ? ||'%%')", (Object)strFieldName);
            }
            if (StringHelper.Compare((String)strCondition, (String)"RIGHTLIKE", (boolean)true) == 0) {
                this.callParams.add(callParam);
                this.callParams.add(callParam2);
                this.callParams.add(callParam3);
                return StringHelper.Format((String)"(?='' or ? is null or %1$s LIKE  '%%'|| ? )", (Object)strFieldName);
            }
        }
        return super.GetStringConditionSQL(strFieldName, dataType, strCondition, strValue, strParamName);
    }

    public String GetCountSQL(String strSQL) {
        return StringHelper.Format((String)"select count(%2$s) as TOTALROW from (%1$s) m1", (Object)strSQL, (Object)this.GetMajorDEHelper().GetKeyDEFHelper().getName());
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
                script.Append("SELECT * FROM (Select m1.*, rownum  as SRFROWINDEX from ( select * from (%1$s) pagetemp ORDER BY pagetemp.%2$s %3$s) m1 ", (Object)strSQL, (Object)strMajor, (Object)strMajorDirection);
            } else {
                script.Append("SELECT * FROM (Select m1.*, rownum  as SRFROWINDEX from ( select * from (%1$s) pagetemp ORDER BY pagetemp.%2$s %3$s,pagetemp.%4$s %5$s) m1 ", (Object)strSQL, (Object)strMajor, (Object)strMajorDirection, (Object)strMinor, (Object)strMinorDirection);
            }
        } else {
            script.Append("SELECT * FROM (Select m1.*, rownum as SRFROWINDEX from (%1$s) m1 ", (Object)strSQL);
        }
        script.Append(" WHERE rownum < %2$s ) a1 WHERE a1.SRFROWINDEX >= %1$s  ", (Object)(nStartPos + 1), (Object)(nStartPos + nPageSize + 1));
        return script.toString();
    }

    public String GetFetchTopRowSQL(String strSQL, int topCount) {
        return StringHelper.Format((String)" select * from (%1$s) toprow where rownum<= %2$s ", (Object)strSQL, (Object)topCount);
    }

    public String GetSortSQL(String strSQL, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection) {
        if (StringHelper.IsNullOrEmpty((String)strMajor) && StringHelper.IsNullOrEmpty((String)strMinor)) {
            return strSQL;
        }
        String strSortParams = "";
        if (!StringHelper.IsNullOrEmpty((String)strMajor)) {
            strSortParams = String.valueOf(strSortParams) + StringHelper.Format((String)"m1.%1$s %2$s", (Object)strMajor, (Object)strMajorDirection);
        }
        if (!StringHelper.IsNullOrEmpty((String)strMinor)) {
            if (!StringHelper.IsNullOrEmpty((String)strSortParams)) {
                strSortParams = String.valueOf(strSortParams) + ",";
            }
            strSortParams = String.valueOf(strSortParams) + StringHelper.Format((String)"m1.%1$s %2$s", (Object)strMinor, (Object)strMinorDirection);
        }
        return StringHelper.Format((String)"Select m1.* from (%1$s) m1 ORDER BY %2$s", (Object)strSQL, (Object)strSortParams);
    }

    public String GetDBType() {
        return "ORACLE";
    }
}

