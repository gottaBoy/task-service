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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnhost.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="0073CF20-FEF4-4E6E-820A-682B4E4B920F", name="CurSln")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`IPADDR`, t1.`MEMO`, t1.`PSDEPSLNHOSTID`, t1.`PSDEPSLNHOSTNAME`, t1.`PSDEPSLNID`, t11.`PSDEPSLNNAME`, t1.`PWD`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERNAME` FROM `T_SRFPSDEPSLNHOST` t1  LEFT JOIN T_SRFPSDEPSLN t11 ON t1.PSDEPSLNID = t11.PSDEPSLNID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="IPADDR", expression="t1.`IPADDR`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDEPSLNHOSTID", expression="t1.`PSDEPSLNHOSTID`", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNHOSTNAME", expression="t1.`PSDEPSLNHOSTNAME`", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.`PSDEPSLNID`", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t11.`PSDEPSLNNAME`", showorder=7), @DEDataQueryCodeExp(name="PWD", expression="t1.`PWD`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="USERNAME", expression="t1.`USERNAME`", showorder=11)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSDEPSLNID` =  ${srfdatacontext('psdepslnid','{\"defname\":\"PSDEPSLNID\",\"dename\":\"PSDEPSLNHOST\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.IPADDR, t1.MEMO, t1.PSDEPSLNHOSTID, t1.PSDEPSLNHOSTNAME, t1.PSDEPSLNID, t11.PSDEPSLNNAME, t1.PWD, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERNAME FROM T_SRFPSDEPSLNHOST t1  LEFT JOIN T_SRFPSDEPSLN t11 ON t1.PSDEPSLNID = t11.PSDEPSLNID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="IPADDR", expression="t1.IPADDR", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDEPSLNHOSTID", expression="t1.PSDEPSLNHOSTID", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNHOSTNAME", expression="t1.PSDEPSLNHOSTNAME", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.PSDEPSLNID", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t11.PSDEPSLNNAME", showorder=7), @DEDataQueryCodeExp(name="PWD", expression="t1.PWD", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="USERNAME", expression="t1.USERNAME", showorder=11)}, conds={@DEDataQueryCodeCond(condition="( t1.PSDEPSLNID =  ${srfdatacontext('psdepslnid','{\"defname\":\"PSDEPSLNID\",\"dename\":\"PSDEPSLNHOST\"}')} )")})})
public class PSDepSlnHostCurSlnDQModel
extends DEDataQueryModelBase {
    public PSDepSlnHostCurSlnDQModel() {
        this.initAnnotation(PSDepSlnHostCurSlnDQModel.class);
    }
}

