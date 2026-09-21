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
package net.ibizsys.pscore.srv.dedesign.demodel.psdefvrdsparam.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="962632A9-99E3-4017-B095-1FF1604DFF85", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSDEDSPARAMID`, t11.`PSDEDSPARAMNAME`, t1.`PSDEFVRDSPARAMID`, t1.`PSDEFVRDSPARAMNAME`, t1.`PSDEFVRID`, t21.`PSDEFVALUERULENAME` AS `PSDEFVRNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEFVRDSPARAM` t1  LEFT JOIN T_SRFPSDEDSPARAM t11 ON t1.PSDEDSPARAMID = t11.PSDEDSPARAMID  LEFT JOIN T_SRFPSDEFVALUERULE t21 ON t1.PSDEFVRID = t21.PSDEFVALUERULEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSDEDSPARAMID", expression="t1.`PSDEDSPARAMID`", showorder=2), @DEDataQueryCodeExp(name="PSDEDSPARAMNAME", expression="t11.`PSDEDSPARAMNAME`", showorder=3), @DEDataQueryCodeExp(name="PSDEFVRDSPARAMID", expression="t1.`PSDEFVRDSPARAMID`", showorder=4), @DEDataQueryCodeExp(name="PSDEFVRDSPARAMNAME", expression="t1.`PSDEFVRDSPARAMNAME`", showorder=5), @DEDataQueryCodeExp(name="PSDEFVRID", expression="t1.`PSDEFVRID`", showorder=6), @DEDataQueryCodeExp(name="PSDEFVRNAME", expression="t21.`PSDEFVALUERULENAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSDEDSPARAMID, t11.PSDEDSPARAMNAME, t1.PSDEFVRDSPARAMID, t1.PSDEFVRDSPARAMNAME, t1.PSDEFVRID, t21.PSDEFVALUERULENAME AS PSDEFVRNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEFVRDSPARAM t1  LEFT JOIN T_SRFPSDEDSPARAM t11 ON t1.PSDEDSPARAMID = t11.PSDEDSPARAMID  LEFT JOIN T_SRFPSDEFVALUERULE t21 ON t1.PSDEFVRID = t21.PSDEFVALUERULEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSDEDSPARAMID", expression="t1.PSDEDSPARAMID", showorder=2), @DEDataQueryCodeExp(name="PSDEDSPARAMNAME", expression="t11.PSDEDSPARAMNAME", showorder=3), @DEDataQueryCodeExp(name="PSDEFVRDSPARAMID", expression="t1.PSDEFVRDSPARAMID", showorder=4), @DEDataQueryCodeExp(name="PSDEFVRDSPARAMNAME", expression="t1.PSDEFVRDSPARAMNAME", showorder=5), @DEDataQueryCodeExp(name="PSDEFVRID", expression="t1.PSDEFVRID", showorder=6), @DEDataQueryCodeExp(name="PSDEFVRNAME", expression="t21.PSDEFVALUERULENAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSDEFVRDSParamDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEFVRDSParamDefaultDQModel() {
        this.initAnnotation(PSDEFVRDSParamDefaultDQModel.class);
    }
}

