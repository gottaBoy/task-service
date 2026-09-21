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
package net.ibizsys.pscore.srv.config.demodel.psportlettype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="355C1670-B561-4C34-8468-864D1B9C4E35", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENABLE`, t1.`JITCTRLOBJ`, t1.`JITMODELOBJ`, t1.`MEMO`, t1.`PORTLETOBJ`, t1.`PSPORTLETTYPEID`, t1.`PSPORTLETTYPENAME`, t1.`SYSPORTLETFLAG`, t1.`SYSPORTLETOBJ`, t1.`TYPEOBJ`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSPORTLETTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="BASECLSPARAMS", expression="t1.`BASECLSPARAMS`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ENABLE", expression="t1.`ENABLE`", showorder=2), @DEDataQueryCodeExp(name="JITCTRLOBJ", expression="t1.`JITCTRLOBJ`", showorder=3), @DEDataQueryCodeExp(name="JITMODELOBJ", expression="t1.`JITMODELOBJ`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="PORTLETOBJ", expression="t1.`PORTLETOBJ`", showorder=6), @DEDataQueryCodeExp(name="PSPORTLETTYPEID", expression="t1.`PSPORTLETTYPEID`", showorder=7), @DEDataQueryCodeExp(name="PSPORTLETTYPENAME", expression="t1.`PSPORTLETTYPENAME`", showorder=8), @DEDataQueryCodeExp(name="SYSPORTLETFLAG", expression="t1.`SYSPORTLETFLAG`", showorder=9), @DEDataQueryCodeExp(name="SYSPORTLETOBJ", expression="t1.`SYSPORTLETOBJ`", showorder=10), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.`TYPEOBJ`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={@DEDataQueryCodeCond(condition="t1.ENABLE = 1")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENABLE, t1.JITCTRLOBJ, t1.JITMODELOBJ, t1.MEMO, t1.PORTLETOBJ, t1.PSPORTLETTYPEID, t1.PSPORTLETTYPENAME, t1.SYSPORTLETFLAG, t1.SYSPORTLETOBJ, t1.TYPEOBJ, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSPORTLETTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="BASECLSPARAMS", expression="t1.BASECLSPARAMS", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ENABLE", expression="t1.ENABLE", showorder=2), @DEDataQueryCodeExp(name="JITCTRLOBJ", expression="t1.JITCTRLOBJ", showorder=3), @DEDataQueryCodeExp(name="JITMODELOBJ", expression="t1.JITMODELOBJ", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="PORTLETOBJ", expression="t1.PORTLETOBJ", showorder=6), @DEDataQueryCodeExp(name="PSPORTLETTYPEID", expression="t1.PSPORTLETTYPEID", showorder=7), @DEDataQueryCodeExp(name="PSPORTLETTYPENAME", expression="t1.PSPORTLETTYPENAME", showorder=8), @DEDataQueryCodeExp(name="SYSPORTLETFLAG", expression="t1.SYSPORTLETFLAG", showorder=9), @DEDataQueryCodeExp(name="SYSPORTLETOBJ", expression="t1.SYSPORTLETOBJ", showorder=10), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.TYPEOBJ", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={@DEDataQueryCodeCond(condition="t1.ENABLE = 1")})})
public class PSPortletTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSPortletTypeDefaultDQModel() {
        this.initAnnotation(PSPortletTypeDefaultDQModel.class);
    }
}

