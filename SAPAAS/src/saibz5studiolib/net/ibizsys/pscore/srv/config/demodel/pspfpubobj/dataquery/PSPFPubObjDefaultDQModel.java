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
package net.ibizsys.pscore.srv.config.demodel.pspfpubobj.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="E0C771A9-61AA-4A3F-A09E-8057D630B020", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MACROPARAMS`, t1.`MEMO`, t1.`PPSPFPUBOBJID`, t1.`PPSPFPUBOBJNAME`, t1.`PSPFID`, t1.`PSPFNAME`, t1.`PSPFPUBOBJID`, t1.`PSPFPUBOBJNAME`, t1.`PSPFSTYLEID`, t1.`PSPFSTYLENAME`, t1.`PUBOBJ`, t1.`PUBOBJTAG`, t1.`PUBOBJTAG2`, t1.`TARGET`, t1.`TARGETTYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSPFPUBOBJ` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MACROPARAMS", expression="t1.`MACROPARAMS`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PPSPFPUBOBJID", expression="t1.`PPSPFPUBOBJID`", showorder=4), @DEDataQueryCodeExp(name="PPSPFPUBOBJNAME", expression="t1.`PPSPFPUBOBJNAME`", showorder=5), @DEDataQueryCodeExp(name="PSPFID", expression="t1.`PSPFID`", showorder=6), @DEDataQueryCodeExp(name="PSPFNAME", expression="t1.`PSPFNAME`", showorder=7), @DEDataQueryCodeExp(name="PSPFPUBOBJID", expression="t1.`PSPFPUBOBJID`", showorder=8), @DEDataQueryCodeExp(name="PSPFPUBOBJNAME", expression="t1.`PSPFPUBOBJNAME`", showorder=9), @DEDataQueryCodeExp(name="PSPFSTYLEID", expression="t1.`PSPFSTYLEID`", showorder=10), @DEDataQueryCodeExp(name="PSPFSTYLENAME", expression="t1.`PSPFSTYLENAME`", showorder=11), @DEDataQueryCodeExp(name="PUBOBJ", expression="t1.`PUBOBJ`", showorder=12), @DEDataQueryCodeExp(name="PUBOBJTAG", expression="t1.`PUBOBJTAG`", showorder=13), @DEDataQueryCodeExp(name="PUBOBJTAG2", expression="t1.`PUBOBJTAG2`", showorder=14), @DEDataQueryCodeExp(name="TARGET", expression="t1.`TARGET`", showorder=15), @DEDataQueryCodeExp(name="TARGETTYPE", expression="t1.`TARGETTYPE`", showorder=16), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=17), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=18), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=19)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MACROPARAMS, t1.MEMO, t1.PPSPFPUBOBJID, t1.PPSPFPUBOBJNAME, t1.PSPFID, t1.PSPFNAME, t1.PSPFPUBOBJID, t1.PSPFPUBOBJNAME, t1.PSPFSTYLEID, t1.PSPFSTYLENAME, t1.PUBOBJ, t1.PUBOBJTAG, t1.PUBOBJTAG2, t1.TARGET, t1.TARGETTYPE, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSPFPUBOBJ t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MACROPARAMS", expression="t1.MACROPARAMS", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PPSPFPUBOBJID", expression="t1.PPSPFPUBOBJID", showorder=4), @DEDataQueryCodeExp(name="PPSPFPUBOBJNAME", expression="t1.PPSPFPUBOBJNAME", showorder=5), @DEDataQueryCodeExp(name="PSPFID", expression="t1.PSPFID", showorder=6), @DEDataQueryCodeExp(name="PSPFNAME", expression="t1.PSPFNAME", showorder=7), @DEDataQueryCodeExp(name="PSPFPUBOBJID", expression="t1.PSPFPUBOBJID", showorder=8), @DEDataQueryCodeExp(name="PSPFPUBOBJNAME", expression="t1.PSPFPUBOBJNAME", showorder=9), @DEDataQueryCodeExp(name="PSPFSTYLEID", expression="t1.PSPFSTYLEID", showorder=10), @DEDataQueryCodeExp(name="PSPFSTYLENAME", expression="t1.PSPFSTYLENAME", showorder=11), @DEDataQueryCodeExp(name="PUBOBJ", expression="t1.PUBOBJ", showorder=12), @DEDataQueryCodeExp(name="PUBOBJTAG", expression="t1.PUBOBJTAG", showorder=13), @DEDataQueryCodeExp(name="PUBOBJTAG2", expression="t1.PUBOBJTAG2", showorder=14), @DEDataQueryCodeExp(name="TARGET", expression="t1.TARGET", showorder=15), @DEDataQueryCodeExp(name="TARGETTYPE", expression="t1.TARGETTYPE", showorder=16), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=17), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=18), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=19)}, conds={})})
public class PSPFPubObjDefaultDQModel
extends DEDataQueryModelBase {
    public PSPFPubObjDefaultDQModel() {
        this.initAnnotation(PSPFPubObjDefaultDQModel.class);
    }
}

