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
package net.ibizsys.pscore.srv.config.demodel.pspfstyleprj.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="C8AF9F91-CB3E-4AE6-B9BD-DD2C388EBD2F", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MAVENFLAG`, t1.`MEMO`, t1.`NAMEFMT`, t1.`NAMEFMT2`, t1.`PRJTYPE`, t1.`PSPFSTYLEID`, t11.`PSPFSTYLENAME`, t1.`PSPFSTYLEPRJID`, t1.`PSPFSTYLEPRJNAME`, t1.`READONLYMODE`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSPFSTYLEPRJ` t1  LEFT JOIN T_SRFPSPFSTYLE t11 ON t1.PSPFSTYLEID = t11.PSPFSTYLEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MAVENFLAG", expression="t1.`MAVENFLAG`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="NAMEFMT", expression="t1.`NAMEFMT`", showorder=4), @DEDataQueryCodeExp(name="NAMEFMT2", expression="t1.`NAMEFMT2`", showorder=5), @DEDataQueryCodeExp(name="PRJTYPE", expression="t1.`PRJTYPE`", showorder=6), @DEDataQueryCodeExp(name="PSPFSTYLEID", expression="t1.`PSPFSTYLEID`", showorder=7), @DEDataQueryCodeExp(name="PSPFSTYLENAME", expression="t11.`PSPFSTYLENAME`", showorder=8), @DEDataQueryCodeExp(name="PSPFSTYLEPRJID", expression="t1.`PSPFSTYLEPRJID`", showorder=9), @DEDataQueryCodeExp(name="PSPFSTYLEPRJNAME", expression="t1.`PSPFSTYLEPRJNAME`", showorder=10), @DEDataQueryCodeExp(name="READONLYMODE", expression="t1.`READONLYMODE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MAVENFLAG, t1.MEMO, t1.NAMEFMT, t1.NAMEFMT2, t1.PRJTYPE, t1.PSPFSTYLEID, t11.PSPFSTYLENAME, t1.PSPFSTYLEPRJID, t1.PSPFSTYLEPRJNAME, t1.READONLYMODE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSPFSTYLEPRJ t1  LEFT JOIN T_SRFPSPFSTYLE t11 ON t1.PSPFSTYLEID = t11.PSPFSTYLEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MAVENFLAG", expression="t1.MAVENFLAG", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="NAMEFMT", expression="t1.NAMEFMT", showorder=4), @DEDataQueryCodeExp(name="NAMEFMT2", expression="t1.NAMEFMT2", showorder=5), @DEDataQueryCodeExp(name="PRJTYPE", expression="t1.PRJTYPE", showorder=6), @DEDataQueryCodeExp(name="PSPFSTYLEID", expression="t1.PSPFSTYLEID", showorder=7), @DEDataQueryCodeExp(name="PSPFSTYLENAME", expression="t11.PSPFSTYLENAME", showorder=8), @DEDataQueryCodeExp(name="PSPFSTYLEPRJID", expression="t1.PSPFSTYLEPRJID", showorder=9), @DEDataQueryCodeExp(name="PSPFSTYLEPRJNAME", expression="t1.PSPFSTYLEPRJNAME", showorder=10), @DEDataQueryCodeExp(name="READONLYMODE", expression="t1.READONLYMODE", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSPFStylePrjDefaultDQModel
extends DEDataQueryModelBase {
    public PSPFStylePrjDefaultDQModel() {
        this.initAnnotation(PSPFStylePrjDefaultDQModel.class);
    }
}

