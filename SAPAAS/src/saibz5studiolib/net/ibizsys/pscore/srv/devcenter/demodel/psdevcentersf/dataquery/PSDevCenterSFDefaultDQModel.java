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
package net.ibizsys.pscore.srv.devcenter.demodel.psdevcentersf.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="DA081F02-E4BA-413B-9E82-35B432B4FB2F", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSDEVCENTERID`, t11.`PSDEVCENTERNAME`, t1.`PSDEVCENTERSFID`, t1.`PSDEVCENTERSFNAME`, t1.`PSSFID`, t1.`PSSFNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVCENTERSF` t1  LEFT JOIN T_SRFPSDEVCENTER t11 ON t1.PSDEVCENTERID = t11.PSDEVCENTERID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=2), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t11.`PSDEVCENTERNAME`", showorder=3), @DEDataQueryCodeExp(name="PSDEVCENTERSFID", expression="t1.`PSDEVCENTERSFID`", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERSFNAME", expression="t1.`PSDEVCENTERSFNAME`", showorder=5), @DEDataQueryCodeExp(name="PSSFID", expression="t1.`PSSFID`", showorder=6), @DEDataQueryCodeExp(name="PSSFNAME", expression="t1.`PSSFNAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSDEVCENTERID, t11.PSDEVCENTERNAME, t1.PSDEVCENTERSFID, t1.PSDEVCENTERSFNAME, t1.PSSFID, t1.PSSFNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVCENTERSF t1  LEFT JOIN T_SRFPSDEVCENTER t11 ON t1.PSDEVCENTERID = t11.PSDEVCENTERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=2), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t11.PSDEVCENTERNAME", showorder=3), @DEDataQueryCodeExp(name="PSDEVCENTERSFID", expression="t1.PSDEVCENTERSFID", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERSFNAME", expression="t1.PSDEVCENTERSFNAME", showorder=5), @DEDataQueryCodeExp(name="PSSFID", expression="t1.PSSFID", showorder=6), @DEDataQueryCodeExp(name="PSSFNAME", expression="t1.PSSFNAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSDevCenterSFDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevCenterSFDefaultDQModel() {
        this.initAnnotation(PSDevCenterSFDefaultDQModel.class);
    }
}

