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
package net.ibizsys.pscore.srv.devcenter.demodel.psdevuserobj.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="55B34EB0-E1B4-48FA-94E4-71C55F301EDD", name="CurDC")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEFAULTFLAG`, t1.`DUTAG`, t1.`DUTAG2`, t1.`DUTAG3`, t1.`DUTAG4`, t1.`ENABLE`, t1.`MEMO`, t1.`PSDEVCENTERID`, t11.`PSDEVCENTERNAME`, t1.`PSDEVUSEROBJID`, t1.`PSDEVUSEROBJNAME`, t1.`PSDEVUSEROBJTYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDEVUSEROBJ` t1  LEFT JOIN `T_SRFPSDEVCENTER` t11 ON t1.`PSDEVCENTERID` = t11.`PSDEVCENTERID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DEFAULTFLAG", expression="t1.`DEFAULTFLAG`", showorder=2), @DEDataQueryCodeExp(name="DUTAG", expression="t1.`DUTAG`", showorder=3), @DEDataQueryCodeExp(name="DUTAG2", expression="t1.`DUTAG2`", showorder=4), @DEDataQueryCodeExp(name="DUTAG3", expression="t1.`DUTAG3`", showorder=5), @DEDataQueryCodeExp(name="DUTAG4", expression="t1.`DUTAG4`", showorder=6), @DEDataQueryCodeExp(name="ENABLE", expression="t1.`ENABLE`", showorder=7), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=9), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t11.`PSDEVCENTERNAME`", showorder=10), @DEDataQueryCodeExp(name="PSDEVUSEROBJID", expression="t1.`PSDEVUSEROBJID`", showorder=11), @DEDataQueryCodeExp(name="PSDEVUSEROBJNAME", expression="t1.`PSDEVUSEROBJNAME`", showorder=12), @DEDataQueryCodeExp(name="PSDEVUSEROBJTYPE", expression="t1.`PSDEVUSEROBJTYPE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=16)}, conds={@DEDataQueryCodeCond(condition="t1.ENABLE = 1"), @DEDataQueryCodeCond(condition="( t1.`PSDEVCENTERID` =  ${srfdatacontext('psdevcenterid','{\"defname\":\"PSDEVCENTERID\",\"dename\":\"PSDEVUSEROBJ\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEFAULTFLAG, t1.DUTAG, t1.DUTAG2, t1.DUTAG3, t1.DUTAG4, t1.ENABLE, t1.MEMO, t1.PSDEVCENTERID, t11.PSDEVCENTERNAME, t1.PSDEVUSEROBJID, t1.PSDEVUSEROBJNAME, t1.PSDEVUSEROBJTYPE, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDEVUSEROBJ t1  LEFT JOIN T_SRFPSDEVCENTER t11 ON t1.PSDEVCENTERID = t11.PSDEVCENTERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DEFAULTFLAG", expression="t1.DEFAULTFLAG", showorder=2), @DEDataQueryCodeExp(name="DUTAG", expression="t1.DUTAG", showorder=3), @DEDataQueryCodeExp(name="DUTAG2", expression="t1.DUTAG2", showorder=4), @DEDataQueryCodeExp(name="DUTAG3", expression="t1.DUTAG3", showorder=5), @DEDataQueryCodeExp(name="DUTAG4", expression="t1.DUTAG4", showorder=6), @DEDataQueryCodeExp(name="ENABLE", expression="t1.ENABLE", showorder=7), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=9), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t11.PSDEVCENTERNAME", showorder=10), @DEDataQueryCodeExp(name="PSDEVUSEROBJID", expression="t1.PSDEVUSEROBJID", showorder=11), @DEDataQueryCodeExp(name="PSDEVUSEROBJNAME", expression="t1.PSDEVUSEROBJNAME", showorder=12), @DEDataQueryCodeExp(name="PSDEVUSEROBJTYPE", expression="t1.PSDEVUSEROBJTYPE", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=16)}, conds={@DEDataQueryCodeCond(condition="t1.ENABLE = 1"), @DEDataQueryCodeCond(condition="( t1.PSDEVCENTERID =  ${srfdatacontext('psdevcenterid','{\"defname\":\"PSDEVCENTERID\",\"dename\":\"PSDEVUSEROBJ\"}')} )")})})
public class PSDevUserObjCurDCDQModel
extends DEDataQueryModelBase {
    public PSDevUserObjCurDCDQModel() {
        this.initAnnotation(PSDevUserObjCurDCDQModel.class);
    }
}

