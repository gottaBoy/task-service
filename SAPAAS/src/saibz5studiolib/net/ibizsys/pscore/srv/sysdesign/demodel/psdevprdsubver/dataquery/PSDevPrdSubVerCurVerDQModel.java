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
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevprdsubver.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="EB229136-512E-43F5-9B3B-BBB8EC918F88", name="CurVer")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PPSDEVPRDSUBVERID`, t11.`PSDEVPRDSUBVERNAME` AS `PPSDEVPRDSUBVERNAME`, t1.`PSDEVPRDSUBVERID`, t1.`PSDEVPRDSUBVERNAME`, t1.`PSDEVPRDVERID`, t21.`PSDEVPRDVERNAME`, t1.`SUBVERSTATE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG`, t1.`VER` FROM `T_SRFPSDEVPRDSUBVER` t1  LEFT JOIN T_SRFPSDEVPRDSUBVER t11 ON t1.PPSDEVPRDSUBVERID = t11.PSDEVPRDSUBVERID  LEFT JOIN T_SRFPSDEVPRDVER t21 ON t1.PSDEVPRDVERID = t21.PSDEVPRDVERID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PPSDEVPRDSUBVERID", expression="t1.`PPSDEVPRDSUBVERID`", showorder=3), @DEDataQueryCodeExp(name="PPSDEVPRDSUBVERNAME", expression="t11.`PSDEVPRDSUBVERNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDEVPRDSUBVERID", expression="t1.`PSDEVPRDSUBVERID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVPRDSUBVERNAME", expression="t1.`PSDEVPRDSUBVERNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEVPRDVERID", expression="t1.`PSDEVPRDVERID`", showorder=7), @DEDataQueryCodeExp(name="PSDEVPRDVERNAME", expression="t21.`PSDEVPRDVERNAME`", showorder=8), @DEDataQueryCodeExp(name="SUBVERSTATE", expression="t1.`SUBVERSTATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12), @DEDataQueryCodeExp(name="VER", expression="t1.`VER`", showorder=13)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSDEVPRDVERID` =  ${srfdatacontext('psdevprdverid','{\"defname\":\"PSDEVPRDVERID\",\"dename\":\"PSDEVPRDSUBVER\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PPSDEVPRDSUBVERID, t11.PSDEVPRDSUBVERNAME AS PPSDEVPRDSUBVERNAME, t1.PSDEVPRDSUBVERID, t1.PSDEVPRDSUBVERNAME, t1.PSDEVPRDVERID, t21.PSDEVPRDVERNAME, t1.SUBVERSTATE, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG, t1.VER FROM T_SRFPSDEVPRDSUBVER t1  LEFT JOIN T_SRFPSDEVPRDSUBVER t11 ON t1.PPSDEVPRDSUBVERID = t11.PSDEVPRDSUBVERID  LEFT JOIN T_SRFPSDEVPRDVER t21 ON t1.PSDEVPRDVERID = t21.PSDEVPRDVERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PPSDEVPRDSUBVERID", expression="t1.PPSDEVPRDSUBVERID", showorder=3), @DEDataQueryCodeExp(name="PPSDEVPRDSUBVERNAME", expression="t11.PSDEVPRDSUBVERNAME", showorder=4), @DEDataQueryCodeExp(name="PSDEVPRDSUBVERID", expression="t1.PSDEVPRDSUBVERID", showorder=5), @DEDataQueryCodeExp(name="PSDEVPRDSUBVERNAME", expression="t1.PSDEVPRDSUBVERNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEVPRDVERID", expression="t1.PSDEVPRDVERID", showorder=7), @DEDataQueryCodeExp(name="PSDEVPRDVERNAME", expression="t21.PSDEVPRDVERNAME", showorder=8), @DEDataQueryCodeExp(name="SUBVERSTATE", expression="t1.SUBVERSTATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12), @DEDataQueryCodeExp(name="VER", expression="t1.VER", showorder=13)}, conds={@DEDataQueryCodeCond(condition="( t1.PSDEVPRDVERID =  ${srfdatacontext('psdevprdverid','{\"defname\":\"PSDEVPRDVERID\",\"dename\":\"PSDEVPRDSUBVER\"}')} )")})})
public class PSDevPrdSubVerCurVerDQModel
extends DEDataQueryModelBase {
    public PSDevPrdSubVerCurVerDQModel() {
        this.initAnnotation(PSDevPrdSubVerCurVerDQModel.class);
    }
}

