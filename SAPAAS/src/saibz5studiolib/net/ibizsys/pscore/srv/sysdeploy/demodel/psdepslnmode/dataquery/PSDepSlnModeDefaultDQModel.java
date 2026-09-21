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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnmode.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="D6970583-C246-41B7-9C1F-9EDFA15D1D2F", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEPSLNID`, t1.`PSDEPSLNMODEID`, t1.`PSDEPSLNMODENAME`, t11.`PSDEPSLNNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEPSLNMODE` t1  LEFT JOIN T_SRFPSDEPSLN t11 ON t1.PSDEPSLNID = t11.PSDEPSLNID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.`PSDEPSLNID`", showorder=3), @DEDataQueryCodeExp(name="PSDEPSLNMODEID", expression="t1.`PSDEPSLNMODEID`", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNMODENAME", expression="t1.`PSDEPSLNMODENAME`", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t11.`PSDEPSLNNAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEPSLNID, t1.PSDEPSLNMODEID, t1.PSDEPSLNMODENAME, t11.PSDEPSLNNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEPSLNMODE t1  LEFT JOIN T_SRFPSDEPSLN t11 ON t1.PSDEPSLNID = t11.PSDEPSLNID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.PSDEPSLNID", showorder=3), @DEDataQueryCodeExp(name="PSDEPSLNMODEID", expression="t1.PSDEPSLNMODEID", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNMODENAME", expression="t1.PSDEPSLNMODENAME", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t11.PSDEPSLNNAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8)}, conds={})})
public class PSDepSlnModeDefaultDQModel
extends DEDataQueryModelBase {
    public PSDepSlnModeDefaultDQModel() {
        this.initAnnotation(PSDepSlnModeDefaultDQModel.class);
    }
}

