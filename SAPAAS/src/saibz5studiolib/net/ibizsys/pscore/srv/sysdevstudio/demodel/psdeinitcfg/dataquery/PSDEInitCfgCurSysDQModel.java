/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeCond
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psdeinitcfg.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="C5E34810-2541-466C-87F4-F40B4B83933B", name="CurSys")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`IGNOREDBMODEL`, t1.`IGNOREEXTMODEL`, t1.`IGNOREMGRMODEL`, t1.`IGNOREUIMODEL`, t1.`INITUIFLAG`, t1.`MEMO`, t1.`PSDEINITCFGID`, t1.`PSDEINITCFGNAME`, t1.`PSSYSTEMID`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEINITCFG` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="IGNOREDBMODEL", expression="t1.`IGNOREDBMODEL`", showorder=2), @DEDataQueryCodeExp(name="IGNOREEXTMODEL", expression="t1.`IGNOREEXTMODEL`", showorder=3), @DEDataQueryCodeExp(name="IGNOREMGRMODEL", expression="t1.`IGNOREMGRMODEL`", showorder=4), @DEDataQueryCodeExp(name="IGNOREUIMODEL", expression="t1.`IGNOREUIMODEL`", showorder=5), @DEDataQueryCodeExp(name="INITUIFLAG", expression="t1.`INITUIFLAG`", showorder=6), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=7), @DEDataQueryCodeExp(name="PSDEINITCFGID", expression="t1.`PSDEINITCFGID`", showorder=8), @DEDataQueryCodeExp(name="PSDEINITCFGNAME", expression="t1.`PSDEINITCFGNAME`", showorder=9), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSSYSTEMID` =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSDEINITCFG\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.IGNOREDBMODEL, t1.IGNOREEXTMODEL, t1.IGNOREMGRMODEL, t1.IGNOREUIMODEL, t1.INITUIFLAG, t1.MEMO, t1.PSDEINITCFGID, t1.PSDEINITCFGNAME, t1.PSSYSTEMID, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEINITCFG t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="IGNOREDBMODEL", expression="t1.IGNOREDBMODEL", showorder=2), @DEDataQueryCodeExp(name="IGNOREEXTMODEL", expression="t1.IGNOREEXTMODEL", showorder=3), @DEDataQueryCodeExp(name="IGNOREMGRMODEL", expression="t1.IGNOREMGRMODEL", showorder=4), @DEDataQueryCodeExp(name="IGNOREUIMODEL", expression="t1.IGNOREUIMODEL", showorder=5), @DEDataQueryCodeExp(name="INITUIFLAG", expression="t1.INITUIFLAG", showorder=6), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=7), @DEDataQueryCodeExp(name="PSDEINITCFGID", expression="t1.PSDEINITCFGID", showorder=8), @DEDataQueryCodeExp(name="PSDEINITCFGNAME", expression="t1.PSDEINITCFGNAME", showorder=9), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={@DEDataQueryCodeCond(condition="( t1.PSSYSTEMID =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSDEINITCFG\"}')} )")})})
public class PSDEInitCfgCurSysDQModel
extends DEDataQueryModelBase {
    public PSDEInitCfgCurSysDQModel() {
        this.initAnnotation(PSDEInitCfgCurSysDQModel.class);
    }
}

