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
package net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="4B42224F-5B84-4923-AE51-E2BD2474A649", name="FontSize")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ALLDCFLAG`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`PSVARSAMPLEVALUEID`, t1.`PSVARSAMPLEVALUENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERTAG`, t1.`USERTAG2`, t1.`VALIDFLAG`, t1.`VALUE`, t1.`VALUE2`, t1.`VARCAT`, t1.`VARTYPE` FROM `T_SRFPSVARSAMPLEVALUE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ALLDCFLAG", expression="t1.`ALLDCFLAG`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=6), @DEDataQueryCodeExp(name="PSVARSAMPLEVALUEID", expression="t1.`PSVARSAMPLEVALUEID`", showorder=7), @DEDataQueryCodeExp(name="PSVARSAMPLEVALUENAME", expression="t1.`PSVARSAMPLEVALUENAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=11), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=12), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=13), @DEDataQueryCodeExp(name="VALUE", expression="t1.`VALUE`", showorder=14), @DEDataQueryCodeExp(name="VALUE2", expression="t1.`VALUE2`", showorder=15), @DEDataQueryCodeExp(name="VARCAT", expression="t1.`VARCAT`", showorder=16), @DEDataQueryCodeExp(name="VARTYPE", expression="t1.`VARTYPE`", showorder=17)}, conds={@DEDataQueryCodeCond(condition="( t1.`VARCAT` = 'FONTSIZE'  AND  t1.`VALIDFLAG` = 1 )")}), @DEDataQueryCode(querycode="SELECT t1.ALLDCFLAG, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.PSVARSAMPLEVALUEID, t1.PSVARSAMPLEVALUENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERTAG, t1.USERTAG2, t1.VALIDFLAG, t1.VALUE, t1.VALUE2, t1.VARCAT, t1.VARTYPE FROM T_SRFPSVARSAMPLEVALUE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ALLDCFLAG", expression="t1.ALLDCFLAG", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=6), @DEDataQueryCodeExp(name="PSVARSAMPLEVALUEID", expression="t1.PSVARSAMPLEVALUEID", showorder=7), @DEDataQueryCodeExp(name="PSVARSAMPLEVALUENAME", expression="t1.PSVARSAMPLEVALUENAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=11), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=12), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=13), @DEDataQueryCodeExp(name="VALUE", expression="t1.VALUE", showorder=14), @DEDataQueryCodeExp(name="VALUE2", expression="t1.VALUE2", showorder=15), @DEDataQueryCodeExp(name="VARCAT", expression="t1.VARCAT", showorder=16), @DEDataQueryCodeExp(name="VARTYPE", expression="t1.VARTYPE", showorder=17)}, conds={@DEDataQueryCodeCond(condition="( t1.VARCAT = 'FONTSIZE'  AND  t1.VALIDFLAG = 1 )")})})
public class PSVarSampleValueFontSizeDQModel
extends DEDataQueryModelBase {
    public PSVarSampleValueFontSizeDQModel() {
        this.initAnnotation(PSVarSampleValueFontSizeDQModel.class);
    }
}

