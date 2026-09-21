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
package net.ibizsys.pscore.srv.paasmgr.demodel.pscoreprdissue.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="CAD401EA-C31E-4724-8E93-48A292543B8B", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ISSUESN`, t1.`ISSUESTATE`, t1.`ISSUETAG`, t1.`ISSUETAG2`, t1.`ISSUEURL`, t1.`MEMO`, t1.`PSCOREPRDID`, t1.`PSCOREPRDISSUEID`, t1.`PSCOREPRDISSUENAME`, t1.`PSCOREPRDNAME`, t1.`PSCOREPRDVERID`, t1.`PSCOREPRDVERNAME`, t1.`REFPSCOREPRDISSUEID`, t11.`PSCOREPRDISSUENAME` AS `REFPSCOREPRDISSUENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSCOREPRDISSUE` t1  LEFT JOIN T_SRFPSCOREPRDISSUE t11 ON t1.REFPSCOREPRDISSUEID = t11.PSCOREPRDISSUEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ISSUESN", expression="t1.`ISSUESN`", showorder=2), @DEDataQueryCodeExp(name="ISSUESTATE", expression="t1.`ISSUESTATE`", showorder=3), @DEDataQueryCodeExp(name="ISSUETAG", expression="t1.`ISSUETAG`", showorder=4), @DEDataQueryCodeExp(name="ISSUETAG2", expression="t1.`ISSUETAG2`", showorder=5), @DEDataQueryCodeExp(name="ISSUEURL", expression="t1.`ISSUEURL`", showorder=6), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=7), @DEDataQueryCodeExp(name="PSCOREPRDID", expression="t1.`PSCOREPRDID`", showorder=8), @DEDataQueryCodeExp(name="PSCOREPRDISSUEID", expression="t1.`PSCOREPRDISSUEID`", showorder=9), @DEDataQueryCodeExp(name="PSCOREPRDISSUENAME", expression="t1.`PSCOREPRDISSUENAME`", showorder=10), @DEDataQueryCodeExp(name="PSCOREPRDNAME", expression="t1.`PSCOREPRDNAME`", showorder=11), @DEDataQueryCodeExp(name="PSCOREPRDVERID", expression="t1.`PSCOREPRDVERID`", showorder=12), @DEDataQueryCodeExp(name="PSCOREPRDVERNAME", expression="t1.`PSCOREPRDVERNAME`", showorder=13), @DEDataQueryCodeExp(name="REFPSCOREPRDISSUEID", expression="t1.`REFPSCOREPRDISSUEID`", showorder=14), @DEDataQueryCodeExp(name="REFPSCOREPRDISSUENAME", expression="t11.`PSCOREPRDISSUENAME`", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=17)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ISSUESN, t1.ISSUESTATE, t1.ISSUETAG, t1.ISSUETAG2, t1.ISSUEURL, t1.MEMO, t1.PSCOREPRDID, t1.PSCOREPRDISSUEID, t1.PSCOREPRDISSUENAME, t1.PSCOREPRDNAME, t1.PSCOREPRDVERID, t1.PSCOREPRDVERNAME, t1.REFPSCOREPRDISSUEID, t11.PSCOREPRDISSUENAME AS REFPSCOREPRDISSUENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSCOREPRDISSUE t1  LEFT JOIN T_SRFPSCOREPRDISSUE t11 ON t1.REFPSCOREPRDISSUEID = t11.PSCOREPRDISSUEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ISSUESN", expression="t1.ISSUESN", showorder=2), @DEDataQueryCodeExp(name="ISSUESTATE", expression="t1.ISSUESTATE", showorder=3), @DEDataQueryCodeExp(name="ISSUETAG", expression="t1.ISSUETAG", showorder=4), @DEDataQueryCodeExp(name="ISSUETAG2", expression="t1.ISSUETAG2", showorder=5), @DEDataQueryCodeExp(name="ISSUEURL", expression="t1.ISSUEURL", showorder=6), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=7), @DEDataQueryCodeExp(name="PSCOREPRDID", expression="t1.PSCOREPRDID", showorder=8), @DEDataQueryCodeExp(name="PSCOREPRDISSUEID", expression="t1.PSCOREPRDISSUEID", showorder=9), @DEDataQueryCodeExp(name="PSCOREPRDISSUENAME", expression="t1.PSCOREPRDISSUENAME", showorder=10), @DEDataQueryCodeExp(name="PSCOREPRDNAME", expression="t1.PSCOREPRDNAME", showorder=11), @DEDataQueryCodeExp(name="PSCOREPRDVERID", expression="t1.PSCOREPRDVERID", showorder=12), @DEDataQueryCodeExp(name="PSCOREPRDVERNAME", expression="t1.PSCOREPRDVERNAME", showorder=13), @DEDataQueryCodeExp(name="REFPSCOREPRDISSUEID", expression="t1.REFPSCOREPRDISSUEID", showorder=14), @DEDataQueryCodeExp(name="REFPSCOREPRDISSUENAME", expression="t11.PSCOREPRDISSUENAME", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=17)}, conds={})})
public class PSCorePrdIssueDefaultDQModel
extends DEDataQueryModelBase {
    public PSCorePrdIssueDefaultDQModel() {
        this.initAnnotation(PSCorePrdIssueDefaultDQModel.class);
    }
}

