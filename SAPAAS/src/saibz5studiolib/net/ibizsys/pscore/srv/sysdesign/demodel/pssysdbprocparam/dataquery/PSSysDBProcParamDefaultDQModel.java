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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdbprocparam.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="B62F5C2C-6402-4077-A0D1-0CBA946698F1", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEFAULTVALUE`, t1.`LENGTH`, t1.`LOGICNAME`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PARAMDIR`, t1.`PRECISION2`, t1.`PSSYSDBPROCID`, t11.`PSSYSDBPROCNAME`, t1.`PSSYSDBPROCPARAMID`, t1.`PSSYSDBPROCPARAMNAME`, t1.`STDDATATYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2` FROM `T_SRFPSSYSDBPROCPARAM` t1  LEFT JOIN `T_SRFPSSYSDBPROC` t11 ON t1.`PSSYSDBPROCID` = t11.`PSSYSDBPROCID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DEFAULTVALUE", expression="t1.`DEFAULTVALUE`", showorder=2), @DEDataQueryCodeExp(name="LENGTH", expression="t1.`LENGTH`", showorder=3), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.`LOGICNAME`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=6), @DEDataQueryCodeExp(name="PARAMDIR", expression="t1.`PARAMDIR`", showorder=7), @DEDataQueryCodeExp(name="PRECISION2", expression="t1.`PRECISION2`", showorder=8), @DEDataQueryCodeExp(name="PSSYSDBPROCID", expression="t1.`PSSYSDBPROCID`", showorder=9), @DEDataQueryCodeExp(name="PSSYSDBPROCNAME", expression="t11.`PSSYSDBPROCNAME`", showorder=10), @DEDataQueryCodeExp(name="PSSYSDBPROCPARAMID", expression="t1.`PSSYSDBPROCPARAMID`", showorder=11), @DEDataQueryCodeExp(name="PSSYSDBPROCPARAMNAME", expression="t1.`PSSYSDBPROCPARAMNAME`", showorder=12), @DEDataQueryCodeExp(name="STDDATATYPE", expression="t1.`STDDATATYPE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=16), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=17), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=18)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEFAULTVALUE, t1.LENGTH, t1.LOGICNAME, t1.MEMO, t1.ORDERVALUE, t1.PARAMDIR, t1.PRECISION2, t1.PSSYSDBPROCID, t11.PSSYSDBPROCNAME, t1.PSSYSDBPROCPARAMID, t1.PSSYSDBPROCPARAMNAME, t1.STDDATATYPE, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2 FROM T_SRFPSSYSDBPROCPARAM t1  LEFT JOIN T_SRFPSSYSDBPROC t11 ON t1.PSSYSDBPROCID = t11.PSSYSDBPROCID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DEFAULTVALUE", expression="t1.DEFAULTVALUE", showorder=2), @DEDataQueryCodeExp(name="LENGTH", expression="t1.LENGTH", showorder=3), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.LOGICNAME", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=6), @DEDataQueryCodeExp(name="PARAMDIR", expression="t1.PARAMDIR", showorder=7), @DEDataQueryCodeExp(name="PRECISION2", expression="t1.PRECISION2", showorder=8), @DEDataQueryCodeExp(name="PSSYSDBPROCID", expression="t1.PSSYSDBPROCID", showorder=9), @DEDataQueryCodeExp(name="PSSYSDBPROCNAME", expression="t11.PSSYSDBPROCNAME", showorder=10), @DEDataQueryCodeExp(name="PSSYSDBPROCPARAMID", expression="t1.PSSYSDBPROCPARAMID", showorder=11), @DEDataQueryCodeExp(name="PSSYSDBPROCPARAMNAME", expression="t1.PSSYSDBPROCPARAMNAME", showorder=12), @DEDataQueryCodeExp(name="STDDATATYPE", expression="t1.STDDATATYPE", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=16), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=17), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=18)}, conds={})})
public class PSSysDBProcParamDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysDBProcParamDefaultDQModel() {
        this.initAnnotation(PSSysDBProcParamDefaultDQModel.class);
    }
}

