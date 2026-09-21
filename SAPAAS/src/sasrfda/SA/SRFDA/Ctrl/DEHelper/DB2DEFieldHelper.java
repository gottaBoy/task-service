/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.Ctrl.DEHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFDTColumn;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEHelper.DB2BaseDADEHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public class DB2DEFieldHelper
extends DB2BaseDADEHelper {
    @Override
    protected String GETSQL_INSERTPROC_BODY_USERDECLARE() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_INSERTPROC_BODY_USERDECLARE());
        stringBuilder.Append("\nDECLARE nORDERFLAG INTEGER;\n");
        return stringBuilder.toString();
    }

    @Override
    protected String GETSQL_UPDATEPROC_BODY_USERDECLARE() {
        String strUserDeclare = super.GETSQL_UPDATEPROC_BODY_USERDECLARE();
        strUserDeclare = String.valueOf(strUserDeclare) + "DECLARE strDEID VARCHAR(100);\n";
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
        stringBuilder.Append("call SP_DATAENTITY_CHANGEVERSION(SRF_PERSONID,VAR_DEID);\n");
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
        stringBuilder.Append("call SP_DATAENTITY_CHANGEVERSION(SRF_PERSONID,strDEID);\n");
        return stringBuilder.toString();
    }

    @Override
    protected String GETSQL_DELETEPROC_BODY_AFTERDELETE() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_DELETEPROC_BODY_AFTERDELETE());
        stringBuilder.Append("\n");
        stringBuilder.Append("DELETE FROM T_SRFDEFIELD WHERE %1$s;\n", (Object)this.GETSQL_PROC_BODY_PKEYCONDITION(false, "", false));
        return stringBuilder.toString();
    }
}

