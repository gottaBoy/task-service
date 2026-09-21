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
package net.ibizsys.pscore.srv.def.demodel.psv3mggrid.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="C8795EF7-CDFA-4FDB-9738-7988101B5B8F", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEGRIDID`, t1.`DEID`, t1.`DENAME`, t1.`IGNOREFLAG`, t1.`PSV3MGGRIDID`, t1.`PSV3MGGRIDNAME`, t1.`PSV3MIGRATEID`, t11.`PSV3MIGRATENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSV3MGGRID` t1  LEFT JOIN T_SRFPSV3MIGRATE t11 ON t1.PSV3MIGRATEID = t11.PSV3MIGRATEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DEGRIDID", expression="t1.`DEGRIDID`", showorder=2), @DEDataQueryCodeExp(name="DEID", expression="t1.`DEID`", showorder=3), @DEDataQueryCodeExp(name="DENAME", expression="t1.`DENAME`", showorder=4), @DEDataQueryCodeExp(name="IGNOREFLAG", expression="t1.`IGNOREFLAG`", showorder=5), @DEDataQueryCodeExp(name="PSV3MGGRIDID", expression="t1.`PSV3MGGRIDID`", showorder=6), @DEDataQueryCodeExp(name="PSV3MGGRIDNAME", expression="t1.`PSV3MGGRIDNAME`", showorder=7), @DEDataQueryCodeExp(name="PSV3MIGRATEID", expression="t1.`PSV3MIGRATEID`", showorder=8), @DEDataQueryCodeExp(name="PSV3MIGRATENAME", expression="t11.`PSV3MIGRATENAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEGRIDID, t1.DEID, t1.DENAME, t1.IGNOREFLAG, t1.PSV3MGGRIDID, t1.PSV3MGGRIDNAME, t1.PSV3MIGRATEID, t11.PSV3MIGRATENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSV3MGGRID t1  LEFT JOIN T_SRFPSV3MIGRATE t11 ON t1.PSV3MIGRATEID = t11.PSV3MIGRATEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DEGRIDID", expression="t1.DEGRIDID", showorder=2), @DEDataQueryCodeExp(name="DEID", expression="t1.DEID", showorder=3), @DEDataQueryCodeExp(name="DENAME", expression="t1.DENAME", showorder=4), @DEDataQueryCodeExp(name="IGNOREFLAG", expression="t1.IGNOREFLAG", showorder=5), @DEDataQueryCodeExp(name="PSV3MGGRIDID", expression="t1.PSV3MGGRIDID", showorder=6), @DEDataQueryCodeExp(name="PSV3MGGRIDNAME", expression="t1.PSV3MGGRIDNAME", showorder=7), @DEDataQueryCodeExp(name="PSV3MIGRATEID", expression="t1.PSV3MIGRATEID", showorder=8), @DEDataQueryCodeExp(name="PSV3MIGRATENAME", expression="t11.PSV3MIGRATENAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSV3MGGridDefaultDQModel
extends DEDataQueryModelBase {
    public PSV3MGGridDefaultDQModel() {
        this.initAnnotation(PSV3MGGridDefaultDQModel.class);
    }
}

