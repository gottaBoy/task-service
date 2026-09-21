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
package net.ibizsys.pscore.srv.bdscheme.demodel.pssysbdmodule.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="1D121D8F-E10E-483C-9EB8-AD5E42DE771E", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DENAMES`, t1.`IMPDEMODE`, t1.`MEMO`, t1.`PSMODULEID`, t11.`PSMODULENAME`, t1.`PSSYSBDMODULEID`, t1.`PSSYSBDMODULENAME`, t1.`PSSYSBDSCHEMEID`, t21.`PSSYSBDSCHEMENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4` FROM `T_SRFPSSYSBDMODULE` t1  LEFT JOIN T_SRFPSMODULE t11 ON t1.PSMODULEID = t11.PSMODULEID  LEFT JOIN T_SRFPSSYSBDSCHEME t21 ON t1.PSSYSBDSCHEMEID = t21.PSSYSBDSCHEMEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="DENAMES", expression="t1.`DENAMES`", showorder=3), @DEDataQueryCodeExp(name="IMPDEMODE", expression="t1.`IMPDEMODE`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="PSMODULEID", expression="t1.`PSMODULEID`", showorder=6), @DEDataQueryCodeExp(name="PSMODULENAME", expression="t11.`PSMODULENAME`", showorder=7), @DEDataQueryCodeExp(name="PSSYSBDMODULEID", expression="t1.`PSSYSBDMODULEID`", showorder=8), @DEDataQueryCodeExp(name="PSSYSBDMODULENAME", expression="t1.`PSSYSBDMODULENAME`", showorder=9), @DEDataQueryCodeExp(name="PSSYSBDSCHEMEID", expression="t1.`PSSYSBDSCHEMEID`", showorder=10), @DEDataQueryCodeExp(name="PSSYSBDSCHEMENAME", expression="t21.`PSSYSBDSCHEMENAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=14), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=15), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=16), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=17), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=18)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.DENAMES, t1.IMPDEMODE, t1.MEMO, t1.PSMODULEID, t11.PSMODULENAME, t1.PSSYSBDMODULEID, t1.PSSYSBDMODULENAME, t1.PSSYSBDSCHEMEID, t21.PSSYSBDSCHEMENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4 FROM T_SRFPSSYSBDMODULE t1  LEFT JOIN T_SRFPSMODULE t11 ON t1.PSMODULEID = t11.PSMODULEID  LEFT JOIN T_SRFPSSYSBDSCHEME t21 ON t1.PSSYSBDSCHEMEID = t21.PSSYSBDSCHEMEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="DENAMES", expression="t1.DENAMES", showorder=3), @DEDataQueryCodeExp(name="IMPDEMODE", expression="t1.IMPDEMODE", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="PSMODULEID", expression="t1.PSMODULEID", showorder=6), @DEDataQueryCodeExp(name="PSMODULENAME", expression="t11.PSMODULENAME", showorder=7), @DEDataQueryCodeExp(name="PSSYSBDMODULEID", expression="t1.PSSYSBDMODULEID", showorder=8), @DEDataQueryCodeExp(name="PSSYSBDMODULENAME", expression="t1.PSSYSBDMODULENAME", showorder=9), @DEDataQueryCodeExp(name="PSSYSBDSCHEMEID", expression="t1.PSSYSBDSCHEMEID", showorder=10), @DEDataQueryCodeExp(name="PSSYSBDSCHEMENAME", expression="t21.PSSYSBDSCHEMENAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=14), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=15), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=16), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=17), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=18)}, conds={})})
public class PSSysBDModuleDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysBDModuleDefaultDQModel() {
        this.initAnnotation(PSSysBDModuleDefaultDQModel.class);
    }
}

