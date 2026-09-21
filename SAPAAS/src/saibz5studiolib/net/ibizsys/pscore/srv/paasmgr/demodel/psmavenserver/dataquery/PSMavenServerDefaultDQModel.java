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
package net.ibizsys.pscore.srv.paasmgr.demodel.psmavenserver.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="24A2644A-C639-43FA-9953-38CA1B9D134F", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`APIPATH`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`IPADDR`, t1.`IPADDR2`, t1.`MAVENPASSWD`, t1.`MAVENSERVERTYPE`, t1.`MAVENURL`, t1.`MAVENUSERNAME`, t1.`MEMO`, t1.`PASSWD`, t1.`PORT`, t1.`PSMAVENSERVERID`, t1.`PSMAVENSERVERNAME`, t1.`PSSVRDOMAINID`, t11.`PSSVRDOMAINNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERNAME`, t1.`VALIDFLAG` FROM `T_SRFPSMAVENSERVER` t1  LEFT JOIN T_SRFPSSVRDOMAIN t11 ON t1.PSSVRDOMAINID = t11.PSSVRDOMAINID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="APIPATH", expression="t1.`APIPATH`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="IPADDR", expression="t1.`IPADDR`", showorder=3), @DEDataQueryCodeExp(name="IPADDR2", expression="t1.`IPADDR2`", showorder=4), @DEDataQueryCodeExp(name="MAVENPASSWD", expression="t1.`MAVENPASSWD`", showorder=5), @DEDataQueryCodeExp(name="MAVENSERVERTYPE", expression="t1.`MAVENSERVERTYPE`", showorder=6), @DEDataQueryCodeExp(name="MAVENURL", expression="t1.`MAVENURL`", showorder=7), @DEDataQueryCodeExp(name="MAVENUSERNAME", expression="t1.`MAVENUSERNAME`", showorder=8), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=9), @DEDataQueryCodeExp(name="PASSWD", expression="t1.`PASSWD`", showorder=10), @DEDataQueryCodeExp(name="PORT", expression="t1.`PORT`", showorder=11), @DEDataQueryCodeExp(name="PSMAVENSERVERID", expression="t1.`PSMAVENSERVERID`", showorder=12), @DEDataQueryCodeExp(name="PSMAVENSERVERNAME", expression="t1.`PSMAVENSERVERNAME`", showorder=13), @DEDataQueryCodeExp(name="PSSVRDOMAINID", expression="t1.`PSSVRDOMAINID`", showorder=14), @DEDataQueryCodeExp(name="PSSVRDOMAINNAME", expression="t11.`PSSVRDOMAINNAME`", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=17), @DEDataQueryCodeExp(name="USERNAME", expression="t1.`USERNAME`", showorder=18), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=19)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.APIPATH, t1.CREATEDATE, t1.CREATEMAN, t1.IPADDR, t1.IPADDR2, t1.MAVENPASSWD, t1.MAVENSERVERTYPE, t1.MAVENURL, t1.MAVENUSERNAME, t1.MEMO, t1.PASSWD, t1.PORT, t1.PSMAVENSERVERID, t1.PSMAVENSERVERNAME, t1.PSSVRDOMAINID, t11.PSSVRDOMAINNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERNAME, t1.VALIDFLAG FROM T_SRFPSMAVENSERVER t1  LEFT JOIN T_SRFPSSVRDOMAIN t11 ON t1.PSSVRDOMAINID = t11.PSSVRDOMAINID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="APIPATH", expression="t1.APIPATH", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="IPADDR", expression="t1.IPADDR", showorder=3), @DEDataQueryCodeExp(name="IPADDR2", expression="t1.IPADDR2", showorder=4), @DEDataQueryCodeExp(name="MAVENPASSWD", expression="t1.MAVENPASSWD", showorder=5), @DEDataQueryCodeExp(name="MAVENSERVERTYPE", expression="t1.MAVENSERVERTYPE", showorder=6), @DEDataQueryCodeExp(name="MAVENURL", expression="t1.MAVENURL", showorder=7), @DEDataQueryCodeExp(name="MAVENUSERNAME", expression="t1.MAVENUSERNAME", showorder=8), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=9), @DEDataQueryCodeExp(name="PASSWD", expression="t1.PASSWD", showorder=10), @DEDataQueryCodeExp(name="PORT", expression="t1.PORT", showorder=11), @DEDataQueryCodeExp(name="PSMAVENSERVERID", expression="t1.PSMAVENSERVERID", showorder=12), @DEDataQueryCodeExp(name="PSMAVENSERVERNAME", expression="t1.PSMAVENSERVERNAME", showorder=13), @DEDataQueryCodeExp(name="PSSVRDOMAINID", expression="t1.PSSVRDOMAINID", showorder=14), @DEDataQueryCodeExp(name="PSSVRDOMAINNAME", expression="t11.PSSVRDOMAINNAME", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=17), @DEDataQueryCodeExp(name="USERNAME", expression="t1.USERNAME", showorder=18), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=19)}, conds={})})
public class PSMavenServerDefaultDQModel
extends DEDataQueryModelBase {
    public PSMavenServerDefaultDQModel() {
        this.initAnnotation(PSMavenServerDefaultDQModel.class);
    }
}

