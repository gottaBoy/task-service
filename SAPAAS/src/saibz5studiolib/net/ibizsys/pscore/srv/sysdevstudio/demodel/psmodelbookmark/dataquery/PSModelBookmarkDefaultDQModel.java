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
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psmodelbookmark.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="FC3B2461-36D8-4B73-A64E-BF224D93EE02", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`FOLDERFLAG`, t1.`MEMO`, t1.`PPSMODELBOOKMARKID`, t11.`PSMODELBOOKMARKNAME` AS `PPSMODELBOOKMARKNAME`, t1.`PSMODELBOOKMARKID`, t1.`PSMODELBOOKMARKNAME`, t1.`PSOBJID`, t1.`PSOBJNAME`, t1.`PSOBJTYPE`, t1.`PSOBJTYPENAME`, t1.`PSSYSTEMID`, t1.`PSSYSTEMNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSMODELBOOKMARK` t1  LEFT JOIN `T_SRFPSMODELBOOKMARK` t11 ON t1.`PPSMODELBOOKMARKID` = t11.`PSMODELBOOKMARKID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="FOLDERFLAG", expression="t1.`FOLDERFLAG`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PPSMODELBOOKMARKID", expression="t1.`PPSMODELBOOKMARKID`", showorder=4), @DEDataQueryCodeExp(name="PPSMODELBOOKMARKNAME", expression="t11.`PSMODELBOOKMARKNAME`", showorder=5), @DEDataQueryCodeExp(name="PSMODELBOOKMARKID", expression="t1.`PSMODELBOOKMARKID`", showorder=6), @DEDataQueryCodeExp(name="PSMODELBOOKMARKNAME", expression="t1.`PSMODELBOOKMARKNAME`", showorder=7), @DEDataQueryCodeExp(name="PSOBJID", expression="t1.`PSOBJID`", showorder=8), @DEDataQueryCodeExp(name="PSOBJNAME", expression="t1.`PSOBJNAME`", showorder=9), @DEDataQueryCodeExp(name="PSOBJTYPE", expression="t1.`PSOBJTYPE`", showorder=10), @DEDataQueryCodeExp(name="PSOBJTYPENAME", expression="t1.`PSOBJTYPENAME`", showorder=11), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=12), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.`PSSYSTEMNAME`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.FOLDERFLAG, t1.MEMO, t1.PPSMODELBOOKMARKID, t11.PSMODELBOOKMARKNAME AS PPSMODELBOOKMARKNAME, t1.PSMODELBOOKMARKID, t1.PSMODELBOOKMARKNAME, t1.PSOBJID, t1.PSOBJNAME, t1.PSOBJTYPE, t1.PSOBJTYPENAME, t1.PSSYSTEMID, t1.PSSYSTEMNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSMODELBOOKMARK t1  LEFT JOIN T_SRFPSMODELBOOKMARK t11 ON t1.PPSMODELBOOKMARKID = t11.PSMODELBOOKMARKID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="FOLDERFLAG", expression="t1.FOLDERFLAG", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PPSMODELBOOKMARKID", expression="t1.PPSMODELBOOKMARKID", showorder=4), @DEDataQueryCodeExp(name="PPSMODELBOOKMARKNAME", expression="t11.PSMODELBOOKMARKNAME", showorder=5), @DEDataQueryCodeExp(name="PSMODELBOOKMARKID", expression="t1.PSMODELBOOKMARKID", showorder=6), @DEDataQueryCodeExp(name="PSMODELBOOKMARKNAME", expression="t1.PSMODELBOOKMARKNAME", showorder=7), @DEDataQueryCodeExp(name="PSOBJID", expression="t1.PSOBJID", showorder=8), @DEDataQueryCodeExp(name="PSOBJNAME", expression="t1.PSOBJNAME", showorder=9), @DEDataQueryCodeExp(name="PSOBJTYPE", expression="t1.PSOBJTYPE", showorder=10), @DEDataQueryCodeExp(name="PSOBJTYPENAME", expression="t1.PSOBJTYPENAME", showorder=11), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=12), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.PSSYSTEMNAME", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15)}, conds={})})
public class PSModelBookmarkDefaultDQModel
extends DEDataQueryModelBase {
    public PSModelBookmarkDefaultDQModel() {
        this.initAnnotation(PSModelBookmarkDefaultDQModel.class);
    }
}

