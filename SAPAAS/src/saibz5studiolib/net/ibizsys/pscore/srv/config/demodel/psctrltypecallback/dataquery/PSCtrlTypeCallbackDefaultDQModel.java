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
package net.ibizsys.pscore.srv.config.demodel.psctrltypecallback.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="C1E1D067-4004-4561-B189-350F9AB9ACBD", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ORDERVALUE`, t1.`PSCTRLTYPECALLBACKID`, t1.`PSCTRLTYPECALLBACKNAME`, t1.`PSCTRLTYPEID`, t11.`PSCTRLTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSCTRLTYPECALLBACK` t1  LEFT JOIN `T_SRFPSCTRLTYPE` t11 ON t1.`PSCTRLTYPEID` = t11.`PSCTRLTYPEID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="R7DEXAMPLE", expression="t1.`R7DEXAMPLE`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=2), @DEDataQueryCodeExp(name="PSCTRLTYPECALLBACKID", expression="t1.`PSCTRLTYPECALLBACKID`", showorder=3), @DEDataQueryCodeExp(name="PSCTRLTYPECALLBACKNAME", expression="t1.`PSCTRLTYPECALLBACKNAME`", showorder=4), @DEDataQueryCodeExp(name="PSCTRLTYPEID", expression="t1.`PSCTRLTYPEID`", showorder=5), @DEDataQueryCodeExp(name="PSCTRLTYPENAME", expression="t11.`PSCTRLTYPENAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ORDERVALUE, t1.PSCTRLTYPECALLBACKID, t1.PSCTRLTYPECALLBACKNAME, t1.PSCTRLTYPEID, t11.PSCTRLTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSCTRLTYPECALLBACK t1  LEFT JOIN T_SRFPSCTRLTYPE t11 ON t1.PSCTRLTYPEID = t11.PSCTRLTYPEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="R7DEXAMPLE", expression="t1.R7DEXAMPLE", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=2), @DEDataQueryCodeExp(name="PSCTRLTYPECALLBACKID", expression="t1.PSCTRLTYPECALLBACKID", showorder=3), @DEDataQueryCodeExp(name="PSCTRLTYPECALLBACKNAME", expression="t1.PSCTRLTYPECALLBACKNAME", showorder=4), @DEDataQueryCodeExp(name="PSCTRLTYPEID", expression="t1.PSCTRLTYPEID", showorder=5), @DEDataQueryCodeExp(name="PSCTRLTYPENAME", expression="t11.PSCTRLTYPENAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=9)}, conds={})})
public class PSCtrlTypeCallbackDefaultDQModel
extends DEDataQueryModelBase {
    public PSCtrlTypeCallbackDefaultDQModel() {
        this.initAnnotation(PSCtrlTypeCallbackDefaultDQModel.class);
    }
}

