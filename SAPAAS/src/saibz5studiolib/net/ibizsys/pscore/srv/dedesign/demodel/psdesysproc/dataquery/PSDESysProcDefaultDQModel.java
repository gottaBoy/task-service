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
package net.ibizsys.pscore.srv.dedesign.demodel.psdesysproc.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="962A521F-C731-451D-835F-C5CD09CECBF6", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ACTIONMODE`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEFAULTMODE`, t1.`MEMO`, t1.`PSDEID`, t1.`PSDENAME`, t1.`PSDESYSPROCID`, t1.`PSDESYSPROCNAME`, t1.`SYSPROCTYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERPARAMS` FROM `T_SRFPSDESYSPROC` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ACTIONMODE", expression="t1.`ACTIONMODE`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="DEFAULTMODE", expression="t1.`DEFAULTMODE`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSDEID", expression="t1.`PSDEID`", showorder=5), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.`PSDENAME`", showorder=6), @DEDataQueryCodeExp(name="PSDESYSPROCID", expression="t1.`PSDESYSPROCID`", showorder=7), @DEDataQueryCodeExp(name="PSDESYSPROCNAME", expression="t1.`PSDESYSPROCNAME`", showorder=8), @DEDataQueryCodeExp(name="SYSPROCTYPE", expression="t1.`SYSPROCTYPE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="USERPARAMS", expression="t1.`USERPARAMS`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.ACTIONMODE, t1.CREATEDATE, t1.CREATEMAN, t1.DEFAULTMODE, t1.MEMO, t1.PSDEID, t1.PSDENAME, t1.PSDESYSPROCID, t1.PSDESYSPROCNAME, t1.SYSPROCTYPE, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERPARAMS FROM T_SRFPSDESYSPROC t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ACTIONMODE", expression="t1.ACTIONMODE", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="DEFAULTMODE", expression="t1.DEFAULTMODE", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSDEID", expression="t1.PSDEID", showorder=5), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.PSDENAME", showorder=6), @DEDataQueryCodeExp(name="PSDESYSPROCID", expression="t1.PSDESYSPROCID", showorder=7), @DEDataQueryCodeExp(name="PSDESYSPROCNAME", expression="t1.PSDESYSPROCNAME", showorder=8), @DEDataQueryCodeExp(name="SYSPROCTYPE", expression="t1.SYSPROCTYPE", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="USERPARAMS", expression="t1.USERPARAMS", showorder=12)}, conds={})})
public class PSDESysProcDefaultDQModel
extends DEDataQueryModelBase {
    public PSDESysProcDefaultDQModel() {
        this.initAnnotation(PSDESysProcDefaultDQModel.class);
    }
}

