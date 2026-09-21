/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data.DB2;

import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DB2.DB2DBProcCaller;
import SA.SRFramework.Data.DB2.DB2DataSet;
import SA.SRFramework.Data.IDBRawProcCaller4;
import SA.SRFramework.Data.SelectResult;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class DB2RawProcCaller4
extends DB2DBProcCaller
implements IDBRawProcCaller4 {
    @Override
    public SelectResult Invoke(String strProcName, Vector<CallParam> list, int nTimeOut) throws SQLException {
        SelectResult dbResult = new SelectResult();
        dbResult.setRetCode(-1);
        dbResult.setDatabase(4);
        Connection DB2Conn = this.CreateConnection();
        if (DB2Conn == null) {
            this.SetErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            dbResult.setErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            return dbResult;
        }
        Hashtable<Integer, String> outputParamList = new Hashtable<Integer, String>();
        Statement cstmt = null;
        try {
            try {
                int nParamCount = 0;
                if (list != null) {
                    nParamCount = list.size();
                }
                String strProc = DB2RawProcCaller4.FormatProcCall(strProcName, nParamCount);
                cstmt = DB2Conn.prepareCall(strProc);
                if (list != null) {
                    int i = 0;
                    while (i < list.size()) {
                        CallParam param = list.get(i);
                        if (param.getDirection() == 1) {
                            if (param.getDataType() != 0) {
                                cstmt.setObject(i + 1, param.getValue(), DB2RawProcCaller4.GetJDBCType(param.getDataType()));
                            } else {
                                cstmt.setObject(i + 1, param.getValue());
                            }
                        } else if (param.getDirection() == 2) {
                            cstmt.registerOutParameter(i + 1, DB2RawProcCaller4.GetJDBCType(param.getDataType()));
                            outputParamList.put(i + 1, param.getOutputParamName().toUpperCase());
                        } else if (param.getDirection() == 3) {
                            if (param.getDataType() != 0) {
                                cstmt.setObject(i + 1, param.getValue(), DB2RawProcCaller4.GetJDBCType(param.getDataType()));
                            } else {
                                cstmt.setObject(i + 1, param.getValue());
                            }
                            cstmt.registerOutParameter(i + 1, DB2RawProcCaller4.GetJDBCType(param.getDataType()));
                            outputParamList.put(i + 1, param.getOutputParamName().toUpperCase());
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
                Enumeration enumeration = outputParamList.keys();
                while (enumeration.hasMoreElements()) {
                    int nIndex = (Integer)enumeration.nextElement();
                    Object objValue = cstmt.getObject(nIndex);
                    if (objValue == null) continue;
                    dbResult.getOutValues().put(outputParamList.get(nIndex), objValue);
                }
                Integer nRetCode = 0;
                dbResult.setRetCode(nRetCode);
                dbResult.setSelectData(dataSet);
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
    public SelectResult Invoke(String strProcName, Vector<CallParam> list) throws SQLException {
        return this.Invoke(strProcName, list, -1);
    }
}

