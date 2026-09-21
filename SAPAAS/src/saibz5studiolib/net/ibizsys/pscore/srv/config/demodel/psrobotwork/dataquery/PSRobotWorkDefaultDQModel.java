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
package net.ibizsys.pscore.srv.config.demodel.psrobotwork.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="EB0DF9C2-A80F-4F44-B0B3-A5AFD1BCB6BE", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSROBOTWORKID`, t1.`PSROBOTWORKNAME`, t1.`TYPEOBJ`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSROBOTWORK` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSROBOTWORKID", expression="t1.`PSROBOTWORKID`", showorder=3), @DEDataQueryCodeExp(name="PSROBOTWORKNAME", expression="t1.`PSROBOTWORKNAME`", showorder=4), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.`TYPEOBJ`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=8)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSROBOTWORKID, t1.PSROBOTWORKNAME, t1.TYPEOBJ, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSROBOTWORK t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSROBOTWORKID", expression="t1.PSROBOTWORKID", showorder=3), @DEDataQueryCodeExp(name="PSROBOTWORKNAME", expression="t1.PSROBOTWORKNAME", showorder=4), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.TYPEOBJ", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=8)}, conds={})})
public class PSRobotWorkDefaultDQModel
extends DEDataQueryModelBase {
    public PSRobotWorkDefaultDQModel() {
        this.initAnnotation(PSRobotWorkDefaultDQModel.class);
    }
}

