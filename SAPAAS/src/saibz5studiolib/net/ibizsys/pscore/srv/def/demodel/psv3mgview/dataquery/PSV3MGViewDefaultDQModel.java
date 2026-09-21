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
package net.ibizsys.pscore.srv.def.demodel.psv3mgview.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="4A92BB3B-E9EE-4547-A485-588F942EFC06", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSV3MGVIEWID`, t1.`PSV3MGVIEWNAME`, t1.`PSV3MIGRATEID`, t11.`PSV3MIGRATENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSV3MGVIEW` t1  LEFT JOIN T_SRFPSV3MIGRATE t11 ON t1.PSV3MIGRATEID = t11.PSV3MIGRATEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSV3MGVIEWID", expression="t1.`PSV3MGVIEWID`", showorder=2), @DEDataQueryCodeExp(name="PSV3MGVIEWNAME", expression="t1.`PSV3MGVIEWNAME`", showorder=3), @DEDataQueryCodeExp(name="PSV3MIGRATEID", expression="t1.`PSV3MIGRATEID`", showorder=4), @DEDataQueryCodeExp(name="PSV3MIGRATENAME", expression="t11.`PSV3MIGRATENAME`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSV3MGVIEWID, t1.PSV3MGVIEWNAME, t1.PSV3MIGRATEID, t11.PSV3MIGRATENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSV3MGVIEW t1  LEFT JOIN T_SRFPSV3MIGRATE t11 ON t1.PSV3MIGRATEID = t11.PSV3MIGRATEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSV3MGVIEWID", expression="t1.PSV3MGVIEWID", showorder=2), @DEDataQueryCodeExp(name="PSV3MGVIEWNAME", expression="t1.PSV3MGVIEWNAME", showorder=3), @DEDataQueryCodeExp(name="PSV3MIGRATEID", expression="t1.PSV3MIGRATEID", showorder=4), @DEDataQueryCodeExp(name="PSV3MIGRATENAME", expression="t11.PSV3MIGRATENAME", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7)}, conds={})})
public class PSV3MGViewDefaultDQModel
extends DEDataQueryModelBase {
    public PSV3MGViewDefaultDQModel() {
        this.initAnnotation(PSV3MGViewDefaultDQModel.class);
    }
}

