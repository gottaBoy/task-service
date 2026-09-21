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
package net.ibizsys.pscore.srv.dedesign.demodel.psdedqcodecond.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="45CCAF60-BA24-453A-8D79-02509B8808D5", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CONDCODE`, t1.`CONDTAG`, t1.`CONDTAG2`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`FIELDNAME`, t1.`IGNOREEMPTY`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSDEDQCODECONDID`, t1.`PSDEDQCODECONDNAME`, t1.`PSDEDQCODEID`, t11.`PSDEDQCODENAME`, t1.`PSVARTYPEID`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEDQCODECOND` t1  LEFT JOIN `T_SRFPSDEDQCODE` t11 ON t1.`PSDEDQCODEID` = t11.`PSDEDQCODEID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CONDCODE", expression="t1.`CONDCODE`", showorder=0), @DEDataQueryCodeExp(name="CONDTAG", expression="t1.`CONDTAG`", showorder=1), @DEDataQueryCodeExp(name="CONDTAG2", expression="t1.`CONDTAG2`", showorder=2), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=3), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=4), @DEDataQueryCodeExp(name="FIELDNAME", expression="t1.`FIELDNAME`", showorder=5), @DEDataQueryCodeExp(name="IGNOREEMPTY", expression="t1.`IGNOREEMPTY`", showorder=6), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=7), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=8), @DEDataQueryCodeExp(name="PSDEDQCODECONDID", expression="t1.`PSDEDQCODECONDID`", showorder=9), @DEDataQueryCodeExp(name="PSDEDQCODECONDNAME", expression="t1.`PSDEDQCODECONDNAME`", showorder=10), @DEDataQueryCodeExp(name="PSDEDQCODEID", expression="t1.`PSDEDQCODEID`", showorder=11), @DEDataQueryCodeExp(name="PSDEDQCODENAME", expression="t11.`PSDEDQCODENAME`", showorder=12), @DEDataQueryCodeExp(name="PSVARTYPEID", expression="t1.`PSVARTYPEID`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CONDCODE, t1.CONDTAG, t1.CONDTAG2, t1.CREATEDATE, t1.CREATEMAN, t1.FIELDNAME, t1.IGNOREEMPTY, t1.MEMO, t1.ORDERVALUE, t1.PSDEDQCODECONDID, t1.PSDEDQCODECONDNAME, t1.PSDEDQCODEID, t11.PSDEDQCODENAME, t1.PSVARTYPEID, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEDQCODECOND t1  LEFT JOIN T_SRFPSDEDQCODE t11 ON t1.PSDEDQCODEID = t11.PSDEDQCODEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CONDCODE", expression="t1.CONDCODE", showorder=0), @DEDataQueryCodeExp(name="CONDTAG", expression="t1.CONDTAG", showorder=1), @DEDataQueryCodeExp(name="CONDTAG2", expression="t1.CONDTAG2", showorder=2), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=3), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=4), @DEDataQueryCodeExp(name="FIELDNAME", expression="t1.FIELDNAME", showorder=5), @DEDataQueryCodeExp(name="IGNOREEMPTY", expression="t1.IGNOREEMPTY", showorder=6), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=7), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=8), @DEDataQueryCodeExp(name="PSDEDQCODECONDID", expression="t1.PSDEDQCODECONDID", showorder=9), @DEDataQueryCodeExp(name="PSDEDQCODECONDNAME", expression="t1.PSDEDQCODECONDNAME", showorder=10), @DEDataQueryCodeExp(name="PSDEDQCODEID", expression="t1.PSDEDQCODEID", showorder=11), @DEDataQueryCodeExp(name="PSDEDQCODENAME", expression="t11.PSDEDQCODENAME", showorder=12), @DEDataQueryCodeExp(name="PSVARTYPEID", expression="t1.PSVARTYPEID", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15)}, conds={})})
public class PSDEDQCodeCondDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEDQCodeCondDefaultDQModel() {
        this.initAnnotation(PSDEDQCodeCondDefaultDQModel.class);
    }
}

