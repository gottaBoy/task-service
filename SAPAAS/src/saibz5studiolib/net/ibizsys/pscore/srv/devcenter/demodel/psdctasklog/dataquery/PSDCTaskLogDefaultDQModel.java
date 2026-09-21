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
package net.ibizsys.pscore.srv.devcenter.demodel.psdctasklog.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="D5AB72D4-7FEF-4B98-A0D6-66F702D8A721", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`BEGINTIME`, t1.`COST`, t1.`COSTLEVEL`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENDTIME`, t1.`PSDCTASKLOGID`, t1.`PSDCTASKLOGNAME`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`PSDEVSLNID`, t1.`PSDEVSLNNAME`, t1.`PSDEVSLNSYSID`, t1.`PSDEVSLNSYSNAME`, t1.`PSTASKSERVERID`, t1.`PSTASKSERVERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDCTASKLOG` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="BEGINTIME", expression="t1.`BEGINTIME`", showorder=0), @DEDataQueryCodeExp(name="COST", expression="t1.`COST`", showorder=1), @DEDataQueryCodeExp(name="COSTLEVEL", expression="t1.`COSTLEVEL`", showorder=2), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=3), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=4), @DEDataQueryCodeExp(name="ENDTIME", expression="t1.`ENDTIME`", showorder=5), @DEDataQueryCodeExp(name="PSDCTASKLOGID", expression="t1.`PSDCTASKLOGID`", showorder=6), @DEDataQueryCodeExp(name="PSDCTASKLOGNAME", expression="t1.`PSDCTASKLOGNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=9), @DEDataQueryCodeExp(name="PSDEVSLNID", expression="t1.`PSDEVSLNID`", showorder=10), @DEDataQueryCodeExp(name="PSDEVSLNNAME", expression="t1.`PSDEVSLNNAME`", showorder=11), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.`PSDEVSLNSYSID`", showorder=12), @DEDataQueryCodeExp(name="PSDEVSLNSYSNAME", expression="t1.`PSDEVSLNSYSNAME`", showorder=13), @DEDataQueryCodeExp(name="PSTASKSERVERID", expression="t1.`PSTASKSERVERID`", showorder=14), @DEDataQueryCodeExp(name="PSTASKSERVERNAME", expression="t1.`PSTASKSERVERNAME`", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=17)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.BEGINTIME, t1.COST, t1.COSTLEVEL, t1.CREATEDATE, t1.CREATEMAN, t1.ENDTIME, t1.PSDCTASKLOGID, t1.PSDCTASKLOGNAME, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.PSDEVSLNID, t1.PSDEVSLNNAME, t1.PSDEVSLNSYSID, t1.PSDEVSLNSYSNAME, t1.PSTASKSERVERID, t1.PSTASKSERVERNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDCTASKLOG t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="BEGINTIME", expression="t1.BEGINTIME", showorder=0), @DEDataQueryCodeExp(name="COST", expression="t1.COST", showorder=1), @DEDataQueryCodeExp(name="COSTLEVEL", expression="t1.COSTLEVEL", showorder=2), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=3), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=4), @DEDataQueryCodeExp(name="ENDTIME", expression="t1.ENDTIME", showorder=5), @DEDataQueryCodeExp(name="PSDCTASKLOGID", expression="t1.PSDCTASKLOGID", showorder=6), @DEDataQueryCodeExp(name="PSDCTASKLOGNAME", expression="t1.PSDCTASKLOGNAME", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=9), @DEDataQueryCodeExp(name="PSDEVSLNID", expression="t1.PSDEVSLNID", showorder=10), @DEDataQueryCodeExp(name="PSDEVSLNNAME", expression="t1.PSDEVSLNNAME", showorder=11), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.PSDEVSLNSYSID", showorder=12), @DEDataQueryCodeExp(name="PSDEVSLNSYSNAME", expression="t1.PSDEVSLNSYSNAME", showorder=13), @DEDataQueryCodeExp(name="PSTASKSERVERID", expression="t1.PSTASKSERVERID", showorder=14), @DEDataQueryCodeExp(name="PSTASKSERVERNAME", expression="t1.PSTASKSERVERNAME", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=17)}, conds={})})
public class PSDCTaskLogDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCTaskLogDefaultDQModel() {
        this.initAnnotation(PSDCTaskLogDefaultDQModel.class);
    }
}

