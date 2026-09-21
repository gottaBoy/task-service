/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data.DB2;

import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DB2.DB2DBProcCaller;
import SA.SRFramework.Data.DB2.DB2DataSet;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.IDBRawProcCaller3;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Data.SelectResult2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DB2RawProcCaller3
extends DB2DBProcCaller
implements IDBRawProcCaller3 {
    @Override
    public SelectResult Invoke(String strCommand, Vector<CallParam> list, int nTimeOut) throws SQLException {
        SelectResult dbResult = new SelectResult();
        dbResult.setRetCode(-1);
        dbResult.setDatabase(4);
        Connection DB2Conn = this.CreateConnection();
        if (DB2Conn == null) {
            this.SetErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            dbResult.setErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            return dbResult;
        }
        PreparedStatement cstmt = null;
        try {
            try {
                cstmt = DB2Conn.prepareStatement(strCommand);
                if (list != null) {
                    int i = 0;
                    while (i < list.size()) {
                        CallParam callParam = list.get(i);
                        if (callParam.getDataType() != 0) {
                            cstmt.setObject(i + 1, callParam.getValue(), DB2RawProcCaller3.GetJDBCType(callParam.getDataType()));
                        } else {
                            cstmt.setObject(i + 1, callParam.getValue());
                        }
                        ++i;
                    }
                }
                cstmt.execute();
                DB2DataSet dataSet = new DB2DataSet();
                while (true) {
                    int updateCount;
                    if ((updateCount = cstmt.getUpdateCount()) < 0) {
                        ResultSet rs = cstmt.getResultSet();
                        if (rs == null) break;
                        dataSet.AddResultSet(rs);
                        rs.close();
                    }
                    cstmt.getMoreResults();
                }
                Integer nRetCode = 0;
                dbResult.setRetCode(nRetCode);
                dbResult.setSelectData(dataSet);
                dbResult.setDataTableIndex(0);
            }
            catch (Exception ex) {
                this.LogErrorInfo(ex.toString());
                dbResult.setErrorInfo(ex.toString());
                ex.printStackTrace(System.out);
                if (cstmt != null) {
                    cstmt.close();
                }
                this.ReleaseConnection(DB2Conn);
            }
        }
        finally {
            if (cstmt != null) {
                cstmt.close();
            }
            this.ReleaseConnection(DB2Conn);
        }
        return dbResult;
    }

    @Override
    public DBResult Invoke2(String strCommand, Vector<CallParam> list, int nTimeOut) throws SQLException {
        DBResult dbResult = new DBResult();
        dbResult.setRetCode(-1);
        dbResult.setDatabase(4);
        Connection DB2Conn = this.CreateConnection();
        if (DB2Conn == null) {
            this.SetErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            dbResult.setErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            return dbResult;
        }
        PreparedStatement cstmt = null;
        try {
            try {
                cstmt = DB2Conn.prepareStatement(strCommand);
                if (list != null) {
                    int i = 0;
                    while (i < list.size()) {
                        CallParam callParam = list.get(i);
                        if (callParam.getDataType() != 0) {
                            cstmt.setObject(i + 1, callParam.getValue(), DB2RawProcCaller3.GetJDBCType(callParam.getDataType()));
                        } else {
                            cstmt.setObject(i + 1, callParam.getValue());
                        }
                        ++i;
                    }
                }
                cstmt.execute();
                Integer nRetCode = 0;
                dbResult.setRetCode(nRetCode);
            }
            catch (Exception ex) {
                this.LogErrorInfo(ex.toString());
                dbResult.setErrorInfo(ex.toString());
                ex.printStackTrace(System.out);
                if (cstmt != null) {
                    cstmt.close();
                }
                this.ReleaseConnection(DB2Conn);
            }
        }
        finally {
            if (cstmt != null) {
                cstmt.close();
            }
            this.ReleaseConnection(DB2Conn);
        }
        return dbResult;
    }

    @Override
    public SelectResult2 Invoke3(String strCommand, Vector<CallParam> list, int nTimeOut) throws SQLException {
        SelectResult2 dbResult;
        block15: {
            dbResult = new SelectResult2(this);
            dbResult.setRetCode(-1);
            dbResult.setDatabase(4);
            Connection DB2Conn = this.CreateConnection();
            if (DB2Conn == null) {
                this.SetErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
                dbResult.setErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
                return dbResult;
            }
            PreparedStatement cstmt = null;
            try {
                try {
                    cstmt = DB2Conn.prepareStatement(strCommand);
                    if (list != null) {
                        int i = 0;
                        while (i < list.size()) {
                            CallParam callParam = list.get(i);
                            if (callParam.getDataType() != 0) {
                                cstmt.setObject(i + 1, callParam.getValue(), DB2RawProcCaller3.GetJDBCType(callParam.getDataType()));
                            } else {
                                cstmt.setObject(i + 1, callParam.getValue());
                            }
                            ++i;
                        }
                    }
                    cstmt.execute();
                    DB2DataSet dataSet = new DB2DataSet();
                    while (true) {
                        int updateCount;
                        if ((updateCount = cstmt.getUpdateCount()) < 0) {
                            ResultSet rs = cstmt.getResultSet();
                            if (rs == null) break;
                            dataSet.AddResultSet(rs, true);
                            break;
                        }
                        cstmt.getMoreResults();
                    }
                    Integer nRetCode = 0;
                    dbResult.setRetCode(nRetCode);
                    dbResult.setSelectData(dataSet);
                    dbResult.setDataTableIndex(0);
                }
                catch (Exception ex) {
                    this.LogErrorInfo(ex.toString());
                    dbResult.setErrorInfo(ex.toString());
                    ex.printStackTrace(System.out);
                    if (dbResult.getRetCode() == 0) {
                        dbResult.setPreparedStatement(cstmt);
                        dbResult.setConnection(DB2Conn);
                        break block15;
                    }
                    cstmt.close();
                    this.ReleaseConnection(DB2Conn);
                }
            }
            finally {
                if (dbResult.getRetCode() == 0) {
                    dbResult.setPreparedStatement(cstmt);
                    dbResult.setConnection(DB2Conn);
                } else {
                    cstmt.close();
                    this.ReleaseConnection(DB2Conn);
                }
            }
        }
        return dbResult;
    }

    @Override
    public void ReleaseSelectResult(SelectResult2 selectResult2) {
        try {
            if (selectResult2.getPreparedStatement() != null) {
                selectResult2.getPreparedStatement().close();
            }
            if (selectResult2.getConnection() != null) {
                this.ReleaseConnection(selectResult2.getConnection());
            }
            selectResult2.setPreparedStatement(null);
            selectResult2.setConnection(null);
            selectResult2.setSelectData(null);
        }
        catch (Exception ex) {
            this.LogErrorInfo(ex.toString());
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public SelectResult Invoke(String strCommand, Vector<CallParam> list) throws SQLException {
        return this.Invoke(strCommand, list, -1);
    }

    @Override
    public DBResult Invoke2(String strCommand, Vector<CallParam> list) throws SQLException {
        return this.Invoke2(strCommand, list, -1);
    }

    @Override
    public SelectResult2 Invoke3(String strCommand, Vector<CallParam> list) throws SQLException {
        return this.Invoke3(strCommand, list, -1);
    }
}

