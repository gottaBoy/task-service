/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeCond
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psmobappstartpage.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="E937D709-5579-4386-A6F7-9EE399705928", name="CurApp")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSAPPVIEWID`, t11.`PSAPPVIEWNAME`, t1.`PSMOBAPPSTARTPAGEID`, t1.`PSMOBAPPSTARTPAGENAME`, t1.`PSSYSAPPID`, t21.`PSSYSAPPNAME`, t1.`PSSYSIMAGEID`, t31.`PSSYSIMAGENAME`, t1.`RESSPEC`, t1.`RESTYPE`, t1.`STARTPAGEFILE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSMOBAPPSTARTPAGE` t1  LEFT JOIN `T_SRFPSAPPVIEW` t11 ON t1.`PSAPPVIEWID` = t11.`PSAPPVIEWID`  LEFT JOIN `T_SRFPSSYSAPP` t21 ON t1.`PSSYSAPPID` = t21.`PSSYSAPPID`  LEFT JOIN `T_SRFPSSYSIMAGE` t31 ON t1.`PSSYSIMAGEID` = t31.`PSSYSIMAGEID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSAPPVIEWID", expression="t1.`PSAPPVIEWID`", showorder=4), @DEDataQueryCodeExp(name="PSAPPVIEWNAME", expression="t11.`PSAPPVIEWNAME`", showorder=5), @DEDataQueryCodeExp(name="PSMOBAPPSTARTPAGEID", expression="t1.`PSMOBAPPSTARTPAGEID`", showorder=6), @DEDataQueryCodeExp(name="PSMOBAPPSTARTPAGENAME", expression="t1.`PSMOBAPPSTARTPAGENAME`", showorder=7), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.`PSSYSAPPID`", showorder=8), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t21.`PSSYSAPPNAME`", showorder=9), @DEDataQueryCodeExp(name="PSSYSIMAGEID", expression="t1.`PSSYSIMAGEID`", showorder=10), @DEDataQueryCodeExp(name="PSSYSIMAGENAME", expression="t31.`PSSYSIMAGENAME`", showorder=11), @DEDataQueryCodeExp(name="RESSPEC", expression="t1.`RESSPEC`", showorder=12), @DEDataQueryCodeExp(name="RESTYPE", expression="t1.`RESTYPE`", showorder=13), @DEDataQueryCodeExp(name="STARTPAGEFILE", expression="t1.`STARTPAGEFILE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=16), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=17)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSSYSAPPID` =  ${srfdatacontext('pssysappid','{\"defname\":\"PSSYSAPPID\",\"dename\":\"PSMOBAPPSTARTPAGE\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSAPPVIEWID, t11.PSAPPVIEWNAME, t1.PSMOBAPPSTARTPAGEID, t1.PSMOBAPPSTARTPAGENAME, t1.PSSYSAPPID, t21.PSSYSAPPNAME, t1.PSSYSIMAGEID, t31.PSSYSIMAGENAME, t1.RESSPEC, t1.RESTYPE, t1.STARTPAGEFILE, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSMOBAPPSTARTPAGE t1  LEFT JOIN T_SRFPSAPPVIEW t11 ON t1.PSAPPVIEWID = t11.PSAPPVIEWID  LEFT JOIN T_SRFPSSYSAPP t21 ON t1.PSSYSAPPID = t21.PSSYSAPPID  LEFT JOIN T_SRFPSSYSIMAGE t31 ON t1.PSSYSIMAGEID = t31.PSSYSIMAGEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSAPPVIEWID", expression="t1.PSAPPVIEWID", showorder=4), @DEDataQueryCodeExp(name="PSAPPVIEWNAME", expression="t11.PSAPPVIEWNAME", showorder=5), @DEDataQueryCodeExp(name="PSMOBAPPSTARTPAGEID", expression="t1.PSMOBAPPSTARTPAGEID", showorder=6), @DEDataQueryCodeExp(name="PSMOBAPPSTARTPAGENAME", expression="t1.PSMOBAPPSTARTPAGENAME", showorder=7), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.PSSYSAPPID", showorder=8), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t21.PSSYSAPPNAME", showorder=9), @DEDataQueryCodeExp(name="PSSYSIMAGEID", expression="t1.PSSYSIMAGEID", showorder=10), @DEDataQueryCodeExp(name="PSSYSIMAGENAME", expression="t31.PSSYSIMAGENAME", showorder=11), @DEDataQueryCodeExp(name="RESSPEC", expression="t1.RESSPEC", showorder=12), @DEDataQueryCodeExp(name="RESTYPE", expression="t1.RESTYPE", showorder=13), @DEDataQueryCodeExp(name="STARTPAGEFILE", expression="t1.STARTPAGEFILE", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=16), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=17)}, conds={@DEDataQueryCodeCond(condition="( t1.PSSYSAPPID =  ${srfdatacontext('pssysappid','{\"defname\":\"PSSYSAPPID\",\"dename\":\"PSMOBAPPSTARTPAGE\"}')} )")})})
public class PSMobAppStartPageCurAppDQModel
extends DEDataQueryModelBase {
    public PSMobAppStartPageCurAppDQModel() {
        this.initAnnotation(PSMobAppStartPageCurAppDQModel.class);
    }
}

