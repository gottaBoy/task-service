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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnuser.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="62EDB14A-3945-4112-85A2-8270A2B00295", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ACCMODE`, t1.`ALLSYSFLAG`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEPSLNID`, t11.`PSDEPSLNNAME`, t1.`PSDEPSLNSYSID`, t21.`PSDEPSLNSYSNAME`, t1.`PSDEPSLNUSERID`, t1.`PSDEPSLNUSERNAME`, t1.`PSDEVUSEROBJID`, t31.`PSDEVUSEROBJNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEPSLNUSER` t1  LEFT JOIN T_SRFPSDEPSLN t11 ON t1.PSDEPSLNID = t11.PSDEPSLNID  LEFT JOIN T_SRFPSDEPSLNSYS t21 ON t1.PSDEPSLNSYSID = t21.PSDEPSLNSYSID  LEFT JOIN T_SRFPSDEVUSEROBJ t31 ON t1.PSDEVUSEROBJID = t31.PSDEVUSEROBJID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ACCMODE", expression="t1.`ACCMODE`", showorder=0), @DEDataQueryCodeExp(name="ALLSYSFLAG", expression="t1.`ALLSYSFLAG`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.`PSDEPSLNID`", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t11.`PSDEPSLNNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNSYSID", expression="t1.`PSDEPSLNSYSID`", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNSYSNAME", expression="t21.`PSDEPSLNSYSNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDEPSLNUSERID", expression="t1.`PSDEPSLNUSERID`", showorder=9), @DEDataQueryCodeExp(name="PSDEPSLNUSERNAME", expression="t1.`PSDEPSLNUSERNAME`", showorder=10), @DEDataQueryCodeExp(name="PSDEVUSEROBJID", expression="t1.`PSDEVUSEROBJID`", showorder=11), @DEDataQueryCodeExp(name="PSDEVUSEROBJNAME", expression="t31.`PSDEVUSEROBJNAME`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.ACCMODE, t1.ALLSYSFLAG, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEPSLNID, t11.PSDEPSLNNAME, t1.PSDEPSLNSYSID, t21.PSDEPSLNSYSNAME, t1.PSDEPSLNUSERID, t1.PSDEPSLNUSERNAME, t1.PSDEVUSEROBJID, t31.PSDEVUSEROBJNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEPSLNUSER t1  LEFT JOIN T_SRFPSDEPSLN t11 ON t1.PSDEPSLNID = t11.PSDEPSLNID  LEFT JOIN T_SRFPSDEPSLNSYS t21 ON t1.PSDEPSLNSYSID = t21.PSDEPSLNSYSID  LEFT JOIN T_SRFPSDEVUSEROBJ t31 ON t1.PSDEVUSEROBJID = t31.PSDEVUSEROBJID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ACCMODE", expression="t1.ACCMODE", showorder=0), @DEDataQueryCodeExp(name="ALLSYSFLAG", expression="t1.ALLSYSFLAG", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.PSDEPSLNID", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t11.PSDEPSLNNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNSYSID", expression="t1.PSDEPSLNSYSID", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNSYSNAME", expression="t21.PSDEPSLNSYSNAME", showorder=8), @DEDataQueryCodeExp(name="PSDEPSLNUSERID", expression="t1.PSDEPSLNUSERID", showorder=9), @DEDataQueryCodeExp(name="PSDEPSLNUSERNAME", expression="t1.PSDEPSLNUSERNAME", showorder=10), @DEDataQueryCodeExp(name="PSDEVUSEROBJID", expression="t1.PSDEVUSEROBJID", showorder=11), @DEDataQueryCodeExp(name="PSDEVUSEROBJNAME", expression="t31.PSDEVUSEROBJNAME", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14)}, conds={})})
public class PSDepSlnUserDefaultDQModel
extends DEDataQueryModelBase {
    public PSDepSlnUserDefaultDQModel() {
        this.initAnnotation(PSDepSlnUserDefaultDQModel.class);
    }
}

