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
package net.ibizsys.pscore.srv.paasmgr.demodel.psdbdevinstbk.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="257EFA1F-152A-4B62-865E-B6725A578FA3", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`BKFILEPATH`, t1.`BKFILESIZE`, t1.`BKINFO`, t1.`BKMODE`, t1.`BKSTATE`, t1.`BKTIME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PASSWD`, t1.`PSDBDEVINSTBKID`, t1.`PSDBDEVINSTBKNAME`, t1.`PSDBDEVINSTID`, t1.`PSDBDEVINSTNAME`, t1.`PSTASKSERVERID`, t1.`PSTASKSERVERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDBDEVINSTBK` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="BKFILEPATH", expression="t1.`BKFILEPATH`", showorder=0), @DEDataQueryCodeExp(name="BKFILESIZE", expression="t1.`BKFILESIZE`", showorder=1), @DEDataQueryCodeExp(name="BKINFO", expression="t1.`BKINFO`", showorder=2), @DEDataQueryCodeExp(name="BKMODE", expression="t1.`BKMODE`", showorder=3), @DEDataQueryCodeExp(name="BKSTATE", expression="t1.`BKSTATE`", showorder=4), @DEDataQueryCodeExp(name="BKTIME", expression="t1.`BKTIME`", showorder=5), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=6), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=7), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=8), @DEDataQueryCodeExp(name="PASSWD", expression="t1.`PASSWD`", showorder=9), @DEDataQueryCodeExp(name="PSDBDEVINSTBKID", expression="t1.`PSDBDEVINSTBKID`", showorder=10), @DEDataQueryCodeExp(name="PSDBDEVINSTBKNAME", expression="t1.`PSDBDEVINSTBKNAME`", showorder=11), @DEDataQueryCodeExp(name="PSDBDEVINSTID", expression="t1.`PSDBDEVINSTID`", showorder=12), @DEDataQueryCodeExp(name="PSDBDEVINSTNAME", expression="t1.`PSDBDEVINSTNAME`", showorder=13), @DEDataQueryCodeExp(name="PSTASKSERVERID", expression="t1.`PSTASKSERVERID`", showorder=14), @DEDataQueryCodeExp(name="PSTASKSERVERNAME", expression="t1.`PSTASKSERVERNAME`", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=18)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.BKFILEPATH, t1.BKFILESIZE, t1.BKINFO, t1.BKMODE, t1.BKSTATE, t1.BKTIME, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PASSWD, t1.PSDBDEVINSTBKID, t1.PSDBDEVINSTBKNAME, t1.PSDBDEVINSTID, t1.PSDBDEVINSTNAME, t1.PSTASKSERVERID, t1.PSTASKSERVERNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDBDEVINSTBK t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="BKFILEPATH", expression="t1.BKFILEPATH", showorder=0), @DEDataQueryCodeExp(name="BKFILESIZE", expression="t1.BKFILESIZE", showorder=1), @DEDataQueryCodeExp(name="BKINFO", expression="t1.BKINFO", showorder=2), @DEDataQueryCodeExp(name="BKMODE", expression="t1.BKMODE", showorder=3), @DEDataQueryCodeExp(name="BKSTATE", expression="t1.BKSTATE", showorder=4), @DEDataQueryCodeExp(name="BKTIME", expression="t1.BKTIME", showorder=5), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=6), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=7), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=8), @DEDataQueryCodeExp(name="PASSWD", expression="t1.PASSWD", showorder=9), @DEDataQueryCodeExp(name="PSDBDEVINSTBKID", expression="t1.PSDBDEVINSTBKID", showorder=10), @DEDataQueryCodeExp(name="PSDBDEVINSTBKNAME", expression="t1.PSDBDEVINSTBKNAME", showorder=11), @DEDataQueryCodeExp(name="PSDBDEVINSTID", expression="t1.PSDBDEVINSTID", showorder=12), @DEDataQueryCodeExp(name="PSDBDEVINSTNAME", expression="t1.PSDBDEVINSTNAME", showorder=13), @DEDataQueryCodeExp(name="PSTASKSERVERID", expression="t1.PSTASKSERVERID", showorder=14), @DEDataQueryCodeExp(name="PSTASKSERVERNAME", expression="t1.PSTASKSERVERNAME", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=18)}, conds={})})
public class PSDBDevInstBKDefaultDQModel
extends DEDataQueryModelBase {
    public PSDBDevInstBKDefaultDQModel() {
        this.initAnnotation(PSDBDevInstBKDefaultDQModel.class);
    }
}

