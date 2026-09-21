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
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevprd.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="2BF1324D-7E5F-41B9-A426-051472257E04", name="CurSln")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ISSUESNPREFIX`, t1.`MEMO`, t1.`PRDSN`, t1.`PRDTAG`, t1.`PRDTAG2`, t1.`PSDEVPRDID`, t1.`PSDEVPRDNAME`, t1.`PSDEVSLNID`, t11.`PSDEVSLNNAME`, t1.`SPECSNPREFIX`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4`, t1.`VALIDFLAG` FROM `T_SRFPSDEVPRD` t1  LEFT JOIN T_SRFPSDEVSLN t11 ON t1.PSDEVSLNID = t11.PSDEVSLNID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="ISSUESNPREFIX", expression="t1.`ISSUESNPREFIX`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PRDSN", expression="t1.`PRDSN`", showorder=5), @DEDataQueryCodeExp(name="PRDTAG", expression="t1.`PRDTAG`", showorder=6), @DEDataQueryCodeExp(name="PRDTAG2", expression="t1.`PRDTAG2`", showorder=7), @DEDataQueryCodeExp(name="PSDEVPRDID", expression="t1.`PSDEVPRDID`", showorder=8), @DEDataQueryCodeExp(name="PSDEVPRDNAME", expression="t1.`PSDEVPRDNAME`", showorder=9), @DEDataQueryCodeExp(name="PSDEVSLNID", expression="t1.`PSDEVSLNID`", showorder=10), @DEDataQueryCodeExp(name="PSDEVSLNNAME", expression="t11.`PSDEVSLNNAME`", showorder=11), @DEDataQueryCodeExp(name="SPECSNPREFIX", expression="t1.`SPECSNPREFIX`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=15), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=16), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=17), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=18), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=19), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=20)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSDEVSLNID` =  ${srfdatacontext('psdevslnid','{\"defname\":\"PSDEVSLNID\",\"dename\":\"PSDEVPRD\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.ISSUESNPREFIX, t1.MEMO, t1.PRDSN, t1.PRDTAG, t1.PRDTAG2, t1.PSDEVPRDID, t1.PSDEVPRDNAME, t1.PSDEVSLNID, t11.PSDEVSLNNAME, t1.SPECSNPREFIX, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4, t1.VALIDFLAG FROM T_SRFPSDEVPRD t1  LEFT JOIN T_SRFPSDEVSLN t11 ON t1.PSDEVSLNID = t11.PSDEVSLNID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="ISSUESNPREFIX", expression="t1.ISSUESNPREFIX", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PRDSN", expression="t1.PRDSN", showorder=5), @DEDataQueryCodeExp(name="PRDTAG", expression="t1.PRDTAG", showorder=6), @DEDataQueryCodeExp(name="PRDTAG2", expression="t1.PRDTAG2", showorder=7), @DEDataQueryCodeExp(name="PSDEVPRDID", expression="t1.PSDEVPRDID", showorder=8), @DEDataQueryCodeExp(name="PSDEVPRDNAME", expression="t1.PSDEVPRDNAME", showorder=9), @DEDataQueryCodeExp(name="PSDEVSLNID", expression="t1.PSDEVSLNID", showorder=10), @DEDataQueryCodeExp(name="PSDEVSLNNAME", expression="t11.PSDEVSLNNAME", showorder=11), @DEDataQueryCodeExp(name="SPECSNPREFIX", expression="t1.SPECSNPREFIX", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=15), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=16), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=17), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=18), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=19), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=20)}, conds={@DEDataQueryCodeCond(condition="( t1.PSDEVSLNID =  ${srfdatacontext('psdevslnid','{\"defname\":\"PSDEVSLNID\",\"dename\":\"PSDEVPRD\"}')} )")})})
public class PSDevPrdCurSlnDQModel
extends DEDataQueryModelBase {
    public PSDevPrdCurSlnDQModel() {
        this.initAnnotation(PSDevPrdCurSlnDQModel.class);
    }
}

