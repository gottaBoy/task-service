/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.DBCallResult
 *  net.ibizsys.paas.db.IDBFunction
 *  net.ibizsys.paas.db.IDataSet
 *  net.ibizsys.paas.db.SqlParam
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.db.impl.DBDialectImpl
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.db.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.IDBFunction;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.db.impl.DBDialectImpl;
import net.ibizsys.paas.db.impl.SQLiteDBImpl;
import net.ibizsys.paas.db.impl.SQLiteDataSetImpl;
import net.ibizsys.paas.db.impl.SQLiteDateDiffNow2DBFunctionImpl;
import net.ibizsys.paas.db.impl.SQLiteDateDiffNowDBFunctionImpl;
import net.ibizsys.paas.db.impl.SQLiteStrLenDBFunctionImpl;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SQLiteDialectImpl
extends DBDialectImpl {
    private static final Log log = LogFactory.getLog(SQLiteDBImpl.class);
    private static SQLiteDateDiffNowDBFunctionImpl sqliteDateDiffNowDBFunctionImpl = new SQLiteDateDiffNowDBFunctionImpl();
    private static SQLiteStrLenDBFunctionImpl sqliteStrLenDBFunctionImpl = new SQLiteStrLenDBFunctionImpl();
    private static SQLiteDateDiffNow2DBFunctionImpl sqliteDateDiffNowDB2FunctionImpl = new SQLiteDateDiffNow2DBFunctionImpl();

    public SQLiteDialectImpl() {
        this.registerDBFunction((IDBFunction)sqliteDateDiffNowDBFunctionImpl);
        this.registerDBFunction((IDBFunction)sqliteStrLenDBFunctionImpl);
        this.registerDBFunction((IDBFunction)sqliteDateDiffNowDB2FunctionImpl);
    }

    public String getDBType() {
        return "MYSQL5";
    }

    public String getCountSQL(String strSQL) {
        return StringHelper.format((String)"select count(*) as TOTALROW from (%1$s) m1", (Object)strSQL);
    }

    public int getJDBCType(int dataType) {
        if (dataType == 1) {
            return -5;
        }
        if (dataType == 2) {
            return -2;
        }
        if (dataType == 3) {
            return -7;
        }
        if (dataType == 4 || dataType == 11 || dataType == 26) {
            return 1;
        }
        if (dataType == 28 || dataType == 5 || dataType == 16 || dataType == 22) {
            return 93;
        }
        if (dataType == 6 || dataType == 29 || dataType == 10 || dataType == 18) {
            return 3;
        }
        if (dataType == 7) {
            return 6;
        }
        if (dataType == 8) {
            return -4;
        }
        if (dataType == 9) {
            return 4;
        }
        if (dataType == 12 || dataType == 21) {
            return -1;
        }
        if (dataType == 14) {
            return 2;
        }
        if (dataType == 13 || dataType == 19 || dataType == 20 || dataType == 25) {
            return 12;
        }
        if (dataType == 15) {
            return 7;
        }
        if (dataType == 17) {
            return 5;
        }
        if (dataType == 23) {
            return -6;
        }
        if (dataType == 24) {
            return -3;
        }
        return 12;
    }

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
        script.append(" ) a1 limit %1$s,%2$s ", (Object)nStartPos, (Object)nPageSize);
        return script.toString();
    }

    public DBCallResult callSql(Connection connection, String strCommand, SqlParamList list, int nTimeOut) {
        DBCallResult dbResult;
        block30: {
            dbResult = new DBCallResult();
            dbResult.setRetCode(0);
            PreparedStatement cstmt = null;
            try {
                try {
                    if (connection == null) {
                        throw new Exception("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
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
                    Boolean bSelect = cstmt.execute();
                    SQLiteDataSetImpl dataSet = new SQLiteDataSetImpl(null, cstmt);
                    dataSet.setSqlInfo(strCommand);
                    int updateCount = cstmt.getUpdateCount();
                    if (!bSelect.booleanValue() && updateCount >= 0) {
                        dbResult.setUpdateCount(updateCount);
                    } else {
                        ResultSet rs = cstmt.getResultSet();
                        if (rs != null) {
                            dataSet.addResultSet(rs);
                        }
                    }
                    dbResult.setRetCode(0);
                    if (dataSet.getDataTableCount() > 0) {
                        dbResult.setDataSet((IDataSet)dataSet);
                        break block30;
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
                    try {
                        if (dbResult.getDataSet() == null) {
                            // empty if block
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
                    if (dbResult.getDataSet() == null) {
                        // empty if block
                    }
                }
                catch (Exception ex) {
                    log.error((Object)ex.getMessage(), (Throwable)ex);
                }
            }
        }
        return dbResult;
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    public DBCallResult callSqlBatch(Connection connection, String[] commands, SqlParamList[] lists, int nBatchSize, int nTimeOut) throws Exception {
        block44: {
            block42: {
                block45: {
                    block43: {
                        dbResult = new DBCallResult();
                        dbResult.setRetCode(0);
                        cstmt = null;
                        cstmt2 = null;
                        isList = null;
                        try {
                            if (connection == null) {
                                throw new Exception("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
                            }
                            if (lists == null) {
                                cstmt2 = connection.createStatement();
                                nIndex = 0;
                                var14_12 = commands;
                                var13_13 = commands.length;
                                var12_14 = 0;
                                while (var12_14 < var13_13) {
                                    strCommand = var14_12[var12_14];
                                    cstmt2.addBatch(strCommand);
                                    if (nBatchSize > 0 && ++nIndex == nBatchSize) {
                                        nIndex = 0;
                                        cstmt2.executeBatch();
                                        cstmt2.clearBatch();
                                    }
                                    ++var12_14;
                                }
                                cstmt2.executeBatch();
                            } else {
                                if (commands.length != 1) {
                                    throw new Exception("\u4f20\u5165SQL\u53c2\u6570\u6709\u8bef\uff0c\u5fc5\u987b\u6307\u5b9a\u4e00\u4e2a\u8981\u6267\u884c\u7684\u8bed\u53e5");
                                }
                                cstmt = connection.prepareStatement(commands[0]);
                                nIndex = 0;
                                var14_12 = lists;
                                var13_13 = lists.length;
                                var12_14 = 0;
                                while (var12_14 < var13_13) {
                                    list = var14_12[var12_14];
                                    i = 0;
                                    while (i < list.size()) {
                                        callParam = (SqlParam)list.get(i);
                                        if (callParam.getDataType() != 0) {
                                            if (callParam.getDataType() == 2 || callParam.getDataType() == 24) {
                                                if (callParam.getValue() == null || !(callParam.getValue() instanceof byte[])) {
                                                    cstmt.setObject(i + 1, callParam.getValue(), this.getJDBCType(callParam.getDataType()));
                                                } else {
                                                    buffer = (byte[])callParam.getValue();
                                                    if (isList == null) {
                                                        isList = new ArrayList<ByteArrayInputStream>();
                                                    }
                                                    is = new ByteArrayInputStream(buffer);
                                                    cstmt.setBinaryStream(i + 1, is, buffer.length);
                                                    isList.add(is);
                                                }
                                            } else {
                                                cstmt.setObject(i + 1, callParam.getValue(), this.getJDBCType(callParam.getDataType()));
                                            }
                                        } else {
                                            cstmt.setObject(i + 1, callParam.getValue());
                                        }
                                        ++i;
                                    }
                                    cstmt.addBatch();
                                    if (nBatchSize > 0 && ++nIndex == nBatchSize) {
                                        nIndex = 0;
                                        cstmt.executeBatch();
                                        cstmt.clearBatch();
                                    }
                                    ++var12_14;
                                }
                                cstmt.executeBatch();
                            }
                            dbResult.setRetCode(0);
                            break block42;
                        }
                        catch (Exception ex) {
                            SQLiteDialectImpl.log.error((Object)ex.getMessage(), (Throwable)ex);
                            dbResult.setErrorInfo(ex.toString());
                            dbResult.setRetCode(1);
                            if (isList == null) break block43;
                            ** for (is : isList)
                        }
lbl-1000:
                        // 1 sources

                        {
                            try {
                                is.close();
                            }
                            catch (Exception ex) {
                                SQLiteDialectImpl.log.error((Object)ex.getMessage(), (Throwable)ex);
                            }
                            continue;
                        }
                    }
                    try {
                        if (cstmt != null) {
                            cstmt.close();
                            cstmt = null;
                        }
                        if (cstmt2 != null) {
                            cstmt2.close();
                            cstmt = null;
                        }
                        break block44;
                    }
                    catch (Exception ex) {
                        SQLiteDialectImpl.log.error((Object)ex.getMessage(), (Throwable)ex);
                    }
                    break block44;
                    catch (Throwable var19_32) {
                        if (isList == null) break block45;
                        ** for (is : isList)
                    }
lbl-1000:
                    // 1 sources

                    {
                        try {
                            is.close();
                        }
                        catch (Exception ex) {
                            SQLiteDialectImpl.log.error((Object)ex.getMessage(), (Throwable)ex);
                        }
                        continue;
                    }
                }
                try {
                    if (cstmt != null) {
                        cstmt.close();
                        cstmt = null;
                    }
                    if (cstmt2 != null) {
                        cstmt2.close();
                        cstmt = null;
                    }
                }
                catch (Exception ex) {
                    SQLiteDialectImpl.log.error((Object)ex.getMessage(), (Throwable)ex);
                }
                throw var19_32;
            }
            if (isList != null) {
                for (InputStream is : isList) {
                    try {
                        is.close();
                    }
                    catch (Exception ex) {
                        SQLiteDialectImpl.log.error((Object)ex.getMessage(), (Throwable)ex);
                    }
                }
            }
            try {
                if (cstmt != null) {
                    cstmt.close();
                    cstmt = null;
                }
                if (cstmt2 != null) {
                    cstmt2.close();
                    cstmt = null;
                }
            }
            catch (Exception ex) {
                SQLiteDialectImpl.log.error((Object)ex.getMessage(), (Throwable)ex);
            }
        }
        return dbResult;
    }

    public DBCallResult callProc(Connection connection, String strProcName, SqlParamList list, int nTimeOut) throws Exception {
        DBCallResult dbResult;
        block25: {
            HashMap<Integer, SqlParam> outputParamMap = new HashMap<Integer, SqlParam>();
            dbResult = new DBCallResult();
            dbResult.setRetCode(0);
            Statement cstmt = null;
            try {
                try {
                    SqlParam callParam;
                    if (connection == null) {
                        throw new Exception("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
                    }
                    String strCall = SQLiteDialectImpl.formatProcCall(strProcName, list.size());
                    cstmt = connection.prepareCall(strCall);
                    if (list != null) {
                        int i = 0;
                        while (i < list.size()) {
                            callParam = (SqlParam)list.get(i);
                            if (callParam.getDirection() == 1) {
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
                    callParam = outputParamMap.keySet().iterator();
                    while (callParam.hasNext()) {
                        int nIndex = (Integer)callParam.next();
                        SqlParam sqlParam = (SqlParam)outputParamMap.get(nIndex);
                        dbResult.getOutputValues(true).put(sqlParam.getOutputParamName(), cstmt.getObject(nIndex));
                    }
                    SQLiteDataSetImpl dataSet = new SQLiteDataSetImpl(null, (PreparedStatement)cstmt);
                    while (true) {
                        int updateCount;
                        if ((updateCount = cstmt.getUpdateCount()) < 0) {
                            ResultSet rs = cstmt.getResultSet();
                            if (rs == null) break;
                            dataSet.addResultSet(rs);
                            break;
                        }
                        dbResult.setUpdateCount(updateCount);
                        cstmt.getMoreResults();
                    }
                    dbResult.setRetCode(0);
                    if (dataSet.getDataTableCount() > 0) {
                        dbResult.setDataSet((IDataSet)dataSet);
                        break block25;
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
        String strCall = "{";
        strCall = String.valueOf(strCall) + "call ";
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
        } else {
            strCall = String.valueOf(strCall) + "()";
        }
        strCall = String.valueOf(strCall) + "; }";
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
        if (!bParam) {
            if (StringHelper.compare((String)strCondOp, (String)"IN", (boolean)true) == 0) {
                String strCondition = "";
                String[] stringArray = strValue.split("[;|,]");
                int n = stringArray.length;
                int n2 = 0;
                while (n2 < n) {
                    String value = stringArray[n2];
                    if (!StringHelper.isNullOrEmpty((String)strCondition)) {
                        strCondition = String.valueOf(strCondition) + " or ";
                    }
                    strCondition = String.valueOf(strCondition) + StringHelper.format((String)"%1$s like '%%%2$s%%'", (Object)strFieldName, (Object)value);
                    ++n2;
                }
                if (StringHelper.isNullOrEmpty((String)strCondition)) {
                    strCondition = "0=0";
                }
                return StringHelper.format((String)"(%1$s)", (Object)strCondition);
            }
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
                return StringHelper.format((String)"UPPER(%1$s) LIKE '%2$s'", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.compare((String)strCondOp, (String)"LEFTLIKE", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                strValue = String.valueOf(strValue) + "%";
                return StringHelper.format((String)"UPPER(%1$s) LIKE '%2$s'", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.compare((String)strCondOp, (String)"RIGHTLIKE", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                strValue = "%" + strValue;
                return StringHelper.format((String)"UPPER(%1$s) LIKE '%2$s'", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
            if (StringHelper.compare((String)strCondOp, (String)"USERLIKE", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                return StringHelper.format((String)"UPPER(%1$s) LIKE '%2$s'", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
        } else {
            SqlParam sqlParam = new SqlParam();
            sqlParam.setDataType(nStdDataType);
            if (StringHelper.compare((String)strCondOp, (String)"IN", (boolean)true) == 0) {
                String strCondition = "";
                String[] stringArray = strValue.split("[;|,]");
                int n = stringArray.length;
                int n3 = 0;
                while (n3 < n) {
                    String value = stringArray[n3];
                    if (!StringHelper.isNullOrEmpty((String)strCondition)) {
                        strCondition = String.valueOf(strCondition) + " or ";
                    }
                    SqlParam sqlParam2 = new SqlParam();
                    sqlParam2.setValue((Object)("%" + value + "%"));
                    sqlParam2.setDataType(nStdDataType);
                    sqlParamList.add((Object)sqlParam2);
                    strCondition = String.valueOf(strCondition) + StringHelper.format((String)"%1$s like ?", (Object)strFieldName);
                    ++n3;
                }
                if (StringHelper.isNullOrEmpty((String)strCondition)) {
                    strCondition = "0=0";
                }
                return StringHelper.format((String)"(%1$s)", (Object)strCondition);
            }
            if (StringHelper.compare((String)strCondOp, (String)"EQ", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                sqlParam.setValue((Object)strValue);
                sqlParamList.add((Object)sqlParam);
                return StringHelper.format((String)"%1$s = ?", (Object)strFieldName);
            }
            if (StringHelper.compare((String)strCondOp, (String)"NOTEQ", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                sqlParam.setValue((Object)strValue);
                sqlParamList.add((Object)sqlParam);
                return StringHelper.format((String)"%1$s <> ?", (Object)strFieldName);
            }
            if (StringHelper.compare((String)strCondOp, (String)"LIKE", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                strValue = "%" + strValue + "%";
                sqlParam.setValue((Object)strValue.toUpperCase());
                sqlParamList.add((Object)sqlParam);
                return StringHelper.format((String)"UPPER(%1$s) LIKE ?", (Object)strFieldName);
            }
            if (StringHelper.compare((String)strCondOp, (String)"LEFTLIKE", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                strValue = String.valueOf(strValue) + "%";
                sqlParam.setValue((Object)strValue.toUpperCase());
                sqlParamList.add((Object)sqlParam);
                return StringHelper.format((String)"UPPER(%1$s) LIKE ?", (Object)strFieldName);
            }
            if (StringHelper.compare((String)strCondOp, (String)"RIGHTLIKE", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                strValue = "%" + strValue;
                sqlParam.setValue((Object)strValue.toUpperCase());
                sqlParamList.add((Object)sqlParam);
                return StringHelper.format((String)"UPPER(%1$s) LIKE ?", (Object)strFieldName);
            }
            if (StringHelper.compare((String)strCondOp, (String)"USERLIKE", (boolean)true) == 0) {
                strValue = strValue.replace("'", "''");
                sqlParam.setValue((Object)strValue.toUpperCase());
                sqlParamList.add((Object)sqlParam);
                return StringHelper.format((String)"UPPER(%1$s) LIKE ?", (Object)strFieldName);
            }
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
            if (StringHelper.compare((String)strCondOp, (String)"BITAND", (boolean)true) == 0) {
                if (StringHelper.compare((String)strValue, (String)"0", (boolean)true) == 0) {
                    return "(0=0)";
                }
                return StringHelper.format((String)"(%1$s & %2$s)>0", (Object)strFieldName, (Object)strValue);
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
                String[] items = strValue.split("[;|,]");
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
        sqlParam.setValue((Object)strValue);
        sqlParam.setDataType(nStdDataType);
        if (StringHelper.compare((String)strCondOp, (String)"BITAND", (boolean)true) == 0) {
            sqlParamList.add((Object)sqlParam);
            if (StringHelper.compare((String)strValue, (String)"0", (boolean)true) == 0) {
                return "(0=?)";
            }
            return StringHelper.format((String)"(%1$s & ?)>0", (Object)strFieldName);
        }
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
        if (StringHelper.compare((String)strCondOp, (String)"IN", (boolean)true) == 0 || StringHelper.compare((String)strCondOp, (String)"NOTIN", (boolean)true) == 0) {
            if (StringHelper.isNullOrEmpty((String)strValue)) {
                if (StringHelper.compare((String)strCondOp, (String)"IN", (boolean)true) == 0) {
                    return "1<>1";
                }
                return "1=1";
            }
            String[] items = strValue.split("[;|,]");
            String strSQL = "";
            strSQL = StringHelper.compare((String)strCondOp, (String)"IN", (boolean)true) == 0 ? StringHelper.format((String)"%1$s IN (", (Object)strFieldName) : StringHelper.format((String)"%1$s NOT IN (", (Object)strFieldName);
            int i = 0;
            while (i < items.length) {
                if (i != 0) {
                    strSQL = String.valueOf(strSQL) + ",";
                }
                strSQL = String.valueOf(strSQL) + StringHelper.format((String)"%1$s", (Object)"?");
                SqlParam sqlParam2 = new SqlParam();
                sqlParam2.setValue((Object)items[i]);
                sqlParam2.setDataType(nStdDataType);
                sqlParamList.add((Object)sqlParam);
                ++i;
            }
            strSQL = String.valueOf(strSQL) + ")";
            return strSQL;
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

    public String getFuncSQL(String strFuncType, boolean bInsert, String[] args) throws Exception {
        if (StringHelper.compare((String)strFuncType, (String)"CURDATETIME", (boolean)true) == 0) {
            return "datetime('now', 'localtime')";
        }
        return super.getFuncSQL(strFuncType, bInsert, args);
    }

    public String getDBObjStandardName(String strOriginName) {
        return StringHelper.format((String)"`%1$s`", (Object)strOriginName);
    }
}

