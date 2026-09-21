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
package net.ibizsys.pscore.srv.paasmgr.demodel.pscoreprdver.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="A5C8F404-9DDA-4748-B711-3FEC775E153B", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEFAULTFLAG`, t1.`MEMO`, t1.`PLANPUBDATE`, t1.`PSCOREPRDFUNCID`, t11.`PSCOREPRDFUNCNAME`, t1.`PSCOREPRDID`, t1.`PSCOREPRDNAME`, t1.`PSCOREPRDVERID`, t1.`PSCOREPRDVERNAME`, t1.`PUBDATE`, t1.`PUBSTATE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VERSN`, t1.`VERTAG`, t1.`VERTAG2`, t1.`VERTYPE` FROM `T_SRFPSCOREPRDVER` t1  LEFT JOIN `T_SRFPSCOREPRDFUNC` t11 ON t1.`PSCOREPRDFUNCID` = t11.`PSCOREPRDFUNCID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DEFAULTFLAG", expression="t1.`DEFAULTFLAG`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PLANPUBDATE", expression="t1.`PLANPUBDATE`", showorder=4), @DEDataQueryCodeExp(name="PSCOREPRDFUNCID", expression="t1.`PSCOREPRDFUNCID`", showorder=5), @DEDataQueryCodeExp(name="PSCOREPRDFUNCNAME", expression="t11.`PSCOREPRDFUNCNAME`", showorder=6), @DEDataQueryCodeExp(name="PSCOREPRDID", expression="t1.`PSCOREPRDID`", showorder=7), @DEDataQueryCodeExp(name="PSCOREPRDNAME", expression="t1.`PSCOREPRDNAME`", showorder=8), @DEDataQueryCodeExp(name="PSCOREPRDVERID", expression="t1.`PSCOREPRDVERID`", showorder=9), @DEDataQueryCodeExp(name="PSCOREPRDVERNAME", expression="t1.`PSCOREPRDVERNAME`", showorder=10), @DEDataQueryCodeExp(name="PUBDATE", expression="t1.`PUBDATE`", showorder=11), @DEDataQueryCodeExp(name="PUBSTATE", expression="t1.`PUBSTATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14), @DEDataQueryCodeExp(name="VERSN", expression="t1.`VERSN`", showorder=15), @DEDataQueryCodeExp(name="VERTAG", expression="t1.`VERTAG`", showorder=16), @DEDataQueryCodeExp(name="VERTAG2", expression="t1.`VERTAG2`", showorder=17), @DEDataQueryCodeExp(name="VERTYPE", expression="t1.`VERTYPE`", showorder=18)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEFAULTFLAG, t1.MEMO, t1.PLANPUBDATE, t1.PSCOREPRDFUNCID, t11.PSCOREPRDFUNCNAME, t1.PSCOREPRDID, t1.PSCOREPRDNAME, t1.PSCOREPRDVERID, t1.PSCOREPRDVERNAME, t1.PUBDATE, t1.PUBSTATE, t1.UPDATEDATE, t1.UPDATEMAN, t1.VERSN, t1.VERTAG, t1.VERTAG2, t1.VERTYPE FROM T_SRFPSCOREPRDVER t1  LEFT JOIN T_SRFPSCOREPRDFUNC t11 ON t1.PSCOREPRDFUNCID = t11.PSCOREPRDFUNCID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DEFAULTFLAG", expression="t1.DEFAULTFLAG", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PLANPUBDATE", expression="t1.PLANPUBDATE", showorder=4), @DEDataQueryCodeExp(name="PSCOREPRDFUNCID", expression="t1.PSCOREPRDFUNCID", showorder=5), @DEDataQueryCodeExp(name="PSCOREPRDFUNCNAME", expression="t11.PSCOREPRDFUNCNAME", showorder=6), @DEDataQueryCodeExp(name="PSCOREPRDID", expression="t1.PSCOREPRDID", showorder=7), @DEDataQueryCodeExp(name="PSCOREPRDNAME", expression="t1.PSCOREPRDNAME", showorder=8), @DEDataQueryCodeExp(name="PSCOREPRDVERID", expression="t1.PSCOREPRDVERID", showorder=9), @DEDataQueryCodeExp(name="PSCOREPRDVERNAME", expression="t1.PSCOREPRDVERNAME", showorder=10), @DEDataQueryCodeExp(name="PUBDATE", expression="t1.PUBDATE", showorder=11), @DEDataQueryCodeExp(name="PUBSTATE", expression="t1.PUBSTATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14), @DEDataQueryCodeExp(name="VERSN", expression="t1.VERSN", showorder=15), @DEDataQueryCodeExp(name="VERTAG", expression="t1.VERTAG", showorder=16), @DEDataQueryCodeExp(name="VERTAG2", expression="t1.VERTAG2", showorder=17), @DEDataQueryCodeExp(name="VERTYPE", expression="t1.VERTYPE", showorder=18)}, conds={})})
public class PSCorePrdVerDefaultDQModel
extends DEDataQueryModelBase {
    public PSCorePrdVerDefaultDQModel() {
        this.initAnnotation(PSCorePrdVerDefaultDQModel.class);
    }
}

