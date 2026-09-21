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
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psmodelsummarytempl.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="65E7FC78-4976-4CEB-87D5-7E2775084CCA", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`MODELDEID`, t1.`PSMODELSUMMARYTEMPLID`, t1.`PSMODELSUMMARYTEMPLNAME`, t1.`TEMPLCONTENT`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSMODELSUMMARYTEMPL` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="MODELDEID", expression="t1.`MODELDEID`", showorder=3), @DEDataQueryCodeExp(name="PSMODELSUMMARYTEMPLID", expression="t1.`PSMODELSUMMARYTEMPLID`", showorder=4), @DEDataQueryCodeExp(name="PSMODELSUMMARYTEMPLNAME", expression="t1.`PSMODELSUMMARYTEMPLNAME`", showorder=5), @DEDataQueryCodeExp(name="TEMPLCONTENT", expression="t1.`TEMPLCONTENT`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.MODELDEID, t1.PSMODELSUMMARYTEMPLID, t1.PSMODELSUMMARYTEMPLNAME, t1.TEMPLCONTENT, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSMODELSUMMARYTEMPL t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="MODELDEID", expression="t1.MODELDEID", showorder=3), @DEDataQueryCodeExp(name="PSMODELSUMMARYTEMPLID", expression="t1.PSMODELSUMMARYTEMPLID", showorder=4), @DEDataQueryCodeExp(name="PSMODELSUMMARYTEMPLNAME", expression="t1.PSMODELSUMMARYTEMPLNAME", showorder=5), @DEDataQueryCodeExp(name="TEMPLCONTENT", expression="t1.TEMPLCONTENT", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=9)}, conds={})})
public class PSModelSummaryTemplDefaultDQModel
extends DEDataQueryModelBase {
    public PSModelSummaryTemplDefaultDQModel() {
        this.initAnnotation(PSModelSummaryTemplDefaultDQModel.class);
    }
}

