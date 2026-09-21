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
package net.ibizsys.pscore.srv.paasmgr.demodel.psrosserver.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="30E8E0FD-2816-4127-B347-2CE2F72DEA31", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`FWTYPE`, t1.`IPADDR`, t1.`MEMO`, t1.`PASSWD`, t1.`PORT`, t1.`PSROSSERVERID`, t1.`PSROSSERVERNAME`, t1.`PSSVRDOMAINID`, t1.`PSSVRDOMAINNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERNAME`, t1.`VALIDFLAG` FROM `T_SRFPSROSSERVER` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="FWTYPE", expression="t1.`FWTYPE`", showorder=2), @DEDataQueryCodeExp(name="IPADDR", expression="t1.`IPADDR`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PASSWD", expression="t1.`PASSWD`", showorder=5), @DEDataQueryCodeExp(name="PORT", expression="t1.`PORT`", showorder=6), @DEDataQueryCodeExp(name="PSROSSERVERID", expression="t1.`PSROSSERVERID`", showorder=7), @DEDataQueryCodeExp(name="PSROSSERVERNAME", expression="t1.`PSROSSERVERNAME`", showorder=8), @DEDataQueryCodeExp(name="PSSVRDOMAINID", expression="t1.`PSSVRDOMAINID`", showorder=9), @DEDataQueryCodeExp(name="PSSVRDOMAINNAME", expression="t1.`PSSVRDOMAINNAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12), @DEDataQueryCodeExp(name="USERNAME", expression="t1.`USERNAME`", showorder=13), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.FWTYPE, t1.IPADDR, t1.MEMO, t1.PASSWD, t1.PORT, t1.PSROSSERVERID, t1.PSROSSERVERNAME, t1.PSSVRDOMAINID, t1.PSSVRDOMAINNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERNAME, t1.VALIDFLAG FROM T_SRFPSROSSERVER t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="FWTYPE", expression="t1.FWTYPE", showorder=2), @DEDataQueryCodeExp(name="IPADDR", expression="t1.IPADDR", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PASSWD", expression="t1.PASSWD", showorder=5), @DEDataQueryCodeExp(name="PORT", expression="t1.PORT", showorder=6), @DEDataQueryCodeExp(name="PSROSSERVERID", expression="t1.PSROSSERVERID", showorder=7), @DEDataQueryCodeExp(name="PSROSSERVERNAME", expression="t1.PSROSSERVERNAME", showorder=8), @DEDataQueryCodeExp(name="PSSVRDOMAINID", expression="t1.PSSVRDOMAINID", showorder=9), @DEDataQueryCodeExp(name="PSSVRDOMAINNAME", expression="t1.PSSVRDOMAINNAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12), @DEDataQueryCodeExp(name="USERNAME", expression="t1.USERNAME", showorder=13), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=14)}, conds={})})
public class PSROSServerDefaultDQModel
extends DEDataQueryModelBase {
    public PSROSServerDefaultDQModel() {
        this.initAnnotation(PSROSServerDefaultDQModel.class);
    }
}

