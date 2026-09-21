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
package net.ibizsys.pscore.srv.paasmgr.demodel.psdcinst.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="36ED38FE-BB2A-4BF8-ABEC-636096E50C7D", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CONNSTR`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DBNAME`, t1.`DBTYPE`, t1.`INSTSTATE`, t1.`MEMO`, t1.`MODELVER`, t1.`ORDERVALUE`, t1.`PASSWD`, t1.`PSDBSERVERID`, t11.`PSDBSERVERNAME`, t1.`PSDCINSTID`, t1.`PSDCINSTNAME`, t1.`PSSVRDOMAINID`, t21.`PSSVRDOMAINNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USEDSIZE`, t1.`USERNAME` FROM `T_SRFPSDCINST` t1  LEFT JOIN T_SRFPSDBSERVER t11 ON t1.PSDBSERVERID = t11.PSDBSERVERID  LEFT JOIN T_SRFPSSVRDOMAIN t21 ON t1.PSSVRDOMAINID = t21.PSSVRDOMAINID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CONNSTR", expression="t1.`CONNSTR`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="DBNAME", expression="t1.`DBNAME`", showorder=3), @DEDataQueryCodeExp(name="DBTYPE", expression="t1.`DBTYPE`", showorder=4), @DEDataQueryCodeExp(name="INSTSTATE", expression="t1.`INSTSTATE`", showorder=5), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=6), @DEDataQueryCodeExp(name="MODELVER", expression="t1.`MODELVER`", showorder=7), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=8), @DEDataQueryCodeExp(name="PASSWD", expression="t1.`PASSWD`", showorder=9), @DEDataQueryCodeExp(name="PSDBSERVERID", expression="t1.`PSDBSERVERID`", showorder=10), @DEDataQueryCodeExp(name="PSDBSERVERNAME", expression="t11.`PSDBSERVERNAME`", showorder=11), @DEDataQueryCodeExp(name="PSDCINSTID", expression="t1.`PSDCINSTID`", showorder=12), @DEDataQueryCodeExp(name="PSDCINSTNAME", expression="t1.`PSDCINSTNAME`", showorder=13), @DEDataQueryCodeExp(name="PSSVRDOMAINID", expression="t1.`PSSVRDOMAINID`", showorder=14), @DEDataQueryCodeExp(name="PSSVRDOMAINNAME", expression="t21.`PSSVRDOMAINNAME`", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=17), @DEDataQueryCodeExp(name="USEDSIZE", expression="t1.`USEDSIZE`", showorder=18), @DEDataQueryCodeExp(name="USERNAME", expression="t1.`USERNAME`", showorder=19)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CONNSTR, t1.CREATEDATE, t1.CREATEMAN, t1.DBNAME, t1.DBTYPE, t1.INSTSTATE, t1.MEMO, t1.MODELVER, t1.ORDERVALUE, t1.PASSWD, t1.PSDBSERVERID, t11.PSDBSERVERNAME, t1.PSDCINSTID, t1.PSDCINSTNAME, t1.PSSVRDOMAINID, t21.PSSVRDOMAINNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USEDSIZE, t1.USERNAME FROM T_SRFPSDCINST t1  LEFT JOIN T_SRFPSDBSERVER t11 ON t1.PSDBSERVERID = t11.PSDBSERVERID  LEFT JOIN T_SRFPSSVRDOMAIN t21 ON t1.PSSVRDOMAINID = t21.PSSVRDOMAINID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CONNSTR", expression="t1.CONNSTR", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="DBNAME", expression="t1.DBNAME", showorder=3), @DEDataQueryCodeExp(name="DBTYPE", expression="t1.DBTYPE", showorder=4), @DEDataQueryCodeExp(name="INSTSTATE", expression="t1.INSTSTATE", showorder=5), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=6), @DEDataQueryCodeExp(name="MODELVER", expression="t1.MODELVER", showorder=7), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=8), @DEDataQueryCodeExp(name="PASSWD", expression="t1.PASSWD", showorder=9), @DEDataQueryCodeExp(name="PSDBSERVERID", expression="t1.PSDBSERVERID", showorder=10), @DEDataQueryCodeExp(name="PSDBSERVERNAME", expression="t11.PSDBSERVERNAME", showorder=11), @DEDataQueryCodeExp(name="PSDCINSTID", expression="t1.PSDCINSTID", showorder=12), @DEDataQueryCodeExp(name="PSDCINSTNAME", expression="t1.PSDCINSTNAME", showorder=13), @DEDataQueryCodeExp(name="PSSVRDOMAINID", expression="t1.PSSVRDOMAINID", showorder=14), @DEDataQueryCodeExp(name="PSSVRDOMAINNAME", expression="t21.PSSVRDOMAINNAME", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=17), @DEDataQueryCodeExp(name="USEDSIZE", expression="t1.USEDSIZE", showorder=18), @DEDataQueryCodeExp(name="USERNAME", expression="t1.USERNAME", showorder=19)}, conds={})})
public class PSDCInstDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCInstDefaultDQModel() {
        this.initAnnotation(PSDCInstDefaultDQModel.class);
    }
}

