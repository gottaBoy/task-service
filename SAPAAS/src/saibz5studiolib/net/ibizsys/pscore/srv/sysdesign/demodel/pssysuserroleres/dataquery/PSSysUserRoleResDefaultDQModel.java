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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysuserroleres.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="64462EDD-82F0-4DB8-B8EB-01C9C478B908", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSSYSOPPRIVID`, t11.`PSSYSOPPRIVNAME`, t1.`PSSYSUNIRESID`, t21.`PSSYSUNIRESNAME`, t1.`PSSYSUSERROLERESID`, t1.`PSSYSUSERROLERESNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4`, t1.`VALIDFLAG` FROM `T_SRFPSSYSUSERROLERES` t1  LEFT JOIN `T_SRFPSSYSOPPRIV` t11 ON t1.`PSSYSOPPRIVID` = t11.`PSSYSOPPRIVID`  LEFT JOIN `T_SRFPSSYSUNIRES` t21 ON t1.`PSSYSUNIRESID` = t21.`PSSYSUNIRESID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSSYSOPPRIVID", expression="t1.`PSSYSOPPRIVID`", showorder=3), @DEDataQueryCodeExp(name="PSSYSOPPRIVNAME", expression="t11.`PSSYSOPPRIVNAME`", showorder=4), @DEDataQueryCodeExp(name="PSSYSUNIRESID", expression="t1.`PSSYSUNIRESID`", showorder=5), @DEDataQueryCodeExp(name="PSSYSUNIRESNAME", expression="t21.`PSSYSUNIRESNAME`", showorder=6), @DEDataQueryCodeExp(name="PSSYSUSERROLERESID", expression="t1.`PSSYSUSERROLERESID`", showorder=7), @DEDataQueryCodeExp(name="PSSYSUSERROLERESNAME", expression="t1.`PSSYSUSERROLERESNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=11), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=12), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=13), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=14), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=16)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSSYSOPPRIVID, t11.PSSYSOPPRIVNAME, t1.PSSYSUNIRESID, t21.PSSYSUNIRESNAME, t1.PSSYSUSERROLERESID, t1.PSSYSUSERROLERESNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4, t1.VALIDFLAG FROM T_SRFPSSYSUSERROLERES t1  LEFT JOIN T_SRFPSSYSOPPRIV t11 ON t1.PSSYSOPPRIVID = t11.PSSYSOPPRIVID  LEFT JOIN T_SRFPSSYSUNIRES t21 ON t1.PSSYSUNIRESID = t21.PSSYSUNIRESID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSSYSOPPRIVID", expression="t1.PSSYSOPPRIVID", showorder=3), @DEDataQueryCodeExp(name="PSSYSOPPRIVNAME", expression="t11.PSSYSOPPRIVNAME", showorder=4), @DEDataQueryCodeExp(name="PSSYSUNIRESID", expression="t1.PSSYSUNIRESID", showorder=5), @DEDataQueryCodeExp(name="PSSYSUNIRESNAME", expression="t21.PSSYSUNIRESNAME", showorder=6), @DEDataQueryCodeExp(name="PSSYSUSERROLERESID", expression="t1.PSSYSUSERROLERESID", showorder=7), @DEDataQueryCodeExp(name="PSSYSUSERROLERESNAME", expression="t1.PSSYSUSERROLERESNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=11), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=12), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=13), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=14), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=16)}, conds={})})
public class PSSysUserRoleResDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysUserRoleResDefaultDQModel() {
        this.initAnnotation(PSSysUserRoleResDefaultDQModel.class);
    }
}

