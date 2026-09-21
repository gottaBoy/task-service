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
package net.ibizsys.pscore.srv.config.demodel.pssfplugintempl.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="29E31C94-FC28-4868-B601-A36ED14FFCE5", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSSFID`, t1.`PSSFNAME`, t1.`PSSFPLUGINID`, t11.`PSSFPLUGINNAME`, t1.`PSSFPLUGINTEMPLID`, t1.`PSSFPLUGINTEMPLNAME`, t1.`TEMPLCODE`, t1.`TEMPLCODE2`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSFPLUGINTEMPL` t1  LEFT JOIN T_SRFPSSFPLUGIN t11 ON t1.PSSFPLUGINID = t11.PSSFPLUGINID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSSFID", expression="t1.`PSSFID`", showorder=3), @DEDataQueryCodeExp(name="PSSFNAME", expression="t1.`PSSFNAME`", showorder=4), @DEDataQueryCodeExp(name="PSSFPLUGINID", expression="t1.`PSSFPLUGINID`", showorder=5), @DEDataQueryCodeExp(name="PSSFPLUGINNAME", expression="t11.`PSSFPLUGINNAME`", showorder=6), @DEDataQueryCodeExp(name="PSSFPLUGINTEMPLID", expression="t1.`PSSFPLUGINTEMPLID`", showorder=7), @DEDataQueryCodeExp(name="PSSFPLUGINTEMPLNAME", expression="t1.`PSSFPLUGINTEMPLNAME`", showorder=8), @DEDataQueryCodeExp(name="TEMPLCODE", expression="t1.`TEMPLCODE`", showorder=9), @DEDataQueryCodeExp(name="TEMPLCODE2", expression="t1.`TEMPLCODE2`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSSFID, t1.PSSFNAME, t1.PSSFPLUGINID, t11.PSSFPLUGINNAME, t1.PSSFPLUGINTEMPLID, t1.PSSFPLUGINTEMPLNAME, t1.TEMPLCODE, t1.TEMPLCODE2, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSFPLUGINTEMPL t1  LEFT JOIN T_SRFPSSFPLUGIN t11 ON t1.PSSFPLUGINID = t11.PSSFPLUGINID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSSFID", expression="t1.PSSFID", showorder=3), @DEDataQueryCodeExp(name="PSSFNAME", expression="t1.PSSFNAME", showorder=4), @DEDataQueryCodeExp(name="PSSFPLUGINID", expression="t1.PSSFPLUGINID", showorder=5), @DEDataQueryCodeExp(name="PSSFPLUGINNAME", expression="t11.PSSFPLUGINNAME", showorder=6), @DEDataQueryCodeExp(name="PSSFPLUGINTEMPLID", expression="t1.PSSFPLUGINTEMPLID", showorder=7), @DEDataQueryCodeExp(name="PSSFPLUGINTEMPLNAME", expression="t1.PSSFPLUGINTEMPLNAME", showorder=8), @DEDataQueryCodeExp(name="TEMPLCODE", expression="t1.TEMPLCODE", showorder=9), @DEDataQueryCodeExp(name="TEMPLCODE2", expression="t1.TEMPLCODE2", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSSFPluginTemplDefaultDQModel
extends DEDataQueryModelBase {
    public PSSFPluginTemplDefaultDQModel() {
        this.initAnnotation(PSSFPluginTemplDefaultDQModel.class);
    }
}

