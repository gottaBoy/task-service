/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeCond
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfpkg.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="CF280BBD-CC58-453E-AD01-4D2B8796116A", name="CurSF")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`OSLIC`, t1.`PKGTAG`, t1.`PKGTAG2`, t1.`PSDCID`, t1.`PSDCNAME`, t1.`PSSFID`, t1.`PSSFNAME`, t1.`PSSFPKGCATID`, t11.`PSSFPKGCATNAME`, t1.`PSSFPKGID`, t1.`PSSFPKGNAME`, t1.`PSSUBSYSID`, t21.`PSSUBSYSNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSFPKG` t1  LEFT JOIN T_SRFPSSFPKGCAT t11 ON t1.PSSFPKGCATID = t11.PSSFPKGCATID  LEFT JOIN T_SRFPSSUBSYS t21 ON t1.PSSUBSYSID = t21.PSSUBSYSID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="OSLIC", expression="t1.`OSLIC`", showorder=3), @DEDataQueryCodeExp(name="PKGTAG", expression="t1.`PKGTAG`", showorder=4), @DEDataQueryCodeExp(name="PKGTAG2", expression="t1.`PKGTAG2`", showorder=5), @DEDataQueryCodeExp(name="PSDCID", expression="t1.`PSDCID`", showorder=6), @DEDataQueryCodeExp(name="PSDCNAME", expression="t1.`PSDCNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSFID", expression="t1.`PSSFID`", showorder=8), @DEDataQueryCodeExp(name="PSSFNAME", expression="t1.`PSSFNAME`", showorder=9), @DEDataQueryCodeExp(name="PSSFPKGCATID", expression="t1.`PSSFPKGCATID`", showorder=10), @DEDataQueryCodeExp(name="PSSFPKGCATNAME", expression="t11.`PSSFPKGCATNAME`", showorder=11), @DEDataQueryCodeExp(name="PSSFPKGID", expression="t1.`PSSFPKGID`", showorder=12), @DEDataQueryCodeExp(name="PSSFPKGNAME", expression="t1.`PSSFPKGNAME`", showorder=13), @DEDataQueryCodeExp(name="PSSUBSYSID", expression="t1.`PSSUBSYSID`", showorder=14), @DEDataQueryCodeExp(name="PSSUBSYSNAME", expression="t21.`PSSUBSYSNAME`", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=17)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSSFID` =  ${srfdatacontext('pssfid','{\"defname\":\"PSSFID\",\"dename\":\"PSSFPKG\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.OSLIC, t1.PKGTAG, t1.PKGTAG2, t1.PSDCID, t1.PSDCNAME, t1.PSSFID, t1.PSSFNAME, t1.PSSFPKGCATID, t11.PSSFPKGCATNAME, t1.PSSFPKGID, t1.PSSFPKGNAME, t1.PSSUBSYSID, t21.PSSUBSYSNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSFPKG t1  LEFT JOIN T_SRFPSSFPKGCAT t11 ON t1.PSSFPKGCATID = t11.PSSFPKGCATID  LEFT JOIN T_SRFPSSUBSYS t21 ON t1.PSSUBSYSID = t21.PSSUBSYSID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="OSLIC", expression="t1.OSLIC", showorder=3), @DEDataQueryCodeExp(name="PKGTAG", expression="t1.PKGTAG", showorder=4), @DEDataQueryCodeExp(name="PKGTAG2", expression="t1.PKGTAG2", showorder=5), @DEDataQueryCodeExp(name="PSDCID", expression="t1.PSDCID", showorder=6), @DEDataQueryCodeExp(name="PSDCNAME", expression="t1.PSDCNAME", showorder=7), @DEDataQueryCodeExp(name="PSSFID", expression="t1.PSSFID", showorder=8), @DEDataQueryCodeExp(name="PSSFNAME", expression="t1.PSSFNAME", showorder=9), @DEDataQueryCodeExp(name="PSSFPKGCATID", expression="t1.PSSFPKGCATID", showorder=10), @DEDataQueryCodeExp(name="PSSFPKGCATNAME", expression="t11.PSSFPKGCATNAME", showorder=11), @DEDataQueryCodeExp(name="PSSFPKGID", expression="t1.PSSFPKGID", showorder=12), @DEDataQueryCodeExp(name="PSSFPKGNAME", expression="t1.PSSFPKGNAME", showorder=13), @DEDataQueryCodeExp(name="PSSUBSYSID", expression="t1.PSSUBSYSID", showorder=14), @DEDataQueryCodeExp(name="PSSUBSYSNAME", expression="t21.PSSUBSYSNAME", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=17)}, conds={@DEDataQueryCodeCond(condition="( t1.PSSFID =  ${srfdatacontext('pssfid','{\"defname\":\"PSSFID\",\"dename\":\"PSSFPKG\"}')} )")})})
public class PSSFPkgCurSFDQModel
extends DEDataQueryModelBase {
    public PSSFPkgCurSFDQModel() {
        this.initAnnotation(PSSFPkgCurSFDQModel.class);
    }
}

