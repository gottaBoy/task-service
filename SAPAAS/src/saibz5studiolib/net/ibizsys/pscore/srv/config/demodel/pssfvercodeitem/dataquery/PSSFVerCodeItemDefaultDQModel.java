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
package net.ibizsys.pscore.srv.config.demodel.pssfvercodeitem.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="A0606BB4-197D-46F6-B7F2-A409445E2A73", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t11.`PSSFSTYLEVERID`, t1.`PSSFVERCODEID`, t1.`PSSFVERCODEITEMID`, t1.`PSSFVERCODEITEMNAME`, t11.`PSSFVERCODENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSFVERCODEITEM` t1  LEFT JOIN T_SRFPSSFVERCODE t11 ON t1.PSSFVERCODEID = t11.PSSFVERCODEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="TEMPLCODE", expression="t1.`TEMPLCODE`", showorder=-1), @DEDataQueryCodeExp(name="TEMPLCODE2", expression="t1.`TEMPLCODE2`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSSFSTYLEVERID", expression="t11.`PSSFSTYLEVERID`", showorder=3), @DEDataQueryCodeExp(name="PSSFVERCODEID", expression="t1.`PSSFVERCODEID`", showorder=4), @DEDataQueryCodeExp(name="PSSFVERCODEITEMID", expression="t1.`PSSFVERCODEITEMID`", showorder=5), @DEDataQueryCodeExp(name="PSSFVERCODEITEMNAME", expression="t1.`PSSFVERCODEITEMNAME`", showorder=6), @DEDataQueryCodeExp(name="PSSFVERCODENAME", expression="t11.`PSSFVERCODENAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t11.PSSFSTYLEVERID, t1.PSSFVERCODEID, t1.PSSFVERCODEITEMID, t1.PSSFVERCODEITEMNAME, t11.PSSFVERCODENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSFVERCODEITEM t1  LEFT JOIN T_SRFPSSFVERCODE t11 ON t1.PSSFVERCODEID = t11.PSSFVERCODEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="TEMPLCODE", expression="t1.TEMPLCODE", showorder=-1), @DEDataQueryCodeExp(name="TEMPLCODE2", expression="t1.TEMPLCODE2", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSSFSTYLEVERID", expression="t11.PSSFSTYLEVERID", showorder=3), @DEDataQueryCodeExp(name="PSSFVERCODEID", expression="t1.PSSFVERCODEID", showorder=4), @DEDataQueryCodeExp(name="PSSFVERCODEITEMID", expression="t1.PSSFVERCODEITEMID", showorder=5), @DEDataQueryCodeExp(name="PSSFVERCODEITEMNAME", expression="t1.PSSFVERCODEITEMNAME", showorder=6), @DEDataQueryCodeExp(name="PSSFVERCODENAME", expression="t11.PSSFVERCODENAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSSFVerCodeItemDefaultDQModel
extends DEDataQueryModelBase {
    public PSSFVerCodeItemDefaultDQModel() {
        this.initAnnotation(PSSFVerCodeItemDefaultDQModel.class);
    }
}

