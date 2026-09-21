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
import SA.SRFDA.Ctrl.DEHelper.SqlServerBaseDADEHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public class SqlServerDEFieldHelper
extends SqlServerBaseDADEHelper {
    @Override
    protected String GETSQL_INSERTPROC_BODY_USERDECLARE() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_INSERTPROC_BODY_USERDECLARE());
        stringBuilder.Append("\n declare @nORDERFLAG INT\n");
        return stringBuilder.toString();
    }

    @Override
    protected String GETSQL_UPDATEPROC_BODY_USERDECLARE() {
        String strUserDeclare = super.GETSQL_UPDATEPROC_BODY_USERDECLARE();
        strUserDeclare = String.valueOf(strUserDeclare) + "  declare @strDEID VARCHAR(100)\n";
        return strUserDeclare;
    }

    @Override
    protected String GETSQL_INSERTPROC_BODY_USERINIT() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_INSERTPROC_BODY_USERINIT());
        stringBuilder.Append("\n");
        stringBuilder.Append("SELECT @nORDERFLAG=MAX(ORDERFLAG)    FROM T_SRFDEFIELD WHERE DEID=@VAR_DEID \n");
        stringBuilder.Append("IF @nORDERFLAG IS NULL  \n begin\n");
        stringBuilder.Append(" set @nORDERFLAG =1 \n end\n ");
        stringBuilder.Append("ELSE\n begin\n ");
        stringBuilder.Append(" set @nORDERFLAG =@nORDERFLAG +  1\n");
        stringBuilder.Append("END  \n");
        return stringBuilder.toString();
    }

    @Override
    protected String GETSQL_INSERTPROC_BODY_INSERTTABLE_FIELDVALUE(IDEFHelper iDEFHelper) {
        IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
        if (StringHelper.Compare((String)iDTColumn.GetColumnName(), (String)"ORDERFLAG", (boolean)true) == 0) {
            return StringHelper.Format((String)"CASE WHEN %2$s%3$s IS NOT NULL THEN %2$s%3$s ELSE @nORDERFLAG END", (Object)"@VF_", (Object)"@VAR_", (Object)iDTColumn.GetColumnName());
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
        stringBuilder.Append("IF %1$s IS NOT NULL AND %1$s=1 \n begin \n", (Object)this.GETFIELDPARAMNAME(true, isMajorDEFHelper.GetDTColumn()));
        stringBuilder.Append("UPDATE T_SRFDEFIELD SET ISMAJOR=0 WHERE ENABLE=1 AND DEID = @VAR_DEID AND DEFID <>  %1$s \n", (Object)this.GETFIELDPARAMNAME(true, defidDEFHelper.GetDTColumn()));
        stringBuilder.Append("END \n");
        stringBuilder.Append("  exec SP_DATAENTITY_CHANGEVERSION @SRF_PERSONID,@VAR_DEID  \n");
        return stringBuilder.toString();
    }

    @Override
    protected String GETSQL_UPDATEPROC_BODY_AFTERUPDATE() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_UPDATEPROC_BODY_AFTERUPDATE());
        stringBuilder.Append("\n");
        stringBuilder.Append("SELECT  @strDEID =DEID  from %1$s WHERE %2$s \n", (Object)this.GetDEViewName(), (Object)this.GETSQL_PROC_BODY_PKEYCONDITION(false, "", false));
        IDEFHelper isMajorDEFHelper = this.GetDEFHelper("ISMAJOR");
        stringBuilder.Append("IF %1$s IS NOT NULL AND %1$s=1 \n begin \n", (Object)this.GETFIELDPARAMNAME(false, isMajorDEFHelper.GetDTColumn()));
        stringBuilder.Append("UPDATE T_SRFDEFIELD SET ISMAJOR=0 WHERE ENABLE=1 AND DEID = @strDEID AND DEFID <>  @VAR_DEFID \n");
        stringBuilder.Append("END  \n");
        stringBuilder.Append(" exec SP_DATAENTITY_CHANGEVERSION @SRF_PERSONID,@strDEID  \n");
        return stringBuilder.toString();
    }

    @Override
    protected String GETSQL_DELETEPROC_BODY_USERDECLARE() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_DELETEPROC_BODY_USERDECLARE());
        stringBuilder.Append("\n");
        if (this.IsDBUnicodeChar()) {
            stringBuilder.Append("declare @vartablename nvarchar(60)\n");
            stringBuilder.Append("declare @varextablename nvarchar(60)\n ");
            stringBuilder.Append("declare @varviewname nvarchar(60)\n");
            stringBuilder.Append("declare @vardefname nvarchar(60)\n");
            stringBuilder.Append("declare @VAR_DEID nvarchar(60)\n");
        } else {
            stringBuilder.Append("declare @vartablename varchar(60)\n");
            stringBuilder.Append("declare @varextablename varchar(60)\n ");
            stringBuilder.Append("declare @varviewname varchar(60)\n");
            stringBuilder.Append("declare @vardefname varchar(60)\n");
            stringBuilder.Append("declare @VAR_DEID varchar(60)\n");
        }
        return stringBuilder.toString();
    }

    @Override
    protected String GETSQL_DELETEPROC_BODY_BEFOREDELETE() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_DELETEPROC_BODY_BEFOREDELETE());
        if (this.IsDevelopMode()) {
            if (this.IsDBUnicodeChar()) {
                stringBuilder.Append("\ndeclare @sql nvarchar(1000) \n");
            } else {
                stringBuilder.Append("\ndeclare @sql varchar(1000) \n");
            }
            stringBuilder.Append("select  @vartablename=t_srfdataentity.tablename,\n");
            stringBuilder.Append(" @varextablename=t_srfdataentity.extablename,\n");
            stringBuilder.Append(" @varviewname=t_srfdataentity.viewname,@VAR_DEID=t_srfdataentity.deid,\n");
            stringBuilder.Append("@vardefname=T_SRFDEFIELD.DEFNAME  \n");
            stringBuilder.Append("FROM \n");
            stringBuilder.Append("T_SRFDEFIELD left join \n");
            stringBuilder.Append("t_srfdataentity \n");
            stringBuilder.Append("on T_SRFDEFIELD.deid=t_srfdataentity.deid\n");
            stringBuilder.Append(" WHERE (T_SRFDEFIELD.DEFID=@VAR_DEFID) \n");
            stringBuilder.Append("");
            stringBuilder.Append("begin try\n");
            stringBuilder.Append("set @sql='alter table '+@vartablename+' drop column '+@vardefname \n exec (@sql)\n");
            stringBuilder.Append("end try \n begin catch \n print 'catch' \n end catch\n");
        }
        stringBuilder.Append("delete t_srfdefield  WHERE (DEFID=@VAR_DEFID) \n");
        stringBuilder.Append(" exec SP_DATAENTITY_CHANGEVERSION @SRF_PERSONID,@VAR_DEID  \n");
        return stringBuilder.toString();
    }
}

