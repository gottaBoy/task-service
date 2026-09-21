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
package net.ibizsys.pscore.srv.appdesign.demodel.psappctrlstyle.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="4CC1DBE2-ED9F-463F-A4FA-314CA4D292EE", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSAPPCTRLSTYLEID`, t1.`PSAPPCTRLSTYLENAME`, t1.`PSCTRLTYPEID`, t11.`PSCTRLTYPENAME`, t1.`PSSYSAPPID`, t21.`PSSYSAPPNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERPARAMS` FROM `T_SRFPSAPPCTRLSTYLE` t1  LEFT JOIN T_SRFPSCTRLTYPE t11 ON t1.PSCTRLTYPEID = t11.PSCTRLTYPEID  LEFT JOIN T_SRFPSSYSAPP t21 ON t1.PSSYSAPPID = t21.PSSYSAPPID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSAPPCTRLSTYLEID", expression="t1.`PSAPPCTRLSTYLEID`", showorder=3), @DEDataQueryCodeExp(name="PSAPPCTRLSTYLENAME", expression="t1.`PSAPPCTRLSTYLENAME`", showorder=4), @DEDataQueryCodeExp(name="PSCTRLTYPEID", expression="t1.`PSCTRLTYPEID`", showorder=5), @DEDataQueryCodeExp(name="PSCTRLTYPENAME", expression="t11.`PSCTRLTYPENAME`", showorder=6), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.`PSSYSAPPID`", showorder=7), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t21.`PSSYSAPPNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="USERPARAMS", expression="t1.`USERPARAMS`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSAPPCTRLSTYLEID, t1.PSAPPCTRLSTYLENAME, t1.PSCTRLTYPEID, t11.PSCTRLTYPENAME, t1.PSSYSAPPID, t21.PSSYSAPPNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERPARAMS FROM T_SRFPSAPPCTRLSTYLE t1  LEFT JOIN T_SRFPSCTRLTYPE t11 ON t1.PSCTRLTYPEID = t11.PSCTRLTYPEID  LEFT JOIN T_SRFPSSYSAPP t21 ON t1.PSSYSAPPID = t21.PSSYSAPPID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSAPPCTRLSTYLEID", expression="t1.PSAPPCTRLSTYLEID", showorder=3), @DEDataQueryCodeExp(name="PSAPPCTRLSTYLENAME", expression="t1.PSAPPCTRLSTYLENAME", showorder=4), @DEDataQueryCodeExp(name="PSCTRLTYPEID", expression="t1.PSCTRLTYPEID", showorder=5), @DEDataQueryCodeExp(name="PSCTRLTYPENAME", expression="t11.PSCTRLTYPENAME", showorder=6), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.PSSYSAPPID", showorder=7), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t21.PSSYSAPPNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="USERPARAMS", expression="t1.USERPARAMS", showorder=11)}, conds={})})
public class PSAppCtrlStyleDefaultDQModel
extends DEDataQueryModelBase {
    public PSAppCtrlStyleDefaultDQModel() {
        this.initAnnotation(PSAppCtrlStyleDefaultDQModel.class);
    }
}

