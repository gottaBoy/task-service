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
package net.ibizsys.pscore.srv.config.demodel.pssfstyleparam.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="60EF7F4B-3D53-4BC3-B91F-0899E59ED6D7", name="AllDCValid")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ALLDCFLAG`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`PSSFID`, t11.`PSSFNAME`, t1.`PSSFSTYLEID`, t21.`PSSFSTYLENAME`, t1.`PSSFSTYLEPARAMID`, t1.`PSSFSTYLEPARAMNAME`, t1.`STYLEPARAMS`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSSFSTYLEPARAM` t1  LEFT JOIN T_SRFPSSF t11 ON t1.PSSFID = t11.PSSFID  LEFT JOIN T_SRFPSSFSTYLE t21 ON t1.PSSFSTYLEID = t21.PSSFSTYLEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ALLDCFLAG", expression="t1.`ALLDCFLAG`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=5), @DEDataQueryCodeExp(name="PSSFID", expression="t1.`PSSFID`", showorder=6), @DEDataQueryCodeExp(name="PSSFNAME", expression="t11.`PSSFNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSFSTYLEID", expression="t1.`PSSFSTYLEID`", showorder=8), @DEDataQueryCodeExp(name="PSSFSTYLENAME", expression="t21.`PSSFSTYLENAME`", showorder=9), @DEDataQueryCodeExp(name="PSSFSTYLEPARAMID", expression="t1.`PSSFSTYLEPARAMID`", showorder=10), @DEDataQueryCodeExp(name="PSSFSTYLEPARAMNAME", expression="t1.`PSSFSTYLEPARAMNAME`", showorder=11), @DEDataQueryCodeExp(name="STYLEPARAMS", expression="t1.`STYLEPARAMS`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=15)}, conds={@DEDataQueryCodeCond(condition="( t1.`VALIDFLAG` = 1  AND  t1.`ALLDCFLAG` = 1 )")}), @DEDataQueryCode(querycode="SELECT t1.ALLDCFLAG, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.PSSFID, t11.PSSFNAME, t1.PSSFSTYLEID, t21.PSSFSTYLENAME, t1.PSSFSTYLEPARAMID, t1.PSSFSTYLEPARAMNAME, t1.STYLEPARAMS, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSSFSTYLEPARAM t1  LEFT JOIN T_SRFPSSF t11 ON t1.PSSFID = t11.PSSFID  LEFT JOIN T_SRFPSSFSTYLE t21 ON t1.PSSFSTYLEID = t21.PSSFSTYLEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ALLDCFLAG", expression="t1.ALLDCFLAG", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=4), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=5), @DEDataQueryCodeExp(name="PSSFID", expression="t1.PSSFID", showorder=6), @DEDataQueryCodeExp(name="PSSFNAME", expression="t11.PSSFNAME", showorder=7), @DEDataQueryCodeExp(name="PSSFSTYLEID", expression="t1.PSSFSTYLEID", showorder=8), @DEDataQueryCodeExp(name="PSSFSTYLENAME", expression="t21.PSSFSTYLENAME", showorder=9), @DEDataQueryCodeExp(name="PSSFSTYLEPARAMID", expression="t1.PSSFSTYLEPARAMID", showorder=10), @DEDataQueryCodeExp(name="PSSFSTYLEPARAMNAME", expression="t1.PSSFSTYLEPARAMNAME", showorder=11), @DEDataQueryCodeExp(name="STYLEPARAMS", expression="t1.STYLEPARAMS", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=15)}, conds={@DEDataQueryCodeCond(condition="( t1.VALIDFLAG = 1  AND  t1.ALLDCFLAG = 1 )")})})
public class PSSFStyleParamAllDCValidDQModel
extends DEDataQueryModelBase {
    public PSSFStyleParamAllDCValidDQModel() {
        this.initAnnotation(PSSFStyleParamAllDCValidDQModel.class);
    }
}

