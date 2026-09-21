/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeCond
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdevusersql.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="EDB105CE-7150-421C-B968-2C22243FC4E5", name="CurUserSQL")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`FILETYPE`, t1.`PSDEVUSERID`, t1.`PSDEVUSERNAME`, t1.`PSDEVUSERSQLID`, t1.`PSDEVUSERSQLNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVUSERSQL` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.`CONTENT`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="FILETYPE", expression="t1.`FILETYPE`", showorder=2), @DEDataQueryCodeExp(name="PSDEVUSERID", expression="t1.`PSDEVUSERID`", showorder=3), @DEDataQueryCodeExp(name="PSDEVUSERNAME", expression="t1.`PSDEVUSERNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDEVUSERSQLID", expression="t1.`PSDEVUSERSQLID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVUSERSQLNAME", expression="t1.`PSDEVUSERSQLNAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8)}, conds={@DEDataQueryCodeCond(condition="( t1.`FILETYPE` = 'SQL'  AND  t1.`PSDEVUSERID` =  ${srfsessioncontext('SRFPERSONID','{\"defname\":\"PSDEVUSERID\",\"dename\":\"PSDEVUSERSQL\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.FILETYPE, t1.PSDEVUSERID, t1.PSDEVUSERNAME, t1.PSDEVUSERSQLID, t1.PSDEVUSERSQLNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVUSERSQL t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.CONTENT", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="FILETYPE", expression="t1.FILETYPE", showorder=2), @DEDataQueryCodeExp(name="PSDEVUSERID", expression="t1.PSDEVUSERID", showorder=3), @DEDataQueryCodeExp(name="PSDEVUSERNAME", expression="t1.PSDEVUSERNAME", showorder=4), @DEDataQueryCodeExp(name="PSDEVUSERSQLID", expression="t1.PSDEVUSERSQLID", showorder=5), @DEDataQueryCodeExp(name="PSDEVUSERSQLNAME", expression="t1.PSDEVUSERSQLNAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8)}, conds={@DEDataQueryCodeCond(condition="( t1.FILETYPE = 'SQL'  AND  t1.PSDEVUSERID =  ${srfsessioncontext('SRFPERSONID','{\"defname\":\"PSDEVUSERID\",\"dename\":\"PSDEVUSERSQL\"}')} )")})})
public class PSDevUserSqlCurUserSQLDQModel
extends DEDataQueryModelBase {
    public PSDevUserSqlCurUserSQLDQModel() {
        this.initAnnotation(PSDevUserSqlCurUserSQLDQModel.class);
    }
}

