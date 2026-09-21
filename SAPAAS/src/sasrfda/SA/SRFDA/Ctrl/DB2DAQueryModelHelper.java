/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Model.QueryModelDeclare;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public class DB2DAQueryModelHelper
extends BaseDAQueryModelHelper {
    @Override
    protected String GetDateTimeConditionSQL(String strFieldName, int nDataType, String strCondition, String strValue, String strParamName) {
        return super.GetDateTimeConditionSQL(strFieldName, nDataType, strCondition, strValue, strParamName);
    }

    @Override
    protected String GetStringConditionSQL(String strFieldName, int dataType, String strCondition, String strValue, String strParamName) {
        if (StringHelper.IsNullOrEmpty((String)strParamName)) {
            boolean bCaseSensitive = this.isFieldQueryCaseSensitive(strFieldName, strCondition);
            strValue = strValue.replace("'", "''");
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
            if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0 || StringHelper.Compare((String)strCondition, (String)"==", (boolean)true) == 0) {
                this.callParams.add(callParam);
                return StringHelper.Format((String)"%1$s =  ? ", (Object)strFieldName);
            }
            if (StringHelper.Compare((String)strCondition, (String)"<>", (boolean)true) == 0) {
                this.callParams.add(callParam);
                return StringHelper.Format((String)"%1$s <>  ? ", (Object)strFieldName);
            }
            if (StringHelper.Compare((String)strCondition, (String)"LIKE", (boolean)true) == 0) {
                this.callParams.add(callParam);
                return StringHelper.Format((String)"%1$s LIKE  '%%'|| ? ||'%%'", (Object)strFieldName);
            }
            if (StringHelper.Compare((String)strCondition, (String)"LEFTLIKE", (boolean)true) == 0) {
                this.callParams.add(callParam);
                return StringHelper.Format((String)"%1$s LIKE   ? ||'%%'", (Object)strFieldName);
            }
            if (StringHelper.Compare((String)strCondition, (String)"RIGHTLIKE", (boolean)true) == 0) {
                this.callParams.add(callParam);
                return StringHelper.Format((String)"%1$s LIKE  '%%'|| ? ", (Object)strFieldName);
            }
        }
        return "";
    }

    @Override
    public String GetCountSQL(String strSQL) {
        return StringHelper.Format((String)"select count(%2$s) as TOTALROW from (%1$s) m1", (Object)strSQL, (Object)this.GetMajorDEHelper().GetKeyDEFHelper().getName());
    }

    @Override
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
                script.Append("SELECT * FROM (Select m1.*, rownumber() over(ORDER BY m1.%2$s %3$s) as SRFROWINDEX from (%1$s ) m1 ", (Object)strSQL, (Object)strMajor, (Object)strMajorDirection);
            } else {
                script.Append("SELECT * FROM (Select m1.*, rownumber() over(ORDER BY m1.%2$s %3$s,%4$s %5$s) as SRFROWINDEX from (%1$s ) m1 ", (Object)strSQL, (Object)strMajor, (Object)strMajorDirection, (Object)strMinor, (Object)strMinorDirection);
            }
        } else {
            int nFetchCnt = nStartPos + nPageSize + 1;
            if (nFetchCnt > 1000000) {
                script.Append("SELECT * FROM (Select m1.*, rownumber() over() as SRFROWINDEX from (%1$s  ) m1 ", (Object)strSQL, (Object)nFetchCnt);
            } else {
                script.Append("SELECT * FROM (Select m1.*, rownumber() over() as SRFROWINDEX from (%1$s  fetch first %2$s  rows only  ) m1 ", (Object)strSQL, (Object)nFetchCnt);
            }
        }
        script.Append(" ) AS a1 WHERE a1.SRFROWINDEX >= %1$s and a1.SRFROWINDEX < %2$s ", (Object)(nStartPos + 1), (Object)(nStartPos + nPageSize + 1));
        return script.toString();
    }

    @Override
    public String GetSortSQL(String strSQL, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection) {
        StringBuilderEx script = new StringBuilderEx();
        if (!StringHelper.IsNullOrEmpty((String)strMajor)) {
            script.Append("Select m1.* from (%1$s) m1 ORDER BY m1.%2$s %3$s", (Object)strSQL, (Object)strMajor, (Object)strMajorDirection);
            if (!StringHelper.IsNullOrEmpty((String)strMinor) && StringHelper.Compare((String)strMajor, (String)strMinor, (boolean)true) != 0) {
                script.Append(", m1.%1$s %2$s", (Object)strSQL, (Object)strMinor, (Object)strMinorDirection);
            }
        } else {
            return strSQL;
        }
        return script.toString();
    }

    @Override
    public String GetFetchTopRowSQL(String strSQL, int topCount) {
        return StringHelper.Format((String)" %1$s fetch first %2$s row only", (Object)strSQL, (Object)topCount);
    }

    @Override
    public String GetDBType() {
        return "DB2";
    }

    @Override
    public String GetQMDeclareScript() {
        String strQMDeclareScript = "";
        for (String strName : this.qmDeclareMap.keySet()) {
            QueryModelDeclare qmDeclare = (QueryModelDeclare)this.qmDeclareMap.get(strName);
            String strDeclareCode = qmDeclare.getDeclareCode();
            String strDeclareCode2 = (strDeclareCode = strDeclareCode.trim()).toUpperCase();
            if (strDeclareCode2.indexOf("WITH") == 0) {
                strDeclareCode = strDeclareCode.substring(4);
            }
            if (!StringHelper.IsNullOrEmpty((String)strQMDeclareScript)) {
                strQMDeclareScript = String.valueOf(strQMDeclareScript) + ",\n";
            }
            strQMDeclareScript = String.valueOf(strQMDeclareScript) + strDeclareCode;
            strQMDeclareScript = String.valueOf(strQMDeclareScript) + "\n";
        }
        if (!StringHelper.IsNullOrEmpty((String)strQMDeclareScript)) {
            strQMDeclareScript = "WITH " + strQMDeclareScript;
        }
        return strQMDeclareScript;
    }
}

