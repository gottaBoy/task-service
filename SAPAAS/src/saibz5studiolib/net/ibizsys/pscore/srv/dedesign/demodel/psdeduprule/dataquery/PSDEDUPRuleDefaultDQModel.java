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
package net.ibizsys.pscore.srv.dedesign.demodel.psdeduprule.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="88FEF07E-400E-4015-85BE-265980578097", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEDUPRULEID`, t1.`PSDEDUPRULENAME`, t1.`PSDEID`, t1.`PSDENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEDUPRULE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEDUPRULEID", expression="t1.`PSDEDUPRULEID`", showorder=3), @DEDataQueryCodeExp(name="PSDEDUPRULENAME", expression="t1.`PSDEDUPRULENAME`", showorder=4), @DEDataQueryCodeExp(name="PSDEID", expression="t1.`PSDEID`", showorder=5), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.`PSDENAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEDUPRULEID, t1.PSDEDUPRULENAME, t1.PSDEID, t1.PSDENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEDUPRULE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEDUPRULEID", expression="t1.PSDEDUPRULEID", showorder=3), @DEDataQueryCodeExp(name="PSDEDUPRULENAME", expression="t1.PSDEDUPRULENAME", showorder=4), @DEDataQueryCodeExp(name="PSDEID", expression="t1.PSDEID", showorder=5), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.PSDENAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8)}, conds={})})
public class PSDEDUPRuleDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEDUPRuleDefaultDQModel() {
        this.initAnnotation(PSDEDUPRuleDefaultDQModel.class);
    }
}

