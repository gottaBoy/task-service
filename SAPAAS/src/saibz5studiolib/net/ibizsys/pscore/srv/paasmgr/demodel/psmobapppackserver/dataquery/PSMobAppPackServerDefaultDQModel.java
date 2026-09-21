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
package net.ibizsys.pscore.srv.paasmgr.demodel.psmobapppackserver.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="D06B253A-7FE8-40F8-8B19-493199116498", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`IPADDR`, t1.`MEMO`, t1.`PASSWD`, t1.`PORT`, t1.`PSMOBAPPPACKSERVERID`, t1.`PSMOBAPPPACKSERVERNAME`, t1.`PSSVRDOMAINID`, t11.`PSSVRDOMAINNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`UPLOADFILEMODE`, t1.`UPLOADPATH`, t1.`USERNAME`, t1.`VALIDFLAG` FROM `T_SRFPSMOBAPPPACKSERVER` t1  LEFT JOIN T_SRFPSSVRDOMAIN t11 ON t1.PSSVRDOMAINID = t11.PSSVRDOMAINID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="IPADDR", expression="t1.`IPADDR`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PASSWD", expression="t1.`PASSWD`", showorder=4), @DEDataQueryCodeExp(name="PORT", expression="t1.`PORT`", showorder=5), @DEDataQueryCodeExp(name="PSMOBAPPPACKSERVERID", expression="t1.`PSMOBAPPPACKSERVERID`", showorder=6), @DEDataQueryCodeExp(name="PSMOBAPPPACKSERVERNAME", expression="t1.`PSMOBAPPPACKSERVERNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSVRDOMAINID", expression="t1.`PSSVRDOMAINID`", showorder=8), @DEDataQueryCodeExp(name="PSSVRDOMAINNAME", expression="t11.`PSSVRDOMAINNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="UPLOADFILEMODE", expression="t1.`UPLOADFILEMODE`", showorder=12), @DEDataQueryCodeExp(name="UPLOADPATH", expression="t1.`UPLOADPATH`", showorder=13), @DEDataQueryCodeExp(name="USERNAME", expression="t1.`USERNAME`", showorder=14), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=15)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.IPADDR, t1.MEMO, t1.PASSWD, t1.PORT, t1.PSMOBAPPPACKSERVERID, t1.PSMOBAPPPACKSERVERNAME, t1.PSSVRDOMAINID, t11.PSSVRDOMAINNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.UPLOADFILEMODE, t1.UPLOADPATH, t1.USERNAME, t1.VALIDFLAG FROM T_SRFPSMOBAPPPACKSERVER t1  LEFT JOIN T_SRFPSSVRDOMAIN t11 ON t1.PSSVRDOMAINID = t11.PSSVRDOMAINID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="IPADDR", expression="t1.IPADDR", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PASSWD", expression="t1.PASSWD", showorder=4), @DEDataQueryCodeExp(name="PORT", expression="t1.PORT", showorder=5), @DEDataQueryCodeExp(name="PSMOBAPPPACKSERVERID", expression="t1.PSMOBAPPPACKSERVERID", showorder=6), @DEDataQueryCodeExp(name="PSMOBAPPPACKSERVERNAME", expression="t1.PSMOBAPPPACKSERVERNAME", showorder=7), @DEDataQueryCodeExp(name="PSSVRDOMAINID", expression="t1.PSSVRDOMAINID", showorder=8), @DEDataQueryCodeExp(name="PSSVRDOMAINNAME", expression="t11.PSSVRDOMAINNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="UPLOADFILEMODE", expression="t1.UPLOADFILEMODE", showorder=12), @DEDataQueryCodeExp(name="UPLOADPATH", expression="t1.UPLOADPATH", showorder=13), @DEDataQueryCodeExp(name="USERNAME", expression="t1.USERNAME", showorder=14), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=15)}, conds={})})
public class PSMobAppPackServerDefaultDQModel
extends DEDataQueryModelBase {
    public PSMobAppPackServerDefaultDQModel() {
        this.initAnnotation(PSMobAppPackServerDefaultDQModel.class);
    }
}

