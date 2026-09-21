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
package net.ibizsys.pscore.srv.config.demodel.pssfstyleprj.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="C1522A98-AA07-4979-84E6-958118A426AA", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MAVENFLAG`, t1.`MEMO`, t1.`NAMEFMT`, t1.`PRJTYPE`, t1.`PSSFSTYLEID`, t11.`PSSFSTYLENAME`, t1.`PSSFSTYLEPRJID`, t1.`PSSFSTYLEPRJNAME`, t1.`READONLYMODE`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSFSTYLEPRJ` t1  LEFT JOIN T_SRFPSSFSTYLE t11 ON t1.PSSFSTYLEID = t11.PSSFSTYLEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MAVENFLAG", expression="t1.`MAVENFLAG`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="NAMEFMT", expression="t1.`NAMEFMT`", showorder=4), @DEDataQueryCodeExp(name="PRJTYPE", expression="t1.`PRJTYPE`", showorder=5), @DEDataQueryCodeExp(name="PSSFSTYLEID", expression="t1.`PSSFSTYLEID`", showorder=6), @DEDataQueryCodeExp(name="PSSFSTYLENAME", expression="t11.`PSSFSTYLENAME`", showorder=7), @DEDataQueryCodeExp(name="PSSFSTYLEPRJID", expression="t1.`PSSFSTYLEPRJID`", showorder=8), @DEDataQueryCodeExp(name="PSSFSTYLEPRJNAME", expression="t1.`PSSFSTYLEPRJNAME`", showorder=9), @DEDataQueryCodeExp(name="READONLYMODE", expression="t1.`READONLYMODE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MAVENFLAG, t1.MEMO, t1.NAMEFMT, t1.PRJTYPE, t1.PSSFSTYLEID, t11.PSSFSTYLENAME, t1.PSSFSTYLEPRJID, t1.PSSFSTYLEPRJNAME, t1.READONLYMODE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSFSTYLEPRJ t1  LEFT JOIN T_SRFPSSFSTYLE t11 ON t1.PSSFSTYLEID = t11.PSSFSTYLEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MAVENFLAG", expression="t1.MAVENFLAG", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="NAMEFMT", expression="t1.NAMEFMT", showorder=4), @DEDataQueryCodeExp(name="PRJTYPE", expression="t1.PRJTYPE", showorder=5), @DEDataQueryCodeExp(name="PSSFSTYLEID", expression="t1.PSSFSTYLEID", showorder=6), @DEDataQueryCodeExp(name="PSSFSTYLENAME", expression="t11.PSSFSTYLENAME", showorder=7), @DEDataQueryCodeExp(name="PSSFSTYLEPRJID", expression="t1.PSSFSTYLEPRJID", showorder=8), @DEDataQueryCodeExp(name="PSSFSTYLEPRJNAME", expression="t1.PSSFSTYLEPRJNAME", showorder=9), @DEDataQueryCodeExp(name="READONLYMODE", expression="t1.READONLYMODE", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSSFStylePrjDefaultDQModel
extends DEDataQueryModelBase {
    public PSSFStylePrjDefaultDQModel() {
        this.initAnnotation(PSSFStylePrjDefaultDQModel.class);
    }
}

