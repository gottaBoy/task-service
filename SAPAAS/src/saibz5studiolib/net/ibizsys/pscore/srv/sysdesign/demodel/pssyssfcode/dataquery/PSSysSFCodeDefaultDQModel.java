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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyssfcode.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="87FE4740-76D1-4A0F-9ADF-3D52C98DC83E", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODEPATH`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`FULLCODENAME`, t1.`MEMO`, t1.`PSSFCODEFOLDERID`, t1.`PSSFCODEFOLDERNAME`, t1.`PSSFCODETYPEID`, t1.`PSSFCODETYPENAME`, t1.`PSSYSSFCODEID`, t1.`PSSYSSFCODENAME`, t1.`PSSYSSFPUBID`, t11.`PSSYSSFPUBNAME`, t1.`SYSOBJID`, t1.`SYSOBJNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSSYSSFCODE` t1  LEFT JOIN T_SRFPSSYSSFPUB t11 ON t1.PSSYSSFPUBID = t11.PSSYSSFPUBID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="PUBCODE", expression="t1.`PUBCODE`", showorder=-1), @DEDataQueryCodeExp(name="USERCODE", expression="t1.`USERCODE`", showorder=-1), @DEDataQueryCodeExp(name="CODEPATH", expression="t1.`CODEPATH`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="FULLCODENAME", expression="t1.`FULLCODENAME`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSSFCODEFOLDERID", expression="t1.`PSSFCODEFOLDERID`", showorder=5), @DEDataQueryCodeExp(name="PSSFCODEFOLDERNAME", expression="t1.`PSSFCODEFOLDERNAME`", showorder=6), @DEDataQueryCodeExp(name="PSSFCODETYPEID", expression="t1.`PSSFCODETYPEID`", showorder=7), @DEDataQueryCodeExp(name="PSSFCODETYPENAME", expression="t1.`PSSFCODETYPENAME`", showorder=8), @DEDataQueryCodeExp(name="PSSYSSFCODEID", expression="t1.`PSSYSSFCODEID`", showorder=9), @DEDataQueryCodeExp(name="PSSYSSFCODENAME", expression="t1.`PSSYSSFCODENAME`", showorder=10), @DEDataQueryCodeExp(name="PSSYSSFPUBID", expression="t1.`PSSYSSFPUBID`", showorder=11), @DEDataQueryCodeExp(name="PSSYSSFPUBNAME", expression="t11.`PSSYSSFPUBNAME`", showorder=12), @DEDataQueryCodeExp(name="SYSOBJID", expression="t1.`SYSOBJID`", showorder=13), @DEDataQueryCodeExp(name="SYSOBJNAME", expression="t1.`SYSOBJNAME`", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=16), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=17)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CODEPATH, t1.CREATEDATE, t1.CREATEMAN, t1.FULLCODENAME, t1.MEMO, t1.PSSFCODEFOLDERID, t1.PSSFCODEFOLDERNAME, t1.PSSFCODETYPEID, t1.PSSFCODETYPENAME, t1.PSSYSSFCODEID, t1.PSSYSSFCODENAME, t1.PSSYSSFPUBID, t11.PSSYSSFPUBNAME, t1.SYSOBJID, t1.SYSOBJNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSSYSSFCODE t1  LEFT JOIN T_SRFPSSYSSFPUB t11 ON t1.PSSYSSFPUBID = t11.PSSYSSFPUBID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="PUBCODE", expression="t1.PUBCODE", showorder=-1), @DEDataQueryCodeExp(name="USERCODE", expression="t1.USERCODE", showorder=-1), @DEDataQueryCodeExp(name="CODEPATH", expression="t1.CODEPATH", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="FULLCODENAME", expression="t1.FULLCODENAME", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSSFCODEFOLDERID", expression="t1.PSSFCODEFOLDERID", showorder=5), @DEDataQueryCodeExp(name="PSSFCODEFOLDERNAME", expression="t1.PSSFCODEFOLDERNAME", showorder=6), @DEDataQueryCodeExp(name="PSSFCODETYPEID", expression="t1.PSSFCODETYPEID", showorder=7), @DEDataQueryCodeExp(name="PSSFCODETYPENAME", expression="t1.PSSFCODETYPENAME", showorder=8), @DEDataQueryCodeExp(name="PSSYSSFCODEID", expression="t1.PSSYSSFCODEID", showorder=9), @DEDataQueryCodeExp(name="PSSYSSFCODENAME", expression="t1.PSSYSSFCODENAME", showorder=10), @DEDataQueryCodeExp(name="PSSYSSFPUBID", expression="t1.PSSYSSFPUBID", showorder=11), @DEDataQueryCodeExp(name="PSSYSSFPUBNAME", expression="t11.PSSYSSFPUBNAME", showorder=12), @DEDataQueryCodeExp(name="SYSOBJID", expression="t1.SYSOBJID", showorder=13), @DEDataQueryCodeExp(name="SYSOBJNAME", expression="t1.SYSOBJNAME", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=16), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=17)}, conds={})})
public class PSSysSFCodeDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysSFCodeDefaultDQModel() {
        this.initAnnotation(PSSysSFCodeDefaultDQModel.class);
    }
}

