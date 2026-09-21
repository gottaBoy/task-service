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
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevprdspec.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="C8EA4CD1-0D88-4844-82F0-9E6A559FC656", name="CurVer")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEVPRDID`, t11.`PSDEVPRDNAME`, t1.`PSDEVPRDSPECID`, t1.`PSDEVPRDSPECNAME`, t1.`PSDEVPRDVERID`, t21.`PSDEVPRDVERNAME`, t1.`SPECSN`, t1.`SPECSTATE`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVPRDSPEC` t1  LEFT JOIN T_SRFPSDEVPRD t11 ON t1.PSDEVPRDID = t11.PSDEVPRDID  LEFT JOIN T_SRFPSDEVPRDVER t21 ON t1.PSDEVPRDVERID = t21.PSDEVPRDVERID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.`CONTENT`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEVPRDID", expression="t1.`PSDEVPRDID`", showorder=3), @DEDataQueryCodeExp(name="PSDEVPRDNAME", expression="t11.`PSDEVPRDNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDEVPRDSPECID", expression="t1.`PSDEVPRDSPECID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVPRDSPECNAME", expression="t1.`PSDEVPRDSPECNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEVPRDVERID", expression="t1.`PSDEVPRDVERID`", showorder=7), @DEDataQueryCodeExp(name="PSDEVPRDVERNAME", expression="t21.`PSDEVPRDVERNAME`", showorder=8), @DEDataQueryCodeExp(name="SPECSN", expression="t1.`SPECSN`", showorder=9), @DEDataQueryCodeExp(name="SPECSTATE", expression="t1.`SPECSTATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSDEVPRDVERID` =  ${srfdatacontext('psdevprdverid','{\"defname\":\"PSDEVPRDVERID\",\"dename\":\"PSDEVPRDSPEC\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEVPRDID, t11.PSDEVPRDNAME, t1.PSDEVPRDSPECID, t1.PSDEVPRDSPECNAME, t1.PSDEVPRDVERID, t21.PSDEVPRDVERNAME, t1.SPECSN, t1.SPECSTATE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVPRDSPEC t1  LEFT JOIN T_SRFPSDEVPRD t11 ON t1.PSDEVPRDID = t11.PSDEVPRDID  LEFT JOIN T_SRFPSDEVPRDVER t21 ON t1.PSDEVPRDVERID = t21.PSDEVPRDVERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.CONTENT", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEVPRDID", expression="t1.PSDEVPRDID", showorder=3), @DEDataQueryCodeExp(name="PSDEVPRDNAME", expression="t11.PSDEVPRDNAME", showorder=4), @DEDataQueryCodeExp(name="PSDEVPRDSPECID", expression="t1.PSDEVPRDSPECID", showorder=5), @DEDataQueryCodeExp(name="PSDEVPRDSPECNAME", expression="t1.PSDEVPRDSPECNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEVPRDVERID", expression="t1.PSDEVPRDVERID", showorder=7), @DEDataQueryCodeExp(name="PSDEVPRDVERNAME", expression="t21.PSDEVPRDVERNAME", showorder=8), @DEDataQueryCodeExp(name="SPECSN", expression="t1.SPECSN", showorder=9), @DEDataQueryCodeExp(name="SPECSTATE", expression="t1.SPECSTATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={@DEDataQueryCodeCond(condition="( t1.PSDEVPRDVERID =  ${srfdatacontext('psdevprdverid','{\"defname\":\"PSDEVPRDVERID\",\"dename\":\"PSDEVPRDSPEC\"}')} )")})})
public class PSDevPrdSpecCurVerDQModel
extends DEDataQueryModelBase {
    public PSDevPrdSpecCurVerDQModel() {
        this.initAnnotation(PSDevPrdSpecCurVerDQModel.class);
    }
}

