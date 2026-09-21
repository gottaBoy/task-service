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
package net.ibizsys.pscore.srv.config.demodel.pspfpkg.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="C0F2A183-072E-4D4D-A1A6-9360B4354922", name="CurPF")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`OSLIC`, t1.`PKGPARAM`, t1.`PKGPARAM2`, t1.`PKGPARAM3`, t1.`PKGPARAM4`, t1.`PKGTAG`, t1.`PKGTAG2`, t1.`PSDCID`, t1.`PSDCNAME`, t1.`PSPFID`, t1.`PSPFNAME`, t1.`PSPFPKGCATID`, t11.`PSPFPKGCATNAME`, t1.`PSPFPKGID`, t1.`PSPFPKGNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSPFPKG` t1  LEFT JOIN T_SRFPSPFPKGCAT t11 ON t1.PSPFPKGCATID = t11.PSPFPKGCATID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="OSLIC", expression="t1.`OSLIC`", showorder=3), @DEDataQueryCodeExp(name="PKGPARAM", expression="t1.`PKGPARAM`", showorder=4), @DEDataQueryCodeExp(name="PKGPARAM2", expression="t1.`PKGPARAM2`", showorder=5), @DEDataQueryCodeExp(name="PKGPARAM3", expression="t1.`PKGPARAM3`", showorder=6), @DEDataQueryCodeExp(name="PKGPARAM4", expression="t1.`PKGPARAM4`", showorder=7), @DEDataQueryCodeExp(name="PKGTAG", expression="t1.`PKGTAG`", showorder=8), @DEDataQueryCodeExp(name="PKGTAG2", expression="t1.`PKGTAG2`", showorder=9), @DEDataQueryCodeExp(name="PSDCID", expression="t1.`PSDCID`", showorder=10), @DEDataQueryCodeExp(name="PSDCNAME", expression="t1.`PSDCNAME`", showorder=11), @DEDataQueryCodeExp(name="PSPFID", expression="t1.`PSPFID`", showorder=12), @DEDataQueryCodeExp(name="PSPFNAME", expression="t1.`PSPFNAME`", showorder=13), @DEDataQueryCodeExp(name="PSPFPKGCATID", expression="t1.`PSPFPKGCATID`", showorder=14), @DEDataQueryCodeExp(name="PSPFPKGCATNAME", expression="t11.`PSPFPKGCATNAME`", showorder=15), @DEDataQueryCodeExp(name="PSPFPKGID", expression="t1.`PSPFPKGID`", showorder=16), @DEDataQueryCodeExp(name="PSPFPKGNAME", expression="t1.`PSPFPKGNAME`", showorder=17), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=18), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=19)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSPFID` =  ${srfdatacontext('pspfid','{\"defname\":\"PSPFID\",\"dename\":\"PSPFPKG\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.OSLIC, t1.PKGPARAM, t1.PKGPARAM2, t1.PKGPARAM3, t1.PKGPARAM4, t1.PKGTAG, t1.PKGTAG2, t1.PSDCID, t1.PSDCNAME, t1.PSPFID, t1.PSPFNAME, t1.PSPFPKGCATID, t11.PSPFPKGCATNAME, t1.PSPFPKGID, t1.PSPFPKGNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSPFPKG t1  LEFT JOIN T_SRFPSPFPKGCAT t11 ON t1.PSPFPKGCATID = t11.PSPFPKGCATID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="OSLIC", expression="t1.OSLIC", showorder=3), @DEDataQueryCodeExp(name="PKGPARAM", expression="t1.PKGPARAM", showorder=4), @DEDataQueryCodeExp(name="PKGPARAM2", expression="t1.PKGPARAM2", showorder=5), @DEDataQueryCodeExp(name="PKGPARAM3", expression="t1.PKGPARAM3", showorder=6), @DEDataQueryCodeExp(name="PKGPARAM4", expression="t1.PKGPARAM4", showorder=7), @DEDataQueryCodeExp(name="PKGTAG", expression="t1.PKGTAG", showorder=8), @DEDataQueryCodeExp(name="PKGTAG2", expression="t1.PKGTAG2", showorder=9), @DEDataQueryCodeExp(name="PSDCID", expression="t1.PSDCID", showorder=10), @DEDataQueryCodeExp(name="PSDCNAME", expression="t1.PSDCNAME", showorder=11), @DEDataQueryCodeExp(name="PSPFID", expression="t1.PSPFID", showorder=12), @DEDataQueryCodeExp(name="PSPFNAME", expression="t1.PSPFNAME", showorder=13), @DEDataQueryCodeExp(name="PSPFPKGCATID", expression="t1.PSPFPKGCATID", showorder=14), @DEDataQueryCodeExp(name="PSPFPKGCATNAME", expression="t11.PSPFPKGCATNAME", showorder=15), @DEDataQueryCodeExp(name="PSPFPKGID", expression="t1.PSPFPKGID", showorder=16), @DEDataQueryCodeExp(name="PSPFPKGNAME", expression="t1.PSPFPKGNAME", showorder=17), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=18), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=19)}, conds={@DEDataQueryCodeCond(condition="( t1.PSPFID =  ${srfdatacontext('pspfid','{\"defname\":\"PSPFID\",\"dename\":\"PSPFPKG\"}')} )")})})
public class PSPFPkgCurPFDQModel
extends DEDataQueryModelBase {
    public PSPFPkgCurPFDQModel() {
        this.initAnnotation(PSPFPkgCurPFDQModel.class);
    }
}

