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
package net.ibizsys.pscore.srv.unisys.demodel.psusmoduleinst.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="AAE562E2-5312-4F88-B4B7-82F87224E26A", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ADMINSERVICEURL`, t1.`ADMINURL`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSUSMODULEID`, t1.`PSUSMODULEINSTID`, t1.`PSUSMODULEINSTNAME`, t11.`PSUSMODULENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSUSMODULEINST` t1  LEFT JOIN T_SRFPSUSMODULE t11 ON t1.PSUSMODULEID = t11.PSUSMODULEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ADMINSERVICEURL", expression="t1.`ADMINSERVICEURL`", showorder=0), @DEDataQueryCodeExp(name="ADMINURL", expression="t1.`ADMINURL`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSUSMODULEID", expression="t1.`PSUSMODULEID`", showorder=5), @DEDataQueryCodeExp(name="PSUSMODULEINSTID", expression="t1.`PSUSMODULEINSTID`", showorder=6), @DEDataQueryCodeExp(name="PSUSMODULEINSTNAME", expression="t1.`PSUSMODULEINSTNAME`", showorder=7), @DEDataQueryCodeExp(name="PSUSMODULENAME", expression="t11.`PSUSMODULENAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.ADMINSERVICEURL, t1.ADMINURL, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSUSMODULEID, t1.PSUSMODULEINSTID, t1.PSUSMODULEINSTNAME, t11.PSUSMODULENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSUSMODULEINST t1  LEFT JOIN T_SRFPSUSMODULE t11 ON t1.PSUSMODULEID = t11.PSUSMODULEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ADMINSERVICEURL", expression="t1.ADMINSERVICEURL", showorder=0), @DEDataQueryCodeExp(name="ADMINURL", expression="t1.ADMINURL", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSUSMODULEID", expression="t1.PSUSMODULEID", showorder=5), @DEDataQueryCodeExp(name="PSUSMODULEINSTID", expression="t1.PSUSMODULEINSTID", showorder=6), @DEDataQueryCodeExp(name="PSUSMODULEINSTNAME", expression="t1.PSUSMODULEINSTNAME", showorder=7), @DEDataQueryCodeExp(name="PSUSMODULENAME", expression="t11.PSUSMODULENAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=11)}, conds={})})
public class PSUSModuleInstDefaultDQModel
extends DEDataQueryModelBase {
    public PSUSModuleInstDefaultDQModel() {
        this.initAnnotation(PSUSModuleInstDefaultDQModel.class);
    }
}

