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
package net.ibizsys.pscore.srv.dynasys.demodel.psdynawfver.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="8BC4CD47-AE44-440E-BA7A-109635E35146", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDYNASYSID`, t11.`PSDYNASYSNAME`, t1.`PSDYNAWFID`, t21.`PSDYNAWFNAME`, t1.`PSDYNAWFVERID`, t1.`PSDYNAWFVERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDYNAWFVER` t1  LEFT JOIN T_SRFPSDYNASYS t11 ON t1.PSDYNASYSID = t11.PSDYNASYSID  LEFT JOIN T_SRFPSDYNAWF t21 ON t1.PSDYNAWFID = t21.PSDYNAWFID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDYNASYSID", expression="t1.`PSDYNASYSID`", showorder=3), @DEDataQueryCodeExp(name="PSDYNASYSNAME", expression="t11.`PSDYNASYSNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDYNAWFID", expression="t1.`PSDYNAWFID`", showorder=5), @DEDataQueryCodeExp(name="PSDYNAWFNAME", expression="t21.`PSDYNAWFNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDYNAWFVERID", expression="t1.`PSDYNAWFVERID`", showorder=7), @DEDataQueryCodeExp(name="PSDYNAWFVERNAME", expression="t1.`PSDYNAWFVERNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDYNASYSID, t11.PSDYNASYSNAME, t1.PSDYNAWFID, t21.PSDYNAWFNAME, t1.PSDYNAWFVERID, t1.PSDYNAWFVERNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDYNAWFVER t1  LEFT JOIN T_SRFPSDYNASYS t11 ON t1.PSDYNASYSID = t11.PSDYNASYSID  LEFT JOIN T_SRFPSDYNAWF t21 ON t1.PSDYNAWFID = t21.PSDYNAWFID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDYNASYSID", expression="t1.PSDYNASYSID", showorder=3), @DEDataQueryCodeExp(name="PSDYNASYSNAME", expression="t11.PSDYNASYSNAME", showorder=4), @DEDataQueryCodeExp(name="PSDYNAWFID", expression="t1.PSDYNAWFID", showorder=5), @DEDataQueryCodeExp(name="PSDYNAWFNAME", expression="t21.PSDYNAWFNAME", showorder=6), @DEDataQueryCodeExp(name="PSDYNAWFVERID", expression="t1.PSDYNAWFVERID", showorder=7), @DEDataQueryCodeExp(name="PSDYNAWFVERNAME", expression="t1.PSDYNAWFVERNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10)}, conds={})})
public class PSDynaWFVerDefaultDQModel
extends DEDataQueryModelBase {
    public PSDynaWFVerDefaultDQModel() {
        this.initAnnotation(PSDynaWFVerDefaultDQModel.class);
    }
}

