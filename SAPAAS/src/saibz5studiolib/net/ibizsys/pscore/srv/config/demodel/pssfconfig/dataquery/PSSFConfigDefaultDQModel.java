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
package net.ibizsys.pscore.srv.config.demodel.pssfconfig.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="4F313362-E3A0-4331-887B-94521E6CD14A", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CONFIGCAT`, t1.`CONFIGDESC`, t1.`CONFIGVALUE`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSSFCONFIGID`, t1.`PSSFCONFIGNAME`, t1.`PSSFID`, t1.`PSSFNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSFCONFIG` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CONFIGCAT", expression="t1.`CONFIGCAT`", showorder=0), @DEDataQueryCodeExp(name="CONFIGDESC", expression="t1.`CONFIGDESC`", showorder=1), @DEDataQueryCodeExp(name="CONFIGVALUE", expression="t1.`CONFIGVALUE`", showorder=2), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=3), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=6), @DEDataQueryCodeExp(name="PSSFCONFIGID", expression="t1.`PSSFCONFIGID`", showorder=7), @DEDataQueryCodeExp(name="PSSFCONFIGNAME", expression="t1.`PSSFCONFIGNAME`", showorder=8), @DEDataQueryCodeExp(name="PSSFID", expression="t1.`PSSFID`", showorder=9), @DEDataQueryCodeExp(name="PSSFNAME", expression="t1.`PSSFNAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CONFIGCAT, t1.CONFIGDESC, t1.CONFIGVALUE, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PSSFCONFIGID, t1.PSSFCONFIGNAME, t1.PSSFID, t1.PSSFNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSFCONFIG t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CONFIGCAT", expression="t1.CONFIGCAT", showorder=0), @DEDataQueryCodeExp(name="CONFIGDESC", expression="t1.CONFIGDESC", showorder=1), @DEDataQueryCodeExp(name="CONFIGVALUE", expression="t1.CONFIGVALUE", showorder=2), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=3), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=6), @DEDataQueryCodeExp(name="PSSFCONFIGID", expression="t1.PSSFCONFIGID", showorder=7), @DEDataQueryCodeExp(name="PSSFCONFIGNAME", expression="t1.PSSFCONFIGNAME", showorder=8), @DEDataQueryCodeExp(name="PSSFID", expression="t1.PSSFID", showorder=9), @DEDataQueryCodeExp(name="PSSFNAME", expression="t1.PSSFNAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSSFConfigDefaultDQModel
extends DEDataQueryModelBase {
    public PSSFConfigDefaultDQModel() {
        this.initAnnotation(PSSFConfigDefaultDQModel.class);
    }
}

