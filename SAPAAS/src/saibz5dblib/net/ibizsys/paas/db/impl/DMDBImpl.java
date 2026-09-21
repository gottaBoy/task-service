/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.DBCallResult
 *  net.ibizsys.paas.db.IDataSet
 *  net.ibizsys.paas.db.SqlParam
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.db.impl.DatabaseImpl
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.db.impl.DMDataSetImpl;
import net.ibizsys.paas.db.impl.DatabaseImpl;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DMDBImpl
extends DatabaseImpl {
    private static final Log log = LogFactory.getLog(DMDBImpl.class);

    public String getPagingSQL(String strSQL, int nStartPos, int nPageSize, String strMajor, String strMajorDirection, String strMinor, String strMinorDirection) {
        if (StringHelper.isNullOrEmpty((String)strMajor) && !StringHelper.isNullOrEmpty((String)strMinor)) {
            strMajor = strMinor;
            strMajorDirection = strMinorDirection;
            strMinor = "";
            strMinorDirection = "";
        }
        StringBuilderEx script = new StringBuilderEx();
        if (!StringHelper.isNullOrEmpty((String)strMinor)) {
            script.append("SELECT * FROM (Select m1.* from ( select * from (%1$s) pagetemp ORDER BY pagetemp.%2$s %3$s,pagetemp.%4$s %5$s) m1 ", (Object)strSQL, (Object)strMajor, (Object)strMajorDirection, (Object)strMinor, (Object)strMinorDirection);
        } else if (!StringHelper.isNullOrEmpty((String)strMajor)) {
            script.append("SELECT * FROM (Select m1.* from ( select * from (%1$s) pagetemp ORDER BY pagetemp.%2$s %3$s) m1 ", (Object)strSQL, (Object)strMajor, (Object)strMajorDirection);
        } else {
            script.append("SELECT * FROM (Select m1.* from (%1$s) m1 ", (Object)strSQL);
        }
        script.append(" ) a1 limit %2$s offset %1$s ", (Object)nStartPos, (Object)nPageSize);
        return script.toString();
    }

    public DBCallResult callSql(Connection connection, String strCommand, SqlParamList list, int nTimeOut) {
        DBCallResult dbResult = new DBCallResult();
        dbResult.setRetCode(0);
        Connection conn = null;
        PreparedStatement cstmt = null;
        try {
            try {
                if (connection == null) {
                    conn = this.getConnection();
                    if (conn == null) {
                        throw new Exception("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
                    }
                    connection = conn;
                }
                cstmt = connection.prepareStatement(strCommand);
                if (list != null) {
                    int i = 0;
                    while (i < list.size()) {
                        SqlParam callParam = (SqlParam)list.get(i);
                        if (callParam.getDataType() != 0) {
                            cstmt.setObject(i + 1, callParam.getValue(), this.getJDBCType(callParam.getDataType()));
                        } else {
                            cstmt.setObject(i + 1, callParam.getValue());
                        }
                        ++i;
                    }
                }
                cstmt.execute();
                DMDataSetImpl dataSet = new DMDataSetImpl(conn, cstmt);
                while (true) {
                    int updateCount;
                    if ((updateCount = cstmt.getUpdateCount()) < 0) {
                        ResultSet rs = cstmt.getResultSet();
                        if (rs == null) break;
                        dataSet.addResultSet(rs);
                        break;
                    }
                    cstmt.getMoreResults();
                }
                dbResult.setRetCode(0);
                if (dataSet.getDataTableCount() > 0) {
                    dbResult.setDataSet((IDataSet)dataSet);
                }
            }
            catch (Exception ex) {
                log.error((Object)ex.getMessage(), (Throwable)ex);
                dbResult.setErrorInfo(ex.toString());
                dbResult.setRetCode(1);
                try {
                    if (dbResult.getDataSet() == null && cstmt != null) {
                        cstmt.close();
                    }
                }
                catch (Exception ex2) {
                    log.error((Object)ex2.getMessage(), (Throwable)ex2);
                }
                try {
                    if (dbResult.getDataSet() == null && conn != null) {
                        conn.close();
                    }
                }
                catch (Exception ex3) {
                    log.error((Object)ex3.getMessage(), (Throwable)ex3);
                }
            }
        }
        finally {
            try {
                if (dbResult.getDataSet() == null && cstmt != null) {
                    cstmt.close();
                }
            }
            catch (Exception ex) {
                log.error((Object)ex.getMessage(), (Throwable)ex);
            }
            try {
                if (dbResult.getDataSet() == null && conn != null) {
                    conn.close();
                }
            }
            catch (Exception ex) {
                log.error((Object)ex.getMessage(), (Throwable)ex);
            }
        }
        return dbResult;
    }

    public DBCallResult callProc(Connection connection, String strProcName, SqlParamList list, int nTimeOut) throws Exception {
        DBCallResult dbResult;
        block29: {
            HashMap<Integer, SqlParam> outputParamMap = new HashMap<Integer, SqlParam>();
            dbResult = new DBCallResult();
            dbResult.setRetCode(0);
            Statement cstmt = null;
            try {
                try {
                    if (connection == null) {
                        throw new Exception("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
                    }
                    int nParamCount = 0;
                    int nParamReturnRS = -1;
                    if (list != null) {
                        nParamCount = list.size();
                    }
                    String strCall = DMDBImpl.formatProcCall(strProcName, nParamCount);
                    cstmt = connection.prepareCall(strCall);
                    if (list != null) {
                        int i = 0;
                        while (i < list.size()) {
                            SqlParam callParam = (SqlParam)list.get(i);
                            if (StringHelper.compare((String)callParam.getOutputParamName(), (String)"SRF_RD", (boolean)true) == 0) {
                                cstmt.registerOutParameter(i + 1, 50);
                                nParamReturnRS = i + 1;
                            } else if (callParam.getDirection() == 1) {
                                cstmt.setObject(i + 1, callParam.getValue(), this.getJDBCType(callParam.getDataType()));
                            } else if (callParam.getDirection() == 2) {
                                cstmt.registerOutParameter(i + 1, this.getJDBCType(callParam.getDataType()));
                                outputParamMap.put(i + 1, callParam);
                            } else if (callParam.getDirection() == 3) {
                                cstmt.setObject(i + 1, callParam.getValue(), this.getJDBCType(callParam.getDataType()));
                                cstmt.registerOutParameter(i + 1, this.getJDBCType(callParam.getDataType()));
                                outputParamMap.put(i + 1, callParam);
                            }
                            ++i;
                        }
                    }
                    cstmt.execute();
                    DMDataSetImpl dataSet = new DMDataSetImpl(null, (PreparedStatement)cstmt);
                    if (nParamReturnRS >= 0) {
                        ResultSet rsSystem = (ResultSet)cstmt.getObject(nParamReturnRS);
                        dataSet.addResultSet(rsSystem);
                    }
                    Iterator iterator = outputParamMap.keySet().iterator();
                    while (iterator.hasNext()) {
                        int nIndex = (Integer)iterator.next();
                        SqlParam sqlParam = (SqlParam)outputParamMap.get(nIndex);
                        dbResult.getOutputValues(true).put(sqlParam.getOutputParamName(), cstmt.getObject(nIndex));
                    }
                    while (true) {
                        int updateCount;
                        if ((updateCount = cstmt.getUpdateCount()) < 0) {
                            ResultSet rs = cstmt.getResultSet();
                            if (rs == null) break;
                            dataSet.addResultSet(rs);
                            break;
                        }
                        cstmt.getMoreResults();
                    }
                    dbResult.setRetCode(0);
                    if (dataSet.getDataTableCount() > 0) {
                        dbResult.setDataSet((IDataSet)dataSet);
                        break block29;
                    }
                    dataSet.close();
                    cstmt = null;
                }
                catch (Exception ex) {
                    log.error((Object)ex.getMessage(), (Throwable)ex);
                    dbResult.setErrorInfo(ex.toString());
                    dbResult.setRetCode(1);
                    try {
                        if (dbResult.getDataSet() == null && cstmt != null) {
                            cstmt.close();
                        }
                    }
                    catch (Exception ex2) {
                        log.error((Object)ex2.getMessage(), (Throwable)ex2);
                    }
                }
            }
            finally {
                try {
                    if (dbResult.getDataSet() == null && cstmt != null) {
                        cstmt.close();
                    }
                }
                catch (Exception ex) {
                    log.error((Object)ex.getMessage(), (Throwable)ex);
                }
            }
        }
        return dbResult;
    }

    protected static String formatProcCall(String strProcName, int nParamCount) {
        String strCall = "call ";
        strCall = String.valueOf(strCall) + strProcName;
        strCall = String.valueOf(strCall) + " ";
        if (nParamCount > 0) {
            strCall = String.valueOf(strCall) + "(";
            int i = 0;
            while (i < nParamCount) {
                if (i != 0) {
                    strCall = String.valueOf(strCall) + ",";
                }
                strCall = String.valueOf(strCall) + "?";
                ++i;
            }
            strCall = String.valueOf(strCall) + ")";
        }
        strCall = String.valueOf(strCall) + " ;";
        return strCall;
    }

    public String getConditionSQL(String strFieldName, int nStdDataType, String strCondOp, String strValue, boolean bParam, SqlParamList sqlParamList) throws Exception {
        if (StringHelper.compare((String)strCondOp, (String)"TESTNULL", (boolean)true) == 0) {
            if (StringHelper.compare((String)strValue, (String)"1", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s IS NULL", (Object)strFieldName);
            }
            return StringHelper.format((String)"%1$s IS NOT NULL", (Object)strFieldName);
        }
        if (StringHelper.compare((String)strCondOp, (String)"ISNULL", (boolean)true) == 0) {
            return StringHelper.format((String)"%1$s IS NULL", (Object)strFieldName);
        }
        if (StringHelper.compare((String)strCondOp, (String)"ISNOTNULL", (boolean)true) == 0) {
            return StringHelper.format((String)"%1$s IS NOT NULL", (Object)strFieldName);
        }
        if (DataTypeHelper.isStringType((int)nStdDataType)) {
            return this.getStringConditionSQL(strFieldName, nStdDataType, strCondOp, strValue, bParam, sqlParamList);
        }
        if (DataTypeHelper.isIntType((int)nStdDataType)) {
            return this.getIntConditionSQL(strFieldName, nStdDataType, strCondOp, strValue, bParam, sqlParamList);
        }
        if (DataTypeHelper.isDoubleType((int)nStdDataType)) {
            return this.getDoubleConditionSQL(strFieldName, nStdDataType, strCondOp, strValue, bParam, sqlParamList);
        }
        if (DataTypeHelper.isDateTimeType((int)nStdDataType)) {
            return this.getDateTimeConditionSQL(strFieldName, nStdDataType, strCondOp, strValue, bParam, sqlParamList);
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6570\u636e\u5e93\u67e5\u8be2\u6761\u4ef6"));
    }

    public String getStringConditionSQL(String strFieldName, int nStdDataType, String strCondOp, String strValue) throws Exception {
        return this.getStringConditionSQL(strFieldName, nStdDataType, strCondOp, strValue, false, null);
    }

    protected String getStringConditionSQL(String strFieldName, int nStdDataType, String strCondOp, String strValue, boolean bParam, SqlParamList sqlParamList) throws Exception {
        if (StringHelper.compare((String)strCondOp, (String)"EQ", (boolean)true) == 0) {
            strValue = strValue.replace("'", "''");
            return StringHelper.format((String)"%1$s = '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.compare((String)strCondOp, (String)"NOTEQ", (boolean)true) == 0) {
            strValue = strValue.replace("'", "''");
            return StringHelper.format((String)"%1$s <> '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.compare((String)strCondOp, (String)"LIKE", (boolean)true) == 0) {
            strValue = strValue.replace("'", "''");
            strValue = "%" + strValue + "%";
            return StringHelper.format((String)"%1$s LIKE '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.compare((String)strCondOp, (String)"LEFTLIKE", (boolean)true) == 0) {
            strValue = strValue.replace("'", "''");
            strValue = String.valueOf(strValue) + "%";
            return StringHelper.format((String)"%1$s LIKE '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.compare((String)strCondOp, (String)"RIGHTLIKE", (boolean)true) == 0) {
            strValue = strValue.replace("'", "''");
            strValue = "%" + strValue;
            return StringHelper.format((String)"%1$s LIKE '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.compare((String)strCondOp, (String)"USERLIKE", (boolean)true) == 0) {
            strValue = strValue.replace("'", "''");
            return StringHelper.format((String)"%1$s LIKE '%2$s'", (Object)strFieldName, (Object)strValue);
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6761\u4ef6\u64cd\u4f5c\u7b26[%1$s]", (Object)strCondOp));
    }

    public String getIntConditionSQL(String strFieldName, int nStdDataType, String strCondOp, String strValue) throws Exception {
        return this.getIntConditionSQL(strFieldName, nStdDataType, strCondOp, strValue, false, null);
    }

    protected String getIntConditionSQL(String strFieldName, int nStdDataType, String strCondOp, String strValue, boolean bParam, SqlParamList sqlParamList) throws Exception {
        if (!bParam) {
            Object objValue = null;
            if (StringHelper.compare((String)strCondOp, (String)"IN", (boolean)true) != 0 && StringHelper.compare((String)strCondOp, (String)"NOTIN", (boolean)true) != 0 && (objValue = DataTypeHelper.testBigInt((String)strValue)) == null) {
                throw new Exception(StringHelper.format((String)"\u503c[%1$s]\u975e\u6574\u6570\u503c", (Object)strValue));
            }
            if (StringHelper.compare((String)strCondOp, (String)"EQ", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s = %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.compare((String)strCondOp, (String)"NOTEQ", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s <> %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.compare((String)strCondOp, (String)"GT", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s > %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.compare((String)strCondOp, (String)"GTANDEQ", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s >= %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.compare((String)strCondOp, (String)"LT", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s < %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.compare((String)strCondOp, (String)"LTANDEQ", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s <= %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.compare((String)strCondOp, (String)"IN", (boolean)true) == 0 || StringHelper.compare((String)strCondOp, (String)"NOTIN", (boolean)true) == 0) {
                if (StringHelper.isNullOrEmpty((String)strValue)) {
                    if (StringHelper.compare((String)strCondOp, (String)"IN", (boolean)true) == 0) {
                        return "1<>1";
                    }
                    return "1=1";
                }
                String[] items = strValue.split("[;]");
                String strSQL = "";
                strSQL = StringHelper.compare((String)strCondOp, (String)"IN", (boolean)true) == 0 ? StringHelper.format((String)"%1$s IN (", (Object)strFieldName) : StringHelper.format((String)"%1$s NOT IN (", (Object)strFieldName);
                int i = 0;
                while (i < items.length) {
                    if (i != 0) {
                        strSQL = String.valueOf(strSQL) + ",";
                    }
                    strSQL = String.valueOf(strSQL) + StringHelper.format((String)"%1$s", (Object)items[i]);
                    ++i;
                }
                strSQL = String.valueOf(strSQL) + ")";
                return strSQL;
            }
            return "";
        }
        SqlParam sqlParam = new SqlParam();
        sqlParam.setParamName(strValue);
        if (StringHelper.compare((String)strCondOp, (String)"EQ", (boolean)true) == 0) {
            sqlParamList.add((Object)sqlParam);
            return StringHelper.format((String)"%1$s = ?", (Object)strFieldName);
        }
        if (StringHelper.compare((String)strCondOp, (String)"NOTEQ", (boolean)true) == 0) {
            sqlParamList.add((Object)sqlParam);
            return StringHelper.format((String)"%1$s <> ?", (Object)strFieldName);
        }
        if (StringHelper.compare((String)strCondOp, (String)"GT", (boolean)true) == 0) {
            sqlParamList.add((Object)sqlParam);
            return StringHelper.format((String)"%1$s > ?", (Object)strFieldName);
        }
        if (StringHelper.compare((String)strCondOp, (String)"GTANDEQ", (boolean)true) == 0) {
            sqlParamList.add((Object)sqlParam);
            return StringHelper.format((String)"%1$s >=?", (Object)strFieldName);
        }
        if (StringHelper.compare((String)strCondOp, (String)"LT", (boolean)true) == 0) {
            sqlParamList.add((Object)sqlParam);
            return StringHelper.format((String)"%1$s < ?", (Object)strFieldName);
        }
        if (StringHelper.compare((String)strCondOp, (String)"LTANDEQ", (boolean)true) == 0) {
            sqlParamList.add((Object)sqlParam);
            return StringHelper.format((String)"%1$s <= ?", (Object)strFieldName);
        }
        return "";
    }

    public String getDoubleConditionSQL(String strFieldName, int nStdDataType, String strCondOp, String strValue) throws Exception {
        return this.getDoubleConditionSQL(strFieldName, nStdDataType, strCondOp, strValue, false, null);
    }

    protected String getDoubleConditionSQL(String strFieldName, int nStdDataType, String strCondOp, String strValue, boolean bParam, SqlParamList sqlParamList) throws Exception {
        if (!bParam) {
            Object objValue = DataTypeHelper.testDouble((String)strValue);
            if (objValue == null && StringHelper.compare((String)strCondOp, (String)"IN", (boolean)true) != 0 && StringHelper.compare((String)strCondOp, (String)"NOTIN", (boolean)true) != 0) {
                throw new Exception(StringHelper.format((String)"\u503c[%1$s]\u975e\u6d6e\u70b9\u503c", (Object)strValue));
            }
            if (StringHelper.compare((String)strCondOp, (String)"EQ", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s = %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.compare((String)strCondOp, (String)"NOTEQ", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s <> %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.compare((String)strCondOp, (String)"GT", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s > %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.compare((String)strCondOp, (String)"GTANDEQ", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s >= %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.compare((String)strCondOp, (String)"LT", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s < %2$s", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.compare((String)strCondOp, (String)"LTANDEQ", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s <= %2$s", (Object)strFieldName, (Object)strValue);
            }
            return "";
        }
        SqlParam sqlParam = new SqlParam();
        sqlParam.setParamName(strValue);
        if (StringHelper.compare((String)strCondOp, (String)"EQ", (boolean)true) == 0) {
            sqlParamList.add((Object)sqlParam);
            return StringHelper.format((String)"%1$s = ?", (Object)strFieldName);
        }
        if (StringHelper.compare((String)strCondOp, (String)"NOTEQ", (boolean)true) == 0) {
            sqlParamList.add((Object)sqlParam);
            return StringHelper.format((String)"%1$s <> ?", (Object)strFieldName);
        }
        if (StringHelper.compare((String)strCondOp, (String)"GT", (boolean)true) == 0) {
            sqlParamList.add((Object)sqlParam);
            return StringHelper.format((String)"%1$s > ?", (Object)strFieldName);
        }
        if (StringHelper.compare((String)strCondOp, (String)"GTANDEQ", (boolean)true) == 0) {
            sqlParamList.add((Object)sqlParam);
            return StringHelper.format((String)"%1$s >=?", (Object)strFieldName);
        }
        if (StringHelper.compare((String)strCondOp, (String)"LT", (boolean)true) == 0) {
            sqlParamList.add((Object)sqlParam);
            return StringHelper.format((String)"%1$s < ?", (Object)strFieldName);
        }
        if (StringHelper.compare((String)strCondOp, (String)"LTANDEQ", (boolean)true) == 0) {
            sqlParamList.add((Object)sqlParam);
            return StringHelper.format((String)"%1$s <= ?", (Object)strFieldName);
        }
        return "";
    }

    public String getDateTimeConditionSQL(String strFieldName, int nStdDataType, String strCondOp, String strValue) throws Exception {
        return this.getDateTimeConditionSQL(strFieldName, nStdDataType, strCondOp, strValue, false, null);
    }

    protected String getDateTimeConditionSQL(String strFieldName, int nStdDataType, String strCondOp, String strValue, boolean bParam, SqlParamList sqlParamList) throws Exception {
        if (!bParam) {
            Object objValue = null;
            if (!StringHelper.isNullOrEmpty((String)strValue)) {
                objValue = DataTypeHelper.testDateTime((String)strValue);
                if (objValue == null) {
                    throw new Exception(StringHelper.format((String)"\u503c[%1$s]\u975e\u65e5\u671f\u65f6\u95f4\u6027", (Object)strValue));
                }
                Timestamp ts = (Timestamp)objValue;
                strValue = StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)ts);
                if (StringHelper.compare((String)strCondOp, (String)"LT", (boolean)true) == 0 || StringHelper.compare((String)strCondOp, (String)"LTANDEQ", (boolean)true) == 0) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(new Date(ts.getTime()));
                    if (calendar.get(11) == 0 && calendar.get(12) == 0 && calendar.get(13) == 0) {
                        strValue = StringHelper.format((String)"%1$tY-%1$tm-%1$td 23:59:59", (Object)ts);
                        objValue = DataTypeHelper.testDateTime((String)strValue);
                    }
                }
            }
            if (StringHelper.compare((String)strCondOp, (String)"EQ", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s = '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.compare((String)strCondOp, (String)"NOTEQ", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s <> '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.compare((String)strCondOp, (String)"GT", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s > '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.compare((String)strCondOp, (String)"GTANDEQ", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s >= '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.compare((String)strCondOp, (String)"LT", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s < '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.compare((String)strCondOp, (String)"LTANDEQ", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s <= '%2$s'", (Object)strFieldName, (Object)strValue);
            }
            return "";
        }
        SqlParam sqlParam = new SqlParam();
        sqlParam.setParamName(strValue);
        if (StringHelper.compare((String)strCondOp, (String)"EQ", (boolean)true) == 0) {
            sqlParamList.add((Object)sqlParam);
            return StringHelper.format((String)"%1$s = ?", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.compare((String)strCondOp, (String)"NOTEQ", (boolean)true) == 0) {
            sqlParamList.add((Object)sqlParam);
            return StringHelper.format((String)"%1$s <> ?", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.compare((String)strCondOp, (String)"GT", (boolean)true) == 0) {
            sqlParamList.add((Object)sqlParam);
            return StringHelper.format((String)"%1$s > ?", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.compare((String)strCondOp, (String)"GTANDEQ", (boolean)true) == 0) {
            sqlParamList.add((Object)sqlParam);
            return StringHelper.format((String)"%1$s >= ?", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.compare((String)strCondOp, (String)"LT", (boolean)true) == 0) {
            sqlParamList.add((Object)sqlParam);
            return StringHelper.format((String)"%1$s < ?", (Object)strFieldName, (Object)strValue);
        }
        if (StringHelper.compare((String)strCondOp, (String)"LTANDEQ", (boolean)true) == 0) {
            sqlParamList.add((Object)sqlParam);
            return StringHelper.format((String)"%1$s <= ?", (Object)strFieldName, (Object)strValue);
        }
        return "";
    }
}

