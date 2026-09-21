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
package net.ibizsys.pscore.srv.devcenter.demodel.psdcsfpkg.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="125D0BB0-9EEC-47F7-9196-8D528808E8BD", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDCSFPKGID`, t1.`PSDCSFPKGNAME`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`PSSFPKGID`, t1.`PSSFPKGNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDCSFPKG` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDCSFPKGID", expression="t1.`PSDCSFPKGID`", showorder=3), @DEDataQueryCodeExp(name="PSDCSFPKGNAME", expression="t1.`PSDCSFPKGNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=6), @DEDataQueryCodeExp(name="PSSFPKGID", expression="t1.`PSSFPKGID`", showorder=7), @DEDataQueryCodeExp(name="PSSFPKGNAME", expression="t1.`PSSFPKGNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDCSFPKGID, t1.PSDCSFPKGNAME, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.PSSFPKGID, t1.PSSFPKGNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDCSFPKG t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDCSFPKGID", expression="t1.PSDCSFPKGID", showorder=3), @DEDataQueryCodeExp(name="PSDCSFPKGNAME", expression="t1.PSDCSFPKGNAME", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=6), @DEDataQueryCodeExp(name="PSSFPKGID", expression="t1.PSSFPKGID", showorder=7), @DEDataQueryCodeExp(name="PSSFPKGNAME", expression="t1.PSSFPKGNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10)}, conds={})})
public class PSDCSFPkgDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCSFPkgDefaultDQModel() {
        this.initAnnotation(PSDCSFPkgDefaultDQModel.class);
    }
}

