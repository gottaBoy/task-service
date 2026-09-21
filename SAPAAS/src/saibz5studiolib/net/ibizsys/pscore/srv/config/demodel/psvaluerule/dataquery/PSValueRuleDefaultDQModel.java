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
package net.ibizsys.pscore.srv.config.demodel.psvaluerule.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="C7FBE529-5B73-4C65-8029-4E37BB1E5CC1", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`CUSTOMOBJ`, t1.`CUSTOMPARAMS`, t1.`MEMO`, t1.`PSVALUERULEID`, t1.`PSVALUERULENAME`, t1.`REGEXPCODE`, t1.`RULEINFO`, t1.`RULETYPE`, t1.`SCRIPT`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSVALUERULE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="CUSTOMOBJ", expression="t1.`CUSTOMOBJ`", showorder=2), @DEDataQueryCodeExp(name="CUSTOMPARAMS", expression="t1.`CUSTOMPARAMS`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSVALUERULEID", expression="t1.`PSVALUERULEID`", showorder=5), @DEDataQueryCodeExp(name="PSVALUERULENAME", expression="t1.`PSVALUERULENAME`", showorder=6), @DEDataQueryCodeExp(name="REGEXPCODE", expression="t1.`REGEXPCODE`", showorder=7), @DEDataQueryCodeExp(name="RULEINFO", expression="t1.`RULEINFO`", showorder=8), @DEDataQueryCodeExp(name="RULETYPE", expression="t1.`RULETYPE`", showorder=9), @DEDataQueryCodeExp(name="SCRIPT", expression="t1.`SCRIPT`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.CUSTOMOBJ, t1.CUSTOMPARAMS, t1.MEMO, t1.PSVALUERULEID, t1.PSVALUERULENAME, t1.REGEXPCODE, t1.RULEINFO, t1.RULETYPE, t1.SCRIPT, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSVALUERULE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="CUSTOMOBJ", expression="t1.CUSTOMOBJ", showorder=2), @DEDataQueryCodeExp(name="CUSTOMPARAMS", expression="t1.CUSTOMPARAMS", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSVALUERULEID", expression="t1.PSVALUERULEID", showorder=5), @DEDataQueryCodeExp(name="PSVALUERULENAME", expression="t1.PSVALUERULENAME", showorder=6), @DEDataQueryCodeExp(name="REGEXPCODE", expression="t1.REGEXPCODE", showorder=7), @DEDataQueryCodeExp(name="RULEINFO", expression="t1.RULEINFO", showorder=8), @DEDataQueryCodeExp(name="RULETYPE", expression="t1.RULETYPE", showorder=9), @DEDataQueryCodeExp(name="SCRIPT", expression="t1.SCRIPT", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSValueRuleDefaultDQModel
extends DEDataQueryModelBase {
    public PSValueRuleDefaultDQModel() {
        this.initAnnotation(PSValueRuleDefaultDQModel.class);
    }
}

