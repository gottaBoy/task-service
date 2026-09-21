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
package net.ibizsys.pscore.srv.wfdesign.demodel.pssyswfmode.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="A80B7BB5-FA3F-48BD-8BC5-4BDF2B1269BF", name="CurSys")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOCKFLAG`, t1.`MEMO`, t1.`PSMODULEID`, t11.`PSMODULENAME`, t1.`PSSYSTEMID`, t1.`PSSYSTEMNAME`, t1.`PSSYSWFMODEID`, t1.`PSSYSWFMODENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4`, t1.`WFMODE` FROM `T_SRFPSSYSWFMODE` t1  LEFT JOIN T_SRFPSMODULE t11 ON t1.PSMODULEID = t11.PSMODULEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="LOCKFLAG", expression="t1.`LOCKFLAG`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSMODULEID", expression="t1.`PSMODULEID`", showorder=4), @DEDataQueryCodeExp(name="PSMODULENAME", expression="t11.`PSMODULENAME`", showorder=5), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=6), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.`PSSYSTEMNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSYSWFMODEID", expression="t1.`PSSYSWFMODEID`", showorder=8), @DEDataQueryCodeExp(name="PSSYSWFMODENAME", expression="t1.`PSSYSWFMODENAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=12), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=13), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=14), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=15), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=16), @DEDataQueryCodeExp(name="WFMODE", expression="t1.`WFMODE`", showorder=17)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSSYSTEMID` =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSSYSWFMODE\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.LOCKFLAG, t1.MEMO, t1.PSMODULEID, t11.PSMODULENAME, t1.PSSYSTEMID, t1.PSSYSTEMNAME, t1.PSSYSWFMODEID, t1.PSSYSWFMODENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4, t1.WFMODE FROM T_SRFPSSYSWFMODE t1  LEFT JOIN T_SRFPSMODULE t11 ON t1.PSMODULEID = t11.PSMODULEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="LOCKFLAG", expression="t1.LOCKFLAG", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSMODULEID", expression="t1.PSMODULEID", showorder=4), @DEDataQueryCodeExp(name="PSMODULENAME", expression="t11.PSMODULENAME", showorder=5), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=6), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.PSSYSTEMNAME", showorder=7), @DEDataQueryCodeExp(name="PSSYSWFMODEID", expression="t1.PSSYSWFMODEID", showorder=8), @DEDataQueryCodeExp(name="PSSYSWFMODENAME", expression="t1.PSSYSWFMODENAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=12), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=13), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=14), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=15), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=16), @DEDataQueryCodeExp(name="WFMODE", expression="t1.WFMODE", showorder=17)}, conds={@DEDataQueryCodeCond(condition="( t1.PSSYSTEMID =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSSYSWFMODE\"}')} )")})})
public class PSSysWFModeCurSysDQModel
extends DEDataQueryModelBase {
    public PSSysWFModeCurSysDQModel() {
        this.initAnnotation(PSSysWFModeCurSysDQModel.class);
    }
}

