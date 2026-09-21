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
package net.ibizsys.pscore.srv.appdesign.demodel.psmobapppacksession.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="69037394-5222-4116-9A4F-E9C8647A9A81", name="CurSys")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSMOBAPPPACKID`, t11.`PSMOBAPPPACKNAME`, t1.`PSMOBAPPPACKSESSIONID`, t1.`PSMOBAPPPACKSESSIONNAME`, t1.`PSSYSAPPID`, t21.`PSSYSAPPNAME`, t1.`PSSYSTEMID`, t1.`PSSYSTEMNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSMOBAPPPACKSESSION` t1  LEFT JOIN T_SRFPSMOBAPPPACK t11 ON t1.PSMOBAPPPACKID = t11.PSMOBAPPPACKID  LEFT JOIN T_SRFPSSYSAPP t21 ON t1.PSSYSAPPID = t21.PSSYSAPPID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSMOBAPPPACKID", expression="t1.`PSMOBAPPPACKID`", showorder=2), @DEDataQueryCodeExp(name="PSMOBAPPPACKNAME", expression="t11.`PSMOBAPPPACKNAME`", showorder=3), @DEDataQueryCodeExp(name="PSMOBAPPPACKSESSIONID", expression="t1.`PSMOBAPPPACKSESSIONID`", showorder=4), @DEDataQueryCodeExp(name="PSMOBAPPPACKSESSIONNAME", expression="t1.`PSMOBAPPPACKSESSIONNAME`", showorder=5), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.`PSSYSAPPID`", showorder=6), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t21.`PSSYSAPPNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=8), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.`PSSYSTEMNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSSYSTEMID` =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSMOBAPPPACKSESSION\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSMOBAPPPACKID, t11.PSMOBAPPPACKNAME, t1.PSMOBAPPPACKSESSIONID, t1.PSMOBAPPPACKSESSIONNAME, t1.PSSYSAPPID, t21.PSSYSAPPNAME, t1.PSSYSTEMID, t1.PSSYSTEMNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSMOBAPPPACKSESSION t1  LEFT JOIN T_SRFPSMOBAPPPACK t11 ON t1.PSMOBAPPPACKID = t11.PSMOBAPPPACKID  LEFT JOIN T_SRFPSSYSAPP t21 ON t1.PSSYSAPPID = t21.PSSYSAPPID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSMOBAPPPACKID", expression="t1.PSMOBAPPPACKID", showorder=2), @DEDataQueryCodeExp(name="PSMOBAPPPACKNAME", expression="t11.PSMOBAPPPACKNAME", showorder=3), @DEDataQueryCodeExp(name="PSMOBAPPPACKSESSIONID", expression="t1.PSMOBAPPPACKSESSIONID", showorder=4), @DEDataQueryCodeExp(name="PSMOBAPPPACKSESSIONNAME", expression="t1.PSMOBAPPPACKSESSIONNAME", showorder=5), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.PSSYSAPPID", showorder=6), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t21.PSSYSAPPNAME", showorder=7), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=8), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.PSSYSTEMNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={@DEDataQueryCodeCond(condition="( t1.PSSYSTEMID =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSMOBAPPPACKSESSION\"}')} )")})})
public class PSMobAppPackSessionCurSysDQModel
extends DEDataQueryModelBase {
    public PSMobAppPackSessionCurSysDQModel() {
        this.initAnnotation(PSMobAppPackSessionCurSysDQModel.class);
    }
}

