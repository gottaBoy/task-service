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
package net.ibizsys.pscore.srv.config.demodel.psdbvaluefunc.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="D28EAED3-3F0C-4706-8742-7FBA33DE7CB8", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ALLDCFLAG`, t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`FUNCSN`, t1.`INPUTSTDDATATYPE`, t1.`LOGICNAME`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`OUTPUTSTDDATATYPE`, t1.`OUTPUTVALUEFORMAT`, t1.`PSDBVALUEFUNCID`, t1.`PSDBVALUEFUNCNAME`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`UXCODENAME`, t1.`VALIDFLAG` FROM `T_SRFPSDBVALUEFUNC` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ALLDCFLAG", expression="t1.`ALLDCFLAG`", showorder=0), @DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="FUNCSN", expression="t1.`FUNCSN`", showorder=4), @DEDataQueryCodeExp(name="INPUTSTDDATATYPE", expression="t1.`INPUTSTDDATATYPE`", showorder=5), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.`LOGICNAME`", showorder=6), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=7), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=8), @DEDataQueryCodeExp(name="OUTPUTSTDDATATYPE", expression="t1.`OUTPUTSTDDATATYPE`", showorder=9), @DEDataQueryCodeExp(name="OUTPUTVALUEFORMAT", expression="t1.`OUTPUTVALUEFORMAT`", showorder=10), @DEDataQueryCodeExp(name="PSDBVALUEFUNCID", expression="t1.`PSDBVALUEFUNCID`", showorder=11), @DEDataQueryCodeExp(name="PSDBVALUEFUNCNAME", expression="t1.`PSDBVALUEFUNCNAME`", showorder=12), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=13), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=16), @DEDataQueryCodeExp(name="UXCODENAME", expression="t1.`UXCODENAME`", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=18)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.ALLDCFLAG, t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.FUNCSN, t1.INPUTSTDDATATYPE, t1.LOGICNAME, t1.MEMO, t1.ORDERVALUE, t1.OUTPUTSTDDATATYPE, t1.OUTPUTVALUEFORMAT, t1.PSDBVALUEFUNCID, t1.PSDBVALUEFUNCNAME, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.UXCODENAME, t1.VALIDFLAG FROM T_SRFPSDBVALUEFUNC t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ALLDCFLAG", expression="t1.ALLDCFLAG", showorder=0), @DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="FUNCSN", expression="t1.FUNCSN", showorder=4), @DEDataQueryCodeExp(name="INPUTSTDDATATYPE", expression="t1.INPUTSTDDATATYPE", showorder=5), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.LOGICNAME", showorder=6), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=7), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=8), @DEDataQueryCodeExp(name="OUTPUTSTDDATATYPE", expression="t1.OUTPUTSTDDATATYPE", showorder=9), @DEDataQueryCodeExp(name="OUTPUTVALUEFORMAT", expression="t1.OUTPUTVALUEFORMAT", showorder=10), @DEDataQueryCodeExp(name="PSDBVALUEFUNCID", expression="t1.PSDBVALUEFUNCID", showorder=11), @DEDataQueryCodeExp(name="PSDBVALUEFUNCNAME", expression="t1.PSDBVALUEFUNCNAME", showorder=12), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=13), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=16), @DEDataQueryCodeExp(name="UXCODENAME", expression="t1.UXCODENAME", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=18)}, conds={})})
public class PSDBValueFuncDefaultDQModel
extends DEDataQueryModelBase {
    public PSDBValueFuncDefaultDQModel() {
        this.initAnnotation(PSDBValueFuncDefaultDQModel.class);
    }
}

