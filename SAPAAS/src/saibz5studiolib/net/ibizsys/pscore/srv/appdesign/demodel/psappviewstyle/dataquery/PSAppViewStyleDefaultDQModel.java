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
package net.ibizsys.pscore.srv.appdesign.demodel.psappviewstyle.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="3441E473-F773-41FE-98B0-EF98BED5577F", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSAPPVIEWSTYLEID`, t1.`PSAPPVIEWSTYLENAME`, t1.`PSSYSAPPID`, t11.`PSSYSAPPNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERPARAMS` FROM `T_SRFPSAPPVIEWSTYLE` t1  LEFT JOIN `T_SRFPSSYSAPP` t11 ON t1.`PSSYSAPPID` = t11.`PSSYSAPPID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSAPPVIEWSTYLEID", expression="t1.`PSAPPVIEWSTYLEID`", showorder=3), @DEDataQueryCodeExp(name="PSAPPVIEWSTYLENAME", expression="t1.`PSAPPVIEWSTYLENAME`", showorder=4), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.`PSSYSAPPID`", showorder=5), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t11.`PSSYSAPPNAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8), @DEDataQueryCodeExp(name="USERPARAMS", expression="t1.`USERPARAMS`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSAPPVIEWSTYLEID, t1.PSAPPVIEWSTYLENAME, t1.PSSYSAPPID, t11.PSSYSAPPNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERPARAMS FROM T_SRFPSAPPVIEWSTYLE t1  LEFT JOIN T_SRFPSSYSAPP t11 ON t1.PSSYSAPPID = t11.PSSYSAPPID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSAPPVIEWSTYLEID", expression="t1.PSAPPVIEWSTYLEID", showorder=3), @DEDataQueryCodeExp(name="PSAPPVIEWSTYLENAME", expression="t1.PSAPPVIEWSTYLENAME", showorder=4), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.PSSYSAPPID", showorder=5), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t11.PSSYSAPPNAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8), @DEDataQueryCodeExp(name="USERPARAMS", expression="t1.USERPARAMS", showorder=9)}, conds={})})
public class PSAppViewStyleDefaultDQModel
extends DEDataQueryModelBase {
    public PSAppViewStyleDefaultDQModel() {
        this.initAnnotation(PSAppViewStyleDefaultDQModel.class);
    }
}

