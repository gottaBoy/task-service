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
package net.ibizsys.pscore.srv.paasmgr.demodel.pscpvissue.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="5EB715BC-F710-427F-9162-D8D311929506", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ISSUESN`, t1.`MEMO`, t1.`PSCOREPRDISSUEID`, t1.`PSCOREPRDISSUENAME`, t1.`PSCOREPRDVERID`, t1.`PSCOREPRDVERNAME`, t1.`PSCPVISSUEID`, t1.`PSCPVISSUENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSCPVISSUE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ISSUESN", expression="t1.`ISSUESN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSCOREPRDISSUEID", expression="t1.`PSCOREPRDISSUEID`", showorder=4), @DEDataQueryCodeExp(name="PSCOREPRDISSUENAME", expression="t1.`PSCOREPRDISSUENAME`", showorder=5), @DEDataQueryCodeExp(name="PSCOREPRDVERID", expression="t1.`PSCOREPRDVERID`", showorder=6), @DEDataQueryCodeExp(name="PSCOREPRDVERNAME", expression="t1.`PSCOREPRDVERNAME`", showorder=7), @DEDataQueryCodeExp(name="PSCPVISSUEID", expression="t1.`PSCPVISSUEID`", showorder=8), @DEDataQueryCodeExp(name="PSCPVISSUENAME", expression="t1.`PSCPVISSUENAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ISSUESN, t1.MEMO, t1.PSCOREPRDISSUEID, t1.PSCOREPRDISSUENAME, t1.PSCOREPRDVERID, t1.PSCOREPRDVERNAME, t1.PSCPVISSUEID, t1.PSCPVISSUENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSCPVISSUE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ISSUESN", expression="t1.ISSUESN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSCOREPRDISSUEID", expression="t1.PSCOREPRDISSUEID", showorder=4), @DEDataQueryCodeExp(name="PSCOREPRDISSUENAME", expression="t1.PSCOREPRDISSUENAME", showorder=5), @DEDataQueryCodeExp(name="PSCOREPRDVERID", expression="t1.PSCOREPRDVERID", showorder=6), @DEDataQueryCodeExp(name="PSCOREPRDVERNAME", expression="t1.PSCOREPRDVERNAME", showorder=7), @DEDataQueryCodeExp(name="PSCPVISSUEID", expression="t1.PSCPVISSUEID", showorder=8), @DEDataQueryCodeExp(name="PSCPVISSUENAME", expression="t1.PSCPVISSUENAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSCPVIssueDefaultDQModel
extends DEDataQueryModelBase {
    public PSCPVIssueDefaultDQModel() {
        this.initAnnotation(PSCPVIssueDefaultDQModel.class);
    }
}

