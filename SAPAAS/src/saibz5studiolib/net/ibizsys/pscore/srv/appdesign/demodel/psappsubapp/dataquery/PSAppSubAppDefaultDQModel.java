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
package net.ibizsys.pscore.srv.appdesign.demodel.psappsubapp.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="22B8B0CC-2E80-4884-AA45-E6940B2A63F5", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`FOLDERNAME`, t1.`MEMO`, t1.`PSAPPSUBAPPID`, t1.`PSAPPSUBAPPNAME`, t1.`PSSUBAPPID`, t11.`PSSUBAPPNAME`, t1.`PSSUBSYSID`, t21.`PSSUBSYSNAME`, t1.`PSSYSAPPID`, t31.`PSSYSAPPNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSAPPSUBAPP` t1  LEFT JOIN `T_SRFPSSUBAPP` t11 ON t1.`PSSUBAPPID` = t11.`PSSUBAPPID`  LEFT JOIN `T_SRFPSSUBSYS` t21 ON t1.`PSSUBSYSID` = t21.`PSSUBSYSID`  LEFT JOIN `T_SRFPSSYSAPP` t31 ON t1.`PSSYSAPPID` = t31.`PSSYSAPPID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="FOLDERNAME", expression="t1.`FOLDERNAME`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSAPPSUBAPPID", expression="t1.`PSAPPSUBAPPID`", showorder=4), @DEDataQueryCodeExp(name="PSAPPSUBAPPNAME", expression="t1.`PSAPPSUBAPPNAME`", showorder=5), @DEDataQueryCodeExp(name="PSSUBAPPID", expression="t1.`PSSUBAPPID`", showorder=6), @DEDataQueryCodeExp(name="PSSUBAPPNAME", expression="t11.`PSSUBAPPNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSUBSYSID", expression="t1.`PSSUBSYSID`", showorder=8), @DEDataQueryCodeExp(name="PSSUBSYSNAME", expression="t21.`PSSUBSYSNAME`", showorder=9), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.`PSSYSAPPID`", showorder=10), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t31.`PSSYSAPPNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.FOLDERNAME, t1.MEMO, t1.PSAPPSUBAPPID, t1.PSAPPSUBAPPNAME, t1.PSSUBAPPID, t11.PSSUBAPPNAME, t1.PSSUBSYSID, t21.PSSUBSYSNAME, t1.PSSYSAPPID, t31.PSSYSAPPNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSAPPSUBAPP t1  LEFT JOIN T_SRFPSSUBAPP t11 ON t1.PSSUBAPPID = t11.PSSUBAPPID  LEFT JOIN T_SRFPSSUBSYS t21 ON t1.PSSUBSYSID = t21.PSSUBSYSID  LEFT JOIN T_SRFPSSYSAPP t31 ON t1.PSSYSAPPID = t31.PSSYSAPPID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="FOLDERNAME", expression="t1.FOLDERNAME", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSAPPSUBAPPID", expression="t1.PSAPPSUBAPPID", showorder=4), @DEDataQueryCodeExp(name="PSAPPSUBAPPNAME", expression="t1.PSAPPSUBAPPNAME", showorder=5), @DEDataQueryCodeExp(name="PSSUBAPPID", expression="t1.PSSUBAPPID", showorder=6), @DEDataQueryCodeExp(name="PSSUBAPPNAME", expression="t11.PSSUBAPPNAME", showorder=7), @DEDataQueryCodeExp(name="PSSUBSYSID", expression="t1.PSSUBSYSID", showorder=8), @DEDataQueryCodeExp(name="PSSUBSYSNAME", expression="t21.PSSUBSYSNAME", showorder=9), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.PSSYSAPPID", showorder=10), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t31.PSSYSAPPNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSAppSubAppDefaultDQModel
extends DEDataQueryModelBase {
    public PSAppSubAppDefaultDQModel() {
        this.initAnnotation(PSAppSubAppDefaultDQModel.class);
    }
}

