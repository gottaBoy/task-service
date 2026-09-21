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
package net.ibizsys.pscore.srv.unisys.demodel.psusdcmoduleinstfunc.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="F0FED0B0-2B72-49D8-8A4D-77D24F277C6C", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`FUNCTAG`, t1.`FUNCTYPE`, t1.`MEMO`, t1.`MOBILEAPPFLAG`, t1.`PSUSDCMODULEINSTFUNCID`, t1.`PSUSDCMODULEINSTFUNCNAME`, t1.`PSUSDCMODULEINSTID`, t11.`PSUSDCMODULEINSTNAME`, t1.`PSUSMODULEINSTFUNCID`, t21.`PSUSMODULEINSTFUNCNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`URL` FROM `T_SRFPSUSDCMODULEINSTFUNC` t1  LEFT JOIN T_SRFPSUSDCMODULEINST t11 ON t1.PSUSDCMODULEINSTID = t11.PSUSDCMODULEINSTID  LEFT JOIN T_SRFPSUSMODULEINSTFUNC t21 ON t1.PSUSMODULEINSTFUNCID = t21.PSUSMODULEINSTFUNCID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="FUNCTAG", expression="t1.`FUNCTAG`", showorder=2), @DEDataQueryCodeExp(name="FUNCTYPE", expression="t1.`FUNCTYPE`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="MOBILEAPPFLAG", expression="t1.`MOBILEAPPFLAG`", showorder=5), @DEDataQueryCodeExp(name="PSUSDCMODULEINSTFUNCID", expression="t1.`PSUSDCMODULEINSTFUNCID`", showorder=6), @DEDataQueryCodeExp(name="PSUSDCMODULEINSTFUNCNAME", expression="t1.`PSUSDCMODULEINSTFUNCNAME`", showorder=7), @DEDataQueryCodeExp(name="PSUSDCMODULEINSTID", expression="t1.`PSUSDCMODULEINSTID`", showorder=8), @DEDataQueryCodeExp(name="PSUSDCMODULEINSTNAME", expression="t11.`PSUSDCMODULEINSTNAME`", showorder=9), @DEDataQueryCodeExp(name="PSUSMODULEINSTFUNCID", expression="t1.`PSUSMODULEINSTFUNCID`", showorder=10), @DEDataQueryCodeExp(name="PSUSMODULEINSTFUNCNAME", expression="t21.`PSUSMODULEINSTFUNCNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13), @DEDataQueryCodeExp(name="URL", expression="t1.`URL`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.FUNCTAG, t1.FUNCTYPE, t1.MEMO, t1.MOBILEAPPFLAG, t1.PSUSDCMODULEINSTFUNCID, t1.PSUSDCMODULEINSTFUNCNAME, t1.PSUSDCMODULEINSTID, t11.PSUSDCMODULEINSTNAME, t1.PSUSMODULEINSTFUNCID, t21.PSUSMODULEINSTFUNCNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.URL FROM T_SRFPSUSDCMODULEINSTFUNC t1  LEFT JOIN T_SRFPSUSDCMODULEINST t11 ON t1.PSUSDCMODULEINSTID = t11.PSUSDCMODULEINSTID  LEFT JOIN T_SRFPSUSMODULEINSTFUNC t21 ON t1.PSUSMODULEINSTFUNCID = t21.PSUSMODULEINSTFUNCID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="FUNCTAG", expression="t1.FUNCTAG", showorder=2), @DEDataQueryCodeExp(name="FUNCTYPE", expression="t1.FUNCTYPE", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="MOBILEAPPFLAG", expression="t1.MOBILEAPPFLAG", showorder=5), @DEDataQueryCodeExp(name="PSUSDCMODULEINSTFUNCID", expression="t1.PSUSDCMODULEINSTFUNCID", showorder=6), @DEDataQueryCodeExp(name="PSUSDCMODULEINSTFUNCNAME", expression="t1.PSUSDCMODULEINSTFUNCNAME", showorder=7), @DEDataQueryCodeExp(name="PSUSDCMODULEINSTID", expression="t1.PSUSDCMODULEINSTID", showorder=8), @DEDataQueryCodeExp(name="PSUSDCMODULEINSTNAME", expression="t11.PSUSDCMODULEINSTNAME", showorder=9), @DEDataQueryCodeExp(name="PSUSMODULEINSTFUNCID", expression="t1.PSUSMODULEINSTFUNCID", showorder=10), @DEDataQueryCodeExp(name="PSUSMODULEINSTFUNCNAME", expression="t21.PSUSMODULEINSTFUNCNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13), @DEDataQueryCodeExp(name="URL", expression="t1.URL", showorder=14)}, conds={})})
public class PSUSDCModuleInstFuncDefaultDQModel
extends DEDataQueryModelBase {
    public PSUSDCModuleInstFuncDefaultDQModel() {
        this.initAnnotation(PSUSDCModuleInstFuncDefaultDQModel.class);
    }
}

