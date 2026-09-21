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
package net.ibizsys.pscore.srv.paasmgr.demodel.psconsoleserver.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="5B9E9DFC-577F-4F0D-A830-04F597EA6F86", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`CSSTATE`, t1.`HTTPADDRESS`, t1.`HTTPPORT`, t1.`IPADDR`, t1.`IPPORT`, t1.`MEMO`, t1.`PSCONSOLESERVERID`, t1.`PSCONSOLESERVERNAME`, t1.`PSSVRDOMAINID`, t11.`PSSVRDOMAINNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSCONSOLESERVER` t1  LEFT JOIN T_SRFPSSVRDOMAIN t11 ON t1.PSSVRDOMAINID = t11.PSSVRDOMAINID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="CSSTATE", expression="t1.`CSSTATE`", showorder=2), @DEDataQueryCodeExp(name="HTTPADDRESS", expression="t1.`HTTPADDRESS`", showorder=3), @DEDataQueryCodeExp(name="HTTPPORT", expression="t1.`HTTPPORT`", showorder=4), @DEDataQueryCodeExp(name="IPADDR", expression="t1.`IPADDR`", showorder=5), @DEDataQueryCodeExp(name="IPPORT", expression="t1.`IPPORT`", showorder=6), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=7), @DEDataQueryCodeExp(name="PSCONSOLESERVERID", expression="t1.`PSCONSOLESERVERID`", showorder=8), @DEDataQueryCodeExp(name="PSCONSOLESERVERNAME", expression="t1.`PSCONSOLESERVERNAME`", showorder=9), @DEDataQueryCodeExp(name="PSSVRDOMAINID", expression="t1.`PSSVRDOMAINID`", showorder=10), @DEDataQueryCodeExp(name="PSSVRDOMAINNAME", expression="t11.`PSSVRDOMAINNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.CSSTATE, t1.HTTPADDRESS, t1.HTTPPORT, t1.IPADDR, t1.IPPORT, t1.MEMO, t1.PSCONSOLESERVERID, t1.PSCONSOLESERVERNAME, t1.PSSVRDOMAINID, t11.PSSVRDOMAINNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSCONSOLESERVER t1  LEFT JOIN T_SRFPSSVRDOMAIN t11 ON t1.PSSVRDOMAINID = t11.PSSVRDOMAINID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="CSSTATE", expression="t1.CSSTATE", showorder=2), @DEDataQueryCodeExp(name="HTTPADDRESS", expression="t1.HTTPADDRESS", showorder=3), @DEDataQueryCodeExp(name="HTTPPORT", expression="t1.HTTPPORT", showorder=4), @DEDataQueryCodeExp(name="IPADDR", expression="t1.IPADDR", showorder=5), @DEDataQueryCodeExp(name="IPPORT", expression="t1.IPPORT", showorder=6), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=7), @DEDataQueryCodeExp(name="PSCONSOLESERVERID", expression="t1.PSCONSOLESERVERID", showorder=8), @DEDataQueryCodeExp(name="PSCONSOLESERVERNAME", expression="t1.PSCONSOLESERVERNAME", showorder=9), @DEDataQueryCodeExp(name="PSSVRDOMAINID", expression="t1.PSSVRDOMAINID", showorder=10), @DEDataQueryCodeExp(name="PSSVRDOMAINNAME", expression="t11.PSSVRDOMAINNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSConsoleServerDefaultDQModel
extends DEDataQueryModelBase {
    public PSConsoleServerDefaultDQModel() {
        this.initAnnotation(PSConsoleServerDefaultDQModel.class);
    }
}

