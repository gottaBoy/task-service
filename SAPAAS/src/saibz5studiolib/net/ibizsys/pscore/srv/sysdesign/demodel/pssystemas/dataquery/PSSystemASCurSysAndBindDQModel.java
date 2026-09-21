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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssystemas.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="2009DC3B-3FA5-4342-9101-0734FC7AE3C5", name="CurSysAndBind")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ASID`, t11.`ASTYPE`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENABLEWEBTOOL`, t1.`MEMO`, t11.`PSAPPSERVERID`, t1.`PSDEVCENTERASID`, t11.`PSDEVCENTERASNAME`, t1.`PSSYSTEMASID`, t1.`PSSYSTEMASNAME`, t1.`PSSYSTEMID`, t1.`PSSYSTEMNAME`, t1.`RESINFO`, t1.`RESREADYTIME`, t1.`RESSTATE`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSYSTEMAS` t1  LEFT JOIN T_SRFPSDEVCENTERAS t11 ON t1.PSDEVCENTERASID = t11.PSDEVCENTERASID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ASID", expression="t1.`ASID`", showorder=0), @DEDataQueryCodeExp(name="ASTYPE", expression="t11.`ASTYPE`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="ENABLEWEBTOOL", expression="t1.`ENABLEWEBTOOL`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="PSAPPSERVERID", expression="t11.`PSAPPSERVERID`", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERASID", expression="t1.`PSDEVCENTERASID`", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERASNAME", expression="t11.`PSDEVCENTERASNAME`", showorder=8), @DEDataQueryCodeExp(name="PSSYSTEMASID", expression="t1.`PSSYSTEMASID`", showorder=9), @DEDataQueryCodeExp(name="PSSYSTEMASNAME", expression="t1.`PSSYSTEMASNAME`", showorder=10), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=11), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.`PSSYSTEMNAME`", showorder=12), @DEDataQueryCodeExp(name="RESINFO", expression="t1.`RESINFO`", showorder=13), @DEDataQueryCodeExp(name="RESREADYTIME", expression="t1.`RESREADYTIME`", showorder=14), @DEDataQueryCodeExp(name="RESSTATE", expression="t1.`RESSTATE`", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=17)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSSYSTEMID` =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSSYSTEMAS\"}')}  AND  t1.`PSDEVCENTERASID` IS NOT NULL )")}), @DEDataQueryCode(querycode="SELECT t1.ASID, t11.ASTYPE, t1.CREATEDATE, t1.CREATEMAN, t1.ENABLEWEBTOOL, t1.MEMO, t11.PSAPPSERVERID, t1.PSDEVCENTERASID, t11.PSDEVCENTERASNAME, t1.PSSYSTEMASID, t1.PSSYSTEMASNAME, t1.PSSYSTEMID, t1.PSSYSTEMNAME, t1.RESINFO, t1.RESREADYTIME, t1.RESSTATE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSYSTEMAS t1  LEFT JOIN T_SRFPSDEVCENTERAS t11 ON t1.PSDEVCENTERASID = t11.PSDEVCENTERASID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ASID", expression="t1.ASID", showorder=0), @DEDataQueryCodeExp(name="ASTYPE", expression="t11.ASTYPE", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="ENABLEWEBTOOL", expression="t1.ENABLEWEBTOOL", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="PSAPPSERVERID", expression="t11.PSAPPSERVERID", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERASID", expression="t1.PSDEVCENTERASID", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERASNAME", expression="t11.PSDEVCENTERASNAME", showorder=8), @DEDataQueryCodeExp(name="PSSYSTEMASID", expression="t1.PSSYSTEMASID", showorder=9), @DEDataQueryCodeExp(name="PSSYSTEMASNAME", expression="t1.PSSYSTEMASNAME", showorder=10), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=11), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.PSSYSTEMNAME", showorder=12), @DEDataQueryCodeExp(name="RESINFO", expression="t1.RESINFO", showorder=13), @DEDataQueryCodeExp(name="RESREADYTIME", expression="t1.RESREADYTIME", showorder=14), @DEDataQueryCodeExp(name="RESSTATE", expression="t1.RESSTATE", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=17)}, conds={@DEDataQueryCodeCond(condition="( t1.PSSYSTEMID =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSSYSTEMAS\"}')}  AND  t1.PSDEVCENTERASID IS NOT NULL )")})})
public class PSSystemASCurSysAndBindDQModel
extends DEDataQueryModelBase {
    public PSSystemASCurSysAndBindDQModel() {
        this.initAnnotation(PSSystemASCurSysAndBindDQModel.class);
    }
}

