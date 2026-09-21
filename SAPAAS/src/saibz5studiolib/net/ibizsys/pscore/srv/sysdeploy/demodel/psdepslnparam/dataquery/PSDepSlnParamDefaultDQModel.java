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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnparam.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="D59CA93D-6476-42D0-97FF-C3969F8B50A3", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEPSLNID`, t11.`PSDEPSLNNAME`, t1.`PSDEPSLNPARAMID`, t1.`PSDEPSLNPARAMNAME`, t1.`PSDEPSLNSYSID`, t21.`PSDEPSLNSYSNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG`, t1.`VALUE` FROM `T_SRFPSDEPSLNPARAM` t1  LEFT JOIN `T_SRFPSDEPSLN` t11 ON t1.`PSDEPSLNID` = t11.`PSDEPSLNID`  LEFT JOIN `T_SRFPSDEPSLNSYS` t21 ON t1.`PSDEPSLNSYSID` = t21.`PSDEPSLNSYSID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.`PSDEPSLNID`", showorder=3), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t11.`PSDEPSLNNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNPARAMID", expression="t1.`PSDEPSLNPARAMID`", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNPARAMNAME", expression="t1.`PSDEPSLNPARAMNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNSYSID", expression="t1.`PSDEPSLNSYSID`", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNSYSNAME", expression="t21.`PSDEPSLNSYSNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=11), @DEDataQueryCodeExp(name="VALUE", expression="t1.`VALUE`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEPSLNID, t11.PSDEPSLNNAME, t1.PSDEPSLNPARAMID, t1.PSDEPSLNPARAMNAME, t1.PSDEPSLNSYSID, t21.PSDEPSLNSYSNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG, t1.VALUE FROM T_SRFPSDEPSLNPARAM t1  LEFT JOIN T_SRFPSDEPSLN t11 ON t1.PSDEPSLNID = t11.PSDEPSLNID  LEFT JOIN T_SRFPSDEPSLNSYS t21 ON t1.PSDEPSLNSYSID = t21.PSDEPSLNSYSID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.PSDEPSLNID", showorder=3), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t11.PSDEPSLNNAME", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNPARAMID", expression="t1.PSDEPSLNPARAMID", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNPARAMNAME", expression="t1.PSDEPSLNPARAMNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNSYSID", expression="t1.PSDEPSLNSYSID", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNSYSNAME", expression="t21.PSDEPSLNSYSNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=11), @DEDataQueryCodeExp(name="VALUE", expression="t1.VALUE", showorder=12)}, conds={})})
public class PSDepSlnParamDefaultDQModel
extends DEDataQueryModelBase {
    public PSDepSlnParamDefaultDQModel() {
        this.initAnnotation(PSDepSlnParamDefaultDQModel.class);
    }
}

