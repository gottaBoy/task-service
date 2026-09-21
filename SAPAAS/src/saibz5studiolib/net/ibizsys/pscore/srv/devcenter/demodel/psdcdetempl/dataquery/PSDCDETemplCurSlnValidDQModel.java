/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeCond
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcdetempl.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="909D05B6-BFD8-43D2-8454-3CAA4FAFC57A", name="CurSlnValid")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ALLDCFLAG`, t1.`BIZTAG`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDCDETEMPLID`, t1.`PSDCDETEMPLNAME`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`PSDEVSLNID`, t11.`PSDEVSLNNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDCDETEMPL` t1  LEFT JOIN `T_SRFPSDEVSLN` t11 ON t1.`PSDEVSLNID` = t11.`PSDEVSLNID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ALLDCFLAG", expression="t1.`ALLDCFLAG`", showorder=0), @DEDataQueryCodeExp(name="BIZTAG", expression="t1.`BIZTAG`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSDCDETEMPLID", expression="t1.`PSDCDETEMPLID`", showorder=5), @DEDataQueryCodeExp(name="PSDCDETEMPLNAME", expression="t1.`PSDCDETEMPLNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDEVSLNID", expression="t1.`PSDEVSLNID`", showorder=9), @DEDataQueryCodeExp(name="PSDEVSLNNAME", expression="t11.`PSDEVSLNNAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=13)}, conds={@DEDataQueryCodeCond(condition="( t1.`VALIDFLAG` = 1  AND  t1.`PSDEVSLNID` =  ${srfdatacontext('psdevslnid','{\"defname\":\"PSDEVSLNID\",\"dename\":\"PSDCDETEMPL\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.ALLDCFLAG, t1.BIZTAG, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDCDETEMPLID, t1.PSDCDETEMPLNAME, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.PSDEVSLNID, t11.PSDEVSLNNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDCDETEMPL t1  LEFT JOIN T_SRFPSDEVSLN t11 ON t1.PSDEVSLNID = t11.PSDEVSLNID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ALLDCFLAG", expression="t1.ALLDCFLAG", showorder=0), @DEDataQueryCodeExp(name="BIZTAG", expression="t1.BIZTAG", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSDCDETEMPLID", expression="t1.PSDCDETEMPLID", showorder=5), @DEDataQueryCodeExp(name="PSDCDETEMPLNAME", expression="t1.PSDCDETEMPLNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=8), @DEDataQueryCodeExp(name="PSDEVSLNID", expression="t1.PSDEVSLNID", showorder=9), @DEDataQueryCodeExp(name="PSDEVSLNNAME", expression="t11.PSDEVSLNNAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=13)}, conds={@DEDataQueryCodeCond(condition="( t1.VALIDFLAG = 1  AND  t1.PSDEVSLNID =  ${srfdatacontext('psdevslnid','{\"defname\":\"PSDEVSLNID\",\"dename\":\"PSDCDETEMPL\"}')} )")})})
public class PSDCDETemplCurSlnValidDQModel
extends DEDataQueryModelBase {
    public PSDCDETemplCurSlnValidDQModel() {
        this.initAnnotation(PSDCDETemplCurSlnValidDQModel.class);
    }
}

