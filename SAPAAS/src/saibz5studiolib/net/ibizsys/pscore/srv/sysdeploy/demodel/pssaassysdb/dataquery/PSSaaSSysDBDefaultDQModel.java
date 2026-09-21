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
package net.ibizsys.pscore.srv.sysdeploy.demodel.pssaassysdb.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="8CC13891-4DEE-4621-9C55-824D90F60559", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t11.`PSDBDEVINSTID` AS `PSDBINSTID`, t1.`PSDEVCENTERDBINSTID`, t11.`PSDEVCENTERDBINSTNAME`, t1.`PSSAASSYSDBID`, t1.`PSSAASSYSDBNAME`, t1.`PSSAASSYSVERID`, t21.`PSSAASSYSVERNAME`, t31.`PSDBDEVINSTID` AS `SAMPLEPSDBINSTID`, t1.`SAMPLEPSDCDBINSTID`, t31.`PSDEVCENTERDBINSTNAME` AS `SAMPLEPSDCDBINSTNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSAASSYSDB` t1  LEFT JOIN T_SRFPSDEVCENTERDBINST t11 ON t1.PSDEVCENTERDBINSTID = t11.PSDEVCENTERDBINSTID  LEFT JOIN T_SRFPSSAASSYSVER t21 ON t1.PSSAASSYSVERID = t21.PSSAASSYSVERID  LEFT JOIN T_SRFPSDEVCENTERDBINST t31 ON t1.SAMPLEPSDCDBINSTID = t31.PSDEVCENTERDBINSTID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDBINSTID", expression="t11.`PSDBDEVINSTID`", showorder=3), @DEDataQueryCodeExp(name="PSDEVCENTERDBINSTID", expression="t1.`PSDEVCENTERDBINSTID`", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERDBINSTNAME", expression="t11.`PSDEVCENTERDBINSTNAME`", showorder=5), @DEDataQueryCodeExp(name="PSSAASSYSDBID", expression="t1.`PSSAASSYSDBID`", showorder=6), @DEDataQueryCodeExp(name="PSSAASSYSDBNAME", expression="t1.`PSSAASSYSDBNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSAASSYSVERID", expression="t1.`PSSAASSYSVERID`", showorder=8), @DEDataQueryCodeExp(name="PSSAASSYSVERNAME", expression="t21.`PSSAASSYSVERNAME`", showorder=9), @DEDataQueryCodeExp(name="SAMPLEPSDBINSTID", expression="t31.`PSDBDEVINSTID`", showorder=10), @DEDataQueryCodeExp(name="SAMPLEPSDCDBINSTID", expression="t1.`SAMPLEPSDCDBINSTID`", showorder=11), @DEDataQueryCodeExp(name="SAMPLEPSDCDBINSTNAME", expression="t31.`PSDEVCENTERDBINSTNAME`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t11.PSDBDEVINSTID AS PSDBINSTID, t1.PSDEVCENTERDBINSTID, t11.PSDEVCENTERDBINSTNAME, t1.PSSAASSYSDBID, t1.PSSAASSYSDBNAME, t1.PSSAASSYSVERID, t21.PSSAASSYSVERNAME, t31.PSDBDEVINSTID AS SAMPLEPSDBINSTID, t1.SAMPLEPSDCDBINSTID, t31.PSDEVCENTERDBINSTNAME AS SAMPLEPSDCDBINSTNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSAASSYSDB t1  LEFT JOIN T_SRFPSDEVCENTERDBINST t11 ON t1.PSDEVCENTERDBINSTID = t11.PSDEVCENTERDBINSTID  LEFT JOIN T_SRFPSSAASSYSVER t21 ON t1.PSSAASSYSVERID = t21.PSSAASSYSVERID  LEFT JOIN T_SRFPSDEVCENTERDBINST t31 ON t1.SAMPLEPSDCDBINSTID = t31.PSDEVCENTERDBINSTID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDBINSTID", expression="t11.PSDBDEVINSTID", showorder=3), @DEDataQueryCodeExp(name="PSDEVCENTERDBINSTID", expression="t1.PSDEVCENTERDBINSTID", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERDBINSTNAME", expression="t11.PSDEVCENTERDBINSTNAME", showorder=5), @DEDataQueryCodeExp(name="PSSAASSYSDBID", expression="t1.PSSAASSYSDBID", showorder=6), @DEDataQueryCodeExp(name="PSSAASSYSDBNAME", expression="t1.PSSAASSYSDBNAME", showorder=7), @DEDataQueryCodeExp(name="PSSAASSYSVERID", expression="t1.PSSAASSYSVERID", showorder=8), @DEDataQueryCodeExp(name="PSSAASSYSVERNAME", expression="t21.PSSAASSYSVERNAME", showorder=9), @DEDataQueryCodeExp(name="SAMPLEPSDBINSTID", expression="t31.PSDBDEVINSTID", showorder=10), @DEDataQueryCodeExp(name="SAMPLEPSDCDBINSTID", expression="t1.SAMPLEPSDCDBINSTID", showorder=11), @DEDataQueryCodeExp(name="SAMPLEPSDCDBINSTNAME", expression="t31.PSDEVCENTERDBINSTNAME", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14)}, conds={})})
public class PSSaaSSysDBDefaultDQModel
extends DEDataQueryModelBase {
    public PSSaaSSysDBDefaultDQModel() {
        this.initAnnotation(PSSaaSSysDBDefaultDQModel.class);
    }
}

