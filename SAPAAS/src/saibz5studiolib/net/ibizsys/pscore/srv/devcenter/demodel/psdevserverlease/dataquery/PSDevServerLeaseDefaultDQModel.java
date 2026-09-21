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
package net.ibizsys.pscore.srv.devcenter.demodel.psdevserverlease.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="73413971-3E33-43A5-9391-43ED5C1EAEF7", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`BEGINTIME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENDTIME`, t1.`LEASESTATE`, t1.`MEMO`, t1.`PSDEVCENTERID`, t11.`PSDEVCENTERNAME`, t1.`PSDEVSERVERID`, t1.`PSDEVSERVERLEASEID`, t1.`PSDEVSERVERLEASENAME`, t21.`PSDEVSERVERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVSERVERLEASE` t1  LEFT JOIN T_SRFPSDEVCENTER t11 ON t1.PSDEVCENTERID = t11.PSDEVCENTERID  LEFT JOIN T_SRFPSDEVSERVER t21 ON t1.PSDEVSERVERID = t21.PSDEVSERVERID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="BEGINTIME", expression="t1.`BEGINTIME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="ENDTIME", expression="t1.`ENDTIME`", showorder=3), @DEDataQueryCodeExp(name="LEASESTATE", expression="t1.`LEASESTATE`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t11.`PSDEVCENTERNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDEVSERVERID", expression="t1.`PSDEVSERVERID`", showorder=8), @DEDataQueryCodeExp(name="PSDEVSERVERLEASEID", expression="t1.`PSDEVSERVERLEASEID`", showorder=9), @DEDataQueryCodeExp(name="PSDEVSERVERLEASENAME", expression="t1.`PSDEVSERVERLEASENAME`", showorder=10), @DEDataQueryCodeExp(name="PSDEVSERVERNAME", expression="t21.`PSDEVSERVERNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.BEGINTIME, t1.CREATEDATE, t1.CREATEMAN, t1.ENDTIME, t1.LEASESTATE, t1.MEMO, t1.PSDEVCENTERID, t11.PSDEVCENTERNAME, t1.PSDEVSERVERID, t1.PSDEVSERVERLEASEID, t1.PSDEVSERVERLEASENAME, t21.PSDEVSERVERNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVSERVERLEASE t1  LEFT JOIN T_SRFPSDEVCENTER t11 ON t1.PSDEVCENTERID = t11.PSDEVCENTERID  LEFT JOIN T_SRFPSDEVSERVER t21 ON t1.PSDEVSERVERID = t21.PSDEVSERVERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="BEGINTIME", expression="t1.BEGINTIME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="ENDTIME", expression="t1.ENDTIME", showorder=3), @DEDataQueryCodeExp(name="LEASESTATE", expression="t1.LEASESTATE", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t11.PSDEVCENTERNAME", showorder=7), @DEDataQueryCodeExp(name="PSDEVSERVERID", expression="t1.PSDEVSERVERID", showorder=8), @DEDataQueryCodeExp(name="PSDEVSERVERLEASEID", expression="t1.PSDEVSERVERLEASEID", showorder=9), @DEDataQueryCodeExp(name="PSDEVSERVERLEASENAME", expression="t1.PSDEVSERVERLEASENAME", showorder=10), @DEDataQueryCodeExp(name="PSDEVSERVERNAME", expression="t21.PSDEVSERVERNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSDevServerLeaseDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevServerLeaseDefaultDQModel() {
        this.initAnnotation(PSDevServerLeaseDefaultDQModel.class);
    }
}

