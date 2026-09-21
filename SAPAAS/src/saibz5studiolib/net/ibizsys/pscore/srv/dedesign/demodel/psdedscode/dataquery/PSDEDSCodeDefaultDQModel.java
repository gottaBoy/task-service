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
package net.ibizsys.pscore.srv.dedesign.demodel.psdedscode.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="FFB2B02E-A8F1-45D1-9D20-7F410B40D7D0", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DBTYPE`, t1.`MEMO`, t1.`PSDEDATASETID`, t11.`PSDEDATASETNAME`, t1.`PSDEDSCODEID`, t1.`PSDEDSCODENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEDSCODE` t1  LEFT JOIN `T_SRFPSDEDATASET` t11 ON t1.`PSDEDATASETID` = t11.`PSDEDATASETID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="QUERYCODE", expression="t1.`QUERYCODE`", showorder=-1), @DEDataQueryCodeExp(name="USERQUERYCODE", expression="t1.`USERQUERYCODE`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DBTYPE", expression="t1.`DBTYPE`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDEDATASETID", expression="t1.`PSDEDATASETID`", showorder=4), @DEDataQueryCodeExp(name="PSDEDATASETNAME", expression="t11.`PSDEDATASETNAME`", showorder=5), @DEDataQueryCodeExp(name="PSDEDSCODEID", expression="t1.`PSDEDSCODEID`", showorder=6), @DEDataQueryCodeExp(name="PSDEDSCODENAME", expression="t1.`PSDEDSCODENAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DBTYPE, t1.MEMO, t1.PSDEDATASETID, t11.PSDEDATASETNAME, t1.PSDEDSCODEID, t1.PSDEDSCODENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEDSCODE t1  LEFT JOIN T_SRFPSDEDATASET t11 ON t1.PSDEDATASETID = t11.PSDEDATASETID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="QUERYCODE", expression="t1.QUERYCODE", showorder=-1), @DEDataQueryCodeExp(name="USERQUERYCODE", expression="t1.USERQUERYCODE", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DBTYPE", expression="t1.DBTYPE", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDEDATASETID", expression="t1.PSDEDATASETID", showorder=4), @DEDataQueryCodeExp(name="PSDEDATASETNAME", expression="t11.PSDEDATASETNAME", showorder=5), @DEDataQueryCodeExp(name="PSDEDSCODEID", expression="t1.PSDEDSCODEID", showorder=6), @DEDataQueryCodeExp(name="PSDEDSCODENAME", expression="t1.PSDEDSCODENAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSDEDSCodeDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEDSCodeDefaultDQModel() {
        this.initAnnotation(PSDEDSCodeDefaultDQModel.class);
    }
}

