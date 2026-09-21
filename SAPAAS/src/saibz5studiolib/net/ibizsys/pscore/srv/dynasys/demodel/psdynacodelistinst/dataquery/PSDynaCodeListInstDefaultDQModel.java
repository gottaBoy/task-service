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
package net.ibizsys.pscore.srv.dynasys.demodel.psdynacodelistinst.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="83277852-A01E-4AEE-9E5F-43C8C0329593", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`INSTVER`, t1.`MEMO`, t1.`PSDYNACODELISTID`, t1.`PSDYNACODELISTINSTID`, t1.`PSDYNACODELISTINSTNAME`, t11.`PSDYNACODELISTNAME`, t1.`PSDYNAINSTID`, t1.`PSDYNAINSTNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDYNACODELISTINST` t1  LEFT JOIN T_SRFPSDYNACODELIST t11 ON t1.PSDYNACODELISTID = t11.PSDYNACODELISTID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="DYNAMODEL", expression="t1.`DYNAMODEL`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="INSTVER", expression="t1.`INSTVER`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDYNACODELISTID", expression="t1.`PSDYNACODELISTID`", showorder=4), @DEDataQueryCodeExp(name="PSDYNACODELISTINSTID", expression="t1.`PSDYNACODELISTINSTID`", showorder=5), @DEDataQueryCodeExp(name="PSDYNACODELISTINSTNAME", expression="t1.`PSDYNACODELISTINSTNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDYNACODELISTNAME", expression="t11.`PSDYNACODELISTNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.`PSDYNAINSTID`", showorder=8), @DEDataQueryCodeExp(name="PSDYNAINSTNAME", expression="t1.`PSDYNAINSTNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.INSTVER, t1.MEMO, t1.PSDYNACODELISTID, t1.PSDYNACODELISTINSTID, t1.PSDYNACODELISTINSTNAME, t11.PSDYNACODELISTNAME, t1.PSDYNAINSTID, t1.PSDYNAINSTNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDYNACODELISTINST t1  LEFT JOIN T_SRFPSDYNACODELIST t11 ON t1.PSDYNACODELISTID = t11.PSDYNACODELISTID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="DYNAMODEL", expression="t1.DYNAMODEL", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="INSTVER", expression="t1.INSTVER", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDYNACODELISTID", expression="t1.PSDYNACODELISTID", showorder=4), @DEDataQueryCodeExp(name="PSDYNACODELISTINSTID", expression="t1.PSDYNACODELISTINSTID", showorder=5), @DEDataQueryCodeExp(name="PSDYNACODELISTINSTNAME", expression="t1.PSDYNACODELISTINSTNAME", showorder=6), @DEDataQueryCodeExp(name="PSDYNACODELISTNAME", expression="t11.PSDYNACODELISTNAME", showorder=7), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.PSDYNAINSTID", showorder=8), @DEDataQueryCodeExp(name="PSDYNAINSTNAME", expression="t1.PSDYNAINSTNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12)}, conds={})})
public class PSDynaCodeListInstDefaultDQModel
extends DEDataQueryModelBase {
    public PSDynaCodeListInstDefaultDQModel() {
        this.initAnnotation(PSDynaCodeListInstDefaultDQModel.class);
    }
}

