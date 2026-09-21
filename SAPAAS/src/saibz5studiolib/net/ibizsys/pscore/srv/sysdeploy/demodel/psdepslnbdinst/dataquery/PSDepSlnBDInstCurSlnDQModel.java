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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnbdinst.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="637F0CDC-8C5C-401B-8059-E6EA1833F10F", name="CurSln")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDCBDINSTID`, t11.`PSDCBDINSTNAME`, t1.`PSDEPSLNBDINSTID`, t1.`PSDEPSLNBDINSTNAME`, t1.`PSDEPSLNID`, t21.`PSDEPSLNNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDEPSLNBDINST` t1  LEFT JOIN T_SRFPSDCBDINST t11 ON t1.PSDCBDINSTID = t11.PSDCBDINSTID  LEFT JOIN T_SRFPSDEPSLN t21 ON t1.PSDEPSLNID = t21.PSDEPSLNID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDCBDINSTID", expression="t1.`PSDCBDINSTID`", showorder=3), @DEDataQueryCodeExp(name="PSDCBDINSTNAME", expression="t11.`PSDCBDINSTNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNBDINSTID", expression="t1.`PSDEPSLNBDINSTID`", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNBDINSTNAME", expression="t1.`PSDEPSLNBDINSTNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.`PSDEPSLNID`", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t21.`PSDEPSLNNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=11)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSDEPSLNID` =  ${srfdatacontext('psdepslnid','{\"defname\":\"PSDEPSLNID\",\"dename\":\"PSDEPSLNBDINST\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDCBDINSTID, t11.PSDCBDINSTNAME, t1.PSDEPSLNBDINSTID, t1.PSDEPSLNBDINSTNAME, t1.PSDEPSLNID, t21.PSDEPSLNNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDEPSLNBDINST t1  LEFT JOIN T_SRFPSDCBDINST t11 ON t1.PSDCBDINSTID = t11.PSDCBDINSTID  LEFT JOIN T_SRFPSDEPSLN t21 ON t1.PSDEPSLNID = t21.PSDEPSLNID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDCBDINSTID", expression="t1.PSDCBDINSTID", showorder=3), @DEDataQueryCodeExp(name="PSDCBDINSTNAME", expression="t11.PSDCBDINSTNAME", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNBDINSTID", expression="t1.PSDEPSLNBDINSTID", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNBDINSTNAME", expression="t1.PSDEPSLNBDINSTNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.PSDEPSLNID", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t21.PSDEPSLNNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=11)}, conds={@DEDataQueryCodeCond(condition="( t1.PSDEPSLNID =  ${srfdatacontext('psdepslnid','{\"defname\":\"PSDEPSLNID\",\"dename\":\"PSDEPSLNBDINST\"}')} )")})})
public class PSDepSlnBDInstCurSlnDQModel
extends DEDataQueryModelBase {
    public PSDepSlnBDInstCurSlnDQModel() {
        this.initAnnotation(PSDepSlnBDInstCurSlnDQModel.class);
    }
}

