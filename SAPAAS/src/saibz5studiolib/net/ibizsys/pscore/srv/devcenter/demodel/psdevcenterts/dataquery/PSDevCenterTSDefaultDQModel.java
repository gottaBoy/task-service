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
package net.ibizsys.pscore.srv.devcenter.demodel.psdevcenterts.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="13EB570B-8782-4CC0-B06F-F0524518791C", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`JITPSTASKSERVERID`, t11.`PSTASKSERVERNAME` AS `JITPSTASKSERVERNAME`, t1.`MEMO`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`PSDEVCENTERTSID`, t1.`PSDEVCENTERTSNAME`, t1.`PSTASKSERVERID`, t1.`PSTASKSERVERNAME`, t21.`SERVERUSAGE`, t21.`SYSVER`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDEVCENTERTS` t1  LEFT JOIN `T_SRFPSTASKSERVER` t11 ON t1.`JITPSTASKSERVERID` = t11.`PSTASKSERVERID`  LEFT JOIN `T_SRFPSTASKSERVER` t21 ON t1.`PSTASKSERVERID` = t21.`PSTASKSERVERID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="JITPSTASKSERVERID", expression="t1.`JITPSTASKSERVERID`", showorder=2), @DEDataQueryCodeExp(name="JITPSTASKSERVERNAME", expression="t11.`PSTASKSERVERNAME`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERTSID", expression="t1.`PSDEVCENTERTSID`", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERTSNAME", expression="t1.`PSDEVCENTERTSNAME`", showorder=8), @DEDataQueryCodeExp(name="PSTASKSERVERID", expression="t1.`PSTASKSERVERID`", showorder=9), @DEDataQueryCodeExp(name="PSTASKSERVERNAME", expression="t1.`PSTASKSERVERNAME`", showorder=10), @DEDataQueryCodeExp(name="SERVERUSAGE", expression="t21.`SERVERUSAGE`", showorder=11), @DEDataQueryCodeExp(name="SYSVER", expression="t21.`SYSVER`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=15)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.JITPSTASKSERVERID, t11.PSTASKSERVERNAME AS JITPSTASKSERVERNAME, t1.MEMO, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.PSDEVCENTERTSID, t1.PSDEVCENTERTSNAME, t1.PSTASKSERVERID, t1.PSTASKSERVERNAME, t21.SERVERUSAGE, t21.SYSVER, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDEVCENTERTS t1  LEFT JOIN T_SRFPSTASKSERVER t11 ON t1.JITPSTASKSERVERID = t11.PSTASKSERVERID  LEFT JOIN T_SRFPSTASKSERVER t21 ON t1.PSTASKSERVERID = t21.PSTASKSERVERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="JITPSTASKSERVERID", expression="t1.JITPSTASKSERVERID", showorder=2), @DEDataQueryCodeExp(name="JITPSTASKSERVERNAME", expression="t11.PSTASKSERVERNAME", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERTSID", expression="t1.PSDEVCENTERTSID", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERTSNAME", expression="t1.PSDEVCENTERTSNAME", showorder=8), @DEDataQueryCodeExp(name="PSTASKSERVERID", expression="t1.PSTASKSERVERID", showorder=9), @DEDataQueryCodeExp(name="PSTASKSERVERNAME", expression="t1.PSTASKSERVERNAME", showorder=10), @DEDataQueryCodeExp(name="SERVERUSAGE", expression="t21.SERVERUSAGE", showorder=11), @DEDataQueryCodeExp(name="SYSVER", expression="t21.SYSVER", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=15)}, conds={})})
public class PSDevCenterTSDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevCenterTSDefaultDQModel() {
        this.initAnnotation(PSDevCenterTSDefaultDQModel.class);
    }
}

