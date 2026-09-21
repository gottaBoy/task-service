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
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnsyspatch.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="00495B26-DEF9-4354-863D-3BD44A0F2413", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`FROMPSDEVSLNSYSVERID`, t11.`PSDEVSLNSYSVERNAME` AS `FROMPSDEVSLNSYSVERNAME`, t1.`MEMO`, t1.`PSDEVSLNSYSID`, t1.`PSDEVSLNSYSPATCHID`, t1.`PSDEVSLNSYSPATCHNAME`, t1.`PSDEVSLNSYSVERID`, t21.`PSDEVSLNSYSVERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVSLNSYSPATCH` t1  LEFT JOIN T_SRFPSDEVSLNSYSVER t11 ON t1.FROMPSDEVSLNSYSVERID = t11.PSDEVSLNSYSVERID  LEFT JOIN T_SRFPSDEVSLNSYSVER t21 ON t1.PSDEVSLNSYSVERID = t21.PSDEVSLNSYSVERID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="FROMPSDEVSLNSYSVERID", expression="t1.`FROMPSDEVSLNSYSVERID`", showorder=2), @DEDataQueryCodeExp(name="FROMPSDEVSLNSYSVERNAME", expression="t11.`PSDEVSLNSYSVERNAME`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.`PSDEVSLNSYSID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVSLNSYSPATCHID", expression="t1.`PSDEVSLNSYSPATCHID`", showorder=6), @DEDataQueryCodeExp(name="PSDEVSLNSYSPATCHNAME", expression="t1.`PSDEVSLNSYSPATCHNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDEVSLNSYSVERID", expression="t1.`PSDEVSLNSYSVERID`", showorder=8), @DEDataQueryCodeExp(name="PSDEVSLNSYSVERNAME", expression="t21.`PSDEVSLNSYSVERNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.FROMPSDEVSLNSYSVERID, t11.PSDEVSLNSYSVERNAME AS FROMPSDEVSLNSYSVERNAME, t1.MEMO, t1.PSDEVSLNSYSID, t1.PSDEVSLNSYSPATCHID, t1.PSDEVSLNSYSPATCHNAME, t1.PSDEVSLNSYSVERID, t21.PSDEVSLNSYSVERNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVSLNSYSPATCH t1  LEFT JOIN T_SRFPSDEVSLNSYSVER t11 ON t1.FROMPSDEVSLNSYSVERID = t11.PSDEVSLNSYSVERID  LEFT JOIN T_SRFPSDEVSLNSYSVER t21 ON t1.PSDEVSLNSYSVERID = t21.PSDEVSLNSYSVERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="FROMPSDEVSLNSYSVERID", expression="t1.FROMPSDEVSLNSYSVERID", showorder=2), @DEDataQueryCodeExp(name="FROMPSDEVSLNSYSVERNAME", expression="t11.PSDEVSLNSYSVERNAME", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.PSDEVSLNSYSID", showorder=5), @DEDataQueryCodeExp(name="PSDEVSLNSYSPATCHID", expression="t1.PSDEVSLNSYSPATCHID", showorder=6), @DEDataQueryCodeExp(name="PSDEVSLNSYSPATCHNAME", expression="t1.PSDEVSLNSYSPATCHNAME", showorder=7), @DEDataQueryCodeExp(name="PSDEVSLNSYSVERID", expression="t1.PSDEVSLNSYSVERID", showorder=8), @DEDataQueryCodeExp(name="PSDEVSLNSYSVERNAME", expression="t21.PSDEVSLNSYSVERNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSDevSlnSysPatchDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevSlnSysPatchDefaultDQModel() {
        this.initAnnotation(PSDevSlnSysPatchDefaultDQModel.class);
    }
}

