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
package net.ibizsys.pscore.srv.appdesign.demodel.psappwf.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="A1F8E418-D952-4B13-801C-DE20C2861AD2", name="CurApp")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSAPPMODULEID`, t11.`PSAPPMODULENAME`, t1.`PSAPPWFID`, t1.`PSAPPWFNAME`, t1.`PSSYSAPPID`, t21.`PSSYSAPPNAME`, t1.`PSWORKFLOWID`, t31.`PSWORKFLOWNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4`, t1.`VALIDFLAG` FROM `T_SRFPSAPPWF` t1  LEFT JOIN `T_SRFPSAPPMODULE` t11 ON t1.`PSAPPMODULEID` = t11.`PSAPPMODULEID`  LEFT JOIN `T_SRFPSSYSAPP` t21 ON t1.`PSSYSAPPID` = t21.`PSSYSAPPID`  LEFT JOIN `T_SRFPSWORKFLOW` t31 ON t1.`PSWORKFLOWID` = t31.`PSWORKFLOWID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSAPPMODULEID", expression="t1.`PSAPPMODULEID`", showorder=3), @DEDataQueryCodeExp(name="PSAPPMODULENAME", expression="t11.`PSAPPMODULENAME`", showorder=4), @DEDataQueryCodeExp(name="PSAPPWFID", expression="t1.`PSAPPWFID`", showorder=5), @DEDataQueryCodeExp(name="PSAPPWFNAME", expression="t1.`PSAPPWFNAME`", showorder=6), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.`PSSYSAPPID`", showorder=7), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t21.`PSSYSAPPNAME`", showorder=8), @DEDataQueryCodeExp(name="PSWORKFLOWID", expression="t1.`PSWORKFLOWID`", showorder=9), @DEDataQueryCodeExp(name="PSWORKFLOWNAME", expression="t31.`PSWORKFLOWNAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=13), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=14), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=15), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=16), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=18)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSSYSAPPID` =  ${srfdatacontext('pssysappid','{\"defname\":\"PSSYSAPPID\",\"dename\":\"PSAPPWF\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSAPPMODULEID, t11.PSAPPMODULENAME, t1.PSAPPWFID, t1.PSAPPWFNAME, t1.PSSYSAPPID, t21.PSSYSAPPNAME, t1.PSWORKFLOWID, t31.PSWORKFLOWNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4, t1.VALIDFLAG FROM T_SRFPSAPPWF t1  LEFT JOIN T_SRFPSAPPMODULE t11 ON t1.PSAPPMODULEID = t11.PSAPPMODULEID  LEFT JOIN T_SRFPSSYSAPP t21 ON t1.PSSYSAPPID = t21.PSSYSAPPID  LEFT JOIN T_SRFPSWORKFLOW t31 ON t1.PSWORKFLOWID = t31.PSWORKFLOWID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSAPPMODULEID", expression="t1.PSAPPMODULEID", showorder=3), @DEDataQueryCodeExp(name="PSAPPMODULENAME", expression="t11.PSAPPMODULENAME", showorder=4), @DEDataQueryCodeExp(name="PSAPPWFID", expression="t1.PSAPPWFID", showorder=5), @DEDataQueryCodeExp(name="PSAPPWFNAME", expression="t1.PSAPPWFNAME", showorder=6), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.PSSYSAPPID", showorder=7), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t21.PSSYSAPPNAME", showorder=8), @DEDataQueryCodeExp(name="PSWORKFLOWID", expression="t1.PSWORKFLOWID", showorder=9), @DEDataQueryCodeExp(name="PSWORKFLOWNAME", expression="t31.PSWORKFLOWNAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=13), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=14), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=15), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=16), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=18)}, conds={@DEDataQueryCodeCond(condition="( t1.PSSYSAPPID =  ${srfdatacontext('pssysappid','{\"defname\":\"PSSYSAPPID\",\"dename\":\"PSAPPWF\"}')} )")})})
public class PSAppWFCurAppDQModel
extends DEDataQueryModelBase {
    public PSAppWFCurAppDQModel() {
        this.initAnnotation(PSAppWFCurAppDQModel.class);
    }
}

