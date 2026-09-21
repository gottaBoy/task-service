/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFDTColumn
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.Ctrl.DEHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFDTColumn;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEHelper.MySQLBaseDADEHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public class MySQLDER1NHelper
extends MySQLBaseDADEHelper {
    @Override
    protected String GETSQL_UPDATEPROC_BODY_USERDECLARE() {
        String strUserDeclare = super.GETSQL_UPDATEPROC_BODY_USERDECLARE();
        strUserDeclare = String.valueOf(strUserDeclare) + " declare  strMAJORDEID VARCHAR(100);\n";
        strUserDeclare = String.valueOf(strUserDeclare) + " declare  strMINORDEID VARCHAR(100);\n";
        return strUserDeclare;
    }

    @Override
    protected String GETSQL_INSERTPROC_BODY_INPUTCHECKS() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_INSERTPROC_BODY_INPUTCHECKS());
        stringBuilder.Append("IF UPPER(VAR_MAJORKEYDEFNAME) = UPPER(VAR_MAJORTEXTDEFNAME) THEN\n");
        stringBuilder.Append("SET  SRF_RETCODE= %1$s;\n", (Object)1007);
        stringBuilder.Append("SET  SRF_RETINFO= '\u952e\u5c5e\u6027\u53ca\u6587\u672c\u5c5e\u6027\u540d\u79f0\u4e0d\u80fd\u76f8\u540c';\n");
        stringBuilder.Append("SET  SRF_TAG= 'MAJORKEYDEFNAME|MAJORTEXTDEFNAME';\n");
        stringBuilder.Append("LEAVE SRFBODY ;\n");
        stringBuilder.Append("END IF;\n");
        stringBuilder.Append("select count(*) into nTemp from t_SRFDEFIELD where DEID=VAR_MINORDEID AND UPPER(DEFNAME) = UPPER(VAR_MAJORKEYDEFNAME) AND (ENABLE=1); \n");
        stringBuilder.Append("IF nTemp <> 0 THEN\n");
        stringBuilder.Append(" SET SRF_RETCODE= %1$s;\n", (Object)1007);
        stringBuilder.Append(" SET SRF_RETINFO= CONCAT('\u5173\u7cfb\u5b9e\u4f53\u4e2d\u5df2\u7ecf\u5b58\u5728\u5c5e\u6027', VAR_MAJORKEYDEFNAME);\n");
        stringBuilder.Append(" SET SRF_TAG= 'MAJORKEYDEFNAME';\n");
        stringBuilder.Append("LEAVE SRFBODY ;\n");
        stringBuilder.Append("END IF;\n");
        stringBuilder.Append("select count(*) into nTemp from t_SRFDEFIELD where DEID=VAR_MINORDEID AND UPPER(DEFNAME) = UPPER(VAR_MAJORTEXTDEFNAME) AND (ENABLE=1); \n");
        stringBuilder.Append("IF nTemp <> 0 THEN\n");
        stringBuilder.Append(" SET SRF_RETCODE= %1$s;\n", (Object)1007);
        stringBuilder.Append(" SET SRF_RETINFO= CONCAT('\u5173\u7cfb\u5b9e\u4f53\u4e2d\u5df2\u7ecf\u5b58\u5728\u5c5e\u6027', VAR_MAJORTEXTDEFNAME);\n");
        stringBuilder.Append(" SET SRF_TAG= 'MAJORTEXTDEFNAME';\n");
        stringBuilder.Append("LEAVE SRFBODY ;\n");
        stringBuilder.Append("END IF;\n");
        return stringBuilder.toString();
    }

    @Override
    protected String GETSQL_INSERTPROC_BODY_INSERTTABLE_FIELDVALUE(IDEFHelper iDEFHelper) {
        IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
        return super.GETSQL_INSERTPROC_BODY_INSERTTABLE_FIELDVALUE(iDEFHelper);
    }

    @Override
    protected String GETSQL_UPDATEPROC_BODY_AFTERUPDATE() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_UPDATEPROC_BODY_AFTERUPDATE());
        stringBuilder.Append("\n");
        stringBuilder.Append("SELECT MAJORDEID,MINORDEID INTO strMAJORDEID,strMINORDEID from %1$s WHERE %2$s;\n", (Object)this.GetDEViewName(), (Object)this.GETSQL_PROC_BODY_PKEYCONDITION(false, "", false));
        stringBuilder.Append(" CALL SP_DATAENTITY_CHANGEVERSION(SRF_PERSONID,strMAJORDEID);\n");
        stringBuilder.Append(" CALL SP_DATAENTITY_CHANGEVERSION(SRF_PERSONID,strMINORDEID);\n");
        return stringBuilder.toString();
    }

    @Override
    protected String GETSQL_INSERTPROC_BODY_AFTERINSERT() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_INSERTPROC_BODY_AFTERINSERT());
        stringBuilder.Append("\n");
        stringBuilder.Append(" CALL SP_DATAENTITY_CHANGEVERSION(SRF_PERSONID,VAR_MINORDEID);\n");
        stringBuilder.Append(" CALL SP_DATAENTITY_CHANGEVERSION(SRF_PERSONID,VAR_MAJORDEID);\n");
        return stringBuilder.toString();
    }
}

