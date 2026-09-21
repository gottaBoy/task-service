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
package net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="B3E391E2-9F9C-4D03-9881-85CB2F1F1BDD", name="CurDCDE")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ALLDCFLAG`, t1.`CODECAT`, t1.`CODETARGET`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`KEYWORDS`, t1.`MEMO`, t1.`PSDCCODESNIPPETID`, t1.`PSDCCODESNIPPETNAME`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`PSDEVSLNID`, t11.`PSDEVSLNNAME`, t1.`REFMODE`, t1.`TEMPLCODE`, t1.`TEMPLCODE2`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDCCODESNIPPET` t1  LEFT JOIN `T_SRFPSDEVSLN` t11 ON t1.`PSDEVSLNID` = t11.`PSDEVSLNID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ALLDCFLAG", expression="t1.`ALLDCFLAG`", showorder=0), @DEDataQueryCodeExp(name="CODECAT", expression="t1.`CODECAT`", showorder=1), @DEDataQueryCodeExp(name="CODETARGET", expression="t1.`CODETARGET`", showorder=2), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=3), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=4), @DEDataQueryCodeExp(name="KEYWORDS", expression="t1.`KEYWORDS`", showorder=5), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=6), @DEDataQueryCodeExp(name="PSDCCODESNIPPETID", expression="t1.`PSDCCODESNIPPETID`", showorder=7), @DEDataQueryCodeExp(name="PSDCCODESNIPPETNAME", expression="t1.`PSDCCODESNIPPETNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=9), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=10), @DEDataQueryCodeExp(name="PSDEVSLNID", expression="t1.`PSDEVSLNID`", showorder=11), @DEDataQueryCodeExp(name="PSDEVSLNNAME", expression="t11.`PSDEVSLNNAME`", showorder=12), @DEDataQueryCodeExp(name="REFMODE", expression="t1.`REFMODE`", showorder=13), @DEDataQueryCodeExp(name="TEMPLCODE", expression="t1.`TEMPLCODE`", showorder=14), @DEDataQueryCodeExp(name="TEMPLCODE2", expression="t1.`TEMPLCODE2`", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=17)}, conds={@DEDataQueryCodeCond(condition="( t1.`ALLDCFLAG` = 0  AND  t1.`PSDEVCENTERID` =  ${srfdatacontext('psdevcenterid','{\"defname\":\"PSDEVCENTERID\",\"dename\":\"PSDCCODESNIPPET\"}')}  AND  t1.`CODETARGET` = 'PSDATAENTITY' )")}), @DEDataQueryCode(querycode="SELECT t1.ALLDCFLAG, t1.CODECAT, t1.CODETARGET, t1.CREATEDATE, t1.CREATEMAN, t1.KEYWORDS, t1.MEMO, t1.PSDCCODESNIPPETID, t1.PSDCCODESNIPPETNAME, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.PSDEVSLNID, t11.PSDEVSLNNAME, t1.REFMODE, t1.TEMPLCODE, t1.TEMPLCODE2, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDCCODESNIPPET t1  LEFT JOIN T_SRFPSDEVSLN t11 ON t1.PSDEVSLNID = t11.PSDEVSLNID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ALLDCFLAG", expression="t1.ALLDCFLAG", showorder=0), @DEDataQueryCodeExp(name="CODECAT", expression="t1.CODECAT", showorder=1), @DEDataQueryCodeExp(name="CODETARGET", expression="t1.CODETARGET", showorder=2), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=3), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=4), @DEDataQueryCodeExp(name="KEYWORDS", expression="t1.KEYWORDS", showorder=5), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=6), @DEDataQueryCodeExp(name="PSDCCODESNIPPETID", expression="t1.PSDCCODESNIPPETID", showorder=7), @DEDataQueryCodeExp(name="PSDCCODESNIPPETNAME", expression="t1.PSDCCODESNIPPETNAME", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=9), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=10), @DEDataQueryCodeExp(name="PSDEVSLNID", expression="t1.PSDEVSLNID", showorder=11), @DEDataQueryCodeExp(name="PSDEVSLNNAME", expression="t11.PSDEVSLNNAME", showorder=12), @DEDataQueryCodeExp(name="REFMODE", expression="t1.REFMODE", showorder=13), @DEDataQueryCodeExp(name="TEMPLCODE", expression="t1.TEMPLCODE", showorder=14), @DEDataQueryCodeExp(name="TEMPLCODE2", expression="t1.TEMPLCODE2", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=17)}, conds={@DEDataQueryCodeCond(condition="( t1.ALLDCFLAG = 0  AND  t1.PSDEVCENTERID =  ${srfdatacontext('psdevcenterid','{\"defname\":\"PSDEVCENTERID\",\"dename\":\"PSDCCODESNIPPET\"}')}  AND  t1.CODETARGET = 'PSDATAENTITY' )")})})
public class PSDCCodeSnippetCurDCDEDQModel
extends DEDataQueryModelBase {
    public PSDCCodeSnippetCurDCDEDQModel() {
        this.initAnnotation(PSDCCodeSnippetCurDCDEDQModel.class);
    }
}

