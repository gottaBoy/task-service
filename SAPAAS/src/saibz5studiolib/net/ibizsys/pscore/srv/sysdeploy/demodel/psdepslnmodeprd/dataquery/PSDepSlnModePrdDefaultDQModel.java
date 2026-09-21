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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnmodeprd.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="DEB2AF86-ABDE-4DB4-90D4-4E3109133D47", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEPSLNASGRPID`, t11.`PSDEPSLNASGRPNAME`, t1.`PSDEPSLNMODEID`, t21.`PSDEPSLNMODENAME`, t1.`PSDEPSLNMODEPRDID`, t1.`PSDEPSLNMODEPRDNAME`, t1.`PSDEPSLNPRDID`, t31.`PSDEPSLNPRDNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEPSLNMODEPRD` t1  LEFT JOIN T_SRFPSDEPSLNASGRP t11 ON t1.PSDEPSLNASGRPID = t11.PSDEPSLNASGRPID  LEFT JOIN T_SRFPSDEPSLNMODE t21 ON t1.PSDEPSLNMODEID = t21.PSDEPSLNMODEID  LEFT JOIN T_SRFPSDEPSLNPRD t31 ON t1.PSDEPSLNPRDID = t31.PSDEPSLNPRDID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEPSLNASGRPID", expression="t1.`PSDEPSLNASGRPID`", showorder=3), @DEDataQueryCodeExp(name="PSDEPSLNASGRPNAME", expression="t11.`PSDEPSLNASGRPNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNMODEID", expression="t1.`PSDEPSLNMODEID`", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNMODENAME", expression="t21.`PSDEPSLNMODENAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNMODEPRDID", expression="t1.`PSDEPSLNMODEPRDID`", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNMODEPRDNAME", expression="t1.`PSDEPSLNMODEPRDNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDEPSLNPRDID", expression="t1.`PSDEPSLNPRDID`", showorder=9), @DEDataQueryCodeExp(name="PSDEPSLNPRDNAME", expression="t31.`PSDEPSLNPRDNAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEPSLNASGRPID, t11.PSDEPSLNASGRPNAME, t1.PSDEPSLNMODEID, t21.PSDEPSLNMODENAME, t1.PSDEPSLNMODEPRDID, t1.PSDEPSLNMODEPRDNAME, t1.PSDEPSLNPRDID, t31.PSDEPSLNPRDNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEPSLNMODEPRD t1  LEFT JOIN T_SRFPSDEPSLNASGRP t11 ON t1.PSDEPSLNASGRPID = t11.PSDEPSLNASGRPID  LEFT JOIN T_SRFPSDEPSLNMODE t21 ON t1.PSDEPSLNMODEID = t21.PSDEPSLNMODEID  LEFT JOIN T_SRFPSDEPSLNPRD t31 ON t1.PSDEPSLNPRDID = t31.PSDEPSLNPRDID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEPSLNASGRPID", expression="t1.PSDEPSLNASGRPID", showorder=3), @DEDataQueryCodeExp(name="PSDEPSLNASGRPNAME", expression="t11.PSDEPSLNASGRPNAME", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNMODEID", expression="t1.PSDEPSLNMODEID", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNMODENAME", expression="t21.PSDEPSLNMODENAME", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNMODEPRDID", expression="t1.PSDEPSLNMODEPRDID", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNMODEPRDNAME", expression="t1.PSDEPSLNMODEPRDNAME", showorder=8), @DEDataQueryCodeExp(name="PSDEPSLNPRDID", expression="t1.PSDEPSLNPRDID", showorder=9), @DEDataQueryCodeExp(name="PSDEPSLNPRDNAME", expression="t31.PSDEPSLNPRDNAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSDepSlnModePrdDefaultDQModel
extends DEDataQueryModelBase {
    public PSDepSlnModePrdDefaultDQModel() {
        this.initAnnotation(PSDepSlnModePrdDefaultDQModel.class);
    }
}

