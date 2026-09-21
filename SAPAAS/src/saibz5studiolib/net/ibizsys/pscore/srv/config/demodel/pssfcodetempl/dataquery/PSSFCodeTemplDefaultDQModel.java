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
package net.ibizsys.pscore.srv.config.demodel.pssfcodetempl.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="F9C66999-9B1C-43D2-BD4B-D12A43693159", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOGICNAME`, t1.`MEMO`, t1.`PSSFCODETEMPLID`, t1.`PSSFCODETEMPLNAME`, t1.`PSSFCODETYPEID`, t11.`PSSFCODETYPENAME`, t21.`PSSFSTYLEID`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSSFCODETEMPL` t1  LEFT JOIN T_SRFPSSFCODETYPE t11 ON t1.PSSFCODETYPEID = t11.PSSFCODETYPEID  LEFT JOIN T_SRFPSSFCODEFOLDER t21 ON t11.PSSFCODEFOLDERID = t21.PSSFCODEFOLDERID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="TEMPLCODE", expression="t1.`TEMPLCODE`", showorder=-1), @DEDataQueryCodeExp(name="TEMPLCODE2", expression="t1.`TEMPLCODE2`", showorder=-1), @DEDataQueryCodeExp(name="TEMPLDESC", expression="t1.`TEMPLDESC`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.`LOGICNAME`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSSFCODETEMPLID", expression="t1.`PSSFCODETEMPLID`", showorder=4), @DEDataQueryCodeExp(name="PSSFCODETEMPLNAME", expression="t1.`PSSFCODETEMPLNAME`", showorder=5), @DEDataQueryCodeExp(name="PSSFCODETYPEID", expression="t1.`PSSFCODETYPEID`", showorder=6), @DEDataQueryCodeExp(name="PSSFCODETYPENAME", expression="t11.`PSSFCODETYPENAME`", showorder=7), @DEDataQueryCodeExp(name="PSSFSTYLEID", expression="t21.`PSSFSTYLEID`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.LOGICNAME, t1.MEMO, t1.PSSFCODETEMPLID, t1.PSSFCODETEMPLNAME, t1.PSSFCODETYPEID, t11.PSSFCODETYPENAME, t21.PSSFSTYLEID, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSSFCODETEMPL t1  LEFT JOIN T_SRFPSSFCODETYPE t11 ON t1.PSSFCODETYPEID = t11.PSSFCODETYPEID  LEFT JOIN T_SRFPSSFCODEFOLDER t21 ON t11.PSSFCODEFOLDERID = t21.PSSFCODEFOLDERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="TEMPLCODE", expression="t1.TEMPLCODE", showorder=-1), @DEDataQueryCodeExp(name="TEMPLCODE2", expression="t1.TEMPLCODE2", showorder=-1), @DEDataQueryCodeExp(name="TEMPLDESC", expression="t1.TEMPLDESC", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.LOGICNAME", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSSFCODETEMPLID", expression="t1.PSSFCODETEMPLID", showorder=4), @DEDataQueryCodeExp(name="PSSFCODETEMPLNAME", expression="t1.PSSFCODETEMPLNAME", showorder=5), @DEDataQueryCodeExp(name="PSSFCODETYPEID", expression="t1.PSSFCODETYPEID", showorder=6), @DEDataQueryCodeExp(name="PSSFCODETYPENAME", expression="t11.PSSFCODETYPENAME", showorder=7), @DEDataQueryCodeExp(name="PSSFSTYLEID", expression="t21.PSSFSTYLEID", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=11)}, conds={})})
public class PSSFCodeTemplDefaultDQModel
extends DEDataQueryModelBase {
    public PSSFCodeTemplDefaultDQModel() {
        this.initAnnotation(PSSFCodeTemplDefaultDQModel.class);
    }
}

