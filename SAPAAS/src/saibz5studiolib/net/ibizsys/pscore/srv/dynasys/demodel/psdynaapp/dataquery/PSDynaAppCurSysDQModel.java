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
package net.ibizsys.pscore.srv.dynasys.demodel.psdynaapp.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="5F0BD8FC-192C-4012-AD52-74F409B75E21", name="CurSys")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOGICNAME`, t1.`MEMO`, t1.`PSAPPTYPEID`, t1.`PSAPPTYPENAME`, t1.`PSDYNAAPPID`, t1.`PSDYNAAPPNAME`, t1.`PSDYNASYSID`, t11.`PSDYNASYSNAME`, t1.`PSSYSAPPID`, t1.`PSSYSAPPNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDYNAAPP` t1  LEFT JOIN `T_SRFPSDYNASYS` t11 ON t1.`PSDYNASYSID` = t11.`PSDYNASYSID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.`LOGICNAME`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSAPPTYPEID", expression="t1.`PSAPPTYPEID`", showorder=4), @DEDataQueryCodeExp(name="PSAPPTYPENAME", expression="t1.`PSAPPTYPENAME`", showorder=5), @DEDataQueryCodeExp(name="PSDYNAAPPID", expression="t1.`PSDYNAAPPID`", showorder=6), @DEDataQueryCodeExp(name="PSDYNAAPPNAME", expression="t1.`PSDYNAAPPNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDYNASYSID", expression="t1.`PSDYNASYSID`", showorder=8), @DEDataQueryCodeExp(name="PSDYNASYSNAME", expression="t11.`PSDYNASYSNAME`", showorder=9), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.`PSSYSAPPID`", showorder=10), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t1.`PSSYSAPPNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=14)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSDYNASYSID` =  ${srfdatacontext('pssystemid','{\"defname\":\"PSDYNASYSID\",\"dename\":\"PSDYNAAPP\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.LOGICNAME, t1.MEMO, t1.PSAPPTYPEID, t1.PSAPPTYPENAME, t1.PSDYNAAPPID, t1.PSDYNAAPPNAME, t1.PSDYNASYSID, t11.PSDYNASYSNAME, t1.PSSYSAPPID, t1.PSSYSAPPNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDYNAAPP t1  LEFT JOIN T_SRFPSDYNASYS t11 ON t1.PSDYNASYSID = t11.PSDYNASYSID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.LOGICNAME", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSAPPTYPEID", expression="t1.PSAPPTYPEID", showorder=4), @DEDataQueryCodeExp(name="PSAPPTYPENAME", expression="t1.PSAPPTYPENAME", showorder=5), @DEDataQueryCodeExp(name="PSDYNAAPPID", expression="t1.PSDYNAAPPID", showorder=6), @DEDataQueryCodeExp(name="PSDYNAAPPNAME", expression="t1.PSDYNAAPPNAME", showorder=7), @DEDataQueryCodeExp(name="PSDYNASYSID", expression="t1.PSDYNASYSID", showorder=8), @DEDataQueryCodeExp(name="PSDYNASYSNAME", expression="t11.PSDYNASYSNAME", showorder=9), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.PSSYSAPPID", showorder=10), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t1.PSSYSAPPNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=14)}, conds={@DEDataQueryCodeCond(condition="( t1.PSDYNASYSID =  ${srfdatacontext('pssystemid','{\"defname\":\"PSDYNASYSID\",\"dename\":\"PSDYNAAPP\"}')} )")})})
public class PSDynaAppCurSysDQModel
extends DEDataQueryModelBase {
    public PSDynaAppCurSysDQModel() {
        this.initAnnotation(PSDynaAppCurSysDQModel.class);
    }
}

