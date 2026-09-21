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
package net.ibizsys.pscore.srv.unisys.demodel.psusmoduleinstref.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="B08286F0-E2F1-4CAA-A0B9-2293B0764D2B", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSUSMODULEINSTID`, t11.`PSUSMODULEINSTNAME`, t1.`PSUSMODULEINSTREFID`, t1.`PSUSMODULEINSTREFNAME`, t1.`REFMODE`, t1.`REFPSUSMODULEINSTID`, t21.`PSUSMODULEINSTNAME` AS `REFPSUSMODULEINSTNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSUSMODULEINSTREF` t1  LEFT JOIN T_SRFPSUSMODULEINST t11 ON t1.PSUSMODULEINSTID = t11.PSUSMODULEINSTID  LEFT JOIN T_SRFPSUSMODULEINST t21 ON t1.REFPSUSMODULEINSTID = t21.PSUSMODULEINSTID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSUSMODULEINSTID", expression="t1.`PSUSMODULEINSTID`", showorder=3), @DEDataQueryCodeExp(name="PSUSMODULEINSTNAME", expression="t11.`PSUSMODULEINSTNAME`", showorder=4), @DEDataQueryCodeExp(name="PSUSMODULEINSTREFID", expression="t1.`PSUSMODULEINSTREFID`", showorder=5), @DEDataQueryCodeExp(name="PSUSMODULEINSTREFNAME", expression="t1.`PSUSMODULEINSTREFNAME`", showorder=6), @DEDataQueryCodeExp(name="REFMODE", expression="t1.`REFMODE`", showorder=7), @DEDataQueryCodeExp(name="REFPSUSMODULEINSTID", expression="t1.`REFPSUSMODULEINSTID`", showorder=8), @DEDataQueryCodeExp(name="REFPSUSMODULEINSTNAME", expression="t21.`PSUSMODULEINSTNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSUSMODULEINSTID, t11.PSUSMODULEINSTNAME, t1.PSUSMODULEINSTREFID, t1.PSUSMODULEINSTREFNAME, t1.REFMODE, t1.REFPSUSMODULEINSTID, t21.PSUSMODULEINSTNAME AS REFPSUSMODULEINSTNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSUSMODULEINSTREF t1  LEFT JOIN T_SRFPSUSMODULEINST t11 ON t1.PSUSMODULEINSTID = t11.PSUSMODULEINSTID  LEFT JOIN T_SRFPSUSMODULEINST t21 ON t1.REFPSUSMODULEINSTID = t21.PSUSMODULEINSTID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSUSMODULEINSTID", expression="t1.PSUSMODULEINSTID", showorder=3), @DEDataQueryCodeExp(name="PSUSMODULEINSTNAME", expression="t11.PSUSMODULEINSTNAME", showorder=4), @DEDataQueryCodeExp(name="PSUSMODULEINSTREFID", expression="t1.PSUSMODULEINSTREFID", showorder=5), @DEDataQueryCodeExp(name="PSUSMODULEINSTREFNAME", expression="t1.PSUSMODULEINSTREFNAME", showorder=6), @DEDataQueryCodeExp(name="REFMODE", expression="t1.REFMODE", showorder=7), @DEDataQueryCodeExp(name="REFPSUSMODULEINSTID", expression="t1.REFPSUSMODULEINSTID", showorder=8), @DEDataQueryCodeExp(name="REFPSUSMODULEINSTNAME", expression="t21.PSUSMODULEINSTNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12)}, conds={})})
public class PSUSModuleInstRefDefaultDQModel
extends DEDataQueryModelBase {
    public PSUSModuleInstRefDefaultDQModel() {
        this.initAnnotation(PSUSModuleInstRefDefaultDQModel.class);
    }
}

