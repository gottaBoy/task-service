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
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevprdver.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="276BE966-09FD-4F8E-873A-45A65250DF3D", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`CURISSUESN`, t1.`CURSPECSN`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PPSDEVPRDVERID`, t11.`PSDEVPRDVERNAME` AS `PPSDEVPRDVERNAME`, t1.`PSDEVPRDID`, t21.`PSDEVPRDNAME`, t1.`PSDEVPRDVERID`, t1.`PSDEVPRDVERNAME`, t1.`STARTISSUESN`, t1.`STARTSPECSN`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDEVPRDVER` t1  LEFT JOIN T_SRFPSDEVPRDVER t11 ON t1.PPSDEVPRDVERID = t11.PSDEVPRDVERID  LEFT JOIN T_SRFPSDEVPRD t21 ON t1.PSDEVPRDID = t21.PSDEVPRDID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="CURISSUESN", expression="t1.`CURISSUESN`", showorder=2), @DEDataQueryCodeExp(name="CURSPECSN", expression="t1.`CURSPECSN`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=5), @DEDataQueryCodeExp(name="PPSDEVPRDVERID", expression="t1.`PPSDEVPRDVERID`", showorder=6), @DEDataQueryCodeExp(name="PPSDEVPRDVERNAME", expression="t11.`PSDEVPRDVERNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDEVPRDID", expression="t1.`PSDEVPRDID`", showorder=8), @DEDataQueryCodeExp(name="PSDEVPRDNAME", expression="t21.`PSDEVPRDNAME`", showorder=9), @DEDataQueryCodeExp(name="PSDEVPRDVERID", expression="t1.`PSDEVPRDVERID`", showorder=10), @DEDataQueryCodeExp(name="PSDEVPRDVERNAME", expression="t1.`PSDEVPRDVERNAME`", showorder=11), @DEDataQueryCodeExp(name="STARTISSUESN", expression="t1.`STARTISSUESN`", showorder=12), @DEDataQueryCodeExp(name="STARTSPECSN", expression="t1.`STARTSPECSN`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=16)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.CURISSUESN, t1.CURSPECSN, t1.MEMO, t1.ORDERVALUE, t1.PPSDEVPRDVERID, t11.PSDEVPRDVERNAME AS PPSDEVPRDVERNAME, t1.PSDEVPRDID, t21.PSDEVPRDNAME, t1.PSDEVPRDVERID, t1.PSDEVPRDVERNAME, t1.STARTISSUESN, t1.STARTSPECSN, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDEVPRDVER t1  LEFT JOIN T_SRFPSDEVPRDVER t11 ON t1.PPSDEVPRDVERID = t11.PSDEVPRDVERID  LEFT JOIN T_SRFPSDEVPRD t21 ON t1.PSDEVPRDID = t21.PSDEVPRDID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="CURISSUESN", expression="t1.CURISSUESN", showorder=2), @DEDataQueryCodeExp(name="CURSPECSN", expression="t1.CURSPECSN", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=5), @DEDataQueryCodeExp(name="PPSDEVPRDVERID", expression="t1.PPSDEVPRDVERID", showorder=6), @DEDataQueryCodeExp(name="PPSDEVPRDVERNAME", expression="t11.PSDEVPRDVERNAME", showorder=7), @DEDataQueryCodeExp(name="PSDEVPRDID", expression="t1.PSDEVPRDID", showorder=8), @DEDataQueryCodeExp(name="PSDEVPRDNAME", expression="t21.PSDEVPRDNAME", showorder=9), @DEDataQueryCodeExp(name="PSDEVPRDVERID", expression="t1.PSDEVPRDVERID", showorder=10), @DEDataQueryCodeExp(name="PSDEVPRDVERNAME", expression="t1.PSDEVPRDVERNAME", showorder=11), @DEDataQueryCodeExp(name="STARTISSUESN", expression="t1.STARTISSUESN", showorder=12), @DEDataQueryCodeExp(name="STARTSPECSN", expression="t1.STARTSPECSN", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=16)}, conds={})})
public class PSDevPrdVerDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevPrdVerDefaultDQModel() {
        this.initAnnotation(PSDevPrdVerDefaultDQModel.class);
    }
}

