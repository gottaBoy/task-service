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
package net.ibizsys.pscore.srv.paasmgr.demodel.pssvrserver.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="8F785997-C8FA-4AD4-A2B0-5E61C08B19C1", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENABLE`, t1.`IPADDR`, t1.`LASTHTTPPORT`, t1.`LASTSSHPORT`, t1.`MEMO`, t1.`PASSWD`, t1.`PORT`, t1.`PSSVRDOMAINID`, t11.`PSSVRDOMAINNAME`, t1.`PSSVRSERVERID`, t1.`PSSVRSERVERNAME`, t1.`TEMPL1ID`, t1.`TEMPL2ID`, t1.`TEMPL3ID`, t1.`TEMPL4ID`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERNAME`, t1.`WEBCONSOLEPATH` FROM `T_SRFPSSVRSERVER` t1  LEFT JOIN T_SRFPSSVRDOMAIN t11 ON t1.PSSVRDOMAINID = t11.PSSVRDOMAINID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ENABLE", expression="t1.`ENABLE`", showorder=2), @DEDataQueryCodeExp(name="IPADDR", expression="t1.`IPADDR`", showorder=3), @DEDataQueryCodeExp(name="LASTHTTPPORT", expression="t1.`LASTHTTPPORT`", showorder=4), @DEDataQueryCodeExp(name="LASTSSHPORT", expression="t1.`LASTSSHPORT`", showorder=5), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=6), @DEDataQueryCodeExp(name="PASSWD", expression="t1.`PASSWD`", showorder=7), @DEDataQueryCodeExp(name="PORT", expression="t1.`PORT`", showorder=8), @DEDataQueryCodeExp(name="PSSVRDOMAINID", expression="t1.`PSSVRDOMAINID`", showorder=9), @DEDataQueryCodeExp(name="PSSVRDOMAINNAME", expression="t11.`PSSVRDOMAINNAME`", showorder=10), @DEDataQueryCodeExp(name="PSSVRSERVERID", expression="t1.`PSSVRSERVERID`", showorder=11), @DEDataQueryCodeExp(name="PSSVRSERVERNAME", expression="t1.`PSSVRSERVERNAME`", showorder=12), @DEDataQueryCodeExp(name="TEMPL1ID", expression="t1.`TEMPL1ID`", showorder=13), @DEDataQueryCodeExp(name="TEMPL2ID", expression="t1.`TEMPL2ID`", showorder=14), @DEDataQueryCodeExp(name="TEMPL3ID", expression="t1.`TEMPL3ID`", showorder=15), @DEDataQueryCodeExp(name="TEMPL4ID", expression="t1.`TEMPL4ID`", showorder=16), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=17), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=18), @DEDataQueryCodeExp(name="USERNAME", expression="t1.`USERNAME`", showorder=19), @DEDataQueryCodeExp(name="WEBCONSOLEPATH", expression="t1.`WEBCONSOLEPATH`", showorder=20)}, conds={@DEDataQueryCodeCond(condition="t1.ENABLE = 1")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENABLE, t1.IPADDR, t1.LASTHTTPPORT, t1.LASTSSHPORT, t1.MEMO, t1.PASSWD, t1.PORT, t1.PSSVRDOMAINID, t11.PSSVRDOMAINNAME, t1.PSSVRSERVERID, t1.PSSVRSERVERNAME, t1.TEMPL1ID, t1.TEMPL2ID, t1.TEMPL3ID, t1.TEMPL4ID, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERNAME, t1.WEBCONSOLEPATH FROM T_SRFPSSVRSERVER t1  LEFT JOIN T_SRFPSSVRDOMAIN t11 ON t1.PSSVRDOMAINID = t11.PSSVRDOMAINID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ENABLE", expression="t1.ENABLE", showorder=2), @DEDataQueryCodeExp(name="IPADDR", expression="t1.IPADDR", showorder=3), @DEDataQueryCodeExp(name="LASTHTTPPORT", expression="t1.LASTHTTPPORT", showorder=4), @DEDataQueryCodeExp(name="LASTSSHPORT", expression="t1.LASTSSHPORT", showorder=5), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=6), @DEDataQueryCodeExp(name="PASSWD", expression="t1.PASSWD", showorder=7), @DEDataQueryCodeExp(name="PORT", expression="t1.PORT", showorder=8), @DEDataQueryCodeExp(name="PSSVRDOMAINID", expression="t1.PSSVRDOMAINID", showorder=9), @DEDataQueryCodeExp(name="PSSVRDOMAINNAME", expression="t11.PSSVRDOMAINNAME", showorder=10), @DEDataQueryCodeExp(name="PSSVRSERVERID", expression="t1.PSSVRSERVERID", showorder=11), @DEDataQueryCodeExp(name="PSSVRSERVERNAME", expression="t1.PSSVRSERVERNAME", showorder=12), @DEDataQueryCodeExp(name="TEMPL1ID", expression="t1.TEMPL1ID", showorder=13), @DEDataQueryCodeExp(name="TEMPL2ID", expression="t1.TEMPL2ID", showorder=14), @DEDataQueryCodeExp(name="TEMPL3ID", expression="t1.TEMPL3ID", showorder=15), @DEDataQueryCodeExp(name="TEMPL4ID", expression="t1.TEMPL4ID", showorder=16), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=17), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=18), @DEDataQueryCodeExp(name="USERNAME", expression="t1.USERNAME", showorder=19), @DEDataQueryCodeExp(name="WEBCONSOLEPATH", expression="t1.WEBCONSOLEPATH", showorder=20)}, conds={@DEDataQueryCodeCond(condition="t1.ENABLE = 1")})})
public class PSSvrServerDefaultDQModel
extends DEDataQueryModelBase {
    public PSSvrServerDefaultDQModel() {
        this.initAnnotation(PSSvrServerDefaultDQModel.class);
    }
}

