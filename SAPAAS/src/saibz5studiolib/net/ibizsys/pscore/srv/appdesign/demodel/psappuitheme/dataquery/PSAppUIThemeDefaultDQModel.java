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
package net.ibizsys.pscore.srv.appdesign.demodel.psappuitheme.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="5741CBFD-DA60-4E7F-AB14-077DB0546532", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSAPPUITHEMEID`, t1.`PSAPPUITHEMENAME`, t1.`PSSYSAPPID`, t11.`PSSYSAPPNAME`, t1.`THEMEDESC`, t1.`THEMETAG`, t1.`THEMEURL`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4`, t1.`VALIDFLAG` FROM `T_SRFPSAPPUITHEME` t1  LEFT JOIN `T_SRFPSSYSAPP` t11 ON t1.`PSSYSAPPID` = t11.`PSSYSAPPID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CSSSTYLE", expression="t1.`CSSSTYLE`", showorder=-1), @DEDataQueryCodeExp(name="THEMEPARAMS", expression="t1.`THEMEPARAMS`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=3), @DEDataQueryCodeExp(name="PSAPPUITHEMEID", expression="t1.`PSAPPUITHEMEID`", showorder=4), @DEDataQueryCodeExp(name="PSAPPUITHEMENAME", expression="t1.`PSAPPUITHEMENAME`", showorder=5), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.`PSSYSAPPID`", showorder=6), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t11.`PSSYSAPPNAME`", showorder=7), @DEDataQueryCodeExp(name="THEMEDESC", expression="t1.`THEMEDESC`", showorder=8), @DEDataQueryCodeExp(name="THEMETAG", expression="t1.`THEMETAG`", showorder=9), @DEDataQueryCodeExp(name="THEMEURL", expression="t1.`THEMEURL`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=13), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=14), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=15), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=16), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=18)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PSAPPUITHEMEID, t1.PSAPPUITHEMENAME, t1.PSSYSAPPID, t11.PSSYSAPPNAME, t1.THEMEDESC, t1.THEMETAG, t1.THEMEURL, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4, t1.VALIDFLAG FROM T_SRFPSAPPUITHEME t1  LEFT JOIN T_SRFPSSYSAPP t11 ON t1.PSSYSAPPID = t11.PSSYSAPPID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CSSSTYLE", expression="t1.CSSSTYLE", showorder=-1), @DEDataQueryCodeExp(name="THEMEPARAMS", expression="t1.THEMEPARAMS", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=3), @DEDataQueryCodeExp(name="PSAPPUITHEMEID", expression="t1.PSAPPUITHEMEID", showorder=4), @DEDataQueryCodeExp(name="PSAPPUITHEMENAME", expression="t1.PSAPPUITHEMENAME", showorder=5), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.PSSYSAPPID", showorder=6), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t11.PSSYSAPPNAME", showorder=7), @DEDataQueryCodeExp(name="THEMEDESC", expression="t1.THEMEDESC", showorder=8), @DEDataQueryCodeExp(name="THEMETAG", expression="t1.THEMETAG", showorder=9), @DEDataQueryCodeExp(name="THEMEURL", expression="t1.THEMEURL", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=13), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=14), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=15), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=16), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=18)}, conds={})})
public class PSAppUIThemeDefaultDQModel
extends DEDataQueryModelBase {
    public PSAppUIThemeDefaultDQModel() {
        this.initAnnotation(PSAppUIThemeDefaultDQModel.class);
    }
}

