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
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnres.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="AA5036EF-2E2A-4F18-A0C6-920D895593BB", name="CurSln")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEVSLNID`, t11.`PSDEVSLNNAME`, t1.`PSDEVSLNRESID`, t1.`PSDEVSLNRESNAME`, t1.`RESTYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4` FROM `T_SRFPSDEVSLNRES` t1  LEFT JOIN `T_SRFPSDEVSLN` t11 ON t1.`PSDEVSLNID` = t11.`PSDEVSLNID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="RESPARAMS", expression="t1.`RESPARAMS`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEVSLNID", expression="t1.`PSDEVSLNID`", showorder=3), @DEDataQueryCodeExp(name="PSDEVSLNNAME", expression="t11.`PSDEVSLNNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDEVSLNRESID", expression="t1.`PSDEVSLNRESID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVSLNRESNAME", expression="t1.`PSDEVSLNRESNAME`", showorder=6), @DEDataQueryCodeExp(name="RESTYPE", expression="t1.`RESTYPE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=10), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=11), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=12), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=13), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=14)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSDEVSLNID` =  ${srfdatacontext('psdevslnid','{\"defname\":\"PSDEVSLNID\",\"dename\":\"PSDEVSLNRES\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEVSLNID, t11.PSDEVSLNNAME, t1.PSDEVSLNRESID, t1.PSDEVSLNRESNAME, t1.RESTYPE, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4 FROM T_SRFPSDEVSLNRES t1  LEFT JOIN T_SRFPSDEVSLN t11 ON t1.PSDEVSLNID = t11.PSDEVSLNID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="RESPARAMS", expression="t1.RESPARAMS", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEVSLNID", expression="t1.PSDEVSLNID", showorder=3), @DEDataQueryCodeExp(name="PSDEVSLNNAME", expression="t11.PSDEVSLNNAME", showorder=4), @DEDataQueryCodeExp(name="PSDEVSLNRESID", expression="t1.PSDEVSLNRESID", showorder=5), @DEDataQueryCodeExp(name="PSDEVSLNRESNAME", expression="t1.PSDEVSLNRESNAME", showorder=6), @DEDataQueryCodeExp(name="RESTYPE", expression="t1.RESTYPE", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=10), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=11), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=12), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=13), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=14)}, conds={@DEDataQueryCodeCond(condition="( t1.PSDEVSLNID =  ${srfdatacontext('psdevslnid','{\"defname\":\"PSDEVSLNID\",\"dename\":\"PSDEVSLNRES\"}')} )")})})
public class PSDevSlnResCurSlnDQModel
extends DEDataQueryModelBase {
    public PSDevSlnResCurSlnDQModel() {
        this.initAnnotation(PSDevSlnResCurSlnDQModel.class);
    }
}

