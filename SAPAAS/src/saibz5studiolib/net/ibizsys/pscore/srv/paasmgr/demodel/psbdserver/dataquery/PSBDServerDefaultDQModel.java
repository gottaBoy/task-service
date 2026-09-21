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
package net.ibizsys.pscore.srv.paasmgr.demodel.psbdserver.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="9AEEF175-2EEA-40EE-AF9A-A317A7673B7F", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`BDTYPE`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`IPADDR`, t1.`MEMO`, t1.`PASSWD`, t1.`PORT`, t1.`PSBDSERVERID`, t1.`PSBDSERVERNAME`, t1.`PSSVRDOMAINID`, t11.`PSSVRDOMAINNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERNAME` FROM `T_SRFPSBDSERVER` t1  LEFT JOIN T_SRFPSSVRDOMAIN t11 ON t1.PSSVRDOMAINID = t11.PSSVRDOMAINID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="BDTYPE", expression="t1.`BDTYPE`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="IPADDR", expression="t1.`IPADDR`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PASSWD", expression="t1.`PASSWD`", showorder=5), @DEDataQueryCodeExp(name="PORT", expression="t1.`PORT`", showorder=6), @DEDataQueryCodeExp(name="PSBDSERVERID", expression="t1.`PSBDSERVERID`", showorder=7), @DEDataQueryCodeExp(name="PSBDSERVERNAME", expression="t1.`PSBDSERVERNAME`", showorder=8), @DEDataQueryCodeExp(name="PSSVRDOMAINID", expression="t1.`PSSVRDOMAINID`", showorder=9), @DEDataQueryCodeExp(name="PSSVRDOMAINNAME", expression="t11.`PSSVRDOMAINNAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12), @DEDataQueryCodeExp(name="USERNAME", expression="t1.`USERNAME`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.BDTYPE, t1.CREATEDATE, t1.CREATEMAN, t1.IPADDR, t1.MEMO, t1.PASSWD, t1.PORT, t1.PSBDSERVERID, t1.PSBDSERVERNAME, t1.PSSVRDOMAINID, t11.PSSVRDOMAINNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERNAME FROM T_SRFPSBDSERVER t1  LEFT JOIN T_SRFPSSVRDOMAIN t11 ON t1.PSSVRDOMAINID = t11.PSSVRDOMAINID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="BDTYPE", expression="t1.BDTYPE", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="IPADDR", expression="t1.IPADDR", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PASSWD", expression="t1.PASSWD", showorder=5), @DEDataQueryCodeExp(name="PORT", expression="t1.PORT", showorder=6), @DEDataQueryCodeExp(name="PSBDSERVERID", expression="t1.PSBDSERVERID", showorder=7), @DEDataQueryCodeExp(name="PSBDSERVERNAME", expression="t1.PSBDSERVERNAME", showorder=8), @DEDataQueryCodeExp(name="PSSVRDOMAINID", expression="t1.PSSVRDOMAINID", showorder=9), @DEDataQueryCodeExp(name="PSSVRDOMAINNAME", expression="t11.PSSVRDOMAINNAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12), @DEDataQueryCodeExp(name="USERNAME", expression="t1.USERNAME", showorder=13)}, conds={})})
public class PSBDServerDefaultDQModel
extends DEDataQueryModelBase {
    public PSBDServerDefaultDQModel() {
        this.initAnnotation(PSBDServerDefaultDQModel.class);
    }
}

