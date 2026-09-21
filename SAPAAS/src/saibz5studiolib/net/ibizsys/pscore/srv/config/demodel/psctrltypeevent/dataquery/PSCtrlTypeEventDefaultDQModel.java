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
package net.ibizsys.pscore.srv.config.demodel.psctrltypeevent.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="D8BD561F-41D3-43AD-8C0C-05D5020D2FBB", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSCTRLEVENTID`, t11.`PSCTRLEVENTNAME`, t1.`PSCTRLTYPEEVENTID`, t1.`PSCTRLTYPEEVENTNAME`, t1.`PSCTRLTYPEID`, t21.`PSCTRLTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSCTRLTYPEEVENT` t1  LEFT JOIN `T_SRFPSCTRLEVENT` t11 ON t1.`PSCTRLEVENTID` = t11.`PSCTRLEVENTID`  LEFT JOIN `T_SRFPSCTRLTYPE` t21 ON t1.`PSCTRLTYPEID` = t21.`PSCTRLTYPEID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="R7DEXAMPLE", expression="t1.`R7DEXAMPLE`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=3), @DEDataQueryCodeExp(name="PSCTRLEVENTID", expression="t1.`PSCTRLEVENTID`", showorder=4), @DEDataQueryCodeExp(name="PSCTRLEVENTNAME", expression="t11.`PSCTRLEVENTNAME`", showorder=5), @DEDataQueryCodeExp(name="PSCTRLTYPEEVENTID", expression="t1.`PSCTRLTYPEEVENTID`", showorder=6), @DEDataQueryCodeExp(name="PSCTRLTYPEEVENTNAME", expression="t1.`PSCTRLTYPEEVENTNAME`", showorder=7), @DEDataQueryCodeExp(name="PSCTRLTYPEID", expression="t1.`PSCTRLTYPEID`", showorder=8), @DEDataQueryCodeExp(name="PSCTRLTYPENAME", expression="t21.`PSCTRLTYPENAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PSCTRLEVENTID, t11.PSCTRLEVENTNAME, t1.PSCTRLTYPEEVENTID, t1.PSCTRLTYPEEVENTNAME, t1.PSCTRLTYPEID, t21.PSCTRLTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSCTRLTYPEEVENT t1  LEFT JOIN T_SRFPSCTRLEVENT t11 ON t1.PSCTRLEVENTID = t11.PSCTRLEVENTID  LEFT JOIN T_SRFPSCTRLTYPE t21 ON t1.PSCTRLTYPEID = t21.PSCTRLTYPEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="R7DEXAMPLE", expression="t1.R7DEXAMPLE", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=3), @DEDataQueryCodeExp(name="PSCTRLEVENTID", expression="t1.PSCTRLEVENTID", showorder=4), @DEDataQueryCodeExp(name="PSCTRLEVENTNAME", expression="t11.PSCTRLEVENTNAME", showorder=5), @DEDataQueryCodeExp(name="PSCTRLTYPEEVENTID", expression="t1.PSCTRLTYPEEVENTID", showorder=6), @DEDataQueryCodeExp(name="PSCTRLTYPEEVENTNAME", expression="t1.PSCTRLTYPEEVENTNAME", showorder=7), @DEDataQueryCodeExp(name="PSCTRLTYPEID", expression="t1.PSCTRLTYPEID", showorder=8), @DEDataQueryCodeExp(name="PSCTRLTYPENAME", expression="t21.PSCTRLTYPENAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12)}, conds={})})
public class PSCtrlTypeEventDefaultDQModel
extends DEDataQueryModelBase {
    public PSCtrlTypeEventDefaultDQModel() {
        this.initAnnotation(PSCtrlTypeEventDefaultDQModel.class);
    }
}

