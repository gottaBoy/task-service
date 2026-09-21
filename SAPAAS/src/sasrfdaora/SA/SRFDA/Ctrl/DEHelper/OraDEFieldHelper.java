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

public class OraDEFieldHelper
extends OraBaseDADEHelper {
    @Override
    protected String GETSQL_INSERTPROC_BODY_USERDECLARE() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_INSERTPROC_BODY_USERDECLARE());
        stringBuilder.Append("\n nORDERFLAG INTEGER;\n");
        return stringBuilder.toString();
    }

    @Override
    protected String GETSQL_UPDATEPROC_BODY_USERDECLARE() {
        String strUserDeclare = super.GETSQL_UPDATEPROC_BODY_USERDECLARE();
        strUserDeclare = String.valueOf(strUserDeclare) + "  strDEID VARCHAR2(100);\n";
        return strUserDeclare;
    }

    @Override
    protected String GETSQL_INSERTPROC_BODY_USERINIT() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_INSERTPROC_BODY_USERINIT());
        stringBuilder.Append("\n");
        stringBuilder.Append("SELECT MAX(ORDERFLAG) INTO nORDERFLAG FROM T_SRFDEFIELD WHERE DEID=VAR_DEID;\n");
        stringBuilder.Append("IF nORDERFLAG IS NULL THEN\n");
        stringBuilder.Append(" nORDERFLAG:=1;\n");
        stringBuilder.Append("ELSE\n");
        stringBuilder.Append(" nORDERFLAG:=nORDERFLAG + 1;\n");
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
        stringBuilder.Append("  SP_DATAENTITY_CHANGEVERSION(SRF_PERSONID,VAR_DEID);\n");
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
        stringBuilder.Append("  SP_DATAENTITY_CHANGEVERSION(SRF_PERSONID,strDEID);\n");
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
        stringBuilder.Append("vardefname varchar2(60);\n");
        stringBuilder.Append("VAR_DEID varchar2(60);\n");
        return stringBuilder.toString();
    }

    @Override
    protected String GETSQL_DELETEPROC_BODY_BEFOREDELETE() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(super.GETSQL_DELETEPROC_BODY_BEFOREDELETE());
        stringBuilder.Append("\n");
        stringBuilder.Append("select t_srfdataentity.tablename,\n");
        stringBuilder.Append("t_srfdataentity.extablename,\n");
        stringBuilder.Append("t_srfdataentity.viewname,t_srfdataentity.deid,\n");
        stringBuilder.Append("T_SRFDEFIELD.DEFNAME into vartablename,varextablename,varviewname,VAR_DEID,vardefname\n");
        stringBuilder.Append("FROM \n");
        stringBuilder.Append("T_SRFDEFIELD left join \n");
        stringBuilder.Append("t_srfdataentity \n");
        stringBuilder.Append("on T_SRFDEFIELD.deid=t_srfdataentity.deid\n");
        stringBuilder.Append(" WHERE (T_SRFDEFIELD.DEFID=VAR_DEFID);\n");
        stringBuilder.Append("");
        if (this.IsDevelopMode()) {
            stringBuilder.Append("begin\n");
            stringBuilder.Append("execute immediate 'alter table %1$s.'||vartablename||' drop column '||vardefname;\n", (Object)this.strDBSCHEMA);
            stringBuilder.Append("exception when   others   then \n");
            stringBuilder.Append("vartablename:=vartablename;\n");
            stringBuilder.Append("end;\n");
            stringBuilder.Append("");
        }
        stringBuilder.Append("delete t_srfdefieldlog  WHERE (DEFID=VAR_DEFID); \n");
        stringBuilder.Append("delete t_srfdefield  WHERE (DEFID=VAR_DEFID);\n");
        stringBuilder.Append(" SP_DATAENTITY_CHANGEVERSION(SRF_PERSONID,VAR_DEID);\n");
        return stringBuilder.toString();
    }
}

