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
package net.ibizsys.pscore.srv.devcenter.demodel.psdcpfplugin.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="D2727E94-67FC-410D-869B-AF057B6DD2BB", name="CurDCValid")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PLUGINTAG`, t1.`PLUGINTYPE`, t1.`PSDCPFPLUGINID`, t1.`PSDCPFPLUGINNAME`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDCPFPLUGIN` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PLUGINTAG", expression="t1.`PLUGINTAG`", showorder=3), @DEDataQueryCodeExp(name="PLUGINTYPE", expression="t1.`PLUGINTYPE`", showorder=4), @DEDataQueryCodeExp(name="PSDCPFPLUGINID", expression="t1.`PSDCPFPLUGINID`", showorder=5), @DEDataQueryCodeExp(name="PSDCPFPLUGINNAME", expression="t1.`PSDCPFPLUGINNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=11)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSDEVCENTERID` =  ${srfdatacontext('psdevcenterid','{\"defname\":\"PSDEVCENTERID\",\"dename\":\"PSDCPFPLUGIN\"}')}  AND  t1.`VALIDFLAG` = 1 )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PLUGINTAG, t1.PLUGINTYPE, t1.PSDCPFPLUGINID, t1.PSDCPFPLUGINNAME, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDCPFPLUGIN t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PLUGINTAG", expression="t1.PLUGINTAG", showorder=3), @DEDataQueryCodeExp(name="PLUGINTYPE", expression="t1.PLUGINTYPE", showorder=4), @DEDataQueryCodeExp(name="PSDCPFPLUGINID", expression="t1.PSDCPFPLUGINID", showorder=5), @DEDataQueryCodeExp(name="PSDCPFPLUGINNAME", expression="t1.PSDCPFPLUGINNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=11)}, conds={@DEDataQueryCodeCond(condition="( t1.PSDEVCENTERID =  ${srfdatacontext('psdevcenterid','{\"defname\":\"PSDEVCENTERID\",\"dename\":\"PSDCPFPLUGIN\"}')}  AND  t1.VALIDFLAG = 1 )")})})
public class PSDCPFPluginCurDCValidDQModel
extends DEDataQueryModelBase {
    public PSDCPFPluginCurDCValidDQModel() {
        this.initAnnotation(PSDCPFPluginCurDCValidDQModel.class);
    }
}

