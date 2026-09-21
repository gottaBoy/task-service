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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnrunlog.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="25579184-59E4-48F2-ABA9-50C15947D162", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOGINFO`, t1.`LOGLEVEL`, t1.`LOGLEVEL2`, t1.`LOGTIME`, t1.`PSDEPSLNASID`, t1.`PSDEPSLNASNAME`, t1.`PSDEPSLNID`, t1.`PSDEPSLNMODEID`, t1.`PSDEPSLNMODENAME`, t1.`PSDEPSLNNAME`, t1.`PSDEPSLNPRDID`, t1.`PSDEPSLNPRDNAME`, t1.`PSDEPSLNRUNLOGID`, t1.`PSDEPSLNRUNLOGNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEPSLNRUNLOG` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="LOGINFO2", expression="t1.`LOGINFO2`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="LOGINFO", expression="t1.`LOGINFO`", showorder=2), @DEDataQueryCodeExp(name="LOGLEVEL", expression="t1.`LOGLEVEL`", showorder=3), @DEDataQueryCodeExp(name="LOGLEVEL2", expression="t1.`LOGLEVEL2`", showorder=4), @DEDataQueryCodeExp(name="LOGTIME", expression="t1.`LOGTIME`", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNASID", expression="t1.`PSDEPSLNASID`", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNASNAME", expression="t1.`PSDEPSLNASNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.`PSDEPSLNID`", showorder=8), @DEDataQueryCodeExp(name="PSDEPSLNMODEID", expression="t1.`PSDEPSLNMODEID`", showorder=9), @DEDataQueryCodeExp(name="PSDEPSLNMODENAME", expression="t1.`PSDEPSLNMODENAME`", showorder=10), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t1.`PSDEPSLNNAME`", showorder=11), @DEDataQueryCodeExp(name="PSDEPSLNPRDID", expression="t1.`PSDEPSLNPRDID`", showorder=12), @DEDataQueryCodeExp(name="PSDEPSLNPRDNAME", expression="t1.`PSDEPSLNPRDNAME`", showorder=13), @DEDataQueryCodeExp(name="PSDEPSLNRUNLOGID", expression="t1.`PSDEPSLNRUNLOGID`", showorder=14), @DEDataQueryCodeExp(name="PSDEPSLNRUNLOGNAME", expression="t1.`PSDEPSLNRUNLOGNAME`", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=17)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.LOGINFO, t1.LOGLEVEL, t1.LOGLEVEL2, t1.LOGTIME, t1.PSDEPSLNASID, t1.PSDEPSLNASNAME, t1.PSDEPSLNID, t1.PSDEPSLNMODEID, t1.PSDEPSLNMODENAME, t1.PSDEPSLNNAME, t1.PSDEPSLNPRDID, t1.PSDEPSLNPRDNAME, t1.PSDEPSLNRUNLOGID, t1.PSDEPSLNRUNLOGNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEPSLNRUNLOG t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="LOGINFO2", expression="t1.LOGINFO2", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="LOGINFO", expression="t1.LOGINFO", showorder=2), @DEDataQueryCodeExp(name="LOGLEVEL", expression="t1.LOGLEVEL", showorder=3), @DEDataQueryCodeExp(name="LOGLEVEL2", expression="t1.LOGLEVEL2", showorder=4), @DEDataQueryCodeExp(name="LOGTIME", expression="t1.LOGTIME", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNASID", expression="t1.PSDEPSLNASID", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNASNAME", expression="t1.PSDEPSLNASNAME", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.PSDEPSLNID", showorder=8), @DEDataQueryCodeExp(name="PSDEPSLNMODEID", expression="t1.PSDEPSLNMODEID", showorder=9), @DEDataQueryCodeExp(name="PSDEPSLNMODENAME", expression="t1.PSDEPSLNMODENAME", showorder=10), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t1.PSDEPSLNNAME", showorder=11), @DEDataQueryCodeExp(name="PSDEPSLNPRDID", expression="t1.PSDEPSLNPRDID", showorder=12), @DEDataQueryCodeExp(name="PSDEPSLNPRDNAME", expression="t1.PSDEPSLNPRDNAME", showorder=13), @DEDataQueryCodeExp(name="PSDEPSLNRUNLOGID", expression="t1.PSDEPSLNRUNLOGID", showorder=14), @DEDataQueryCodeExp(name="PSDEPSLNRUNLOGNAME", expression="t1.PSDEPSLNRUNLOGNAME", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=17)}, conds={})})
public class PSDepSlnRunLogDefaultDQModel
extends DEDataQueryModelBase {
    public PSDepSlnRunLogDefaultDQModel() {
        this.initAnnotation(PSDepSlnRunLogDefaultDQModel.class);
    }
}

