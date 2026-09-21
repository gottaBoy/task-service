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
package net.ibizsys.pscore.srv.config.demodel.psrobottypeability.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="160DE5F1-B374-4E97-9CB3-0853222AD06E", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENERGY`, t1.`MEMO`, t1.`PSROBOTTYPEABILITYID`, t1.`PSROBOTTYPEABILITYNAME`, t1.`PSROBOTTYPEID`, t11.`PSROBOTTYPENAME`, t1.`PSROBOTWORKTYPEID`, t21.`PSROBOTWORKTYPENAME`, t1.`ROBOTLEVEL`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSROBOTTYPEABILITY` t1  LEFT JOIN T_SRFPSROBOTTYPE t11 ON t1.PSROBOTTYPEID = t11.PSROBOTTYPEID  LEFT JOIN T_SRFPSROBOTWORKTYPE t21 ON t1.PSROBOTWORKTYPEID = t21.PSROBOTWORKTYPEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ENERGY", expression="t1.`ENERGY`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSROBOTTYPEABILITYID", expression="t1.`PSROBOTTYPEABILITYID`", showorder=4), @DEDataQueryCodeExp(name="PSROBOTTYPEABILITYNAME", expression="t1.`PSROBOTTYPEABILITYNAME`", showorder=5), @DEDataQueryCodeExp(name="PSROBOTTYPEID", expression="t1.`PSROBOTTYPEID`", showorder=6), @DEDataQueryCodeExp(name="PSROBOTTYPENAME", expression="t11.`PSROBOTTYPENAME`", showorder=7), @DEDataQueryCodeExp(name="PSROBOTWORKTYPEID", expression="t1.`PSROBOTWORKTYPEID`", showorder=8), @DEDataQueryCodeExp(name="PSROBOTWORKTYPENAME", expression="t21.`PSROBOTWORKTYPENAME`", showorder=9), @DEDataQueryCodeExp(name="ROBOTLEVEL", expression="t1.`ROBOTLEVEL`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENERGY, t1.MEMO, t1.PSROBOTTYPEABILITYID, t1.PSROBOTTYPEABILITYNAME, t1.PSROBOTTYPEID, t11.PSROBOTTYPENAME, t1.PSROBOTWORKTYPEID, t21.PSROBOTWORKTYPENAME, t1.ROBOTLEVEL, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSROBOTTYPEABILITY t1  LEFT JOIN T_SRFPSROBOTTYPE t11 ON t1.PSROBOTTYPEID = t11.PSROBOTTYPEID  LEFT JOIN T_SRFPSROBOTWORKTYPE t21 ON t1.PSROBOTWORKTYPEID = t21.PSROBOTWORKTYPEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ENERGY", expression="t1.ENERGY", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSROBOTTYPEABILITYID", expression="t1.PSROBOTTYPEABILITYID", showorder=4), @DEDataQueryCodeExp(name="PSROBOTTYPEABILITYNAME", expression="t1.PSROBOTTYPEABILITYNAME", showorder=5), @DEDataQueryCodeExp(name="PSROBOTTYPEID", expression="t1.PSROBOTTYPEID", showorder=6), @DEDataQueryCodeExp(name="PSROBOTTYPENAME", expression="t11.PSROBOTTYPENAME", showorder=7), @DEDataQueryCodeExp(name="PSROBOTWORKTYPEID", expression="t1.PSROBOTWORKTYPEID", showorder=8), @DEDataQueryCodeExp(name="PSROBOTWORKTYPENAME", expression="t21.PSROBOTWORKTYPENAME", showorder=9), @DEDataQueryCodeExp(name="ROBOTLEVEL", expression="t1.ROBOTLEVEL", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=13)}, conds={})})
public class PSRobotTypeAbilityDefaultDQModel
extends DEDataQueryModelBase {
    public PSRobotTypeAbilityDefaultDQModel() {
        this.initAnnotation(PSRobotTypeAbilityDefaultDQModel.class);
    }
}

