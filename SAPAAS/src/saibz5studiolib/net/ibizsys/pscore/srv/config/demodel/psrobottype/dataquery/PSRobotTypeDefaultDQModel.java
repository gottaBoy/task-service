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
package net.ibizsys.pscore.srv.config.demodel.psrobottype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="3DB0A324-617E-42E0-B0FB-11B429F87B86", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MAXENERGY`, t1.`MEMO`, t1.`PSROBOTTYPEID`, t1.`PSROBOTTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERTAG`, t1.`USERTAG2`, t1.`VALIDFLAG` FROM `T_SRFPSROBOTTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MAXENERGY", expression="t1.`MAXENERGY`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSROBOTTYPEID", expression="t1.`PSROBOTTYPEID`", showorder=4), @DEDataQueryCodeExp(name="PSROBOTTYPENAME", expression="t1.`PSROBOTTYPENAME`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=8), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=9), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MAXENERGY, t1.MEMO, t1.PSROBOTTYPEID, t1.PSROBOTTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERTAG, t1.USERTAG2, t1.VALIDFLAG FROM T_SRFPSROBOTTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MAXENERGY", expression="t1.MAXENERGY", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSROBOTTYPEID", expression="t1.PSROBOTTYPEID", showorder=4), @DEDataQueryCodeExp(name="PSROBOTTYPENAME", expression="t1.PSROBOTTYPENAME", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=8), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=9), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=10)}, conds={})})
public class PSRobotTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSRobotTypeDefaultDQModel() {
        this.initAnnotation(PSRobotTypeDefaultDQModel.class);
    }
}

