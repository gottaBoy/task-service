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
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevprdissueplan.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="56F01FC6-F36F-40CD-8DBB-8ED7D369278D", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PLANSTATE`, t1.`PSDEVPRDISSUEID`, t11.`PSDEVPRDISSUENAME`, t1.`PSDEVPRDISSUEPLANID`, t1.`PSDEVPRDISSUEPLANNAME`, t1.`PSDEVPRDSUBVERID`, t21.`PSDEVPRDSUBVERNAME`, t1.`PSDEVPRDVERID`, t1.`PSDEVPRDVERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVPRDISSUEPLAN` t1  LEFT JOIN T_SRFPSDEVPRDISSUE t11 ON t1.PSDEVPRDISSUEID = t11.PSDEVPRDISSUEID  LEFT JOIN T_SRFPSDEVPRDSUBVER t21 ON t1.PSDEVPRDSUBVERID = t21.PSDEVPRDSUBVERID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=3), @DEDataQueryCodeExp(name="PLANSTATE", expression="t1.`PLANSTATE`", showorder=4), @DEDataQueryCodeExp(name="PSDEVPRDISSUEID", expression="t1.`PSDEVPRDISSUEID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVPRDISSUENAME", expression="t11.`PSDEVPRDISSUENAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEVPRDISSUEPLANID", expression="t1.`PSDEVPRDISSUEPLANID`", showorder=7), @DEDataQueryCodeExp(name="PSDEVPRDISSUEPLANNAME", expression="t1.`PSDEVPRDISSUEPLANNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDEVPRDSUBVERID", expression="t1.`PSDEVPRDSUBVERID`", showorder=9), @DEDataQueryCodeExp(name="PSDEVPRDSUBVERNAME", expression="t21.`PSDEVPRDSUBVERNAME`", showorder=10), @DEDataQueryCodeExp(name="PSDEVPRDVERID", expression="t1.`PSDEVPRDVERID`", showorder=11), @DEDataQueryCodeExp(name="PSDEVPRDVERNAME", expression="t1.`PSDEVPRDVERNAME`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PLANSTATE, t1.PSDEVPRDISSUEID, t11.PSDEVPRDISSUENAME, t1.PSDEVPRDISSUEPLANID, t1.PSDEVPRDISSUEPLANNAME, t1.PSDEVPRDSUBVERID, t21.PSDEVPRDSUBVERNAME, t1.PSDEVPRDVERID, t1.PSDEVPRDVERNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVPRDISSUEPLAN t1  LEFT JOIN T_SRFPSDEVPRDISSUE t11 ON t1.PSDEVPRDISSUEID = t11.PSDEVPRDISSUEID  LEFT JOIN T_SRFPSDEVPRDSUBVER t21 ON t1.PSDEVPRDSUBVERID = t21.PSDEVPRDSUBVERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=3), @DEDataQueryCodeExp(name="PLANSTATE", expression="t1.PLANSTATE", showorder=4), @DEDataQueryCodeExp(name="PSDEVPRDISSUEID", expression="t1.PSDEVPRDISSUEID", showorder=5), @DEDataQueryCodeExp(name="PSDEVPRDISSUENAME", expression="t11.PSDEVPRDISSUENAME", showorder=6), @DEDataQueryCodeExp(name="PSDEVPRDISSUEPLANID", expression="t1.PSDEVPRDISSUEPLANID", showorder=7), @DEDataQueryCodeExp(name="PSDEVPRDISSUEPLANNAME", expression="t1.PSDEVPRDISSUEPLANNAME", showorder=8), @DEDataQueryCodeExp(name="PSDEVPRDSUBVERID", expression="t1.PSDEVPRDSUBVERID", showorder=9), @DEDataQueryCodeExp(name="PSDEVPRDSUBVERNAME", expression="t21.PSDEVPRDSUBVERNAME", showorder=10), @DEDataQueryCodeExp(name="PSDEVPRDVERID", expression="t1.PSDEVPRDVERID", showorder=11), @DEDataQueryCodeExp(name="PSDEVPRDVERNAME", expression="t1.PSDEVPRDVERNAME", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14)}, conds={})})
public class PSDevPrdIssuePlanDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevPrdIssuePlanDefaultDQModel() {
        this.initAnnotation(PSDevPrdIssuePlanDefaultDQModel.class);
    }
}

