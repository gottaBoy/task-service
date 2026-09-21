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
package net.ibizsys.pscore.srv.config.demodel.psctrltypemodel.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="AC14207E-C63E-44DF-972E-F7CA893B6DD5", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSCTRLMODELID`, t11.`PSCTRLMODELNAME`, t1.`PSCTRLTYPEID`, t1.`PSCTRLTYPEMODELID`, t1.`PSCTRLTYPEMODELNAME`, t1.`PSCTRLTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSCTRLTYPEMODEL` t1  LEFT JOIN `T_SRFPSCTRLMODEL` t11 ON t1.`PSCTRLMODELID` = t11.`PSCTRLMODELID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="R7DEXAMPLE", expression="t1.`R7DEXAMPLE`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=3), @DEDataQueryCodeExp(name="PSCTRLMODELID", expression="t1.`PSCTRLMODELID`", showorder=4), @DEDataQueryCodeExp(name="PSCTRLMODELNAME", expression="t11.`PSCTRLMODELNAME`", showorder=5), @DEDataQueryCodeExp(name="PSCTRLTYPEID", expression="t1.`PSCTRLTYPEID`", showorder=6), @DEDataQueryCodeExp(name="PSCTRLTYPEMODELID", expression="t1.`PSCTRLTYPEMODELID`", showorder=7), @DEDataQueryCodeExp(name="PSCTRLTYPEMODELNAME", expression="t1.`PSCTRLTYPEMODELNAME`", showorder=8), @DEDataQueryCodeExp(name="PSCTRLTYPENAME", expression="t1.`PSCTRLTYPENAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PSCTRLMODELID, t11.PSCTRLMODELNAME, t1.PSCTRLTYPEID, t1.PSCTRLTYPEMODELID, t1.PSCTRLTYPEMODELNAME, t1.PSCTRLTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSCTRLTYPEMODEL t1  LEFT JOIN T_SRFPSCTRLMODEL t11 ON t1.PSCTRLMODELID = t11.PSCTRLMODELID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=3), @DEDataQueryCodeExp(name="PSCTRLMODELID", expression="t1.PSCTRLMODELID", showorder=4), @DEDataQueryCodeExp(name="PSCTRLMODELNAME", expression="t11.PSCTRLMODELNAME", showorder=5), @DEDataQueryCodeExp(name="PSCTRLTYPEID", expression="t1.PSCTRLTYPEID", showorder=6), @DEDataQueryCodeExp(name="PSCTRLTYPEMODELID", expression="t1.PSCTRLTYPEMODELID", showorder=7), @DEDataQueryCodeExp(name="PSCTRLTYPEMODELNAME", expression="t1.PSCTRLTYPEMODELNAME", showorder=8), @DEDataQueryCodeExp(name="PSCTRLTYPENAME", expression="t1.PSCTRLTYPENAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12)}, conds={})})
public class PSCtrlTypeModelDefaultDQModel
extends DEDataQueryModelBase {
    public PSCtrlTypeModelDefaultDQModel() {
        this.initAnnotation(PSCtrlTypeModelDefaultDQModel.class);
    }
}

