/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBCallerParam
 *  SA.SRFramework.Data.SqlServer.SqlDBProcCaller
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.DataEx.SqlServer;

import SA.SRFramework.Data.DBCallerParam;
import SA.SRFramework.Data.SqlServer.SqlDBProcCaller;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public class SqlDBProcCallerEx
extends SqlDBProcCaller {
    public static final String DATABASE = "MSSQL";
    public static final String GOTOTARGET = "SRF_RT";

    protected void AppendSystemParam(StringBuilderEx stringBuilder) {
        stringBuilder.Append("declare @srf_retcode int\r\n");
        stringBuilder.Append("declare @srf_message varchar(1000)\r\n");
        stringBuilder.Append("declare @srf_tag varchar(1000)\r\n");
        stringBuilder.Append("declare @srf_tag2 varchar(1000)\r\n");
        stringBuilder.Append("declare @srf_opman varchar(60)\r\n");
    }

    protected void AppendSearchSystemParam(StringBuilderEx stringBuilder, boolean bPaging) {
        stringBuilder.Append("declare @srf_sortparam varchar(60)\r\n");
        stringBuilder.Append("declare @srf_sortdirect varchar(60)\r\n");
        stringBuilder.Append("declare @srf_sql nvarchar(4000)\r\n");
        stringBuilder.Append("declare @srf_condsql nvarchar(4000)\r\n");
        stringBuilder.Append("declare @srf_countsql nvarchar(4000)\r\n");
        if (bPaging) {
            stringBuilder.Append("declare @srf_pageno int\r\n");
            stringBuilder.Append("declare @srf_pagesize int\r\n");
        }
    }

    protected void AppendCommonParam(StringBuilderEx stringBuilder) {
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if (param.getDeclareParam() && (StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)DATABASE, (boolean)true) == 0)) {
                String strExt = param.getDataTypeExt();
                if (StringHelper.Length((String)strExt) == 0) {
                    stringBuilder.Append("declare @%1$s %2$s\r\n", param.getID(), param.getDataType());
                } else {
                    stringBuilder.Append("declare @%1$s %2$s", param.getID(), param.getDataType());
                    stringBuilder.Append("(");
                    stringBuilder.Append(strExt);
                    stringBuilder.Append(")\r\n");
                }
            }
            ++i;
        }
    }

    protected void AppendInsertParamValue(StringBuilderEx stringBuilder) {
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if (param.getDeclareParam() && (StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)DATABASE, (boolean)true) == 0)) {
                if (param.getRawValue()) {
                    stringBuilder.Append("set @%1$s = %2$s\r\n", param.getID(), param.getParamValue());
                } else if (StringHelper.Compare((String)param.getValueMode(), (String)"IDENTITY", (boolean)true) != 0) {
                    stringBuilder.Append("set @%1$s = ?\r\n", param.getID());
                }
            }
            ++i;
        }
    }

    protected void AppendUpdateParamValue(StringBuilderEx stringBuilder) {
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if (param.getDeclareParam() && (StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)DATABASE, (boolean)true) == 0)) {
                if (param.getRawValue()) {
                    stringBuilder.Append("set @%1$s = %2$s\r\n", param.getID(), param.getParamValue());
                } else {
                    stringBuilder.Append("set @%1$s = ?\r\n", param.getID());
                }
            }
            ++i;
        }
    }

    protected String GetInsertKeyCondition() {
        String strKeyCondition = "";
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if (StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)DATABASE, (boolean)true) == 0) {
                if (!param.getKey()) break;
                if (StringHelper.Compare((String)param.getValueMode(), (String)"IDENTITY", (boolean)true) != 0) {
                    if (StringHelper.Length((String)strKeyCondition) != 0) {
                        strKeyCondition = String.valueOf(strKeyCondition) + " AND ";
                    }
                    strKeyCondition = String.valueOf(strKeyCondition) + StringHelper.Format((String)"([%1$s] = @%1$s)", (Object)param.getID());
                }
            }
            ++i;
        }
        return strKeyCondition;
    }

    protected void AppendGetKeyCode(StringBuilderEx stringBuilder) {
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if (StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)DATABASE, (boolean)true) == 0) {
                if (!param.getKey()) break;
                if (StringHelper.Compare((String)param.getValueMode(), (String)"IDENTITY", (boolean)true) == 0) {
                    stringBuilder.Append("select @%1$s=@@identity from %2$s\r\n", param.getID(), this.dbCallerConfig.getProcName());
                }
            }
            ++i;
        }
    }

    protected String GetUpdateKeyCondition() {
        String strKeyCondition = "";
        int nCount = this.dbCallerConfig.getParams().size();
        int i = 0;
        while (i < nCount) {
            DBCallerParam param = (DBCallerParam)this.dbCallerConfig.getParams().get(i);
            if (StringHelper.Length((String)param.getDatabase()) == 0 || StringHelper.Compare((String)param.getDatabase(), (String)DATABASE, (boolean)true) == 0) {
                if (!param.getKey()) break;
                if (StringHelper.Length((String)strKeyCondition) != 0) {
                    strKeyCondition = String.valueOf(strKeyCondition) + " AND ";
                }
                strKeyCondition = String.valueOf(strKeyCondition) + StringHelper.Format((String)"([%1$s] = @%1$s)", (Object)param.getID());
            }
            ++i;
        }
        return strKeyCondition;
    }
}

