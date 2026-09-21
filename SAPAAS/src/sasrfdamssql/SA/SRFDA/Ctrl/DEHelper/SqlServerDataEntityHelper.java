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

public class SqlServerDataEntityHelper
extends SqlServerBaseDADEHelper {
    @Override
    protected String GETSQL_UPDATEPROC_BODY_UPDATETABLE_FIELDVALUE(IDEFHelper iDEFHelper) {
        IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
        if (StringHelper.Compare((String)iDTColumn.GetColumnName(), (String)"DEVERSION", (boolean)true) == 0) {
            return StringHelper.Format((String)"CASE %1$s%3$s WHEN 1 THEN %2$s%3$s ELSE %3$s+1 END", (Object)"@VF_", (Object)"@VAR_", (Object)iDTColumn.GetColumnName());
        }
        return super.GETSQL_UPDATEPROC_BODY_UPDATETABLE_FIELDVALUE(iDEFHelper);
    }

    @Override
    protected String GETSQL_INSERTPROC_BODY_AFTERINSERT() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_INSERTPROC_BODY_AFTERINSERT());
        stringBuilder.Append("\n");
        return stringBuilder.toString();
    }

    @Override
    protected String GETSQL_DELETEPROC_BODY_BEFOREDELETE() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_DELETEPROC_BODY_BEFOREDELETE());
        if (this.IsDevelopMode()) {
            if (this.IsDBUnicodeChar()) {
                stringBuilder.Append("\n declare @sql nvarchar(1000) \n");
            } else {
                stringBuilder.Append("\n declare @sql varchar(1000) \n");
            }
            stringBuilder.Append("select @vartablename=tablename,@varextablename=extablename,@varviewname=viewname  \n");
            stringBuilder.Append("FROM t_srfdataentity  WHERE (DEID=@VAR_DEID) \n");
            stringBuilder.Append("");
            stringBuilder.Append("begin try \n");
            stringBuilder.Append("set @sql ='drop view '+@varviewname \n exec  (@sql)  ");
            stringBuilder.Append("\nend try\n begin catch  \n");
            stringBuilder.Append("print 'catch'\n");
            stringBuilder.Append("end catch\n");
            stringBuilder.Append("");
            stringBuilder.Append("begin try \n");
            stringBuilder.Append(" set @sql = ' drop table '+@varextablename \n exec (@sql) \n");
            stringBuilder.Append("end try\n begin catch  \n");
            stringBuilder.Append("print 'catch'\n");
            stringBuilder.Append("end catch\n");
            stringBuilder.Append("");
            stringBuilder.Append("begin try \n");
            stringBuilder.Append("set @sql=  'drop table '+@vartablename \n exec (@sql) \n");
            stringBuilder.Append("end try\n begin catch  \n");
            stringBuilder.Append("print 'catch'\n");
            stringBuilder.Append("end catch\n");
            stringBuilder.Append("");
            stringBuilder.Append("begin try \n");
            stringBuilder.Append("delete  t_srfder11 where majordeid=@VAR_DEID or minordeid=@VAR_DEID \n");
            stringBuilder.Append("end try\n begin catch  \n");
            stringBuilder.Append("print 'catch'\n");
            stringBuilder.Append("end catch\n");
            stringBuilder.Append("begin try \n");
            stringBuilder.Append("delete  t_srfder1N where majordeid=@VAR_DEID or minordeid=@VAR_DEID \n");
            stringBuilder.Append("end try\n begin catch  \n");
            stringBuilder.Append("print 'catch'\n");
            stringBuilder.Append("end catch\n");
            stringBuilder.Append("begin try \n");
            stringBuilder.Append("delete t_srfderindex where deid=@VAR_DEID \n");
            stringBuilder.Append("end try\n begin catch  \n");
            stringBuilder.Append("print 'catch'\n");
            stringBuilder.Append("end catch\n");
            stringBuilder.Append("begin try \n");
            stringBuilder.Append("delete t_srfform where deid=@VAR_DEID \n");
            stringBuilder.Append("end try\n begin catch  \n");
            stringBuilder.Append("print 'catch'\n");
            stringBuilder.Append("end catch\n");
            stringBuilder.Append("begin try \n");
            stringBuilder.Append("delete t_srfdatagrid where deid=@VAR_DEID  \n");
            stringBuilder.Append("end try\n begin catch  \n");
            stringBuilder.Append("print 'catch'\n");
            stringBuilder.Append("end catch\n");
            stringBuilder.Append("begin try \n");
            stringBuilder.Append("delete t_srfdefield where deid=@VAR_DEID \n");
            stringBuilder.Append("end try\n begin catch  \n");
            stringBuilder.Append("print 'catch'\n");
            stringBuilder.Append("end catch\n");
            stringBuilder.Append("begin try \n");
            stringBuilder.Append("delete t_srfpage where deid=@VAR_DEID \n");
            stringBuilder.Append("end try\n begin catch  \n");
            stringBuilder.Append("print 'catch'\n");
            stringBuilder.Append("end catch\n");
            stringBuilder.Append("begin try \n");
            stringBuilder.Append("delete t_srfDeWf where deid=@VAR_DEID \n");
            stringBuilder.Append("end try\n begin catch  \n");
            stringBuilder.Append("print 'catch'\n");
            stringBuilder.Append("end catch\n");
        }
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
        } else {
            stringBuilder.Append("declare @vartablename varchar(60)\n");
            stringBuilder.Append("declare @varextablename varchar(60)\n ");
            stringBuilder.Append("declare @varviewname varchar(60)\n");
        }
        return stringBuilder.toString();
    }
}

