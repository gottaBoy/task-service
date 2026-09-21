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
package net.ibizsys.pscore.srv.appdesign.demodel.psappviewref.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="9921CE41-2FB1-4122-8958-8C64DDEFF6D6", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MAJORPSAPPVIEWID`, t11.`PSAPPVIEWNAME` AS `MAJORPSAPPVIEWNAME`, t1.`MEMO`, t1.`MINORPSAPPVIEWID`, t21.`PSAPPVIEWNAME` AS `MINORPSAPPVIEWNAME`, t1.`OPENMODE`, t1.`PSAPPVIEWREFID`, t1.`PSAPPVIEWREFNAME`, t1.`REFMODETEXT`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSAPPVIEWREF` t1  LEFT JOIN T_SRFPSAPPVIEW t11 ON t1.MAJORPSAPPVIEWID = t11.PSAPPVIEWID  LEFT JOIN T_SRFPSAPPVIEW t21 ON t1.MINORPSAPPVIEWID = t21.PSAPPVIEWID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MAJORPSAPPVIEWID", expression="t1.`MAJORPSAPPVIEWID`", showorder=2), @DEDataQueryCodeExp(name="MAJORPSAPPVIEWNAME", expression="t11.`PSAPPVIEWNAME`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="MINORPSAPPVIEWID", expression="t1.`MINORPSAPPVIEWID`", showorder=5), @DEDataQueryCodeExp(name="MINORPSAPPVIEWNAME", expression="t21.`PSAPPVIEWNAME`", showorder=6), @DEDataQueryCodeExp(name="OPENMODE", expression="t1.`OPENMODE`", showorder=7), @DEDataQueryCodeExp(name="PSAPPVIEWREFID", expression="t1.`PSAPPVIEWREFID`", showorder=8), @DEDataQueryCodeExp(name="PSAPPVIEWREFNAME", expression="t1.`PSAPPVIEWREFNAME`", showorder=9), @DEDataQueryCodeExp(name="REFMODETEXT", expression="t1.`REFMODETEXT`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MAJORPSAPPVIEWID, t11.PSAPPVIEWNAME AS MAJORPSAPPVIEWNAME, t1.MEMO, t1.MINORPSAPPVIEWID, t21.PSAPPVIEWNAME AS MINORPSAPPVIEWNAME, t1.OPENMODE, t1.PSAPPVIEWREFID, t1.PSAPPVIEWREFNAME, t1.REFMODETEXT, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSAPPVIEWREF t1  LEFT JOIN T_SRFPSAPPVIEW t11 ON t1.MAJORPSAPPVIEWID = t11.PSAPPVIEWID  LEFT JOIN T_SRFPSAPPVIEW t21 ON t1.MINORPSAPPVIEWID = t21.PSAPPVIEWID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MAJORPSAPPVIEWID", expression="t1.MAJORPSAPPVIEWID", showorder=2), @DEDataQueryCodeExp(name="MAJORPSAPPVIEWNAME", expression="t11.PSAPPVIEWNAME", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="MINORPSAPPVIEWID", expression="t1.MINORPSAPPVIEWID", showorder=5), @DEDataQueryCodeExp(name="MINORPSAPPVIEWNAME", expression="t21.PSAPPVIEWNAME", showorder=6), @DEDataQueryCodeExp(name="OPENMODE", expression="t1.OPENMODE", showorder=7), @DEDataQueryCodeExp(name="PSAPPVIEWREFID", expression="t1.PSAPPVIEWREFID", showorder=8), @DEDataQueryCodeExp(name="PSAPPVIEWREFNAME", expression="t1.PSAPPVIEWREFNAME", showorder=9), @DEDataQueryCodeExp(name="REFMODETEXT", expression="t1.REFMODETEXT", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSAppViewRefDefaultDQModel
extends DEDataQueryModelBase {
    public PSAppViewRefDefaultDQModel() {
        this.initAnnotation(PSAppViewRefDefaultDQModel.class);
    }
}

