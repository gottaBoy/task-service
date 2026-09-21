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
package net.ibizsys.pscore.srv.config.demodel.pspfctrltype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="45B975DE-24C9-4315-9F1D-6E427D81AD4B", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`CTRLCLASS`, t1.`MEMO`, t1.`PSCTRLTYPEID`, t11.`PSCTRLTYPENAME`, t1.`PSPFCTRLTYPEID`, t1.`PSPFCTRLTYPENAME`, t1.`PSPFID`, t21.`PSPFNAME`, t1.`PSPFSTYLEID`, t31.`PSPFSTYLENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSPFCTRLTYPE` t1  LEFT JOIN T_SRFPSCTRLTYPE t11 ON t1.PSCTRLTYPEID = t11.PSCTRLTYPEID  LEFT JOIN T_SRFPSPF t21 ON t1.PSPFID = t21.PSPFID  LEFT JOIN T_SRFPSPFSTYLE t31 ON t1.PSPFSTYLEID = t31.PSPFSTYLEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CTRLDESC", expression="t1.`CTRLDESC`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="CTRLCLASS", expression="t1.`CTRLCLASS`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSCTRLTYPEID", expression="t1.`PSCTRLTYPEID`", showorder=4), @DEDataQueryCodeExp(name="PSCTRLTYPENAME", expression="t11.`PSCTRLTYPENAME`", showorder=5), @DEDataQueryCodeExp(name="PSPFCTRLTYPEID", expression="t1.`PSPFCTRLTYPEID`", showorder=6), @DEDataQueryCodeExp(name="PSPFCTRLTYPENAME", expression="t1.`PSPFCTRLTYPENAME`", showorder=7), @DEDataQueryCodeExp(name="PSPFID", expression="t1.`PSPFID`", showorder=8), @DEDataQueryCodeExp(name="PSPFNAME", expression="t21.`PSPFNAME`", showorder=9), @DEDataQueryCodeExp(name="PSPFSTYLEID", expression="t1.`PSPFSTYLEID`", showorder=10), @DEDataQueryCodeExp(name="PSPFSTYLENAME", expression="t31.`PSPFSTYLENAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.CTRLCLASS, t1.MEMO, t1.PSCTRLTYPEID, t11.PSCTRLTYPENAME, t1.PSPFCTRLTYPEID, t1.PSPFCTRLTYPENAME, t1.PSPFID, t21.PSPFNAME, t1.PSPFSTYLEID, t31.PSPFSTYLENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSPFCTRLTYPE t1  LEFT JOIN T_SRFPSCTRLTYPE t11 ON t1.PSCTRLTYPEID = t11.PSCTRLTYPEID  LEFT JOIN T_SRFPSPF t21 ON t1.PSPFID = t21.PSPFID  LEFT JOIN T_SRFPSPFSTYLE t31 ON t1.PSPFSTYLEID = t31.PSPFSTYLEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CTRLDESC", expression="t1.CTRLDESC", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="CTRLCLASS", expression="t1.CTRLCLASS", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSCTRLTYPEID", expression="t1.PSCTRLTYPEID", showorder=4), @DEDataQueryCodeExp(name="PSCTRLTYPENAME", expression="t11.PSCTRLTYPENAME", showorder=5), @DEDataQueryCodeExp(name="PSPFCTRLTYPEID", expression="t1.PSPFCTRLTYPEID", showorder=6), @DEDataQueryCodeExp(name="PSPFCTRLTYPENAME", expression="t1.PSPFCTRLTYPENAME", showorder=7), @DEDataQueryCodeExp(name="PSPFID", expression="t1.PSPFID", showorder=8), @DEDataQueryCodeExp(name="PSPFNAME", expression="t21.PSPFNAME", showorder=9), @DEDataQueryCodeExp(name="PSPFSTYLEID", expression="t1.PSPFSTYLEID", showorder=10), @DEDataQueryCodeExp(name="PSPFSTYLENAME", expression="t31.PSPFSTYLENAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSPFCtrlTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSPFCtrlTypeDefaultDQModel() {
        this.initAnnotation(PSPFCtrlTypeDefaultDQModel.class);
    }
}

