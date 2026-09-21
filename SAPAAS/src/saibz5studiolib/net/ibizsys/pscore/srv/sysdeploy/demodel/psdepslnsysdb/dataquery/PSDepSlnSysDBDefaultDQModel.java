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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnsysdb.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="22493E23-7DB3-469E-A26C-B057EAFC49B6", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEPSLNDBINSTID`, t11.`PSDEPSLNDBINSTNAME`, t1.`PSDEPSLNID`, t21.`PSDEPSLNNAME`, t1.`PSDEPSLNSYSDBID`, t1.`PSDEPSLNSYSDBNAME`, t1.`PSDEPSLNSYSID`, t31.`PSDEPSLNSYSNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEPSLNSYSDB` t1  LEFT JOIN T_SRFPSDEPSLNDBINST t11 ON t1.PSDEPSLNDBINSTID = t11.PSDEPSLNDBINSTID  LEFT JOIN T_SRFPSDEPSLN t21 ON t1.PSDEPSLNID = t21.PSDEPSLNID  LEFT JOIN T_SRFPSDEPSLNSYS t31 ON t1.PSDEPSLNSYSID = t31.PSDEPSLNSYSID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEPSLNDBINSTID", expression="t1.`PSDEPSLNDBINSTID`", showorder=3), @DEDataQueryCodeExp(name="PSDEPSLNDBINSTNAME", expression="t11.`PSDEPSLNDBINSTNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.`PSDEPSLNID`", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t21.`PSDEPSLNNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNSYSDBID", expression="t1.`PSDEPSLNSYSDBID`", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNSYSDBNAME", expression="t1.`PSDEPSLNSYSDBNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDEPSLNSYSID", expression="t1.`PSDEPSLNSYSID`", showorder=9), @DEDataQueryCodeExp(name="PSDEPSLNSYSNAME", expression="t31.`PSDEPSLNSYSNAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEPSLNDBINSTID, t11.PSDEPSLNDBINSTNAME, t1.PSDEPSLNID, t21.PSDEPSLNNAME, t1.PSDEPSLNSYSDBID, t1.PSDEPSLNSYSDBNAME, t1.PSDEPSLNSYSID, t31.PSDEPSLNSYSNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEPSLNSYSDB t1  LEFT JOIN T_SRFPSDEPSLNDBINST t11 ON t1.PSDEPSLNDBINSTID = t11.PSDEPSLNDBINSTID  LEFT JOIN T_SRFPSDEPSLN t21 ON t1.PSDEPSLNID = t21.PSDEPSLNID  LEFT JOIN T_SRFPSDEPSLNSYS t31 ON t1.PSDEPSLNSYSID = t31.PSDEPSLNSYSID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEPSLNDBINSTID", expression="t1.PSDEPSLNDBINSTID", showorder=3), @DEDataQueryCodeExp(name="PSDEPSLNDBINSTNAME", expression="t11.PSDEPSLNDBINSTNAME", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.PSDEPSLNID", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t21.PSDEPSLNNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNSYSDBID", expression="t1.PSDEPSLNSYSDBID", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNSYSDBNAME", expression="t1.PSDEPSLNSYSDBNAME", showorder=8), @DEDataQueryCodeExp(name="PSDEPSLNSYSID", expression="t1.PSDEPSLNSYSID", showorder=9), @DEDataQueryCodeExp(name="PSDEPSLNSYSNAME", expression="t31.PSDEPSLNSYSNAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSDepSlnSysDBDefaultDQModel
extends DEDataQueryModelBase {
    public PSDepSlnSysDBDefaultDQModel() {
        this.initAnnotation(PSDepSlnSysDBDefaultDQModel.class);
    }
}

