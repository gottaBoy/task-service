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
package net.ibizsys.pscore.srv.config.demodel.psdbvalueop.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="9A938894-D33B-4D46-95E2-E5EFD7C3E093", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DBFLAG`, t1.`DLFLAG`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSDBVALUEOPID`, t1.`PSDBVALUEOPNAME`, t1.`SIMPLENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDBVALUEOP` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DBFLAG", expression="t1.`DBFLAG`", showorder=2), @DEDataQueryCodeExp(name="DLFLAG", expression="t1.`DLFLAG`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=5), @DEDataQueryCodeExp(name="PSDBVALUEOPID", expression="t1.`PSDBVALUEOPID`", showorder=6), @DEDataQueryCodeExp(name="PSDBVALUEOPNAME", expression="t1.`PSDBVALUEOPNAME`", showorder=7), @DEDataQueryCodeExp(name="SIMPLENAME", expression="t1.`SIMPLENAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DBFLAG, t1.DLFLAG, t1.MEMO, t1.ORDERVALUE, t1.PSDBVALUEOPID, t1.PSDBVALUEOPNAME, t1.SIMPLENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDBVALUEOP t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DBFLAG", expression="t1.DBFLAG", showorder=2), @DEDataQueryCodeExp(name="DLFLAG", expression="t1.DLFLAG", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=5), @DEDataQueryCodeExp(name="PSDBVALUEOPID", expression="t1.PSDBVALUEOPID", showorder=6), @DEDataQueryCodeExp(name="PSDBVALUEOPNAME", expression="t1.PSDBVALUEOPNAME", showorder=7), @DEDataQueryCodeExp(name="SIMPLENAME", expression="t1.SIMPLENAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=11)}, conds={})})
public class PSDBValueOPDefaultDQModel
extends DEDataQueryModelBase {
    public PSDBValueOPDefaultDQModel() {
        this.initAnnotation(PSDBValueOPDefaultDQModel.class);
    }
}

