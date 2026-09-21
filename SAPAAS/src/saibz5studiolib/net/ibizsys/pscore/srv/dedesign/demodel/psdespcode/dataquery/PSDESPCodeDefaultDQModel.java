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
package net.ibizsys.pscore.srv.dedesign.demodel.psdespcode.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="74BBAC1C-9A1A-49E6-A416-F5BC06F0D68F", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`COMPILEFLAG`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t11.`PSDEID`, t1.`PSDESPCODEID`, t1.`PSDESPCODENAME`, t1.`PSDESYSPROCID`, t1.`PSDESYSPROCNAME`, t11.`SYSPROCTYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERPARAMS` FROM `T_SRFPSDESPCODE` t1  LEFT JOIN `T_SRFPSDESYSPROC` t11 ON t1.`PSDESYSPROCID` = t11.`PSDESYSPROCID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="FULLCODE", expression="t1.`FULLCODE`", showorder=-1), @DEDataQueryCodeExp(name="USERCODE", expression="t1.`USERCODE`", showorder=-1), @DEDataQueryCodeExp(name="COMPILEFLAG", expression="t1.`COMPILEFLAG`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDEID", expression="t11.`PSDEID`", showorder=4), @DEDataQueryCodeExp(name="PSDESPCODEID", expression="t1.`PSDESPCODEID`", showorder=5), @DEDataQueryCodeExp(name="PSDESPCODENAME", expression="t1.`PSDESPCODENAME`", showorder=6), @DEDataQueryCodeExp(name="PSDESYSPROCID", expression="t1.`PSDESYSPROCID`", showorder=7), @DEDataQueryCodeExp(name="PSDESYSPROCNAME", expression="t1.`PSDESYSPROCNAME`", showorder=8), @DEDataQueryCodeExp(name="SYSPROCTYPE", expression="t11.`SYSPROCTYPE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="USERPARAMS", expression="t1.`USERPARAMS`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.COMPILEFLAG, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t11.PSDEID, t1.PSDESPCODEID, t1.PSDESPCODENAME, t1.PSDESYSPROCID, t1.PSDESYSPROCNAME, t11.SYSPROCTYPE, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERPARAMS FROM T_SRFPSDESPCODE t1  LEFT JOIN T_SRFPSDESYSPROC t11 ON t1.PSDESYSPROCID = t11.PSDESYSPROCID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="FULLCODE", expression="t1.FULLCODE", showorder=-1), @DEDataQueryCodeExp(name="USERCODE", expression="t1.USERCODE", showorder=-1), @DEDataQueryCodeExp(name="COMPILEFLAG", expression="t1.COMPILEFLAG", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDEID", expression="t11.PSDEID", showorder=4), @DEDataQueryCodeExp(name="PSDESPCODEID", expression="t1.PSDESPCODEID", showorder=5), @DEDataQueryCodeExp(name="PSDESPCODENAME", expression="t1.PSDESPCODENAME", showorder=6), @DEDataQueryCodeExp(name="PSDESYSPROCID", expression="t1.PSDESYSPROCID", showorder=7), @DEDataQueryCodeExp(name="PSDESYSPROCNAME", expression="t1.PSDESYSPROCNAME", showorder=8), @DEDataQueryCodeExp(name="SYSPROCTYPE", expression="t11.SYSPROCTYPE", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="USERPARAMS", expression="t1.USERPARAMS", showorder=12)}, conds={})})
public class PSDESPCodeDefaultDQModel
extends DEDataQueryModelBase {
    public PSDESPCodeDefaultDQModel() {
        this.initAnnotation(PSDESPCodeDefaultDQModel.class);
    }
}

