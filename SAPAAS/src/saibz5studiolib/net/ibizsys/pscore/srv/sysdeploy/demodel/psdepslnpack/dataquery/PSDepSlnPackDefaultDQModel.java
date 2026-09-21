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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnpack.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="3E38125A-4239-4125-9A60-B8E6D521C2BC", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEPTOOLTYPE`, t1.`MEMO`, t1.`PACKSTATE`, t1.`PSDEPSLNID`, t11.`PSDEPSLNNAME`, t1.`PSDEPSLNPACKID`, t1.`PSDEPSLNPACKNAME`, t1.`PSDEVCENTERFILEID`, t21.`PSDEVCENTERFILENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEPSLNPACK` t1  LEFT JOIN T_SRFPSDEPSLN t11 ON t1.PSDEPSLNID = t11.PSDEPSLNID  LEFT JOIN T_SRFPSDEVCENTERFILE t21 ON t1.PSDEVCENTERFILEID = t21.PSDEVCENTERFILEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="PACKERRORINFO", expression="t1.`PACKERRORINFO`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DEPTOOLTYPE", expression="t1.`DEPTOOLTYPE`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PACKSTATE", expression="t1.`PACKSTATE`", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.`PSDEPSLNID`", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t11.`PSDEPSLNNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNPACKID", expression="t1.`PSDEPSLNPACKID`", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNPACKNAME", expression="t1.`PSDEPSLNPACKNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERFILEID", expression="t1.`PSDEVCENTERFILEID`", showorder=9), @DEDataQueryCodeExp(name="PSDEVCENTERFILENAME", expression="t21.`PSDEVCENTERFILENAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEPTOOLTYPE, t1.MEMO, t1.PACKSTATE, t1.PSDEPSLNID, t11.PSDEPSLNNAME, t1.PSDEPSLNPACKID, t1.PSDEPSLNPACKNAME, t1.PSDEVCENTERFILEID, t21.PSDEVCENTERFILENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEPSLNPACK t1  LEFT JOIN T_SRFPSDEPSLN t11 ON t1.PSDEPSLNID = t11.PSDEPSLNID  LEFT JOIN T_SRFPSDEVCENTERFILE t21 ON t1.PSDEVCENTERFILEID = t21.PSDEVCENTERFILEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="PACKERRORINFO", expression="t1.PACKERRORINFO", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DEPTOOLTYPE", expression="t1.DEPTOOLTYPE", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PACKSTATE", expression="t1.PACKSTATE", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.PSDEPSLNID", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t11.PSDEPSLNNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNPACKID", expression="t1.PSDEPSLNPACKID", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNPACKNAME", expression="t1.PSDEPSLNPACKNAME", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERFILEID", expression="t1.PSDEVCENTERFILEID", showorder=9), @DEDataQueryCodeExp(name="PSDEVCENTERFILENAME", expression="t21.PSDEVCENTERFILENAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSDepSlnPackDefaultDQModel
extends DEDataQueryModelBase {
    public PSDepSlnPackDefaultDQModel() {
        this.initAnnotation(PSDepSlnPackDefaultDQModel.class);
    }
}

