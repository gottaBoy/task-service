/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.IDBRawProcCaller4
 *  SA.SRFramework.Data.Oracle.OraDBProcCaller
 *  SA.SRFramework.Data.Oracle.OracleDataSet
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.Data.Oracle;

import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.IDBRawProcCaller4;
import SA.SRFramework.Data.Oracle.OraDBProcCaller;
import SA.SRFramework.Data.Oracle.OracleDataSet;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class OraRawProcCaller4
extends OraDBProcCaller
implements IDBRawProcCaller4 {
    public SelectResult Invoke(String strProcName, Vector<CallParam> list, int nTimeOut) throws SQLException {
        SelectResult dbResult = new SelectResult();
        dbResult.setRetCode(-1);
        dbResult.setDatabase(1);
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
                int nParamReturnRS = -1;
                if (list != null) {
                    nParamCount = list.size();
                }
                String strProc = this.FormatProcCall(strProcName, nParamCount);
                cstmt = DB2Conn.prepareCall(strProc);
                if (nTimeOut > 0) {
                    cstmt.setQueryTimeout(300);
                }
                if (list != null) {
                    int i = 0;
                    while (i < list.size()) {
                        CallParam param = list.get(i);
                        if (StringHelper.Compare((String)param.getOutputParamName(), (String)"SRF_RD", (boolean)true) == 0) {
                            cstmt.registerOutParameter(i + 1, -10);
                            nParamReturnRS = i + 1;
                        } else if (param.getDirection() == 1) {
                            if (param.getDataType() != 0) {
                                cstmt.setObject(i + 1, param.getValue(), this.GetJDBCType(param.getDataType()));
                            } else {
                                cstmt.setObject(i + 1, param.getValue());
                            }
                        } else if (param.getDirection() == 2) {
                            cstmt.registerOutParameter(i + 1, this.GetJDBCType(param.getDataType()));
                            outputParamList.put(i + 1, param.getOutputParamName().toUpperCase());
                        } else if (param.getDirection() == 3) {
                            if (param.getDataType() != 0) {
                                cstmt.setObject(i + 1, param.getValue(), this.GetJDBCType(param.getDataType()));
                            } else {
                                cstmt.setObject(i + 1, param.getValue());
                            }
                            cstmt.registerOutParameter(i + 1, this.GetJDBCType(param.getDataType()));
                            outputParamList.put(i + 1, param.getOutputParamName().toUpperCase());
                        }
                        ++i;
                    }
                }
                cstmt.execute();
                OracleDataSet dataSet = new OracleDataSet();
                if (nParamReturnRS >= 0) {
                    try {
                        ResultSet rsSystem = (ResultSet)cstmt.getObject(nParamReturnRS);
                        dataSet.AddResultSet(rsSystem);
                        rsSystem.close();
                    }
                    catch (Exception rsSystem) {
                        // empty catch block
                    }
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
                dbResult.setSelectData((DataSet)dataSet);
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

    public SelectResult Invoke(String strProcName, Vector<CallParam> list) throws SQLException {
        return this.Invoke(strProcName, list, -1);
    }
}

