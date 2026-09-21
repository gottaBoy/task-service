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
package net.ibizsys.pscore.srv.def.demodel.psv3migratede.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="09B53261-DCCF-4402-A362-13581CB33DCF", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEID`, t1.`PSDEID`, t1.`PSDENAME`, t11.`PSSYSTEMID`, t1.`PSV3MIGRATEDEID`, t1.`PSV3MIGRATEDENAME`, t1.`PSV3MIGRATEID`, t11.`PSV3MIGRATENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSV3MIGRATEDE` t1  LEFT JOIN T_SRFPSV3MIGRATE t11 ON t1.PSV3MIGRATEID = t11.PSV3MIGRATEID  LEFT JOIN T_SRFPSDATAENTITY t21 ON t1.PSDEID = t21.PSDATAENTITYID  LEFT JOIN T_SRFPSSYSTEM t31 ON t21.PSSYSTEMID = t31.PSSYSTEMID  LEFT JOIN T_SRFPSSF t41 ON t31.PSSFID = t41.PSSFID  LEFT JOIN T_SRFPSMODULE t51 ON t21.PSMODULEID = t51.PSMODULEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DEID", expression="t1.`DEID`", showorder=2), @DEDataQueryCodeExp(name="PSDEID", expression="t1.`PSDEID`", showorder=3), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.`PSDENAME`", showorder=4), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t11.`PSSYSTEMID`", showorder=5), @DEDataQueryCodeExp(name="PSV3MIGRATEDEID", expression="t1.`PSV3MIGRATEDEID`", showorder=6), @DEDataQueryCodeExp(name="PSV3MIGRATEDENAME", expression="t1.`PSV3MIGRATEDENAME`", showorder=7), @DEDataQueryCodeExp(name="PSV3MIGRATEID", expression="t1.`PSV3MIGRATEID`", showorder=8), @DEDataQueryCodeExp(name="PSV3MIGRATENAME", expression="t11.`PSV3MIGRATENAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={@DEDataQueryCodeCond(condition="( t41.`MEMO` <> 'ddd' )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEID, t1.PSDEID, t1.PSDENAME, t11.PSSYSTEMID, t1.PSV3MIGRATEDEID, t1.PSV3MIGRATEDENAME, t1.PSV3MIGRATEID, t11.PSV3MIGRATENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSV3MIGRATEDE t1  LEFT JOIN T_SRFPSV3MIGRATE t11 ON t1.PSV3MIGRATEID = t11.PSV3MIGRATEID  LEFT JOIN T_SRFPSDATAENTITY t21 ON t1.PSDEID = t21.PSDATAENTITYID  LEFT JOIN T_SRFPSSYSTEM t31 ON t21.PSSYSTEMID = t31.PSSYSTEMID  LEFT JOIN T_SRFPSSF t41 ON t31.PSSFID = t41.PSSFID  LEFT JOIN T_SRFPSMODULE t51 ON t21.PSMODULEID = t51.PSMODULEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DEID", expression="t1.DEID", showorder=2), @DEDataQueryCodeExp(name="PSDEID", expression="t1.PSDEID", showorder=3), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.PSDENAME", showorder=4), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t11.PSSYSTEMID", showorder=5), @DEDataQueryCodeExp(name="PSV3MIGRATEDEID", expression="t1.PSV3MIGRATEDEID", showorder=6), @DEDataQueryCodeExp(name="PSV3MIGRATEDENAME", expression="t1.PSV3MIGRATEDENAME", showorder=7), @DEDataQueryCodeExp(name="PSV3MIGRATEID", expression="t1.PSV3MIGRATEID", showorder=8), @DEDataQueryCodeExp(name="PSV3MIGRATENAME", expression="t11.PSV3MIGRATENAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={@DEDataQueryCodeCond(condition="( t41.MEMO <> 'ddd' )")})})
public class PSV3MigrateDEDefaultDQModel
extends DEDataQueryModelBase {
    public PSV3MigrateDEDefaultDQModel() {
        this.initAnnotation(PSV3MigrateDEDefaultDQModel.class);
    }
}

