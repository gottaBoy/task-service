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
package net.ibizsys.pscore.srv.dynasys.demodel.psdynadeformtempl.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="9D1B16E6-E14C-4A9D-8FF9-4D68CED7ADD7", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEFORMID`, t11.`PSDEFORMNAME`, t1.`PSDYNADEFORMTEMPLID`, t1.`PSDYNADEFORMTEMPLNAME`, t1.`PSDYNADETEMPLID`, t21.`PSDYNADETEMPLNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDYNADEFORMTEMPL` t1  LEFT JOIN T_SRFPSDEFORM t11 ON t1.PSDEFORMID = t11.PSDEFORMID  LEFT JOIN T_SRFPSDYNADETEMPL t21 ON t1.PSDYNADETEMPLID = t21.PSDYNADETEMPLID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEFORMID", expression="t1.`PSDEFORMID`", showorder=3), @DEDataQueryCodeExp(name="PSDEFORMNAME", expression="t11.`PSDEFORMNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDYNADEFORMTEMPLID", expression="t1.`PSDYNADEFORMTEMPLID`", showorder=5), @DEDataQueryCodeExp(name="PSDYNADEFORMTEMPLNAME", expression="t1.`PSDYNADEFORMTEMPLNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDYNADETEMPLID", expression="t1.`PSDYNADETEMPLID`", showorder=7), @DEDataQueryCodeExp(name="PSDYNADETEMPLNAME", expression="t21.`PSDYNADETEMPLNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEFORMID, t11.PSDEFORMNAME, t1.PSDYNADEFORMTEMPLID, t1.PSDYNADEFORMTEMPLNAME, t1.PSDYNADETEMPLID, t21.PSDYNADETEMPLNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDYNADEFORMTEMPL t1  LEFT JOIN T_SRFPSDEFORM t11 ON t1.PSDEFORMID = t11.PSDEFORMID  LEFT JOIN T_SRFPSDYNADETEMPL t21 ON t1.PSDYNADETEMPLID = t21.PSDYNADETEMPLID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEFORMID", expression="t1.PSDEFORMID", showorder=3), @DEDataQueryCodeExp(name="PSDEFORMNAME", expression="t11.PSDEFORMNAME", showorder=4), @DEDataQueryCodeExp(name="PSDYNADEFORMTEMPLID", expression="t1.PSDYNADEFORMTEMPLID", showorder=5), @DEDataQueryCodeExp(name="PSDYNADEFORMTEMPLNAME", expression="t1.PSDYNADEFORMTEMPLNAME", showorder=6), @DEDataQueryCodeExp(name="PSDYNADETEMPLID", expression="t1.PSDYNADETEMPLID", showorder=7), @DEDataQueryCodeExp(name="PSDYNADETEMPLNAME", expression="t21.PSDYNADETEMPLNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10)}, conds={})})
public class PSDynaDEFormTemplDefaultDQModel
extends DEDataQueryModelBase {
    public PSDynaDEFormTemplDefaultDQModel() {
        this.initAnnotation(PSDynaDEFormTemplDefaultDQModel.class);
    }
}

