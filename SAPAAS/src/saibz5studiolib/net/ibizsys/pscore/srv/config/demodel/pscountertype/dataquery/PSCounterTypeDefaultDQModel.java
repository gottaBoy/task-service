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
package net.ibizsys.pscore.srv.config.demodel.pscountertype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="F8D179EF-9612-409F-BCA8-046198F963B2", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`COUNTEROBJ`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`JITCTRLOBJ`, t1.`MEMO`, t1.`PSCOUNTERTYPEID`, t1.`PSCOUNTERTYPENAME`, t1.`TYPEOBJ`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSCOUNTERTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="BASECLSPARAMS", expression="t1.`BASECLSPARAMS`", showorder=-1), @DEDataQueryCodeExp(name="TYPEPARAMS", expression="t1.`TYPEPARAMS`", showorder=-1), @DEDataQueryCodeExp(name="COUNTEROBJ", expression="t1.`COUNTEROBJ`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="JITCTRLOBJ", expression="t1.`JITCTRLOBJ`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSCOUNTERTYPEID", expression="t1.`PSCOUNTERTYPEID`", showorder=5), @DEDataQueryCodeExp(name="PSCOUNTERTYPENAME", expression="t1.`PSCOUNTERTYPENAME`", showorder=6), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.`TYPEOBJ`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.COUNTEROBJ, t1.CREATEDATE, t1.CREATEMAN, t1.JITCTRLOBJ, t1.MEMO, t1.PSCOUNTERTYPEID, t1.PSCOUNTERTYPENAME, t1.TYPEOBJ, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSCOUNTERTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="BASECLSPARAMS", expression="t1.BASECLSPARAMS", showorder=-1), @DEDataQueryCodeExp(name="TYPEPARAMS", expression="t1.TYPEPARAMS", showorder=-1), @DEDataQueryCodeExp(name="COUNTEROBJ", expression="t1.COUNTEROBJ", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="JITCTRLOBJ", expression="t1.JITCTRLOBJ", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSCOUNTERTYPEID", expression="t1.PSCOUNTERTYPEID", showorder=5), @DEDataQueryCodeExp(name="PSCOUNTERTYPENAME", expression="t1.PSCOUNTERTYPENAME", showorder=6), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.TYPEOBJ", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSCounterTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSCounterTypeDefaultDQModel() {
        this.initAnnotation(PSCounterTypeDefaultDQModel.class);
    }
}

