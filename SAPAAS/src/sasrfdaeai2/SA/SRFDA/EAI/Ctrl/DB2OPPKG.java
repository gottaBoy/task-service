/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Ctrl.BaseDBOPCustomProcess;
import SA.SRFDA.EAI.Ctrl.BaseDBOPPKG;
import SA.SRFDA.EAI.Ctrl.DB2OPProcPkgProcess;
import SA.SRFDA.EAI.Ctrl.DB2OPRecordSet;
import SA.SRFDA.EAI.Ctrl.DB2OPSelInsProcess;
import SA.SRFDA.EAI.Ctrl.DB2OPSelLoopProcess;
import SA.SRFDA.EAI.Ctrl.DB2OPTmpTable;
import SA.SRFDA.EAI.Ctrl.IDBOPProcess;
import SA.SRFDA.EAI.Ctrl.IDBOPRecordSet;
import SA.SRFDA.EAI.Ctrl.IDBOPTmpTable;
import SA.SRFDA.EAI.Data.DBOPDTMap;
import SA.SRFDA.EAI.Data.DBOPPKGParam;
import SA.SRFDA.EAI.Data.DBOPProc;
import SA.SRFDA.EAI.Data.DBProcPkg;
import SA.SRFDA.EAI.Data.DBRS;
import SA.SRFDA.EAI.Data.DBTmpTable;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public class DB2OPPKG
extends BaseDBOPPKG {
    @Override
    protected IDBOPProcess OnCreatePkgBodyProcess() throws Exception {
        DBProcPkg dbProcPkg = new DBProcPkg();
        dbProcPkg.setPROCMODEL(this.dbOPPkg.getPROCMODEL());
        DB2OPProcPkgProcess db2ProcPkg = new DB2OPProcPkgProcess();
        db2ProcPkg.Init(this, dbProcPkg);
        return db2ProcPkg;
    }

    @Override
    protected IDBOPTmpTable OnCreateDBOPTmpTable(DBTmpTable tmpTable) throws Exception {
        return new DB2OPTmpTable();
    }

    @Override
    protected IDBOPProcess OnCreateDBOPProcess(DBOPProc dbOPProc) throws Exception {
        if (StringHelper.Compare((String)dbOPProc.getEAIDBOPPROCTYPE(), (String)"DBOPPROC_SELECT_INSERT", (boolean)true) == 0) {
            return new DB2OPSelInsProcess();
        }
        if (StringHelper.Compare((String)dbOPProc.getEAIDBOPPROCTYPE(), (String)"DBOPPROC_CUSTOM_CALL", (boolean)true) == 0) {
            return new BaseDBOPCustomProcess();
        }
        if (StringHelper.Compare((String)dbOPProc.getEAIDBOPPROCTYPE(), (String)"DBOPPROC_SELECT_LOOPCALL", (boolean)true) == 0) {
            return new DB2OPSelLoopProcess();
        }
        return null;
    }

    @Override
    protected IDBOPRecordSet OnCreateDBRecordSet(DBRS dbRS) throws Exception {
        return new DB2OPRecordSet();
    }

    @Override
    public String getDBType() {
        return "DB2";
    }

    @Override
    protected void OnGenDBOPPKG_Header(StringBuilderEx stringBuilder) throws Exception {
        stringBuilder.Append("CREATE PROCEDURE %1$s.%2$s (\n", (Object)this.getDBSchema(), (Object)this.getProcName());
        boolean bFirst = true;
        for (DBOPPKGParam procParam : this.iDBOPSetting.getSysProcParams()) {
            if (bFirst) {
                bFirst = false;
            } else {
                stringBuilder.Append(",");
            }
            stringBuilder.Append(this.OnGetProcParam(procParam, true));
        }
        for (DBOPPKGParam procParam : this.procParams) {
            if (bFirst) {
                bFirst = false;
            } else {
                stringBuilder.Append(",");
            }
            stringBuilder.Append(this.OnGetProcParam(procParam, false));
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

    protected String OnGetProcParam(DBOPPKGParam pkgParam, boolean bSystem) throws Exception {
        boolean bInternal = false;
        String strParamDir = "";
        if (StringHelper.Compare((String)pkgParam.getPARAMTYPE(), (String)"IN", (boolean)true) == 0) {
            strParamDir = "IN";
        }
        if (StringHelper.Compare((String)pkgParam.getPARAMTYPE(), (String)"OUT", (boolean)true) == 0) {
            strParamDir = "OUT";
        }
        if (StringHelper.Compare((String)pkgParam.getPARAMTYPE(), (String)"INOUT", (boolean)true) == 0) {
            strParamDir = "INOUT";
        }
        if (StringHelper.Compare((String)pkgParam.getPARAMTYPE(), (String)"INTERNAL", (boolean)true) == 0) {
            bInternal = true;
            strParamDir = "DECLARE ";
        }
        return StringHelper.Format((String)"%1$s %2$s%3$s %4$s", (Object)strParamDir, (Object)(bSystem ? "SRF_" : "VAR_"), (Object)pkgParam.getEAIDBOPPKGPARAMNAME().toUpperCase(), (Object)this.OnGetParamDataType(pkgParam, bInternal));
    }

    protected String OnGetParamDataType(DBOPPKGParam pkgParam, boolean bDefault) throws Exception {
        String strType = "";
        DBOPDTMap dbopdtMap = this.iDBOPSetting.FindDBDataType(pkgParam.getDATATYPE());
        strType = dbopdtMap.getDBDATATYPE();
        if (dbopdtMap.getPARAMCNT() == 1 && dbopdtMap.getLENGTHDV() > 0) {
            strType = StringHelper.Format((String)"%1$s(%2$s)", (Object)strType, (Object)dbopdtMap.getLENGTHDV());
        }
        if (dbopdtMap.getPARAMCNT() == 2 && dbopdtMap.getLENGTHDV() > 0 && dbopdtMap.getPRECISIONDV() > 0) {
            strType = StringHelper.Format((String)"%1$s(%2$s,%3$s)", (Object)strType, (Object)dbopdtMap.getLENGTHDV(), (Object)dbopdtMap.getPRECISIONDV());
        }
        if (bDefault && !StringHelper.IsNullOrEmpty((String)pkgParam.getDEFAULTVALUE())) {
            strType = StringHelper.Format((String)"%1$s=%2$s", (Object)strType, (Object)pkgParam.getDEFAULTVALUE());
        }
        return strType;
    }

    @Override
    protected void OnGenDBOPPKG_Body(StringBuilderEx stringBuilder) throws Exception {
        stringBuilder.Append("BEGIN\n", (Object)stringBuilder);
        this.OnGenDBOPPKG_Body_Declare(stringBuilder);
        stringBuilder.Append("\n");
        this.OnGenDBOPPKG_Body_UserDeclare(stringBuilder);
        this.OnGenDBOPPKG_Body_SystemInit(stringBuilder);
        stringBuilder.Append("\n");
        this.OnGenDBOPPKG_Body_UserInit(stringBuilder);
        stringBuilder.Append("\n");
        this.OnGenDBOPPKG_Body_CreateTmpTable(stringBuilder);
        stringBuilder.Append("\n");
        this.OnGenDBOPPKG_Body_Process(stringBuilder);
        stringBuilder.Append("\n");
        this.OnGenDBOPPKG_Body_DropTmpTable(stringBuilder);
        stringBuilder.Append("\n");
        stringBuilder.Append("EXIT:RETURN;\n");
        stringBuilder.Append("END\n");
    }

    protected void OnGenDBOPPKG_Body_Declare(StringBuilderEx stringBuilder) throws Exception {
        for (DBOPPKGParam procParam : this.iDBOPSetting.getSysDeclareParams()) {
            stringBuilder.Append("%1$s;\n", (Object)this.OnGetProcParam(procParam, true));
        }
        for (DBOPPKGParam procParam : this.internalParams) {
            stringBuilder.Append("%1$s;\n", (Object)this.OnGetProcParam(procParam, false));
        }
    }
}

