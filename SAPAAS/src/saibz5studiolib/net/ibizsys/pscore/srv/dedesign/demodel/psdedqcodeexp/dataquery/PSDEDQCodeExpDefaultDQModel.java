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
package net.ibizsys.pscore.srv.dedesign.demodel.psdedqcodeexp.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="7D198B95-CC9F-46E1-9C0A-B326F6EFED8A", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`EXPCODE`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSDEDQCODEEXPID`, t1.`PSDEDQCODEEXPNAME`, t1.`PSDEDQCODEID`, t11.`PSDEDQCODENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEDQCODEEXP` t1  LEFT JOIN `T_SRFPSDEDQCODE` t11 ON t1.`PSDEDQCODEID` = t11.`PSDEDQCODEID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="EXPCODE", expression="t1.`EXPCODE`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=4), @DEDataQueryCodeExp(name="PSDEDQCODEEXPID", expression="t1.`PSDEDQCODEEXPID`", showorder=5), @DEDataQueryCodeExp(name="PSDEDQCODEEXPNAME", expression="t1.`PSDEDQCODEEXPNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEDQCODEID", expression="t1.`PSDEDQCODEID`", showorder=7), @DEDataQueryCodeExp(name="PSDEDQCODENAME", expression="t11.`PSDEDQCODENAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.EXPCODE, t1.MEMO, t1.ORDERVALUE, t1.PSDEDQCODEEXPID, t1.PSDEDQCODEEXPNAME, t1.PSDEDQCODEID, t11.PSDEDQCODENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEDQCODEEXP t1  LEFT JOIN T_SRFPSDEDQCODE t11 ON t1.PSDEDQCODEID = t11.PSDEDQCODEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="EXPCODE", expression="t1.EXPCODE", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=4), @DEDataQueryCodeExp(name="PSDEDQCODEEXPID", expression="t1.PSDEDQCODEEXPID", showorder=5), @DEDataQueryCodeExp(name="PSDEDQCODEEXPNAME", expression="t1.PSDEDQCODEEXPNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEDQCODEID", expression="t1.PSDEDQCODEID", showorder=7), @DEDataQueryCodeExp(name="PSDEDQCODENAME", expression="t11.PSDEDQCODENAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10)}, conds={})})
public class PSDEDQCodeExpDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEDQCodeExpDefaultDQModel() {
        this.initAnnotation(PSDEDQCodeExpDefaultDQModel.class);
    }
}

