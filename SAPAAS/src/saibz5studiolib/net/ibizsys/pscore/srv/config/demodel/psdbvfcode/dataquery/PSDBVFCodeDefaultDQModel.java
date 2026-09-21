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
package net.ibizsys.pscore.srv.config.demodel.psdbvfcode.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="6EFECF68-9195-4AF4-ADED-F53E818C30F2", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDBTYPEID`, t11.`PSDBTYPENAME`, t1.`PSDBVFCODEID`, t1.`PSDBVFCODENAME`, t1.`PSDBVFID`, t21.`PSDBVALUEFUNCNAME` AS `PSDBVFNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDBVFCODE` t1  LEFT JOIN T_SRFPSDBTYPE t11 ON t1.PSDBTYPEID = t11.PSDBTYPEID  LEFT JOIN T_SRFPSDBVALUEFUNC t21 ON t1.PSDBVFID = t21.PSDBVALUEFUNCID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="FUNCCODE", expression="t1.`FUNCCODE`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDBTYPEID", expression="t1.`PSDBTYPEID`", showorder=3), @DEDataQueryCodeExp(name="PSDBTYPENAME", expression="t11.`PSDBTYPENAME`", showorder=4), @DEDataQueryCodeExp(name="PSDBVFCODEID", expression="t1.`PSDBVFCODEID`", showorder=5), @DEDataQueryCodeExp(name="PSDBVFCODENAME", expression="t1.`PSDBVFCODENAME`", showorder=6), @DEDataQueryCodeExp(name="PSDBVFID", expression="t1.`PSDBVFID`", showorder=7), @DEDataQueryCodeExp(name="PSDBVFNAME", expression="t21.`PSDBVALUEFUNCNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDBTYPEID, t11.PSDBTYPENAME, t1.PSDBVFCODEID, t1.PSDBVFCODENAME, t1.PSDBVFID, t21.PSDBVALUEFUNCNAME AS PSDBVFNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDBVFCODE t1  LEFT JOIN T_SRFPSDBTYPE t11 ON t1.PSDBTYPEID = t11.PSDBTYPEID  LEFT JOIN T_SRFPSDBVALUEFUNC t21 ON t1.PSDBVFID = t21.PSDBVALUEFUNCID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="FUNCCODE", expression="t1.FUNCCODE", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDBTYPEID", expression="t1.PSDBTYPEID", showorder=3), @DEDataQueryCodeExp(name="PSDBTYPENAME", expression="t11.PSDBTYPENAME", showorder=4), @DEDataQueryCodeExp(name="PSDBVFCODEID", expression="t1.PSDBVFCODEID", showorder=5), @DEDataQueryCodeExp(name="PSDBVFCODENAME", expression="t1.PSDBVFCODENAME", showorder=6), @DEDataQueryCodeExp(name="PSDBVFID", expression="t1.PSDBVFID", showorder=7), @DEDataQueryCodeExp(name="PSDBVFNAME", expression="t21.PSDBVALUEFUNCNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10)}, conds={})})
public class PSDBVFCodeDefaultDQModel
extends DEDataQueryModelBase {
    public PSDBVFCodeDefaultDQModel() {
        this.initAnnotation(PSDBVFCodeDefaultDQModel.class);
    }
}

