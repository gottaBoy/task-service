/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBCallerParam
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.Oracle.OracleDataSet
 *  SA.SRFramework.Data.SearchResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.DataEx.DB2;

import SA.SRFramework.Data.DBCallerParam;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.Oracle.OracleDataSet;
import SA.SRFramework.Data.SearchResult;
import SA.SRFramework.DataEx.DB2.DB2DBProcCallerEx;
import SA.SRFramework.DataEx.IDBSearchCmdCaller;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class DB2SearchCmdCaller
extends DB2DBProcCallerEx
implements IDBSearchCmdCaller {
    @Override
    public SearchResult Invoke(int nCountPerPage, int nPageNO, String strSortParam, int nSortDirect, Hashtable paramList, String strOpPersonId) throws SQLException {
        SearchResult searchResult = null;
        Connection SqlConn = this.CreateConnection();
        if (SqlConn == null) {
            searchResult = new SearchResult();
            this.SetErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            searchResult.setErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            return searchResult;
        }
        try {
            try {
                searchResult = this.Invoke(SqlConn, nCountPerPage, nPageNO, strSortParam, nSortDirect, paramList, strOpPersonId);
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                this.ReleaseConnection(SqlConn);
            }
        }
        finally {
            this.ReleaseConnection(SqlConn);
        }
        return searchResult;
    }

    @Override
    public SearchResult Invoke(Connection connection, int nCountPerPage, int nPageNO, String strSortParam, int nSortDirect, Hashtable paramList, String strOpPersonId) throws SQLException {
        SearchResult searchResult = new SearchResult();
        searchResult.setRetCode(1);
        searchResult.setDatabase(1);
        if (this.dbCallerConfig.getAutoGenProc() && !this.dbCallerConfig.getGenProcFinish()) {
            DBResult dbResult = this.GenSearchProc(connection);
            if (dbResult == null) {
                return searchResult;
            }
            if (dbResult.getRetCode() != 0) {
                searchResult.setRetCode(dbResult.getRetCode());
                searchResult.setErrorInfo(dbResult.getErrorInfo());
                return searchResult;
            }
        }
        Hashtable<Integer, String> outputParamList = new Hashtable<Integer, String>();
        CallableStatement cstmt = null;
        try {
            try {
                int nParamCount;
                ArrayList procParams = this.GetProcParams();
                int nCallParamCount = nParamCount = procParams.size();
                if (this.dbCallerConfig.getLogDBOperator()) {
                    ++nCallParamCount;
                }
                String strProc = this.FormatProcCall(this.dbCallerConfig.getGenProcName(), nCallParamCount += 6);
                cstmt = connection.prepareCall(strProc);
                int nParamIndex = 1;
                int nParamReturnRS = nParamIndex++;
                cstmt.registerOutParameter(nParamReturnRS, -10);
                int nParamReturnTotalRow = nParamIndex++;
                cstmt.registerOutParameter(nParamReturnTotalRow, -10);
                int nParamCountPerPageIndex = nParamIndex++;
                cstmt.setObject(nParamCountPerPageIndex, nCountPerPage, 2);
                int nParamPageNOIndex = nParamIndex++;
                cstmt.setObject(nParamPageNOIndex, nPageNO, 2);
                int i = 0;
                while (i < nParamCount) {
                    DBCallerParam param = (DBCallerParam)procParams.get(i);
                    if (param.getDeclareParam() && !param.getRawValue() && (StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)"DB2", (boolean)true) == 0)) {
                        String strParamValue = param.getParamValue().toUpperCase();
                        if (param.getEndOfDay()) {
                            this.SetParamEndOfDay(paramList, strParamValue);
                        }
                        if (param.getDirection() == 1) {
                            cstmt.setObject(nParamIndex, paramList.get(strParamValue), this.GetJDBCType(param.getDBType()));
                        } else if (param.getDirection() == 2) {
                            cstmt.registerOutParameter(nParamIndex, this.GetJDBCType(param.getDBType()));
                            outputParamList.put(nParamIndex, strParamValue);
                        } else if (param.getDirection() == 3) {
                            cstmt.setObject(nParamIndex, paramList.get(strParamValue), this.GetJDBCType(param.getDBType()));
                            cstmt.registerOutParameter(nParamIndex, this.GetJDBCType(param.getDBType()));
                            outputParamList.put(nParamIndex, strParamValue);
                        }
                        ++nParamIndex;
                    }
                    ++i;
                }
                int nParamSortParamIndex = nParamIndex++;
                cstmt.setObject(nParamSortParamIndex, strSortParam, 12);
                String strDefaultSort = this.dbCallerConfig.getDefaultSort();
                if (StringHelper.IsNullOrEmpty((String)strDefaultSort) && this.dbCallerConfig.isAutoDefaultSort()) {
                    strDefaultSort = ",rowid asc";
                }
                int nParamSortDirectIndex = nParamIndex++;
                cstmt.setObject(nParamSortDirectIndex, nSortDirect == 0 ? "ASC" + strDefaultSort : "DESC" + strDefaultSort, 12);
                if (this.dbCallerConfig.getLogDBOperator()) {
                    int nParamOPPersonIndex = nParamIndex++;
                    cstmt.setObject(nParamOPPersonIndex, strOpPersonId, 12);
                }
                cstmt.execute();
                OracleDataSet dataSet = new OracleDataSet();
                ResultSet rs = (ResultSet)cstmt.getObject(nParamReturnRS);
                dataSet.AddResultSet(rs);
                rs.close();
                ResultSet rsTotal = (ResultSet)cstmt.getObject(nParamReturnTotalRow);
                dataSet.AddResultSet(rsTotal);
                rsTotal.close();
                searchResult.setRetCode(0);
                searchResult.setSearchData((DataSet)dataSet);
                searchResult.setDataTableIndex(0);
                searchResult.setTotalRow(Integer.parseInt(dataSet.getTable(1).GetRow(0).Get("TOTALROW").toString()));
                searchResult.setItemPerPage(nCountPerPage);
                searchResult.setPageNo(nPageNO);
                Enumeration enumeration = outputParamList.keys();
                while (enumeration.hasMoreElements()) {
                    int nIndex = (Integer)enumeration.nextElement();
                    String strParamValue = (String)outputParamList.get(nIndex);
                    if (cstmt.getObject(nIndex) == null) continue;
                    paramList.put(strParamValue, cstmt.getObject(nIndex));
                }
            }
            catch (Exception ex) {
                this.LogErrorInfo(ex.toString());
                searchResult.setErrorInfo(ex.toString());
                ex.printStackTrace(System.out);
                if (cstmt != null) {
                    cstmt.close();
                }
            }
        }
        finally {
            if (cstmt != null) {
                cstmt.close();
            }
        }
        return searchResult;
    }

    protected DBResult GenSearchProc(Connection connection) {
        String strGroupBy;
        DBCallerParam param;
        DBResult dbResult = new DBResult();
        dbResult.setRetCode(1);
        dbResult.setDatabase(1);
        String strGenProcName = this.dbCallerConfig.getGenProcName();
        if (StringHelper.Length((String)strGenProcName) == 0) {
            dbResult.setErrorInfo("\u6ca1\u6709\u5b9a\u4e49\u4ea7\u751f\u7684\u8fc7\u7a0b\u540d\u79f0");
            return dbResult;
        }
        StringBuilderEx stringBuilder = new StringBuilderEx();
        this.AppendCreateProc(stringBuilder, strGenProcName);
        stringBuilder.Append("\n(\n");
        stringBuilder.Append("varRd out PKG_SRF2.recordset,\n");
        stringBuilder.Append("varRdTotal out PKG_SRF2.recordset, --\u603b\u8bb0\u5f55\u6570\n");
        stringBuilder.Append("varCountPerPage NUMBER default 10, --\u6bcf\u9875\u8bb0\u5f55\u6570\n");
        stringBuilder.Append("varPageNO NUMBER default 1, --\u5f53\u524d\u9875\u6570\n");
        if (this.AppendProcParam(stringBuilder, true, false)) {
            stringBuilder.Append(",\n");
        }
        stringBuilder.Append("varSortParam VARCHAR2 default null, --\u7f3a\u7701\u6392\u5e8f\u53c2\u6570\n");
        stringBuilder.Append("varSortDirect VARCHAR2 default null, --\u7f3a\u7701\u6392\u5e8f\u65b9\u5411\n");
        stringBuilder.Append("varOPPersonId VARCHAR2");
        stringBuilder.Append("\n)\n");
        stringBuilder.Append("IS\n");
        stringBuilder.Append("strSql VARCHAR2(4000):='';\n");
        stringBuilder.Append("strConSql VARCHAR2(4000):='';\n");
        stringBuilder.Append("strCountSql VARCHAR2(4000):='';\n");
        stringBuilder.Append("strPageSql VARCHAR2(4000):='';\n");
        stringBuilder.Append("nStartRow NUMBER:= (varPageNO - 1)* varCountPerPage + 1;\n");
        stringBuilder.Append("nEndRow NUMBER:= (varPageNO )* varCountPerPage ;\n");
        stringBuilder.Append("strSortParam VARCHAR2(200) :='';\n");
        stringBuilder.Append("strSortDirect VARCHAR2(20):='';\n");
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if (param.getDeclareParam() && (StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)"DB2", (boolean)true) == 0) && DataTypeHelper.IsStringType((int)param.getDBType()) && StringHelper.Compare((String)param.getMatchAction(), (String)"LIKE", (boolean)true) == 0 && !param.getRawValue()) {
                stringBuilder.Append("str%1$s VARCHAR2(500) := ''; \n", param.getID());
            }
            ++i;
        }
        stringBuilder.Append("BEGIN\n");
        stringBuilder.Append("--\u6392\u5e8f\u53d8\u91cf\u5904\u7406\n");
        stringBuilder.Append("if varSortParam IS NULL OR varSortParam = '' THEN\n");
        stringBuilder.Append("\tstrSortParam := '%1$s';  --\u8bbe\u7f6e\u7f3a\u7701\u6392\u5e8f\u5b57\u6bb5\n", this.dbCallerConfig.getSortParam());
        stringBuilder.Append("else\n");
        stringBuilder.Append("\tstrSortParam := varSortParam;  \n");
        stringBuilder.Append("END if;\n");
        stringBuilder.Append("if varSortDirect IS NULL OR varSortDirect = '' THEN\n");
        stringBuilder.Append("\tstrSortDirect := '%1$s'; --\u8bbe\u7f6e\u7f3a\u7701\u6392\u5e8f\u65b9\u5411\n", this.dbCallerConfig.getSortDirect());
        stringBuilder.Append("else\n");
        stringBuilder.Append("\tstrSortDirect := varSortDirect; \n");
        stringBuilder.Append("END if;\n");
        i = 0;
        while (i < nCount) {
            param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if (param.getDeclareParam() && (StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)"DB2", (boolean)true) == 0) && DataTypeHelper.IsStringType((int)param.getDBType()) && StringHelper.Compare((String)param.getMatchAction(), (String)"LIKE", (boolean)true) == 0) {
                stringBuilder.Append("if var%1$s IS NOT NULL then\n", param.getID());
                stringBuilder.Append("\tif var%1$s = '' then\n", param.getID());
                stringBuilder.Append("\t\tstr%1$s := '%%';\n", param.getID());
                stringBuilder.Append("\telse\n", param.getID());
                stringBuilder.Append("\t\tstr%1$s := '%%' || upper(var%1$s) || '%%';\n", param.getID());
                stringBuilder.Append("\tEND IF;\n", param.getID());
                stringBuilder.Append("END IF;\n", param.getID());
            }
            ++i;
        }
        if (StringHelper.Length((String)this.dbCallerConfig.getUserReturn()) > 0) {
            stringBuilder.Append("strSql:= 'select %2$s,* from %1$s' ;\n", this.dbCallerConfig.getViewName(), this.dbCallerConfig.getUserReturn());
        } else {
            stringBuilder.Append("strSql:= 'select * from %1$s';\n", this.dbCallerConfig.getViewName());
        }
        stringBuilder.Append("strCountSql:= 'select count(*) as TOTALROW from %1$s';\n", this.dbCallerConfig.getViewName());
        if (this.dbCallerConfig.getLogicEnable()) {
            stringBuilder.Append("strConSql := ' where enable = 1 ';\n");
        } else {
            stringBuilder.Append("strConSql := '';\n");
        }
        nCount = this.dbCallerConfig.getParams().size();
        i = 0;
        while (i < nCount) {
            param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if ((StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)"DB2", (boolean)true) == 0) && param.getSearch() && StringHelper.Length((String)param.getMatchAction()) != 0) {
                if (!param.getRawValue()) {
                    if (DataTypeHelper.IsStringType((int)param.getDBType())) {
                        if (StringHelper.Compare((String)param.getMatchAction(), (String)"LIKE", (boolean)true) == 0) {
                            stringBuilder.Append("if var%1$s  IS NOT NULL THEN\n", param.getID());
                            stringBuilder.Append("\tif strConSql = '' OR strConSql IS NULL THEN\n");
                            stringBuilder.Append("\t\tstrConSql := strConSql || ' WHERE ';\n");
                            stringBuilder.Append("\tELSE\n", param.getID());
                            stringBuilder.Append("\t\tstrConSql := strConSql || ' AND ';\n");
                            stringBuilder.Append("\tEND IF;\n");
                            stringBuilder.Append("\tIF fu_pfspellJudge(var%1$s) then  \n", param.getID());
                            stringBuilder.Append("\t\tstrConSql := strConSql || ' (fu_pfspellcn(%1$s,1) = upper('''|| var%2$s ||'''))';\n", param.getParamName(), param.getID());
                            stringBuilder.Append("\tELSE \n");
                            stringBuilder.Append("\t\tstrConSql := strConSql || ' (upper(%1$s) LIKE '''|| str%2$s ||''')';\n", param.getParamName(), param.getID());
                            stringBuilder.Append("\tEND IF; \n");
                            stringBuilder.Append("END IF;\n");
                        } else {
                            stringBuilder.Append("if var%1$s  IS NOT NULL THEN\n", param.getID());
                            stringBuilder.Append("\tif strConSql = '' OR strConSql IS NULL THEN\n");
                            stringBuilder.Append("\t\tstrConSql := strConSql || ' WHERE ';\n");
                            stringBuilder.Append("\tELSE\n");
                            stringBuilder.Append("\t\tstrConSql := strConSql || ' AND ';\n");
                            stringBuilder.Append("\tEND IF;\n");
                            stringBuilder.Append("\t\tstrConSql := strConSql || ' (%1$s %2$s '''|| var%3$s ||''')';\n", param.getParamName(), param.getMatchAction(), param.getID());
                            stringBuilder.Append("END IF;\n");
                        }
                    } else {
                        String strCastFunc = param.getCastFunc();
                        if (StringHelper.Length((String)strCastFunc) == 0) {
                            strCastFunc = DataTypeHelper.IsDateTimeType((int)param.getDBType()) ? "fn_FormatDate(var%1$s)" : "to_char(var%1$s)";
                        }
                        String strCastParam = StringHelper.Format((String)strCastFunc, (Object)param.getID());
                        stringBuilder.Append("if var%1$s  IS NOT NULL THEN\n", param.getID());
                        stringBuilder.Append("\tif strConSql = '' OR strConSql IS NULL THEN\n");
                        stringBuilder.Append("\t\tstrConSql := strConSql || ' WHERE ';\n");
                        stringBuilder.Append("\tELSE\n");
                        stringBuilder.Append("\t\tstrConSql := strConSql || ' AND ';\n");
                        stringBuilder.Append("\tEND IF;\n");
                        if (DataTypeHelper.IsDateTimeType((int)param.getDBType())) {
                            stringBuilder.Append("\t\tstrConSql := strConSql || ' (%1$s %2$s '|| %3$s ||')';\n", param.getParamName(), param.getMatchAction(), strCastParam);
                        } else {
                            stringBuilder.Append("\t\tstrConSql := strConSql || ' (%1$s %2$s '|| %3$s ||')';\n", param.getParamName(), param.getMatchAction(), strCastParam);
                        }
                        stringBuilder.Append("END IF;\n");
                    }
                } else {
                    stringBuilder.Append("if strConSql = '' OR strConSql IS NULL THEN\n");
                    stringBuilder.Append("\tstrConSql := strConSql || ' WHERE ';\n");
                    stringBuilder.Append("ELSE\n");
                    stringBuilder.Append("\tstrConSql := strConSql || ' AND ';\n");
                    stringBuilder.Append("END IF;\n");
                    stringBuilder.Append("\tstrConSql := strConSql || ' (%1$s %2$s %3$s)';\n", param.getParamName(), param.getMatchAction(), param.getParamValue());
                }
            }
            ++i;
        }
        String strExtCondition = this.dbCallerConfig.FindCustomAction("DB2", "CONDITION");
        if (StringHelper.Length((String)strExtCondition) > 0) {
            stringBuilder.Append("if strConSql = '' OR strConSql IS NULL THEN\n");
            stringBuilder.Append("\tstrConSql := strConSql || ' WHERE ';\n");
            stringBuilder.Append("ELSE\n");
            stringBuilder.Append("\tstrConSql := strConSql || ' AND ';\n");
            stringBuilder.Append("END IF;\n");
            stringBuilder.Append("strConSql := strConSql || ' %1$s ';\n", strExtCondition);
        }
        if (StringHelper.Length((String)(strGroupBy = this.dbCallerConfig.FindCustomAction("DB2", "GROUPBY"))) > 0) {
            stringBuilder.Append("strConSql := strConSql ||  ' %1$s ';\n", strGroupBy);
        }
        stringBuilder.Append(" --\u6392\u5e8f\u5904\u7406\n");
        stringBuilder.Append("strConSql := strConSql|| ' Order By ' || strSortParam || ' ' || strSortDirect ;\n");
        String strExtSort = this.dbCallerConfig.FindCustomAction("DB2", "DEFAULTORDER");
        if (StringHelper.Length((String)strExtSort) > 0) {
            stringBuilder.Append("strConSql := strConSql|| ' %1$s ';\n", strExtSort);
        }
        stringBuilder.Append(" strSql := strSql || strConSql ;\n");
        this.AppendPagingCode(stringBuilder);
        this.AppendProcEnd(stringBuilder, strGenProcName);
        try {
            DBResult dbResult2 = this.ExecCreateProcSQL(connection, stringBuilder.toString());
            if (dbResult2 != null && dbResult2.getRetCode() == 0) {
                this.dbCallerConfig.setGenProcFinish(true);
            }
            return dbResult2;
        }
        catch (Exception ex) {
            this.LogErrorInfo(ex.toString());
            dbResult.setErrorInfo(ex.toString());
            ex.printStackTrace(System.out);
            return dbResult;
        }
    }

    @Override
    public DBResult CreateProc() throws SQLException {
        DBResult dbResult = null;
        Connection SqlConn = this.CreateConnection();
        if (SqlConn == null) {
            dbResult = new DBResult();
            this.SetErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            dbResult.setErrorInfo("\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            return dbResult;
        }
        try {
            dbResult = this.GenSearchProc(SqlConn);
            if (dbResult == null) {
                DBResult dBResult = dbResult;
                return dBResult;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            this.ReleaseConnection(SqlConn);
        }
        return dbResult;
    }

    protected void AppendPagingCode(StringBuilderEx stringBuilder) {
        stringBuilder.Append("--\u5206\u9875\u5904\u7406\n");
        stringBuilder.Append("strPageSql := 'SELECT * FROM ';\n");
        stringBuilder.Append("strPageSql := strPageSql || '( ';\n");
        stringBuilder.Append("strPageSql := strPageSql || 'SELECT A.*, rownum r ';\n");
        stringBuilder.Append("strPageSql := strPageSql || 'FROM  ';\n");
        stringBuilder.Append("strPageSql := strPageSql || '( ';\n");
        stringBuilder.Append("strPageSql := strPageSql || strSql ;\n");
        stringBuilder.Append("strPageSql := strPageSql || ') A ';\n");
        stringBuilder.Append("strPageSql := strPageSql || 'WHERE rownum <= '|| to_char(nEndRow) ;\n");
        stringBuilder.Append("strPageSql := strPageSql || ') B ';\n");
        stringBuilder.Append("strPageSql := strPageSql || 'WHERE r >= '|| to_char(nStartRow);\n");
        stringBuilder.Append("strCountSql := strCountSql || strConSql;\n");
        stringBuilder.Append("--\u6267\u884c\u83b7\u53d6\u884c\u6570\u7684\u8fc7\u7a0b\n");
        stringBuilder.Append("PKG_SRF2.sp_execute(strCountSql,varRdTotal);\n");
        stringBuilder.Append("--\u6267\u884c\u83b7\u53d6\u5206\u9875\u7ed3\u679c\u96c6\u5408\u7684\u8fc7\u7a0b\n");
        stringBuilder.Append("PKG_SRF2.sp_execute(strPageSql,varRd);\n");
    }

    protected void AppendConSqlCode(StringBuilderEx stringBuilder, String strConSql, String strPreFix) {
        stringBuilder.Append("%1$sIf %2$s = '' OR %2$s IS NULL THEN\n", strPreFix, strConSql);
        stringBuilder.Append("%1$s\t%2$s := %2$s || ' WHERE ';\n", strPreFix, strConSql);
        stringBuilder.Append("%1$sELSE\n", strPreFix);
        stringBuilder.Append("%1$s\t%2$s := %2$s || ' AND ';\n", strPreFix, strConSql);
        stringBuilder.Append("%1$sEND IF;\n", strPreFix);
    }
}

