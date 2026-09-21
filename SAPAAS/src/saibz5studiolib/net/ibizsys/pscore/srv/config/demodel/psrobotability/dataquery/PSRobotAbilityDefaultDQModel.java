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
package net.ibizsys.pscore.srv.config.demodel.psrobotability.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="5FFF10DC-013A-4283-80D8-F3ECE0A82583", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ABILITYTAG`, t1.`ABILITYTAG2`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEFAULTFLAG`, t1.`MEMO`, t1.`PSROBOTABILITYID`, t1.`PSROBOTABILITYNAME`, t1.`PSROBOTWORKID`, t1.`PSROBOTWORKNAME`, t1.`TYPEOBJ`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSROBOTABILITY` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ABILITYTAG", expression="t1.`ABILITYTAG`", showorder=0), @DEDataQueryCodeExp(name="ABILITYTAG2", expression="t1.`ABILITYTAG2`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="DEFAULTFLAG", expression="t1.`DEFAULTFLAG`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="PSROBOTABILITYID", expression="t1.`PSROBOTABILITYID`", showorder=6), @DEDataQueryCodeExp(name="PSROBOTABILITYNAME", expression="t1.`PSROBOTABILITYNAME`", showorder=7), @DEDataQueryCodeExp(name="PSROBOTWORKID", expression="t1.`PSROBOTWORKID`", showorder=8), @DEDataQueryCodeExp(name="PSROBOTWORKNAME", expression="t1.`PSROBOTWORKNAME`", showorder=9), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.`TYPEOBJ`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.ABILITYTAG, t1.ABILITYTAG2, t1.CREATEDATE, t1.CREATEMAN, t1.DEFAULTFLAG, t1.MEMO, t1.PSROBOTABILITYID, t1.PSROBOTABILITYNAME, t1.PSROBOTWORKID, t1.PSROBOTWORKNAME, t1.TYPEOBJ, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSROBOTABILITY t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ABILITYTAG", expression="t1.ABILITYTAG", showorder=0), @DEDataQueryCodeExp(name="ABILITYTAG2", expression="t1.ABILITYTAG2", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="DEFAULTFLAG", expression="t1.DEFAULTFLAG", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="PSROBOTABILITYID", expression="t1.PSROBOTABILITYID", showorder=6), @DEDataQueryCodeExp(name="PSROBOTABILITYNAME", expression="t1.PSROBOTABILITYNAME", showorder=7), @DEDataQueryCodeExp(name="PSROBOTWORKID", expression="t1.PSROBOTWORKID", showorder=8), @DEDataQueryCodeExp(name="PSROBOTWORKNAME", expression="t1.PSROBOTWORKNAME", showorder=9), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.TYPEOBJ", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=13)}, conds={})})
public class PSRobotAbilityDefaultDQModel
extends DEDataQueryModelBase {
    public PSRobotAbilityDefaultDQModel() {
        this.initAnnotation(PSRobotAbilityDefaultDQModel.class);
    }
}

