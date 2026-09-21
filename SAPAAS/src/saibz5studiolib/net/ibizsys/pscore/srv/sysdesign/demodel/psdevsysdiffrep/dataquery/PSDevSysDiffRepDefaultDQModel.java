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
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevsysdiffrep.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="43F3C1D7-2701-42C8-A730-BC2762E8CADE", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`BEGINTIME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DSTPSDEVSLNSYSID`, t1.`DSTPSDEVSLNSYSNAME`, t1.`DSTSYSMODELVER`, t1.`ENDTIME`, t1.`MEMO`, t1.`PSDEVSLNSYSID`, t11.`PSDEVSLNSYSNAME`, t1.`PSDEVSYSDIFFREPID`, t1.`PSDEVSYSDIFFREPNAME`, t1.`REPSTATE`, t1.`SYSMODELVER`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVSYSDIFFREP` t1  LEFT JOIN T_SRFPSDEVSLNSYS t11 ON t1.PSDEVSLNSYSID = t11.PSDEVSLNSYSID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="BEGINTIME", expression="t1.`BEGINTIME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="DSTPSDEVSLNSYSID", expression="t1.`DSTPSDEVSLNSYSID`", showorder=3), @DEDataQueryCodeExp(name="DSTPSDEVSLNSYSNAME", expression="t1.`DSTPSDEVSLNSYSNAME`", showorder=4), @DEDataQueryCodeExp(name="DSTSYSMODELVER", expression="t1.`DSTSYSMODELVER`", showorder=5), @DEDataQueryCodeExp(name="ENDTIME", expression="t1.`ENDTIME`", showorder=6), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=7), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.`PSDEVSLNSYSID`", showorder=8), @DEDataQueryCodeExp(name="PSDEVSLNSYSNAME", expression="t11.`PSDEVSLNSYSNAME`", showorder=9), @DEDataQueryCodeExp(name="PSDEVSYSDIFFREPID", expression="t1.`PSDEVSYSDIFFREPID`", showorder=10), @DEDataQueryCodeExp(name="PSDEVSYSDIFFREPNAME", expression="t1.`PSDEVSYSDIFFREPNAME`", showorder=11), @DEDataQueryCodeExp(name="REPSTATE", expression="t1.`REPSTATE`", showorder=12), @DEDataQueryCodeExp(name="SYSMODELVER", expression="t1.`SYSMODELVER`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.BEGINTIME, t1.CREATEDATE, t1.CREATEMAN, t1.DSTPSDEVSLNSYSID, t1.DSTPSDEVSLNSYSNAME, t1.DSTSYSMODELVER, t1.ENDTIME, t1.MEMO, t1.PSDEVSLNSYSID, t11.PSDEVSLNSYSNAME, t1.PSDEVSYSDIFFREPID, t1.PSDEVSYSDIFFREPNAME, t1.REPSTATE, t1.SYSMODELVER, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVSYSDIFFREP t1  LEFT JOIN T_SRFPSDEVSLNSYS t11 ON t1.PSDEVSLNSYSID = t11.PSDEVSLNSYSID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="BEGINTIME", expression="t1.BEGINTIME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="DSTPSDEVSLNSYSID", expression="t1.DSTPSDEVSLNSYSID", showorder=3), @DEDataQueryCodeExp(name="DSTPSDEVSLNSYSNAME", expression="t1.DSTPSDEVSLNSYSNAME", showorder=4), @DEDataQueryCodeExp(name="DSTSYSMODELVER", expression="t1.DSTSYSMODELVER", showorder=5), @DEDataQueryCodeExp(name="ENDTIME", expression="t1.ENDTIME", showorder=6), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=7), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.PSDEVSLNSYSID", showorder=8), @DEDataQueryCodeExp(name="PSDEVSLNSYSNAME", expression="t11.PSDEVSLNSYSNAME", showorder=9), @DEDataQueryCodeExp(name="PSDEVSYSDIFFREPID", expression="t1.PSDEVSYSDIFFREPID", showorder=10), @DEDataQueryCodeExp(name="PSDEVSYSDIFFREPNAME", expression="t1.PSDEVSYSDIFFREPNAME", showorder=11), @DEDataQueryCodeExp(name="REPSTATE", expression="t1.REPSTATE", showorder=12), @DEDataQueryCodeExp(name="SYSMODELVER", expression="t1.SYSMODELVER", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15)}, conds={})})
public class PSDevSysDiffRepDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevSysDiffRepDefaultDQModel() {
        this.initAnnotation(PSDevSysDiffRepDefaultDQModel.class);
    }
}

