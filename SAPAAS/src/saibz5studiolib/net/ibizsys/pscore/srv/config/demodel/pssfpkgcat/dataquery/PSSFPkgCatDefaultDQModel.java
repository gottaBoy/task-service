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
package net.ibizsys.pscore.srv.config.demodel.pssfpkgcat.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="4172DCD7-F737-49A7-A3A6-562C1157F5B8", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CATTAG`, t1.`CATTAG2`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSSFID`, t1.`PSSFNAME`, t1.`PSSFPKGCATID`, t1.`PSSFPKGCATNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSFPKGCAT` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CATTAG", expression="t1.`CATTAG`", showorder=0), @DEDataQueryCodeExp(name="CATTAG2", expression="t1.`CATTAG2`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSSFID", expression="t1.`PSSFID`", showorder=5), @DEDataQueryCodeExp(name="PSSFNAME", expression="t1.`PSSFNAME`", showorder=6), @DEDataQueryCodeExp(name="PSSFPKGCATID", expression="t1.`PSSFPKGCATID`", showorder=7), @DEDataQueryCodeExp(name="PSSFPKGCATNAME", expression="t1.`PSSFPKGCATNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CATTAG, t1.CATTAG2, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSSFID, t1.PSSFNAME, t1.PSSFPKGCATID, t1.PSSFPKGCATNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSFPKGCAT t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CATTAG", expression="t1.CATTAG", showorder=0), @DEDataQueryCodeExp(name="CATTAG2", expression="t1.CATTAG2", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSSFID", expression="t1.PSSFID", showorder=5), @DEDataQueryCodeExp(name="PSSFNAME", expression="t1.PSSFNAME", showorder=6), @DEDataQueryCodeExp(name="PSSFPKGCATID", expression="t1.PSSFPKGCATID", showorder=7), @DEDataQueryCodeExp(name="PSSFPKGCATNAME", expression="t1.PSSFPKGCATNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10)}, conds={})})
public class PSSFPkgCatDefaultDQModel
extends DEDataQueryModelBase {
    public PSSFPkgCatDefaultDQModel() {
        this.initAnnotation(PSSFPkgCatDefaultDQModel.class);
    }
}

