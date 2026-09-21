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
package net.ibizsys.pscore.srv.config.demodel.pssamplevalue.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="3C2D7E2A-3F6F-4C06-B921-CDA5B7B312C0", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`NULLVALUE`, t1.`PSSAMPLEVALUEID`, t1.`PSSAMPLEVALUENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG`, t1.`VALUE`, t1.`VALUELIST` FROM `T_SRFPSSAMPLEVALUE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="NULLVALUE", expression="t1.`NULLVALUE`", showorder=3), @DEDataQueryCodeExp(name="PSSAMPLEVALUEID", expression="t1.`PSSAMPLEVALUEID`", showorder=4), @DEDataQueryCodeExp(name="PSSAMPLEVALUENAME", expression="t1.`PSSAMPLEVALUENAME`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=8), @DEDataQueryCodeExp(name="VALUE", expression="t1.`VALUE`", showorder=9), @DEDataQueryCodeExp(name="VALUELIST", expression="t1.`VALUELIST`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.NULLVALUE, t1.PSSAMPLEVALUEID, t1.PSSAMPLEVALUENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG, t1.VALUE, t1.VALUELIST FROM T_SRFPSSAMPLEVALUE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="NULLVALUE", expression="t1.NULLVALUE", showorder=3), @DEDataQueryCodeExp(name="PSSAMPLEVALUEID", expression="t1.PSSAMPLEVALUEID", showorder=4), @DEDataQueryCodeExp(name="PSSAMPLEVALUENAME", expression="t1.PSSAMPLEVALUENAME", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=8), @DEDataQueryCodeExp(name="VALUE", expression="t1.VALUE", showorder=9), @DEDataQueryCodeExp(name="VALUELIST", expression="t1.VALUELIST", showorder=10)}, conds={})})
public class PSSampleValueDefaultDQModel
extends DEDataQueryModelBase {
    public PSSampleValueDefaultDQModel() {
        this.initAnnotation(PSSampleValueDefaultDQModel.class);
    }
}

