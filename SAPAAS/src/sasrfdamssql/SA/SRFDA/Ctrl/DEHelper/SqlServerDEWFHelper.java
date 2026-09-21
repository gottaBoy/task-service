/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.Ctrl.DEHelper;

import SA.SRFDA.Ctrl.DEHelper.SqlServerBaseDADEHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public class SqlServerDEWFHelper
extends SqlServerBaseDADEHelper {
    @Override
    protected String GETSQL_UPDATEPROC_BODY_USERDECLARE() {
        String strUserDeclare = super.GETSQL_UPDATEPROC_BODY_USERDECLARE();
        strUserDeclare = this.IsDBUnicodeChar() ? String.valueOf(strUserDeclare) + " declare @strDEID NVARCHAR(100)\n" : String.valueOf(strUserDeclare) + " declare @strDEID VARCHAR(100)\n";
        return strUserDeclare;
    }

    @Override
    protected String GETSQL_UPDATEPROC_BODY_AFTERUPDATE() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_UPDATEPROC_BODY_AFTERUPDATE());
        stringBuilder.Append("\n");
        stringBuilder.Append("SELECT @strDEID=DEID  from %1$s WHERE %2$s \n", (Object)this.GetDEViewName(), (Object)this.GETSQL_PROC_BODY_PKEYCONDITION(false, "", false));
        stringBuilder.Append(" exec SP_DATAENTITY_CHANGEVERSION @SRF_PERSONID,@strDEID  \n");
        return stringBuilder.toString();
    }

    @Override
    protected String GETSQL_INSERTPROC_BODY_AFTERINSERT() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_INSERTPROC_BODY_AFTERINSERT());
        stringBuilder.Append("\n");
        stringBuilder.Append(" exec SP_DATAENTITY_CHANGEVERSION @SRF_PERSONID,@VAR_DEID  \n");
        return stringBuilder.toString();
    }
}

