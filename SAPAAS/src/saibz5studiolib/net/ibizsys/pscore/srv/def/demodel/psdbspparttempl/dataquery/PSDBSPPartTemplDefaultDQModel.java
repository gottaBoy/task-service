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
package net.ibizsys.pscore.srv.def.demodel.psdbspparttempl.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="BDA8FF5E-1167-4772-8F05-7C8603AA3CB9", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDBSPPARTTEMPLID`, t1.`PSDBSPPARTTEMPLNAME`, t1.`PSDBSYSPROCTEMPLID`, t11.`PSDBSYSPROCTEMPLNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDBSPPARTTEMPL` t1  LEFT JOIN T_SRFPSDBSYSPROCTEMPL t11 ON t1.PSDBSYSPROCTEMPLID = t11.PSDBSYSPROCTEMPLID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="TEMPLCODE", expression="t1.`TEMPLCODE`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDBSPPARTTEMPLID", expression="t1.`PSDBSPPARTTEMPLID`", showorder=3), @DEDataQueryCodeExp(name="PSDBSPPARTTEMPLNAME", expression="t1.`PSDBSPPARTTEMPLNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDBSYSPROCTEMPLID", expression="t1.`PSDBSYSPROCTEMPLID`", showorder=5), @DEDataQueryCodeExp(name="PSDBSYSPROCTEMPLNAME", expression="t11.`PSDBSYSPROCTEMPLNAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDBSPPARTTEMPLID, t1.PSDBSPPARTTEMPLNAME, t1.PSDBSYSPROCTEMPLID, t11.PSDBSYSPROCTEMPLNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDBSPPARTTEMPL t1  LEFT JOIN T_SRFPSDBSYSPROCTEMPL t11 ON t1.PSDBSYSPROCTEMPLID = t11.PSDBSYSPROCTEMPLID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="TEMPLCODE", expression="t1.TEMPLCODE", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDBSPPARTTEMPLID", expression="t1.PSDBSPPARTTEMPLID", showorder=3), @DEDataQueryCodeExp(name="PSDBSPPARTTEMPLNAME", expression="t1.PSDBSPPARTTEMPLNAME", showorder=4), @DEDataQueryCodeExp(name="PSDBSYSPROCTEMPLID", expression="t1.PSDBSYSPROCTEMPLID", showorder=5), @DEDataQueryCodeExp(name="PSDBSYSPROCTEMPLNAME", expression="t11.PSDBSYSPROCTEMPLNAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8)}, conds={})})
public class PSDBSPPartTemplDefaultDQModel
extends DEDataQueryModelBase {
    public PSDBSPPartTemplDefaultDQModel() {
        this.initAnnotation(PSDBSPPartTemplDefaultDQModel.class);
    }
}

