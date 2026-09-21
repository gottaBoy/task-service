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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdbdetail.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="895DCCE4-F1EF-493A-B72B-EA64306DB7CD", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t11.`DBVER`, CASE WHEN  (t11.`DBVER`-t1.`PUBDBVER`) =0 THEN 1 ELSE 0 END AS `MATCHFLAG`, t1.`MEMO`, t1.`PSDEID`, t1.`PSDENAME`, t1.`PSSYSDBDETAILID`, t1.`PSSYSDBDETAILNAME`, t1.`PSSYSTEMDBCFGID`, t21.`PSSYSTEMDBCFGNAME`, t1.`PUBDBVER`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSYSDBDETAIL` t1  LEFT JOIN `T_SRFPSDATAENTITY` t11 ON t1.`PSDEID` = t11.`PSDATAENTITYID`  LEFT JOIN `T_SRFPSSYSTEMDBCFG` t21 ON t1.`PSSYSTEMDBCFGID` = t21.`PSSYSTEMDBCFGID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DBVER", expression="t11.`DBVER`", showorder=2), @DEDataQueryCodeExp(name="MATCHFLAG", expression="CASE WHEN  (t11.`DBVER`-t1.`PUBDBVER`) =0 THEN 1 ELSE 0 END", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSDEID", expression="t1.`PSDEID`", showorder=5), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.`PSDENAME`", showorder=6), @DEDataQueryCodeExp(name="PSSYSDBDETAILID", expression="t1.`PSSYSDBDETAILID`", showorder=7), @DEDataQueryCodeExp(name="PSSYSDBDETAILNAME", expression="t1.`PSSYSDBDETAILNAME`", showorder=8), @DEDataQueryCodeExp(name="PSSYSTEMDBCFGID", expression="t1.`PSSYSTEMDBCFGID`", showorder=9), @DEDataQueryCodeExp(name="PSSYSTEMDBCFGNAME", expression="t21.`PSSYSTEMDBCFGNAME`", showorder=10), @DEDataQueryCodeExp(name="PUBDBVER", expression="t1.`PUBDBVER`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t11.DBVER, CASE WHEN  (t11.DBVER-t1.PUBDBVER) =0 THEN 1 ELSE 0 END AS MATCHFLAG, t1.MEMO, t1.PSDEID, t1.PSDENAME, t1.PSSYSDBDETAILID, t1.PSSYSDBDETAILNAME, t1.PSSYSTEMDBCFGID, t21.PSSYSTEMDBCFGNAME, t1.PUBDBVER, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSYSDBDETAIL t1  LEFT JOIN T_SRFPSDATAENTITY t11 ON t1.PSDEID = t11.PSDATAENTITYID  LEFT JOIN T_SRFPSSYSTEMDBCFG t21 ON t1.PSSYSTEMDBCFGID = t21.PSSYSTEMDBCFGID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DBVER", expression="t11.DBVER", showorder=2), @DEDataQueryCodeExp(name="MATCHFLAG", expression="CASE WHEN  (t11.DBVER-t1.PUBDBVER) =0 THEN 1 ELSE 0 END", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSDEID", expression="t1.PSDEID", showorder=5), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.PSDENAME", showorder=6), @DEDataQueryCodeExp(name="PSSYSDBDETAILID", expression="t1.PSSYSDBDETAILID", showorder=7), @DEDataQueryCodeExp(name="PSSYSDBDETAILNAME", expression="t1.PSSYSDBDETAILNAME", showorder=8), @DEDataQueryCodeExp(name="PSSYSTEMDBCFGID", expression="t1.PSSYSTEMDBCFGID", showorder=9), @DEDataQueryCodeExp(name="PSSYSTEMDBCFGNAME", expression="t21.PSSYSTEMDBCFGNAME", showorder=10), @DEDataQueryCodeExp(name="PUBDBVER", expression="t1.PUBDBVER", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSSysDBDetailDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysDBDetailDefaultDQModel() {
        this.initAnnotation(PSSysDBDetailDefaultDQModel.class);
    }
}

