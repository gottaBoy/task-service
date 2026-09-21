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
package net.ibizsys.pscore.srv.config.demodel.psmodelmodule.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="784B210D-DCE2-4B93-949E-6478D3BDD0B0", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`MODULETYPE`, t1.`ORDERVALUE`, t1.`PPSMODELMODULEID`, t11.`PSMODELMODULENAME` AS `PPSMODELMODULENAME`, t1.`PSMODELID`, t1.`PSMODELMODULEID`, t1.`PSMODELMODULENAME`, t1.`PSMODELNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSMODELMODULE` t1  LEFT JOIN T_SRFPSMODELMODULE t11 ON t1.PPSMODELMODULEID = t11.PSMODELMODULEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="MODULETYPE", expression="t1.`MODULETYPE`", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=4), @DEDataQueryCodeExp(name="PPSMODELMODULEID", expression="t1.`PPSMODELMODULEID`", showorder=5), @DEDataQueryCodeExp(name="PPSMODELMODULENAME", expression="t11.`PSMODELMODULENAME`", showorder=6), @DEDataQueryCodeExp(name="PSMODELID", expression="t1.`PSMODELID`", showorder=7), @DEDataQueryCodeExp(name="PSMODELMODULEID", expression="t1.`PSMODELMODULEID`", showorder=8), @DEDataQueryCodeExp(name="PSMODELMODULENAME", expression="t1.`PSMODELMODULENAME`", showorder=9), @DEDataQueryCodeExp(name="PSMODELNAME", expression="t1.`PSMODELNAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.MODULETYPE, t1.ORDERVALUE, t1.PPSMODELMODULEID, t11.PSMODELMODULENAME AS PPSMODELMODULENAME, t1.PSMODELID, t1.PSMODELMODULEID, t1.PSMODELMODULENAME, t1.PSMODELNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSMODELMODULE t1  LEFT JOIN T_SRFPSMODELMODULE t11 ON t1.PPSMODELMODULEID = t11.PSMODELMODULEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="MODULETYPE", expression="t1.MODULETYPE", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=4), @DEDataQueryCodeExp(name="PPSMODELMODULEID", expression="t1.PPSMODELMODULEID", showorder=5), @DEDataQueryCodeExp(name="PPSMODELMODULENAME", expression="t11.PSMODELMODULENAME", showorder=6), @DEDataQueryCodeExp(name="PSMODELID", expression="t1.PSMODELID", showorder=7), @DEDataQueryCodeExp(name="PSMODELMODULEID", expression="t1.PSMODELMODULEID", showorder=8), @DEDataQueryCodeExp(name="PSMODELMODULENAME", expression="t1.PSMODELMODULENAME", showorder=9), @DEDataQueryCodeExp(name="PSMODELNAME", expression="t1.PSMODELNAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=13)}, conds={})})
public class PSModelModuleDefaultDQModel
extends DEDataQueryModelBase {
    public PSModelModuleDefaultDQModel() {
        this.initAnnotation(PSModelModuleDefaultDQModel.class);
    }
}

