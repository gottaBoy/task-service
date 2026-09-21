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
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevprdsyssync.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="385D3885-29D9-42D5-B85D-52443071F94F", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DSTPSDEVPRDSYSID`, t11.`PSDEVPRDSYSNAME` AS `DSTPSDEVPRDSYSNAME`, t1.`MEMO`, t1.`PSDEVPRDID`, t21.`PSDEVPRDNAME`, t1.`PSDEVPRDSYSSYNCID`, t1.`PSDEVPRDSYSSYNCNAME`, t1.`SRCPSDEVPRDSYSID`, t31.`PSDEVPRDSYSNAME` AS `SRCPSDEVPRDSYSNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVPRDSYSSYNC` t1  LEFT JOIN T_SRFPSDEVPRDSYS t11 ON t1.DSTPSDEVPRDSYSID = t11.PSDEVPRDSYSID  LEFT JOIN T_SRFPSDEVPRD t21 ON t1.PSDEVPRDID = t21.PSDEVPRDID  LEFT JOIN T_SRFPSDEVPRDSYS t31 ON t1.SRCPSDEVPRDSYSID = t31.PSDEVPRDSYSID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DSTPSDEVPRDSYSID", expression="t1.`DSTPSDEVPRDSYSID`", showorder=2), @DEDataQueryCodeExp(name="DSTPSDEVPRDSYSNAME", expression="t11.`PSDEVPRDSYSNAME`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSDEVPRDID", expression="t1.`PSDEVPRDID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVPRDNAME", expression="t21.`PSDEVPRDNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEVPRDSYSSYNCID", expression="t1.`PSDEVPRDSYSSYNCID`", showorder=7), @DEDataQueryCodeExp(name="PSDEVPRDSYSSYNCNAME", expression="t1.`PSDEVPRDSYSSYNCNAME`", showorder=8), @DEDataQueryCodeExp(name="SRCPSDEVPRDSYSID", expression="t1.`SRCPSDEVPRDSYSID`", showorder=9), @DEDataQueryCodeExp(name="SRCPSDEVPRDSYSNAME", expression="t31.`PSDEVPRDSYSNAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DSTPSDEVPRDSYSID, t11.PSDEVPRDSYSNAME AS DSTPSDEVPRDSYSNAME, t1.MEMO, t1.PSDEVPRDID, t21.PSDEVPRDNAME, t1.PSDEVPRDSYSSYNCID, t1.PSDEVPRDSYSSYNCNAME, t1.SRCPSDEVPRDSYSID, t31.PSDEVPRDSYSNAME AS SRCPSDEVPRDSYSNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVPRDSYSSYNC t1  LEFT JOIN T_SRFPSDEVPRDSYS t11 ON t1.DSTPSDEVPRDSYSID = t11.PSDEVPRDSYSID  LEFT JOIN T_SRFPSDEVPRD t21 ON t1.PSDEVPRDID = t21.PSDEVPRDID  LEFT JOIN T_SRFPSDEVPRDSYS t31 ON t1.SRCPSDEVPRDSYSID = t31.PSDEVPRDSYSID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DSTPSDEVPRDSYSID", expression="t1.DSTPSDEVPRDSYSID", showorder=2), @DEDataQueryCodeExp(name="DSTPSDEVPRDSYSNAME", expression="t11.PSDEVPRDSYSNAME", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSDEVPRDID", expression="t1.PSDEVPRDID", showorder=5), @DEDataQueryCodeExp(name="PSDEVPRDNAME", expression="t21.PSDEVPRDNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEVPRDSYSSYNCID", expression="t1.PSDEVPRDSYSSYNCID", showorder=7), @DEDataQueryCodeExp(name="PSDEVPRDSYSSYNCNAME", expression="t1.PSDEVPRDSYSSYNCNAME", showorder=8), @DEDataQueryCodeExp(name="SRCPSDEVPRDSYSID", expression="t1.SRCPSDEVPRDSYSID", showorder=9), @DEDataQueryCodeExp(name="SRCPSDEVPRDSYSNAME", expression="t31.PSDEVPRDSYSNAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSDevPrdSysSyncDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevPrdSysSyncDefaultDQModel() {
        this.initAnnotation(PSDevPrdSysSyncDefaultDQModel.class);
    }
}

