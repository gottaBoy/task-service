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
package net.ibizsys.pscore.srv.dedesign.demodel.psdeviewgrpdetail.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="B59A186A-DDBE-4998-841E-7F87F61B2234", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEVIEWBASEID`, t11.`PSDEVIEWBASENAME`, t1.`PSDEVIEWGROUPID`, t21.`PSDEVIEWGROUPNAME`, t1.`PSDEVIEWGRPDETAILID`, t1.`PSDEVIEWGRPDETAILNAME`, t1.`REFMODE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDEVIEWGRPDETAIL` t1  LEFT JOIN T_SRFPSDEVIEWBASE t11 ON t1.PSDEVIEWBASEID = t11.PSDEVIEWBASEID  LEFT JOIN T_SRFPSDEVIEWGROUP t21 ON t1.PSDEVIEWGROUPID = t21.PSDEVIEWGROUPID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEVIEWBASEID", expression="t1.`PSDEVIEWBASEID`", showorder=3), @DEDataQueryCodeExp(name="PSDEVIEWBASENAME", expression="t11.`PSDEVIEWBASENAME`", showorder=4), @DEDataQueryCodeExp(name="PSDEVIEWGROUPID", expression="t1.`PSDEVIEWGROUPID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVIEWGROUPNAME", expression="t21.`PSDEVIEWGROUPNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEVIEWGRPDETAILID", expression="t1.`PSDEVIEWGRPDETAILID`", showorder=7), @DEDataQueryCodeExp(name="PSDEVIEWGRPDETAILNAME", expression="t1.`PSDEVIEWGRPDETAILNAME`", showorder=8), @DEDataQueryCodeExp(name="REFMODE", expression="t1.`REFMODE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEVIEWBASEID, t11.PSDEVIEWBASENAME, t1.PSDEVIEWGROUPID, t21.PSDEVIEWGROUPNAME, t1.PSDEVIEWGRPDETAILID, t1.PSDEVIEWGRPDETAILNAME, t1.REFMODE, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDEVIEWGRPDETAIL t1  LEFT JOIN T_SRFPSDEVIEWBASE t11 ON t1.PSDEVIEWBASEID = t11.PSDEVIEWBASEID  LEFT JOIN T_SRFPSDEVIEWGROUP t21 ON t1.PSDEVIEWGROUPID = t21.PSDEVIEWGROUPID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEVIEWBASEID", expression="t1.PSDEVIEWBASEID", showorder=3), @DEDataQueryCodeExp(name="PSDEVIEWBASENAME", expression="t11.PSDEVIEWBASENAME", showorder=4), @DEDataQueryCodeExp(name="PSDEVIEWGROUPID", expression="t1.PSDEVIEWGROUPID", showorder=5), @DEDataQueryCodeExp(name="PSDEVIEWGROUPNAME", expression="t21.PSDEVIEWGROUPNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEVIEWGRPDETAILID", expression="t1.PSDEVIEWGRPDETAILID", showorder=7), @DEDataQueryCodeExp(name="PSDEVIEWGRPDETAILNAME", expression="t1.PSDEVIEWGRPDETAILNAME", showorder=8), @DEDataQueryCodeExp(name="REFMODE", expression="t1.REFMODE", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12)}, conds={})})
public class PSDEViewGrpDetailDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEViewGrpDetailDefaultDQModel() {
        this.initAnnotation(PSDEViewGrpDetailDefaultDQModel.class);
    }
}

