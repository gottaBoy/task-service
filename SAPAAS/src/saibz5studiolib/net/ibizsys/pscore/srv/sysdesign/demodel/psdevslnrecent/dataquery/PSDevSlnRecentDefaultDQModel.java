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
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnrecent.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="62635428-F9FF-422F-ACD6-73F19DAE5034", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ORDERVALUE`, t1.`PSDEVSLNID`, t11.`PSDEVSLNNAME`, t1.`PSDEVSLNRECENTID`, t1.`PSDEVSLNRECENTNAME`, t1.`PSDEVUSERID`, t1.`PSDEVUSERNAME`, t1.`PSOBJID`, t1.`PSOBJNAME`, t1.`PSOBJTYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVSLNRECENT` t1  LEFT JOIN T_SRFPSDEVSLN t11 ON t1.PSDEVSLNID = t11.PSDEVSLNID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=2), @DEDataQueryCodeExp(name="PSDEVSLNID", expression="t1.`PSDEVSLNID`", showorder=3), @DEDataQueryCodeExp(name="PSDEVSLNNAME", expression="t11.`PSDEVSLNNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDEVSLNRECENTID", expression="t1.`PSDEVSLNRECENTID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVSLNRECENTNAME", expression="t1.`PSDEVSLNRECENTNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEVUSERID", expression="t1.`PSDEVUSERID`", showorder=7), @DEDataQueryCodeExp(name="PSDEVUSERNAME", expression="t1.`PSDEVUSERNAME`", showorder=8), @DEDataQueryCodeExp(name="PSOBJID", expression="t1.`PSOBJID`", showorder=9), @DEDataQueryCodeExp(name="PSOBJNAME", expression="t1.`PSOBJNAME`", showorder=10), @DEDataQueryCodeExp(name="PSOBJTYPE", expression="t1.`PSOBJTYPE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ORDERVALUE, t1.PSDEVSLNID, t11.PSDEVSLNNAME, t1.PSDEVSLNRECENTID, t1.PSDEVSLNRECENTNAME, t1.PSDEVUSERID, t1.PSDEVUSERNAME, t1.PSOBJID, t1.PSOBJNAME, t1.PSOBJTYPE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVSLNRECENT t1  LEFT JOIN T_SRFPSDEVSLN t11 ON t1.PSDEVSLNID = t11.PSDEVSLNID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=2), @DEDataQueryCodeExp(name="PSDEVSLNID", expression="t1.PSDEVSLNID", showorder=3), @DEDataQueryCodeExp(name="PSDEVSLNNAME", expression="t11.PSDEVSLNNAME", showorder=4), @DEDataQueryCodeExp(name="PSDEVSLNRECENTID", expression="t1.PSDEVSLNRECENTID", showorder=5), @DEDataQueryCodeExp(name="PSDEVSLNRECENTNAME", expression="t1.PSDEVSLNRECENTNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEVUSERID", expression="t1.PSDEVUSERID", showorder=7), @DEDataQueryCodeExp(name="PSDEVUSERNAME", expression="t1.PSDEVUSERNAME", showorder=8), @DEDataQueryCodeExp(name="PSOBJID", expression="t1.PSOBJID", showorder=9), @DEDataQueryCodeExp(name="PSOBJNAME", expression="t1.PSOBJNAME", showorder=10), @DEDataQueryCodeExp(name="PSOBJTYPE", expression="t1.PSOBJTYPE", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSDevSlnRecentDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevSlnRecentDefaultDQModel() {
        this.initAnnotation(PSDevSlnRecentDefaultDQModel.class);
    }
}

