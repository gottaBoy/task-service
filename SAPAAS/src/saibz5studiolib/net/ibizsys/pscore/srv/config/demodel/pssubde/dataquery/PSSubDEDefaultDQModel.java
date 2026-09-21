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
package net.ibizsys.pscore.srv.config.demodel.pssubde.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="E582121F-5235-4959-8E2B-65E945D7F629", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOGICNAME`, t1.`MEMO`, t1.`MODULECODENAME`, t1.`MODULENAME`, t1.`PSDEID`, t1.`PSSUBDEID`, t1.`PSSUBDENAME`, t1.`PSSUBSYSID`, t1.`PSSUBSYSNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSUBDE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.`LOGICNAME`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="MODULECODENAME", expression="t1.`MODULECODENAME`", showorder=5), @DEDataQueryCodeExp(name="MODULENAME", expression="t1.`MODULENAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEID", expression="t1.`PSDEID`", showorder=7), @DEDataQueryCodeExp(name="PSSUBDEID", expression="t1.`PSSUBDEID`", showorder=8), @DEDataQueryCodeExp(name="PSSUBDENAME", expression="t1.`PSSUBDENAME`", showorder=9), @DEDataQueryCodeExp(name="PSSUBSYSID", expression="t1.`PSSUBSYSID`", showorder=10), @DEDataQueryCodeExp(name="PSSUBSYSNAME", expression="t1.`PSSUBSYSNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.LOGICNAME, t1.MEMO, t1.MODULECODENAME, t1.MODULENAME, t1.PSDEID, t1.PSSUBDEID, t1.PSSUBDENAME, t1.PSSUBSYSID, t1.PSSUBSYSNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSUBDE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.LOGICNAME", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="MODULECODENAME", expression="t1.MODULECODENAME", showorder=5), @DEDataQueryCodeExp(name="MODULENAME", expression="t1.MODULENAME", showorder=6), @DEDataQueryCodeExp(name="PSDEID", expression="t1.PSDEID", showorder=7), @DEDataQueryCodeExp(name="PSSUBDEID", expression="t1.PSSUBDEID", showorder=8), @DEDataQueryCodeExp(name="PSSUBDENAME", expression="t1.PSSUBDENAME", showorder=9), @DEDataQueryCodeExp(name="PSSUBSYSID", expression="t1.PSSUBSYSID", showorder=10), @DEDataQueryCodeExp(name="PSSUBSYSNAME", expression="t1.PSSUBSYSNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSSubDEDefaultDQModel
extends DEDataQueryModelBase {
    public PSSubDEDefaultDQModel() {
        this.initAnnotation(PSSubDEDefaultDQModel.class);
    }
}

