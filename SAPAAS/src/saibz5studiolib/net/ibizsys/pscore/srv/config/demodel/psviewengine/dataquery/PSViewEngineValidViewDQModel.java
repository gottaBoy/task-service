/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeCond
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psviewengine.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="61341B37-336F-4E01-9DA0-32F169D81482", name="ValidView")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ALLDCFLAG`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENGINEOBJ`, t1.`ENGINETYPE`, t1.`MEMO`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`PSVIEWENGINEID`, t1.`PSVIEWENGINENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSVIEWENGINE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ALLDCFLAG", expression="t1.`ALLDCFLAG`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="ENGINEOBJ", expression="t1.`ENGINEOBJ`", showorder=3), @DEDataQueryCodeExp(name="ENGINETYPE", expression="t1.`ENGINETYPE`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=7), @DEDataQueryCodeExp(name="PSVIEWENGINEID", expression="t1.`PSVIEWENGINEID`", showorder=8), @DEDataQueryCodeExp(name="PSVIEWENGINENAME", expression="t1.`PSVIEWENGINENAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12)}, conds={@DEDataQueryCodeCond(condition="( t1.`VALIDFLAG` = 1  AND  t1.`ENGINETYPE` = 'VIEW' )")}), @DEDataQueryCode(querycode="SELECT t1.ALLDCFLAG, t1.CREATEDATE, t1.CREATEMAN, t1.ENGINEOBJ, t1.ENGINETYPE, t1.MEMO, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.PSVIEWENGINEID, t1.PSVIEWENGINENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSVIEWENGINE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ALLDCFLAG", expression="t1.ALLDCFLAG", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="ENGINEOBJ", expression="t1.ENGINEOBJ", showorder=3), @DEDataQueryCodeExp(name="ENGINETYPE", expression="t1.ENGINETYPE", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=7), @DEDataQueryCodeExp(name="PSVIEWENGINEID", expression="t1.PSVIEWENGINEID", showorder=8), @DEDataQueryCodeExp(name="PSVIEWENGINENAME", expression="t1.PSVIEWENGINENAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12)}, conds={@DEDataQueryCodeCond(condition="( t1.VALIDFLAG = 1  AND  t1.ENGINETYPE = 'VIEW' )")})})
public class PSViewEngineValidViewDQModel
extends DEDataQueryModelBase {
    public PSViewEngineValidViewDQModel() {
        this.initAnnotation(PSViewEngineValidViewDQModel.class);
    }
}

