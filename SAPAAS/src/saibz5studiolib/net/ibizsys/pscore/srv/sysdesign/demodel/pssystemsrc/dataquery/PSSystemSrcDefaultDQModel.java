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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssystemsrc.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="D7912D74-39EE-4CD4-AA28-7D77CBCA804F", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSSYSTEMID`, t1.`PSSYSTEMNAME`, t1.`PSSYSTEMSRCID`, t1.`PSSYSTEMSRCNAME`, t1.`SOURCEID`, t1.`SRCPSDEVSLNSYSID`, t1.`SRCPSDEVSLNSYSNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSSYSTEMSRC` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=3), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.`PSSYSTEMNAME`", showorder=4), @DEDataQueryCodeExp(name="PSSYSTEMSRCID", expression="t1.`PSSYSTEMSRCID`", showorder=5), @DEDataQueryCodeExp(name="PSSYSTEMSRCNAME", expression="t1.`PSSYSTEMSRCNAME`", showorder=6), @DEDataQueryCodeExp(name="SOURCEID", expression="t1.`SOURCEID`", showorder=7), @DEDataQueryCodeExp(name="SRCPSDEVSLNSYSID", expression="t1.`SRCPSDEVSLNSYSID`", showorder=8), @DEDataQueryCodeExp(name="SRCPSDEVSLNSYSNAME", expression="t1.`SRCPSDEVSLNSYSNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSSYSTEMID, t1.PSSYSTEMNAME, t1.PSSYSTEMSRCID, t1.PSSYSTEMSRCNAME, t1.SOURCEID, t1.SRCPSDEVSLNSYSID, t1.SRCPSDEVSLNSYSNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSSYSTEMSRC t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=3), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.PSSYSTEMNAME", showorder=4), @DEDataQueryCodeExp(name="PSSYSTEMSRCID", expression="t1.PSSYSTEMSRCID", showorder=5), @DEDataQueryCodeExp(name="PSSYSTEMSRCNAME", expression="t1.PSSYSTEMSRCNAME", showorder=6), @DEDataQueryCodeExp(name="SOURCEID", expression="t1.SOURCEID", showorder=7), @DEDataQueryCodeExp(name="SRCPSDEVSLNSYSID", expression="t1.SRCPSDEVSLNSYSID", showorder=8), @DEDataQueryCodeExp(name="SRCPSDEVSLNSYSNAME", expression="t1.SRCPSDEVSLNSYSNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12)}, conds={})})
public class PSSystemSrcDefaultDQModel
extends DEDataQueryModelBase {
    public PSSystemSrcDefaultDQModel() {
        this.initAnnotation(PSSystemSrcDefaultDQModel.class);
    }
}

