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
package net.ibizsys.pscore.srv.paasmgr.demodel.psregistryserver.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="C1A709C9-C7C7-4939-A8F5-3A605F289B7D", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`APIPATH`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`IPADDR`, t1.`IPADDR2`, t1.`MEMO`, t1.`PASSWD`, t1.`PORT`, t1.`PSREGISTRYSERVERID`, t1.`PSREGISTRYSERVERNAME`, t1.`PSSVRDOMAINID`, t11.`PSSVRDOMAINNAME`, t1.`REGISTRYPASSWD`, t1.`REGISTRYTYPE`, t1.`REGISTRYURL`, t1.`REGISTRYUSERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERNAME`, t1.`VALIDFLAG` FROM `T_SRFPSREGISTRYSERVER` t1  LEFT JOIN T_SRFPSSVRDOMAIN t11 ON t1.PSSVRDOMAINID = t11.PSSVRDOMAINID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="APIPATH", expression="t1.`APIPATH`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="IPADDR", expression="t1.`IPADDR`", showorder=3), @DEDataQueryCodeExp(name="IPADDR2", expression="t1.`IPADDR2`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="PASSWD", expression="t1.`PASSWD`", showorder=6), @DEDataQueryCodeExp(name="PORT", expression="t1.`PORT`", showorder=7), @DEDataQueryCodeExp(name="PSREGISTRYSERVERID", expression="t1.`PSREGISTRYSERVERID`", showorder=8), @DEDataQueryCodeExp(name="PSREGISTRYSERVERNAME", expression="t1.`PSREGISTRYSERVERNAME`", showorder=9), @DEDataQueryCodeExp(name="PSSVRDOMAINID", expression="t1.`PSSVRDOMAINID`", showorder=10), @DEDataQueryCodeExp(name="PSSVRDOMAINNAME", expression="t11.`PSSVRDOMAINNAME`", showorder=11), @DEDataQueryCodeExp(name="REGISTRYPASSWD", expression="t1.`REGISTRYPASSWD`", showorder=12), @DEDataQueryCodeExp(name="REGISTRYTYPE", expression="t1.`REGISTRYTYPE`", showorder=13), @DEDataQueryCodeExp(name="REGISTRYURL", expression="t1.`REGISTRYURL`", showorder=14), @DEDataQueryCodeExp(name="REGISTRYUSERNAME", expression="t1.`REGISTRYUSERNAME`", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=17), @DEDataQueryCodeExp(name="USERNAME", expression="t1.`USERNAME`", showorder=18), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=19)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.APIPATH, t1.CREATEDATE, t1.CREATEMAN, t1.IPADDR, t1.IPADDR2, t1.MEMO, t1.PASSWD, t1.PORT, t1.PSREGISTRYSERVERID, t1.PSREGISTRYSERVERNAME, t1.PSSVRDOMAINID, t11.PSSVRDOMAINNAME, t1.REGISTRYPASSWD, t1.REGISTRYTYPE, t1.REGISTRYURL, t1.REGISTRYUSERNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERNAME, t1.VALIDFLAG FROM T_SRFPSREGISTRYSERVER t1  LEFT JOIN T_SRFPSSVRDOMAIN t11 ON t1.PSSVRDOMAINID = t11.PSSVRDOMAINID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="APIPATH", expression="t1.APIPATH", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="IPADDR", expression="t1.IPADDR", showorder=3), @DEDataQueryCodeExp(name="IPADDR2", expression="t1.IPADDR2", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="PASSWD", expression="t1.PASSWD", showorder=6), @DEDataQueryCodeExp(name="PORT", expression="t1.PORT", showorder=7), @DEDataQueryCodeExp(name="PSREGISTRYSERVERID", expression="t1.PSREGISTRYSERVERID", showorder=8), @DEDataQueryCodeExp(name="PSREGISTRYSERVERNAME", expression="t1.PSREGISTRYSERVERNAME", showorder=9), @DEDataQueryCodeExp(name="PSSVRDOMAINID", expression="t1.PSSVRDOMAINID", showorder=10), @DEDataQueryCodeExp(name="PSSVRDOMAINNAME", expression="t11.PSSVRDOMAINNAME", showorder=11), @DEDataQueryCodeExp(name="REGISTRYPASSWD", expression="t1.REGISTRYPASSWD", showorder=12), @DEDataQueryCodeExp(name="REGISTRYTYPE", expression="t1.REGISTRYTYPE", showorder=13), @DEDataQueryCodeExp(name="REGISTRYURL", expression="t1.REGISTRYURL", showorder=14), @DEDataQueryCodeExp(name="REGISTRYUSERNAME", expression="t1.REGISTRYUSERNAME", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=17), @DEDataQueryCodeExp(name="USERNAME", expression="t1.USERNAME", showorder=18), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=19)}, conds={})})
public class PSRegistryServerDefaultDQModel
extends DEDataQueryModelBase {
    public PSRegistryServerDefaultDQModel() {
        this.initAnnotation(PSRegistryServerDefaultDQModel.class);
    }
}

