/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.IDBRawProcCaller4
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.Data.MySQL;

import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.IDBRawProcCaller4;
import SA.SRFramework.Data.MySQL.MySQLDBProcCallerEx;
import SA.SRFramework.Data.MySQL.MySQLDataSet;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Utility.StringHelper;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MySQLRawProcCaller4
extends MySQLDBProcCallerEx
implements IDBRawProcCaller4 {
    private static final Log log = LogFactory.getLog(MySQLRawProcCaller4.class);

    public SelectResult Invoke(String strProcName, Vector<CallParam> list, int nTimeOut) throws SQLException {
        SelectResult dbResult = new SelectResult();
        dbResult.setRetCode(-1);
        dbResult.setDatabase(3);
        Connection MySql = this.CreateConnection();
        if (MySql == null) {
            this.SetErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            dbResult.setErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            return dbResult;
        }
        Hashtable<Integer, String> outputParamList = new Hashtable<Integer, String>();
        CallableStatement cstmt = null;
        try {
            try {
                int nParamCount = 0;
                if (list != null) {
                    nParamCount = list.size();
                }
                String strProc = this.FormatProcCall2(strProcName, nParamCount);
                log.debug((Object)StringHelper.Format((String)"\u51c6\u5907\u8c03\u7528\u5b58\u50a8\u8fc7\u7a0b[%1$s]", (Object)strProc));
                cstmt = MySql.prepareCall(strProc);
                if (list != null) {
                    int i = 0;
                    while (i < list.size()) {
                        CallParam param = list.get(i);
                        if (param.getDirection() == 1) {
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
                MySQLDataSet dataSet = new MySQLDataSet();
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
                dbResult.setSelectData((DataSet)dataSet);
            }
            catch (Exception ex) {
                this.LogErrorInfo(ex.toString());
                dbResult.setErrorInfo(ex.toString());
                ex.printStackTrace(System.out);
                if (cstmt != null) {
                    cstmt.close();
                }
                this.ReleaseConnection(MySql);
            }
        }
        finally {
            if (cstmt != null) {
                cstmt.close();
            }
            this.ReleaseConnection(MySql);
        }
        return dbResult;
    }

    public SelectResult Invoke(String strProcName, Vector<CallParam> list) throws SQLException {
        return this.Invoke(strProcName, list, -1);
    }

    protected String FormatProcCall2(String strProcName, int nParamCount) {
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
        strCall = String.valueOf(strCall) + " }";
        return strCall;
    }
}
