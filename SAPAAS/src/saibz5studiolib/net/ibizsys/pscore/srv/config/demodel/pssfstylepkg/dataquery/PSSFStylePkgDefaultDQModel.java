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
package net.ibizsys.pscore.srv.config.demodel.pssfstylepkg.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="23C08A3A-1E34-43DE-B047-D6CF52FB4A9A", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSSFPKGID`, t11.`PSSFPKGNAME`, t1.`PSSFPKGVERID`, t21.`PSSFPKGVERNAME`, t1.`PSSFSTYLEID`, t1.`PSSFSTYLENAME`, t1.`PSSFSTYLEPKGID`, t1.`PSSFSTYLEPKGNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSFSTYLEPKG` t1  LEFT JOIN T_SRFPSSFPKG t11 ON t1.PSSFPKGID = t11.PSSFPKGID  LEFT JOIN T_SRFPSSFPKGVER t21 ON t1.PSSFPKGVERID = t21.PSSFPKGVERID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=3), @DEDataQueryCodeExp(name="PSSFPKGID", expression="t1.`PSSFPKGID`", showorder=4), @DEDataQueryCodeExp(name="PSSFPKGNAME", expression="t11.`PSSFPKGNAME`", showorder=5), @DEDataQueryCodeExp(name="PSSFPKGVERID", expression="t1.`PSSFPKGVERID`", showorder=6), @DEDataQueryCodeExp(name="PSSFPKGVERNAME", expression="t21.`PSSFPKGVERNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSFSTYLEID", expression="t1.`PSSFSTYLEID`", showorder=8), @DEDataQueryCodeExp(name="PSSFSTYLENAME", expression="t1.`PSSFSTYLENAME`", showorder=9), @DEDataQueryCodeExp(name="PSSFSTYLEPKGID", expression="t1.`PSSFSTYLEPKGID`", showorder=10), @DEDataQueryCodeExp(name="PSSFSTYLEPKGNAME", expression="t1.`PSSFSTYLEPKGNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PSSFPKGID, t11.PSSFPKGNAME, t1.PSSFPKGVERID, t21.PSSFPKGVERNAME, t1.PSSFSTYLEID, t1.PSSFSTYLENAME, t1.PSSFSTYLEPKGID, t1.PSSFSTYLEPKGNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSFSTYLEPKG t1  LEFT JOIN T_SRFPSSFPKG t11 ON t1.PSSFPKGID = t11.PSSFPKGID  LEFT JOIN T_SRFPSSFPKGVER t21 ON t1.PSSFPKGVERID = t21.PSSFPKGVERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=3), @DEDataQueryCodeExp(name="PSSFPKGID", expression="t1.PSSFPKGID", showorder=4), @DEDataQueryCodeExp(name="PSSFPKGNAME", expression="t11.PSSFPKGNAME", showorder=5), @DEDataQueryCodeExp(name="PSSFPKGVERID", expression="t1.PSSFPKGVERID", showorder=6), @DEDataQueryCodeExp(name="PSSFPKGVERNAME", expression="t21.PSSFPKGVERNAME", showorder=7), @DEDataQueryCodeExp(name="PSSFSTYLEID", expression="t1.PSSFSTYLEID", showorder=8), @DEDataQueryCodeExp(name="PSSFSTYLENAME", expression="t1.PSSFSTYLENAME", showorder=9), @DEDataQueryCodeExp(name="PSSFSTYLEPKGID", expression="t1.PSSFSTYLEPKGID", showorder=10), @DEDataQueryCodeExp(name="PSSFSTYLEPKGNAME", expression="t1.PSSFSTYLEPKGNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSSFStylePkgDefaultDQModel
extends DEDataQueryModelBase {
    public PSSFStylePkgDefaultDQModel() {
        this.initAnnotation(PSSFStylePkgDefaultDQModel.class);
    }
}

