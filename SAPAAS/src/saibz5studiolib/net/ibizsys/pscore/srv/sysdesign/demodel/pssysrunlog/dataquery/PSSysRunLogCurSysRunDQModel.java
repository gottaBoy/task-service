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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysrunlog.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="CD8F046A-64ED-4F47-9E55-114C34A20269", name="CurSysRun")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOGINFO`, t1.`LOGLEVEL`, t1.`LOGLEVEL2`, t1.`LOGTIME`, t1.`PSSYSRUNLOGID`, t1.`PSSYSRUNLOGNAME`, t1.`PSSYSRUNSESSIONID`, t1.`PSSYSRUNSESSIONNAME`, t1.`PSSYSTEMID`, t1.`PSSYSTEMNAME`, t11.`RUNSTATE`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSYSRUNLOG` t1  LEFT JOIN T_SRFPSSYSRUNSESSION t11 ON t1.PSSYSRUNSESSIONID = t11.PSSYSRUNSESSIONID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="LOGINFO2", expression="t1.`LOGINFO2`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="LOGINFO", expression="t1.`LOGINFO`", showorder=2), @DEDataQueryCodeExp(name="LOGLEVEL", expression="t1.`LOGLEVEL`", showorder=3), @DEDataQueryCodeExp(name="LOGLEVEL2", expression="t1.`LOGLEVEL2`", showorder=4), @DEDataQueryCodeExp(name="LOGTIME", expression="t1.`LOGTIME`", showorder=5), @DEDataQueryCodeExp(name="PSSYSRUNLOGID", expression="t1.`PSSYSRUNLOGID`", showorder=6), @DEDataQueryCodeExp(name="PSSYSRUNLOGNAME", expression="t1.`PSSYSRUNLOGNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSYSRUNSESSIONID", expression="t1.`PSSYSRUNSESSIONID`", showorder=8), @DEDataQueryCodeExp(name="PSSYSRUNSESSIONNAME", expression="t1.`PSSYSRUNSESSIONNAME`", showorder=9), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=10), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.`PSSYSTEMNAME`", showorder=11), @DEDataQueryCodeExp(name="RUNSTATE", expression="t11.`RUNSTATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14)}, conds={@DEDataQueryCodeCond(condition="( t11.`RUNSTATE` = 20  AND  t1.`PSSYSTEMID` =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSSYSRUNLOG\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.LOGINFO, t1.LOGLEVEL, t1.LOGLEVEL2, t1.LOGTIME, t1.PSSYSRUNLOGID, t1.PSSYSRUNLOGNAME, t1.PSSYSRUNSESSIONID, t1.PSSYSRUNSESSIONNAME, t1.PSSYSTEMID, t1.PSSYSTEMNAME, t11.RUNSTATE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSYSRUNLOG t1  LEFT JOIN T_SRFPSSYSRUNSESSION t11 ON t1.PSSYSRUNSESSIONID = t11.PSSYSRUNSESSIONID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="LOGINFO2", expression="t1.LOGINFO2", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="LOGINFO", expression="t1.LOGINFO", showorder=2), @DEDataQueryCodeExp(name="LOGLEVEL", expression="t1.LOGLEVEL", showorder=3), @DEDataQueryCodeExp(name="LOGLEVEL2", expression="t1.LOGLEVEL2", showorder=4), @DEDataQueryCodeExp(name="LOGTIME", expression="t1.LOGTIME", showorder=5), @DEDataQueryCodeExp(name="PSSYSRUNLOGID", expression="t1.PSSYSRUNLOGID", showorder=6), @DEDataQueryCodeExp(name="PSSYSRUNLOGNAME", expression="t1.PSSYSRUNLOGNAME", showorder=7), @DEDataQueryCodeExp(name="PSSYSRUNSESSIONID", expression="t1.PSSYSRUNSESSIONID", showorder=8), @DEDataQueryCodeExp(name="PSSYSRUNSESSIONNAME", expression="t1.PSSYSRUNSESSIONNAME", showorder=9), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=10), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.PSSYSTEMNAME", showorder=11), @DEDataQueryCodeExp(name="RUNSTATE", expression="t11.RUNSTATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14)}, conds={@DEDataQueryCodeCond(condition="( t11.RUNSTATE = 20  AND  t1.PSSYSTEMID =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSSYSRUNLOG\"}')} )")})})
public class PSSysRunLogCurSysRunDQModel
extends DEDataQueryModelBase {
    public PSSysRunLogCurSysRunDQModel() {
        this.initAnnotation(PSSysRunLogCurSysRunDQModel.class);
    }
}

