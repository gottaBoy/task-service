/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevprdspecplan.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="5BACDFD5-1AA0-462B-9A77-E2AE0B2CACD4", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PLANSTATE`, t1.`PSDEVPRDSPECID`, t11.`PSDEVPRDSPECNAME`, t1.`PSDEVPRDSPECPLANID`, t1.`PSDEVPRDSPECPLANNAME`, t1.`PSDEVPRDSUBVERID`, t21.`PSDEVPRDSUBVERNAME`, t1.`PSDEVPRDVERID`, t1.`PSDEVPRDVERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVPRDSPECPLAN` t1  LEFT JOIN T_SRFPSDEVPRDSPEC t11 ON t1.PSDEVPRDSPECID = t11.PSDEVPRDSPECID  LEFT JOIN T_SRFPSDEVPRDSUBVER t21 ON t1.PSDEVPRDSUBVERID = t21.PSDEVPRDSUBVERID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=3), @DEDataQueryCodeExp(name="PLANSTATE", expression="t1.`PLANSTATE`", showorder=4), @DEDataQueryCodeExp(name="PSDEVPRDSPECID", expression="t1.`PSDEVPRDSPECID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVPRDSPECNAME", expression="t11.`PSDEVPRDSPECNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEVPRDSPECPLANID", expression="t1.`PSDEVPRDSPECPLANID`", showorder=7), @DEDataQueryCodeExp(name="PSDEVPRDSPECPLANNAME", expression="t1.`PSDEVPRDSPECPLANNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDEVPRDSUBVERID", expression="t1.`PSDEVPRDSUBVERID`", showorder=9), @DEDataQueryCodeExp(name="PSDEVPRDSUBVERNAME", expression="t21.`PSDEVPRDSUBVERNAME`", showorder=10), @DEDataQueryCodeExp(name="PSDEVPRDVERID", expression="t1.`PSDEVPRDVERID`", showorder=11), @DEDataQueryCodeExp(name="PSDEVPRDVERNAME", expression="t1.`PSDEVPRDVERNAME`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PLANSTATE, t1.PSDEVPRDSPECID, t11.PSDEVPRDSPECNAME, t1.PSDEVPRDSPECPLANID, t1.PSDEVPRDSPECPLANNAME, t1.PSDEVPRDSUBVERID, t21.PSDEVPRDSUBVERNAME, t1.PSDEVPRDVERID, t1.PSDEVPRDVERNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVPRDSPECPLAN t1  LEFT JOIN T_SRFPSDEVPRDSPEC t11 ON t1.PSDEVPRDSPECID = t11.PSDEVPRDSPECID  LEFT JOIN T_SRFPSDEVPRDSUBVER t21 ON t1.PSDEVPRDSUBVERID = t21.PSDEVPRDSUBVERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=3), @DEDataQueryCodeExp(name="PLANSTATE", expression="t1.PLANSTATE", showorder=4), @DEDataQueryCodeExp(name="PSDEVPRDSPECID", expression="t1.PSDEVPRDSPECID", showorder=5), @DEDataQueryCodeExp(name="PSDEVPRDSPECNAME", expression="t11.PSDEVPRDSPECNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEVPRDSPECPLANID", expression="t1.PSDEVPRDSPECPLANID", showorder=7), @DEDataQueryCodeExp(name="PSDEVPRDSPECPLANNAME", expression="t1.PSDEVPRDSPECPLANNAME", showorder=8), @DEDataQueryCodeExp(name="PSDEVPRDSUBVERID", expression="t1.PSDEVPRDSUBVERID", showorder=9), @DEDataQueryCodeExp(name="PSDEVPRDSUBVERNAME", expression="t21.PSDEVPRDSUBVERNAME", showorder=10), @DEDataQueryCodeExp(name="PSDEVPRDVERID", expression="t1.PSDEVPRDVERID", showorder=11), @DEDataQueryCodeExp(name="PSDEVPRDVERNAME", expression="t1.PSDEVPRDVERNAME", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14)}, conds={})})
public class PSDevPrdSpecPlanDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevPrdSpecPlanDefaultDQModel() {
        this.initAnnotation(PSDevPrdSpecPlanDefaultDQModel.class);
    }
}

