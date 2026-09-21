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
package net.ibizsys.pscore.srv.devcenter.demodel.psdevcenterres.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="68AA6BD1-7D5C-45C8-93A4-87D344EA614C", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ALLOCATED`, t1.`ALLOCATEDINFO`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEVCENTERID`, t11.`PSDEVCENTERNAME`, t1.`PSDEVCENTERRESID`, t1.`PSDEVCENTERRESNAME`, t1.`RESTYPE`, t1.`TIMETAG`, t1.`TIMETYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USED`, t1.`USEDINFO` FROM `T_SRFPSDEVCENTERRES` t1  LEFT JOIN `T_SRFPSDEVCENTER` t11 ON t1.`PSDEVCENTERID` = t11.`PSDEVCENTERID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ALLOCATED", expression="t1.`ALLOCATED`", showorder=0), @DEDataQueryCodeExp(name="ALLOCATEDINFO", expression="t1.`ALLOCATEDINFO`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t11.`PSDEVCENTERNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERRESID", expression="t1.`PSDEVCENTERRESID`", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERRESNAME", expression="t1.`PSDEVCENTERRESNAME`", showorder=8), @DEDataQueryCodeExp(name="RESTYPE", expression="t1.`RESTYPE`", showorder=9), @DEDataQueryCodeExp(name="TIMETAG", expression="t1.`TIMETAG`", showorder=10), @DEDataQueryCodeExp(name="TIMETYPE", expression="t1.`TIMETYPE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13), @DEDataQueryCodeExp(name="USED", expression="t1.`USED`", showorder=14), @DEDataQueryCodeExp(name="USEDINFO", expression="t1.`USEDINFO`", showorder=15)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.ALLOCATED, t1.ALLOCATEDINFO, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEVCENTERID, t11.PSDEVCENTERNAME, t1.PSDEVCENTERRESID, t1.PSDEVCENTERRESNAME, t1.RESTYPE, t1.TIMETAG, t1.TIMETYPE, t1.UPDATEDATE, t1.UPDATEMAN, t1.USED, t1.USEDINFO FROM T_SRFPSDEVCENTERRES t1  LEFT JOIN T_SRFPSDEVCENTER t11 ON t1.PSDEVCENTERID = t11.PSDEVCENTERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ALLOCATED", expression="t1.ALLOCATED", showorder=0), @DEDataQueryCodeExp(name="ALLOCATEDINFO", expression="t1.ALLOCATEDINFO", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t11.PSDEVCENTERNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERRESID", expression="t1.PSDEVCENTERRESID", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERRESNAME", expression="t1.PSDEVCENTERRESNAME", showorder=8), @DEDataQueryCodeExp(name="RESTYPE", expression="t1.RESTYPE", showorder=9), @DEDataQueryCodeExp(name="TIMETAG", expression="t1.TIMETAG", showorder=10), @DEDataQueryCodeExp(name="TIMETYPE", expression="t1.TIMETYPE", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13), @DEDataQueryCodeExp(name="USED", expression="t1.USED", showorder=14), @DEDataQueryCodeExp(name="USEDINFO", expression="t1.USEDINFO", showorder=15)}, conds={})})
public class PSDevCenterResDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevCenterResDefaultDQModel() {
        this.initAnnotation(PSDevCenterResDefaultDQModel.class);
    }
}

