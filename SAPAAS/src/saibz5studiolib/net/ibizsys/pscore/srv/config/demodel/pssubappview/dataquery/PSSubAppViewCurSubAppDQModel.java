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
package net.ibizsys.pscore.srv.config.demodel.pssubappview.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="0F427D8B-C095-4869-A351-9D0515555F3E", name="CurSubApp")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`BACKENDURL`, t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`FULLCODENAME`, t1.`MODULECODENAME`, t1.`MODULENAME`, t1.`PAGEURL`, t1.`PSAPPVIEWID`, t1.`PSDEVIEWBASEID`, t1.`PSSUBAPPID`, t1.`PSSUBAPPNAME`, t1.`PSSUBAPPVIEWID`, t1.`PSSUBAPPVIEWNAME`, t1.`PSSUBDEVIEWID`, t11.`PSSUBDEVIEWNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSUBAPPVIEW` t1  LEFT JOIN `T_SRFPSSUBDEVIEW` t11 ON t1.`PSSUBDEVIEWID` = t11.`PSSUBDEVIEWID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="BACKENDURL", expression="t1.`BACKENDURL`", showorder=0), @DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="FULLCODENAME", expression="t1.`FULLCODENAME`", showorder=4), @DEDataQueryCodeExp(name="MODULECODENAME", expression="t1.`MODULECODENAME`", showorder=5), @DEDataQueryCodeExp(name="MODULENAME", expression="t1.`MODULENAME`", showorder=6), @DEDataQueryCodeExp(name="PAGEURL", expression="t1.`PAGEURL`", showorder=7), @DEDataQueryCodeExp(name="PSAPPVIEWID", expression="t1.`PSAPPVIEWID`", showorder=8), @DEDataQueryCodeExp(name="PSDEVIEWBASEID", expression="t1.`PSDEVIEWBASEID`", showorder=9), @DEDataQueryCodeExp(name="PSSUBAPPID", expression="t1.`PSSUBAPPID`", showorder=10), @DEDataQueryCodeExp(name="PSSUBAPPNAME", expression="t1.`PSSUBAPPNAME`", showorder=11), @DEDataQueryCodeExp(name="PSSUBAPPVIEWID", expression="t1.`PSSUBAPPVIEWID`", showorder=12), @DEDataQueryCodeExp(name="PSSUBAPPVIEWNAME", expression="t1.`PSSUBAPPVIEWNAME`", showorder=13), @DEDataQueryCodeExp(name="PSSUBDEVIEWID", expression="t1.`PSSUBDEVIEWID`", showorder=14), @DEDataQueryCodeExp(name="PSSUBDEVIEWNAME", expression="t11.`PSSUBDEVIEWNAME`", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=17)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSSUBAPPID` =  ${srfdatacontext('pssubappid','{\"defname\":\"PSSUBAPPID\",\"dename\":\"PSSUBAPPVIEW\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.BACKENDURL, t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.FULLCODENAME, t1.MODULECODENAME, t1.MODULENAME, t1.PAGEURL, t1.PSAPPVIEWID, t1.PSDEVIEWBASEID, t1.PSSUBAPPID, t1.PSSUBAPPNAME, t1.PSSUBAPPVIEWID, t1.PSSUBAPPVIEWNAME, t1.PSSUBDEVIEWID, t11.PSSUBDEVIEWNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSUBAPPVIEW t1  LEFT JOIN T_SRFPSSUBDEVIEW t11 ON t1.PSSUBDEVIEWID = t11.PSSUBDEVIEWID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="BACKENDURL", expression="t1.BACKENDURL", showorder=0), @DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="FULLCODENAME", expression="t1.FULLCODENAME", showorder=4), @DEDataQueryCodeExp(name="MODULECODENAME", expression="t1.MODULECODENAME", showorder=5), @DEDataQueryCodeExp(name="MODULENAME", expression="t1.MODULENAME", showorder=6), @DEDataQueryCodeExp(name="PAGEURL", expression="t1.PAGEURL", showorder=7), @DEDataQueryCodeExp(name="PSAPPVIEWID", expression="t1.PSAPPVIEWID", showorder=8), @DEDataQueryCodeExp(name="PSDEVIEWBASEID", expression="t1.PSDEVIEWBASEID", showorder=9), @DEDataQueryCodeExp(name="PSSUBAPPID", expression="t1.PSSUBAPPID", showorder=10), @DEDataQueryCodeExp(name="PSSUBAPPNAME", expression="t1.PSSUBAPPNAME", showorder=11), @DEDataQueryCodeExp(name="PSSUBAPPVIEWID", expression="t1.PSSUBAPPVIEWID", showorder=12), @DEDataQueryCodeExp(name="PSSUBAPPVIEWNAME", expression="t1.PSSUBAPPVIEWNAME", showorder=13), @DEDataQueryCodeExp(name="PSSUBDEVIEWID", expression="t1.PSSUBDEVIEWID", showorder=14), @DEDataQueryCodeExp(name="PSSUBDEVIEWNAME", expression="t11.PSSUBDEVIEWNAME", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=17)}, conds={@DEDataQueryCodeCond(condition="( t1.PSSUBAPPID =  ${srfdatacontext('pssubappid','{\"defname\":\"PSSUBAPPID\",\"dename\":\"PSSUBAPPVIEW\"}')} )")})})
public class PSSubAppViewCurSubAppDQModel
extends DEDataQueryModelBase {
    public PSSubAppViewCurSubAppDQModel() {
        this.initAnnotation(PSSubAppViewCurSubAppDQModel.class);
    }
}

