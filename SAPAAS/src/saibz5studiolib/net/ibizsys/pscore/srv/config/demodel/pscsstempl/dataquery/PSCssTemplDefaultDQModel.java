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
package net.ibizsys.pscore.srv.config.demodel.pscsstempl.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="507B6C64-138F-46E7-A650-AA05527E20BD", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`CSSNAME`, t1.`CSSSTYLE`, t1.`MEMO`, t1.`PSCSSCATTEMPLID`, t11.`PSCSSCATTEMPLNAME`, t1.`PSCSSTEMPLID`, t1.`PSCSSTEMPLNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSCSSTEMPL` t1  LEFT JOIN T_SRFPSCSSCATTEMPL t11 ON t1.PSCSSCATTEMPLID = t11.PSCSSCATTEMPLID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="CSSNAME", expression="t1.`CSSNAME`", showorder=2), @DEDataQueryCodeExp(name="CSSSTYLE", expression="t1.`CSSSTYLE`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSCSSCATTEMPLID", expression="t1.`PSCSSCATTEMPLID`", showorder=5), @DEDataQueryCodeExp(name="PSCSSCATTEMPLNAME", expression="t11.`PSCSSCATTEMPLNAME`", showorder=6), @DEDataQueryCodeExp(name="PSCSSTEMPLID", expression="t1.`PSCSSTEMPLID`", showorder=7), @DEDataQueryCodeExp(name="PSCSSTEMPLNAME", expression="t1.`PSCSSTEMPLNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.CSSNAME, t1.CSSSTYLE, t1.MEMO, t1.PSCSSCATTEMPLID, t11.PSCSSCATTEMPLNAME, t1.PSCSSTEMPLID, t1.PSCSSTEMPLNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSCSSTEMPL t1  LEFT JOIN T_SRFPSCSSCATTEMPL t11 ON t1.PSCSSCATTEMPLID = t11.PSCSSCATTEMPLID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="CSSNAME", expression="t1.CSSNAME", showorder=2), @DEDataQueryCodeExp(name="CSSSTYLE", expression="t1.CSSSTYLE", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSCSSCATTEMPLID", expression="t1.PSCSSCATTEMPLID", showorder=5), @DEDataQueryCodeExp(name="PSCSSCATTEMPLNAME", expression="t11.PSCSSCATTEMPLNAME", showorder=6), @DEDataQueryCodeExp(name="PSCSSTEMPLID", expression="t1.PSCSSTEMPLID", showorder=7), @DEDataQueryCodeExp(name="PSCSSTEMPLNAME", expression="t1.PSCSSTEMPLNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10)}, conds={})})
public class PSCssTemplDefaultDQModel
extends DEDataQueryModelBase {
    public PSCssTemplDefaultDQModel() {
        this.initAnnotation(PSCssTemplDefaultDQModel.class);
    }
}

