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
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psstudiotheme.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="D2C121D6-E6B5-4945-A7F2-2F70001A948F", name="AllDCValid")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ALLDCFLAG`, t1.`CARDCSSSTYLE`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`PSSTUDIOTHEMEID`, t1.`PSSTUDIOTHEMENAME`, t1.`THEMECODE`, t1.`THEMEDATA`, t1.`THEMEDATA2`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSSTUDIOTHEME` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ALLDCFLAG", expression="t1.`ALLDCFLAG`", showorder=0), @DEDataQueryCodeExp(name="CARDCSSSTYLE", expression="t1.`CARDCSSSTYLE`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=6), @DEDataQueryCodeExp(name="PSSTUDIOTHEMEID", expression="t1.`PSSTUDIOTHEMEID`", showorder=7), @DEDataQueryCodeExp(name="PSSTUDIOTHEMENAME", expression="t1.`PSSTUDIOTHEMENAME`", showorder=8), @DEDataQueryCodeExp(name="THEMECODE", expression="t1.`THEMECODE`", showorder=9), @DEDataQueryCodeExp(name="THEMEDATA", expression="t1.`THEMEDATA`", showorder=10), @DEDataQueryCodeExp(name="THEMEDATA2", expression="t1.`THEMEDATA2`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=14)}, conds={@DEDataQueryCodeCond(condition="( t1.`ALLDCFLAG` = 1  AND  t1.`VALIDFLAG` = 1 )")}), @DEDataQueryCode(querycode="SELECT t1.ALLDCFLAG, t1.CARDCSSSTYLE, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.PSSTUDIOTHEMEID, t1.PSSTUDIOTHEMENAME, t1.THEMECODE, t1.THEMEDATA, t1.THEMEDATA2, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSSTUDIOTHEME t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ALLDCFLAG", expression="t1.ALLDCFLAG", showorder=0), @DEDataQueryCodeExp(name="CARDCSSSTYLE", expression="t1.CARDCSSSTYLE", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=6), @DEDataQueryCodeExp(name="PSSTUDIOTHEMEID", expression="t1.PSSTUDIOTHEMEID", showorder=7), @DEDataQueryCodeExp(name="PSSTUDIOTHEMENAME", expression="t1.PSSTUDIOTHEMENAME", showorder=8), @DEDataQueryCodeExp(name="THEMECODE", expression="t1.THEMECODE", showorder=9), @DEDataQueryCodeExp(name="THEMEDATA", expression="t1.THEMEDATA", showorder=10), @DEDataQueryCodeExp(name="THEMEDATA2", expression="t1.THEMEDATA2", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=14)}, conds={@DEDataQueryCodeCond(condition="( t1.ALLDCFLAG = 1  AND  t1.VALIDFLAG = 1 )")})})
public class PSStudioThemeAllDCValidDQModel
extends DEDataQueryModelBase {
    public PSStudioThemeAllDCValidDQModel() {
        this.initAnnotation(PSStudioThemeAllDCValidDQModel.class);
    }
}

