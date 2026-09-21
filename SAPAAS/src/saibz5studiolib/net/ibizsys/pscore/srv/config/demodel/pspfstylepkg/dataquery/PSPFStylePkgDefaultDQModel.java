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
package net.ibizsys.pscore.srv.config.demodel.pspfstylepkg.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="998F962C-45DA-4852-9FDD-59EB651688CD", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSPFPKGID`, t11.`PSPFPKGNAME`, t1.`PSPFPKGVERID`, t21.`PSPFPKGVERNAME`, t1.`PSPFSTYLEID`, t31.`PSPFSTYLENAME`, t1.`PSPFSTYLEPKGID`, t1.`PSPFSTYLEPKGNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSPFSTYLEPKG` t1  LEFT JOIN T_SRFPSPFPKG t11 ON t1.PSPFPKGID = t11.PSPFPKGID  LEFT JOIN T_SRFPSPFPKGVER t21 ON t1.PSPFPKGVERID = t21.PSPFPKGVERID  LEFT JOIN T_SRFPSPFSTYLE t31 ON t1.PSPFSTYLEID = t31.PSPFSTYLEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=3), @DEDataQueryCodeExp(name="PSPFPKGID", expression="t1.`PSPFPKGID`", showorder=4), @DEDataQueryCodeExp(name="PSPFPKGNAME", expression="t11.`PSPFPKGNAME`", showorder=5), @DEDataQueryCodeExp(name="PSPFPKGVERID", expression="t1.`PSPFPKGVERID`", showorder=6), @DEDataQueryCodeExp(name="PSPFPKGVERNAME", expression="t21.`PSPFPKGVERNAME`", showorder=7), @DEDataQueryCodeExp(name="PSPFSTYLEID", expression="t1.`PSPFSTYLEID`", showorder=8), @DEDataQueryCodeExp(name="PSPFSTYLENAME", expression="t31.`PSPFSTYLENAME`", showorder=9), @DEDataQueryCodeExp(name="PSPFSTYLEPKGID", expression="t1.`PSPFSTYLEPKGID`", showorder=10), @DEDataQueryCodeExp(name="PSPFSTYLEPKGNAME", expression="t1.`PSPFSTYLEPKGNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PSPFPKGID, t11.PSPFPKGNAME, t1.PSPFPKGVERID, t21.PSPFPKGVERNAME, t1.PSPFSTYLEID, t31.PSPFSTYLENAME, t1.PSPFSTYLEPKGID, t1.PSPFSTYLEPKGNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSPFSTYLEPKG t1  LEFT JOIN T_SRFPSPFPKG t11 ON t1.PSPFPKGID = t11.PSPFPKGID  LEFT JOIN T_SRFPSPFPKGVER t21 ON t1.PSPFPKGVERID = t21.PSPFPKGVERID  LEFT JOIN T_SRFPSPFSTYLE t31 ON t1.PSPFSTYLEID = t31.PSPFSTYLEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=3), @DEDataQueryCodeExp(name="PSPFPKGID", expression="t1.PSPFPKGID", showorder=4), @DEDataQueryCodeExp(name="PSPFPKGNAME", expression="t11.PSPFPKGNAME", showorder=5), @DEDataQueryCodeExp(name="PSPFPKGVERID", expression="t1.PSPFPKGVERID", showorder=6), @DEDataQueryCodeExp(name="PSPFPKGVERNAME", expression="t21.PSPFPKGVERNAME", showorder=7), @DEDataQueryCodeExp(name="PSPFSTYLEID", expression="t1.PSPFSTYLEID", showorder=8), @DEDataQueryCodeExp(name="PSPFSTYLENAME", expression="t31.PSPFSTYLENAME", showorder=9), @DEDataQueryCodeExp(name="PSPFSTYLEPKGID", expression="t1.PSPFSTYLEPKGID", showorder=10), @DEDataQueryCodeExp(name="PSPFSTYLEPKGNAME", expression="t1.PSPFSTYLEPKGNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSPFStylePkgDefaultDQModel
extends DEDataQueryModelBase {
    public PSPFStylePkgDefaultDQModel() {
        this.initAnnotation(PSPFStylePkgDefaultDQModel.class);
    }
}

