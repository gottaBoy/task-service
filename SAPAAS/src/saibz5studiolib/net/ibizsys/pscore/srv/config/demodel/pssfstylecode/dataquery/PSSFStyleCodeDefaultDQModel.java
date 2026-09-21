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
package net.ibizsys.pscore.srv.config.demodel.pssfstylecode.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="D4088A1B-1ACF-445D-B016-3EC22652C210", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSSFSTYLECODEID`, t1.`PSSFSTYLECODENAME`, t1.`PSSFSTYLEID`, t11.`PSSFSTYLENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSFSTYLECODE` t1  LEFT JOIN T_SRFPSSFSTYLE t11 ON t1.PSSFSTYLEID = t11.PSSFSTYLEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="STYLECODE", expression="t1.`STYLECODE`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSSFSTYLECODEID", expression="t1.`PSSFSTYLECODEID`", showorder=3), @DEDataQueryCodeExp(name="PSSFSTYLECODENAME", expression="t1.`PSSFSTYLECODENAME`", showorder=4), @DEDataQueryCodeExp(name="PSSFSTYLEID", expression="t1.`PSSFSTYLEID`", showorder=5), @DEDataQueryCodeExp(name="PSSFSTYLENAME", expression="t11.`PSSFSTYLENAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSSFSTYLECODEID, t1.PSSFSTYLECODENAME, t1.PSSFSTYLEID, t11.PSSFSTYLENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSFSTYLECODE t1  LEFT JOIN T_SRFPSSFSTYLE t11 ON t1.PSSFSTYLEID = t11.PSSFSTYLEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="STYLECODE", expression="t1.STYLECODE", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSSFSTYLECODEID", expression="t1.PSSFSTYLECODEID", showorder=3), @DEDataQueryCodeExp(name="PSSFSTYLECODENAME", expression="t1.PSSFSTYLECODENAME", showorder=4), @DEDataQueryCodeExp(name="PSSFSTYLEID", expression="t1.PSSFSTYLEID", showorder=5), @DEDataQueryCodeExp(name="PSSFSTYLENAME", expression="t11.PSSFSTYLENAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8)}, conds={})})
public class PSSFStyleCodeDefaultDQModel
extends DEDataQueryModelBase {
    public PSSFStyleCodeDefaultDQModel() {
        this.initAnnotation(PSSFStyleCodeDefaultDQModel.class);
    }
}

