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
package net.ibizsys.pscore.srv.config.demodel.pspfstylecode.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="34B12661-11B4-4FE1-8140-BC4D1B5B0920", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSPFSTYLECODEID`, t1.`PSPFSTYLECODENAME`, t1.`PSPFSTYLEID`, t11.`PSPFSTYLENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSPFSTYLECODE` t1  LEFT JOIN T_SRFPSPFSTYLE t11 ON t1.PSPFSTYLEID = t11.PSPFSTYLEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="STYLECODE", expression="t1.`STYLECODE`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSPFSTYLECODEID", expression="t1.`PSPFSTYLECODEID`", showorder=3), @DEDataQueryCodeExp(name="PSPFSTYLECODENAME", expression="t1.`PSPFSTYLECODENAME`", showorder=4), @DEDataQueryCodeExp(name="PSPFSTYLEID", expression="t1.`PSPFSTYLEID`", showorder=5), @DEDataQueryCodeExp(name="PSPFSTYLENAME", expression="t11.`PSPFSTYLENAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSPFSTYLECODEID, t1.PSPFSTYLECODENAME, t1.PSPFSTYLEID, t11.PSPFSTYLENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSPFSTYLECODE t1  LEFT JOIN T_SRFPSPFSTYLE t11 ON t1.PSPFSTYLEID = t11.PSPFSTYLEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="STYLECODE", expression="t1.STYLECODE", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSPFSTYLECODEID", expression="t1.PSPFSTYLECODEID", showorder=3), @DEDataQueryCodeExp(name="PSPFSTYLECODENAME", expression="t1.PSPFSTYLECODENAME", showorder=4), @DEDataQueryCodeExp(name="PSPFSTYLEID", expression="t1.PSPFSTYLEID", showorder=5), @DEDataQueryCodeExp(name="PSPFSTYLENAME", expression="t11.PSPFSTYLENAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8)}, conds={})})
public class PSPFStyleCodeDefaultDQModel
extends DEDataQueryModelBase {
    public PSPFStyleCodeDefaultDQModel() {
        this.initAnnotation(PSPFStyleCodeDefaultDQModel.class);
    }
}

