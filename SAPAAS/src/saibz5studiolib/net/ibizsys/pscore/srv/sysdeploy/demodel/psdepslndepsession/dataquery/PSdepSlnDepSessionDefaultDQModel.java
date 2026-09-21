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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslndepsession.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="A07C6133-A2C9-4EB8-B298-7989F203965F", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`BEGINTIME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEPSTATE`, t1.`ENDTIME`, t1.`MEMO`, t1.`PSDEPSLNDEPSESSIONID`, t1.`PSDEPSLNDEPSESSIONNAME`, t1.`PSDEPSLNID`, t11.`PSDEPSLNNAME`, t1.`PSDEPSLNPACKID`, t21.`PSDEPSLNPACKNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEPSLNDEPSESSION` t1  LEFT JOIN T_SRFPSDEPSLN t11 ON t1.PSDEPSLNID = t11.PSDEPSLNID  LEFT JOIN T_SRFPSDEPSLNPACK t21 ON t1.PSDEPSLNPACKID = t21.PSDEPSLNPACKID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="DEPINFO", expression="t1.`DEPINFO`", showorder=-1), @DEDataQueryCodeExp(name="BEGINTIME", expression="t1.`BEGINTIME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="DEPSTATE", expression="t1.`DEPSTATE`", showorder=3), @DEDataQueryCodeExp(name="ENDTIME", expression="t1.`ENDTIME`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNDEPSESSIONID", expression="t1.`PSDEPSLNDEPSESSIONID`", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNDEPSESSIONNAME", expression="t1.`PSDEPSLNDEPSESSIONNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.`PSDEPSLNID`", showorder=8), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t11.`PSDEPSLNNAME`", showorder=9), @DEDataQueryCodeExp(name="PSDEPSLNPACKID", expression="t1.`PSDEPSLNPACKID`", showorder=10), @DEDataQueryCodeExp(name="PSDEPSLNPACKNAME", expression="t21.`PSDEPSLNPACKNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.BEGINTIME, t1.CREATEDATE, t1.CREATEMAN, t1.DEPSTATE, t1.ENDTIME, t1.MEMO, t1.PSDEPSLNDEPSESSIONID, t1.PSDEPSLNDEPSESSIONNAME, t1.PSDEPSLNID, t11.PSDEPSLNNAME, t1.PSDEPSLNPACKID, t21.PSDEPSLNPACKNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEPSLNDEPSESSION t1  LEFT JOIN T_SRFPSDEPSLN t11 ON t1.PSDEPSLNID = t11.PSDEPSLNID  LEFT JOIN T_SRFPSDEPSLNPACK t21 ON t1.PSDEPSLNPACKID = t21.PSDEPSLNPACKID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="DEPINFO", expression="t1.DEPINFO", showorder=-1), @DEDataQueryCodeExp(name="BEGINTIME", expression="t1.BEGINTIME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="DEPSTATE", expression="t1.DEPSTATE", showorder=3), @DEDataQueryCodeExp(name="ENDTIME", expression="t1.ENDTIME", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNDEPSESSIONID", expression="t1.PSDEPSLNDEPSESSIONID", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNDEPSESSIONNAME", expression="t1.PSDEPSLNDEPSESSIONNAME", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.PSDEPSLNID", showorder=8), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t11.PSDEPSLNNAME", showorder=9), @DEDataQueryCodeExp(name="PSDEPSLNPACKID", expression="t1.PSDEPSLNPACKID", showorder=10), @DEDataQueryCodeExp(name="PSDEPSLNPACKNAME", expression="t21.PSDEPSLNPACKNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSdepSlnDepSessionDefaultDQModel
extends DEDataQueryModelBase {
    public PSdepSlnDepSessionDefaultDQModel() {
        this.initAnnotation(PSdepSlnDepSessionDefaultDQModel.class);
    }
}

