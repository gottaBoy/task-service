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
package net.ibizsys.pscore.srv.config.demodel.psrobotworktype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="3CC25B72-64D2-4599-8A4F-531BF90D2634", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENERGY`, t1.`MEMO`, t1.`PSROBOTWORKTYPEID`, t1.`PSROBOTWORKTYPENAME`, t1.`ROBOTLEVEL`, t1.`TYPEOBJ`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERTAG`, t1.`USERTAG2`, t1.`VALIDFLAG`, t1.`WORKDESC` FROM `T_SRFPSROBOTWORKTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="TYPEPARAMS", expression="t1.`TYPEPARAMS`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ENERGY", expression="t1.`ENERGY`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSROBOTWORKTYPEID", expression="t1.`PSROBOTWORKTYPEID`", showorder=4), @DEDataQueryCodeExp(name="PSROBOTWORKTYPENAME", expression="t1.`PSROBOTWORKTYPENAME`", showorder=5), @DEDataQueryCodeExp(name="ROBOTLEVEL", expression="t1.`ROBOTLEVEL`", showorder=6), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.`TYPEOBJ`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=10), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12), @DEDataQueryCodeExp(name="WORKDESC", expression="t1.`WORKDESC`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENERGY, t1.MEMO, t1.PSROBOTWORKTYPEID, t1.PSROBOTWORKTYPENAME, t1.ROBOTLEVEL, t1.TYPEOBJ, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERTAG, t1.USERTAG2, t1.VALIDFLAG, t1.WORKDESC FROM T_SRFPSROBOTWORKTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="TYPEPARAMS", expression="t1.TYPEPARAMS", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ENERGY", expression="t1.ENERGY", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSROBOTWORKTYPEID", expression="t1.PSROBOTWORKTYPEID", showorder=4), @DEDataQueryCodeExp(name="PSROBOTWORKTYPENAME", expression="t1.PSROBOTWORKTYPENAME", showorder=5), @DEDataQueryCodeExp(name="ROBOTLEVEL", expression="t1.ROBOTLEVEL", showorder=6), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.TYPEOBJ", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=10), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12), @DEDataQueryCodeExp(name="WORKDESC", expression="t1.WORKDESC", showorder=13)}, conds={})})
public class PSRobotWorkTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSRobotWorkTypeDefaultDQModel() {
        this.initAnnotation(PSRobotWorkTypeDefaultDQModel.class);
    }
}

