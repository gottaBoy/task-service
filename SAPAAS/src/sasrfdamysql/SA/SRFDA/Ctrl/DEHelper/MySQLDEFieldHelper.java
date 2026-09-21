/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFDTColumn
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.Ctrl.DEHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFDTColumn;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEHelper.MySQLBaseDADEHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public class MySQLDEFieldHelper
extends MySQLBaseDADEHelper {
    @Override
    protected String GETSQL_INSERTPROC_BODY_USERDECLARE() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_INSERTPROC_BODY_USERDECLARE());
        stringBuilder.Append("\n declare nORDERFLAG INT;\n");
        return stringBuilder.toString();
    }

    @Override
    protected String GETSQL_UPDATEPROC_BODY_USERDECLARE() {
        String strUserDeclare = super.GETSQL_UPDATEPROC_BODY_USERDECLARE();
        strUserDeclare = String.valueOf(strUserDeclare) + " declare strDEID VARCHAR(100);\n";
        return strUserDeclare;
    }

    @Override
    protected String GETSQL_INSERTPROC_BODY_USERINIT() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_INSERTPROC_BODY_USERINIT());
        stringBuilder.Append("\n");
        stringBuilder.Append("SELECT MAX(ORDERFLAG) INTO nORDERFLAG FROM T_SRFDEFIELD WHERE DEID=VAR_DEID;\n");
        stringBuilder.Append("IF nORDERFLAG IS NULL THEN\n");
        stringBuilder.Append("SET nORDERFLAG=1;\n");
        stringBuilder.Append("ELSE\n");
        stringBuilder.Append("SET nORDERFLAG=nORDERFLAG + 1;\n");
        stringBuilder.Append("END IF;\n");
        return stringBuilder.toString();
    }

    @Override
    protected String GETSQL_INSERTPROC_BODY_INSERTTABLE_FIELDVALUE(IDEFHelper iDEFHelper) {
        IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
        if (StringHelper.Compare((String)iDTColumn.GetColumnName(), (String)"ORDERFLAG", (boolean)true) == 0) {
            return StringHelper.Format((String)"CASE WHEN %2$s%3$s IS NOT NULL THEN %2$s%3$s ELSE nORDERFLAG END", (Object)"VF_", (Object)"VAR_", (Object)iDTColumn.GetColumnName());
        }
        return super.GETSQL_INSERTPROC_BODY_INSERTTABLE_FIELDVALUE(iDEFHelper);
    }

    @Override
    protected String GETSQL_INSERTPROC_BODY_AFTERINSERT() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_INSERTPROC_BODY_AFTERINSERT());
        stringBuilder.Append("\n");
        IDEFHelper isMajorDEFHelper = this.GetDEFHelper("ISMAJOR");
        IDEFHelper defidDEFHelper = this.GetDEFHelper("DEFID");
        stringBuilder.Append("IF %1$s IS NOT NULL AND %1$s=1 THEN \n", (Object)this.GETFIELDPARAMNAME(true, isMajorDEFHelper.GetDTColumn()));
        stringBuilder.Append("UPDATE T_SRFDEFIELD SET ISMAJOR=0 WHERE ENABLE=1 AND DEID = VAR_DEID AND DEFID <>  %1$s;\n", (Object)this.GETFIELDPARAMNAME(true, defidDEFHelper.GetDTColumn()));
        stringBuilder.Append("END IF;\n");
        stringBuilder.Append(" CALL SP_DATAENTITY_CHANGEVERSION(SRF_PERSONID,VAR_DEID);\n");
        return stringBuilder.toString();
    }

    @Override
    protected String GETSQL_UPDATEPROC_BODY_AFTERUPDATE() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_UPDATEPROC_BODY_AFTERUPDATE());
        stringBuilder.Append("\n");
        stringBuilder.Append("SELECT DEID INTO strDEID from %1$s WHERE %2$s;\n", (Object)this.GetDEViewName(), (Object)this.GETSQL_PROC_BODY_PKEYCONDITION(false, "", false));
        IDEFHelper isMajorDEFHelper = this.GetDEFHelper("ISMAJOR");
        stringBuilder.Append("IF %1$s IS NOT NULL AND %1$s=1 THEN \n", (Object)this.GETFIELDPARAMNAME(false, isMajorDEFHelper.GetDTColumn()));
        stringBuilder.Append("UPDATE T_SRFDEFIELD SET ISMAJOR=0 WHERE ENABLE=1 AND DEID = strDEID AND DEFID <>  VAR_DEFID;\n");
        stringBuilder.Append("END IF;\n");
        stringBuilder.Append(" CALL SP_DATAENTITY_CHANGEVERSION(SRF_PERSONID,strDEID);\n");
        return stringBuilder.toString();
    }

    @Override
    protected String GETSQL_DELETEPROC_BODY_USERDECLARE() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_DELETEPROC_BODY_USERDECLARE());
        stringBuilder.Append("\n");
        stringBuilder.Append("declare vartablename varchar(60);\n");
        stringBuilder.Append("declare varextablename varchar(60);\n ");
        stringBuilder.Append("declare varviewname varchar(60);\n");
        stringBuilder.Append("declare vardefname varchar(60);\n");
        stringBuilder.Append("declare VAR_DEID varchar(60);\n");
        return stringBuilder.toString();
    }

    @Override
    protected String GETSQL_DELETEPROC_BODY_BEFOREDELETE() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_DELETEPROC_BODY_BEFOREDELETE());
        stringBuilder.Append("\n");
        stringBuilder.Append("delete from t_srfdefieldlog  WHERE (DEFID=VAR_DEFID); \n");
        stringBuilder.Append("delete from t_srfdefield  WHERE (DEFID=VAR_DEFID);\n");
        stringBuilder.Append("CALL SP_DATAENTITY_CHANGEVERSION(SRF_PERSONID,VAR_DEID);\n");
        return stringBuilder.toString();
    }
}

