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
package net.ibizsys.pscore.srv.def.demodel.psdbsysproctempl.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="464FF75C-1997-4899-960D-38D7030F5792", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDBSYSPROCTEMPLID`, t1.`PSDBSYSPROCTEMPLNAME`, t1.`PSDBSYSPROCTYPEID`, t11.`PSDBSYSPROCTYPENAME`, t1.`PSDBTYPEID`, t1.`PSDBTYPENAME`, t1.`PUBOBJ`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDBSYSPROCTEMPL` t1  LEFT JOIN `T_SRFPSDBSYSPROCTYPE` t11 ON t1.`PSDBSYSPROCTYPEID` = t11.`PSDBSYSPROCTYPEID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODETEMPL", expression="t1.`CODETEMPL`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDBSYSPROCTEMPLID", expression="t1.`PSDBSYSPROCTEMPLID`", showorder=3), @DEDataQueryCodeExp(name="PSDBSYSPROCTEMPLNAME", expression="t1.`PSDBSYSPROCTEMPLNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDBSYSPROCTYPEID", expression="t1.`PSDBSYSPROCTYPEID`", showorder=5), @DEDataQueryCodeExp(name="PSDBSYSPROCTYPENAME", expression="t11.`PSDBSYSPROCTYPENAME`", showorder=6), @DEDataQueryCodeExp(name="PSDBTYPEID", expression="t1.`PSDBTYPEID`", showorder=7), @DEDataQueryCodeExp(name="PSDBTYPENAME", expression="t1.`PSDBTYPENAME`", showorder=8), @DEDataQueryCodeExp(name="PUBOBJ", expression="t1.`PUBOBJ`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDBSYSPROCTEMPLID, t1.PSDBSYSPROCTEMPLNAME, t1.PSDBSYSPROCTYPEID, t11.PSDBSYSPROCTYPENAME, t1.PSDBTYPEID, t1.PSDBTYPENAME, t1.PUBOBJ, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDBSYSPROCTEMPL t1  LEFT JOIN T_SRFPSDBSYSPROCTYPE t11 ON t1.PSDBSYSPROCTYPEID = t11.PSDBSYSPROCTYPEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODETEMPL", expression="t1.CODETEMPL", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDBSYSPROCTEMPLID", expression="t1.PSDBSYSPROCTEMPLID", showorder=3), @DEDataQueryCodeExp(name="PSDBSYSPROCTEMPLNAME", expression="t1.PSDBSYSPROCTEMPLNAME", showorder=4), @DEDataQueryCodeExp(name="PSDBSYSPROCTYPEID", expression="t1.PSDBSYSPROCTYPEID", showorder=5), @DEDataQueryCodeExp(name="PSDBSYSPROCTYPENAME", expression="t11.PSDBSYSPROCTYPENAME", showorder=6), @DEDataQueryCodeExp(name="PSDBTYPEID", expression="t1.PSDBTYPEID", showorder=7), @DEDataQueryCodeExp(name="PSDBTYPENAME", expression="t1.PSDBTYPENAME", showorder=8), @DEDataQueryCodeExp(name="PUBOBJ", expression="t1.PUBOBJ", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSDBSysProcTemplDefaultDQModel
extends DEDataQueryModelBase {
    public PSDBSysProcTemplDefaultDQModel() {
        this.initAnnotation(PSDBSysProcTemplDefaultDQModel.class);
    }
}

