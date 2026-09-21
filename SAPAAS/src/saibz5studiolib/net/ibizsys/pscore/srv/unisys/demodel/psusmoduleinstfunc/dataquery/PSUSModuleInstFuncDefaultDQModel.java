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
package net.ibizsys.pscore.srv.unisys.demodel.psusmoduleinstfunc.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="4BFA9A5F-9D48-46C3-97A8-A4BE6027CAE3", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`FUNCTAG`, t1.`FUNCTYPE`, t1.`MEMO`, t1.`MOBILEAPPFLAG`, t1.`PSUSMODULEINSTFUNCID`, t1.`PSUSMODULEINSTFUNCNAME`, t1.`PSUSMODULEINSTID`, t11.`PSUSMODULEINSTNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`URL` FROM `T_SRFPSUSMODULEINSTFUNC` t1  LEFT JOIN T_SRFPSUSMODULEINST t11 ON t1.PSUSMODULEINSTID = t11.PSUSMODULEINSTID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="FUNCTAG", expression="t1.`FUNCTAG`", showorder=2), @DEDataQueryCodeExp(name="FUNCTYPE", expression="t1.`FUNCTYPE`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="MOBILEAPPFLAG", expression="t1.`MOBILEAPPFLAG`", showorder=5), @DEDataQueryCodeExp(name="PSUSMODULEINSTFUNCID", expression="t1.`PSUSMODULEINSTFUNCID`", showorder=6), @DEDataQueryCodeExp(name="PSUSMODULEINSTFUNCNAME", expression="t1.`PSUSMODULEINSTFUNCNAME`", showorder=7), @DEDataQueryCodeExp(name="PSUSMODULEINSTID", expression="t1.`PSUSMODULEINSTID`", showorder=8), @DEDataQueryCodeExp(name="PSUSMODULEINSTNAME", expression="t11.`PSUSMODULEINSTNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="URL", expression="t1.`URL`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.FUNCTAG, t1.FUNCTYPE, t1.MEMO, t1.MOBILEAPPFLAG, t1.PSUSMODULEINSTFUNCID, t1.PSUSMODULEINSTFUNCNAME, t1.PSUSMODULEINSTID, t11.PSUSMODULEINSTNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.URL FROM T_SRFPSUSMODULEINSTFUNC t1  LEFT JOIN T_SRFPSUSMODULEINST t11 ON t1.PSUSMODULEINSTID = t11.PSUSMODULEINSTID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="FUNCTAG", expression="t1.FUNCTAG", showorder=2), @DEDataQueryCodeExp(name="FUNCTYPE", expression="t1.FUNCTYPE", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="MOBILEAPPFLAG", expression="t1.MOBILEAPPFLAG", showorder=5), @DEDataQueryCodeExp(name="PSUSMODULEINSTFUNCID", expression="t1.PSUSMODULEINSTFUNCID", showorder=6), @DEDataQueryCodeExp(name="PSUSMODULEINSTFUNCNAME", expression="t1.PSUSMODULEINSTFUNCNAME", showorder=7), @DEDataQueryCodeExp(name="PSUSMODULEINSTID", expression="t1.PSUSMODULEINSTID", showorder=8), @DEDataQueryCodeExp(name="PSUSMODULEINSTNAME", expression="t11.PSUSMODULEINSTNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="URL", expression="t1.URL", showorder=12)}, conds={})})
public class PSUSModuleInstFuncDefaultDQModel
extends DEDataQueryModelBase {
    public PSUSModuleInstFuncDefaultDQModel() {
        this.initAnnotation(PSUSModuleInstFuncDefaultDQModel.class);
    }
}

