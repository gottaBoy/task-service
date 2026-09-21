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
package net.ibizsys.pscore.srv.appdesign.demodel.psapppfplugin.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="B79E1D57-76CF-43B5-BA33-AB3DEFC4AAA2", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSAPPPFPLUGINID`, t1.`PSAPPPFPLUGINNAME`, t1.`PSSYSAPPID`, t11.`PSSYSAPPNAME`, t1.`PSSYSPFPLUGINID`, t21.`PSSYSPFPLUGINNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4`, t1.`VALIDFLAG` FROM `T_SRFPSAPPPFPLUGIN` t1  LEFT JOIN `T_SRFPSSYSAPP` t11 ON t1.`PSSYSAPPID` = t11.`PSSYSAPPID`  LEFT JOIN `T_SRFPSSYSPFPLUGIN` t21 ON t1.`PSSYSPFPLUGINID` = t21.`PSSYSPFPLUGINID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSAPPPFPLUGINID", expression="t1.`PSAPPPFPLUGINID`", showorder=4), @DEDataQueryCodeExp(name="PSAPPPFPLUGINNAME", expression="t1.`PSAPPPFPLUGINNAME`", showorder=5), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.`PSSYSAPPID`", showorder=6), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t11.`PSSYSAPPNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSYSPFPLUGINID", expression="t1.`PSSYSPFPLUGINID`", showorder=8), @DEDataQueryCodeExp(name="PSSYSPFPLUGINNAME", expression="t21.`PSSYSPFPLUGINNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=12), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=13), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=14), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=15), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=16), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=17)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSAPPPFPLUGINID, t1.PSAPPPFPLUGINNAME, t1.PSSYSAPPID, t11.PSSYSAPPNAME, t1.PSSYSPFPLUGINID, t21.PSSYSPFPLUGINNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4, t1.VALIDFLAG FROM T_SRFPSAPPPFPLUGIN t1  LEFT JOIN T_SRFPSSYSAPP t11 ON t1.PSSYSAPPID = t11.PSSYSAPPID  LEFT JOIN T_SRFPSSYSPFPLUGIN t21 ON t1.PSSYSPFPLUGINID = t21.PSSYSPFPLUGINID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSAPPPFPLUGINID", expression="t1.PSAPPPFPLUGINID", showorder=4), @DEDataQueryCodeExp(name="PSAPPPFPLUGINNAME", expression="t1.PSAPPPFPLUGINNAME", showorder=5), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.PSSYSAPPID", showorder=6), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t11.PSSYSAPPNAME", showorder=7), @DEDataQueryCodeExp(name="PSSYSPFPLUGINID", expression="t1.PSSYSPFPLUGINID", showorder=8), @DEDataQueryCodeExp(name="PSSYSPFPLUGINNAME", expression="t21.PSSYSPFPLUGINNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=12), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=13), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=14), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=15), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=16), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=17)}, conds={})})
public class PSAppPFPluginDefaultDQModel
extends DEDataQueryModelBase {
    public PSAppPFPluginDefaultDQModel() {
        this.initAnnotation(PSAppPFPluginDefaultDQModel.class);
    }
}

