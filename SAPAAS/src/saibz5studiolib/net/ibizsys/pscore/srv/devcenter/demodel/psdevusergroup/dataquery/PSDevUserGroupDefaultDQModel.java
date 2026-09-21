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
package net.ibizsys.pscore.srv.devcenter.demodel.psdevusergroup.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="6A88A672-A395-4696-BA01-63E6CD32972C", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t11.`DEFAULTFLAG`, t11.`DUTAG`, t11.`DUTAG2`, t11.`DUTAG3`, t11.`DUTAG4`, t1.`ENABLE`, t1.`GROUPTAG`, t1.`GROUPTAG2`, t11.`MEMO`, t11.`PSDEVCENTERID`, t21.`PSDEVCENTERNAME`, t1.`PSDEVUSERGROUPID`, t1.`PSDEVUSERGROUPNAME`, t11.`PSDEVUSEROBJTYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t11.`VALIDFLAG` FROM `T_SRFPSDEVUSERGROUP` t1  LEFT JOIN `T_SRFPSDEVUSEROBJ` t11 ON t1.`PSDEVUSERGROUPID` = t11.`PSDEVUSEROBJID`  LEFT JOIN `T_SRFPSDEVCENTER` t21 ON t11.`PSDEVCENTERID` = t21.`PSDEVCENTERID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DEFAULTFLAG", expression="t11.`DEFAULTFLAG`", showorder=2), @DEDataQueryCodeExp(name="DUTAG", expression="t11.`DUTAG`", showorder=3), @DEDataQueryCodeExp(name="DUTAG2", expression="t11.`DUTAG2`", showorder=4), @DEDataQueryCodeExp(name="DUTAG3", expression="t11.`DUTAG3`", showorder=5), @DEDataQueryCodeExp(name="DUTAG4", expression="t11.`DUTAG4`", showorder=6), @DEDataQueryCodeExp(name="ENABLE", expression="t1.`ENABLE`", showorder=7), @DEDataQueryCodeExp(name="GROUPTAG", expression="t1.`GROUPTAG`", showorder=8), @DEDataQueryCodeExp(name="GROUPTAG2", expression="t1.`GROUPTAG2`", showorder=9), @DEDataQueryCodeExp(name="MEMO", expression="t11.`MEMO`", showorder=10), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t11.`PSDEVCENTERID`", showorder=11), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t21.`PSDEVCENTERNAME`", showorder=12), @DEDataQueryCodeExp(name="PSDEVUSERGROUPID", expression="t1.`PSDEVUSERGROUPID`", showorder=13), @DEDataQueryCodeExp(name="PSDEVUSERGROUPNAME", expression="t1.`PSDEVUSERGROUPNAME`", showorder=14), @DEDataQueryCodeExp(name="PSDEVUSEROBJTYPE", expression="t11.`PSDEVUSEROBJTYPE`", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t11.`VALIDFLAG`", showorder=18)}, conds={@DEDataQueryCodeCond(condition="t1.ENABLE = 1")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t11.DEFAULTFLAG, t11.DUTAG, t11.DUTAG2, t11.DUTAG3, t11.DUTAG4, t1.ENABLE, t1.GROUPTAG, t1.GROUPTAG2, t11.MEMO, t11.PSDEVCENTERID, t21.PSDEVCENTERNAME, t1.PSDEVUSERGROUPID, t1.PSDEVUSERGROUPNAME, t11.PSDEVUSEROBJTYPE, t1.UPDATEDATE, t1.UPDATEMAN, t11.VALIDFLAG FROM T_SRFPSDEVUSERGROUP t1  LEFT JOIN T_SRFPSDEVUSEROBJ t11 ON t1.PSDEVUSERGROUPID = t11.PSDEVUSEROBJID  LEFT JOIN T_SRFPSDEVCENTER t21 ON t11.PSDEVCENTERID = t21.PSDEVCENTERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DEFAULTFLAG", expression="t11.DEFAULTFLAG", showorder=2), @DEDataQueryCodeExp(name="DUTAG", expression="t11.DUTAG", showorder=3), @DEDataQueryCodeExp(name="DUTAG2", expression="t11.DUTAG2", showorder=4), @DEDataQueryCodeExp(name="DUTAG3", expression="t11.DUTAG3", showorder=5), @DEDataQueryCodeExp(name="DUTAG4", expression="t11.DUTAG4", showorder=6), @DEDataQueryCodeExp(name="ENABLE", expression="t1.ENABLE", showorder=7), @DEDataQueryCodeExp(name="GROUPTAG", expression="t1.GROUPTAG", showorder=8), @DEDataQueryCodeExp(name="GROUPTAG2", expression="t1.GROUPTAG2", showorder=9), @DEDataQueryCodeExp(name="MEMO", expression="t11.MEMO", showorder=10), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t11.PSDEVCENTERID", showorder=11), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t21.PSDEVCENTERNAME", showorder=12), @DEDataQueryCodeExp(name="PSDEVUSERGROUPID", expression="t1.PSDEVUSERGROUPID", showorder=13), @DEDataQueryCodeExp(name="PSDEVUSERGROUPNAME", expression="t1.PSDEVUSERGROUPNAME", showorder=14), @DEDataQueryCodeExp(name="PSDEVUSEROBJTYPE", expression="t11.PSDEVUSEROBJTYPE", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t11.VALIDFLAG", showorder=18)}, conds={@DEDataQueryCodeCond(condition="t1.ENABLE = 1")})})
public class PSDevUserGroupDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevUserGroupDefaultDQModel() {
        this.initAnnotation(PSDevUserGroupDefaultDQModel.class);
    }
}

