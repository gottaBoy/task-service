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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysrefde.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="4BB0F4BC-5CB2-4351-960C-4A76E28BE2C6", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOGICNAME`, t1.`MEMO`, t1.`ORIPSDEID`, t1.`PSSYSREFDEID`, t1.`PSSYSREFDENAME`, t1.`PSSYSREFID`, t11.`PSSYSREFNAME`, t1.`SERVICECLS`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSYSREFDE` t1  LEFT JOIN T_SRFPSSYSREF t11 ON t1.PSSYSREFID = t11.PSSYSREFID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.`LOGICNAME`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="ORIPSDEID", expression="t1.`ORIPSDEID`", showorder=4), @DEDataQueryCodeExp(name="PSSYSREFDEID", expression="t1.`PSSYSREFDEID`", showorder=5), @DEDataQueryCodeExp(name="PSSYSREFDENAME", expression="t1.`PSSYSREFDENAME`", showorder=6), @DEDataQueryCodeExp(name="PSSYSREFID", expression="t1.`PSSYSREFID`", showorder=7), @DEDataQueryCodeExp(name="PSSYSREFNAME", expression="t11.`PSSYSREFNAME`", showorder=8), @DEDataQueryCodeExp(name="SERVICECLS", expression="t1.`SERVICECLS`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.LOGICNAME, t1.MEMO, t1.ORIPSDEID, t1.PSSYSREFDEID, t1.PSSYSREFDENAME, t1.PSSYSREFID, t11.PSSYSREFNAME, t1.SERVICECLS, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSYSREFDE t1  LEFT JOIN T_SRFPSSYSREF t11 ON t1.PSSYSREFID = t11.PSSYSREFID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.LOGICNAME", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="ORIPSDEID", expression="t1.ORIPSDEID", showorder=4), @DEDataQueryCodeExp(name="PSSYSREFDEID", expression="t1.PSSYSREFDEID", showorder=5), @DEDataQueryCodeExp(name="PSSYSREFDENAME", expression="t1.PSSYSREFDENAME", showorder=6), @DEDataQueryCodeExp(name="PSSYSREFID", expression="t1.PSSYSREFID", showorder=7), @DEDataQueryCodeExp(name="PSSYSREFNAME", expression="t11.PSSYSREFNAME", showorder=8), @DEDataQueryCodeExp(name="SERVICECLS", expression="t1.SERVICECLS", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSSysRefDEDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysRefDEDefaultDQModel() {
        this.initAnnotation(PSSysRefDEDefaultDQModel.class);
    }
}

