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
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psdevslnsyslocklog.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="21751A0E-79C5-4D32-B1DB-15ED8EF8914A", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOCKREASON`, t1.`LOCKTYPE`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`PSDEVSLNSYSID`, t1.`PSDEVSLNSYSLOCKLOGID`, t1.`PSDEVSLNSYSLOCKLOGNAME`, t1.`PSDEVSLNSYSNAME`, t1.`UNLOCKTIME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVSLNSYSLOCKLOG` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="LOGPARAM", expression="t1.`LOGPARAM`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="LOCKREASON", expression="t1.`LOCKREASON`", showorder=2), @DEDataQueryCodeExp(name="LOCKTYPE", expression="t1.`LOCKTYPE`", showorder=3), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=5), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.`PSDEVSLNSYSID`", showorder=6), @DEDataQueryCodeExp(name="PSDEVSLNSYSLOCKLOGID", expression="t1.`PSDEVSLNSYSLOCKLOGID`", showorder=7), @DEDataQueryCodeExp(name="PSDEVSLNSYSLOCKLOGNAME", expression="t1.`PSDEVSLNSYSLOCKLOGNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDEVSLNSYSNAME", expression="t1.`PSDEVSLNSYSNAME`", showorder=9), @DEDataQueryCodeExp(name="UNLOCKTIME", expression="t1.`UNLOCKTIME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.LOCKREASON, t1.LOCKTYPE, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.PSDEVSLNSYSID, t1.PSDEVSLNSYSLOCKLOGID, t1.PSDEVSLNSYSLOCKLOGNAME, t1.PSDEVSLNSYSNAME, t1.UNLOCKTIME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVSLNSYSLOCKLOG t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="LOGPARAM", expression="t1.LOGPARAM", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="LOCKREASON", expression="t1.LOCKREASON", showorder=2), @DEDataQueryCodeExp(name="LOCKTYPE", expression="t1.LOCKTYPE", showorder=3), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=5), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.PSDEVSLNSYSID", showorder=6), @DEDataQueryCodeExp(name="PSDEVSLNSYSLOCKLOGID", expression="t1.PSDEVSLNSYSLOCKLOGID", showorder=7), @DEDataQueryCodeExp(name="PSDEVSLNSYSLOCKLOGNAME", expression="t1.PSDEVSLNSYSLOCKLOGNAME", showorder=8), @DEDataQueryCodeExp(name="PSDEVSLNSYSNAME", expression="t1.PSDEVSLNSYSNAME", showorder=9), @DEDataQueryCodeExp(name="UNLOCKTIME", expression="t1.UNLOCKTIME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSDevSlnSysLockLogDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevSlnSysLockLogDefaultDQModel() {
        this.initAnnotation(PSDevSlnSysLockLogDefaultDQModel.class);
    }
}

