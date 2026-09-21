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
package net.ibizsys.pscore.srv.def.demodel.psdbsysproctype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="6F58DD0B-AA0D-468E-9699-563F8CEF7E30", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ICONPATH`, t1.`MEMO`, t1.`PSDBSYSPROCTYPEID`, t1.`PSDBSYSPROCTYPENAME`, t1.`RETURNRESULT`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDBSYSPROCTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.`ICONPATH`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSDBSYSPROCTYPEID", expression="t1.`PSDBSYSPROCTYPEID`", showorder=5), @DEDataQueryCodeExp(name="PSDBSYSPROCTYPENAME", expression="t1.`PSDBSYSPROCTYPENAME`", showorder=6), @DEDataQueryCodeExp(name="RETURNRESULT", expression="t1.`RETURNRESULT`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.ICONPATH, t1.MEMO, t1.PSDBSYSPROCTYPEID, t1.PSDBSYSPROCTYPENAME, t1.RETURNRESULT, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDBSYSPROCTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.ICONPATH", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSDBSYSPROCTYPEID", expression="t1.PSDBSYSPROCTYPEID", showorder=5), @DEDataQueryCodeExp(name="PSDBSYSPROCTYPENAME", expression="t1.PSDBSYSPROCTYPENAME", showorder=6), @DEDataQueryCodeExp(name="RETURNRESULT", expression="t1.RETURNRESULT", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSDBSysProcTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSDBSysProcTypeDefaultDQModel() {
        this.initAnnotation(PSDBSysProcTypeDefaultDQModel.class);
    }
}

