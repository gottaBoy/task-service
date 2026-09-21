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
package net.ibizsys.pscore.srv.config.demodel.pssyspolicymodel.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="DC9111C5-56B0-4AFF-BB1E-42B54DFBFC1E", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`CURCNT`, t1.`FIELDS`, t1.`MAXCNT`, t1.`MEMO`, t1.`MODELTAG`, t1.`POLICYINFO`, t1.`PSSYSPOLICYID`, t1.`PSSYSPOLICYMODELID`, t1.`PSSYSPOLICYMODELNAME`, t11.`PSSYSPOLICYNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSYSPOLICYMODEL` t1  LEFT JOIN T_SRFPSSYSPOLICY t11 ON t1.PSSYSPOLICYID = t11.PSSYSPOLICYID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="CURCNT", expression="t1.`CURCNT`", showorder=2), @DEDataQueryCodeExp(name="FIELDS", expression="t1.`FIELDS`", showorder=3), @DEDataQueryCodeExp(name="MAXCNT", expression="t1.`MAXCNT`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="MODELTAG", expression="t1.`MODELTAG`", showorder=6), @DEDataQueryCodeExp(name="POLICYINFO", expression="t1.`POLICYINFO`", showorder=7), @DEDataQueryCodeExp(name="PSSYSPOLICYID", expression="t1.`PSSYSPOLICYID`", showorder=8), @DEDataQueryCodeExp(name="PSSYSPOLICYMODELID", expression="t1.`PSSYSPOLICYMODELID`", showorder=9), @DEDataQueryCodeExp(name="PSSYSPOLICYMODELNAME", expression="t1.`PSSYSPOLICYMODELNAME`", showorder=10), @DEDataQueryCodeExp(name="PSSYSPOLICYNAME", expression="t11.`PSSYSPOLICYNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.CURCNT, t1.FIELDS, t1.MAXCNT, t1.MEMO, t1.MODELTAG, t1.POLICYINFO, t1.PSSYSPOLICYID, t1.PSSYSPOLICYMODELID, t1.PSSYSPOLICYMODELNAME, t11.PSSYSPOLICYNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSYSPOLICYMODEL t1  LEFT JOIN T_SRFPSSYSPOLICY t11 ON t1.PSSYSPOLICYID = t11.PSSYSPOLICYID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="CURCNT", expression="t1.CURCNT", showorder=2), @DEDataQueryCodeExp(name="FIELDS", expression="t1.FIELDS", showorder=3), @DEDataQueryCodeExp(name="MAXCNT", expression="t1.MAXCNT", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="MODELTAG", expression="t1.MODELTAG", showorder=6), @DEDataQueryCodeExp(name="POLICYINFO", expression="t1.POLICYINFO", showorder=7), @DEDataQueryCodeExp(name="PSSYSPOLICYID", expression="t1.PSSYSPOLICYID", showorder=8), @DEDataQueryCodeExp(name="PSSYSPOLICYMODELID", expression="t1.PSSYSPOLICYMODELID", showorder=9), @DEDataQueryCodeExp(name="PSSYSPOLICYMODELNAME", expression="t1.PSSYSPOLICYMODELNAME", showorder=10), @DEDataQueryCodeExp(name="PSSYSPOLICYNAME", expression="t11.PSSYSPOLICYNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSSysPolicyModelDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysPolicyModelDefaultDQModel() {
        this.initAnnotation(PSSysPolicyModelDefaultDQModel.class);
    }
}

