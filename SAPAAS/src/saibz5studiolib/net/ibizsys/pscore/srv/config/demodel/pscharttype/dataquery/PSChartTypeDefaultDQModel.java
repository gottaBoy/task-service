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
package net.ibizsys.pscore.srv.config.demodel.pscharttype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="F68AE1F8-A9A8-47C7-B503-C58E7FFFCC09", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`CTRLOBJ`, t1.`ENABLE`, t1.`ICONPATH`, t1.`MEMO`, t1.`PSCHARTTYPEID`, t1.`PSCHARTTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSCHARTTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="CTRLOBJ", expression="t1.`CTRLOBJ`", showorder=2), @DEDataQueryCodeExp(name="ENABLE", expression="t1.`ENABLE`", showorder=3), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.`ICONPATH`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="PSCHARTTYPEID", expression="t1.`PSCHARTTYPEID`", showorder=6), @DEDataQueryCodeExp(name="PSCHARTTYPENAME", expression="t1.`PSCHARTTYPENAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=10)}, conds={@DEDataQueryCodeCond(condition="t1.ENABLE = 1")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.CTRLOBJ, t1.ENABLE, t1.ICONPATH, t1.MEMO, t1.PSCHARTTYPEID, t1.PSCHARTTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSCHARTTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="CTRLOBJ", expression="t1.CTRLOBJ", showorder=2), @DEDataQueryCodeExp(name="ENABLE", expression="t1.ENABLE", showorder=3), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.ICONPATH", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="PSCHARTTYPEID", expression="t1.PSCHARTTYPEID", showorder=6), @DEDataQueryCodeExp(name="PSCHARTTYPENAME", expression="t1.PSCHARTTYPENAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=10)}, conds={@DEDataQueryCodeCond(condition="t1.ENABLE = 1")})})
public class PSChartTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSChartTypeDefaultDQModel() {
        this.initAnnotation(PSChartTypeDefaultDQModel.class);
    }
}

