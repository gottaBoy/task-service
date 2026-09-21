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
package net.ibizsys.pscore.srv.dynasys.demodel.psdynawfverinst.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="F9C0887A-1DDE-43DA-A33F-42286B7EA726", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`INSTVER`, t1.`MEMO`, t1.`PSDYNAINSTID`, t1.`PSDYNAINSTNAME`, t1.`PSDYNAWFVERID`, t1.`PSDYNAWFVERINSTID`, t1.`PSDYNAWFVERINSTNAME`, t11.`PSDYNAWFVERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG`, t1.`WFVERSION` FROM `T_SRFPSDYNAWFVERINST` t1  LEFT JOIN T_SRFPSDYNAWFVER t11 ON t1.PSDYNAWFVERID = t11.PSDYNAWFVERID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="DYNAMODEL", expression="t1.`DYNAMODEL`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="INSTVER", expression="t1.`INSTVER`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.`PSDYNAINSTID`", showorder=4), @DEDataQueryCodeExp(name="PSDYNAINSTNAME", expression="t1.`PSDYNAINSTNAME`", showorder=5), @DEDataQueryCodeExp(name="PSDYNAWFVERID", expression="t1.`PSDYNAWFVERID`", showorder=6), @DEDataQueryCodeExp(name="PSDYNAWFVERINSTID", expression="t1.`PSDYNAWFVERINSTID`", showorder=7), @DEDataQueryCodeExp(name="PSDYNAWFVERINSTNAME", expression="t1.`PSDYNAWFVERINSTNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDYNAWFVERNAME", expression="t11.`PSDYNAWFVERNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12), @DEDataQueryCodeExp(name="WFVERSION", expression="t1.`WFVERSION`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.INSTVER, t1.MEMO, t1.PSDYNAINSTID, t1.PSDYNAINSTNAME, t1.PSDYNAWFVERID, t1.PSDYNAWFVERINSTID, t1.PSDYNAWFVERINSTNAME, t11.PSDYNAWFVERNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG, t1.WFVERSION FROM T_SRFPSDYNAWFVERINST t1  LEFT JOIN T_SRFPSDYNAWFVER t11 ON t1.PSDYNAWFVERID = t11.PSDYNAWFVERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="DYNAMODEL", expression="t1.DYNAMODEL", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="INSTVER", expression="t1.INSTVER", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.PSDYNAINSTID", showorder=4), @DEDataQueryCodeExp(name="PSDYNAINSTNAME", expression="t1.PSDYNAINSTNAME", showorder=5), @DEDataQueryCodeExp(name="PSDYNAWFVERID", expression="t1.PSDYNAWFVERID", showorder=6), @DEDataQueryCodeExp(name="PSDYNAWFVERINSTID", expression="t1.PSDYNAWFVERINSTID", showorder=7), @DEDataQueryCodeExp(name="PSDYNAWFVERINSTNAME", expression="t1.PSDYNAWFVERINSTNAME", showorder=8), @DEDataQueryCodeExp(name="PSDYNAWFVERNAME", expression="t11.PSDYNAWFVERNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12), @DEDataQueryCodeExp(name="WFVERSION", expression="t1.WFVERSION", showorder=13)}, conds={})})
public class PSDynaWFVerInstDefaultDQModel
extends DEDataQueryModelBase {
    public PSDynaWFVerInstDefaultDQModel() {
        this.initAnnotation(PSDynaWFVerInstDefaultDQModel.class);
    }
}

