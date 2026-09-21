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
package net.ibizsys.pscore.srv.devcenter.demodel.psdcsfpkgver.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="BCFF85A8-DCEE-4B6E-8BC1-048C74140935", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDCSFPKGID`, t1.`PSDCSFPKGNAME`, t1.`PSDCSFPKGVERID`, t1.`PSDCSFPKGVERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VERPARAM`, t1.`VERTAG`, t1.`VERTAG2` FROM `T_SRFPSDCSFPKGVER` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDCSFPKGID", expression="t1.`PSDCSFPKGID`", showorder=3), @DEDataQueryCodeExp(name="PSDCSFPKGNAME", expression="t1.`PSDCSFPKGNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDCSFPKGVERID", expression="t1.`PSDCSFPKGVERID`", showorder=5), @DEDataQueryCodeExp(name="PSDCSFPKGVERNAME", expression="t1.`PSDCSFPKGVERNAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8), @DEDataQueryCodeExp(name="VERPARAM", expression="t1.`VERPARAM`", showorder=9), @DEDataQueryCodeExp(name="VERTAG", expression="t1.`VERTAG`", showorder=10), @DEDataQueryCodeExp(name="VERTAG2", expression="t1.`VERTAG2`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDCSFPKGID, t1.PSDCSFPKGNAME, t1.PSDCSFPKGVERID, t1.PSDCSFPKGVERNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VERPARAM, t1.VERTAG, t1.VERTAG2 FROM T_SRFPSDCSFPKGVER t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDCSFPKGID", expression="t1.PSDCSFPKGID", showorder=3), @DEDataQueryCodeExp(name="PSDCSFPKGNAME", expression="t1.PSDCSFPKGNAME", showorder=4), @DEDataQueryCodeExp(name="PSDCSFPKGVERID", expression="t1.PSDCSFPKGVERID", showorder=5), @DEDataQueryCodeExp(name="PSDCSFPKGVERNAME", expression="t1.PSDCSFPKGVERNAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8), @DEDataQueryCodeExp(name="VERPARAM", expression="t1.VERPARAM", showorder=9), @DEDataQueryCodeExp(name="VERTAG", expression="t1.VERTAG", showorder=10), @DEDataQueryCodeExp(name="VERTAG2", expression="t1.VERTAG2", showorder=11)}, conds={})})
public class PSDCSFPkgVerDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCSFPkgVerDefaultDQModel() {
        this.initAnnotation(PSDCSFPkgVerDefaultDQModel.class);
    }
}

