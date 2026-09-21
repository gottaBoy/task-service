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
package net.ibizsys.pscore.srv.def.demodel.psdbprocparam.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="AAEF0E06-BC08-4E91-B009-39AE23B3488C", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`JDBCTYPE`, t1.`ORDERVALUE`, t1.`PARAMDIR`, t1.`PSDBPROCPARAMID`, t1.`PSDBPROCPARAMNAME`, t1.`PSDESPCODEID`, t11.`PSDESPCODENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDBPROCPARAM` t1  LEFT JOIN T_SRFPSDESPCODE t11 ON t1.PSDESPCODEID = t11.PSDESPCODEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="JDBCTYPE", expression="t1.`JDBCTYPE`", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=3), @DEDataQueryCodeExp(name="PARAMDIR", expression="t1.`PARAMDIR`", showorder=4), @DEDataQueryCodeExp(name="PSDBPROCPARAMID", expression="t1.`PSDBPROCPARAMID`", showorder=5), @DEDataQueryCodeExp(name="PSDBPROCPARAMNAME", expression="t1.`PSDBPROCPARAMNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDESPCODEID", expression="t1.`PSDESPCODEID`", showorder=7), @DEDataQueryCodeExp(name="PSDESPCODENAME", expression="t11.`PSDESPCODENAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.JDBCTYPE, t1.ORDERVALUE, t1.PARAMDIR, t1.PSDBPROCPARAMID, t1.PSDBPROCPARAMNAME, t1.PSDESPCODEID, t11.PSDESPCODENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDBPROCPARAM t1  LEFT JOIN T_SRFPSDESPCODE t11 ON t1.PSDESPCODEID = t11.PSDESPCODEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="JDBCTYPE", expression="t1.JDBCTYPE", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=3), @DEDataQueryCodeExp(name="PARAMDIR", expression="t1.PARAMDIR", showorder=4), @DEDataQueryCodeExp(name="PSDBPROCPARAMID", expression="t1.PSDBPROCPARAMID", showorder=5), @DEDataQueryCodeExp(name="PSDBPROCPARAMNAME", expression="t1.PSDBPROCPARAMNAME", showorder=6), @DEDataQueryCodeExp(name="PSDESPCODEID", expression="t1.PSDESPCODEID", showorder=7), @DEDataQueryCodeExp(name="PSDESPCODENAME", expression="t11.PSDESPCODENAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10)}, conds={})})
public class PSDBProcParamDefaultDQModel
extends DEDataQueryModelBase {
    public PSDBProcParamDefaultDQModel() {
        this.initAnnotation(PSDBProcParamDefaultDQModel.class);
    }
}

