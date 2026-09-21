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
package net.ibizsys.pscore.srv.config.demodel.pssfexception.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="4C2E0140-A3E0-4893-8814-0B23F20837D8", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOGICNAME`, t1.`MEMO`, t1.`PSSFEXCEPTIONID`, t1.`PSSFEXCEPTIONNAME`, t1.`PSSFID`, t11.`PSSFNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSSFEXCEPTION` t1  LEFT JOIN T_SRFPSSF t11 ON t1.PSSFID = t11.PSSFID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.`LOGICNAME`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSSFEXCEPTIONID", expression="t1.`PSSFEXCEPTIONID`", showorder=4), @DEDataQueryCodeExp(name="PSSFEXCEPTIONNAME", expression="t1.`PSSFEXCEPTIONNAME`", showorder=5), @DEDataQueryCodeExp(name="PSSFID", expression="t1.`PSSFID`", showorder=6), @DEDataQueryCodeExp(name="PSSFNAME", expression="t11.`PSSFNAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.LOGICNAME, t1.MEMO, t1.PSSFEXCEPTIONID, t1.PSSFEXCEPTIONNAME, t1.PSSFID, t11.PSSFNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSSFEXCEPTION t1  LEFT JOIN T_SRFPSSF t11 ON t1.PSSFID = t11.PSSFID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.LOGICNAME", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSSFEXCEPTIONID", expression="t1.PSSFEXCEPTIONID", showorder=4), @DEDataQueryCodeExp(name="PSSFEXCEPTIONNAME", expression="t1.PSSFEXCEPTIONNAME", showorder=5), @DEDataQueryCodeExp(name="PSSFID", expression="t1.PSSFID", showorder=6), @DEDataQueryCodeExp(name="PSSFNAME", expression="t11.PSSFNAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=10)}, conds={})})
public class PSSFExceptionDefaultDQModel
extends DEDataQueryModelBase {
    public PSSFExceptionDefaultDQModel() {
        this.initAnnotation(PSSFExceptionDefaultDQModel.class);
    }
}

