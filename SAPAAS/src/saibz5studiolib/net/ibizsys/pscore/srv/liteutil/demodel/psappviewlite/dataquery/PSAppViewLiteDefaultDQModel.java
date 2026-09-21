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
package net.ibizsys.pscore.srv.liteutil.demodel.psappviewlite.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="E7F592E8-8149-42E0-8D74-D57630CA0C7C", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`PSAPPMODULEID`, t1.`PSAPPVIEWID`, t1.`PSAPPVIEWNAME`, t1.`PSAPPVIEWTYPE`, t11.`PSDEID`, t11.`PSDENAME`, t1.`PSDEVIEWBASEID`, t1.`PSSYSAPPID` FROM `T_SRFPSAPPVIEW` t1  LEFT JOIN T_SRFPSDEVIEWBASE t11 ON t1.PSDEVIEWBASEID = t11.PSDEVIEWBASEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="PSAPPMODULEID", expression="t1.`PSAPPMODULEID`", showorder=0), @DEDataQueryCodeExp(name="PSAPPVIEWID", expression="t1.`PSAPPVIEWID`", showorder=1), @DEDataQueryCodeExp(name="PSAPPVIEWNAME", expression="t1.`PSAPPVIEWNAME`", showorder=2), @DEDataQueryCodeExp(name="PSAPPVIEWTYPE", expression="t1.`PSAPPVIEWTYPE`", showorder=3), @DEDataQueryCodeExp(name="PSDEID", expression="t11.`PSDEID`", showorder=4), @DEDataQueryCodeExp(name="PSDENAME", expression="t11.`PSDENAME`", showorder=5), @DEDataQueryCodeExp(name="PSDEVIEWBASEID", expression="t1.`PSDEVIEWBASEID`", showorder=6), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.`PSSYSAPPID`", showorder=7)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.PSAPPMODULEID, t1.PSAPPVIEWID, t1.PSAPPVIEWNAME, t1.PSAPPVIEWTYPE, t11.PSDEID, t11.PSDENAME, t1.PSDEVIEWBASEID, t1.PSSYSAPPID FROM T_SRFPSAPPVIEW t1  LEFT JOIN T_SRFPSDEVIEWBASE t11 ON t1.PSDEVIEWBASEID = t11.PSDEVIEWBASEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="PSAPPMODULEID", expression="t1.PSAPPMODULEID", showorder=0), @DEDataQueryCodeExp(name="PSAPPVIEWID", expression="t1.PSAPPVIEWID", showorder=1), @DEDataQueryCodeExp(name="PSAPPVIEWNAME", expression="t1.PSAPPVIEWNAME", showorder=2), @DEDataQueryCodeExp(name="PSAPPVIEWTYPE", expression="t1.PSAPPVIEWTYPE", showorder=3), @DEDataQueryCodeExp(name="PSDEID", expression="t11.PSDEID", showorder=4), @DEDataQueryCodeExp(name="PSDENAME", expression="t11.PSDENAME", showorder=5), @DEDataQueryCodeExp(name="PSDEVIEWBASEID", expression="t1.PSDEVIEWBASEID", showorder=6), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.PSSYSAPPID", showorder=7)}, conds={})})
public class PSAppViewLiteDefaultDQModel
extends DEDataQueryModelBase {
    public PSAppViewLiteDefaultDQModel() {
        this.initAnnotation(PSAppViewLiteDefaultDQModel.class);
    }
}

