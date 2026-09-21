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
package net.ibizsys.pscore.srv.appdesign.demodel.psappdeviewref.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="5AF1520F-BFC8-4F10-87E6-C1D8F68F8CCE", name="CurSys")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSAPPDEVIEWREFID`, t1.`PSAPPDEVIEWREFNAME`, t1.`PSDEVIEWBASEID`, t11.`PSDEVIEWBASENAME`, t1.`PSSYSAPPID`, t21.`PSSYSAPPNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSAPPDEVIEWREF` t1  LEFT JOIN T_SRFPSDEVIEWBASE t11 ON t1.PSDEVIEWBASEID = t11.PSDEVIEWBASEID  LEFT JOIN T_SRFPSSYSAPP t21 ON t1.PSSYSAPPID = t21.PSSYSAPPID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSAPPDEVIEWREFID", expression="t1.`PSAPPDEVIEWREFID`", showorder=3), @DEDataQueryCodeExp(name="PSAPPDEVIEWREFNAME", expression="t1.`PSAPPDEVIEWREFNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDEVIEWBASEID", expression="t1.`PSDEVIEWBASEID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVIEWBASENAME", expression="t11.`PSDEVIEWBASENAME`", showorder=6), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.`PSSYSAPPID`", showorder=7), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t21.`PSSYSAPPNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10)}, conds={@DEDataQueryCodeCond(condition="( t21.`PSSYSTEMID` =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSSYSAPP\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSAPPDEVIEWREFID, t1.PSAPPDEVIEWREFNAME, t1.PSDEVIEWBASEID, t11.PSDEVIEWBASENAME, t1.PSSYSAPPID, t21.PSSYSAPPNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSAPPDEVIEWREF t1  LEFT JOIN T_SRFPSDEVIEWBASE t11 ON t1.PSDEVIEWBASEID = t11.PSDEVIEWBASEID  LEFT JOIN T_SRFPSSYSAPP t21 ON t1.PSSYSAPPID = t21.PSSYSAPPID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSAPPDEVIEWREFID", expression="t1.PSAPPDEVIEWREFID", showorder=3), @DEDataQueryCodeExp(name="PSAPPDEVIEWREFNAME", expression="t1.PSAPPDEVIEWREFNAME", showorder=4), @DEDataQueryCodeExp(name="PSDEVIEWBASEID", expression="t1.PSDEVIEWBASEID", showorder=5), @DEDataQueryCodeExp(name="PSDEVIEWBASENAME", expression="t11.PSDEVIEWBASENAME", showorder=6), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.PSSYSAPPID", showorder=7), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t21.PSSYSAPPNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10)}, conds={@DEDataQueryCodeCond(condition="( t21.PSSYSTEMID =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSSYSAPP\"}')} )")})})
public class PSAppDEViewRefCurSysDQModel
extends DEDataQueryModelBase {
    public PSAppDEViewRefCurSysDQModel() {
        this.initAnnotation(PSAppDEViewRefCurSysDQModel.class);
    }
}

