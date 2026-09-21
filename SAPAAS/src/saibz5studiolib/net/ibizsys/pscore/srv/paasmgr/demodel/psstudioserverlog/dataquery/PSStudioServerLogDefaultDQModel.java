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
package net.ibizsys.pscore.srv.paasmgr.demodel.psstudioserverlog.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="E86005CE-482A-43D2-8D10-209AB2DFA274", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DCCNT`, t1.`DEFAULTFLAG`, t1.`FREEMEMORY`, t1.`LOGTIME`, t1.`MAXMEMORY`, t1.`PSSTUDIOSERVERID`, t1.`PSSTUDIOSERVERLOGID`, t1.`PSSTUDIOSERVERLOGNAME`, t1.`PSSTUDIOSERVERNAME`, t1.`SYSMODELCNT`, t1.`SYSMODELINSTCNT`, t1.`THREADCNT`, t1.`TOTALMEMORY`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCNT` FROM `T_SRFPSSTUDIOSERVERLOG` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DCCNT", expression="t1.`DCCNT`", showorder=2), @DEDataQueryCodeExp(name="DEFAULTFLAG", expression="t1.`DEFAULTFLAG`", showorder=3), @DEDataQueryCodeExp(name="FREEMEMORY", expression="t1.`FREEMEMORY`", showorder=4), @DEDataQueryCodeExp(name="LOGTIME", expression="t1.`LOGTIME`", showorder=5), @DEDataQueryCodeExp(name="MAXMEMORY", expression="t1.`MAXMEMORY`", showorder=6), @DEDataQueryCodeExp(name="PSSTUDIOSERVERID", expression="t1.`PSSTUDIOSERVERID`", showorder=7), @DEDataQueryCodeExp(name="PSSTUDIOSERVERLOGID", expression="t1.`PSSTUDIOSERVERLOGID`", showorder=8), @DEDataQueryCodeExp(name="PSSTUDIOSERVERLOGNAME", expression="t1.`PSSTUDIOSERVERLOGNAME`", showorder=9), @DEDataQueryCodeExp(name="PSSTUDIOSERVERNAME", expression="t1.`PSSTUDIOSERVERNAME`", showorder=10), @DEDataQueryCodeExp(name="SYSMODELCNT", expression="t1.`SYSMODELCNT`", showorder=11), @DEDataQueryCodeExp(name="SYSMODELINSTCNT", expression="t1.`SYSMODELINSTCNT`", showorder=12), @DEDataQueryCodeExp(name="THREADCNT", expression="t1.`THREADCNT`", showorder=13), @DEDataQueryCodeExp(name="TOTALMEMORY", expression="t1.`TOTALMEMORY`", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=16), @DEDataQueryCodeExp(name="USERCNT", expression="t1.`USERCNT`", showorder=17)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DCCNT, t1.DEFAULTFLAG, t1.FREEMEMORY, t1.LOGTIME, t1.MAXMEMORY, t1.PSSTUDIOSERVERID, t1.PSSTUDIOSERVERLOGID, t1.PSSTUDIOSERVERLOGNAME, t1.PSSTUDIOSERVERNAME, t1.SYSMODELCNT, t1.SYSMODELINSTCNT, t1.THREADCNT, t1.TOTALMEMORY, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCNT FROM T_SRFPSSTUDIOSERVERLOG t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DCCNT", expression="t1.DCCNT", showorder=2), @DEDataQueryCodeExp(name="DEFAULTFLAG", expression="t1.DEFAULTFLAG", showorder=3), @DEDataQueryCodeExp(name="FREEMEMORY", expression="t1.FREEMEMORY", showorder=4), @DEDataQueryCodeExp(name="LOGTIME", expression="t1.LOGTIME", showorder=5), @DEDataQueryCodeExp(name="MAXMEMORY", expression="t1.MAXMEMORY", showorder=6), @DEDataQueryCodeExp(name="PSSTUDIOSERVERID", expression="t1.PSSTUDIOSERVERID", showorder=7), @DEDataQueryCodeExp(name="PSSTUDIOSERVERLOGID", expression="t1.PSSTUDIOSERVERLOGID", showorder=8), @DEDataQueryCodeExp(name="PSSTUDIOSERVERLOGNAME", expression="t1.PSSTUDIOSERVERLOGNAME", showorder=9), @DEDataQueryCodeExp(name="PSSTUDIOSERVERNAME", expression="t1.PSSTUDIOSERVERNAME", showorder=10), @DEDataQueryCodeExp(name="SYSMODELCNT", expression="t1.SYSMODELCNT", showorder=11), @DEDataQueryCodeExp(name="SYSMODELINSTCNT", expression="t1.SYSMODELINSTCNT", showorder=12), @DEDataQueryCodeExp(name="THREADCNT", expression="t1.THREADCNT", showorder=13), @DEDataQueryCodeExp(name="TOTALMEMORY", expression="t1.TOTALMEMORY", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=16), @DEDataQueryCodeExp(name="USERCNT", expression="t1.USERCNT", showorder=17)}, conds={})})
public class PSStudioServerLogDefaultDQModel
extends DEDataQueryModelBase {
    public PSStudioServerLogDefaultDQModel() {
        this.initAnnotation(PSStudioServerLogDefaultDQModel.class);
    }
}

