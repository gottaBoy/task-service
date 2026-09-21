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
package net.ibizsys.pscore.srv.wfdesign.demodel.pssyswfcat.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="EA4CF256-4ACE-4CA6-AD69-451C636BF5A3", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CATCODE`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSMODULEID`, t11.`PSMODULENAME`, t1.`PSSYSTEMID`, t1.`PSSYSTEMNAME`, t1.`PSSYSWFCATID`, t1.`PSSYSWFCATNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4`, t1.`VALIDFLAG` FROM `T_SRFPSSYSWFCAT` t1  LEFT JOIN `T_SRFPSMODULE` t11 ON t1.`PSMODULEID` = t11.`PSMODULEID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CATCODE", expression="t1.`CATCODE`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=4), @DEDataQueryCodeExp(name="PSMODULEID", expression="t1.`PSMODULEID`", showorder=5), @DEDataQueryCodeExp(name="PSMODULENAME", expression="t11.`PSMODULENAME`", showorder=6), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=7), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.`PSSYSTEMNAME`", showorder=8), @DEDataQueryCodeExp(name="PSSYSWFCATID", expression="t1.`PSSYSWFCATID`", showorder=9), @DEDataQueryCodeExp(name="PSSYSWFCATNAME", expression="t1.`PSSYSWFCATNAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=13), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=14), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=15), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=16), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=18)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CATCODE, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PSMODULEID, t11.PSMODULENAME, t1.PSSYSTEMID, t1.PSSYSTEMNAME, t1.PSSYSWFCATID, t1.PSSYSWFCATNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4, t1.VALIDFLAG FROM T_SRFPSSYSWFCAT t1  LEFT JOIN T_SRFPSMODULE t11 ON t1.PSMODULEID = t11.PSMODULEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CATCODE", expression="t1.CATCODE", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=4), @DEDataQueryCodeExp(name="PSMODULEID", expression="t1.PSMODULEID", showorder=5), @DEDataQueryCodeExp(name="PSMODULENAME", expression="t11.PSMODULENAME", showorder=6), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=7), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.PSSYSTEMNAME", showorder=8), @DEDataQueryCodeExp(name="PSSYSWFCATID", expression="t1.PSSYSWFCATID", showorder=9), @DEDataQueryCodeExp(name="PSSYSWFCATNAME", expression="t1.PSSYSWFCATNAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=13), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=14), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=15), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=16), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=18)}, conds={})})
public class PSSysWFCatDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysWFCatDefaultDQModel() {
        this.initAnnotation(PSSysWFCatDefaultDQModel.class);
    }
}

