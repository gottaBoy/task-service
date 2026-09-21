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
package net.ibizsys.pscore.srv.appdesign.demodel.psappviewtempl.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="C03D8EC0-7795-4DE7-A507-9BEB155F47B4", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSAPPVIEWSTYLEID`, t11.`PSAPPVIEWSTYLENAME`, t1.`PSAPPVIEWTEMPLID`, t1.`PSAPPVIEWTEMPLNAME`, t1.`PSPFPUBCODEID`, t21.`PSPFPUBCODENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERPARAMS` FROM `T_SRFPSAPPVIEWTEMPL` t1  LEFT JOIN T_SRFPSAPPVIEWSTYLE t11 ON t1.PSAPPVIEWSTYLEID = t11.PSAPPVIEWSTYLEID  LEFT JOIN T_SRFPSPFPUBCODE t21 ON t1.PSPFPUBCODEID = t21.PSPFPUBCODEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="TEMPLCODE", expression="t1.`TEMPLCODE`", showorder=-1), @DEDataQueryCodeExp(name="TEMPLCODE2", expression="t1.`TEMPLCODE2`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSAPPVIEWSTYLEID", expression="t1.`PSAPPVIEWSTYLEID`", showorder=3), @DEDataQueryCodeExp(name="PSAPPVIEWSTYLENAME", expression="t11.`PSAPPVIEWSTYLENAME`", showorder=4), @DEDataQueryCodeExp(name="PSAPPVIEWTEMPLID", expression="t1.`PSAPPVIEWTEMPLID`", showorder=5), @DEDataQueryCodeExp(name="PSAPPVIEWTEMPLNAME", expression="t1.`PSAPPVIEWTEMPLNAME`", showorder=6), @DEDataQueryCodeExp(name="PSPFPUBCODEID", expression="t1.`PSPFPUBCODEID`", showorder=7), @DEDataQueryCodeExp(name="PSPFPUBCODENAME", expression="t21.`PSPFPUBCODENAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="USERPARAMS", expression="t1.`USERPARAMS`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSAPPVIEWSTYLEID, t11.PSAPPVIEWSTYLENAME, t1.PSAPPVIEWTEMPLID, t1.PSAPPVIEWTEMPLNAME, t1.PSPFPUBCODEID, t21.PSPFPUBCODENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERPARAMS FROM T_SRFPSAPPVIEWTEMPL t1  LEFT JOIN T_SRFPSAPPVIEWSTYLE t11 ON t1.PSAPPVIEWSTYLEID = t11.PSAPPVIEWSTYLEID  LEFT JOIN T_SRFPSPFPUBCODE t21 ON t1.PSPFPUBCODEID = t21.PSPFPUBCODEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="TEMPLCODE", expression="t1.TEMPLCODE", showorder=-1), @DEDataQueryCodeExp(name="TEMPLCODE2", expression="t1.TEMPLCODE2", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSAPPVIEWSTYLEID", expression="t1.PSAPPVIEWSTYLEID", showorder=3), @DEDataQueryCodeExp(name="PSAPPVIEWSTYLENAME", expression="t11.PSAPPVIEWSTYLENAME", showorder=4), @DEDataQueryCodeExp(name="PSAPPVIEWTEMPLID", expression="t1.PSAPPVIEWTEMPLID", showorder=5), @DEDataQueryCodeExp(name="PSAPPVIEWTEMPLNAME", expression="t1.PSAPPVIEWTEMPLNAME", showorder=6), @DEDataQueryCodeExp(name="PSPFPUBCODEID", expression="t1.PSPFPUBCODEID", showorder=7), @DEDataQueryCodeExp(name="PSPFPUBCODENAME", expression="t21.PSPFPUBCODENAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="USERPARAMS", expression="t1.USERPARAMS", showorder=11)}, conds={})})
public class PSAppViewTemplDefaultDQModel
extends DEDataQueryModelBase {
    public PSAppViewTemplDefaultDQModel() {
        this.initAnnotation(PSAppViewTemplDefaultDQModel.class);
    }
}

