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
package net.ibizsys.pscore.srv.dedesign.demodel.psdedupruleitem.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="651EBFE0-F0ED-447C-8AE9-B2A93F620BF1", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSDEDUPRULEID`, t1.`PSDEDUPRULEITEMID`, t1.`PSDEDUPRULEITEMNAME`, t11.`PSDEDUPRULENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEDUPRULEITEM` t1  LEFT JOIN T_SRFPSDEDUPRULE t11 ON t1.PSDEDUPRULEID = t11.PSDEDUPRULEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSDEDUPRULEID", expression="t1.`PSDEDUPRULEID`", showorder=2), @DEDataQueryCodeExp(name="PSDEDUPRULEITEMID", expression="t1.`PSDEDUPRULEITEMID`", showorder=3), @DEDataQueryCodeExp(name="PSDEDUPRULEITEMNAME", expression="t1.`PSDEDUPRULEITEMNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDEDUPRULENAME", expression="t11.`PSDEDUPRULENAME`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSDEDUPRULEID, t1.PSDEDUPRULEITEMID, t1.PSDEDUPRULEITEMNAME, t11.PSDEDUPRULENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEDUPRULEITEM t1  LEFT JOIN T_SRFPSDEDUPRULE t11 ON t1.PSDEDUPRULEID = t11.PSDEDUPRULEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSDEDUPRULEID", expression="t1.PSDEDUPRULEID", showorder=2), @DEDataQueryCodeExp(name="PSDEDUPRULEITEMID", expression="t1.PSDEDUPRULEITEMID", showorder=3), @DEDataQueryCodeExp(name="PSDEDUPRULEITEMNAME", expression="t1.PSDEDUPRULEITEMNAME", showorder=4), @DEDataQueryCodeExp(name="PSDEDUPRULENAME", expression="t11.PSDEDUPRULENAME", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7)}, conds={})})
public class PSDEDUPRuleItemDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEDUPRuleItemDefaultDQModel() {
        this.initAnnotation(PSDEDUPRuleItemDefaultDQModel.class);
    }
}

