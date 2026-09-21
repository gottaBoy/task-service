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
package net.ibizsys.pscore.srv.config.demodel.psviewstyle.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="D6963AED-7A6B-450E-8A79-D4477226E263", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`EXTENDCTRL`, t1.`EXTENDVIEW`, t1.`MEMO`, t1.`NAMEMODE`, t1.`PSDCID`, t1.`PSDCNAME`, t1.`PSPFPLUGINID`, t11.`PSPFPLUGINNAME`, t1.`PSVIEWSTYLEID`, t1.`PSVIEWSTYLENAME`, t1.`TYPECODE`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSVIEWSTYLE` t1  LEFT JOIN `T_SRFPSPFPLUGIN` t11 ON t1.`PSPFPLUGINID` = t11.`PSPFPLUGINID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="VIEWPARAMS", expression="t1.`VIEWPARAMS`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="EXTENDCTRL", expression="t1.`EXTENDCTRL`", showorder=2), @DEDataQueryCodeExp(name="EXTENDVIEW", expression="t1.`EXTENDVIEW`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="NAMEMODE", expression="t1.`NAMEMODE`", showorder=5), @DEDataQueryCodeExp(name="PSDCID", expression="t1.`PSDCID`", showorder=6), @DEDataQueryCodeExp(name="PSDCNAME", expression="t1.`PSDCNAME`", showorder=7), @DEDataQueryCodeExp(name="PSPFPLUGINID", expression="t1.`PSPFPLUGINID`", showorder=8), @DEDataQueryCodeExp(name="PSPFPLUGINNAME", expression="t11.`PSPFPLUGINNAME`", showorder=9), @DEDataQueryCodeExp(name="PSVIEWSTYLEID", expression="t1.`PSVIEWSTYLEID`", showorder=10), @DEDataQueryCodeExp(name="PSVIEWSTYLENAME", expression="t1.`PSVIEWSTYLENAME`", showorder=11), @DEDataQueryCodeExp(name="TYPECODE", expression="t1.`TYPECODE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.EXTENDCTRL, t1.EXTENDVIEW, t1.MEMO, t1.NAMEMODE, t1.PSDCID, t1.PSDCNAME, t1.PSPFPLUGINID, t11.PSPFPLUGINNAME, t1.PSVIEWSTYLEID, t1.PSVIEWSTYLENAME, t1.TYPECODE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSVIEWSTYLE t1  LEFT JOIN T_SRFPSPFPLUGIN t11 ON t1.PSPFPLUGINID = t11.PSPFPLUGINID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="VIEWPARAMS", expression="t1.VIEWPARAMS", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="EXTENDCTRL", expression="t1.EXTENDCTRL", showorder=2), @DEDataQueryCodeExp(name="EXTENDVIEW", expression="t1.EXTENDVIEW", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="NAMEMODE", expression="t1.NAMEMODE", showorder=5), @DEDataQueryCodeExp(name="PSDCID", expression="t1.PSDCID", showorder=6), @DEDataQueryCodeExp(name="PSDCNAME", expression="t1.PSDCNAME", showorder=7), @DEDataQueryCodeExp(name="PSPFPLUGINID", expression="t1.PSPFPLUGINID", showorder=8), @DEDataQueryCodeExp(name="PSPFPLUGINNAME", expression="t11.PSPFPLUGINNAME", showorder=9), @DEDataQueryCodeExp(name="PSVIEWSTYLEID", expression="t1.PSVIEWSTYLEID", showorder=10), @DEDataQueryCodeExp(name="PSVIEWSTYLENAME", expression="t1.PSVIEWSTYLENAME", showorder=11), @DEDataQueryCodeExp(name="TYPECODE", expression="t1.TYPECODE", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14)}, conds={})})
public class PSViewStyleDefaultDQModel
extends DEDataQueryModelBase {
    public PSViewStyleDefaultDQModel() {
        this.initAnnotation(PSViewStyleDefaultDQModel.class);
    }
}

