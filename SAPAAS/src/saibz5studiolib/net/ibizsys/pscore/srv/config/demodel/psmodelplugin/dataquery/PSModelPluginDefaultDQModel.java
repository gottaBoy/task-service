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
package net.ibizsys.pscore.srv.config.demodel.psmodelplugin.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="497221B6-0A09-45EA-BA43-AB97C4428B07", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DIFFOBJ`, t1.`MEMO`, t1.`PLUGINTYPE`, t1.`PSMODELID`, t11.`PSMODELNAME`, t1.`PSMODELPLUGINID`, t1.`PSMODELPLUGINNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSMODELPLUGIN` t1  LEFT JOIN T_SRFPSMODEL t11 ON t1.PSMODELID = t11.PSMODELID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="JSCODE", expression="t1.`JSCODE`", showorder=-1), @DEDataQueryCodeExp(name="PLUGINPARAMS", expression="t1.`PLUGINPARAMS`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DIFFOBJ", expression="t1.`DIFFOBJ`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PLUGINTYPE", expression="t1.`PLUGINTYPE`", showorder=4), @DEDataQueryCodeExp(name="PSMODELID", expression="t1.`PSMODELID`", showorder=5), @DEDataQueryCodeExp(name="PSMODELNAME", expression="t11.`PSMODELNAME`", showorder=6), @DEDataQueryCodeExp(name="PSMODELPLUGINID", expression="t1.`PSMODELPLUGINID`", showorder=7), @DEDataQueryCodeExp(name="PSMODELPLUGINNAME", expression="t1.`PSMODELPLUGINNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DIFFOBJ, t1.MEMO, t1.PLUGINTYPE, t1.PSMODELID, t11.PSMODELNAME, t1.PSMODELPLUGINID, t1.PSMODELPLUGINNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSMODELPLUGIN t1  LEFT JOIN T_SRFPSMODEL t11 ON t1.PSMODELID = t11.PSMODELID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="JSCODE", expression="t1.JSCODE", showorder=-1), @DEDataQueryCodeExp(name="PLUGINPARAMS", expression="t1.PLUGINPARAMS", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DIFFOBJ", expression="t1.DIFFOBJ", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PLUGINTYPE", expression="t1.PLUGINTYPE", showorder=4), @DEDataQueryCodeExp(name="PSMODELID", expression="t1.PSMODELID", showorder=5), @DEDataQueryCodeExp(name="PSMODELNAME", expression="t11.PSMODELNAME", showorder=6), @DEDataQueryCodeExp(name="PSMODELPLUGINID", expression="t1.PSMODELPLUGINID", showorder=7), @DEDataQueryCodeExp(name="PSMODELPLUGINNAME", expression="t1.PSMODELPLUGINNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=11)}, conds={})})
public class PSModelPluginDefaultDQModel
extends DEDataQueryModelBase {
    public PSModelPluginDefaultDQModel() {
        this.initAnnotation(PSModelPluginDefaultDQModel.class);
    }
}

