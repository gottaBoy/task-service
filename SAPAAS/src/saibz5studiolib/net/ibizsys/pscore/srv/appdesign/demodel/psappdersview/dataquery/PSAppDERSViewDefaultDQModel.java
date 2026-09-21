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
package net.ibizsys.pscore.srv.appdesign.demodel.psappdersview.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="5022C8EF-A341-4C3D-96E7-BDA0E6875C19", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSAPPDERSID`, t11.`PSAPPDERSNAME`, t1.`PSAPPDERSVIEWID`, t1.`PSAPPDERSVIEWNAME`, t1.`PSAPPDEVIEWID`, t21.`PSAPPDEVIEWNAME`, t11.`PSSYSAPPID`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSAPPDERSVIEW` t1  LEFT JOIN T_SRFPSAPPDERS t11 ON t1.PSAPPDERSID = t11.PSAPPDERSID  LEFT JOIN T_SRFPSAPPDEVIEW t21 ON t1.PSAPPDEVIEWID = t21.PSAPPDEVIEWID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSAPPDERSID", expression="t1.`PSAPPDERSID`", showorder=3), @DEDataQueryCodeExp(name="PSAPPDERSNAME", expression="t11.`PSAPPDERSNAME`", showorder=4), @DEDataQueryCodeExp(name="PSAPPDERSVIEWID", expression="t1.`PSAPPDERSVIEWID`", showorder=5), @DEDataQueryCodeExp(name="PSAPPDERSVIEWNAME", expression="t1.`PSAPPDERSVIEWNAME`", showorder=6), @DEDataQueryCodeExp(name="PSAPPDEVIEWID", expression="t1.`PSAPPDEVIEWID`", showorder=7), @DEDataQueryCodeExp(name="PSAPPDEVIEWNAME", expression="t21.`PSAPPDEVIEWNAME`", showorder=8), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t11.`PSSYSAPPID`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSAPPDERSID, t11.PSAPPDERSNAME, t1.PSAPPDERSVIEWID, t1.PSAPPDERSVIEWNAME, t1.PSAPPDEVIEWID, t21.PSAPPDEVIEWNAME, t11.PSSYSAPPID, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSAPPDERSVIEW t1  LEFT JOIN T_SRFPSAPPDERS t11 ON t1.PSAPPDERSID = t11.PSAPPDERSID  LEFT JOIN T_SRFPSAPPDEVIEW t21 ON t1.PSAPPDEVIEWID = t21.PSAPPDEVIEWID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSAPPDERSID", expression="t1.PSAPPDERSID", showorder=3), @DEDataQueryCodeExp(name="PSAPPDERSNAME", expression="t11.PSAPPDERSNAME", showorder=4), @DEDataQueryCodeExp(name="PSAPPDERSVIEWID", expression="t1.PSAPPDERSVIEWID", showorder=5), @DEDataQueryCodeExp(name="PSAPPDERSVIEWNAME", expression="t1.PSAPPDERSVIEWNAME", showorder=6), @DEDataQueryCodeExp(name="PSAPPDEVIEWID", expression="t1.PSAPPDEVIEWID", showorder=7), @DEDataQueryCodeExp(name="PSAPPDEVIEWNAME", expression="t21.PSAPPDEVIEWNAME", showorder=8), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t11.PSSYSAPPID", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12)}, conds={})})
public class PSAppDERSViewDefaultDQModel
extends DEDataQueryModelBase {
    public PSAppDERSViewDefaultDQModel() {
        this.initAnnotation(PSAppDERSViewDefaultDQModel.class);
    }
}

