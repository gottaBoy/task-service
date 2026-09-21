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
package net.ibizsys.pscore.srv.config.demodel.psctrltypeaction.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="2B9E3490-A59A-4B5C-8CEA-D52DB949812E", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSCTRLACTIONID`, t11.`PSCTRLACTIONNAME`, t1.`PSCTRLTYPEACTIONID`, t1.`PSCTRLTYPEACTIONNAME`, t1.`PSCTRLTYPEID`, t21.`PSCTRLTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSCTRLTYPEACTION` t1  LEFT JOIN `T_SRFPSCTRLACTION` t11 ON t1.`PSCTRLACTIONID` = t11.`PSCTRLACTIONID`  LEFT JOIN `T_SRFPSCTRLTYPE` t21 ON t1.`PSCTRLTYPEID` = t21.`PSCTRLTYPEID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="R7DEXAMPLE", expression="t1.`R7DEXAMPLE`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=3), @DEDataQueryCodeExp(name="PSCTRLACTIONID", expression="t1.`PSCTRLACTIONID`", showorder=4), @DEDataQueryCodeExp(name="PSCTRLACTIONNAME", expression="t11.`PSCTRLACTIONNAME`", showorder=5), @DEDataQueryCodeExp(name="PSCTRLTYPEACTIONID", expression="t1.`PSCTRLTYPEACTIONID`", showorder=6), @DEDataQueryCodeExp(name="PSCTRLTYPEACTIONNAME", expression="t1.`PSCTRLTYPEACTIONNAME`", showorder=7), @DEDataQueryCodeExp(name="PSCTRLTYPEID", expression="t1.`PSCTRLTYPEID`", showorder=8), @DEDataQueryCodeExp(name="PSCTRLTYPENAME", expression="t21.`PSCTRLTYPENAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PSCTRLACTIONID, t11.PSCTRLACTIONNAME, t1.PSCTRLTYPEACTIONID, t1.PSCTRLTYPEACTIONNAME, t1.PSCTRLTYPEID, t21.PSCTRLTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSCTRLTYPEACTION t1  LEFT JOIN T_SRFPSCTRLACTION t11 ON t1.PSCTRLACTIONID = t11.PSCTRLACTIONID  LEFT JOIN T_SRFPSCTRLTYPE t21 ON t1.PSCTRLTYPEID = t21.PSCTRLTYPEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="R7DEXAMPLE", expression="t1.R7DEXAMPLE", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=3), @DEDataQueryCodeExp(name="PSCTRLACTIONID", expression="t1.PSCTRLACTIONID", showorder=4), @DEDataQueryCodeExp(name="PSCTRLACTIONNAME", expression="t11.PSCTRLACTIONNAME", showorder=5), @DEDataQueryCodeExp(name="PSCTRLTYPEACTIONID", expression="t1.PSCTRLTYPEACTIONID", showorder=6), @DEDataQueryCodeExp(name="PSCTRLTYPEACTIONNAME", expression="t1.PSCTRLTYPEACTIONNAME", showorder=7), @DEDataQueryCodeExp(name="PSCTRLTYPEID", expression="t1.PSCTRLTYPEID", showorder=8), @DEDataQueryCodeExp(name="PSCTRLTYPENAME", expression="t21.PSCTRLTYPENAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12)}, conds={})})
public class PSCtrlTypeActionDefaultDQModel
extends DEDataQueryModelBase {
    public PSCtrlTypeActionDefaultDQModel() {
        this.initAnnotation(PSCtrlTypeActionDefaultDQModel.class);
    }
}

