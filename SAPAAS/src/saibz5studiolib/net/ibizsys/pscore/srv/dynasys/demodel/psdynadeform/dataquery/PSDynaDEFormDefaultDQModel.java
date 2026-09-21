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
package net.ibizsys.pscore.srv.dynasys.demodel.psdynadeform.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="F1830B1A-B893-4FB6-A7A1-43E67CDACBB5", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEFORMID`, t11.`PSDEFORMNAME`, t1.`PSDYNADEFORMID`, t1.`PSDYNADEFORMNAME`, t1.`PSDYNADEID`, t21.`PSDYNADENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDYNADEFORM` t1  LEFT JOIN T_SRFPSDEFORM t11 ON t1.PSDEFORMID = t11.PSDEFORMID  LEFT JOIN T_SRFPSDYNADE t21 ON t1.PSDYNADEID = t21.PSDYNADEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEFORMID", expression="t1.`PSDEFORMID`", showorder=3), @DEDataQueryCodeExp(name="PSDEFORMNAME", expression="t11.`PSDEFORMNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDYNADEFORMID", expression="t1.`PSDYNADEFORMID`", showorder=5), @DEDataQueryCodeExp(name="PSDYNADEFORMNAME", expression="t1.`PSDYNADEFORMNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDYNADEID", expression="t1.`PSDYNADEID`", showorder=7), @DEDataQueryCodeExp(name="PSDYNADENAME", expression="t21.`PSDYNADENAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEFORMID, t11.PSDEFORMNAME, t1.PSDYNADEFORMID, t1.PSDYNADEFORMNAME, t1.PSDYNADEID, t21.PSDYNADENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDYNADEFORM t1  LEFT JOIN T_SRFPSDEFORM t11 ON t1.PSDEFORMID = t11.PSDEFORMID  LEFT JOIN T_SRFPSDYNADE t21 ON t1.PSDYNADEID = t21.PSDYNADEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEFORMID", expression="t1.PSDEFORMID", showorder=3), @DEDataQueryCodeExp(name="PSDEFORMNAME", expression="t11.PSDEFORMNAME", showorder=4), @DEDataQueryCodeExp(name="PSDYNADEFORMID", expression="t1.PSDYNADEFORMID", showorder=5), @DEDataQueryCodeExp(name="PSDYNADEFORMNAME", expression="t1.PSDYNADEFORMNAME", showorder=6), @DEDataQueryCodeExp(name="PSDYNADEID", expression="t1.PSDYNADEID", showorder=7), @DEDataQueryCodeExp(name="PSDYNADENAME", expression="t21.PSDYNADENAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10)}, conds={})})
public class PSDynaDEFormDefaultDQModel
extends DEDataQueryModelBase {
    public PSDynaDEFormDefaultDQModel() {
        this.initAnnotation(PSDynaDEFormDefaultDQModel.class);
    }
}

