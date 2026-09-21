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
package net.ibizsys.pscore.srv.dynasys.demodel.psdynacodelist.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="5E14F907-7DC2-4C55-BEB1-E34F3851A1B7", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOGICNAME`, t1.`MEMO`, t1.`PSDYNACODELISTID`, t1.`PSDYNACODELISTNAME`, t1.`PSDYNASYSID`, t11.`PSDYNASYSNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDYNACODELIST` t1  LEFT JOIN T_SRFPSDYNASYS t11 ON t1.PSDYNASYSID = t11.PSDYNASYSID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.`LOGICNAME`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDYNACODELISTID", expression="t1.`PSDYNACODELISTID`", showorder=4), @DEDataQueryCodeExp(name="PSDYNACODELISTNAME", expression="t1.`PSDYNACODELISTNAME`", showorder=5), @DEDataQueryCodeExp(name="PSDYNASYSID", expression="t1.`PSDYNASYSID`", showorder=6), @DEDataQueryCodeExp(name="PSDYNASYSNAME", expression="t11.`PSDYNASYSNAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.LOGICNAME, t1.MEMO, t1.PSDYNACODELISTID, t1.PSDYNACODELISTNAME, t1.PSDYNASYSID, t11.PSDYNASYSNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDYNACODELIST t1  LEFT JOIN T_SRFPSDYNASYS t11 ON t1.PSDYNASYSID = t11.PSDYNASYSID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.LOGICNAME", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDYNACODELISTID", expression="t1.PSDYNACODELISTID", showorder=4), @DEDataQueryCodeExp(name="PSDYNACODELISTNAME", expression="t1.PSDYNACODELISTNAME", showorder=5), @DEDataQueryCodeExp(name="PSDYNASYSID", expression="t1.PSDYNASYSID", showorder=6), @DEDataQueryCodeExp(name="PSDYNASYSNAME", expression="t11.PSDYNASYSNAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSDynaCodeListDefaultDQModel
extends DEDataQueryModelBase {
    public PSDynaCodeListDefaultDQModel() {
        this.initAnnotation(PSDynaCodeListDefaultDQModel.class);
    }
}

