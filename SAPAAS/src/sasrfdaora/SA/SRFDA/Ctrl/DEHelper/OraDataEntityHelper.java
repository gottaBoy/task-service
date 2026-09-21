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
import SA.SRFDA.Ctrl.DEHelper.OraBaseDADEHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public class OraDataEntityHelper
extends OraBaseDADEHelper {
    @Override
    protected String GETSQL_UPDATEPROC_BODY_UPDATETABLE_FIELDVALUE(IDEFHelper iDEFHelper, boolean bInheritMode) {
        IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
        if (StringHelper.Compare((String)iDTColumn.GetColumnName(), (String)"DEVERSION", (boolean)true) == 0) {
            return StringHelper.Format((String)"CASE %1$s%3$s WHEN 1 THEN %2$s%3$s ELSE %3$s+1 END", (Object)"VF_", (Object)"VAR_", (Object)iDTColumn.GetColumnName());
        }
        return super.GETSQL_UPDATEPROC_BODY_UPDATETABLE_FIELDVALUE(iDEFHelper, bInheritMode);
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
        stringBuilder.Append("\n");
        stringBuilder.Append("select tablename,extablename,viewname into vartablename,varextablename,varviewname\n");
        stringBuilder.Append("FROM t_srfdataentity  WHERE (DEID=VAR_DEID);\n");
        stringBuilder.Append("");
        if (this.IsDevelopMode()) {
            stringBuilder.Append("begin\n");
            stringBuilder.Append("execute immediate 'drop view %1$s.'||varviewname;\n", (Object)this.strDBSCHEMA);
            stringBuilder.Append("exception when   others   then \n");
            stringBuilder.Append("vartablename:=vartablename;\n");
            stringBuilder.Append("end;\n");
            stringBuilder.Append("");
            stringBuilder.Append("begin\n");
            stringBuilder.Append("execute immediate ' drop table %1$s.'||varextablename ;\n", (Object)this.strDBSCHEMA);
            stringBuilder.Append("exception when   others   then \n");
            stringBuilder.Append("vartablename:=vartablename;\n");
            stringBuilder.Append("end;\n");
            stringBuilder.Append("");
            stringBuilder.Append("begin\n");
            stringBuilder.Append("execute immediate 'drop table %1$s.'||vartablename ;\n", (Object)this.strDBSCHEMA);
            stringBuilder.Append("exception when   others   then \n");
            stringBuilder.Append("vartablename:=vartablename;\n");
            stringBuilder.Append("end;\n");
            stringBuilder.Append("");
        }
        stringBuilder.Append("delete  t_srfder11 where majordeid=VAR_DEID or minordeid=VAR_DEID;\n");
        stringBuilder.Append("delete  t_srfder1N where majordeid=VAR_DEID or minordeid=VAR_DEID;\n");
        stringBuilder.Append("delete t_srfderindex where deid=VAR_DEID;\n");
        stringBuilder.Append("delete t_srfform where deid=VAR_DEID;\n");
        stringBuilder.Append("delete t_srfdatagrid where deid=VAR_DEID; \n");
        stringBuilder.Append("delete t_srfdefield where deid=VAR_DEID;\n");
        stringBuilder.Append("delete t_srfDeWf where deid=VAR_DEID;\n");
        stringBuilder.Append("delete t_srfdergroupdetail where t_srfdergroupdetail.dergroupid in (select dergroupid from t_srfdergroup where deid=VAR_DEID);\n");
        stringBuilder.Append("delete t_Srfdergroup where deid=VAR_DEID;\n");
        stringBuilder.Append("delete t_srfpage where deid=VAR_DEID;\n");
        stringBuilder.Append("delete t_srfuserroledataaction where t_srfuserroledataaction.userroledataid in (select userroledataid from t_srfuserroledata where deid=VAR_DEID);\n");
        stringBuilder.Append("delete t_srfuserroledatadetail where t_srfuserroledatadetail.userroledataid in (select userroledataid from t_srfuserroledata where deid=VAR_DEID);\n");
        stringBuilder.Append("delete t_srfuserroledatas where t_srfuserroledatas.userroledataid in (select userroledataid from t_srfuserroledata where deid=VAR_DEID);\n");
        stringBuilder.Append("delete t_srfuserroledata where t_srfuserroledata.deid=VAR_DEID;\n");
        stringBuilder.Append("delete t_srfhelpdocitem where t_srfhelpdocitem.deid=VAR_DEID;\n");
        stringBuilder.Append("delete t_srfcalendartype where deid=VAR_DEID;\n");
        stringBuilder.Append("delete t_srfquerymodel where deid=VAR_DEID;\n");
        return stringBuilder.toString();
    }

    @Override
    protected String GETSQL_DELETEPROC_BODY_USERDECLARE() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_DELETEPROC_BODY_USERDECLARE());
        stringBuilder.Append("\n");
        stringBuilder.Append("vartablename varchar2(60);\n");
        stringBuilder.Append("varextablename varchar2(60);\n ");
        stringBuilder.Append("varviewname varchar2(60);\n");
        return stringBuilder.toString();
    }
}

