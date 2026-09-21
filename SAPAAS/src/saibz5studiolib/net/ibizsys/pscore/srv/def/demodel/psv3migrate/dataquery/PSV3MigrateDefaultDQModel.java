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
package net.ibizsys.pscore.srv.def.demodel.psv3migrate.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="2EF9D1F1-F13F-49B9-8F49-4AA2471BF9AE", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEIDPREFIX`, t1.`DENAMEPREFIX`, t1.`MEMO`, t1.`PSMODULEID`, t11.`PSMODULENAME`, t1.`PSSYSTEMID`, t21.`PSSYSTEMNAME`, t1.`PSV3MIGRATEID`, t1.`PSV3MIGRATENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSV3MIGRATE` t1  LEFT JOIN T_SRFPSMODULE t11 ON t1.PSMODULEID = t11.PSMODULEID  LEFT JOIN T_SRFPSSYSTEM t21 ON t1.PSSYSTEMID = t21.PSSYSTEMID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="EXCLUDEIDS", expression="t1.`EXCLUDEIDS`", showorder=-1), @DEDataQueryCodeExp(name="EXCLUDENAMES", expression="t1.`EXCLUDENAMES`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DEIDPREFIX", expression="t1.`DEIDPREFIX`", showorder=2), @DEDataQueryCodeExp(name="DENAMEPREFIX", expression="t1.`DENAMEPREFIX`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSMODULEID", expression="t1.`PSMODULEID`", showorder=5), @DEDataQueryCodeExp(name="PSMODULENAME", expression="t11.`PSMODULENAME`", showorder=6), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=7), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t21.`PSSYSTEMNAME`", showorder=8), @DEDataQueryCodeExp(name="PSV3MIGRATEID", expression="t1.`PSV3MIGRATEID`", showorder=9), @DEDataQueryCodeExp(name="PSV3MIGRATENAME", expression="t1.`PSV3MIGRATENAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEIDPREFIX, t1.DENAMEPREFIX, t1.MEMO, t1.PSMODULEID, t11.PSMODULENAME, t1.PSSYSTEMID, t21.PSSYSTEMNAME, t1.PSV3MIGRATEID, t1.PSV3MIGRATENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSV3MIGRATE t1  LEFT JOIN T_SRFPSMODULE t11 ON t1.PSMODULEID = t11.PSMODULEID  LEFT JOIN T_SRFPSSYSTEM t21 ON t1.PSSYSTEMID = t21.PSSYSTEMID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="EXCLUDEIDS", expression="t1.EXCLUDEIDS", showorder=-1), @DEDataQueryCodeExp(name="EXCLUDENAMES", expression="t1.EXCLUDENAMES", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DEIDPREFIX", expression="t1.DEIDPREFIX", showorder=2), @DEDataQueryCodeExp(name="DENAMEPREFIX", expression="t1.DENAMEPREFIX", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSMODULEID", expression="t1.PSMODULEID", showorder=5), @DEDataQueryCodeExp(name="PSMODULENAME", expression="t11.PSMODULENAME", showorder=6), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=7), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t21.PSSYSTEMNAME", showorder=8), @DEDataQueryCodeExp(name="PSV3MIGRATEID", expression="t1.PSV3MIGRATEID", showorder=9), @DEDataQueryCodeExp(name="PSV3MIGRATENAME", expression="t1.PSV3MIGRATENAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSV3MigrateDefaultDQModel
extends DEDataQueryModelBase {
    public PSV3MigrateDefaultDQModel() {
        this.initAnnotation(PSV3MigrateDefaultDQModel.class);
    }
}

