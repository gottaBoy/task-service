/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.IDBRawProcCaller4
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.Data.SqlServer.SqlDBProcCaller
 */
package SA.SRFramework.Data.SqlServer;

import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.IDBRawProcCaller4;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Data.SqlServer.SqlDBProcCaller;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class SqlServerRawProcCaller4
extends SqlDBProcCaller
implements IDBRawProcCaller4 {
    public SelectResult Invoke(String strProcName, Vector<CallParam> list, int nTimeOut) throws SQLException {
        SelectResult dbResult = new SelectResult();
        dbResult.setRetCode(-1);
        dbResult.setDatabase(2);
        Connection GroupLevel = this.CreateConnection();
        if (GroupLevel == null) {
            this.SetErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            dbResult.setErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            return dbResult;
        }
        Hashtable<Integer, String> outputParamList = new Hashtable<Integer, String>();
        Statement cstmt = null;
        try {
            try {
                int nParamCount = 0;
                int nParamReturnRS = -1;
                if (list != null) {
                    nParamCount = list.size();
                }
                String strProc = SqlServerRawProcCaller4.FormatProcCall((String)strProcName, (int)nParamCount, (boolean)false);
                cstmt = GroupLevel.prepareCall(strProc);
                if (list != null) {
                    int i = 0;
                    while (i < list.size()) {
                        CallParam param = list.get(i);
                        if (param.getDirection() == 1) {
                            if (param.getDataType() != 0) {
                                cstmt.setObject(i + 1, param.getValue(), SqlServerRawProcCaller4.GetJDBCType((int)param.getDataType()));
                            } else {
                                cstmt.setObject(i + 1, param.getValue());
                            }
                        } else if (param.getDirection() == 2) {
                            cstmt.registerOutParameter(i + 1, SqlServerRawProcCaller4.GetJDBCType((int)param.getDataType()));
                            outputParamList.put(i + 1, param.getOutputParamName().toUpperCase());
                        } else if (param.getDirection() == 3) {
                            if (param.getDataType() != 0) {
                                cstmt.setObject(i + 1, param.getValue(), SqlServerRawProcCaller4.GetJDBCType((int)param.getDataType()));
                            } else {
                                cstmt.setObject(i + 1, param.getValue());
                            }
                            cstmt.registerOutParameter(i + 1, SqlServerRawProcCaller4.GetJDBCType((int)param.getDataType()));
                            outputParamList.put(i + 1, param.getOutputParamName().toUpperCase());
                        }
                        ++i;
                    }
                }
                cstmt.execute();
                DataSet dataSet = new DataSet();
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
                dbResult.setRetCode(nRetCode.intValue());
                dbResult.setSelectData(dataSet);
            }
            catch (Exception ex) {
                this.LogErrorInfo(ex.toString());
                dbResult.setErrorInfo(ex.toString());
                ex.printStackTrace(System.out);
                if (cstmt != null) {
                    cstmt.close();
                }
                this.ReleaseConnection(GroupLevel);
            }
        }
        finally {
            if (cstmt != null) {
                cstmt.close();
            }
            this.ReleaseConnection(GroupLevel);
        }
        return dbResult;
    }

    public SelectResult Invoke(String strProcName, Vector<CallParam> list) throws SQLException {
        return this.Invoke(strProcName, list, -1);
    }
}

