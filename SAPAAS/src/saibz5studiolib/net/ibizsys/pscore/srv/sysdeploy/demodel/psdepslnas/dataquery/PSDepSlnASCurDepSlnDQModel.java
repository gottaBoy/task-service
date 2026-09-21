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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnas.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="E2A9EA14-E290-4B35-B2EA-080CDC6A350D", name="CurDepSln")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ASTYPE`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENABLELOCALMODE`, t1.`ENABLEREMOTEMODE`, t1.`HTTPPORT`, t1.`MEMO`, t1.`PSDEPSLNASID`, t1.`PSDEPSLNASNAME`, t1.`PSDEPSLNHOSTID`, t11.`PSDEPSLNHOSTNAME`, t1.`PSDEPSLNID`, t21.`PSDEPSLNNAME`, t1.`PSDEVCENTERASID`, t31.`PSDEVCENTERASNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEPSLNAS` t1  LEFT JOIN T_SRFPSDEPSLNHOST t11 ON t1.PSDEPSLNHOSTID = t11.PSDEPSLNHOSTID  LEFT JOIN T_SRFPSDEPSLN t21 ON t1.PSDEPSLNID = t21.PSDEPSLNID  LEFT JOIN T_SRFPSDEVCENTERAS t31 ON t1.PSDEVCENTERASID = t31.PSDEVCENTERASID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ASTYPE", expression="t1.`ASTYPE`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="ENABLELOCALMODE", expression="t1.`ENABLELOCALMODE`", showorder=3), @DEDataQueryCodeExp(name="ENABLEREMOTEMODE", expression="t1.`ENABLEREMOTEMODE`", showorder=4), @DEDataQueryCodeExp(name="HTTPPORT", expression="t1.`HTTPPORT`", showorder=5), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNASID", expression="t1.`PSDEPSLNASID`", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNASNAME", expression="t1.`PSDEPSLNASNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDEPSLNHOSTID", expression="t1.`PSDEPSLNHOSTID`", showorder=9), @DEDataQueryCodeExp(name="PSDEPSLNHOSTNAME", expression="t11.`PSDEPSLNHOSTNAME`", showorder=10), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.`PSDEPSLNID`", showorder=11), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t21.`PSDEPSLNNAME`", showorder=12), @DEDataQueryCodeExp(name="PSDEVCENTERASID", expression="t1.`PSDEVCENTERASID`", showorder=13), @DEDataQueryCodeExp(name="PSDEVCENTERASNAME", expression="t31.`PSDEVCENTERASNAME`", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=16)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSDEPSLNID` =  ${srfdatacontext('psdepslnid','{\"defname\":\"PSDEPSLNID\",\"dename\":\"PSDEPSLNAS\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.ASTYPE, t1.CREATEDATE, t1.CREATEMAN, t1.ENABLELOCALMODE, t1.ENABLEREMOTEMODE, t1.HTTPPORT, t1.MEMO, t1.PSDEPSLNASID, t1.PSDEPSLNASNAME, t1.PSDEPSLNHOSTID, t11.PSDEPSLNHOSTNAME, t1.PSDEPSLNID, t21.PSDEPSLNNAME, t1.PSDEVCENTERASID, t31.PSDEVCENTERASNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEPSLNAS t1  LEFT JOIN T_SRFPSDEPSLNHOST t11 ON t1.PSDEPSLNHOSTID = t11.PSDEPSLNHOSTID  LEFT JOIN T_SRFPSDEPSLN t21 ON t1.PSDEPSLNID = t21.PSDEPSLNID  LEFT JOIN T_SRFPSDEVCENTERAS t31 ON t1.PSDEVCENTERASID = t31.PSDEVCENTERASID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ASTYPE", expression="t1.ASTYPE", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="ENABLELOCALMODE", expression="t1.ENABLELOCALMODE", showorder=3), @DEDataQueryCodeExp(name="ENABLEREMOTEMODE", expression="t1.ENABLEREMOTEMODE", showorder=4), @DEDataQueryCodeExp(name="HTTPPORT", expression="t1.HTTPPORT", showorder=5), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNASID", expression="t1.PSDEPSLNASID", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNASNAME", expression="t1.PSDEPSLNASNAME", showorder=8), @DEDataQueryCodeExp(name="PSDEPSLNHOSTID", expression="t1.PSDEPSLNHOSTID", showorder=9), @DEDataQueryCodeExp(name="PSDEPSLNHOSTNAME", expression="t11.PSDEPSLNHOSTNAME", showorder=10), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.PSDEPSLNID", showorder=11), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t21.PSDEPSLNNAME", showorder=12), @DEDataQueryCodeExp(name="PSDEVCENTERASID", expression="t1.PSDEVCENTERASID", showorder=13), @DEDataQueryCodeExp(name="PSDEVCENTERASNAME", expression="t31.PSDEVCENTERASNAME", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=16)}, conds={@DEDataQueryCodeCond(condition="( t1.PSDEPSLNID =  ${srfdatacontext('psdepslnid','{\"defname\":\"PSDEPSLNID\",\"dename\":\"PSDEPSLNAS\"}')} )")})})
public class PSDepSlnASCurDepSlnDQModel
extends DEDataQueryModelBase {
    public PSDepSlnASCurDepSlnDQModel() {
        this.initAnnotation(PSDepSlnASCurDepSlnDQModel.class);
    }
}

