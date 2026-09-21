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
package net.ibizsys.pscore.srv.config.demodel.psdbvaluemode.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="201F0254-3EEB-4071-AD5C-2BBEA95DF596", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDBVALUEMODEID`, t1.`PSDBVALUEMODENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDBVALUEMODE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDBVALUEMODEID", expression="t1.`PSDBVALUEMODEID`", showorder=3), @DEDataQueryCodeExp(name="PSDBVALUEMODENAME", expression="t1.`PSDBVALUEMODENAME`", showorder=4), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=5), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=6)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDBVALUEMODEID, t1.PSDBVALUEMODENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDBVALUEMODE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDBVALUEMODEID", expression="t1.PSDBVALUEMODEID", showorder=3), @DEDataQueryCodeExp(name="PSDBVALUEMODENAME", expression="t1.PSDBVALUEMODENAME", showorder=4), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=5), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=6)}, conds={})})
public class PSDBValueModeDefaultDQModel
extends DEDataQueryModelBase {
    public PSDBValueModeDefaultDQModel() {
        this.initAnnotation(PSDBValueModeDefaultDQModel.class);
    }
}

