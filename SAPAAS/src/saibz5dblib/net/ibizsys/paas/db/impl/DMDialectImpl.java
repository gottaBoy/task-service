/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dm.jdbc.driver.DmdbType
 *  net.ibizsys.paas.db.DBCallResult
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

import dm.jdbc.driver.DmdbType;
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
import java.util.Iterator;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.db.impl.DBDialectImpl;
import net.ibizsys.paas.db.impl.DMDataSetImpl;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DMDialectImpl
extends DBDialectImpl {
    private static final Log log = LogFactory.getLog(DMDialectImpl.class);

    public String getDBType() {
        return "DM";
    }

    public String getCountSQL(String strSQL) {
        return StringHelper.format((String)"select count(*) as TOTALROW from (%1$s) m1", (Object)strSQL);
    }

    public int getJDBCType(int dataType) {
        return DmdbType.sqlTypeToDType((int)dataType);
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
        script.append(" ) a1 limit %2$s offset %1$s ", (Object)nStartPos, (Object)nPageSize);
        return script.toString();
    }

    public DBCallResult callSql(Connection connection, String strCommand, SqlParamList list, int nTimeOut) {
        DBCallResult dbResult;
        block21: {
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
                    cstmt.execute();
                    DMDataSetImpl dataSet = new DMDataSetImpl(null, cstmt);
                    dataSet.setSqlInfo(strCommand);
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
                        break block21;
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
                            DMDialectImpl.log.error((Object)ex.getMessage(), (Throwable)ex);
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
                                DMDialectImpl.log.error((Object)ex.getMessage(), (Throwable)ex);
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
                        DMDialectImpl.log.error((Object)ex.getMessage(), (Throwable)ex);
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
                            DMDialectImpl.log.error((Object)ex.getMessage(), (Throwable)ex);
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
                    DMDialectImpl.log.error((Object)ex.getMessage(), (Throwable)ex);
                }
                throw var19_32;
            }
            if (isList != null) {
                for (InputStream is : isList) {
                    try {
                        is.close();
                    }
                    catch (Exception ex) {
                        DMDialectImpl.log.error((Object)ex.getMessage(), (Throwable)ex);
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
                DMDialectImpl.log.error((Object)ex.getMessage(), (Throwable)ex);
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
                    String strCall = DMDialectImpl.formatProcCall(strProcName, nParamCount);
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
                return StringHelper.format((String)"%1$s = to_date('%2$s','yyyy-mm-dd hh24:mi:ss')", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.compare((String)strCondOp, (String)"NOTEQ", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s <> to_date('%2$s','yyyy-mm-dd hh24:mi:ss')", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.compare((String)strCondOp, (String)"GT", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s > to_date('%2$s','yyyy-mm-dd hh24:mi:ss')", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.compare((String)strCondOp, (String)"GTANDEQ", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s >= to_date('%2$s','yyyy-mm-dd hh24:mi:ss')", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.compare((String)strCondOp, (String)"LT", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s < to_date('%2$s','yyyy-mm-dd hh24:mi:ss')", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.compare((String)strCondOp, (String)"LTANDEQ", (boolean)true) == 0) {
                return StringHelper.format((String)"%1$s <= to_date('%2$s','yyyy-mm-dd hh24:mi:ss')", (Object)strFieldName, (Object)strValue);
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
            return "sysdate()";
        }
        return super.getFuncSQL(strFuncType, bInsert, args);
    }
}

