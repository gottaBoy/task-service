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
package net.ibizsys.pscore.srv.unisys.demodel.psusdcmoduleinstref.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="4F41E8D0-48DE-4A3B-9F1D-1FA483FAC647", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSUSDCMODULEINSTID`, t11.`PSUSDCMODULEINSTNAME`, t1.`PSUSDCMODULEINSTREFID`, t1.`PSUSDCMODULEINSTREFNAME`, t1.`REFMODE`, t1.`REFPSUSDCMODULEINSTID`, t21.`PSUSDCMODULEINSTNAME` AS `REFPSUSDCMODULEINSTNAME`, t1.`SERVICEURL`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSUSDCMODULEINSTREF` t1  LEFT JOIN T_SRFPSUSDCMODULEINST t11 ON t1.PSUSDCMODULEINSTID = t11.PSUSDCMODULEINSTID  LEFT JOIN T_SRFPSUSDCMODULEINST t21 ON t1.REFPSUSDCMODULEINSTID = t21.PSUSDCMODULEINSTID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSUSDCMODULEINSTID", expression="t1.`PSUSDCMODULEINSTID`", showorder=2), @DEDataQueryCodeExp(name="PSUSDCMODULEINSTNAME", expression="t11.`PSUSDCMODULEINSTNAME`", showorder=3), @DEDataQueryCodeExp(name="PSUSDCMODULEINSTREFID", expression="t1.`PSUSDCMODULEINSTREFID`", showorder=4), @DEDataQueryCodeExp(name="PSUSDCMODULEINSTREFNAME", expression="t1.`PSUSDCMODULEINSTREFNAME`", showorder=5), @DEDataQueryCodeExp(name="REFMODE", expression="t1.`REFMODE`", showorder=6), @DEDataQueryCodeExp(name="REFPSUSDCMODULEINSTID", expression="t1.`REFPSUSDCMODULEINSTID`", showorder=7), @DEDataQueryCodeExp(name="REFPSUSDCMODULEINSTNAME", expression="t21.`PSUSDCMODULEINSTNAME`", showorder=8), @DEDataQueryCodeExp(name="SERVICEURL", expression="t1.`SERVICEURL`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSUSDCMODULEINSTID, t11.PSUSDCMODULEINSTNAME, t1.PSUSDCMODULEINSTREFID, t1.PSUSDCMODULEINSTREFNAME, t1.REFMODE, t1.REFPSUSDCMODULEINSTID, t21.PSUSDCMODULEINSTNAME AS REFPSUSDCMODULEINSTNAME, t1.SERVICEURL, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSUSDCMODULEINSTREF t1  LEFT JOIN T_SRFPSUSDCMODULEINST t11 ON t1.PSUSDCMODULEINSTID = t11.PSUSDCMODULEINSTID  LEFT JOIN T_SRFPSUSDCMODULEINST t21 ON t1.REFPSUSDCMODULEINSTID = t21.PSUSDCMODULEINSTID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSUSDCMODULEINSTID", expression="t1.PSUSDCMODULEINSTID", showorder=2), @DEDataQueryCodeExp(name="PSUSDCMODULEINSTNAME", expression="t11.PSUSDCMODULEINSTNAME", showorder=3), @DEDataQueryCodeExp(name="PSUSDCMODULEINSTREFID", expression="t1.PSUSDCMODULEINSTREFID", showorder=4), @DEDataQueryCodeExp(name="PSUSDCMODULEINSTREFNAME", expression="t1.PSUSDCMODULEINSTREFNAME", showorder=5), @DEDataQueryCodeExp(name="REFMODE", expression="t1.REFMODE", showorder=6), @DEDataQueryCodeExp(name="REFPSUSDCMODULEINSTID", expression="t1.REFPSUSDCMODULEINSTID", showorder=7), @DEDataQueryCodeExp(name="REFPSUSDCMODULEINSTNAME", expression="t21.PSUSDCMODULEINSTNAME", showorder=8), @DEDataQueryCodeExp(name="SERVICEURL", expression="t1.SERVICEURL", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSUSDCModuleInstRefDefaultDQModel
extends DEDataQueryModelBase {
    public PSUSDCModuleInstRefDefaultDQModel() {
        this.initAnnotation(PSUSDCModuleInstRefDefaultDQModel.class);
    }
}

