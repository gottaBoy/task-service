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
package net.ibizsys.pscore.srv.paasmgr.demodel.pscpvfunc.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="C31406AF-C6B3-4802-B526-BE2C497570F2", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`FUNCSN`, t1.`MEMO`, t1.`PSCOREPRDFUNCID`, t1.`PSCOREPRDFUNCNAME`, t1.`PSCOREPRDVERID`, t1.`PSCOREPRDVERNAME`, t1.`PSCPVFUNCID`, t1.`PSCPVFUNCNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSCPVFUNC` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="FUNCSN", expression="t1.`FUNCSN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSCOREPRDFUNCID", expression="t1.`PSCOREPRDFUNCID`", showorder=4), @DEDataQueryCodeExp(name="PSCOREPRDFUNCNAME", expression="t1.`PSCOREPRDFUNCNAME`", showorder=5), @DEDataQueryCodeExp(name="PSCOREPRDVERID", expression="t1.`PSCOREPRDVERID`", showorder=6), @DEDataQueryCodeExp(name="PSCOREPRDVERNAME", expression="t1.`PSCOREPRDVERNAME`", showorder=7), @DEDataQueryCodeExp(name="PSCPVFUNCID", expression="t1.`PSCPVFUNCID`", showorder=8), @DEDataQueryCodeExp(name="PSCPVFUNCNAME", expression="t1.`PSCPVFUNCNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.FUNCSN, t1.MEMO, t1.PSCOREPRDFUNCID, t1.PSCOREPRDFUNCNAME, t1.PSCOREPRDVERID, t1.PSCOREPRDVERNAME, t1.PSCPVFUNCID, t1.PSCPVFUNCNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSCPVFUNC t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="FUNCSN", expression="t1.FUNCSN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSCOREPRDFUNCID", expression="t1.PSCOREPRDFUNCID", showorder=4), @DEDataQueryCodeExp(name="PSCOREPRDFUNCNAME", expression="t1.PSCOREPRDFUNCNAME", showorder=5), @DEDataQueryCodeExp(name="PSCOREPRDVERID", expression="t1.PSCOREPRDVERID", showorder=6), @DEDataQueryCodeExp(name="PSCOREPRDVERNAME", expression="t1.PSCOREPRDVERNAME", showorder=7), @DEDataQueryCodeExp(name="PSCPVFUNCID", expression="t1.PSCPVFUNCID", showorder=8), @DEDataQueryCodeExp(name="PSCPVFUNCNAME", expression="t1.PSCPVFUNCNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSCPVFuncDefaultDQModel
extends DEDataQueryModelBase {
    public PSCPVFuncDefaultDQModel() {
        this.initAnnotation(PSCPVFuncDefaultDQModel.class);
    }
}

