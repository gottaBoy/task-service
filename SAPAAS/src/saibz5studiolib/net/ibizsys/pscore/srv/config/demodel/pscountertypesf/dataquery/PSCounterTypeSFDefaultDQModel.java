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
package net.ibizsys.pscore.srv.config.demodel.pscountertypesf.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="84D751C6-43A9-4353-8104-ABC56E1D5486", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`BASEOBJ`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSCOUNTERTYPEID`, t11.`PSCOUNTERTYPENAME`, t1.`PSCOUNTERTYPESFID`, t1.`PSCOUNTERTYPESFNAME`, t1.`PSSFID`, t21.`PSSFNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSCOUNTERTYPESF` t1  LEFT JOIN T_SRFPSCOUNTERTYPE t11 ON t1.PSCOUNTERTYPEID = t11.PSCOUNTERTYPEID  LEFT JOIN T_SRFPSSF t21 ON t1.PSSFID = t21.PSSFID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="BASEOBJ", expression="t1.`BASEOBJ`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSCOUNTERTYPEID", expression="t1.`PSCOUNTERTYPEID`", showorder=4), @DEDataQueryCodeExp(name="PSCOUNTERTYPENAME", expression="t11.`PSCOUNTERTYPENAME`", showorder=5), @DEDataQueryCodeExp(name="PSCOUNTERTYPESFID", expression="t1.`PSCOUNTERTYPESFID`", showorder=6), @DEDataQueryCodeExp(name="PSCOUNTERTYPESFNAME", expression="t1.`PSCOUNTERTYPESFNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSFID", expression="t1.`PSSFID`", showorder=8), @DEDataQueryCodeExp(name="PSSFNAME", expression="t21.`PSSFNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.BASEOBJ, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSCOUNTERTYPEID, t11.PSCOUNTERTYPENAME, t1.PSCOUNTERTYPESFID, t1.PSCOUNTERTYPESFNAME, t1.PSSFID, t21.PSSFNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSCOUNTERTYPESF t1  LEFT JOIN T_SRFPSCOUNTERTYPE t11 ON t1.PSCOUNTERTYPEID = t11.PSCOUNTERTYPEID  LEFT JOIN T_SRFPSSF t21 ON t1.PSSFID = t21.PSSFID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="BASEOBJ", expression="t1.BASEOBJ", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSCOUNTERTYPEID", expression="t1.PSCOUNTERTYPEID", showorder=4), @DEDataQueryCodeExp(name="PSCOUNTERTYPENAME", expression="t11.PSCOUNTERTYPENAME", showorder=5), @DEDataQueryCodeExp(name="PSCOUNTERTYPESFID", expression="t1.PSCOUNTERTYPESFID", showorder=6), @DEDataQueryCodeExp(name="PSCOUNTERTYPESFNAME", expression="t1.PSCOUNTERTYPESFNAME", showorder=7), @DEDataQueryCodeExp(name="PSSFID", expression="t1.PSSFID", showorder=8), @DEDataQueryCodeExp(name="PSSFNAME", expression="t21.PSSFNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSCounterTypeSFDefaultDQModel
extends DEDataQueryModelBase {
    public PSCounterTypeSFDefaultDQModel() {
        this.initAnnotation(PSCounterTypeSFDefaultDQModel.class);
    }
}

