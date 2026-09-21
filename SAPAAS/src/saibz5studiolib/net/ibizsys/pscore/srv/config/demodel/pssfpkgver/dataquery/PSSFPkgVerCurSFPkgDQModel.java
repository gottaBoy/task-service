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
package net.ibizsys.pscore.srv.config.demodel.pssfpkgver.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="AAF62730-360D-4C74-8AB5-EF7A5C59AB4E", name="CurSFPkg")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDCID`, t1.`PSDCNAME`, t1.`PSSFPKGID`, t11.`PSSFPKGNAME`, t1.`PSSFPKGVERID`, t1.`PSSFPKGVERNAME`, t1.`SUBSYSVER`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VERPARAM`, t1.`VERTAG`, t1.`VERTAG2` FROM `T_SRFPSSFPKGVER` t1  LEFT JOIN T_SRFPSSFPKG t11 ON t1.PSSFPKGID = t11.PSSFPKGID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDCID", expression="t1.`PSDCID`", showorder=3), @DEDataQueryCodeExp(name="PSDCNAME", expression="t1.`PSDCNAME`", showorder=4), @DEDataQueryCodeExp(name="PSSFPKGID", expression="t1.`PSSFPKGID`", showorder=5), @DEDataQueryCodeExp(name="PSSFPKGNAME", expression="t11.`PSSFPKGNAME`", showorder=6), @DEDataQueryCodeExp(name="PSSFPKGVERID", expression="t1.`PSSFPKGVERID`", showorder=7), @DEDataQueryCodeExp(name="PSSFPKGVERNAME", expression="t1.`PSSFPKGVERNAME`", showorder=8), @DEDataQueryCodeExp(name="SUBSYSVER", expression="t1.`SUBSYSVER`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VERPARAM", expression="t1.`VERPARAM`", showorder=12), @DEDataQueryCodeExp(name="VERTAG", expression="t1.`VERTAG`", showorder=13), @DEDataQueryCodeExp(name="VERTAG2", expression="t1.`VERTAG2`", showorder=14)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSSFPKGID` =  ${srfdatacontext('pssfpkgid','{\"defname\":\"PSSFPKGID\",\"dename\":\"PSSFPKGVER\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDCID, t1.PSDCNAME, t1.PSSFPKGID, t11.PSSFPKGNAME, t1.PSSFPKGVERID, t1.PSSFPKGVERNAME, t1.SUBSYSVER, t1.UPDATEDATE, t1.UPDATEMAN, t1.VERPARAM, t1.VERTAG, t1.VERTAG2 FROM T_SRFPSSFPKGVER t1  LEFT JOIN T_SRFPSSFPKG t11 ON t1.PSSFPKGID = t11.PSSFPKGID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDCID", expression="t1.PSDCID", showorder=3), @DEDataQueryCodeExp(name="PSDCNAME", expression="t1.PSDCNAME", showorder=4), @DEDataQueryCodeExp(name="PSSFPKGID", expression="t1.PSSFPKGID", showorder=5), @DEDataQueryCodeExp(name="PSSFPKGNAME", expression="t11.PSSFPKGNAME", showorder=6), @DEDataQueryCodeExp(name="PSSFPKGVERID", expression="t1.PSSFPKGVERID", showorder=7), @DEDataQueryCodeExp(name="PSSFPKGVERNAME", expression="t1.PSSFPKGVERNAME", showorder=8), @DEDataQueryCodeExp(name="SUBSYSVER", expression="t1.SUBSYSVER", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VERPARAM", expression="t1.VERPARAM", showorder=12), @DEDataQueryCodeExp(name="VERTAG", expression="t1.VERTAG", showorder=13), @DEDataQueryCodeExp(name="VERTAG2", expression="t1.VERTAG2", showorder=14)}, conds={@DEDataQueryCodeCond(condition="( t1.PSSFPKGID =  ${srfdatacontext('pssfpkgid','{\"defname\":\"PSSFPKGID\",\"dename\":\"PSSFPKGVER\"}')} )")})})
public class PSSFPkgVerCurSFPkgDQModel
extends DEDataQueryModelBase {
    public PSSFPkgVerCurSFPkgDQModel() {
        this.initAnnotation(PSSFPkgVerCurSFPkgDQModel.class);
    }
}

