/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDEAnalysisHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DB2DEAnalysisHelper
extends BaseDEAnalysisHelper {
    protected String strDBSCHEMA = "DB2ADMIN";
    private static final Log log = LogFactory.getLog(DB2DEAnalysisHelper.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected void APPEND_PROC_HEADER(StringBuilderEx stringBuilder) {
        stringBuilder.Append("CREATE PROCEDURE %1$s.%2$s (\n", (Object)this.strDBSCHEMA, (Object)this.strProcName);
        String strSystemParam = this.GETSQL_PROC_HEADER_PARAM();
        if (!StringHelper.IsNullOrEmpty((String)strSystemParam)) {
            stringBuilder.Append(strSystemParam);
        }
        stringBuilder.Append("\n)\n");
        stringBuilder.Append("DYNAMIC RESULT SETS 0\n");
        stringBuilder.Append("LANGUAGE SQL\n");
        stringBuilder.Append("NOT DETERMINISTIC\n");
        stringBuilder.Append("NO EXTERNAL ACTION\n");
        stringBuilder.Append("MODIFIES SQL DATA\n");
        stringBuilder.Append("CALLED ON NULL INPUT\n");
        stringBuilder.Append("INHERIT SPECIAL REGISTERS\n");
    }

    protected String GETSQL_PROC_HEADER_PARAM() {
        String strSystemParams = "";
        strSystemParams = String.valueOf(strSystemParams) + "IN SRF_PERSONID VARCHAR(60),\n";
        strSystemParams = String.valueOf(strSystemParams) + "OUT SRF_RETCODE INT,\n";
        strSystemParams = String.valueOf(strSystemParams) + "OUT SRF_RETINFO VARCHAR(1000),\n";
        strSystemParams = String.valueOf(strSystemParams) + "OUT SRF_TAG VARCHAR(1000),";
        strSystemParams = String.valueOf(strSystemParams) + "IN VAR_DEANALYSISID VARCHAR(100)\n";
        return strSystemParams;
    }

    @Override
    protected void APPEND_PROC_BODY(StringBuilderEx stringBuilder) {
        stringBuilder.Append("BEGIN\n", (Object)stringBuilder);
        stringBuilder.Append(this.GETSQL_PROC_BODY_SYSTEMDECLARE());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_PROC_BODY_USERDECLARE());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_PROC_BODY_SYSTEMINIT());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_PROC_BODY_USERINIT());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_PROC_BODY_CHECKRUNTIME());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_PROC_BODY_BEFORECODE());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_PROC_BODY_PREVLOOP());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_PROC_BODY_CURRUN());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_PROC_BODY_NEXTLOOP());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_PROC_BODY_AFTERCODE());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_PROC_BODY_UPDATERUNTIME());
        stringBuilder.Append("SET SRF_RETCODE= 0;\n");
        stringBuilder.Append("SET SRF_RETINFO='';\n");
        stringBuilder.Append("EXIT:RETURN;\n");
        stringBuilder.Append("END\n");
    }

    protected String GETSQL_PROC_BODY_SYSTEMDECLARE() {
        String strSystemDeclare = "declare nTemp INTEGER;\n";
        strSystemDeclare = String.valueOf(strSystemDeclare) + "declare SRF_CURTIME timestamp;\n";
        strSystemDeclare = String.valueOf(strSystemDeclare) + "declare dtBeginTime timestamp;\n";
        strSystemDeclare = String.valueOf(strSystemDeclare) + "declare dtEndTime timestamp;\n";
        strSystemDeclare = String.valueOf(strSystemDeclare) + "declare strCycleTimeType VARCHAR(100);\n";
        strSystemDeclare = String.valueOf(strSystemDeclare) + "declare strCycleTimeId VARCHAR(100);\n";
        strSystemDeclare = String.valueOf(strSystemDeclare) + "declare strPCycleTimeId VARCHAR(100);\n";
        strSystemDeclare = String.valueOf(strSystemDeclare) + "declare strCurCycleTimeId VARCHAR(100);\n";
        strSystemDeclare = String.valueOf(strSystemDeclare) + "declare nPrevCycleCount INTEGER;\n";
        strSystemDeclare = String.valueOf(strSystemDeclare) + "declare nNextCycleCount INTEGER;";
        return strSystemDeclare;
    }

    protected String GETSQL_PROC_BODY_SYSTEMINIT() {
        String strSQL = "";
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"SELECT CURRENT timestamp INTO SRF_CURTIME FROM SYSIBM.SYSDUMMY1;\n");
        return strSQL;
    }

    protected String GETSQL_PROC_BODY_CHECKRUNTIME() {
        String strSQL = "";
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"IF NOT EXISTS(select * from t_SRFDEANALYSIS t1 where t1.DEANALYSIS=VAR_DEANALYSIS AND (t1.ISRUN IS NULL OR t1.ISRUN = 0) AND ( t1.LASTRUNTIME IS NULL OR FU_SRFSECONDSDIFF(SRF_CURTIME,t1.LASTRUNTIME)>t1.RUNINTERVAL)) THEN\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"SET SRF_RETCODE = 0;\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"GOTO EXIT;\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"END IF;\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"UPDATE t_SRFDEANALYSIS SET LASTRUNTIME=SRF_CURTIME,ISRUN=1 where t1.DEANALYSIS=VAR_DEANALYSIS;\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"COMMIT;\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"select CycleTimeType,PrevCycleCount,NextCycleCount into strCycleTimeType,nPrevCycleCount,nNextCycleCount  from t_SRFDEANALYSIS t1 where t1.DEANALYSIS=VAR_DEANALYSIS ;\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"IF NOT EXISTS(select * from T_SRFCYCLETIME t1 where t1.CYCLETIMETYPE=strCycleTimeType AND ( SRF_CURTIME >=t1.BEGINTIME AND SRF_CURTIME <=t1.ENDTIME )) THEN\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"SET SRF_RETCODE = %1$s;\n", (Object)1003);
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"SET SRF_RETINFO= '%1$s';\n", (Object)StringHelper.Format((String)"\u6ca1\u6709\u5f53\u524d\u65f6\u95f4\u6240\u5bf9\u5e94\u7684\u65f6\u95f4\u5468\u671f"));
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"GOTO EXIT;\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"END IF;\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"select CYCLETIMEID,PCYCLETIMEID INTO strCycleTimeId,strPCycleTimeId from T_SRFCYCLETIME t1 where t1.CYCLETIMETYPE=strCycleTimeType AND ( SRF_CURTIME >=t1.BEGINTIME AND SRF_CURTIME <=t1.ENDTIME );\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"SET strCurCycleTimeId=strCycleTimeId;\n");
        return strSQL;
    }

    protected String GETSQL_PROC_BODY_UPDATERUNTIME() {
        String strSQL = "";
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"SELECT CURRENT timestamp INTO SRF_CURTIME FROM SYSIBM.SYSDUMMY1;\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"UPDATE t_SRFDEANALYSIS SET LASTRUNFINISHTIME=SRF_CURTIME,ISRUN=0 where t1.DEANALYSIS=VAR_DEANALYSIS;\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"COMMIT;\n");
        return strSQL;
    }

    protected String GETSQL_PROC_BODY_PREVLOOP() {
        if (this.deAnalysis.getPREVCYCLECOUNT() <= 0) {
            return "";
        }
        String strSQL = "";
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"-- \u5468\u671f\u4e4b\u524d\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"SET nPrevCycleCount=%1$s;\n", (Object)this.deAnalysis.getPREVCYCLECOUNT());
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"WHILE nPrevCycleCount> 0 AND strPCycleTimeId IS NOT NULL DO\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"IF NOT EXISTS(select * from T_SRFCYCLETIME t1 where t1.CYCLETIMEID=strPCycleTimeId)) THEN\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"SET nPrevCycleCount = 0;\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"ELSE\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"SET nPrevCycleCount = nPrevCycleCount-1;\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"select BEGINTIME,ENDTIME,CYCLETIMEID,PCYCLETIMEID into dtBeginTime,dtEndTime,strCurCycleTimeId,strPCycleTimeId from T_SRFCYCLETIME t1 where t1.CYCLETIMEID=strPCycleTimeId;\n");
        strSQL = String.valueOf(strSQL) + this.GETSQL_PROC_BODY_LOOPBEFORECODE();
        strSQL = String.valueOf(strSQL) + this.GETSQL_PROC_BODY_RUNCODE();
        strSQL = String.valueOf(strSQL) + this.GETSQL_PROC_BODY_LOOPAFTERCODE();
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"END IF;\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"END WHILE;\n");
        return strSQL;
    }

    protected String GETSQL_PROC_BODY_CURRUN() {
        String strSQL = "";
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"-- \u5f53\u524d\u5468\u671f\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"SET strCurCycleTimeId=strCycleTimeId;\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"select BEGINTIME,ENDTIME into dtBeginTime,dtEndTime from T_SRFCYCLETIME t1 where t1.CYCLETIMEID=strCurCycleTimeId;\n");
        strSQL = String.valueOf(strSQL) + this.GETSQL_PROC_BODY_LOOPBEFORECODE();
        strSQL = String.valueOf(strSQL) + this.GETSQL_PROC_BODY_RUNCODE();
        strSQL = String.valueOf(strSQL) + this.GETSQL_PROC_BODY_LOOPAFTERCODE();
        return strSQL;
    }

    protected String GETSQL_PROC_BODY_NEXTLOOP() {
        if (this.deAnalysis.getNEXTCYCLECOUNT() <= 0) {
            return "";
        }
        String strSQL = "";
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"-- \u5468\u671f\u4e4b\u540e\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"SET nNextCycleCount=%1$s;\n", (Object)this.deAnalysis.getNEXTCYCLECOUNT());
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"SET strCurCycleTimeId=strCycleTimeId;\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"WHILE nNextCycleCount> 0 AND strCurCycleTimeId IS NOT NULL DO\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"IF NOT EXISTS(select * from T_SRFCYCLETIME t1 where t1.PCYCLETIMEID=strCurCycleTimeId)) THEN\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"SET nNextCycleCount = 0;\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"ELSE\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"SET nNextCycleCount = nNextCycleCount-1;\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"select BEGINTIME,ENDTIME,CYCLETIMEID into dtBeginTime,dtEndTime,strCurCycleTimeId from T_SRFCYCLETIME t1 where t1.PCYCLETIMEID=strCurCycleTimeId;\n");
        strSQL = String.valueOf(strSQL) + this.GETSQL_PROC_BODY_LOOPBEFORECODE();
        strSQL = String.valueOf(strSQL) + this.GETSQL_PROC_BODY_RUNCODE();
        strSQL = String.valueOf(strSQL) + this.GETSQL_PROC_BODY_LOOPAFTERCODE();
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"END IF;\n");
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"END WHILE;\n");
        return strSQL;
    }
}

