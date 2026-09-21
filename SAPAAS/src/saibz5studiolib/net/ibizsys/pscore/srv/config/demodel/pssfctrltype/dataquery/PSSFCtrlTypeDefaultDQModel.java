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
package net.ibizsys.pscore.srv.config.demodel.pssfctrltype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="E1ADB5D5-C430-4826-BEBE-8E1F09088C4A", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`HANDLERCLASS`, t1.`MEMO`, t1.`MODELCLASS`, t1.`PSCTRLTYPEID`, t11.`PSCTRLTYPENAME`, t1.`PSSFCTRLTYPEID`, t1.`PSSFCTRLTYPENAME`, t1.`PSSFID`, t21.`PSSFNAME`, t1.`PSSFSTYLEID`, t31.`PSSFSTYLENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSFCTRLTYPE` t1  LEFT JOIN T_SRFPSCTRLTYPE t11 ON t1.PSCTRLTYPEID = t11.PSCTRLTYPEID  LEFT JOIN T_SRFPSSF t21 ON t1.PSSFID = t21.PSSFID  LEFT JOIN T_SRFPSSFSTYLE t31 ON t1.PSSFSTYLEID = t31.PSSFSTYLEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CTRLDESC", expression="t1.`CTRLDESC`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="HANDLERCLASS", expression="t1.`HANDLERCLASS`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="MODELCLASS", expression="t1.`MODELCLASS`", showorder=4), @DEDataQueryCodeExp(name="PSCTRLTYPEID", expression="t1.`PSCTRLTYPEID`", showorder=5), @DEDataQueryCodeExp(name="PSCTRLTYPENAME", expression="t11.`PSCTRLTYPENAME`", showorder=6), @DEDataQueryCodeExp(name="PSSFCTRLTYPEID", expression="t1.`PSSFCTRLTYPEID`", showorder=7), @DEDataQueryCodeExp(name="PSSFCTRLTYPENAME", expression="t1.`PSSFCTRLTYPENAME`", showorder=8), @DEDataQueryCodeExp(name="PSSFID", expression="t1.`PSSFID`", showorder=9), @DEDataQueryCodeExp(name="PSSFNAME", expression="t21.`PSSFNAME`", showorder=10), @DEDataQueryCodeExp(name="PSSFSTYLEID", expression="t1.`PSSFSTYLEID`", showorder=11), @DEDataQueryCodeExp(name="PSSFSTYLENAME", expression="t31.`PSSFSTYLENAME`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.HANDLERCLASS, t1.MEMO, t1.MODELCLASS, t1.PSCTRLTYPEID, t11.PSCTRLTYPENAME, t1.PSSFCTRLTYPEID, t1.PSSFCTRLTYPENAME, t1.PSSFID, t21.PSSFNAME, t1.PSSFSTYLEID, t31.PSSFSTYLENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSFCTRLTYPE t1  LEFT JOIN T_SRFPSCTRLTYPE t11 ON t1.PSCTRLTYPEID = t11.PSCTRLTYPEID  LEFT JOIN T_SRFPSSF t21 ON t1.PSSFID = t21.PSSFID  LEFT JOIN T_SRFPSSFSTYLE t31 ON t1.PSSFSTYLEID = t31.PSSFSTYLEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CTRLDESC", expression="t1.CTRLDESC", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="HANDLERCLASS", expression="t1.HANDLERCLASS", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="MODELCLASS", expression="t1.MODELCLASS", showorder=4), @DEDataQueryCodeExp(name="PSCTRLTYPEID", expression="t1.PSCTRLTYPEID", showorder=5), @DEDataQueryCodeExp(name="PSCTRLTYPENAME", expression="t11.PSCTRLTYPENAME", showorder=6), @DEDataQueryCodeExp(name="PSSFCTRLTYPEID", expression="t1.PSSFCTRLTYPEID", showorder=7), @DEDataQueryCodeExp(name="PSSFCTRLTYPENAME", expression="t1.PSSFCTRLTYPENAME", showorder=8), @DEDataQueryCodeExp(name="PSSFID", expression="t1.PSSFID", showorder=9), @DEDataQueryCodeExp(name="PSSFNAME", expression="t21.PSSFNAME", showorder=10), @DEDataQueryCodeExp(name="PSSFSTYLEID", expression="t1.PSSFSTYLEID", showorder=11), @DEDataQueryCodeExp(name="PSSFSTYLENAME", expression="t31.PSSFSTYLENAME", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14)}, conds={})})
public class PSSFCtrlTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSSFCtrlTypeDefaultDQModel() {
        this.initAnnotation(PSSFCtrlTypeDefaultDQModel.class);
    }
}

