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
package net.ibizsys.pscore.srv.dedesign.demodel.psdedqcode.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="F888302A-6E40-4471-8AC9-FD5CE5BD7929", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DBTYPE`, t1.`MEMO`, t1.`PSDEDQCODEID`, t1.`PSDEDQCODENAME`, t1.`PSDEDQID`, t11.`PSDEDATAQUERYNAME` AS `PSDEDQNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEDQCODE` t1  LEFT JOIN `T_SRFPSDEDATAQUERY` t11 ON t1.`PSDEDQID` = t11.`PSDEDATAQUERYID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="QUERYCODE", expression="t1.`QUERYCODE`", showorder=-1), @DEDataQueryCodeExp(name="QUERYCODETEMP", expression="t1.`QUERYCODETEMP`", showorder=-1), @DEDataQueryCodeExp(name="USERQUERYCODE", expression="t1.`USERQUERYCODE`", showorder=-1), @DEDataQueryCodeExp(name="USERQUERYCODE2", expression="t1.`USERQUERYCODE2`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DBTYPE", expression="t1.`DBTYPE`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDEDQCODEID", expression="t1.`PSDEDQCODEID`", showorder=4), @DEDataQueryCodeExp(name="PSDEDQCODENAME", expression="t1.`PSDEDQCODENAME`", showorder=5), @DEDataQueryCodeExp(name="PSDEDQID", expression="t1.`PSDEDQID`", showorder=6), @DEDataQueryCodeExp(name="PSDEDQNAME", expression="t11.`PSDEDATAQUERYNAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DBTYPE, t1.MEMO, t1.PSDEDQCODEID, t1.PSDEDQCODENAME, t1.PSDEDQID, t11.PSDEDATAQUERYNAME AS PSDEDQNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEDQCODE t1  LEFT JOIN T_SRFPSDEDATAQUERY t11 ON t1.PSDEDQID = t11.PSDEDATAQUERYID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="QUERYCODE", expression="t1.QUERYCODE", showorder=-1), @DEDataQueryCodeExp(name="QUERYCODETEMP", expression="t1.QUERYCODETEMP", showorder=-1), @DEDataQueryCodeExp(name="USERQUERYCODE", expression="t1.USERQUERYCODE", showorder=-1), @DEDataQueryCodeExp(name="USERQUERYCODE2", expression="t1.USERQUERYCODE2", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DBTYPE", expression="t1.DBTYPE", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDEDQCODEID", expression="t1.PSDEDQCODEID", showorder=4), @DEDataQueryCodeExp(name="PSDEDQCODENAME", expression="t1.PSDEDQCODENAME", showorder=5), @DEDataQueryCodeExp(name="PSDEDQID", expression="t1.PSDEDQID", showorder=6), @DEDataQueryCodeExp(name="PSDEDQNAME", expression="t11.PSDEDATAQUERYNAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSDEDQCodeDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEDQCodeDefaultDQModel() {
        this.initAnnotation(PSDEDQCodeDefaultDQModel.class);
    }
}

