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
package net.ibizsys.pscore.srv.paasmgr.demodel.psdevslnsysts.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="E3DD7390-10B3-4B01-BB3F-2A47AD5E7B24", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOADTIME`, t1.`MEMO`, t1.`PSDEVSLNSYSID`, t1.`PSDEVSLNSYSNAME`, t1.`PSDEVSLNSYSTSID`, t1.`PSDEVSLNSYSTSNAME`, t1.`PSTASKSERVERID`, t1.`PSTASKSERVERNAME`, t1.`UNLOADTIME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVSLNSYSTS` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="LOADTIME", expression="t1.`LOADTIME`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.`PSDEVSLNSYSID`", showorder=4), @DEDataQueryCodeExp(name="PSDEVSLNSYSNAME", expression="t1.`PSDEVSLNSYSNAME`", showorder=5), @DEDataQueryCodeExp(name="PSDEVSLNSYSTSID", expression="t1.`PSDEVSLNSYSTSID`", showorder=6), @DEDataQueryCodeExp(name="PSDEVSLNSYSTSNAME", expression="t1.`PSDEVSLNSYSTSNAME`", showorder=7), @DEDataQueryCodeExp(name="PSTASKSERVERID", expression="t1.`PSTASKSERVERID`", showorder=8), @DEDataQueryCodeExp(name="PSTASKSERVERNAME", expression="t1.`PSTASKSERVERNAME`", showorder=9), @DEDataQueryCodeExp(name="UNLOADTIME", expression="t1.`UNLOADTIME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.LOADTIME, t1.MEMO, t1.PSDEVSLNSYSID, t1.PSDEVSLNSYSNAME, t1.PSDEVSLNSYSTSID, t1.PSDEVSLNSYSTSNAME, t1.PSTASKSERVERID, t1.PSTASKSERVERNAME, t1.UNLOADTIME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVSLNSYSTS t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="LOADTIME", expression="t1.LOADTIME", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.PSDEVSLNSYSID", showorder=4), @DEDataQueryCodeExp(name="PSDEVSLNSYSNAME", expression="t1.PSDEVSLNSYSNAME", showorder=5), @DEDataQueryCodeExp(name="PSDEVSLNSYSTSID", expression="t1.PSDEVSLNSYSTSID", showorder=6), @DEDataQueryCodeExp(name="PSDEVSLNSYSTSNAME", expression="t1.PSDEVSLNSYSTSNAME", showorder=7), @DEDataQueryCodeExp(name="PSTASKSERVERID", expression="t1.PSTASKSERVERID", showorder=8), @DEDataQueryCodeExp(name="PSTASKSERVERNAME", expression="t1.PSTASKSERVERNAME", showorder=9), @DEDataQueryCodeExp(name="UNLOADTIME", expression="t1.UNLOADTIME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSDevSlnSysTSDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevSlnSysTSDefaultDQModel() {
        this.initAnnotation(PSDevSlnSysTSDefaultDQModel.class);
    }
}

