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
package net.ibizsys.pscore.srv.paasmgr.demodel.pssysmodelinstbk.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="3ECF480B-7B7D-402B-9300-E294A6C77FAE", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`BKFILEPATH`, t1.`BKFILESIZE`, t1.`BKINFO`, t1.`BKSTATE`, t1.`BKTIME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PASSWD`, t1.`PSSYSMODELINSTBKID`, t1.`PSSYSMODELINSTBKNAME`, t1.`PSSYSMODELINSTID`, t1.`PSSYSMODELINSTNAME`, t1.`PSTASKSERVERID`, t1.`PSTASKSERVERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSSYSMODELINSTBK` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="BKFILEPATH", expression="t1.`BKFILEPATH`", showorder=0), @DEDataQueryCodeExp(name="BKFILESIZE", expression="t1.`BKFILESIZE`", showorder=1), @DEDataQueryCodeExp(name="BKINFO", expression="t1.`BKINFO`", showorder=2), @DEDataQueryCodeExp(name="BKSTATE", expression="t1.`BKSTATE`", showorder=3), @DEDataQueryCodeExp(name="BKTIME", expression="t1.`BKTIME`", showorder=4), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=5), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=6), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=7), @DEDataQueryCodeExp(name="PASSWD", expression="t1.`PASSWD`", showorder=8), @DEDataQueryCodeExp(name="PSSYSMODELINSTBKID", expression="t1.`PSSYSMODELINSTBKID`", showorder=9), @DEDataQueryCodeExp(name="PSSYSMODELINSTBKNAME", expression="t1.`PSSYSMODELINSTBKNAME`", showorder=10), @DEDataQueryCodeExp(name="PSSYSMODELINSTID", expression="t1.`PSSYSMODELINSTID`", showorder=11), @DEDataQueryCodeExp(name="PSSYSMODELINSTNAME", expression="t1.`PSSYSMODELINSTNAME`", showorder=12), @DEDataQueryCodeExp(name="PSTASKSERVERID", expression="t1.`PSTASKSERVERID`", showorder=13), @DEDataQueryCodeExp(name="PSTASKSERVERNAME", expression="t1.`PSTASKSERVERNAME`", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=16), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=17)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.BKFILEPATH, t1.BKFILESIZE, t1.BKINFO, t1.BKSTATE, t1.BKTIME, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PASSWD, t1.PSSYSMODELINSTBKID, t1.PSSYSMODELINSTBKNAME, t1.PSSYSMODELINSTID, t1.PSSYSMODELINSTNAME, t1.PSTASKSERVERID, t1.PSTASKSERVERNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSSYSMODELINSTBK t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="BKFILEPATH", expression="t1.BKFILEPATH", showorder=0), @DEDataQueryCodeExp(name="BKFILESIZE", expression="t1.BKFILESIZE", showorder=1), @DEDataQueryCodeExp(name="BKINFO", expression="t1.BKINFO", showorder=2), @DEDataQueryCodeExp(name="BKSTATE", expression="t1.BKSTATE", showorder=3), @DEDataQueryCodeExp(name="BKTIME", expression="t1.BKTIME", showorder=4), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=5), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=6), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=7), @DEDataQueryCodeExp(name="PASSWD", expression="t1.PASSWD", showorder=8), @DEDataQueryCodeExp(name="PSSYSMODELINSTBKID", expression="t1.PSSYSMODELINSTBKID", showorder=9), @DEDataQueryCodeExp(name="PSSYSMODELINSTBKNAME", expression="t1.PSSYSMODELINSTBKNAME", showorder=10), @DEDataQueryCodeExp(name="PSSYSMODELINSTID", expression="t1.PSSYSMODELINSTID", showorder=11), @DEDataQueryCodeExp(name="PSSYSMODELINSTNAME", expression="t1.PSSYSMODELINSTNAME", showorder=12), @DEDataQueryCodeExp(name="PSTASKSERVERID", expression="t1.PSTASKSERVERID", showorder=13), @DEDataQueryCodeExp(name="PSTASKSERVERNAME", expression="t1.PSTASKSERVERNAME", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=16), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=17)}, conds={})})
public class PSSysModelInstBKDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysModelInstBKDefaultDQModel() {
        this.initAnnotation(PSSysModelInstBKDefaultDQModel.class);
    }
}

