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
package net.ibizsys.pscore.srv.config.demodel.pssfpubojb.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="0D23A8C8-C836-4768-BCF4-3EE2E2C1DAF1", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MACROPARAMS`, t1.`MEMO`, t1.`PPSSFPUBOBJID`, t1.`PPSSFPUBOBJNAME`, t1.`PSSFID`, t1.`PSSFNAME`, t1.`PSSFPUBOBJID`, t1.`PSSFPUBOBJNAME`, t1.`PSSFSTYLEID`, t1.`PSSFSTYLENAME`, t1.`PUBOBJ`, t1.`PUBOBJTAG`, t1.`PUBOBJTAG2`, t1.`TARGET`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSSFPUBOBJ` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MACROPARAMS", expression="t1.`MACROPARAMS`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PPSSFPUBOBJID", expression="t1.`PPSSFPUBOBJID`", showorder=4), @DEDataQueryCodeExp(name="PPSSFPUBOBJNAME", expression="t1.`PPSSFPUBOBJNAME`", showorder=5), @DEDataQueryCodeExp(name="PSSFID", expression="t1.`PSSFID`", showorder=6), @DEDataQueryCodeExp(name="PSSFNAME", expression="t1.`PSSFNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSFPUBOBJID", expression="t1.`PSSFPUBOBJID`", showorder=8), @DEDataQueryCodeExp(name="PSSFPUBOBJNAME", expression="t1.`PSSFPUBOBJNAME`", showorder=9), @DEDataQueryCodeExp(name="PSSFSTYLEID", expression="t1.`PSSFSTYLEID`", showorder=10), @DEDataQueryCodeExp(name="PSSFSTYLENAME", expression="t1.`PSSFSTYLENAME`", showorder=11), @DEDataQueryCodeExp(name="PUBOBJ", expression="t1.`PUBOBJ`", showorder=12), @DEDataQueryCodeExp(name="PUBOBJTAG", expression="t1.`PUBOBJTAG`", showorder=13), @DEDataQueryCodeExp(name="PUBOBJTAG2", expression="t1.`PUBOBJTAG2`", showorder=14), @DEDataQueryCodeExp(name="TARGET", expression="t1.`TARGET`", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=18)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MACROPARAMS, t1.MEMO, t1.PPSSFPUBOBJID, t1.PPSSFPUBOBJNAME, t1.PSSFID, t1.PSSFNAME, t1.PSSFPUBOBJID, t1.PSSFPUBOBJNAME, t1.PSSFSTYLEID, t1.PSSFSTYLENAME, t1.PUBOBJ, t1.PUBOBJTAG, t1.PUBOBJTAG2, t1.TARGET, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSSFPUBOBJ t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MACROPARAMS", expression="t1.MACROPARAMS", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PPSSFPUBOBJID", expression="t1.PPSSFPUBOBJID", showorder=4), @DEDataQueryCodeExp(name="PPSSFPUBOBJNAME", expression="t1.PPSSFPUBOBJNAME", showorder=5), @DEDataQueryCodeExp(name="PSSFID", expression="t1.PSSFID", showorder=6), @DEDataQueryCodeExp(name="PSSFNAME", expression="t1.PSSFNAME", showorder=7), @DEDataQueryCodeExp(name="PSSFPUBOBJID", expression="t1.PSSFPUBOBJID", showorder=8), @DEDataQueryCodeExp(name="PSSFPUBOBJNAME", expression="t1.PSSFPUBOBJNAME", showorder=9), @DEDataQueryCodeExp(name="PSSFSTYLEID", expression="t1.PSSFSTYLEID", showorder=10), @DEDataQueryCodeExp(name="PSSFSTYLENAME", expression="t1.PSSFSTYLENAME", showorder=11), @DEDataQueryCodeExp(name="PUBOBJ", expression="t1.PUBOBJ", showorder=12), @DEDataQueryCodeExp(name="PUBOBJTAG", expression="t1.PUBOBJTAG", showorder=13), @DEDataQueryCodeExp(name="PUBOBJTAG2", expression="t1.PUBOBJTAG2", showorder=14), @DEDataQueryCodeExp(name="TARGET", expression="t1.TARGET", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=18)}, conds={})})
public class PSSFPubOjbDefaultDQModel
extends DEDataQueryModelBase {
    public PSSFPubOjbDefaultDQModel() {
        this.initAnnotation(PSSFPubOjbDefaultDQModel.class);
    }
}

