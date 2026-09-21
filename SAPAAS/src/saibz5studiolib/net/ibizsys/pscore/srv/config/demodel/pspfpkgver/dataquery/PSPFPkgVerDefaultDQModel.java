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
package net.ibizsys.pscore.srv.config.demodel.pspfpkgver.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="B72F0C2C-B710-4051-AEEA-8E13D56768AF", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PKGPARAM`, t1.`PKGPARAM2`, t1.`PKGPARAM3`, t1.`PKGPARAM4`, t1.`PSDCID`, t1.`PSDCNAME`, t1.`PSPFPKGID`, t11.`PSPFPKGNAME`, t1.`PSPFPKGVERID`, t1.`PSPFPKGVERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSPFPKGVER` t1  LEFT JOIN T_SRFPSPFPKG t11 ON t1.PSPFPKGID = t11.PSPFPKGID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PKGPARAM", expression="t1.`PKGPARAM`", showorder=3), @DEDataQueryCodeExp(name="PKGPARAM2", expression="t1.`PKGPARAM2`", showorder=4), @DEDataQueryCodeExp(name="PKGPARAM3", expression="t1.`PKGPARAM3`", showorder=5), @DEDataQueryCodeExp(name="PKGPARAM4", expression="t1.`PKGPARAM4`", showorder=6), @DEDataQueryCodeExp(name="PSDCID", expression="t1.`PSDCID`", showorder=7), @DEDataQueryCodeExp(name="PSDCNAME", expression="t1.`PSDCNAME`", showorder=8), @DEDataQueryCodeExp(name="PSPFPKGID", expression="t1.`PSPFPKGID`", showorder=9), @DEDataQueryCodeExp(name="PSPFPKGNAME", expression="t11.`PSPFPKGNAME`", showorder=10), @DEDataQueryCodeExp(name="PSPFPKGVERID", expression="t1.`PSPFPKGVERID`", showorder=11), @DEDataQueryCodeExp(name="PSPFPKGVERNAME", expression="t1.`PSPFPKGVERNAME`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PKGPARAM, t1.PKGPARAM2, t1.PKGPARAM3, t1.PKGPARAM4, t1.PSDCID, t1.PSDCNAME, t1.PSPFPKGID, t11.PSPFPKGNAME, t1.PSPFPKGVERID, t1.PSPFPKGVERNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSPFPKGVER t1  LEFT JOIN T_SRFPSPFPKG t11 ON t1.PSPFPKGID = t11.PSPFPKGID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PKGPARAM", expression="t1.PKGPARAM", showorder=3), @DEDataQueryCodeExp(name="PKGPARAM2", expression="t1.PKGPARAM2", showorder=4), @DEDataQueryCodeExp(name="PKGPARAM3", expression="t1.PKGPARAM3", showorder=5), @DEDataQueryCodeExp(name="PKGPARAM4", expression="t1.PKGPARAM4", showorder=6), @DEDataQueryCodeExp(name="PSDCID", expression="t1.PSDCID", showorder=7), @DEDataQueryCodeExp(name="PSDCNAME", expression="t1.PSDCNAME", showorder=8), @DEDataQueryCodeExp(name="PSPFPKGID", expression="t1.PSPFPKGID", showorder=9), @DEDataQueryCodeExp(name="PSPFPKGNAME", expression="t11.PSPFPKGNAME", showorder=10), @DEDataQueryCodeExp(name="PSPFPKGVERID", expression="t1.PSPFPKGVERID", showorder=11), @DEDataQueryCodeExp(name="PSPFPKGVERNAME", expression="t1.PSPFPKGVERNAME", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14)}, conds={})})
public class PSPFPkgVerDefaultDQModel
extends DEDataQueryModelBase {
    public PSPFPkgVerDefaultDQModel() {
        this.initAnnotation(PSPFPkgVerDefaultDQModel.class);
    }
}

