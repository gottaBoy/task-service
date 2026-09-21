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
package net.ibizsys.pscore.srv.dynasys.demodel.psdynadeforminst.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="BB052854-5C04-4AFF-B4D7-F6A47CC8BF87", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEFORMID`, t1.`PSDEFORMNAME`, t1.`PSDYNADEFORMID`, t1.`PSDYNADEFORMINSTID`, t1.`PSDYNADEFORMINSTNAME`, t11.`PSDYNADEFORMNAME`, t1.`PSDYNAINSTID`, t1.`PSDYNAINSTNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDYNADEFORMINST` t1  LEFT JOIN T_SRFPSDYNADEFORM t11 ON t1.PSDYNADEFORMID = t11.PSDYNADEFORMID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEFORMID", expression="t1.`PSDEFORMID`", showorder=3), @DEDataQueryCodeExp(name="PSDEFORMNAME", expression="t1.`PSDEFORMNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDYNADEFORMID", expression="t1.`PSDYNADEFORMID`", showorder=5), @DEDataQueryCodeExp(name="PSDYNADEFORMINSTID", expression="t1.`PSDYNADEFORMINSTID`", showorder=6), @DEDataQueryCodeExp(name="PSDYNADEFORMINSTNAME", expression="t1.`PSDYNADEFORMINSTNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDYNADEFORMNAME", expression="t11.`PSDYNADEFORMNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.`PSDYNAINSTID`", showorder=9), @DEDataQueryCodeExp(name="PSDYNAINSTNAME", expression="t1.`PSDYNAINSTNAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEFORMID, t1.PSDEFORMNAME, t1.PSDYNADEFORMID, t1.PSDYNADEFORMINSTID, t1.PSDYNADEFORMINSTNAME, t11.PSDYNADEFORMNAME, t1.PSDYNAINSTID, t1.PSDYNAINSTNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDYNADEFORMINST t1  LEFT JOIN T_SRFPSDYNADEFORM t11 ON t1.PSDYNADEFORMID = t11.PSDYNADEFORMID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEFORMID", expression="t1.PSDEFORMID", showorder=3), @DEDataQueryCodeExp(name="PSDEFORMNAME", expression="t1.PSDEFORMNAME", showorder=4), @DEDataQueryCodeExp(name="PSDYNADEFORMID", expression="t1.PSDYNADEFORMID", showorder=5), @DEDataQueryCodeExp(name="PSDYNADEFORMINSTID", expression="t1.PSDYNADEFORMINSTID", showorder=6), @DEDataQueryCodeExp(name="PSDYNADEFORMINSTNAME", expression="t1.PSDYNADEFORMINSTNAME", showorder=7), @DEDataQueryCodeExp(name="PSDYNADEFORMNAME", expression="t11.PSDYNADEFORMNAME", showorder=8), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.PSDYNAINSTID", showorder=9), @DEDataQueryCodeExp(name="PSDYNAINSTNAME", expression="t1.PSDYNAINSTNAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSDynaDEFormInstDefaultDQModel
extends DEDataQueryModelBase {
    public PSDynaDEFormInstDefaultDQModel() {
        this.initAnnotation(PSDynaDEFormInstDefaultDQModel.class);
    }
}

